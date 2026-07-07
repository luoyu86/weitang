package com.chinavisionary.microtang.room.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.GridLayoutManager;
import butterknife.BindView;
import butterknife.OnClick;
import c.e.a.a.i.b;
import c.e.a.d.j;
import c.e.a.d.o;
import c.e.a.d.x;
import c.e.b.c.d.h;
import c.e.c.h0.g.c;
import com.chinavisionary.core.app.net.base.dto.RequestErrDto;
import com.chinavisionary.core.weight.BaseSwipeRefreshLayout;
import com.chinavisionary.framework.mobile.common.vo.ResourceVo;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.auth.IDAuthActivity;
import com.chinavisionary.microtang.base.BaseFragment;
import com.chinavisionary.microtang.main.event.EventUpdateAliYunOss;
import com.chinavisionary.microtang.map.MapDialogFragment;
import com.chinavisionary.microtang.room.adapter.RoomSourceDeviceListAdapter;
import com.chinavisionary.microtang.room.model.RoomOperationModel;
import com.chinavisionary.microtang.room.vo.ActivityListBean;
import com.chinavisionary.microtang.room.vo.RoomDeviceListItemVo;
import com.chinavisionary.microtang.room.vo.RoomSourceDetailsVo;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class RoomSourceDetailsFragment extends BaseFragment<RoomDeviceListItemVo> {
    public String B;
    public String C;
    public String D;
    public String E;
    public c F;
    public RoomOperationModel G;

    @BindView(R.id.view_bottom_line)
    public View mBottomLineView;

    @BindView(R.id.tv_pre_look)
    public TextView mPreLookTv;

    @BindView(R.id.tv_pre_room)
    public TextView mPreRoomTv;

    @BindView(R.id.tv_sign_room)
    public TextView mSignRoomTv;

    @BindView(R.id.swipe_refresh_layout)
    public BaseSwipeRefreshLayout mSwipeRefreshLayout;

    @BindView(R.id.tv_title)
    public TextView mTitleTv;

    public class a extends GridLayoutManager.SpanSizeLookup {
        public a() {
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanSize(int i2) {
            if (o.isNotEmpty(RoomSourceDetailsFragment.this.t.getList()) && i2 != 0 && ((RoomDeviceListItemVo) RoomSourceDetailsFragment.this.t.getList().get(i2 - 1)).getItemType() == 34952) {
                return 6;
            }
            return ((o.isNotEmpty(RoomSourceDetailsFragment.this.t.getList()) && i2 != 0 && ((RoomDeviceListItemVo) RoomSourceDetailsFragment.this.t.getList().get(i2 + (-1))).getItemType() == 39) || i2 == 0) ? 6 : 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: R1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void S1(View view) {
        J1();
    }

    public static RoomSourceDetailsFragment getInstance(String str, String str2) {
        RoomSourceDetailsFragment roomSourceDetailsFragment = new RoomSourceDetailsFragment();
        roomSourceDetailsFragment.f6484b = str;
        roomSourceDetailsFragment.B = str2;
        return roomSourceDetailsFragment;
    }

    private void o0() {
        this.l = false;
        BaseSwipeRefreshLayout baseSwipeRefreshLayout = this.mSwipeRefreshLayout;
        this.s = baseSwipeRefreshLayout;
        this.r = baseSwipeRefreshLayout.getBaseRecyclerView();
        this.t = new RoomSourceDeviceListAdapter(getFragmentManager());
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this.f6486d, 6);
        gridLayoutManager.setSpanSizeLookup(new a());
        this.r.setLayoutManager(gridLayoutManager);
        I1();
    }

    public final void I1() {
        View viewInflate = LayoutInflater.from(this.f6486d).inflate(R.layout.item_room_source_details_head_layout, (ViewGroup) this.r, false);
        this.F.initHeadView(viewInflate, this.y);
        this.t.addHeadView(viewInflate);
    }

    public final void J1() {
        if (!x.isNotNull(this.B)) {
            V1(this.f6484b, false);
        } else {
            n();
            r1(this.B);
        }
    }

    public final void K1() {
        if (M()) {
            V1(this.f6484b, true);
        } else {
            X1(R.string.tip_pre_auth);
        }
    }

    public final void L1(RoomSourceDetailsVo roomSourceDetailsVo) {
        this.mSwipeRefreshLayout.setRefreshing(false);
        this.F.setupHeadData(roomSourceDetailsVo);
        if (roomSourceDetailsVo != null) {
            this.C = roomSourceDetailsVo.getCommunityUrl();
            this.mSignRoomTv.setVisibility(roomSourceDetailsVo.isSignFlag() ? 0 : 8);
            if (x.isNotNull(this.B)) {
                this.mPreRoomTv.setVisibility(8);
            } else {
                this.mPreRoomTv.setVisibility(roomSourceDetailsVo.isReserveFlag() ? 0 : 8);
            }
            ((RoomSourceDeviceListAdapter) this.t).setUrl(this.C);
            RoomDeviceListItemVo roomDeviceListItemVo = new RoomDeviceListItemVo();
            roomDeviceListItemVo.setItemType(39);
            List<RoomDeviceListItemVo> deviceList = roomSourceDetailsVo.getDeviceList();
            if (o.listIsEmpty(deviceList)) {
                deviceList = new ArrayList<>();
            }
            deviceList.add(roomDeviceListItemVo);
            if (o.isNotEmpty(deviceList)) {
                D(deviceList);
            } else {
                H();
            }
            T1(roomSourceDetailsVo);
        }
        O1();
    }

    public final void M1() {
        if (!M()) {
            X1(R.string.tip_auth_sign);
        } else if (c.e.c.m0.c.getInstance().isShowEnterpriseMsg()) {
            C1(x.getString(R.string.tip_enterprise_not_sale), x.getString(R.string.big_tip_msg), Boolean.TRUE, new View.OnClickListener() { // from class: c.e.c.h0.f.v
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f1518a.S1(view);
                }
            });
        } else {
            J1();
        }
    }

    public final void N1(View view, boolean z) {
        if (N()) {
            if (z) {
                K1();
            } else {
                M1();
            }
        }
    }

    public final void O1() {
        this.mBottomLineView.setVisibility(this.mPreLookTv.getVisibility() == 0 || this.mPreRoomTv.getVisibility() == 0 || this.mSignRoomTv.getVisibility() == 0 ? 0 : 8);
    }

    public final void T1(RoomSourceDetailsVo roomSourceDetailsVo) {
        boolean z;
        String groupName = roomSourceDetailsVo.getGroupName();
        String buildingName = roomSourceDetailsVo.getBuildingName();
        if (x.isNotNull(groupName) && x.isNotNull(buildingName)) {
            String roomSourceMapPathToGroupName = b.getRoomSourceMapPathToGroupName(groupName, buildingName);
            List<ResourceVo> resourceListToPath = b.getInstance().getResourceListToPath(b.getRoomSourceBigMapPathToGroupName(groupName, buildingName));
            boolean z2 = true;
            if (o.isNotEmpty(resourceListToPath)) {
                this.E = resourceListToPath.get(0).getUrl();
                z = false;
            } else {
                z = true;
            }
            List<ResourceVo> resourceListToPath2 = b.getInstance().getResourceListToPath(roomSourceMapPathToGroupName);
            if (o.isNotEmpty(resourceListToPath2)) {
                ResourceVo resourceVo = resourceListToPath2.get(0);
                this.D = resourceVo.getUrl();
                this.F.loadRoomLocationImg(resourceVo);
                z2 = z;
            }
            if (z2) {
                Z1();
            }
        }
    }

    public final void U1(View view) {
        ActivityListBean activityListBean = (ActivityListBean) view.getTag();
        c1(1, activityListBean.getActivityUrl(), activityListBean.getTitle());
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
        switch (view.getId()) {
            case R.id.img_room_location /* 2131231276 */:
                if (view.getTag() != null) {
                    Y1((h) view.getTag());
                }
                break;
            case R.id.tv_activity_content /* 2131231917 */:
                U1(view);
                break;
            case R.id.tv_cat_community_details /* 2131231999 */:
                W1(view);
                break;
            case R.id.tv_pre_room /* 2131232264 */:
                N1(view, true);
                break;
            case R.id.tv_sign_room /* 2131232418 */:
                N1(view, false);
                break;
        }
    }

    public final void V1(String str, boolean z) {
        d(AirQualityFragment.getInstance(str, z), R.id.flayout_content);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        this.mTitleTv.setText(R.string.title_room_source_details);
        this.F = new c();
        o0();
        a2();
        b2();
        z0(R.string.loading_text);
        j0();
    }

    public final void W1(View view) {
        String string;
        if (x.isNotNull(this.C)) {
            if ("18688948873".equals(s())) {
                string = x.getString(R.string.title_community_details);
                this.C = "https://chinavisionary-vtown-uat2.oss-cn-beijing.aliyuncs.com/android/details/%E5%BE%AE%E6%A3%A0%E7%A4%BE%E5%8C%BA.jpg";
            } else {
                string = "";
            }
            c1(1, this.C, string);
        }
    }

    public final void X1(int i2) {
        d0(IDAuthActivity.class);
        F0(i2);
    }

    public final void Y1(h hVar) {
        h hVar2 = new h();
        hVar2.setLongitude(hVar.getLongitude());
        hVar2.setLatitude(hVar.getLatitude());
        hVar2.setLocationName(this.F.getRoomLocation());
        d(MapDialogFragment.getInstance(hVar2), R.id.flayout_content);
    }

    public final void Z1() {
        EventUpdateAliYunOss eventUpdateAliYunOss = new EventUpdateAliYunOss();
        eventUpdateAliYunOss.setMethodName(getClass().getSimpleName() + "-sendRefreshAliYunOss");
        k(eventUpdateAliYunOss);
    }

    public final void a2() {
        this.mPreLookTv.setVisibility(Q() ? 8 : 0);
        this.mPreRoomTv.setOnClickListener(this.y);
        this.mSignRoomTv.setOnClickListener(this.y);
        O1();
    }

    public final void b2() {
        RoomOperationModel roomOperationModel = (RoomOperationModel) h(RoomOperationModel.class);
        this.G = roomOperationModel;
        roomOperationModel.updateBaseUrl(j.getInstance().getH5ApiBaseUrl());
        this.G.getRoomDetails().observe(this, new Observer() { // from class: c.e.c.h0.f.u
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1517a.L1((RoomSourceDetailsVo) obj);
            }
        });
        this.G.getErrRequestLiveData().observe(this, new Observer() { // from class: c.e.c.h0.f.t
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1516a.C((RequestErrDto) obj);
            }
        });
    }

    @OnClick({R.id.tv_back})
    public void backClick(View view) {
        n();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_room_source_details;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void j0() {
        this.G.getRoomSourceDetails(this.f6484b);
    }

    @OnClick({R.id.tv_pre_look})
    public void preLookRoom(View view) {
        if (N()) {
            d(PreLookRoomFragment.getInstance(this.f6484b), R.id.flayout_content);
        }
    }
}
