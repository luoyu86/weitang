package com.lzy.ninegrid;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class NineGridView extends ViewGroup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static b f9426a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f9427b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f9428c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f9429d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f9430e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f9431f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f9432g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f9433h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f9434i;
    public int j;
    public List<ImageView> k;
    public List<c.k.b.a> l;
    public c.k.b.b m;

    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f9435a;

        public a(int i2) {
            this.f9435a = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.k.b.b bVar = NineGridView.this.m;
            Context context = NineGridView.this.getContext();
            NineGridView nineGridView = NineGridView.this;
            bVar.b(context, nineGridView, this.f9435a, nineGridView.m.getImageInfo());
        }
    }

    public interface b {
        Bitmap getCacheImage(String str);

        void onDisplayImage(Context context, ImageView imageView, String str);
    }

    public NineGridView(Context context) {
        this(context, null);
    }

    public static b getImageLoader() {
        return f9426a;
    }

    public static void setImageLoader(b bVar) {
        f9426a = bVar;
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
        return this.f9429d;
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
            int i7 = this.f9432g;
            int paddingLeft = ((this.f9434i + this.f9430e) * (i6 % i7)) + getPaddingLeft();
            int paddingTop = ((this.j + this.f9430e) * (i6 / i7)) + getPaddingTop();
            imageView.layout(paddingLeft, paddingTop, this.f9434i + paddingLeft, this.j + paddingTop);
            b bVar = f9426a;
            if (bVar != null) {
                bVar.onDisplayImage(getContext(), imageView, this.l.get(i6).thumbnailUrl);
            }
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
                int i4 = this.f9427b;
                if (i4 <= paddingLeft) {
                    paddingLeft = i4;
                }
                this.f9434i = paddingLeft;
                int i5 = (int) (paddingLeft / this.f9428c);
                this.j = i5;
                if (i5 > i4) {
                    this.f9434i = (int) (paddingLeft * ((i4 * 1.0f) / i5));
                    this.j = i4;
                }
            } else {
                int i6 = (paddingLeft - (this.f9430e * 2)) / 3;
                this.j = i6;
                this.f9434i = i6;
            }
            int i7 = this.f9434i;
            int i8 = this.f9432g;
            size = (i7 * i8) + (this.f9430e * (i8 - 1)) + getPaddingLeft() + getPaddingRight();
            int i9 = this.j;
            int i10 = this.f9433h;
            paddingTop = (i9 * i10) + (this.f9430e * (i10 - 1)) + getPaddingTop() + getPaddingBottom();
        }
        setMeasuredDimension(size, paddingTop);
    }

    public void setAdapter(@NonNull c.k.b.b bVar) {
        this.m = bVar;
        List<c.k.b.a> imageInfo = bVar.getImageInfo();
        if (imageInfo == null || imageInfo.isEmpty()) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        int size = imageInfo.size();
        int i2 = this.f9429d;
        if (i2 > 0 && size > i2) {
            imageInfo = imageInfo.subList(0, i2);
            size = imageInfo.size();
        }
        this.f9433h = (size / 3) + (size % 3 == 0 ? 0 : 1);
        this.f9432g = 3;
        if (this.f9431f == 1 && size == 4) {
            this.f9433h = 2;
            this.f9432g = 2;
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
        int size3 = bVar.getImageInfo().size();
        int i4 = this.f9429d;
        if (size3 > i4) {
            View childAt = getChildAt(i4 - 1);
            if (childAt instanceof NineGridViewWrapper) {
                ((NineGridViewWrapper) childAt).setMoreNum(bVar.getImageInfo().size() - this.f9429d);
            }
        }
        this.l = imageInfo;
        requestLayout();
    }

    public void setGridSpacing(int i2) {
        this.f9430e = i2;
    }

    public void setMaxSize(int i2) {
        this.f9429d = i2;
    }

    public void setSingleImageRatio(float f2) {
        this.f9428c = f2;
    }

    public void setSingleImageSize(int i2) {
        this.f9427b = i2;
    }

    public NineGridView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NineGridView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f9427b = 250;
        this.f9428c = 1.0f;
        this.f9429d = 9;
        this.f9430e = 3;
        this.f9431f = 0;
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.f9430e = (int) TypedValue.applyDimension(1, this.f9430e, displayMetrics);
        this.f9427b = (int) TypedValue.applyDimension(1, this.f9427b, displayMetrics);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.NineGridView);
        this.f9430e = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.NineGridView_ngv_gridSpacing, this.f9430e);
        this.f9427b = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.NineGridView_ngv_singleImageSize, this.f9427b);
        this.f9428c = typedArrayObtainStyledAttributes.getFloat(R.styleable.NineGridView_ngv_singleImageRatio, this.f9428c);
        this.f9429d = typedArrayObtainStyledAttributes.getInt(R.styleable.NineGridView_ngv_maxSize, this.f9429d);
        this.f9431f = typedArrayObtainStyledAttributes.getInt(R.styleable.NineGridView_ngv_mode, this.f9431f);
        typedArrayObtainStyledAttributes.recycle();
        this.k = new ArrayList();
    }
}
