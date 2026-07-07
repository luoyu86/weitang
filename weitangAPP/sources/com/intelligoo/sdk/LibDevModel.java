package com.intelligoo.sdk;

import android.content.Context;
import android.os.Bundle;
import com.alibaba.android.arouter.utils.Consts;
import com.intelligoo.sdk.LibInterface;
import com.tom_roush.fontbox.ttf.OS2WindowsMetricsTable;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public class LibDevModel {
    public static final int CONTROL_ELECTRIC = 1;
    public static final int CONTROL_lOCK = 0;
    public static final String DEVICE_KEY = "com.intelligoo.sdk.DeviceModel.DEVICE_KEY";
    public static final int DEV_TYPE_2G_ACCESS_CONTROLLER = 16;
    public static final int DEV_TYPE_2G_DM_DEVICE = 15;
    public static final int DEV_TYPE_ACCESS_CONTROLLER = 2;
    public static final int DEV_TYPE_AM180 = 19;
    public static final int DEV_TYPE_BLE_CONTROLER = 5;
    public static final int DEV_TYPE_DM_DEVICE = 10;
    public static final int DEV_TYPE_EXT200 = 14;
    public static final int DEV_TYPE_EXT211 = 18;
    public static final int DEV_TYPE_EXT220 = 20;
    public static final int DEV_TYPE_LIFT_CONTROLLER = 3;
    public static final int DEV_TYPE_LOCK = 4;
    public static final int DEV_TYPE_M200_WIFI_ACCESS_DEVICE = 13;
    public static final int DEV_TYPE_M260_WIFI_ACCESS_DEVICE = 12;
    public static final int DEV_TYPE_Q100 = 21;
    public static final int DEV_TYPE_QCCODE_DEVICE = 8;
    public static final int DEV_TYPE_QRCODE_DEVICE = 9;
    public static final int DEV_TYPE_READER = 1;
    public static final int DEV_TYPE_SL100B = 27;
    public static final int DEV_TYPE_SL200B = 28;
    public static final int DEV_TYPE_SL300B = 29;
    public static final int DEV_TYPE_TOUCH_CONTROLLER = 11;
    public static final int DEV_TYPE_TOUCH_SWITCH = 7;
    public static final int DEV_TYPE_V620_EXTEND = 17;
    public static final int Dev_Type_CONTROLER = 6;
    public static final int WIEGAND_26 = 26;
    public static final int WIEGAND_34 = 34;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static ArrayList<Integer> f9153a = new ArrayList<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static ArrayList<Integer> f9154b = new ArrayList<>();
    public String devSn = null;
    public String devMac = null;
    public int devType = 1;
    public int privilege = 4;
    public int openType = 1;
    public int verified = 3;
    public String startDate = null;
    public String endDate = null;
    public int useCount = 0;
    public String eKey = null;
    public String cardno = null;

    static {
        f9153a.add(0);
        f9153a.add(4);
        f9153a.add(5);
        f9153a.add(6);
        f9153a.add(7);
        f9153a.add(8);
        f9153a.add(7);
        f9153a.add(9);
        f9153a.add(10);
        f9153a.add(11);
        f9153a.add(12);
        f9153a.add(13);
        f9153a.add(15);
        f9153a.add(16);
        f9153a.add(18);
        f9153a.add(20);
        f9153a.add(21);
        f9154b.add(3);
        f9154b.add(4);
        f9154b.add(5);
        f9154b.add(10);
        f9154b.add(15);
        f9154b.add(16);
        f9154b.add(18);
        f9154b.add(20);
        f9154b.add(21);
        f9154b.add(22);
        f9154b.add(23);
    }

    private static int a(Context context, LibDevModel libDevModel, LibInterface.ManagerCallback managerCallback, boolean z) {
        int iCompareTo;
        String str = libDevModel.endDate;
        int iCompareTo2 = -1;
        if (str != null && !"".equals(str) && libDevModel.endDate.length() > 0) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss", Locale.getDefault());
            try {
                iCompareTo = Calendar.getInstance().getTime().compareTo(simpleDateFormat.parse(libDevModel.endDate));
            } catch (ParseException e2) {
                e2.printStackTrace();
                iCompareTo = -1;
            }
            if (iCompareTo == 1) {
                return -43;
            }
        }
        String str2 = libDevModel.startDate;
        if (str2 != null && !"".equals(str2) && libDevModel.startDate.length() > 0) {
            SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyyMMddHHmmss", Locale.getDefault());
            try {
                iCompareTo2 = simpleDateFormat2.parse(libDevModel.startDate).compareTo(Calendar.getInstance().getTime());
            } catch (ParseException e3) {
                e3.printStackTrace();
            }
            if (iCompareTo2 == 1) {
                return -44;
            }
        }
        if (context == null) {
            return -42;
        }
        if (managerCallback == null && z) {
            return -103;
        }
        String str3 = libDevModel.devSn;
        if (str3 == null || "".equals(str3)) {
            return -2;
        }
        String str4 = libDevModel.devMac;
        if (str4 == null || "".equals(str4)) {
            return -3;
        }
        if (libDevModel.devType == 0) {
            return -5;
        }
        String str5 = libDevModel.eKey;
        if (str5 == null || "".equals(str5)) {
            return -4;
        }
        if (libDevModel.eKey.length() < 68) {
            return 11;
        }
        if (libDevModel.devSn.length() != 10) {
            return -2;
        }
        if (libDevModel.devMac.length() != 17) {
            return -3;
        }
        i.a(libDevModel);
        return 0;
    }

    public static int a(Bundle bundle, int i2) {
        byte[] bArrA;
        if (bundle == null) {
            return 91;
        }
        if (i2 != 3) {
            if (i2 != 4) {
                if (i2 != 5) {
                    if (i2 != 10) {
                        if (i2 == 18) {
                            if (!bundle.containsKey(ConstantsUtils.IP_ADDRESS) || !bundle.containsKey(ConstantsUtils.PORT) || !bundle.containsKey(ConstantsUtils.AP_NAME) || !bundle.containsKey(ConstantsUtils.AP_PASSWORD)) {
                                return 92;
                            }
                            String string = bundle.getString(ConstantsUtils.IP_ADDRESS);
                            bundle.getInt(ConstantsUtils.PORT);
                            String string2 = bundle.getString(ConstantsUtils.AP_NAME);
                            String string3 = bundle.getString(ConstantsUtils.AP_PASSWORD);
                            if (string != null && string2 != null && string3 != null) {
                                byte[] bArrA2 = a(string);
                                byte[] bytes = string2.getBytes();
                                byte[] bytes2 = {0};
                                if (string3.length() > 0) {
                                    bytes2 = string3.getBytes();
                                }
                                if (bArrA2 == null || bArrA2.length > 19 || bytes == null || bytes.length > 19 || bytes2 == null || bytes2.length > 19) {
                                }
                            }
                            return 93;
                        }
                        if (i2 != 20) {
                            if (i2 != 15) {
                                if (i2 != 16) {
                                    if (i2 != 22) {
                                        if (i2 != 23) {
                                            return -13;
                                        }
                                        if (!bundle.containsKey(ConstantsUtils.SERVER_IP) || !bundle.containsKey(ConstantsUtils.SERVER_PORT)) {
                                            return 92;
                                        }
                                        String string4 = bundle.getString(ConstantsUtils.SERVER_IP);
                                        bundle.getInt(ConstantsUtils.SERVER_PORT);
                                        if (string4 == null || (bArrA = a(string4)) == null || bArrA.length > 19) {
                                            return 93;
                                        }
                                    } else {
                                        if (!bundle.containsKey(ConstantsUtils.DHCP_ENABLE)) {
                                            return 92;
                                        }
                                        int i3 = bundle.getInt(ConstantsUtils.DHCP_ENABLE);
                                        if (i3 == 1) {
                                            if (!bundle.containsKey(ConstantsUtils.STATIC_IP) || !bundle.containsKey(ConstantsUtils.SUBNET_MASK) || !bundle.containsKey(ConstantsUtils.GATEWAY) || !bundle.containsKey(ConstantsUtils.DNS_SERVER)) {
                                                return 92;
                                            }
                                            String string5 = bundle.getString(ConstantsUtils.STATIC_IP);
                                            String string6 = bundle.getString(ConstantsUtils.SUBNET_MASK);
                                            String string7 = bundle.getString(ConstantsUtils.GATEWAY);
                                            String string8 = bundle.getString(ConstantsUtils.DNS_SERVER);
                                            if (string5 != null && string6 != null && string7 != null && string8 != null) {
                                                byte[] bArrA3 = a(string5);
                                                byte[] bArrA4 = a(string6);
                                                byte[] bArrA5 = a(string7);
                                                byte[] bArrA6 = a(string8);
                                                if (bArrA3.length > 19 || bArrA4.length > 19 || bArrA5.length > 19 || bArrA6.length > 19) {
                                                }
                                            }
                                            return 93;
                                        }
                                        if (i3 != 0) {
                                            return 93;
                                        }
                                    }
                                } else {
                                    if (!bundle.containsKey(ConstantsUtils.CARD_NUMBER)) {
                                        return 92;
                                    }
                                    long[] longArray = bundle.getLongArray(ConstantsUtils.CARD_NUMBER);
                                    if (longArray == null || longArray.length <= 0 || longArray.length > 1000) {
                                        return 93;
                                    }
                                }
                            } else {
                                if (!bundle.containsKey(ConstantsUtils.CARD_NUMBER)) {
                                    return 92;
                                }
                                long[] longArray2 = bundle.getLongArray(ConstantsUtils.CARD_NUMBER);
                                if (longArray2 == null || longArray2.length <= 0 || longArray2.length > 1000) {
                                    return 93;
                                }
                            }
                        } else if (!bundle.containsKey(ConstantsUtils.SECTOR_KEY) || bundle.getString(ConstantsUtils.SECTOR_KEY).length() != 32) {
                            return 93;
                        }
                    } else {
                        if (!bundle.containsKey(ConstantsUtils.WIEGAND) || !bundle.containsKey(ConstantsUtils.OPEN_DELAY) || !bundle.containsKey(ConstantsUtils.CONTROL)) {
                            return 92;
                        }
                        int i4 = bundle.getInt(ConstantsUtils.WIEGAND);
                        int i5 = bundle.getInt(ConstantsUtils.OPEN_DELAY);
                        int i6 = bundle.getInt(ConstantsUtils.CONTROL);
                        l.a("wiegand:" + i4 + "openDelay:" + i5 + "controlWay:" + i6);
                        if (i4 != 26 && i4 != 34 && i5 <= 0 && i6 != 0 && i6 != 1) {
                            return 93;
                        }
                    }
                } else {
                    if (!bundle.containsKey(ConstantsUtils.MODIFY_OLD_PWD) || !bundle.containsKey(ConstantsUtils.MODIFY_NEW_PWD)) {
                        return 92;
                    }
                    if (bundle.getString(ConstantsUtils.MODIFY_OLD_PWD) == null || bundle.getString(ConstantsUtils.MODIFY_NEW_PWD) == null) {
                        return 93;
                    }
                }
            } else {
                if (!bundle.containsKey(ConstantsUtils.SYC_SET_TIME)) {
                    return 92;
                }
                if (bundle.getString(ConstantsUtils.SYC_SET_TIME) == null) {
                    return 93;
                }
            }
        } else {
            if (!bundle.containsKey(ConstantsUtils.MANAGER_ADD_DEV)) {
                return 92;
            }
            if (bundle.getString(ConstantsUtils.MANAGER_ADD_DEV) == null) {
                return 93;
            }
        }
        return 0;
    }

    private static Bundle a(Bundle bundle) {
        String string = bundle.getString(ConstantsUtils.IP_ADDRESS);
        int i2 = bundle.getInt(ConstantsUtils.PORT);
        String string2 = bundle.getString(ConstantsUtils.AP_NAME);
        String string3 = bundle.getString(ConstantsUtils.AP_PASSWORD);
        byte[] bArrA = a(string);
        byte[] bArr = {(byte) ((i2 >> 8) & 255), (byte) (i2 & 255)};
        byte[] bytes = string2.getBytes();
        byte[] bytes2 = {0};
        if (string3.length() > 0) {
            try {
                bytes2 = string3.getBytes("UTF-8");
            } catch (UnsupportedEncodingException unused) {
            }
        }
        Bundle bundle2 = new Bundle();
        bundle2.putByteArray(ConstantsUtils.IP_ADDRESS, bArrA);
        bundle2.putByteArray(ConstantsUtils.PORT, bArr);
        bundle2.putByteArray(ConstantsUtils.AP_NAME, bytes);
        bundle2.putByteArray(ConstantsUtils.AP_PASSWORD, bytes2);
        return bundle2;
    }

    public static Bundle a(List<String> list) {
        Bundle bundle = new Bundle();
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (list.get(i2).length() > 0) {
                arrayList.add(list.get(i2));
            }
        }
        long[] jArr = new long[arrayList.size()];
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            jArr[i3] = Long.parseLong((String) arrayList.get(i3));
        }
        bundle.putLongArray(ConstantsUtils.CARD_NUMBER, jArr);
        return bundle;
    }

    public static boolean a(Integer num) {
        return f9153a.contains(num);
    }

    private static boolean a(ArrayList<String> arrayList) {
        if (arrayList != null && arrayList.size() <= 50) {
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                try {
                    if (Long.parseLong(arrayList.get(i2)) > -1) {
                        return false;
                    }
                } catch (NumberFormatException unused) {
                }
            }
        }
        return false;
    }

    private static byte[] a(String str) {
        byte[] bArr = new byte[4];
        int iIndexOf = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < 4 && iIndexOf < str.length(); i3++) {
            iIndexOf = str.indexOf(Consts.DOT, i2);
            if (iIndexOf != -1 && i3 < 3) {
                bArr[i3] = (byte) (Integer.parseInt(str.substring(i2, iIndexOf)) & 255);
                i2 = iIndexOf + 1;
            }
            if (i3 == 3) {
                bArr[i3] = (byte) (Integer.parseInt(str.substring(i2, str.length())) & 255);
                iIndexOf = 0;
                i2 = 0;
            }
        }
        return bArr;
    }

    private static Bundle b(Bundle bundle) {
        String string = bundle.getString(ConstantsUtils.SERVER_IP);
        int i2 = bundle.getInt(ConstantsUtils.SERVER_PORT);
        byte[] bArrA = a(string);
        byte[] bArr = {(byte) ((i2 >> 8) & 255), (byte) (i2 & 255)};
        Bundle bundle2 = new Bundle();
        bundle2.putByteArray(ConstantsUtils.SERVER_IP, bArrA);
        bundle2.putByteArray(ConstantsUtils.SERVER_PORT, bArr);
        return bundle2;
    }

    private static String b(String str) {
        if ("FFFFFFFFFFFF".equals(str)) {
            return str;
        }
        byte[] bArrE = e.e(str);
        byte[] bArr = {74, 90, 77, 84, 109, 111};
        for (int i2 = 0; i2 < 6; i2++) {
            bArrE[i2] = (byte) (bArrE[i2] ^ bArr[i2]);
        }
        return e.c(bArrE, 6);
    }

    public static boolean b(Integer num) {
        return f9154b.contains(num);
    }

    private static Bundle c(Bundle bundle) {
        int i2 = bundle.getInt(ConstantsUtils.DHCP_ENABLE);
        Bundle bundle2 = new Bundle();
        if (i2 == 1) {
            String string = bundle.getString(ConstantsUtils.STATIC_IP);
            String string2 = bundle.getString(ConstantsUtils.SUBNET_MASK);
            String string3 = bundle.getString(ConstantsUtils.GATEWAY);
            String string4 = bundle.getString(ConstantsUtils.DNS_SERVER);
            byte[] bArrA = a(string);
            byte[] bArrA2 = a(string2);
            byte[] bArrA3 = a(string3);
            byte[] bArrA4 = a(string4);
            bundle2.putByteArray(ConstantsUtils.STATIC_IP, bArrA);
            bundle2.putByteArray(ConstantsUtils.SUBNET_MASK, bArrA2);
            bundle2.putByteArray(ConstantsUtils.GATEWAY, bArrA3);
            bundle2.putByteArray(ConstantsUtils.DNS_SERVER, bArrA4);
        }
        bundle2.putByte(ConstantsUtils.DHCP_ENABLE, (byte) i2);
        return bundle2;
    }

    public static int checkCardno(LibDevModel libDevModel) {
        int i2 = libDevModel.devType;
        if ((i2 == 1 || i2 == 9 || i2 == 14 || i2 == 17 || i2 == 18 || i2 == 20) && "0000000000".equals(h.d(libDevModel.eKey, false))) {
            String str = libDevModel.cardno;
            if (str != null && str.length() != 0) {
                try {
                    Long.parseLong(libDevModel.cardno);
                } catch (Exception unused) {
                }
            }
            return -1;
        }
        return 0;
    }

    public static int checkFingerprint(ArrayList<DMFingerprintModel> arrayList) {
        DMFingerprintModel dMFingerprintModel;
        ArrayList<byte[]> arrayList2;
        if (arrayList == null) {
            return -26;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            if (!(arrayList.get(i2) instanceof DMFingerprintModel) || (arrayList2 = (dMFingerprintModel = arrayList.get(i2)).fingerprintdatas) == null || arrayList2.size() == 0) {
                return -27;
            }
            for (int i3 = 0; i3 < dMFingerprintModel.fingerprintdatas.size(); i3++) {
                byte[] bArr = dMFingerprintModel.fingerprintdatas.get(i3);
                if (bArr == null || bArr.length <= 0) {
                    return -27;
                }
            }
        }
        return 0;
    }

    public static int cleanAllOpenDoorRecords(Context context, LibDevModel libDevModel, LibInterface.ManagerCallback managerCallback) {
        int iA = a(context, libDevModel, managerCallback, true);
        return iA != 0 ? iA : f.a(context, 33, managerCallback);
    }

    public static int cleanCard(Context context, LibDevModel libDevModel, LibInterface.ManagerCallback managerCallback) {
        int iA = a(context, libDevModel, managerCallback, true);
        if (iA != 0) {
            return iA;
        }
        i.a(libDevModel);
        return f.a(context, 19, managerCallback);
    }

    public static int cleanFingerprints(Context context, LibDevModel libDevModel, LibInterface.ManagerCallback managerCallback) {
        int iA = a(context, libDevModel, managerCallback, true);
        return iA != 0 ? iA : f.a(context, 29, managerCallback);
    }

    public static int configWifi(Context context, LibDevModel libDevModel, Bundle bundle, LibInterface.ManagerCallback managerCallback) {
        int iA = a(context, libDevModel, managerCallback, true);
        if (iA != 0) {
            return iA;
        }
        i iVarA = i.a(libDevModel);
        if (b((Integer) 18)) {
            int iA2 = a(bundle, 18);
            if (iA2 != 0) {
                return iA2;
            }
            Bundle bundleA = a(bundle);
            if (bundleA == null) {
                return 93;
            }
            iVarA.a(bundleA);
        }
        l.a("" + iVarA.f9266b.toString());
        return f.a(context, 18, managerCallback);
    }

    public static int controlDevice(Context context, int i2, LibDevModel libDevModel, Bundle bundle, LibInterface.ManagerCallback managerCallback) {
        int iA = a(context, libDevModel, managerCallback, true);
        if (iA != 0) {
            return iA;
        }
        int iCheckCardno = checkCardno(libDevModel);
        if (iCheckCardno != 0) {
            return iCheckCardno;
        }
        if (!a(Integer.valueOf(i2))) {
            return -13;
        }
        i iVarA = i.a(libDevModel);
        if (b(Integer.valueOf(i2))) {
            int iA2 = a(bundle, i2);
            if (iA2 != 0) {
                return iA2;
            }
            iVarA.a(bundle);
        }
        return f.a(context, i2, managerCallback);
    }

    public static int deleteCard(Context context, LibDevModel libDevModel, List<String> list, final LibInterface.ManagerCallback managerCallback) {
        int iA = a(context, libDevModel, managerCallback, true);
        if (iA != 0) {
            return iA;
        }
        Bundle bundleA = a(list);
        i iVarA = i.a(libDevModel);
        if (b((Integer) 16)) {
            int iA2 = a(bundleA, 16);
            if (iA2 != 0) {
                return iA2;
            }
            iVarA.a(bundleA);
        }
        return f.a(context, 16, new LibInterface.ManagerCallback() { // from class: com.intelligoo.sdk.LibDevModel.3
            @Override // com.intelligoo.sdk.LibInterface.ManagerCallback
            public void setResult(int i2, Bundle bundle) {
                managerCallback.setResult(i2, bundle);
            }
        });
    }

    public static int deleteDeviceData(Context context, LibDevModel libDevModel, LibInterface.ManagerCallback managerCallback) {
        int iA = a(context, libDevModel, managerCallback, true);
        return iA != 0 ? iA : f.a(context, 12, managerCallback);
    }

    public static int deleteFingerprints(Context context, LibDevModel libDevModel, ArrayList<String> arrayList, LibInterface.ManagerCallback managerCallback) {
        int iA = a(context, libDevModel, managerCallback, true);
        if (iA != 0) {
            return iA;
        }
        a(arrayList);
        i iVarA = i.a(libDevModel);
        Bundle bundle = new Bundle();
        bundle.putStringArrayList(ConstantsUtils.USERIDS, arrayList);
        iVarA.a(bundle);
        return f.a(context, 30, managerCallback);
    }

    public static int existSwipeCardAddModel(Context context, LibDevModel libDevModel, LibInterface.ManagerCallback managerCallback) {
        int iA = a(context, libDevModel, managerCallback, true);
        return iA != 0 ? iA : f.a(context, 8, managerCallback);
    }

    public static int existSwipeCardDeleteModel(Context context, LibDevModel libDevModel, LibInterface.ManagerCallback managerCallback) {
        int iA = a(context, libDevModel, managerCallback, true);
        return iA != 0 ? iA : f.a(context, 9, managerCallback);
    }

    public static int getCardNumbersFromDevice(Context context, LibDevModel libDevModel, LibInterface.ReadCardCallback readCardCallback) {
        int iA = a(context, libDevModel, null, false);
        return iA != 0 ? iA : f.a(context, 24, readCardCallback);
    }

    public static int getDeviceConfig(Context context, LibDevModel libDevModel, LibInterface.ManagerCallback managerCallback) {
        int iA = a(context, libDevModel, managerCallback, true);
        return iA != 0 ? iA : f.a(context, 11, managerCallback);
    }

    public static Map<String, String> getEkeyIdentityAndResource(String str) {
        int i2;
        int i3;
        HashMap map = new HashMap();
        if (str != null) {
            if (str.length() == 68) {
                map.put("resIdentity", str.substring(43, 54));
                i2 = 64;
                i3 = 65;
            } else if (str.length() == 74) {
                map.put("resIdentity", str.substring(43, 54));
                i2 = 70;
                i3 = 71;
            }
            map.put("keyResource", str.substring(i2, i3));
        }
        return map;
    }

    public static int getNBDeviceInfo(Context context, LibDevModel libDevModel, LibInterface.ManagerCallback managerCallback) {
        int iA = a(context, libDevModel, managerCallback, true);
        return iA != 0 ? iA : f.a(context, 34, managerCallback);
    }

    public static int getOpenDoorRecordFromDevice(Context context, LibDevModel libDevModel, LibInterface.ReadOpenRecordCallback readOpenRecordCallback) {
        if (readOpenRecordCallback == null) {
            return -103;
        }
        int iA = a(context, libDevModel, null, false);
        return iA != 0 ? iA : f.a(context, 25, readOpenRecordCallback);
    }

    public static int getRecentOpenDoorRecordFromDevice(Context context, LibDevModel libDevModel, int i2, LibInterface.ReadOpenRecordCallback readOpenRecordCallback) {
        if (readOpenRecordCallback == null) {
            return -103;
        }
        int iA = a(context, libDevModel, null, false);
        if (iA != 0) {
            return iA;
        }
        if (i2 < 0) {
            return 93;
        }
        i iVarA = i.a(libDevModel);
        Bundle bundle = new Bundle();
        if (i2 == 0) {
            i2 = -1;
        }
        bundle.putInt(ConstantsUtils.RECORD_READCOUNT, i2);
        iVarA.a(bundle);
        return f.a(context, 32, readOpenRecordCallback);
    }

    public static int modifyPwd(Context context, LibDevModel libDevModel, String str, String str2, LibInterface.ManagerCallback managerCallback) {
        int iA = a(context, libDevModel, managerCallback, true);
        if (iA != 0) {
            return iA;
        }
        if (str == null) {
            str = null;
        } else if (str.equals("")) {
            str = "000000";
        }
        if (str == null || str.length() != 6 || str2 == null || str2.length() != 6) {
            return -19;
        }
        i iVarA = i.a(libDevModel);
        Bundle bundle = new Bundle();
        bundle.putString(ConstantsUtils.MODIFY_NEW_PWD, str2);
        bundle.putString(ConstantsUtils.MODIFY_OLD_PWD, str);
        iVarA.a(bundle);
        return f.a(context, 5, managerCallback);
    }

    public static int openDoor(Context context, LibDevModel libDevModel, LibInterface.ManagerCallback managerCallback) {
        int iA = a(context, libDevModel, managerCallback, true);
        if (iA != 0) {
            return iA;
        }
        int iCheckCardno = checkCardno(libDevModel);
        return iCheckCardno != 0 ? iCheckCardno : f.a(context, 0, managerCallback);
    }

    public static int rebootDevice(Context context, LibDevModel libDevModel, LibInterface.ManagerCallback managerCallback) {
        int iA = a(context, libDevModel, managerCallback, true);
        return iA != 0 ? iA : f.a(context, 21, managerCallback);
    }

    public static int resetDeviceConfig(Context context, LibDevModel libDevModel, LibInterface.ManagerCallback managerCallback) {
        int iA = a(context, libDevModel, managerCallback, true);
        return iA != 0 ? iA : f.a(context, 13, managerCallback);
    }

    public static int scanAddDevice(Context context, String str, Bundle bundle, LibInterface.ManagerCallback managerCallback) {
        LibDevModel libDevModel = new LibDevModel();
        libDevModel.devMac = str;
        i iVarA = i.a(libDevModel);
        if (b((Integer) 3)) {
            int iA = a(bundle, 3);
            if (iA != 0) {
                return iA;
            }
            iVarA.a(bundle);
        }
        return f.a(context, 3, managerCallback);
    }

    public static int scanDevice(Context context, boolean z, int i2, ScanCallback scanCallback) {
        if (context == null) {
            return -42;
        }
        if (scanCallback == null) {
            return -103;
        }
        if (i2 < 11 && i2 > 0) {
            i2 *= OS2WindowsMetricsTable.WEIGHT_CLASS_SEMI_BOLD;
        }
        if ((i2 >= 0 || i2 == -1) && i2 <= 60000) {
            return m.a(context, z, i2, scanCallback);
        }
        return -108;
    }

    public static int scanDeviceBG(Context context, int i2, ScanCallBackSort scanCallBackSort) {
        if (context == null) {
            return -42;
        }
        if (scanCallBackSort == null) {
            return -103;
        }
        if (i2 < 11 && i2 > 0) {
            i2 *= OS2WindowsMetricsTable.WEIGHT_CLASS_SEMI_BOLD;
        }
        if ((i2 >= 0 || i2 == -1) && i2 <= 60000) {
            return m.a(context, i2, scanCallBackSort);
        }
        return -108;
    }

    public static int scanDeviceNonfilter(Context context, int i2, ScanCallBackSort scanCallBackSort) {
        if (context == null) {
            return -42;
        }
        if (scanCallBackSort == null) {
            return -103;
        }
        if (i2 < 11 && i2 > 0) {
            i2 *= OS2WindowsMetricsTable.WEIGHT_CLASS_SEMI_BOLD;
        }
        if ((i2 >= 0 || i2 == -1) && i2 <= 60000) {
            return m.b(context, i2, scanCallBackSort);
        }
        return -108;
    }

    public static int scanDeviceSort(Context context, boolean z, int i2, ScanCallBackSort scanCallBackSort) {
        if (context == null) {
            return -42;
        }
        if (scanCallBackSort == null) {
            return -103;
        }
        if (i2 < 11 && i2 > 0) {
            i2 *= OS2WindowsMetricsTable.WEIGHT_CLASS_SEMI_BOLD;
        }
        if ((i2 >= 0 || i2 == -1) && i2 <= 60000) {
            return m.a(context, z, i2, scanCallBackSort);
        }
        return -108;
    }

    public static int scanDeviceSortWithElectri(Context context, boolean z, int i2, ScanCallBackSortWithElectricity scanCallBackSortWithElectricity) {
        if (context == null) {
            return -42;
        }
        if (scanCallBackSortWithElectricity == null) {
            return -103;
        }
        if (i2 < 11 && i2 > 0) {
            i2 *= OS2WindowsMetricsTable.WEIGHT_CLASS_SEMI_BOLD;
        }
        if ((i2 >= 0 || i2 == -1) && i2 <= 60000) {
            return m.a(context, z, i2, scanCallBackSortWithElectricity);
        }
        return -108;
    }

    public static int setDeviceConfig(Context context, LibDevModel libDevModel, int i2, int i3, int i4, LibInterface.ManagerCallback managerCallback) {
        int iA = a(context, libDevModel, managerCallback, true);
        if (iA != 0) {
            return iA;
        }
        if (i2 != 26 && i2 != 34) {
            return -16;
        }
        if (i3 < 1 || i4 > 254) {
            return -17;
        }
        if (i4 != 0 && i4 != 1) {
            return -18;
        }
        i iVarA = i.a(libDevModel);
        Bundle bundle = new Bundle();
        bundle.putInt(ConstantsUtils.WIEGAND, i2);
        bundle.putInt(ConstantsUtils.OPEN_DELAY, i3);
        bundle.putInt(ConstantsUtils.CONTROL, i4);
        iVarA.a(bundle);
        return f.a(context, 10, managerCallback);
    }

    public static int setDeviceStaticIP(Context context, LibDevModel libDevModel, Bundle bundle, LibInterface.ManagerCallback managerCallback) {
        int iA = a(context, libDevModel, managerCallback, true);
        if (iA != 0) {
            return iA;
        }
        i iVarA = i.a(libDevModel);
        if (b((Integer) 22)) {
            int iA2 = a(bundle, 22);
            if (iA2 != 0) {
                return iA2;
            }
            Bundle bundleC = c(bundle);
            if (bundleC == null) {
                return 93;
            }
            iVarA.a(bundleC);
        }
        l.a("" + iVarA.f9266b.toString());
        return f.a(context, 22, managerCallback);
    }

    public static int setReadSectorKey(Context context, LibDevModel libDevModel, int i2, int i3, String str, LibInterface.ManagerCallback managerCallback) {
        int iA = a(context, libDevModel, managerCallback, true);
        if (iA != 0) {
            return iA;
        }
        if (i2 < 0 || i2 > 255) {
            return -23;
        }
        if (i3 < 0 || i3 > 15) {
            return -24;
        }
        if (str == null || !Pattern.matches("[a-f0-9A-F]{12}", str)) {
            return -22;
        }
        String strB = b(str);
        i iVarA = i.a(libDevModel);
        byte[] bArr = {(byte) (i2 & 255)};
        byte[] bArr2 = {(byte) (i3 & 255)};
        Bundle bundle = new Bundle();
        bundle.putByteArray(ConstantsUtils.DEVICE_ID, bArr);
        bundle.putByteArray(ConstantsUtils.MIFARE_SECTOR, bArr2);
        bundle.putByteArray(ConstantsUtils.SECTOR_KEY, e.e(strB));
        iVarA.a(bundle);
        return f.a(context, 20, managerCallback);
    }

    public static int setServerIP(Context context, LibDevModel libDevModel, Bundle bundle, LibInterface.ManagerCallback managerCallback) {
        int iA = a(context, libDevModel, managerCallback, true);
        if (iA != 0) {
            return iA;
        }
        i iVarA = i.a(libDevModel);
        if (b((Integer) 23)) {
            int iA2 = a(bundle, 23);
            if (iA2 != 0) {
                return iA2;
            }
            Bundle bundleB = b(bundle);
            if (bundleB == null) {
                return 93;
            }
            iVarA.a(bundleB);
        }
        l.a("" + iVarA.f9266b.toString());
        return f.a(context, 23, managerCallback);
    }

    public static void stopScan() {
        m.b();
    }

    public static void stopScanDevice() {
        m.a();
    }

    public static int swipeAddCardModel(Context context, LibDevModel libDevModel, LibInterface.ManagerCallback managerCallback) {
        int iA = a(context, libDevModel, managerCallback, true);
        return iA != 0 ? iA : f.a(context, 6, managerCallback);
    }

    public static int swipeCardDeleteModel(Context context, LibDevModel libDevModel, LibInterface.ManagerCallback managerCallback) {
        int iA = a(context, libDevModel, managerCallback, true);
        return iA != 0 ? iA : f.a(context, 7, managerCallback);
    }

    public static int syncDeviceTime(Context context, LibDevModel libDevModel, String str, LibInterface.ManagerCallback managerCallback) {
        int iA = a(context, libDevModel, managerCallback, true);
        if (iA != 0) {
            return iA;
        }
        if (str.length() == 16) {
            str = str.substring(2, str.length());
        }
        i iVarA = i.a(libDevModel);
        Bundle bundle = new Bundle();
        bundle.putString(ConstantsUtils.SYC_SET_TIME, str);
        iVarA.a(bundle);
        return f.a(context, 4, managerCallback);
    }

    public static int syncFingerPrintToDevice(Context context, LibDevModel libDevModel, ArrayList<DMFingerprintModel> arrayList, LibInterface.SyncFingerprintCallback syncFingerprintCallback) {
        if (syncFingerprintCallback == null) {
            return -103;
        }
        int iA = a(context, libDevModel, null, false);
        return (iA == 0 && checkFingerprint(arrayList) == 0) ? f.a(context, 26, arrayList, syncFingerprintCallback) : iA;
    }

    public static int writeCard(final Context context, LibDevModel libDevModel, List<String> list, final LibInterface.ManagerCallback managerCallback, boolean z) {
        int iA = a(context, libDevModel, managerCallback, true);
        if (iA != 0) {
            return iA;
        }
        if (list == null || list.size() == 0) {
            return -20;
        }
        Bundle bundleA = a(list);
        i iVarA = i.a(libDevModel);
        if (b((Integer) 15)) {
            int iA2 = a(bundleA, 15);
            if (iA2 != 0) {
                return iA2;
            }
            iVarA.a(bundleA);
        }
        return z ? f.a(context, 15, new LibInterface.ManagerCallback() { // from class: com.intelligoo.sdk.LibDevModel.1
            @Override // com.intelligoo.sdk.LibInterface.ManagerCallback
            public void setResult(int i2, Bundle bundle) {
                managerCallback.setResult(i2, bundle);
            }
        }) : f.a(context, 12, new LibInterface.ManagerCallback() { // from class: com.intelligoo.sdk.LibDevModel.2
            @Override // com.intelligoo.sdk.LibInterface.ManagerCallback
            public void setResult(int i2, Bundle bundle) {
                if (i2 != 0) {
                    managerCallback.setResult(i2, bundle);
                } else {
                    f.a(context, 15, new LibInterface.ManagerCallback() { // from class: com.intelligoo.sdk.LibDevModel.2.1
                        @Override // com.intelligoo.sdk.LibInterface.ManagerCallback
                        public void setResult(int i3, Bundle bundle2) {
                            managerCallback.setResult(i3, bundle2);
                        }
                    });
                }
            }
        });
    }

    public String toString() {
        return "device:[ devSn: " + this.devSn + " | devMac：" + this.devMac + " | devType：" + this.devType + " | eKey：" + this.eKey + "]";
    }
}
