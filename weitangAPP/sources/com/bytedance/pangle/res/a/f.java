package com.bytedance.pangle.res.a;

import java.io.DataInput;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public abstract class f implements DataInput {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i f6223a;

    public f(i iVar) {
        this.f6223a = iVar;
    }

    @Override // java.io.DataInput
    public boolean readBoolean() {
        return this.f6223a.readBoolean();
    }

    @Override // java.io.DataInput
    public byte readByte() {
        return this.f6223a.readByte();
    }

    @Override // java.io.DataInput
    public char readChar() {
        return this.f6223a.readChar();
    }

    @Override // java.io.DataInput
    public double readDouble() {
        return this.f6223a.readDouble();
    }

    @Override // java.io.DataInput
    public float readFloat() {
        return this.f6223a.readFloat();
    }

    @Override // java.io.DataInput
    public void readFully(byte[] bArr, int i2, int i3) throws IOException {
        this.f6223a.readFully(bArr, i2, i3);
    }

    @Override // java.io.DataInput
    public int readInt() {
        return this.f6223a.readInt();
    }

    @Override // java.io.DataInput
    public String readLine() {
        return this.f6223a.readLine();
    }

    @Override // java.io.DataInput
    public long readLong() {
        return this.f6223a.readLong();
    }

    @Override // java.io.DataInput
    public short readShort() {
        return this.f6223a.readShort();
    }

    @Override // java.io.DataInput
    public String readUTF() {
        return this.f6223a.readUTF();
    }

    @Override // java.io.DataInput
    public int readUnsignedByte() {
        return this.f6223a.readUnsignedByte();
    }

    @Override // java.io.DataInput
    public int readUnsignedShort() {
        return this.f6223a.readUnsignedShort();
    }

    @Override // java.io.DataInput
    public int skipBytes(int i2) {
        return this.f6223a.skipBytes(i2);
    }

    @Override // java.io.DataInput
    public void readFully(byte[] bArr) throws IOException {
        this.f6223a.readFully(bArr);
    }
}
