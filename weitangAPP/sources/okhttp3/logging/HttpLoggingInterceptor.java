package okhttp3.logging;

import androidx.recyclerview.widget.RecyclerView;
import anet.channel.util.HttpConstant;
import f.c;
import f.e;
import f.j;
import java.io.EOFException;
import java.nio.charset.Charset;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import okhttp3.Connection;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.platform.Platform;

/* JADX INFO: loaded from: classes2.dex */
public final class HttpLoggingInterceptor implements Interceptor {
    private static final Charset UTF8 = Charset.forName("UTF-8");
    private volatile Level level;
    private final Logger logger;

    public enum Level {
        NONE,
        BASIC,
        HEADERS,
        BODY
    }

    public interface Logger {
        public static final Logger DEFAULT = new Logger() { // from class: okhttp3.logging.HttpLoggingInterceptor.Logger.1
            @Override // okhttp3.logging.HttpLoggingInterceptor.Logger
            public void log(String str) {
                Platform.get().log(4, str, null);
            }
        };

        void log(String str);
    }

    public HttpLoggingInterceptor() {
        this(Logger.DEFAULT);
    }

    private boolean bodyHasUnknownEncoding(Headers headers) {
        String str = headers.get("Content-Encoding");
        return (str == null || str.equalsIgnoreCase("identity") || str.equalsIgnoreCase(HttpConstant.GZIP)) ? false : true;
    }

    public static boolean isPlaintext(c cVar) {
        try {
            c cVar2 = new c();
            cVar.copyTo(cVar2, 0L, cVar.size() < 64 ? cVar.size() : 64L);
            for (int i2 = 0; i2 < 16; i2++) {
                if (cVar2.exhausted()) {
                    return true;
                }
                int utf8CodePoint = cVar2.readUtf8CodePoint();
                if (Character.isISOControl(utf8CodePoint) && !Character.isWhitespace(utf8CodePoint)) {
                    return false;
                }
            }
            return true;
        } catch (EOFException unused) {
            return false;
        }
    }

    public Level getLevel() {
        return this.level;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws Exception {
        boolean z;
        long j;
        char c2;
        String string;
        boolean z2;
        Level level = this.level;
        Request request = chain.request();
        if (level == Level.NONE) {
            return chain.proceed(request);
        }
        boolean z3 = level == Level.BODY;
        boolean z4 = z3 || level == Level.HEADERS;
        RequestBody requestBodyBody = request.body();
        boolean z5 = requestBodyBody != null;
        Connection connection = chain.connection();
        StringBuilder sb = new StringBuilder();
        sb.append("--> ");
        sb.append(request.method());
        sb.append(' ');
        sb.append(request.url());
        sb.append(connection != null ? " " + connection.protocol() : "");
        String string2 = sb.toString();
        if (!z4 && z5) {
            string2 = string2 + " (" + requestBodyBody.contentLength() + "-byte body)";
        }
        this.logger.log(string2);
        if (z4) {
            if (z5) {
                if (requestBodyBody.contentType() != null) {
                    this.logger.log("Content-Type: " + requestBodyBody.contentType());
                }
                if (requestBodyBody.contentLength() != -1) {
                    this.logger.log("Content-Length: " + requestBodyBody.contentLength());
                }
            }
            Headers headers = request.headers();
            int size = headers.size();
            int i2 = 0;
            while (i2 < size) {
                String strName = headers.name(i2);
                int i3 = size;
                if ("Content-Type".equalsIgnoreCase(strName) || "Content-Length".equalsIgnoreCase(strName)) {
                    z2 = z4;
                } else {
                    z2 = z4;
                    this.logger.log(strName + ": " + headers.value(i2));
                }
                i2++;
                size = i3;
                z4 = z2;
            }
            z = z4;
            if (!z3 || !z5) {
                this.logger.log("--> END " + request.method());
            } else if (bodyHasUnknownEncoding(request.headers())) {
                this.logger.log("--> END " + request.method() + " (encoded body omitted)");
            } else {
                c cVar = new c();
                requestBodyBody.writeTo(cVar);
                Charset charset = UTF8;
                MediaType mediaTypeContentType = requestBodyBody.contentType();
                if (mediaTypeContentType != null) {
                    charset = mediaTypeContentType.charset(charset);
                }
                this.logger.log("");
                if (isPlaintext(cVar)) {
                    this.logger.log(cVar.readString(charset));
                    this.logger.log("--> END " + request.method() + " (" + requestBodyBody.contentLength() + "-byte body)");
                } else {
                    this.logger.log("--> END " + request.method() + " (binary " + requestBodyBody.contentLength() + "-byte body omitted)");
                }
            }
        } else {
            z = z4;
        }
        long jNanoTime = System.nanoTime();
        try {
            Response responseProceed = chain.proceed(request);
            long millis = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - jNanoTime);
            ResponseBody responseBodyBody = responseProceed.body();
            long jContentLength = responseBodyBody.contentLength();
            String str = jContentLength != -1 ? jContentLength + "-byte" : "unknown-length";
            Logger logger = this.logger;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("<-- ");
            sb2.append(responseProceed.code());
            if (responseProceed.message().isEmpty()) {
                j = jContentLength;
                string = "";
                c2 = ' ';
            } else {
                StringBuilder sb3 = new StringBuilder();
                j = jContentLength;
                c2 = ' ';
                sb3.append(' ');
                sb3.append(responseProceed.message());
                string = sb3.toString();
            }
            sb2.append(string);
            sb2.append(c2);
            sb2.append(responseProceed.request().url());
            sb2.append(" (");
            sb2.append(millis);
            sb2.append("ms");
            sb2.append(z ? "" : ", " + str + " body");
            sb2.append(')');
            logger.log(sb2.toString());
            if (z) {
                Headers headers2 = responseProceed.headers();
                int size2 = headers2.size();
                for (int i4 = 0; i4 < size2; i4++) {
                    this.logger.log(headers2.name(i4) + ": " + headers2.value(i4));
                }
                if (!z3 || !HttpHeaders.hasBody(responseProceed)) {
                    this.logger.log("<-- END HTTP");
                } else if (bodyHasUnknownEncoding(responseProceed.headers())) {
                    this.logger.log("<-- END HTTP (encoded body omitted)");
                } else {
                    e eVarSource = responseBodyBody.source();
                    eVarSource.request(RecyclerView.FOREVER_NS);
                    c cVarBuffer = eVarSource.buffer();
                    Long l = null;
                    j jVar = null;
                    if (HttpConstant.GZIP.equalsIgnoreCase(headers2.get("Content-Encoding"))) {
                        Long lValueOf = Long.valueOf(cVarBuffer.size());
                        try {
                            j jVar2 = new j(cVarBuffer.m471clone());
                            try {
                                cVarBuffer = new c();
                                cVarBuffer.writeAll(jVar2);
                                jVar2.close();
                                l = lValueOf;
                            } catch (Throwable th) {
                                th = th;
                                jVar = jVar2;
                                if (jVar != null) {
                                    jVar.close();
                                }
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    }
                    Charset charset2 = UTF8;
                    MediaType mediaTypeContentType2 = responseBodyBody.contentType();
                    if (mediaTypeContentType2 != null) {
                        charset2 = mediaTypeContentType2.charset(charset2);
                    }
                    if (!isPlaintext(cVarBuffer)) {
                        this.logger.log("");
                        this.logger.log("<-- END HTTP (binary " + cVarBuffer.size() + "-byte body omitted)");
                        return responseProceed;
                    }
                    if (j != 0) {
                        this.logger.log("");
                        this.logger.log(cVarBuffer.m471clone().readString(charset2));
                    }
                    if (l != null) {
                        this.logger.log("<-- END HTTP (" + cVarBuffer.size() + "-byte, " + l + "-gzipped-byte body)");
                    } else {
                        this.logger.log("<-- END HTTP (" + cVarBuffer.size() + "-byte body)");
                    }
                }
            }
            return responseProceed;
        } catch (Exception e2) {
            this.logger.log("<-- HTTP FAILED: " + e2);
            throw e2;
        }
    }

    public HttpLoggingInterceptor setLevel(Level level) {
        Objects.requireNonNull(level, "level == null. Use Level.NONE instead.");
        this.level = level;
        return this;
    }

    public HttpLoggingInterceptor(Logger logger) {
        this.level = Level.NONE;
        this.logger = logger;
    }
}
