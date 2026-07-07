package com.bytedance.android.live.base.api.callback;

/* JADX INFO: loaded from: classes.dex */
public interface CommonCallback<T, D> {
    void onFail(D d2);

    void onSuccess(T t);
}
