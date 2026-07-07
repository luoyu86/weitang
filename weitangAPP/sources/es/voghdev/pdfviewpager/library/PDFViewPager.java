package es.voghdev.pdfviewpager.library;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;
import es.voghdev.pdfviewpager.library.adapter.PDFPagerAdapter;

/* JADX INFO: loaded from: classes2.dex */
public class PDFViewPager extends ViewPager {
    public Context context;

    public PDFViewPager(Context context, String str) {
        super(context);
        this.context = context;
        init(str);
    }

    public void init(String str) {
        initAdapter(this.context, str);
    }

    public void initAdapter(Context context, String str) {
        setAdapter(new PDFPagerAdapter.Builder(context).setPdfPath(str).setOffScreenSize(getOffscreenPageLimit()).create());
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        try {
            return super.onInterceptTouchEvent(motionEvent);
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public void init(AttributeSet attributeSet) {
        if (isInEditMode()) {
            setBackgroundResource(R.drawable.flaticon_pdf_dummy);
            return;
        }
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = this.context.obtainStyledAttributes(attributeSet, R.styleable.PDFViewPager);
            String string = typedArrayObtainStyledAttributes.getString(R.styleable.PDFViewPager_assetFileName);
            if (string != null && string.length() > 0) {
                initAdapter(this.context, string);
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public PDFViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        init(attributeSet);
    }
}
