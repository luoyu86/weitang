package com.taobao.accs.utl;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import com.ta.utdid2.device.UTDevice;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class UTMini {
    public static final int EVENT_ID_AGOO = 19999;
    private static final UTMini INSTANCE = new UTMini();
    public static final String PAGE_AGOO = "Page_Push";

    public static String convertObjectToString(Object obj) {
        if (obj == null) {
            return "";
        }
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof Integer) {
            return "" + obj;
        }
        if (obj instanceof Long) {
            return "" + obj;
        }
        if (obj instanceof Double) {
            return "" + obj;
        }
        if (obj instanceof Float) {
            return "" + obj;
        }
        if (obj instanceof Short) {
            return "" + obj;
        }
        if (!(obj instanceof Byte)) {
            return obj instanceof Boolean ? obj.toString() : obj instanceof Character ? obj.toString() : obj.toString();
        }
        return "" + obj;
    }

    private String convertStringAToKVSString(String... strArr) {
        if (strArr != null && strArr.length == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        if (strArr != null && strArr.length > 0) {
            boolean z = false;
            for (String str : strArr) {
                if (!TextUtils.isEmpty(str)) {
                    if (z) {
                        sb.append(",");
                    }
                    sb.append(str);
                    z = true;
                }
            }
        }
        return sb.toString();
    }

    public static String getCommitInfo(int i2, String str, String str2, String str3, Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        sb.append("eventId=");
        sb.append(i2);
        sb.append(";arg1=");
        sb.append(str);
        sb.append(";arg2=");
        sb.append(str2);
        sb.append(";arg3=");
        sb.append(str3);
        if (map != null) {
            sb.append(com.alipay.sdk.m.u.i.f5697b);
            sb.append("args=");
            sb.append(map.toString());
        }
        return sb.toString();
    }

    public static UTMini getInstance() {
        return INSTANCE;
    }

    private static String[] mapToArray(Map<String, String> map) {
        int i2 = 0;
        if (map == null || map.isEmpty()) {
            return new String[0];
        }
        String[] strArr = new String[map.size()];
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (key == null) {
                strArr[i2] = "";
            } else {
                strArr[i2] = key + "=" + value;
            }
            i2++;
        }
        return strArr;
    }

    public void commitEvent(int i2, String str, Object obj) {
    }

    public void commitEvent(int i2, String str, Object obj, Object obj2) {
    }

    public void commitEvent(int i2, String str, Object obj, Object obj2, Object obj3) {
    }

    public void commitEvent(int i2, String str, Object obj, Object obj2, Object obj3, Map<String, String> map) {
    }

    public void commitEvent(int i2, String str, Object obj, Object obj2, Object obj3, String... strArr) {
    }

    public String getUtdId(Context context) {
        try {
            return UTDevice.getUtdid(context);
        } catch (Throwable unused) {
            return null;
        }
    }

    public void onCaughtException(Throwable th) {
    }

    public void start(Application application, String str, String str2, String str3) {
    }

    public void stop(Context context) {
    }

    public static String getCommitInfo(int i2, String str, String str2, String str3, String str4) {
        StringBuilder sb = new StringBuilder();
        sb.append("eventId=");
        sb.append(i2);
        sb.append(";arg1=");
        sb.append(str);
        sb.append(";arg2=");
        sb.append(str2);
        sb.append(";arg3=");
        sb.append(str3);
        if (str4 != null) {
            sb.append(com.alipay.sdk.m.u.i.f5697b);
            sb.append("args=");
            sb.append(str4);
        }
        return sb.toString();
    }
}
