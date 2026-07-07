package c.e.c.z.c;

import c.e.a.d.x;
import c.e.c.e0.a.b;
import com.chinavisionary.microtang.main.event.EventBadgeMsgVo;
import com.chinavisionary.microtang.msg.vo.BadgeCountVo;

/* JADX INFO: loaded from: classes.dex */
public class a {
    public static void checkIsClearNotify(String str) {
        String notifyMessageKey = b.getInstance().getNotifyMessageKey();
        if (x.isNotNull(notifyMessageKey) && notifyMessageKey.equals(str)) {
            clearNotification();
        }
    }

    public static void clearNotification() {
        c.e.c.e0.a.a.getInstance().recycler();
    }

    public EventBadgeMsgVo getEventBadgeMsgVo(BadgeCountVo badgeCountVo) {
        EventBadgeMsgVo eventBadgeMsgVo = new EventBadgeMsgVo();
        eventBadgeMsgVo.setShow(badgeCountVo.isShowNumber());
        eventBadgeMsgVo.setShowPaint(badgeCountVo.isShowPoint());
        eventBadgeMsgVo.setBadgeNumber(badgeCountVo.getUnreadCount());
        return eventBadgeMsgVo;
    }
}
