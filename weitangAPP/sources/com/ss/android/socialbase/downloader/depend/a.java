package com.ss.android.socialbase.downloader.depend;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a implements ul {
    private boolean ok = false;

    @Override // com.ss.android.socialbase.downloader.depend.ul
    public void ok(List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        this.ok = true;
    }

    @Override // com.ss.android.socialbase.downloader.depend.ul
    public boolean ok() {
        return this.ok;
    }
}
