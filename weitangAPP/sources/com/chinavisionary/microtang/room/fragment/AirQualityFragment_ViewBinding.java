package com.chinavisionary.microtang.room.fragment;

import android.view.View;
import android.widget.Button;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import b.c.d;
import butterknife.Unbinder;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.sign.view.BaseWebView;

/* JADX INFO: loaded from: classes2.dex */
public class AirQualityFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AirQualityFragment f8308b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f8309c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f8310d;

    public class a extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ AirQualityFragment f8311c;

        public a(AirQualityFragment airQualityFragment) {
            this.f8311c = airQualityFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f8311c.confirmClick(view);
        }
    }

    public class b extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ AirQualityFragment f8313c;

        public b(AirQualityFragment airQualityFragment) {
            this.f8313c = airQualityFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f8313c.cancelClick(view);
        }
    }

    @UiThread
    public AirQualityFragment_ViewBinding(AirQualityFragment airQualityFragment, View view) {
        this.f8308b = airQualityFragment;
        airQualityFragment.mContentWebView = (BaseWebView) d.findRequiredViewAsType(view, R.id.web_view_content, "field 'mContentWebView'", BaseWebView.class);
        View viewFindRequiredView = d.findRequiredView(view, R.id.btn_confirm, "field 'mConfirmBtn' and method 'confirmClick'");
        airQualityFragment.mConfirmBtn = (Button) d.castView(viewFindRequiredView, R.id.btn_confirm, "field 'mConfirmBtn'", Button.class);
        this.f8309c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(airQualityFragment));
        airQualityFragment.mLayoutAirView = d.findRequiredView(view, R.id.constraint_layout_alert_air, "field 'mLayoutAirView'");
        View viewFindRequiredView2 = d.findRequiredView(view, R.id.btn_think, "method 'cancelClick'");
        this.f8310d = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(airQualityFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        AirQualityFragment airQualityFragment = this.f8308b;
        if (airQualityFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f8308b = null;
        airQualityFragment.mContentWebView = null;
        airQualityFragment.mConfirmBtn = null;
        airQualityFragment.mLayoutAirView = null;
        this.f8309c.setOnClickListener(null);
        this.f8309c = null;
        this.f8310d.setOnClickListener(null);
        this.f8310d = null;
    }
}
