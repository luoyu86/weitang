package c.e.a.a.i;

import android.content.Context;
import c.e.a.d.o;
import c.e.a.d.q;
import c.e.a.d.x;
import com.alibaba.sdk.android.oss.ClientConfiguration;
import com.alibaba.sdk.android.oss.ClientException;
import com.alibaba.sdk.android.oss.OSSClient;
import com.alibaba.sdk.android.oss.ServiceException;
import com.alibaba.sdk.android.oss.callback.OSSCompletedCallback;
import com.alibaba.sdk.android.oss.common.auth.OSSStsTokenCredentialProvider;
import com.alibaba.sdk.android.oss.model.ListObjectsRequest;
import com.alibaba.sdk.android.oss.model.ListObjectsResult;
import com.alibaba.sdk.android.oss.model.OSSObjectSummary;
import com.chinavisionary.core.app.oss.bo.AliYunOssResultVo;
import com.chinavisionary.core.app.oss.bo.AliYunTokenConfigBo;
import com.chinavisionary.core.app.oss.bo.BucketBo;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f1027a;

    /* JADX INFO: renamed from: c.e.a.a.i.a$a, reason: collision with other inner class name */
    public class C0018a implements OSSCompletedCallback<ListObjectsRequest, ListObjectsResult> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BucketBo f1028a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ OSSClient f1029b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ c.e.a.a.i.c.a f1030c;

        public C0018a(BucketBo bucketBo, OSSClient oSSClient, c.e.a.a.i.c.a aVar) {
            this.f1028a = bucketBo;
            this.f1029b = oSSClient;
            this.f1030c = aVar;
        }

        @Override // com.alibaba.sdk.android.oss.callback.OSSCompletedCallback
        public void onFailure(ListObjectsRequest listObjectsRequest, ClientException clientException, ServiceException serviceException) {
            q.d(C0018a.class.getSimpleName(), "onFailure bucket name = " + this.f1028a.getBucketName() + ", getErrorCode = " + serviceException.getErrorCode() + ", getStatusCode = " + serviceException.getStatusCode() + ", err msg = " + serviceException.getMessage());
            c.e.a.a.i.c.a aVar = this.f1030c;
            StringBuilder sb = new StringBuilder();
            sb.append("bucket name = ");
            sb.append(this.f1028a.getBucketName());
            sb.append(", err msg = ");
            sb.append(serviceException.getMessage());
            aVar.onFailed(sb.toString());
        }

        @Override // com.alibaba.sdk.android.oss.callback.OSSCompletedCallback
        public void onSuccess(ListObjectsRequest listObjectsRequest, ListObjectsResult listObjectsResult) {
            if (listObjectsResult == null) {
                q.d(C0018a.class.getSimpleName(), "bucket name = " + this.f1028a.getBucketName() + " result is empty");
                this.f1030c.onFailed("bucket name = " + this.f1028a.getBucketName() + " result is empty");
                return;
            }
            q.d(C0018a.class.getSimpleName(), "onSuccess");
            List<OSSObjectSummary> objectSummaries = listObjectsResult.getObjectSummaries();
            if (!o.isNotEmpty(objectSummaries)) {
                q.d(C0018a.class.getSimpleName(), "bucket name = " + this.f1028a.getBucketName() + " result summaryList empty");
                this.f1030c.onFailed("bucket name = " + this.f1028a.getBucketName() + " result summaryList empty");
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (OSSObjectSummary oSSObjectSummary : objectSummaries) {
                if (oSSObjectSummary != null) {
                    String key = oSSObjectSummary.getKey();
                    if (x.isNotNull(key)) {
                        List listF = a.this.f(oSSObjectSummary, this.f1028a.getBucketName(), this.f1029b);
                        if (o.isNotEmpty(listF)) {
                            AliYunOssResultVo aliYunOssResultVo = new AliYunOssResultVo();
                            aliYunOssResultVo.setBucketName(this.f1028a.getBucketName());
                            aliYunOssResultVo.setPathName(key);
                            aliYunOssResultVo.setPicUrl((String) listF.get(0));
                            arrayList.add(aliYunOssResultVo);
                        }
                    }
                }
            }
            q.d(C0018a.class.getSimpleName(), "callback  onSuccess size=" + arrayList.size() + ",summaryList=" + objectSummaries.size());
            if (!arrayList.isEmpty()) {
                b.getInstance().setList(arrayList);
                this.f1030c.onSuccess(arrayList);
                return;
            }
            this.f1030c.onFailed("bucket name = " + this.f1028a.getBucketName() + " result ossUrls empty");
        }
    }

    public a(Context context) {
        this.f1027a = context;
    }

    public final void b(OSSClient oSSClient, BucketBo bucketBo) {
        c.e.a.a.i.c.a callback = bucketBo.getCallback();
        ListObjectsRequest listObjectsRequestD = d(bucketBo.getBucketName());
        q.d(a.class.getSimpleName(), "getBucketList getBucketName = " + bucketBo.getBucketName());
        oSSClient.asyncListObjects(listObjectsRequestD, new C0018a(bucketBo, oSSClient, callback)).waitUntilFinished();
    }

    public final ClientConfiguration c() {
        ClientConfiguration clientConfiguration = new ClientConfiguration();
        clientConfiguration.setConnectionTimeout(5000);
        clientConfiguration.setSocketTimeout(5000);
        clientConfiguration.setMaxConcurrentRequest(10);
        clientConfiguration.setMaxErrorRetry(2);
        return clientConfiguration;
    }

    public final ListObjectsRequest d(String str) {
        ListObjectsRequest listObjectsRequest = new ListObjectsRequest(str);
        listObjectsRequest.setMaxKeys(1000);
        return listObjectsRequest;
    }

    public final OSSClient e(AliYunTokenConfigBo aliYunTokenConfigBo) {
        return new OSSClient(this.f1027a, aliYunTokenConfigBo.getEndpoint(), g(aliYunTokenConfigBo), c());
    }

    public final List<String> f(OSSObjectSummary oSSObjectSummary, String str, OSSClient oSSClient) {
        ArrayList arrayList = new ArrayList();
        if (oSSObjectSummary != null) {
            String strPresignPublicObjectURL = oSSClient.presignPublicObjectURL(str, oSSObjectSummary.getKey());
            if (x.isNotNull(strPresignPublicObjectURL)) {
                arrayList.add(strPresignPublicObjectURL);
            }
        }
        return arrayList;
    }

    public final OSSStsTokenCredentialProvider g(AliYunTokenConfigBo aliYunTokenConfigBo) {
        return new OSSStsTokenCredentialProvider(aliYunTokenConfigBo.getAccessKeyId(), aliYunTokenConfigBo.getSecretKeyId(), aliYunTokenConfigBo.getSecurityToken());
    }

    public void getAliYunOssUrl(AliYunTokenConfigBo aliYunTokenConfigBo, BucketBo bucketBo) {
        b(e(aliYunTokenConfigBo), bucketBo);
    }
}
