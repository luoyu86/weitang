package com.tom_roush.harmony.javax.imageio.stream;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteOrder;
import java.util.Objects;
import javax.mail.UIDFolder;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ImageInputStreamImpl implements ImageInputStream {
    public int currentByte;
    private final PositionStack offsetStack;
    private final PositionStack posStack;
    public ByteOrder byteOrder = ByteOrder.BIG_ENDIAN;
    public long streamPos = 0;
    public long flushedPos = 0;
    public int bitOffset = 0;
    private boolean closed = false;
    private final byte[] buff = new byte[8];

    public static class PositionStack {
        private static final int SIZE = 10;
        private int pos;
        private long[] values;

        private PositionStack() {
            this.values = new long[10];
            this.pos = 0;
        }

        private void ensure(int i2) {
            long[] jArr = new long[Math.max(this.values.length * 2, i2)];
            long[] jArr2 = this.values;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            this.values = jArr;
        }

        public boolean isEmpty() {
            return this.pos == 0;
        }

        public long pop() {
            long[] jArr = this.values;
            int i2 = this.pos - 1;
            this.pos = i2;
            return jArr[i2];
        }

        public void push(long j) {
            int i2 = this.pos;
            if (i2 >= this.values.length) {
                ensure(i2 + 1);
            }
            long[] jArr = this.values;
            int i3 = this.pos;
            this.pos = i3 + 1;
            jArr[i3] = j;
        }
    }

    public ImageInputStreamImpl() {
        this.posStack = new PositionStack();
        this.offsetStack = new PositionStack();
    }

    public final void checkClosed() throws IOException {
        if (this.closed) {
            throw new IOException("stream is closed");
        }
    }

    @Override // com.tom_roush.harmony.javax.imageio.stream.ImageInputStream
    public void close() throws IOException {
        checkClosed();
        this.closed = true;
    }

    public void finalize() throws Throwable {
        if (this.closed) {
            return;
        }
        try {
            close();
        } finally {
            super.finalize();
        }
    }

    @Override // com.tom_roush.harmony.javax.imageio.stream.ImageInputStream
    public void flush() throws IOException {
        flushBefore(getStreamPosition());
    }

    @Override // com.tom_roush.harmony.javax.imageio.stream.ImageInputStream
    public void flushBefore(long j) throws IOException {
        if (j > getStreamPosition()) {
            throw new IndexOutOfBoundsException("Trying to flush outside of current position");
        }
        if (j < this.flushedPos) {
            throw new IndexOutOfBoundsException("Trying to flush within already flushed portion");
        }
        this.flushedPos = j;
    }

    @Override // com.tom_roush.harmony.javax.imageio.stream.ImageInputStream
    public int getBitOffset() throws IOException {
        checkClosed();
        return this.bitOffset;
    }

    @Override // com.tom_roush.harmony.javax.imageio.stream.ImageInputStream
    public ByteOrder getByteOrder() {
        return this.byteOrder;
    }

    @Override // com.tom_roush.harmony.javax.imageio.stream.ImageInputStream
    public long getFlushedPosition() {
        return this.flushedPos;
    }

    @Override // com.tom_roush.harmony.javax.imageio.stream.ImageInputStream
    public long getStreamPosition() throws IOException {
        checkClosed();
        return this.streamPos;
    }

    @Override // com.tom_roush.harmony.javax.imageio.stream.ImageInputStream
    public boolean isCached() {
        return false;
    }

    @Override // com.tom_roush.harmony.javax.imageio.stream.ImageInputStream
    public boolean isCachedFile() {
        return false;
    }

    @Override // com.tom_roush.harmony.javax.imageio.stream.ImageInputStream
    public boolean isCachedMemory() {
        return false;
    }

    @Override // com.tom_roush.harmony.javax.imageio.stream.ImageInputStream
    public long length() {
        return -1L;
    }

    @Override // com.tom_roush.harmony.javax.imageio.stream.ImageInputStream
    public void mark() {
        try {
            this.posStack.push(getStreamPosition());
            this.offsetStack.push(getBitOffset());
        } catch (IOException e2) {
            e2.printStackTrace();
            throw new RuntimeException("Stream marking error");
        }
    }

    @Override // com.tom_roush.harmony.javax.imageio.stream.ImageInputStream
    public abstract int read() throws IOException;

    @Override // com.tom_roush.harmony.javax.imageio.stream.ImageInputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // com.tom_roush.harmony.javax.imageio.stream.ImageInputStream
    public abstract int read(byte[] bArr, int i2, int i3) throws IOException;

    @Override // com.tom_roush.harmony.javax.imageio.stream.ImageInputStream
    public int readBit() throws IOException {
        checkClosed();
        int i2 = this.bitOffset;
        int i3 = read();
        if (i3 == -1) {
            throw new EOFException();
        }
        int i4 = (i2 + 1) & 7;
        if (i4 != 0) {
            i3 >>= 8 - i4;
            seek(getStreamPosition() - 1);
        }
        this.bitOffset = i4;
        return i3 & 1;
    }

    @Override // com.tom_roush.harmony.javax.imageio.stream.ImageInputStream
    public long readBits(int i2) throws IOException {
        checkClosed();
        if (i2 < 0 || i2 > 64) {
            throw new IllegalArgumentException();
        }
        long bit = 0;
        for (int i3 = 0; i3 < i2; i3++) {
            bit = (bit << 1) | ((long) readBit());
        }
        return bit;
    }

    @Override // com.tom_roush.harmony.javax.imageio.stream.ImageInputStream, java.io.DataInput
    public boolean readBoolean() throws IOException {
        int i2 = read();
        if (i2 >= 0) {
            return i2 != 0;
        }
        throw new EOFException("EOF reached");
    }

    @Override // com.tom_roush.harmony.javax.imageio.stream.ImageInputStream, java.io.DataInput
    public byte readByte() throws IOException {
        int i2 = read();
        if (i2 >= 0) {
            return (byte) i2;
        }
        throw new EOFException("EOF reached");
    }

    @Override // com.tom_roush.harmony.javax.imageio.stream.ImageInputStream
    public void readBytes(IIOByteBuffer iIOByteBuffer, int i2) throws IOException {
        Objects.requireNonNull(iIOByteBuffer, "buffer is NULL");
        byte[] bArr = new byte[i2];
        int i3 = read(bArr, 0, i2);
        iIOByteBuffer.setData(bArr);
        iIOByteBuffer.setOffset(0);
        iIOByteBuffer.setLength(i3);
    }

    @Override // com.tom_roush.harmony.javax.imageio.stream.ImageInputStream, java.io.DataInput
    public char readChar() throws IOException {
        return (char) readShort();
    }

    @Override // com.tom_roush.harmony.javax.imageio.stream.ImageInputStream, java.io.DataInput
    public double readDouble() throws IOException {
        return Double.longBitsToDouble(readLong());
    }

    @Override // com.tom_roush.harmony.javax.imageio.stream.ImageInputStream, java.io.DataInput
    public float readFloat() throws IOException {
        return Float.intBitsToFloat(readInt());
    }

    @Override // com.tom_roush.harmony.javax.imageio.stream.ImageInputStream, java.io.DataInput
    public void readFully(byte[] bArr, int i2, int i3) throws IOException {
        if (i2 < 0 || i3 < 0 || i2 + i3 > bArr.length) {
            throw new IndexOutOfBoundsException();
        }
        while (i3 > 0) {
            int i4 = read(bArr, i2, i3);
            if (i4 == -1) {
                throw new EOFException();
            }
            i2 += i4;
            i3 -= i4;
        }
    }

    @Override // com.tom_roush.harmony.javax.imageio.stream.ImageInputStream, java.io.DataInput
    public int readInt() throws IOException {
        if (read(this.buff, 0, 4) < 0) {
            throw new EOFException();
        }
        if (this.byteOrder == ByteOrder.BIG_ENDIAN) {
            byte[] bArr = this.buff;
            return (bArr[3] & 255) | ((bArr[0] & 255) << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8);
        }
        byte[] bArr2 = this.buff;
        return (bArr2[0] & 255) | ((bArr2[3] & 255) << 24) | ((bArr2[2] & 255) << 16) | ((bArr2[1] & 255) << 8);
    }

    @Override // com.tom_roush.harmony.javax.imageio.stream.ImageInputStream, java.io.DataInput
    public String readLine() throws IOException {
        StringBuilder sb = new StringBuilder(80);
        boolean z = true;
        while (true) {
            int i2 = read();
            if (i2 == -1) {
                break;
            }
            z = false;
            if (i2 == 10) {
                break;
            }
            if (i2 == 13) {
                int i3 = read();
                if (i3 != 10 && i3 != -1) {
                    seek(getStreamPosition() - 1);
                }
            } else {
                sb.append((char) i2);
            }
        }
        if (z) {
            return null;
        }
        return sb.toString();
    }

    @Override // com.tom_roush.harmony.javax.imageio.stream.ImageInputStream, java.io.DataInput
    public long readLong() throws IOException {
        if (read(this.buff, 0, 8) < 0) {
            throw new EOFException();
        }
        if (this.byteOrder == ByteOrder.BIG_ENDIAN) {
            byte[] bArr = this.buff;
            return ((((long) (((((bArr[0] & 255) << 24) | ((bArr[1] & 255) << 16)) | ((bArr[2] & 255) << 8)) | (bArr[3] & 255))) & UIDFolder.MAXUID) << 32) | (((long) ((bArr[7] & 255) | ((bArr[6] & 255) << 8) | ((bArr[4] & 255) << 24) | ((bArr[5] & 255) << 16))) & UIDFolder.MAXUID);
        }
        byte[] bArr2 = this.buff;
        int i2 = (bArr2[0] & 255) | ((bArr2[3] & 255) << 24) | ((bArr2[2] & 255) << 16) | ((bArr2[1] & 255) << 8);
        return (((long) i2) & UIDFolder.MAXUID) | ((((long) ((bArr2[4] & 255) | (((bArr2[5] & 255) << 8) | (((bArr2[7] & 255) << 24) | ((bArr2[6] & 255) << 16))))) & UIDFolder.MAXUID) << 32);
    }

    @Override // com.tom_roush.harmony.javax.imageio.stream.ImageInputStream, java.io.DataInput
    public short readShort() throws IOException {
        int i2;
        if (read(this.buff, 0, 2) < 0) {
            throw new EOFException();
        }
        if (this.byteOrder == ByteOrder.BIG_ENDIAN) {
            byte[] bArr = this.buff;
            i2 = (bArr[1] & 255) | (bArr[0] << 8);
        } else {
            byte[] bArr2 = this.buff;
            i2 = (bArr2[0] & 255) | (bArr2[1] << 8);
        }
        return (short) i2;
    }

    @Override // com.tom_roush.harmony.javax.imageio.stream.ImageInputStream, java.io.DataInput
    public String readUTF() throws IOException {
        ByteOrder byteOrder = getByteOrder();
        setByteOrder(ByteOrder.BIG_ENDIAN);
        int unsignedShort = readUnsignedShort();
        char[] cArr = new char[unsignedShort];
        readFully(new byte[unsignedShort], 0, unsignedShort);
        setByteOrder(byteOrder);
        return new DataInputStream(new ByteArrayInputStream(this.buff)).readUTF();
    }

    @Override // com.tom_roush.harmony.javax.imageio.stream.ImageInputStream, java.io.DataInput
    public int readUnsignedByte() throws IOException {
        int i2 = read();
        if (i2 >= 0) {
            return i2;
        }
        throw new EOFException("EOF reached");
    }

    @Override // com.tom_roush.harmony.javax.imageio.stream.ImageInputStream
    public long readUnsignedInt() throws IOException {
        return ((long) readInt()) & UIDFolder.MAXUID;
    }

    @Override // com.tom_roush.harmony.javax.imageio.stream.ImageInputStream, java.io.DataInput
    public int readUnsignedShort() throws IOException {
        return readShort() & 65535;
    }

    @Override // com.tom_roush.harmony.javax.imageio.stream.ImageInputStream
    public void reset() throws IOException {
        if (this.posStack.isEmpty() || this.offsetStack.isEmpty()) {
            return;
        }
        long jPop = this.posStack.pop();
        if (jPop < this.flushedPos) {
            throw new IOException("marked position lies in the flushed portion of the stream");
        }
        seek(jPop);
        setBitOffset((int) this.offsetStack.pop());
    }

    @Override // com.tom_roush.harmony.javax.imageio.stream.ImageInputStream
    public void seek(long j) throws IOException {
        checkClosed();
        if (j < getFlushedPosition()) {
            throw new IllegalArgumentException("trying to seek before flushed pos");
        }
        this.bitOffset = 0;
        this.streamPos = j;
    }

    @Override // com.tom_roush.harmony.javax.imageio.stream.ImageInputStream
    public void setBitOffset(int i2) throws IOException {
        checkClosed();
        if (i2 < 0 || i2 > 7) {
            throw new IllegalArgumentException();
        }
        this.bitOffset = i2;
    }

    @Override // com.tom_roush.harmony.javax.imageio.stream.ImageInputStream
    public void setByteOrder(ByteOrder byteOrder) {
        this.byteOrder = byteOrder;
    }

    @Override // com.tom_roush.harmony.javax.imageio.stream.ImageInputStream, java.io.DataInput
    public int skipBytes(int i2) throws IOException {
        return (int) skipBytes(i2);
    }

    @Override // com.tom_roush.harmony.javax.imageio.stream.ImageInputStream
    public long skipBytes(long j) throws IOException {
        seek(getStreamPosition() + j);
        return j;
    }

    @Override // com.tom_roush.harmony.javax.imageio.stream.ImageInputStream, java.io.DataInput
    public void readFully(byte[] bArr) throws IOException {
        readFully(bArr, 0, bArr.length);
    }

    @Override // com.tom_roush.harmony.javax.imageio.stream.ImageInputStream
    public void readFully(short[] sArr, int i2, int i3) throws IOException {
        if (i2 < 0 || i3 < 0 || i2 + i3 > sArr.length) {
            throw new IndexOutOfBoundsException();
        }
        for (int i4 = 0; i4 < i3; i4++) {
            sArr[i2 + i4] = readShort();
        }
    }

    @Override // com.tom_roush.harmony.javax.imageio.stream.ImageInputStream
    public void readFully(char[] cArr, int i2, int i3) throws IOException {
        if (i2 < 0 || i3 < 0 || i2 + i3 > cArr.length) {
            throw new IndexOutOfBoundsException();
        }
        for (int i4 = 0; i4 < i3; i4++) {
            cArr[i2 + i4] = readChar();
        }
    }

    @Override // com.tom_roush.harmony.javax.imageio.stream.ImageInputStream
    public void readFully(int[] iArr, int i2, int i3) throws IOException {
        if (i2 < 0 || i3 < 0 || i2 + i3 > iArr.length) {
            throw new IndexOutOfBoundsException();
        }
        for (int i4 = 0; i4 < i3; i4++) {
            iArr[i2 + i4] = readInt();
        }
    }

    @Override // com.tom_roush.harmony.javax.imageio.stream.ImageInputStream
    public void readFully(long[] jArr, int i2, int i3) throws IOException {
        if (i2 < 0 || i3 < 0 || i2 + i3 > jArr.length) {
            throw new IndexOutOfBoundsException();
        }
        for (int i4 = 0; i4 < i3; i4++) {
            jArr[i2 + i4] = readLong();
        }
    }

    @Override // com.tom_roush.harmony.javax.imageio.stream.ImageInputStream
    public void readFully(float[] fArr, int i2, int i3) throws IOException {
        if (i2 < 0 || i3 < 0 || i2 + i3 > fArr.length) {
            throw new IndexOutOfBoundsException();
        }
        for (int i4 = 0; i4 < i3; i4++) {
            fArr[i2 + i4] = readFloat();
        }
    }

    @Override // com.tom_roush.harmony.javax.imageio.stream.ImageInputStream
    public void readFully(double[] dArr, int i2, int i3) throws IOException {
        if (i2 < 0 || i3 < 0 || i2 + i3 > dArr.length) {
            throw new IndexOutOfBoundsException();
        }
        for (int i4 = 0; i4 < i3; i4++) {
            dArr[i2 + i4] = readFloat();
        }
    }
}
