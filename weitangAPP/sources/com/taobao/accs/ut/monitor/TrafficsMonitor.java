package com.taobao.accs.ut.monitor;

import android.content.Context;
import android.text.TextUtils;
import anet.channel.appmonitor.AppMonitor;
import anet.channel.statist.Dimension;
import anet.channel.statist.Measure;
import anet.channel.statist.Monitor;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.BaseMonitor;
import com.taobao.accs.utl.UtilityImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.android.agoo.common.AgooConstants;

/* JADX INFO: loaded from: classes2.dex */
public class TrafficsMonitor {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Context f10461d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<String, List<a>> f10458a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<String, String> f10459b = new HashMap<String, String>() { // from class: com.taobao.accs.ut.monitor.TrafficsMonitor.1
        {
            put("im", "512");
            put("motu", "513");
            put("acds", "514");
            put(GlobalClientInfo.AGOO_SERVICE_ID, "515");
            put(AgooConstants.AGOO_SERVICE_AGOOACK, "515");
            put("agooTokenReport", "515");
            put("accsSelf", "1000");
        }
    };

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f10460c = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f10462e = "";

    @Monitor(module = "NetworkSDK", monitorPoint = "TrafficStats")
    public static class StatTrafficMonitor extends BaseMonitor {

        @Dimension
        public String bizId;

        @Dimension
        public String date;

        @Dimension
        public String host;

        @Dimension
        public boolean isBackground;

        @Dimension
        public String serviceId;

        @Measure
        public long size;
    }

    public TrafficsMonitor(Context context) {
        this.f10461d = context;
    }

    private void b() {
        String str;
        boolean z;
        synchronized (this.f10458a) {
            String strA = UtilityImpl.a(System.currentTimeMillis());
            if (TextUtils.isEmpty(this.f10462e) || this.f10462e.equals(strA)) {
                str = strA;
                z = false;
            } else {
                str = this.f10462e;
                z = true;
            }
            Iterator<String> it = this.f10458a.keySet().iterator();
            while (it.hasNext()) {
                for (a aVar : this.f10458a.get(it.next())) {
                    if (aVar != null) {
                        com.taobao.accs.a.a aVarA = com.taobao.accs.a.a.a(this.f10461d);
                        String str2 = aVar.f10468e;
                        String str3 = aVar.f10466c;
                        aVarA.a(str2, str3, this.f10459b.get(str3), aVar.f10467d, aVar.f10469f, str);
                    }
                }
            }
            ALog.Level level = ALog.Level.D;
            if (ALog.isPrintLog(level)) {
                ALog.d("TrafficsMonitor", "savetoDay:" + str + " saveTraffics" + this.f10458a.toString(), new Object[0]);
            }
            if (z) {
                this.f10458a.clear();
                c();
            } else if (ALog.isPrintLog(level)) {
                ALog.d("TrafficsMonitor", "no need commit lastsaveDay:" + this.f10462e + " currday:" + strA, new Object[0]);
            }
            this.f10462e = strA;
            this.f10460c = 0;
        }
    }

    private void c() {
        List<a> listA = com.taobao.accs.a.a.a(this.f10461d).a(false);
        if (listA == null) {
            return;
        }
        try {
            for (a aVar : listA) {
                if (aVar != null) {
                    StatTrafficMonitor statTrafficMonitor = new StatTrafficMonitor();
                    statTrafficMonitor.bizId = aVar.f10465b;
                    statTrafficMonitor.date = aVar.f10464a;
                    statTrafficMonitor.host = aVar.f10468e;
                    statTrafficMonitor.isBackground = aVar.f10467d;
                    statTrafficMonitor.size = aVar.f10469f;
                    AppMonitor.getInstance().commitStat(statTrafficMonitor);
                }
            }
            com.taobao.accs.a.a.a(this.f10461d).a();
        } catch (Throwable th) {
            ALog.e("", th.toString(), new Object[0]);
            th.printStackTrace();
        }
    }

    public void a(a aVar) {
        boolean z;
        String str;
        if (aVar == null || aVar.f10468e == null || aVar.f10469f <= 0) {
            return;
        }
        aVar.f10466c = TextUtils.isEmpty(aVar.f10466c) ? "accsSelf" : aVar.f10466c;
        synchronized (this.f10458a) {
            String str2 = this.f10459b.get(aVar.f10466c);
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            aVar.f10465b = str2;
            List<a> arrayList = this.f10458a.get(str2);
            if (arrayList != null) {
                Iterator<a> it = arrayList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = true;
                        break;
                    }
                    a next = it.next();
                    if (next.f10467d == aVar.f10467d && (str = next.f10468e) != null && str.equals(aVar.f10468e)) {
                        next.f10469f += aVar.f10469f;
                        z = false;
                        break;
                    }
                }
                if (z) {
                    arrayList.add(aVar);
                }
            } else {
                arrayList = new ArrayList<>();
                arrayList.add(aVar);
            }
            this.f10458a.put(str2, arrayList);
            int i2 = this.f10460c + 1;
            this.f10460c = i2;
            if (i2 >= 10) {
                b();
            }
        }
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f10464a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f10465b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f10466c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f10467d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f10468e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public long f10469f;

        public a(String str, boolean z, String str2, long j) {
            this.f10466c = str;
            this.f10467d = z;
            this.f10468e = str2;
            this.f10469f = j;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("date:" + this.f10464a);
            sb.append(" ");
            sb.append("bizId:" + this.f10465b);
            sb.append(" ");
            sb.append("serviceId:" + this.f10466c);
            sb.append(" ");
            sb.append("host:" + this.f10468e);
            sb.append(" ");
            sb.append("isBackground:" + this.f10467d);
            sb.append(" ");
            sb.append("size:" + this.f10469f);
            return sb.toString();
        }

        public a(String str, String str2, String str3, boolean z, String str4, long j) {
            this.f10464a = str;
            this.f10465b = str2;
            this.f10466c = str3;
            this.f10467d = z;
            this.f10468e = str4;
            this.f10469f = j;
        }
    }

    public void a() {
        try {
            synchronized (this.f10458a) {
                this.f10458a.clear();
            }
            List<a> listA = com.taobao.accs.a.a.a(this.f10461d).a(true);
            if (listA == null) {
                return;
            }
            Iterator<a> it = listA.iterator();
            while (it.hasNext()) {
                a(it.next());
            }
        } catch (Exception e2) {
            ALog.w("TrafficsMonitor", e2.toString(), new Object[0]);
        }
    }
}
