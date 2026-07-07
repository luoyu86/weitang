package com.tianmu.danikula.videocache.file;

import com.tianmu.danikula.videocache.Cache;
import com.tianmu.danikula.videocache.ProxyCacheException;
import com.tom_roush.pdfbox.pdmodel.common.PDPageLabelRange;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/* JADX INFO: loaded from: classes2.dex */
public class FileCache implements Cache {
    private static final String TEMP_POSTFIX = ".download";
    private RandomAccessFile dataFile;
    private final DiskUsage diskUsage;
    public File file;

    public FileCache(File file) {
        this(file, new UnlimitedDiskUsage());
    }

    private boolean isTempFile(File file) {
        return file.getName().endsWith(TEMP_POSTFIX);
    }

    @Override // com.tianmu.danikula.videocache.Cache
    public synchronized void append(byte[] bArr, int i2) {
        try {
            if (isCompleted()) {
                throw new ProxyCacheException("Error append cache: cache file " + this.file + " is completed!");
            }
            this.dataFile.seek(available());
            this.dataFile.write(bArr, 0, i2);
        } catch (IOException e2) {
            throw new ProxyCacheException(String.format("Error writing %d bytes to %s from buffer with size %d", Integer.valueOf(i2), this.dataFile, Integer.valueOf(bArr.length)), e2);
        }
    }

    @Override // com.tianmu.danikula.videocache.Cache
    public synchronized long available() {
        try {
        } catch (IOException e2) {
            throw new ProxyCacheException("Error reading length of file " + this.file, e2);
        }
        return (int) this.dataFile.length();
    }

    @Override // com.tianmu.danikula.videocache.Cache
    public synchronized void close() {
        try {
            this.dataFile.close();
            this.diskUsage.touch(this.file);
        } catch (IOException e2) {
            throw new ProxyCacheException("Error closing file " + this.file, e2);
        }
    }

    @Override // com.tianmu.danikula.videocache.Cache
    public synchronized void complete() {
        if (isCompleted()) {
            return;
        }
        close();
        File file = new File(this.file.getParentFile(), this.file.getName().substring(0, this.file.getName().length() - 9));
        if (!this.file.renameTo(file)) {
            throw new ProxyCacheException("Error renaming file " + this.file + " to " + file + " for completion!");
        }
        this.file = file;
        try {
            this.dataFile = new RandomAccessFile(this.file, PDPageLabelRange.STYLE_ROMAN_LOWER);
            this.diskUsage.touch(this.file);
        } catch (IOException e2) {
            throw new ProxyCacheException("Error opening " + this.file + " as disc cache", e2);
        }
    }

    public File getFile() {
        return this.file;
    }

    @Override // com.tianmu.danikula.videocache.Cache
    public synchronized boolean isCompleted() {
        return !isTempFile(this.file);
    }

    @Override // com.tianmu.danikula.videocache.Cache
    public synchronized int read(byte[] bArr, long j, int i2) {
        try {
            this.dataFile.seek(j);
        } catch (IOException e2) {
            throw new ProxyCacheException(String.format("Error reading %d bytes with offset %d from file[%d bytes] to buffer[%d bytes]", Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(available()), Integer.valueOf(bArr.length)), e2);
        }
        return this.dataFile.read(bArr, 0, i2);
    }

    public FileCache(File file, DiskUsage diskUsage) throws ProxyCacheException {
        File file2;
        try {
            if (diskUsage == null) {
                throw new NullPointerException();
            }
            this.diskUsage = diskUsage;
            Files.makeDir(file.getParentFile());
            boolean zExists = file.exists();
            if (zExists) {
                file2 = file;
            } else {
                file2 = new File(file.getParentFile(), file.getName() + TEMP_POSTFIX);
            }
            this.file = file2;
            this.dataFile = new RandomAccessFile(this.file, zExists ? PDPageLabelRange.STYLE_ROMAN_LOWER : "rw");
        } catch (IOException e2) {
            throw new ProxyCacheException("Error using file " + file + " as disc cache", e2);
        }
    }
}
