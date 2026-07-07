package com.chinavisionary.microtang.service.fragment;

import android.view.View;
import androidx.lifecycle.Observer;
import butterknife.BindView;
import com.chinavisionary.core.app.net.base.dto.RequestErrDto;
import com.chinavisionary.core.weight.BaseSwipeRefreshLayout;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseFragment;
import com.chinavisionary.microtang.repair.vo.ResponseVo;
import com.chinavisionary.microtang.service.adapter.CustomerHotReasonAdapter;
import com.chinavisionary.microtang.service.model.CustomerServiceModel;
import com.chinavisionary.microtang.service.vo.CustomerHotReasonVo;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class CustomerHotReasonFragment extends BaseFragment<CustomerHotReasonVo> {
    public CustomerServiceModel C;

    @BindView(R.id.swipe_refresh_layout_repair_list)
    public BaseSwipeRefreshLayout mHotReasonRecyclerView;
    public int B = -1;
    public c.e.a.a.c.c.a D = new a();

    public class a implements c.e.a.a.c.c.a {
        public a() {
        }

        @Override // c.e.a.a.c.c.a
        public void onItemClickListener(View view, int i2) {
            ((CustomerHotReasonVo) CustomerHotReasonFragment.this.t.getList().get(i2)).setOpen(!((CustomerHotReasonVo) CustomerHotReasonFragment.this.t.getList().get(i2)).isOpen());
            if (CustomerHotReasonFragment.this.B != -1 && CustomerHotReasonFragment.this.B != i2) {
                ((CustomerHotReasonVo) CustomerHotReasonFragment.this.t.getList().get(CustomerHotReasonFragment.this.B)).setOpen(false);
            }
            CustomerHotReasonFragment.this.B = i2;
            CustomerHotReasonFragment.this.t.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: M1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void N1(ResponseVo responseVo) {
        R1();
        if (responseVo != null) {
            D(responseVo.getRows());
            K1(responseVo.getRows());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: O1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void P1(RequestErrDto requestErrDto) {
        R1();
        C(requestErrDto);
        B();
    }

    public static CustomerHotReasonFragment getInstance() {
        return new CustomerHotReasonFragment();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final void K1(List<CustomerHotReasonVo> list) {
        if (this.f6483a == 1) {
            if (list == null || list.isEmpty()) {
                CustomerHotReasonVo customerHotReasonVo = new CustomerHotReasonVo();
                customerHotReasonVo.setType(34952);
                this.t.addDataToList((T) customerHotReasonVo);
            }
        }
    }

    public final void L1() {
        this.r = this.mHotReasonRecyclerView.getBaseRecyclerView();
        CustomerHotReasonAdapter customerHotReasonAdapter = new CustomerHotReasonAdapter();
        this.t = customerHotReasonAdapter;
        customerHotReasonAdapter.setOnItemClickListener(this.D);
        this.l = false;
    }

    public final void Q1() {
        CustomerServiceModel customerServiceModel = (CustomerServiceModel) h(CustomerServiceModel.class);
        this.C = customerServiceModel;
        customerServiceModel.getHotReasonResult().observe(this, new Observer() { // from class: c.e.c.i0.b.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1545a.N1((ResponseVo) obj);
            }
        });
        this.C.getErrRequestLiveData().observe(this, new Observer() { // from class: c.e.c.i0.b.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1543a.P1((RequestErrDto) obj);
            }
        });
    }

    public final void R1() {
        H();
        this.mHotReasonRecyclerView.setRefreshing(false);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        L1();
        Q1();
        z0(R.string.loading_text);
        j0();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_repair_list;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void j0() {
        this.C.getHotQuestionsList();
    }
}
