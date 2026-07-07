package okhttp3.internal.http2;

import f.a;
import f.c;
import f.e;
import f.s;
import f.t;
import f.u;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class Http2Stream {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public long bytesLeftInWriteWindow;
    public final Http2Connection connection;
    private boolean hasResponseHeaders;
    public final int id;
    private final List<Header> requestHeaders;
    private List<Header> responseHeaders;
    public final FramingSink sink;
    private final FramingSource source;
    public long unacknowledgedBytesRead = 0;
    public final StreamTimeout readTimeout = new StreamTimeout();
    public final StreamTimeout writeTimeout = new StreamTimeout();
    public ErrorCode errorCode = null;

    public final class FramingSink implements s {
        public static final /* synthetic */ boolean $assertionsDisabled = false;
        private static final long EMIT_BUFFER_SIZE = 16384;
        public boolean closed;
        public boolean finished;
        private final c sendBuffer = new c();

        public FramingSink() {
        }

        private void emitFrame(boolean z) throws IOException {
            Http2Stream http2Stream;
            long jMin;
            Http2Stream http2Stream2;
            synchronized (Http2Stream.this) {
                Http2Stream.this.writeTimeout.enter();
                while (true) {
                    try {
                        http2Stream = Http2Stream.this;
                        if (http2Stream.bytesLeftInWriteWindow > 0 || this.finished || this.closed || http2Stream.errorCode != null) {
                            break;
                        } else {
                            http2Stream.waitForIo();
                        }
                    } finally {
                    }
                }
                http2Stream.writeTimeout.exitAndThrowIfTimedOut();
                Http2Stream.this.checkOutNotClosed();
                jMin = Math.min(Http2Stream.this.bytesLeftInWriteWindow, this.sendBuffer.size());
                http2Stream2 = Http2Stream.this;
                http2Stream2.bytesLeftInWriteWindow -= jMin;
            }
            http2Stream2.writeTimeout.enter();
            try {
                Http2Stream http2Stream3 = Http2Stream.this;
                http2Stream3.connection.writeData(http2Stream3.id, z && jMin == this.sendBuffer.size(), this.sendBuffer, jMin);
            } finally {
            }
        }

        @Override // f.s, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            synchronized (Http2Stream.this) {
                if (this.closed) {
                    return;
                }
                if (!Http2Stream.this.sink.finished) {
                    if (this.sendBuffer.size() > 0) {
                        while (this.sendBuffer.size() > 0) {
                            emitFrame(true);
                        }
                    } else {
                        Http2Stream http2Stream = Http2Stream.this;
                        http2Stream.connection.writeData(http2Stream.id, true, null, 0L);
                    }
                }
                synchronized (Http2Stream.this) {
                    this.closed = true;
                }
                Http2Stream.this.connection.flush();
                Http2Stream.this.cancelStreamIfNecessary();
            }
        }

        @Override // f.s, java.io.Flushable
        public void flush() throws IOException {
            synchronized (Http2Stream.this) {
                Http2Stream.this.checkOutNotClosed();
            }
            while (this.sendBuffer.size() > 0) {
                emitFrame(false);
                Http2Stream.this.connection.flush();
            }
        }

        @Override // f.s
        public u timeout() {
            return Http2Stream.this.writeTimeout;
        }

        @Override // f.s
        public void write(c cVar, long j) throws IOException {
            this.sendBuffer.write(cVar, j);
            while (this.sendBuffer.size() >= 16384) {
                emitFrame(false);
            }
        }
    }

    public final class FramingSource implements t {
        public static final /* synthetic */ boolean $assertionsDisabled = false;
        public boolean closed;
        public boolean finished;
        private final long maxByteCount;
        private final c receiveBuffer = new c();
        private final c readBuffer = new c();

        public FramingSource(long j) {
            this.maxByteCount = j;
        }

        private void updateConnectionFlowControl(long j) {
            Http2Stream.this.connection.updateConnectionFlowControl(j);
        }

        private void waitUntilReadable() throws IOException {
            Http2Stream.this.readTimeout.enter();
            while (this.readBuffer.size() == 0 && !this.finished && !this.closed) {
                try {
                    Http2Stream http2Stream = Http2Stream.this;
                    if (http2Stream.errorCode != null) {
                        break;
                    } else {
                        http2Stream.waitForIo();
                    }
                } finally {
                    Http2Stream.this.readTimeout.exitAndThrowIfTimedOut();
                }
            }
        }

        @Override // f.t, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            long size;
            synchronized (Http2Stream.this) {
                this.closed = true;
                size = this.readBuffer.size();
                this.readBuffer.clear();
                Http2Stream.this.notifyAll();
            }
            if (size > 0) {
                updateConnectionFlowControl(size);
            }
            Http2Stream.this.cancelStreamIfNecessary();
        }

        @Override // f.t
        public long read(c cVar, long j) throws IOException {
            ErrorCode errorCode;
            long j2;
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            }
            synchronized (Http2Stream.this) {
                waitUntilReadable();
                if (this.closed) {
                    throw new IOException("stream closed");
                }
                errorCode = Http2Stream.this.errorCode;
                if (this.readBuffer.size() > 0) {
                    c cVar2 = this.readBuffer;
                    j2 = cVar2.read(cVar, Math.min(j, cVar2.size()));
                    Http2Stream.this.unacknowledgedBytesRead += j2;
                } else {
                    j2 = -1;
                }
                if (errorCode == null) {
                    if (Http2Stream.this.unacknowledgedBytesRead >= r13.connection.okHttpSettings.getInitialWindowSize() / 2) {
                        Http2Stream http2Stream = Http2Stream.this;
                        http2Stream.connection.writeWindowUpdateLater(http2Stream.id, http2Stream.unacknowledgedBytesRead);
                        Http2Stream.this.unacknowledgedBytesRead = 0L;
                    }
                }
            }
            if (j2 != -1) {
                updateConnectionFlowControl(j2);
                return j2;
            }
            if (errorCode == null) {
                return -1L;
            }
            throw new StreamResetException(errorCode);
        }

        public void receive(e eVar, long j) throws IOException {
            boolean z;
            boolean z2;
            boolean z3;
            while (j > 0) {
                synchronized (Http2Stream.this) {
                    z = this.finished;
                    z2 = true;
                    z3 = this.readBuffer.size() + j > this.maxByteCount;
                }
                if (z3) {
                    eVar.skip(j);
                    Http2Stream.this.closeLater(ErrorCode.FLOW_CONTROL_ERROR);
                    return;
                }
                if (z) {
                    eVar.skip(j);
                    return;
                }
                long j2 = eVar.read(this.receiveBuffer, j);
                if (j2 == -1) {
                    throw new EOFException();
                }
                j -= j2;
                synchronized (Http2Stream.this) {
                    if (this.readBuffer.size() != 0) {
                        z2 = false;
                    }
                    this.readBuffer.writeAll(this.receiveBuffer);
                    if (z2) {
                        Http2Stream.this.notifyAll();
                    }
                }
            }
        }

        @Override // f.t
        public u timeout() {
            return Http2Stream.this.readTimeout;
        }
    }

    public class StreamTimeout extends a {
        public StreamTimeout() {
        }

        public void exitAndThrowIfTimedOut() throws IOException {
            if (exit()) {
                throw newTimeoutException(null);
            }
        }

        @Override // f.a
        public IOException newTimeoutException(IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException(com.alipay.sdk.m.m.a.h0);
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        @Override // f.a
        public void timedOut() {
            Http2Stream.this.closeLater(ErrorCode.CANCEL);
        }
    }

    public Http2Stream(int i2, Http2Connection http2Connection, boolean z, boolean z2, List<Header> list) {
        Objects.requireNonNull(http2Connection, "connection == null");
        Objects.requireNonNull(list, "requestHeaders == null");
        this.id = i2;
        this.connection = http2Connection;
        this.bytesLeftInWriteWindow = http2Connection.peerSettings.getInitialWindowSize();
        FramingSource framingSource = new FramingSource(http2Connection.okHttpSettings.getInitialWindowSize());
        this.source = framingSource;
        FramingSink framingSink = new FramingSink();
        this.sink = framingSink;
        framingSource.finished = z2;
        framingSink.finished = z;
        this.requestHeaders = list;
    }

    private boolean closeInternal(ErrorCode errorCode) {
        synchronized (this) {
            if (this.errorCode != null) {
                return false;
            }
            if (this.source.finished && this.sink.finished) {
                return false;
            }
            this.errorCode = errorCode;
            notifyAll();
            this.connection.removeStream(this.id);
            return true;
        }
    }

    public void addBytesToWriteWindow(long j) {
        this.bytesLeftInWriteWindow += j;
        if (j > 0) {
            notifyAll();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void cancelStreamIfNecessary() throws java.io.IOException {
        /*
            r2 = this;
            monitor-enter(r2)
            okhttp3.internal.http2.Http2Stream$FramingSource r0 = r2.source     // Catch: java.lang.Throwable -> L2f
            boolean r1 = r0.finished     // Catch: java.lang.Throwable -> L2f
            if (r1 != 0) goto L17
            boolean r0 = r0.closed     // Catch: java.lang.Throwable -> L2f
            if (r0 == 0) goto L17
            okhttp3.internal.http2.Http2Stream$FramingSink r0 = r2.sink     // Catch: java.lang.Throwable -> L2f
            boolean r1 = r0.finished     // Catch: java.lang.Throwable -> L2f
            if (r1 != 0) goto L15
            boolean r0 = r0.closed     // Catch: java.lang.Throwable -> L2f
            if (r0 == 0) goto L17
        L15:
            r0 = 1
            goto L18
        L17:
            r0 = 0
        L18:
            boolean r1 = r2.isOpen()     // Catch: java.lang.Throwable -> L2f
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L2f
            if (r0 == 0) goto L25
            okhttp3.internal.http2.ErrorCode r0 = okhttp3.internal.http2.ErrorCode.CANCEL
            r2.close(r0)
            goto L2e
        L25:
            if (r1 != 0) goto L2e
            okhttp3.internal.http2.Http2Connection r0 = r2.connection
            int r1 = r2.id
            r0.removeStream(r1)
        L2e:
            return
        L2f:
            r0 = move-exception
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L2f
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Stream.cancelStreamIfNecessary():void");
    }

    public void checkOutNotClosed() throws IOException {
        FramingSink framingSink = this.sink;
        if (framingSink.closed) {
            throw new IOException("stream closed");
        }
        if (framingSink.finished) {
            throw new IOException("stream finished");
        }
        if (this.errorCode != null) {
            throw new StreamResetException(this.errorCode);
        }
    }

    public void close(ErrorCode errorCode) throws IOException {
        if (closeInternal(errorCode)) {
            this.connection.writeSynReset(this.id, errorCode);
        }
    }

    public void closeLater(ErrorCode errorCode) {
        if (closeInternal(errorCode)) {
            this.connection.writeSynResetLater(this.id, errorCode);
        }
    }

    public Http2Connection getConnection() {
        return this.connection;
    }

    public synchronized ErrorCode getErrorCode() {
        return this.errorCode;
    }

    public int getId() {
        return this.id;
    }

    public List<Header> getRequestHeaders() {
        return this.requestHeaders;
    }

    public s getSink() {
        synchronized (this) {
            if (!this.hasResponseHeaders && !isLocallyInitiated()) {
                throw new IllegalStateException("reply before requesting the sink");
            }
        }
        return this.sink;
    }

    public t getSource() {
        return this.source;
    }

    public boolean isLocallyInitiated() {
        return this.connection.client == ((this.id & 1) == 1);
    }

    public synchronized boolean isOpen() {
        if (this.errorCode != null) {
            return false;
        }
        FramingSource framingSource = this.source;
        if (framingSource.finished || framingSource.closed) {
            FramingSink framingSink = this.sink;
            if (framingSink.finished || framingSink.closed) {
                if (this.hasResponseHeaders) {
                    return false;
                }
            }
        }
        return true;
    }

    public u readTimeout() {
        return this.readTimeout;
    }

    public void receiveData(e eVar, int i2) throws IOException {
        this.source.receive(eVar, i2);
    }

    public void receiveFin() {
        boolean zIsOpen;
        synchronized (this) {
            this.source.finished = true;
            zIsOpen = isOpen();
            notifyAll();
        }
        if (zIsOpen) {
            return;
        }
        this.connection.removeStream(this.id);
    }

    public void receiveHeaders(List<Header> list) {
        boolean zIsOpen;
        synchronized (this) {
            zIsOpen = true;
            this.hasResponseHeaders = true;
            if (this.responseHeaders == null) {
                this.responseHeaders = list;
                zIsOpen = isOpen();
                notifyAll();
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(this.responseHeaders);
                arrayList.add(null);
                arrayList.addAll(list);
                this.responseHeaders = arrayList;
            }
        }
        if (zIsOpen) {
            return;
        }
        this.connection.removeStream(this.id);
    }

    public synchronized void receiveRstStream(ErrorCode errorCode) {
        if (this.errorCode == null) {
            this.errorCode = errorCode;
            notifyAll();
        }
    }

    public void sendResponseHeaders(List<Header> list, boolean z) throws IOException {
        boolean z2;
        boolean z3;
        boolean z4;
        Objects.requireNonNull(list, "responseHeaders == null");
        synchronized (this) {
            z2 = true;
            this.hasResponseHeaders = true;
            if (z) {
                z3 = false;
                z4 = false;
            } else {
                this.sink.finished = true;
                z3 = true;
                z4 = true;
            }
        }
        if (!z3) {
            synchronized (this.connection) {
                if (this.connection.bytesLeftInWriteWindow != 0) {
                    z2 = false;
                }
            }
            z3 = z2;
        }
        this.connection.writeSynReply(this.id, z4, list);
        if (z3) {
            this.connection.flush();
        }
    }

    public synchronized List<Header> takeResponseHeaders() throws IOException {
        List<Header> list;
        if (!isLocallyInitiated()) {
            throw new IllegalStateException("servers cannot read response headers");
        }
        this.readTimeout.enter();
        while (this.responseHeaders == null && this.errorCode == null) {
            try {
                waitForIo();
            } catch (Throwable th) {
                this.readTimeout.exitAndThrowIfTimedOut();
                throw th;
            }
        }
        this.readTimeout.exitAndThrowIfTimedOut();
        list = this.responseHeaders;
        if (list == null) {
            throw new StreamResetException(this.errorCode);
        }
        this.responseHeaders = null;
        return list;
    }

    public void waitForIo() throws InterruptedIOException {
        try {
            wait();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException();
        }
    }

    public u writeTimeout() {
        return this.writeTimeout;
    }
}
