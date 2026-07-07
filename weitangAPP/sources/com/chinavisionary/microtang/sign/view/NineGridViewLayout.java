package com.chinavisionary.microtang.sign.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import c.e.c.j0.d.c;
import com.lzy.ninegrid.NineGridView;
import com.lzy.ninegrid.NineGridViewWrapper;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class NineGridViewLayout extends ViewGroup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static NineGridView.b f8580a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f8581b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f8582c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f8583d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f8584e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f8585f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f8586g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f8587h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f8588i;
    public int j;
    public List<ImageView> k;
    public List<c.k.b.a> l;
    public c m;

    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f8589a;

        public a(int i2) {
            this.f8589a = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c cVar = NineGridViewLayout.this.m;
            Context context = NineGridViewLayout.this.getContext();
            NineGridViewLayout nineGridViewLayout = NineGridViewLayout.this;
            cVar.b(context, nineGridViewLayout, this.f8589a, nineGridViewLayout.m.getImageInfo());
        }
    }

    public NineGridViewLayout(Context context) {
        this(context, null);
    }

    public static NineGridView.b getImageLoader() {
        return f8580a;
    }

    public static void setImageLoader(NineGridView.b bVar) {
        f8580a = bVar;
    }

    public final ImageView b(int i2) {
        if (i2 < this.k.size()) {
            return this.k.get(i2);
        }
        ImageView imageViewA = this.m.a(getContext());
        imageViewA.setOnClickListener(new a(i2));
        this.k.add(imageViewA);
        return imageViewA;
    }

    public int getMaxSize() {
        return this.f8583d;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        List<c.k.b.a> list = this.l;
        if (list == null) {
            return;
        }
        int size = list.size();
        for (int i6 = 0; i6 < size; i6++) {
            ImageView imageView = (ImageView) getChildAt(i6);
            NineGridView.b bVar = f8580a;
            if (bVar != null) {
                bVar.onDisplayImage(getContext(), imageView, this.l.get(i6).thumbnailUrl);
            }
            int i7 = this.f8586g;
            int paddingLeft = ((this.f8588i + this.f8584e) * (i6 % i7)) + getPaddingLeft();
            int paddingTop = ((this.j + this.f8584e) * (i6 / i7)) + getPaddingTop();
            imageView.layout(paddingLeft, paddingTop, this.f8588i + paddingLeft, this.j + paddingTop);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        int paddingTop;
        super.onMeasure(i2, i3);
        int size = View.MeasureSpec.getSize(i2);
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        List<c.k.b.a> list = this.l;
        if (list == null || list.size() <= 0) {
            paddingTop = 0;
        } else {
            if (this.l.size() == 1) {
                int i4 = this.f8581b;
                if (i4 <= paddingLeft) {
                    paddingLeft = i4;
                }
                this.f8588i = paddingLeft;
                int i5 = (int) (paddingLeft / this.f8582c);
                this.j = i5;
                if (i5 > i4) {
                    this.f8588i = (int) (paddingLeft * ((i4 * 1.0f) / i5));
                    this.j = i4;
                }
            } else {
                int i6 = (paddingLeft - (this.f8584e * 2)) / 3;
                this.j = i6;
                this.f8588i = i6;
            }
            int i7 = this.f8588i;
            int i8 = this.f8586g;
            size = (i7 * i8) + (this.f8584e * (i8 - 1)) + getPaddingLeft() + getPaddingRight();
            int i9 = this.j;
            int i10 = this.f8587h;
            paddingTop = (i9 * i10) + (this.f8584e * (i10 - 1)) + getPaddingTop() + getPaddingBottom();
        }
        setMeasuredDimension(size, paddingTop);
    }

    public void setAdapter(@NonNull c cVar) {
        this.m = cVar;
        removeAllViews();
        List<c.k.b.a> imageInfo = cVar.getImageInfo();
        if (imageInfo == null || imageInfo.isEmpty()) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        int size = imageInfo.size();
        int i2 = this.f8583d;
        if (i2 > 0 && size > i2) {
            imageInfo = imageInfo.subList(0, i2);
            size = imageInfo.size();
        }
        this.f8587h = (size / 3) + (size % 3 == 0 ? 0 : 1);
        this.f8586g = 3;
        if (this.f8585f == 1 && size == 4) {
            this.f8587h = 2;
            this.f8586g = 2;
        }
        List<c.k.b.a> list = this.l;
        if (list == null) {
            for (int i3 = 0; i3 < size; i3++) {
                ImageView imageViewB = b(i3);
                if (imageViewB == null) {
                    return;
                }
                addView(imageViewB, generateDefaultLayoutParams());
            }
        } else {
            int size2 = list.size();
            if (size2 > size) {
                removeViews(size, size2 - size);
            } else if (size2 < size) {
                while (size2 < size) {
                    ImageView imageViewB2 = b(size2);
                    if (imageViewB2 == null) {
                        return;
                    }
                    addView(imageViewB2, generateDefaultLayoutParams());
                    size2++;
                }
            }
        }
        int size3 = cVar.getImageInfo().size();
        int i4 = this.f8583d;
        if (size3 > i4) {
            View childAt = getChildAt(i4 - 1);
            if (childAt instanceof NineGridViewWrapper) {
                ((NineGridViewWrapper) childAt).setMoreNum(cVar.getImageInfo().size() - this.f8583d);
            }
        }
        this.l = imageInfo;
        requestLayout();
    }

    public void setGridSpacing(int i2) {
        this.f8584e = i2;
    }

    public void setMaxSize(int i2) {
        this.f8583d = i2;
    }

    public void setSingleImageRatio(float f2) {
        this.f8582c = f2;
    }

    public void setSingleImageSize(int i2) {
        this.f8581b = i2;
    }

    public NineGridViewLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NineGridViewLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f8581b = 70;
        this.f8582c = 1.0f;
        this.f8583d = 9;
        this.f8584e = 3;
        this.f8585f = 0;
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.f8584e = (int) TypedValue.applyDimension(1, this.f8584e, displayMetrics);
        int iApplyDimension = (int) TypedValue.applyDimension(1, this.f8581b, displayMetrics);
        this.f8581b = iApplyDimension;
        this.f8584e = this.f8584e;
        this.f8581b = iApplyDimension;
        this.f8582c = this.f8582c;
        this.f8583d = this.f8583d;
        this.f8585f = this.f8585f;
        this.k = new ArrayList();
    }
}
