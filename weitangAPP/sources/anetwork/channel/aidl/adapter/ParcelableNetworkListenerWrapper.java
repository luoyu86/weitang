package anetwork.channel.aidl.adapter;

import a.a.c;
import a.a.d;
import a.a.e;
import a.a.f;
import a.a.i;
import a.a.m.b.a;
import android.os.Handler;
import android.os.RemoteException;
import anet.channel.util.ALog;
import anetwork.channel.aidl.DefaultFinishEvent;
import anetwork.channel.aidl.DefaultProgressEvent;
import anetwork.channel.aidl.ParcelableHeader;
import anetwork.channel.aidl.ParcelableInputStream;
import anetwork.channel.aidl.ParcelableNetworkListener;

/* JADX INFO: loaded from: classes.dex */
public class ParcelableNetworkListenerWrapper extends ParcelableNetworkListener.Stub {
    private static final String TAG = "anet.ParcelableNetworkListenerWrapper";
    private Handler handler;
    private i listener;
    private Object mContext;
    private byte state;

    public ParcelableNetworkListenerWrapper(i iVar, Handler handler, Object obj) {
        this.state = (byte) 0;
        this.listener = iVar;
        if (iVar != null) {
            if (c.class.isAssignableFrom(iVar.getClass())) {
                this.state = (byte) (this.state | 1);
            }
            if (e.class.isAssignableFrom(iVar.getClass())) {
                this.state = (byte) (this.state | 2);
            }
            if (f.class.isAssignableFrom(iVar.getClass())) {
                this.state = (byte) (this.state | 4);
            }
            if (d.class.isAssignableFrom(iVar.getClass())) {
                this.state = (byte) (this.state | 8);
            }
        }
        this.handler = handler;
        this.mContext = obj;
    }

    private void dispatch(byte b2, Object obj) {
        Handler handler = this.handler;
        if (handler == null) {
            dispatchCallback(b2, obj);
        } else {
            handler.post(new a(this, b2, obj));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchCallback(byte b2, Object obj) {
        try {
            if (b2 == 4) {
                ParcelableHeader parcelableHeader = (ParcelableHeader) obj;
                ((f) this.listener).onResponseCode(parcelableHeader.getResponseCode(), parcelableHeader.getHeader(), this.mContext);
                if (ALog.isPrintLog(1)) {
                    ALog.d(TAG, "[onResponseCode]" + parcelableHeader, null, new Object[0]);
                    return;
                }
                return;
            }
            if (b2 == 2) {
                DefaultProgressEvent defaultProgressEvent = (DefaultProgressEvent) obj;
                if (defaultProgressEvent != null) {
                    defaultProgressEvent.setContext(this.mContext);
                }
                ((e) this.listener).onDataReceived(defaultProgressEvent, this.mContext);
                if (ALog.isPrintLog(1)) {
                    ALog.d(TAG, "[onDataReceived]" + defaultProgressEvent, null, new Object[0]);
                    return;
                }
                return;
            }
            if (b2 != 1) {
                if (b2 == 8) {
                    ((d) this.listener).onInputStreamGet((ParcelableInputStream) obj, this.mContext);
                    if (ALog.isPrintLog(1)) {
                        ALog.d(TAG, "[onInputStreamReceived]", null, new Object[0]);
                        return;
                    }
                    return;
                }
                return;
            }
            DefaultFinishEvent defaultFinishEvent = (DefaultFinishEvent) obj;
            if (defaultFinishEvent != null) {
                defaultFinishEvent.setContext(this.mContext);
            }
            ((c) this.listener).onFinished(defaultFinishEvent, this.mContext);
            if (ALog.isPrintLog(1)) {
                ALog.d(TAG, "[onFinished]" + defaultFinishEvent, null, new Object[0]);
            }
        } catch (Exception unused) {
            ALog.e(TAG, "dispatchCallback error", null, new Object[0]);
        }
    }

    public i getListener() {
        return this.listener;
    }

    @Override // anetwork.channel.aidl.ParcelableNetworkListener
    public byte getListenerState() throws RemoteException {
        return this.state;
    }

    @Override // anetwork.channel.aidl.ParcelableNetworkListener
    public void onDataReceived(DefaultProgressEvent defaultProgressEvent) throws RemoteException {
        if ((this.state & 2) != 0) {
            dispatch((byte) 2, defaultProgressEvent);
        }
    }

    @Override // anetwork.channel.aidl.ParcelableNetworkListener
    public void onFinished(DefaultFinishEvent defaultFinishEvent) throws RemoteException {
        if ((this.state & 1) != 0) {
            dispatch((byte) 1, defaultFinishEvent);
        }
        this.listener = null;
        this.mContext = null;
        this.handler = null;
    }

    @Override // anetwork.channel.aidl.ParcelableNetworkListener
    public void onInputStreamGet(ParcelableInputStream parcelableInputStream) throws RemoteException {
        if ((this.state & 8) != 0) {
            dispatch((byte) 8, parcelableInputStream);
        }
    }

    @Override // anetwork.channel.aidl.ParcelableNetworkListener
    public boolean onResponseCode(int i2, ParcelableHeader parcelableHeader) throws RemoteException {
        if ((this.state & 4) == 0) {
            return false;
        }
        dispatch((byte) 4, parcelableHeader);
        return false;
    }
}
