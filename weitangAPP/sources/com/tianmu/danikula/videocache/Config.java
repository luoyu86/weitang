package com.tianmu.danikula.videocache;

import com.tianmu.danikula.videocache.file.DiskUsage;
import com.tianmu.danikula.videocache.file.FileNameGenerator;
import com.tianmu.danikula.videocache.headers.HeaderInjector;
import com.tianmu.danikula.videocache.sourcestorage.SourceInfoStorage;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public class Config {
    public final File cacheRoot;
    public final DiskUsage diskUsage;
    public final FileNameGenerator fileNameGenerator;
    public final HeaderInjector headerInjector;
    public final SourceInfoStorage sourceInfoStorage;

    public Config(File file, FileNameGenerator fileNameGenerator, DiskUsage diskUsage, SourceInfoStorage sourceInfoStorage, HeaderInjector headerInjector) {
        this.cacheRoot = file;
        this.fileNameGenerator = fileNameGenerator;
        this.diskUsage = diskUsage;
        this.sourceInfoStorage = sourceInfoStorage;
        this.headerInjector = headerInjector;
    }

    public File generateCacheFile(String str) {
        return new File(this.cacheRoot, this.fileNameGenerator.generate(str));
    }
}
