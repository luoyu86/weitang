package cn.com.heaton.blelibrary.ble.model;

import android.text.TextUtils;
import cn.com.heaton.blelibrary.ble.exception.BleWriteException;

/* JADX INFO: loaded from: classes.dex */
public class EntityData {
    private static final int DEFAULT_LENGTH = 20;
    private String address;
    private boolean autoWriteMode;
    private byte[] data;
    private long delay;
    private boolean lastPackComplete;
    private int packLength;

    public static class Builder {
        private String address;
        private boolean autoWriteMode;
        private byte[] data;
        private long delay;
        private boolean lastPackComplete;
        private int packLength = 20;

        public EntityData build() {
            return new EntityData(this.autoWriteMode, this.address, this.data, this.packLength, this.delay, this.lastPackComplete);
        }

        public String getAddress() {
            return this.address;
        }

        public byte[] getData() {
            return this.data;
        }

        public long getDelay() {
            return this.delay;
        }

        public int getPackLength() {
            return this.packLength;
        }

        public boolean isAutoWriteMode() {
            return this.autoWriteMode;
        }

        public boolean isLastPackComplete() {
            return this.lastPackComplete;
        }

        public Builder setAddress(String str) {
            this.address = str;
            return this;
        }

        public Builder setAutoWriteMode(boolean z) {
            this.autoWriteMode = z;
            return this;
        }

        public Builder setData(byte[] bArr) {
            this.data = bArr;
            return this;
        }

        public Builder setDelay(long j) {
            this.delay = j;
            return this;
        }

        public Builder setLastPackComplete(boolean z) {
            this.lastPackComplete = z;
            return this;
        }

        public Builder setPackLength(int i2) {
            this.packLength = i2;
            return this;
        }
    }

    public EntityData(boolean z, String str, byte[] bArr, int i2, long j, boolean z2) {
        this.packLength = 20;
        this.autoWriteMode = z;
        this.address = str;
        this.data = bArr;
        this.packLength = i2;
        this.delay = j;
        this.lastPackComplete = z2;
    }

    public static void validParms(EntityData entityData) throws BleWriteException {
        String str = TextUtils.isEmpty(entityData.address) ? "ble address isn't null" : "";
        if (entityData.data == null) {
            str = "ble data isn't null";
        }
        if (entityData.packLength <= 0) {
            str = "The data length per packet cannot be less than 0";
        }
        if (!TextUtils.isEmpty(str)) {
            throw new BleWriteException(str);
        }
    }

    public String getAddress() {
        return this.address;
    }

    public byte[] getData() {
        if (this.data == null) {
            this.data = new byte[0];
        }
        return this.data;
    }

    public long getDelay() {
        return this.delay;
    }

    public int getPackLength() {
        return this.packLength;
    }

    public boolean isAutoWriteMode() {
        return this.autoWriteMode;
    }

    public boolean isLastPackComplete() {
        return this.lastPackComplete;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public void setAutoWriteMode(boolean z) {
        this.autoWriteMode = z;
    }

    public void setData(byte[] bArr) {
        this.data = bArr;
    }

    public void setDelay(long j) {
        this.delay = j;
    }

    public void setLastPackComplete(boolean z) {
        this.lastPackComplete = z;
    }

    public void setPackLength(int i2) {
        this.packLength = i2;
    }

    public EntityData(String str, byte[] bArr, int i2, long j, boolean z) {
        this(false, str, bArr, i2, j, false);
    }

    public EntityData(String str, byte[] bArr, int i2, long j) {
        this(false, str, bArr, i2, j, false);
    }

    public EntityData() {
        this.packLength = 20;
    }

    public EntityData(String str, byte[] bArr, int i2) {
        this(false, str, bArr, i2, 0L, false);
    }
}
