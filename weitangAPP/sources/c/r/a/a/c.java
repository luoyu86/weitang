package c.r.a.a;

import android.app.Activity;
import android.content.Intent;
import androidx.fragment.app.Fragment;
import com.wildma.idcardcamera.camera.CameraActivity;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<Activity> f3142a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WeakReference<Fragment> f3143b;

    public c(Activity activity) {
        this(activity, null);
    }

    public static c create(Activity activity) {
        return new c(activity);
    }

    public static String getImagePath(Intent intent) {
        return intent != null ? intent.getStringExtra("image_path") : "";
    }

    public void openCamera(int i2) {
        Activity activity = this.f3142a.get();
        Fragment fragment = this.f3143b.get();
        Intent intent = new Intent(activity, (Class<?>) CameraActivity.class);
        intent.putExtra("take_type", i2);
        if (fragment != null) {
            fragment.startActivityForResult(intent, i2);
        } else {
            activity.startActivityForResult(intent, i2);
        }
    }

    public c(Fragment fragment) {
        this(fragment.getActivity(), fragment);
    }

    public static c create(Fragment fragment) {
        return new c(fragment);
    }

    public c(Activity activity, Fragment fragment) {
        this.f3142a = new WeakReference<>(activity);
        this.f3143b = new WeakReference<>(fragment);
    }
}
