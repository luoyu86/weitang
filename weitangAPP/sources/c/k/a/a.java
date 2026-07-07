package c.k.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;
import androidx.core.content.FileProvider;
import c.k.a.e.c;
import c.k.a.e.d;
import com.lzy.imagepicker.R;
import com.lzy.imagepicker.bean.ImageItem;
import com.lzy.imagepicker.view.CropImageView;
import com.tom_roush.fontbox.ttf.OS2WindowsMetricsTable;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f2771a = "a";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile a f2772b;
    public c.k.a.d.a l;
    public File n;
    public File o;
    public List<c.k.a.c.a> r;
    public List<InterfaceC0039a> t;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f2773c = true;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f2774d = 9;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f2775e = true;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f2776f = true;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f2777g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f2778h = OS2WindowsMetricsTable.WEIGHT_CLASS_EXTRA_BOLD;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f2779i = OS2WindowsMetricsTable.WEIGHT_CLASS_EXTRA_BOLD;
    public int j = 280;
    public int k = 280;
    public CropImageView.e m = CropImageView.e.RECTANGLE;
    public ArrayList<ImageItem> p = new ArrayList<>();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public ArrayList<String> f2780q = new ArrayList<>();
    public int s = 0;

    /* JADX INFO: renamed from: c.k.a.a$a, reason: collision with other inner class name */
    public interface InterfaceC0039a {
        void onImageSelected(int i2, ImageItem imageItem, boolean z);
    }

    public static File createFile(File file, String str, String str2) {
        if (!file.exists() || !file.isDirectory()) {
            file.mkdirs();
        }
        return new File(file, str + new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.CHINA).format(new Date(System.currentTimeMillis())) + str2);
    }

    public static void galleryAddPic(Context context, File file) {
        try {
            Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
            intent.setData(Uri.fromFile(file));
            context.sendBroadcast(intent);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static synchronized a getInstance() {
        if (f2772b == null) {
            synchronized (a.class) {
                if (f2772b == null) {
                    f2772b = new a();
                }
            }
        }
        return f2772b;
    }

    public final void a(int i2, ImageItem imageItem, boolean z) {
        List<InterfaceC0039a> list = this.t;
        if (list == null) {
            return;
        }
        Iterator<InterfaceC0039a> it = list.iterator();
        while (it.hasNext()) {
            it.next().onImageSelected(i2, imageItem, z);
        }
    }

    public void addOnImageSelectedListener(InterfaceC0039a interfaceC0039a) {
        if (this.t == null) {
            this.t = new ArrayList();
        }
        this.t.add(interfaceC0039a);
    }

    public void addSelectedImageItem(int i2, ImageItem imageItem, boolean z) {
        if (z) {
            this.p.add(imageItem);
            this.f2780q.add(imageItem.path);
        } else {
            removeImageItem(imageItem.path);
        }
        a(i2, imageItem, z);
    }

    public void clear() {
        Log.d(a.class.getSimpleName(), "clear");
        List<InterfaceC0039a> list = this.t;
        if (list != null) {
            list.clear();
            this.t = null;
        }
        List<c.k.a.c.a> list2 = this.r;
        if (list2 != null) {
            list2.clear();
            this.r = null;
        }
        ArrayList<ImageItem> arrayList = this.p;
        if (arrayList != null) {
            arrayList.clear();
        }
        this.f2780q.clear();
        this.s = 0;
    }

    public void clearSelectedImages() {
        ArrayList<ImageItem> arrayList = this.p;
        if (arrayList != null) {
            arrayList.clear();
        }
        this.f2780q.clear();
    }

    public File getCropCacheFolder(Context context) {
        if (this.n == null) {
            this.n = new File(context.getCacheDir() + "/ImagePicker/cropTemp/");
        }
        return this.n;
    }

    public ArrayList<ImageItem> getCurrentImageFolderItems() {
        List<c.k.a.c.a> list = this.r;
        if (list == null || list.isEmpty()) {
            this.r = new ArrayList();
            c.k.a.c.a aVar = new c.k.a.c.a();
            aVar.name = "所有";
            this.r.add(aVar);
        }
        return this.r.get(this.s).images;
    }

    public int getCurrentImageFolderPosition() {
        return this.s;
    }

    public int getFocusHeight() {
        return this.k;
    }

    public int getFocusWidth() {
        return this.j;
    }

    public List<c.k.a.c.a> getImageFolders() {
        return this.r;
    }

    public c.k.a.d.a getImageLoader() {
        return this.l;
    }

    public int getOutPutX() {
        return this.f2778h;
    }

    public int getOutPutY() {
        return this.f2779i;
    }

    public int getSelectImageCount() {
        ArrayList<ImageItem> arrayList = this.p;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public int getSelectLimit() {
        return this.f2774d;
    }

    public ArrayList<ImageItem> getSelectedImages() {
        return this.p;
    }

    public CropImageView.e getStyle() {
        return this.m;
    }

    public File getTakeImageFile() {
        return this.o;
    }

    public boolean isCrop() {
        return this.f2775e;
    }

    public boolean isMultiMode() {
        return this.f2773c;
    }

    public boolean isSaveRectangle() {
        return this.f2777g;
    }

    public boolean isSelect(ImageItem imageItem) {
        return isSelectPath(imageItem.path);
    }

    public boolean isSelectPath(String str) {
        return this.f2780q.contains(str);
    }

    public boolean isShowCamera() {
        return this.f2776f;
    }

    public void removeImageItem(String str) {
        int size = this.p.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                i2 = -1;
                break;
            } else if (this.p.get(i2).path.equals(str)) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 != -1) {
            this.p.remove(i2);
        }
        this.f2780q.remove(str);
    }

    public void removeOnImageSelectedListener(InterfaceC0039a interfaceC0039a) {
        List<InterfaceC0039a> list = this.t;
        if (list == null) {
            return;
        }
        list.remove(interfaceC0039a);
    }

    public void restoreInstanceState(Bundle bundle) {
    }

    public void saveInstanceState(Bundle bundle) {
    }

    public void setCrop(boolean z) {
        this.f2775e = z;
    }

    public void setCropCacheFolder(File file) {
        this.n = file;
    }

    public void setCurrentImageFolderPosition(int i2) {
        this.s = i2;
    }

    public void setFocusHeight(int i2) {
        this.k = i2;
    }

    public void setFocusWidth(int i2) {
        this.j = i2;
    }

    public void setImageFolders(List<c.k.a.c.a> list) {
        this.r = list;
        Log.d(a.class.getSimpleName(), "setImageFolders");
    }

    public void setImageLoader(c.k.a.d.a aVar) {
        this.l = aVar;
    }

    public void setMultiMode(boolean z) {
        this.f2773c = z;
    }

    public void setOutPutX(int i2) {
        this.f2778h = i2;
    }

    public void setOutPutY(int i2) {
        this.f2779i = i2;
    }

    public void setSaveRectangle(boolean z) {
        this.f2777g = z;
    }

    public void setSelectLimit(int i2) {
        this.f2774d = i2;
    }

    public void setSelectedImages(ArrayList<ImageItem> arrayList) {
        if (arrayList == null) {
            return;
        }
        this.p = arrayList;
    }

    public void setShowCamera(boolean z) {
        this.f2776f = z;
    }

    public void setStyle(CropImageView.e eVar) {
        this.m = eVar;
    }

    public void takePicture(Activity activity, int i2) {
        Uri uriForFile;
        if (this.p.size() >= getSelectLimit()) {
            Toast.makeText(activity.getApplicationContext(), activity.getString(R.string.ip_select_limit, new Object[]{Integer.valueOf(getSelectLimit())}), 0).show();
            return;
        }
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        intent.setFlags(67108864);
        if (intent.resolveActivity(activity.getPackageManager()) != null) {
            if (d.existSDCard()) {
                this.o = new File(Environment.getExternalStorageDirectory(), "/DCIM/camera/");
            } else {
                this.o = Environment.getDataDirectory();
            }
            File fileCreateFile = createFile(this.o, "IMG_", ".jpg");
            this.o = fileCreateFile;
            if (fileCreateFile != null) {
                Log.d(f2771a, "takeImageFile = " + this.o.getAbsolutePath());
                if (Build.VERSION.SDK_INT <= 23) {
                    uriForFile = Uri.fromFile(this.o);
                } else {
                    uriForFile = FileProvider.getUriForFile(activity, c.getFileProviderName(activity), this.o);
                    Iterator<ResolveInfo> it = activity.getPackageManager().queryIntentActivities(intent, 65536).iterator();
                    while (it.hasNext()) {
                        activity.grantUriPermission(it.next().activityInfo.packageName, uriForFile, 3);
                    }
                }
                intent.putExtra("output", uriForFile);
            }
        }
        activity.startActivityForResult(intent, i2);
    }
}
