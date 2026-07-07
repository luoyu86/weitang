package com.chinavisionary.microtang.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageButton;
import c.e.a.d.a0;
import c.e.a.d.x;
import com.chinavisionary.core.weight.CoreRoundedImageView;
import com.chinavisionary.microtang.R;
import java.math.BigDecimal;

/* JADX INFO: loaded from: classes2.dex */
public class SpecView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f8679a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AppCompatImageButton f8680b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public AppCompatImageButton f8681c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public CoreRoundedImageView f8682d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TextView f8683e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f8684f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f8685g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f8686h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f8687i;
    public boolean j;
    public boolean k;
    public View.OnClickListener l;
    public View.OnTouchListener m;
    public View.OnClickListener n;

    public class a implements View.OnTouchListener {
        public a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    public SpecView(Context context) {
        super(context);
        this.f8686h = 0;
        this.f8687i = -1;
        this.j = true;
        this.k = true;
        this.m = new a();
        this.n = new View.OnClickListener() { // from class: c.e.c.n0.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f1732a.f(view);
            }
        };
        d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void f(View view) {
        if (!this.k) {
            View.OnClickListener onClickListener = this.l;
            if (onClickListener != null) {
                onClickListener.onClick(view);
                return;
            }
            return;
        }
        int id = view.getId();
        if (id == R.id.img_add_spec || id == R.id.img_btn_add) {
            c();
        } else if (id == R.id.img_btn_reduce) {
            b();
        }
        if (this.l != null) {
            view.setTag(R.id.tv_spec_number, Integer.valueOf(this.f8684f));
            this.l.onClick(view);
        }
    }

    public final void a() {
        boolean z = this.j ? true : this.f8684f > 0;
        this.f8682d.setVisibility(z ? 8 : 0);
        this.f8679a.setVisibility(z ? 0 : 8);
        this.f8681c.setVisibility(z ? 0 : 8);
        this.f8680b.setVisibility(z ? 0 : 8);
    }

    public final void b() {
        int i2 = this.f8684f - 1;
        this.f8684f = i2;
        int i3 = this.f8686h;
        if (i2 <= i3) {
            this.f8684f = i3;
        }
        g();
    }

    public final void c() {
        int i2 = this.f8684f + 1;
        this.f8684f = i2;
        int i3 = this.f8685g;
        if (i2 > i3) {
            this.f8684f = i3;
            a0.showToast(getContext(), "最多只能购买:" + this.f8685g + "份");
        }
        g();
    }

    public final void d() {
        View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.item_spec_add_reduce_layout, (ViewGroup) this, false);
        this.f8679a = (TextView) viewInflate.findViewById(R.id.tv_spec_number);
        this.f8680b = (AppCompatImageButton) viewInflate.findViewById(R.id.img_btn_add);
        this.f8681c = (AppCompatImageButton) viewInflate.findViewById(R.id.img_btn_reduce);
        this.f8682d = (CoreRoundedImageView) viewInflate.findViewById(R.id.img_add_spec);
        addView(viewInflate);
        setOnTouchListener(this.m);
    }

    public final void g() {
        a();
        TextView textView = this.f8679a;
        int i2 = this.f8684f;
        if (i2 <= this.f8686h) {
            i2 = 1;
        }
        textView.setText(String.valueOf(i2));
        TextView textView2 = this.f8683e;
        if (textView2 != null) {
            this.f8683e.setText(x.getString(R.string.rmb_placeholder, x.bigDecimalMultiplyToBigDecimal((BigDecimal) textView2.getTag(), new BigDecimal(this.f8684f))));
        }
    }

    public void setClickSpec(boolean z) {
        this.k = z;
    }

    public void setIsGoneAddSpecImgView(boolean z) {
        this.j = z;
    }

    public void setMinSelectNumber(int i2) {
        this.f8686h = i2;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.l = onClickListener;
        this.f8680b.setOnClickListener(null);
        this.f8681c.setOnClickListener(null);
        this.f8682d.setOnClickListener(null);
        this.f8680b.setOnClickListener(this.n);
        this.f8681c.setOnClickListener(this.n);
        this.f8682d.setOnClickListener(this.n);
    }

    public void setSpecCountPriceTv(TextView textView) {
        this.f8683e = textView;
    }

    public void setupData(int i2, int i3, int i4) {
        this.f8687i = i2;
        this.f8685g = i4;
        this.f8680b.setTag(Integer.valueOf(i2));
        this.f8682d.setTag(Integer.valueOf(i2));
        this.f8681c.setTag(Integer.valueOf(i2));
        setupSpecNumber(i3);
        a();
    }

    public void setupIndex(int i2) {
        AppCompatImageButton appCompatImageButton = this.f8680b;
        if (appCompatImageButton == null || this.f8681c == null) {
            return;
        }
        appCompatImageButton.setTag(appCompatImageButton.getId(), Integer.valueOf(i2));
        CoreRoundedImageView coreRoundedImageView = this.f8682d;
        coreRoundedImageView.setTag(coreRoundedImageView.getId(), Integer.valueOf(i2));
        AppCompatImageButton appCompatImageButton2 = this.f8681c;
        appCompatImageButton2.setTag(appCompatImageButton2.getId(), Integer.valueOf(i2));
    }

    public void setupSpecNumber(int i2) {
        this.f8684f = i2;
        this.f8680b.setTag(R.id.tv_spec_number, Integer.valueOf(i2));
        this.f8682d.setTag(R.id.tv_spec_number, Integer.valueOf(i2));
        this.f8681c.setTag(R.id.tv_spec_number, Integer.valueOf(i2));
        this.f8679a.setText(String.valueOf(i2));
    }

    public SpecView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8686h = 0;
        this.f8687i = -1;
        this.j = true;
        this.k = true;
        this.m = new a();
        this.n = new View.OnClickListener() { // from class: c.e.c.n0.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f1732a.f(view);
            }
        };
        d();
    }

    public SpecView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f8686h = 0;
        this.f8687i = -1;
        this.j = true;
        this.k = true;
        this.m = new a();
        this.n = new View.OnClickListener() { // from class: c.e.c.n0.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f1732a.f(view);
            }
        };
        d();
    }
}
