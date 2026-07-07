package com.chinavisionary.microtang.sign.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
import com.chinavisionary.core.weight.CoreRoundedImageView;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.me.vo.IDTypeNameValueVo;
import com.chinavisionary.microtang.sign.view.RentUserLayout;
import com.chinavisionary.microtang.sign.view.TogetherLiveLayout;
import com.chinavisionary.microtang.sign.vo.ContactDetailsVo;
import com.chinavisionary.microtang.sign.vo.SignRoomVo;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class SignRoomAdapter extends BaseRecyclerAdapter<SignRoomVo> {
    public List<IDTypeNameValueVo> n;

    public static class PayModeVH extends BaseRecyclerViewHolder<SignRoomVo> {

        @BindView(R.id.tv_item)
        public TextView mItemTv;

        @BindView(R.id.cb_pay)
        public CheckBox mPayCb;

        @BindView(R.id.img_pay_icon)
        public CoreRoundedImageView mPayIconImg;

        @BindView(R.id.tv_left_title)
        public TextView mPayModeNameTv;

        @BindView(R.id.tv_title)
        public TextView mTitleTv;

        public PayModeVH(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        public void g(SignRoomVo signRoomVo) {
            this.mTitleTv.setVisibility(x.isNullStr(signRoomVo.getItemTitle()) ^ true ? 0 : 8);
            this.mPayIconImg.setImageResource(signRoomVo.getPayDrawableId());
            this.mPayModeNameTv.setText(signRoomVo.getLeft());
            this.mPayCb.setChecked(signRoomVo.isCheck());
        }
    }

    public class PayModeVH_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public PayModeVH f8494b;

        @UiThread
        public PayModeVH_ViewBinding(PayModeVH payModeVH, View view) {
            this.f8494b = payModeVH;
            payModeVH.mTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title, "field 'mTitleTv'", TextView.class);
            payModeVH.mPayIconImg = (CoreRoundedImageView) d.findRequiredViewAsType(view, R.id.img_pay_icon, "field 'mPayIconImg'", CoreRoundedImageView.class);
            payModeVH.mPayModeNameTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_left_title, "field 'mPayModeNameTv'", TextView.class);
            payModeVH.mPayCb = (CheckBox) d.findRequiredViewAsType(view, R.id.cb_pay, "field 'mPayCb'", CheckBox.class);
            payModeVH.mItemTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_item, "field 'mItemTv'", TextView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            PayModeVH payModeVH = this.f8494b;
            if (payModeVH == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f8494b = null;
            payModeVH.mTitleTv = null;
            payModeVH.mPayIconImg = null;
            payModeVH.mPayModeNameTv = null;
            payModeVH.mPayCb = null;
            payModeVH.mItemTv = null;
        }
    }

    public static class PayPriceVH extends BaseRecyclerViewHolder<SignRoomVo> {

        @BindView(R.id.img_pay_info_icon)
        public ImageView mPayInfoImg;

        @BindView(R.id.view_pay_info)
        public View mPayInfoView;

        @BindView(R.id.tv_pay_price_value)
        public TextView mPriceTv;

        public PayPriceVH(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        public void g(SignRoomVo signRoomVo) {
            this.mPriceTv.setText(x.appendStringToResId(R.string.rmb_placeholder, signRoomVo.getPrice()));
        }
    }

    public class PayPriceVH_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public PayPriceVH f8495b;

        @UiThread
        public PayPriceVH_ViewBinding(PayPriceVH payPriceVH, View view) {
            this.f8495b = payPriceVH;
            payPriceVH.mPriceTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_pay_price_value, "field 'mPriceTv'", TextView.class);
            payPriceVH.mPayInfoImg = (ImageView) d.findRequiredViewAsType(view, R.id.img_pay_info_icon, "field 'mPayInfoImg'", ImageView.class);
            payPriceVH.mPayInfoView = d.findRequiredView(view, R.id.view_pay_info, "field 'mPayInfoView'");
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            PayPriceVH payPriceVH = this.f8495b;
            if (payPriceVH == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f8495b = null;
            payPriceVH.mPriceTv = null;
            payPriceVH.mPayInfoImg = null;
            payPriceVH.mPayInfoView = null;
        }
    }

    public static class RentUserInfoVH extends BaseRecyclerViewHolder<SignRoomVo> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f8496f;

        @BindView(R.id.llayout_together_live)
        public LinearLayout mTogetherLiveLayout;

        public RentUserInfoVH(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        public void g(List<SignRoomVo> list, View.OnClickListener onClickListener, int i2) {
            this.mTogetherLiveLayout.removeAllViews();
            List<ContactDetailsVo.RoommatesBean> roommatesBeans = list.get(i2).getRoommatesBeans();
            int size = roommatesBeans.size();
            for (int i3 = 0; i3 < size; i3++) {
                RentUserLayout rentUserLayout = new RentUserLayout(this.mTogetherLiveLayout.getContext());
                rentUserLayout.setShowRentUser(this.f8496f);
                rentUserLayout.setupRentUser(list, roommatesBeans.get(i3), i2, onClickListener, i3);
                this.mTogetherLiveLayout.addView(rentUserLayout);
            }
        }

        public void setRent(boolean z) {
            this.f8496f = z;
        }
    }

    public class RentUserInfoVH_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public RentUserInfoVH f8497b;

        @UiThread
        public RentUserInfoVH_ViewBinding(RentUserInfoVH rentUserInfoVH, View view) {
            this.f8497b = rentUserInfoVH;
            rentUserInfoVH.mTogetherLiveLayout = (LinearLayout) d.findRequiredViewAsType(view, R.id.llayout_together_live, "field 'mTogetherLiveLayout'", LinearLayout.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            RentUserInfoVH rentUserInfoVH = this.f8497b;
            if (rentUserInfoVH == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f8497b = null;
            rentUserInfoVH.mTogetherLiveLayout = null;
        }
    }

    public static class SignRoomVH extends BaseRecyclerViewHolder<SignRoomVo> {

        @BindView(R.id.tv_left_title)
        public TextView mLeftTitleTv;

        @BindView(R.id.img_right_icon)
        public ImageView mRightIconImg;

        @BindView(R.id.tv_right_title)
        public TextView mRightTitleTv;

        @BindView(R.id.tv_split_line)
        public TextView mSplitLineTv;

        @BindView(R.id.tv_title)
        public TextView mTitleTv;

        @BindView(R.id.edt_user_info)
        public EditText mUserInfoEdt;

        public SignRoomVH(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        public void g(SignRoomVo signRoomVo) {
            String itemTitle = signRoomVo.getItemTitle();
            boolean z = !x.isNullStr(itemTitle);
            this.mTitleTv.setText(x.getNotNullStr(itemTitle, ""));
            this.mTitleTv.setVisibility(z ? 0 : 8);
            this.mSplitLineTv.setVisibility(signRoomVo.isShowLine() ? 0 : 8);
            this.mRightIconImg.setVisibility(signRoomVo.isShowRightIcon() ? 0 : 4);
            boolean zIsShowEdit = signRoomVo.isShowEdit();
            this.mUserInfoEdt.setVisibility(zIsShowEdit ? 0 : 8);
            this.mUserInfoEdt.setHint(x.getNotNullStr(signRoomVo.getHintValue(), ""));
            this.mLeftTitleTv.setText(x.getNotNullStr(signRoomVo.getLeft(), ""));
            this.mRightTitleTv.setVisibility(zIsShowEdit ? 8 : 0);
            boolean z2 = !x.isNullStr(signRoomVo.getPrice());
            this.mRightTitleTv.setTextColor(z2 ? this.mRightTitleTv.getResources().getColor(R.color.item_room_tv_price_color) : this.mRightTitleTv.getResources().getColor(R.color.colore757575));
            String strAppendStringToResId = x.appendStringToResId(R.string.rmb_placeholder, signRoomVo.getPrice());
            TextView textView = this.mRightTitleTv;
            if (!z2) {
                strAppendStringToResId = signRoomVo.getRight();
            }
            textView.setText(strAppendStringToResId);
        }
    }

    public class SignRoomVH_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public SignRoomVH f8498b;

        @UiThread
        public SignRoomVH_ViewBinding(SignRoomVH signRoomVH, View view) {
            this.f8498b = signRoomVH;
            signRoomVH.mTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title, "field 'mTitleTv'", TextView.class);
            signRoomVH.mLeftTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_left_title, "field 'mLeftTitleTv'", TextView.class);
            signRoomVH.mRightTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_right_title, "field 'mRightTitleTv'", TextView.class);
            signRoomVH.mUserInfoEdt = (EditText) d.findRequiredViewAsType(view, R.id.edt_user_info, "field 'mUserInfoEdt'", EditText.class);
            signRoomVH.mRightIconImg = (ImageView) d.findRequiredViewAsType(view, R.id.img_right_icon, "field 'mRightIconImg'", ImageView.class);
            signRoomVH.mSplitLineTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_split_line, "field 'mSplitLineTv'", TextView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            SignRoomVH signRoomVH = this.f8498b;
            if (signRoomVH == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f8498b = null;
            signRoomVH.mTitleTv = null;
            signRoomVH.mLeftTitleTv = null;
            signRoomVH.mRightTitleTv = null;
            signRoomVH.mUserInfoEdt = null;
            signRoomVH.mRightIconImg = null;
            signRoomVH.mSplitLineTv = null;
        }
    }

    public static class TogetherVH extends BaseRecyclerViewHolder<SignRoomVo> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f8499f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public List<IDTypeNameValueVo> f8500g;

        @BindView(R.id.llayout_together_live)
        public LinearLayout mTogetherLiveLayout;

        public TogetherVH(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        public void g(List<SignRoomVo> list, View.OnClickListener onClickListener, int i2) {
            this.mTogetherLiveLayout.removeAllViews();
            SignRoomVo signRoomVo = list.get(i2);
            List<ContactDetailsVo.RoommatesBean> roommatesBeans = signRoomVo.getRoommatesBeans();
            int size = roommatesBeans.size();
            for (int i3 = 0; i3 < size; i3++) {
                TogetherLiveLayout togetherLiveLayout = new TogetherLiveLayout(this.mTogetherLiveLayout.getContext());
                togetherLiveLayout.setupIdTypeList(this.f8500g);
                togetherLiveLayout.setupList(list, roommatesBeans.get(i3), i2, onClickListener, i3, signRoomVo.isEdit());
                this.mTogetherLiveLayout.addView(togetherLiveLayout);
            }
        }

        public void h(List<IDTypeNameValueVo> list) {
            this.f8500g = list;
        }

        public void setRent(boolean z) {
            this.f8499f = z;
        }
    }

    public class TogetherVH_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public TogetherVH f8501b;

        @UiThread
        public TogetherVH_ViewBinding(TogetherVH togetherVH, View view) {
            this.f8501b = togetherVH;
            togetherVH.mTogetherLiveLayout = (LinearLayout) d.findRequiredViewAsType(view, R.id.llayout_together_live, "field 'mTogetherLiveLayout'", LinearLayout.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            TogetherVH togetherVH = this.f8501b;
            if (togetherVH == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f8501b = null;
            togetherVH.mTogetherLiveLayout = null;
        }
    }

    @Override // com.chinavisionary.core.app.adapter.BaseRecyclerAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        return ((SignRoomVo) this.f6460b.get(i2)).getType();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i2) {
        int itemViewType = viewHolder.getItemViewType();
        if (itemViewType == 1) {
            PayPriceVH payPriceVH = (PayPriceVH) viewHolder;
            payPriceVH.g((SignRoomVo) this.f6460b.get(i2));
            payPriceVH.mPayInfoView.setOnClickListener(this.f6461c);
            b(payPriceVH, i2);
            return;
        }
        if (itemViewType == 2) {
            PayModeVH payModeVH = (PayModeVH) viewHolder;
            payModeVH.g((SignRoomVo) this.f6460b.get(i2));
            b(payModeVH, i2);
            return;
        }
        if (itemViewType == 3) {
            ((TogetherVH) viewHolder).g(this.f6460b, this.f6461c, i2);
            return;
        }
        if (itemViewType == 4) {
            RentUserInfoVH rentUserInfoVH = (RentUserInfoVH) viewHolder;
            rentUserInfoVH.setRent(true);
            rentUserInfoVH.g(this.f6460b, this.f6461c, i2);
        } else if (itemViewType == 5) {
            RentUserInfoVH rentUserInfoVH2 = (RentUserInfoVH) viewHolder;
            rentUserInfoVH2.setRent(false);
            rentUserInfoVH2.g(this.f6460b, this.f6461c, i2);
        } else if (itemViewType != 34952) {
            SignRoomVH signRoomVH = (SignRoomVH) viewHolder;
            signRoomVH.g((SignRoomVo) this.f6460b.get(i2));
            signRoomVH.mRightTitleTv.setTag(Integer.valueOf(i2));
            signRoomVH.mRightTitleTv.setOnClickListener(this.f6461c);
            b(signRoomVH, i2);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        if (i2 == 1) {
            View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_pay_price_layout, viewGroup, false);
            PayPriceVH payPriceVH = new PayPriceVH(viewInflate);
            viewInflate.setTag(payPriceVH);
            return payPriceVH;
        }
        if (i2 == 2) {
            View viewInflate2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_pay, viewGroup, false);
            PayModeVH payModeVH = new PayModeVH(viewInflate2);
            viewInflate2.setTag(payModeVH);
            return payModeVH;
        }
        if (i2 == 3) {
            View viewInflate3 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_together_live_info, viewGroup, false);
            TogetherVH togetherVH = new TogetherVH(viewInflate3);
            togetherVH.h(this.n);
            viewInflate3.setTag(togetherVH);
            return togetherVH;
        }
        if (i2 == 4) {
            View viewInflate4 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_together_live_info, viewGroup, false);
            RentUserInfoVH rentUserInfoVH = new RentUserInfoVH(viewInflate4);
            rentUserInfoVH.setRent(true);
            viewInflate4.setTag(rentUserInfoVH);
            return rentUserInfoVH;
        }
        if (i2 == 5) {
            View viewInflate5 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_together_live_info, viewGroup, false);
            RentUserInfoVH rentUserInfoVH2 = new RentUserInfoVH(viewInflate5);
            rentUserInfoVH2.setRent(false);
            viewInflate5.setTag(rentUserInfoVH2);
            return rentUserInfoVH2;
        }
        if (i2 == 34952) {
            return new BaseRecyclerAdapter.EmptyViewHolder(d(viewGroup));
        }
        View viewInflate6 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_sign_room_layout, viewGroup, false);
        SignRoomVH signRoomVH = new SignRoomVH(viewInflate6);
        viewInflate6.setTag(signRoomVH);
        return signRoomVH;
    }

    public void setIdTypeList(List<IDTypeNameValueVo> list) {
        this.n = list;
    }
}
