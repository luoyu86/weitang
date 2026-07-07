package com.tianmu.danikula.videocache.sourcestorage;

import com.tianmu.danikula.videocache.SourceInfo;

/* JADX INFO: loaded from: classes2.dex */
public class NoSourceInfoStorage implements SourceInfoStorage {
    @Override // com.tianmu.danikula.videocache.sourcestorage.SourceInfoStorage
    public SourceInfo get(String str) {
        return null;
    }

    @Override // com.tianmu.danikula.videocache.sourcestorage.SourceInfoStorage
    public void put(String str, SourceInfo sourceInfo) {
    }

    @Override // com.tianmu.danikula.videocache.sourcestorage.SourceInfoStorage
    public void release() {
    }
}
