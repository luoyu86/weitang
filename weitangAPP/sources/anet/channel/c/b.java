package anet.channel.c;

import com.taobao.orange.OrangeConfigListenerV1;

/* JADX INFO: loaded from: classes.dex */
public class b implements OrangeConfigListenerV1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f389a;

    public b(a aVar) {
        this.f389a = aVar;
    }

    public void onConfigUpdate(String str, boolean z) {
        this.f389a.onConfigUpdate(str);
    }
}
