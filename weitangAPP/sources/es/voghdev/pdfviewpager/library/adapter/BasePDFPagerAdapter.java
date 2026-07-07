package es.voghdev.pdfviewpager.library.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.pdf.PdfRenderer;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import es.voghdev.pdfviewpager.library.R;
import java.io.File;
import java.io.IOException;
import java.net.URI;

/* JADX INFO: loaded from: classes2.dex */
public class BasePDFPagerAdapter extends PagerAdapter {
    public static final int DEFAULT_OFFSCREENSIZE = 1;
    public static final float DEFAULT_QUALITY = 2.0f;
    public static final int FIRST_PAGE = 0;
    public BitmapContainer bitmapContainer;
    public Context context;
    public LayoutInflater inflater;
    public int offScreenSize;
    public String pdfPath;
    public float renderQuality;
    public PdfRenderer renderer;

    public BasePDFPagerAdapter(Context context, String str) {
        this.pdfPath = str;
        this.context = context;
        this.renderQuality = 2.0f;
        this.offScreenSize = 1;
        init();
    }

    public void close() {
        releaseAllBitmaps();
        PdfRenderer pdfRenderer = this.renderer;
        if (pdfRenderer != null) {
            pdfRenderer.close();
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
    }

    public PdfRendererParams extractPdfParamsFromFirstPage(PdfRenderer pdfRenderer, float f2) {
        PdfRenderer.Page pDFPage = getPDFPage(pdfRenderer, 0);
        PdfRendererParams pdfRendererParams = new PdfRendererParams();
        pdfRendererParams.setRenderQuality(f2);
        pdfRendererParams.setOffScreenSize(this.offScreenSize);
        pdfRendererParams.setWidth((int) (pDFPage.getWidth() * f2));
        pdfRendererParams.setHeight((int) (pDFPage.getHeight() * f2));
        pDFPage.close();
        return pdfRendererParams;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        PdfRenderer pdfRenderer = this.renderer;
        if (pdfRenderer != null) {
            return pdfRenderer.getPageCount();
        }
        return 0;
    }

    public PdfRenderer.Page getPDFPage(PdfRenderer pdfRenderer, int i2) {
        return pdfRenderer.openPage(i2);
    }

    public ParcelFileDescriptor getSeekableFileDescriptor(String str) throws IOException {
        File file = new File(str);
        return file.exists() ? ParcelFileDescriptor.open(file, 268435456) : isAnAsset(str) ? ParcelFileDescriptor.open(new File(this.context.getCacheDir(), str), 268435456) : this.context.getContentResolver().openFileDescriptor(Uri.parse(URI.create(String.format("file://%s", str)).toString()), "rw");
    }

    public void init() {
        try {
            this.renderer = new PdfRenderer(getSeekableFileDescriptor(this.pdfPath));
            this.inflater = (LayoutInflater) this.context.getSystemService("layout_inflater");
            this.bitmapContainer = new SimpleBitmapPool(extractPdfParamsFromFirstPage(this.renderer, this.renderQuality));
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i2) {
        View viewInflate = this.inflater.inflate(R.layout.view_pdf_page, viewGroup, false);
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.imageView);
        if (this.renderer != null && getCount() >= i2) {
            PdfRenderer.Page pDFPage = getPDFPage(this.renderer, i2);
            Bitmap bitmap = this.bitmapContainer.get(i2);
            pDFPage.render(bitmap, null, null, 1);
            pDFPage.close();
            imageView.setImageBitmap(bitmap);
            ((ViewPager) viewGroup).addView(viewInflate, 0);
        }
        return viewInflate;
    }

    public boolean isAnAsset(String str) {
        return !str.startsWith("/");
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == ((View) obj);
    }

    public void releaseAllBitmaps() {
        BitmapContainer bitmapContainer = this.bitmapContainer;
        if (bitmapContainer != null) {
            bitmapContainer.clear();
        }
    }

    public BasePDFPagerAdapter(Context context, String str, int i2) {
        this.pdfPath = str;
        this.context = context;
        this.renderQuality = 2.0f;
        this.offScreenSize = i2;
        init();
    }
}
