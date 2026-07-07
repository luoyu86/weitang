package com.chinavisionary.twlib.open;

import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import b.c.d;
import butterknife.Unbinder;
import com.chinavisionary.twlib.R;

/* JADX INFO: loaded from: classes2.dex */
public class OpenDoorActivity_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public OpenDoorActivity f8781b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f8782c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f8783d;

    public class a extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ OpenDoorActivity f8784c;

        public a(OpenDoorActivity openDoorActivity) {
            this.f8784c = openDoorActivity;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f8784c.retryOpenUnlockBtn(view);
        }
    }

    public class b extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ OpenDoorActivity f8786c;

        public b(OpenDoorActivity openDoorActivity) {
            this.f8786c = openDoorActivity;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f8786c.backClick();
        }
    }

    @UiThread
    public OpenDoorActivity_ViewBinding(OpenDoorActivity openDoorActivity) {
        this(openDoorActivity, openDoorActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        OpenDoorActivity openDoorActivity = this.f8781b;
        if (openDoorActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f8781b = null;
        openDoorActivity.mTitleTv = null;
        openDoorActivity.mRoomTitleTv = null;
        openDoorActivity.mBackImg = null;
        openDoorActivity.mTipMsgTv = null;
        openDoorActivity.mSplitLineTv = null;
        openDoorActivity.mBgImg = null;
        openDoorActivity.mTimerMsgTv = null;
        openDoorActivity.mRetryOpenUnlockBtn = null;
        openDoorActivity.mLLprogressBar = null;
        openDoorActivity.mFrameLayout = null;
        this.f8782c.setOnClickListener(null);
        this.f8782c = null;
        this.f8783d.setOnClickListener(null);
        this.f8783d = null;
    }

    @UiThread
    public OpenDoorActivity_ViewBinding(OpenDoorActivity openDoorActivity, View view) {
        this.f8781b = openDoorActivity;
        openDoorActivity.mTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title, "field 'mTitleTv'", TextView.class);
        openDoorActivity.mRoomTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_open_door_name, "field 'mRoomTitleTv'", TextView.class);
        openDoorActivity.mBackImg = (ImageView) d.findRequiredViewAsType(view, R.id.img_back, "field 'mBackImg'", ImageView.class);
        openDoorActivity.mTipMsgTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_tip, "field 'mTipMsgTv'", TextView.class);
        openDoorActivity.mSplitLineTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title_split_line, "field 'mSplitLineTv'", TextView.class);
        openDoorActivity.mBgImg = (ImageView) d.findRequiredViewAsType(view, R.id.img_ble_open_door_bg, "field 'mBgImg'", ImageView.class);
        openDoorActivity.mTimerMsgTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_timer_msg, "field 'mTimerMsgTv'", TextView.class);
        int i2 = R.id.btn_retry_open;
        View viewFindRequiredView = d.findRequiredView(view, i2, "field 'mRetryOpenUnlockBtn' and method 'retryOpenUnlockBtn'");
        openDoorActivity.mRetryOpenUnlockBtn = (Button) d.castView(viewFindRequiredView, i2, "field 'mRetryOpenUnlockBtn'", Button.class);
        this.f8782c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(openDoorActivity));
        openDoorActivity.mLLprogressBar = (LinearLayout) d.findRequiredViewAsType(view, R.id.dialog_loading_view, "field 'mLLprogressBar'", LinearLayout.class);
        openDoorActivity.mFrameLayout = (FrameLayout) d.findRequiredViewAsType(view, R.id.frame_layout, "field 'mFrameLayout'", FrameLayout.class);
        View viewFindRequiredView2 = d.findRequiredView(view, R.id.tv_back, "method 'backClick'");
        this.f8783d = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(openDoorActivity));
    }
}
