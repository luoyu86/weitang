package com.bytedance.pangle.e;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class h implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final FileInputStream f6014a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private a f6015b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private b[] f6016c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private c[] f6017d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Map<String, c> f6018e = new HashMap();

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final byte[] f6019a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final short f6020b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final short f6021c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f6022d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final long f6023e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final long f6024f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final long f6025g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final int f6026h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final short f6027i;
        public final short j;
        public final short k;
        public final short l;
        public final short m;
        public final short n;

        public /* synthetic */ a(FileChannel fileChannel, byte b2) {
            this(fileChannel);
        }

        private a(FileChannel fileChannel) throws IOException {
            byte[] bArr = new byte[16];
            this.f6019a = bArr;
            fileChannel.position(0L);
            fileChannel.read(ByteBuffer.wrap(bArr));
            if (bArr[0] != 127 || bArr[1] != 69 || bArr[2] != 76 || bArr[3] != 70) {
                throw new IOException(String.format("bad elf magic: %x %x %x %x.", Byte.valueOf(bArr[0]), Byte.valueOf(bArr[1]), Byte.valueOf(bArr[2]), Byte.valueOf(bArr[3])));
            }
            h.a(bArr[4], 2, "bad elf class: " + ((int) bArr[4]));
            h.a(bArr[5], 2, "bad elf data encoding: " + ((int) bArr[5]));
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(bArr[4] == 1 ? 36 : 48);
            byteBufferAllocate.order(bArr[5] == 1 ? ByteOrder.LITTLE_ENDIAN : ByteOrder.BIG_ENDIAN);
            h.b(fileChannel, byteBufferAllocate, "failed to read rest part of ehdr.");
            this.f6020b = byteBufferAllocate.getShort();
            this.f6021c = byteBufferAllocate.getShort();
            int i2 = byteBufferAllocate.getInt();
            this.f6022d = i2;
            h.a(i2, 1, "bad elf version: " + i2);
            byte b2 = bArr[4];
            if (b2 == 1) {
                this.f6023e = byteBufferAllocate.getInt();
                this.f6024f = byteBufferAllocate.getInt();
                this.f6025g = byteBufferAllocate.getInt();
            } else {
                if (b2 != 2) {
                    throw new IOException("Unexpected elf class: " + ((int) bArr[4]));
                }
                this.f6023e = byteBufferAllocate.getLong();
                this.f6024f = byteBufferAllocate.getLong();
                this.f6025g = byteBufferAllocate.getLong();
            }
            this.f6026h = byteBufferAllocate.getInt();
            this.f6027i = byteBufferAllocate.getShort();
            this.j = byteBufferAllocate.getShort();
            this.k = byteBufferAllocate.getShort();
            this.l = byteBufferAllocate.getShort();
            this.m = byteBufferAllocate.getShort();
            this.n = byteBufferAllocate.getShort();
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f6028a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f6029b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f6030c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long f6031d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final long f6032e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final long f6033f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final long f6034g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final long f6035h;

        public /* synthetic */ b(ByteBuffer byteBuffer, int i2, byte b2) {
            this(byteBuffer, i2);
        }

        private b(ByteBuffer byteBuffer, int i2) throws IOException {
            if (i2 == 1) {
                this.f6028a = byteBuffer.getInt();
                this.f6030c = byteBuffer.getInt();
                this.f6031d = byteBuffer.getInt();
                this.f6032e = byteBuffer.getInt();
                this.f6033f = byteBuffer.getInt();
                this.f6034g = byteBuffer.getInt();
                this.f6029b = byteBuffer.getInt();
                this.f6035h = byteBuffer.getInt();
                return;
            }
            if (i2 != 2) {
                throw new IOException("Unexpected elf class: ".concat(String.valueOf(i2)));
            }
            this.f6028a = byteBuffer.getInt();
            this.f6029b = byteBuffer.getInt();
            this.f6030c = byteBuffer.getLong();
            this.f6031d = byteBuffer.getLong();
            this.f6032e = byteBuffer.getLong();
            this.f6033f = byteBuffer.getLong();
            this.f6034g = byteBuffer.getLong();
            this.f6035h = byteBuffer.getLong();
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f6036a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f6037b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f6038c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long f6039d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final long f6040e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final long f6041f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f6042g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final int f6043h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final long f6044i;
        public final long j;
        public String k;

        public /* synthetic */ c(ByteBuffer byteBuffer, int i2, byte b2) {
            this(byteBuffer, i2);
        }

        private c(ByteBuffer byteBuffer, int i2) throws IOException {
            if (i2 == 1) {
                this.f6036a = byteBuffer.getInt();
                this.f6037b = byteBuffer.getInt();
                this.f6038c = byteBuffer.getInt();
                this.f6039d = byteBuffer.getInt();
                this.f6040e = byteBuffer.getInt();
                this.f6041f = byteBuffer.getInt();
                this.f6042g = byteBuffer.getInt();
                this.f6043h = byteBuffer.getInt();
                this.f6044i = byteBuffer.getInt();
                this.j = byteBuffer.getInt();
            } else {
                if (i2 != 2) {
                    throw new IOException("Unexpected elf class: ".concat(String.valueOf(i2)));
                }
                this.f6036a = byteBuffer.getInt();
                this.f6037b = byteBuffer.getInt();
                this.f6038c = byteBuffer.getLong();
                this.f6039d = byteBuffer.getLong();
                this.f6040e = byteBuffer.getLong();
                this.f6041f = byteBuffer.getLong();
                this.f6042g = byteBuffer.getInt();
                this.f6043h = byteBuffer.getInt();
                this.f6044i = byteBuffer.getLong();
                this.j = byteBuffer.getLong();
            }
            this.k = null;
        }
    }

    private h(File file) throws IOException {
        c[] cVarArr;
        this.f6015b = null;
        this.f6016c = null;
        this.f6017d = null;
        FileInputStream fileInputStream = new FileInputStream(file);
        this.f6014a = fileInputStream;
        FileChannel channel = fileInputStream.getChannel();
        byte b2 = 0;
        byte b3 = 0;
        this.f6015b = new a(channel, 0 == true ? 1 : 0);
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(128);
        byteBufferAllocate.limit(this.f6015b.j);
        byteBufferAllocate.order(this.f6015b.f6019a[5] == 1 ? ByteOrder.LITTLE_ENDIAN : ByteOrder.BIG_ENDIAN);
        channel.position(this.f6015b.f6024f);
        this.f6016c = new b[this.f6015b.k];
        for (int i2 = 0; i2 < this.f6016c.length; i2++) {
            b(channel, byteBufferAllocate, "failed to read phdr.");
            this.f6016c[i2] = new b(byteBufferAllocate, this.f6015b.f6019a[4], b3 == true ? 1 : 0);
        }
        channel.position(this.f6015b.f6025g);
        byteBufferAllocate.limit(this.f6015b.l);
        this.f6017d = new c[this.f6015b.m];
        int i3 = 0;
        while (true) {
            cVarArr = this.f6017d;
            if (i3 >= cVarArr.length) {
                break;
            }
            b(channel, byteBufferAllocate, "failed to read shdr.");
            this.f6017d[i3] = new c(byteBufferAllocate, this.f6015b.f6019a[4], b2 == true ? 1 : 0);
            i3++;
        }
        short s = this.f6015b.n;
        if (s > 0) {
            c cVar = cVarArr[s];
            ByteBuffer byteBufferAllocate2 = ByteBuffer.allocate((int) cVar.f6041f);
            this.f6014a.getChannel().position(cVar.f6040e);
            b(this.f6014a.getChannel(), byteBufferAllocate2, "failed to read section: " + cVar.k);
            for (c cVar2 : this.f6017d) {
                byteBufferAllocate2.position(cVar2.f6036a);
                String strA = a(byteBufferAllocate2);
                cVar2.k = strA;
                this.f6018e.put(strA, cVar2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(FileChannel fileChannel, ByteBuffer byteBuffer, String str) throws IOException {
        byteBuffer.rewind();
        int i2 = fileChannel.read(byteBuffer);
        if (i2 == byteBuffer.limit()) {
            byteBuffer.flip();
            return;
        }
        throw new IOException(str + " Rest bytes insufficient, expect to read " + byteBuffer.limit() + " bytes but only " + i2 + " bytes were read.");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.f6014a.close();
        this.f6018e.clear();
        this.f6016c = null;
        this.f6017d = null;
    }

    public static boolean a(File file) {
        try {
            com.bytedance.pangle.util.g.a(new h(file));
            return true;
        } catch (IOException unused) {
            com.bytedance.pangle.util.g.a((Closeable) null);
            return false;
        } catch (Throwable th) {
            com.bytedance.pangle.util.g.a((Closeable) null);
            throw th;
        }
    }

    private static String a(ByteBuffer byteBuffer) {
        byte[] bArrArray = byteBuffer.array();
        int iPosition = byteBuffer.position();
        while (byteBuffer.hasRemaining() && bArrArray[byteBuffer.position()] != 0) {
            byteBuffer.position(byteBuffer.position() + 1);
        }
        byteBuffer.position(byteBuffer.position() + 1);
        return new String(bArrArray, iPosition, (byteBuffer.position() - iPosition) - 1, Charset.forName("ASCII"));
    }

    public static /* synthetic */ void a(int i2, int i3, String str) throws IOException {
        if (i2 <= 0 || i2 > i3) {
            throw new IOException(str);
        }
    }
}
