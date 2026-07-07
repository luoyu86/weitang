package com.chinavisionary.microtang.room.fragment;

import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import b.c.d;
import butterknife.Unbinder;
import com.chinavisionary.core.weight.BaseRecyclerView;
import com.chinavisionary.microtang.R;

/* JADX INFO: loaded from: classes2.dex */
public class PreLookRoomFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public PreLookRoomFragment f8332b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f8333c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f8334d;

    public class a extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ PreLookRoomFragment f8335c;

        public a(PreLookRoomFragment preLookRoomFragment) {
            this.f8335c = preLookRoomFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f8335c.finishFragment(view);
        }
    }

    public class b extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ PreLookRoomFragment f8337c;

        public b(PreLookRoomFragment preLookRoomFragment) {
            this.f8337c = preLookRoomFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f8337c.submitClick(view);
        }
    }

    @UiThread
    public PreLookRoomFragment_ViewBinding(PreLookRoomFragment preLookRoomFragment, View view) {
        this.f8332b = preLookRoomFragment;
        preLookRoomFragment.mUserNameEdt = (EditText) d.findRequiredViewAsType(view, R.id.edt_user_name, "field 'mUserNameEdt'", EditText.class);
        preLookRoomFragment.mUserContactEdt = (EditText) d.findRequiredViewAsType(view, R.id.edt_user_contact, "field 'mUserContactEdt'", EditText.class);
        preLookRoomFragment.mRoomTimeSelTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_look_room_time_sel, "field 'mRoomTimeSelTv'", TextView.class);
        preLookRoomFragment.mLimitSizeTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_leaving_message_limit_size, "field 'mLimitSizeTv'", TextView.class);
        preLookRoomFragment.mLeavingMessageTv = (EditText) d.findRequiredViewAsType(view, R.id.edt_leaving_message, "field 'mLeavingMessageTv'", EditText.class);
        preLookRoomFragment.mRecyclerView = (BaseRecyclerView) d.findRequiredViewAsType(view, R.id.recycler_pre_time, "field 'mRecyclerView'", BaseRecyclerView.class);
        preLookRoomFragment.mRadioGroup = (RadioGroup) d.findRequiredViewAsType(view, R.id.radio_group, "field 'mRadioGroup'", RadioGroup.class);
        preLookRoomFragment.mContentBgView = d.findRequiredView(view, R.id.view_content_finish, "field 'mContentBgView'");
        View viewFindRequiredView = d.findRequiredView(view, R.id.tv_finish, "method 'finishFragment'");
        this.f8333c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(preLookRoomFragment));
        View viewFindRequiredView2 = d.findRequiredView(view, R.id.btn_pre_look_room, "method 'submitClick'");
        this.f8334d = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(preLookRoomFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        PreLookRoomFragment preLookRoomFragment = this.f8332b;
        if (preLookRoomFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f8332b = null;
        preLookRoomFragment.mUserNameEdt = null;
        preLookRoomFragment.mUserContactEdt = null;
        preLookRoomFragment.mRoomTimeSelTv = null;
        preLookRoomFragment.mLimitSizeTv = null;
        preLookRoomFragment.mLeavingMessageTv = null;
        preLookRoomFragment.mRecyclerView = null;
        preLookRoomFragment.mRadioGroup = null;
        preLookRoomFragment.mContentBgView = null;
        this.f8333c.setOnClickListener(null);
        this.f8333c = null;
        this.f8334d.setOnClickListener(null);
        this.f8334d = null;
    }
}
