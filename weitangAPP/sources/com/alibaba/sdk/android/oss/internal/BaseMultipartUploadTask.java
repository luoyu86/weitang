package com.alibaba.sdk.android.oss.internal;

import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.alibaba.sdk.android.oss.ClientException;
import com.alibaba.sdk.android.oss.ServiceException;
import com.alibaba.sdk.android.oss.TaskCancelException;
import com.alibaba.sdk.android.oss.callback.OSSCompletedCallback;
import com.alibaba.sdk.android.oss.callback.OSSProgressCallback;
import com.alibaba.sdk.android.oss.common.OSSConstants;
import com.alibaba.sdk.android.oss.common.OSSLog;
import com.alibaba.sdk.android.oss.model.CompleteMultipartUploadRequest;
import com.alibaba.sdk.android.oss.model.CompleteMultipartUploadResult;
import com.alibaba.sdk.android.oss.model.MultipartUploadRequest;
import com.alibaba.sdk.android.oss.model.OSSRequest;
import com.alibaba.sdk.android.oss.model.PartETag;
import com.alibaba.sdk.android.oss.network.ExecutionContext;
import com.tom_roush.pdfbox.pdmodel.common.PDPageLabelRange;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseMultipartUploadTask<Request extends MultipartUploadRequest, Result extends CompleteMultipartUploadResult> implements Callable<Result> {
    public final int CPU_SIZE;
    public final int KEEP_ALIVE_TIME;
    public final int MAX_CORE_POOL_SIZE;
    public final int MAX_IMUM_POOL_SIZE;
    public final int MAX_QUEUE_SIZE;
    public InternalRequestOperation mApiOperation;
    public boolean mCheckCRC64;
    public OSSCompletedCallback<Request, Result> mCompletedCallback;
    public ExecutionContext mContext;
    public long mFileLength;
    public boolean mIsCancel;
    public long mLastPartSize;
    public Object mLock;
    public int[] mPartAttr;
    public List<PartETag> mPartETags;
    public int mPartExceptionCount;
    public ThreadPoolExecutor mPoolExecutor;
    public OSSProgressCallback<Request> mProgressCallback;
    public Request mRequest;
    public int mRunPartTaskCount;
    public Exception mUploadException;
    public File mUploadFile;
    public String mUploadFilePath;
    public String mUploadId;
    public Uri mUploadUri;
    public long mUploadedLength;

    public BaseMultipartUploadTask(InternalRequestOperation internalRequestOperation, Request request, OSSCompletedCallback<Request, Result> oSSCompletedCallback, ExecutionContext executionContext) {
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors() * 2;
        this.CPU_SIZE = iAvailableProcessors;
        int i2 = iAvailableProcessors < 5 ? iAvailableProcessors : 5;
        this.MAX_CORE_POOL_SIZE = i2;
        this.MAX_IMUM_POOL_SIZE = iAvailableProcessors;
        this.KEEP_ALIVE_TIME = 3000;
        this.MAX_QUEUE_SIZE = 5000;
        this.mPoolExecutor = new ThreadPoolExecutor(i2, iAvailableProcessors, 3000L, TimeUnit.MILLISECONDS, new ArrayBlockingQueue(5000), new ThreadFactory() { // from class: com.alibaba.sdk.android.oss.internal.BaseMultipartUploadTask.1
            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                return new Thread(runnable, "oss-android-multipart-thread");
            }
        });
        this.mPartETags = new ArrayList();
        this.mLock = new Object();
        this.mUploadedLength = 0L;
        this.mCheckCRC64 = false;
        this.mPartAttr = new int[2];
        this.mApiOperation = internalRequestOperation;
        this.mRequest = request;
        this.mProgressCallback = request.getProgressCallback();
        this.mCompletedCallback = oSSCompletedCallback;
        this.mContext = executionContext;
        this.mCheckCRC64 = request.getCRC64() == OSSRequest.CRC64Config.YES;
    }

    public abstract void abortThisUpload();

    public void checkCancel() throws ClientException {
        if (this.mContext.getCancellationHandler().isCancelled()) {
            TaskCancelException taskCancelException = new TaskCancelException("multipart cancel");
            throw new ClientException(taskCancelException.getMessage(), taskCancelException, Boolean.TRUE);
        }
    }

    public void checkException() throws ServiceException, ClientException, IOException {
        if (this.mUploadException != null) {
            releasePool();
            Exception exc = this.mUploadException;
            if (exc instanceof IOException) {
                throw ((IOException) exc);
            }
            if (exc instanceof ServiceException) {
                throw ((ServiceException) exc);
            }
            if (!(exc instanceof ClientException)) {
                throw new ClientException(this.mUploadException.getMessage(), this.mUploadException);
            }
            throw ((ClientException) exc);
        }
    }

    public void checkInitData() throws ClientException {
        if (this.mRequest.getUploadFilePath() != null) {
            this.mUploadFilePath = this.mRequest.getUploadFilePath();
            this.mUploadedLength = 0L;
            File file = new File(this.mUploadFilePath);
            this.mUploadFile = file;
            this.mFileLength = file.length();
        } else if (this.mRequest.getUploadUri() != null) {
            this.mUploadUri = this.mRequest.getUploadUri();
            ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = null;
            try {
                try {
                    parcelFileDescriptorOpenFileDescriptor = this.mContext.getApplicationContext().getContentResolver().openFileDescriptor(this.mUploadUri, PDPageLabelRange.STYLE_ROMAN_LOWER);
                    this.mFileLength = parcelFileDescriptorOpenFileDescriptor.getStatSize();
                    try {
                        parcelFileDescriptorOpenFileDescriptor.close();
                    } catch (IOException e2) {
                        OSSLog.logThrowable2Local(e2);
                    }
                } catch (IOException e3) {
                    throw new ClientException(e3.getMessage(), e3, Boolean.TRUE);
                }
            } catch (Throwable th) {
                if (parcelFileDescriptorOpenFileDescriptor != null) {
                    try {
                        parcelFileDescriptorOpenFileDescriptor.close();
                    } catch (IOException e4) {
                        OSSLog.logThrowable2Local(e4);
                    }
                }
                throw th;
            }
        }
        if (this.mFileLength == 0) {
            throw new ClientException("file length must not be 0");
        }
        checkPartSize(this.mPartAttr);
        long partSize = this.mRequest.getPartSize();
        int i2 = this.mPartAttr[1];
        OSSLog.logDebug("[checkInitData] - partNumber : " + i2);
        OSSLog.logDebug("[checkInitData] - partSize : " + partSize);
        if (i2 > 1 && partSize < OSSConstants.MIN_PART_SIZE_LIMIT) {
            throw new ClientException("Part size must be greater than or equal to 100KB!");
        }
    }

    public void checkPartSize(int[] iArr) {
        long partSize = this.mRequest.getPartSize();
        OSSLog.logDebug("[checkPartSize] - mFileLength : " + this.mFileLength);
        OSSLog.logDebug("[checkPartSize] - partSize : " + partSize);
        long j = this.mFileLength;
        int i2 = (int) (j / partSize);
        if (j % partSize != 0) {
            i2++;
        }
        if (i2 == 1) {
            partSize = j;
        } else if (i2 > 5000) {
            partSize = j / ((long) 5000);
            i2 = 5000;
        }
        int i3 = (int) partSize;
        iArr[0] = i3;
        iArr[1] = i2;
        this.mRequest.setPartSize(i3);
        OSSLog.logDebug("[checkPartSize] - partNumber : " + i2);
        OSSLog.logDebug("[checkPartSize] - partSize : " + i3);
        long j2 = this.mFileLength % partSize;
        if (j2 != 0) {
            partSize = j2;
        }
        this.mLastPartSize = partSize;
    }

    public boolean checkWaitCondition(int i2) {
        return this.mPartETags.size() != i2;
    }

    public CompleteMultipartUploadResult completeMultipartUploadResult() throws ServiceException, ClientException {
        CompleteMultipartUploadResult completeMultipartUploadResultSyncCompleteMultipartUpload;
        if (this.mPartETags.size() > 0) {
            Collections.sort(this.mPartETags, new Comparator<PartETag>() { // from class: com.alibaba.sdk.android.oss.internal.BaseMultipartUploadTask.2
                @Override // java.util.Comparator
                public int compare(PartETag partETag, PartETag partETag2) {
                    if (partETag.getPartNumber() < partETag2.getPartNumber()) {
                        return -1;
                    }
                    return partETag.getPartNumber() > partETag2.getPartNumber() ? 1 : 0;
                }
            });
            CompleteMultipartUploadRequest completeMultipartUploadRequest = new CompleteMultipartUploadRequest(this.mRequest.getBucketName(), this.mRequest.getObjectKey(), this.mUploadId, this.mPartETags);
            completeMultipartUploadRequest.setMetadata(this.mRequest.getMetadata());
            if (this.mRequest.getCallbackParam() != null) {
                completeMultipartUploadRequest.setCallbackParam(this.mRequest.getCallbackParam());
            }
            if (this.mRequest.getCallbackVars() != null) {
                completeMultipartUploadRequest.setCallbackVars(this.mRequest.getCallbackVars());
            }
            completeMultipartUploadRequest.setCRC64(this.mRequest.getCRC64());
            completeMultipartUploadResultSyncCompleteMultipartUpload = this.mApiOperation.syncCompleteMultipartUpload(completeMultipartUploadRequest);
        } else {
            completeMultipartUploadResultSyncCompleteMultipartUpload = null;
        }
        this.mUploadedLength = 0L;
        return completeMultipartUploadResultSyncCompleteMultipartUpload;
    }

    public abstract Result doMultipartUpload() throws ServiceException, ClientException, InterruptedException, IOException;

    public abstract void initMultipartUploadId() throws ServiceException, ClientException, IOException;

    public void notifyMultipartThread() {
        this.mLock.notify();
        this.mPartExceptionCount = 0;
    }

    public void onProgressCallback(Request request, long j, long j2) {
        OSSProgressCallback<Request> oSSProgressCallback = this.mProgressCallback;
        if (oSSProgressCallback != null) {
            oSSProgressCallback.onProgress(request, j, j2);
        }
    }

    public void preUploadPart(int i2, int i3, int i4) throws Exception {
    }

    public abstract void processException(Exception exc);

    public void releasePool() {
        ThreadPoolExecutor threadPoolExecutor = this.mPoolExecutor;
        if (threadPoolExecutor != null) {
            threadPoolExecutor.getQueue().clear();
            this.mPoolExecutor.shutdown();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x00a8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void uploadPart(int r12, int r13, int r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 383
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.oss.internal.BaseMultipartUploadTask.uploadPart(int, int, int):void");
    }

    public void uploadPartFinish(PartETag partETag) throws Exception {
    }

    @Override // java.util.concurrent.Callable
    public Result call() throws Exception {
        try {
            checkInitData();
            initMultipartUploadId();
            Result result = (Result) doMultipartUpload();
            OSSCompletedCallback<Request, Result> oSSCompletedCallback = this.mCompletedCallback;
            if (oSSCompletedCallback != null) {
                oSSCompletedCallback.onSuccess(this.mRequest, result);
            }
            return result;
        } catch (ServiceException e2) {
            OSSCompletedCallback<Request, Result> oSSCompletedCallback2 = this.mCompletedCallback;
            if (oSSCompletedCallback2 != null) {
                oSSCompletedCallback2.onFailure(this.mRequest, null, e2);
            }
            throw e2;
        } catch (Exception e3) {
            ClientException clientException = e3 instanceof ClientException ? (ClientException) e3 : new ClientException(e3.toString(), e3);
            OSSCompletedCallback<Request, Result> oSSCompletedCallback3 = this.mCompletedCallback;
            if (oSSCompletedCallback3 != null) {
                oSSCompletedCallback3.onFailure(this.mRequest, clientException, null);
            }
            throw clientException;
        }
    }
}
