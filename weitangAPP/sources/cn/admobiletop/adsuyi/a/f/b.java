package cn.admobiletop.adsuyi.a.f;

import android.database.Cursor;
import cn.admobiletop.adsuyi.a.f.c;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class b implements cn.admobiletop.adsuyi.a.f.c.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Map f3232a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f3233b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ List f3234c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ c.a f3235d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ c f3236e;

    public b(c cVar, Map map, String str, List list, c.a aVar) {
        this.f3236e = cVar;
        this.f3232a = map;
        this.f3233b = str;
        this.f3234c = list;
        this.f3235d = aVar;
    }

    @Override // cn.admobiletop.adsuyi.a.f.c.a
    public void a(Cursor cursor) {
        this.f3236e.d(cursor, this.f3232a);
    }

    @Override // cn.admobiletop.adsuyi.a.f.c.a
    public void onFinish() {
        this.f3236e.j(this.f3233b, this.f3234c, this.f3232a);
        this.f3236e.f3245c.put(this.f3233b, this.f3232a);
        this.f3236e.f3246d = this.f3232a;
        if (this.f3236e.f3244b == null || this.f3235d == null) {
            return;
        }
        this.f3236e.f3244b.post(new a(this));
    }
}
