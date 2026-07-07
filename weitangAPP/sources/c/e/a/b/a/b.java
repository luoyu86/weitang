package c.e.a.b.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import c.e.a.d.r;
import com.chinavisionary.core.photo.photopicker.PhotoPickerActivity;
import com.chinavisionary.core.photo.photopicker.entity.Photo;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static b f1043a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f1044b;
    public a j;
    public boolean k;
    public d m;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f1045c = 9;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f1046d = 3;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f1047e = 9;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f1048f = 3;
    public boolean n = true;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f1049g = true;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f1050h = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f1051i = true;
    public List<Photo> l = new ArrayList();

    public static void b(boolean z) {
        f1044b = z;
    }

    public static void destroy() {
        f1043a = null;
    }

    public static b getCurrentPhotoPicker() {
        return f1043a;
    }

    public static b init() {
        b bVar = new b();
        f1043a = bVar;
        return bVar;
    }

    public final void a(Context context, a aVar) {
        if (f1044b) {
            return;
        }
        this.j = aVar;
        c.e.a.b.a.i.c.init();
        c.e.a.b.a.i.c.getHelper().setConfig(this.m);
        c.e.a.b.a.i.c.getHelper().addAll(this.l);
        Intent intent = new Intent();
        intent.setClass(context, PhotoPickerActivity.class);
        intent.setFlags(268435456);
        context.startActivity(intent);
    }

    public int getColumn() {
        return this.f1048f;
    }

    public d getConfig() {
        return this.m;
    }

    public a getListener() {
        return this.j;
    }

    public int getMaxCount() {
        return this.f1047e;
    }

    public boolean isOnlyPreview() {
        return this.k;
    }

    public boolean isPreviewEnable() {
        return this.f1051i;
    }

    public boolean isShowCamera() {
        return this.f1049g;
    }

    public boolean isShowGif() {
        return this.f1050h;
    }

    public boolean isUseSystemCamera() {
        return this.n;
    }

    public b setColumn(int i2) {
        this.f1048f = i2;
        return this;
    }

    public b setConfig(d dVar) {
        this.m = dVar;
        return this;
    }

    public b setMaxCount(int i2) {
        this.f1047e = i2;
        return this;
    }

    public b setOnlyPreview(boolean z) {
        this.k = z;
        return this;
    }

    public b setPreviewEnable(boolean z) {
        this.f1051i = z;
        return this;
    }

    public b setSelectedList(List<String> list) {
        this.l.clear();
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.l.add(new Photo(i2, list.get(i2)));
        }
        return this;
    }

    public b setShowCamera(boolean z) {
        this.f1049g = z;
        return this;
    }

    public b setShowGif(boolean z) {
        this.f1050h = z;
        return this;
    }

    public b setUseSystemCamera(boolean z) {
        this.n = z;
        return this;
    }

    public void startPick(Context context, a aVar) {
        try {
            if (r.requestPermissions((Activity) context, 17, "android.permission.CAMERA", "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE")) {
                a(context, aVar);
            }
        } catch (Exception unused) {
        }
    }
}
