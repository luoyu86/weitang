package e.a.a.b;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Build;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    public static List<ResolveInfo> resolveBroadcast(Context context, Intent intent) {
        List<ResolveInfo> listQueryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 0);
        return listQueryBroadcastReceivers != null ? listQueryBroadcastReceivers : Collections.emptyList();
    }

    public static void sendDefaultIntentExplicitly(Context context, Intent intent) throws e.a.a.a {
        boolean z = false;
        if (Build.VERSION.SDK_INT >= 26) {
            Intent intent2 = new Intent(intent);
            intent2.setAction("me.leolin.shortcutbadger.BADGE_COUNT_UPDATE");
            try {
                sendIntentExplicitly(context, intent2);
                z = true;
            } catch (e.a.a.a unused) {
            }
        }
        if (z) {
            return;
        }
        sendIntentExplicitly(context, intent);
    }

    public static void sendIntentExplicitly(Context context, Intent intent) throws e.a.a.a {
        List<ResolveInfo> listResolveBroadcast = resolveBroadcast(context, intent);
        if (listResolveBroadcast.size() == 0) {
            throw new e.a.a.a("unable to resolve intent: " + intent.toString());
        }
        for (ResolveInfo resolveInfo : listResolveBroadcast) {
            Intent intent2 = new Intent(intent);
            if (resolveInfo != null) {
                intent2.setPackage(resolveInfo.resolvePackageName);
                context.sendBroadcast(intent2);
            }
        }
    }
}
