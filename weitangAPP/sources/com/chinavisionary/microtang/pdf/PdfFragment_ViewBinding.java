package com.chinavisionary.microtang.pdf;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import b.c.b;
import b.c.d;
import butterknife.Unbinder;
import com.chinavisionary.core.weight.BaseSwipeRefreshLayout;
import com.chinavisionary.microtang.R;

/* JADX INFO: loaded from: classes.dex */
public class PdfFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public PdfFragment f8134b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f8135c;

    public class a extends b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ PdfFragment f8136c;

        public a(PdfFragment pdfFragment) {
            this.f8136c = pdfFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f8136c.backClick();
        }
    }

    @UiThread
    public PdfFragment_ViewBinding(PdfFragment pdfFragment, View view) {
        this.f8134b = pdfFragment;
        pdfFragment.mTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title, "field 'mTitleTv'", TextView.class);
        pdfFragment.mTitleRightTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title_right, "field 'mTitleRightTv'", TextView.class);
        pdfFragment.mPageCountTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_page_count_value, "field 'mPageCountTv'", TextView.class);
        pdfFragment.remotePdfRoot = (FrameLayout) d.findRequiredViewAsType(view, R.id.frame_layout, "field 'remotePdfRoot'", FrameLayout.class);
        pdfFragment.mPdfLayout = (BaseSwipeRefreshLayout) d.findRequiredViewAsType(view, R.id.banner_view, "field 'mPdfLayout'", BaseSwipeRefreshLayout.class);
        pdfFragment.mRightImg = (ImageView) d.findRequiredViewAsType(view, R.id.img_right_icon, "field 'mRightImg'", ImageView.class);
        pdfFragment.mLeftImg = (ImageView) d.findRequiredViewAsType(view, R.id.img_left_icon, "field 'mLeftImg'", ImageView.class);
        View viewFindRequiredView = d.findRequiredView(view, R.id.tv_back, "method 'backClick'");
        this.f8135c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(pdfFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        PdfFragment pdfFragment = this.f8134b;
        if (pdfFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f8134b = null;
        pdfFragment.mTitleTv = null;
        pdfFragment.mTitleRightTv = null;
        pdfFragment.mPageCountTv = null;
        pdfFragment.remotePdfRoot = null;
        pdfFragment.mPdfLayout = null;
        pdfFragment.mRightImg = null;
        pdfFragment.mLeftImg = null;
        this.f8135c.setOnClickListener(null);
        this.f8135c = null;
    }
}
