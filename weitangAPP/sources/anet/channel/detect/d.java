package anet.channel.detect;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import anet.channel.AwcnConfig;
import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.RequestCb;
import anet.channel.appmonitor.AppMonitor;
import anet.channel.entity.ConnType;
import anet.channel.request.Request;
import anet.channel.session.TnetSpdySession;
import anet.channel.session.b;
import anet.channel.statist.HorseRaceStat;
import anet.channel.strategy.ConnProtocol;
import anet.channel.strategy.IConnStrategy;
import anet.channel.strategy.StrategyCenter;
import anet.channel.strategy.l;
import anet.channel.util.ALog;
import anet.channel.util.AppLifecycle;
import anet.channel.util.ErrorConstant;
import anet.channel.util.HttpConstant;
import anet.channel.util.HttpUrl;
import com.bytedance.android.live.base.api.push.ILivePush;
import java.io.IOException;
import java.net.Socket;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.android.agoo.common.AgooConstants;
import org.android.netutil.PingResponse;
import org.android.netutil.PingTask;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TreeMap<String, l.c> f411a = new TreeMap<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private AtomicInteger f412b = new AtomicInteger(1);

    private void c(String str, l.e eVar) {
        String str2 = "HR" + this.f412b.getAndIncrement();
        ALog.i("anet.HorseRaceDetector", "startTcpTask", str2, "ip", eVar.f688a, "port", Integer.valueOf(eVar.f689b.f661a));
        HorseRaceStat horseRaceStat = new HorseRaceStat(str, eVar);
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            Socket socket = new Socket(eVar.f688a, eVar.f689b.f661a);
            int i2 = eVar.f689b.f663c;
            if (i2 == 0) {
                i2 = 10000;
            }
            socket.setSoTimeout(i2);
            ALog.i("anet.HorseRaceDetector", "socket connect success", str2, new Object[0]);
            horseRaceStat.connRet = 1;
            horseRaceStat.connTime = System.currentTimeMillis() - jCurrentTimeMillis;
            socket.close();
        } catch (IOException unused) {
            horseRaceStat.connTime = System.currentTimeMillis() - jCurrentTimeMillis;
            horseRaceStat.connErrorCode = ErrorConstant.ERROR_IO_EXCEPTION;
        }
        AppMonitor.getInstance().commitStat(horseRaceStat);
    }

    public void a() {
        ALog.e("anet.HorseRaceDetector", "network detect thread start", null, new Object[0]);
        while (true) {
            synchronized (this.f411a) {
                if (!AwcnConfig.isHorseRaceEnable()) {
                    this.f411a.clear();
                    return;
                }
                Map.Entry<String, l.c> entryPollFirstEntry = this.f411a.pollFirstEntry();
                if (entryPollFirstEntry == null) {
                    return;
                }
                try {
                    a(entryPollFirstEntry.getValue());
                } catch (Exception e2) {
                    ALog.e("anet.HorseRaceDetector", "start hr task failed", null, e2, new Object[0]);
                }
            }
        }
    }

    public void b() {
        StrategyCenter.getInstance().registerListener(new e(this));
        AppLifecycle.registerLifecycleListener(new f(this));
    }

    private void b(String str, l.e eVar) {
        ConnProtocol connProtocolValueOf = ConnProtocol.valueOf(eVar.f689b);
        ConnType connTypeValueOf = ConnType.valueOf(connProtocolValueOf);
        if (connTypeValueOf == null) {
            return;
        }
        ALog.i("anet.HorseRaceDetector", "startLongLinkTask", null, "host", str, "ip", eVar.f688a, "port", Integer.valueOf(eVar.f689b.f661a), "protocol", connProtocolValueOf);
        String str2 = "HR" + this.f412b.getAndIncrement();
        Context context = GlobalAppRuntimeInfo.getContext();
        StringBuilder sb = new StringBuilder();
        sb.append(connTypeValueOf.isSSL() ? "https://" : "http://");
        sb.append(str);
        TnetSpdySession tnetSpdySession = new TnetSpdySession(context, new anet.channel.entity.a(sb.toString(), str2, a(connProtocolValueOf, eVar)));
        HorseRaceStat horseRaceStat = new HorseRaceStat(str, eVar);
        long jCurrentTimeMillis = System.currentTimeMillis();
        tnetSpdySession.registerEventcb(InputDeviceCompat.SOURCE_KEYBOARD, new h(this, horseRaceStat, jCurrentTimeMillis, str2, eVar, tnetSpdySession));
        tnetSpdySession.connect();
        synchronized (horseRaceStat) {
            try {
                int i2 = eVar.f689b.f663c;
                if (i2 == 0) {
                    i2 = 10000;
                }
                horseRaceStat.wait(i2);
                if (horseRaceStat.connTime == 0) {
                    horseRaceStat.connTime = System.currentTimeMillis() - jCurrentTimeMillis;
                }
                a(eVar.f688a, horseRaceStat);
                AppMonitor.getInstance().commitStat(horseRaceStat);
            } catch (InterruptedException unused) {
            }
        }
        tnetSpdySession.close(false);
    }

    private void a(l.c cVar) {
        l.e[] eVarArr = cVar.f679b;
        if (eVarArr == null || eVarArr.length == 0) {
            return;
        }
        String str = cVar.f678a;
        int i2 = 0;
        while (true) {
            l.e[] eVarArr2 = cVar.f679b;
            if (i2 >= eVarArr2.length) {
                return;
            }
            l.e eVar = eVarArr2[i2];
            String str2 = eVar.f689b.f662b;
            if (!str2.equalsIgnoreCase("http") && !str2.equalsIgnoreCase("https")) {
                if (!str2.equalsIgnoreCase(ConnType.HTTP2) && !str2.equalsIgnoreCase(ConnType.SPDY) && !str2.equalsIgnoreCase(ConnType.QUIC)) {
                    if (str2.equalsIgnoreCase("tcp")) {
                        c(str, eVar);
                    }
                } else {
                    b(str, eVar);
                }
            } else {
                a(str, eVar);
            }
            i2++;
        }
    }

    private void a(String str, l.e eVar) {
        HttpUrl httpUrl = HttpUrl.parse(eVar.f689b.f662b + HttpConstant.SCHEME_SPLIT + str + eVar.f690c);
        if (httpUrl == null) {
            return;
        }
        ALog.i("anet.HorseRaceDetector", "startShortLinkTask", null, AgooConstants.OPEN_URL, httpUrl);
        Request requestBuild = new Request.Builder().setUrl(httpUrl).addHeader("Connection", ILivePush.ClickType.CLOSE).setConnectTimeout(eVar.f689b.f663c).setReadTimeout(eVar.f689b.f664d).setRedirectEnable(false).setSslSocketFactory(new anet.channel.util.j(str)).setSeq("HR" + this.f412b.getAndIncrement()).build();
        requestBuild.setDnsOptimize(eVar.f688a, eVar.f689b.f661a);
        long jCurrentTimeMillis = System.currentTimeMillis();
        b.a aVarA = anet.channel.session.b.a(requestBuild, (RequestCb) null);
        long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
        HorseRaceStat horseRaceStat = new HorseRaceStat(str, eVar);
        horseRaceStat.connTime = jCurrentTimeMillis2;
        int i2 = aVarA.f564a;
        if (i2 <= 0) {
            horseRaceStat.connErrorCode = i2;
        } else {
            horseRaceStat.connRet = 1;
            horseRaceStat.reqRet = aVarA.f564a == 200 ? 1 : 0;
            horseRaceStat.reqErrorCode = aVarA.f564a;
            horseRaceStat.reqTime = horseRaceStat.connTime;
        }
        a(eVar.f688a, horseRaceStat);
        AppMonitor.getInstance().commitStat(horseRaceStat);
    }

    private static IConnStrategy a(ConnProtocol connProtocol, l.e eVar) {
        return new j(eVar, connProtocol);
    }

    private void a(String str, HorseRaceStat horseRaceStat) {
        if (AwcnConfig.isPing6Enable() && anet.channel.strategy.utils.c.b(str)) {
            try {
                PingResponse pingResponse = (PingResponse) new PingTask(str, 1000, 3, 0, 0).launch().get();
                if (pingResponse == null) {
                    return;
                }
                horseRaceStat.pingSuccessCount = pingResponse.getSuccessCnt();
                horseRaceStat.pingTimeoutCount = 3 - horseRaceStat.pingSuccessCount;
                horseRaceStat.localIP = pingResponse.getLocalIPStr();
            } catch (Throwable th) {
                ALog.e("anet.HorseRaceDetector", "ping6 task fail.", null, th, new Object[0]);
            }
        }
    }
}
