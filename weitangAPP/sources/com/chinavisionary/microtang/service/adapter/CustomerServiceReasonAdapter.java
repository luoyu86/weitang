package com.chinavisionary.microtang.service.adapter;

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
import c.k.b.a;
import com.alibaba.fastjson.JSON;
import com.chinavisionary.core.app.adapter.BaseRecyclerAdapter;
import com.chinavisionary.core.app.adapter.BaseRecyclerViewHolder;
import com.chinavisionary.core.app.config.bo.UserInfoVo;
import com.chinavisionary.core.weight.CoreRoundedImageView;
import com.chinavisionary.framework.mobile.common.vo.ResourceVo;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.service.bo.ResponseFormBo;
import com.chinavisionary.microtang.service.vo.MeReasonVo;
import com.lzy.ninegrid.NineGridView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class CustomerServiceReasonAdapter extends BaseRecyclerAdapter<MeReasonVo> {
    public UserInfoVo n;
    public String o;

    public static class CustomerServiceReasonVh extends BaseRecyclerViewHolder<MeReasonVo> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f8401f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public UserInfoVo f8402g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public View.OnClickListener f8403h;

        @BindView(R.id.btn_cat_reply)
        public AppCompatButton mCatReplyBtn;

        @BindView(R.id.btn_comment_service)
        public AppCompatButton mCommentServiceBtn;

        @BindView(R.id.tv_comment_service_content)
        public TextView mCommentServiceContentTv;

        @BindView(R.id.tv_name)
        public TextView mNameTv;

        @BindView(R.id.nine_grid_view_reason)
        public NineGridView mNineGridView;

        @BindView(R.id.tv_phone)
        public TextView mPhoneTv;

        @BindView(R.id.tv_reason_msg)
        public TextView mReasonMsgTv;

        @BindView(R.id.tv_reply_content)
        public TextView mReplyMsgTv;

        @BindView(R.id.nine_grid_view_reply)
        public NineGridView mReplyNineGridView;

        @BindView(R.id.layout_reply)
        public View mReplyView;

        @BindView(R.id.tv_time)
        public TextView mTimeTv;

        @BindView(R.id.img_user_icon)
        public CoreRoundedImageView mUserIconImg;

        public CustomerServiceReasonVh(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        public final List<a> j(List<ResourceVo> list) {
            ArrayList arrayList = new ArrayList();
            if (list != null && !list.isEmpty()) {
                for (ResourceVo resourceVo : list) {
                    if (resourceVo != null) {
                        a aVar = new a();
                        aVar.setBigImageUrl(resourceVo.getUrl());
                        aVar.setThumbnailUrl(resourceVo.getUrl());
                        arrayList.add(aVar);
                    }
                }
            }
            return arrayList;
        }

        public final void k(MeReasonVo meReasonVo, boolean z) {
            ResponseFormBo formDataSourceVo;
            boolean z2;
            if (z) {
                formDataSourceVo = meReasonVo.getDataSourceVo();
                z2 = formDataSourceVo != null;
                this.mReplyView.setVisibility(z2 ? 0 : 8);
                o(new ArrayList());
            } else {
                formDataSourceVo = meReasonVo.getFormDataSourceVo();
                z2 = formDataSourceVo != null;
                s(new ArrayList());
            }
            if (z2) {
                List<ResponseFormBo.ItemsBean> items = formDataSourceVo.getItems();
                this.mReplyMsgTv.setText("");
                if (items == null || items.isEmpty()) {
                    return;
                }
                Iterator<ResponseFormBo.ItemsBean> it = items.iterator();
                while (it.hasNext()) {
                    l(it.next(), z);
                }
            }
        }

        public final void l(ResponseFormBo.ItemsBean itemsBean, boolean z) {
            if (itemsBean == null) {
                this.mReplyMsgTv.setText("");
                this.mReasonMsgTv.setText("");
                return;
            }
            String value = itemsBean.getValue();
            int type = itemsBean.getType();
            if (type != -1 && type != 0 && type != 6) {
                if (type == 7) {
                    if (x.isNotNull(value)) {
                        List<ResourceVo> array = JSON.parseArray(value, ResourceVo.class);
                        if (z) {
                            o(array);
                            return;
                        } else {
                            s(array);
                            return;
                        }
                    }
                    return;
                }
                if (type != 10) {
                    return;
                }
            }
            if (z) {
                u(itemsBean);
            } else {
                t(itemsBean);
            }
        }

        public void m(MeReasonVo meReasonVo) {
            UserInfoVo userInfoVo = this.f8402g;
            if (userInfoVo != null) {
                this.mUserIconImg.loadImageToResourceVo(userInfoVo.getAvatar());
                this.mNameTv.setText(x.getNotNullStr(this.f8402g.getNickname(), ""));
            }
            this.mCatReplyBtn.setVisibility((x.isNotNull(meReasonVo.getHandleFormKey()) && meReasonVo.getDataSourceVo() == null) ? 0 : 8);
            this.mPhoneTv.setText(x.getNotNullStr(this.f8401f, ""));
            this.mTimeTv.setText(x.appendStringToResId(R.string.placeholder_reason_time, z.getTime(meReasonVo.getCreateTime())));
            k(meReasonVo, false);
            k(meReasonVo, true);
            q();
            r(meReasonVo);
        }

        public final void n(String str) {
            this.f8401f = str;
        }

        public final void o(List<ResourceVo> list) {
            this.mReplyNineGridView.setAdapter(new c.k.b.d.a(this.mNineGridView.getContext(), j(list)));
        }

        public final void p(UserInfoVo userInfoVo) {
            this.f8402g = userInfoVo;
        }

        public final void q() {
            this.mCatReplyBtn.setTag(Integer.valueOf(this.f6468a));
            if (this.f8403h != null) {
                this.mCatReplyBtn.setOnClickListener(null);
                this.mCatReplyBtn.setOnClickListener(this.f8403h);
            }
            this.mCommentServiceBtn.setTag(Integer.valueOf(this.f6468a));
            if (this.f8403h != null) {
                this.mCommentServiceBtn.setOnClickListener(null);
                this.mCommentServiceBtn.setOnClickListener(this.f8403h);
            }
        }

        public final void r(MeReasonVo meReasonVo) {
            int i2 = 0;
            this.mCommentServiceBtn.setVisibility(meReasonVo.isCanReply() && x.isNotNull(meReasonVo.getComplaintOrderKey()) ? 0 : 8);
            boolean zIsNotNull = x.isNotNull(meReasonVo.getReplyContent());
            TextView textView = this.mCommentServiceContentTv;
            if (!meReasonVo.isCanReply() && !zIsNotNull) {
                i2 = 8;
            }
            textView.setVisibility(i2);
            String str = "";
            if (zIsNotNull) {
                str = x.getString(R.string.title_comment_content_prefix) + x.getNotNullStr(meReasonVo.getReplyContent(), "");
            }
            this.mCommentServiceContentTv.setText(str);
        }

        public final void s(List<ResourceVo> list) {
            this.mNineGridView.setAdapter(new c.k.b.d.a(this.mNineGridView.getContext(), j(list)));
        }

        public final void setOnClickListener(View.OnClickListener onClickListener) {
            this.f8403h = onClickListener;
        }

        public final void t(ResponseFormBo.ItemsBean itemsBean) {
            this.mReasonMsgTv.setText(itemsBean.getName() + x.getString(R.string.title_colon) + x.getNotNullStr(itemsBean.getValue(), ""));
        }

        public final void u(ResponseFormBo.ItemsBean itemsBean) {
            this.mReplyMsgTv.append(itemsBean.getName() + x.getString(R.string.title_colon) + x.getNotNullStr(itemsBean.getValue(), ""));
        }
    }

    public class CustomerServiceReasonVh_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public CustomerServiceReasonVh f8404b;

        @UiThread
        public CustomerServiceReasonVh_ViewBinding(CustomerServiceReasonVh customerServiceReasonVh, View view) {
            this.f8404b = customerServiceReasonVh;
            customerServiceReasonVh.mUserIconImg = (CoreRoundedImageView) d.findRequiredViewAsType(view, R.id.img_user_icon, "field 'mUserIconImg'", CoreRoundedImageView.class);
            customerServiceReasonVh.mNameTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_name, "field 'mNameTv'", TextView.class);
            customerServiceReasonVh.mPhoneTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_phone, "field 'mPhoneTv'", TextView.class);
            customerServiceReasonVh.mTimeTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_time, "field 'mTimeTv'", TextView.class);
            customerServiceReasonVh.mCatReplyBtn = (AppCompatButton) d.findRequiredViewAsType(view, R.id.btn_cat_reply, "field 'mCatReplyBtn'", AppCompatButton.class);
            customerServiceReasonVh.mReasonMsgTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_reason_msg, "field 'mReasonMsgTv'", TextView.class);
            customerServiceReasonVh.mNineGridView = (NineGridView) d.findRequiredViewAsType(view, R.id.nine_grid_view_reason, "field 'mNineGridView'", NineGridView.class);
            customerServiceReasonVh.mReplyView = d.findRequiredView(view, R.id.layout_reply, "field 'mReplyView'");
            customerServiceReasonVh.mReplyMsgTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_reply_content, "field 'mReplyMsgTv'", TextView.class);
            customerServiceReasonVh.mReplyNineGridView = (NineGridView) d.findRequiredViewAsType(view, R.id.nine_grid_view_reply, "field 'mReplyNineGridView'", NineGridView.class);
            customerServiceReasonVh.mCommentServiceContentTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_comment_service_content, "field 'mCommentServiceContentTv'", TextView.class);
            customerServiceReasonVh.mCommentServiceBtn = (AppCompatButton) d.findRequiredViewAsType(view, R.id.btn_comment_service, "field 'mCommentServiceBtn'", AppCompatButton.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            CustomerServiceReasonVh customerServiceReasonVh = this.f8404b;
            if (customerServiceReasonVh == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f8404b = null;
            customerServiceReasonVh.mUserIconImg = null;
            customerServiceReasonVh.mNameTv = null;
            customerServiceReasonVh.mPhoneTv = null;
            customerServiceReasonVh.mTimeTv = null;
            customerServiceReasonVh.mCatReplyBtn = null;
            customerServiceReasonVh.mReasonMsgTv = null;
            customerServiceReasonVh.mNineGridView = null;
            customerServiceReasonVh.mReplyView = null;
            customerServiceReasonVh.mReplyMsgTv = null;
            customerServiceReasonVh.mReplyNineGridView = null;
            customerServiceReasonVh.mCommentServiceContentTv = null;
            customerServiceReasonVh.mCommentServiceBtn = null;
        }
    }

    public CustomerServiceReasonAdapter(UserInfoVo userInfoVo, String str) {
        this.n = userInfoVo;
        this.o = str;
        MeReasonVo meReasonVo = new MeReasonVo();
        meReasonVo.setType(34952);
        addDataToList(meReasonVo);
    }

    @Override // com.chinavisionary.core.app.adapter.BaseRecyclerAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        List<T> list = this.f6460b;
        if (list != 0 && list.size() == 1 && ((MeReasonVo) this.f6460b.get(i2)).getType() == 34952) {
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
        CustomerServiceReasonVh customerServiceReasonVh = (CustomerServiceReasonVh) viewHolder;
        customerServiceReasonVh.setListPosition(i2);
        customerServiceReasonVh.setOnClickListener(this.f6461c);
        customerServiceReasonVh.m((MeReasonVo) this.f6460b.get(i2));
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
        View viewI = i(viewGroup, R.layout.item_customer_service_reason);
        CustomerServiceReasonVh customerServiceReasonVh = new CustomerServiceReasonVh(viewI);
        customerServiceReasonVh.p(this.n);
        customerServiceReasonVh.n(this.o);
        viewI.setTag(customerServiceReasonVh);
        return customerServiceReasonVh;
    }
}
