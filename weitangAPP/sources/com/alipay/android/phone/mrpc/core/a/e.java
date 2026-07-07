package com.alipay.android.phone.mrpc.core.a;

import com.alipay.android.phone.mrpc.core.RpcException;
import java.util.ArrayList;
import okhttp3.HttpUrl;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;

/* JADX INFO: loaded from: classes.dex */
public final class e extends b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f5060c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object f5061d;

    public e(int i2, String str, Object obj) {
        super(str, obj);
        this.f5060c = i2;
    }

    @Override // com.alipay.android.phone.mrpc.core.a.f
    public final void a(Object obj) {
        this.f5061d = obj;
    }

    @Override // com.alipay.android.phone.mrpc.core.a.f
    public final byte[] a() {
        try {
            ArrayList arrayList = new ArrayList();
            if (this.f5061d != null) {
                arrayList.add(new BasicNameValuePair("extParam", com.alipay.sdk.m.e.f.a(this.f5061d)));
            }
            arrayList.add(new BasicNameValuePair("operationType", this.f5058a));
            StringBuilder sb = new StringBuilder();
            sb.append(this.f5060c);
            arrayList.add(new BasicNameValuePair("id", sb.toString()));
            new StringBuilder("mParams is:").append(this.f5059b);
            Object obj = this.f5059b;
            arrayList.add(new BasicNameValuePair("requestData", obj == null ? HttpUrl.PATH_SEGMENT_ENCODE_SET_URI : com.alipay.sdk.m.e.f.a(obj)));
            return URLEncodedUtils.format(arrayList, "utf-8").getBytes();
        } catch (Exception e2) {
            StringBuilder sb2 = new StringBuilder("request  =");
            sb2.append(this.f5059b);
            sb2.append(":");
            sb2.append(e2);
            throw new RpcException(9, sb2.toString() == null ? "" : e2.getMessage(), e2);
        }
    }
}
