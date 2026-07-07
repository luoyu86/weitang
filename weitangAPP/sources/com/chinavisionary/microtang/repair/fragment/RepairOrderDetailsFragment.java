package com.chinavisionary.microtang.repair.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.lifecycle.Observer;
import butterknife.BindView;
import butterknife.OnClick;
import c.e.a.d.q;
import c.e.a.d.x;
import com.chinavisionary.core.app.base.CoreBaseFragment;
import com.chinavisionary.core.app.config.bo.LeftTitleToRightArrowVo;
import com.chinavisionary.core.app.net.base.dto.RequestErrDto;
import com.chinavisionary.core.app.net.base.dto.ResponseStateVo;
import com.chinavisionary.core.weight.BaseSwipeRefreshLayout;
import com.chinavisionary.core.weight.CoreRoundedImageView;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseFragment;
import com.chinavisionary.microtang.bill.BillTabActivity;
import com.chinavisionary.microtang.order.event.EventUpdateOrderStatus;
import com.chinavisionary.microtang.repair.adapter.RepairOrderDetailsAdapter;
import com.chinavisionary.microtang.repair.event.UpdateAuthOpenDoorTimeEvent;
import com.chinavisionary.microtang.repair.model.RepairModel;
import com.chinavisionary.microtang.repair.vo.EventUpdateOrderState;
import com.chinavisionary.microtang.repair.vo.RepairOrderItemDetailsVo;
import com.chinavisionary.microtang.repair.vo.UpdateAuthOpenDoorTimeFragmentParamBo;
import com.chinavisionary.microtang.view.ExitStateView;
import com.hedgehog.ratingbar.RatingBar;
import g.b.a.m;
import g.b.a.r;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class RepairOrderDetailsFragment extends BaseFragment<LeftTitleToRightArrowVo> {
    public View B;
    public ExitStateView C;
    public CoreRoundedImageView D;
    public TextView E;
    public TextView F;
    public RatingBar G;
    public ImageButton H;
    public int I;
    public String J;
    public RepairOrderItemDetailsVo K;
    public RepairModel L;
    public c.e.c.g0.c.a M;
    public int N;
    public RepairOrderListFragment O;
    public final c.e.a.a.c.c.a P = new a();

    @BindView(R.id.btn_next)
    public AppCompatButton mCommentBtn;

    @BindView(R.id.swipe_refresh_layout)
    public BaseSwipeRefreshLayout mSwipeRefreshLayout;

    @BindView(R.id.tv_title)
    public TextView mTitleTv;

    @BindView(R.id.btn_update_auth_door)
    public AppCompatButton mUpdateAuthDoorBtn;

    public class a implements c.e.a.a.c.c.a {
        public a() {
        }

        @Override // c.e.a.a.c.c.a
        public void onItemClickListener(View view, int i2) {
            if (((LeftTitleToRightArrowVo) RepairOrderDetailsFragment.this.t.getList().get(i2)).getOnlyKey() == 1) {
                RepairOrderDetailsFragment.this.P1();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: J1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void K1(RepairOrderItemDetailsVo repairOrderItemDetailsVo) {
        Y1();
        I1(repairOrderItemDetailsVo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: L1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void M1(RequestErrDto requestErrDto) {
        Y1();
        C(requestErrDto);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: N1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void O1(ResponseStateVo responseStateVo) {
        Y1();
        if (F(responseStateVo, R.string.tip_cancel_success, R.string.tip_cancel_failed)) {
            RepairOrderListFragment repairOrderListFragment = this.O;
            if (repairOrderListFragment != null) {
                repairOrderListFragment.Q1(this.N, 2);
            }
            T1();
            j0();
        }
    }

    public static RepairOrderDetailsFragment getInstance(String str, int i2) {
        RepairOrderDetailsFragment repairOrderDetailsFragment = new RepairOrderDetailsFragment();
        repairOrderDetailsFragment.setState(i2);
        repairOrderDetailsFragment.setArguments(CoreBaseFragment.q(str));
        return repairOrderDetailsFragment;
    }

    public final void G1() {
        View viewInflate = LayoutInflater.from(this.f6487e).inflate(R.layout.item_repair_order_details_head, (ViewGroup) null, false);
        this.C = (ExitStateView) viewInflate.findViewById(R.id.state_view);
        this.B = viewInflate.findViewById(R.id.layout_user_view);
        this.D = (CoreRoundedImageView) viewInflate.findViewById(R.id.img_user_icon);
        this.E = (TextView) viewInflate.findViewById(R.id.tv_user_name);
        this.G = (RatingBar) viewInflate.findViewById(R.id.rating_bar_comment);
        this.F = (TextView) viewInflate.findViewById(R.id.tv_order_number);
        ImageButton imageButton = (ImageButton) viewInflate.findViewById(R.id.img_btn_phone);
        this.H = imageButton;
        imageButton.setOnClickListener(this.y);
        viewInflate.setVisibility(8);
        this.t.addHeadView(viewInflate);
    }

    public final void H1(int i2) {
        int i3 = 0;
        boolean z = i2 == 3;
        boolean z2 = i2 != 2;
        if (i2 == 1 || i2 == 3) {
            this.mCommentBtn.setText(x.getString(R.string.title_cancel));
        }
        if (z) {
            this.mCommentBtn.setEnabled(false);
            this.mCommentBtn.setText(R.string.title_acceptance_order);
            this.mCommentBtn.setTextColor(getResources().getColor(R.color.colore757575));
            this.mCommentBtn.setBackgroundColor(getResources().getColor(R.color.color_line));
        }
        boolean z3 = i2 == 5;
        if (!z2 || z3) {
            q.d(this.f6485c, "handlerBtnToState visibility = 8");
            this.mCommentBtn.setEnabled(false);
            this.mCommentBtn.setText(x.getString(z3 ? R.string.title_over_order : R.string.title_cancelled));
            this.mCommentBtn.setTextColor(getResources().getColor(R.color.colore757575));
            this.mCommentBtn.setBackgroundColor(getResources().getColor(R.color.color_line));
            i3 = 8;
        }
        if (c.e.a.a.a.getInstance().isTestRepair()) {
            this.mUpdateAuthDoorBtn.setVisibility(i3);
        }
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final void I1(RepairOrderItemDetailsVo repairOrderItemDetailsVo) {
        if (repairOrderItemDetailsVo != null) {
            this.K = repairOrderItemDetailsVo;
            ArrayList arrayList = new ArrayList();
            LeftTitleToRightArrowVo leftTitleToRightArrowVo = new LeftTitleToRightArrowVo();
            leftTitleToRightArrowVo.setTitle(true);
            leftTitleToRightArrowVo.setTitle(x.getString(R.string.title_repair_detailed_title));
            RepairOrderItemDetailsVo.BaseInfoBean baseInfo = repairOrderItemDetailsVo.getBaseInfo();
            if (baseInfo != null) {
                this.I = baseInfo.getStatus();
                this.B.setVisibility(baseInfo.getStatus() == 3 ? 0 : 8);
                if (x.isNotNull(baseInfo.getBillKey())) {
                    LeftTitleToRightArrowVo leftTitleToRightArrowVo2 = new LeftTitleToRightArrowVo();
                    leftTitleToRightArrowVo2.setTitle(x.getString(R.string.title_repair_fee));
                    leftTitleToRightArrowVo2.setTitle(true);
                    arrayList.add(leftTitleToRightArrowVo2);
                    LeftTitleToRightArrowVo leftTitleToRightArrowVo3 = new LeftTitleToRightArrowVo();
                    leftTitleToRightArrowVo3.setLeft(x.getString(R.string.title_repair_pay_fee_item));
                    leftTitleToRightArrowVo3.setRight(baseInfo.getRepairAmountTypeName());
                    arrayList.add(leftTitleToRightArrowVo3);
                    LeftTitleToRightArrowVo leftTitleToRightArrowVo4 = new LeftTitleToRightArrowVo();
                    leftTitleToRightArrowVo4.setLeft(x.getString(R.string.title_pay_fee_price_item));
                    leftTitleToRightArrowVo4.setOnlyKey(1);
                    leftTitleToRightArrowVo4.setKey(baseInfo.getBillKey());
                    leftTitleToRightArrowVo4.setShowArrow(true);
                    leftTitleToRightArrowVo4.setRight(x.bigDecimalToString(baseInfo.getRepairAmount()));
                    leftTitleToRightArrowVo4.setPrice(true);
                    arrayList.add(leftTitleToRightArrowVo4);
                }
            }
            arrayList.add(leftTitleToRightArrowVo);
            RepairOrderItemDetailsVo.WorkerInfoBean workerInfo = repairOrderItemDetailsVo.getWorkerInfo();
            if (workerInfo != null) {
                this.E.setText(x.getNotNullStr(workerInfo.getRepairName(), ""));
                this.F.setText(workerInfo.getWorkorderNums() + "");
                this.G.setStar((float) workerInfo.getScore());
                this.J = workerInfo.getRepairPhone();
            }
            arrayList.addAll(this.M.getAdapterData(baseInfo));
            if (baseInfo != null) {
                U1(baseInfo.getStatus());
                H1(baseInfo.getStatus());
                Long toTime = baseInfo.getToTime();
                if (toTime != null) {
                    int i2 = ((toTime.longValue() - System.currentTimeMillis()) > 0L ? 1 : ((toTime.longValue() - System.currentTimeMillis()) == 0L ? 0 : -1));
                }
            }
            this.t.initListData(arrayList);
        }
    }

    public final void P1() {
        d0(BillTabActivity.class);
    }

    public final void Q1() {
        int i2 = this.I;
        if (i2 == 1 || i2 == 3) {
            u0(x.getString(R.string.title_confirm_cancel_repair_order));
        } else {
            if (i2 != 4) {
                return;
            }
            K0(RepairOrderCommentFragment.getInstance(this.f6484b), R.id.flayout_content);
        }
    }

    public final void R1() {
        RepairOrderItemDetailsVo repairOrderItemDetailsVo = this.K;
        if (repairOrderItemDetailsVo == null || repairOrderItemDetailsVo.getBaseInfo() == null) {
            F0(R.string.title_data_err_retry);
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        RepairOrderItemDetailsVo.BaseInfoBean baseInfo = this.K.getBaseInfo();
        if (x.isNotNull(baseInfo.getWorkOrderKey())) {
            UpdateAuthOpenDoorTimeFragmentParamBo updateAuthOpenDoorTimeFragmentParamBo = new UpdateAuthOpenDoorTimeFragmentParamBo();
            updateAuthOpenDoorTimeFragmentParamBo.setAuth(baseInfo.getAuthOpen());
            updateAuthOpenDoorTimeFragmentParamBo.setOrderKey(this.f6484b);
            updateAuthOpenDoorTimeFragmentParamBo.setType(1);
            updateAuthOpenDoorTimeFragmentParamBo.setWorkOrderKey(baseInfo.getWorkOrderKey());
            updateAuthOpenDoorTimeFragmentParamBo.setEndServiceTime(baseInfo.getToTime());
            updateAuthOpenDoorTimeFragmentParamBo.setStartServiceTime(baseInfo.getFromTime());
            updateAuthOpenDoorTimeFragmentParamBo.setEndTime(baseInfo.getOpenToTime());
            updateAuthOpenDoorTimeFragmentParamBo.setStartTime(baseInfo.getOpenFromTime());
            K0(UpdateAuthOpenDoorTimeFragment.getInstance(updateAuthOpenDoorTimeFragmentParamBo), R.id.flayout_content);
        } else {
            F0(R.string.tip_work_order_key_empty);
        }
        q.d(this.f6485c, "openUpdateAuthDoorFragment time:" + (System.currentTimeMillis() - jCurrentTimeMillis) + "ms");
    }

    public final void S1() {
        z0(R.string.tip_cancel_ordering);
        this.L.cancelRepairOrder(this.f6484b);
    }

    public final void T1() {
        k(new EventUpdateOrderStatus());
    }

    public final void U1(int i2) {
        if (i2 == 2) {
            this.C.setVisibility(8);
        } else {
            this.C.setStateVoList(this.M.getStateVoListToState(i2));
        }
        boolean z = i2 >= 3;
        this.D.setVisibility(z ? 0 : 8);
        this.E.setVisibility(z ? 0 : 8);
        this.G.setVisibility(z ? 0 : 8);
        this.F.setVisibility(z ? 0 : 8);
        this.H.setVisibility(z ? 0 : 8);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
        switch (view.getId()) {
            case R.id.btn_next /* 2131230879 */:
                Q1();
                break;
            case R.id.btn_update_auth_door /* 2131230915 */:
                R1();
                break;
            case R.id.img_btn_phone /* 2131231199 */:
                f(this.J);
                break;
            case R.id.tv_alert_confirm /* 2131231942 */:
                S1();
                break;
        }
    }

    public final void V1() {
        RepairModel repairModel = (RepairModel) h(RepairModel.class);
        this.L = repairModel;
        repairModel.getRepairOrderItemDetails().observe(this, new Observer() { // from class: c.e.c.g0.b.n
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1472a.K1((RepairOrderItemDetailsVo) obj);
            }
        });
        this.L.getErrRequestLiveData().observe(this, new Observer() { // from class: c.e.c.g0.b.o
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1473a.M1((RequestErrDto) obj);
            }
        });
        this.L.getResultLiveData().observe(this, new Observer() { // from class: c.e.c.g0.b.m
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1471a.O1((ResponseStateVo) obj);
            }
        });
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        X1();
        W1();
        V1();
        H1(this.I);
        z0(R.string.loading_text);
        j0();
    }

    public final void W1() {
        this.M = new c.e.c.g0.c.a();
        this.r = this.mSwipeRefreshLayout.getBaseRecyclerView();
        RepairOrderDetailsAdapter repairOrderDetailsAdapter = new RepairOrderDetailsAdapter();
        this.t = repairOrderDetailsAdapter;
        repairOrderDetailsAdapter.setOnClickListener(this.y);
        this.t.setOnItemClickListener(this.P);
        G1();
    }

    public final void X1() {
        this.mTitleTv.setText(R.string.title_repair_order_details);
        h0(this);
        this.mUpdateAuthDoorBtn.setOnClickListener(this.y);
        this.mCommentBtn.setOnClickListener(this.y);
    }

    public final void Y1() {
        H();
        this.mSwipeRefreshLayout.setRefreshing(false);
    }

    @OnClick({R.id.tv_back})
    public void backClick(View view) {
        n();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_repair_order_details;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void j0() {
        RepairModel repairModel = this.L;
        if (repairModel != null) {
            repairModel.getRepairOrderItemDetails(this.f6484b);
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        L0(this);
    }

    public void setRepairOrderListFragment(RepairOrderListFragment repairOrderListFragment, int i2) {
        this.N = i2;
        this.O = repairOrderListFragment;
    }

    public void setState(int i2) {
        this.I = i2;
    }

    @m(threadMode = r.BACKGROUND)
    public void updateAuthDoorEventList(UpdateAuthOpenDoorTimeEvent updateAuthOpenDoorTimeEvent) {
        j0();
    }

    @m(threadMode = r.BACKGROUND)
    public void updateList(EventUpdateOrderState eventUpdateOrderState) {
        j0();
    }
}
