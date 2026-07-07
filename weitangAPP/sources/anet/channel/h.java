package anet.channel;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import anet.channel.util.ALog;
import com.taobao.accs.messenger.MessengerService;

/* JADX INFO: loaded from: classes.dex */
public class h implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Intent f480a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f481b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ SessionRequest f482c;

    public h(SessionRequest sessionRequest, Intent intent, Context context) {
        this.f482c = sessionRequest;
        this.f480a = intent;
        this.f481b = context;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        ALog.d("awcn.SessionRequest", "onServiceConnected", null, new Object[0]);
        try {
            try {
                Messenger messenger = new Messenger(iBinder);
                Message message = new Message();
                message.getData().putParcelable(MessengerService.INTENT, this.f480a);
                messenger.send(message);
            } catch (Exception e2) {
                ALog.e("awcn.SessionRequest", "onServiceConnected sendMessage error.", null, e2, new Object[0]);
            }
        } finally {
            this.f481b.unbindService(this);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        ALog.d("awcn.SessionRequest", "onServiceDisconnected", null, new Object[0]);
        this.f481b.unbindService(this);
    }
}
