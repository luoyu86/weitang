package cn.admobiletop.adsuyi.adapter.gdt.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import cn.admobiletop.adsuyi.ad.data.ADSuyiDrawVodAdInfo;
import cn.admobiletop.adsuyi.ad.error.ADSuyiError;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiDrawVodAdListener;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiDrawVodVideoListener;
import cn.admobiletop.adsuyi.adapter.gdt.R;
import cn.admobiletop.adsuyi.adapter.gdt.widget.NativeDrawADInfoView;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.nativ.MediaView;
import com.qq.e.ads.nativ.NativeADEventListener;
import com.qq.e.ads.nativ.NativeADMediaListener;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.ads.nativ.widget.NativeAdContainer;
import com.qq.e.comm.util.AdError;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class c extends b<ADSuyiDrawVodAdListener, NativeUnifiedADData> implements ADSuyiDrawVodAdInfo, NativeADEventListener, NativeADMediaListener {
    public ADSuyiDrawVodVideoListener k;
    public View l;
    public RelativeLayout m;
    public MediaView n;
    public RelativeLayout o;
    public ImageView p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public NativeAdContainer f3619q;
    public NativeDrawADInfoView r;
    public ArrayList<ImageView> s;
    public List<View> t;
    public int u;
    public int v;
    public VideoOption w;

    public c(int i2, int i3, String str) {
        super(str);
        this.u = i2;
        this.v = i3;
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiBaseAdInfo
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void setAdapterAdInfo(NativeUnifiedADData nativeUnifiedADData) {
        super.setAdapterAdInfo(nativeUnifiedADData);
        if (nativeUnifiedADData == null || !cn.admobiletop.adsuyi.adapter.gdt.c.c.a()) {
            return;
        }
        nativeUnifiedADData.setDownloadConfirmListener(cn.admobiletop.adsuyi.adapter.gdt.c.c.f3681b);
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiDrawVodAdInfo
    public View getMediaView(@NonNull ViewGroup viewGroup) {
        View viewInflate = ((LayoutInflater) viewGroup.getContext().getSystemService("layout_inflater")).inflate(R.layout.adsuyi_gdt_native_draw_ad, (ViewGroup) null);
        this.l = viewInflate;
        this.m = (RelativeLayout) viewInflate.findViewById(R.id.adsuyi_gdt_custom_container);
        this.n = (MediaView) this.l.findViewById(R.id.adsuyi_gdt_gdt_media_view);
        this.o = (RelativeLayout) this.l.findViewById(R.id.adsuyi_gdt_ad_info_container);
        this.p = (ImageView) this.l.findViewById(R.id.adsuyi_gdt_img_poster);
        this.f3619q = (NativeAdContainer) this.l.findViewById(R.id.adsuyi_gdt_native_ad_container);
        NativeDrawADInfoView nativeDrawADInfoView = (NativeDrawADInfoView) this.l.findViewById(R.id.adsuyi_gdt_ad_info_view);
        this.r = nativeDrawADInfoView;
        nativeDrawADInfoView.setAdInfo(getAdapterAdInfo());
        if (isVideo()) {
            this.p.setVisibility(4);
            this.n.setVisibility(0);
        } else {
            this.p.setVisibility(0);
            this.n.setVisibility(4);
        }
        this.o.setVisibility(0);
        ArrayList arrayList = new ArrayList();
        this.t = arrayList;
        arrayList.addAll(this.r.getClickableViews());
        this.s = new ArrayList<>();
        if (getAdapterAdInfo().getAdPatternType() == 1 || getAdapterAdInfo().getAdPatternType() == 4) {
            this.t.add(this.p);
            this.s.add(this.p);
        }
        if (isVideo() && this.w == null) {
            this.w = cn.admobiletop.adsuyi.adapter.gdt.e.e.a(false);
        }
        return this.l;
    }

    public boolean isVideo() {
        return getAdapterAdInfo() != null && 2 == getAdapterAdInfo().getAdPatternType();
    }

    @Override // com.qq.e.ads.nativ.NativeADEventListener
    public void onADClicked() {
        if (getAdListener() != 0) {
            ((ADSuyiDrawVodAdListener) getAdListener()).onAdClick(this);
        }
    }

    @Override // com.qq.e.ads.nativ.NativeADEventListener
    public void onADError(AdError adError) {
        if (getAdListener() != 0) {
            ((ADSuyiDrawVodAdListener) getAdListener()).onRenderFailed(this, new ADSuyiError(adError.getErrorCode(), adError.getErrorMsg()));
        }
    }

    @Override // com.qq.e.ads.nativ.NativeADEventListener
    public void onADExposed() {
        if (getAdListener() != 0) {
            ((ADSuyiDrawVodAdListener) getAdListener()).onAdExpose(this);
        }
    }

    @Override // com.qq.e.ads.nativ.NativeADEventListener
    public void onADStatusChanged() {
    }

    @Override // com.qq.e.ads.nativ.NativeADMediaListener
    public void onVideoClicked() {
        if (getAdListener() != 0) {
            ((ADSuyiDrawVodAdListener) getAdListener()).onAdClick(this);
        }
    }

    @Override // com.qq.e.ads.nativ.NativeADMediaListener
    public void onVideoCompleted() {
        ADSuyiDrawVodVideoListener aDSuyiDrawVodVideoListener = this.k;
        if (aDSuyiDrawVodVideoListener != null) {
            aDSuyiDrawVodVideoListener.onVideoComplete(this);
        }
        RelativeLayout relativeLayout = this.o;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
        NativeDrawADInfoView nativeDrawADInfoView = this.r;
        if (nativeDrawADInfoView != null) {
            nativeDrawADInfoView.b();
        }
    }

    @Override // com.qq.e.ads.nativ.NativeADMediaListener
    public void onVideoError(AdError adError) {
        if (getAdListener() != 0) {
            ((ADSuyiDrawVodAdListener) getAdListener()).onRenderFailed(this, new ADSuyiError(adError.getErrorCode(), adError.getErrorMsg()));
        }
    }

    @Override // com.qq.e.ads.nativ.NativeADMediaListener
    public void onVideoInit() {
    }

    @Override // com.qq.e.ads.nativ.NativeADMediaListener
    public void onVideoLoaded(int i2) {
        ADSuyiDrawVodVideoListener aDSuyiDrawVodVideoListener = this.k;
        if (aDSuyiDrawVodVideoListener != null) {
            aDSuyiDrawVodVideoListener.onVideoLoad(this);
        }
    }

    @Override // com.qq.e.ads.nativ.NativeADMediaListener
    public void onVideoLoading() {
    }

    @Override // com.qq.e.ads.nativ.NativeADMediaListener
    public void onVideoPause() {
        ADSuyiDrawVodVideoListener aDSuyiDrawVodVideoListener = this.k;
        if (aDSuyiDrawVodVideoListener != null) {
            aDSuyiDrawVodVideoListener.onVideoPause(this);
        }
    }

    @Override // com.qq.e.ads.nativ.NativeADMediaListener
    public void onVideoReady() {
    }

    @Override // com.qq.e.ads.nativ.NativeADMediaListener
    public void onVideoResume() {
    }

    @Override // com.qq.e.ads.nativ.NativeADMediaListener
    public void onVideoStart() {
        ADSuyiDrawVodVideoListener aDSuyiDrawVodVideoListener = this.k;
        if (aDSuyiDrawVodVideoListener != null) {
            aDSuyiDrawVodVideoListener.onVideoStart(this);
        }
        RelativeLayout relativeLayout = this.o;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(0);
        }
        NativeDrawADInfoView nativeDrawADInfoView = this.r;
        if (nativeDrawADInfoView != null) {
            nativeDrawADInfoView.a();
        }
    }

    @Override // com.qq.e.ads.nativ.NativeADMediaListener
    public void onVideoStop() {
    }

    @Override // cn.admobiletop.adsuyi.adapter.gdt.a.b, cn.admobiletop.adsuyi.ad.data.ADSuyiBaseAdInfo
    public void releaseAdapter() {
        super.releaseAdapter();
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.f3619q = null;
        this.r = null;
        this.w = null;
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiDrawVodAdInfo
    public void render(@NonNull ViewGroup viewGroup) {
        getAdapterAdInfo().setNativeAdEventListener(this);
        getAdapterAdInfo().bindAdToView(viewGroup.getContext(), this.f3619q, new FrameLayout.LayoutParams(0, 0), this.t);
        if (this.n != null && isVideo()) {
            getAdapterAdInfo().bindMediaView(this.n, this.w, this);
        }
        if (!this.s.isEmpty()) {
            getAdapterAdInfo().bindImageViews(this.s, 0);
        }
        this.r.a(getAdapterAdInfo());
        RelativeLayout relativeLayout = this.m;
        if (relativeLayout != null) {
            ViewGroup.LayoutParams layoutParams = relativeLayout.getLayoutParams();
            layoutParams.width = this.u;
            layoutParams.height = this.v;
            this.m.setLayoutParams(layoutParams);
        }
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiDrawVodAdInfo
    public void setVideoListener(ADSuyiDrawVodVideoListener aDSuyiDrawVodVideoListener) {
        if (isVideo()) {
            this.k = aDSuyiDrawVodVideoListener;
        }
    }

    public void a() {
        if (getAdapterAdInfo() != null) {
            getAdapterAdInfo().resume();
        }
    }
}
