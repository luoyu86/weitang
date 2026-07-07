package okhttp3.internal.ws;

import android.support.v4.media.session.PlaybackStateCompat;
import f.c;
import f.d;
import f.f;
import f.s;
import f.u;
import java.io.IOException;
import java.util.Objects;
import java.util.Random;

/* JADX INFO: loaded from: classes2.dex */
public final class WebSocketWriter {
    public boolean activeWriter;
    public final c buffer = new c();
    public final FrameSink frameSink = new FrameSink();
    public final boolean isClient;
    private final c.C0245c maskCursor;
    private final byte[] maskKey;
    public final Random random;
    public final d sink;
    public final c sinkBuffer;
    public boolean writerClosed;

    public final class FrameSink implements s {
        public boolean closed;
        public long contentLength;
        public int formatOpcode;
        public boolean isFirstFrame;

        public FrameSink() {
        }

        @Override // f.s, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.closed) {
                throw new IOException("closed");
            }
            WebSocketWriter webSocketWriter = WebSocketWriter.this;
            webSocketWriter.writeMessageFrame(this.formatOpcode, webSocketWriter.buffer.size(), this.isFirstFrame, true);
            this.closed = true;
            WebSocketWriter.this.activeWriter = false;
        }

        @Override // f.s, java.io.Flushable
        public void flush() throws IOException {
            if (this.closed) {
                throw new IOException("closed");
            }
            WebSocketWriter webSocketWriter = WebSocketWriter.this;
            webSocketWriter.writeMessageFrame(this.formatOpcode, webSocketWriter.buffer.size(), this.isFirstFrame, false);
            this.isFirstFrame = false;
        }

        @Override // f.s
        public u timeout() {
            return WebSocketWriter.this.sink.timeout();
        }

        @Override // f.s
        public void write(c cVar, long j) throws IOException {
            if (this.closed) {
                throw new IOException("closed");
            }
            WebSocketWriter.this.buffer.write(cVar, j);
            boolean z = this.isFirstFrame && this.contentLength != -1 && WebSocketWriter.this.buffer.size() > this.contentLength - PlaybackStateCompat.ACTION_PLAY_FROM_URI;
            long jCompleteSegmentByteCount = WebSocketWriter.this.buffer.completeSegmentByteCount();
            if (jCompleteSegmentByteCount <= 0 || z) {
                return;
            }
            WebSocketWriter.this.writeMessageFrame(this.formatOpcode, jCompleteSegmentByteCount, this.isFirstFrame, false);
            this.isFirstFrame = false;
        }
    }

    public WebSocketWriter(boolean z, d dVar, Random random) {
        Objects.requireNonNull(dVar, "sink == null");
        Objects.requireNonNull(random, "random == null");
        this.isClient = z;
        this.sink = dVar;
        this.sinkBuffer = dVar.buffer();
        this.random = random;
        this.maskKey = z ? new byte[4] : null;
        this.maskCursor = z ? new c.C0245c() : null;
    }

    private void writeControlFrame(int i2, f fVar) throws IOException {
        if (this.writerClosed) {
            throw new IOException("closed");
        }
        int size = fVar.size();
        if (size > 125) {
            throw new IllegalArgumentException("Payload size must be less than or equal to 125");
        }
        this.sinkBuffer.writeByte(i2 | 128);
        if (this.isClient) {
            this.sinkBuffer.writeByte(size | 128);
            this.random.nextBytes(this.maskKey);
            this.sinkBuffer.write(this.maskKey);
            if (size > 0) {
                long size2 = this.sinkBuffer.size();
                this.sinkBuffer.write(fVar);
                this.sinkBuffer.readAndWriteUnsafe(this.maskCursor);
                this.maskCursor.seek(size2);
                WebSocketProtocol.toggleMask(this.maskCursor, this.maskKey);
                this.maskCursor.close();
            }
        } else {
            this.sinkBuffer.writeByte(size);
            this.sinkBuffer.write(fVar);
        }
        this.sink.flush();
    }

    public s newMessageSink(int i2, long j) {
        if (this.activeWriter) {
            throw new IllegalStateException("Another message writer is active. Did you call close()?");
        }
        this.activeWriter = true;
        FrameSink frameSink = this.frameSink;
        frameSink.formatOpcode = i2;
        frameSink.contentLength = j;
        frameSink.isFirstFrame = true;
        frameSink.closed = false;
        return frameSink;
    }

    public void writeClose(int i2, f fVar) throws IOException {
        f byteString = f.EMPTY;
        if (i2 != 0 || fVar != null) {
            if (i2 != 0) {
                WebSocketProtocol.validateCloseCode(i2);
            }
            c cVar = new c();
            cVar.writeShort(i2);
            if (fVar != null) {
                cVar.write(fVar);
            }
            byteString = cVar.readByteString();
        }
        try {
            writeControlFrame(8, byteString);
        } finally {
            this.writerClosed = true;
        }
    }

    public void writeMessageFrame(int i2, long j, boolean z, boolean z2) throws IOException {
        if (this.writerClosed) {
            throw new IOException("closed");
        }
        if (!z) {
            i2 = 0;
        }
        if (z2) {
            i2 |= 128;
        }
        this.sinkBuffer.writeByte(i2);
        int i3 = this.isClient ? 128 : 0;
        if (j <= 125) {
            this.sinkBuffer.writeByte(((int) j) | i3);
        } else if (j <= WebSocketProtocol.PAYLOAD_SHORT_MAX) {
            this.sinkBuffer.writeByte(i3 | 126);
            this.sinkBuffer.writeShort((int) j);
        } else {
            this.sinkBuffer.writeByte(i3 | 127);
            this.sinkBuffer.writeLong(j);
        }
        if (this.isClient) {
            this.random.nextBytes(this.maskKey);
            this.sinkBuffer.write(this.maskKey);
            if (j > 0) {
                long size = this.sinkBuffer.size();
                this.sinkBuffer.write(this.buffer, j);
                this.sinkBuffer.readAndWriteUnsafe(this.maskCursor);
                this.maskCursor.seek(size);
                WebSocketProtocol.toggleMask(this.maskCursor, this.maskKey);
                this.maskCursor.close();
            }
        } else {
            this.sinkBuffer.write(this.buffer, j);
        }
        this.sink.emit();
    }

    public void writePing(f fVar) throws IOException {
        writeControlFrame(9, fVar);
    }

    public void writePong(f fVar) throws IOException {
        writeControlFrame(10, fVar);
    }
}
