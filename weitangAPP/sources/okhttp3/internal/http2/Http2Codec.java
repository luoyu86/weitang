package okhttp3.internal.http2;

import f.c;
import f.f;
import f.h;
import f.l;
import f.s;
import f.t;
import f.u;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;
import okhttp3.internal.connection.StreamAllocation;
import okhttp3.internal.http.HttpCodec;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http.RealResponseBody;
import okhttp3.internal.http.RequestLine;
import okhttp3.internal.http.StatusLine;

/* JADX INFO: loaded from: classes2.dex */
public final class Http2Codec implements HttpCodec {
    private static final f CONNECTION;
    private static final f ENCODING;
    private static final f HOST;
    private static final List<f> HTTP_2_SKIPPED_REQUEST_HEADERS;
    private static final List<f> HTTP_2_SKIPPED_RESPONSE_HEADERS;
    private static final f KEEP_ALIVE;
    private static final f PROXY_CONNECTION;
    private static final f TE;
    private static final f TRANSFER_ENCODING;
    private static final f UPGRADE;
    private final Interceptor.Chain chain;
    private final Http2Connection connection;
    private final Protocol protocol;
    private Http2Stream stream;
    public final StreamAllocation streamAllocation;

    public class StreamFinishingSource extends h {
        public long bytesRead;
        public boolean completed;

        public StreamFinishingSource(t tVar) {
            super(tVar);
            this.completed = false;
            this.bytesRead = 0L;
        }

        private void endOfInput(IOException iOException) {
            if (this.completed) {
                return;
            }
            this.completed = true;
            Http2Codec http2Codec = Http2Codec.this;
            http2Codec.streamAllocation.streamFinished(false, http2Codec, this.bytesRead, iOException);
        }

        @Override // f.h, f.t, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            super.close();
            endOfInput(null);
        }

        @Override // f.h, f.t
        public long read(c cVar, long j) throws IOException {
            try {
                long j2 = delegate().read(cVar, j);
                if (j2 > 0) {
                    this.bytesRead += j2;
                }
                return j2;
            } catch (IOException e2) {
                endOfInput(e2);
                throw e2;
            }
        }
    }

    static {
        f fVarEncodeUtf8 = f.encodeUtf8("connection");
        CONNECTION = fVarEncodeUtf8;
        f fVarEncodeUtf82 = f.encodeUtf8("host");
        HOST = fVarEncodeUtf82;
        f fVarEncodeUtf83 = f.encodeUtf8("keep-alive");
        KEEP_ALIVE = fVarEncodeUtf83;
        f fVarEncodeUtf84 = f.encodeUtf8("proxy-connection");
        PROXY_CONNECTION = fVarEncodeUtf84;
        f fVarEncodeUtf85 = f.encodeUtf8("transfer-encoding");
        TRANSFER_ENCODING = fVarEncodeUtf85;
        f fVarEncodeUtf86 = f.encodeUtf8("te");
        TE = fVarEncodeUtf86;
        f fVarEncodeUtf87 = f.encodeUtf8("encoding");
        ENCODING = fVarEncodeUtf87;
        f fVarEncodeUtf88 = f.encodeUtf8("upgrade");
        UPGRADE = fVarEncodeUtf88;
        HTTP_2_SKIPPED_REQUEST_HEADERS = Util.immutableList(fVarEncodeUtf8, fVarEncodeUtf82, fVarEncodeUtf83, fVarEncodeUtf84, fVarEncodeUtf86, fVarEncodeUtf85, fVarEncodeUtf87, fVarEncodeUtf88, Header.TARGET_METHOD, Header.TARGET_PATH, Header.TARGET_SCHEME, Header.TARGET_AUTHORITY);
        HTTP_2_SKIPPED_RESPONSE_HEADERS = Util.immutableList(fVarEncodeUtf8, fVarEncodeUtf82, fVarEncodeUtf83, fVarEncodeUtf84, fVarEncodeUtf86, fVarEncodeUtf85, fVarEncodeUtf87, fVarEncodeUtf88);
    }

    public Http2Codec(OkHttpClient okHttpClient, Interceptor.Chain chain, StreamAllocation streamAllocation, Http2Connection http2Connection) {
        this.chain = chain;
        this.streamAllocation = streamAllocation;
        this.connection = http2Connection;
        List<Protocol> listProtocols = okHttpClient.protocols();
        Protocol protocol = Protocol.H2_PRIOR_KNOWLEDGE;
        this.protocol = listProtocols.contains(protocol) ? protocol : Protocol.HTTP_2;
    }

    public static List<Header> http2HeadersList(Request request) {
        Headers headers = request.headers();
        ArrayList arrayList = new ArrayList(headers.size() + 4);
        arrayList.add(new Header(Header.TARGET_METHOD, request.method()));
        arrayList.add(new Header(Header.TARGET_PATH, RequestLine.requestPath(request.url())));
        String strHeader = request.header("Host");
        if (strHeader != null) {
            arrayList.add(new Header(Header.TARGET_AUTHORITY, strHeader));
        }
        arrayList.add(new Header(Header.TARGET_SCHEME, request.url().scheme()));
        int size = headers.size();
        for (int i2 = 0; i2 < size; i2++) {
            f fVarEncodeUtf8 = f.encodeUtf8(headers.name(i2).toLowerCase(Locale.US));
            if (!HTTP_2_SKIPPED_REQUEST_HEADERS.contains(fVarEncodeUtf8)) {
                arrayList.add(new Header(fVarEncodeUtf8, headers.value(i2)));
            }
        }
        return arrayList;
    }

    public static Response.Builder readHttp2HeadersList(List<Header> list, Protocol protocol) throws IOException {
        Headers.Builder builder = new Headers.Builder();
        int size = list.size();
        StatusLine statusLine = null;
        for (int i2 = 0; i2 < size; i2++) {
            Header header = list.get(i2);
            if (header != null) {
                f fVar = header.name;
                String strUtf8 = header.value.utf8();
                if (fVar.equals(Header.RESPONSE_STATUS)) {
                    statusLine = StatusLine.parse("HTTP/1.1 " + strUtf8);
                } else if (!HTTP_2_SKIPPED_RESPONSE_HEADERS.contains(fVar)) {
                    Internal.instance.addLenient(builder, fVar.utf8(), strUtf8);
                }
            } else if (statusLine != null && statusLine.code == 100) {
                builder = new Headers.Builder();
                statusLine = null;
            }
        }
        if (statusLine != null) {
            return new Response.Builder().protocol(protocol).code(statusLine.code).message(statusLine.message).headers(builder.build());
        }
        throw new ProtocolException("Expected ':status' header not present");
    }

    @Override // okhttp3.internal.http.HttpCodec
    public void cancel() {
        Http2Stream http2Stream = this.stream;
        if (http2Stream != null) {
            http2Stream.closeLater(ErrorCode.CANCEL);
        }
    }

    @Override // okhttp3.internal.http.HttpCodec
    public s createRequestBody(Request request, long j) {
        return this.stream.getSink();
    }

    @Override // okhttp3.internal.http.HttpCodec
    public void finishRequest() throws IOException {
        this.stream.getSink().close();
    }

    @Override // okhttp3.internal.http.HttpCodec
    public void flushRequest() throws IOException {
        this.connection.flush();
    }

    @Override // okhttp3.internal.http.HttpCodec
    public ResponseBody openResponseBody(Response response) throws IOException {
        StreamAllocation streamAllocation = this.streamAllocation;
        streamAllocation.eventListener.responseBodyStart(streamAllocation.call);
        return new RealResponseBody(response.header("Content-Type"), HttpHeaders.contentLength(response), l.buffer(new StreamFinishingSource(this.stream.getSource())));
    }

    @Override // okhttp3.internal.http.HttpCodec
    public Response.Builder readResponseHeaders(boolean z) throws IOException {
        Response.Builder http2HeadersList = readHttp2HeadersList(this.stream.takeResponseHeaders(), this.protocol);
        if (z && Internal.instance.code(http2HeadersList) == 100) {
            return null;
        }
        return http2HeadersList;
    }

    @Override // okhttp3.internal.http.HttpCodec
    public void writeRequestHeaders(Request request) throws IOException {
        if (this.stream != null) {
            return;
        }
        Http2Stream http2StreamNewStream = this.connection.newStream(http2HeadersList(request), request.body() != null);
        this.stream = http2StreamNewStream;
        u timeout = http2StreamNewStream.readTimeout();
        long timeoutMillis = this.chain.readTimeoutMillis();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        timeout.timeout(timeoutMillis, timeUnit);
        this.stream.writeTimeout().timeout(this.chain.writeTimeoutMillis(), timeUnit);
    }
}
