package com.chinavisionary.microtang.msg.fragment;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import b.c.b;
import b.c.d;
import butterknife.Unbinder;
import com.chinavisionary.core.weight.CoreRoundedImageView;
import com.chinavisionary.microtang.R;

/* JADX INFO: loaded from: classes.dex */
public class MsgDetailsFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public MsgDetailsFragment f7950b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f7951c;

    public class a extends b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ MsgDetailsFragment f7952c;

        public a(MsgDetailsFragment msgDetailsFragment) {
            this.f7952c = msgDetailsFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7952c.backClick(view);
        }
    }

    @UiThread
    public MsgDetailsFragment_ViewBinding(MsgDetailsFragment msgDetailsFragment, View view) {
        this.f7950b = msgDetailsFragment;
        msgDetailsFragment.mTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title, "field 'mTitleTv'", TextView.class);
        msgDetailsFragment.mSplitLineTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title_split_line, "field 'mSplitLineTv'", TextView.class);
        msgDetailsFragment.mTitleMsgTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_msg_title, "field 'mTitleMsgTv'", TextView.class);
        msgDetailsFragment.mMsgContentTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_msg_content, "field 'mMsgContentTv'", TextView.class);
        msgDetailsFragment.mImageView = (CoreRoundedImageView) d.findRequiredViewAsType(view, R.id.img_msg_cover, "field 'mImageView'", CoreRoundedImageView.class);
        View viewFindRequiredView = d.findRequiredView(view, R.id.tv_back, "method 'backClick'");
        this.f7951c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(msgDetailsFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        MsgDetailsFragment msgDetailsFragment = this.f7950b;
        if (msgDetailsFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f7950b = null;
        msgDetailsFragment.mTitleTv = null;
        msgDetailsFragment.mSplitLineTv = null;
        msgDetailsFragment.mTitleMsgTv = null;
        msgDetailsFragment.mMsgContentTv = null;
        msgDetailsFragment.mImageView = null;
        this.f7951c.setOnClickListener(null);
        this.f7951c = null;
    }
}
