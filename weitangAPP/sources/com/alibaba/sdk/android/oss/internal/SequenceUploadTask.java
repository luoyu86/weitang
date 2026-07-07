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

/* JADX INFO: loaded from: classes.dex */
public class SequenceUploadTask extends BaseMultipartUploadTask<ResumableUploadRequest, ResumableUploadResult> implements Callable<ResumableUploadResult> {
    private List<Integer> mAlreadyUploadIndex;
    private File mCRC64RecordFile;
    private long mFirstPartSize;
    private File mRecordFile;
    private OSSSharedPreferences mSp;

    public SequenceUploadTask(ResumableUploadRequest resumableUploadRequest, OSSCompletedCallback<ResumableUploadRequest, ResumableUploadResult> oSSCompletedCallback, ExecutionContext executionContext, InternalRequestOperation internalRequestOperation) {
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

    /* JADX WARN: Removed duplicated region for block: B:41:0x013a  */
    @Override // com.alibaba.sdk.android.oss.internal.BaseMultipartUploadTask
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void initMultipartUploadId() throws com.alibaba.sdk.android.oss.ServiceException, com.alibaba.sdk.android.oss.ClientException, java.io.IOException {
        /*
            Method dump skipped, instruction units count: 651
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.oss.internal.SequenceUploadTask.initMultipartUploadId():void");
    }

    @Override // com.alibaba.sdk.android.oss.internal.BaseMultipartUploadTask
    public void processException(Exception exc) {
        if (this.mUploadException == null || !exc.getMessage().equals(this.mUploadException.getMessage())) {
            this.mUploadException = exc;
        }
        OSSLog.logThrowable2Local(exc);
        if (!this.mContext.getCancellationHandler().isCancelled() || this.mIsCancel) {
            return;
        }
        this.mIsCancel = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:100:0x01b9 A[Catch: IOException -> 0x01b0, TRY_LEAVE, TryCatch #10 {IOException -> 0x01b0, blocks: (B:94:0x01ac, B:98:0x01b4, B:100:0x01b9), top: B:109:0x01ac }] */
    /* JADX WARN: Removed duplicated region for block: B:109:0x01ac A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:121:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:123:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00ba A[Catch: ServiceException -> 0x010c, Exception -> 0x010f, all -> 0x01a8, TryCatch #0 {Exception -> 0x010f, blocks: (B:29:0x0071, B:30:0x008a, B:32:0x00ba, B:33:0x00c5, B:35:0x00de, B:43:0x00f9, B:44:0x010b), top: B:104:0x0071 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00de A[Catch: ServiceException -> 0x010c, Exception -> 0x010f, all -> 0x01a8, TRY_LEAVE, TryCatch #0 {Exception -> 0x010f, blocks: (B:29:0x0071, B:30:0x008a, B:32:0x00ba, B:33:0x00c5, B:35:0x00de, B:43:0x00f9, B:44:0x010b), top: B:104:0x0071 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00f9 A[Catch: ServiceException -> 0x010c, Exception -> 0x010f, all -> 0x01a8, TRY_ENTER, TryCatch #0 {Exception -> 0x010f, blocks: (B:29:0x0071, B:30:0x008a, B:32:0x00ba, B:33:0x00c5, B:35:0x00de, B:43:0x00f9, B:44:0x010b), top: B:104:0x0071 }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x012e A[Catch: IOException -> 0x0132, TRY_ENTER, TryCatch #9 {IOException -> 0x0132, blocks: (B:37:0x00ea, B:39:0x00ef, B:41:0x00f4, B:64:0x012e, B:68:0x0136, B:70:0x013b, B:85:0x019a, B:87:0x019f, B:89:0x01a4), top: B:108:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0136 A[Catch: IOException -> 0x0132, TryCatch #9 {IOException -> 0x0132, blocks: (B:37:0x00ea, B:39:0x00ef, B:41:0x00f4, B:64:0x012e, B:68:0x0136, B:70:0x013b, B:85:0x019a, B:87:0x019f, B:89:0x01a4), top: B:108:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x013b A[Catch: IOException -> 0x0132, TRY_LEAVE, TryCatch #9 {IOException -> 0x0132, blocks: (B:37:0x00ea, B:39:0x00ef, B:41:0x00f4, B:64:0x012e, B:68:0x0136, B:70:0x013b, B:85:0x019a, B:87:0x019f, B:89:0x01a4), top: B:108:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0151 A[Catch: all -> 0x01a8, TryCatch #8 {all -> 0x01a8, blocks: (B:29:0x0071, B:30:0x008a, B:32:0x00ba, B:33:0x00c5, B:35:0x00de, B:43:0x00f9, B:44:0x010b, B:77:0x0149, B:79:0x0151, B:80:0x0155, B:82:0x016f, B:83:0x018d), top: B:104:0x0071 }] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0155 A[Catch: all -> 0x01a8, TryCatch #8 {all -> 0x01a8, blocks: (B:29:0x0071, B:30:0x008a, B:32:0x00ba, B:33:0x00c5, B:35:0x00de, B:43:0x00f9, B:44:0x010b, B:77:0x0149, B:79:0x0151, B:80:0x0155, B:82:0x016f, B:83:0x018d), top: B:104:0x0071 }] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x019a A[Catch: IOException -> 0x0132, TRY_ENTER, TryCatch #9 {IOException -> 0x0132, blocks: (B:37:0x00ea, B:39:0x00ef, B:41:0x00f4, B:64:0x012e, B:68:0x0136, B:70:0x013b, B:85:0x019a, B:87:0x019f, B:89:0x01a4), top: B:108:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x019f A[Catch: IOException -> 0x0132, TryCatch #9 {IOException -> 0x0132, blocks: (B:37:0x00ea, B:39:0x00ef, B:41:0x00f4, B:64:0x012e, B:68:0x0136, B:70:0x013b, B:85:0x019a, B:87:0x019f, B:89:0x01a4), top: B:108:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01a4 A[Catch: IOException -> 0x0132, TRY_LEAVE, TryCatch #9 {IOException -> 0x0132, blocks: (B:37:0x00ea, B:39:0x00ef, B:41:0x00f4, B:64:0x012e, B:68:0x0136, B:70:0x013b, B:85:0x019a, B:87:0x019f, B:89:0x01a4), top: B:108:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01b4 A[Catch: IOException -> 0x01b0, TryCatch #10 {IOException -> 0x01b0, blocks: (B:94:0x01ac, B:98:0x01b4, B:100:0x01b9), top: B:109:0x01ac }] */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v21 */
    /* JADX WARN: Type inference failed for: r0v22 */
    /* JADX WARN: Type inference failed for: r0v23 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.io.RandomAccessFile] */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.io.RandomAccessFile] */
    /* JADX WARN: Type inference failed for: r0v6, types: [com.alibaba.sdk.android.oss.model.UploadPartRequest] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r12v0, types: [com.alibaba.sdk.android.oss.internal.BaseMultipartUploadTask, com.alibaba.sdk.android.oss.internal.SequenceUploadTask] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v20, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v23 */
    /* JADX WARN: Type inference failed for: r1v24 */
    /* JADX WARN: Type inference failed for: r1v25 */
    /* JADX WARN: Type inference failed for: r1v26 */
    /* JADX WARN: Type inference failed for: r1v27 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.io.RandomAccessFile] */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.io.RandomAccessFile] */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8, types: [java.io.RandomAccessFile] */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v14, types: [java.io.BufferedInputStream] */
    /* JADX WARN: Type inference failed for: r5v16 */
    /* JADX WARN: Type inference failed for: r5v17 */
    /* JADX WARN: Type inference failed for: r5v18 */
    /* JADX WARN: Type inference failed for: r5v19 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v20 */
    /* JADX WARN: Type inference failed for: r5v21, types: [java.io.BufferedInputStream] */
    /* JADX WARN: Type inference failed for: r5v22 */
    /* JADX WARN: Type inference failed for: r5v23 */
    /* JADX WARN: Type inference failed for: r5v24 */
    /* JADX WARN: Type inference failed for: r5v3, types: [java.io.BufferedInputStream] */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.io.BufferedInputStream] */
    /* JADX WARN: Type inference failed for: r5v5, types: [java.io.BufferedInputStream] */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9 */
    @Override // com.alibaba.sdk.android.oss.internal.BaseMultipartUploadTask
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void uploadPart(int r13, int r14, int r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 449
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.oss.internal.SequenceUploadTask.uploadPart(int, int, int):void");
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
        long j = this.mUploadedLength;
        checkCancel();
        int[] iArr = this.mPartAttr;
        int i2 = iArr[0];
        int i3 = iArr[1];
        if (this.mPartETags.size() > 0 && this.mAlreadyUploadIndex.size() > 0) {
            long jLongValue = this.mUploadedLength;
            if (jLongValue > this.mFileLength) {
                throw new ClientException("The uploading file is inconsistent with before");
            }
            if (this.mFirstPartSize != i2) {
                throw new ClientException("The part size setting is inconsistent with before");
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
        for (int i4 = 0; i4 < i3; i4++) {
            if (this.mAlreadyUploadIndex.size() == 0 || !this.mAlreadyUploadIndex.contains(Integer.valueOf(i4 + 1))) {
                if (i4 == i3 - 1) {
                    i2 = (int) (this.mFileLength - j);
                }
                OSSLog.logDebug("upload part readByte : " + i2);
                j += (long) i2;
                uploadPart(i4, i2, i3);
                if (this.mUploadException != null) {
                    break;
                }
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
        return resumableUploadResult;
    }
}
