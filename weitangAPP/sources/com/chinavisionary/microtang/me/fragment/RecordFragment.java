package com.chinavisionary.microtang.me.fragment;

import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import butterknife.BindView;
import c.e.a.d.z;
import com.chinavisionary.core.app.base.LeftTitleToRightArrowAdapter;
import com.chinavisionary.core.app.config.bo.LeftTitleToRightArrowVo;
import com.chinavisionary.core.app.net.base.dto.RequestErrDto;
import com.chinavisionary.core.app.net.base.dto.ResponseRowsVo;
import com.chinavisionary.core.weight.BaseSwipeRefreshLayout;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseFragment;
import com.chinavisionary.microtang.hydropower.model.PayHydropowerModel;
import com.chinavisionary.microtang.me.vo.RecordVo;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class RecordFragment extends BaseFragment<LeftTitleToRightArrowVo> {
    public int B;
    public PayHydropowerModel C;

    @BindView(R.id.swipe_refresh_layout)
    public BaseSwipeRefreshLayout mSwipeRefreshLayout;

    @BindView(R.id.tv_value)
    public TextView mValueTv;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: F1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void G1(ResponseRowsVo responseRowsVo) {
        K1();
        if (responseRowsVo == null || responseRowsVo.getRows() == null) {
            return;
        }
        E1(responseRowsVo.getRows());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: H1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void I1(RequestErrDto requestErrDto) {
        C(requestErrDto);
        K1();
    }

    public static RecordFragment getInstance(int i2) {
        RecordFragment recordFragment = new RecordFragment();
        recordFragment.setType(i2);
        return recordFragment;
    }

    public final void E1(List<RecordVo> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (RecordVo recordVo : list) {
            LeftTitleToRightArrowVo leftTitleToRightArrowVo = new LeftTitleToRightArrowVo();
            if (recordVo != null) {
                leftTitleToRightArrowVo.setLeft(String.valueOf(recordVo.getCurrentMeterReading()));
                leftTitleToRightArrowVo.setRight(z.getTime(recordVo.getCurrentMeterReadingTime()));
            }
            arrayList.add(leftTitleToRightArrowVo);
        }
        D(arrayList);
    }

    public final void J1() {
        PayHydropowerModel payHydropowerModel = (PayHydropowerModel) h(PayHydropowerModel.class);
        this.C = payHydropowerModel;
        payHydropowerModel.getRecordList().observe(this, new Observer() { // from class: c.e.c.x.d.m1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f2071a.G1((ResponseRowsVo) obj);
            }
        });
        this.C.getErrRequestLiveData().observe(this, new Observer() { // from class: c.e.c.x.d.n1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f2075a.I1((RequestErrDto) obj);
            }
        });
    }

    public final void K1() {
        this.mSwipeRefreshLayout.setRefreshing(false);
        H();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        this.r = this.mSwipeRefreshLayout.getBaseRecyclerView();
        this.t = new LeftTitleToRightArrowAdapter();
        J1();
        z0(R.string.loading_text);
        j0();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_record_layout;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void j0() {
        this.C.getRecordList(r(), this.B);
    }

    public final void setType(int i2) {
        this.B = i2;
    }
}
