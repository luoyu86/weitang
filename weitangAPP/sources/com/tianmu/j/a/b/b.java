package com.tianmu.j.a.b;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tianmu.c.f.t;

/* JADX INFO: loaded from: classes2.dex */
public class b extends LinearLayout implements com.tianmu.j.b.a.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f12241a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f12242b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.tianmu.j.b.a.b f12243c;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.setVisibility(8);
            b.this.f12243c.b(false);
        }
    }

    public b(Context context) {
        this(context, null);
    }

    @Override // com.tianmu.j.b.a.c
    public View a() {
        return this;
    }

    @Override // com.tianmu.j.b.a.c
    public void a(int i2, int i3) {
    }

    @Override // com.tianmu.j.b.a.c
    public void a(boolean z, Animation animation) {
    }

    @Override // com.tianmu.j.b.a.c
    public void b(int i2) {
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f12241a = motionEvent.getX();
            this.f12242b = motionEvent.getY();
            getParent().requestDisallowInterceptTouchEvent(true);
        } else if (action == 2) {
            float fAbs = Math.abs(motionEvent.getX() - this.f12241a);
            float fAbs2 = Math.abs(motionEvent.getY() - this.f12242b);
            if (fAbs > ViewConfiguration.get(getContext()).getScaledTouchSlop() || fAbs2 > ViewConfiguration.get(getContext()).getScaledTouchSlop()) {
                getParent().requestDisallowInterceptTouchEvent(false);
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public b(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        setVisibility(8);
        LayoutInflater.from(getContext()).inflate(t.f11515a, (ViewGroup) this, true);
        findViewById(t.f11516b).setOnClickListener(new a());
        setClickable(true);
    }

    @Override // com.tianmu.j.b.a.c
    public void a(@NonNull com.tianmu.j.b.a.b bVar) {
        this.f12243c = bVar;
    }

    @Override // com.tianmu.j.b.a.c
    public void a(int i2) {
        if (i2 == -1) {
            bringToFront();
            setVisibility(0);
        } else if (i2 == 0) {
            setVisibility(8);
        }
    }
}
