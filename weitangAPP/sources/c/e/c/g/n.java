package c.e.c.g;

import android.app.Activity;
import android.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import c.e.a.d.x;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.sign.vo.ResponseConfirmContactVo;

/* JADX INFO: loaded from: classes.dex */
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile n f1458a;

    public static /* synthetic */ void a(AlertDialog alertDialog, View.OnClickListener onClickListener, View view) {
        alertDialog.dismiss();
        onClickListener.onClick(view);
    }

    public static /* synthetic */ void b(AlertDialog alertDialog, View.OnClickListener onClickListener, View view) {
        alertDialog.dismiss();
        onClickListener.onClick(view);
    }

    public static /* synthetic */ void c(AlertDialog alertDialog, View.OnClickListener onClickListener, View view) {
        alertDialog.dismiss();
        onClickListener.onClick(view);
    }

    public static /* synthetic */ void d(AlertDialog alertDialog, View.OnClickListener onClickListener, View view) {
        alertDialog.dismiss();
        onClickListener.onClick(view);
    }

    public static /* synthetic */ void e(AlertDialog alertDialog, View.OnClickListener onClickListener, View view) {
        alertDialog.dismiss();
        onClickListener.onClick(view);
    }

    public static /* synthetic */ void f(AlertDialog alertDialog, View.OnClickListener onClickListener, View view) {
        alertDialog.dismiss();
        onClickListener.onClick(view);
    }

    public static /* synthetic */ void g(AlertDialog alertDialog, View.OnClickListener onClickListener, View view) {
        alertDialog.dismiss();
        onClickListener.onClick(view);
    }

    public static synchronized n getInstance() {
        if (f1458a == null) {
            synchronized (n.class) {
                if (f1458a == null) {
                    f1458a = new n();
                }
            }
        }
        return f1458a;
    }

    public static /* synthetic */ void i(View.OnClickListener onClickListener, AlertDialog alertDialog, View view) {
        onClickListener.onClick(view);
        alertDialog.dismiss();
    }

    public static /* synthetic */ void j(AlertDialog alertDialog, View.OnClickListener onClickListener, View view) {
        alertDialog.dismiss();
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    public static /* synthetic */ void k(AlertDialog alertDialog, View.OnClickListener onClickListener, View view) {
        alertDialog.dismiss();
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    public static /* synthetic */ void l(AlertDialog alertDialog, View.OnClickListener onClickListener, View view) {
        alertDialog.dismiss();
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    public final void m(TextView textView, String str) {
        if (x.isNullStr(str)) {
            return;
        }
        textView.setText(str);
    }

    public AlertDialog showAlert(Activity activity, String str, String str2, String str3, String str4, View.OnClickListener onClickListener) {
        return showAlert(activity, str, str2, str3, str4, onClickListener, true);
    }

    public AlertDialog showAlertBig(Activity activity, String str, String str2, String str3, String str4, final View.OnClickListener onClickListener, boolean z) {
        View viewInflate = LayoutInflater.from(activity).inflate(R.layout.item_alert_confirm_cancel_big_layout, (ViewGroup) null);
        TextView textView = (TextView) viewInflate.findViewById(R.id.tv_title);
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.tv_content);
        TextView textView3 = (TextView) viewInflate.findViewById(R.id.tv_alert_cancel);
        TextView textView4 = (TextView) viewInflate.findViewById(R.id.tv_alert_confirm);
        TextView textView5 = (TextView) viewInflate.findViewById(R.id.tv_center_line);
        m(textView, str);
        m(textView2, str2);
        m(textView3, str4);
        m(textView4, str3);
        textView3.setVisibility(z ? 8 : 0);
        textView5.setVisibility(z ? 4 : 0);
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setView(viewInflate);
        final AlertDialog alertDialogCreate = builder.create();
        if (z) {
            alertDialogCreate.setCancelable(false);
            alertDialogCreate.setCanceledOnTouchOutside(false);
        }
        alertDialogCreate.getWindow().setBackgroundDrawableResource(R.drawable.bg_alert);
        alertDialogCreate.show();
        textView3.setOnClickListener(new View.OnClickListener() { // from class: c.e.c.g.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                n.c(alertDialogCreate, onClickListener, view);
            }
        });
        textView4.setOnClickListener(new View.OnClickListener() { // from class: c.e.c.g.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                n.d(alertDialogCreate, onClickListener, view);
            }
        });
        WindowManager.LayoutParams attributes = alertDialogCreate.getWindow().getAttributes();
        attributes.width = activity.getResources().getDimensionPixelSize(R.dimen.dp_250);
        attributes.height = activity.getResources().getDimensionPixelSize(R.dimen.dp_180);
        alertDialogCreate.getWindow().setAttributes(attributes);
        return alertDialogCreate;
    }

    public AlertDialog showAlertPhoto(Activity activity, final View.OnClickListener onClickListener) {
        View viewInflate = LayoutInflater.from(activity).inflate(R.layout.item_alert_select_photo_layout, (ViewGroup) null);
        TextView textView = (TextView) viewInflate.findViewById(R.id.tv_alert_photo_select);
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.tv_alert_camera);
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setView(viewInflate);
        final AlertDialog alertDialogCreate = builder.create();
        alertDialogCreate.getWindow().setBackgroundDrawableResource(R.drawable.bg_alert);
        alertDialogCreate.show();
        textView.setOnClickListener(new View.OnClickListener() { // from class: c.e.c.g.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                n.e(alertDialogCreate, onClickListener, view);
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() { // from class: c.e.c.g.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                n.f(alertDialogCreate, onClickListener, view);
            }
        });
        WindowManager.LayoutParams attributes = alertDialogCreate.getWindow().getAttributes();
        attributes.width = activity.getResources().getDimensionPixelSize(R.dimen.dp_250);
        attributes.height = activity.getResources().getDimensionPixelSize(R.dimen.dp_178);
        alertDialogCreate.getWindow().setAttributes(attributes);
        return alertDialogCreate;
    }

    public AlertDialog showAlertUnCancel(Activity activity, String str, String str2, String str3, String str4, final View.OnClickListener onClickListener) {
        View viewInflate = LayoutInflater.from(activity).inflate(R.layout.item_alert_confirm_cancel_layout, (ViewGroup) null);
        TextView textView = (TextView) viewInflate.findViewById(R.id.tv_title);
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.tv_content);
        TextView textView3 = (TextView) viewInflate.findViewById(R.id.tv_alert_cancel);
        TextView textView4 = (TextView) viewInflate.findViewById(R.id.tv_alert_confirm);
        m(textView, str);
        m(textView2, str2);
        m(textView3, str4);
        m(textView4, str3);
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setView(viewInflate);
        final AlertDialog alertDialogCreate = builder.create();
        alertDialogCreate.getWindow().setBackgroundDrawableResource(R.drawable.bg_alert);
        alertDialogCreate.setCancelable(false);
        alertDialogCreate.setCanceledOnTouchOutside(false);
        alertDialogCreate.show();
        textView3.setOnClickListener(new View.OnClickListener() { // from class: c.e.c.g.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                n.g(alertDialogCreate, onClickListener, view);
            }
        });
        textView4.setOnClickListener(new View.OnClickListener() { // from class: c.e.c.g.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                onClickListener.onClick(view);
            }
        });
        WindowManager.LayoutParams attributes = alertDialogCreate.getWindow().getAttributes();
        attributes.width = activity.getResources().getDimensionPixelSize(R.dimen.dp_250);
        attributes.height = activity.getResources().getDimensionPixelSize(R.dimen.dp_136);
        alertDialogCreate.getWindow().setAttributes(attributes);
        return alertDialogCreate;
    }

    public AlertDialog showAppVersionAlert(Activity activity, final View.OnClickListener onClickListener, String str) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        View viewInflate = LayoutInflater.from(activity).inflate(R.layout.alert_exit_rent_layout, (ViewGroup) null);
        Button button = (Button) viewInflate.findViewById(R.id.btn_alert_confirm);
        TextView textView = (TextView) viewInflate.findViewById(R.id.tv_alert_title);
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.tv_alert_content);
        builder.setView(viewInflate);
        textView.setText(x.getString(R.string.tip_version_update));
        textView2.setText(x.getNotNullStr(str, x.getString(R.string.default_app_update_tip)));
        final AlertDialog alertDialogCreate = builder.create();
        alertDialogCreate.getWindow().setBackgroundDrawableResource(R.drawable.bg_alert);
        button.setOnClickListener(new View.OnClickListener() { // from class: c.e.c.g.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                n.j(alertDialogCreate, onClickListener, view);
            }
        });
        alertDialogCreate.show();
        WindowManager.LayoutParams attributes = alertDialogCreate.getWindow().getAttributes();
        attributes.width = activity.getResources().getDimensionPixelSize(R.dimen.dp_276);
        attributes.height = activity.getResources().getDimensionPixelSize(R.dimen.dp_300);
        alertDialogCreate.getWindow().setAttributes(attributes);
        return alertDialogCreate;
    }

    public AlertDialog showAuthAlert(Activity activity, View.OnClickListener onClickListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        View viewInflate = LayoutInflater.from(activity).inflate(R.layout.alert_tip_auth_layout, (ViewGroup) null);
        ((Button) viewInflate.findViewById(R.id.btn_alert_confirm)).setOnClickListener(onClickListener);
        ((Button) viewInflate.findViewById(R.id.btn_alert_cancel)).setOnClickListener(onClickListener);
        builder.setView(viewInflate);
        AlertDialog alertDialogCreate = builder.create();
        alertDialogCreate.getWindow().setBackgroundDrawableResource(R.drawable.bg_alert);
        alertDialogCreate.show();
        WindowManager.LayoutParams attributes = alertDialogCreate.getWindow().getAttributes();
        attributes.width = activity.getResources().getDimensionPixelSize(R.dimen.dp_276);
        attributes.height = activity.getResources().getDimensionPixelSize(R.dimen.dp_345);
        alertDialogCreate.getWindow().setAttributes(attributes);
        return alertDialogCreate;
    }

    public AlertDialog showCleanPaySuccessAlert(Activity activity, View.OnClickListener onClickListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        View viewInflate = LayoutInflater.from(activity).inflate(R.layout.alert_clean_pay_success_layout, (ViewGroup) null);
        ((Button) viewInflate.findViewById(R.id.btn_alert_clean_success_confirm)).setOnClickListener(onClickListener);
        builder.setView(viewInflate);
        builder.setCancelable(false);
        AlertDialog alertDialogCreate = builder.create();
        alertDialogCreate.setCanceledOnTouchOutside(false);
        alertDialogCreate.getWindow().setBackgroundDrawableResource(R.drawable.bg_alert);
        alertDialogCreate.show();
        WindowManager.LayoutParams attributes = alertDialogCreate.getWindow().getAttributes();
        attributes.width = activity.getResources().getDimensionPixelSize(R.dimen.dp_276);
        attributes.height = activity.getResources().getDimensionPixelSize(R.dimen.dp_300);
        alertDialogCreate.getWindow().setAttributes(attributes);
        return alertDialogCreate;
    }

    public AlertDialog showExitRentAlert(Activity activity, View.OnClickListener onClickListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        View viewInflate = LayoutInflater.from(activity).inflate(R.layout.alert_exit_rent_layout, (ViewGroup) null);
        ((Button) viewInflate.findViewById(R.id.btn_alert_confirm)).setOnClickListener(onClickListener);
        builder.setView(viewInflate);
        AlertDialog alertDialogCreate = builder.create();
        alertDialogCreate.getWindow().setBackgroundDrawableResource(R.drawable.bg_alert);
        alertDialogCreate.show();
        WindowManager.LayoutParams attributes = alertDialogCreate.getWindow().getAttributes();
        attributes.width = activity.getResources().getDimensionPixelSize(R.dimen.dp_276);
        attributes.height = activity.getResources().getDimensionPixelSize(R.dimen.dp_300);
        alertDialogCreate.getWindow().setAttributes(attributes);
        return alertDialogCreate;
    }

    public AlertDialog showPayInfoAlert(Activity activity, View.OnClickListener onClickListener, ResponseConfirmContactVo responseConfirmContactVo) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        View viewInflate = LayoutInflater.from(activity).inflate(R.layout.alert_pay_info_layout, (ViewGroup) null);
        TextView textView = (TextView) viewInflate.findViewById(R.id.tv_pay_info_count_value);
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.tv_pay_info_despite_value);
        TextView textView3 = (TextView) viewInflate.findViewById(R.id.tv_pay_info_manger_fee_value);
        TextView textView4 = (TextView) viewInflate.findViewById(R.id.tv_pay_info_count_fee_value);
        textView.setText(x.appendStringToResId(R.string.placeholder_rmb_china_unit, x.bigDecimalToString(responseConfirmContactVo.getRentTotalFee())));
        textView2.setText(x.appendStringToResId(R.string.placeholder_rmb_china_unit, x.bigDecimalToString(responseConfirmContactVo.getDepositFee())));
        textView3.setText(x.appendStringToResId(R.string.placeholder_rmb_china_unit, x.bigDecimalToString(responseConfirmContactVo.getManagementFee())));
        textView4.setText(x.appendStringToResId(R.string.placeholder_rmb_china_unit, x.bigDecimalToString(responseConfirmContactVo.getPayFee())));
        ((Button) viewInflate.findViewById(R.id.btn_alert_confirm)).setOnClickListener(onClickListener);
        builder.setView(viewInflate);
        AlertDialog alertDialogCreate = builder.create();
        alertDialogCreate.getWindow().setBackgroundDrawableResource(R.drawable.bg_alert);
        alertDialogCreate.show();
        WindowManager.LayoutParams attributes = alertDialogCreate.getWindow().getAttributes();
        attributes.width = activity.getResources().getDimensionPixelSize(R.dimen.dp_276);
        attributes.height = activity.getResources().getDimensionPixelSize(R.dimen.dp_370);
        alertDialogCreate.getWindow().setAttributes(attributes);
        return alertDialogCreate;
    }

    public AlertDialog showPhotoAlert(Activity activity, final View.OnClickListener onClickListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        View viewInflate = LayoutInflater.from(activity).inflate(R.layout.alert_photo_camera, (ViewGroup) null);
        Button button = (Button) viewInflate.findViewById(R.id.btn_alert_photo);
        Button button2 = (Button) viewInflate.findViewById(R.id.btn_alert_camera);
        builder.setView(viewInflate);
        final AlertDialog alertDialogCreate = builder.create();
        alertDialogCreate.getWindow().setBackgroundDrawableResource(R.drawable.bg_alert);
        alertDialogCreate.show();
        button.setOnClickListener(new View.OnClickListener() { // from class: c.e.c.g.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                n.k(alertDialogCreate, onClickListener, view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: c.e.c.g.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                n.l(alertDialogCreate, onClickListener, view);
            }
        });
        WindowManager.LayoutParams attributes = alertDialogCreate.getWindow().getAttributes();
        attributes.width = activity.getResources().getDimensionPixelSize(R.dimen.dp_276);
        attributes.height = activity.getResources().getDimensionPixelSize(R.dimen.dp_276);
        alertDialogCreate.getWindow().setAttributes(attributes);
        return alertDialogCreate;
    }

    public AlertDialog showAlert(Activity activity, String str, String str2, String str3, String str4, final View.OnClickListener onClickListener, boolean z) {
        View viewInflate = LayoutInflater.from(activity).inflate(R.layout.item_alert_confirm_cancel_layout, (ViewGroup) null);
        TextView textView = (TextView) viewInflate.findViewById(R.id.tv_title);
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.tv_content);
        TextView textView3 = (TextView) viewInflate.findViewById(R.id.tv_alert_cancel);
        TextView textView4 = (TextView) viewInflate.findViewById(R.id.tv_alert_confirm);
        m(textView, str);
        m(textView2, str2);
        m(textView3, str4);
        m(textView4, str3);
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setView(viewInflate);
        final AlertDialog alertDialogCreate = builder.create();
        alertDialogCreate.getWindow().setBackgroundDrawableResource(R.drawable.bg_alert);
        alertDialogCreate.setCancelable(z);
        alertDialogCreate.show();
        textView3.setOnClickListener(new View.OnClickListener() { // from class: c.e.c.g.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                n.a(alertDialogCreate, onClickListener, view);
            }
        });
        textView4.setOnClickListener(new View.OnClickListener() { // from class: c.e.c.g.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                n.b(alertDialogCreate, onClickListener, view);
            }
        });
        WindowManager.LayoutParams attributes = alertDialogCreate.getWindow().getAttributes();
        attributes.width = activity.getResources().getDimensionPixelSize(R.dimen.dp_250);
        attributes.height = activity.getResources().getDimensionPixelSize(R.dimen.dp_136);
        alertDialogCreate.getWindow().setAttributes(attributes);
        return alertDialogCreate;
    }

    public AlertDialog showAlertUnCancel(Activity activity, String str, String str2, String str3, final View.OnClickListener onClickListener) {
        View viewInflate = LayoutInflater.from(activity).inflate(R.layout.item_alert_confirm_layout, (ViewGroup) null);
        TextView textView = (TextView) viewInflate.findViewById(R.id.tv_title);
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.tv_content);
        TextView textView3 = (TextView) viewInflate.findViewById(R.id.tv_alert_confirm);
        m(textView, str);
        m(textView2, str2);
        m(textView3, str3);
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setView(viewInflate);
        final AlertDialog alertDialogCreate = builder.create();
        alertDialogCreate.getWindow().setBackgroundDrawableResource(R.drawable.bg_alert);
        alertDialogCreate.setCancelable(false);
        alertDialogCreate.setCanceledOnTouchOutside(false);
        alertDialogCreate.show();
        textView3.setOnClickListener(new View.OnClickListener() { // from class: c.e.c.g.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                n.i(onClickListener, alertDialogCreate, view);
            }
        });
        WindowManager.LayoutParams attributes = alertDialogCreate.getWindow().getAttributes();
        attributes.width = activity.getResources().getDimensionPixelSize(R.dimen.dp_250);
        attributes.height = activity.getResources().getDimensionPixelSize(R.dimen.dp_180);
        alertDialogCreate.getWindow().setAttributes(attributes);
        return alertDialogCreate;
    }
}
