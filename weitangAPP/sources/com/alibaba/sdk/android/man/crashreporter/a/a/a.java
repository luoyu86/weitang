package com.alibaba.sdk.android.man.crashreporter.a.a;

import android.content.Context;
import com.alibaba.sdk.android.man.crashreporter.ReporterConfigure;
import com.alibaba.sdk.android.man.crashreporter.a.a.a.a.d;
import com.alibaba.sdk.android.man.crashreporter.a.a.a.a.e;
import com.alibaba.sdk.android.man.crashreporter.d.c;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class a implements com.alibaba.sdk.android.man.crashreporter.a.a.b {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private b f83a = new b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private C0059a f4681a = new C0059a();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private com.alibaba.sdk.android.man.crashreporter.a.a.a.a.a f84a = null;

    /* JADX INFO: renamed from: com.alibaba.sdk.android.man.crashreporter.a.a.a$a, reason: collision with other inner class name */
    public final class C0059a implements com.alibaba.sdk.android.man.crashreporter.a.a.a.a {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public LinkedList<com.alibaba.sdk.android.man.crashreporter.a.a.a.a> f85a = new LinkedList<>();

        public C0059a() {
        }

        public void a(com.alibaba.sdk.android.man.crashreporter.a.a.a.a aVar) {
            if (aVar != null) {
                this.f85a.add(aVar);
            }
        }

        @Override // com.alibaba.sdk.android.man.crashreporter.a.a.a.c
        public void a(Map<String, String> map) {
            Iterator<com.alibaba.sdk.android.man.crashreporter.a.a.a.a> it = this.f85a.iterator();
            while (it.hasNext()) {
                try {
                    it.next().a(map);
                } catch (Exception e2) {
                    com.alibaba.sdk.android.man.crashreporter.b.a.d("External collect error.", e2);
                }
            }
        }
    }

    public final class b implements com.alibaba.sdk.android.man.crashreporter.a.a.a.b {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public LinkedList<com.alibaba.sdk.android.man.crashreporter.a.a.a.b> f86a = new LinkedList<>();

        public b() {
        }

        public void a(com.alibaba.sdk.android.man.crashreporter.a.a.a.b bVar) {
            if (bVar != null) {
                this.f86a.add(bVar);
            }
        }

        @Override // com.alibaba.sdk.android.man.crashreporter.a.a.a.c
        public void a(Map<com.alibaba.sdk.android.man.crashreporter.global.a, String> map) {
            Iterator<com.alibaba.sdk.android.man.crashreporter.a.a.a.b> it = this.f86a.iterator();
            while (it.hasNext()) {
                try {
                    it.next().a(map);
                } catch (Exception e2) {
                    com.alibaba.sdk.android.man.crashreporter.b.a.d("Internal collect error.", e2);
                }
            }
        }
    }

    @Override // com.alibaba.sdk.android.man.crashreporter.a.a.b
    public void a(ReporterConfigure reporterConfigure, Context context, c cVar, com.alibaba.sdk.android.man.crashreporter.a.b bVar) {
        try {
            if (context == null) {
                com.alibaba.sdk.android.man.crashreporter.b.a.e("init collector failure!");
                return;
            }
            this.f83a.a(new com.alibaba.sdk.android.man.crashreporter.a.a.a.a.c());
            this.f83a.a(new e(context));
            if (reporterConfigure.enableActivityMonitor) {
                com.alibaba.sdk.android.man.crashreporter.a.a.a.a.a aVar = new com.alibaba.sdk.android.man.crashreporter.a.a.a.a.a(context, cVar, bVar);
                this.f84a = aVar;
                this.f83a.a(aVar);
            }
            if (reporterConfigure.enableDumpSysLog) {
                this.f83a.a(new d(com.alibaba.sdk.android.man.crashreporter.global.a.SYS_LOG));
            }
            if (reporterConfigure.enableDumpEventsLog) {
                this.f83a.a(new d(com.alibaba.sdk.android.man.crashreporter.global.a.EVENTS_LOG));
            }
            if (reporterConfigure.enableDumpRadioLog) {
                this.f83a.a(new d(com.alibaba.sdk.android.man.crashreporter.global.a.RADIO_LOG));
            }
        } catch (Exception e2) {
            com.alibaba.sdk.android.man.crashreporter.b.a.d("init collector err!", e2);
        }
    }

    @Override // com.alibaba.sdk.android.man.crashreporter.a.a.b
    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public Map<com.alibaba.sdk.android.man.crashreporter.global.a, String> mo40b() {
        EnumMap enumMap = new EnumMap(com.alibaba.sdk.android.man.crashreporter.global.a.class);
        this.f83a.a(enumMap);
        return enumMap;
    }

    @Override // com.alibaba.sdk.android.man.crashreporter.a.a.b
    public String b() {
        com.alibaba.sdk.android.man.crashreporter.a.a.a.a.a aVar = this.f84a;
        return aVar != null ? aVar.b() : "";
    }

    @Override // com.alibaba.sdk.android.man.crashreporter.a.a.b
    public Map<String, String> a() {
        HashMap map = new HashMap();
        this.f4681a.a(map);
        return map;
    }

    public void a(com.alibaba.sdk.android.man.crashreporter.a.a.a.a aVar) {
        this.f4681a.a(aVar);
    }
}
