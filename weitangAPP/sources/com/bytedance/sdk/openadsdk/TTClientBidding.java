package com.bytedance.sdk.openadsdk;

/* JADX INFO: loaded from: classes.dex */
public interface TTClientBidding {
    void loss(Double d2, String str, String str2);

    void setAdInteractionListener(TTAdInteractionListener tTAdInteractionListener);

    void setPrice(Double d2);

    void win(Double d2);
}
