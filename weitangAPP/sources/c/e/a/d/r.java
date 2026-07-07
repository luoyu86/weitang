package c.e.a.d;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import c.e.a.a.e.q;
import com.bytedance.pangle.servermanager.AbsServerManager;
import com.chinavisionary.core.R;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class r {

    public class a implements q.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f1225a;

        public a(Activity activity) {
            this.f1225a = activity;
        }

        @Override // c.e.a.a.e.q.c
        public void onClickButtonLeft() {
        }

        @Override // c.e.a.a.e.q.c
        public void onClickButtonRight() {
            r.startApplicationDetailsSettings(this.f1225a, 18);
        }
    }

    public interface b {
        void onPermissionsDenied(int i2, List<String> list, boolean z);

        void onPermissionsGranted(int i2, List<String> list, boolean z);
    }

    public static boolean a() {
        return Build.VERSION.SDK_INT >= 23;
    }

    public static boolean deniedRequestPermissionsAgain(@NonNull Activity activity, @NonNull String... strArr) {
        if (!a()) {
            return false;
        }
        for (String str : getDeniedPermissions(activity, strArr)) {
            if (ContextCompat.checkSelfPermission(activity, str) != -1 && !ActivityCompat.shouldShowRequestPermissionRationale(activity, str)) {
                return true;
            }
        }
        return false;
    }

    public static boolean getAudioPermissions(@NonNull Activity activity, int i2) {
        return requestPermissions(activity, i2, "android.permission.RECORD_AUDIO", "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE");
    }

    public static boolean getCallPhonePermissions(@NonNull Activity activity, int i2) {
        return requestPermissions(activity, i2, "android.permission.CALL_PHONE");
    }

    public static boolean getCameraPermissions(@NonNull Activity activity, int i2) {
        return requestPermissions(activity, i2, "android.permission.CAMERA", "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE");
    }

    public static boolean getContactsPermissions(@NonNull Activity activity, int i2) {
        return requestPermissions(activity, i2, "android.permission.READ_CONTACTS");
    }

    public static List<String> getDeniedPermissions(@NonNull Activity activity, @NonNull String... strArr) {
        if (!a()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            if (ContextCompat.checkSelfPermission(activity, str) != 0) {
                arrayList.add(str);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return arrayList;
    }

    public static boolean getExternalStoragePermissions(@NonNull Activity activity, int i2) {
        return requestPermissions(activity, i2, "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE");
    }

    public static boolean getInstallPermissions(@NonNull Activity activity, int i2) {
        return requestPermissions(activity, i2, "android.permission.REQUEST_INSTALL_PACKAGES");
    }

    public static boolean getLocationPermissions(@NonNull Activity activity, int i2) {
        return requestPermissions(activity, i2, "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION");
    }

    public static boolean getSendSMSPermissions(@NonNull Activity activity, int i2) {
        return requestPermissions(activity, i2, "android.permission.SEND_SMS");
    }

    public static boolean hasPermissions(@NonNull Activity activity, @NonNull String... strArr) {
        if (!a()) {
            return true;
        }
        for (String str : strArr) {
            if (ContextCompat.checkSelfPermission(activity, str) != 0) {
                return false;
            }
        }
        return true;
    }

    public static void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr, @NonNull b bVar) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i3 = 0; i3 < strArr.length; i3++) {
            String str = strArr[i3];
            if (iArr[i3] == 0) {
                arrayList.add(str);
            } else {
                arrayList2.add(str);
            }
        }
        if (bVar != null) {
            if (!arrayList.isEmpty()) {
                bVar.onPermissionsGranted(i2, arrayList, arrayList2.isEmpty());
            }
            if (arrayList2.isEmpty()) {
                return;
            }
            bVar.onPermissionsDenied(i2, arrayList2, arrayList.isEmpty());
        }
    }

    public static boolean requestPermissions(Activity activity, int i2, String... strArr) {
        if (!a() || hasPermissions(activity, strArr)) {
            return true;
        }
        if (deniedRequestPermissionsAgain(activity, strArr)) {
            startApplicationDetailsSettings(activity, i2);
            return false;
        }
        List<String> deniedPermissions = getDeniedPermissions(activity, strArr);
        if (deniedPermissions == null) {
            return false;
        }
        ActivityCompat.requestPermissions(activity, (String[]) deniedPermissions.toArray(new String[deniedPermissions.size()]), i2);
        return false;
    }

    public static void showAskDialog(Activity activity) {
        c.e.a.a.e.q qVar = new c.e.a.a.e.q(activity);
        qVar.setTitle("权限申请提示");
        qVar.setContent("刚才申请的权限您拒绝了，将影响您使用App，是否马上设置？");
        qVar.setButtonText(activity.getString(R.string.text_cancel), "去设置");
        qVar.setButtonTextColor(Color.parseColor("#FFBDBDBD"), Color.parseColor("#FF375BF1"));
        qVar.setOnClickButtonListener(new a(activity));
        qVar.show();
    }

    public static void startApplicationDetailsSettings(@NonNull Activity activity, int i2) {
        Intent intent = new Intent("android.settings.LOCATION_SOURCE_SETTINGS");
        intent.setData(Uri.fromParts(AbsServerManager.PACKAGE_QUERY_BINDER, activity.getPackageName(), null));
        activity.startActivityForResult(intent, i2);
    }

    public static String[] getLocationPermissions() {
        return new String[]{"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"};
    }
}
