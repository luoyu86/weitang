package g.a.g.a;

/* JADX INFO: loaded from: classes2.dex */
public class w implements q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile int f14161a = 4;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f14162b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public i[] f14163c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public i[] f14164d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public i f14165e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f14166f = -1;

    public int a() {
        int i2 = this.f14161a;
        if (i2 <= 0) {
            return i2;
        }
        int i3 = i2 - 1;
        this.f14161a = i3;
        return i3;
    }

    public int b() {
        return this.f14161a;
    }

    public void c(int i2) {
        this.f14161a = i2;
    }

    public int getConfWidth() {
        return this.f14162b;
    }

    public i[] getPreComp() {
        return this.f14163c;
    }

    public i[] getPreCompNeg() {
        return this.f14164d;
    }

    public i getTwice() {
        return this.f14165e;
    }

    public int getWidth() {
        return this.f14166f;
    }

    public boolean isPromoted() {
        return this.f14161a <= 0;
    }

    public void setConfWidth(int i2) {
        this.f14162b = i2;
    }

    public void setPreComp(i[] iVarArr) {
        this.f14163c = iVarArr;
    }

    public void setPreCompNeg(i[] iVarArr) {
        this.f14164d = iVarArr;
    }

    public void setTwice(i iVar) {
        this.f14165e = iVar;
    }

    public void setWidth(int i2) {
        this.f14166f = i2;
    }
}
