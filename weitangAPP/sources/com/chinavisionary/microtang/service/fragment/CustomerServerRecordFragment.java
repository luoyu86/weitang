package com.chinavisionary.microtang.service.fragment;

import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import butterknife.BindView;
import butterknife.OnClick;
import c.e.a.d.x;
import com.chinavisionary.core.app.net.base.dto.RequestErrDto;
import com.chinavisionary.core.weight.BaseSwipeRefreshLayout;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseFragment;
import com.chinavisionary.microtang.contract.adapter.ContractGridSpecItemDecoration;
import com.chinavisionary.microtang.repair.vo.ResponseVo;
import com.chinavisionary.microtang.service.adapter.CustomerServerRecordAdapter;
import com.chinavisionary.microtang.service.model.CustomerServiceModel;
import com.chinavisionary.microtang.service.vo.CustomerServerRecordVo;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class CustomerServerRecordFragment extends BaseFragment<CustomerServerRecordVo> {
    public CustomerServiceModel B;

    @BindView(R.id.swipe_refresh_layout_record)
    public BaseSwipeRefreshLayout mBaseSwipeRefreshLayout;

    @BindView(R.id.tv_title_split_line)
    public TextView mSplitLineTv;

    @BindView(R.id.tv_title)
    public TextView mTitleTv;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: F1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void G1(ResponseVo responseVo) {
        this.mBaseSwipeRefreshLayout.setRefreshing(false);
        if (responseVo == null) {
            E1(null);
        } else {
            D(responseVo.getRows());
            E1(responseVo.getRows());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: H1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void I1(RequestErrDto requestErrDto) {
        H();
        G0(requestErrDto.getErrMsg());
    }

    public static CustomerServerRecordFragment getInstance() {
        return new CustomerServerRecordFragment();
    }

    private void o0() {
        this.r = this.mBaseSwipeRefreshLayout.getBaseRecyclerView();
        CustomerServerRecordAdapter customerServerRecordAdapter = new CustomerServerRecordAdapter();
        this.t = customerServerRecordAdapter;
        customerServerRecordAdapter.setEmptyTipMsg(x.getString(R.string.tip_customer_server_record_is_empty));
        this.t.setEmptyMsgTextColor(R.color.colore757575);
        this.r.addItemDecoration(new ContractGridSpecItemDecoration(getResources().getDimensionPixelSize(R.dimen.dp_14)));
        z0(R.string.loading_text);
        j0();
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final void E1(List<CustomerServerRecordVo> list) {
        if (this.f6483a == 1) {
            if (list == null || list.isEmpty()) {
                this.t.initListData(null);
                this.t.addDataToList((T) new CustomerServerRecordVo());
            }
        }
    }

    public final void J1() {
        CustomerServiceModel customerServiceModel = new CustomerServiceModel();
        this.B = customerServiceModel;
        customerServiceModel.getRecordListLiveData().observe(this, new Observer() { // from class: c.e.c.i0.b.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1547a.G1((ResponseVo) obj);
            }
        });
        this.B.getErrRequestLiveData().observe(this, new Observer() { // from class: c.e.c.i0.b.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1549a.I1((RequestErrDto) obj);
            }
        });
    }

    public final void K1() {
        this.mTitleTv.setText(R.string.title_customer_server_record);
        this.mSplitLineTv.setVisibility(0);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        K1();
        J1();
        o0();
    }

    @OnClick({R.id.tv_back})
    public void backClick(View view) {
        n();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_customer_server_record;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void j0() {
        this.B.getRecordList(r());
    }
}
