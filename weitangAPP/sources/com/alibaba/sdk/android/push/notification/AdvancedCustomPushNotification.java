package com.alibaba.sdk.android.push.notification;

/* JADX INFO: loaded from: classes.dex */
public class AdvancedCustomPushNotification extends BasicCustomPushNotification {
    private final int mContentView;
    private int mIcon = 0;
    private final int mIconView;
    private final int mNotificationView;
    private final int mTitleView;

    public AdvancedCustomPushNotification(int i2, int i3, int i4, int i5) {
        this.notificationType = 3;
        this.mNotificationView = i2;
        this.mTitleView = i4;
        this.mIconView = i3;
        this.mContentView = i5;
    }

    public int getContentView() {
        return this.mContentView;
    }

    public int getIcon() {
        return this.mIcon;
    }

    public int getIconView() {
        return this.mIconView;
    }

    public int getNotificationView() {
        return this.mNotificationView;
    }

    public int getTitleView() {
        return this.mTitleView;
    }

    public void setIcon(int i2) {
        this.mIcon = i2;
    }

    @Override // com.alibaba.sdk.android.push.notification.BasicCustomPushNotification
    public String toString() {
        return super.toString() + ", notificationView:" + this.mNotificationView + ", titleView:" + this.mTitleView + ", iconView:" + this.mTitleView + ", contentView:" + this.mContentView;
    }
}
