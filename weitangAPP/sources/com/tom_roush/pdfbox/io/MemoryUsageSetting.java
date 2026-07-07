package com.tom_roush.pdfbox.io;

import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public final class MemoryUsageSetting {
    private final long maxMainMemoryBytes;
    private final long maxStorageBytes;
    private File tempDir;
    private final boolean useMainMemory;
    private final boolean useTempFile;

    private MemoryUsageSetting(boolean z, boolean z2, long j, long j2) {
        boolean z3 = false;
        boolean z4 = !z2 || z;
        j = z ? j : -1L;
        j2 = j2 <= 0 ? -1L : j2;
        j = j < -1 ? -1L : j;
        if (!z4 || j != 0) {
            z3 = z4;
        } else if (!z2) {
            j = j2;
            z3 = z4;
        }
        if (z3 && j2 > -1 && (j == -1 || j > j2)) {
            j2 = j;
        }
        this.useMainMemory = z3;
        this.useTempFile = z2;
        this.maxMainMemoryBytes = j;
        this.maxStorageBytes = j2;
    }

    public static MemoryUsageSetting setupMainMemoryOnly() {
        return setupMainMemoryOnly(-1L);
    }

    public static MemoryUsageSetting setupMixed(long j) {
        return setupMixed(j, -1L);
    }

    public static MemoryUsageSetting setupTempFileOnly() {
        return setupTempFileOnly(-1L);
    }

    public long getMaxMainMemoryBytes() {
        return this.maxMainMemoryBytes;
    }

    public long getMaxStorageBytes() {
        return this.maxStorageBytes;
    }

    public MemoryUsageSetting getPartitionedCopy(int i2) {
        long j = this.maxMainMemoryBytes;
        if (j > 0) {
            j /= (long) i2;
        }
        long j2 = j;
        long j3 = this.maxStorageBytes;
        if (j3 > 0) {
            j3 /= (long) i2;
        }
        MemoryUsageSetting memoryUsageSetting = new MemoryUsageSetting(this.useMainMemory, this.useTempFile, j2, j3);
        memoryUsageSetting.tempDir = this.tempDir;
        return memoryUsageSetting;
    }

    public File getTempDir() {
        return this.tempDir;
    }

    public boolean isMainMemoryRestricted() {
        return this.maxMainMemoryBytes >= 0;
    }

    public boolean isStorageRestricted() {
        return this.maxStorageBytes > 0;
    }

    public MemoryUsageSetting setTempDir(File file) {
        this.tempDir = file;
        return this;
    }

    public String toString() {
        String str;
        if (!this.useMainMemory) {
            if (!isStorageRestricted()) {
                return "Scratch file only with no size restriction";
            }
            return "Scratch file only with max. of " + this.maxStorageBytes + " bytes";
        }
        if (!this.useTempFile) {
            if (!isMainMemoryRestricted()) {
                return "Main memory only with no size restriction";
            }
            return "Main memory only with max. of " + this.maxMainMemoryBytes + " bytes";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Mixed mode with max. of ");
        sb.append(this.maxMainMemoryBytes);
        sb.append(" main memory bytes");
        if (isStorageRestricted()) {
            str = " and max. of " + this.maxStorageBytes + " storage bytes";
        } else {
            str = " and unrestricted scratch file size";
        }
        sb.append(str);
        return sb.toString();
    }

    public boolean useMainMemory() {
        return this.useMainMemory;
    }

    public boolean useTempFile() {
        return this.useTempFile;
    }

    public static MemoryUsageSetting setupMainMemoryOnly(long j) {
        return new MemoryUsageSetting(true, false, j, j);
    }

    public static MemoryUsageSetting setupMixed(long j, long j2) {
        return new MemoryUsageSetting(true, true, j, j2);
    }

    public static MemoryUsageSetting setupTempFileOnly(long j) {
        return new MemoryUsageSetting(false, true, 0L, j);
    }
}
