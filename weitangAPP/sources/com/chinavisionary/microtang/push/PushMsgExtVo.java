package com.chinavisionary.microtang.push;

import c.e.a.d.x;
import com.chinavisionary.core.app.net.base.dto.BaseVo;

/* JADX INFO: loaded from: classes2.dex */
public class PushMsgExtVo extends BaseVo {
    private String URL;
    private String forwardType;
    private String messageCreateTime;
    private String messageKey;
    private String unreadCount;
    private String unreadShowType;

    public String getForwardType() {
        return this.forwardType;
    }

    public String getMessageCreateTime() {
        return this.messageCreateTime;
    }

    public String getMessageKey() {
        return this.messageKey;
    }

    public int getMsgCount() {
        if (x.isNotNull(this.unreadCount)) {
            try {
                return Integer.parseInt(this.unreadCount);
            } catch (NumberFormatException e2) {
                e2.printStackTrace();
            }
        }
        return 0;
    }

    public int getShowType() {
        if (x.isNotNull(this.unreadShowType)) {
            try {
                return Integer.parseInt(this.unreadShowType);
            } catch (NumberFormatException e2) {
                e2.printStackTrace();
            }
        }
        return 1;
    }

    public String getURL() {
        return this.URL;
    }

    public String getUnreadCount() {
        return this.unreadCount;
    }

    public String getUnreadShowType() {
        return this.unreadShowType;
    }

    public void setForwardType(String str) {
        this.forwardType = str;
    }

    public void setMessageCreateTime(String str) {
        this.messageCreateTime = str;
    }

    public void setMessageKey(String str) {
        this.messageKey = str;
    }

    public void setURL(String str) {
        this.URL = str;
    }

    public void setUnreadCount(String str) {
        this.unreadCount = str;
    }

    public void setUnreadShowType(String str) {
        this.unreadShowType = str;
    }
}
