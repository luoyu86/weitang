package c.a.a.a.a;

import android.app.Notification;
import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f791a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f792b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Map f793c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f794d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ boolean f795e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Handler f796f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ l f797g;

    public h(c cVar, Context context, Map map, String str, boolean z, Handler handler, l lVar) {
        this.f791a = cVar;
        this.f792b = context;
        this.f793c = map;
        this.f794d = str;
        this.f795e = z;
        this.f796f = handler;
        this.f797g = lVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Notification notificationCustomNotificationUI = this.f791a.customNotificationUI(this.f792b, this.f793c);
        Notification notificationCustomSummaryNotification = (!TextUtils.isEmpty(this.f794d) || this.f795e) ? this.f791a.customSummaryNotification(this.f792b, this.f793c) : null;
        Handler handler = this.f796f;
        if (handler != null) {
            handler.post(new i(this, notificationCustomNotificationUI, notificationCustomSummaryNotification));
        } else {
            this.f797g.a(notificationCustomNotificationUI, notificationCustomSummaryNotification);
        }
    }
}
