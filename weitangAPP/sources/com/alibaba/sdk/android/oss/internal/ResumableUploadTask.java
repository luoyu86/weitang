package com.alibaba.sdk.android.oss.internal;

import android.text.TextUtils;
import com.alibaba.sdk.android.oss.ClientException;
import com.alibaba.sdk.android.oss.callback.OSSCompletedCallback;
import com.alibaba.sdk.android.oss.callback.OSSProgressCallback;
import com.alibaba.sdk.android.oss.common.OSSLog;
import com.alibaba.sdk.android.oss.common.utils.OSSSharedPreferences;
import com.alibaba.sdk.android.oss.model.AbortMultipartUploadRequest;
import com.alibaba.sdk.android.oss.model.CompleteMultipartUploadResult;
import com.alibaba.sdk.android.oss.model.PartETag;
import com.alibaba.sdk.android.oss.model.ResumableUploadRequest;
import com.alibaba.sdk.android.oss.model.ResumableUploadResult;
import com.alibaba.sdk.android.oss.network.ExecutionContext;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: loaded from: classes.dex */
public class ResumableUploadTask extends BaseMultipartUploadTask<ResumableUploadRequest, ResumableUploadResult> implements Callable<ResumableUploadResult> {
    private List<Integer> mAlreadyUploadIndex;
    private File mCRC64RecordFile;
    private File mRecordFile;
    private OSSSharedPreferences mSp;

    public ResumableUploadTask(ResumableUploadRequest resumableUploadRequest, OSSCompletedCallback<ResumableUploadRequest, ResumableUploadResult> oSSCompletedCallback, ExecutionContext executionContext, InternalRequestOperation internalRequestOperation) {
        super(internalRequestOperation, resumableUploadRequest, oSSCompletedCallback, executionContext);
        this.mAlreadyUploadIndex = new ArrayList();
        this.mSp = OSSSharedPreferences.instance(this.mContext.getApplicationContext());
    }

    @Override // com.alibaba.sdk.android.oss.internal.BaseMultipartUploadTask
    public void abortThisUpload() {
        if (this.mUploadId != null) {
            this.mApiOperation.abortMultipartUpload(new AbortMultipartUploadRequest(((ResumableUploadRequest) this.mRequest).getBucketName(), ((ResumableUploadRequest) this.mRequest).getObjectKey(), this.mUploadId), null).waitUntilFinished();
        }
    }

    @Override // com.alibaba.sdk.android.oss.internal.BaseMultipartUploadTask
    public void checkException() throws Throwable {
        if (this.mContext.getCancellationHandler().isCancelled()) {
            if (((ResumableUploadRequest) this.mRequest).deleteUploadOnCancelling().booleanValue()) {
                abortThisUpload();
                File file = this.mRecordFile;
                if (file != null) {
                    file.delete();
                }
            } else {
                List<PartETag> list = this.mPartETags;
                if (list != null && list.size() > 0 && this.mCheckCRC64 && ((ResumableUploadRequest) this.mRequest).getRecordDirectory() != null) {
                    HashMap map = new HashMap();
                    for (PartETag partETag : this.mPartETags) {
                        map.put(Integer.valueOf(partETag.getPartNumber()), Long.valueOf(partETag.getCRC64()));
                    }
                    ObjectOutputStream objectOutputStream = null;
                    try {
                        try {
                            File file2 = new File(((ResumableUploadRequest) this.mRequest).getRecordDirectory() + File.separator + this.mUploadId);
                            this.mCRC64RecordFile = file2;
                            if (!file2.exists()) {
                                this.mCRC64RecordFile.createNewFile();
                            }
                            ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(new FileOutputStream(this.mCRC64RecordFile));
                            try {
                                objectOutputStream2.writeObject(map);
                                objectOutputStream2.close();
                            } catch (IOException e2) {
                                e = e2;
                                objectOutputStream = objectOutputStream2;
                                OSSLog.logThrowable2Local(e);
                                if (objectOutputStream != null) {
                                    objectOutputStream.close();
                                }
                            } catch (Throwable th) {
                                th = th;
                                objectOutputStream = objectOutputStream2;
                                if (objectOutputStream != null) {
                                    objectOutputStream.close();
                                }
                                throw th;
                            }
                        } catch (IOException e3) {
                            e = e3;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
            }
        }
        super.checkException();
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0331 A[LOOP:0: B:43:0x0187->B:102:0x0331, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0339 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:138:0x033a A[EDGE_INSN: B:138:0x033a->B:104:0x033a BREAK  A[LOOP:0: B:43:0x0187->B:102:0x0331], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0327  */
    @Override // com.alibaba.sdk.android.oss.internal.BaseMultipartUploadTask
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void initMultipartUploadId() throws com.alibaba.sdk.android.oss.ServiceException, com.alibaba.sdk.android.oss.ClientException, java.io.IOException {
        /*
            Method dump skipped, instruction units count: 967
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.oss.internal.ResumableUploadTask.initMultipartUploadId():void");
    }

    @Override // com.alibaba.sdk.android.oss.internal.BaseMultipartUploadTask
    public void processException(Exception exc) {
        synchronized (this.mLock) {
            this.mPartExceptionCount++;
            this.mUploadException = exc;
            OSSLog.logThrowable2Local(exc);
            if (this.mContext.getCancellationHandler().isCancelled() && !this.mIsCancel) {
                this.mIsCancel = true;
                this.mLock.notify();
            }
            if (this.mPartETags.size() == this.mRunPartTaskCount - this.mPartExceptionCount) {
                notifyMultipartThread();
            }
        }
    }

    @Override // com.alibaba.sdk.android.oss.internal.BaseMultipartUploadTask
    public void uploadPartFinish(PartETag partETag) throws Exception {
        if (!this.mContext.getCancellationHandler().isCancelled() || this.mSp.contains(this.mUploadId)) {
            return;
        }
        this.mSp.setStringValue(this.mUploadId, String.valueOf(this.mUploadedLength));
        onProgressCallback(this.mRequest, this.mUploadedLength, this.mFileLength);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.alibaba.sdk.android.oss.internal.BaseMultipartUploadTask
    public ResumableUploadResult doMultipartUpload() throws Throwable {
        ThreadPoolExecutor threadPoolExecutor;
        long j = this.mUploadedLength;
        checkCancel();
        int[] iArr = this.mPartAttr;
        final int i2 = iArr[0];
        final int i3 = iArr[1];
        if (this.mPartETags.size() > 0 && this.mAlreadyUploadIndex.size() > 0) {
            long jLongValue = this.mUploadedLength;
            if (jLongValue > this.mFileLength) {
                throw new ClientException("The uploading file is inconsistent with before");
            }
            if (!TextUtils.isEmpty(this.mSp.getStringValue(this.mUploadId))) {
                jLongValue = Long.valueOf(this.mSp.getStringValue(this.mUploadId)).longValue();
            }
            long j2 = jLongValue;
            OSSProgressCallback<Request> oSSProgressCallback = this.mProgressCallback;
            if (oSSProgressCallback != 0) {
                oSSProgressCallback.onProgress(this.mRequest, j2, this.mFileLength);
            }
            this.mSp.removeKey(this.mUploadId);
        }
        this.mRunPartTaskCount = this.mPartETags.size();
        for (final int i4 = 0; i4 < i3; i4++) {
            if ((this.mAlreadyUploadIndex.size() == 0 || !this.mAlreadyUploadIndex.contains(Integer.valueOf(i4 + 1))) && (threadPoolExecutor = this.mPoolExecutor) != null) {
                if (i4 == i3 - 1) {
                    i2 = (int) (this.mFileLength - j);
                }
                j += (long) i2;
                threadPoolExecutor.execute(new Runnable() { // from class: com.alibaba.sdk.android.oss.internal.ResumableUploadTask.1
                    @Override // java.lang.Runnable
                    public void run() throws Throwable {
                        ResumableUploadTask.this.uploadPart(i4, i2, i3);
                    }
                });
            }
        }
        if (checkWaitCondition(i3)) {
            synchronized (this.mLock) {
                this.mLock.wait();
            }
        }
        checkException();
        CompleteMultipartUploadResult completeMultipartUploadResult = completeMultipartUploadResult();
        ResumableUploadResult resumableUploadResult = completeMultipartUploadResult != null ? new ResumableUploadResult(completeMultipartUploadResult) : null;
        File file = this.mRecordFile;
        if (file != null) {
            file.delete();
        }
        File file2 = this.mCRC64RecordFile;
        if (file2 != null) {
            file2.delete();
        }
        releasePool();
        return resumableUploadResult;
    }
}
