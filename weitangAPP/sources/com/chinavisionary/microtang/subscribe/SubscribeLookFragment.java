package com.chinavisionary.microtang.subscribe;

import android.app.AlertDialog;
import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import butterknife.BindView;
import butterknife.OnClick;
import c.e.a.d.x;
import c.e.c.g.n;
import com.chinavisionary.core.app.net.base.dto.RequestErrDto;
import com.chinavisionary.core.weight.BaseSwipeRefreshLayout;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseFragment;
import com.chinavisionary.microtang.msg.adpater.TopSpacingGridSpecItemDecoration;
import com.chinavisionary.microtang.subscribe.adapter.SubscribeLookAdapter;
import com.chinavisionary.microtang.subscribe.model.SubscribeModel;
import com.chinavisionary.microtang.subscribe.vo.ResponseSubscribeVo;
import com.chinavisionary.microtang.subscribe.vo.SubscribeLookVo;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class SubscribeLookFragment extends BaseFragment<SubscribeLookVo> {
    public SubscribeModel B;
    public AlertDialog C;
    public String D;

    @BindView(R.id.swipe_refresh_layout_subscribe)
    public BaseSwipeRefreshLayout mSubscribeLookRefreshLayout;

    @BindView(R.id.tv_title)
    public TextView mTitleTv;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: H1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void I1(ResponseSubscribeVo responseSubscribeVo) {
        this.mSubscribeLookRefreshLayout.setRefreshing(false);
        D(responseSubscribeVo.getRows());
        E1(responseSubscribeVo.getRows());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: J1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void K1(String str) {
        H();
        F0(R.string.title_cancel_success);
        this.f6483a = 1;
        j0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: L1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void M1(RequestErrDto requestErrDto) {
        H();
        G0(requestErrDto.getErrMsg());
        this.mSubscribeLookRefreshLayout.setRefreshing(false);
    }

    public static SubscribeLookFragment getInstance() {
        return new SubscribeLookFragment();
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final void E1(List<SubscribeLookVo> list) {
        if (this.f6483a == 1) {
            if (list == null || list.isEmpty()) {
                this.t.initListData(null);
                this.t.addDataToList((T) new SubscribeLookVo());
            }
        }
    }

    public final void F1() {
        z0(R.string.tip_cancel_subscribe_loading);
        this.B.cancelSubscribe(this.D);
    }

    public final void G1() {
        z0(R.string.loading_text);
        this.f6483a = 1;
        j0();
    }

    public final void N1() {
        SubscribeModel subscribeModel = (SubscribeModel) ViewModelProviders.of(this).get(SubscribeModel.class);
        this.B = subscribeModel;
        subscribeModel.getListMutableLiveData().observe(this, new Observer() { // from class: c.e.c.k0.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1644a.I1((ResponseSubscribeVo) obj);
            }
        });
        this.B.getResultLiveData().observe(this, new Observer() { // from class: c.e.c.k0.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1645a.K1((String) obj);
            }
        });
        this.B.getErrRequestLiveData().observe(this, new Observer() { // from class: c.e.c.k0.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1643a.M1((RequestErrDto) obj);
            }
        });
    }

    public final void O1() {
        this.r = this.mSubscribeLookRefreshLayout.getBaseRecyclerView();
        SubscribeLookAdapter subscribeLookAdapter = new SubscribeLookAdapter();
        this.t = subscribeLookAdapter;
        subscribeLookAdapter.setEmptyTipMsg(x.getString(R.string.title_subscribe_look_is_empty));
        this.r.addItemDecoration(new TopSpacingGridSpecItemDecoration(getResources().getDimensionPixelSize(R.dimen.dp_14)));
        this.t.setOnClickListener(this.y);
    }

    public final void P1(View view) {
        this.D = (String) view.getTag();
        this.C = n.getInstance().showAlert(this.f6487e, null, x.getString(R.string.tip_confirm_cancel_subscribe), null, null, this.y);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
        switch (view.getId()) {
            case R.id.btn_cancel /* 2131230848 */:
                P1(view);
                break;
            case R.id.tv_alert_cancel /* 2131231941 */:
                this.C.dismiss();
                break;
            case R.id.tv_alert_confirm /* 2131231942 */:
                this.C.dismiss();
                F1();
                break;
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        this.mTitleTv.setText(R.string.title_subscribe_look_record);
        N1();
        O1();
        G1();
    }

    @OnClick({R.id.tv_back})
    public void backClick(View view) {
        n();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_subscribe_look;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void j0() {
        this.B.getSubscribeList(r());
    }
}
