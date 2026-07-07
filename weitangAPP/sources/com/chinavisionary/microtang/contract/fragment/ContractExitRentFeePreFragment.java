package com.chinavisionary.microtang.contract.fragment;

import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import butterknife.BindView;
import butterknife.OnClick;
import c.b.a.d.g;
import c.b.a.f.c;
import c.e.a.d.z;
import c.e.c.o.d.d;
import com.chinavisionary.core.app.base.LeftTitleToRightArrowAdapter;
import com.chinavisionary.core.app.config.bo.LeftTitleToRightArrowVo;
import com.chinavisionary.core.app.net.base.dto.RequestErrDto;
import com.chinavisionary.core.weight.BaseSwipeRefreshLayout;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseFragment;
import com.chinavisionary.microtang.contract.model.ContractModel;
import com.chinavisionary.microtang.contract.vo.ExitRentFeeConfigVo;
import com.chinavisionary.microtang.contract.vo.RentBackFeePreviewListVo;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ContractExitRentFeePreFragment extends BaseFragment<LeftTitleToRightArrowVo> {
    public ExitRentFeeConfigVo B;
    public ContractModel C;
    public d D;
    public c E;
    public c.e.c.o.d.a F;
    public c.e.a.a.c.c.a G = new c.e.a.a.c.c.a() { // from class: c.e.c.o.c.f
        @Override // c.e.a.a.c.c.a
        public final void onItemClickListener(View view, int i2) {
            this.f1743a.N1(view, i2);
        }
    };

    @BindView(R.id.swipe_refresh_layout)
    public BaseSwipeRefreshLayout mSwipeRefreshLayout;

    @BindView(R.id.tv_title)
    public TextView mTitleTv;

    public class a implements g {
        public a() {
        }

        @Override // c.b.a.d.g
        public void onTimeSelect(Date date, View view) {
            ContractExitRentFeePreFragment.this.O1(date);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: M1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void N1(View view, int i2) {
        if (((LeftTitleToRightArrowVo) this.t.getList().get(i2)).getOnlyKey() != 1233) {
            return;
        }
        F1();
    }

    public static ContractExitRentFeePreFragment getInstance(ExitRentFeeConfigVo exitRentFeeConfigVo) {
        ContractExitRentFeePreFragment contractExitRentFeePreFragment = new ContractExitRentFeePreFragment();
        contractExitRentFeePreFragment.B = exitRentFeeConfigVo;
        return contractExitRentFeePreFragment;
    }

    public final void F1() {
        J1(Long.valueOf(this.B.getStartTime()), Long.valueOf(this.B.getEndTime()));
    }

    public final Map<String, String> G1() {
        HashMap map = new HashMap();
        ExitRentFeeConfigVo exitRentFeeConfigVo = this.B;
        if (exitRentFeeConfigVo != null) {
            map.put("contractKey", exitRentFeeConfigVo.getKey());
            map.put("rentBackDate", String.valueOf(this.B.getExitRentDate()));
        }
        return map;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final void H1(RentBackFeePreviewListVo rentBackFeePreviewListVo) {
        this.t.initListData((List<T>) this.D.getRentBackList(rentBackFeePreviewListVo, this.B));
        S1();
    }

    public final void I1(RequestErrDto requestErrDto) {
        C(requestErrDto);
        S1();
    }

    public final void J1(Long l, Long l2) {
        if (l == null || l2 == null) {
            F0(R.string.title_exit_rent_range_is_emtpy);
            return;
        }
        if (l.longValue() > l2.longValue()) {
            F0(R.string.title_start_time_great_end_time);
            return;
        }
        Calendar.getInstance().setTimeInMillis(l.longValue());
        Calendar.getInstance().setTimeInMillis(l2.longValue());
        this.E = this.F.getTimePickerView(this.f6487e, l, l2, new a(), this.y);
        R1();
        this.E.show();
    }

    public final void O1(Date date) {
        this.B.setExitRentDate(date.getTime());
        R1();
        this.E.dismiss();
        ((LeftTitleToRightArrowVo) this.t.getList().get(2)).setRight(z.getTimeYYMMDD(Long.valueOf(date.getTime())) + c.e.c.o.d.a.getExitAdvanceDay(Long.valueOf(date.getTime())));
        this.t.notifyItemChanged(2);
        if (this.B.getExitRentTimeCallback() != null) {
            this.B.getExitRentTimeCallback().onExitRentTime(date);
        }
        j0();
    }

    public final void P1() {
        this.D = new d();
        ContractModel contractModel = (ContractModel) h(ContractModel.class);
        this.C = contractModel;
        contractModel.getRentBackFeePreviewResult().observe(this, new Observer() { // from class: c.e.c.o.c.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1739a.H1((RentBackFeePreviewListVo) obj);
            }
        });
        this.C.getErrRequestLiveData().observe(this, new Observer() { // from class: c.e.c.o.c.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1741a.I1((RequestErrDto) obj);
            }
        });
    }

    public final void Q1() {
        this.r = this.mSwipeRefreshLayout.getBaseRecyclerView();
        LeftTitleToRightArrowAdapter leftTitleToRightArrowAdapter = new LeftTitleToRightArrowAdapter();
        this.t = leftTitleToRightArrowAdapter;
        leftTitleToRightArrowAdapter.setOnItemClickListener(this.G);
    }

    public final void R1() {
        c cVar = this.E;
        if (cVar != null) {
            cVar.setDate(this.F.getSelectDate(Long.valueOf(this.B.getExitRentDate())));
        }
    }

    public final void S1() {
        H();
        this.mSwipeRefreshLayout.setRefreshing(false);
    }

    public final void T1() {
        this.C.getRentBackFeePreview(G1());
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
        if (view.getId() == R.id.btn_confirm_time) {
            this.E.returnData();
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        this.mTitleTv.setText(R.string.title_exit_rent_fee_pre);
        this.F = new c.e.c.o.d.a();
        Q1();
        P1();
        j0();
    }

    @OnClick({R.id.tv_back})
    public void backClick(View view) {
        n();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_contract_exit_rent_fee_pre;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void j0() {
        z0(R.string.tip_get_data);
        T1();
    }
}
