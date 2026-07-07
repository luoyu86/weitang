package c.e.a.b.a.i;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;
import com.chinavisionary.core.R;
import com.chinavisionary.core.photo.photopicker.entity.Photo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static c f1107a;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public c.e.a.b.a.d f1113g;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List<Activity> f1112f = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<Photo> f1108b = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List<Photo> f1109c = new ArrayList();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List<a> f1110d = new ArrayList();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List<b> f1111e = new ArrayList();

    public interface a {
        void selectedCount(int i2);
    }

    public interface b {
        void onSelectedChanged(Photo photo);
    }

    public static void destroy() {
    }

    public static c getHelper() {
        return f1107a;
    }

    public static c init() {
        c cVar = new c();
        f1107a = cVar;
        return cVar;
    }

    public final void a(Photo photo) {
        Iterator<b> it = this.f1111e.iterator();
        while (it.hasNext()) {
            it.next().onSelectedChanged(photo);
        }
    }

    public void addActivity(Activity activity) {
        if (this.f1112f.contains(activity)) {
            return;
        }
        this.f1112f.add(activity);
    }

    public void addAll(List<Photo> list) {
        this.f1108b.clear();
        this.f1108b.addAll(list);
    }

    public void addSelected(Photo photo) {
        if (this.f1108b.contains(photo)) {
            return;
        }
        this.f1108b.add(photo);
        c();
    }

    public void addSelectedChangeListener(a aVar) {
        if (this.f1110d.contains(aVar)) {
            return;
        }
        this.f1110d.add(aVar);
    }

    public void addStateChangeListener(b bVar) {
        if (this.f1111e.contains(bVar)) {
            return;
        }
        this.f1111e.add(bVar);
    }

    public final void b() {
        Iterator<Activity> it = this.f1112f.iterator();
        while (it.hasNext()) {
            it.next().finish();
        }
        this.f1112f.clear();
        Log.i("ssss", "==finish==  " + f1107a);
        destroy();
    }

    public final void c() {
        Iterator<a> it = this.f1110d.iterator();
        while (it.hasNext()) {
            it.next().selectedCount(this.f1108b.size());
        }
    }

    public void capturePhotoFinish(String str) {
        if (c.e.a.b.a.b.getCurrentPhotoPicker() != null && c.e.a.b.a.b.getCurrentPhotoPicker().getListener() != null) {
            c.e.a.b.a.b.getCurrentPhotoPicker().getListener().onPhotoCapture(str);
        }
        b();
    }

    public void finishPick(boolean z) {
        ArrayList arrayList = new ArrayList();
        if (!z) {
            Iterator<Photo> it = this.f1108b.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().getPath());
            }
        }
        if (c.e.a.b.a.b.getCurrentPhotoPicker() != null) {
            if (c.e.a.b.a.b.getCurrentPhotoPicker().getListener() != null) {
                c.e.a.b.a.b.getCurrentPhotoPicker().getListener().onPhotoPick(z, arrayList);
            }
        } else if (c.e.a.b.a.c.getCurrentPhotoPreview() != null && c.e.a.b.a.c.getCurrentPhotoPreview().getListener() != null) {
            c.e.a.b.a.c.getCurrentPhotoPreview().getListener().onPhotoPick(z, arrayList);
        }
        b();
    }

    public List<Activity> getActivities() {
        return this.f1112f;
    }

    public c.e.a.b.a.d getConfig() {
        return this.f1113g;
    }

    public List<Photo> getCurrentPagePhotos() {
        return this.f1109c;
    }

    public List<Photo> getSelectedList() {
        return this.f1108b;
    }

    public boolean isSelected(Photo photo) {
        return this.f1108b.contains(photo);
    }

    public void removeActivity(Activity activity) {
        this.f1112f.remove(activity);
    }

    public void removeSelectedChangeListener(a aVar) {
        this.f1110d.remove(aVar);
    }

    public void removeStateChangeListener(b bVar) {
        this.f1111e.remove(bVar);
    }

    public void removeUnselected(Photo photo) {
        this.f1108b.remove(photo);
        c();
    }

    public void setConfig(c.e.a.b.a.d dVar) {
        this.f1113g = dVar;
    }

    public void setCurrentPagePhotos(List<Photo> list) {
        this.f1109c = list;
    }

    public boolean toggleSelection(Context context, Photo photo) {
        int maxCount = c.e.a.b.a.b.getCurrentPhotoPicker() != null ? c.e.a.b.a.b.getCurrentPhotoPicker().getMaxCount() : c.e.a.b.a.c.getCurrentPhotoPreview().getMaxCount();
        if (maxCount <= 0) {
            return false;
        }
        if (maxCount == 1) {
            if (this.f1108b.contains(photo)) {
                removeUnselected(photo);
                a(photo);
            } else {
                a(photo);
                for (int i2 = 0; i2 < this.f1108b.size(); i2++) {
                    a(this.f1108b.get(i2));
                }
                this.f1108b.clear();
                addSelected(photo);
            }
            return true;
        }
        int size = this.f1108b.size();
        boolean zIsSelected = photo.isSelected();
        if (size + (zIsSelected ? -1 : 1) > maxCount) {
            Toast.makeText(context, context.getString(R.string.__picker_over_max_count_tips, Integer.valueOf(maxCount)), 1).show();
            return false;
        }
        a(photo);
        if (zIsSelected) {
            removeUnselected(photo);
        } else {
            addSelected(photo);
        }
        return true;
    }
}
