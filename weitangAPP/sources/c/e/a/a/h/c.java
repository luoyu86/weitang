package c.e.a.a.h;

import c.e.a.d.q;
import c.e.a.d.w;
import c.e.a.d.y;
import com.alibaba.android.arouter.utils.Consts;
import com.alibaba.fastjson.JSON;
import com.alibaba.sdk.android.oss.common.OSSConstants;
import com.chinavisionary.core.app.net.base.dto.RequestErrDto;
import com.chinavisionary.core.app.net.base.dto.ResponseUploadVo;
import com.chinavisionary.core.app.net.base.dto.UploadDto;
import com.chinavisionary.core.app.net.base.dto.UploadProgressDto;
import f.l;
import f.t;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static c f1012a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final HttpLoggingInterceptor f1013b = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public OkHttpClient f1014c;

    public class a implements HostnameVerifier {
        public a() {
        }

        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            return true;
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ UploadDto f1016a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ OkHttpClient f1017b;

        public class a implements Callback {
            public a() {
            }

            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                q.d(c.class.getCanonicalName() + "onFailure", "error msg :" + iOException.getMessage());
                b bVar = b.this;
                c.this.m(bVar.f1016a.getIUploadCallback(), b.this.f1016a.getRequestUrl(), iOException.getMessage());
                call.cancel();
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) throws IOException {
                c.e.a.a.h.e.c iUploadCallback = b.this.f1016a.getIUploadCallback();
                ResponseBody responseBodyBody = response.body();
                if (responseBodyBody != null) {
                    String strString = responseBodyBody.string();
                    if (response.isSuccessful()) {
                        ResponseUploadVo responseUploadVo = (ResponseUploadVo) JSON.parseObject(strString, ResponseUploadVo.class);
                        if (responseUploadVo.isSuccess()) {
                            iUploadCallback.onSuccess(responseUploadVo);
                        } else {
                            b bVar = b.this;
                            c.this.n(iUploadCallback, bVar.f1016a.getRequestUrl(), responseUploadVo.getMessage(), response.code());
                        }
                    } else {
                        b bVar2 = b.this;
                        c.this.n(iUploadCallback, bVar2.f1016a.getRequestUrl(), response.code() + response.message(), response.code());
                    }
                } else {
                    b bVar3 = b.this;
                    c.this.n(iUploadCallback, bVar3.f1016a.getRequestUrl(), response.code() + response.message(), response.code());
                }
                call.cancel();
                q.d(c.class.getCanonicalName() + "onResponse", "response code : " + response.code());
            }
        }

        public b(UploadDto uploadDto, OkHttpClient okHttpClient) {
            this.f1016a = uploadDto;
            this.f1017b = okHttpClient;
        }

        @Override // java.lang.Runnable
        public void run() {
            UploadDto uploadDto = this.f1016a;
            if (uploadDto == null || uploadDto.getIUploadCallback() == null) {
                return;
            }
            List<File> uploadFile = this.f1016a.getUploadFile();
            if (uploadFile == null || uploadFile.isEmpty()) {
                c.this.m(this.f1016a.getIUploadCallback(), this.f1016a.getRequestUrl(), "上传失败,请重新选择图片进行上传");
                return;
            }
            this.f1017b.newCall(new Request.Builder().url(this.f1016a.getRequestUrl()).addHeader("Token", c.this.k()).post(c.this.j(uploadFile, new UploadProgressDto())).build()).enqueue(new a());
        }
    }

    /* JADX INFO: renamed from: c.e.a.a.h.c$c, reason: collision with other inner class name */
    public class C0017c extends RequestBody {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MediaType f1020a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ File f1021b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ c.e.a.a.h.e.a f1022c;

        public C0017c(MediaType mediaType, File file, c.e.a.a.h.e.a aVar) {
            this.f1020a = mediaType;
            this.f1021b = file;
            this.f1022c = aVar;
        }

        @Override // okhttp3.RequestBody
        public long contentLength() {
            return this.f1021b.length();
        }

        @Override // okhttp3.RequestBody
        public MediaType contentType() {
            return this.f1020a;
        }

        @Override // okhttp3.RequestBody
        public void writeTo(f.d dVar) {
            try {
                t tVarSource = l.source(this.f1021b);
                f.c cVar = new f.c();
                long jContentLength = contentLength();
                long j = 8192;
                if (jContentLength <= j) {
                    j = jContentLength;
                }
                long j2 = 0;
                while (true) {
                    long j3 = tVarSource.read(cVar, j);
                    if (j3 == -1) {
                        dVar.flush();
                        tVarSource.close();
                        return;
                    } else {
                        dVar.write(cVar, j3);
                        j2 += j3;
                        c.e.a.a.h.e.a aVar = this.f1022c;
                        if (aVar != null) {
                            aVar.onProgress(j2, this.f1021b.getAbsolutePath(), j2 == jContentLength);
                        }
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public class d implements Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f1024a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f1025b;

        public d(e eVar, String str) {
            this.f1024a = eVar;
            this.f1025b = str;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            c.this.l(this.f1024a, call, iOException.getMessage());
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) throws IOException {
            boolean zDelete;
            ResponseBody responseBodyBody = response.body();
            if (responseBodyBody == null) {
                c.this.l(this.f1024a, call, "response body is empty");
                return;
            }
            List<String> listPathSegments = call.request().url().pathSegments();
            if (listPathSegments != null && !listPathSegments.isEmpty()) {
                String str = listPathSegments.get(listPathSegments.size() - 1);
                String strSubstring = str.lastIndexOf(Consts.DOT) >= 0 ? str.substring(str.lastIndexOf(Consts.DOT)) : str;
                q.d(c.class.getSimpleName(), "file name: " + str + ", fileE:" + strSubstring);
            }
            File file = new File(this.f1025b);
            File parentFile = file.getParentFile();
            if (parentFile != null && !parentFile.exists()) {
                boolean zMkdirs = file.getParentFile().mkdirs();
                q.d(c.class.getSimpleName(), "is create :" + zMkdirs);
            }
            if (parentFile == null || !parentFile.canWrite()) {
                c.this.l(this.f1024a, call, "save file is directory");
                return;
            }
            if (!file.exists()) {
                zDelete = file.createNewFile();
                q.d(c.class.getSimpleName(), "download file createNewFile isCreateSuccess=" + zDelete);
            } else {
                if (file.length() == responseBodyBody.contentLength()) {
                    e eVar = this.f1024a;
                    if (eVar != null) {
                        eVar.onSuccess(file.getPath());
                    }
                    q.d(c.class.getSimpleName(), "download file content equals");
                    return;
                }
                zDelete = file.delete();
                q.d(c.class.getSimpleName(), "download file delete isCreateSuccess=" + zDelete);
            }
            q.d(c.class.getSimpleName(), "download file content equals isCreateSuccess=" + zDelete);
            if (!zDelete) {
                c.this.l(this.f1024a, call, "save file path error");
                return;
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            InputStream inputStreamByteStream = responseBodyBody.byteStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int i2 = inputStreamByteStream.read(bArr);
                if (i2 == -1) {
                    break;
                } else {
                    fileOutputStream.write(bArr, 0, i2);
                }
            }
            fileOutputStream.flush();
            fileOutputStream.close();
            inputStreamByteStream.close();
            e eVar2 = this.f1024a;
            if (eVar2 != null) {
                eVar2.onSuccess(file.getPath());
            }
        }
    }

    public interface e {
        void onFailed(RequestErrDto requestErrDto);

        void onSuccess(String str);
    }

    public static class f implements X509TrustManager {
        public f() {
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        }

        @Override // javax.net.ssl.X509TrustManager
        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }

        public /* synthetic */ f(a aVar) {
            this();
        }
    }

    public static class g implements HostnameVerifier {
        public g() {
        }

        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            return true;
        }

        public /* synthetic */ g(a aVar) {
            this();
        }
    }

    public c() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        OkHttpClient.Builder builderFollowRedirects = builder.readTimeout(20L, timeUnit).writeTimeout(20L, timeUnit).connectTimeout(20L, timeUnit).sslSocketFactory(g()).hostnameVerifier(new g(null)).followRedirects(true);
        builderFollowRedirects.hostnameVerifier(new a());
        if (c.e.a.a.a.getInstance().isDebug()) {
            builderFollowRedirects.addNetworkInterceptor(f1013b);
        }
        builderFollowRedirects.addInterceptor(new c.e.a.a.h.d.a());
        this.f1014c = builderFollowRedirects.build();
    }

    public static SSLSocketFactory g() {
        a aVar = null;
        try {
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, new TrustManager[]{new f(aVar)}, new SecureRandom());
            return sSLContext.getSocketFactory();
        } catch (Exception unused) {
            return null;
        }
    }

    public static c getInstance() {
        if (f1012a == null) {
            synchronized (c.class) {
                if (f1012a == null) {
                    f1012a = new c();
                }
            }
        }
        return f1012a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void p(String str, Callback callback) {
        this.f1014c.newCall(new Request.Builder().url(str).build()).enqueue(callback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void r(String str, String str2, Callback callback) {
        this.f1014c.newCall(new Request.Builder().url(str2).post(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), str)).build()).enqueue(callback);
    }

    public final void downloadFile(String str, String str2, e eVar) {
        this.f1014c.newCall(new Request.Builder().url(str).build()).enqueue(new d(eVar, str2));
    }

    public final void f(UploadDto uploadDto, OkHttpClient okHttpClient) {
        y.get().addRunnable(new b(uploadDto, okHttpClient));
    }

    public final OkHttpClient getOkHttpClient() {
        return this.f1014c;
    }

    public final RequestBody h(MediaType mediaType, File file, c.e.a.a.h.e.a aVar) {
        return new C0017c(mediaType, file, aVar);
    }

    public final String i(String str) {
        String contentTypeFor = URLConnection.getFileNameMap().getContentTypeFor(str);
        return contentTypeFor == null ? OSSConstants.DEFAULT_OBJECT_CONTENT_TYPE : contentTypeFor;
    }

    public final RequestBody j(List<File> list, UploadProgressDto uploadProgressDto) {
        MultipartBody.Builder builder = new MultipartBody.Builder();
        builder.setType(MultipartBody.FORM);
        int size = list.size();
        long length = 0;
        for (int i2 = 0; i2 < size; i2++) {
            File file = list.get(i2);
            if (file.exists()) {
                length += file.length();
                builder.addFormDataPart("file", file.getName(), h(MediaType.parse(i(file.getName())), file, uploadProgressDto.getIDownloadProgressCallback()));
            }
        }
        uploadProgressDto.setTotalLength(length);
        return builder.build();
    }

    public final String k() {
        String token = c.e.a.a.b.getInstance().getToken();
        if (token == null) {
            token = w.getInstance().getString("Token", "");
        }
        return token == null ? "" : token;
    }

    public final void l(e eVar, Call call, String str) {
        if (eVar == null || call == null) {
            return;
        }
        RequestErrDto requestErrDto = new RequestErrDto();
        requestErrDto.setUrl(call.request().url().toString());
        requestErrDto.setErrMsg(str);
        eVar.onFailed(requestErrDto);
    }

    public final void m(c.e.a.a.h.e.c cVar, String str, String str2) {
        RequestErrDto requestErrDto = new RequestErrDto();
        requestErrDto.setUrl(str);
        requestErrDto.setErrMsg(str2);
        cVar.onFailure(requestErrDto);
    }

    public final void n(c.e.a.a.h.e.c cVar, String str, String str2, int i2) {
        RequestErrDto requestErrDto = new RequestErrDto();
        requestErrDto.setUrl(str);
        requestErrDto.setErrMsg(str2);
        requestErrDto.setCode(i2);
        cVar.onFailure(requestErrDto);
    }

    public final void requestGet(final String str, final Callback callback) {
        y.get().addRunnable(new Runnable() { // from class: c.e.a.a.h.a
            @Override // java.lang.Runnable
            public final void run() {
                this.f1005a.p(str, callback);
            }
        });
    }

    public final void requestPost(final String str, final String str2, final Callback callback) {
        y.get().addRunnable(new Runnable() { // from class: c.e.a.a.h.b
            @Override // java.lang.Runnable
            public final void run() {
                this.f1008a.r(str2, str, callback);
            }
        });
    }

    public final void uploadFile(UploadDto uploadDto) {
        f(uploadDto, this.f1014c);
    }
}
