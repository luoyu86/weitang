package c.a.a.a.a;

import android.content.Context;
import com.aliyun.ams.emas.push.notification.CPushMessage;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public interface b {
    void onMessageArrived(Context context, CPushMessage cPushMessage);

    void onNotificationOpened(Context context, String str, String str2, String str3, int i2);

    void onNotificationReceivedWithoutShow(Context context, String str, String str2, Map<String, String> map, int i2, String str3, String str4);

    void onNotificationRemoved(Context context, String str, String str2, String str3, int i2, String str4);

    void onNotificationShow(Context context, String str, String str2, Map<String, String> map);
}
