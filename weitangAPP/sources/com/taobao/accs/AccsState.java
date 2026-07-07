package com.taobao.accs;

import android.os.SystemClock;
import anet.channel.strategy.dispatch.DispatchConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class AccsState {
    public static final String ALL = "all";
    public static final String BIND_APP_FROM_CACHE = "bfc";
    public static final String CONNECTION_CHANGE = "cc";
    public static final String LAST_MSG_RECEIVE_TIME = "lmrt";
    public static final String LAST_MSG_SEND_TIME = "lmst";
    public static final String RECENT_ERRORS = "re";
    public static final String SDK_VERSION = "sv";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private HashMap<String, c> f10226a = new HashMap<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f10227b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f10228c = -1;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final AccsState f10229a = new AccsState();

        private a() {
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f10230a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f10231b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f10232c;

        public b(long j, String str, String str2) {
            this.f10230a = j;
            this.f10231b = str;
            this.f10232c = str2;
        }

        public JSONArray a() {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(this.f10230a);
            jSONArray.put(this.f10231b);
            jSONArray.put(this.f10232c);
            return jSONArray;
        }
    }

    public static class c {
        public static final int MAX_HISTORY = 5;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final HashMap<String, b> f10233a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final HashMap<String, ArrayList<b>> f10234b;

        private c() {
            this.f10233a = new HashMap<>();
            this.f10234b = new HashMap<>();
        }

        public void a(String str, Object obj, long j) {
            this.f10233a.put(str, new b(j, str, a(obj)));
        }

        public void b(String str, Object obj, long j) {
            ArrayList<b> arrayList = this.f10234b.get(str);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.f10234b.put(str, arrayList);
            }
            arrayList.add(new b(j, str, a(obj)));
            while (arrayList.size() > 5) {
                arrayList.remove(0);
            }
        }

        private static String a(Object obj) {
            return obj == null ? "null" : obj.toString();
        }

        public boolean a(String str) {
            return this.f10233a.containsKey(str) || this.f10234b.containsKey(str);
        }

        public JSONArray a() {
            JSONArray jSONArray = new JSONArray();
            Iterator it = new ArrayList(this.f10233a.values()).iterator();
            while (it.hasNext()) {
                jSONArray.put(((b) it.next()).a());
            }
            ArrayList arrayList = new ArrayList();
            Iterator<ArrayList<b>> it2 = this.f10234b.values().iterator();
            while (it2.hasNext()) {
                arrayList.addAll(it2.next());
            }
            Iterator it3 = arrayList.iterator();
            while (it3.hasNext()) {
                jSONArray.put(((b) it3.next()).a());
            }
            return jSONArray;
        }

        public JSONArray b(String str) {
            JSONArray jSONArray = new JSONArray();
            b bVar = this.f10233a.get(str);
            if (bVar != null) {
                jSONArray.put(bVar.a());
            }
            ArrayList<b> arrayList = this.f10234b.get(str);
            if (arrayList != null) {
                Iterator<b> it = arrayList.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next().a());
                }
            }
            return jSONArray;
        }
    }

    public static AccsState getInstance() {
        return a.f10229a;
    }

    public synchronized void a(String str, Object obj) {
        a(ALL).a(str, obj, b());
    }

    public synchronized void b(String str, Object obj) {
        a(ALL).b(str, obj, b());
    }

    public synchronized String getState() {
        if (!a(this.f10226a)) {
            return "{}";
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(DispatchConstants.TIMESTAMP, this.f10228c);
            for (Map.Entry entry : new ArrayList(this.f10226a.entrySet())) {
                jSONObject.put((String) entry.getKey(), ((c) entry.getValue()).a());
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject.toString();
    }

    public synchronized String getStateByKey(String str) {
        if (!a(this.f10226a, str)) {
            return "{}";
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(DispatchConstants.TIMESTAMP, this.f10228c);
            for (Map.Entry entry : new ArrayList(this.f10226a.entrySet())) {
                if (((c) entry.getValue()).a(str)) {
                    jSONObject.put((String) entry.getKey(), ((c) entry.getValue()).b(str));
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject.toString();
    }

    public synchronized void a(String str, String str2, Object obj) {
        a(str).a(str2, obj, b());
    }

    public synchronized void b(String str, String str2, Object obj) {
        a(str).b(str2, obj, b());
    }

    private c a(String str) {
        c cVar = this.f10226a.get(str);
        if (cVar != null) {
            return cVar;
        }
        c cVar2 = new c();
        this.f10226a.put(str, cVar2);
        return cVar2;
    }

    private long b() {
        a();
        return SystemClock.elapsedRealtime() - this.f10227b;
    }

    private void a() {
        if (this.f10228c < 0 || this.f10227b < 0) {
            this.f10228c = System.currentTimeMillis();
            this.f10227b = SystemClock.elapsedRealtime();
        }
    }

    private boolean a(HashMap<String, c> map) {
        return map.size() > 0;
    }

    private boolean a(HashMap<String, c> map, String str) {
        Iterator it = new ArrayList(map.values()).iterator();
        while (it.hasNext()) {
            if (((c) it.next()).a(str)) {
                return true;
            }
        }
        return false;
    }
}
