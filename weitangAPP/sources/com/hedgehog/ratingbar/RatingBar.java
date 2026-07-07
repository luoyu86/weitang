package com.hedgehog.ratingbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import java.math.BigDecimal;

/* JADX INFO: loaded from: classes2.dex */
public class RatingBar extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f9076a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f9077b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f9078c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f9079d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public b f9080e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f9081f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f9082g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f9083h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f9084i;
    public Drawable j;
    public Drawable k;
    public Drawable l;
    public int m;
    public boolean n;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (RatingBar.this.f9076a) {
                if (!RatingBar.this.f9077b) {
                    RatingBar.this.setStar(r0.indexOfChild(view) + 1.0f);
                    if (RatingBar.this.f9080e != null) {
                        RatingBar.this.f9080e.onRatingChange(RatingBar.this.indexOfChild(view) + 1.0f);
                        return;
                    }
                    return;
                }
                if (RatingBar.this.m % 2 == 0) {
                    RatingBar.this.setStar(r0.indexOfChild(view) + 1.0f);
                } else {
                    RatingBar.this.setStar(r0.indexOfChild(view) + 0.5f);
                }
                if (RatingBar.this.f9080e != null) {
                    if (RatingBar.this.m % 2 == 0) {
                        RatingBar.this.f9080e.onRatingChange(RatingBar.this.indexOfChild(view) + 1.0f);
                        RatingBar.d(RatingBar.this);
                    } else {
                        RatingBar.this.f9080e.onRatingChange(RatingBar.this.indexOfChild(view) + 0.5f);
                        RatingBar.d(RatingBar.this);
                    }
                }
            }
        }
    }

    public interface b {
        void onRatingChange(float f2);
    }

    public RatingBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.m = 1;
        this.n = true;
        setOrientation(0);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RatingBar);
        this.l = typedArrayObtainStyledAttributes.getDrawable(R.styleable.RatingBar_starHalf);
        this.j = typedArrayObtainStyledAttributes.getDrawable(R.styleable.RatingBar_starEmpty);
        this.k = typedArrayObtainStyledAttributes.getDrawable(R.styleable.RatingBar_starFill);
        this.f9081f = typedArrayObtainStyledAttributes.getDimension(R.styleable.RatingBar_starImageSize, 120.0f);
        this.f9082g = typedArrayObtainStyledAttributes.getDimension(R.styleable.RatingBar_starImageWidth, 60.0f);
        this.f9083h = typedArrayObtainStyledAttributes.getDimension(R.styleable.RatingBar_starImageHeight, 120.0f);
        this.f9084i = typedArrayObtainStyledAttributes.getDimension(R.styleable.RatingBar_starImagePadding, 15.0f);
        this.f9078c = typedArrayObtainStyledAttributes.getInteger(R.styleable.RatingBar_starCount, 5);
        this.f9079d = typedArrayObtainStyledAttributes.getInteger(R.styleable.RatingBar_starNum, 0);
        this.f9076a = typedArrayObtainStyledAttributes.getBoolean(R.styleable.RatingBar_clickable, true);
        this.f9077b = typedArrayObtainStyledAttributes.getBoolean(R.styleable.RatingBar_halfstart, false);
        for (int i2 = 0; i2 < this.f9079d; i2++) {
            addView(f(context, false));
        }
        for (int i3 = 0; i3 < this.f9078c; i3++) {
            ImageView imageViewF = f(context, this.n);
            imageViewF.setOnClickListener(new a());
            addView(imageViewF);
        }
    }

    public static /* synthetic */ int d(RatingBar ratingBar) {
        int i2 = ratingBar.m;
        ratingBar.m = i2 + 1;
        return i2;
    }

    public final ImageView f(Context context, boolean z) {
        ImageView imageView = new ImageView(context);
        imageView.setLayoutParams(new ViewGroup.LayoutParams(Math.round(this.f9082g), Math.round(this.f9083h)));
        imageView.setPadding(0, 0, Math.round(this.f9084i), 0);
        if (z) {
            imageView.setImageDrawable(this.j);
        } else {
            imageView.setImageDrawable(this.k);
        }
        return imageView;
    }

    public void halfStar(boolean z) {
        this.f9077b = z;
    }

    public void setImagePadding(float f2) {
        this.f9084i = f2;
    }

    public void setOnRatingChangeListener(b bVar) {
        this.f9080e = bVar;
    }

    public void setStar(float f2) {
        int i2 = (int) f2;
        float fFloatValue = new BigDecimal(Float.toString(f2)).subtract(new BigDecimal(Integer.toString(i2))).floatValue();
        int i3 = this.f9078c;
        float f3 = i2 > i3 ? i3 : i2;
        if (f3 < 0.0f) {
            f3 = 0.0f;
        }
        for (int i4 = 0; i4 < f3; i4++) {
            ((ImageView) getChildAt(i4)).setImageDrawable(this.k);
        }
        if (fFloatValue > 0.0f) {
            ((ImageView) getChildAt(i2)).setImageDrawable(this.l);
            int i5 = this.f9078c;
            while (true) {
                i5--;
                if (i5 < 1.0f + f3) {
                    return;
                } else {
                    ((ImageView) getChildAt(i5)).setImageDrawable(this.j);
                }
            }
        } else {
            int i6 = this.f9078c;
            while (true) {
                i6--;
                if (i6 < f3) {
                    return;
                } else {
                    ((ImageView) getChildAt(i6)).setImageDrawable(this.j);
                }
            }
        }
    }

    public void setStarCount(int i2) {
        this.f9078c = i2;
    }

    public void setStarEmptyDrawable(Drawable drawable) {
        this.j = drawable;
    }

    public void setStarFillDrawable(Drawable drawable) {
        this.k = drawable;
    }

    public void setStarHalfDrawable(Drawable drawable) {
        this.l = drawable;
    }

    public void setStarImageHeight(float f2) {
        this.f9083h = f2;
    }

    public void setStarImageSize(float f2) {
        this.f9081f = f2;
    }

    public void setStarImageWidth(float f2) {
        this.f9082g = f2;
    }

    public void setmClickable(boolean z) {
        this.f9076a = z;
    }
}
