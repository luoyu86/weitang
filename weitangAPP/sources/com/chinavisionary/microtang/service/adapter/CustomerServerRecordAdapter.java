package com.chinavisionary.microtang.service.adapter;

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
import c.e.a.d.z;
import c.k.b.a;
import com.chinavisionary.core.app.adapter.BaseRecyclerAdapter;
import com.chinavisionary.core.app.adapter.BaseRecyclerViewHolder;
import com.chinavisionary.framework.mobile.common.vo.ResourceVo;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.service.vo.CustomerServerRecordVo;
import com.chinavisionary.microtang.service.vo.ScopeVo;
import com.lzy.ninegrid.NineGridView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class CustomerServerRecordAdapter extends BaseRecyclerAdapter<CustomerServerRecordVo> {

    public static class CustomerServerRecordVH extends BaseRecyclerViewHolder<CustomerServerRecordVo> {

        @BindView(R.id.tv_categories_value)
        public TextView mCategoriesTv;

        @BindView(R.id.nine_grid_view_commend)
        public NineGridView mNineGridView;

        @BindView(R.id.tv_publish_time)
        public TextView mPublishTimeTv;

        @BindView(R.id.tv_question_info)
        public TextView mQuestionInfoTv;

        @BindView(R.id.tv_question_value)
        public TextView mQuestionTv;

        @BindView(R.id.tv_reply_content)
        public TextView mReplyContentTv;

        @BindView(R.id.tv_right_value)
        public TextView mStateNameTv;

        public CustomerServerRecordVH(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        public final void g(CustomerServerRecordVo customerServerRecordVo) {
            if (customerServerRecordVo != null) {
                List<ResourceVo> picture = customerServerRecordVo.getPicture();
                boolean z = (picture == null || picture.isEmpty()) ? false : true;
                if (z) {
                    ArrayList arrayList = new ArrayList();
                    for (ResourceVo resourceVo : picture) {
                        if (resourceVo != null) {
                            a aVar = new a();
                            aVar.setThumbnailUrl(resourceVo.getUrl());
                            aVar.setBigImageUrl(resourceVo.getUrl());
                            arrayList.add(aVar);
                        }
                    }
                    NineGridView nineGridView = this.mNineGridView;
                    nineGridView.setAdapter(new c.k.b.d.a(nineGridView.getContext(), arrayList));
                }
                this.mNineGridView.setVisibility(z ? 0 : 8);
            }
        }

        public void h(CustomerServerRecordVo customerServerRecordVo) {
            ScopeVo scopeVo;
            ScopeVo scopeVo2;
            this.mPublishTimeTv.setText(z.getTime(customerServerRecordVo.getCreateTime()));
            this.mStateNameTv.setText(x.getNotNullStr(customerServerRecordVo.getStateName(), ""));
            List<ScopeVo> scope = customerServerRecordVo.getScope();
            List<ScopeVo> scopeDescribe = customerServerRecordVo.getScopeDescribe();
            String name = null;
            String name2 = (scope == null || scope.isEmpty() || (scopeVo2 = scope.get(0)) == null) ? null : scopeVo2.getName();
            if (scopeDescribe != null && !scopeDescribe.isEmpty() && (scopeVo = scopeDescribe.get(0)) != null) {
                name = scopeVo.getName();
            }
            this.mCategoriesTv.setText(x.getNotNullStr(name2, ""));
            this.mQuestionTv.setText(x.getNotNullStr(name, ""));
            this.mQuestionInfoTv.setText(x.getNotNullStr(customerServerRecordVo.getRemark(), ""));
            this.mReplyContentTv.setVisibility(x.isNotNull(customerServerRecordVo.getReply()) ? 0 : 8);
            this.mReplyContentTv.setText(x.getNotNullStr(customerServerRecordVo.getReply(), ""));
            g(customerServerRecordVo);
        }
    }

    public class CustomerServerRecordVH_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public CustomerServerRecordVH f8400b;

        @UiThread
        public CustomerServerRecordVH_ViewBinding(CustomerServerRecordVH customerServerRecordVH, View view) {
            this.f8400b = customerServerRecordVH;
            customerServerRecordVH.mPublishTimeTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_publish_time, "field 'mPublishTimeTv'", TextView.class);
            customerServerRecordVH.mStateNameTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_right_value, "field 'mStateNameTv'", TextView.class);
            customerServerRecordVH.mCategoriesTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_categories_value, "field 'mCategoriesTv'", TextView.class);
            customerServerRecordVH.mQuestionTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_question_value, "field 'mQuestionTv'", TextView.class);
            customerServerRecordVH.mQuestionInfoTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_question_info, "field 'mQuestionInfoTv'", TextView.class);
            customerServerRecordVH.mNineGridView = (NineGridView) d.findRequiredViewAsType(view, R.id.nine_grid_view_commend, "field 'mNineGridView'", NineGridView.class);
            customerServerRecordVH.mReplyContentTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_reply_content, "field 'mReplyContentTv'", TextView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            CustomerServerRecordVH customerServerRecordVH = this.f8400b;
            if (customerServerRecordVH == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f8400b = null;
            customerServerRecordVH.mPublishTimeTv = null;
            customerServerRecordVH.mStateNameTv = null;
            customerServerRecordVH.mCategoriesTv = null;
            customerServerRecordVH.mQuestionTv = null;
            customerServerRecordVH.mQuestionInfoTv = null;
            customerServerRecordVH.mNineGridView = null;
            customerServerRecordVH.mReplyContentTv = null;
        }
    }

    @Override // com.chinavisionary.core.app.adapter.BaseRecyclerAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        if (1 == this.f6460b.size() && i2 == 0 && ((CustomerServerRecordVo) this.f6460b.get(i2)).getRemark() == null && x.isNullStr(((CustomerServerRecordVo) this.f6460b.get(i2)).getKey())) {
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
        ((CustomerServerRecordVH) viewHolder).h((CustomerServerRecordVo) this.f6460b.get(i2));
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
        View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_customer_server_record_layout, viewGroup, false);
        CustomerServerRecordVH customerServerRecordVH = new CustomerServerRecordVH(viewInflate);
        viewInflate.setTag(customerServerRecordVH);
        return customerServerRecordVH;
    }
}
