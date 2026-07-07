package com.chinavisionary.microtang.merchant.fragment;

import android.view.View;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.GridLayoutManager;
import butterknife.BindView;
import butterknife.OnClick;
import c.e.a.d.o;
import c.e.a.d.q;
import c.e.a.d.x;
import com.chinavisionary.core.app.base.CoreBaseFragment;
import com.chinavisionary.core.app.net.base.dto.RequestErrDto;
import com.chinavisionary.core.app.net.base.dto.ResponseRowsVo;
import com.chinavisionary.core.scan.view.ScanCodeActivity;
import com.chinavisionary.core.weight.BaseSwipeRefreshLayout;
import com.chinavisionary.core.weight.banner.EditBannerView;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseFragment;
import com.chinavisionary.microtang.main.vo.MerchantInfoVo;
import com.chinavisionary.microtang.main.vo.RoomModelVo;
import com.chinavisionary.microtang.merchant.MerchantMainActivity;
import com.chinavisionary.microtang.merchant.adapter.MerchantListAdapter;
import com.chinavisionary.microtang.merchant.model.MerchantModel;
import com.chinavisionary.microtang.msg.MsgActivity;
import com.chinavisionary.microtang.room.SearchRoomActivity;
import com.chinavisionary.microtang.room.adapter.GridSpecItemDecoration;
import com.chinavisionary.microtang.service.CustomerServiceActivity;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class MerchantListFragment extends BaseFragment<RoomModelVo.ModulesBean> {
    public boolean C;
    public MerchantModel D;

    @BindView(R.id.swipe_refresh_layout_main)
    public BaseSwipeRefreshLayout mBaseSwipeRefreshLayout;
    public boolean B = true;
    public c.e.a.a.c.c.a E = new a();

    public class a implements c.e.a.a.c.c.a {
        public a() {
        }

        @Override // c.e.a.a.c.c.a
        public void onItemClickListener(View view, int i2) {
            q.d(MerchantListFragment.class.getCanonicalName(), "start time:" + System.currentTimeMillis());
            MerchantListFragment.this.c0(MerchantMainActivity.class, ((RoomModelVo.ModulesBean) MerchantListFragment.this.t.getList().get(i2)).getMerchantInfoVo().getMerchantKey());
        }
    }

    public class b implements CoreBaseFragment.d {
        public b() {
        }

        @Override // com.chinavisionary.core.app.base.CoreBaseFragment.d
        public void updatePosition(int i2, int i3) {
            MerchantListFragment.this.t.setFirstLastPosition(i2, i3);
        }
    }

    public class c extends GridLayoutManager.SpanSizeLookup {
        public c() {
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanSize(int i2) {
            if (MerchantListFragment.this.r.getAdapter() == null || !((i2 == MerchantListFragment.this.r.getAdapter().getItemCount() - 1 && MerchantListFragment.this.t.isShowFooterView()) || MerchantListFragment.this.t.getItemViewType(i2) == 34952)) {
                return (MerchantListFragment.this.C && i2 == 0) ? 2 : 1;
            }
            return 2;
        }
    }

    public static MerchantListFragment getInstance() {
        return new MerchantListFragment();
    }

    private void o0() {
        MerchantListAdapter merchantListAdapter = new MerchantListAdapter();
        this.t = merchantListAdapter;
        merchantListAdapter.setDefaultLastPosition(6);
        this.t.setOnClickListener(this.y);
        this.t.setOnItemClickListener(this.E);
        this.v = new b();
    }

    public final void M1(int i2) {
        if (this.r.getItemDecorationCount() > 0) {
            this.r.removeItemDecorationAt(0);
        }
        GridSpecItemDecoration gridSpecItemDecoration = new GridSpecItemDecoration(2, getResources().getDimensionPixelOffset(R.dimen.dp_12));
        gridSpecItemDecoration.setSkipPosition(i2);
        this.r.addItemDecoration(gridSpecItemDecoration);
    }

    public final RoomModelVo.ModulesBean N1() {
        if (o() != null) {
            List<EditBannerView.BannerDto> bannerDto = o().getBannerDto();
            if (o.isNotEmpty(bannerDto)) {
                this.C = true;
                RoomModelVo.ModulesBean modulesBean = new RoomModelVo.ModulesBean();
                modulesBean.setModuleType(1);
                modulesBean.setBannerDtoList(bannerDto);
                return modulesBean;
            }
        }
        return null;
    }

    public final void O1(ResponseRowsVo<MerchantInfoVo> responseRowsVo) {
        H();
        this.mBaseSwipeRefreshLayout.setRefreshing(false);
        if (responseRowsVo != null) {
            ArrayList arrayList = new ArrayList();
            List<MerchantInfoVo> rows = responseRowsVo.getRows();
            if (o.isNotEmpty(rows)) {
                for (MerchantInfoVo merchantInfoVo : rows) {
                    if (merchantInfoVo != null) {
                        RoomModelVo.ModulesBean modulesBean = new RoomModelVo.ModulesBean();
                        modulesBean.setModuleType(6);
                        modulesBean.setMerchantInfoVo(merchantInfoVo);
                        arrayList.add(modulesBean);
                    }
                }
            }
            if (this.f6483a == 1) {
                RoomModelVo.ModulesBean modulesBeanN1 = N1();
                if (modulesBeanN1 != null) {
                    M1(0);
                    arrayList.add(0, modulesBeanN1);
                } else {
                    M1(-1);
                }
            }
            D(arrayList);
        }
    }

    public final void P1(View view) {
        int iIntValue = ((Integer) view.getTag()).intValue();
        int iIntValue2 = ((Integer) view.getTag(view.getId())).intValue();
        i("position:" + iIntValue + ", index:" + iIntValue2 + ",title:" + ((RoomModelVo.ModulesBean) this.t.getList().get(iIntValue)).getSubModules().get(iIntValue2).getModelProductVo().getParam().getCommodityTitle());
    }

    public final void Q1(RequestErrDto requestErrDto) {
        C(requestErrDto);
        this.mBaseSwipeRefreshLayout.setRefreshing(false);
    }

    public final void R1(View view) {
        EditBannerView.BannerDto bannerDto = (EditBannerView.BannerDto) view.getTag(R.id.edt_banner_view_img_path_id);
        if (x.isNotNull(bannerDto.getDataKey())) {
            String title = bannerDto.getTitle();
            super.c1(Integer.valueOf(bannerDto.getDataType()), bannerDto.getDataKey(), title);
            super.V0(title);
        }
    }

    public final void U1() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this.f6487e, 2);
        this.r.setLayoutManager(gridLayoutManager);
        gridLayoutManager.setSpanSizeLookup(new c());
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
        int id = view.getId();
        if (id == R.id.edt_input_search) {
            d0(SearchRoomActivity.class);
        } else if (id == R.id.img_banner_pic) {
            R1(view);
        } else if (id == R.id.llayout_item_room) {
            P1(view);
        }
    }

    public final void V1() {
        MerchantModel merchantModel = (MerchantModel) h(MerchantModel.class);
        this.D = merchantModel;
        merchantModel.getMerchantListResult().observe(this, new Observer() { // from class: c.e.c.y.b.m
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f2237a.O1((ResponseRowsVo) obj);
            }
        });
        this.D.getErrRequestLiveData().observe(this, new Observer() { // from class: c.e.c.y.b.l
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f2236a.Q1((RequestErrDto) obj);
            }
        });
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        W1();
        V1();
    }

    public final void W1() {
        this.r = this.mBaseSwipeRefreshLayout.getBaseRecyclerView();
        o0();
        M1(-1);
        U1();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_merchant_list;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void j0() {
        this.D.getMerchantList(r());
    }

    @OnClick({R.id.rlayout_notify})
    public void msgClickView() {
        if (N()) {
            d0(MsgActivity.class);
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.B) {
            this.B = false;
            j0();
        }
        q.d(getClass().getSimpleName(), "on resume");
    }

    @OnClick({R.id.rlayout_scan})
    public void openScan() {
        d0(ScanCodeActivity.class);
    }

    @OnClick({R.id.rlayout_server})
    public void serverClick() {
        if (c.e.a.a.a.getInstance().isIMModel()) {
            d0(CustomerServiceActivity.class);
        } else if (N()) {
            d0(CustomerServiceActivity.class);
        }
    }
}
