package com.alibaba.sdk.android.push.e;

import android.content.Context;
import com.alibaba.sdk.android.ams.common.logger.AmsLogger;
import com.alibaba.sdk.android.ams.common.util.StringUtil;
import com.alibaba.sdk.android.error.ErrorCode;
import com.alibaba.sdk.android.push.CommonCallback;
import com.alibaba.sdk.android.push.e.f;
import com.taobao.accs.common.Constants;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final AmsLogger f4947a = AmsLogger.getLogger("MPS:VipRequestManager");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static g f4948b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Context f4949c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final f f4950d = new f();

    private g() {
    }

    public static g a() {
        if (f4948b == null) {
            f4948b = new g();
        }
        return f4948b;
    }

    private String a(int i2) {
        f.a aVarA = this.f4950d.a(i2);
        if (aVarA == null) {
            return null;
        }
        return aVarA.a();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private Map<String, String> a(String str, String str2, String[] strArr, Map<String, String> map) throws com.alibaba.sdk.android.push.a.c {
        int i2;
        String str3;
        str.hashCode();
        switch (str) {
            case "account":
                String strF = f();
                if (StringUtil.isEmpty(strF)) {
                    throw new com.alibaba.sdk.android.push.a.c("account is empty");
                }
                map.put("account", strF);
                return map;
            case "tags":
                if (strArr == null) {
                    throw new com.alibaba.sdk.android.push.a.c("tags array is empty");
                }
                StringBuilder sb = new StringBuilder();
                for (i2 = 0; i2 < strArr.length; i2++) {
                    if (i2 != strArr.length - 1 && !StringUtil.isEmpty(strArr[i2])) {
                        sb.append(strArr[i2]);
                        str3 = ",";
                    } else if (i2 == strArr.length - 1 && !StringUtil.isEmpty(strArr[i2])) {
                        str3 = strArr[i2];
                    }
                    sb.append(str3);
                }
                if (StringUtil.isEmpty(sb.toString())) {
                    throw new com.alibaba.sdk.android.push.a.c("tags array is empty");
                }
                map.put("tags", sb.toString());
                return map;
            case "alias":
                if (StringUtil.isEmpty(str2)) {
                    throw new com.alibaba.sdk.android.push.a.c("alias is empty");
                }
                map.put("alias", str2);
                return map;
            case "deviceId":
                String strE = e();
                if (StringUtil.isEmpty(strE)) {
                    throw new com.alibaba.sdk.android.push.a.c("deviceId is empty.");
                }
                map.put("deviceId", strE);
                return map;
            default:
                return map;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, String str) {
        this.f4950d.a(i2, str);
    }

    public static void a(Context context) {
        f4949c = context;
        if (f4948b == null) {
            f4948b = a();
        }
    }

    private void a(com.alibaba.sdk.android.push.a.c cVar, String str, CommonCallback commonCallback) {
        a((Throwable) cVar, str, commonCallback);
    }

    private void a(com.alibaba.sdk.android.push.a.d dVar, String str, CommonCallback commonCallback) {
        a((Throwable) dVar, str, commonCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        com.alibaba.sdk.android.ams.common.b.c.a().a("mps_account", str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, long j) {
        com.alibaba.sdk.android.push.c.a aVarA = com.alibaba.sdk.android.push.c.a.a();
        com.alibaba.sdk.android.ams.common.b.b bVarA = com.alibaba.sdk.android.ams.common.b.c.a();
        if (aVarA == null || bVarA == null) {
            return;
        }
        aVarA.a(str, bVarA.b(), j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, String str3) {
        com.alibaba.sdk.android.push.c.a aVarA = com.alibaba.sdk.android.push.c.a.a();
        com.alibaba.sdk.android.ams.common.b.b bVarA = com.alibaba.sdk.android.ams.common.b.c.a();
        if (aVarA == null || bVarA == null) {
            return;
        }
        aVarA.a(str, str2, bVarA.b(), str3);
    }

    private void a(Throwable th, String str, CommonCallback commonCallback) {
        ErrorCode errorCodeBuild = com.alibaba.sdk.android.push.common.global.c.f4884q.copy().msg(th.getMessage()).build();
        f4947a.e(str + " Fail: errorCode:" + errorCodeBuild, th);
        if (commonCallback != null) {
            commonCallback.onFailed(errorCodeBuild.getCode(), errorCodeBuild.getMsg());
        }
        a(errorCodeBuild.getCode(), errorCodeBuild.getMsg(), str);
    }

    private static boolean c(Context context) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(com.alibaba.sdk.android.push.common.util.b.a(context, "KEY_LAUNCH_MARK"));
        Calendar calendar2 = Calendar.getInstance();
        return calendar.get(6) == calendar2.get(6) && calendar.get(1) == calendar2.get(1);
    }

    private String e() {
        return com.alibaba.sdk.android.ams.common.b.c.a().b();
    }

    private String f() {
        return com.alibaba.sdk.android.ams.common.b.c.a().c("mps_account");
    }

    private Map<String, String> g() {
        String strB = b();
        HashMap map = new HashMap();
        map.put(Constants.KEY_APP_KEY, strB);
        map.put("os", "2");
        map.put("version", "3.10.1");
        return map;
    }

    public void a(final int i2, final CommonCallback commonCallback) {
        String strA;
        final long jCurrentTimeMillis = System.currentTimeMillis();
        AmsLogger amsLogger = f4947a;
        amsLogger.d("listTags");
        if (1 == i2 && (strA = a(2)) != null) {
            amsLogger.d("get from cache");
            if (commonCallback != null) {
                commonCallback.onSuccess(strA);
                return;
            }
            return;
        }
        try {
            h hVar = new h(f4949c, "https://" + com.alibaba.sdk.android.ams.common.a.a.c() + "/list-tag", new CommonCallback() { // from class: com.alibaba.sdk.android.push.e.g.10
                @Override // com.alibaba.sdk.android.push.CommonCallback
                public void onFailed(String str, String str2) {
                    g.this.a(str, str2, "/list-tag");
                    CommonCallback commonCallback2 = commonCallback;
                    if (commonCallback2 != null) {
                        commonCallback2.onFailed(str, str2);
                    }
                }

                @Override // com.alibaba.sdk.android.push.CommonCallback
                public void onSuccess(String str) {
                    g.this.a("/list-tag", System.currentTimeMillis() - jCurrentTimeMillis);
                    if (1 == i2) {
                        g.f4947a.d("store cache");
                        g.this.a(2, str);
                    }
                    CommonCallback commonCallback2 = commonCallback;
                    if (commonCallback2 != null) {
                        commonCallback2.onSuccess(str);
                    }
                }
            });
            Map<String, String> mapG = g();
            if (i2 != 1) {
                throw new com.alibaba.sdk.android.push.a.d("target is invalid.");
            }
            Map<String, String> mapA = a("deviceId", (String) null, (String[]) null, mapG);
            mapA.put(Constants.KEY_TARGET, String.valueOf(i2));
            mapA.put("VipRequestType", com.alibaba.sdk.android.push.common.util.a.d.LIST_TAGS.a() + "");
            hVar.execute(mapA);
        } catch (com.alibaba.sdk.android.push.a.c e2) {
            a(e2, "/list-tag", commonCallback);
        } catch (com.alibaba.sdk.android.push.a.d e3) {
            a(e3, "/list-tag", commonCallback);
        }
    }

    public void a(int i2, String[] strArr, String str, final CommonCallback commonCallback) {
        Map<String, String> mapA;
        String str2;
        final long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            h hVar = new h(f4949c, "https://" + com.alibaba.sdk.android.ams.common.a.a.c() + "/bind-tag", new CommonCallback() { // from class: com.alibaba.sdk.android.push.e.g.8
                @Override // com.alibaba.sdk.android.push.CommonCallback
                public void onFailed(String str3, String str4) {
                    g.this.a(str3, str4, "/bind-tag");
                    CommonCallback commonCallback2 = commonCallback;
                    if (commonCallback2 != null) {
                        commonCallback2.onFailed(str3, str4);
                    }
                }

                @Override // com.alibaba.sdk.android.push.CommonCallback
                public void onSuccess(String str3) {
                    g.this.a("/bind-tag", System.currentTimeMillis() - jCurrentTimeMillis);
                    CommonCallback commonCallback2 = commonCallback;
                    if (commonCallback2 != null) {
                        commonCallback2.onSuccess(str3);
                    }
                }
            });
            if (strArr == null || strArr.length == 0) {
                throw new com.alibaba.sdk.android.push.a.d("tags is empty.");
            }
            Map<String, String> mapG = g();
            if (i2 == 1) {
                f4947a.d("Binding tag to device.");
                mapA = a("deviceId", (String) null, (String[]) null, mapG);
                str2 = com.alibaba.sdk.android.push.common.util.a.d.BIND_TAG_TO_DEVICE.a() + "";
            } else if (i2 == 2) {
                f4947a.d("Binding tag to account.");
                mapA = a("account", (String) null, (String[]) null, mapG);
                str2 = com.alibaba.sdk.android.push.common.util.a.d.BIND_TAG_TO_ACCOUNT.a() + "";
            } else {
                if (i2 != 3) {
                    throw new com.alibaba.sdk.android.push.a.d("target is invalid.");
                }
                mapA = a("alias", str, (String[]) null, mapG);
                str2 = com.alibaba.sdk.android.push.common.util.a.d.BIND_TAG_TO_ALIAS.a() + "";
            }
            mapA.put("VipRequestType", str2);
            Map<String, String> mapA2 = a("tags", (String) null, strArr, mapA);
            mapA2.put(Constants.KEY_TARGET, String.valueOf(i2));
            hVar.execute(mapA2);
        } catch (com.alibaba.sdk.android.push.a.c e2) {
            a(e2, "/bind-tag", commonCallback);
        } catch (com.alibaba.sdk.android.push.a.d e3) {
            a(e3, "/bind-tag", commonCallback);
        }
    }

    public void a(final CommonCallback commonCallback) {
        f4947a.d("unbinding account");
        final long jCurrentTimeMillis = System.currentTimeMillis();
        h hVar = new h(f4949c, "https://" + com.alibaba.sdk.android.ams.common.a.a.c() + "/unbind-account", new CommonCallback() { // from class: com.alibaba.sdk.android.push.e.g.7
            @Override // com.alibaba.sdk.android.push.CommonCallback
            public void onFailed(String str, String str2) {
                g.this.a(str, str2, "/unbind-account");
                CommonCallback commonCallback2 = commonCallback;
                if (commonCallback2 != null) {
                    commonCallback2.onFailed(str, str2);
                }
            }

            @Override // com.alibaba.sdk.android.push.CommonCallback
            public void onSuccess(String str) {
                g.this.a("");
                g.this.a("/unbind-account", System.currentTimeMillis() - jCurrentTimeMillis);
                CommonCallback commonCallback2 = commonCallback;
                if (commonCallback2 != null) {
                    commonCallback2.onSuccess(str);
                }
            }
        });
        try {
            Map<String, String> mapG = g();
            mapG.put("account", "");
            mapG.put("VipRequestType", String.valueOf(com.alibaba.sdk.android.push.common.util.a.d.UNBIND_ACCOUNT.a()));
            hVar.execute(a("deviceId", (String) null, (String[]) null, mapG));
        } catch (com.alibaba.sdk.android.push.a.c e2) {
            a(e2, "/unbind-account", commonCallback);
        }
    }

    public void a(final String str, final CommonCallback commonCallback) {
        f4947a.d("binding account" + str);
        final long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            h hVar = new h(f4949c, "https://" + com.alibaba.sdk.android.ams.common.a.a.c() + "/bind-account", new CommonCallback() { // from class: com.alibaba.sdk.android.push.e.g.1
                @Override // com.alibaba.sdk.android.push.CommonCallback
                public void onFailed(String str2, String str3) {
                    g.this.a(str2, str3, "/bind-account");
                    CommonCallback commonCallback2 = commonCallback;
                    if (commonCallback2 != null) {
                        commonCallback2.onFailed(str2, str3);
                    }
                }

                @Override // com.alibaba.sdk.android.push.CommonCallback
                public void onSuccess(String str2) {
                    g.this.a(str);
                    g.this.a("/bind-account", System.currentTimeMillis() - jCurrentTimeMillis);
                    CommonCallback commonCallback2 = commonCallback;
                    if (commonCallback2 != null) {
                        commonCallback2.onSuccess(str2);
                    }
                }
            });
            Map<String, String> mapG = g();
            if (StringUtil.isEmpty(str)) {
                throw new com.alibaba.sdk.android.push.a.d("account input is empty!");
            }
            mapG.put("account", str);
            mapG.put("VipRequestType", String.valueOf(com.alibaba.sdk.android.push.common.util.a.d.BIND_ACCOUNT.a()));
            hVar.execute(a("deviceId", (String) null, (String[]) null, mapG));
        } catch (com.alibaba.sdk.android.push.a.c e2) {
            a(e2, "/bind-account", commonCallback);
        } catch (com.alibaba.sdk.android.push.a.d e3) {
            a(e3, "/bind-account", commonCallback);
        }
    }

    public String b() {
        return com.alibaba.sdk.android.ams.common.b.c.a().a();
    }

    public void b(int i2, String[] strArr, String str, final CommonCallback commonCallback) {
        Map<String, String> mapA;
        String str2;
        final long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            h hVar = new h(f4949c, "https://" + com.alibaba.sdk.android.ams.common.a.a.c() + "/unbind-tag", new CommonCallback() { // from class: com.alibaba.sdk.android.push.e.g.9
                @Override // com.alibaba.sdk.android.push.CommonCallback
                public void onFailed(String str3, String str4) {
                    g.this.a(str3, str4, "/unbind-tag");
                    CommonCallback commonCallback2 = commonCallback;
                    if (commonCallback2 != null) {
                        commonCallback2.onFailed(str3, str4);
                    }
                }

                @Override // com.alibaba.sdk.android.push.CommonCallback
                public void onSuccess(String str3) {
                    if (commonCallback != null) {
                        g.this.a("/unbind-tag", System.currentTimeMillis() - jCurrentTimeMillis);
                        commonCallback.onSuccess(str3);
                    }
                }
            });
            Map<String, String> mapG = g();
            if (i2 == 1) {
                f4947a.d("Unbinding tag from device.");
                mapA = a("deviceId", (String) null, (String[]) null, mapG);
                str2 = com.alibaba.sdk.android.push.common.util.a.d.UNBIND_TAG_TO_DEVICE.a() + "";
            } else if (i2 == 2) {
                f4947a.d("Unbinding tag from account.");
                mapA = a("account", (String) null, (String[]) null, mapG);
                str2 = com.alibaba.sdk.android.push.common.util.a.d.UNBIND_TAG_TO_ACCOUNT.a() + "";
            } else {
                if (i2 != 3) {
                    throw new com.alibaba.sdk.android.push.a.d("target is invalid.");
                }
                f4947a.d("Unbinding tag from alias.");
                mapA = a("alias", str, (String[]) null, mapG);
                str2 = com.alibaba.sdk.android.push.common.util.a.d.UNBIND_TAG_TO_ALIAS.a() + "";
            }
            mapA.put("VipRequestType", str2);
            Map<String, String> mapA2 = a("tags", (String) null, strArr, mapA);
            mapA2.put(Constants.KEY_TARGET, String.valueOf(i2));
            hVar.execute(mapA2);
        } catch (com.alibaba.sdk.android.push.a.c e2) {
            a(e2, "/unbind-tag", commonCallback);
        } catch (com.alibaba.sdk.android.push.a.d e3) {
            a(e3, "/unbind-tag", commonCallback);
        }
    }

    public void b(Context context) {
        if (c(context)) {
            f4947a.e("onAppStart has already sent today");
            return;
        }
        f4947a.d("onAppStart");
        h hVar = new h(f4949c, "https://" + com.alibaba.sdk.android.ams.common.a.a.c() + "/active", new CommonCallback() { // from class: com.alibaba.sdk.android.push.e.g.6
            @Override // com.alibaba.sdk.android.push.CommonCallback
            public void onFailed(String str, String str2) {
                g.f4947a.e("onAppStart failed. errorCode:" + str + " errorMsg:" + str2);
            }

            @Override // com.alibaba.sdk.android.push.CommonCallback
            public void onSuccess(String str) {
                g.f4947a.d("onAppStart success");
                try {
                    com.alibaba.sdk.android.push.common.util.b.a(g.f4949c, "KEY_LAUNCH_MARK", System.currentTimeMillis());
                } catch (Throwable th) {
                    g.f4947a.e("onAppStart success", th);
                }
            }
        });
        try {
            Map<String, String> mapG = g();
            mapG.put("VipRequestType", String.valueOf(com.alibaba.sdk.android.push.common.util.a.d.ON_APP_START.a()));
            hVar.execute(a("deviceId", (String) null, (String[]) null, mapG));
        } catch (com.alibaba.sdk.android.push.a.c e2) {
            a(e2, "/active", (CommonCallback) null);
        }
    }

    public void b(final CommonCallback commonCallback) {
        final long jCurrentTimeMillis = System.currentTimeMillis();
        AmsLogger amsLogger = f4947a;
        amsLogger.d("listAliases");
        String strA = a(1);
        if (strA != null) {
            amsLogger.d("get from cache");
            if (commonCallback != null) {
                commonCallback.onSuccess(strA);
                return;
            }
            return;
        }
        try {
            h hVar = new h(f4949c, "https://" + com.alibaba.sdk.android.ams.common.a.a.c() + "/list-alias", new CommonCallback() { // from class: com.alibaba.sdk.android.push.e.g.13
                @Override // com.alibaba.sdk.android.push.CommonCallback
                public void onFailed(String str, String str2) {
                    g.this.a(str, str2, "/list-alias");
                    CommonCallback commonCallback2 = commonCallback;
                    if (commonCallback2 != null) {
                        commonCallback2.onFailed(str, str2);
                    }
                }

                @Override // com.alibaba.sdk.android.push.CommonCallback
                public void onSuccess(String str) {
                    g.f4947a.d("store cache");
                    g.this.a(1, str);
                    g.this.a("/list-alias", System.currentTimeMillis() - jCurrentTimeMillis);
                    CommonCallback commonCallback2 = commonCallback;
                    if (commonCallback2 != null) {
                        commonCallback2.onSuccess(str);
                    }
                }
            });
            Map<String, String> mapG = g();
            mapG.put("VipRequestType", com.alibaba.sdk.android.push.common.util.a.d.LIST_ALIASES.a() + "");
            hVar.execute(a("deviceId", (String) null, (String[]) null, mapG));
        } catch (com.alibaba.sdk.android.push.a.c e2) {
            a(e2, "/list-alias", commonCallback);
        }
    }

    public void b(String str, final CommonCallback commonCallback) {
        final long jCurrentTimeMillis = System.currentTimeMillis();
        f4947a.d("Adding alias to device");
        try {
            h hVar = new h(f4949c, "https://" + com.alibaba.sdk.android.ams.common.a.a.c() + "/add-alias", new CommonCallback() { // from class: com.alibaba.sdk.android.push.e.g.11
                @Override // com.alibaba.sdk.android.push.CommonCallback
                public void onFailed(String str2, String str3) {
                    g.this.a(str2, str3, "/add-alias");
                    CommonCallback commonCallback2 = commonCallback;
                    if (commonCallback2 != null) {
                        commonCallback2.onFailed(str2, str3);
                    }
                }

                @Override // com.alibaba.sdk.android.push.CommonCallback
                public void onSuccess(String str2) {
                    g.this.a("/add-alias", System.currentTimeMillis() - jCurrentTimeMillis);
                    CommonCallback commonCallback2 = commonCallback;
                    if (commonCallback2 != null) {
                        commonCallback2.onSuccess(str2);
                    }
                }
            });
            Map<String, String> mapA = a("alias", str, (String[]) null, a("deviceId", (String) null, (String[]) null, g()));
            mapA.put("VipRequestType", String.valueOf(com.alibaba.sdk.android.push.common.util.a.d.BIND_ALIAS.a()));
            hVar.execute(mapA);
        } catch (com.alibaba.sdk.android.push.a.c e2) {
            a(e2, "/add-alias", commonCallback);
        }
    }

    public void c(final CommonCallback commonCallback) {
        f4947a.d("check vip push status");
        final long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            h hVar = new h(f4949c, "https://" + com.alibaba.sdk.android.ams.common.a.a.c() + "/push-status", new CommonCallback() { // from class: com.alibaba.sdk.android.push.e.g.14
                @Override // com.alibaba.sdk.android.push.CommonCallback
                public void onFailed(String str, String str2) {
                    g.this.a(str, str2, "/push-status");
                    CommonCallback commonCallback2 = commonCallback;
                    if (commonCallback2 != null) {
                        commonCallback2.onFailed(str, str2);
                    }
                }

                @Override // com.alibaba.sdk.android.push.CommonCallback
                public void onSuccess(String str) {
                    g.this.a("/push-status", System.currentTimeMillis() - jCurrentTimeMillis);
                    CommonCallback commonCallback2 = commonCallback;
                    if (commonCallback2 != null) {
                        commonCallback2.onSuccess(str);
                    }
                }
            });
            Map<String, String> mapA = a("deviceId", (String) null, (String[]) null, g());
            mapA.put("VipRequestType", String.valueOf(com.alibaba.sdk.android.push.common.util.a.d.CHECK_PUSH_STATUS.a()));
            hVar.execute(mapA);
        } catch (com.alibaba.sdk.android.push.a.c e2) {
            a(e2, "/push-status", commonCallback);
        }
    }

    public void c(String str, final CommonCallback commonCallback) {
        final long jCurrentTimeMillis = System.currentTimeMillis();
        f4947a.d("Removing alias from device");
        try {
            h hVar = new h(f4949c, "https://" + com.alibaba.sdk.android.ams.common.a.a.c() + "/remove-alias", new CommonCallback() { // from class: com.alibaba.sdk.android.push.e.g.12
                @Override // com.alibaba.sdk.android.push.CommonCallback
                public void onFailed(String str2, String str3) {
                    g.this.a(str2, str3, "/remove-alias");
                    CommonCallback commonCallback2 = commonCallback;
                    if (commonCallback2 != null) {
                        commonCallback2.onFailed(str2, str3);
                    }
                }

                @Override // com.alibaba.sdk.android.push.CommonCallback
                public void onSuccess(String str2) {
                    g.this.a("/remove-alias", System.currentTimeMillis() - jCurrentTimeMillis);
                    CommonCallback commonCallback2 = commonCallback;
                    if (commonCallback2 != null) {
                        commonCallback2.onSuccess(str2);
                    }
                }
            });
            Map<String, String> mapA = a("deviceId", (String) null, (String[]) null, g());
            if (StringUtil.isEmpty(str)) {
                str = "";
            }
            mapA.put("alias", str);
            mapA.put("VipRequestType", String.valueOf(com.alibaba.sdk.android.push.common.util.a.d.UNBIND_ALIAS.a()));
            hVar.execute(mapA);
        } catch (com.alibaba.sdk.android.push.a.c e2) {
            a(e2, "/remove-alias", commonCallback);
        }
    }

    public void d(final CommonCallback commonCallback) {
        final long jCurrentTimeMillis = System.currentTimeMillis();
        f4947a.d("unbinding vip");
        try {
            h hVar = new h(f4949c, "https://" + com.alibaba.sdk.android.ams.common.a.a.c() + "/push-switch", new CommonCallback() { // from class: com.alibaba.sdk.android.push.e.g.2
                @Override // com.alibaba.sdk.android.push.CommonCallback
                public void onFailed(String str, String str2) {
                    g.this.a(str, str2, "/push-switch");
                    CommonCallback commonCallback2 = commonCallback;
                    if (commonCallback2 != null) {
                        commonCallback2.onFailed(str, str2);
                    }
                }

                @Override // com.alibaba.sdk.android.push.CommonCallback
                public void onSuccess(String str) {
                    g.this.a("/push-switch", System.currentTimeMillis() - jCurrentTimeMillis);
                    CommonCallback commonCallback2 = commonCallback;
                    if (commonCallback2 != null) {
                        commonCallback2.onSuccess(str);
                    }
                }
            });
            Map<String, String> mapA = a("deviceId", (String) null, (String[]) null, g());
            mapA.put("VipRequestType", String.valueOf(com.alibaba.sdk.android.push.common.util.a.d.TURN_OFF_PUSH.a()));
            mapA.put("enable", "false");
            hVar.execute(mapA);
        } catch (com.alibaba.sdk.android.push.a.c e2) {
            a(e2, "/push-switch false", commonCallback);
        }
    }

    public void d(String str, final CommonCallback commonCallback) {
        f4947a.d("binding phoneNumber:" + str);
        final long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            h hVar = new h(f4949c, "https://" + com.alibaba.sdk.android.ams.common.a.a.c() + "/set-phone", new CommonCallback() { // from class: com.alibaba.sdk.android.push.e.g.4
                @Override // com.alibaba.sdk.android.push.CommonCallback
                public void onFailed(String str2, String str3) {
                    g.this.a(str2, str3, "/set-phone");
                    CommonCallback commonCallback2 = commonCallback;
                    if (commonCallback2 != null) {
                        commonCallback2.onFailed(str2, str3);
                    }
                }

                @Override // com.alibaba.sdk.android.push.CommonCallback
                public void onSuccess(String str2) {
                    g.this.a("/set-phone", System.currentTimeMillis() - jCurrentTimeMillis);
                    CommonCallback commonCallback2 = commonCallback;
                    if (commonCallback2 != null) {
                        commonCallback2.onSuccess(str2);
                    }
                }
            });
            Map<String, String> mapG = g();
            if (StringUtil.isEmpty(str)) {
                throw new com.alibaba.sdk.android.push.a.d("account input is empty!");
            }
            mapG.put("mob", str);
            mapG.put("VipRequestType", String.valueOf(com.alibaba.sdk.android.push.common.util.a.d.BIND_PHONE_NUMBER.a()));
            hVar.execute(a("deviceId", (String) null, (String[]) null, mapG));
        } catch (com.alibaba.sdk.android.push.a.c e2) {
            a(e2, "/set-phone", commonCallback);
        } catch (com.alibaba.sdk.android.push.a.d e3) {
            a(e3, "/set-phone", commonCallback);
        }
    }

    public void e(final CommonCallback commonCallback) {
        final long jCurrentTimeMillis = System.currentTimeMillis();
        f4947a.d("binding vip push");
        try {
            h hVar = new h(f4949c, "https://" + com.alibaba.sdk.android.ams.common.a.a.c() + "/push-switch", new CommonCallback() { // from class: com.alibaba.sdk.android.push.e.g.3
                @Override // com.alibaba.sdk.android.push.CommonCallback
                public void onFailed(String str, String str2) {
                    g.this.a(str, str2, "/push-switch");
                    CommonCallback commonCallback2 = commonCallback;
                    if (commonCallback2 != null) {
                        commonCallback2.onFailed(str, str2);
                    }
                }

                @Override // com.alibaba.sdk.android.push.CommonCallback
                public void onSuccess(String str) {
                    g.this.a("/push-switch", System.currentTimeMillis() - jCurrentTimeMillis);
                    CommonCallback commonCallback2 = commonCallback;
                    if (commonCallback2 != null) {
                        commonCallback2.onSuccess(str);
                    }
                }
            });
            Map<String, String> mapA = a("deviceId", (String) null, (String[]) null, g());
            mapA.put("VipRequestType", String.valueOf(com.alibaba.sdk.android.push.common.util.a.d.TURN_ON_PUSH.a()));
            mapA.put("enable", "true");
            hVar.execute(mapA);
        } catch (com.alibaba.sdk.android.push.a.c e2) {
            a(e2, "/push-switch true", commonCallback);
        }
    }

    public void f(final CommonCallback commonCallback) {
        final long jCurrentTimeMillis = System.currentTimeMillis();
        f4947a.d("unbinding phone number");
        h hVar = new h(f4949c, "https://" + com.alibaba.sdk.android.ams.common.a.a.c() + "/unset-phone", new CommonCallback() { // from class: com.alibaba.sdk.android.push.e.g.5
            @Override // com.alibaba.sdk.android.push.CommonCallback
            public void onFailed(String str, String str2) {
                g.this.a(str, str2, "/unset-phone");
                CommonCallback commonCallback2 = commonCallback;
                if (commonCallback2 != null) {
                    commonCallback2.onFailed(str, str2);
                }
            }

            @Override // com.alibaba.sdk.android.push.CommonCallback
            public void onSuccess(String str) {
                g.this.a("/unset-phone", System.currentTimeMillis() - jCurrentTimeMillis);
                CommonCallback commonCallback2 = commonCallback;
                if (commonCallback2 != null) {
                    commonCallback2.onSuccess(str);
                }
            }
        });
        try {
            Map<String, String> mapG = g();
            mapG.put("VipRequestType", String.valueOf(com.alibaba.sdk.android.push.common.util.a.d.UNBIND_PHONE_NUMBER.a()));
            hVar.execute(a("deviceId", (String) null, (String[]) null, mapG));
        } catch (com.alibaba.sdk.android.push.a.c e2) {
            a(e2, "/unset-phone", commonCallback);
        }
    }
}
