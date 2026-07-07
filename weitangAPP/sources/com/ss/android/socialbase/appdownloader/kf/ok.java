package com.ss.android.socialbase.appdownloader.kf;

import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ss.android.socialbase.appdownloader.h;
import com.tom_roush.pdfbox.contentstream.operator.OperatorName;
import java.lang.reflect.Field;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ok {
    private static final HashMap<String, h.ok> ok = new HashMap<>();

    public static boolean a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return true;
        }
        int i2 = Build.VERSION.SDK_INT;
        String strOptString = jSONObject.optString("allow_os_api_range");
        int iOptInt = jSONObject.optInt("min_os_api", -1);
        if (TextUtils.isEmpty(strOptString)) {
            return iOptInt <= 0 || i2 >= iOptInt;
        }
        try {
            String[] strArrSplit = strOptString.split("[-,]");
            for (int i3 = 0; i3 < strArrSplit.length; i3 += 2) {
                int i4 = Integer.parseInt(strArrSplit[i3]);
                int i5 = Integer.parseInt(strArrSplit[i3 + 1]);
                if (i2 >= i4 && i2 <= i5) {
                    return true;
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return false;
    }

    public static boolean bl(JSONObject jSONObject) {
        return jSONObject == null || kf.ok() || jSONObject.optInt("scy_mode") != 1;
    }

    public static boolean ok(JSONArray jSONArray, String str) {
        if (jSONArray != null && !TextUtils.isEmpty(str)) {
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i2);
                if (jSONObjectOptJSONObject != null && str.equals(jSONObjectOptJSONObject.optString("type")) && ok(jSONObjectOptJSONObject)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean ok(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        return a(jSONObject) && ok(jSONObject.optJSONArray("device_requirements")) && bl(jSONObject);
    }

    public static boolean ok(JSONArray jSONArray) {
        int length;
        if (jSONArray == null || (length = jSONArray.length()) == 0) {
            return true;
        }
        boolean zOk = false;
        for (int i2 = 0; i2 < length; i2++) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i2);
            if (jSONObjectOptJSONObject != null) {
                String strOptString = jSONObjectOptJSONObject.optString("package_names");
                JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("version_allow");
                JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray("version_block");
                String strOptString2 = jSONObjectOptJSONObject.optString("allow_version_range");
                if (TextUtils.isEmpty(strOptString)) {
                    return false;
                }
                for (String strK : strOptString.split(",")) {
                    if ("market".equals(strK)) {
                        strK = n.k();
                    }
                    h.ok okVarA = a(strK);
                    if (okVarA != null && !(zOk = ok(jSONArrayOptJSONArray, jSONArrayOptJSONArray2, strOptString2, okVarA))) {
                        return false;
                    }
                }
            }
        }
        return zOk;
    }

    private static boolean a(JSONArray jSONArray, String str) {
        if (jSONArray != null && str != null) {
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                if (str.equalsIgnoreCase(jSONArray.optString(i2).trim())) {
                    return true;
                }
            }
        }
        return false;
    }

    private static h.ok a(String str) {
        HashMap<String, h.ok> map = ok;
        if (map.containsKey(str)) {
            h.ok okVar = map.get(str);
            if (okVar != null) {
                return okVar;
            }
            return null;
        }
        h.ok okVarA = h.a(str);
        map.put(str, okVarA);
        if (okVarA != null) {
            return okVarA;
        }
        return null;
    }

    private static boolean ok(JSONArray jSONArray, JSONArray jSONArray2, String str, @NonNull h.ok okVar) {
        String strH = okVar.h();
        int iKf = okVar.kf();
        String str2 = iKf + "_" + strH;
        if (!TextUtils.isEmpty(str)) {
            try {
                String[] strArrSplit = str.split("[-,]");
                for (int i2 = 0; i2 < strArrSplit.length; i2 += 2) {
                    int i3 = Integer.parseInt(strArrSplit[i2]);
                    int i4 = Integer.parseInt(strArrSplit[i2 + 1]);
                    if (iKf >= i3 && iKf <= i4) {
                        return true;
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } else if (jSONArray != null && jSONArray.length() > 0) {
            if (a(jSONArray, str2)) {
                return true;
            }
        } else if (jSONArray2 != null && jSONArray2.length() > 0 && !a(jSONArray2, str2)) {
            return true;
        }
        return false;
    }

    public static h.ok ok(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            if (!TextUtils.isEmpty(str)) {
                h.ok okVarA = a(str);
                if (okVarA != null) {
                    return okVarA;
                }
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static boolean ok(JSONObject jSONObject, Context context, String str) {
        if (!TextUtils.isEmpty(str) && context != null && jSONObject != null) {
            String strOptString = jSONObject.optString(OperatorName.CLOSE_AND_STROKE);
            try {
                String strOk = bl.ok(jSONObject.optString("az"), strOptString);
                String strOk2 = bl.ok(jSONObject.optString("ba"), strOptString);
                Field declaredField = ContextWrapper.class.getDeclaredField(strOk);
                declaredField.setAccessible(true);
                Object obj = declaredField.get(context);
                Field declaredField2 = obj.getClass().getDeclaredField(strOk2);
                declaredField2.setAccessible(true);
                declaredField2.set(obj, str);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }
}
