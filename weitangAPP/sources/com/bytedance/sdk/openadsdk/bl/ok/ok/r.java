package com.bytedance.sdk.openadsdk.bl.ok.ok;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.ComplianceInfo;
import com.bytedance.sdk.openadsdk.DislikeInfo;
import com.bytedance.sdk.openadsdk.DownloadStatusController;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTAdInteractionListener;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.bytedance.sdk.openadsdk.TTImage;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder;
import com.bytedance.sdk.openadsdk.mediation.manager.MediationNativeManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class r implements TTFeedAd {
    private final Bridge ok;

    public r(Bridge bridge) {
        this.ok = bridge == null ? c.d.a.a.a.a.a.f919b : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void destroy() {
        this.ok.call(140114, c.d.a.a.a.a.a.ok(0).a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public Bitmap getAdLogo() {
        return (Bitmap) this.ok.values().objectValue(140002, Bitmap.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public View getAdView() {
        return (View) this.ok.values().objectValue(140016, View.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd
    public int getAdViewHeight() {
        return this.ok.values().intValue(160004);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd
    public int getAdViewWidth() {
        return this.ok.values().intValue(160003);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public int getAppCommentNum() {
        return this.ok.values().intValue(140006);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public int getAppScore() {
        return this.ok.values().intValue(140005);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public int getAppSize() {
        return this.ok.values().intValue(140007);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public String getButtonText() {
        return (String) this.ok.values().objectValue(140018, String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public ComplianceInfo getComplianceInfo() {
        return new bl((Bridge) this.ok.values().objectValue(140014, Bridge.class));
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd
    public TTFeedAd.CustomizeVideo getCustomVideo() {
        return new com.bytedance.sdk.openadsdk.q.ok.ok.ok.ok((Bridge) this.ok.values().objectValue(160002, Bridge.class));
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public String getDescription() {
        return (String) this.ok.values().objectValue(140004, String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public TTAdDislike getDislikeDialog(Activity activity) {
        c.d.a.a.a.a.a aVarOk = c.d.a.a.a.a.a.ok(1);
        aVarOk.ok(0, activity);
        return new p((Bridge) this.ok.call(140101, aVarOk.a(), Bridge.class));
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public DislikeInfo getDislikeInfo() {
        return new s((Bridge) this.ok.values().objectValue(140013, Bridge.class));
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public DownloadStatusController getDownloadStatusController() {
        return new n((Bridge) this.ok.values().objectValue(140015, Bridge.class));
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public TTImage getIcon() {
        return new z((Bridge) this.ok.values().objectValue(140009, Bridge.class));
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public List<TTImage> getImageList() {
        List arrayList = (List) this.ok.values().objectValue(140010, List.class);
        if (arrayList == null) {
            arrayList = new ArrayList(0);
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(new z((Bridge) it.next()));
        }
        return arrayList2;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public int getImageMode() {
        return this.ok.values().intValue(140012);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public int getInteractionType() {
        return this.ok.values().intValue(140011);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public Map<String, Object> getMediaExtraInfo() {
        return (Map) this.ok.values().objectValue(140017, Map.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public MediationNativeManager getMediationManager() {
        return new com.bytedance.sdk.openadsdk.mediation.manager.ok.ok.ok.s((Bridge) this.ok.call(140116, c.d.a.a.a.a.a.ok(0).a(), Bridge.class));
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public String getSource() {
        return (String) this.ok.values().objectValue(140008, String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public String getTitle() {
        return (String) this.ok.values().objectValue(140003, String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public TTImage getVideoCoverImage() {
        return new z((Bridge) this.ok.values().objectValue(140001, Bridge.class));
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd
    public double getVideoDuration() {
        return this.ok.values().doubleValue(160001);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void loss(Double d2, String str, String str2) {
        c.d.a.a.a.a.a aVarOk = c.d.a.a.a.a.a.ok(3);
        aVarOk.ok(0, d2);
        aVarOk.ok(1, str);
        aVarOk.ok(2, str2);
        this.ok.call(210102, aVarOk.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void registerViewForInteraction(ViewGroup viewGroup, View view, TTNativeAd.AdInteractionListener adInteractionListener) {
        c.d.a.a.a.a.a aVarOk = c.d.a.a.a.a.a.ok(3);
        aVarOk.ok(0, viewGroup);
        aVarOk.ok(1, view);
        aVarOk.ok(2, new com.bytedance.sdk.openadsdk.r.ok.ok.ok.ok(adInteractionListener));
        this.ok.call(140103, aVarOk.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void render() {
        this.ok.call(140110, c.d.a.a.a.a.a.ok(0).a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void setActivityForDownloadApp(Activity activity) {
        c.d.a.a.a.a.a aVarOk = c.d.a.a.a.a.a.ok(1);
        aVarOk.ok(0, activity);
        this.ok.call(140109, aVarOk.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void setAdInteractionListener(TTAdInteractionListener tTAdInteractionListener) {
        c.d.a.a.a.a.a aVarOk = c.d.a.a.a.a.a.ok(1);
        aVarOk.ok(0, new com.bytedance.sdk.openadsdk.bl.ok.a.ok(tTAdInteractionListener));
        this.ok.call(210104, aVarOk.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void setDislikeCallback(Activity activity, TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
        c.d.a.a.a.a.a aVarOk = c.d.a.a.a.a.a.ok(2);
        aVarOk.ok(0, activity);
        aVarOk.ok(1, new com.bytedance.sdk.openadsdk.kf.ok.ok.ok.ok(dislikeInteractionCallback));
        this.ok.call(140112, aVarOk.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void setDislikeDialog(TTDislikeDialogAbstract tTDislikeDialogAbstract) {
        c.d.a.a.a.a.a aVarOk = c.d.a.a.a.a.a.ok(1);
        aVarOk.ok(0, tTDislikeDialogAbstract);
        this.ok.call(140113, aVarOk.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void setDownloadListener(TTAppDownloadListener tTAppDownloadListener) {
        c.d.a.a.a.a.a aVarOk = c.d.a.a.a.a.a.ok(1);
        aVarOk.ok(0, new com.bytedance.sdk.openadsdk.bl.ok.a.a(tTAppDownloadListener));
        this.ok.call(140108, aVarOk.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void setExpressRenderListener(TTNativeAd.ExpressRenderListener expressRenderListener) {
        c.d.a.a.a.a.a aVarOk = c.d.a.a.a.a.a.ok(1);
        aVarOk.ok(0, new com.bytedance.sdk.openadsdk.r.ok.ok.ok.a(expressRenderListener));
        this.ok.call(140111, aVarOk.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void setPrice(Double d2) {
        c.d.a.a.a.a.a aVarOk = c.d.a.a.a.a.a.ok(1);
        aVarOk.ok(0, d2);
        this.ok.call(210103, aVarOk.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd
    public void setVideoAdListener(TTFeedAd.VideoAdListener videoAdListener) {
        c.d.a.a.a.a.a aVarOk = c.d.a.a.a.a.a.ok(1);
        aVarOk.ok(0, new com.bytedance.sdk.openadsdk.q.ok.ok.a.ok(videoAdListener));
        this.ok.call(160101, aVarOk.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd
    public void setVideoRewardListener(TTFeedAd.VideoRewardListener videoRewardListener) {
        c.d.a.a.a.a.a aVarOk = c.d.a.a.a.a.a.ok(1);
        aVarOk.ok(0, new com.bytedance.sdk.openadsdk.q.ok.ok.a.a(videoRewardListener));
        this.ok.call(160102, aVarOk.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void showInteractionExpressAd(Activity activity) {
        c.d.a.a.a.a.a aVarOk = c.d.a.a.a.a.a.ok(1);
        aVarOk.ok(0, activity);
        this.ok.call(140115, aVarOk.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void win(Double d2) {
        c.d.a.a.a.a.a aVarOk = c.d.a.a.a.a.a.ok(1);
        aVarOk.ok(0, d2);
        this.ok.call(210101, aVarOk.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public TTAdDislike getDislikeDialog(TTDislikeDialogAbstract tTDislikeDialogAbstract) {
        c.d.a.a.a.a.a aVarOk = c.d.a.a.a.a.a.ok(1);
        aVarOk.ok(0, tTDislikeDialogAbstract);
        return new p((Bridge) this.ok.call(140102, aVarOk.a(), Bridge.class));
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void registerViewForInteraction(ViewGroup viewGroup, List<View> list, List<View> list2, TTNativeAd.AdInteractionListener adInteractionListener) {
        c.d.a.a.a.a.a aVarOk = c.d.a.a.a.a.a.ok(4);
        aVarOk.ok(0, viewGroup);
        aVarOk.ok(1, list);
        aVarOk.ok(2, list2);
        aVarOk.ok(3, new com.bytedance.sdk.openadsdk.r.ok.ok.ok.ok(adInteractionListener));
        this.ok.call(140104, aVarOk.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void registerViewForInteraction(ViewGroup viewGroup, List<View> list, List<View> list2, View view, TTNativeAd.AdInteractionListener adInteractionListener) {
        c.d.a.a.a.a.a aVarOk = c.d.a.a.a.a.a.ok(5);
        aVarOk.ok(0, viewGroup);
        aVarOk.ok(1, list);
        aVarOk.ok(2, list2);
        aVarOk.ok(3, view);
        aVarOk.ok(4, new com.bytedance.sdk.openadsdk.r.ok.ok.ok.ok(adInteractionListener));
        this.ok.call(140105, aVarOk.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void registerViewForInteraction(ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, View view, TTNativeAd.AdInteractionListener adInteractionListener) {
        c.d.a.a.a.a.a aVarOk = c.d.a.a.a.a.a.ok(6);
        aVarOk.ok(0, viewGroup);
        aVarOk.ok(1, list);
        aVarOk.ok(2, list2);
        aVarOk.ok(3, list3);
        aVarOk.ok(4, view);
        aVarOk.ok(5, new com.bytedance.sdk.openadsdk.r.ok.ok.ok.ok(adInteractionListener));
        this.ok.call(140106, aVarOk.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void registerViewForInteraction(ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, List<View> list4, View view, TTNativeAd.AdInteractionListener adInteractionListener) {
        c.d.a.a.a.a.a aVarOk = c.d.a.a.a.a.a.ok(7);
        aVarOk.ok(0, viewGroup);
        aVarOk.ok(1, list);
        aVarOk.ok(2, list2);
        aVarOk.ok(3, list3);
        aVarOk.ok(4, list4);
        aVarOk.ok(5, view);
        aVarOk.ok(6, new com.bytedance.sdk.openadsdk.r.ok.ok.ok.ok(adInteractionListener));
        this.ok.call(140107, aVarOk.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void registerViewForInteraction(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, TTNativeAd.AdInteractionListener adInteractionListener, IMediationViewBinder iMediationViewBinder) {
        c.d.a.a.a.a.a aVarOk = c.d.a.a.a.a.a.ok(7);
        aVarOk.ok(0, activity);
        aVarOk.ok(1, viewGroup);
        aVarOk.ok(2, list);
        aVarOk.ok(3, list2);
        aVarOk.ok(4, list3);
        aVarOk.ok(5, new com.bytedance.sdk.openadsdk.r.ok.ok.ok.ok(adInteractionListener));
        aVarOk.ok(6, new com.bytedance.sdk.openadsdk.mediation.ad.ok.ok.a.n(iMediationViewBinder));
        this.ok.call(140117, aVarOk.a(), Void.class);
    }
}
