package cn.admobiletop.adsuyi.ad.widget;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import cn.admobiletop.adsuyi.util.ADSuyiViewUtil;

/* JADX INFO: loaded from: classes.dex */
public class ADSuyiWebClickView extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f3566a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ADSuyiWebView f3567b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f3568c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f3569d;

    public ADSuyiWebClickView(Context context, int i2) {
        this(context, i2, true);
    }

    public final void a() {
        View view = new View(getContext());
        this.f3568c = view;
        view.setBackgroundColor(0);
        addView(this.f3568c, new ViewGroup.LayoutParams(-1, -1));
    }

    public void addTargetView() {
        if (this.f3569d) {
            return;
        }
        this.f3569d = true;
        ADSuyiViewUtil.addDefaultAdTargetView(this.f3566a, this);
    }

    public final void b() {
        ADSuyiWebView aDSuyiWebView = new ADSuyiWebView(getContext().getApplicationContext());
        this.f3567b = aDSuyiWebView;
        addView(aDSuyiWebView, new ViewGroup.LayoutParams(-1, -1));
    }

    public ADSuyiWebView getAdSuyiWebView() {
        return this.f3567b;
    }

    public View getClickView() {
        return this.f3568c;
    }

    public void loadHtml(String str) {
        ADSuyiWebView aDSuyiWebView = this.f3567b;
        if (aDSuyiWebView != null) {
            aDSuyiWebView.loadHtml(str);
        }
    }

    public void release() {
        ADSuyiWebView aDSuyiWebView = this.f3567b;
        if (aDSuyiWebView != null) {
            aDSuyiWebView.destroyWebView(true);
            this.f3567b = null;
        }
    }

    public ADSuyiWebClickView(Context context, int i2, boolean z) {
        super(context);
        this.f3566a = i2;
        b();
        a();
        if (z) {
            addTargetView();
        }
    }
}
