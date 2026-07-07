package com.chinavisionary.microtang.alert.adapter;

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
import com.chinavisionary.core.app.config.bo.LeftTitleToRightArrowVo;
import com.chinavisionary.microtang.R;

/* JADX INFO: loaded from: classes.dex */
public class AlertListAdapter extends BaseRecyclerAdapter<LeftTitleToRightArrowVo> {

    public static class AlertListVH extends BaseRecyclerViewHolder<LeftTitleToRightArrowVo> {

        @BindView(R.id.tv_left)
        public TextView mLeftTv;

        @BindView(R.id.tv_right_value)
        public TextView mRightTv;

        public AlertListVH(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        public void setData(LeftTitleToRightArrowVo leftTitleToRightArrowVo) {
            this.mLeftTv.setText(x.getNotNullStr(leftTitleToRightArrowVo.getLeft(), ""));
            this.mRightTv.setText(x.getNotNullStr(leftTitleToRightArrowVo.getRight(), ""));
        }
    }

    public class AlertListVH_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public AlertListVH f6814b;

        @UiThread
        public AlertListVH_ViewBinding(AlertListVH alertListVH, View view) {
            this.f6814b = alertListVH;
            alertListVH.mLeftTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_left, "field 'mLeftTv'", TextView.class);
            alertListVH.mRightTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_right_value, "field 'mRightTv'", TextView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            AlertListVH alertListVH = this.f6814b;
            if (alertListVH == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f6814b = null;
            alertListVH.mLeftTv = null;
            alertListVH.mRightTv = null;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i2) {
        ((AlertListVH) viewHolder).setData((LeftTitleToRightArrowVo) this.f6460b.get(i2));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        View viewI = i(viewGroup, R.layout.item_alert_list_layout);
        AlertListVH alertListVH = new AlertListVH(viewI);
        viewI.setTag(alertListVH);
        return alertListVH;
    }
}
