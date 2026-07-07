package com.chinavisionary.microtang.main.fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.OnClick;
import c.e.a.d.x;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseFragment;

/* JADX INFO: loaded from: classes.dex */
public class VersionUpdateFragment extends BaseFragment {
    public String B;
    public String C;
    public boolean D;

    @BindView(R.id.btn_alert_cancel)
    public Button mCancelBtn;

    @BindView(R.id.tv_alert_content)
    public TextView mContentTv;

    public static VersionUpdateFragment getInstance(String str, String str2, boolean z) {
        VersionUpdateFragment versionUpdateFragment = new VersionUpdateFragment();
        versionUpdateFragment.setTipContent(str);
        versionUpdateFragment.G1(str2);
        versionUpdateFragment.H1(z);
        return versionUpdateFragment;
    }

    public final void E1(boolean z) {
        if (!this.D) {
            n();
        } else {
            if (z) {
                return;
            }
            m();
        }
    }

    public final void F1(Context context, String str) {
        if (!x.isNotNull(str)) {
            n();
            return;
        }
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        if (intent.resolveActivity(context.getPackageManager()) == null) {
            Toast.makeText(context.getApplicationContext(), "请下载浏览器", 0).show();
        } else {
            intent.resolveActivity(context.getPackageManager());
            context.startActivity(Intent.createChooser(intent, "请选择浏览器"));
        }
    }

    public final void G1(String str) {
        this.C = str;
    }

    public final void H1(boolean z) {
        this.D = z;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        this.mCancelBtn.setText(this.D ? R.string.title_exit_app : R.string.title_not_update_version);
        this.mContentTv.setText(x.getNotNullStr(this.B, ""));
    }

    @OnClick({R.id.btn_alert_cancel})
    public void cancelView(View view) {
        E1(false);
    }

    @OnClick({R.id.view_bg})
    public void clickView(View view) {
        E1(true);
    }

    @OnClick({R.id.btn_alert_confirm})
    public void confirmView(View view) {
        F1(this.f6487e, this.C);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_version_update_layout;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void j0() {
    }

    public void setTipContent(String str) {
        this.B = str;
    }
}
