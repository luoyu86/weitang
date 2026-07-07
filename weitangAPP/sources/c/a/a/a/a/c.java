package c.a.a.a.a;

import android.app.Notification;
import android.content.Context;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public interface c {
    boolean checkNotificationShowInInnerGroup(Map<String, String> map);

    Notification customNotificationUI(Context context, Map<String, String> map);

    Notification customSummaryNotification(Context context, Map<String, String> map);

    boolean showNotificationNow(Context context, Map<String, String> map);
}
