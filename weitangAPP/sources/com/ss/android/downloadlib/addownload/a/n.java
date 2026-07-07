package com.ss.android.downloadlib.addownload.a;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.downloadad.api.download.AdDownloadController;
import com.ss.android.downloadad.api.download.AdDownloadEventConfig;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class n implements com.ss.android.downloadad.api.ok.ok {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public DownloadModel f9775a;
    public DownloadEventConfig bl;
    public com.ss.android.downloadad.api.ok.a n;
    public long ok;
    public DownloadController s;

    public n() {
    }

    @Override // com.ss.android.downloadad.api.ok.ok
    public long a() {
        return this.f9775a.getId();
    }

    @Override // com.ss.android.downloadad.api.ok.ok
    public boolean bl() {
        return this.f9775a.isAd();
    }

    @Override // com.ss.android.downloadad.api.ok.ok
    public JSONObject h() {
        return this.f9775a.getExtra();
    }

    @Override // com.ss.android.downloadad.api.ok.ok
    public JSONObject i() {
        return this.bl.getExtraJson();
    }

    @Override // com.ss.android.downloadad.api.ok.ok
    public DownloadModel io() {
        return this.f9775a;
    }

    @Override // com.ss.android.downloadad.api.ok.ok
    public long j() {
        return this.f9775a.getExtraValue();
    }

    @Override // com.ss.android.downloadad.api.ok.ok
    public String k() {
        return this.bl.getClickButtonTag();
    }

    @Override // com.ss.android.downloadad.api.ok.ok
    public String kf() {
        if (this.f9775a.getDeepLink() != null) {
            return this.f9775a.getDeepLink().getOpenUrl();
        }
        return null;
    }

    public boolean m() {
        if (y()) {
            return false;
        }
        if (!this.f9775a.isAd()) {
            return this.f9775a instanceof AdDownloadModel;
        }
        DownloadModel downloadModel = this.f9775a;
        return (downloadModel instanceof AdDownloadModel) && !TextUtils.isEmpty(downloadModel.getLogExtra()) && (this.bl instanceof AdDownloadEventConfig) && (this.s instanceof AdDownloadController);
    }

    @Override // com.ss.android.downloadad.api.ok.ok
    public String n() {
        return this.f9775a.getPackageName();
    }

    @Override // com.ss.android.downloadad.api.ok.ok
    public DownloadController o() {
        return this.s;
    }

    @Override // com.ss.android.downloadad.api.ok.ok
    public String ok() {
        return this.f9775a.getDownloadUrl();
    }

    @Override // com.ss.android.downloadad.api.ok.ok
    public int p() {
        if (this.s.getDownloadMode() == 2) {
            return 2;
        }
        return this.f9775a.getFunnelType();
    }

    @Override // com.ss.android.downloadad.api.ok.ok
    public String q() {
        return this.bl.getRefer();
    }

    @Override // com.ss.android.downloadad.api.ok.ok
    public JSONObject r() {
        return this.bl.getParamsJson();
    }

    @Override // com.ss.android.downloadad.api.ok.ok
    public List<String> rh() {
        return this.f9775a.getClickTrackUrl();
    }

    @Override // com.ss.android.downloadad.api.ok.ok
    public String s() {
        return this.f9775a.getLogExtra();
    }

    @Override // com.ss.android.downloadad.api.ok.ok
    public Object t() {
        return this.bl.getExtraEventObject();
    }

    @Override // com.ss.android.downloadad.api.ok.ok
    public JSONObject td() {
        return this.f9775a.getDownloadSettings();
    }

    @Override // com.ss.android.downloadad.api.ok.ok
    public int u() {
        return this.bl.getDownloadScene();
    }

    @Override // com.ss.android.downloadad.api.ok.ok
    public DownloadEventConfig ul() {
        return this.bl;
    }

    @Override // com.ss.android.downloadad.api.ok.ok
    public boolean x() {
        return this.s.enableNewActivity();
    }

    public boolean y() {
        DownloadModel downloadModel;
        if (this.ok == 0 || (downloadModel = this.f9775a) == null || this.bl == null || this.s == null) {
            return true;
        }
        return downloadModel.isAd() && this.ok <= 0;
    }

    @Override // com.ss.android.downloadad.api.ok.ok
    public boolean z() {
        return this.bl.isEnableV3Event();
    }

    @Override // com.ss.android.downloadad.api.ok.ok
    public int zz() {
        return 0;
    }

    public n(long j, @NonNull DownloadModel downloadModel, @NonNull DownloadEventConfig downloadEventConfig, @NonNull DownloadController downloadController) {
        this.ok = j;
        this.f9775a = downloadModel;
        this.bl = downloadEventConfig;
        this.s = downloadController;
    }
}
