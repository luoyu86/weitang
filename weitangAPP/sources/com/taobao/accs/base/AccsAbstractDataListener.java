package com.taobao.accs.base;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.alibaba.sdk.android.error.ErrorCode;
import com.taobao.accs.ACCSManager;
import com.taobao.accs.IACCSManager;
import com.taobao.accs.base.TaoBaseService;
import com.taobao.accs.common.Constants;
import com.taobao.accs.ut.monitor.NetPerformanceMonitor;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.AppMonitorAdapter;
import com.taobao.accs.utl.BaseMonitor;
import com.taobao.accs.utl.UTMini;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AccsAbstractDataListener implements AccsDataListenerV2 {
    private static final String TAG = "AccsAbstractDataListener";

    private static Map<TaoBaseService.ExtHeaderType, String> getExtHeader(Map<Integer, String> map) {
        HashMap map2;
        HashMap map3 = null;
        if (map == null) {
            return null;
        }
        try {
            map2 = new HashMap();
        } catch (Exception e2) {
            e = e2;
        }
        try {
            for (TaoBaseService.ExtHeaderType extHeaderType : TaoBaseService.ExtHeaderType.values()) {
                String str = map.get(Integer.valueOf(extHeaderType.ordinal()));
                if (!TextUtils.isEmpty(str)) {
                    map2.put(extHeaderType, str);
                }
            }
            return map2;
        } catch (Exception e3) {
            e = e3;
            map3 = map2;
            ALog.e(TAG, "getExtHeader", e, new Object[0]);
            return map3;
        }
    }

    private static TaoBaseService.ExtraInfo getExtraInfo(Intent intent) {
        TaoBaseService.ExtraInfo extraInfo = new TaoBaseService.ExtraInfo();
        try {
            HashMap map = (HashMap) intent.getSerializableExtra(TaoBaseService.ExtraInfo.EXT_HEADER);
            Map<TaoBaseService.ExtHeaderType, String> extHeader = getExtHeader(map);
            String stringExtra = intent.getStringExtra("packageName");
            String stringExtra2 = intent.getStringExtra("host");
            extraInfo.connType = intent.getIntExtra(Constants.KEY_CONN_TYPE, 0);
            extraInfo.extHeader = extHeader;
            extraInfo.oriExtHeader = map;
            extraInfo.fromPackage = stringExtra;
            extraInfo.fromHost = stringExtra2;
        } catch (Throwable th) {
            ALog.e(TAG, "getExtraInfo", th, new Object[0]);
        }
        return extraInfo;
    }

    public static int onReceiveData(Context context, Intent intent, AccsDataListenerV2 accsDataListenerV2) {
        String stringExtra;
        String str = "onReceiveData";
        if (accsDataListenerV2 == null || context == null) {
            ALog.e(TAG, "onReceiveData listener or context null", new Object[0]);
            return 2;
        }
        if (intent == null) {
            return 2;
        }
        String stringExtra2 = "";
        try {
            int intExtra = intent.getIntExtra("command", -1);
            ErrorCode errorCode = Constants.getErrorCode(intent);
            String stringExtra3 = intent.getStringExtra(Constants.KEY_USER_ID);
            stringExtra = intent.getStringExtra(Constants.KEY_DATA_ID);
            stringExtra2 = intent.getStringExtra(Constants.KEY_SERVICE_ID);
            if (ALog.isPrintLog(ALog.Level.I)) {
                try {
                    ALog.i(TAG, "onReceiveData", Constants.KEY_DATA_ID, stringExtra, Constants.KEY_SERVICE_ID, stringExtra2, "command", Integer.valueOf(intExtra), "className", accsDataListenerV2.getClass().getName());
                } catch (Exception e2) {
                    e = e2;
                    stringExtra = "onReceiveData";
                    str = "1";
                    AppMonitorAdapter.commitAlarmFail("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, stringExtra2, str, "callback error" + e.toString());
                    ALog.e(TAG, stringExtra, e, new Object[0]);
                    return 2;
                }
            }
            try {
                if (intExtra > 0) {
                    UTMini.getInstance().commitEvent(66001, "MsgToBuss5", "commandId=" + intExtra, "serviceId=" + stringExtra2 + " dataId=" + stringExtra, Integer.valueOf(Constants.SDK_VERSION_CODE));
                    stringExtra = "onReceiveData";
                    try {
                        AppMonitorAdapter.commitCount("accs", BaseMonitor.COUNT_POINT_TO_BUSS, "3commandId=" + intExtra + "serviceId=" + stringExtra2, 0.0d);
                        if (intExtra == 5) {
                            str = "1";
                            accsDataListenerV2.onBind(stringExtra2, errorCode.getCodeInt(), getExtraInfo(intent));
                        } else if (intExtra == 6) {
                            str = "1";
                            accsDataListenerV2.onUnbind(stringExtra2, errorCode.getCodeInt(), getExtraInfo(intent));
                        } else if (intExtra == 100) {
                            str = "1";
                            String stringExtra4 = intent.getStringExtra(Constants.KEY_DATA_ID);
                            if (TextUtils.equals(Constants.SEND_TYPE_RES, intent.getStringExtra(Constants.KEY_SEND_TYPE))) {
                                accsDataListenerV2.onResponse(stringExtra2, stringExtra4, errorCode.getCodeInt(), errorCode.getMsg(), intent.getByteArrayExtra("data"), getExtraInfo(intent));
                            } else {
                                accsDataListenerV2.onSendData(stringExtra2, stringExtra4, errorCode.getCodeInt(), errorCode.getMsg(), getExtraInfo(intent));
                            }
                        } else {
                            if (intExtra != 101) {
                                if (intExtra == 103) {
                                    boolean booleanExtra = intent.getBooleanExtra(Constants.KEY_CONNECT_AVAILABLE, false);
                                    String stringExtra5 = intent.getStringExtra("host");
                                    boolean booleanExtra2 = intent.getBooleanExtra(Constants.KEY_TYPE_INAPP, false);
                                    boolean booleanExtra3 = intent.getBooleanExtra(Constants.KEY_CENTER_HOST, false);
                                    if (TextUtils.isEmpty(stringExtra5)) {
                                        return 2;
                                    }
                                    if (booleanExtra) {
                                        accsDataListenerV2.onConnected(new TaoBaseService.ConnectInfo(stringExtra5, booleanExtra2, booleanExtra3));
                                        return 2;
                                    }
                                    accsDataListenerV2.onDisconnected(new TaoBaseService.ConnectInfo(stringExtra5, booleanExtra2, booleanExtra3, errorCode.getCodeInt(), errorCode.getMsg()));
                                    return 2;
                                }
                                if (intExtra != 104) {
                                    ALog.w(TAG, "onReceiveData command not handled " + intExtra, new Object[0]);
                                    return 2;
                                }
                                boolean booleanExtra4 = intent.getBooleanExtra(Constants.KEY_ANTI_BRUSH_RET, false);
                                ALog.e(TAG, "onReceiveData anti brush result:" + booleanExtra4, new Object[0]);
                                accsDataListenerV2.onAntiBrush(booleanExtra4, null);
                                return 2;
                            }
                            byte[] byteArrayExtra = intent.getByteArrayExtra("data");
                            boolean booleanExtra5 = intent.getBooleanExtra(Constants.KEY_NEED_BUSINESS_ACK, false);
                            if (byteArrayExtra != null) {
                                String stringExtra6 = intent.getStringExtra(Constants.KEY_DATA_ID);
                                if (ALog.isPrintLog(ALog.Level.D)) {
                                    ALog.d(TAG, "onReceiveData COMMAND_RECEIVE_DATA onData dataId:" + stringExtra6 + " serviceId:" + stringExtra2, new Object[0]);
                                }
                                TaoBaseService.ExtraInfo extraInfo = getExtraInfo(intent);
                                if (booleanExtra5) {
                                    ALog.i(TAG, "onReceiveData try to send biz ack dataId " + stringExtra6, new Object[0]);
                                    sendBusinessAck(context, intent, stringExtra6, extraInfo.oriExtHeader);
                                }
                                NetPerformanceMonitor netPerformanceMonitor = (NetPerformanceMonitor) intent.getSerializableExtra(Constants.KEY_MONIROT);
                                if (netPerformanceMonitor != null) {
                                    netPerformanceMonitor.onToAccsTime();
                                }
                                AppMonitorAdapter.commitCount("accs", BaseMonitor.COUNT_POINT_TO_BUSS_SUCCESS, "1commandId=101serviceId=" + stringExtra2, 0.0d);
                                accsDataListenerV2.onData(stringExtra2, stringExtra3, stringExtra6, byteArrayExtra, extraInfo);
                                return 2;
                            }
                            ALog.e(TAG, "onReceiveData COMMAND_RECEIVE_DATA msg null", new Object[0]);
                            str = "1";
                            AppMonitorAdapter.commitAlarmFail("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, stringExtra2, str, "COMMAND_RECEIVE_DATA msg null");
                        }
                    } catch (Exception e3) {
                        e = e3;
                        str = "1";
                        AppMonitorAdapter.commitAlarmFail("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, stringExtra2, str, "callback error" + e.toString());
                        ALog.e(TAG, stringExtra, e, new Object[0]);
                        return 2;
                    }
                } else {
                    stringExtra = "onReceiveData";
                    str = "1";
                    ALog.w(TAG, "onReceiveData command not handled " + intExtra, new Object[0]);
                }
                return 2;
            } catch (Exception e4) {
                e = e4;
                AppMonitorAdapter.commitAlarmFail("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, stringExtra2, str, "callback error" + e.toString());
                ALog.e(TAG, stringExtra, e, new Object[0]);
                return 2;
            }
        } catch (Exception e5) {
            e = e5;
            stringExtra = "onReceiveData";
            str = "1";
        }
    }

    private static void sendBusinessAck(Context context, Intent intent, String str, Map<Integer, String> map) {
        try {
            ALog.i(TAG, "sendBusinessAck", Constants.KEY_DATA_ID, str);
            if (intent != null) {
                String stringExtra = intent.getStringExtra("host");
                String stringExtra2 = intent.getStringExtra("source");
                String stringExtra3 = intent.getStringExtra(Constants.KEY_TARGET);
                String stringExtra4 = intent.getStringExtra(Constants.KEY_APP_KEY);
                String stringExtra5 = intent.getStringExtra(Constants.KEY_CONFIG_TAG);
                short shortExtra = intent.getShortExtra(Constants.KEY_FLAGS, (short) 0);
                IACCSManager accsInstance = ACCSManager.getAccsInstance(context, stringExtra4, stringExtra5);
                if (accsInstance != null) {
                    accsInstance.sendBusinessAck(stringExtra3, stringExtra2, str, shortExtra, stringExtra, map);
                    AppMonitorAdapter.commitCount("accs", BaseMonitor.COUNT_BUSINESS_ACK_SUCC, "", 0.0d);
                } else {
                    AppMonitorAdapter.commitCount("accs", BaseMonitor.COUNT_BUSINESS_ACK_FAIL, "no acsmgr", 0.0d);
                }
            }
        } catch (Throwable th) {
            ALog.e(TAG, "sendBusinessAck", th, new Object[0]);
            AppMonitorAdapter.commitCount("accs", BaseMonitor.COUNT_BUSINESS_ACK_FAIL, th.toString(), 0.0d);
        }
    }

    @Override // com.taobao.accs.base.AccsDataListener
    public void onAntiBrush(boolean z, TaoBaseService.ExtraInfo extraInfo) {
    }

    @Override // com.taobao.accs.base.AccsDataListener
    public void onBind(String str, int i2, TaoBaseService.ExtraInfo extraInfo) {
    }

    @Override // com.taobao.accs.base.AccsDataListenerV2
    public void onBind(String str, int i2, String str2, TaoBaseService.ExtraInfo extraInfo) {
        onBind(str, i2, extraInfo);
    }

    @Override // com.taobao.accs.base.AccsDataListener
    public void onConnected(TaoBaseService.ConnectInfo connectInfo) {
    }

    @Override // com.taobao.accs.base.AccsDataListener
    public void onDisconnected(TaoBaseService.ConnectInfo connectInfo) {
    }

    @Override // com.taobao.accs.base.AccsDataListenerV2
    public void onResponse(String str, String str2, int i2, String str3, byte[] bArr, TaoBaseService.ExtraInfo extraInfo) {
        onResponse(str, str2, i2, bArr, extraInfo);
    }

    @Override // com.taobao.accs.base.AccsDataListener
    public void onResponse(String str, String str2, int i2, byte[] bArr, TaoBaseService.ExtraInfo extraInfo) {
    }

    @Override // com.taobao.accs.base.AccsDataListener
    public void onSendData(String str, String str2, int i2, TaoBaseService.ExtraInfo extraInfo) {
    }

    @Override // com.taobao.accs.base.AccsDataListenerV2
    public void onSendData(String str, String str2, int i2, String str3, TaoBaseService.ExtraInfo extraInfo) {
        onSendData(str, str2, i2, extraInfo);
    }

    @Override // com.taobao.accs.base.AccsDataListener
    public void onUnbind(String str, int i2, TaoBaseService.ExtraInfo extraInfo) {
    }

    @Override // com.taobao.accs.base.AccsDataListenerV2
    public void onUnbind(String str, int i2, String str2, TaoBaseService.ExtraInfo extraInfo) {
        onUnbind(str, i2, extraInfo);
    }
}
