package com.qq.e.comm.pi;

import android.content.Context;
import com.qq.e.ads.dfa.GDTApk;

/* JADX INFO: loaded from: classes2.dex */
public interface DFA {
    void loadGDTApk();

    void startInstall(Context context, GDTApk gDTApk);
}
