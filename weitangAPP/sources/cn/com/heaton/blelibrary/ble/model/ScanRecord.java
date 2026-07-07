package cn.com.heaton.blelibrary.ble.model;

import android.os.ParcelUuid;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(api = 21)
public class ScanRecord {
    private static final int DATA_TYPE_FLAGS = 1;
    private static final int DATA_TYPE_LOCAL_NAME_COMPLETE = 9;
    private static final int DATA_TYPE_LOCAL_NAME_SHORT = 8;
    private static final int DATA_TYPE_MANUFACTURER_SPECIFIC_DATA = 255;
    private static final int DATA_TYPE_SERVICE_DATA = 22;
    private static final int DATA_TYPE_SERVICE_UUIDS_128_BIT_COMPLETE = 7;
    private static final int DATA_TYPE_SERVICE_UUIDS_128_BIT_PARTIAL = 6;
    private static final int DATA_TYPE_SERVICE_UUIDS_16_BIT_COMPLETE = 3;
    private static final int DATA_TYPE_SERVICE_UUIDS_16_BIT_PARTIAL = 2;
    private static final int DATA_TYPE_SERVICE_UUIDS_32_BIT_COMPLETE = 5;
    private static final int DATA_TYPE_SERVICE_UUIDS_32_BIT_PARTIAL = 4;
    private static final int DATA_TYPE_TX_POWER_LEVEL = 10;
    private static final String TAG = "ScanRecord";
    private final int mAdvertiseFlags;
    private final byte[] mBytes;
    private final String mDeviceName;
    private final SparseArray<byte[]> mManufacturerSpecificData;
    private final Map<ParcelUuid, byte[]> mServiceData;

    @Nullable
    private final List<ParcelUuid> mServiceUuids;
    private final int mTxPowerLevel;
    public static final char[] hexArray = "0123456789ABCDEF".toCharArray();
    public static final ParcelUuid BASE_UUID = ParcelUuid.fromString("00000000-0000-1000-8000-00805F9B34FB");

    private ScanRecord(List<ParcelUuid> list, SparseArray<byte[]> sparseArray, Map<ParcelUuid, byte[]> map, int i2, int i3, String str, byte[] bArr) {
        this.mServiceUuids = list;
        this.mManufacturerSpecificData = sparseArray;
        this.mServiceData = map;
        this.mDeviceName = str;
        this.mAdvertiseFlags = i2;
        this.mTxPowerLevel = i3;
        this.mBytes = bArr;
    }

    public static String bytesToHex(byte[] bArr) {
        char[] cArr = new char[bArr.length * 2];
        for (int i2 = 0; i2 < bArr.length; i2++) {
            int i3 = bArr[i2] & 255;
            int i4 = i2 * 2;
            char[] cArr2 = hexArray;
            cArr[i4] = cArr2[i3 >>> 4];
            cArr[i4 + 1] = cArr2[i3 & 15];
        }
        return new String(cArr);
    }

    private static byte[] extractBytes(byte[] bArr, int i2, int i3) {
        byte[] bArr2 = new byte[i3];
        System.arraycopy(bArr, i2, bArr2, 0, i3);
        return bArr2;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0092  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static cn.com.heaton.blelibrary.ble.model.ScanRecord parseFromBytes(byte[] r14) {
        /*
            Method dump skipped, instruction units count: 222
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.com.heaton.blelibrary.ble.model.ScanRecord.parseFromBytes(byte[]):cn.com.heaton.blelibrary.ble.model.ScanRecord");
    }

    private static int parseServiceUuid(byte[] bArr, int i2, int i3, int i4, List<ParcelUuid> list) {
        while (i3 > 0) {
            list.add(parseUuidFrom(extractBytes(bArr, i2, i4)));
            i3 -= i4;
            i2 += i4;
        }
        return i2;
    }

    public static ParcelUuid parseUuidFrom(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("uuidBytes cannot be null");
        }
        int length = bArr.length;
        if (length != 16 && length != 32 && length != 128) {
            throw new IllegalArgumentException("uuidBytes length invalid - " + length);
        }
        if (length == 128) {
            ByteBuffer byteBufferOrder = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
            return new ParcelUuid(new UUID(byteBufferOrder.getLong(8), byteBufferOrder.getLong(0)));
        }
        long j = length == 16 ? ((long) (bArr[0] & 255)) + ((long) ((bArr[1] & 255) << 8)) : ((long) (bArr[0] & 255)) + ((long) ((bArr[1] & 255) << 8)) + ((long) ((bArr[2] & 255) << 16)) + ((long) ((bArr[3] & 255) << 24));
        ParcelUuid parcelUuid = BASE_UUID;
        return new ParcelUuid(new UUID(parcelUuid.getUuid().getMostSignificantBits() + (j << 32), parcelUuid.getUuid().getLeastSignificantBits()));
    }

    public static String toString(SparseArray<byte[]> sparseArray) {
        if (sparseArray == null) {
            return "null";
        }
        if (sparseArray.size() == 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('{');
        for (int i2 = 0; i2 < sparseArray.size(); i2++) {
            sb.append(sparseArray.keyAt(i2));
            sb.append("=");
            sb.append(Arrays.toString(sparseArray.valueAt(i2)));
        }
        sb.append('}');
        return sb.toString();
    }

    public int getAdvertiseFlags() {
        return this.mAdvertiseFlags;
    }

    public byte[] getBytes() {
        return this.mBytes;
    }

    @Nullable
    public String getDeviceName() {
        return this.mDeviceName;
    }

    public SparseArray<byte[]> getManufacturerSpecificData() {
        return this.mManufacturerSpecificData;
    }

    public Map<ParcelUuid, byte[]> getServiceData() {
        return this.mServiceData;
    }

    public List<ParcelUuid> getServiceUuids() {
        return this.mServiceUuids;
    }

    public int getTxPowerLevel() {
        return this.mTxPowerLevel;
    }

    @Nullable
    public byte[] getManufacturerSpecificData(int i2) {
        return this.mManufacturerSpecificData.get(i2);
    }

    @Nullable
    public byte[] getServiceData(ParcelUuid parcelUuid) {
        if (parcelUuid == null) {
            return null;
        }
        return this.mServiceData.get(parcelUuid);
    }

    public static <T> String toString(Map<T, byte[]> map) {
        if (map == null) {
            return "null";
        }
        if (map.isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('{');
        Iterator<Map.Entry<T, byte[]>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            T key = it.next().getKey();
            sb.append(key);
            sb.append("=");
            sb.append(Arrays.toString(map.get(key)));
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public String toString() {
        return "ScanRecord [mAdvertiseFlags=" + this.mAdvertiseFlags + ", mServiceUuids=" + this.mServiceUuids + ", mManufacturerSpecificData=" + toString(this.mManufacturerSpecificData) + ", mServiceData=" + toString(this.mServiceData) + ", mTxPowerLevel=" + this.mTxPowerLevel + ", mDeviceName=" + this.mDeviceName + "]";
    }
}
