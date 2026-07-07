package com.chinavisionary.microtang.room.fragment;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import b.c.d;
import butterknife.Unbinder;
import com.chinavisionary.core.weight.BaseRecyclerView;
import com.chinavisionary.microtang.R;

/* JADX INFO: loaded from: classes2.dex */
public class ReceiverSaleFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ReceiverSaleFragment f8339b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f8340c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f8341d;

    public class a extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ReceiverSaleFragment f8342c;

        public a(ReceiverSaleFragment receiverSaleFragment) {
            this.f8342c = receiverSaleFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f8342c.closeFragment(view);
        }
    }

    public class b extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ReceiverSaleFragment f8344c;

        public b(ReceiverSaleFragment receiverSaleFragment) {
            this.f8344c = receiverSaleFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f8344c.closeFragment(view);
        }
    }

    @UiThread
    public ReceiverSaleFragment_ViewBinding(ReceiverSaleFragment receiverSaleFragment, View view) {
        this.f8339b = receiverSaleFragment;
        receiverSaleFragment.mBgView = d.findRequiredView(view, R.id.view_bg, "field 'mBgView'");
        receiverSaleFragment.mReceiveSaleRecyclerView = (BaseRecyclerView) d.findRequiredViewAsType(view, R.id.recycler_receive_sale, "field 'mReceiveSaleRecyclerView'", BaseRecyclerView.class);
        View viewFindRequiredView = d.findRequiredView(view, R.id.img_close, "method 'closeFragment'");
        this.f8340c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(receiverSaleFragment));
        View viewFindRequiredView2 = d.findRequiredView(view, R.id.view_transparent_bg, "method 'closeFragment'");
        this.f8341d = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(receiverSaleFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        ReceiverSaleFragment receiverSaleFragment = this.f8339b;
        if (receiverSaleFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f8339b = null;
        receiverSaleFragment.mBgView = null;
        receiverSaleFragment.mReceiveSaleRecyclerView = null;
        this.f8340c.setOnClickListener(null);
        this.f8340c = null;
        this.f8341d.setOnClickListener(null);
        this.f8341d = null;
    }
}
