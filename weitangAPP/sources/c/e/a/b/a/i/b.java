package c.e.a.b.a.i;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;
import com.chinavisionary.core.R;
import com.chinavisionary.core.photo.photopicker.utils.PhotoDirectoryLoader;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class b {

    public static class a implements LoaderManager.LoaderCallbacks<Cursor> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public WeakReference<Context> f1105a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public InterfaceC0021b f1106b;

        public a(Context context, InterfaceC0021b interfaceC0021b) {
            this.f1105a = new WeakReference<>(context);
            this.f1106b = interfaceC0021b;
        }

        @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
        public Loader<Cursor> onCreateLoader(int i2, Bundle bundle) {
            return new PhotoDirectoryLoader(this.f1105a.get(), c.e.a.b.a.b.getCurrentPhotoPicker().isShowGif());
        }

        @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
        public void onLoaderReset(Loader<Cursor> loader) {
        }

        @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
        public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
            if (cursor == null) {
                return;
            }
            List<c.e.a.b.a.g.b> arrayList = new ArrayList<>();
            c.e.a.b.a.g.b bVar = new c.e.a.b.a.g.b();
            bVar.setName(this.f1105a.get().getString(R.string.__picker_all_image));
            bVar.setId("ALL");
            while (cursor.moveToNext()) {
                int i2 = cursor.getInt(cursor.getColumnIndexOrThrow("_id"));
                String string = cursor.getString(cursor.getColumnIndexOrThrow("bucket_id"));
                String string2 = cursor.getString(cursor.getColumnIndexOrThrow("bucket_display_name"));
                String string3 = cursor.getString(cursor.getColumnIndexOrThrow("_data"));
                c.e.a.b.a.g.b bVar2 = new c.e.a.b.a.g.b();
                bVar2.setId(string);
                bVar2.setName(string2);
                if (arrayList.contains(bVar2)) {
                    arrayList.get(arrayList.indexOf(bVar2)).addPhoto(i2, string3);
                } else {
                    bVar2.setCoverPath(string3);
                    bVar2.addPhoto(i2, string3);
                    bVar2.setDateAdded(cursor.getLong(cursor.getColumnIndexOrThrow("date_added")));
                    arrayList.add(bVar2);
                }
                bVar.addPhoto(i2, string3);
            }
            if (bVar.getPhotoPaths().size() > 0) {
                bVar.setCoverPath(bVar.getPhotoPaths().get(0));
            }
            arrayList.add(0, bVar);
            InterfaceC0021b interfaceC0021b = this.f1106b;
            if (interfaceC0021b != null) {
                interfaceC0021b.onResultCallback(arrayList);
            }
        }
    }

    /* JADX INFO: renamed from: c.e.a.b.a.i.b$b, reason: collision with other inner class name */
    public interface InterfaceC0021b {
        void onResultCallback(List<c.e.a.b.a.g.b> list);
    }

    public static void getPhotoDirs(FragmentActivity fragmentActivity, Bundle bundle, InterfaceC0021b interfaceC0021b) {
        fragmentActivity.getSupportLoaderManager().initLoader(0, bundle, new a(fragmentActivity, interfaceC0021b));
    }
}
