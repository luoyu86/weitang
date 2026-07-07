package com.intelligoo.sdk;

import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ScanCallBackSort {
    public abstract void onScanResult(ArrayList<Map<String, Integer>> arrayList);

    public abstract void onScanResultAtOnce(String str, int i2);
}
