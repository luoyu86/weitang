package com.qq.e.ads;

import com.qq.e.comm.util.AdError;

/* JADX INFO: loaded from: classes2.dex */
public abstract class NativeAbstractAD<T> extends AbstractAD<T> {

    public interface BasicADListener {
        void onNoAD(AdError adError);
    }

    @Override // com.qq.e.ads.AbstractAD
    public void a(T t) {
    }
}
