package com.chinavisionary.microtang.room.fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import butterknife.BindView;
import butterknife.OnClick;
import c.e.a.d.o;
import c.e.a.d.q;
import c.e.a.d.x;
import c.e.c.m0.c;
import com.chinavisionary.core.app.base.CoreBaseFragment;
import com.chinavisionary.core.app.net.base.dto.NewResponseRowsVo;
import com.chinavisionary.core.app.net.base.dto.RequestErrDto;
import com.chinavisionary.core.weight.BaseSwipeRefreshLayout;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.auth.IDAuthActivity;
import com.chinavisionary.microtang.base.BaseFragment;
import com.chinavisionary.microtang.main.bo.RequestGroupItemDetailsRoomListBo;
import com.chinavisionary.microtang.main.model.NewRoomModel;
import com.chinavisionary.microtang.main.vo.ResponseGroupItemDetailsRoomVo;
import com.chinavisionary.microtang.repair.vo.ResponseVo;
import com.chinavisionary.microtang.room.adapter.MoreRentRoomAdapter;
import com.chinavisionary.microtang.room.vo.MoreRentRoomVo;

/* JADX INFO: loaded from: classes2.dex */
public class MoreRentRoomFragment extends BaseFragment<MoreRentRoomVo> {
    public c.e.c.h0.e.a B;
    public NewRoomModel C;
    public String F;

    @BindView(R.id.btn_reset)
    public ImageButton mResetImgBtn;

    @BindView(R.id.tv_room_source_list)
    public TextView mRoomSourceTv;

    @BindView(R.id.edt_search_room)
    public EditText mSearchRoomEdt;

    @BindView(R.id.swipe_refresh_layout_more_rent)
    public BaseSwipeRefreshLayout mSwipeRefreshLayout;

    @BindView(R.id.tv_tip_search)
    public TextView mTipSearchTv;
    public int D = 0;
    public int E = 0;
    public final c.e.a.a.c.c.a G = new c.e.a.a.c.c.a() { // from class: c.e.c.h0.f.f
        @Override // c.e.a.a.c.c.a
        public final void onItemClickListener(View view, int i2) {
            this.f1500a.V1(view, i2);
        }
    };
    public final TextWatcher H = new b();
    public final Runnable I = new Runnable() { // from class: c.e.c.h0.f.h
        @Override // java.lang.Runnable
        public final void run() {
            this.f1502a.X1();
        }
    };

    public class a implements View.OnFocusChangeListener {
        public a() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            q.d(a.class.getCanonicalName(), "onFocusChange hasFocus = " + z);
            if (!z) {
                MoreRentRoomFragment.this.mSearchRoomEdt.getLayoutParams().width = MoreRentRoomFragment.this.D;
            } else {
                MoreRentRoomFragment.this.B.onExpandedHied();
                MoreRentRoomFragment.this.mSearchRoomEdt.getLayoutParams().width = MoreRentRoomFragment.this.E;
            }
        }
    }

    public class b implements TextWatcher {
        public b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            MoreRentRoomFragment.this.d2();
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            MoreRentRoomFragment.this.f6488f.removeCallbacksAndMessages(null);
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: S1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void T1(MoreRentRoomVo moreRentRoomVo, View view) {
        Z1(moreRentRoomVo.getAssetInstanceKey(), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: U1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void V1(View view, int i2) {
        c2(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: W1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void X1() {
        this.f6483a = 1;
        this.mTipSearchTv.setVisibility(0);
        String string = this.mSearchRoomEdt.getText().toString();
        this.mResetImgBtn.setVisibility(x.isNotNull(string) ? 0 : 8);
        this.C.getGroupItemDetailsRoomList(K1(string));
    }

    public static MoreRentRoomFragment getInstance(String str, c.e.c.h0.e.a aVar) {
        MoreRentRoomFragment moreRentRoomFragment = new MoreRentRoomFragment();
        moreRentRoomFragment.B = aVar;
        moreRentRoomFragment.setArguments(CoreBaseFragment.q(str));
        return moreRentRoomFragment;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final void J1() {
        if (this.f6483a == 1) {
            this.t.addDataToList((T) new MoreRentRoomVo());
        }
    }

    public final RequestGroupItemDetailsRoomListBo K1(String str) {
        RequestGroupItemDetailsRoomListBo requestGroupItemDetailsRoomListBo = new RequestGroupItemDetailsRoomListBo();
        requestGroupItemDetailsRoomListBo.setPageBo(r());
        requestGroupItemDetailsRoomListBo.setPageSize(60000);
        requestGroupItemDetailsRoomListBo.setGroupKey(this.f6484b);
        if (x.isNotNull(str)) {
            requestGroupItemDetailsRoomListBo.setHouseName(str);
        }
        requestGroupItemDetailsRoomListBo.setProjectKey(this.F);
        return requestGroupItemDetailsRoomListBo;
    }

    public final void L1(NewResponseRowsVo<ResponseGroupItemDetailsRoomVo> newResponseRowsVo) {
        N1(c.e.c.h0.g.b.groupRoomToMoreRentRoomVo(newResponseRowsVo));
    }

    public final void M1(MoreRentRoomVo moreRentRoomVo) {
        if (M()) {
            Z1(moreRentRoomVo.getAssetInstanceKey(), true);
        } else {
            a2(R.string.tip_pre_auth);
        }
    }

    public final void N1(ResponseVo<MoreRentRoomVo> responseVo) {
        if (responseVo == null || !o.isNotEmpty(responseVo.getRows())) {
            this.mTipSearchTv.setVisibility(8);
            D(null);
            J1();
        } else {
            this.mTipSearchTv.setVisibility(8);
            D(responseVo.getRows());
        }
        g2(null);
    }

    public final void O1(final MoreRentRoomVo moreRentRoomVo) {
        if (!M()) {
            a2(R.string.tip_auth_sign);
        } else if (c.getInstance().isShowEnterpriseMsg()) {
            C1(x.getString(R.string.tip_enterprise_not_sale), x.getString(R.string.big_tip_msg), Boolean.TRUE, new View.OnClickListener() { // from class: c.e.c.h0.f.i
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f1503a.T1(moreRentRoomVo, view);
                }
            });
        } else {
            Z1(moreRentRoomVo.getAssetInstanceKey(), false);
        }
    }

    public final void P1(View view, boolean z) {
        MoreRentRoomVo moreRentRoomVo = (MoreRentRoomVo) view.getTag();
        int status = moreRentRoomVo.getStatus();
        if (N()) {
            if (z) {
                M1(moreRentRoomVo);
                return;
            }
            if (status != 1) {
                if (status == 5) {
                    M1(moreRentRoomVo);
                    return;
                } else if (status != 6 && status != 7) {
                    return;
                }
            }
            O1(moreRentRoomVo);
        }
    }

    public final void Q1() {
        this.D = this.mRoomSourceTv.getResources().getDimensionPixelSize(R.dimen.dp_124);
        this.E = this.mRoomSourceTv.getResources().getDimensionPixelSize(R.dimen.dp_240);
        this.mRoomSourceTv.setVisibility(0);
        this.F = R0();
        this.f6488f = new CoreBaseFragment.c(this);
        this.mSearchRoomEdt.getLayoutParams().width = this.D;
        this.mSearchRoomEdt.setRawInputType(2);
        this.mSearchRoomEdt.addTextChangedListener(this.H);
        this.mSearchRoomEdt.setOnFocusChangeListener(new a());
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
        int id = view.getId();
        if (id == R.id.tv_cat_room_source_details) {
            b2(view);
        } else if (id == R.id.tv_room_pre) {
            P1(view, true);
        } else {
            if (id != R.id.tv_room_sing_or_pre) {
                return;
            }
            P1(view, false);
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        Q1();
        e2();
        f2();
        z0(R.string.loading_text);
        j0();
    }

    public final void Z1(String str, boolean z) {
        d(AirQualityFragment.getInstance(str, z), R.id.flayout_content);
    }

    public final void a2(int i2) {
        d0(IDAuthActivity.class);
        F0(i2);
    }

    public final void b2(View view) {
        c2(((Integer) view.getTag()).intValue());
    }

    public final void c2(int i2) {
        MoreRentRoomVo moreRentRoomVo = (MoreRentRoomVo) o.getListDataToPosition(this.t.getList(), i2);
        if (moreRentRoomVo != null) {
            K0(RoomSourceDetailsFragment.getInstance(moreRentRoomVo.getAssetInstanceKey(), null), R.id.flayout_content);
        }
    }

    public final void d2() {
        this.f6488f.postDelayed(this.I, 300L);
    }

    public final void e2() {
        BaseSwipeRefreshLayout baseSwipeRefreshLayout = this.mSwipeRefreshLayout;
        this.s = baseSwipeRefreshLayout;
        this.r = baseSwipeRefreshLayout.getBaseRecyclerView();
        MoreRentRoomAdapter moreRentRoomAdapter = new MoreRentRoomAdapter();
        this.t = moreRentRoomAdapter;
        moreRentRoomAdapter.setEmptyIconResId(R.mipmap.ic_empty_room_list);
        this.t.setEmptyTipMsg(getString(R.string.tip_search_room_empty));
        this.t.setOnItemClickListener(this.G);
        this.t.setOnClickListener(this.y);
    }

    public final void f2() {
        NewRoomModel newRoomModel = (NewRoomModel) h(NewRoomModel.class);
        this.C = newRoomModel;
        newRoomModel.getGroupRoomListResult().observe(this, new Observer() { // from class: c.e.c.h0.f.j
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1505a.L1((NewResponseRowsVo) obj);
            }
        });
        this.C.getErrRequestLiveData().observe(this, new Observer() { // from class: c.e.c.h0.f.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1501a.g2((RequestErrDto) obj);
            }
        });
    }

    public final void g2(RequestErrDto requestErrDto) {
        H();
        this.mTipSearchTv.setVisibility(8);
        this.mSwipeRefreshLayout.setRefreshing(false);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_more_rent_room;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void j0() {
        this.C.getGroupItemDetailsRoomList(K1(null));
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.mSearchRoomEdt.removeTextChangedListener(this.H);
    }

    @OnClick({R.id.btn_reset})
    public void resetClick() {
        this.f6483a = 1;
        this.mSearchRoomEdt.setText("");
        this.mResetImgBtn.setVisibility(8);
        this.C.getGroupItemDetailsRoomList(K1(null));
    }
}
