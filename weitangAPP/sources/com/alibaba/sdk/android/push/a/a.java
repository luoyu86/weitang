package com.alibaba.sdk.android.push.a;

import android.content.Context;
import android.graphics.Bitmap;
import com.alibaba.sdk.android.ams.common.logger.AmsLogger;
import com.alibaba.sdk.android.error.ErrorCode;
import com.alibaba.sdk.android.push.CommonCallback;
import com.alibaba.sdk.android.push.common.global.MpsGlobalSetter;
import com.alibaba.sdk.android.push.e.g;
import com.alibaba.sdk.android.push.notification.CPushMessage;
import com.taobao.agoo.ICallback;
import com.taobao.agoo.TaobaoRegister;
import com.tom_roush.pdfbox.pdmodel.documentinterchange.taggedpdf.PDPrintFieldAttributeObject;
import com.ut.device.UTDevice;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final AmsLogger f4751b = AmsLogger.getLogger("MPS:CloudPushService");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f4752a;

    /* JADX INFO: renamed from: com.alibaba.sdk.android.push.a.a$2, reason: invalid class name */
    public class AnonymousClass2 implements CommonCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CommonCallback f4755a;

        /* JADX INFO: renamed from: com.alibaba.sdk.android.push.a.a$2$1, reason: invalid class name */
        public class AnonymousClass1 extends ICallback {
            public AnonymousClass1() {
            }

            @Override // com.taobao.agoo.ICallback
            public void onFailure(String str, String str2) {
                ErrorCode errorCodeBuild = com.alibaba.sdk.android.push.common.global.c.a(str, str2).detail("turnOffPushChannel unbindAgoo").build();
                CommonCallback commonCallback = AnonymousClass2.this.f4755a;
                if (commonCallback != null) {
                    commonCallback.onFailed(errorCodeBuild.getCode(), errorCodeBuild.getMsg());
                }
            }

            @Override // com.taobao.agoo.ICallback
            public void onSuccess() {
                g.a().d(new CommonCallback() { // from class: com.alibaba.sdk.android.push.a.a.2.1.1
                    @Override // com.alibaba.sdk.android.push.CommonCallback
                    public void onFailed(final String str, final String str2) {
                        TaobaoRegister.bindAgoo(a.this.f4752a, new ICallback() { // from class: com.alibaba.sdk.android.push.a.a.2.1.1.1
                            @Override // com.taobao.agoo.ICallback
                            public void onFailure(String str3, String str4) {
                                ErrorCode errorCodeBuild = com.alibaba.sdk.android.push.common.global.c.a(str3, str4).detail("turnOffPushChannel bindAgoo").build();
                                CommonCallback commonCallback = AnonymousClass2.this.f4755a;
                                if (commonCallback != null) {
                                    commonCallback.onFailed(errorCodeBuild.getCode(), errorCodeBuild.getMsg());
                                }
                            }

                            @Override // com.taobao.agoo.ICallback
                            public void onSuccess() {
                                CommonCallback commonCallback = AnonymousClass2.this.f4755a;
                                if (commonCallback != null) {
                                    commonCallback.onFailed(str, str2);
                                }
                            }
                        });
                    }

                    @Override // com.alibaba.sdk.android.push.CommonCallback
                    public void onSuccess(String str) {
                        CommonCallback commonCallback = AnonymousClass2.this.f4755a;
                        if (commonCallback != null) {
                            commonCallback.onSuccess(str);
                        }
                    }
                });
            }
        }

        public AnonymousClass2(CommonCallback commonCallback) {
            this.f4755a = commonCallback;
        }

        @Override // com.alibaba.sdk.android.push.CommonCallback
        public void onFailed(String str, String str2) {
            CommonCallback commonCallback = this.f4755a;
            if (commonCallback != null) {
                commonCallback.onFailed(str, str2);
            }
        }

        @Override // com.alibaba.sdk.android.push.CommonCallback
        public void onSuccess(String str) {
            if (!str.equals(PDPrintFieldAttributeObject.CHECKED_STATE_OFF)) {
                TaobaoRegister.unbindAgoo(a.this.f4752a, new AnonymousClass1());
                return;
            }
            a.f4751b.d("already off. return");
            CommonCallback commonCallback = this.f4755a;
            if (commonCallback != null) {
                commonCallback.onSuccess(str);
            }
        }
    }

    /* JADX INFO: renamed from: com.alibaba.sdk.android.push.a.a$3, reason: invalid class name */
    public class AnonymousClass3 implements CommonCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CommonCallback f4762a;

        /* JADX INFO: renamed from: com.alibaba.sdk.android.push.a.a$3$1, reason: invalid class name */
        public class AnonymousClass1 extends ICallback {
            public AnonymousClass1() {
            }

            @Override // com.taobao.agoo.ICallback
            public void onFailure(String str, String str2) {
                ErrorCode errorCodeBuild = com.alibaba.sdk.android.push.common.global.c.a(str, str2).detail("turnOnPushChannel bindAgoo").build();
                CommonCallback commonCallback = AnonymousClass3.this.f4762a;
                if (commonCallback != null) {
                    commonCallback.onFailed(errorCodeBuild.getCode(), errorCodeBuild.getMsg());
                }
            }

            @Override // com.taobao.agoo.ICallback
            public void onSuccess() {
                g.a().e(new CommonCallback() { // from class: com.alibaba.sdk.android.push.a.a.3.1.1
                    @Override // com.alibaba.sdk.android.push.CommonCallback
                    public void onFailed(final String str, final String str2) {
                        TaobaoRegister.unbindAgoo(a.this.f4752a, new ICallback() { // from class: com.alibaba.sdk.android.push.a.a.3.1.1.1
                            @Override // com.taobao.agoo.ICallback
                            public void onFailure(String str3, String str4) {
                                ErrorCode errorCodeBuild = com.alibaba.sdk.android.push.common.global.c.a(str3, str4).detail("turnOnPushChannel unbindAgoo").build();
                                CommonCallback commonCallback = AnonymousClass3.this.f4762a;
                                if (commonCallback != null) {
                                    commonCallback.onFailed(errorCodeBuild.getCode(), errorCodeBuild.getMsg());
                                }
                            }

                            @Override // com.taobao.agoo.ICallback
                            public void onSuccess() {
                                CommonCallback commonCallback = AnonymousClass3.this.f4762a;
                                if (commonCallback != null) {
                                    commonCallback.onFailed(str, str2);
                                }
                            }
                        });
                    }

                    @Override // com.alibaba.sdk.android.push.CommonCallback
                    public void onSuccess(String str) {
                        CommonCallback commonCallback = AnonymousClass3.this.f4762a;
                        if (commonCallback != null) {
                            commonCallback.onSuccess(str);
                        }
                    }
                });
            }
        }

        public AnonymousClass3(CommonCallback commonCallback) {
            this.f4762a = commonCallback;
        }

        @Override // com.alibaba.sdk.android.push.CommonCallback
        public void onFailed(String str, String str2) {
            CommonCallback commonCallback = this.f4762a;
            if (commonCallback != null) {
                commonCallback.onFailed(str, str2);
            }
        }

        @Override // com.alibaba.sdk.android.push.CommonCallback
        public void onSuccess(String str) {
            if (!str.equals(PDPrintFieldAttributeObject.CHECKED_STATE_ON)) {
                TaobaoRegister.bindAgoo(a.this.f4752a, new AnonymousClass1());
                return;
            }
            a.f4751b.d("already on. return");
            CommonCallback commonCallback = this.f4762a;
            if (commonCallback != null) {
                commonCallback.onSuccess(str);
            }
        }
    }

    public a(Context context) {
        this.f4752a = context;
        g.a(context);
    }

    public String a() {
        return com.alibaba.sdk.android.ams.common.b.c.a().b();
    }

    public String a(Context context) {
        return UTDevice.getUtdid(context);
    }

    public void a(int i2) {
        MpsGlobalSetter.setNotificationSmallIconId(i2);
    }

    public void a(int i2, int i3, int i4, int i5, final CommonCallback commonCallback) {
        f4751b.d("setDoNotDisturb " + i2 + ":" + i3 + "-" + i4 + ":" + i5);
        TaobaoRegister.setDoNotDisturb(i2, i3, i4, i5, new c.a.a.a.a.a() { // from class: com.alibaba.sdk.android.push.a.a.1
            @Override // c.a.a.a.a.a
            public void onFailed(String str, String str2) {
                ErrorCode errorCodeBuild = com.alibaba.sdk.android.push.common.global.c.a(str, str2).build();
                commonCallback.onFailed(errorCodeBuild.getCode(), errorCodeBuild.getMsg());
            }

            @Override // c.a.a.a.a.a
            public void onSuccess(String str) {
                commonCallback.onSuccess(str);
            }
        });
    }

    public void a(int i2, CommonCallback commonCallback) {
        g.a().a(i2, commonCallback);
    }

    public void a(int i2, String[] strArr, String str, CommonCallback commonCallback) {
        g.a().a(i2, strArr, str, commonCallback);
    }

    public void a(Bitmap bitmap) {
        MpsGlobalSetter.setNotificationLargeIconBitmap(bitmap);
    }

    public void a(CommonCallback commonCallback) {
        g.a().a(commonCallback);
    }

    public void a(CPushMessage cPushMessage) {
        TaobaoRegister.clickMessage(CPushMessage.to(cPushMessage));
    }

    public void a(Class<?> cls) {
        TaobaoRegister.setPushMsgReceiveService(cls);
    }

    public void a(String str) {
        MpsGlobalSetter.setNotificationSoundPath(str);
    }

    public void a(String str, CommonCallback commonCallback) {
        g.a().a(str, commonCallback);
    }

    public void a(boolean z) {
        TaobaoRegister.setDoNotDisturbMode(z);
    }

    public void b() {
        TaobaoRegister.clearNotificationCreatedByAliyun(this.f4752a);
    }

    public void b(int i2, String[] strArr, String str, CommonCallback commonCallback) {
        g.a().b(i2, strArr, str, commonCallback);
    }

    public void b(Context context) {
        g.a().b(context);
    }

    public void b(CommonCallback commonCallback) {
        g.a().b(commonCallback);
    }

    public void b(CPushMessage cPushMessage) {
        TaobaoRegister.dismissMessage(CPushMessage.to(cPushMessage));
    }

    public void b(String str) {
        com.alibaba.sdk.android.ams.common.b.c.a().d(str);
    }

    public void b(String str, CommonCallback commonCallback) {
        g.a().b(str, commonCallback);
    }

    public void b(boolean z) {
        MpsGlobalSetter.setDebug(z);
    }

    public void c(CommonCallback commonCallback) {
        g.a().f(commonCallback);
    }

    public void c(String str) {
        com.alibaba.sdk.android.ams.common.b.c.a().e(str);
    }

    public void c(String str, CommonCallback commonCallback) {
        g.a().c(str, commonCallback);
    }

    public void d(CommonCallback commonCallback) {
        f(new AnonymousClass2(commonCallback));
    }

    public void d(String str, CommonCallback commonCallback) {
        g.a().d(str, commonCallback);
    }

    public void e(CommonCallback commonCallback) {
        f(new AnonymousClass3(commonCallback));
    }

    public void f(CommonCallback commonCallback) {
        g.a().c(commonCallback);
    }
}
