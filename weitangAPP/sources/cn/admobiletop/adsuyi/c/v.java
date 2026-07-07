package cn.admobiletop.adsuyi.c;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import cn.admobiletop.adsuyi.c.A;
import cn.admobiletop.adsuyi.c.I;

/* JADX INFO: loaded from: classes.dex */
public class v extends C0333m {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String[] f4271b = {"orientation"};

    public enum a {
        MICRO(3, 96, 96),
        MINI(1, 512, 384),
        FULL(2, -1, -1);


        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f4276e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f4277f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f4278g;

        a(int i2, int i3, int i4) {
            this.f4276e = i2;
            this.f4277f = i3;
            this.f4278g = i4;
        }
    }

    public v(Context context) {
        super(context);
    }

    public static int i(ContentResolver contentResolver, Uri uri) {
        Cursor cursorQuery = null;
        try {
            cursorQuery = contentResolver.query(uri, f4271b, null, null, null);
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

    public static a j(int i2, int i3) {
        a aVar = a.MICRO;
        if (i2 <= aVar.f4277f && i3 <= aVar.f4278g) {
            return aVar;
        }
        a aVar2 = a.MINI;
        return (i2 > aVar2.f4277f || i3 > aVar2.f4278g) ? a.FULL : aVar2;
    }

    @Override // cn.admobiletop.adsuyi.c.C0333m, cn.admobiletop.adsuyi.c.I
    public boolean a(G g2) {
        Uri uri = g2.f4153e;
        return "content".equals(uri.getScheme()) && "media".equals(uri.getAuthority());
    }

    @Override // cn.admobiletop.adsuyi.c.C0333m, cn.admobiletop.adsuyi.c.I
    public I.a a(G g2, int i2) {
        Bitmap thumbnail;
        ContentResolver contentResolver = this.f4236a.getContentResolver();
        int i3 = i(contentResolver, g2.f4153e);
        String type = contentResolver.getType(g2.f4153e);
        boolean z = type != null && type.startsWith("video/");
        if (g2.c()) {
            a aVarJ = j(g2.f4157i, g2.j);
            if (!z && aVarJ == a.FULL) {
                return new I.a(null, h(g2), A.d.DISK, i3);
            }
            long id = ContentUris.parseId(g2.f4153e);
            BitmapFactory.Options optionsF = I.f(g2);
            optionsF.inJustDecodeBounds = true;
            I.b(g2.f4157i, g2.j, aVarJ.f4277f, aVarJ.f4278g, optionsF, g2);
            if (z) {
                thumbnail = MediaStore.Video.Thumbnails.getThumbnail(contentResolver, id, aVarJ == a.FULL ? 1 : aVarJ.f4276e, optionsF);
            } else {
                thumbnail = MediaStore.Images.Thumbnails.getThumbnail(contentResolver, id, aVarJ.f4276e, optionsF);
            }
            if (thumbnail != null) {
                return new I.a(thumbnail, null, A.d.DISK, i3);
            }
        }
        return new I.a(null, h(g2), A.d.DISK, i3);
    }
}
