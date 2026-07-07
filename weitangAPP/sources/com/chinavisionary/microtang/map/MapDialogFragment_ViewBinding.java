package com.chinavisionary.microtang.map;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import b.c.b;
import b.c.d;
import butterknife.Unbinder;
import com.chinavisionary.core.weight.BaseRecyclerView;
import com.chinavisionary.microtang.R;

/* JADX INFO: loaded from: classes.dex */
public class MapDialogFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public MapDialogFragment f7503b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f7504c;

    public class a extends b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ MapDialogFragment f7505c;

        public a(MapDialogFragment mapDialogFragment) {
            this.f7505c = mapDialogFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7505c.backClick(view);
        }
    }

    @UiThread
    public MapDialogFragment_ViewBinding(MapDialogFragment mapDialogFragment, View view) {
        this.f7503b = mapDialogFragment;
        mapDialogFragment.mRecyclerView = (BaseRecyclerView) d.findRequiredViewAsType(view, R.id.recycler_map, "field 'mRecyclerView'", BaseRecyclerView.class);
        mapDialogFragment.mTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title, "field 'mTitleTv'", TextView.class);
        View viewFindRequiredView = d.findRequiredView(view, R.id.view_bg, "method 'backClick'");
        this.f7504c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(mapDialogFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        MapDialogFragment mapDialogFragment = this.f7503b;
        if (mapDialogFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f7503b = null;
        mapDialogFragment.mRecyclerView = null;
        mapDialogFragment.mTitleTv = null;
        this.f7504c.setOnClickListener(null);
        this.f7504c = null;
    }
}
