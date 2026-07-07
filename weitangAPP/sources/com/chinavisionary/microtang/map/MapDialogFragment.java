package com.chinavisionary.microtang.map;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import c.e.a.a.b;
import c.e.a.a.c.c.a;
import c.e.a.d.x;
import c.e.b.c.d.h;
import com.chinavisionary.core.weight.BaseRecyclerView;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseFragment;
import com.chinavisionary.microtang.map.adapter.MapAdapter;
import com.chinavisionary.microtang.map.vo.MapItemVo;

/* JADX INFO: loaded from: classes.dex */
public class MapDialogFragment extends BaseFragment<MapItemVo> {
    public h B;
    public final a C = new a() { // from class: c.e.c.w.a
        @Override // c.e.a.a.c.c.a
        public final void onItemClickListener(View view, int i2) {
            this.f2008a.G1(view, i2);
        }
    };

    @BindView(R.id.recycler_map)
    public BaseRecyclerView mRecyclerView;

    @BindView(R.id.tv_title)
    public TextView mTitleTv;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: F1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void G1(View view, int i2) {
        E1(i2);
    }

    public static MapDialogFragment getInstance(h hVar) {
        MapDialogFragment mapDialogFragment = new MapDialogFragment();
        mapDialogFragment.B = hVar;
        return mapDialogFragment;
    }

    public final void E1(int i2) {
        int type = ((MapItemVo) this.t.getList().get(i2)).getType();
        if (type == 1) {
            I1(this.B);
        } else if (type == 2) {
            H1(this.B);
        }
        n();
    }

    public final void H1(h hVar) {
        try {
            Intent intent = new Intent();
            intent.setData(Uri.parse("baidumap://map/marker?location=" + hVar.getLatitude() + "," + hVar.getLongitude() + "&title=" + x.getNotNullStr(hVar.getLocationName(), getString(R.string.title_me_location)) + "&zoom=9&coord_type=gcj02&traffic=on&src=com.chinavisionary.microtang"));
            startActivity(intent);
        } catch (Exception e2) {
            e2.printStackTrace();
            G0("打开失败，请先安装百度地图App");
        }
    }

    public final void I1(h hVar) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.addCategory("android.intent.category.DEFAULT");
            intent.setPackage("com.autonavi.minimap");
            intent.setData(Uri.parse("androidamap://viewMap?sourceApplication=" + b.getInstance().getAppName() + "&poiname=" + x.getNotNullStr(hVar.getLocationName(), getString(R.string.title_me_location)) + "&lat=" + hVar.getLatitude() + "&lon=" + hVar.getLongitude() + "&dev=0"));
            startActivity(intent);
        } catch (Exception e2) {
            e2.printStackTrace();
            G0("打开失败，请先安装高德地图App");
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        c.e.c.w.b.a aVar = new c.e.c.w.b.a();
        this.r = this.mRecyclerView;
        MapAdapter mapAdapter = new MapAdapter();
        this.t = mapAdapter;
        mapAdapter.setOnItemClickListener(this.C);
        D(aVar.getMapList(this.f6486d));
    }

    @OnClick({R.id.view_bg})
    public void backClick(View view) {
        n();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_map_dialog;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void j0() {
    }
}
