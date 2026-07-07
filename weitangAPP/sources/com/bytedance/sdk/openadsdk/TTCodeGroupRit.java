package com.bytedance.sdk.openadsdk;

/* JADX INFO: loaded from: classes.dex */
public interface TTCodeGroupRit {

    public interface TTCodeGroupRitListener {
        void onFail(int i2, String str);

        void onSuccess(TTCodeGroupRit tTCodeGroupRit);
    }

    String getRit();

    int getSlotType();
}
