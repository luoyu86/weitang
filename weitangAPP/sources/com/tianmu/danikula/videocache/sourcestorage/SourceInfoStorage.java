package com.tianmu.danikula.videocache.sourcestorage;

import com.tianmu.danikula.videocache.SourceInfo;

/* JADX INFO: loaded from: classes2.dex */
public interface SourceInfoStorage {
    SourceInfo get(String str);

    void put(String str, SourceInfo sourceInfo);

    void release();
}
