package c.a.a.a.a;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import com.aliyun.ams.emas.push.AgooMessageIntentService;
import com.taobao.accs.messenger.MessengerService;

/* JADX INFO: loaded from: classes.dex */
public class f extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AgooMessageIntentService f790a;

    public f(AgooMessageIntentService agooMessageIntentService) {
        this.f790a = agooMessageIntentService;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Intent intent;
        if (message == null || (intent = (Intent) message.getData().getParcelable(MessengerService.INTENT)) == null) {
            return;
        }
        this.f790a.onStartCommand(intent, 0, 0);
    }
}
