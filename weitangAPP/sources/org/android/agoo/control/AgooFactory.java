package org.android.agoo.control;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.taobao.accs.base.TaoBaseService;
import com.taobao.accs.client.AdapterGlobalClientInfo;
import com.taobao.accs.common.Constants;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.dispatch.IntentDispatch;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.AdapterUtilityImpl;
import com.taobao.accs.utl.UTMini;
import com.taobao.accs.utl.UtilityImpl;
import com.tom_roush.pdfbox.contentstream.operator.OperatorName;
import java.util.List;
import javax.crypto.spec.SecretKeySpec;
import org.android.agoo.common.AgooConstants;
import org.android.agoo.common.Config;
import org.android.agoo.common.MsgDO;
import org.android.agoo.message.MessageService;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class AgooFactory {
    private static final String DEAL_MESSAGE = "accs.msgRecevie";
    private static final String TAG = "AgooFactory";
    private static Context sContext;
    private static AgooFactory sInstance;
    private NotifManager notifyManager = null;
    private MessageService messageService = null;
    private boolean mCacheMessageEnabled = true;

    private AgooFactory(Context context) {
        init(context, null, null);
    }

    private static boolean checkPackage(Context context, String str) {
        return context.getPackageManager().getApplicationInfo(str, 0) != null;
    }

    private static String downgradeV1(String str, String str2, String str3) {
        ALog.d(TAG, "v2 downgrade to v1 decrypt message", new Object[0]);
        List<String> utdids = UtilityImpl.getUtdids(Constants.SP_FILE_NAME, sContext);
        if (utdids != null && !utdids.isEmpty()) {
            for (int i2 = 0; i2 < utdids.size(); i2++) {
                String encryptedMsgWithoutAgooByUtdid = parseEncryptedMsgWithoutAgooByUtdid(str, str2, str3, utdids.get(i2));
                if (encryptedMsgWithoutAgooByUtdid != null) {
                    UtilityImpl.hitUtdid(Constants.SP_FILE_NAME, sContext, utdids.get(i2));
                    ALog.d(TAG, "use v1 decrypt message successfully", new Object[0]);
                    return encryptedMsgWithoutAgooByUtdid;
                }
            }
        }
        return null;
    }

    private static Bundle getFlag(long j, MsgDO msgDO) {
        Bundle bundle = new Bundle();
        try {
            char[] charArray = Long.toBinaryString(j).toCharArray();
            if (charArray != null && 8 <= charArray.length) {
                if (8 <= charArray.length) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("");
                    sb.append(Integer.parseInt("" + charArray[1] + charArray[2] + charArray[3] + charArray[4], 2));
                    bundle.putString(AgooConstants.MESSAGE_ENCRYPTED, sb.toString());
                    if (charArray[6] == '1') {
                        bundle.putString(AgooConstants.MESSAGE_REPORT, "1");
                        msgDO.reportStr = "1";
                    }
                    if (charArray[7] == '1') {
                        bundle.putString(AgooConstants.MESSAGE_NOTIFICATION, "1");
                    }
                }
                if (9 <= charArray.length && charArray[8] == '1') {
                    bundle.putString(AgooConstants.MESSAGE_HAS_TEST, "1");
                }
                if (10 <= charArray.length && charArray[9] == '1') {
                    bundle.putString(AgooConstants.MESSAGE_DUPLICATE, "1");
                }
                if (11 <= charArray.length && charArray[10] == '1') {
                    bundle.putInt(AgooConstants.MESSAGE_POPUP, 1);
                }
            }
        } catch (Throwable unused) {
        }
        return bundle;
    }

    public static AgooFactory getInstance(Context context) {
        if (sInstance == null) {
            synchronized (AgooFactory.class) {
                if (sInstance == null) {
                    sInstance = new AgooFactory(context.getApplicationContext());
                }
            }
        }
        return sInstance;
    }

    private void init(Context context, NotifManager notifManager, MessageService messageService) {
        sContext = context.getApplicationContext();
        this.notifyManager = notifManager;
        if (notifManager == null) {
            this.notifyManager = new NotifManager();
        }
        this.notifyManager.init(sContext);
        this.messageService = messageService;
        if (messageService == null) {
            this.messageService = new MessageService();
        }
        this.messageService.a(sContext);
    }

    public static Bundle msgReceiverPreHandlerOnly(Context context, byte[] bArr, String str, String str2) {
        JSONArray jSONArray;
        String str3;
        int i2;
        String str4;
        String str5 = "ext";
        if (bArr != null) {
            try {
                if (bArr.length > 0) {
                    String str6 = new String(bArr, "utf-8");
                    if (ALog.isPrintLog(ALog.Level.I)) {
                        ALog.i(TAG, "msgReceiveOnly,message--->[" + str6 + "],utdid=" + AdapterUtilityImpl.getDeviceId(context), new Object[0]);
                    }
                    if (TextUtils.isEmpty(str6)) {
                        ALog.i(TAG, "handleMessage message==null,utdid=" + AdapterUtilityImpl.getDeviceId(context), new Object[0]);
                        return null;
                    }
                    JSONArray jSONArray2 = new JSONArray(str6);
                    StringBuilder sb = new StringBuilder();
                    Bundle bundle = null;
                    String string = null;
                    int i3 = 0;
                    for (int length = jSONArray2.length(); i3 < length; length = i2) {
                        bundle = new Bundle();
                        JSONObject jSONObject = jSONArray2.getJSONObject(i3);
                        if (jSONObject == null) {
                            jSONArray = jSONArray2;
                            str3 = str5;
                            str4 = str6;
                            i2 = length;
                        } else {
                            MsgDO msgDO = new MsgDO();
                            String string2 = jSONObject.getString("p");
                            String string3 = jSONObject.getString(OperatorName.SET_FLATNESS);
                            String string4 = jSONObject.getString(OperatorName.CLOSE_FILL_NON_ZERO_AND_STROKE);
                            String str7 = str6;
                            long j = jSONObject.getLong(OperatorName.FILL_NON_ZERO);
                            if (!jSONObject.isNull(str5)) {
                                string = jSONObject.getString(str5);
                            }
                            sb.append(string3);
                            jSONArray = jSONArray2;
                            if (i3 < length - 1) {
                                sb.append(",");
                            }
                            msgDO.msgIds = string3;
                            msgDO.extData = string;
                            msgDO.removePacks = string2;
                            msgDO.messageSource = str;
                            if (TextUtils.isEmpty(string4)) {
                                msgDO.errorCode = AgooConstants.ACK_BODY_NULL;
                            } else if (TextUtils.isEmpty(string2)) {
                                msgDO.errorCode = AgooConstants.ACK_PACK_NULL;
                            } else if (j == -1) {
                                msgDO.errorCode = AgooConstants.ACK_FLAG_NULL;
                            } else if (checkPackage(context, string2)) {
                                Bundle flag = getFlag(j, msgDO);
                                String string5 = flag.getString(AgooConstants.MESSAGE_ENCRYPTED);
                                str3 = str5;
                                StringBuilder sb2 = new StringBuilder();
                                i2 = length;
                                sb2.append("encrypted: ");
                                sb2.append(string5);
                                Log.d("wy", sb2.toString());
                                if (!context.getPackageName().equals(string2) || TextUtils.equals(string5, Integer.toString(4))) {
                                    bundle.putAll(flag);
                                    try {
                                        String string6 = jSONObject.getString(DispatchConstants.TIMESTAMP);
                                        if (!TextUtils.isEmpty(string6)) {
                                            bundle.putString("time", string6);
                                        }
                                    } catch (Throwable unused) {
                                        if (ALog.isPrintLog(ALog.Level.I)) {
                                            ALog.i(TAG, "agoo msg has no time", new Object[0]);
                                        }
                                    }
                                    bundle.putLong(AgooConstants.MESSAGE_TRACE, System.currentTimeMillis());
                                    bundle.putString("id", string3);
                                    bundle.putString(AgooConstants.MESSAGE_BODY, string4);
                                    bundle.putString("source", string2);
                                    bundle.putString(AgooConstants.MESSAGE_FROM_APPKEY, str2);
                                    bundle.putString(AgooConstants.MESSAGE_EXT, string);
                                    str4 = str7;
                                    bundle.putString(AgooConstants.MESSAGE_ORI, str4);
                                    bundle.putString("type", "common-push");
                                    bundle.putString(AgooConstants.MESSAGE_SOURCE, str);
                                } else {
                                    ALog.e(TAG, "msgReceive msg encrypted flag not exist, cannot prase!!!", new Object[0]);
                                    msgDO.errorCode = AgooConstants.REPORT_NOT_ENCRYPT;
                                    str4 = str7;
                                }
                                i3++;
                                jSONArray2 = jSONArray;
                                str6 = str4;
                                str5 = str3;
                            } else {
                                ALog.d(TAG, "msgReceive check package is del,pack=" + string2, new Object[0]);
                            }
                            str3 = str5;
                            i2 = length;
                            str4 = str7;
                        }
                        i3++;
                        jSONArray2 = jSONArray;
                        str6 = str4;
                        str5 = str3;
                    }
                    return bundle;
                }
            } catch (Throwable th) {
                if (!ALog.isPrintLog(ALog.Level.E)) {
                    return null;
                }
                ALog.e(TAG, "msgReceive is error,e=" + th, new Object[0]);
                return null;
            }
        }
        ALog.i(TAG, "handleMessage data==null,utdid=" + AdapterUtilityImpl.getDeviceId(context), new Object[0]);
        return null;
    }

    public static String parseEncryptedMsg(String str) {
        try {
            String strB = Config.b(sContext);
            String strC = Config.c(sContext);
            if (TextUtils.isEmpty(strC)) {
                ALog.e(TAG, "getAppSign secret null", new Object[0]);
                return null;
            }
            String encryptedMsgWithoutAgoo = parseEncryptedMsgWithoutAgoo(str, strB, strC);
            if (encryptedMsgWithoutAgoo == null) {
                return downgradeV1(str, strB, strC);
            }
            boolean z = true;
            try {
                new JSONObject(encryptedMsgWithoutAgoo);
            } catch (Exception unused) {
                ALog.d(TAG, "v2 decrypt error, need to downgrade", new Object[0]);
                z = false;
            }
            if (!z) {
                return downgradeV1(str, strB, strC);
            }
            ALog.d(TAG, "use v2 decrypt message successfully", new Object[0]);
            return encryptedMsgWithoutAgoo;
        } catch (Throwable th) {
            ALog.e(TAG, "parseEncryptedMsg failure: ", th, new Object[0]);
            return null;
        }
    }

    public static String parseEncryptedMsgWithoutAgoo(String str, String str2, String str3) {
        String str4 = null;
        try {
            byte[] bArrA = org.android.agoo.common.a.a(str3.getBytes("utf-8"), (str2 + str3).getBytes("utf-8"));
            if (bArrA == null || bArrA.length <= 0) {
                ALog.w(TAG, "aesDecrypt key is null!", new Object[0]);
            } else {
                str4 = new String(org.android.agoo.common.a.a(Base64.decode(str, 8), new SecretKeySpec(org.android.agoo.common.a.a(bArrA), "AES"), org.android.agoo.common.a.a(str2.getBytes("utf-8"))), "utf-8");
            }
        } catch (Throwable th) {
            ALog.w(TAG, "parseEncryptedMsg body: ", str);
            ALog.w(TAG, "parseEncryptedMsg appKey: ", str2);
            ALog.w(TAG, "parseEncryptedMsg appSecret: ", str3);
            ALog.w(TAG, "parseEncryptedMsg failure: ", th, new Object[0]);
        }
        return str4;
    }

    public static String parseEncryptedMsgWithoutAgooByUtdid(String str, String str2, String str3, String str4) {
        String str5 = null;
        try {
            byte[] bArrA = org.android.agoo.common.a.a(str3.getBytes("utf-8"), (str2 + str4).getBytes("utf-8"));
            if (bArrA == null || bArrA.length <= 0) {
                ALog.w(TAG, "aesDecrypt key is null!", new Object[0]);
            } else {
                str5 = new String(org.android.agoo.common.a.a(Base64.decode(str, 8), new SecretKeySpec(org.android.agoo.common.a.a(bArrA), "AES"), org.android.agoo.common.a.a(str2.getBytes("utf-8"))), "utf-8");
            }
        } catch (Throwable th) {
            ALog.w(TAG, "parseEncryptedMsg body: ", str);
            ALog.w(TAG, "parseEncryptedMsg appKey: ", str2);
            ALog.w(TAG, "parseEncryptedMsg appSecret: ", str3);
            ALog.w(TAG, "parseEncryptedMsg utdid: ", str4);
            ALog.w(TAG, "parseEncryptedMsg failure: ", th, new Object[0]);
        }
        return str5;
    }

    private void sendMsgToBusiness(Context context, String str, Bundle bundle, boolean z, String str2, TaoBaseService.ExtraInfo extraInfo) {
        Intent intent = new Intent();
        intent.setAction("org.agoo.android.intent.action.RECEIVE");
        intent.setPackage(str);
        intent.putExtras(bundle);
        intent.putExtra("type", "common-push");
        intent.putExtra(AgooConstants.MESSAGE_SOURCE, str2);
        intent.addFlags(32);
        try {
            Bundle bundle2 = new Bundle();
            bundle2.putSerializable(AgooConstants.MESSAGE_ACCS_EXTRA, extraInfo);
            intent.putExtra(AgooConstants.MESSAGE_AGOO_BUNDLE, bundle2);
        } catch (Throwable th) {
            ALog.e(TAG, "sendMsgToBusiness", th, new Object[0]);
        }
        if (ALog.isPrintLog(ALog.Level.I)) {
            ALog.i(TAG, "sendMsgToBusiness intent:" + bundle.toString() + ",utdid=" + AdapterUtilityImpl.getDeviceId(context) + ",pack=" + str + ",agooFlag=" + z, new Object[0]);
        }
        if (z) {
            return;
        }
        String agooCustomServiceName = AdapterGlobalClientInfo.getAgooCustomServiceName(context);
        if (TextUtils.isEmpty(agooCustomServiceName)) {
            ALog.e(TAG, "sendMsgToBusiness failed, can not find custom service", new Object[0]);
        } else {
            intent.setClassName(str, agooCustomServiceName);
            IntentDispatch.dispatchIntent(context, intent, agooCustomServiceName);
        }
    }

    public void clickMessage(Context context, String str, String str2) {
        ThreadPoolExecutorFactory.execute(new f(this, str, str2));
    }

    public void dismissMessage(Context context, String str, String str2) {
        ThreadPoolExecutorFactory.execute(new g(this, str, str2));
    }

    public MessageService getMessageService() {
        return this.messageService;
    }

    public NotifManager getNotifyManager() {
        return this.notifyManager;
    }

    public boolean isCacheMessageEnabled() {
        return this.mCacheMessageEnabled;
    }

    public void msgReceive(byte[] bArr, String str) {
        msgReceive(bArr, str, null);
    }

    public Bundle msgReceiverPreHandler(byte[] bArr, String str, TaoBaseService.ExtraInfo extraInfo, boolean z) {
        JSONArray jSONArray;
        String str2;
        boolean z2;
        Bundle bundle;
        String str3;
        String str4;
        int i2;
        StringBuilder sb;
        StringBuilder sb2;
        int i3;
        StringBuilder sb3;
        String str5 = "ext";
        if (bArr != null) {
            try {
                if (bArr.length > 0) {
                    String str6 = new String(bArr, "utf-8");
                    if (ALog.isPrintLog(ALog.Level.I)) {
                        ALog.i(TAG, "msgReceive,message--->[" + str6 + "],utdid=" + AdapterUtilityImpl.getDeviceId(sContext), new Object[0]);
                    }
                    if (TextUtils.isEmpty(str6)) {
                        UTMini.getInstance().commitEvent(AgooConstants.AGOO_EVENT_ID, DEAL_MESSAGE, AdapterUtilityImpl.getDeviceId(sContext), "message==null");
                        ALog.i(TAG, "handleMessage message==null,utdid=" + AdapterUtilityImpl.getDeviceId(sContext), new Object[0]);
                        return null;
                    }
                    JSONArray jSONArray2 = new JSONArray(str6);
                    int length = jSONArray2.length();
                    StringBuilder sb4 = new StringBuilder();
                    StringBuilder sb5 = new StringBuilder();
                    StringBuilder sb6 = new StringBuilder();
                    Bundle bundle2 = null;
                    String str7 = null;
                    int i4 = 0;
                    while (i4 < length) {
                        Bundle bundle3 = new Bundle();
                        JSONObject jSONObject = jSONArray2.getJSONObject(i4);
                        if (jSONObject == null) {
                            jSONArray = jSONArray2;
                            i2 = i4;
                            sb2 = sb6;
                            sb3 = sb4;
                            i3 = length;
                            str2 = str5;
                            str3 = str6;
                            bundle = bundle3;
                            sb = sb5;
                        } else {
                            MsgDO msgDO = new MsgDO();
                            jSONArray = jSONArray2;
                            String string = jSONObject.getString("p");
                            String str8 = str7;
                            String string2 = jSONObject.getString(OperatorName.SET_FLATNESS);
                            String str9 = str6;
                            String string3 = jSONObject.getString(OperatorName.CLOSE_FILL_NON_ZERO_AND_STROKE);
                            StringBuilder sb7 = sb6;
                            StringBuilder sb8 = sb5;
                            long j = jSONObject.getLong(OperatorName.FILL_NON_ZERO);
                            String string4 = !jSONObject.isNull(str5) ? jSONObject.getString(str5) : str8;
                            sb4.append(string2);
                            str2 = str5;
                            int i5 = length - 1;
                            int i6 = length;
                            if (i4 < i5) {
                                sb4.append(",");
                            }
                            msgDO.msgIds = string2;
                            msgDO.extData = string4;
                            msgDO.removePacks = string;
                            msgDO.messageSource = str;
                            if (TextUtils.isEmpty(string3)) {
                                msgDO.errorCode = AgooConstants.ACK_BODY_NULL;
                                this.notifyManager.handlerACKMessage(msgDO, extraInfo);
                            } else if (TextUtils.isEmpty(string)) {
                                msgDO.errorCode = AgooConstants.ACK_PACK_NULL;
                                this.notifyManager.handlerACKMessage(msgDO, extraInfo);
                            } else if (j == -1) {
                                msgDO.errorCode = AgooConstants.ACK_FLAG_NULL;
                                this.notifyManager.handlerACKMessage(msgDO, extraInfo);
                            } else {
                                StringBuilder sb9 = sb4;
                                if (checkPackage(sContext, string)) {
                                    Bundle flag = getFlag(j, msgDO);
                                    String string5 = flag.getString(AgooConstants.MESSAGE_ENCRYPTED);
                                    if (!sContext.getPackageName().equals(string)) {
                                        z2 = true;
                                    } else if (TextUtils.equals(string5, Integer.toString(4))) {
                                        z2 = false;
                                    } else {
                                        ALog.e(TAG, "msgReceive msg encrypted flag not exist, cannot prase!!!", new Object[0]);
                                        UTMini.getInstance().commitEvent(AgooConstants.AGOO_EVENT_ID, DEAL_MESSAGE, AdapterUtilityImpl.getDeviceId(sContext), "encrypted!=4", AgooConstants.ACK_PACK_ERROR);
                                        msgDO.errorCode = AgooConstants.REPORT_NOT_ENCRYPT;
                                        this.notifyManager.handlerACKMessage(msgDO, extraInfo);
                                        str4 = string4;
                                        i2 = i4;
                                        sb2 = sb7;
                                        sb = sb8;
                                    }
                                    bundle = bundle3;
                                    bundle.putAll(flag);
                                    try {
                                        String string6 = jSONObject.getString(DispatchConstants.TIMESTAMP);
                                        if (!TextUtils.isEmpty(string6)) {
                                            bundle.putString("time", string6);
                                        }
                                    } catch (Throwable unused) {
                                        if (ALog.isPrintLog(ALog.Level.I)) {
                                            ALog.i(TAG, "agoo msg has no time", new Object[0]);
                                        }
                                    }
                                    bundle.putLong(AgooConstants.MESSAGE_TRACE, System.currentTimeMillis());
                                    bundle.putString("id", string2);
                                    bundle.putString(AgooConstants.MESSAGE_BODY, string3);
                                    bundle.putString("source", string);
                                    bundle.putString(AgooConstants.MESSAGE_FROM_APPKEY, Config.b(sContext));
                                    bundle.putString(AgooConstants.MESSAGE_EXT, string4);
                                    str3 = str9;
                                    bundle.putString(AgooConstants.MESSAGE_ORI, str3);
                                    if (z) {
                                        str4 = string4;
                                        i2 = i4;
                                        sb2 = sb7;
                                        sb = sb8;
                                        sb3 = sb9;
                                        i3 = i6;
                                        sendMsgToBusiness(sContext, string, bundle, z2, str, extraInfo);
                                    } else {
                                        str4 = string4;
                                        i2 = i4;
                                        sb = sb8;
                                        sb2 = sb7;
                                        i3 = i6;
                                        sb3 = sb9;
                                        bundle.putString("type", "common-push");
                                        bundle.putString(AgooConstants.MESSAGE_SOURCE, str);
                                    }
                                    str7 = str4;
                                } else {
                                    ALog.d(TAG, "msgReceive check package is del,pack=" + string, new Object[0]);
                                    UTMini.getInstance().commitEvent(AgooConstants.AGOO_EVENT_ID, DEAL_MESSAGE, AdapterUtilityImpl.getDeviceId(sContext), "deletePack", string);
                                    sb7.append(string);
                                    sb8.append(string2);
                                    if (i4 < i5) {
                                        sb7.append(",");
                                        sb8.append(",");
                                    }
                                    sb = sb8;
                                    str4 = string4;
                                    i2 = i4;
                                    sb2 = sb7;
                                }
                                str3 = str9;
                                bundle = bundle3;
                                i3 = i6;
                                sb3 = sb9;
                                str7 = str4;
                            }
                            str4 = string4;
                            i2 = i4;
                            sb3 = sb4;
                            str3 = str9;
                            bundle = bundle3;
                            sb = sb8;
                            sb2 = sb7;
                            i3 = i6;
                            str7 = str4;
                        }
                        i4 = i2 + 1;
                        sb6 = sb2;
                        bundle2 = bundle;
                        sb5 = sb;
                        sb4 = sb3;
                        length = i3;
                        str5 = str2;
                        jSONArray2 = jSONArray;
                        str6 = str3;
                    }
                    StringBuilder sb10 = sb6;
                    StringBuilder sb11 = sb5;
                    if (sb10.length() > 0) {
                        MsgDO msgDO2 = new MsgDO();
                        msgDO2.msgIds = sb11.toString();
                        msgDO2.removePacks = sb10.toString();
                        msgDO2.errorCode = AgooConstants.ACK_REMOVE_PACKAGE;
                        msgDO2.messageSource = str;
                        this.notifyManager.handlerACKMessage(msgDO2, extraInfo);
                    }
                    return bundle2;
                }
            } catch (Throwable th) {
                if (!ALog.isPrintLog(ALog.Level.E)) {
                    return null;
                }
                ALog.e(TAG, "msgReceive is error,e=" + th, new Object[0]);
                return null;
            }
        }
        UTMini.getInstance().commitEvent(AgooConstants.AGOO_EVENT_ID, DEAL_MESSAGE, AdapterUtilityImpl.getDeviceId(sContext), "data==null");
        ALog.i(TAG, "handleMessage data==null,utdid=" + AdapterUtilityImpl.getDeviceId(sContext), new Object[0]);
        return null;
    }

    public void reportCacheMsg() {
        try {
            ThreadPoolExecutorFactory.execute(new c(this));
        } catch (Throwable th) {
            ALog.e(TAG, "reportCacheMsg fail:" + th.toString(), new Object[0]);
        }
    }

    public void saveMsg(byte[] bArr) {
        saveMsg(bArr, "0");
    }

    public void setCacheMessageEnabled(boolean z) {
        this.mCacheMessageEnabled = z;
    }

    public void updateMsg(byte[] bArr, boolean z) {
        ThreadPoolExecutorFactory.execute(new d(this, bArr, z));
    }

    public void updateMsgStatus(String str, String str2) {
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                if (ALog.isPrintLog(ALog.Level.I)) {
                    ALog.i(TAG, "updateNotifyMsg begin,messageId=" + str + ",status=" + str2 + ",reportTimes=" + Config.g(sContext), new Object[0]);
                }
                if (TextUtils.equals(str2, MessageService.MSG_ACCS_NOTIFY_CLICK)) {
                    this.messageService.a(str, "2");
                } else if (TextUtils.equals(str2, MessageService.MSG_ACCS_NOTIFY_DISMISS)) {
                    this.messageService.a(str, "3");
                }
            }
        } catch (Throwable th) {
            ALog.e(TAG, "updateNotifyMsg e=" + th.toString(), new Object[0]);
        }
    }

    public void updateNotifyMsg(String str, String str2) {
        ThreadPoolExecutorFactory.execute(new e(this, str, str2));
    }

    public void msgReceive(byte[] bArr, String str, TaoBaseService.ExtraInfo extraInfo) {
        try {
            if (ALog.isPrintLog(ALog.Level.I)) {
                ALog.i(TAG, "into--[AgooFactory,msgReceive]:messageSource=" + str, new Object[0]);
            }
            ThreadPoolExecutorFactory.execute(new b(this, bArr, str, extraInfo));
        } catch (Throwable th) {
            ALog.e(TAG, "serviceImpl init task fail:" + th.toString(), new Object[0]);
        }
    }

    public void saveMsg(byte[] bArr, String str) {
        if (bArr == null || bArr.length <= 0) {
            return;
        }
        ThreadPoolExecutorFactory.execute(new a(this, bArr, str));
    }
}
