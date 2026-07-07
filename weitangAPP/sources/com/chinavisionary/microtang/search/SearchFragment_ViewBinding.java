package com.chinavisionary.microtang.search;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import b.c.b;
import b.c.d;
import butterknife.Unbinder;
import com.chinavisionary.core.weight.BaseRecyclerView;
import com.chinavisionary.microtang.R;

/* JADX INFO: loaded from: classes2.dex */
public class SearchFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SearchFragment f8392b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f8393c;

    public class a extends b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ SearchFragment f8394c;

        public a(SearchFragment searchFragment) {
            this.f8394c = searchFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f8394c.backClick(view);
        }
    }

    @UiThread
    public SearchFragment_ViewBinding(SearchFragment searchFragment, View view) {
        this.f8392b = searchFragment;
        searchFragment.mTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title, "field 'mTitleTv'", TextView.class);
        searchFragment.mSearchEdt = (EditText) d.findRequiredViewAsType(view, R.id.edt_input_search, "field 'mSearchEdt'", EditText.class);
        searchFragment.mRecyclerView = (BaseRecyclerView) d.findRequiredViewAsType(view, R.id.recycler_search_result, "field 'mRecyclerView'", BaseRecyclerView.class);
        View viewFindRequiredView = d.findRequiredView(view, R.id.tv_back, "method 'backClick'");
        this.f8393c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(searchFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        SearchFragment searchFragment = this.f8392b;
        if (searchFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f8392b = null;
        searchFragment.mTitleTv = null;
        searchFragment.mSearchEdt = null;
        searchFragment.mRecyclerView = null;
        this.f8393c.setOnClickListener(null);
        this.f8393c = null;
    }
}
