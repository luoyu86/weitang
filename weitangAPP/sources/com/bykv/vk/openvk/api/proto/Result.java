package com.bykv.vk.openvk.api.proto;

/* JADX INFO: loaded from: classes.dex */
public interface Result {
    int code();

    boolean isSuccess();

    String message();

    ValueSet values();
}
