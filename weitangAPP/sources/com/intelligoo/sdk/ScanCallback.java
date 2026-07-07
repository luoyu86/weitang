package com.intelligoo.sdk;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ScanCallback {
    public abstract void onScanResult(ArrayList<String> arrayList, ArrayList<Integer> arrayList2);

    public abstract void onScanResultAtOnce(String str, int i2);
}
