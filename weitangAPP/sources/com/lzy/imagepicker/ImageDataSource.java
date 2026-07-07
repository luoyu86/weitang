package com.lzy.imagepicker;

import android.database.Cursor;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import androidx.fragment.app.FragmentActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.CursorLoader;
import androidx.loader.content.Loader;
import c.k.a.e.d;
import com.lzy.imagepicker.bean.ImageItem;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ImageDataSource implements LoaderManager.LoaderCallbacks<Cursor> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ArrayList<c.k.a.c.a> f9328a = new ArrayList<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String[] f9329b = {"_display_name", "_data", "_size", "width", "height", "mime_type", "date_added"};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public FragmentActivity f9330c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public b f9331d;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Cursor f9332a;

        public a(Cursor cursor) {
            this.f9332a = cursor;
        }

        @Override // java.lang.Runnable
        public void run() {
            Log.d(a.class.getSimpleName(), "onLoadFinished count:" + this.f9332a.getCount());
            ArrayList<ImageItem> arrayList = new ArrayList<>();
            while (this.f9332a.moveToNext()) {
                try {
                    Cursor cursor = this.f9332a;
                    String string = cursor.getString(cursor.getColumnIndexOrThrow(ImageDataSource.this.f9329b[0]));
                    Cursor cursor2 = this.f9332a;
                    String string2 = cursor2.getString(cursor2.getColumnIndexOrThrow(ImageDataSource.this.f9329b[1]));
                    Cursor cursor3 = this.f9332a;
                    long j = cursor3.getLong(cursor3.getColumnIndexOrThrow(ImageDataSource.this.f9329b[2]));
                    Cursor cursor4 = this.f9332a;
                    int i2 = cursor4.getInt(cursor4.getColumnIndexOrThrow(ImageDataSource.this.f9329b[3]));
                    Cursor cursor5 = this.f9332a;
                    int i3 = cursor5.getInt(cursor5.getColumnIndexOrThrow(ImageDataSource.this.f9329b[4]));
                    Cursor cursor6 = this.f9332a;
                    String string3 = cursor6.getString(cursor6.getColumnIndexOrThrow(ImageDataSource.this.f9329b[5]));
                    Cursor cursor7 = this.f9332a;
                    long j2 = cursor7.getLong(cursor7.getColumnIndexOrThrow(ImageDataSource.this.f9329b[6]));
                    ImageItem imageItem = new ImageItem();
                    imageItem.name = string;
                    imageItem.path = string2;
                    imageItem.size = j;
                    imageItem.width = i2;
                    imageItem.height = i3;
                    imageItem.mimeType = string3;
                    imageItem.addTime = j2;
                    arrayList.add(imageItem);
                    File parentFile = new File(string2).getParentFile();
                    c.k.a.c.a aVar = new c.k.a.c.a();
                    aVar.name = parentFile.getName();
                    aVar.path = parentFile.getAbsolutePath();
                    if (ImageDataSource.this.f9328a.contains(aVar)) {
                        Log.d(getClass().getSimpleName(), "get image folder");
                        ((c.k.a.c.a) ImageDataSource.this.f9328a.get(ImageDataSource.this.f9328a.indexOf(aVar))).images.add(imageItem);
                    } else {
                        ArrayList<ImageItem> arrayList2 = new ArrayList<>();
                        arrayList2.add(imageItem);
                        aVar.cover = imageItem;
                        aVar.images = arrayList2;
                        ImageDataSource.this.f9328a.add(aVar);
                        Log.d(getClass().getSimpleName(), "add image folder");
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            }
            if (this.f9332a.getCount() > 0 && !arrayList.isEmpty()) {
                c.k.a.c.a aVar2 = new c.k.a.c.a();
                aVar2.name = ImageDataSource.this.f9330c.getResources().getString(R.string.ip_all_images);
                aVar2.path = "/";
                aVar2.cover = arrayList.get(0);
                aVar2.images = arrayList;
                ImageDataSource.this.f9328a.add(0, aVar2);
            }
            Log.d(getClass().getSimpleName(), "onLoadFinished size:" + ImageDataSource.this.f9328a.size());
            c.k.a.a.getInstance().setImageFolders(ImageDataSource.this.f9328a);
            if (!ImageDataSource.this.f9328a.isEmpty()) {
                d.addAllImageFolder(ImageDataSource.this.f9328a);
            }
            if (ImageDataSource.this.f9331d != null) {
                ImageDataSource.this.f9331d.onImagesLoaded(ImageDataSource.this.f9328a);
            }
            this.f9332a.close();
        }
    }

    public interface b {
        void onImagesLoaded(List<c.k.a.c.a> list);
    }

    public ImageDataSource(FragmentActivity fragmentActivity, String str, b bVar) {
        this.f9330c = fragmentActivity;
        if (d.getImageFolders().isEmpty()) {
            this.f9331d = bVar;
        } else if (bVar != null) {
            bVar.onImagesLoaded(d.getImageFolders());
        }
        Log.d(getClass().getSimpleName(), "ImageDataSource");
        LoaderManager supportLoaderManager = fragmentActivity.getSupportLoaderManager();
        if (str == null) {
            supportLoaderManager.initLoader(0, null, this);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("path", str);
        supportLoaderManager.initLoader(1, bundle, this);
    }

    @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
    public Loader<Cursor> onCreateLoader(int i2, Bundle bundle) {
        CursorLoader cursorLoader;
        if (i2 == 0) {
            cursorLoader = new CursorLoader(this.f9330c, MediaStore.Images.Media.EXTERNAL_CONTENT_URI, this.f9329b, null, null, this.f9329b[6] + " DESC");
        } else {
            cursorLoader = null;
        }
        if (i2 == 1) {
            cursorLoader = new CursorLoader(this.f9330c, MediaStore.Images.Media.EXTERNAL_CONTENT_URI, this.f9329b, this.f9329b[1] + " like '%" + bundle.getString("path") + "%'", null, this.f9329b[6] + " DESC");
        }
        Log.d(getClass().getSimpleName(), "onCreateLoader");
        return cursorLoader;
    }

    @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
    public void onLoaderReset(Loader<Cursor> loader) {
        Log.d(getClass().getSimpleName(), "onLoaderReset");
    }

    @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        if (cursor == null || cursor.isClosed()) {
            return;
        }
        new Thread(new a(cursor)).start();
    }
}
