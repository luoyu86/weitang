package com.chinavisionary.microtang.order.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.lifecycle.Observer;
import butterknife.BindView;
import butterknife.OnClick;
import c.e.a.d.x;
import c.e.c.b0.c.d;
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
import com.chinavisionary.microtang.order.model.CleanOrderModel;
import com.chinavisionary.microtang.order.vo.CleanOrderDetailsVo;
import com.chinavisionary.microtang.order.vo.CleanOrderItemDetailsVo;
import com.chinavisionary.microtang.repair.adapter.RepairOrderDetailsAdapter;
import com.chinavisionary.microtang.repair.event.UpdateAuthOpenDoorTimeEvent;
import com.chinavisionary.microtang.repair.fragment.UpdateAuthOpenDoorTimeFragment;
import com.chinavisionary.microtang.repair.vo.EventUpdateOrderState;
import com.chinavisionary.microtang.repair.vo.UpdateAuthOpenDoorTimeFragmentParamBo;
import com.chinavisionary.microtang.view.ExitStateView;
import com.hedgehog.ratingbar.RatingBar;
import g.b.a.m;
import g.b.a.r;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class CleanOrderDetailsFragment extends BaseFragment<LeftTitleToRightArrowVo> {
    public CleanOrderItemDetailsVo B;
    public View C;
    public ExitStateView D;
    public CoreRoundedImageView E;
    public TextView F;
    public TextView G;
    public RatingBar H;
    public ImageButton I;
    public int J;
    public String K;
    public CleanOrderModel L;
    public d M;
    public c.e.a.a.c.c.a N = new a();

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
            if (((LeftTitleToRightArrowVo) CleanOrderDetailsFragment.this.t.getList().get(i2)).getOnlyKey() == 1) {
                CleanOrderDetailsFragment.this.P1();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: J1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void K1(CleanOrderItemDetailsVo cleanOrderItemDetailsVo) {
        Y1();
        I1(cleanOrderItemDetailsVo);
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
            T1();
            j0();
        }
    }

    public static CleanOrderDetailsFragment getInstance(String str, int i2) {
        CleanOrderDetailsFragment cleanOrderDetailsFragment = new CleanOrderDetailsFragment();
        cleanOrderDetailsFragment.setState(i2);
        cleanOrderDetailsFragment.setArguments(CoreBaseFragment.q(str));
        return cleanOrderDetailsFragment;
    }

    public final void G1() {
        View viewInflate = LayoutInflater.from(this.f6487e).inflate(R.layout.item_repair_order_details_head, (ViewGroup) null, false);
        this.D = (ExitStateView) viewInflate.findViewById(R.id.state_view);
        this.C = viewInflate.findViewById(R.id.layout_user_view);
        this.E = (CoreRoundedImageView) viewInflate.findViewById(R.id.img_user_icon);
        this.F = (TextView) viewInflate.findViewById(R.id.tv_user_name);
        this.H = (RatingBar) viewInflate.findViewById(R.id.rating_bar_comment);
        this.G = (TextView) viewInflate.findViewById(R.id.tv_order_number);
        ImageButton imageButton = (ImageButton) viewInflate.findViewById(R.id.img_btn_phone);
        this.I = imageButton;
        imageButton.setOnClickListener(this.y);
        viewInflate.setVisibility(8);
        this.t.addHeadView(viewInflate);
    }

    public final void H1(int i2, boolean z) {
        boolean z2 = i2 != 2;
        if (i2 != 1 && i2 != 3) {
            z = z2;
        }
        this.mCommentBtn.setVisibility(z ? 0 : 8);
        if (i2 == 1 || i2 == 3) {
            this.mCommentBtn.setText(x.getString(R.string.title_cancel));
        }
        boolean z3 = i2 == 5;
        boolean z4 = (i2 == 2 || z3) ? false : true;
        if (!z || z3) {
            this.mCommentBtn.setEnabled(false);
            this.mCommentBtn.setText(x.getString(z3 ? R.string.title_over_order : R.string.title_cancelled));
            this.mCommentBtn.setTextColor(getResources().getColor(R.color.colore757575));
            this.mCommentBtn.setBackgroundColor(getResources().getColor(R.color.color_line));
        }
        if (c.e.a.a.a.getInstance().isTestRepair()) {
            this.mUpdateAuthDoorBtn.setVisibility(z4 ? 0 : 8);
        }
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final void I1(CleanOrderItemDetailsVo cleanOrderItemDetailsVo) {
        if (cleanOrderItemDetailsVo != null) {
            this.B = cleanOrderItemDetailsVo;
            ArrayList arrayList = new ArrayList();
            LeftTitleToRightArrowVo leftTitleToRightArrowVo = new LeftTitleToRightArrowVo();
            leftTitleToRightArrowVo.setTitle(true);
            leftTitleToRightArrowVo.setTitle(x.getString(R.string.title_clean_detailed_title));
            CleanOrderDetailsVo baseInfo = cleanOrderItemDetailsVo.getBaseInfo();
            if (baseInfo != null) {
                this.J = baseInfo.getStatus();
                this.C.setVisibility(baseInfo.getStatus() == 3 ? 0 : 8);
                if (x.isNotNull(baseInfo.getBillKey())) {
                    LeftTitleToRightArrowVo leftTitleToRightArrowVo2 = new LeftTitleToRightArrowVo();
                    leftTitleToRightArrowVo2.setTitle(x.getString(R.string.title_clean_fee));
                    leftTitleToRightArrowVo2.setTitle(true);
                    arrayList.add(leftTitleToRightArrowVo2);
                    LeftTitleToRightArrowVo leftTitleToRightArrowVo3 = new LeftTitleToRightArrowVo();
                    leftTitleToRightArrowVo3.setLeft(x.getString(R.string.title_repair_pay_fee_item));
                    leftTitleToRightArrowVo3.setRight(baseInfo.getBusinessTypeName());
                    arrayList.add(leftTitleToRightArrowVo3);
                    LeftTitleToRightArrowVo leftTitleToRightArrowVo4 = new LeftTitleToRightArrowVo();
                    leftTitleToRightArrowVo4.setLeft(x.getString(R.string.title_pay_fee_price_item));
                    leftTitleToRightArrowVo4.setOnlyKey(1);
                    leftTitleToRightArrowVo4.setKey(baseInfo.getBillKey());
                    leftTitleToRightArrowVo4.setShowArrow(true);
                    leftTitleToRightArrowVo4.setRight(x.bigDecimalToString(baseInfo.getOrderAmount()));
                    leftTitleToRightArrowVo4.setPrice(true);
                    arrayList.add(leftTitleToRightArrowVo4);
                }
            }
            arrayList.add(leftTitleToRightArrowVo);
            CleanOrderItemDetailsVo.WorkerInfoBean workerInfo = cleanOrderItemDetailsVo.getWorkerInfo();
            if (workerInfo != null) {
                this.F.setText(x.getNotNullStr(workerInfo.getHandlerPhone(), ""));
                this.K = workerInfo.getHandlerPhone();
            }
            arrayList.addAll(this.M.getAdapterData(baseInfo, workerInfo));
            if (baseInfo != null) {
                U1(baseInfo.getStatus());
                H1(baseInfo.getStatus(), baseInfo.isCanCancel());
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
        int i2 = this.J;
        if (i2 == 1 || i2 == 3) {
            u0(x.getString(R.string.title_confirm_cancel_clean_order));
        } else {
            if (i2 != 4) {
                return;
            }
            K0(CleanOrderCommentFragment.getInstance(this.f6484b), R.id.flayout_content);
        }
    }

    public final void R1() {
        CleanOrderItemDetailsVo cleanOrderItemDetailsVo = this.B;
        if (cleanOrderItemDetailsVo == null || cleanOrderItemDetailsVo.getBaseInfo() == null) {
            F0(R.string.title_data_err_retry);
            return;
        }
        CleanOrderDetailsVo baseInfo = this.B.getBaseInfo();
        if (!x.isNotNull(baseInfo.getWorkOrderKey())) {
            F0(R.string.tip_work_order_key_empty);
            return;
        }
        UpdateAuthOpenDoorTimeFragmentParamBo updateAuthOpenDoorTimeFragmentParamBo = new UpdateAuthOpenDoorTimeFragmentParamBo();
        updateAuthOpenDoorTimeFragmentParamBo.setAuth(baseInfo.isAuthOpen());
        updateAuthOpenDoorTimeFragmentParamBo.setOrderKey(this.f6484b);
        updateAuthOpenDoorTimeFragmentParamBo.setWorkOrderKey(baseInfo.getWorkOrderKey());
        updateAuthOpenDoorTimeFragmentParamBo.setEndServiceTime(baseInfo.getToTime());
        updateAuthOpenDoorTimeFragmentParamBo.setStartServiceTime(baseInfo.getFromTime());
        updateAuthOpenDoorTimeFragmentParamBo.setEndTime(baseInfo.getOpenToTime());
        updateAuthOpenDoorTimeFragmentParamBo.setStartTime(baseInfo.getOpenFromTime());
        updateAuthOpenDoorTimeFragmentParamBo.setType(2);
        K0(UpdateAuthOpenDoorTimeFragment.getInstance(updateAuthOpenDoorTimeFragmentParamBo), R.id.flayout_content);
    }

    public final void S1() {
        z0(R.string.tip_cancel_ordering);
        this.L.postCancelOrder(this.f6484b);
    }

    public final void T1() {
        k(new EventUpdateOrderStatus());
    }

    public final void U1(int i2) {
        if (i2 == 2) {
            this.D.setVisibility(8);
        } else {
            this.D.setStateVoList(this.M.getStateVoListToState(i2));
        }
        boolean z = i2 >= 3;
        this.E.setVisibility(z ? 0 : 8);
        this.F.setVisibility(z ? 0 : 8);
        this.H.setVisibility(z ? 0 : 8);
        this.G.setVisibility(z ? 0 : 8);
        this.I.setVisibility(z ? 0 : 8);
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
                f(this.K);
                break;
            case R.id.tv_alert_confirm /* 2131231942 */:
                S1();
                break;
        }
    }

    public final void V1() {
        CleanOrderModel cleanOrderModel = (CleanOrderModel) h(CleanOrderModel.class);
        this.L = cleanOrderModel;
        cleanOrderModel.getOrderDetails().observe(this, new Observer() { // from class: c.e.c.b0.b.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1386a.K1((CleanOrderItemDetailsVo) obj);
            }
        });
        this.L.getErrRequestLiveData().observe(this, new Observer() { // from class: c.e.c.b0.b.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1387a.M1((RequestErrDto) obj);
            }
        });
        this.L.getCancelResultVo().observe(this, new Observer() { // from class: c.e.c.b0.b.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1385a.O1((ResponseStateVo) obj);
            }
        });
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        X1();
        W1();
        V1();
        H1(this.J, false);
        z0(R.string.loading_text);
        j0();
    }

    public final void W1() {
        this.M = new d();
        this.r = this.mSwipeRefreshLayout.getBaseRecyclerView();
        RepairOrderDetailsAdapter repairOrderDetailsAdapter = new RepairOrderDetailsAdapter();
        this.t = repairOrderDetailsAdapter;
        repairOrderDetailsAdapter.setOnClickListener(this.y);
        this.t.setOnItemClickListener(this.N);
        G1();
    }

    public final void X1() {
        this.mTitleTv.setText(R.string.title_clean_order_details);
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
        CleanOrderModel cleanOrderModel = this.L;
        if (cleanOrderModel != null) {
            cleanOrderModel.getCleanOrderDetails(this.f6484b);
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        L0(this);
    }

    public void setState(int i2) {
        this.J = i2;
    }

    @m(threadMode = r.BACKGROUND)
    public void updateAuthDoorEventList(UpdateAuthOpenDoorTimeEvent updateAuthOpenDoorTimeEvent) {
        j0();
    }

    @m(threadMode = r.MAIN)
    public void updateList(EventUpdateOrderState eventUpdateOrderState) {
        j0();
    }
}
