package com.alibaba.android.arouter.thread;

import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes.dex */
public class CancelableCountDownLatch extends CountDownLatch {
    public CancelableCountDownLatch(int i2) {
        super(i2);
    }

    public void cancel() {
        while (getCount() > 0) {
            countDown();
        }
    }
}
