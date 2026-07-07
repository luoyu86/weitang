package com.chinavisionary.microtang.clean.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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
import c.e.a.d.z;
import com.chinavisionary.core.app.adapter.BaseRecyclerAdapter;
import com.chinavisionary.core.app.adapter.BaseRecyclerViewHolder;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.clean.view.TimerTextView;
import com.chinavisionary.microtang.clean.vo.CleanVo;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class CleanAdapter extends BaseRecyclerAdapter<CleanVo> {

    public static class CleanVH extends BaseRecyclerViewHolder<CleanVo> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public List<CleanVo> f6930f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f6931g;

        @BindView(R.id.btn_cancel_order)
        public Button mCancelOrderBtn;

        @BindView(R.id.btn_cancel_pay)
        public Button mCancelPayBtn;

        @BindView(R.id.tv_create_time_value)
        public TextView mCreateTimeTv;

        @BindView(R.id.tv_order_value)
        public TextView mOrderNoTv;

        @BindView(R.id.btn_pay)
        public Button mPayBtn;

        @BindView(R.id.tv_server_time_value)
        public TextView mServerTimeTv;

        @BindView(R.id.tv_state_name)
        public TextView mStateNameTv;

        @BindView(R.id.tv_surplus_time_title)
        public TextView mSurplusTimeTitleTv;

        @BindView(R.id.tv_surplus_time_value)
        public TimerTextView mSurplusTimeTv;

        public CleanVH(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        public final void g(Button button) {
            this.mPayBtn.setVisibility(8);
            this.mCancelPayBtn.setVisibility(8);
            this.mSurplusTimeTitleTv.setVisibility(8);
            this.mSurplusTimeTv.setVisibility(8);
            button.setText(R.string.title_cancel);
            button.setVisibility(0);
            button.setBackgroundResource(R.drawable.bg_btn_cancel);
            button.setTextColor(button.getResources().getColor(R.color.color383838));
        }

        public final void h(Button button) {
            this.mPayBtn.setVisibility(8);
            this.mCancelPayBtn.setVisibility(8);
            this.mSurplusTimeTitleTv.setVisibility(8);
            this.mSurplusTimeTv.setVisibility(8);
            button.setText(R.string.title_comment);
            button.setVisibility(0);
            button.setBackgroundResource(R.drawable.bg_btn_commend);
            button.setTextColor(button.getResources().getColor(R.color.tab_item_select_color));
        }

        public void i(CleanVo cleanVo) {
            this.mCancelOrderBtn.setTag(cleanVo);
            this.mPayBtn.setTag(cleanVo.getKey());
            this.mCancelPayBtn.setTag(cleanVo.getKey());
            this.mStateNameTv.setText(x.getNotNullStr(cleanVo.getStateName(), ""));
            this.mOrderNoTv.setText(x.getNotNullStr(cleanVo.getOrderCode(), ""));
            this.mCreateTimeTv.setText(x.getNotNullStr(z.getTime(cleanVo.getCreateTime()), ""));
            this.mServerTimeTv.setText(x.appendStringToResId(R.string.placeholder_hour, z.getHourToTime(cleanVo.getDuration())));
            if (cleanVo.getState() == null) {
                j();
                return;
            }
            int iIntValue = cleanVo.getState().intValue();
            if (iIntValue == 1) {
                k(cleanVo);
                return;
            }
            if (iIntValue == 2) {
                g(this.mCancelOrderBtn);
            } else if (iIntValue == 3) {
                h(this.mCancelOrderBtn);
            } else {
                if (iIntValue != 4) {
                    return;
                }
                j();
            }
        }

        public final void j() {
            this.mCancelOrderBtn.setVisibility(8);
            this.mPayBtn.setVisibility(8);
            this.mCancelPayBtn.setVisibility(8);
            this.mSurplusTimeTitleTv.setVisibility(8);
            this.mSurplusTimeTv.setVisibility(8);
            this.mCancelPayBtn.setVisibility(8);
        }

        public final void k(CleanVo cleanVo) {
            this.mCancelOrderBtn.setVisibility(8);
            this.mSurplusTimeTitleTv.setVisibility(0);
            this.mSurplusTimeTv.setVisibility(0);
            this.mPayBtn.setVisibility(0);
            this.mCancelPayBtn.setVisibility(0);
            this.mSurplusTimeTv.setTimer(cleanVo.getPayDeadline());
            this.mSurplusTimeTv.setCleanVos(this.f6930f);
            this.mSurplusTimeTv.setPosition(this.f6931g);
        }

        public void setCleanVoList(List<CleanVo> list) {
            this.f6930f = list;
        }

        public void setPosition(int i2) {
            this.f6931g = i2;
        }
    }

    public class CleanVH_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public CleanVH f6932b;

        @UiThread
        public CleanVH_ViewBinding(CleanVH cleanVH, View view) {
            this.f6932b = cleanVH;
            cleanVH.mStateNameTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_state_name, "field 'mStateNameTv'", TextView.class);
            cleanVH.mOrderNoTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_order_value, "field 'mOrderNoTv'", TextView.class);
            cleanVH.mCreateTimeTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_create_time_value, "field 'mCreateTimeTv'", TextView.class);
            cleanVH.mServerTimeTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_server_time_value, "field 'mServerTimeTv'", TextView.class);
            cleanVH.mSurplusTimeTv = (TimerTextView) d.findRequiredViewAsType(view, R.id.tv_surplus_time_value, "field 'mSurplusTimeTv'", TimerTextView.class);
            cleanVH.mSurplusTimeTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_surplus_time_title, "field 'mSurplusTimeTitleTv'", TextView.class);
            cleanVH.mCancelOrderBtn = (Button) d.findRequiredViewAsType(view, R.id.btn_cancel_order, "field 'mCancelOrderBtn'", Button.class);
            cleanVH.mPayBtn = (Button) d.findRequiredViewAsType(view, R.id.btn_pay, "field 'mPayBtn'", Button.class);
            cleanVH.mCancelPayBtn = (Button) d.findRequiredViewAsType(view, R.id.btn_cancel_pay, "field 'mCancelPayBtn'", Button.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            CleanVH cleanVH = this.f6932b;
            if (cleanVH == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f6932b = null;
            cleanVH.mStateNameTv = null;
            cleanVH.mOrderNoTv = null;
            cleanVH.mCreateTimeTv = null;
            cleanVH.mServerTimeTv = null;
            cleanVH.mSurplusTimeTv = null;
            cleanVH.mSurplusTimeTitleTv = null;
            cleanVH.mCancelOrderBtn = null;
            cleanVH.mPayBtn = null;
            cleanVH.mCancelPayBtn = null;
        }
    }

    @Override // com.chinavisionary.core.app.adapter.BaseRecyclerAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        if (1 == this.f6460b.size() && i2 == 0 && x.isNullStr(((CleanVo) this.f6460b.get(i2)).getOrderCode()) && x.isNullStr(((CleanVo) this.f6460b.get(i2)).getKey())) {
            return 34952;
        }
        return super.getItemViewType(i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i2) {
        int itemViewType = viewHolder.getItemViewType();
        if (itemViewType == 34952 || itemViewType == 39321) {
            return;
        }
        CleanVH cleanVH = (CleanVH) viewHolder;
        cleanVH.i((CleanVo) this.f6460b.get(i2));
        cleanVH.setCleanVoList(this.f6460b);
        cleanVH.setPosition(i2);
        p(cleanVH.mCancelOrderBtn);
        p(cleanVH.mPayBtn);
        p(cleanVH.mCancelPayBtn);
        b(cleanVH, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        if (i2 == 34952) {
            return new BaseRecyclerAdapter.EmptyViewHolder(d(viewGroup));
        }
        if (i2 == 39321) {
            return new BaseRecyclerAdapter.FooterViewHolder(f(viewGroup));
        }
        View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_clean_record_layout, viewGroup, false);
        CleanVH cleanVH = new CleanVH(viewInflate);
        viewInflate.setTag(cleanVH);
        return cleanVH;
    }

    public final void p(Button button) {
        button.setOnClickListener(null);
        View.OnClickListener onClickListener = this.f6461c;
        if (onClickListener != null) {
            button.setOnClickListener(onClickListener);
        }
    }
}
