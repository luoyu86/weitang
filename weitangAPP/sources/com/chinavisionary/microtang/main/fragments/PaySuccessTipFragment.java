package com.chinavisionary.microtang.main.fragments;

import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import c.e.a.d.x;
import c.e.c.r.a;
import com.alibaba.fastjson.JSON;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseFragment;
import com.chinavisionary.microtang.web.bridge.BridgeWebViewActivity;
import com.chinavisionary.paymentlibrary.vo.ResponseOrderTicketBo;

/* JADX INFO: loaded from: classes.dex */
public class PaySuccessTipFragment extends BaseFragment<String> {
    public boolean B;
    public String C;
    public String D;
    public ResponseOrderTicketBo E;

    @BindView(R.id.tv_open_details)
    public TextView mOpenDetailsTv;

    @BindView(R.id.tv_title)
    public TextView mTitleTv;

    public static PaySuccessTipFragment getInstance(boolean z, String str, String str2) {
        PaySuccessTipFragment paySuccessTipFragment = new PaySuccessTipFragment();
        paySuccessTipFragment.B = z;
        paySuccessTipFragment.C = str2;
        paySuccessTipFragment.D = str;
        return paySuccessTipFragment;
    }

    public final void E1() {
        String str = this.C;
        if (str != null) {
            try {
                this.E = (ResponseOrderTicketBo) JSON.parseObject(str, ResponseOrderTicketBo.class);
                String string = x.getString(R.string.title_go_use);
                x.getString(R.string.title_alert_close);
                D1(this.E.getPopupContent(), "", string, this.y);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
        if (view.getId() == R.id.tv_open_details) {
            if (this.B) {
                m();
                c0(BridgeWebViewActivity.class, a.getMyOrder());
            } else {
                m();
                c0(BridgeWebViewActivity.class, a.getMyBill());
            }
        }
        if (view.getId() == R.id.tv_alert_confirm) {
            String targetAppid = this.E.getTargetAppid();
            String targetPath = this.E.getTargetPath();
            m();
            if (x.isNotNull(targetAppid)) {
                c1(15, targetAppid, targetPath);
            }
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        this.mTitleTv.setText(R.string.tip_pay_success);
        this.mOpenDetailsTv.setOnClickListener(this.y);
        this.mOpenDetailsTv.setText(this.B ? R.string.title_cat_order_details : R.string.title_cat_bill_details);
        E1();
    }

    @OnClick({R.id.tv_back})
    public void clickBack() {
        m();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_pay_success_tip;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void j0() {
    }
}
