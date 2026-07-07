package anet.channel;

import anet.channel.util.HttpConstant;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class k implements a.a.n.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j f494a;

    public k(j jVar) {
        this.f494a = jVar;
    }

    @Override // a.a.n.c
    public boolean handleCache(String str, Map<String, String> map) {
        return "weex".equals(map.get(HttpConstant.F_REFER));
    }
}
