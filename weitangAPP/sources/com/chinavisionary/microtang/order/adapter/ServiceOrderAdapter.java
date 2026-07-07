package com.chinavisionary.microtang.order.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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
import com.chinavisionary.microtang.order.vo.ServiceOrderVo;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ServiceOrderAdapter extends BaseRecyclerAdapter<ServiceOrderVo> {

    public static class RepairOrderVh extends BaseRecyclerViewHolder<ServiceOrderVo> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public View.OnClickListener f8063f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f8064g;

        @BindView(R.id.btn_action)
        public AppCompatButton mActionBtn;

        @BindView(R.id.tv_service_address_value)
        public TextView mAddressTv;

        @BindView(R.id.btn_contact)
        public AppCompatButton mContactBtn;

        @BindView(R.id.tv_content)
        public TextView mContentTv;

        @BindView(R.id.tv_service_person_title)
        public TextView mPersonTitleTv;

        @BindView(R.id.tv_service_person_value)
        public TextView mPersonTv;

        @BindView(R.id.tv_service_state)
        public TextView mStateTv;

        @BindView(R.id.tv_service_time_value)
        public TextView mTimeTv;

        public RepairOrderVh(View view) {
            super(view);
            ButterKnife.bind(this, view);
            this.mContactBtn.setVisibility(8);
        }

        public void g(ServiceOrderVo serviceOrderVo) {
            int status = serviceOrderVo.getStatus();
            this.mContactBtn.setVisibility(8);
            this.mContentTv.setText(x.getNotNullStr(serviceOrderVo.getContent(), ""));
            this.mAddressTv.setText(x.getNotNullStr(serviceOrderVo.getAddress(), ""));
            this.mTimeTv.setText(z.getTimeFromTo(serviceOrderVo.getFromTime(), serviceOrderVo.getToTime()));
            this.mStateTv.setText(x.getNotNullStr(serviceOrderVo.getStatusName(), ""));
            boolean z = (!serviceOrderVo.getCanCancel() || status == 2 || status == 5) ? false : true;
            boolean z2 = status == 4;
            if (z2) {
                z = z2;
            }
            this.mActionBtn.setVisibility(z ? 0 : 8);
            this.mActionBtn.setText(z2 ? R.string.title_comment : R.string.title_cancel);
            if (status == 3) {
                this.mActionBtn.setVisibility(8);
            }
            h(this.mActionBtn);
            h(this.mContactBtn);
        }

        public final void h(Button button) {
            button.setOnClickListener(null);
            button.setOnClickListener(this.f8063f);
            button.setTag(Integer.valueOf(this.f8064g));
        }

        public void setOnClickListener(View.OnClickListener onClickListener) {
            this.f8063f = onClickListener;
        }

        public void setPosition(int i2) {
            this.f8064g = i2;
        }
    }

    public class RepairOrderVh_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public RepairOrderVh f8065b;

        @UiThread
        public RepairOrderVh_ViewBinding(RepairOrderVh repairOrderVh, View view) {
            this.f8065b = repairOrderVh;
            repairOrderVh.mContentTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_content, "field 'mContentTv'", TextView.class);
            repairOrderVh.mAddressTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_service_address_value, "field 'mAddressTv'", TextView.class);
            repairOrderVh.mTimeTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_service_time_value, "field 'mTimeTv'", TextView.class);
            repairOrderVh.mPersonTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_service_person_value, "field 'mPersonTv'", TextView.class);
            repairOrderVh.mPersonTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_service_person_title, "field 'mPersonTitleTv'", TextView.class);
            repairOrderVh.mStateTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_service_state, "field 'mStateTv'", TextView.class);
            repairOrderVh.mActionBtn = (AppCompatButton) d.findRequiredViewAsType(view, R.id.btn_action, "field 'mActionBtn'", AppCompatButton.class);
            repairOrderVh.mContactBtn = (AppCompatButton) d.findRequiredViewAsType(view, R.id.btn_contact, "field 'mContactBtn'", AppCompatButton.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            RepairOrderVh repairOrderVh = this.f8065b;
            if (repairOrderVh == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f8065b = null;
            repairOrderVh.mContentTv = null;
            repairOrderVh.mAddressTv = null;
            repairOrderVh.mTimeTv = null;
            repairOrderVh.mPersonTv = null;
            repairOrderVh.mPersonTitleTv = null;
            repairOrderVh.mStateTv = null;
            repairOrderVh.mActionBtn = null;
            repairOrderVh.mContactBtn = null;
        }
    }

    public ServiceOrderAdapter() {
        addEmptyData();
    }

    public void addEmptyData() {
        ServiceOrderVo serviceOrderVo = new ServiceOrderVo();
        serviceOrderVo.setStatus(34952);
        addDataToList(serviceOrderVo);
    }

    @Override // com.chinavisionary.core.app.adapter.BaseRecyclerAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        if (this.f6466h != null && i2 == 0) {
            return 26214;
        }
        if (this.f6463e && i2 == getItemCount() - 1) {
            return 39321;
        }
        List<T> list = this.f6460b;
        if (list != 0 && !list.isEmpty() && this.f6460b.size() == 1 && ((ServiceOrderVo) this.f6460b.get(i2)).getStatus() == 34952 && ((ServiceOrderVo) this.f6460b.get(i2)).getStatusName() == null) {
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
        RepairOrderVh repairOrderVh = (RepairOrderVh) viewHolder;
        b(repairOrderVh, i2);
        repairOrderVh.setPosition(i2);
        repairOrderVh.g((ServiceOrderVo) this.f6460b.get(i2));
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
        View viewI = i(viewGroup, R.layout.item_repair_order);
        RepairOrderVh repairOrderVh = new RepairOrderVh(viewI);
        viewI.setTag(repairOrderVh);
        repairOrderVh.setOnClickListener(this.f6461c);
        return repairOrderVh;
    }
}
