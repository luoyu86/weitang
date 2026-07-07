package com.qq.e.ads.nativ;

import android.content.Context;
import android.text.TextUtils;
import com.qq.e.ads.NativeAbstractAD;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.pi.NUADI;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.AdErrorConvertor;
import com.qq.e.comm.util.GDTLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class NativeUnifiedAD extends NativeAbstractAD<NUADI> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public AdListenerAdapter f9600f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public NativeADUnifiedListener f9601g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public List<Integer> f9602h = new ArrayList();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public List<String> f9603i;
    public volatile int j;
    public volatile int k;
    public String l;
    public LoadAdParams m;

    public static class AdListenerAdapter implements ADListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public NativeADUnifiedListener f9604a;

        public AdListenerAdapter(NativeADUnifiedListener nativeADUnifiedListener) {
            this.f9604a = nativeADUnifiedListener;
        }

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            Integer num;
            if (this.f9604a != null) {
                int type = aDEvent.getType();
                if (type != 100) {
                    if (type == 101 && (num = (Integer) aDEvent.getParam(Integer.class)) != null) {
                        this.f9604a.onNoAD(AdErrorConvertor.formatErrorCode(num.intValue()));
                        return;
                    }
                    return;
                }
                List list = (List) aDEvent.getParam(List.class);
                if (list == null || list.size() <= 0) {
                    return;
                }
                ArrayList arrayList = new ArrayList();
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(new NativeUnifiedADDataAdapter((NativeUnifiedADData) it.next()));
                }
                this.f9604a.onADLoaded(arrayList);
            }
        }
    }

    public NativeUnifiedAD(Context context, String str, NativeADUnifiedListener nativeADUnifiedListener) {
        this.f9601g = nativeADUnifiedListener;
        this.f9600f = new AdListenerAdapter(nativeADUnifiedListener);
        a(context, str);
    }

    public NativeUnifiedAD(Context context, String str, NativeADUnifiedListener nativeADUnifiedListener, String str2) {
        this.f9601g = nativeADUnifiedListener;
        this.f9600f = new AdListenerAdapter(nativeADUnifiedListener);
        a(context, str, str2);
    }

    @Override // com.qq.e.ads.AbstractAD
    public Object a(Context context, POFactory pOFactory, String str, String str2, String str3) {
        return pOFactory.getNativeAdManagerDelegate(context, str, str2, str3, this.f9600f);
    }

    @Override // com.qq.e.ads.AbstractAD
    public void b(int i2) {
        NativeADUnifiedListener nativeADUnifiedListener = this.f9601g;
        if (nativeADUnifiedListener != null) {
            nativeADUnifiedListener.onNoAD(AdErrorConvertor.formatErrorCode(i2));
        }
    }

    public final void d(int i2, boolean z) {
        if (a()) {
            if (!b()) {
                if (z) {
                    this.f9602h.add(Integer.valueOf(i2));
                    return;
                }
                return;
            }
            T t = this.f9515a;
            if (t != 0) {
                LoadAdParams loadAdParams = this.m;
                NUADI nuadi = (NUADI) t;
                if (loadAdParams != null) {
                    nuadi.loadData(i2, loadAdParams);
                } else {
                    nuadi.loadData(i2);
                }
            }
        }
    }

    public String getAdNetWorkName() {
        T t = this.f9515a;
        if (t != 0) {
            return ((NUADI) t).getAdNetWorkName();
        }
        a("getAdNetWorkName");
        return null;
    }

    public void loadData(int i2) {
        d(i2, true);
    }

    public void loadData(int i2, LoadAdParams loadAdParams) {
        this.m = loadAdParams;
        loadData(i2);
    }

    public void setCategories(List<String> list) {
        this.f9603i = list;
        T t = this.f9515a;
        if (t == 0 || list == null) {
            return;
        }
        ((NUADI) t).setCategories(list);
    }

    public void setMaxVideoDuration(int i2) {
        this.k = i2;
        if (this.k > 0 && this.j > this.k) {
            GDTLogger.e("maxVideoDuration 设置值非法，不得小于minVideoDuration");
        }
        T t = this.f9515a;
        if (t != 0) {
            ((NUADI) t).setMaxVideoDuration(this.k);
        }
    }

    public void setMinVideoDuration(int i2) {
        this.j = i2;
        if (this.k > 0 && this.j > this.k) {
            GDTLogger.e("minVideoDuration 设置值非法，不得大于maxVideoDuration");
        }
        T t = this.f9515a;
        if (t != 0) {
            ((NUADI) t).setMinVideoDuration(this.j);
        }
    }

    public void setVastClassName(String str) {
        if (TextUtils.isEmpty(str)) {
            GDTLogger.e("Vast class name 不能为空");
            return;
        }
        this.l = str;
        T t = this.f9515a;
        if (t != 0) {
            ((NUADI) t).setVastClassName(str);
        }
    }

    @Override // com.qq.e.ads.NativeAbstractAD, com.qq.e.ads.AbstractAD
    public void a(Object obj) {
        NUADI nuadi = (NUADI) obj;
        nuadi.setMinVideoDuration(this.j);
        nuadi.setMaxVideoDuration(this.k);
        nuadi.setVastClassName(this.l);
        List<String> list = this.f9603i;
        if (list != null) {
            setCategories(list);
        }
        Iterator<Integer> it = this.f9602h.iterator();
        while (it.hasNext()) {
            d(it.next().intValue(), false);
        }
    }
}
