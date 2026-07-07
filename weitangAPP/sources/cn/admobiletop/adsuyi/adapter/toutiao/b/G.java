package cn.admobiletop.adsuyi.adapter.toutiao.b;

/* JADX INFO: loaded from: classes.dex */
public class G implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3937a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f3938b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ K f3939c;

    public G(K k, int i2, String str) {
        this.f3939c = k;
        this.f3937a = i2;
        this.f3938b = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f3939c.onAdFailed(this.f3937a, this.f3938b);
    }
}
