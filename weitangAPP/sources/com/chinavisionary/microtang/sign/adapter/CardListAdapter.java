package com.chinavisionary.microtang.sign.adapter;

import android.view.LayoutInflater;
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
import com.chinavisionary.microtang.sign.vo.CardVo;

/* JADX INFO: loaded from: classes2.dex */
public class CardListAdapter extends BaseRecyclerAdapter<CardVo> {

    public static class CardVH extends BaseRecyclerViewHolder<CardVo> {

        @BindView(R.id.tv_right_title)
        public TextView mRightTv;

        public CardVH(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        public void g(CardVo cardVo) {
            this.mRightTv.setText(x.getNotNullStr(cardVo.getCardName(), ""));
        }
    }

    public class CardVH_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public CardVH f8490b;

        @UiThread
        public CardVH_ViewBinding(CardVH cardVH, View view) {
            this.f8490b = cardVH;
            cardVH.mRightTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_right_title, "field 'mRightTv'", TextView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            CardVH cardVH = this.f8490b;
            if (cardVH == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f8490b = null;
            cardVH.mRightTv = null;
        }
    }

    @Override // com.chinavisionary.core.app.adapter.BaseRecyclerAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f6460b.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i2) {
        if (viewHolder.getItemViewType() != 34952) {
            CardVH cardVH = (CardVH) viewHolder;
            cardVH.g((CardVo) this.f6460b.get(i2));
            b(cardVH, i2);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        if (i2 == 34952) {
            return new BaseRecyclerAdapter.EmptyViewHolder(d(viewGroup));
        }
        View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_right_layout, viewGroup, false);
        CardVH cardVH = new CardVH(viewInflate);
        viewInflate.setTag(cardVH);
        return cardVH;
    }
}
