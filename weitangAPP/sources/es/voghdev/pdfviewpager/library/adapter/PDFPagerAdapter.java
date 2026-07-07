package es.voghdev.pdfviewpager.library.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.pdf.PdfRenderer;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.ViewPager;
import c.g.a.a.a;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import es.voghdev.pdfviewpager.library.R;
import es.voghdev.pdfviewpager.library.util.EmptyClickListener;

/* JADX INFO: loaded from: classes2.dex */
public class PDFPagerAdapter extends BasePDFPagerAdapter {
    private static final float DEFAULT_SCALE = 1.0f;
    public View.OnClickListener pageClickListener;
    public PdfScale scale;

    public static class Builder {
        public Context context;
        public String pdfPath = "";
        public float scale = 1.0f;
        public float centerX = 0.0f;
        public float centerY = 0.0f;
        public int offScreenSize = 1;
        public float renderQuality = 2.0f;
        public View.OnClickListener pageClickListener = new EmptyClickListener();

        public Builder(Context context) {
            this.context = context;
        }

        public PDFPagerAdapter create() {
            PDFPagerAdapter pDFPagerAdapter = new PDFPagerAdapter(this.context, this.pdfPath);
            pDFPagerAdapter.scale.setScale(this.scale);
            pDFPagerAdapter.scale.setCenterX(this.centerX);
            pDFPagerAdapter.scale.setCenterY(this.centerY);
            pDFPagerAdapter.offScreenSize = this.offScreenSize;
            pDFPagerAdapter.renderQuality = this.renderQuality;
            pDFPagerAdapter.pageClickListener = this.pageClickListener;
            return pDFPagerAdapter;
        }

        public Builder setCenterX(float f2) {
            this.centerX = f2;
            return this;
        }

        public Builder setCenterY(float f2) {
            this.centerY = f2;
            return this;
        }

        public Builder setOffScreenSize(int i2) {
            this.offScreenSize = i2;
            return this;
        }

        public Builder setOnPageClickListener(View.OnClickListener onClickListener) {
            if (onClickListener != null) {
                this.pageClickListener = onClickListener;
            }
            return this;
        }

        public Builder setPdfPath(String str) {
            this.pdfPath = str;
            return this;
        }

        public Builder setRenderQuality(float f2) {
            this.renderQuality = f2;
            return this;
        }

        public Builder setScale(float f2) {
            this.scale = f2;
            return this;
        }

        public Builder setScale(PdfScale pdfScale) {
            this.scale = pdfScale.getScale();
            this.centerX = pdfScale.getCenterX();
            this.centerY = pdfScale.getCenterY();
            return this;
        }
    }

    public PDFPagerAdapter(Context context, String str) {
        super(context, str);
        this.scale = new PdfScale();
        this.pageClickListener = new EmptyClickListener();
    }

    @Override // es.voghdev.pdfviewpager.library.adapter.BasePDFPagerAdapter
    public void close() {
        super.close();
    }

    @Override // es.voghdev.pdfviewpager.library.adapter.BasePDFPagerAdapter, androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i2) {
        View viewInflate = this.inflater.inflate(R.layout.view_pdf_page, viewGroup, false);
        SubsamplingScaleImageView subsamplingScaleImageView = (SubsamplingScaleImageView) viewInflate.findViewById(R.id.subsamplingImageView);
        if (this.renderer != null && getCount() >= i2) {
            PdfRenderer.Page pDFPage = getPDFPage(this.renderer, i2);
            Bitmap bitmap = this.bitmapContainer.get(i2);
            subsamplingScaleImageView.setImage(a.bitmap(bitmap));
            pDFPage.render(bitmap, null, null, 1);
            pDFPage.close();
            ((ViewPager) viewGroup).addView(viewInflate, 0);
        }
        return viewInflate;
    }
}
