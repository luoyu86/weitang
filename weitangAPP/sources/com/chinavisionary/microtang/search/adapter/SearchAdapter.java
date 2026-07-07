package com.chinavisionary.microtang.search.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import b.c.d;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import c.e.a.d.x;
import com.chinavisionary.core.app.adapter.BaseRecyclerAdapter;
import com.chinavisionary.core.app.adapter.BaseRecyclerViewHolder;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.search.SearchVo;

/* JADX INFO: loaded from: classes2.dex */
public class SearchAdapter extends BaseRecyclerAdapter<SearchVo> {

    public static class SearchVh extends BaseRecyclerViewHolder<SearchVo> {

        @BindView(R.id.tv_content)
        public TextView mTextView;

        public SearchVh(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        public void g(SearchVo searchVo) {
            this.mTextView.setText(x.getNotNullStr(searchVo.getTitle(), ""));
        }
    }

    public class SearchVh_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public SearchVh f8396b;

        @UiThread
        public SearchVh_ViewBinding(SearchVh searchVh, View view) {
            this.f8396b = searchVh;
            searchVh.mTextView = (TextView) d.findRequiredViewAsType(view, R.id.tv_content, "field 'mTextView'", TextView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            SearchVh searchVh = this.f8396b;
            if (searchVh == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f8396b = null;
            searchVh.mTextView = null;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i2) {
        if (viewHolder.getItemViewType() != 26214) {
            SearchVh searchVh = (SearchVh) viewHolder;
            searchVh.g((SearchVo) this.f6460b.get(i2 - h()));
            b(searchVh, i2);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        if (i2 == 26214) {
            return new BaseRecyclerAdapter.RecyclerHeadViewHodler(this.f6466h);
        }
        View viewI = i(viewGroup, R.layout.item_search);
        SearchVh searchVh = new SearchVh(viewI);
        viewI.setTag(searchVh);
        return searchVh;
    }
}
