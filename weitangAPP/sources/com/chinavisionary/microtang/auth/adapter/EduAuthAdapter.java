package com.chinavisionary.microtang.auth.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import b.c.d;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.chinavisionary.core.app.adapter.BaseRecyclerViewHolder;
import com.chinavisionary.core.app.base.LeftTitleToRightArrowAdapter;
import com.chinavisionary.core.app.config.bo.LeftTitleToRightArrowVo;
import com.chinavisionary.core.weight.CoreRoundedImageView;
import com.chinavisionary.framework.mobile.common.vo.ResourceVo;
import com.chinavisionary.microtang.R;

/* JADX INFO: loaded from: classes.dex */
public class EduAuthAdapter extends LeftTitleToRightArrowAdapter {

    public static class AlertTipVh extends BaseRecyclerViewHolder<LeftTitleToRightArrowVo> {

        @BindView(R.id.img_alert_tip)
        public ImageView mAlertTipMsgImg;

        @BindView(R.id.tv_alert_tip_msg)
        public TextView mAlertTipMsgTv;

        public AlertTipVh(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        public void setData(LeftTitleToRightArrowVo leftTitleToRightArrowVo) {
            this.mAlertTipMsgTv.setText(c(leftTitleToRightArrowVo.getTitle()));
        }
    }

    public class AlertTipVh_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public AlertTipVh f6818b;

        @UiThread
        public AlertTipVh_ViewBinding(AlertTipVh alertTipVh, View view) {
            this.f6818b = alertTipVh;
            alertTipVh.mAlertTipMsgImg = (ImageView) d.findRequiredViewAsType(view, R.id.img_alert_tip, "field 'mAlertTipMsgImg'", ImageView.class);
            alertTipVh.mAlertTipMsgTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_alert_tip_msg, "field 'mAlertTipMsgTv'", TextView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            AlertTipVh alertTipVh = this.f6818b;
            if (alertTipVh == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f6818b = null;
            alertTipVh.mAlertTipMsgImg = null;
            alertTipVh.mAlertTipMsgTv = null;
        }
    }

    public static class EduPhotoVh extends BaseRecyclerViewHolder<LeftTitleToRightArrowVo> {

        @BindView(R.id.img_edu_photo)
        public CoreRoundedImageView mEduPhotoImg;

        public EduPhotoVh(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        public void setData(LeftTitleToRightArrowVo leftTitleToRightArrowVo) {
            Object extObj = leftTitleToRightArrowVo.getExtObj();
            if (extObj instanceof ResourceVo) {
                this.mEduPhotoImg.loadImageToUrl(((ResourceVo) extObj).getUrl());
            }
        }
    }

    public class EduPhotoVh_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public EduPhotoVh f6819b;

        @UiThread
        public EduPhotoVh_ViewBinding(EduPhotoVh eduPhotoVh, View view) {
            this.f6819b = eduPhotoVh;
            eduPhotoVh.mEduPhotoImg = (CoreRoundedImageView) d.findRequiredViewAsType(view, R.id.img_edu_photo, "field 'mEduPhotoImg'", CoreRoundedImageView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            EduPhotoVh eduPhotoVh = this.f6819b;
            if (eduPhotoVh == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f6819b = null;
            eduPhotoVh.mEduPhotoImg = null;
        }
    }

    @Override // com.chinavisionary.core.app.base.LeftTitleToRightArrowAdapter
    public void q(RecyclerView.ViewHolder viewHolder, int i2) {
        int itemViewType = viewHolder.getItemViewType();
        if (itemViewType == 19) {
            v(viewHolder, i2);
        } else {
            if (itemViewType != 20) {
                return;
            }
            u(viewHolder, i2);
        }
    }

    @Override // com.chinavisionary.core.app.base.LeftTitleToRightArrowAdapter
    public RecyclerView.ViewHolder r(ViewGroup viewGroup, int i2) {
        return i2 != 19 ? i2 != 20 ? super.r(viewGroup, i2) : s(viewGroup) : t(viewGroup);
    }

    public final AlertTipVh s(ViewGroup viewGroup) {
        View viewI = i(viewGroup, R.layout.item_alert_tip);
        AlertTipVh alertTipVh = new AlertTipVh(viewI);
        viewI.setTag(alertTipVh);
        return alertTipVh;
    }

    public final EduPhotoVh t(ViewGroup viewGroup) {
        View viewI = i(viewGroup, R.layout.item_edu_auth);
        EduPhotoVh eduPhotoVh = new EduPhotoVh(viewI);
        a(eduPhotoVh);
        viewI.setTag(eduPhotoVh);
        return eduPhotoVh;
    }

    public final void u(RecyclerView.ViewHolder viewHolder, int i2) {
        ((AlertTipVh) viewHolder).setData((LeftTitleToRightArrowVo) this.f6460b.get(i2));
    }

    public final void v(RecyclerView.ViewHolder viewHolder, int i2) {
        ((EduPhotoVh) viewHolder).setData((LeftTitleToRightArrowVo) this.f6460b.get(i2));
    }
}
