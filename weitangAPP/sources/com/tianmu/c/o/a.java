package com.tianmu.c.o;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import com.tianmu.TianmuSDK;
import com.tianmu.ad.activity.AdDetailActivity;
import com.tianmu.ad.activity.AdDownloadDetailActivity;
import com.tianmu.ad.activity.LandscapeAdDetailActivity;
import com.tianmu.ad.activity.LandscapeAdDownloadDetailActivity;
import com.tianmu.ad.base.BaseAdTouchView;
import com.tianmu.ad.model.INativeAd;
import com.tianmu.biz.utils.d;
import com.tianmu.biz.utils.n0;
import com.tianmu.biz.utils.s0;
import com.tianmu.c.n.j;
import com.tianmu.c.n.m;
import com.tianmu.c.n.q;
import com.tianmu.http.listener.SimpleHttpListener;
import com.tianmu.utils.TianmuDisplayUtil;
import com.tianmu.utils.TianmuLogUtil;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f11921a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f11922b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f11923c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f11924d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f11925e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f11926f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f11927g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f11928h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f11929i;
    private boolean j;
    private int k;
    private int l;
    private int m;

    /* JADX INFO: renamed from: com.tianmu.c.o.a$a, reason: collision with other inner class name */
    public class ViewOnTouchListenerC0214a implements View.OnTouchListener {
        public ViewOnTouchListenerC0214a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            a.this.a(motionEvent);
            return false;
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f11931a;

        public b(View view) {
            this.f11931a = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.l = this.f11931a.getHeight();
            a.this.k = this.f11931a.getWidth();
        }
    }

    public class c extends SimpleHttpListener {
        public c(a aVar) {
        }

        @Override // com.tianmu.http.listener.SimpleHttpListener, com.tianmu.http.listener.HttpListener
        public void onRequestFailed(int i2, String str, String str2) {
            if (i2 != -2001 || TextUtils.isEmpty(str2)) {
                return;
            }
            j.b().a().a(str2, null, null);
        }
    }

    private void b(List<String> list) {
        if (this.f11929i) {
            return;
        }
        a(list, true);
        this.f11929i = true;
    }

    public void a(View view) {
        if (view != null) {
            view.setOnTouchListener(new ViewOnTouchListenerC0214a());
            this.l = view.getHeight();
            int width = view.getWidth();
            this.k = width;
            if (this.l == 0 && width == 0) {
                view.post(new b(view));
            }
        }
    }

    private void b(View view) {
        if (view instanceof BaseAdTouchView) {
            BaseAdTouchView baseAdTouchView = (BaseAdTouchView) view;
            this.f11921a = baseAdTouchView.getDownX();
            this.f11923c = baseAdTouchView.getDownY();
            this.f11925e = baseAdTouchView.getUpX();
            this.f11927g = baseAdTouchView.getUpY();
            this.f11922b = baseAdTouchView.getDownSX();
            this.f11924d = baseAdTouchView.getDownSY();
            this.f11926f = baseAdTouchView.getUpSX();
            this.f11928h = baseAdTouchView.getUpSY();
            a(baseAdTouchView);
        }
    }

    public void a(INativeAd iNativeAd) {
        if (iNativeAd == null || this.f11929i || !(iNativeAd instanceof com.tianmu.c.i.c)) {
            return;
        }
        a(((com.tianmu.c.i.c) iNativeAd).m());
    }

    private void a(List<String> list) {
        if (list != null) {
            try {
                if (list.isEmpty()) {
                    return;
                }
                b(list);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void a(View view, INativeAd iNativeAd) {
        a(view, iNativeAd, false, 0);
    }

    public void a(View view, INativeAd iNativeAd, int i2) {
        a(view, iNativeAd, false, i2);
    }

    private void b(Context context, String str, com.tianmu.c.i.c cVar) {
        Intent intent;
        if (context != null) {
            try {
                m.b().a(cVar);
                boolean z = cVar.I() || (!TextUtils.isEmpty(str) && str.contains(".apk"));
                if (cVar.isLandscape()) {
                    if (z) {
                        intent = new Intent(context, (Class<?>) LandscapeAdDownloadDetailActivity.class);
                    } else {
                        intent = new Intent(context, (Class<?>) LandscapeAdDetailActivity.class);
                    }
                } else if (z) {
                    intent = new Intent(context, (Class<?>) AdDownloadDetailActivity.class);
                } else {
                    intent = new Intent(context, (Class<?>) AdDetailActivity.class);
                }
                com.tianmu.c.n.a.a().a(cVar.u(), cVar);
                intent.addFlags(268435456);
                intent.putExtra(AdDetailActivity.KEY_ADKEY, cVar.u());
                intent.putExtra(AdDetailActivity.KEY_WEB_URL, str);
                context.startActivity(intent);
            } catch (Exception e2) {
                e2.printStackTrace();
                s0.a("跳转落地页失败了!");
            }
        }
    }

    public void a(View view, INativeAd iNativeAd, boolean z, int i2) {
        if (view == null || view.getContext() == null || iNativeAd == null) {
            return;
        }
        if (i2 != 1 && i2 != 5 && i2 != 999) {
            b(view);
        } else {
            a();
        }
        a(iNativeAd, this.f11921a, this.f11923c, this.f11925e, this.f11927g, this.f11922b, this.f11924d, this.f11926f, this.f11928h, this.k, this.l, z, this.m);
    }

    private void a() {
        this.f11921a = -999;
        this.f11923c = -999;
        this.f11925e = -999;
        this.f11927g = -999;
        this.f11922b = -999;
        this.f11924d = -999;
        this.f11926f = -999;
        this.f11928h = -999;
    }

    private void a(BaseAdTouchView baseAdTouchView) {
        int iA = q.a().a(baseAdTouchView);
        this.m = iA;
        if (iA == 1) {
            this.f11922b = baseAdTouchView.getDownX();
            this.f11924d = baseAdTouchView.getDownY();
            this.f11926f = baseAdTouchView.getUpX();
            this.f11928h = baseAdTouchView.getUpY();
            return;
        }
        if (iA == 2) {
            this.f11925e = baseAdTouchView.getMoveX();
            this.f11927g = baseAdTouchView.getMoveY();
            this.f11926f = baseAdTouchView.getMoveSX();
            this.f11928h = baseAdTouchView.getMoveSY();
        }
    }

    public void a(INativeAd iNativeAd, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, boolean z, int i12) {
        int iPx2dp;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int iPx2dp2;
        try {
            TianmuLogUtil.iD("click view coordinate px : (" + i2 + "," + i3 + "," + i4 + "," + i5 + ")");
            TianmuLogUtil.iD("click screen coordinate px : (" + i6 + "," + i7 + "," + i8 + "," + i9 + ")");
            StringBuilder sb = new StringBuilder();
            sb.append("click view size px : (width = ");
            sb.append(i10);
            sb.append(",hegith = ");
            sb.append(i11);
            sb.append(")");
            TianmuLogUtil.iD(sb.toString());
            if (i2 != -999) {
                int iPx2dp3 = TianmuDisplayUtil.px2dp(i2);
                int iPx2dp4 = TianmuDisplayUtil.px2dp(i3);
                int iPx2dp5 = TianmuDisplayUtil.px2dp(i4);
                int iPx2dp6 = TianmuDisplayUtil.px2dp(i5);
                iPx2dp2 = TianmuDisplayUtil.px2dp(i6);
                int iPx2dp7 = TianmuDisplayUtil.px2dp(i7);
                int iPx2dp8 = TianmuDisplayUtil.px2dp(i8);
                i13 = iPx2dp3;
                i14 = iPx2dp4;
                iPx2dp = TianmuDisplayUtil.px2dp(i9);
                i16 = iPx2dp5;
                i15 = iPx2dp8;
                i18 = iPx2dp6;
                i17 = iPx2dp7;
            } else {
                iPx2dp = i9;
                i13 = i2;
                i14 = i3;
                i15 = i8;
                i16 = i4;
                i17 = i7;
                i18 = i5;
                iPx2dp2 = i6;
            }
            int iPx2dp9 = TianmuDisplayUtil.px2dp(i10);
            int iPx2dp10 = TianmuDisplayUtil.px2dp(i11);
            StringBuilder sb2 = new StringBuilder();
            try {
                sb2.append("click view coordinate dp : (");
                sb2.append(i13);
                sb2.append(",");
                sb2.append(i14);
                sb2.append(",");
                sb2.append(i16);
                sb2.append(",");
                sb2.append(i18);
                sb2.append(")");
                TianmuLogUtil.iD(sb2.toString());
                TianmuLogUtil.iD("click screen coordinate dp : (" + iPx2dp2 + "," + i17 + "," + i15 + "," + iPx2dp + ")");
                StringBuilder sb3 = new StringBuilder();
                sb3.append("click view size dp : (width = ");
                sb3.append(iPx2dp9);
                sb3.append(",hegith = ");
                sb3.append(iPx2dp10);
                sb3.append(")");
                TianmuLogUtil.iD(sb3.toString());
                if (iNativeAd instanceof com.tianmu.c.i.c) {
                    com.tianmu.c.i.c cVar = (com.tianmu.c.i.c) iNativeAd;
                    com.tianmu.c.h.d.a.c().a(cVar, new com.tianmu.c.i.j(i13, i14, i16, i18, iPx2dp2, i17, i15, iPx2dp, iPx2dp9, iPx2dp10));
                    b(cVar.m());
                    int i19 = iPx2dp;
                    int i20 = i15;
                    int i21 = i17;
                    int i22 = i14;
                    int i23 = i13;
                    a(cVar.j(), i13, i14, i16, i18, iPx2dp2, i21, i20, i19, iPx2dp9, iPx2dp10, z, i12);
                    String str = cVar.getLandingPageUrl() + "";
                    a(TianmuSDK.getInstance().getContext(), n0.a(str, i23, i22, i16, i18, iPx2dp2, i21, i20, i19, iPx2dp9, iPx2dp10), cVar);
                }
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
            }
        } catch (Exception e3) {
            e = e3;
        }
    }

    private void a(List<String> list, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, boolean z, int i12) {
        String strA;
        if (this.j || list == null || list.size() <= 0 || j.b().a() == null) {
            return;
        }
        for (int i13 = 0; i13 < list.size(); i13++) {
            String str = list.get(i13);
            if (str != null) {
                String strReplace = n0.a(str, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11).replace(" ", "");
                if (z) {
                    strReplace = strReplace.replace("_ADM_OPTIMIZATION_", "1");
                }
                if (i12 != 0) {
                    strA = n0.a(strReplace, 1);
                } else {
                    strA = n0.a(strReplace, 0);
                }
                j.b().a().a(strA, null, new c(this));
            }
        }
        this.j = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f11921a = (int) motionEvent.getX();
            this.f11922b = (int) motionEvent.getRawX();
            this.f11923c = (int) motionEvent.getY();
            this.f11924d = (int) motionEvent.getRawY();
            return;
        }
        if (action != 1) {
            return;
        }
        this.f11925e = (int) motionEvent.getX();
        this.f11926f = (int) motionEvent.getRawX();
        this.f11927g = (int) motionEvent.getY();
        this.f11928h = (int) motionEvent.getRawY();
    }

    private void a(Context context, String str, com.tianmu.c.i.c cVar) {
        if (cVar != null && cVar.K() && !TextUtils.isEmpty(str)) {
            if (d.d(str)) {
                return;
            }
            b(context, str, cVar);
            return;
        }
        b(context, str, cVar);
    }

    public void a(List<String> list, boolean z) {
        j.b().a(list, z);
    }

    public void a(List<String> list, int i2, boolean z) {
        HashMap<String, String> map = new HashMap<>(3);
        map.put("__TM_PLAY_DURATION__", String.valueOf(i2 / 1000));
        map.put("__TM_PLAY_MILLI_DURATION__", String.valueOf(i2));
        map.put("__TM_PLAY_FINISH__", String.valueOf(z ? 1 : 0));
        j.b().a(list, map);
    }
}
