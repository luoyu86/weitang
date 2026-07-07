package com.tianmu.biz.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tianmu.c.f.p0;

/* JADX INFO: loaded from: classes2.dex */
public class i extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private View f11022a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private TextView f11023b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ImageView f11024c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private b f11025d;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (i.this.f11025d != null) {
                i.this.f11025d.close();
            }
        }
    }

    public interface b {
        void close();
    }

    public i(@NonNull Context context) {
        super(context);
        b();
        c();
    }

    private void b() {
        View viewInflate = ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(p0.f11476a, (ViewGroup) this, true);
        this.f11022a = viewInflate;
        this.f11023b = (TextView) this.f11022a.findViewById(p0.f11478c);
        this.f11024c = (ImageView) this.f11022a.findViewById(p0.f11479d);
    }

    private void c() {
        this.f11024c.setOnClickListener(new a());
    }

    public void a(b bVar) {
        this.f11025d = bVar;
    }

    public void a(int i2) {
        TextView textView = this.f11023b;
        if (textView != null) {
            textView.setVisibility(0);
            this.f11023b.setText(i2 + " S");
        }
    }

    public void a() {
        this.f11025d = null;
    }
}
