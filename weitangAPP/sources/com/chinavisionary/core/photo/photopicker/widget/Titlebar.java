package com.chinavisionary.core.photo.photopicker.widget;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.e.a.b.a.d;
import c.e.a.b.a.i.c;
import com.chinavisionary.core.R;

/* JADX INFO: loaded from: classes.dex */
public class Titlebar extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RelativeLayout f6611a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f6612b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ImageView f6613c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f6614d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TextView f6615e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ImageView f6616f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View.OnClickListener f6617g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View.OnClickListener f6618h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Activity f6619i;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Titlebar.this.f6619i.finish();
        }
    }

    public class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f6621a;

        public b(Activity activity) {
            this.f6621a = activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f6621a.finish();
        }
    }

    public Titlebar(Context context) {
        this(context, null);
    }

    public final void b(Context context, AttributeSet attributeSet, int i2) throws Throwable {
        TypedArray typedArrayObtainStyledAttributes;
        TypedArray typedArray = null;
        try {
            typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.PickerTitleBar);
        } catch (Throwable th) {
            th = th;
        }
        try {
            String string = typedArrayObtainStyledAttributes.getString(R.styleable.PickerTitleBar_mtb_leftTxt);
            String string2 = typedArrayObtainStyledAttributes.getString(R.styleable.PickerTitleBar_mtb_title);
            String string3 = typedArrayObtainStyledAttributes.getString(R.styleable.PickerTitleBar_mtb_rightTxt);
            Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(R.styleable.PickerTitleBar_mtb_left_icon);
            Drawable drawable2 = typedArrayObtainStyledAttributes.getDrawable(R.styleable.PickerTitleBar_mtb_right_icon);
            setLeft(drawable, string, null);
            setTitle(string2);
            setRight(drawable2, string3, null);
            typedArrayObtainStyledAttributes.recycle();
        } catch (Throwable th2) {
            th = th2;
            typedArray = typedArrayObtainStyledAttributes;
            if (typedArray != null) {
                typedArray.recycle();
            }
            throw th;
        }
    }

    public final void c(Context context, AttributeSet attributeSet, int i2) {
        if (context instanceof Activity) {
            this.f6617g = new b((Activity) context);
        }
    }

    public final void d(Context context) {
        RelativeLayout relativeLayout = (RelativeLayout) View.inflate(context, R.layout.__picker_view_titlebar, null);
        this.f6611a = relativeLayout;
        this.f6613c = (ImageView) relativeLayout.findViewById(R.id.iv_left);
        this.f6612b = (TextView) this.f6611a.findViewById(R.id.tv_left);
        this.f6614d = (TextView) this.f6611a.findViewById(R.id.tv_title);
        this.f6616f = (ImageView) this.f6611a.findViewById(R.id.iv_right);
        this.f6615e = (TextView) this.f6611a.findViewById(R.id.tv_right);
        addView(this.f6611a);
    }

    public final void e() {
        d config = c.getHelper().getConfig();
        if (config != null) {
            this.f6613c.setImageResource(config.getBackImgRes());
            this.f6612b.setTextColor(config.getFinishTextColor());
            this.f6612b.setTextSize(1, config.getFinishTextSize());
            this.f6614d.setTextColor(config.getTitleColor());
            this.f6614d.setTextSize(1, config.getTitleSize());
            this.f6615e.setTextColor(config.getFinishTextColor());
            this.f6615e.setTextSize(1, config.getFinishTextSize());
            if (config.getTitleBarColor() != Integer.MAX_VALUE) {
                setBackgroundColor(config.getTitleBarColor());
            }
            this.f6616f.setImageResource(config.getDeleteImgRes());
        }
    }

    public ImageView getIvLeft() {
        return this.f6613c;
    }

    public ImageView getIvRight() {
        return this.f6616f;
    }

    public TextView getTvLeft() {
        return this.f6612b;
    }

    public TextView getTvRight() {
        return this.f6615e;
    }

    public TextView getTvTitle() {
        return this.f6614d;
    }

    public void init(Activity activity) {
        this.f6619i = activity;
        a aVar = new a();
        this.f6617g = aVar;
        this.f6613c.setOnClickListener(aVar);
    }

    public void setLeft(Drawable drawable, String str, View.OnClickListener onClickListener) {
        if (drawable != null) {
            this.f6613c.setVisibility(0);
            this.f6613c.setImageDrawable(drawable);
            this.f6612b.setVisibility(8);
        } else if (!TextUtils.isEmpty(str)) {
            this.f6612b.setVisibility(0);
            this.f6612b.setText(str);
            this.f6613c.setVisibility(8);
        }
        if (onClickListener != null) {
            this.f6617g = onClickListener;
        }
    }

    public void setLeftOnclickListener(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.f6617g = onClickListener;
            this.f6613c.setOnClickListener(onClickListener);
            this.f6612b.setOnClickListener(this.f6617g);
        }
    }

    public void setRight(Drawable drawable, String str, View.OnClickListener onClickListener) {
        if (!TextUtils.isEmpty(str)) {
            this.f6615e.setVisibility(0);
            this.f6615e.setText(str);
            this.f6616f.setVisibility(8);
            if (onClickListener != null) {
                this.f6618h = onClickListener;
                this.f6615e.setOnClickListener(onClickListener);
            }
        } else if (drawable != null) {
            this.f6616f.setVisibility(0);
            this.f6615e.setVisibility(8);
            this.f6616f.setImageDrawable(drawable);
            if (onClickListener != null) {
                this.f6618h = onClickListener;
                this.f6616f.setOnClickListener(onClickListener);
            }
        }
        if (onClickListener != null) {
            this.f6618h = onClickListener;
            this.f6616f.setOnClickListener(onClickListener);
        }
    }

    public void setRightOnclickListener(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.f6618h = onClickListener;
            this.f6616f.setOnClickListener(onClickListener);
            this.f6615e.setOnClickListener(this.f6618h);
        }
    }

    public void setTitle(String str) {
        this.f6614d.setText(str);
        if (TextUtils.isEmpty(str)) {
            this.f6614d.setVisibility(8);
        } else {
            this.f6614d.setVisibility(0);
        }
    }

    public Titlebar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.view.View
    public RelativeLayout getRootView() {
        return this.f6611a;
    }

    public Titlebar(Context context, AttributeSet attributeSet, int i2) throws Throwable {
        super(context, attributeSet, i2);
        d(context);
        b(context, attributeSet, i2);
        c(context, attributeSet, i2);
        e();
    }

    @TargetApi(21)
    public Titlebar(Context context, AttributeSet attributeSet, int i2, int i3) {
        this(context, attributeSet, i2);
    }
}
