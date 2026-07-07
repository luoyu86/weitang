package com.chinavisionary.microtang.open;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import c.e.a.a.b;
import c.e.a.d.x;
import c.e.c.r.a;
import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseActivity;
import com.chinavisionary.microtang.contract.fragment.ContractPropertyStateFragment;
import com.chinavisionary.microtang.web.bridge.BridgeWebViewActivity;

/* JADX INFO: loaded from: classes.dex */
@Route(path = "/live_check/live_check")
public class LiveCheckActivity extends BaseActivity {

    @Autowired(name = "isShowAlert")
    public boolean k;

    @Autowired(name = "isFinish")
    public boolean l;

    @Autowired(name = "key")
    public String m;

    @Autowired(name = "showDate")
    public String n;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: m0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void n0(DialogInterface dialogInterface) {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: p0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void q0(AlertDialog alertDialog, View view) {
        alertDialog.dismiss();
        W(BridgeWebViewActivity.class, a.getAssetsConfirm(this.m));
    }

    public static void r0(TextView textView, String str) {
        if (x.isNullStr(str)) {
            return;
        }
        textView.setText(str);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseActivity
    public void U(View view) {
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseActivity
    public int getLayoutId() {
        return R.layout.activity_content;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseActivity
    public void initView(Bundle bundle) {
        ARouter.getInstance().inject(this);
        if (!c.e.a.a.a.getInstance().isH5Repair()) {
            ContractPropertyStateFragment contractPropertyStateFragment = ContractPropertyStateFragment.getInstance(this.m);
            contractPropertyStateFragment.setFinish(this.l);
            Y(contractPropertyStateFragment, R.id.flayout_content);
        } else if (this.k) {
            showAssetConfirmAlert();
        } else {
            finish();
            W(BridgeWebViewActivity.class, a.getAssetsConfirm(this.m));
        }
    }

    public AlertDialog showAssetConfirmAlert() {
        View viewInflate = LayoutInflater.from(this).inflate(R.layout.alert_asset_confirm_layout, (ViewGroup) null);
        TextView textView = (TextView) viewInflate.findViewById(R.id.tv_content);
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.img_close);
        Button button = (Button) viewInflate.findViewById(R.id.btn_confirm);
        r0(textView, x.appendStringToResId(R.string.placeholder_tip_asset_confirm, this.n));
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(viewInflate);
        final AlertDialog alertDialogCreate = builder.create();
        alertDialogCreate.getWindow().setBackgroundDrawableResource(R.drawable.core_lib_bg_radius_alert);
        alertDialogCreate.setCancelable(false);
        alertDialogCreate.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: c.e.c.a0.a
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                this.f1318a.n0(dialogInterface);
            }
        });
        alertDialogCreate.show();
        imageView.setOnClickListener(new View.OnClickListener() { // from class: c.e.c.a0.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                alertDialogCreate.dismiss();
            }
        });
        button.setOnClickListener(new View.OnClickListener() { // from class: c.e.c.a0.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f1319a.q0(alertDialogCreate, view);
            }
        });
        b.getInstance().setupGradModel(viewInflate);
        WindowManager.LayoutParams attributes = alertDialogCreate.getWindow().getAttributes();
        attributes.width = getResources().getDimensionPixelSize(R.dimen.dp_272);
        attributes.height = getResources().getDimensionPixelSize(R.dimen.dp_346);
        alertDialogCreate.getWindow().setAttributes(attributes);
        return alertDialogCreate;
    }
}
