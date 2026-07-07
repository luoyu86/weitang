package com.tom_roush.pdfbox.pdmodel.encryption;

/* JADX INFO: loaded from: classes2.dex */
public class AccessPermission {
    private static final int ASSEMBLE_DOCUMENT_BIT = 11;
    private static final int DEFAULT_PERMISSIONS = -4;
    private static final int DEGRADED_PRINT_BIT = 12;
    private static final int EXTRACT_BIT = 5;
    private static final int EXTRACT_FOR_ACCESSIBILITY_BIT = 10;
    private static final int FILL_IN_FORM_BIT = 9;
    private static final int MODIFICATION_BIT = 4;
    private static final int MODIFY_ANNOTATIONS_BIT = 6;
    private static final int PRINT_BIT = 3;
    private int bytes;
    private boolean readOnly;

    public AccessPermission() {
        this.readOnly = false;
        this.bytes = -4;
    }

    public static AccessPermission getOwnerAccessPermission() {
        AccessPermission accessPermission = new AccessPermission();
        accessPermission.setCanAssembleDocument(true);
        accessPermission.setCanExtractContent(true);
        accessPermission.setCanExtractForAccessibility(true);
        accessPermission.setCanFillInForm(true);
        accessPermission.setCanModify(true);
        accessPermission.setCanModifyAnnotations(true);
        accessPermission.setCanPrint(true);
        accessPermission.setCanPrintDegraded(true);
        return accessPermission;
    }

    private boolean isPermissionBitOn(int i2) {
        return ((1 << (i2 - 1)) & this.bytes) != 0;
    }

    private boolean setPermissionBit(int i2, boolean z) {
        int i3 = this.bytes;
        int i4 = z ? (1 << (i2 - 1)) | i3 : (~(1 << (i2 - 1))) & i3;
        this.bytes = i4;
        return ((1 << (i2 - 1)) & i4) != 0;
    }

    public boolean canAssembleDocument() {
        return isPermissionBitOn(11);
    }

    public boolean canExtractContent() {
        return isPermissionBitOn(5);
    }

    public boolean canExtractForAccessibility() {
        return isPermissionBitOn(10);
    }

    public boolean canFillInForm() {
        return isPermissionBitOn(9);
    }

    public boolean canModify() {
        return isPermissionBitOn(4);
    }

    public boolean canModifyAnnotations() {
        return isPermissionBitOn(6);
    }

    public boolean canPrint() {
        return isPermissionBitOn(3);
    }

    public boolean canPrintDegraded() {
        return isPermissionBitOn(12);
    }

    public int getPermissionBytes() {
        return this.bytes;
    }

    public int getPermissionBytesForPublicKey() {
        setPermissionBit(1, true);
        setPermissionBit(7, false);
        setPermissionBit(8, false);
        for (int i2 = 13; i2 <= 32; i2++) {
            setPermissionBit(i2, false);
        }
        return this.bytes;
    }

    public boolean hasAnyRevision3PermissionSet() {
        if (canFillInForm() || canExtractForAccessibility() || canAssembleDocument()) {
            return true;
        }
        return canPrintDegraded();
    }

    public boolean isOwnerPermission() {
        return canAssembleDocument() && canExtractContent() && canExtractForAccessibility() && canFillInForm() && canModify() && canModifyAnnotations() && canPrint() && canPrintDegraded();
    }

    public boolean isReadOnly() {
        return this.readOnly;
    }

    public void setCanAssembleDocument(boolean z) {
        if (this.readOnly) {
            return;
        }
        setPermissionBit(11, z);
    }

    public void setCanExtractContent(boolean z) {
        if (this.readOnly) {
            return;
        }
        setPermissionBit(5, z);
    }

    public void setCanExtractForAccessibility(boolean z) {
        if (this.readOnly) {
            return;
        }
        setPermissionBit(10, z);
    }

    public void setCanFillInForm(boolean z) {
        if (this.readOnly) {
            return;
        }
        setPermissionBit(9, z);
    }

    public void setCanModify(boolean z) {
        if (this.readOnly) {
            return;
        }
        setPermissionBit(4, z);
    }

    public void setCanModifyAnnotations(boolean z) {
        if (this.readOnly) {
            return;
        }
        setPermissionBit(6, z);
    }

    public void setCanPrint(boolean z) {
        if (this.readOnly) {
            return;
        }
        setPermissionBit(3, z);
    }

    public void setCanPrintDegraded(boolean z) {
        if (this.readOnly) {
            return;
        }
        setPermissionBit(12, z);
    }

    public void setReadOnly() {
        this.readOnly = true;
    }

    public AccessPermission(byte[] bArr) {
        this.readOnly = false;
        this.bytes = 0;
        int i2 = 0 | (bArr[0] & 255);
        this.bytes = i2;
        int i3 = i2 << 8;
        this.bytes = i3;
        int i4 = i3 | (bArr[1] & 255);
        this.bytes = i4;
        int i5 = i4 << 8;
        this.bytes = i5;
        int i6 = i5 | (bArr[2] & 255);
        this.bytes = i6;
        int i7 = i6 << 8;
        this.bytes = i7;
        this.bytes = (bArr[3] & 255) | i7;
    }

    public AccessPermission(int i2) {
        this.readOnly = false;
        this.bytes = i2;
    }
}
