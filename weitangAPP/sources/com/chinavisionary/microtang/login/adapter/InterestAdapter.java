package com.chinavisionary.microtang.login.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import b.c.d;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.chinavisionary.core.app.adapter.BaseRecyclerAdapter;
import com.chinavisionary.core.app.adapter.BaseRecyclerViewHolder;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.login.bo.InterestItemVo;

/* JADX INFO: loaded from: classes.dex */
public class InterestAdapter extends BaseRecyclerAdapter<InterestItemVo> {

    public static class InterestVh extends BaseRecyclerViewHolder<InterestItemVo> {

        @BindView(R.id.cb_interest)
        public CheckBox mInterestCb;

        public InterestVh(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        public void g(InterestItemVo interestItemVo) {
            this.mInterestCb.setTag(Integer.valueOf(getAdapterPosition()));
            this.mInterestCb.setOnClickListener(this.f6469b);
            this.mInterestCb.setText(interestItemVo.getTagName());
            this.mInterestCb.setChecked(interestItemVo.isSelect());
        }
    }

    public class InterestVh_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public InterestVh f7343b;

        @UiThread
        public InterestVh_ViewBinding(InterestVh interestVh, View view) {
            this.f7343b = interestVh;
            interestVh.mInterestCb = (CheckBox) d.findRequiredViewAsType(view, R.id.cb_interest, "field 'mInterestCb'", CheckBox.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            InterestVh interestVh = this.f7343b;
            if (interestVh == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f7343b = null;
            interestVh.mInterestCb = null;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i2) {
        ((InterestVh) viewHolder).g((InterestItemVo) this.f6460b.get(i2));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        return p(viewGroup);
    }

    public final InterestVh p(ViewGroup viewGroup) {
        InterestVh interestVh = new InterestVh(i(viewGroup, R.layout.item_interest));
        interestVh.setViewOnClickListener(this.f6461c);
        return interestVh;
    }
}
