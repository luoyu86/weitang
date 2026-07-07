package com.taobao.agoo.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.taobao.accs.AccsClientConfig;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.UtilityImpl;
import com.tom_roush.pdfbox.contentstream.operator.OperatorName;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.android.agoo.common.Config;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    public static final String SP_AGOO_BIND_FILE_NAME = "EMAS_AGOO_BIND";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ConcurrentMap<String, Integer> f10497a = new ConcurrentHashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f10498b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Context f10499c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f10500d;

    public a(Context context) {
        if (context == null) {
            throw new RuntimeException("Context is null!!");
        }
        this.f10499c = context.getApplicationContext();
        StringBuilder sb = new StringBuilder();
        try {
            sb.append("EMAS_AGOO_BIND");
            sb.append(Config.d(context));
            sb.append(AccsClientConfig.getConfigByTag(Config.d(context)).getInappHost());
            this.f10500d = sb.toString();
        } catch (Throwable unused) {
        }
    }

    public void a(String str) {
        Integer num = this.f10497a.get(str);
        if (num == null || num.intValue() != 2) {
            this.f10497a.put(str, 2);
            a(this.f10499c, this.f10500d, this.f10498b, this.f10497a);
        }
    }

    public boolean b(String str) {
        if (this.f10497a.isEmpty()) {
            b();
        }
        Integer num = this.f10497a.get(str);
        ALog.i("AgooBindCache", "isAgooRegistered", "packageName", str, "appStatus", num, "agooBindStatus", this.f10497a);
        return (UtilityImpl.utdidChanged(Config.PREFERENCES, this.f10499c) || num == null || num.intValue() != 2) ? false : true;
    }

    private void a(Context context, String str, long j, Map<String, Integer> map) {
        try {
            String[] strArr = (String[]) map.keySet().toArray(new String[0]);
            JSONArray jSONArray = new JSONArray();
            if (j > 0 && j < System.currentTimeMillis()) {
                jSONArray.put(j);
            } else {
                jSONArray.put(System.currentTimeMillis() - (Math.random() * 8.64E7d));
            }
            for (String str2 : strArr) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("p", str2);
                jSONObject.put(OperatorName.CLOSE_AND_STROKE, map.get(str2).intValue());
                jSONArray.put(jSONObject);
            }
            SharedPreferences.Editor editorEdit = context.getSharedPreferences(str, 0).edit();
            editorEdit.putString("bind_status", jSONArray.toString());
            editorEdit.apply();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void b() {
        try {
            String string = this.f10499c.getSharedPreferences(this.f10500d, 0).getString("bind_status", null);
            if (TextUtils.isEmpty(string)) {
                ALog.w("AgooBindCache", "restoreAgooClients packs null return", new Object[0]);
                return;
            }
            JSONArray jSONArray = new JSONArray(string);
            this.f10498b = jSONArray.getLong(0);
            long jCurrentTimeMillis = System.currentTimeMillis();
            long j = this.f10498b;
            if (jCurrentTimeMillis < 86400000 + j) {
                for (int i2 = 1; i2 < jSONArray.length(); i2++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i2);
                    this.f10497a.put(jSONObject.getString("p"), Integer.valueOf(jSONObject.getInt(OperatorName.CLOSE_AND_STROKE)));
                }
                ALog.i("AgooBindCache", "restoreAgooClients", "mAgooBindStatus", this.f10497a);
                return;
            }
            ALog.i("AgooBindCache", "restoreAgooClients expired", "agooLastFlushTime", Long.valueOf(j));
            this.f10498b = 0L;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void a() {
        this.f10497a.clear();
        this.f10498b = 0L;
        try {
            this.f10499c.getSharedPreferences(this.f10500d, 0).edit().clear().commit();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
