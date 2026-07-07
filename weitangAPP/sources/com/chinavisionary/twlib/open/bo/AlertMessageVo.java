package com.chinavisionary.twlib.open.bo;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.chinavisionary.core.app.net.base.dto.NewBaseVo;

/* JADX INFO: loaded from: classes2.dex */
public class AlertMessageVo extends NewBaseVo implements Parcelable {
    public static final Parcelable.Creator<AlertMessageVo> CREATOR = new a();
    public static final String HELP_URL = "https://app.yuanjingweitang.com/help.html";
    public static final String PRIVACY_URL = "https://app.yuanjingweitang.com/privacy.html";
    public static final String REGISTER_PROTOCOL_URL = "https://app.yuanjingweitang.com/register.html";
    private static final String TAG = "AlertMessageVo";
    public static final int TYPE_APP_LOGIN_PROTOCOL = 6999;
    public static final int TYPE_APP_NOT_NETWORK = 5900;
    public static final int TYPE_APP_PROTOCOL = 5999;
    public static final int TYPE_CONTRACT_WAIT_PAY = 1;
    public static final int TYPE_CONTRACT_WAIT_SIGN = 2;
    public static final int TYPE_OPEN_ALI_MINI_PROGRAM = 18;
    public static final int TYPE_OPEN_COMMENT_UI = 19;
    public static final int TYPE_OPEN_WX_MINI_PROGRAM = 15;
    public static final int TYPE_OTHER = 5;
    public static final int TYPE_RENT_FEE = 0;
    public static final int TYPE_WALLET_RECHARGE = 7;
    private String cancelText;
    private String centerText;
    private String confirmText;
    private String content;
    private int countDownTime;
    private int forwardType;
    private String href;
    private Boolean isForce;
    private String messageKey;
    private Integer messageType;
    private String primaryKey;
    private String targetAppid;
    private String targetMiniType;
    private String targetPath;
    private String title;
    private String version;

    public class a implements Parcelable.Creator<AlertMessageVo> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AlertMessageVo createFromParcel(Parcel parcel) {
            return new AlertMessageVo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AlertMessageVo[] newArray(int i2) {
            return new AlertMessageVo[i2];
        }
    }

    public AlertMessageVo() {
        this.forwardType = -1;
        this.countDownTime = 5;
        this.isForce = Boolean.FALSE;
        this.messageType = -1;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getCancelText() {
        return this.cancelText;
    }

    public String getCenterText() {
        return this.centerText;
    }

    public String getConfirmText() {
        return this.confirmText;
    }

    public String getContent() {
        return this.content;
    }

    public int getCountDownTime() {
        return this.countDownTime;
    }

    public Boolean getForce() {
        if (c.e.a.a.a.getInstance().isAdmin()) {
            return Boolean.FALSE;
        }
        Boolean bool = this.isForce;
        return bool == null ? Boolean.FALSE : bool;
    }

    public int getForwardType() {
        return this.forwardType;
    }

    public String getHref() {
        return this.href;
    }

    public String getMessageKey() {
        String str = this.primaryKey;
        return str != null ? str : this.messageKey;
    }

    public Integer getMessageType() {
        return this.messageType;
    }

    public String getPrimaryKey() {
        return this.primaryKey;
    }

    public String getTargetAppid() {
        return this.targetAppid;
    }

    public String getTargetMiniType() {
        return this.targetMiniType;
    }

    public String getTargetPath() {
        return this.targetPath;
    }

    public String getTitle() {
        return this.title;
    }

    public String getVersion() {
        return this.version;
    }

    public void readFromParcel(Parcel parcel) {
        try {
            this.cancelText = parcel.readString();
            this.confirmText = parcel.readString();
            this.content = parcel.readString();
            this.forwardType = parcel.readInt();
            this.href = parcel.readString();
            this.isForce = (Boolean) parcel.readValue(Boolean.class.getClassLoader());
            this.messageKey = parcel.readString();
            this.messageType = Integer.valueOf(parcel.readInt());
            this.title = parcel.readString();
            this.version = parcel.readString();
            setBaseKey(parcel.readString());
            setCode(parcel.readString());
            setSuccess(parcel.readByte() != 0);
            setMessage(parcel.readString());
            setCountDownTime(parcel.readInt());
            Log.d(TAG, "readFromParcel");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setCancelText(String str) {
        this.cancelText = str;
    }

    public void setCenterText(String str) {
        this.centerText = str;
    }

    public void setConfirmText(String str) {
        this.confirmText = str;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setCountDownTime(int i2) {
        this.countDownTime = i2;
    }

    public void setForce(Boolean bool) {
        this.isForce = bool;
    }

    public void setForwardType(int i2) {
        this.forwardType = i2;
    }

    public void setHref(String str) {
        this.href = str;
    }

    public void setMessageKey(String str) {
        this.messageKey = str;
    }

    public void setMessageType(Integer num) {
        this.messageType = num;
    }

    public void setPrimaryKey(String str) {
        this.primaryKey = str;
    }

    public void setTargetAppid(String str) {
        this.targetAppid = str;
    }

    public void setTargetMiniType(String str) {
        this.targetMiniType = str;
    }

    public void setTargetPath(String str) {
        this.targetPath = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setVersion(String str) {
        this.version = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        try {
            parcel.writeString(this.cancelText);
            parcel.writeString(this.confirmText);
            parcel.writeString(this.content);
            parcel.writeInt(this.forwardType);
            parcel.writeString(this.href);
            parcel.writeValue(this.isForce);
            parcel.writeString(this.messageKey);
            parcel.writeInt(this.messageType.intValue());
            parcel.writeString(this.title);
            parcel.writeString(this.version);
            parcel.writeString(this.primaryKey);
            parcel.writeString(getBaseKey());
            parcel.writeString(getCode());
            parcel.writeByte(isSuccess() ? (byte) 1 : (byte) 0);
            parcel.writeString(getMessage());
            parcel.writeInt(this.countDownTime);
            Log.d(TAG, "writeToParcel");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public AlertMessageVo(Parcel parcel) {
        this.forwardType = -1;
        this.countDownTime = 5;
        this.isForce = Boolean.FALSE;
        this.messageType = -1;
        try {
            this.cancelText = parcel.readString();
            this.confirmText = parcel.readString();
            this.content = parcel.readString();
            this.forwardType = parcel.readInt();
            this.href = parcel.readString();
            this.isForce = (Boolean) parcel.readValue(Boolean.class.getClassLoader());
            this.messageKey = parcel.readString();
            this.messageType = Integer.valueOf(parcel.readInt());
            this.title = parcel.readString();
            this.version = parcel.readString();
            this.primaryKey = parcel.readString();
            setBaseKey(parcel.readString());
            setCode(parcel.readString());
            setSuccess(parcel.readByte() != 0);
            setMessage(parcel.readString());
            this.countDownTime = parcel.readInt();
            Log.d(TAG, TAG);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
