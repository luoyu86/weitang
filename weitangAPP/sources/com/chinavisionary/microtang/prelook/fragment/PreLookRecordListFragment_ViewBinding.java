package com.chinavisionary.microtang.prelook.fragment;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import b.c.d;
import butterknife.Unbinder;
import com.chinavisionary.core.weight.BaseRecyclerView;
import com.chinavisionary.microtang.R;

/* JADX INFO: loaded from: classes2.dex */
public class PreLookRecordListFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public PreLookRecordListFragment f8201b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f8202c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f8203d;

    public class a extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ PreLookRecordListFragment f8204c;

        public a(PreLookRecordListFragment preLookRecordListFragment) {
            this.f8204c = preLookRecordListFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f8204c.backClick(view);
        }
    }

    public class b extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ PreLookRecordListFragment f8206c;

        public b(PreLookRecordListFragment preLookRecordListFragment) {
            this.f8206c = preLookRecordListFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f8206c.catRentChangeInfo(view);
        }
    }

    @UiThread
    public PreLookRecordListFragment_ViewBinding(PreLookRecordListFragment preLookRecordListFragment, View view) {
        this.f8201b = preLookRecordListFragment;
        preLookRecordListFragment.mTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title, "field 'mTitleTv'", TextView.class);
        preLookRecordListFragment.mPreLookRecycler = (BaseRecyclerView) d.findRequiredViewAsType(view, R.id.recycler_pre_look_record, "field 'mPreLookRecycler'", BaseRecyclerView.class);
        View viewFindRequiredView = d.findRequiredView(view, R.id.tv_back, "method 'backClick'");
        this.f8202c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(preLookRecordListFragment));
        View viewFindRequiredView2 = d.findRequiredView(view, R.id.tv_rent_change_info, "method 'catRentChangeInfo'");
        this.f8203d = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(preLookRecordListFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        PreLookRecordListFragment preLookRecordListFragment = this.f8201b;
        if (preLookRecordListFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f8201b = null;
        preLookRecordListFragment.mTitleTv = null;
        preLookRecordListFragment.mPreLookRecycler = null;
        this.f8202c.setOnClickListener(null);
        this.f8202c = null;
        this.f8203d.setOnClickListener(null);
        this.f8203d = null;
    }
}
