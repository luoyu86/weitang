package com.chinavisionary.microtang.clean.view;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import c.e.a.d.x;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.clean.vo.CleanVo;
import java.lang.ref.WeakReference;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class TimerTextView extends AppCompatTextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f6958a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Long f6959b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List<CleanVo> f6960c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f6961d;

    public class a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public WeakReference<TimerTextView> f6962a;

        public a(TimerTextView timerTextView) {
            this.f6962a = new WeakReference<>(timerTextView);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            TimerTextView timerTextView = this.f6962a.get();
            if (timerTextView != null) {
                timerTextView.updateMessage(message);
            }
        }

        public void recycler() {
            WeakReference<TimerTextView> weakReference = this.f6962a;
            if (weakReference != null) {
                weakReference.clear();
                this.f6962a = null;
                removeCallbacksAndMessages(null);
            }
        }
    }

    public TimerTextView(Context context) {
        super(context);
    }

    public final void a() {
        long jLongValue = (this.f6959b.longValue() % 60000) / 1000;
        long jLongValue2 = (this.f6959b.longValue() % 3600000) / 60000;
        setText(jLongValue2 + ":" + (jLongValue - (jLongValue2 * 60)));
    }

    public final void b() {
        if (this.f6958a == null) {
            this.f6958a = new a(this);
        }
        a aVar = this.f6958a;
        if (aVar != null) {
            aVar.sendMessageDelayed(aVar.obtainMessage(), 1000L);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f6959b != null) {
            b();
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a aVar = this.f6958a;
        if (aVar != null) {
            aVar.recycler();
            this.f6958a = null;
        }
    }

    public void setCleanVos(List<CleanVo> list) {
        this.f6960c = list;
    }

    public void setPosition(int i2) {
        this.f6961d = i2;
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        super.setText(x.appendStringToResId(R.string.placeholder_minute, charSequence.toString()), bufferType);
    }

    public void setTimer(Long l) {
        this.f6959b = l;
    }

    public void updateMessage(Message message) {
        Long l = this.f6959b;
        if (l != null) {
            this.f6959b = Long.valueOf(l.longValue() - 1000);
            b();
            a();
            List<CleanVo> list = this.f6960c;
            if (list != null) {
                list.get(this.f6961d).setPayDeadline(this.f6959b);
            }
        }
    }

    public TimerTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
