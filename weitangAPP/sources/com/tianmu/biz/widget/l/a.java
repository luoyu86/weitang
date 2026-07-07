package com.tianmu.biz.widget.l;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tianmu.TianmuSDK;
import com.tianmu.biz.utils.i0;
import com.tianmu.biz.utils.t0;
import com.tianmu.biz.widget.roundimage.RoundImageView;
import com.tianmu.c.f.d1;
import com.tianmu.c.f.x;
import com.tianmu.checkapk.widget.NoticeAdContainer;

/* JADX INFO: loaded from: classes2.dex */
public class a extends Dialog {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static String f11065g = "KEY_DO_NOT_REMIND";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private NoticeAdContainer f11066a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private RoundImageView f11067b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private TextView f11068c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private TextView f11069d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ImageView f11070e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private com.tianmu.d.b.a f11071f;

    /* JADX INFO: renamed from: com.tianmu.biz.widget.l.a$a, reason: collision with other inner class name */
    public class ViewOnClickListenerC0194a implements View.OnClickListener {
        public ViewOnClickListenerC0194a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            i0.a().a(a.f11065g, true);
            a.this.b();
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f11071f != null) {
                a.this.f11071f.a();
            }
            a.this.a();
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.b();
        }
    }

    public class d implements com.tianmu.d.b.a {
        public d() {
        }

        @Override // com.tianmu.d.b.a
        public void a() {
        }

        @Override // com.tianmu.d.b.a
        public void b() {
            if (a.this.f11071f != null) {
                a.this.f11071f.b();
            }
            a.this.a();
        }

        @Override // com.tianmu.d.b.a
        public void c() {
            a.this.b();
        }
    }

    public a(@NonNull Context context) {
        super(context, d1.f11318b);
        setContentView(x.f11533a);
        d();
        this.f11066a = (NoticeAdContainer) findViewById(x.f11534b);
        RoundImageView roundImageView = (RoundImageView) findViewById(x.f11535c);
        this.f11067b = roundImageView;
        roundImageView.a(10);
        this.f11068c = (TextView) findViewById(x.f11537e);
        this.f11069d = (TextView) findViewById(x.f11538f);
        this.f11070e = (ImageView) findViewById(x.f11539g);
        setCancelable(true);
        setCanceledOnTouchOutside(false);
        c();
    }

    private void c() {
        this.f11068c.setOnClickListener(new ViewOnClickListenerC0194a());
        this.f11069d.setOnClickListener(new b());
        this.f11070e.setOnClickListener(new c());
        this.f11066a.a(new d());
    }

    private void d() {
        try {
            Window window = getWindow();
            if (window != null) {
                window.setFlags(8, 8);
                window.setFlags(32, 32);
                window.setFlags(262144, 262144);
                int iD = (int) t0.d(getContext());
                window.setGravity(48);
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.width = -1;
                attributes.height = -2;
                if (iD >= 80) {
                    iD = 0;
                }
                attributes.y = iD;
                attributes.dimAmount = 0.0f;
                window.setWindowAnimations(d1.f11320d);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        NoticeAdContainer noticeAdContainer = this.f11066a;
        if (noticeAdContainer != null && noticeAdContainer.a() != null) {
            this.f11066a.a().c();
        }
        a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        com.tianmu.d.b.a aVar = this.f11071f;
        if (aVar != null) {
            aVar.c();
        }
        a();
    }

    public void a(com.tianmu.d.b.a aVar) {
        this.f11071f = aVar;
    }

    public void a(String str) {
        if (this.f11067b == null || TextUtils.isEmpty(str)) {
            return;
        }
        TianmuSDK.getInstance().getImageLoader().loadImage(getContext(), str, this.f11067b);
    }

    public void a() {
        NoticeAdContainer noticeAdContainer = this.f11066a;
        if (noticeAdContainer != null) {
            noticeAdContainer.b();
            this.f11066a = null;
        }
        dismiss();
    }
}
