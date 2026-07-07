package c.e.a.d;

import android.app.AlertDialog;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import com.chinavisionary.core.R;

/* JADX INFO: loaded from: classes.dex */
public class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile p f1223a;

    public static synchronized p getInstance() {
        if (f1223a == null && f1223a == null) {
            synchronized (p.class) {
                f1223a = new p();
            }
        }
        return f1223a;
    }

    public AlertDialog showLoadDialog(Context context, String str) {
        return showLoadDialog(context, str, true);
    }

    public AlertDialog showLoadDialog(Context context, String str, boolean z) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.dialog_loading, (ViewGroup) null);
        TextView textView = (TextView) viewInflate.findViewById(R.id.tv_tip);
        textView.setVisibility(0);
        textView.setText(str);
        builder.setCancelable(z);
        builder.setView(viewInflate);
        AlertDialog alertDialogCreate = builder.create();
        alertDialogCreate.setCanceledOnTouchOutside(false);
        alertDialogCreate.getWindow().setBackgroundDrawableResource(R.drawable.bg_load_alert);
        alertDialogCreate.show();
        WindowManager.LayoutParams attributes = alertDialogCreate.getWindow().getAttributes();
        Resources resources = context.getResources();
        int i2 = R.dimen.dp_130;
        attributes.width = resources.getDimensionPixelSize(i2);
        attributes.height = context.getResources().getDimensionPixelSize(i2);
        return alertDialogCreate;
    }
}
