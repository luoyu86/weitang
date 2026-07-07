package com.chinavisionary.microtang.map;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import b.c.b;
import b.c.d;
import butterknife.Unbinder;
import com.chinavisionary.microtang.R;

/* JADX INFO: loaded from: classes.dex */
public class MapFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public MapFragment f7507b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f7508c;

    public class a extends b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ MapFragment f7509c;

        public a(MapFragment mapFragment) {
            this.f7509c = mapFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7509c.backClick();
        }
    }

    @UiThread
    public MapFragment_ViewBinding(MapFragment mapFragment, View view) {
        this.f7507b = mapFragment;
        mapFragment.mNavigationImg = (ImageView) d.findRequiredViewAsType(view, R.id.img_navigation, "field 'mNavigationImg'", ImageView.class);
        mapFragment.mAddressTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_address, "field 'mAddressTv'", TextView.class);
        mapFragment.mTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title, "field 'mTitleTv'", TextView.class);
        mapFragment.mBgView = d.findRequiredView(view, R.id.view_bg, "field 'mBgView'");
        View viewFindRequiredView = d.findRequiredView(view, R.id.tv_back, "method 'backClick'");
        this.f7508c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(mapFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        MapFragment mapFragment = this.f7507b;
        if (mapFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f7507b = null;
        mapFragment.mNavigationImg = null;
        mapFragment.mAddressTv = null;
        mapFragment.mTitleTv = null;
        mapFragment.mBgView = null;
        this.f7508c.setOnClickListener(null);
        this.f7508c = null;
    }
}
