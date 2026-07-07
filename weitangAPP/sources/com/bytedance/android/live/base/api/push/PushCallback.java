package com.bytedance.android.live.base.api.push;

import com.bytedance.android.live.base.api.push.model.PushData;

/* JADX INFO: loaded from: classes.dex */
public interface PushCallback {
    void onFailed(Throwable th);

    void onSuccess(PushData pushData);
}
