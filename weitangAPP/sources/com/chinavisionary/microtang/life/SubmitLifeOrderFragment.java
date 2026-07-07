package com.chinavisionary.microtang.life;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import butterknife.BindView;
import butterknife.OnClick;
import c.b.a.d.e;
import c.b.a.f.b;
import c.e.a.d.o;
import c.e.a.d.q;
import c.e.a.d.w;
import c.e.a.d.x;
import com.alibaba.fastjson.JSON;
import com.chinavisionary.core.app.adapter.BaseRecyclerAdapter;
import com.chinavisionary.core.app.net.base.dto.RequestErrDto;
import com.chinavisionary.core.weight.BaseSwipeRefreshLayout;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseFragment;
import com.chinavisionary.microtang.clean.model.NewCleanModel;
import com.chinavisionary.microtang.clean.vo.CreateCleanOrderVo;
import com.chinavisionary.microtang.life.adapter.SubmitLifeOrderAdapter;
import com.chinavisionary.microtang.life.vo.SubmitLifeOrderDetailsVo;
import com.chinavisionary.microtang.life.vo.SubmitLifeOrderVo;
import com.chinavisionary.microtang.life.vo.SubmitOrderRequestParamVo;
import com.chinavisionary.microtang.life.vo.TimeSelectVo;
import com.chinavisionary.paymentlibrary.PayTypeFragment;
import com.chinavisionary.paymentlibrary.model.NewBillModel;
import com.chinavisionary.paymentlibrary.vo.CreateIncrementOrderParamBo;
import com.chinavisionary.paymentlibrary.vo.PayBillResultVo;
import com.chinavisionary.paymentlibrary.vo.PayTypeVo;
import com.chinavisionary.paymentlibrary.vo.ResponseH5BillDetailsVo;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class SubmitLifeOrderFragment extends BaseFragment<SubmitLifeOrderVo> {
    public c.e.c.t.p.a B;
    public b<String> C;
    public List<String> D;
    public List<List<String>> E;
    public int F;
    public int G;
    public NewCleanModel H;
    public SubmitOrderRequestParamVo I;
    public String J;
    public String K;
    public NewBillModel L;
    public String M;
    public ResponseH5BillDetailsVo N;
    public final c.e.a.a.c.c.a O = new c.e.a.a.c.c.a() { // from class: c.e.c.t.n
        @Override // c.e.a.a.c.c.a
        public final void onItemClickListener(View view, int i2) {
            this.f1849a.O1(view, i2);
        }
    };

    @BindView(R.id.view_bottom_bg)
    public View mBgView;

    @BindView(R.id.btn_submit)
    public Button mSubmitBtn;

    @BindView(R.id.swipe_refresh_layout)
    public BaseSwipeRefreshLayout mSwipeRefreshLayout;

    @BindView(R.id.tv_title)
    public TextView mTitleTv;

    public class a implements e {
        public a() {
        }

        @Override // c.b.a.d.e
        public void onOptionsSelect(int i2, int i3, int i4, View view) {
            SubmitLifeOrderFragment.this.X1(i2, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: N1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void O1(View view, int i2) {
        if (((SubmitLifeOrderVo) this.t.getList().get(i2)).getItemType() == 221) {
            Y1();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: P1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void Q1(SubmitLifeOrderDetailsVo submitLifeOrderDetailsVo) {
        if (submitLifeOrderDetailsVo != null) {
            H1(submitLifeOrderDetailsVo);
        }
        Z1(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: R1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void S1(RequestErrDto requestErrDto) {
        if (requestErrDto != null) {
            G0(requestErrDto.getErrMsg());
        }
        Z1(null);
    }

    public static SubmitLifeOrderFragment getInstance(String str, String str2, String str3, String str4) {
        SubmitLifeOrderFragment submitLifeOrderFragment = new SubmitLifeOrderFragment();
        submitLifeOrderFragment.f6484b = str;
        submitLifeOrderFragment.J = str2;
        submitLifeOrderFragment.M = str3;
        submitLifeOrderFragment.K = str4;
        return submitLifeOrderFragment;
    }

    public final void F1() {
        if (this.N != null) {
            H();
            T1(this.N);
            return;
        }
        z0(R.string.loading_text);
        CreateIncrementOrderParamBo createIncrementOrderParamBo = new CreateIncrementOrderParamBo();
        createIncrementOrderParamBo.setCommodityId(this.f6484b);
        createIncrementOrderParamBo.setSpaceId(v());
        createIncrementOrderParamBo.setPayChannel(1);
        SubmitOrderRequestParamVo submitOrderRequestParamVo = this.I;
        if (submitOrderRequestParamVo != null) {
            createIncrementOrderParamBo.setRemark(submitOrderRequestParamVo.getRemark());
            createIncrementOrderParamBo.setExtraParam(this.I.getKeyValueMap());
        }
        this.L.createNewCleanOrder(createIncrementOrderParamBo);
    }

    public final String G1() {
        return w.getInstance().getString("current_room_key", null);
    }

    public final void H1(SubmitLifeOrderDetailsVo submitLifeOrderDetailsVo) {
        List<SubmitLifeOrderVo> listToQuestionBean = this.B.getListToQuestionBean(submitLifeOrderDetailsVo.getQuestion());
        if (submitLifeOrderDetailsVo.getDeliveryFee() != null) {
            ArrayList arrayList = new ArrayList();
            SubmitLifeOrderVo submitLifeOrderVo = new SubmitLifeOrderVo();
            submitLifeOrderVo.setTip(submitLifeOrderDetailsVo.getDeliveryFeeDesc());
            submitLifeOrderVo.setTitle("配送费用");
            submitLifeOrderVo.setValue(submitLifeOrderDetailsVo.getDeliveryFee().toPlainString() + "元");
            arrayList.add(submitLifeOrderVo);
            submitLifeOrderDetailsVo.setTipList(arrayList);
            Iterator<SubmitLifeOrderVo> it = submitLifeOrderDetailsVo.getTipList().iterator();
            while (it.hasNext()) {
                it.next().setItemType(SubmitLifeOrderVo.ITEM_TYPE_INFO);
            }
            listToQuestionBean.addAll(0, submitLifeOrderDetailsVo.getTipList());
        }
        D(this.B.getSubmitLiefOrder(G1(), listToQuestionBean));
        TimeSelectVo timeSelectVo = this.B.getTimeSelectVo(submitLifeOrderDetailsVo.getDeliveryTime());
        this.D = timeSelectVo.getOneList();
        this.E = timeSelectVo.getTwoList();
        J1();
        if (o.isNotEmpty(this.D) && o.isNotEmpty(this.E)) {
            X1(0, 0);
        }
    }

    public final void I1(PayBillResultVo payBillResultVo) {
        if (payBillResultVo != null) {
            ResponseH5BillDetailsVo responseH5BillDetailsVo = new ResponseH5BillDetailsVo();
            this.N = responseH5BillDetailsVo;
            responseH5BillDetailsVo.setOrderId(payBillResultVo.getPaymentKey());
            if (this.M != null) {
                this.N.setActualAmount(new BigDecimal(this.M));
            }
            F1();
        }
    }

    public final void J1() {
        b<String> bVarBuild = new c.b.a.b.a(this.f6487e, new a()).setCancelColor(getResources().getColor(R.color.color555555)).setSubmitColor(getResources().getColor(R.color.colorff9900)).setSubmitText(x.getString(R.string.title_confirm_value)).build();
        this.C = bVarBuild;
        bVarBuild.setTitleText(x.getString(R.string.title_select_time_value));
        this.C.setPicker(this.D, null, null);
    }

    public final void K1() {
        this.mSwipeRefreshLayout.setBackgroundColor(getResources().getColor(R.color.colorF8F8F8));
        this.l = false;
        this.mSwipeRefreshLayout.setEnabled(false);
        this.mTitleTv.setText(R.string.title_submit_order);
        this.mBgView.setVisibility(0);
        this.mSubmitBtn.setVisibility(0);
        this.mSubmitBtn.setText(R.string.title_submit_order);
        this.mSubmitBtn.setOnClickListener(this.y);
        W1();
    }

    public final void T1(ResponseH5BillDetailsVo responseH5BillDetailsVo) {
        CreateCleanOrderVo createCleanOrderVo = new CreateCleanOrderVo();
        createCleanOrderVo.setValueaddedKey(this.f6484b);
        createCleanOrderVo.setRoomKey(v());
        PayTypeVo payTypeVo = new PayTypeVo();
        payTypeVo.setType(17);
        payTypeVo.setPrice(this.M);
        payTypeVo.setResStrId(R.string.title_pay_increment_fee);
        payTypeVo.setTitle(this.J);
        payTypeVo.setCouponKey(this.K);
        payTypeVo.setOpenOrderList(true);
        payTypeVo.setInitBJPay(c.e.a.a.a.getInstance().isBjIncrement());
        payTypeVo.setExtJson(JSON.toJSONString(createCleanOrderVo));
        payTypeVo.setResponseH5BillDetailsVoJson(JSON.toJSONString(responseH5BillDetailsVo));
        g0();
        d(PayTypeFragment.getInstance(payTypeVo), R.id.flayout_content);
    }

    public final void U1() {
        NewCleanModel newCleanModel = (NewCleanModel) h(NewCleanModel.class);
        this.H = newCleanModel;
        newCleanModel.getSubmitLifeOrderDetailsResult().observe(getViewLifecycleOwner(), new Observer() { // from class: c.e.c.t.l
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1847a.Q1((SubmitLifeOrderDetailsVo) obj);
            }
        });
        this.H.getErrRequestLiveData().observe(getViewLifecycleOwner(), new Observer() { // from class: c.e.c.t.m
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1848a.Z1((RequestErrDto) obj);
            }
        });
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
        if (view.getId() == R.id.btn_submit) {
            SubmitOrderRequestParamVo submitOrderRequestParamVo = this.B.getSubmitOrderRequestParamVo(this.t.getList());
            this.I = submitOrderRequestParamVo;
            if (submitOrderRequestParamVo.isErr()) {
                G0(this.I.getErrMsgTip());
                return;
            }
            F1();
            q.d(this.f6485c, "SubmitOrderRequestParamVo = " + JSON.toJSONString(this.I));
        }
    }

    public final void V1() {
        NewBillModel newBillModel = (NewBillModel) h(NewBillModel.class);
        this.L = newBillModel;
        newBillModel.getIncrementPayBillResultLiveData().observe(getViewLifecycleOwner(), new Observer() { // from class: c.e.c.t.j
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1845a.I1((PayBillResultVo) obj);
            }
        });
        this.L.getErrRequestLiveData().observe(getViewLifecycleOwner(), new Observer() { // from class: c.e.c.t.k
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1846a.S1((RequestErrDto) obj);
            }
        });
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        K1();
        this.B = new c.e.c.t.p.a();
        U1();
        V1();
        z0(R.string.loading_text);
        j0();
    }

    public final void W1() {
        this.t = new SubmitLifeOrderAdapter();
        this.r = this.mSwipeRefreshLayout.getBaseRecyclerView();
        this.t.setOnItemClickListener(this.O);
    }

    public final void X1(int i2, int i3) {
        String str = this.D.get(i2);
        this.F = i2;
        this.G = i3;
        q.d(this.f6485c, "onOptionsSelect mSelectIndex = " + this.F + ",mTwoIndex = " + this.G + ",tx = " + str);
        a2(str);
    }

    public final void Y1() {
        b<String> bVar = this.C;
        if (bVar != null) {
            bVar.show();
        }
    }

    public final void Z1(RequestErrDto requestErrDto) {
        H();
        this.mSwipeRefreshLayout.setRefreshing(false);
    }

    public final void a2(String str) {
        BaseRecyclerAdapter<T> baseRecyclerAdapter = this.t;
        if (baseRecyclerAdapter != 0) {
            ((SubmitLifeOrderVo) baseRecyclerAdapter.getList().get(1)).setValue(str);
            this.t.notifyItemChanged(1);
        }
    }

    @OnClick({R.id.tv_back})
    public void backClick() {
        n();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_recycler;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void j0() {
        this.H.getSubmitOrderDetails(this.f6484b);
    }
}
