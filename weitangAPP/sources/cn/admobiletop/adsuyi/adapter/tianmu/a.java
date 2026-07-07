package cn.admobiletop.adsuyi.adapter.tianmu;

import android.location.Location;
import cn.admobiletop.adsuyi.ADSuyiSdk;
import com.tianmu.config.TianmuLocationProvider;

/* JADX INFO: loaded from: classes.dex */
public class a implements TianmuLocationProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f3789a;

    public a(b bVar) {
        this.f3789a = bVar;
    }

    @Override // com.tianmu.config.TianmuLocationProvider
    public double getLatitude() {
        Location location;
        if (ADSuyiSdk.getInstance().getContext() == null || (location = ADSuyiSdk.getInstance().getLocation(ADSuyiSdk.getInstance().getContext())) == null) {
            return 0.0d;
        }
        return location.getLatitude();
    }

    @Override // com.tianmu.config.TianmuLocationProvider
    public double getLongitude() {
        Location location;
        if (ADSuyiSdk.getInstance().getContext() == null || (location = ADSuyiSdk.getInstance().getLocation(ADSuyiSdk.getInstance().getContext())) == null) {
            return 0.0d;
        }
        return location.getLongitude();
    }
}
