package okhttp3.internal.cache2;

import f.c;
import f.f;
import f.t;
import f.u;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import okhttp3.internal.Util;

/* JADX INFO: loaded from: classes2.dex */
public final class Relay {
    private static final long FILE_HEADER_SIZE = 32;
    public static final f PREFIX_CLEAN = f.encodeUtf8("OkHttp cache v1\n");
    public static final f PREFIX_DIRTY = f.encodeUtf8("OkHttp DIRTY :(\n");
    private static final int SOURCE_FILE = 2;
    private static final int SOURCE_UPSTREAM = 1;
    public final long bufferMaxSize;
    public boolean complete;
    public RandomAccessFile file;
    private final f metadata;
    public int sourceCount;
    public t upstream;
    public long upstreamPos;
    public Thread upstreamReader;
    public final c upstreamBuffer = new c();
    public final c buffer = new c();

    public class RelaySource implements t {
        private FileOperator fileOperator;
        private long sourcePos;
        private final u timeout = new u();

        public RelaySource() {
            this.fileOperator = new FileOperator(Relay.this.file.getChannel());
        }

        @Override // f.t, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.fileOperator == null) {
                return;
            }
            RandomAccessFile randomAccessFile = null;
            this.fileOperator = null;
            synchronized (Relay.this) {
                Relay relay = Relay.this;
                int i2 = relay.sourceCount - 1;
                relay.sourceCount = i2;
                if (i2 == 0) {
                    RandomAccessFile randomAccessFile2 = relay.file;
                    relay.file = null;
                    randomAccessFile = randomAccessFile2;
                }
            }
            if (randomAccessFile != null) {
                Util.closeQuietly(randomAccessFile);
            }
        }

        @Override // f.t
        public long read(c cVar, long j) throws IOException {
            long j2;
            char c2;
            Relay relay;
            if (this.fileOperator == null) {
                throw new IllegalStateException("closed");
            }
            synchronized (Relay.this) {
                while (true) {
                    long j3 = this.sourcePos;
                    Relay relay2 = Relay.this;
                    j2 = relay2.upstreamPos;
                    if (j3 != j2) {
                        long size = j2 - relay2.buffer.size();
                        long j4 = this.sourcePos;
                        if (j4 >= size) {
                            long jMin = Math.min(j, j2 - j4);
                            Relay.this.buffer.copyTo(cVar, this.sourcePos - size, jMin);
                            this.sourcePos += jMin;
                            return jMin;
                        }
                        c2 = 2;
                    } else if (!relay2.complete) {
                        if (relay2.upstreamReader == null) {
                            relay2.upstreamReader = Thread.currentThread();
                            c2 = 1;
                            break;
                        }
                        this.timeout.waitUntilNotified(relay2);
                    } else {
                        return -1L;
                    }
                }
                if (c2 == 2) {
                    long jMin2 = Math.min(j, j2 - this.sourcePos);
                    this.fileOperator.read(this.sourcePos + 32, cVar, jMin2);
                    this.sourcePos += jMin2;
                    return jMin2;
                }
                try {
                    Relay relay3 = Relay.this;
                    long j5 = relay3.upstream.read(relay3.upstreamBuffer, relay3.bufferMaxSize);
                    if (j5 == -1) {
                        Relay.this.commit(j2);
                        synchronized (Relay.this) {
                            Relay relay4 = Relay.this;
                            relay4.upstreamReader = null;
                            relay4.notifyAll();
                        }
                        return -1L;
                    }
                    long jMin3 = Math.min(j5, j);
                    Relay.this.upstreamBuffer.copyTo(cVar, 0L, jMin3);
                    this.sourcePos += jMin3;
                    this.fileOperator.write(j2 + 32, Relay.this.upstreamBuffer.m471clone(), j5);
                    synchronized (Relay.this) {
                        Relay relay5 = Relay.this;
                        relay5.buffer.write(relay5.upstreamBuffer, j5);
                        long size2 = Relay.this.buffer.size();
                        Relay relay6 = Relay.this;
                        if (size2 > relay6.bufferMaxSize) {
                            c cVar2 = relay6.buffer;
                            cVar2.skip(cVar2.size() - Relay.this.bufferMaxSize);
                        }
                        relay = Relay.this;
                        relay.upstreamPos += j5;
                    }
                    synchronized (relay) {
                        Relay relay7 = Relay.this;
                        relay7.upstreamReader = null;
                        relay7.notifyAll();
                    }
                    return jMin3;
                } catch (Throwable th) {
                    synchronized (Relay.this) {
                        Relay relay8 = Relay.this;
                        relay8.upstreamReader = null;
                        relay8.notifyAll();
                        throw th;
                    }
                }
            }
        }

        @Override // f.t
        public u timeout() {
            return this.timeout;
        }
    }

    private Relay(RandomAccessFile randomAccessFile, t tVar, long j, f fVar, long j2) {
        this.file = randomAccessFile;
        this.upstream = tVar;
        this.complete = tVar == null;
        this.upstreamPos = j;
        this.metadata = fVar;
        this.bufferMaxSize = j2;
    }

    public static Relay edit(File file, t tVar, f fVar, long j) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        Relay relay = new Relay(randomAccessFile, tVar, 0L, fVar, j);
        randomAccessFile.setLength(0L);
        relay.writeHeader(PREFIX_DIRTY, -1L, -1L);
        return relay;
    }

    public static Relay read(File file) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        FileOperator fileOperator = new FileOperator(randomAccessFile.getChannel());
        c cVar = new c();
        fileOperator.read(0L, cVar, 32L);
        if (!cVar.readByteString(r2.size()).equals(PREFIX_CLEAN)) {
            throw new IOException("unreadable cache file");
        }
        long j = cVar.readLong();
        long j2 = cVar.readLong();
        c cVar2 = new c();
        fileOperator.read(j + 32, cVar2, j2);
        return new Relay(randomAccessFile, null, j, cVar2.readByteString(), 0L);
    }

    private void writeHeader(f fVar, long j, long j2) throws IOException {
        c cVar = new c();
        cVar.write(fVar);
        cVar.writeLong(j);
        cVar.writeLong(j2);
        if (cVar.size() != 32) {
            throw new IllegalArgumentException();
        }
        new FileOperator(this.file.getChannel()).write(0L, cVar, 32L);
    }

    private void writeMetadata(long j) throws IOException {
        c cVar = new c();
        cVar.write(this.metadata);
        new FileOperator(this.file.getChannel()).write(32 + j, cVar, this.metadata.size());
    }

    public void commit(long j) throws IOException {
        writeMetadata(j);
        this.file.getChannel().force(false);
        writeHeader(PREFIX_CLEAN, j, this.metadata.size());
        this.file.getChannel().force(false);
        synchronized (this) {
            this.complete = true;
        }
        Util.closeQuietly(this.upstream);
        this.upstream = null;
    }

    public boolean isClosed() {
        return this.file == null;
    }

    public f metadata() {
        return this.metadata;
    }

    public t newSource() {
        synchronized (this) {
            if (this.file == null) {
                return null;
            }
            this.sourceCount++;
            return new RelaySource();
        }
    }
}
