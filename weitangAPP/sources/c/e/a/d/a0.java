package c.e.a.d;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import com.chinavisionary.core.R;

/* JADX INFO: loaded from: classes.dex */
public class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Toast f1176a;

    public static void cancelToast() {
        try {
            Toast toast = f1176a;
            if (toast != null) {
                toast.cancel();
                f1176a = null;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void showImage(Context context, int i2) {
        try {
            cancelToast();
            ImageView imageView = new ImageView(context);
            imageView.setBackgroundResource(i2);
            Toast toast = new Toast(context);
            f1176a = toast;
            toast.setGravity(17, 0, -60);
            f1176a.setView(imageView);
            f1176a.show();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void showLayout(Context context, int i2) {
        try {
            cancelToast();
            View viewInflate = View.inflate(context, i2, null);
            Toast toast = new Toast(context);
            f1176a = toast;
            toast.setGravity(17, 0, -60);
            f1176a.setView(viewInflate);
            f1176a.setDuration(0);
            f1176a.show();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void showToast(Context context, String str, int i2) {
        if (context != null) {
            try {
                if (x.isNotNull(str)) {
                    cancelToast();
                    Toast toastMakeText = Toast.makeText(context, str, i2);
                    toastMakeText.setGravity(17, 0, -30);
                    toastMakeText.show();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static Toast showToastFailed(Context context, @NonNull String str) {
        cancelToast();
        f1176a = new Toast(context);
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.layout_toast, (ViewGroup) null);
        ((ImageView) viewInflate.findViewById(R.id.iv_tip)).setImageResource(R.drawable.ic_tips_error);
        ((TextView) viewInflate.findViewById(R.id.tv_tip)).setText(str);
        f1176a.setView(viewInflate);
        f1176a.setGravity(17, 0, -60);
        f1176a.show();
        return f1176a;
    }

    public static Toast showToastSuccess(Context context, @NonNull String str) {
        cancelToast();
        f1176a = new Toast(context);
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.layout_toast, (ViewGroup) null);
        ((ImageView) viewInflate.findViewById(R.id.iv_tip)).setImageResource(R.drawable.ic_tips_success);
        ((TextView) viewInflate.findViewById(R.id.tv_tip)).setText(str);
        f1176a.setView(viewInflate);
        f1176a.setGravity(17, 0, -60);
        f1176a.show();
        return f1176a;
    }

    public static void showToast(Context context, int i2, int i3) {
        try {
            cancelToast();
            Toast toastMakeText = Toast.makeText(context, i2, i3);
            toastMakeText.setGravity(17, 0, -30);
            toastMakeText.show();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void showToast(Context context, String str) {
        if (!x.isNotNull(str) || v.getInstance().isRepeatedlyAction(str)) {
            return;
        }
        showToast(context, str, 0);
    }

    public static void showToast(Context context, int i2) {
        if (v.getInstance().isRepeatedlyAction(i2)) {
            return;
        }
        showToast(context, i2, 0);
    }
}
