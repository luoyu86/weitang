package c.e.a.b.a;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import com.chinavisionary.core.photo.photopicker.PhotoPagerActivity;
import com.chinavisionary.core.photo.photopicker.entity.Photo;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static c f1052a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f1053b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Handler f1054c = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f1055d;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f1058g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public a f1059h;
    public d j;
    public boolean k;
    public c.e.a.b.a.h.b l;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f1057f = true;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List<Photo> f1056e = new ArrayList();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public List<Photo> f1060i = new ArrayList();

    public static void a(boolean z) {
        f1053b = z;
    }

    public static void destroy() {
        f1052a.f1056e.clear();
        f1052a.f1060i.clear();
        f1052a = null;
    }

    public static c getCurrentPhotoPreview() {
        return f1052a;
    }

    public static c init() {
        c cVar = new c();
        f1052a = cVar;
        return cVar;
    }

    public d getConfig() {
        return this.j;
    }

    public int getCurrentPos() {
        return this.f1055d;
    }

    public a getListener() {
        return this.f1059h;
    }

    public int getMaxCount() {
        return Math.max(this.f1058g, this.f1056e.size());
    }

    public c.e.a.b.a.h.b getOnPhotoDeleteListener() {
        return this.l;
    }

    public List<Photo> getPhotos() {
        return this.f1056e;
    }

    public boolean isPreviewOnly() {
        return this.f1057f;
    }

    public boolean isShowDelete() {
        return this.k;
    }

    public c setConfig(d dVar) {
        this.j = dVar;
        return this;
    }

    public c setCurrentPos(int i2) {
        this.f1055d = i2;
        return this;
    }

    public c setMaxCount(int i2) {
        this.f1058g = i2;
        return this;
    }

    public c setPhotoPaths(List<String> list) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            arrayList.add(new Photo(i2, list.get(i2)));
        }
        setPhotos(arrayList);
        return this;
    }

    public c setPhotos(List<Photo> list) {
        this.f1056e.clear();
        this.f1056e.addAll(list);
        return this;
    }

    public c setPreviewOnly(boolean z) {
        this.f1057f = z;
        return this;
    }

    public c setSelectedList(List<String> list) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            arrayList.add(new Photo(i2, list.get(i2)));
        }
        this.f1060i.clear();
        this.f1060i.addAll(arrayList);
        return this;
    }

    public c setShowDelete(boolean z, c.e.a.b.a.h.b bVar) {
        this.k = z;
        this.l = bVar;
        return this;
    }

    public void startPreview(Context context, a aVar) {
        if (f1053b) {
            return;
        }
        a(true);
        if (c.e.a.b.a.i.c.getHelper() == null) {
            c.e.a.b.a.i.c cVarInit = c.e.a.b.a.i.c.init();
            cVarInit.addAll(this.f1060i);
            cVarInit.setConfig(this.j);
        }
        this.f1059h = aVar;
        Intent intent = new Intent(context, (Class<?>) PhotoPagerActivity.class);
        intent.setFlags(268435456);
        context.startActivity(intent);
    }
}
