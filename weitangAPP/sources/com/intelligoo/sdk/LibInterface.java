package com.intelligoo.sdk;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class LibInterface {

    public interface ManagerCallback {
        void setResult(int i2, Bundle bundle);
    }

    public interface ReadCardCallback {
        void onProgress(int i2, int i3);

        void onResult(int i2, int i3, ArrayList<String> arrayList);
    }

    public interface ReadFingerprintCallback {
        void onProgress(int i2, int i3, int i4, int i5);

        void onResult(int i2, int i3, ArrayList arrayList);
    }

    public interface ReadOpenRecordCallback {
        void onProgress(int i2, int i3);

        void onResult(int i2, int i3, ArrayList<Map> arrayList);
    }

    public interface SyncFingerprintCallback {
        void onProgress(int i2, int i3);

        void onResult(int i2, int i3);
    }
}
