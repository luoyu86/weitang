package com.tianmu.g;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import com.tianmu.g.r;
import com.tianmu.g.x;

/* JADX INFO: loaded from: classes2.dex */
public class n extends f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String[] f12098b = {"orientation"};

    /* JADX WARN: $VALUES field not found */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    public static final class a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final a f12099d = new a("MICRO", 0, 3, 96, 96);

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final a f12100e = new a("MINI", 1, 1, 512, 384);

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f12101f = new a("FULL", 2, 2, -1, -1);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f12102a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f12103b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f12104c;

        private a(String str, int i2, int i3, int i4, int i5) {
            this.f12102a = i3;
            this.f12103b = i4;
            this.f12104c = i5;
        }
    }

    public n(Context context) {
        super(context);
    }

    @Override // com.tianmu.g.f, com.tianmu.g.x
    public boolean a(v vVar) {
        Uri uri = vVar.f12159d;
        return "content".equals(uri.getScheme()) && "media".equals(uri.getAuthority());
    }

    @Override // com.tianmu.g.f, com.tianmu.g.x
    public x.a a(v vVar, int i2) {
        Bitmap thumbnail;
        ContentResolver contentResolver = this.f12063a.getContentResolver();
        int iA = a(contentResolver, vVar.f12159d);
        String type = contentResolver.getType(vVar.f12159d);
        boolean z = type != null && type.startsWith("video/");
        if (vVar.c()) {
            a aVarA = a(vVar.f12163h, vVar.f12164i);
            if (!z && aVarA == a.f12101f) {
                return new x.a(null, c(vVar), r.e.f12137c, iA);
            }
            long id = ContentUris.parseId(vVar.f12159d);
            BitmapFactory.Options optionsB = x.b(vVar);
            optionsB.inJustDecodeBounds = true;
            x.a(vVar.f12163h, vVar.f12164i, aVarA.f12103b, aVarA.f12104c, optionsB, vVar);
            if (z) {
                thumbnail = MediaStore.Video.Thumbnails.getThumbnail(contentResolver, id, aVarA == a.f12101f ? 1 : aVarA.f12102a, optionsB);
            } else {
                thumbnail = MediaStore.Images.Thumbnails.getThumbnail(contentResolver, id, aVarA.f12102a, optionsB);
            }
            if (thumbnail != null) {
                return new x.a(thumbnail, null, r.e.f12137c, iA);
            }
        }
        return new x.a(null, c(vVar), r.e.f12137c, iA);
    }

    public static a a(int i2, int i3) {
        a aVar = a.f12099d;
        if (i2 <= aVar.f12103b && i3 <= aVar.f12104c) {
            return aVar;
        }
        a aVar2 = a.f12100e;
        return (i2 > aVar2.f12103b || i3 > aVar2.f12104c) ? a.f12101f : aVar2;
    }

    public static int a(ContentResolver contentResolver, Uri uri) {
        Cursor cursorQuery = null;
        try {
            cursorQuery = contentResolver.query(uri, f12098b, null, null, null);
            if (cursorQuery != null && cursorQuery.moveToFirst()) {
                int i2 = cursorQuery.getInt(0);
                cursorQuery.close();
                return i2;
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return 0;
        } catch (RuntimeException unused) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return 0;
        } catch (Throwable th) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            throw th;
        }
    }
}
