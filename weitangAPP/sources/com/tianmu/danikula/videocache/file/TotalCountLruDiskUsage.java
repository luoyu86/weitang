package com.tianmu.danikula.videocache.file;

import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public class TotalCountLruDiskUsage extends LruDiskUsage {
    private final int maxCount;

    public TotalCountLruDiskUsage(int i2) {
        if (i2 <= 0) {
            throw new IllegalArgumentException("Max count must be positive number!");
        }
        this.maxCount = i2;
    }

    @Override // com.tianmu.danikula.videocache.file.LruDiskUsage
    public boolean accept(File file, long j, int i2) {
        return i2 <= this.maxCount;
    }
}
