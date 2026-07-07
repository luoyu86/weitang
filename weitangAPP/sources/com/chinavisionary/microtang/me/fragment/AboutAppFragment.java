package com.chinavisionary.microtang.me.fragment;

import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import c.e.a.a.b;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseFragment;
import com.chinavisionary.microtang.web.WebViewActivity;

/* JADX INFO: loaded from: classes.dex */
public class AboutAppFragment extends BaseFragment<String> {

    @BindView(R.id.tv_app_version)
    public TextView mAppVersionTv;

    @BindView(R.id.tv_title)
    public TextView mTitleTv;

    public static AboutAppFragment getInstance() {
        return new AboutAppFragment();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        this.mTitleTv.setText(R.string.title_app_version);
        this.mAppVersionTv.setText(getString(R.string.title_placeholder_app_version, b.getInstance().getAppVersionName()));
    }

    @OnClick({R.id.tv_back})
    public void clickBack() {
        n();
    }

    @OnClick({R.id.tv_app_icp})
    public void clickOpenAppIcp() {
        c0(WebViewActivity.class, "https://beian.miit.gov.cn/#/Integrated/recordQuery");
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_about_app;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void j0() {
    }
}
