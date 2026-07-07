package com.tianmu.ad.activity;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ImageView;
import com.tianmu.c.f.v;
import com.tianmu.c.l.a;

/* JADX INFO: loaded from: classes2.dex */
public class FullScreenVodActivity extends RewardVodActivity {
    private Handler R = new Handler(Looper.getMainLooper());
    private boolean S = false;
    private ImageView T;

    private void g() {
        Handler handler = this.R;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.R = null;
        }
    }

    private void h() {
        Handler handler;
        if (this.f10582c <= 0) {
            a(0);
        } else {
            if (this.s || this.S || (handler = this.R) == null) {
                return;
            }
            this.S = true;
            handler.postDelayed(new Runnable() { // from class: com.tianmu.ad.activity.FullScreenVodActivity.2
                @Override // java.lang.Runnable
                public void run() {
                    FullScreenVodActivity.this.a(0);
                }
            }, Math.max(this.f10582c * 1000, 1000));
        }
    }

    @Override // com.tianmu.ad.activity.RewardVodActivity
    public void c() {
        super.c();
        ImageView imageView = (ImageView) findViewById(v.f11524a);
        this.T = imageView;
        imageView.setOnClickListener(new a() { // from class: com.tianmu.ad.activity.FullScreenVodActivity.1
            @Override // com.tianmu.c.l.a
            public void onSingleClick(View view) {
                FullScreenVodActivity fullScreenVodActivity = FullScreenVodActivity.this;
                if (fullScreenVodActivity.t) {
                    fullScreenVodActivity.f();
                } else {
                    fullScreenVodActivity.e();
                }
            }
        });
    }

    @Override // com.tianmu.ad.activity.RewardVodActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        g();
        super.onDestroy();
    }

    @Override // com.tianmu.ad.activity.RewardVodActivity, com.tianmu.biz.widget.a.InterfaceC0188a
    public void onVideoPrepared(long j) {
        super.onVideoPrepared(j);
        h();
    }

    @Override // com.tianmu.ad.activity.RewardVodActivity
    public synchronized void a(boolean z) {
        a(8);
        g();
        super.a(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2) {
        ImageView imageView = this.T;
        if (imageView != null) {
            imageView.setVisibility(i2);
        }
    }
}
