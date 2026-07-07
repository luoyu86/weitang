package com.intelligoo.sdk.a.a;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public class a implements Parcelable {
    public static final Parcelable.Creator<a> CREATOR = new Parcelable.Creator<a>() { // from class: com.intelligoo.sdk.a.a.a.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public a createFromParcel(Parcel parcel) {
            return new a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public a[] newArray(int i2) {
            return new a[i2];
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f9173a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f9174b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final byte[] f9175c;

    public a(int i2, int i3, byte[] bArr) {
        this.f9173a = i2;
        this.f9174b = i3;
        this.f9175c = bArr;
    }

    public a(Parcel parcel) {
        Bundle bundle = parcel.readBundle(getClass().getClassLoader());
        this.f9173a = bundle.getInt("record_length");
        this.f9174b = bundle.getInt("record_type");
        this.f9175c = bundle.getByteArray("record_data");
    }

    private static String a(int i2) {
        if (i2 == 32) {
            return "Service Data - 32-bit UUID.";
        }
        if (i2 == 33) {
            return "Service Data - 128-bit UUID.";
        }
        if (i2 == 61) {
            return "3D Information Data.";
        }
        if (i2 == 255) {
            return "Manufacturer Specific Data.";
        }
        switch (i2) {
            case 1:
                return "Flags for discoverAbility.";
            case 2:
                return "Partial list of 16 bit service UUIDs.";
            case 3:
                return "Complete list of 16 bit service UUIDs.";
            case 4:
                return "Partial list of 32 bit service UUIDs.";
            case 5:
                return "Complete list of 32 bit service UUIDs.";
            case 6:
                return "Partial list of 128 bit service UUIDs.";
            case 7:
                return "Complete list of 128 bit service UUIDs.";
            case 8:
                return "Short local device name.";
            case 9:
                return "Complete local device name.";
            case 10:
                return "Transmit power level.";
            default:
                switch (i2) {
                    case 13:
                        return "Class of device.";
                    case 14:
                        return "Simple Pairing Hash C.";
                    case 15:
                        return "Simple Pairing Randomizer R.";
                    case 16:
                        return "Security Manager TK Value.";
                    case 17:
                        return "Security Manager Out Of Band Flags.";
                    case 18:
                        return "Slave Connection Interval Range.";
                    default:
                        switch (i2) {
                            case 20:
                                return "List of 16-bit Service Solicitation UUIDs.";
                            case 21:
                                return "List of 128-bit Service Solicitation UUIDs.";
                            case 22:
                                return "Service Data - 16-bit UUID.";
                            case 23:
                                return "Public Target Address.";
                            case 24:
                                return "Random Target Address.";
                            case 25:
                                return "Appearance.";
                            case 26:
                                return "Advertising Interval.";
                            case 27:
                                return "LE Bluetooth Device Address.";
                            case 28:
                                return "LE Role.";
                            case 29:
                                return "Simple Pairing Hash C-256.";
                            case 30:
                                return "Simple Pairing Randomizer R-256.";
                            default:
                                return "Unknown AdRecord Structure: " + i2;
                        }
                }
        }
    }

    public byte[] a() {
        return this.f9175c;
    }

    public String b() {
        return a(this.f9174b);
    }

    public int c() {
        return this.f9174b;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "AdRecord [mLength=" + this.f9173a + ", mType=" + this.f9174b + ", mData=" + Arrays.toString(this.f9175c) + ", getHumanReadableType()=" + b() + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        Bundle bundle = new Bundle(getClass().getClassLoader());
        bundle.putInt("record_length", this.f9173a);
        bundle.putInt("record_type", this.f9174b);
        bundle.putByteArray("record_data", this.f9175c);
        parcel.writeBundle(bundle);
    }
}
