package cn.admobiletop.adsuyi.ad.data;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.DrawableRes;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiAdListener;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiSingleClickListener;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class ADSuyiBaseAdInfo<T extends ADSuyiAdListener, E> implements ADSuyiAdInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f3490a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f3491b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f3492c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f3493d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ADSuyiSingleClickListener f3494e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ADSuyiSingleClickListener f3495f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ADSuyiSingleClickListener f3496g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public T f3497h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public E f3498i;
    public Map<String, Object> j;

    public ADSuyiBaseAdInfo(String str, String str2, @DrawableRes int i2) {
        this.f3490a = str;
        this.f3491b = str2;
        this.f3492c = i2;
    }

    public ADSuyiSingleClickListener getActionClickListener() {
        return this.f3494e;
    }

    public T getAdListener() {
        return this.f3497h;
    }

    public E getAdapterAdInfo() {
        return this.f3498i;
    }

    public ADSuyiSingleClickListener getClickListener() {
        return this.f3496g;
    }

    public ADSuyiSingleClickListener getCloseClickListener() {
        return this.f3495f;
    }

    public Map<String, Object> getExtInfo() {
        if (this.j == null) {
            this.j = new HashMap();
        }
        return this.j;
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiAdInfo
    public String getPlatform() {
        return this.f3490a;
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiAdInfo
    public int getPlatformIcon() {
        return this.f3492c;
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiAdInfo
    public String getPlatformPosId() {
        return this.f3491b;
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiAdInfo
    public boolean isReleased() {
        return this.f3493d;
    }

    public abstract void onActionClick(ViewGroup viewGroup, View view);

    public abstract void onAdContainerClick(View view);

    public abstract void onCloseClick(View view);

    public void registerCloseView(View view) {
        if (view != null) {
            if (this.f3495f == null) {
                this.f3495f = new ADSuyiSingleClickListener() { // from class: cn.admobiletop.adsuyi.ad.data.ADSuyiBaseAdInfo.1
                    @Override // cn.admobiletop.adsuyi.ad.listener.ADSuyiSingleClickListener
                    public void onSingleClick(View view2) {
                        ADSuyiBaseAdInfo.this.onCloseClick(view2);
                    }
                };
            }
            view.setOnClickListener(this.f3495f);
        }
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiAdInfo, cn.admobiletop.adsuyi.ad.data.IBaseRelease
    public final void release() {
        this.f3493d = true;
        this.f3494e = null;
        this.f3495f = null;
        this.f3496g = null;
        this.f3497h = null;
        try {
            releaseAdapter();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public abstract void releaseAdapter();

    public void setActionClickListener(ViewGroup viewGroup, View... viewArr) {
        if (viewArr == null || viewArr.length <= 0) {
            return;
        }
        if (this.f3494e == null) {
            this.f3494e = new ADSuyiSingleClickListener() { // from class: cn.admobiletop.adsuyi.ad.data.ADSuyiBaseAdInfo.3
                @Override // cn.admobiletop.adsuyi.ad.listener.ADSuyiSingleClickListener
                public void onSingleClick(View view) {
                    ADSuyiBaseAdInfo.this.onActionClick(getContainer(), view);
                }
            };
        }
        this.f3494e.setContainer(viewGroup);
        for (View view : viewArr) {
            if (view != null && view != viewGroup) {
                view.setOnClickListener(this.f3494e);
            }
        }
    }

    public void setAdContainerClickListener(ViewGroup viewGroup) {
        if (viewGroup != null) {
            if (this.f3496g == null) {
                this.f3496g = new ADSuyiSingleClickListener() { // from class: cn.admobiletop.adsuyi.ad.data.ADSuyiBaseAdInfo.2
                    @Override // cn.admobiletop.adsuyi.ad.listener.ADSuyiSingleClickListener
                    public void onSingleClick(View view) {
                        ADSuyiBaseAdInfo.this.onAdContainerClick(view);
                    }
                };
            }
            viewGroup.setOnClickListener(this.f3496g);
        }
    }

    public void setAdListener(T t) {
        this.f3497h = t;
    }

    public void setAdapterAdInfo(E e2) {
        this.f3498i = e2;
    }
}
