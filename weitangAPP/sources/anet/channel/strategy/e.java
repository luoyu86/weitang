package anet.channel.strategy;

/* JADX INFO: loaded from: classes.dex */
public class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f645a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ StrategyInfoHolder f646b;

    public e(StrategyInfoHolder strategyInfoHolder, String str) {
        this.f646b = strategyInfoHolder;
        this.f645a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f646b.a(this.f645a, true);
    }
}
