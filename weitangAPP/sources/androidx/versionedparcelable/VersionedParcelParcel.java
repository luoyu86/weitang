package androidx.versionedparcelable;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseIntArray;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class VersionedParcelParcel extends VersionedParcel {
    private static final boolean DEBUG = false;
    private static final String TAG = "VersionedParcelParcel";
    private int mCurrentField;
    private final int mEnd;
    private int mNextRead;
    private final int mOffset;
    private final Parcel mParcel;
    private final SparseIntArray mPositionLookup;
    private final String mPrefix;

    public VersionedParcelParcel(Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), "");
    }

    private int readUntilField(int i2) {
        int i3;
        do {
            int i4 = this.mNextRead;
            if (i4 >= this.mEnd) {
                return -1;
            }
            this.mParcel.setDataPosition(i4);
            int i5 = this.mParcel.readInt();
            i3 = this.mParcel.readInt();
            this.mNextRead += i5;
        } while (i3 != i2);
        return this.mParcel.dataPosition();
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void closeField() {
        int i2 = this.mCurrentField;
        if (i2 >= 0) {
            int i3 = this.mPositionLookup.get(i2);
            int iDataPosition = this.mParcel.dataPosition();
            this.mParcel.setDataPosition(i3);
            this.mParcel.writeInt(iDataPosition - i3);
            this.mParcel.setDataPosition(iDataPosition);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public VersionedParcel createSubParcel() {
        Parcel parcel = this.mParcel;
        int iDataPosition = parcel.dataPosition();
        int i2 = this.mNextRead;
        if (i2 == this.mOffset) {
            i2 = this.mEnd;
        }
        return new VersionedParcelParcel(parcel, iDataPosition, i2, this.mPrefix + "  ");
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public boolean readBoolean() {
        return this.mParcel.readInt() != 0;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public Bundle readBundle() {
        return this.mParcel.readBundle(getClass().getClassLoader());
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public byte[] readByteArray() {
        int i2 = this.mParcel.readInt();
        if (i2 < 0) {
            return null;
        }
        byte[] bArr = new byte[i2];
        this.mParcel.readByteArray(bArr);
        return bArr;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public double readDouble() {
        return this.mParcel.readDouble();
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public boolean readField(int i2) {
        int untilField = readUntilField(i2);
        if (untilField == -1) {
            return false;
        }
        this.mParcel.setDataPosition(untilField);
        return true;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public float readFloat() {
        return this.mParcel.readFloat();
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public int readInt() {
        return this.mParcel.readInt();
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public long readLong() {
        return this.mParcel.readLong();
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public <T extends Parcelable> T readParcelable() {
        return (T) this.mParcel.readParcelable(getClass().getClassLoader());
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public String readString() {
        return this.mParcel.readString();
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public IBinder readStrongBinder() {
        return this.mParcel.readStrongBinder();
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void setOutputField(int i2) {
        closeField();
        this.mCurrentField = i2;
        this.mPositionLookup.put(i2, this.mParcel.dataPosition());
        writeInt(0);
        writeInt(i2);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeBoolean(boolean z) {
        this.mParcel.writeInt(z ? 1 : 0);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeBundle(Bundle bundle) {
        this.mParcel.writeBundle(bundle);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeByteArray(byte[] bArr) {
        if (bArr == null) {
            this.mParcel.writeInt(-1);
        } else {
            this.mParcel.writeInt(bArr.length);
            this.mParcel.writeByteArray(bArr);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeDouble(double d2) {
        this.mParcel.writeDouble(d2);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeFloat(float f2) {
        this.mParcel.writeFloat(f2);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeInt(int i2) {
        this.mParcel.writeInt(i2);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeLong(long j) {
        this.mParcel.writeLong(j);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeParcelable(Parcelable parcelable) {
        this.mParcel.writeParcelable(parcelable, 0);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeString(String str) {
        this.mParcel.writeString(str);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeStrongBinder(IBinder iBinder) {
        this.mParcel.writeStrongBinder(iBinder);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeStrongInterface(IInterface iInterface) {
        this.mParcel.writeStrongInterface(iInterface);
    }

    public VersionedParcelParcel(Parcel parcel, int i2, int i3, String str) {
        this.mPositionLookup = new SparseIntArray();
        this.mCurrentField = -1;
        this.mNextRead = 0;
        this.mParcel = parcel;
        this.mOffset = i2;
        this.mEnd = i3;
        this.mNextRead = i2;
        this.mPrefix = str;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeByteArray(byte[] bArr, int i2, int i3) {
        if (bArr != null) {
            this.mParcel.writeInt(bArr.length);
            this.mParcel.writeByteArray(bArr, i2, i3);
        } else {
            this.mParcel.writeInt(-1);
        }
    }
}
