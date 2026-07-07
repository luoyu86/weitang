package com.alipay.sdk.m.j;

/* JADX INFO: loaded from: classes.dex */
public enum c {
    SUCCEEDED(9000, "处理成功"),
    FAILED(4000, "系统繁忙，请稍后再试"),
    CANCELED(6001, "用户取消"),
    NETWORK_ERROR(6002, "网络连接异常"),
    ACTIVITY_NOT_START_EXIT(6007, "支付未完成"),
    PARAMS_ERROR(4001, "参数错误"),
    DOUBLE_REQUEST(5000, "重复请求"),
    PAY_WAITTING(8000, "支付结果确认中");


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f5397a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f5398b;

    c(int i2, String str) {
        this.f5397a = i2;
        this.f5398b = str;
    }

    public void a(int i2) {
        this.f5397a = i2;
    }

    public int b() {
        return this.f5397a;
    }

    public static c b(int i2) {
        return i2 != 4001 ? i2 != 5000 ? i2 != 8000 ? i2 != 9000 ? i2 != 6001 ? i2 != 6002 ? FAILED : NETWORK_ERROR : CANCELED : SUCCEEDED : PAY_WAITTING : DOUBLE_REQUEST : PARAMS_ERROR;
    }

    public void a(String str) {
        this.f5398b = str;
    }

    public String a() {
        return this.f5398b;
    }
}
