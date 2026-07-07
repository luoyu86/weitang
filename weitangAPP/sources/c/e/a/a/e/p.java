package c.e.a.a.e;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import c.e.a.d.a0;
import c.e.a.d.x;
import com.chinavisionary.core.R;
import com.chinavisionary.core.app.dialog.AlertParamVo;

/* JADX INFO: loaded from: classes.dex */
public class p {

    public class a implements DialogInterface.OnShowListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ EditText f990a;

        public a(EditText editText) {
            this.f990a = editText;
        }

        @Override // android.content.DialogInterface.OnShowListener
        public void onShow(DialogInterface dialogInterface) {
            final EditText editText = this.f990a;
            editText.postDelayed(new Runnable() { // from class: c.e.a.a.e.a
                @Override // java.lang.Runnable
                public final void run() {
                    EditText editText2 = editText;
                    ((InputMethodManager) editText2.getContext().getSystemService("input_method")).showSoftInput(editText2, 0);
                }
            }, 100L);
        }
    }

    public class b implements DialogInterface.OnShowListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ EditText f991a;

        public b(EditText editText) {
            this.f991a = editText;
        }

        @Override // android.content.DialogInterface.OnShowListener
        public void onShow(DialogInterface dialogInterface) {
            final EditText editText = this.f991a;
            editText.postDelayed(new Runnable() { // from class: c.e.a.a.e.b
                @Override // java.lang.Runnable
                public final void run() {
                    EditText editText2 = editText;
                    ((InputMethodManager) editText2.getContext().getSystemService("input_method")).showSoftInput(editText2, 0);
                }
            }, 100L);
        }
    }

    public static /* synthetic */ void a(AlertDialog alertDialog, View.OnClickListener onClickListener, View view) {
        alertDialog.dismiss();
        onClickListener.onClick(view);
    }

    public static /* synthetic */ void b(AlertDialog alertDialog, View.OnClickListener onClickListener, View view) {
        alertDialog.dismiss();
        onClickListener.onClick(view);
    }

    public static /* synthetic */ void c(AlertDialog alertDialog, AlertParamVo alertParamVo, View view) {
        alertDialog.dismiss();
        alertParamVo.getOnClickListener().onClick(view);
    }

    public static /* synthetic */ void d(EditText editText, AlertParamVo alertParamVo, AlertDialog alertDialog, View view) {
        String string = editText.getText().toString();
        if (alertParamVo.isContentCanIsEmpty()) {
            view.setTag(string);
            alertDialog.dismiss();
            alertParamVo.getOnClickListener().onClick(view);
        } else {
            if (!x.isNotNull(string)) {
                a0.showToast(view.getContext(), R.string.core_lib_tip_input_empty);
                return;
            }
            view.setTag(string);
            alertDialog.dismiss();
            alertParamVo.getOnClickListener().onClick(view);
        }
    }

    public static /* synthetic */ void e(AlertDialog alertDialog, AlertParamVo alertParamVo, View view) {
        alertDialog.dismiss();
        alertParamVo.getOnClickListener().onClick(view);
    }

    public static /* synthetic */ void f(EditText editText, AlertParamVo alertParamVo, AlertDialog alertDialog, View view) {
        String string = editText.getText().toString();
        if (alertParamVo.isContentCanIsEmpty()) {
            view.setTag(string);
            alertDialog.dismiss();
            alertParamVo.getOnClickListener().onClick(view);
        } else {
            if (!x.isNotNull(string)) {
                a0.showToast(view.getContext(), R.string.core_lib_tip_input_empty);
                return;
            }
            view.setTag(string);
            alertDialog.dismiss();
            alertParamVo.getOnClickListener().onClick(view);
        }
    }

    public static /* synthetic */ void g(AlertDialog alertDialog, View.OnClickListener onClickListener, View view) {
        alertDialog.dismiss();
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    public static /* synthetic */ void h(AlertDialog alertDialog, View.OnClickListener onClickListener, View view) {
        alertDialog.dismiss();
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    public static /* synthetic */ void i(AlertDialog alertDialog, View.OnClickListener onClickListener, View view) {
        alertDialog.dismiss();
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
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

    public static void m(TextView textView, String str) {
        if (x.isNullStr(str)) {
            return;
        }
        textView.setText(str);
    }

    public static AlertDialog showAlert(Activity activity, String str, String str2, String str3, String str4, View.OnClickListener onClickListener, boolean z) {
        return showAlert(activity, str, str2, str3, str4, onClickListener, z, false, 0);
    }

    public static AlertDialog showAlertOnlyConfirm(Activity activity, String str, String str2, String str3, String str4, View.OnClickListener onClickListener, boolean z) {
        return showAlert(activity, str, str2, str3, str4, onClickListener, z, true, 0);
    }

    public static AlertDialog showAlertTextColor(Activity activity, String str, String str2, String str3, String str4, View.OnClickListener onClickListener, boolean z) {
        return showAlert(activity, str, str2, str3, str4, onClickListener, z, false, R.color.color999999);
    }

    public static AlertDialog showBigInputAlert(final AlertParamVo alertParamVo) {
        View viewInflate = LayoutInflater.from(alertParamVo.getActivity()).inflate(R.layout.core_lib_alert_big_input_layout, (ViewGroup) null);
        TextView textView = (TextView) viewInflate.findViewById(R.id.tv_title);
        final EditText editText = (EditText) viewInflate.findViewById(R.id.core_lib_edt_input);
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.tv_alert_cancel);
        TextView textView3 = (TextView) viewInflate.findViewById(R.id.tv_alert_confirm);
        m(textView, alertParamVo.getTitle());
        m(textView2, alertParamVo.getCancel());
        m(textView3, alertParamVo.getConfirm());
        if (alertParamVo.getTitleFontSize() > 0.0f) {
            textView.setTextSize(alertParamVo.getTitleFontSize());
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(alertParamVo.getActivity());
        builder.setView(viewInflate);
        if (x.isNotNull(alertParamVo.getContent())) {
            editText.setText(alertParamVo.getContent());
        }
        if (x.isNotNull(alertParamVo.getHintText())) {
            editText.setHint(alertParamVo.getHintText());
        }
        editText.setInputType(alertParamVo.getInputType());
        editText.setFocusable(true);
        editText.setFocusableInTouchMode(true);
        editText.requestFocus();
        final AlertDialog alertDialogCreate = builder.create();
        alertDialogCreate.getWindow().setBackgroundDrawableResource(R.drawable.core_lib_bg_alert);
        alertDialogCreate.setCancelable(alertParamVo.isCancelable());
        alertDialogCreate.setOnShowListener(new b(editText));
        alertDialogCreate.show();
        textView2.setOnClickListener(new View.OnClickListener() { // from class: c.e.a.a.e.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                p.c(alertDialogCreate, alertParamVo, view);
            }
        });
        textView3.setOnClickListener(new View.OnClickListener() { // from class: c.e.a.a.e.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                p.d(editText, alertParamVo, alertDialogCreate, view);
            }
        });
        c.e.a.a.b.getInstance().setupGradModel(viewInflate);
        WindowManager.LayoutParams attributes = alertDialogCreate.getWindow().getAttributes();
        attributes.width = viewInflate.getResources().getDimensionPixelSize(R.dimen.dp_250);
        attributes.height = viewInflate.getResources().getDimensionPixelSize(R.dimen.dp_194);
        alertDialogCreate.getWindow().setAttributes(attributes);
        return alertDialogCreate;
    }

    public static AlertDialog showInputAlert(final AlertParamVo alertParamVo) {
        View viewInflate = LayoutInflater.from(alertParamVo.getActivity()).inflate(R.layout.core_lib_alert_input_layout, (ViewGroup) null);
        TextView textView = (TextView) viewInflate.findViewById(R.id.tv_title);
        final EditText editText = (EditText) viewInflate.findViewById(R.id.core_lib_edt_input);
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.tv_alert_cancel);
        TextView textView3 = (TextView) viewInflate.findViewById(R.id.tv_alert_confirm);
        m(textView, alertParamVo.getTitle());
        m(textView2, alertParamVo.getCancel());
        m(textView3, alertParamVo.getConfirm());
        AlertDialog.Builder builder = new AlertDialog.Builder(alertParamVo.getActivity());
        builder.setView(viewInflate);
        if (x.isNotNull(alertParamVo.getContent())) {
            editText.setText(alertParamVo.getContent());
        }
        if (x.isNotNull(alertParamVo.getHintText())) {
            editText.setHint(alertParamVo.getHintText());
        }
        editText.setInputType(alertParamVo.getInputType());
        editText.setFocusable(true);
        editText.setFocusableInTouchMode(true);
        editText.requestFocus();
        final AlertDialog alertDialogCreate = builder.create();
        alertDialogCreate.getWindow().setBackgroundDrawableResource(R.drawable.core_lib_bg_alert);
        alertDialogCreate.setCancelable(alertParamVo.isCancelable());
        alertDialogCreate.setOnShowListener(new a(editText));
        alertDialogCreate.show();
        textView2.setOnClickListener(new View.OnClickListener() { // from class: c.e.a.a.e.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                p.e(alertDialogCreate, alertParamVo, view);
            }
        });
        textView3.setOnClickListener(new View.OnClickListener() { // from class: c.e.a.a.e.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                p.f(editText, alertParamVo, alertDialogCreate, view);
            }
        });
        c.e.a.a.b.getInstance().setupGradModel(viewInflate);
        WindowManager.LayoutParams attributes = alertDialogCreate.getWindow().getAttributes();
        attributes.width = viewInflate.getResources().getDimensionPixelSize(R.dimen.dp_250);
        attributes.height = viewInflate.getResources().getDimensionPixelSize(R.dimen.dp_144);
        alertDialogCreate.getWindow().setAttributes(attributes);
        return alertDialogCreate;
    }

    public static AlertDialog showMapAlert(Activity activity, final View.OnClickListener onClickListener) {
        View viewInflate = LayoutInflater.from(activity).inflate(R.layout.item_core_lib_alert_menu, (ViewGroup) null);
        TextView textView = (TextView) viewInflate.findViewById(R.id.tv_baidu);
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.tv_gd);
        TextView textView3 = (TextView) viewInflate.findViewById(R.id.tv_alert_cancel);
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setView(viewInflate);
        final AlertDialog alertDialogCreate = builder.create();
        alertDialogCreate.getWindow().setBackgroundDrawableResource(R.drawable.core_lib_bg_alert);
        alertDialogCreate.show();
        textView3.setOnClickListener(new View.OnClickListener() { // from class: c.e.a.a.e.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                p.g(alertDialogCreate, onClickListener, view);
            }
        });
        textView.setOnClickListener(new View.OnClickListener() { // from class: c.e.a.a.e.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                p.h(alertDialogCreate, onClickListener, view);
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() { // from class: c.e.a.a.e.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                p.i(alertDialogCreate, onClickListener, view);
            }
        });
        c.e.a.a.b.getInstance().setupGradModel(viewInflate);
        WindowManager.LayoutParams attributes = alertDialogCreate.getWindow().getAttributes();
        attributes.width = activity.getResources().getDimensionPixelSize(R.dimen.dp_250);
        attributes.height = activity.getResources().getDimensionPixelSize(R.dimen.dp_146);
        alertDialogCreate.getWindow().setAttributes(attributes);
        return alertDialogCreate;
    }

    public static AlertDialog showSharedAlert(Activity activity, final View.OnClickListener onClickListener) {
        View viewInflate = LayoutInflater.from(activity).inflate(R.layout.item_core_lib_alert_shared, (ViewGroup) null);
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.img_wx);
        ImageView imageView2 = (ImageView) viewInflate.findViewById(R.id.img_wx_timeline);
        TextView textView = (TextView) viewInflate.findViewById(R.id.tv_alert_cancel);
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setView(viewInflate);
        final AlertDialog alertDialogCreate = builder.create();
        alertDialogCreate.getWindow().setBackgroundDrawableResource(R.drawable.core_lib_bg_alert);
        alertDialogCreate.show();
        textView.setOnClickListener(new View.OnClickListener() { // from class: c.e.a.a.e.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                p.j(alertDialogCreate, onClickListener, view);
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() { // from class: c.e.a.a.e.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                p.k(alertDialogCreate, onClickListener, view);
            }
        });
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: c.e.a.a.e.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                p.l(alertDialogCreate, onClickListener, view);
            }
        });
        c.e.a.a.b.getInstance().setupGradModel(viewInflate);
        WindowManager.LayoutParams attributes = alertDialogCreate.getWindow().getAttributes();
        attributes.width = activity.getResources().getDimensionPixelSize(R.dimen.dp_250);
        attributes.height = activity.getResources().getDimensionPixelSize(R.dimen.dp_146);
        alertDialogCreate.getWindow().setAttributes(attributes);
        return alertDialogCreate;
    }

    public static AlertDialog showAlert(Activity activity, String str, String str2, String str3, String str4, final View.OnClickListener onClickListener, boolean z, boolean z2, int i2) {
        View viewInflate = LayoutInflater.from(activity).inflate(R.layout.core_lib_item_alert_confirm_cancel_layout, (ViewGroup) null);
        TextView textView = (TextView) viewInflate.findViewById(R.id.tv_title);
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.tv_content);
        TextView textView3 = (TextView) viewInflate.findViewById(R.id.tv_alert_cancel);
        TextView textView4 = (TextView) viewInflate.findViewById(R.id.tv_alert_confirm);
        TextView textView5 = (TextView) viewInflate.findViewById(R.id.tv_center_line);
        m(textView, str);
        m(textView2, str2);
        m(textView3, str4);
        m(textView4, str3);
        if (i2 > 0) {
            textView4.setTextColor(activity.getResources().getColor(i2));
        }
        if (z2) {
            textView3.setVisibility(8);
            textView5.setVisibility(8);
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setView(viewInflate);
        final AlertDialog alertDialogCreate = builder.create();
        alertDialogCreate.getWindow().setBackgroundDrawableResource(R.drawable.core_lib_bg_radius_alert);
        alertDialogCreate.setCancelable(z);
        alertDialogCreate.show();
        textView3.setOnClickListener(new View.OnClickListener() { // from class: c.e.a.a.e.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                p.a(alertDialogCreate, onClickListener, view);
            }
        });
        textView4.setOnClickListener(new View.OnClickListener() { // from class: c.e.a.a.e.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                p.b(alertDialogCreate, onClickListener, view);
            }
        });
        c.e.a.a.b.getInstance().setupGradModel(viewInflate);
        WindowManager.LayoutParams attributes = alertDialogCreate.getWindow().getAttributes();
        attributes.width = activity.getResources().getDimensionPixelSize(R.dimen.dp_250);
        attributes.height = activity.getResources().getDimensionPixelSize(R.dimen.dp_186);
        alertDialogCreate.getWindow().setAttributes(attributes);
        return alertDialogCreate;
    }
}
