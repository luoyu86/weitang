package com.tianmu.c.h.d;

import android.content.Intent;
import android.text.TextUtils;
import com.aliyun.ams.emas.push.AgooMessageReceiver;
import com.tianmu.biz.utils.s0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static c f11647b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map<String, Intent> f11648a;

    private c() {
    }

    public static c c() {
        if (f11647b == null) {
            synchronized (c.class) {
                if (f11647b == null) {
                    f11647b = new c();
                }
            }
        }
        return f11647b;
    }

    public void a(String str, Intent intent) {
        if (this.f11648a == null) {
            this.f11648a = new HashMap();
        }
        this.f11648a.put(str, intent);
    }

    public void b() {
        Map<String, Intent> map = this.f11648a;
        if (map != null) {
            map.clear();
        }
    }

    public void d(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            Intent intentA = c().a(str);
            String stringExtra = intentA.getStringExtra("title");
            String stringExtra2 = intentA.getStringExtra("appPackageName");
            intentA.getIntExtra("downloadState", 0);
            b.a().a(str, stringExtra, stringExtra2, true);
        } catch (Throwable th) {
            s0.a("下载出错了~");
            th.printStackTrace();
        }
    }

    public void e(String str) {
        Map<String, Intent> map = this.f11648a;
        if (map != null) {
            map.remove(str);
        }
    }

    public void f(String str) {
        int iB;
        if (TextUtils.isEmpty(str) || (iB = c().b(str)) == 2 || iB == 1) {
            return;
        }
        try {
            Intent intentA = c().a(str);
            b.a().b(str, intentA.getStringExtra("title"), intentA.getStringExtra("appPackageName"), true);
        } catch (Throwable th) {
            s0.a("下载出错了~");
            th.printStackTrace();
        }
    }

    public void g(String str) {
        try {
            Intent intentA = c().a(str);
            b.a().c(str, intentA.getStringExtra("title"), intentA.getStringExtra("appPackageName"), true);
        } catch (Throwable th) {
            s0.a("下载出错了~");
            th.printStackTrace();
        }
    }

    public int b(String str) {
        Intent intentA;
        Map<String, Intent> map = this.f11648a;
        if (map == null || !map.containsKey(str) || (intentA = a(str)) == null) {
            return 0;
        }
        return intentA.getIntExtra("downloadState", 0);
    }

    public Intent a(String str) {
        Map<String, Intent> map = this.f11648a;
        if (map != null) {
            return map.get(str);
        }
        return null;
    }

    public void a(String str, int i2) {
        Intent intentA;
        Map<String, Intent> map = this.f11648a;
        if (map == null || !map.containsKey(str) || (intentA = a(str)) == null) {
            return;
        }
        intentA.putExtra("downloadState", i2);
    }

    public int c(String str) {
        Intent intentA;
        Map<String, Intent> map = this.f11648a;
        if (map == null || !map.containsKey(str) || (intentA = a(str)) == null) {
            return 0;
        }
        int intExtra = intentA.getIntExtra(AgooMessageReceiver.NOTIFICATION_ID, 0);
        if (intExtra != 0) {
            return intExtra;
        }
        int iA = a(8);
        intentA.putExtra(AgooMessageReceiver.NOTIFICATION_ID, iA);
        return iA;
    }

    private int a(int i2) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i3 = 0; i3 < i2; i3++) {
            sb.append(random.nextInt(10));
        }
        return Integer.parseInt(sb.toString());
    }

    public List<Intent> a() {
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = this.f11648a.keySet().iterator();
        while (it.hasNext()) {
            arrayList.add(this.f11648a.get(it.next()));
        }
        return arrayList;
    }
}
