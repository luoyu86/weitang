package com.taobao.accs.base;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import androidx.annotation.NonNull;
import com.taobao.accs.messenger.MessengerService;
import com.taobao.accs.utl.ALog;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class TaoBaseService extends Service implements AccsDataListenerV2 {
    private static final String TAG = "TaoBaseService";
    private final AccsAbstractDataListener mDefaultDataListener = new AccsAbstractDataListener() { // from class: com.taobao.accs.base.TaoBaseService.1
        @Override // com.taobao.accs.base.AccsAbstractDataListener, com.taobao.accs.base.AccsDataListener
        public void onBind(String str, int i2, ExtraInfo extraInfo) {
        }

        @Override // com.taobao.accs.base.AccsDataListener
        public void onData(String str, String str2, String str3, byte[] bArr, ExtraInfo extraInfo) {
        }

        @Override // com.taobao.accs.base.AccsAbstractDataListener, com.taobao.accs.base.AccsDataListener
        public void onResponse(String str, String str2, int i2, byte[] bArr, ExtraInfo extraInfo) {
        }

        @Override // com.taobao.accs.base.AccsAbstractDataListener, com.taobao.accs.base.AccsDataListener
        public void onSendData(String str, String str2, int i2, ExtraInfo extraInfo) {
        }

        @Override // com.taobao.accs.base.AccsAbstractDataListener, com.taobao.accs.base.AccsDataListener
        public void onUnbind(String str, int i2, ExtraInfo extraInfo) {
        }
    };
    private final Messenger mMessenger = new Messenger(new MessageHandler(this));

    public enum ExtHeaderType {
        TYPE_BUSINESS,
        TYPE_SID,
        TYPE_USERID,
        TYPE_COOKIE,
        TYPE_TAG,
        TYPE_STATUS,
        TYPE_DELAY,
        TYPE_EXPIRE,
        TYPE_LOCATION,
        TYPE_UNIT,
        TYPE_NEED_BUSINESS_ACK;

        public static ExtHeaderType valueOf(int i2) {
            switch (i2) {
                case 0:
                    return TYPE_BUSINESS;
                case 1:
                    return TYPE_SID;
                case 2:
                    return TYPE_USERID;
                case 3:
                    return TYPE_COOKIE;
                case 4:
                    return TYPE_TAG;
                case 5:
                    return TYPE_STATUS;
                case 6:
                    return TYPE_DELAY;
                case 7:
                    return TYPE_EXPIRE;
                case 8:
                    return TYPE_LOCATION;
                case 9:
                    return TYPE_UNIT;
                case 10:
                    return TYPE_NEED_BUSINESS_ACK;
                default:
                    return null;
            }
        }
    }

    public static class ExtraInfo implements Serializable {
        public static final String EXT_HEADER = "ext_header";
        public int connType;
        public Map<ExtHeaderType, String> extHeader;
        public String fromHost;
        public String fromPackage;
        public Map<Integer, String> oriExtHeader;
    }

    public static class MessageHandler extends Handler {
        private final WeakReference<TaoBaseService> mReference;

        public MessageHandler(TaoBaseService taoBaseService) {
            this.mReference = new WeakReference<>(taoBaseService);
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            ALog.i(TaoBaseService.TAG, "handleMessage on receive msg", "msg", message.toString());
            Intent intent = (Intent) message.getData().getParcelable(MessengerService.INTENT);
            if (intent != null) {
                ALog.i(TaoBaseService.TAG, "handleMessage get intent success", MessengerService.INTENT, intent.toString());
                if (this.mReference.get() != null) {
                    this.mReference.get().onStartCommand(intent, 0, 0);
                }
            }
        }
    }

    @Override // com.taobao.accs.base.AccsDataListener
    public void onAntiBrush(boolean z, ExtraInfo extraInfo) {
        this.mDefaultDataListener.onAntiBrush(z, extraInfo);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.mMessenger.getBinder();
    }

    @Override // com.taobao.accs.base.AccsDataListener
    public void onBind(String str, int i2, ExtraInfo extraInfo) {
    }

    @Override // com.taobao.accs.base.AccsDataListener
    public void onConnected(ConnectInfo connectInfo) {
        this.mDefaultDataListener.onConnected(connectInfo);
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.taobao.accs.base.AccsDataListener
    public void onDisconnected(ConnectInfo connectInfo) {
        this.mDefaultDataListener.onDisconnected(connectInfo);
    }

    @Override // com.taobao.accs.base.AccsDataListenerV2
    public void onResponse(String str, String str2, int i2, String str3, byte[] bArr, ExtraInfo extraInfo) {
        onResponse(str, str2, i2, bArr, extraInfo);
    }

    @Override // com.taobao.accs.base.AccsDataListener
    public void onResponse(String str, String str2, int i2, byte[] bArr, ExtraInfo extraInfo) {
    }

    @Override // com.taobao.accs.base.AccsDataListener
    public void onSendData(String str, String str2, int i2, ExtraInfo extraInfo) {
    }

    @Override // com.taobao.accs.base.AccsDataListenerV2
    public void onSendData(String str, String str2, int i2, String str3, ExtraInfo extraInfo) {
        onSendData(str, str2, i2, extraInfo);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        if (ALog.isPrintLog(ALog.Level.D)) {
            ALog.d(TAG, "onStartCommand", "className", getClass().getSimpleName());
        }
        return AccsAbstractDataListener.onReceiveData(this, intent, this);
    }

    @Override // com.taobao.accs.base.AccsDataListener
    public void onUnbind(String str, int i2, ExtraInfo extraInfo) {
    }

    @Override // com.taobao.accs.base.AccsDataListenerV2
    public void onUnbind(String str, int i2, String str2, ExtraInfo extraInfo) {
        onUnbind(str, i2, extraInfo);
    }

    @Override // com.taobao.accs.base.AccsDataListenerV2
    public void onBind(String str, int i2, String str2, ExtraInfo extraInfo) {
        onBind(str, i2, extraInfo);
    }

    public static class ConnectInfo implements Serializable {
        private static final long serialVersionUID = 8974674111758240362L;
        public boolean connected;
        public int errorCode;
        public String errordetail;
        public String host;
        public boolean isCenterHost;
        public boolean isInapp;

        public ConnectInfo(String str, boolean z, boolean z2) {
            this.host = str;
            this.isInapp = z;
            this.isCenterHost = z2;
        }

        public String toString() {
            return "ConnectInfo{host='" + this.host + "', isInapp=" + this.isInapp + ", isCenterHost=" + this.isCenterHost + ", connected=" + this.connected + ", errorCode=" + this.errorCode + ", errorDetail='" + this.errordetail + "'}";
        }

        public ConnectInfo(String str, boolean z, boolean z2, int i2, String str2) {
            this.host = str;
            this.isInapp = z;
            this.isCenterHost = z2;
            this.errorCode = i2;
            this.errordetail = str2;
        }
    }
}
