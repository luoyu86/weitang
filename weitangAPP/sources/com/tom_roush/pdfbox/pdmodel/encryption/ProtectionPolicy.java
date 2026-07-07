package com.tom_roush.pdfbox.pdmodel.encryption;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ProtectionPolicy {
    private static final short DEFAULT_KEY_LENGTH = 40;
    private short encryptionKeyLength = DEFAULT_KEY_LENGTH;
    private boolean preferAES = false;

    public int getEncryptionKeyLength() {
        return this.encryptionKeyLength;
    }

    public boolean isPreferAES() {
        return this.preferAES;
    }

    public void setEncryptionKeyLength(int i2) {
        if (i2 == 40 || i2 == 128 || i2 == 256) {
            this.encryptionKeyLength = (short) i2;
            return;
        }
        throw new IllegalArgumentException("Invalid key length '" + i2 + "' value must be 40, 128 or 256!");
    }

    public void setPreferAES(boolean z) {
        this.preferAES = z;
    }
}
