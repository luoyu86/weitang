package com.chinavisionary.microtang.contract.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.lifecycle.Observer;
import butterknife.BindView;
import butterknife.OnClick;
import c.e.a.d.x;
import c.e.a.d.z;
import com.chinavisionary.core.app.base.CoreBaseFragment;
import com.chinavisionary.core.app.base.LeftTitleToRightArrowAdapter;
import com.chinavisionary.core.app.config.bo.LeftTitleToRightArrowVo;
import com.chinavisionary.core.app.net.base.dto.RequestErrDto;
import com.chinavisionary.core.app.net.base.dto.ResponseStateVo;
import com.chinavisionary.core.weight.BaseSwipeRefreshLayout;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseFragment;
import com.chinavisionary.microtang.contract.model.ContractModel;
import com.chinavisionary.microtang.contract.vo.ContractExitRentStateDetailsVo;
import com.chinavisionary.microtang.view.ExitStateView;
import com.chinavisionary.microtang.vo.StateVo;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class ContractExitRentStateFragment extends BaseFragment<LeftTitleToRightArrowVo> {
    public ExitStateView B;
    public AppCompatButton C;
    public ContractModel D;

    @BindView(R.id.swipe_refresh_layout)
    public BaseSwipeRefreshLayout mSwipeRefreshLayout;

    @BindView(R.id.tv_title)
    public TextView mTitleTv;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: G1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void H1(ContractExitRentStateDetailsVo contractExitRentStateDetailsVo) {
        this.mSwipeRefreshLayout.setRefreshing(false);
        F1(contractExitRentStateDetailsVo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: I1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void J1(ResponseStateVo responseStateVo) {
        this.B.setVisibility(F(responseStateVo, R.string.tip_cancel_success, R.string.tip_cancel_failed) ? 8 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: K1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void L1(RequestErrDto requestErrDto) {
        this.mSwipeRefreshLayout.setRefreshing(false);
        C(requestErrDto);
    }

    public static ContractExitRentStateFragment getInstance(String str) {
        ContractExitRentStateFragment contractExitRentStateFragment = new ContractExitRentStateFragment();
        contractExitRentStateFragment.setArguments(CoreBaseFragment.q(str));
        return contractExitRentStateFragment;
    }

    public final void E1() {
        View viewInflate = LayoutInflater.from(this.f6487e).inflate(R.layout.item_exit_rent_state, (ViewGroup) null, false);
        this.B = (ExitStateView) viewInflate.findViewById(R.id.tv_exit_state);
        AppCompatButton appCompatButton = (AppCompatButton) viewInflate.findViewById(R.id.btn_cancel_exit_rent);
        this.C = appCompatButton;
        appCompatButton.setOnClickListener(this.y);
        this.t.addHeadView(viewInflate);
        N1();
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final void F1(ContractExitRentStateDetailsVo contractExitRentStateDetailsVo) {
        ArrayList arrayList = new ArrayList();
        LeftTitleToRightArrowVo leftTitleToRightArrowVo = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo.setLeft("房间地址");
        leftTitleToRightArrowVo.setRight(contractExitRentStateDetailsVo.getAddress());
        arrayList.add(leftTitleToRightArrowVo);
        LeftTitleToRightArrowVo leftTitleToRightArrowVo2 = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo2.setTitle("签约主体信息");
        leftTitleToRightArrowVo2.setTitle(true);
        arrayList.add(leftTitleToRightArrowVo2);
        LeftTitleToRightArrowVo leftTitleToRightArrowVo3 = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo3.setLeft("姓名");
        leftTitleToRightArrowVo3.setRight(contractExitRentStateDetailsVo.getSignUserName());
        leftTitleToRightArrowVo3.setKey("233");
        arrayList.add(leftTitleToRightArrowVo3);
        LeftTitleToRightArrowVo leftTitleToRightArrowVo4 = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo4.setLeft("证件类型");
        leftTitleToRightArrowVo4.setRight("身份证");
        leftTitleToRightArrowVo4.setKey("233");
        arrayList.add(leftTitleToRightArrowVo4);
        LeftTitleToRightArrowVo leftTitleToRightArrowVo5 = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo5.setLeft("证件号");
        leftTitleToRightArrowVo5.setRight(contractExitRentStateDetailsVo.getCardNo());
        leftTitleToRightArrowVo5.setKey("233");
        arrayList.add(leftTitleToRightArrowVo5);
        LeftTitleToRightArrowVo leftTitleToRightArrowVo6 = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo6.setLeft("手机号");
        leftTitleToRightArrowVo6.setRight(contractExitRentStateDetailsVo.getSignUserPhone());
        leftTitleToRightArrowVo6.setKey("233");
        arrayList.add(leftTitleToRightArrowVo6);
        LeftTitleToRightArrowVo leftTitleToRightArrowVo7 = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo7.setTitle("退租信息");
        leftTitleToRightArrowVo7.setTitle(true);
        arrayList.add(leftTitleToRightArrowVo7);
        LeftTitleToRightArrowVo leftTitleToRightArrowVo8 = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo8.setLeft("申请日期");
        leftTitleToRightArrowVo8.setRight(z.getTime(contractExitRentStateDetailsVo.getRentBackApplyDate()));
        arrayList.add(leftTitleToRightArrowVo8);
        LeftTitleToRightArrowVo leftTitleToRightArrowVo9 = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo9.setLeft("退租日期");
        leftTitleToRightArrowVo9.setRight(z.getTime(contractExitRentStateDetailsVo.getRentBackDate()));
        leftTitleToRightArrowVo9.setRightFontColor(R.color.tab_item_select_color);
        arrayList.add(leftTitleToRightArrowVo9);
        this.t.initListData(arrayList);
    }

    public final void M1() {
        z0(R.string.tip_cancel_exit_rent);
        this.D.cancelExitRent(this.f6484b);
    }

    public final void N1() {
        ArrayList arrayList = new ArrayList();
        StateVo stateVo = new StateVo();
        stateVo.setTitle("已申请");
        stateVo.setOver(true);
        arrayList.add(stateVo);
        StateVo stateVo2 = new StateVo();
        stateVo2.setTitle("已受理");
        stateVo2.setOver(true);
        arrayList.add(stateVo2);
        StateVo stateVo3 = new StateVo();
        stateVo3.setTitle("确认中");
        arrayList.add(stateVo3);
        StateVo stateVo4 = new StateVo();
        stateVo4.setTitle("已完成");
        arrayList.add(stateVo4);
        this.B.setStateVoList(arrayList);
        this.C.setVisibility(stateVo2.isOver() ? 8 : 0);
    }

    public final void O1() {
        ContractModel contractModel = (ContractModel) h(ContractModel.class);
        this.D = contractModel;
        contractModel.getExitRentDetails().observe(this, new Observer() { // from class: c.e.c.o.c.q
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1766a.H1((ContractExitRentStateDetailsVo) obj);
            }
        });
        this.D.getRequestResult().observe(this, new Observer() { // from class: c.e.c.o.c.o
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1762a.J1((ResponseStateVo) obj);
            }
        });
        this.D.getErrRequestLiveData().observe(this, new Observer() { // from class: c.e.c.o.c.p
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1764a.L1((RequestErrDto) obj);
            }
        });
    }

    public final void P1() {
        this.r = this.mSwipeRefreshLayout.getBaseRecyclerView();
        this.t = new LeftTitleToRightArrowAdapter();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
        int id = view.getId();
        if (id == R.id.btn_cancel_exit_rent) {
            u0(x.getString(R.string.title_alert_tip));
        } else {
            if (id != R.id.tv_alert_confirm) {
                return;
            }
            M1();
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        this.mTitleTv.setText(R.string.title_exit_rent_apply);
        O1();
        P1();
        E1();
        j0();
    }

    @OnClick({R.id.tv_back})
    public void backClick(View view) {
        n();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_recycler;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void j0() {
        z0(R.string.loading_text);
        this.D.getContractExitRentInfo(this.f6484b);
    }
}
