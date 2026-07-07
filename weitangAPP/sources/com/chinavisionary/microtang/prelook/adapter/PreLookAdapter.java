package com.chinavisionary.microtang.prelook.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import androidx.appcompat.widget.AppCompatButton;
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
import com.chinavisionary.microtang.prelook.vo.PreLookVo;

/* JADX INFO: loaded from: classes2.dex */
public class PreLookAdapter extends BaseRecyclerAdapter<PreLookVo> {

    public static class PreLookVh extends BaseRecyclerViewHolder<PreLookVo> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public View.OnClickListener f8189f;

        @BindView(R.id.btn_comment)
        public AppCompatButton mCommentBtn;

        @BindView(R.id.tv_look_time_value)
        public TextView mLookRoomTimeTv;

        @BindView(R.id.tv_look_room_value)
        public TextView mLookRoomTv;

        public PreLookVh(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        public void g(PreLookVo preLookVo) {
            this.mLookRoomTv.setText(x.getNotNullStr(preLookVo.getAddress(), ""));
            this.mLookRoomTimeTv.setText(z.getTime(preLookVo.getAppointmentTime()));
            this.mCommentBtn.setText(preLookVo.getStatus() != 2 ? R.string.title_comment : R.string.title_cancel);
            this.mCommentBtn.setTag(preLookVo);
            this.mCommentBtn.setOnClickListener(null);
            this.mCommentBtn.setOnClickListener(this.f8189f);
        }

        public void setOnClickListener(View.OnClickListener onClickListener) {
            this.f8189f = onClickListener;
        }
    }

    public class PreLookVh_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public PreLookVh f8190b;

        @UiThread
        public PreLookVh_ViewBinding(PreLookVh preLookVh, View view) {
            this.f8190b = preLookVh;
            preLookVh.mCommentBtn = (AppCompatButton) d.findRequiredViewAsType(view, R.id.btn_comment, "field 'mCommentBtn'", AppCompatButton.class);
            preLookVh.mLookRoomTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_look_room_value, "field 'mLookRoomTv'", TextView.class);
            preLookVh.mLookRoomTimeTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_look_time_value, "field 'mLookRoomTimeTv'", TextView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            PreLookVh preLookVh = this.f8190b;
            if (preLookVh == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f8190b = null;
            preLookVh.mCommentBtn = null;
            preLookVh.mLookRoomTv = null;
            preLookVh.mLookRoomTimeTv = null;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i2) {
        ((PreLookVh) viewHolder).g((PreLookVo) this.f6460b.get(i2));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_pre_look_layout, viewGroup, false);
        PreLookVh preLookVh = new PreLookVh(viewInflate);
        preLookVh.setOnClickListener(this.f6461c);
        viewInflate.setTag(preLookVh);
        return preLookVh;
    }
}
