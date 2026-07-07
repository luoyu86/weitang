package anet.channel.detect;

import anet.channel.Session;
import anet.channel.entity.EventCb;
import anet.channel.request.Request;
import anet.channel.session.TnetSpdySession;
import anet.channel.statist.HorseRaceStat;
import anet.channel.strategy.l;
import anet.channel.util.ALog;
import anet.channel.util.HttpUrl;

/* JADX INFO: loaded from: classes.dex */
public class h implements EventCb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HorseRaceStat f416a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f417b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f418c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ l.e f419d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ TnetSpdySession f420e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ d f421f;

    public h(d dVar, HorseRaceStat horseRaceStat, long j, String str, l.e eVar, TnetSpdySession tnetSpdySession) {
        this.f421f = dVar;
        this.f416a = horseRaceStat;
        this.f417b = j;
        this.f418c = str;
        this.f419d = eVar;
        this.f420e = tnetSpdySession;
    }

    @Override // anet.channel.entity.EventCb
    public void onEvent(Session session, int i2, anet.channel.entity.b bVar) {
        if (this.f416a.connTime != 0) {
            return;
        }
        this.f416a.connTime = System.currentTimeMillis() - this.f417b;
        if (i2 != 1) {
            this.f416a.connErrorCode = bVar.f460b;
            synchronized (this.f416a) {
                this.f416a.notify();
            }
            return;
        }
        ALog.i("anet.HorseRaceDetector", "tnetSpdySession connect success", this.f418c, new Object[0]);
        this.f416a.connRet = 1;
        HttpUrl httpUrl = HttpUrl.parse(session.getHost() + this.f419d.f690c);
        if (httpUrl == null) {
            return;
        }
        this.f420e.request(new Request.Builder().setUrl(httpUrl).setReadTimeout(this.f419d.f689b.f664d).setRedirectEnable(false).setSeq(this.f418c).build(), new i(this));
    }
}
