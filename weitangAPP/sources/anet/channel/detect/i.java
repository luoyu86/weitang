package anet.channel.detect;

import anet.channel.RequestCb;
import anet.channel.bytes.ByteArray;
import anet.channel.statist.HorseRaceStat;
import anet.channel.statist.RequestStatistic;
import anet.channel.util.ALog;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class i implements RequestCb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f422a;

    public i(h hVar) {
        this.f422a = hVar;
    }

    @Override // anet.channel.RequestCb
    public void onDataReceive(ByteArray byteArray, boolean z) {
    }

    @Override // anet.channel.RequestCb
    public void onFinish(int i2, String str, RequestStatistic requestStatistic) {
        ALog.i("anet.HorseRaceDetector", "LongLinkTask request finish", this.f422a.f418c, "statusCode", Integer.valueOf(i2), "msg", str);
        if (this.f422a.f416a.reqErrorCode == 0) {
            this.f422a.f416a.reqErrorCode = i2;
        } else {
            HorseRaceStat horseRaceStat = this.f422a.f416a;
            horseRaceStat.reqRet = horseRaceStat.reqErrorCode == 200 ? 1 : 0;
        }
        HorseRaceStat horseRaceStat2 = this.f422a.f416a;
        long jCurrentTimeMillis = System.currentTimeMillis();
        h hVar = this.f422a;
        horseRaceStat2.reqTime = (jCurrentTimeMillis - hVar.f417b) + hVar.f416a.connTime;
        synchronized (this.f422a.f416a) {
            this.f422a.f416a.notify();
        }
    }

    @Override // anet.channel.RequestCb
    public void onResponseCode(int i2, Map<String, List<String>> map) {
        this.f422a.f416a.reqErrorCode = i2;
    }
}
