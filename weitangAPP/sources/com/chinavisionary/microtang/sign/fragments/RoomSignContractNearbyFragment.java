package com.chinavisionary.microtang.sign.fragments;

import android.os.Message;
import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import butterknife.BindView;
import butterknife.OnClick;
import c.e.a.a.h.c;
import c.e.a.d.j;
import c.e.a.d.x;
import c.e.c.j0.b.s;
import c.e.c.j0.c.d;
import com.alibaba.fastjson.JSON;
import com.chinavisionary.core.app.base.CoreBaseFragment;
import com.chinavisionary.core.app.base.LeftTitleToRightArrowAdapter;
import com.chinavisionary.core.app.config.bo.LeftTitleToRightArrowVo;
import com.chinavisionary.core.app.net.base.dto.RequestErrDto;
import com.chinavisionary.core.app.net.base.dto.ResponseRowsVo;
import com.chinavisionary.core.weight.BaseSwipeRefreshLayout;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseFragment;
import com.chinavisionary.microtang.bill.vo.PayBillResultVo;
import com.chinavisionary.microtang.bill.vo.PayBillVo;
import com.chinavisionary.microtang.contract.model.ContractModel;
import com.chinavisionary.microtang.contract.vo.ContractClauseVo;
import com.chinavisionary.microtang.contract.vo.ResultTreatyVo;
import com.chinavisionary.microtang.pre.event.EventUpdateReserveList;
import com.chinavisionary.microtang.pre.model.ReserveModel;
import com.chinavisionary.microtang.pre.vo.RequestReserveInfoVo;
import com.chinavisionary.microtang.pre.vo.ReserveClauseRequestVo;
import com.chinavisionary.microtang.sign.vo.ConfirmContractEvent;
import com.chinavisionary.paymentlibrary.PayTypeFragment;
import com.chinavisionary.paymentlibrary.vo.PayTypeVo;
import g.b.a.m;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/* JADX INFO: loaded from: classes2.dex */
public class RoomSignContractNearbyFragment extends BaseFragment<LeftTitleToRightArrowVo> {
    public ContractModel B;
    public ReserveModel C;
    public int D;
    public boolean E;
    public boolean F;
    public String G;
    public RequestReserveInfoVo H;
    public LeftTitleToRightArrowVo I;
    public c.e.a.a.c.c.a J = new c.e.a.a.c.c.a() { // from class: c.e.c.j0.b.t
        @Override // c.e.a.a.c.c.a
        public final void onItemClickListener(View view, int i2) {
            this.f1615a.W1(view, i2);
        }
    };

    @BindView(R.id.recycler_view_sign_contract_nearby)
    public BaseSwipeRefreshLayout mSwipeRefreshLayout;

    @BindView(R.id.tv_title)
    public TextView mTitleTv;

    public class a implements Callback {
        public a() {
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            if (RoomSignContractNearbyFragment.this.f6488f != null) {
                RoomSignContractNearbyFragment.this.f6488f.obtainMessage().sendToTarget();
            }
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) throws IOException {
            if (!response.isSuccessful()) {
                if (RoomSignContractNearbyFragment.this.f6488f != null) {
                    RoomSignContractNearbyFragment.this.f6488f.obtainMessage().sendToTarget();
                }
            } else {
                String strString = response.body().string();
                if (RoomSignContractNearbyFragment.this.f6488f != null) {
                    RoomSignContractNearbyFragment.this.f6488f.obtainMessage(1, strString).sendToTarget();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: V1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void W1(View view, int i2) {
        this.D = i2;
        LeftTitleToRightArrowVo leftTitleToRightArrowVo = (LeftTitleToRightArrowVo) this.t.getList().get(i2);
        this.I = leftTitleToRightArrowVo;
        O1(leftTitleToRightArrowVo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: X1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void Y1(ResultTreatyVo resultTreatyVo) {
        if (resultTreatyVo != null) {
            b2(this.I, resultTreatyVo.getContent());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: Z1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void a2(RequestErrDto requestErrDto) {
        C(requestErrDto);
        g2();
    }

    public static RoomSignContractNearbyFragment getInstance(String str) {
        RoomSignContractNearbyFragment roomSignContractNearbyFragment = new RoomSignContractNearbyFragment();
        roomSignContractNearbyFragment.setArguments(CoreBaseFragment.q(str));
        return roomSignContractNearbyFragment;
    }

    public final void K1() {
        ReserveClauseRequestVo reserveClauseRequestVo = new ReserveClauseRequestVo();
        reserveClauseRequestVo.setAssetInstanceKey(this.H.getAssetInstanceKey());
        reserveClauseRequestVo.setCardNo(this.H.getCardNo());
        reserveClauseRequestVo.setReserveUserName(this.H.getReserveUserName());
        this.C.getReserveContractClause(reserveClauseRequestVo);
    }

    public final void L1(ResponseRowsVo<ContractClauseVo> responseRowsVo) {
        g2();
        if (responseRowsVo == null) {
            F0(R.string.data_error);
        } else if (responseRowsVo.getSuccess()) {
            P1(responseRowsVo.getRows());
        } else {
            G0(responseRowsVo.getMessage());
        }
    }

    public final void M1(PayBillResultVo payBillResultVo) {
        H();
        c2();
        if (payBillResultVo != null) {
            if (!payBillResultVo.isSuccess()) {
                G0(payBillResultVo.getMessage());
                return;
            }
            PayBillVo payBillVo = new PayBillVo();
            payBillVo.setPaymentKey(payBillResultVo.getPaymentKey());
            PayTypeVo payTypeVo = new PayTypeVo();
            payTypeVo.setResStrId(R.string.title_pay_reserve_fee);
            payTypeVo.setPrice(this.G);
            payTypeVo.setType(16);
            payTypeVo.setExtJson(JSON.toJSONString(payBillVo));
            payTypeVo.setBaseKey(payBillResultVo.getKey());
            K0(PayTypeFragment.getInstance(payTypeVo), R.id.flayout_content);
        }
    }

    public final void N1() {
        z0(R.string.tip_submit_data_loading);
        RequestReserveInfoVo requestReserveInfoVo = this.H;
        if (requestReserveInfoVo != null) {
            this.C.postReserve(requestReserveInfoVo);
        }
    }

    public final void O1(LeftTitleToRightArrowVo leftTitleToRightArrowVo) {
        b2(leftTitleToRightArrowVo, null);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final void P1(List<ContractClauseVo> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            for (ContractClauseVo contractClauseVo : list) {
                if (contractClauseVo != null) {
                    LeftTitleToRightArrowVo leftTitleToRightArrowVo = new LeftTitleToRightArrowVo();
                    leftTitleToRightArrowVo.setLeft(contractClauseVo.getContractEnclosureName());
                    leftTitleToRightArrowVo.setRight(x.getString(R.string.title_click_look_confirm));
                    leftTitleToRightArrowVo.setOnlyKey(-1);
                    leftTitleToRightArrowVo.setExtObj(contractClauseVo.getContractEnclosureHtmlUrl());
                    arrayList.add(leftTitleToRightArrowVo);
                }
            }
        }
        this.t.initListData(arrayList);
    }

    public final void Q1() {
        h0(this);
        this.mTitleTv.setText(R.string.title_contract_nearby);
        this.f6488f = new CoreBaseFragment.c(this);
    }

    public final boolean R1() {
        for (LeftTitleToRightArrowVo leftTitleToRightArrowVo : this.t.getList()) {
            if (leftTitleToRightArrowVo.getOnlyKey() == -1) {
                G0("请查看并确认" + leftTitleToRightArrowVo.getLeft());
                return true;
            }
        }
        return false;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        Q1();
        e2();
        d2();
        if (this.F) {
            f2();
        }
        j0();
    }

    public final void b2(LeftTitleToRightArrowVo leftTitleToRightArrowVo, String str) {
        String str2 = (String) leftTitleToRightArrowVo.getExtObj();
        z0(R.string.loading_text);
        c.getInstance().requestGet(j.getInstance().getBaseUrl() + str2, new a());
    }

    public final void c2() {
        k(new EventUpdateReserveList());
    }

    @OnClick({R.id.btn_confirm})
    public void confirmClick(View view) {
        if (!M0(view) || R1()) {
            return;
        }
        if (this.F) {
            N1();
        } else {
            K0(RoomPayCostDetailsFragment.getInstance(this.f6484b), R.id.flayout_content);
        }
    }

    public final void d2() {
        ContractModel contractModel = (ContractModel) h(ContractModel.class);
        this.B = contractModel;
        contractModel.getRequestTreaty().observe(this, new Observer() { // from class: c.e.c.j0.b.q
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1612a.Y1((ResultTreatyVo) obj);
            }
        });
        this.B.getContractClauseList().observe(this, new s(this));
        this.B.getErrRequestLiveData().observe(this, new Observer() { // from class: c.e.c.j0.b.p
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1611a.a2((RequestErrDto) obj);
            }
        });
    }

    public final void e2() {
        this.r = this.mSwipeRefreshLayout.getBaseRecyclerView();
        LeftTitleToRightArrowAdapter leftTitleToRightArrowAdapter = new LeftTitleToRightArrowAdapter();
        this.t = leftTitleToRightArrowAdapter;
        leftTitleToRightArrowAdapter.setOnItemClickListener(this.J);
        if (this.F) {
            this.t.addHeadView(d.getInstance().getPreAdapterHeadView(this.f6487e, 2));
        } else {
            this.t.addHeadView(d.getInstance().getAdapterHeadView(this.f6487e, 2));
        }
    }

    @m
    public void eventConfirm(ConfirmContractEvent confirmContractEvent) {
        LeftTitleToRightArrowVo leftTitleToRightArrowVo = (LeftTitleToRightArrowVo) this.t.getList().get(confirmContractEvent.getPosition());
        leftTitleToRightArrowVo.setRight(x.getString(R.string.title_confirm_over));
        leftTitleToRightArrowVo.setOnlyKey(0);
        this.t.notifyDataSetChanged();
    }

    public final void f2() {
        ReserveModel reserveModel = (ReserveModel) h(ReserveModel.class);
        this.C = reserveModel;
        reserveModel.getContractClauseVoLiveData().observe(this, new s(this));
        this.C.getPayBillResultVoLiveData().observe(this, new Observer() { // from class: c.e.c.j0.b.u
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1616a.M1((PayBillResultVo) obj);
            }
        });
        this.C.getErrRequestLiveData().observe(this, new Observer() { // from class: c.e.c.j0.b.r
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1613a.C((RequestErrDto) obj);
            }
        });
    }

    @OnClick({R.id.tv_back})
    public void finishFragment(View view) {
        n();
    }

    public final void g2() {
        H();
        this.mSwipeRefreshLayout.setRefreshing(false);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_room_sign_contract_nearby;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void j0() {
        z0(R.string.loading_text);
        if (this.F) {
            K1();
        } else {
            this.B.queryContractClauseList(this.f6484b);
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        L0(this);
    }

    public void setKeepRent(boolean z) {
        this.E = z;
    }

    public void setRequestReserveInfoVo(RequestReserveInfoVo requestReserveInfoVo, String str) {
        this.F = true;
        this.G = str;
        this.H = requestReserveInfoVo;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void z(Message message) {
        H();
        if (message.what != 1) {
            F0(R.string.error_view_hint);
            return;
        }
        RoomContractConfirmFragment roomContractConfirmFragment = RoomContractConfirmFragment.getInstance(this.D, null, ((LeftTitleToRightArrowVo) this.t.getList().get(this.D)).getLeft());
        roomContractConfirmFragment.setHtmlContent((String) message.obj);
        K0(roomContractConfirmFragment, R.id.flayout_content);
    }
}
