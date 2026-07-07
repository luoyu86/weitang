package com.alipay.sdk.m.c0;

import com.taobao.accs.utl.BaseMonitor;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public File f5298a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.alipay.sdk.m.g0.a f5299b;

    public b(String str, com.alipay.sdk.m.g0.a aVar) {
        this.f5298a = null;
        this.f5299b = null;
        this.f5298a = new File(str);
        this.f5299b = aVar;
    }

    public static String a(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", "id");
            jSONObject.put(BaseMonitor.COUNT_ERROR, str);
            return jSONObject.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b() {
        File file = this.f5298a;
        if (file == null) {
            return;
        }
        if (file.exists() && this.f5298a.isDirectory() && this.f5298a.list().length != 0) {
            ArrayList arrayList = new ArrayList();
            for (String str : this.f5298a.list()) {
                arrayList.add(str);
            }
            Collections.sort(arrayList);
            String str2 = (String) arrayList.get(arrayList.size() - 1);
            int size = arrayList.size();
            if (str2.equals(new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime()) + ".log")) {
                if (arrayList.size() < 2) {
                    return;
                }
                str2 = (String) arrayList.get(arrayList.size() - 2);
                size--;
            }
            if (!this.f5299b.logCollect(a(com.alipay.sdk.m.z.b.a(this.f5298a.getAbsolutePath(), str2)))) {
                size--;
            }
            for (int i2 = 0; i2 < size; i2++) {
                new File(this.f5298a, (String) arrayList.get(i2)).delete();
            }
        }
    }

    public final void a() {
        new Thread(new c(this)).start();
    }
}
