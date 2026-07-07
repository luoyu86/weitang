package com.chinavisionary.microtang.service.fragment;

import android.view.View;
import androidx.lifecycle.Observer;
import butterknife.BindView;
import c.e.a.d.x;
import c.e.a.d.y;
import com.chinavisionary.core.app.net.base.dto.RequestErrDto;
import com.chinavisionary.core.app.net.base.dto.ResponseStateVo;
import com.chinavisionary.core.weight.BaseSwipeRefreshLayout;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseFragment;
import com.chinavisionary.microtang.repair.vo.ResponseVo;
import com.chinavisionary.microtang.service.adapter.CustomerServiceReasonAdapter;
import com.chinavisionary.microtang.service.bo.CreateServiceCommentBo;
import com.chinavisionary.microtang.service.bo.ResponseFormBo;
import com.chinavisionary.microtang.service.bo.ResponseFormTemplateDetailsVo;
import com.chinavisionary.microtang.service.model.CustomerServiceModel;
import com.chinavisionary.microtang.service.model.TemplateModel;
import com.chinavisionary.microtang.service.vo.EventUpdateReasonVo;
import com.chinavisionary.microtang.service.vo.MeReasonVo;
import g.b.a.c;
import g.b.a.m;
import g.b.a.r;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class CustomerServiceMeReasonFragment extends BaseFragment<MeReasonVo> {
    public int B;
    public Map<String, ResponseFormBo> C = new HashMap();
    public int D;
    public TemplateModel E;
    public CustomerServiceModel F;

    @BindView(R.id.swipe_refresh_layout_repair_list)
    public BaseSwipeRefreshLayout mSwipeRefreshLayout;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: R1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void S1(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            MeReasonVo meReasonVo = (MeReasonVo) it.next();
            if (meReasonVo != null) {
                String formKey = meReasonVo.getFormKey();
                try {
                    Thread.sleep(200L);
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
                this.E.getFormValueTemplate(formKey);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: U1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void V1(RequestErrDto requestErrDto) {
        a2();
        C(requestErrDto);
    }

    public static CustomerServiceMeReasonFragment getInstance() {
        return new CustomerServiceMeReasonFragment();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final void E1(List<MeReasonVo> list) {
        if (list == null || list.isEmpty()) {
            MeReasonVo meReasonVo = new MeReasonVo();
            meReasonVo.setType(34952);
            this.t.addDataToList((T) meReasonVo);
        }
    }

    public final void F1(final List<MeReasonVo> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        this.D = list.size();
        y.get().addRunnable(new Runnable() { // from class: c.e.c.i0.b.p
            @Override // java.lang.Runnable
            public final void run() {
                this.f1566a.S1(list);
            }
        });
    }

    public final void G1(View view) {
        String str = (String) view.getTag();
        String complaintOrderKey = ((MeReasonVo) this.t.getList().get(this.B)).getComplaintOrderKey();
        if (x.isNotNull(str) && x.isNotNull(complaintOrderKey)) {
            z0(R.string.tip_submit_data_loading);
            CreateServiceCommentBo createServiceCommentBo = new CreateServiceCommentBo();
            createServiceCommentBo.setComplaintOrderKey(complaintOrderKey);
            createServiceCommentBo.setContent(str);
            this.F.postCustomerServiceComment(createServiceCommentBo);
        }
    }

    public final void H1(View view) {
        this.B = ((Integer) view.getTag()).intValue();
        String handleFormKey = ((MeReasonVo) this.t.getList().get(this.B)).getHandleFormKey();
        if (x.isNotNull(handleFormKey)) {
            z0(R.string.tip_get_data);
            this.E.getTemplate(handleFormKey);
        }
    }

    public final void I1(ResponseStateVo responseStateVo) {
        if (F(responseStateVo, R.string.tip_submit_success, R.string.tip_submit_failed)) {
            j0();
        }
    }

    public final void J1(ResponseFormBo responseFormBo) {
        if (responseFormBo == null) {
            a2();
            return;
        }
        this.C.put(responseFormBo.getFormKey(), responseFormBo);
        if (this.D == this.C.size()) {
            Y1();
        }
    }

    public final void K1(ResponseVo<MeReasonVo> responseVo) {
        if (responseVo == null || responseVo.getRows() == null) {
            a2();
            return;
        }
        this.C.clear();
        List<MeReasonVo> rows = responseVo.getRows();
        E(rows, false);
        F1(rows);
        E1(rows);
        this.t.notifyDataSetChanged();
    }

    public final void L1(ResponseFormTemplateDetailsVo responseFormTemplateDetailsVo) {
        if (responseFormTemplateDetailsVo != null) {
            this.E.getFormTemplateDataSource(responseFormTemplateDetailsVo.getFormTemplateKey());
        }
    }

    public final void M1(ResponseFormBo responseFormBo) {
        H();
        ((MeReasonVo) this.t.getList().get(this.B)).setDataSourceVo(responseFormBo);
        this.t.notifyDataSetChanged();
    }

    public final void N1() {
        h0(this);
        this.r = this.mSwipeRefreshLayout.getBaseRecyclerView();
        CustomerServiceReasonAdapter customerServiceReasonAdapter = new CustomerServiceReasonAdapter(w(), t());
        this.t = customerServiceReasonAdapter;
        customerServiceReasonAdapter.setEmptyTipMsg(x.getString(R.string.title_empty_reason));
        this.t.setOnClickListener(this.y);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
        int id = view.getId();
        if (id == R.id.btn_cat_reply) {
            H1(view);
            return;
        }
        if (id == R.id.btn_comment_service) {
            this.B = ((Integer) view.getTag()).intValue();
            x0(null, null, null, false);
        } else {
            if (id != R.id.tv_alert_confirm) {
                return;
            }
            G1(view);
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        N1();
        Z1();
        z0(R.string.loading_text);
        j0();
    }

    public final void Y1() {
        List<MeReasonVo> list = this.t.getList();
        if (list == null || list.isEmpty()) {
            return;
        }
        for (MeReasonVo meReasonVo : list) {
            String formKey = meReasonVo.getFormKey();
            if (x.isNotNull(formKey) && this.C.containsKey(formKey)) {
                meReasonVo.setFormDataSourceVo(this.C.get(formKey));
            }
        }
        this.t.notifyDataSetChanged();
        a2();
    }

    public final void Z1() {
        TemplateModel templateModel = (TemplateModel) h(TemplateModel.class);
        this.E = templateModel;
        templateModel.getTemplateDetailsResult().observe(this, new Observer() { // from class: c.e.c.i0.b.v
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1573a.L1((ResponseFormTemplateDetailsVo) obj);
            }
        });
        this.E.getBoMutableLiveData().observe(this, new Observer() { // from class: c.e.c.i0.b.u
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1572a.M1((ResponseFormBo) obj);
            }
        });
        this.E.getFormResult().observe(this, new Observer() { // from class: c.e.c.i0.b.t
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1571a.J1((ResponseFormBo) obj);
            }
        });
        this.E.getErrRequestLiveData().observe(this, new Observer() { // from class: c.e.c.i0.b.q
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1568a.C((RequestErrDto) obj);
            }
        });
        CustomerServiceModel customerServiceModel = (CustomerServiceModel) h(CustomerServiceModel.class);
        this.F = customerServiceModel;
        customerServiceModel.getMeReasonResult().observe(this, new Observer() { // from class: c.e.c.i0.b.w
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1574a.K1((ResponseVo) obj);
            }
        });
        this.F.getCreateCommentResultLive().observe(this, new Observer() { // from class: c.e.c.i0.b.s
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1570a.I1((ResponseStateVo) obj);
            }
        });
        this.F.getErrRequestLiveData().observe(this, new Observer() { // from class: c.e.c.i0.b.r
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1569a.V1((RequestErrDto) obj);
            }
        });
    }

    public final void a2() {
        H();
        this.mSwipeRefreshLayout.setRefreshing(false);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_repair_list;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void j0() {
        this.F.getMeQuestionsList();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (c.getDefault().isRegistered(this)) {
            c.getDefault().unregister(this);
        }
    }

    @m(threadMode = r.MAIN)
    public void updateReason(EventUpdateReasonVo eventUpdateReasonVo) {
        j0();
    }
}
