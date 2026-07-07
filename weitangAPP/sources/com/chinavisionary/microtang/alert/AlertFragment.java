package com.chinavisionary.microtang.alert;

import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import c.e.a.d.x;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.alert.vo.AlertVo;
import com.chinavisionary.microtang.base.BaseFragment;

/* JADX INFO: loaded from: classes.dex */
public class AlertFragment extends BaseFragment {
    public AlertVo B;

    @BindView(R.id.tv_content)
    public TextView mContentTv;

    @BindView(R.id.tv_title)
    public TextView mTitleTv;

    public static AlertFragment getInstance(AlertVo alertVo) {
        AlertFragment alertFragment = new AlertFragment();
        alertFragment.F1(alertVo);
        return alertFragment;
    }

    public final void E1() {
    }

    public final void F1(AlertVo alertVo) {
        this.B = alertVo;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        AlertVo alertVo = this.B;
        if (alertVo != null) {
            this.mTitleTv.setText(x.getNotNullStr(alertVo.getTitle(), ""));
            this.mContentTv.setText(x.getNotNullStr(this.B.getContent(), ""));
        }
    }

    @OnClick({R.id.btn_action})
    public void actionClick(View view) {
        n();
        E1();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_alert_layout;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void j0() {
    }
}
