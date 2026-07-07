package com.chinavisionary.microtang.pre.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import butterknife.BindView;
import butterknife.OnClick;
import com.chinavisionary.core.app.base.CoreBaseFragment;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseFragment;
import com.chinavisionary.microtang.web.WebViewActivity;

/* JADX INFO: loaded from: classes2.dex */
public class PreOrderCancelFragment extends BaseFragment {

    @BindView(R.id.edt_cancel_reason)
    public AppCompatEditText mCancelReasonEdt;

    @BindView(R.id.tv_title)
    public TextView mTitleTv;

    public static PreOrderCancelFragment getInstance(String str) {
        PreOrderCancelFragment preOrderCancelFragment = new PreOrderCancelFragment();
        preOrderCancelFragment.setArguments(CoreBaseFragment.q(str));
        return preOrderCancelFragment;
    }

    public final void E1() {
        K0(PreOrderAppealFragment.getInstance(this.f6484b), R.id.flayout_content);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        this.mTitleTv.setText("取消预定");
    }

    @OnClick({R.id.tv_back})
    public void backClick(View view) {
        n();
    }

    @OnClick({R.id.tv_cat_cancel_info})
    public void catCancelInfoClick(View view) {
        G0("查看预定取消说明");
        Intent intent = new Intent(this.f6487e, (Class<?>) WebViewActivity.class);
        intent.setFlags(268435456);
        intent.putExtra("key", "http://www.baidu.com");
        startActivity(intent);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_pre_order_cancel;
    }

    @OnClick({R.id.tv_help})
    public void helpClick(View view) {
        E1();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void j0() {
    }

    @OnClick({R.id.btn_submit})
    public void submitClick(View view) {
        G0("提交");
    }
}
