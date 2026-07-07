package com.tianmu.biz.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tianmu.R;
import com.tianmu.TianmuSDK;
import com.tianmu.biz.widget.roundimage.RoundedImageView;
import com.tianmu.c.f.k0;
import com.tianmu.config.TianmuImageLoader;
import com.tianmu.utils.TianmuDisplayUtil;

/* JADX INFO: loaded from: classes2.dex */
public class h extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private View f11015a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private TextView f11016b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private TextView f11017c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private RoundedImageView f11018d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private TextView f11019e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private TextView f11020f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private LinearLayout f11021g;

    public class a implements View.OnClickListener {
        public a(h hVar) {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    public h(@NonNull Context context, String str, String str2, String str3, String str4, com.tianmu.c.l.a aVar, com.tianmu.c.l.a aVar2, com.tianmu.c.l.a aVar3) {
        super(context);
        a();
        a(aVar, aVar2, aVar3);
        a(str, str2, str3, str4);
    }

    private void a() {
        View viewInflate = ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(k0.f11408a, (ViewGroup) this, false);
        this.f11015a = viewInflate;
        this.f11021g = (LinearLayout) viewInflate.findViewById(k0.k);
        this.f11018d = (RoundedImageView) this.f11015a.findViewById(k0.f11409b);
        this.f11016b = (TextView) this.f11015a.findViewById(k0.f11410c);
        this.f11017c = (TextView) this.f11015a.findViewById(k0.f11411d);
        this.f11019e = (TextView) this.f11015a.findViewById(k0.f11412e);
        this.f11020f = (TextView) this.f11015a.findViewById(k0.f11414g);
        addView(this.f11015a);
    }

    private void a(com.tianmu.c.l.a aVar, com.tianmu.c.l.a aVar2, com.tianmu.c.l.a aVar3) {
        this.f11021g.setOnClickListener(new a(this));
        findViewById(k0.f11415h).setOnClickListener(aVar3);
        findViewById(k0.f11416i).setOnClickListener(aVar3);
        findViewById(k0.f11412e).setOnClickListener(aVar2);
        findViewById(k0.j).setOnClickListener(aVar);
    }

    private void a(String str, String str2, String str3, String str4) {
        RoundedImageView roundedImageView;
        this.f11016b.setText(str2);
        this.f11017c.setText(str3);
        this.f11019e.setText(str4);
        TianmuImageLoader imageLoader = TianmuSDK.getInstance().getImageLoader();
        if (imageLoader == null || str == null || (roundedImageView = this.f11018d) == null) {
            return;
        }
        roundedImageView.a(TianmuDisplayUtil.dp2px(8));
        imageLoader.loadImage(this.f11018d.getContext(), str, this.f11018d);
    }

    public void a(long j) {
        TextView textView = this.f11020f;
        if (textView != null) {
            if (j == 0) {
                textView.setText(R.string.tianmu_reward_achieve);
                return;
            }
            textView.setVisibility(0);
            this.f11020f.setText(getContext().getResources().getString(R.string.tianmu_reward_achieve_count_down).replace("%1$", String.valueOf(j)));
        }
    }
}
