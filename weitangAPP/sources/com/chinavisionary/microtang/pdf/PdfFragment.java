package com.chinavisionary.microtang.pdf;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.FileProvider;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.OnClick;
import c.e.a.d.l;
import c.e.a.d.o;
import c.e.a.d.q;
import c.e.a.d.x;
import com.chinavisionary.core.app.base.CoreBaseFragment;
import com.chinavisionary.core.weight.BaseSwipeRefreshLayout;
import com.chinavisionary.core.weight.banner.EditBannerView;
import com.chinavisionary.framework.mobile.common.vo.ResourceVo;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseFragment;
import com.tom_roush.pdfbox.contentstream.operator.OperatorName;
import com.tom_roush.pdfbox.pdmodel.PDDocument;
import com.tom_roush.pdfbox.rendering.ImageType;
import com.tom_roush.pdfbox.rendering.PDFRenderer;
import es.voghdev.pdfviewpager.library.RemotePDFViewPager;
import es.voghdev.pdfviewpager.library.remote.DownloadFile;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class PdfFragment extends BaseFragment<EditBannerView.BannerDto> {
    public String B;
    public RemotePDFViewPager C;
    public List<EditBannerView.BannerDto> D;
    public int E;
    public int F = 0;
    public File G;
    public int H;

    @BindView(R.id.img_left_icon)
    public ImageView mLeftImg;

    @BindView(R.id.tv_page_count_value)
    public TextView mPageCountTv;

    @BindView(R.id.banner_view)
    public BaseSwipeRefreshLayout mPdfLayout;

    @BindView(R.id.img_right_icon)
    public ImageView mRightImg;

    @BindView(R.id.tv_title_right)
    public TextView mTitleRightTv;

    @BindView(R.id.tv_title)
    public TextView mTitleTv;

    @BindView(R.id.frame_layout)
    public FrameLayout remotePdfRoot;

    public class a implements DownloadFile.Listener {
        public a() {
        }

        @Override // es.voghdev.pdfviewpager.library.remote.DownloadFile.Listener
        public void onFailure(Exception exc) {
            PdfFragment.this.F0(R.string.tip_load_err_retry);
        }

        @Override // es.voghdev.pdfviewpager.library.remote.DownloadFile.Listener
        public void onProgressUpdate(int i2, int i3) {
        }

        @Override // es.voghdev.pdfviewpager.library.remote.DownloadFile.Listener
        public void onSuccess(String str, String str2) {
            if (x.isNotNull(str) && x.isNotNull(str2)) {
                File file = new File(str2);
                String str3 = PdfFragment.this.B + ".pdf";
                l.renamePdfFile(file.getAbsolutePath(), str3);
                PdfFragment.this.G = new File(file.getParent(), str3);
                q.d(a.class.getSimpleName(), "onSuccess destinationPath =" + PdfFragment.this.G.getAbsolutePath());
                PdfFragment.this.S1();
            }
        }
    }

    public class b implements ViewPager.OnPageChangeListener {
        public b() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i2, float f2, int i3) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            PdfFragment.this.E = i2;
            PdfFragment.this.W1();
        }
    }

    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PdfFragment.this.H();
            if (o.isNotEmpty(PdfFragment.this.D)) {
                PdfFragment.this.t.initListData(PdfFragment.this.D);
            }
        }
    }

    public static PdfFragment getInstance(String str, String str2) {
        PdfFragment pdfFragment = new PdfFragment();
        pdfFragment.f6484b = str;
        pdfFragment.B = str2;
        return pdfFragment;
    }

    public final void O1() {
        int i2 = this.F;
        if (i2 > 0) {
            int i3 = this.E + 1;
            this.E = i3;
            if (i3 >= i2) {
                this.E = 0;
            }
            U1();
        }
    }

    public final void P1() {
        CoreBaseFragment.c cVar = this.f6488f;
        if (cVar != null) {
            cVar.post(new c());
        }
    }

    public final void Q1() {
        File file = this.G;
        if (file != null) {
            Uri uriForFile = FileProvider.getUriForFile(this.f6486d, "com.chinavisionary.microtang.provider", file);
            Intent intent = new Intent("android.intent.action.SEND");
            intent.putExtra("android.intent.extra.STREAM", uriForFile);
            intent.addFlags(1);
            intent.setType("application/pdf");
            intent.setFlags(268435456);
            startActivity(Intent.createChooser(intent, "分享文件"));
        }
    }

    public final void R1() {
        if (this.F > 0) {
            int i2 = this.E - 1;
            this.E = i2;
            if (i2 <= 0) {
                this.E = 0;
            }
            U1();
        }
    }

    public final void S1() {
        try {
            PDDocument pDDocumentLoad = PDDocument.load(this.G);
            PDFRenderer pDFRenderer = new PDFRenderer(pDDocumentLoad);
            int numberOfPages = pDDocumentLoad.getNumberOfPages();
            File pdfAppCacheDir = l.getPdfAppCacheDir();
            for (int i2 = 0; i2 < numberOfPages; i2++) {
                Bitmap bitmapRenderImage = pDFRenderer.renderImage(i2, 2.0f, ImageType.RGB);
                this.H = bitmapRenderImage.getHeight();
                String str = pdfAppCacheDir.getAbsolutePath() + File.separator + System.currentTimeMillis() + ".jpg";
                File file = new File(str);
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                bitmapRenderImage.compress(Bitmap.CompressFormat.JPEG, 80, fileOutputStream);
                fileOutputStream.close();
                bitmapRenderImage.recycle();
                Thread.sleep(1L);
                q.d(this.f6485c, "bitmap length = " + file.length());
                EditBannerView.BannerDto bannerDto = new EditBannerView.BannerDto();
                bannerDto.setPicFitXy(false);
                ResourceVo resourceVo = new ResourceVo();
                resourceVo.setKey(OperatorName.SET_FLATNESS + i2);
                resourceVo.setUrl(str);
                resourceVo.setSampleUrl(str);
                bannerDto.setCover(resourceVo);
                this.D.add(bannerDto);
            }
            P1();
        } catch (Exception e2) {
            Log.e("PdfBox-Android-Sample", "Exception thrown while rendering file", e2);
        }
    }

    public void T1(String str) {
        if (x.isNotNull(str)) {
            RemotePDFViewPager remotePDFViewPager = new RemotePDFViewPager(this.f6486d, str, new a());
            this.C = remotePDFViewPager;
            remotePDFViewPager.setId(R.id.pdfViewPager);
            this.C.addOnPageChangeListener(new b());
        }
    }

    public final void U1() {
        RemotePDFViewPager remotePDFViewPager = this.C;
        if (remotePDFViewPager != null) {
            remotePDFViewPager.setCurrentItem(this.E);
            W1();
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
        int id = view.getId();
        if (id == R.id.img_left_icon) {
            R1();
        } else if (id == R.id.img_right_icon) {
            O1();
        } else {
            if (id != R.id.tv_title_right) {
                return;
            }
            Q1();
        }
    }

    public final void V1() {
        int i2 = this.E >= 1 ? 0 : 8;
        if (this.mLeftImg.getVisibility() != i2) {
            this.mLeftImg.setVisibility(i2);
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        this.mTitleRightTv.setText(R.string.title_other_app_open_file);
        this.mTitleRightTv.setVisibility(0);
        this.mTitleRightTv.setOnClickListener(this.y);
        this.mTitleTv.setText(R.string.title_electron_contract);
        z0(R.string.loading_text);
        T1(this.f6484b);
        this.f6488f = new CoreBaseFragment.c(this);
        this.D = new ArrayList();
        this.mLeftImg.setOnClickListener(this.y);
        this.mRightImg.setOnClickListener(this.y);
        this.mPdfLayout.setEnabled(false);
        this.mPdfLayout.setRefreshing(false);
        this.r = this.mPdfLayout.getBaseRecyclerView();
        this.t = new PdfRecyclerAdapter();
    }

    public final void W1() {
        V1();
        this.mPageCountTv.setText((this.E + 1) + "/" + this.F);
    }

    @OnClick({R.id.tv_back})
    public void backClick() {
        m();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_pdf_view;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void j0() {
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        l.deleteFolder(l.getPdfAppCacheDir().getAbsolutePath());
    }
}
