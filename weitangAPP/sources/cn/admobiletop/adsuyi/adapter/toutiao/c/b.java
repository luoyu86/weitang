package cn.admobiletop.adsuyi.adapter.toutiao.c;

import android.location.Location;
import cn.admobiletop.adsuyi.ADSuyiSdk;
import com.bytedance.sdk.openadsdk.LocationProvider;

/* JADX INFO: loaded from: classes.dex */
public class b implements LocationProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f4058a;

    public b(c cVar) {
        this.f4058a = cVar;
    }

    @Override // com.bytedance.sdk.openadsdk.LocationProvider
    public double getLatitude() {
        Location location;
        if (ADSuyiSdk.getInstance().getContext() == null || (location = ADSuyiSdk.getInstance().getLocation(ADSuyiSdk.getInstance().getContext())) == null) {
            return 0.0d;
        }
        return location.getLatitude();
    }

    @Override // com.bytedance.sdk.openadsdk.LocationProvider
    public double getLongitude() {
        Location location;
        if (ADSuyiSdk.getInstance().getContext() == null || (location = ADSuyiSdk.getInstance().getLocation(ADSuyiSdk.getInstance().getContext())) == null) {
            return 0.0d;
        }
        return location.getLongitude();
    }
}
