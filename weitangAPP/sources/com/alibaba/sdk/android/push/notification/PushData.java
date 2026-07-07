package com.alibaba.sdk.android.push.notification;

import android.content.Context;
import android.os.Build;
import com.alibaba.sdk.android.ams.common.logger.AmsLogger;
import com.alibaba.sdk.android.ams.common.util.StringUtil;
import com.alibaba.sdk.android.push.common.util.JSONUtils;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class PushData {
    public static final String KEY_BIG_BODY = "big_body";
    public static final String KEY_BIG_PICTURE = "big_picture";
    public static final String KEY_BIG_TITLE = "big_title";
    public static final String KEY_CHANNEL = "notification_channel";
    public static final String KEY_CONTENT = "content";
    public static final String KEY_CUSTOM_NOTIFICAITON_ID = "custom_notification_id";
    public static final String KEY_EXT = "ext";
    public static final String KEY_IMAGE = "image";
    public static final String KEY_INBOX_CONTENT = "inbox_content";
    public static final String KEY_MSG_ID = "msg_id";
    public static final String KEY_MUSIC = "music";
    public static final String KEY_NOTIFICATION_PRIORITY = "_ALIYUN_NOTIFICATION_PRIORITY_";
    public static final String KEY_NOTIFY_ID = "notify_id";
    public static final String KEY_NOTIFY_TYPE = "remind";
    public static final String KEY_STYLE = "style";
    public static final String KEY_TITLE = "title";
    public static final int NOTIFY_TYPE_SILENT = 0;
    public static final int NOTIFY_TYPE_SOUND = 2;
    public static final int NOTIFY_TYPE_VIBRATE = 1;
    public static final int NOTIFY_TYPE_VIBRATE_SOUND = 3;
    public static final int NO_CUSTOM_NOTIFICATION = 0;
    private String mBigBody;
    private String mBigPicture;
    private String mBigTitle;
    private String mContentText;
    private int mCustomNotificationId;
    private Map<String, String> mExtraMap;
    private String mImage;
    private String mInboxContent;
    private String mMsgId;
    private String mNotificationChannel;
    private int mNotifyId;
    private int mNotifyType;
    private int mPriority;
    private String mSound;
    private String mStyle;
    private String mTitle;
    private static final String TAG = "MPS:PushData";
    private static final AmsLogger LOGGER = AmsLogger.getLogger(TAG);

    public PushData() {
        int i2 = Build.VERSION.SDK_INT;
        this.mPriority = 0;
        this.mCustomNotificationId = 0;
    }

    public static PushData parse(Context context, Map<String, String> map) {
        String str = map.get("title");
        String str2 = map.get("content");
        if (StringUtil.isEmpty(str) || StringUtil.isEmpty(str2)) {
            LOGGER.e("title or content of notify is empty: " + map);
            return null;
        }
        PushData pushData = new PushData();
        String strValueOf = map.get("remind");
        if (StringUtil.isEmpty(strValueOf)) {
            strValueOf = String.valueOf(2);
        }
        String str3 = map.get("music");
        String str4 = map.get("ext");
        String str5 = map.get("notification_channel");
        pushData.setTitle(str);
        pushData.setContentText(str2);
        pushData.setNotifyType(Integer.parseInt(strValueOf));
        pushData.setNotificationChannel(str5);
        pushData.setImage(map.get("image"));
        pushData.setStyle(map.get("style"));
        pushData.setBigTitle(map.get("big_title"));
        pushData.setBigBody(map.get("big_body"));
        pushData.setBigPicture(map.get("big_picture"));
        pushData.setInboxContent(map.get("inbox_content"));
        pushData.setMsgId(map.get("msg_id"));
        try {
            pushData.setNotifyId(Integer.parseInt(map.get("notify_id")));
        } catch (Throwable unused) {
        }
        pushData.setSound(StringUtil.isEmpty(str3) ? null : str3);
        if (!StringUtil.isEmpty(str4)) {
            try {
                Map<String, String> map2 = JSONUtils.toMap(new JSONObject(str4));
                pushData.setPriority(map2.containsKey("_ALIYUN_NOTIFICATION_PRIORITY_") ? map2.get("_ALIYUN_NOTIFICATION_PRIORITY_") : Build.VERSION.SDK_INT >= 16 ? String.valueOf(0) : String.valueOf(0));
                pushData.setExtraMap(map2);
            } catch (JSONException e2) {
                LOGGER.e("Parse inner json(ext) error:", e2);
            }
        }
        if (map.containsKey(KEY_CUSTOM_NOTIFICAITON_ID)) {
            pushData.setCustomNotificationId(Integer.parseInt(map.get(KEY_CUSTOM_NOTIFICAITON_ID)));
        }
        return pushData;
    }

    private void setBigBody(String str) {
        this.mBigBody = str;
    }

    private void setBigPicture(String str) {
        this.mBigPicture = str;
    }

    private void setBigTitle(String str) {
        this.mBigTitle = str;
    }

    private void setContentText(String str) {
        this.mContentText = str;
    }

    private void setCustomNotificationId(int i2) {
        this.mCustomNotificationId = i2;
    }

    private void setExtraMap(Map<String, String> map) {
        this.mExtraMap = map;
    }

    private void setInboxContent(String str) {
        this.mInboxContent = str;
    }

    private void setMsgId(String str) {
        this.mMsgId = str;
    }

    private void setNotificationChannel(String str) {
        this.mNotificationChannel = str;
    }

    private void setNotifyId(int i2) {
        this.mNotifyId = i2;
    }

    private void setNotifyType(int i2) {
        this.mNotifyType = i2;
    }

    private void setPriority(String str) {
        try {
            this.mPriority = Integer.parseInt(str);
        } catch (NumberFormatException e2) {
            LOGGER.e("formar error:数字格式错误", e2);
        }
    }

    private void setSound(String str) {
        this.mSound = str;
    }

    private void setStyle(String str) {
        this.mStyle = str;
    }

    private void setTitle(String str) {
        this.mTitle = str;
    }

    public String getBigBody() {
        return this.mBigBody;
    }

    public String getBigPicture() {
        return this.mBigPicture;
    }

    public String getBigTitle() {
        return this.mBigTitle;
    }

    public String getContentText() {
        return this.mContentText;
    }

    public int getCustomNotificationId() {
        return this.mCustomNotificationId;
    }

    public Map<String, String> getExtraMap() {
        return this.mExtraMap;
    }

    public String getImage() {
        return this.mImage;
    }

    public String getInboxContent() {
        return this.mInboxContent;
    }

    public String getMsgId() {
        return this.mMsgId;
    }

    public String getNotificationChannel() {
        return this.mNotificationChannel;
    }

    public int getNotifyId() {
        return this.mNotifyId;
    }

    public int getNotifyType() {
        return this.mNotifyType;
    }

    public int getPriority() {
        return this.mPriority;
    }

    public String getSound() {
        return this.mSound;
    }

    public String getStyle() {
        return this.mStyle;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public void setImage(String str) {
        this.mImage = str;
    }

    public String toString() {
        return "PushData{title='" + this.mTitle + "', contentText='" + this.mContentText + "', image='" + this.mImage + "', notifyType=" + this.mNotifyType + ", sound='" + this.mSound + "', notificationChannel='" + this.mNotificationChannel + "', priority=" + this.mPriority + ", customNotificationId=" + this.mCustomNotificationId + ", extraMap=" + this.mExtraMap + ", style='" + this.mStyle + "', bigTitle='" + this.mBigTitle + "', bigPicture='" + this.mBigPicture + "', bigBody='" + this.mBigBody + "', inboxContent='" + this.mInboxContent + "', notifyId=" + this.mNotifyId + ", msgId='" + this.mMsgId + "'}";
    }
}
