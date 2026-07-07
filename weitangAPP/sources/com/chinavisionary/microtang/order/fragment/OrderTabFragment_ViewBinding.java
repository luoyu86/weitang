package com.chinavisionary.microtang.order.fragment;

import android.view.View;
import android.widget.EditText;
import androidx.annotation.UiThread;
import b.c.d;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseTabFragment_ViewBinding;

/* JADX INFO: loaded from: classes.dex */
public class OrderTabFragment_ViewBinding extends BaseTabFragment_ViewBinding {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public OrderTabFragment f8102d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f8103e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f8104f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f8105g;

    public class a extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ OrderTabFragment f8106c;

        public a(OrderTabFragment orderTabFragment) {
            this.f8106c = orderTabFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f8106c.openScan();
        }
    }

    public class b extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ OrderTabFragment f8108c;

        public b(OrderTabFragment orderTabFragment) {
            this.f8108c = orderTabFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f8108c.msgClickView();
        }
    }

    public class c extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ OrderTabFragment f8110c;

        public c(OrderTabFragment orderTabFragment) {
            this.f8110c = orderTabFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f8110c.serverClick();
        }
    }

    @UiThread
    public OrderTabFragment_ViewBinding(OrderTabFragment orderTabFragment, View view) {
        super(orderTabFragment, view);
        this.f8102d = orderTabFragment;
        orderTabFragment.mSplitLineTv = d.findRequiredView(view, R.id.tv_title_split_line, "field 'mSplitLineTv'");
        orderTabFragment.mSearchOrderEdt = (EditText) d.findRequiredViewAsType(view, R.id.edt_search_room, "field 'mSearchOrderEdt'", EditText.class);
        View viewFindRequiredView = d.findRequiredView(view, R.id.rlayout_scan, "method 'openScan'");
        this.f8103e = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(orderTabFragment));
        View viewFindRequiredView2 = d.findRequiredView(view, R.id.rlayout_notify, "method 'msgClickView'");
        this.f8104f = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(orderTabFragment));
        View viewFindRequiredView3 = d.findRequiredView(view, R.id.rlayout_server, "method 'serverClick'");
        this.f8105g = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(orderTabFragment));
    }

    @Override // com.chinavisionary.microtang.base.BaseTabFragment_ViewBinding, butterknife.Unbinder
    public void unbind() {
        OrderTabFragment orderTabFragment = this.f8102d;
        if (orderTabFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f8102d = null;
        orderTabFragment.mSplitLineTv = null;
        orderTabFragment.mSearchOrderEdt = null;
        this.f8103e.setOnClickListener(null);
        this.f8103e = null;
        this.f8104f.setOnClickListener(null);
        this.f8104f = null;
        this.f8105g.setOnClickListener(null);
        this.f8105g = null;
        super.unbind();
    }
}
