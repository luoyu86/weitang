package com.chinavisionary.microtang.alert;

import android.graphics.Bitmap;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import c.e.a.d.x;
import c.e.b.c.d.f;
import c.e.b.c.d.o;
import c.e.c.o0.i.a;
import com.chinavisionary.core.app.base.CoreBaseFragment;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseFragment;

/* JADX INFO: loaded from: classes.dex */
public class SharedAlertFragment extends BaseFragment<String> {
    public o B;
    public a C;

    @BindView(R.id.tv_alert_cancel)
    public TextView mCancelSharedTv;

    @BindView(R.id.img_wx)
    public ImageView mSharedWxImg;

    @BindView(R.id.img_wx_timeline)
    public ImageView mSharedWxTimelineImg;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: G1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void H1(int i2) {
        String string = i2 == 0 ? x.getString(R.string.title_wx_chart) : x.getString(R.string.title_wx_timeline);
        f data = this.B.getData();
        if (data != null && x.isNotNull(data.getCoverUrl())) {
            k1(data.getTitle(), string);
            Bitmap bitmapToUrl = this.C.getBitmapToUrl(data.getCoverUrl());
            if (bitmapToUrl != null) {
                this.B.setBitmap(Bitmap.createScaledBitmap(bitmapToUrl, 50, 50, true));
                try {
                    bitmapToUrl.recycle();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
        this.f6488f.obtainMessage(i2).sendToTarget();
    }

    public static SharedAlertFragment getInstance(o oVar) {
        SharedAlertFragment sharedAlertFragment = new SharedAlertFragment();
        sharedAlertFragment.B = oVar;
        return sharedAlertFragment;
    }

    public final void E1() {
        I1(0);
    }

    public final void F1() {
        I1(1);
    }

    public final void I1(final int i2) {
        z0(R.string.tip_shared);
        new Thread(new Runnable() { // from class: c.e.c.g.m
            @Override // java.lang.Runnable
            public final void run() {
                this.f1456a.H1(i2);
            }
        }).start();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
        int id = view.getId();
        if (id == R.id.img_wx) {
            E1();
        } else if (id == R.id.img_wx_timeline) {
            F1();
        } else {
            if (id != R.id.tv_alert_cancel) {
                return;
            }
            n();
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        this.f6488f = new CoreBaseFragment.c(this);
        this.C = new a(this.f6487e);
        this.mSharedWxImg.setOnClickListener(this.y);
        this.mCancelSharedTv.setOnClickListener(this.y);
        this.mSharedWxTimelineImg.setOnClickListener(this.y);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_alert_shared_layout;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void j0() {
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void z(Message message) {
        super.z(message);
        H();
        int i2 = message.what;
        if (i2 == 0) {
            this.C.shared(this.B, 0);
        } else if (i2 == 1) {
            this.C.shared(this.B, 1);
        }
        n();
    }
}
