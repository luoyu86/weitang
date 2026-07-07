package com.taobao.accs;

import android.app.Notification;
import com.taobao.accs.ChannelService;
import com.taobao.accs.utl.ALog;

/* JADX INFO: loaded from: classes2.dex */
public class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ChannelService.KernelService f10245a;

    public b(ChannelService.KernelService kernelService) {
        this.f10245a = kernelService;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            ChannelService channelService = ChannelService.getInstance();
            int i2 = this.f10245a.f10236b.getPackageManager().getPackageInfo(this.f10245a.getPackageName(), 0).applicationInfo.icon;
            if (i2 != 0) {
                Notification.Builder builder = new Notification.Builder(this.f10245a.f10236b);
                builder.setSmallIcon(i2);
                channelService.startForeground(ChannelService.NOTIFY_ID, builder.build());
                Notification.Builder builder2 = new Notification.Builder(this.f10245a.f10236b);
                builder2.setSmallIcon(i2);
                ChannelService.KernelService.f10235a.startForeground(ChannelService.NOTIFY_ID, builder2.build());
                ChannelService.KernelService.f10235a.stopForeground(true);
            }
            ChannelService.KernelService.f10235a.stopSelf();
        } catch (Throwable th) {
            ALog.e(ChannelService.TAG, " onStartCommand run", th, new Object[0]);
        }
    }
}
