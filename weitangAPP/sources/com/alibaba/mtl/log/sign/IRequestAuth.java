package com.alibaba.mtl.log.sign;

/* JADX INFO: loaded from: classes.dex */
public interface IRequestAuth {
    String getAppkey();

    String getSign(String str);
}
