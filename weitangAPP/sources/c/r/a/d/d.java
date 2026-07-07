package c.r.a.d;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.bytedance.pangle.servermanager.AbsServerManager;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class d {
    public static boolean checkPermissionFirst(Context context, int i2, String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            if (ContextCompat.checkSelfPermission(context, str) != 0) {
                arrayList.add(str);
            }
        }
        if (arrayList.isEmpty()) {
            return true;
        }
        ActivityCompat.requestPermissions((Activity) context, (String[]) arrayList.toArray(new String[arrayList.size()]), i2);
        return false;
    }

    public static boolean checkPermissionSecond(Context context, int i2, String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            if (ContextCompat.checkSelfPermission(context, str) != 0) {
                arrayList.add(str);
            }
        }
        if (arrayList.isEmpty()) {
            return true;
        }
        ActivityCompat.requestPermissions((Activity) context, (String[]) arrayList.toArray(new String[arrayList.size()]), i2);
        Intent intent = new Intent();
        intent.addFlags(268435456);
        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts(AbsServerManager.PACKAGE_QUERY_BINDER, context.getPackageName(), null));
        context.startActivity(intent);
        return false;
    }
}
