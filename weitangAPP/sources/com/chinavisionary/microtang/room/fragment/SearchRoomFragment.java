package com.chinavisionary.microtang.room.fragment;

import android.content.Intent;
import android.os.Message;
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
import c.e.c.m0.d;
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
import com.chinavisionary.microtang.room.RoomSourceDetailsActivity;
import com.chinavisionary.microtang.room.adapter.MoreRentRoomAdapter;
import com.chinavisionary.microtang.room.vo.MoreRentRoomVo;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class SearchRoomFragment extends BaseFragment<MoreRentRoomVo> {
    public String B;
    public NewRoomModel C;
    public String D;
    public Long E;
    public Boolean F;
    public List<MoreRentRoomVo> H;

    @BindView(R.id.tv_finish)
    public TextView mCancelTv;

    @BindView(R.id.btn_reset)
    public ImageButton mResetImgBtn;

    @BindView(R.id.edt_search_room)
    public EditText mSearchRoomEdt;

    @BindView(R.id.swipe_refresh_layout_more_rent)
    public BaseSwipeRefreshLayout mSwipeRefreshLayout;

    @BindView(R.id.tv_tip_msg)
    public TextView mTipSearchTv;
    public boolean G = false;
    public final c.e.a.a.c.c.a I = new c.e.a.a.c.c.a() { // from class: c.e.c.h0.f.y
        @Override // c.e.a.a.c.c.a
        public final void onItemClickListener(View view, int i2) {
            this.f1522a.V1(view, i2);
        }
    };
    public final TextWatcher J = new a();
    public Runnable K = new b();

    public class a implements TextWatcher {
        public a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            q.d(a.class.getSimpleName(), "afterTextChanged");
            SearchRoomFragment.this.b2();
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            q.d(a.class.getSimpleName(), "beforeTextChanged");
            SearchRoomFragment.this.f6488f.removeCallbacksAndMessages(null);
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            q.d(a.class.getSimpleName(), "onTextChanged");
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SearchRoomFragment.this.f6483a = 1;
            SearchRoomFragment.this.j0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: S1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void T1(MoreRentRoomVo moreRentRoomVo, View view) {
        W1(moreRentRoomVo.getAssetInstanceKey(), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: U1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void V1(View view, int i2) {
        if (x.isNullStr(this.D)) {
            Y1(i2);
        }
    }

    public static SearchRoomFragment getInstance() {
        return new SearchRoomFragment();
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final void H1() {
        if (this.f6483a == 1) {
            this.mTipSearchTv.setVisibility(8);
            this.t.addDataToList((T) new MoreRentRoomVo());
        }
    }

    public final RequestGroupItemDetailsRoomListBo I1(String str) {
        RequestGroupItemDetailsRoomListBo requestGroupItemDetailsRoomListBo = new RequestGroupItemDetailsRoomListBo();
        requestGroupItemDetailsRoomListBo.setPageBo(r());
        requestGroupItemDetailsRoomListBo.setPageSize(60000);
        requestGroupItemDetailsRoomListBo.setGroupKey(this.f6484b);
        if (x.isNotNull(str)) {
            requestGroupItemDetailsRoomListBo.setHouseName(str);
        }
        requestGroupItemDetailsRoomListBo.setProjectKey(this.B);
        return requestGroupItemDetailsRoomListBo;
    }

    public final void J1(NewResponseRowsVo<ResponseGroupItemDetailsRoomVo> newResponseRowsVo) {
        L1(c.e.c.h0.g.b.groupRoomToMoreRentRoomVo(newResponseRowsVo));
    }

    public final void K1(MoreRentRoomVo moreRentRoomVo) {
        if (M()) {
            W1(moreRentRoomVo.getAssetInstanceKey(), true);
        } else {
            d0(IDAuthActivity.class);
            F0(R.string.tip_pre_auth);
        }
    }

    public final void L1(ResponseVo<MoreRentRoomVo> responseVo) {
        if (responseVo == null || responseVo.getRows() == null || responseVo.getRows().isEmpty()) {
            D(null);
            H1();
        } else {
            d.getInstance().addMoreRentRoom(this.B, responseVo.getRows());
            this.mTipSearchTv.setVisibility(8);
            if (!this.G) {
                c2(responseVo.getRows());
            }
        }
        f2(null);
    }

    public final void M1(final MoreRentRoomVo moreRentRoomVo) {
        if (!M()) {
            d0(IDAuthActivity.class);
            F0(R.string.tip_auth_sign);
        } else if (c.getInstance().isShowEnterpriseMsg()) {
            C1(x.getString(R.string.tip_enterprise_not_sale), x.getString(R.string.big_tip_msg), Boolean.TRUE, new View.OnClickListener() { // from class: c.e.c.h0.f.w
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f1519a.T1(moreRentRoomVo, view);
                }
            });
        } else {
            W1(moreRentRoomVo.getAssetInstanceKey(), false);
        }
    }

    public final void N1(View view, boolean z) {
        MoreRentRoomVo moreRentRoomVo = (MoreRentRoomVo) view.getTag();
        int status = moreRentRoomVo.getStatus();
        if (N()) {
            if (z) {
                K1(moreRentRoomVo);
                return;
            }
            if (status != 1) {
                if (status == 5) {
                    K1(moreRentRoomVo);
                    return;
                } else if (status != 6 && status != 7) {
                    return;
                }
            }
            M1(moreRentRoomVo);
        }
    }

    public final void O1() {
        this.B = R0();
        this.f6488f = new CoreBaseFragment.c(this);
        this.mSearchRoomEdt.addTextChangedListener(this.J);
        this.mSearchRoomEdt.setFocusable(true);
        this.mSearchRoomEdt.setFocusableInTouchMode(true);
        this.mSearchRoomEdt.requestFocus();
        this.mCancelTv.setOnClickListener(this.y);
    }

    public final boolean P1(String str) {
        if (!this.H.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            if (x.isNotNull(str)) {
                String upperCase = str.trim().toUpperCase(Locale.ROOT);
                for (MoreRentRoomVo moreRentRoomVo : this.H) {
                    if (moreRentRoomVo != null && x.isNotNull(moreRentRoomVo.getHouseName()) && moreRentRoomVo.getHouseName().trim().toUpperCase(Locale.ROOT).contains(upperCase)) {
                        arrayList.add(moreRentRoomVo);
                    }
                }
            } else {
                arrayList.addAll(this.H);
            }
            if (!arrayList.isEmpty()) {
                D(arrayList);
                return false;
            }
        }
        return true;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
        switch (view.getId()) {
            case R.id.tv_cat_room_source_details /* 2131232007 */:
                Z1(view);
                break;
            case R.id.tv_finish /* 2131232115 */:
                n();
                break;
            case R.id.tv_room_comment /* 2131232335 */:
                X1(view);
                break;
            case R.id.tv_room_pre /* 2131232353 */:
                N1(view, true);
                break;
            case R.id.tv_room_sing_or_pre /* 2131232366 */:
                N1(view, false);
                break;
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        O1();
        d2();
        e2();
        this.H = new ArrayList();
        this.mSearchRoomEdt.setRawInputType(2);
        E0(this.mSearchRoomEdt);
        List<MoreRentRoomVo> cacheMoreRentRoom = d.getInstance().getCacheMoreRentRoom(this.B);
        if (o.isNotEmpty(cacheMoreRentRoom) && x.isNullStr(this.D)) {
            this.G = true;
            c2(cacheMoreRentRoom);
        } else {
            z0(R.string.loading_text);
        }
        a2();
    }

    public final void W1(String str, boolean z) {
        AirQualityFragment airQualityFragment = AirQualityFragment.getInstance(str, z);
        if (x.isNotNull(this.D)) {
            airQualityFragment.setContractKey(this.D);
            airQualityFragment.setExtendOldRentFlag(this.F);
            airQualityFragment.setBackRentDate(this.E);
        }
        d(airQualityFragment, R.id.flayout_content);
    }

    public final void X1(View view) {
        K0(MoreCommentFragment.getInstance(((MoreRentRoomVo) view.getTag()).getAssetInstanceKey()), R.id.flayout_content);
    }

    public final void Y1(int i2) {
        String goodsKey = ((MoreRentRoomVo) this.t.getList().get(i2)).getGoodsKey();
        if (!x.isNotNull(goodsKey)) {
            F0(R.string.tip_request_param_is_empty);
            return;
        }
        Intent intent = new Intent(this.f6487e, (Class<?>) RoomSourceDetailsActivity.class);
        intent.putExtra("key", goodsKey);
        intent.putExtra("goodsKey", goodsKey);
        intent.setFlags(268435456);
        startActivity(intent);
    }

    public final void Z1(View view) {
        int iIntValue = ((Integer) view.getTag()).intValue();
        if (x.isNullStr(this.D)) {
            Y1(iIntValue);
        }
    }

    public final void a2() {
        this.C.getGroupItemDetailsRoomList(I1(null));
    }

    public final void b2() {
        if (P1(this.mSearchRoomEdt.getText().toString())) {
            CoreBaseFragment.c cVar = this.f6488f;
            cVar.sendMessageDelayed(cVar.obtainMessage(1), 300L);
        }
        q.d(getClass().getSimpleName(), "requestSearch");
    }

    public final void c2(List<MoreRentRoomVo> list) {
        if (this.H.isEmpty()) {
            this.H.addAll(list);
        }
        D(list);
    }

    public final void d2() {
        this.r = this.mSwipeRefreshLayout.getBaseRecyclerView();
        MoreRentRoomAdapter moreRentRoomAdapter = new MoreRentRoomAdapter();
        this.t = moreRentRoomAdapter;
        moreRentRoomAdapter.setEmptyIconResId(R.mipmap.ic_empty_room_list);
        this.t.setEmptyTipMsg(getString(R.string.tip_search_room_empty));
        this.t.setOnItemClickListener(this.I);
        this.t.setOnClickListener(this.y);
    }

    public final void e2() {
        NewRoomModel newRoomModel = (NewRoomModel) h(NewRoomModel.class);
        this.C = newRoomModel;
        newRoomModel.getGroupRoomListResult().observe(this, new Observer() { // from class: c.e.c.h0.f.z
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1523a.J1((NewResponseRowsVo) obj);
            }
        });
        this.C.getErrRequestLiveData().observe(this, new Observer() { // from class: c.e.c.h0.f.x
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1521a.f2((RequestErrDto) obj);
            }
        });
    }

    public final void f2(RequestErrDto requestErrDto) {
        if (requestErrDto != null) {
            int code = requestErrDto.getCode();
            boolean zOpenTipActivity = c.getInstance().openTipActivity(this.f6487e, code);
            q.d(this.f6485c, "stopRefreshOrHandleErr errCode = " + code);
            if (zOpenTipActivity) {
                n();
            }
        }
        this.mTipSearchTv.setVisibility(8);
        this.mSwipeRefreshLayout.setRefreshing(false);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_search_room;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void j0() {
        String string = this.mSearchRoomEdt.getText().toString();
        q.d(getClass().getSimpleName(), "key search value :" + string);
        this.mResetImgBtn.setVisibility(x.isNotNull(string) ? 0 : 8);
        this.C.getGroupItemDetailsRoomList(I1(string));
        if (this.f6483a == 1 && this.mTipSearchTv.getVisibility() == 8) {
            this.mTipSearchTv.setVisibility(0);
        } else {
            if (this.mTipSearchTv.getText().toString().equals(x.getString(R.string.title_searching))) {
                return;
            }
            this.mTipSearchTv.setText(R.string.title_searching);
        }
    }

    @OnClick({R.id.btn_reset})
    public void resetClick(View view) {
        this.f6483a = 1;
        this.mSearchRoomEdt.setText("");
        this.mTipSearchTv.setVisibility(8);
        this.mResetImgBtn.setVisibility(8);
        a2();
    }

    public void setBackRentDate(Long l) {
        this.E = l;
    }

    public void setContractKey(String str) {
        this.D = str;
    }

    public void setExtendOldRentFlag(Boolean bool) {
        this.F = bool;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void z(Message message) {
        super.z(message);
        if (message.what == 1) {
            this.f6483a = 1;
            j0();
        }
    }
}
