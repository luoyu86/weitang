package anet.channel.fulltrace;

import anet.channel.statist.RequestStatistic;

/* JADX INFO: loaded from: classes.dex */
public interface IFullTraceAnalysis {
    void commitRequest(String str, RequestStatistic requestStatistic);

    String createRequest();

    b getSceneInfo();
}
