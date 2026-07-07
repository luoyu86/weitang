package c.e.a.a;

import c.e.a.d.j;
import c.e.a.d.w;
import c.o.a.f;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f933a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f934b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f935c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f936d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f937e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f938f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f939g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f940h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f941i;
    public boolean j;
    public boolean k;
    public boolean l;
    public boolean m;
    public boolean n;
    public boolean o;
    public boolean p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f942q;

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f943a = new a();
    }

    public static a getInstance() {
        return b.f943a;
    }

    public final void a() {
        f.addLogAdapter(new c.o.a.a());
    }

    public final void b() {
        j.getInstance().f1216b = this.f933a ? 2 : 1;
        if (this.o) {
            j.getInstance().f1216b = w.getInstance().getInt("app_eve", 1);
            this.f935c = true;
            this.f937e = true;
            this.k = true;
        }
    }

    public boolean isADDebug() {
        return this.f934b;
    }

    public boolean isAdmin() {
        return this.f941i;
    }

    public boolean isBjIncrement() {
        return this.f937e;
    }

    public boolean isDebug() {
        return this.f933a;
    }

    public boolean isEnterpriseUser() {
        return this.p;
    }

    public boolean isH5Model() {
        return this.f936d;
    }

    public boolean isH5Repair() {
        return this.n;
    }

    public boolean isIMModel() {
        return this.f940h;
    }

    public boolean isJHModel() {
        return this.f935c;
    }

    public boolean isNewVersionModel() {
        return this.f938f;
    }

    public boolean isQQAppStory() {
        return this.f942q;
    }

    public boolean isSandBoxDebug() {
        return this.f939g;
    }

    public boolean isShowPwdDoor() {
        return this.l;
    }

    public boolean isTestModel() {
        return this.o;
    }

    public boolean isTestOpenDoorMt() {
        return this.j;
    }

    public boolean isTestRepair() {
        return this.k;
    }

    public boolean isTestServerErr() {
        return this.m;
    }

    public void setAdmin(boolean z) {
        this.f941i = z;
    }

    public void setBjIncrement(boolean z) {
        this.f937e = z;
    }

    public void setDebug(boolean z) {
        this.f933a = z;
        this.f939g = false;
        this.f935c = true;
        this.k = true;
        this.o = z;
        this.n = true;
        this.f934b = z;
        this.p = true;
        setAdmin(false);
        setBjIncrement(true);
        b();
    }

    public void setEnterpriseUser(boolean z) {
        this.p = z;
    }

    public void setH5Model(boolean z) {
        this.f936d = z;
    }

    public void setH5Repair(boolean z) {
        this.n = z;
    }

    public void setIMModel(boolean z) {
        this.f940h = z;
    }

    public void setJHModel(boolean z) {
        this.f935c = z;
    }

    public void setNewVersionModel(boolean z) {
        this.f938f = z;
    }

    public void setQQAppStory(boolean z) {
        this.f942q = z;
    }

    public void setShowPwdDoor(boolean z) {
        this.l = z;
    }

    public void setTestModel(boolean z) {
        this.o = z;
    }

    public void setTestRepair(boolean z) {
        this.k = z;
    }

    public void setTestServerErr(boolean z) {
        this.m = z;
    }

    public a() {
        this.f933a = false;
        this.f934b = false;
        this.f935c = false;
        this.f936d = false;
        this.f937e = false;
        this.f938f = true;
        this.f939g = false;
        this.f940h = false;
        this.f941i = false;
        this.j = false;
        this.k = false;
        this.l = false;
        this.m = false;
        this.n = false;
        this.o = false;
        this.p = false;
        this.f942q = false;
        a();
    }
}
