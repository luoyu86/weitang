package anet.channel;

import anet.channel.heartbeat.IHeartbeat;

/* JADX INFO: loaded from: classes.dex */
public class SessionInfo {
    public final IAuth auth;
    public final DataFrameCb dataFrameCb;
    public final IHeartbeat heartbeat;
    public final String host;
    public final boolean isAccs;
    public final boolean isKeepAlive;

    private SessionInfo(String str, boolean z, boolean z2, IAuth iAuth, IHeartbeat iHeartbeat, DataFrameCb dataFrameCb) {
        this.host = str;
        this.isAccs = z2;
        this.auth = iAuth;
        this.isKeepAlive = z;
        this.heartbeat = iHeartbeat;
        this.dataFrameCb = dataFrameCb;
    }

    public static SessionInfo create(String str, boolean z, boolean z2, IAuth iAuth, IHeartbeat iHeartbeat, DataFrameCb dataFrameCb) {
        return new SessionInfo(str, z, z2, iAuth, iHeartbeat, dataFrameCb);
    }
}
