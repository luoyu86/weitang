package com.chinavisionary.microtang.service.fragment;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import b.c.d;
import butterknife.Unbinder;
import com.chinavisionary.core.weight.BaseRecyclerView;
import com.chinavisionary.core.weight.BaseSwipeRefreshLayout;
import com.chinavisionary.microtang.R;

/* JADX INFO: loaded from: classes2.dex */
public class CustomerServiceFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public CustomerServiceFragment f8433b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f8434c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f8435d;

    public class a extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ CustomerServiceFragment f8436c;

        public a(CustomerServiceFragment customerServiceFragment) {
            this.f8436c = customerServiceFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f8436c.backClick(view);
        }
    }

    public class b extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ CustomerServiceFragment f8438c;

        public b(CustomerServiceFragment customerServiceFragment) {
            this.f8438c = customerServiceFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f8438c.submit(view);
        }
    }

    @UiThread
    public CustomerServiceFragment_ViewBinding(CustomerServiceFragment customerServiceFragment, View view) {
        this.f8433b = customerServiceFragment;
        customerServiceFragment.mTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title, "field 'mTitleTv'", TextView.class);
        customerServiceFragment.mTitleRightTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title_right, "field 'mTitleRightTv'", TextView.class);
        customerServiceFragment.mSplitLineTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title_split_line, "field 'mSplitLineTv'", TextView.class);
        customerServiceFragment.mBaseSwipeRefreshLayout = (BaseSwipeRefreshLayout) d.findRequiredViewAsType(view, R.id.swipe_refresh_layout, "field 'mBaseSwipeRefreshLayout'", BaseSwipeRefreshLayout.class);
        customerServiceFragment.mQuestionCategoriesTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_question_value, "field 'mQuestionCategoriesTv'", TextView.class);
        customerServiceFragment.mQuestionTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_common_question_value, "field 'mQuestionTv'", TextView.class);
        customerServiceFragment.mPhoneTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_phone, "field 'mPhoneTv'", TextView.class);
        customerServiceFragment.mQuestionInfoEdt = (EditText) d.findRequiredViewAsType(view, R.id.edt_question_info, "field 'mQuestionInfoEdt'", EditText.class);
        customerServiceFragment.mNineGridView = (BaseRecyclerView) d.findRequiredViewAsType(view, R.id.nine_grid_view_commend, "field 'mNineGridView'", BaseRecyclerView.class);
        View viewFindRequiredView = d.findRequiredView(view, R.id.tv_back, "method 'backClick'");
        this.f8434c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(customerServiceFragment));
        View viewFindRequiredView2 = d.findRequiredView(view, R.id.btn_submit, "method 'submit'");
        this.f8435d = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(customerServiceFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        CustomerServiceFragment customerServiceFragment = this.f8433b;
        if (customerServiceFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f8433b = null;
        customerServiceFragment.mTitleTv = null;
        customerServiceFragment.mTitleRightTv = null;
        customerServiceFragment.mSplitLineTv = null;
        customerServiceFragment.mBaseSwipeRefreshLayout = null;
        customerServiceFragment.mQuestionCategoriesTv = null;
        customerServiceFragment.mQuestionTv = null;
        customerServiceFragment.mPhoneTv = null;
        customerServiceFragment.mQuestionInfoEdt = null;
        customerServiceFragment.mNineGridView = null;
        this.f8434c.setOnClickListener(null);
        this.f8434c = null;
        this.f8435d.setOnClickListener(null);
        this.f8435d = null;
    }
}
