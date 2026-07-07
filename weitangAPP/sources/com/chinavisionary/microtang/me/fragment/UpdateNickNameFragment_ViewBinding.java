package com.chinavisionary.microtang.me.fragment;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import b.c.b;
import b.c.d;
import butterknife.Unbinder;
import com.chinavisionary.microtang.R;

/* JADX INFO: loaded from: classes.dex */
public class UpdateNickNameFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public UpdateNickNameFragment f7698b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f7699c;

    public class a extends b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ UpdateNickNameFragment f7700c;

        public a(UpdateNickNameFragment updateNickNameFragment) {
            this.f7700c = updateNickNameFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7700c.backClick(view);
        }
    }

    @UiThread
    public UpdateNickNameFragment_ViewBinding(UpdateNickNameFragment updateNickNameFragment, View view) {
        this.f7698b = updateNickNameFragment;
        updateNickNameFragment.mTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title, "field 'mTitleTv'", TextView.class);
        updateNickNameFragment.mTitleRightTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title_right, "field 'mTitleRightTv'", TextView.class);
        updateNickNameFragment.mTitleSplitLineTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title_split_line, "field 'mTitleSplitLineTv'", TextView.class);
        updateNickNameFragment.mNickNameEdt = (EditText) d.findRequiredViewAsType(view, R.id.edt_nick_name, "field 'mNickNameEdt'", EditText.class);
        updateNickNameFragment.mDelEdtImg = (ImageView) d.findRequiredViewAsType(view, R.id.img_del_edt, "field 'mDelEdtImg'", ImageView.class);
        View viewFindRequiredView = d.findRequiredView(view, R.id.tv_back, "method 'backClick'");
        this.f7699c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(updateNickNameFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        UpdateNickNameFragment updateNickNameFragment = this.f7698b;
        if (updateNickNameFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f7698b = null;
        updateNickNameFragment.mTitleTv = null;
        updateNickNameFragment.mTitleRightTv = null;
        updateNickNameFragment.mTitleSplitLineTv = null;
        updateNickNameFragment.mNickNameEdt = null;
        updateNickNameFragment.mDelEdtImg = null;
        this.f7699c.setOnClickListener(null);
        this.f7699c = null;
    }
}
