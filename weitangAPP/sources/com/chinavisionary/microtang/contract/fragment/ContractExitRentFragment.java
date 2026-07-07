package com.chinavisionary.microtang.contract.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import butterknife.BindView;
import butterknife.OnClick;
import c.b.a.d.g;
import c.b.a.f.c;
import c.e.a.d.x;
import c.e.a.d.z;
import com.chinavisionary.core.app.adapter.BaseRecyclerAdapter;
import com.chinavisionary.core.app.base.CoreBaseFragment;
import com.chinavisionary.core.app.config.bo.LeftTitleToRightArrowVo;
import com.chinavisionary.core.app.net.base.dto.RequestErrDto;
import com.chinavisionary.core.app.net.base.dto.ResponseStateVo;
import com.chinavisionary.core.weight.BaseSwipeRefreshLayout;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseFragment;
import com.chinavisionary.microtang.contract.adapter.ContractExitRentAdapter;
import com.chinavisionary.microtang.contract.model.ContractModel;
import com.chinavisionary.microtang.contract.vo.ContractExitRentVo;
import com.chinavisionary.microtang.contract.vo.ExitRentFeeConfigVo;
import com.chinavisionary.microtang.contract.vo.ExitRentVo;
import com.chinavisionary.microtang.contract.vo.RequestExitRentVo;
import com.chinavisionary.microtang.contract.vo.UpdateContractEventVo;
import com.chinavisionary.microtang.web.WebViewActivity;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ContractExitRentFragment extends BaseFragment<LeftTitleToRightArrowVo> {
    public int B;
    public Long C;
    public c D;
    public ContractModel E;
    public c.e.c.o.d.a F;
    public Long G;
    public Long H;
    public RequestExitRentVo I;
    public c.e.c.o.b.a J = new a();
    public c.e.a.a.c.c.a K = new c.e.a.a.c.c.a() { // from class: c.e.c.o.c.h
        @Override // c.e.a.a.c.c.a
        public final void onItemClickListener(View view, int i2) {
            this.f1747a.O1(view, i2);
        }
    };

    @BindView(R.id.swipe_refresh_layout)
    public BaseSwipeRefreshLayout mSwipeRefreshLayout;

    @BindView(R.id.tv_title)
    public TextView mTitleTv;

    public class a implements c.e.c.o.b.a {
        public a() {
        }

        @Override // c.e.c.o.b.a
        public void onExitRentTime(Date date) {
            ContractExitRentFragment.this.W1(date);
        }
    }

    public class b implements g {
        public b() {
        }

        @Override // c.b.a.d.g
        public void onTimeSelect(Date date, View view) {
            ContractExitRentFragment.this.W1(date);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: N1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void O1(View view, int i2) {
        int onlyKey = ((LeftTitleToRightArrowVo) this.t.getList().get(i2)).getOnlyKey();
        this.B = i2;
        if (onlyKey == 12) {
            I1();
        } else if (onlyKey == 17) {
            H1();
        } else {
            if (onlyKey != 1233) {
                return;
            }
            G1();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: P1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void Q1(ResponseStateVo responseStateVo) {
        a2();
        if (F(responseStateVo, R.string.tip_submit_success, R.string.tip_submit_failed)) {
            g0();
            g.b.a.c.getDefault().post(new UpdateContractEventVo());
            K0(ContractRescissionDetailsFragment.getInstance(this.f6484b), R.id.flayout_content);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: R1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void S1(ResponseStateVo responseStateVo) {
        a2();
        if (responseStateVo != null) {
            V1(responseStateVo.getContent());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: T1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void U1(RequestErrDto requestErrDto) {
        a2();
        C(requestErrDto);
    }

    public static ContractExitRentFragment getInstance(String str) {
        ContractExitRentFragment contractExitRentFragment = new ContractExitRentFragment();
        contractExitRentFragment.setArguments(CoreBaseFragment.q(str));
        return contractExitRentFragment;
    }

    public final void F1() {
        this.t.getList().add(this.B + 1, this.F.getExitRentFeeItem());
    }

    public final void G1() {
        K1(this.G, this.H);
    }

    public final void H1() {
        ExitRentFeeConfigVo exitRentFeeConfigVo = new ExitRentFeeConfigVo();
        exitRentFeeConfigVo.setKey(this.f6484b);
        exitRentFeeConfigVo.setExitRentDate(this.C.longValue());
        exitRentFeeConfigVo.setStartTime(this.G.longValue());
        exitRentFeeConfigVo.setEndTime(this.H.longValue());
        exitRentFeeConfigVo.setExitRentTimeCallback(this.J);
        exitRentFeeConfigVo.setRentAddress(((LeftTitleToRightArrowVo) this.t.getList().get(0)).getRight());
        d(ContractExitRentFeePreFragment.getInstance(exitRentFeeConfigVo), R.id.flayout_content);
    }

    public final void I1() {
        z0(R.string.tip_get_data);
        this.E.getExitRentRule();
    }

    public final void J1() {
        RequestExitRentVo exitRentVo = this.F.getExitRentVo(this.t.getList());
        this.I = exitRentVo;
        if (this.C == null) {
            F0(R.string.title_exit_rent_time);
            return;
        }
        if (exitRentVo.getRentBackTagKeys().isEmpty()) {
            F0(R.string.title_select_exit_rent_reason);
            return;
        }
        this.I.setRentBackDate(this.C.longValue());
        this.I.setContractKey(this.f6484b);
        z0(R.string.tip_submit_data_loading);
        this.E.postExitRent(this.I);
    }

    public final void K1(Long l, Long l2) {
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
        c timePickerView = this.F.getTimePickerView(this.f6487e, l, l2, new b(), this.y);
        this.D = timePickerView;
        timePickerView.show();
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final void L1(ContractExitRentVo contractExitRentVo) {
        a2();
        this.G = contractExitRentVo.getRentBackDate();
        this.H = contractExitRentVo.getRentEndDate();
        this.t.initListData((List<T>) this.F.getListData(contractExitRentVo));
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
        int id = view.getId();
        if (id == R.id.btn_confirm_time) {
            this.D.returnData();
            return;
        }
        if (id == R.id.id_exit_reason_cb) {
            b2(view);
        } else {
            if (id != R.id.tv_alert_confirm) {
                return;
            }
            z0(R.string.tip_submit_data_loading);
            this.E.postExitRent(this.I);
        }
    }

    public final void V1(String str) {
        Intent intent = new Intent(this.f6487e, (Class<?>) WebViewActivity.class);
        intent.setFlags(268435456);
        intent.putExtra("content", str);
        intent.putExtra("titleKey", x.getString(R.string.title_exit_rule));
        startActivity(intent);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        this.mTitleTv.setText(R.string.title_apply_exit_rent);
        this.F = new c.e.c.o.d.a();
        Y1();
        Z1();
        j0();
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void W1(Date date) {
        if (this.C == null) {
            F1();
        }
        int onlyKeyToPosition = LeftTitleToRightArrowVo.getOnlyKeyToPosition(this.t.getList(), 1233);
        this.C = Long.valueOf(date.getTime());
        this.D.dismiss();
        this.D.setDate(this.F.getSelectDate(this.C));
        ((LeftTitleToRightArrowVo) this.t.getList().get(onlyKeyToPosition)).setRight(z.getTimeYYMMDD(this.C) + c.e.c.o.d.a.getExitAdvanceDay(this.C));
        this.t.notifyItemChanged(onlyKeyToPosition);
    }

    public final void X1() {
        int onlyKeyToPosition;
        BaseRecyclerAdapter<T> baseRecyclerAdapter = this.t;
        if (baseRecyclerAdapter == 0 || (onlyKeyToPosition = LeftTitleToRightArrowVo.getOnlyKeyToPosition(baseRecyclerAdapter.getList(), 17)) == -1) {
            return;
        }
        this.t.getList().remove(onlyKeyToPosition);
        this.t.notifyDataSetChanged();
    }

    public final void Y1() {
        ContractModel contractModel = (ContractModel) h(ContractModel.class);
        this.E = contractModel;
        contractModel.getExitRent().observe(this, new Observer() { // from class: c.e.c.o.c.j
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1751a.L1((ContractExitRentVo) obj);
            }
        });
        this.E.getRequestResult().observe(this, new Observer() { // from class: c.e.c.o.c.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1745a.Q1((ResponseStateVo) obj);
            }
        });
        this.E.getExitRentRuleResult().observe(this, new Observer() { // from class: c.e.c.o.c.k
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1754a.S1((ResponseStateVo) obj);
            }
        });
        this.E.getErrRequestLiveData().observe(this, new Observer() { // from class: c.e.c.o.c.i
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1749a.U1((RequestErrDto) obj);
            }
        });
    }

    public final void Z1() {
        this.r = this.mSwipeRefreshLayout.getBaseRecyclerView();
        ContractExitRentAdapter contractExitRentAdapter = new ContractExitRentAdapter();
        this.t = contractExitRentAdapter;
        contractExitRentAdapter.setOnItemClickListener(this.K);
        this.t.setOnClickListener(this.y);
    }

    public final void a2() {
        H();
        this.mSwipeRefreshLayout.setRefreshing(false);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void b2(View view) {
        CheckBox checkBox = (CheckBox) view;
        int iIntValue = ((Integer) view.getTag(R.id.id_exit_reason_cb_index)).intValue();
        int iIntValue2 = ((Integer) view.getTag(R.id.id_exit_reason_cb)).intValue();
        ((ExitRentVo) ((LeftTitleToRightArrowVo) this.t.getList().get(iIntValue2)).getExtObj()).getTags().get(iIntValue).setSelect(checkBox.isChecked());
        this.t.notifyItemChanged(iIntValue2);
    }

    @OnClick({R.id.tv_back})
    public void backClick(View view) {
        n();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_contract_exit_rent;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void j0() {
        z0(R.string.loading_text);
        this.C = null;
        X1();
        this.E.getContractExitRentInfo(this.f6484b);
    }

    @OnClick({R.id.btn_next})
    public void nextClick(View view) {
        J1();
    }
}
