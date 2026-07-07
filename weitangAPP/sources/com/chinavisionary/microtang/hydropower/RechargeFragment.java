package com.chinavisionary.microtang.hydropower;

import android.content.Intent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.GridLayoutManager;
import butterknife.BindView;
import butterknife.OnClick;
import c.e.a.a.a;
import c.e.a.d.o;
import c.e.a.d.x;
import c.e.c.h0.e.b;
import com.alibaba.fastjson.JSON;
import com.chinavisionary.core.app.net.base.dto.NewResponseRowsVo;
import com.chinavisionary.core.app.net.base.dto.RequestErrDto;
import com.chinavisionary.core.app.net.base.dto.ResponseRowsVo;
import com.chinavisionary.core.weight.BaseRecyclerView;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseFragment;
import com.chinavisionary.microtang.hydropower.model.PayHydropowerModel;
import com.chinavisionary.microtang.hydropower.vo.ElectricVo;
import com.chinavisionary.microtang.hydropower.vo.RoomOtherFeeUnitVo;
import com.chinavisionary.microtang.hydropower.vo.WaterElectriVo;
import com.chinavisionary.microtang.me.adapter.RechargeAdapter;
import com.chinavisionary.paymentlibrary.FragmentPay;
import com.chinavisionary.paymentlibrary.PayTypeActivity;
import com.chinavisionary.paymentlibrary.model.NewBillModel;
import com.chinavisionary.paymentlibrary.vo.PayBillResultVo;
import com.chinavisionary.paymentlibrary.vo.PayTypeVo;
import com.chinavisionary.paymentlibrary.vo.RechargeWaterEleVo;
import com.chinavisionary.paymentlibrary.vo.ResponseH5BillDetailsVo;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class RechargeFragment extends BaseFragment<ElectricVo> {
    public int D;
    public String F;
    public BigDecimal G;
    public BigDecimal H;
    public String I;
    public String J;
    public LinearLayout.LayoutParams K;
    public List<CheckBox> L;
    public PayHydropowerModel M;
    public NewBillModel N;
    public String O;
    public ResponseH5BillDetailsVo P;

    @BindView(R.id.cb_pay)
    public CheckBox mPayCb;

    @BindView(R.id.tv_right_value)
    public TextView mPayPriceTv;

    @BindView(R.id.recycler_recharge)
    public BaseRecyclerView mRechargeRv;

    @BindView(R.id.tv_title)
    public TextView mTitleTv;

    @BindView(R.id.cb_wx_pay)
    public CheckBox mWxPayCb;
    public int B = 4;
    public int C = -1;
    public int E = 2;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: V1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void W1(int i2, boolean z) {
        if (i2 >= 0) {
            O1(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: X1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void Y1(RequestErrDto requestErrDto) {
        if (requestErrDto != null) {
            G0(requestErrDto.getErrMsg());
        }
        H();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: Z1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void a2(ResponseRowsVo responseRowsVo) {
        H();
        if (responseRowsVo != null) {
            E1(responseRowsVo.getRows());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void c2(NewResponseRowsVo newResponseRowsVo) {
        H();
        if (newResponseRowsVo != null) {
            E1(newResponseRowsVo.getRows());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: d2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void e2(RoomOtherFeeUnitVo roomOtherFeeUnitVo) {
        if (roomOtherFeeUnitVo != null) {
            this.G = roomOtherFeeUnitVo.getWaterPrice();
            this.H = roomOtherFeeUnitVo.getElectricityPrice();
            Q1();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: f2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void g2(RequestErrDto requestErrDto) {
        H();
        G0(requestErrDto.getErrMsg());
    }

    public static RechargeFragment getInstance(int i2) {
        RechargeFragment rechargeFragment = new RechargeFragment();
        rechargeFragment.n2(i2);
        return rechargeFragment;
    }

    public final void E1(List<ElectricVo> list) {
        D(list);
    }

    public final void F1() {
        z0(R.string.tip_create_order);
    }

    public final void G1() {
        if (this.P != null) {
            H();
            l2(this.O, this.P);
            return;
        }
        z0(R.string.loading_text);
        RechargeWaterEleVo rechargeWaterEleVo = new RechargeWaterEleVo();
        rechargeWaterEleVo.setPayChannel(1);
        rechargeWaterEleVo.setAmount(new BigDecimal(this.F));
        this.N.postPayWaterEle(rechargeWaterEleVo);
    }

    public final void H1() {
        this.E = 1;
        F1();
    }

    public final void I1(String str) {
        H();
        if (x.isNotNull(str)) {
            d(FragmentPay.getInstance(str, this.E), R.id.flayout_content);
        } else {
            F0(R.string.tip_pay_code_is_empty);
        }
    }

    public final void J1() {
        this.E = 2;
        F1();
    }

    public final void K1() {
        this.M.getElectricList(5);
    }

    public final void L1() {
        this.M.getRechargeWalletList();
    }

    public final void M1() {
        this.M.getWaterList(4);
    }

    public final void N1(PayBillResultVo payBillResultVo) {
        if (payBillResultVo != null) {
            ResponseH5BillDetailsVo responseH5BillDetailsVo = new ResponseH5BillDetailsVo();
            this.P = responseH5BillDetailsVo;
            responseH5BillDetailsVo.setOrderId(payBillResultVo.getPaymentKey());
            if (this.O != null) {
                this.P.setActualAmount(new BigDecimal(this.O));
            }
            G1();
        }
    }

    public final void O1(int i2) {
        List list = this.t.getList();
        if (o.isNotEmpty(list)) {
            int i3 = 0;
            while (i3 < list.size()) {
                ((ElectricVo) list.get(i3)).setDefaultFlag(i2 == i3);
                i3++;
            }
        }
        this.C = i2;
        this.F = ((ElectricVo) list.get(i2)).getValue();
        this.t.notifyDataSetChanged();
    }

    /* JADX INFO: renamed from: P1, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public final void k2(WaterElectriVo waterElectriVo) {
        if (waterElectriVo != null) {
            if (waterElectriVo.isSuccess()) {
                I1(waterElectriVo.getOrderNo());
            } else {
                G0(waterElectriVo.getMessage());
            }
        }
    }

    public final void Q1() {
        int i2 = this.B;
        if (i2 == 3) {
            this.mTitleTv.setText(x.appendStringToResId(R.string.placeholder_room_price, this.I));
            return;
        }
        if (i2 == 4) {
            this.mTitleTv.setText(x.appendStringToResId(R.string.placeholder_water_price, x.bigDecimalToPlainString(this.G)));
            M1();
        } else if (i2 == 5) {
            this.mTitleTv.setText(x.appendStringToResId(R.string.placeholder_electric_price, x.bigDecimalToPlainString(this.H)));
            K1();
        } else {
            if (i2 != 7) {
                return;
            }
            this.mTitleTv.setText(R.string.title_recharge_amount);
            L1();
        }
    }

    public final void R1(View view) {
        int iIntValue = ((Integer) view.getTag()).intValue();
        this.F = (String) view.getTag(R.id.id_recharge_cb);
        int i2 = this.C;
        if (i2 != -1) {
            if (i2 != iIntValue) {
                this.L.get(i2).setChecked(false);
            } else {
                this.L.get(this.C).setChecked(!this.L.get(i2).isChecked());
            }
        }
        this.C = iIntValue;
        p2(this.F);
    }

    public final void S1() {
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.dp_80);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.dp_56);
        this.G = new BigDecimal(0);
        this.H = new BigDecimal(0);
        this.D = getResources().getColor(R.color.color383838);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize2);
        this.K = layoutParams;
        layoutParams.rightMargin = getResources().getDimensionPixelSize(R.dimen.dp_6);
        this.L = new ArrayList();
        RechargeAdapter rechargeAdapter = new RechargeAdapter();
        this.t = rechargeAdapter;
        rechargeAdapter.setICheckBoxCallback(new b() { // from class: c.e.c.s.g
            @Override // c.e.c.h0.e.b
            public final void onCheckBoxClick(int i2, boolean z) {
                this.f1832a.W1(i2, z);
            }
        });
        this.r = this.mRechargeRv;
        this.r.setLayoutManager(new GridLayoutManager(this.f6486d, 4));
    }

    public final boolean T1() {
        return this.B == 3 || this.C != -1;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
        if (view.getId() != R.id.id_recharge_cb) {
            return;
        }
        R1(view);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        S1();
        o2();
        z0(R.string.loading_text);
        j0();
    }

    @OnClick({R.id.tv_item})
    public void alipayClick(View view) {
        if (!T1()) {
            this.mPayCb.setChecked(false);
        } else {
            m2(true);
            H1();
        }
    }

    @OnClick({R.id.tv_bg})
    public void backClick(View view) {
        n();
    }

    @OnClick({R.id.btn_pay})
    public void confirmPayView(View view) {
        String str = this.F;
        if (str == null) {
            F0(R.string.tip_select_recharge_number);
        } else {
            this.O = str;
            G1();
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_recharge;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void j0() {
        this.mTitleTv.setText(R.string.title_recharge_amount);
        L1();
    }

    public final void l2(String str, ResponseH5BillDetailsVo responseH5BillDetailsVo) {
        com.chinavisionary.microtang.bill.vo.RechargeWaterEleVo rechargeWaterEleVo = new com.chinavisionary.microtang.bill.vo.RechargeWaterEleVo();
        rechargeWaterEleVo.setAmount(new BigDecimal(this.F));
        PayTypeVo payTypeVo = new PayTypeVo();
        payTypeVo.setType(this.B);
        payTypeVo.setPrice(x.getNotNullStr(str, ""));
        payTypeVo.setResStrId(R.string.title_recharge_wallet);
        payTypeVo.setInitBJPay(a.getInstance().isJHModel());
        payTypeVo.setExtJson(JSON.toJSONString(rechargeWaterEleVo));
        payTypeVo.setResponseH5BillDetailsVoJson(JSON.toJSONString(responseH5BillDetailsVo));
        g0();
        Intent intent = new Intent(this.f6487e, (Class<?>) PayTypeActivity.class);
        intent.setFlags(268435456);
        intent.putExtra("key", JSON.toJSONString(payTypeVo));
        this.f6487e.startActivity(intent);
    }

    public final void m2(boolean z) {
        this.mPayCb.setChecked(z);
        this.mWxPayCb.setChecked(!z);
    }

    public final void n2(int i2) {
        this.B = i2;
    }

    public final void o2() {
        NewBillModel newBillModel = (NewBillModel) h(NewBillModel.class);
        this.N = newBillModel;
        newBillModel.getIncrementPayBillResultLiveData().observeForever(new Observer() { // from class: c.e.c.s.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1827a.N1((PayBillResultVo) obj);
            }
        });
        this.N.getErrRequestLiveData().observe(this, new Observer() { // from class: c.e.c.s.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1829a.Y1((RequestErrDto) obj);
            }
        });
        PayHydropowerModel payHydropowerModel = (PayHydropowerModel) h(PayHydropowerModel.class);
        this.M = payHydropowerModel;
        payHydropowerModel.getElectricLiveData().observe(this, new Observer() { // from class: c.e.c.s.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1826a.a2((ResponseRowsVo) obj);
            }
        });
        this.M.getWaterLiveData().observe(this, new Observer() { // from class: c.e.c.s.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1833a.c2((NewResponseRowsVo) obj);
            }
        });
        this.M.getRoomFeeLiveData().observe(this, new Observer() { // from class: c.e.c.s.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1831a.e2((RoomOtherFeeUnitVo) obj);
            }
        });
        this.M.getErrRequestLiveData().observe(this, new Observer() { // from class: c.e.c.s.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1828a.g2((RequestErrDto) obj);
            }
        });
        this.M.getElectriVoLiveData().observe(this, new Observer() { // from class: c.e.c.s.i
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1834a.i2((WaterElectriVo) obj);
            }
        });
        this.M.getWaterVoLiveData().observe(this, new Observer() { // from class: c.e.c.s.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1830a.k2((WaterElectriVo) obj);
            }
        });
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.C = -1;
    }

    public final void p2(String str) {
        int i2 = this.B;
        if (i2 == 4) {
            BigDecimal bigDecimal = this.G;
            if (bigDecimal != null) {
                BigDecimal scale = bigDecimal.multiply(new BigDecimal(str)).setScale(2, 4);
                this.mPayPriceTv.setText(x.bigDecimalToString(scale) + x.getString(R.string.rmb_china_unit));
                return;
            }
            return;
        }
        if (i2 != 5) {
            if (i2 != 7) {
                return;
            }
            this.mPayPriceTv.setText(String.valueOf(str) + x.getString(R.string.rmb_china_unit));
            return;
        }
        BigDecimal bigDecimal2 = this.H;
        if (bigDecimal2 != null) {
            BigDecimal scale2 = bigDecimal2.multiply(new BigDecimal(str)).setScale(2, 4);
            this.mPayPriceTv.setText(x.bigDecimalToString(scale2) + x.getString(R.string.rmb_china_unit));
        }
    }

    public void setPayCode(String str) {
        this.J = str;
    }

    public void setRoomPrice(String str) {
        this.I = str;
    }

    @OnClick({R.id.view_bg})
    public void touchOutside(View view) {
        n();
    }

    @OnClick({R.id.tv_wx_item})
    public void wxPayClick(View view) {
        if (!T1()) {
            this.mWxPayCb.setChecked(false);
        } else {
            m2(false);
            J1();
        }
    }
}
