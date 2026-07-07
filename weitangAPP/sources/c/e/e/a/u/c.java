package c.e.e.a.u;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Build;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import c.e.a.d.g;
import c.e.e.a.s.f;
import c.e.e.a.x.i;
import c.e.e.a.x.k;
import c.e.e.a.x.l;
import com.alibaba.fastjson.JSON;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.chinavisionary.core.app.config.bo.AppConfigExtVo;
import com.chinavisionary.core.app.event.EventUpdateSelectRoom;
import com.chinavisionary.twlib.R;
import com.chinavisionary.twlib.open.bo.ResponseOpenDoorVo;
import com.chinavisionary.twlib.open.service.OpenDoorService;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class c {
    public static Integer getDoorType(String str) {
        int i2;
        str.hashCode();
        i2 = 2;
        switch (str) {
            case "GUODN_ROUTE":
                break;
            case "ZISNOO_ROUTE":
                i2 = 16;
                break;
            case "THINMOO_ROUTE":
                i2 = 1;
                break;
            case "TIANWANG_ROUTE":
                i2 = 0;
                break;
            case "MARS_TIANYIYUN_HTTP_DOOR":
                i2 = 15;
                break;
            default:
                return null;
        }
        return Integer.valueOf(i2);
    }

    public final boolean a(Activity activity, String str) {
        return g.getInstance().isCheckSelfLaboratory(str) && BluetoothAdapter.getDefaultAdapter().isEnabled() && checkGPSIsOpen(activity) && checkAllMustPermission(getAllMustPermission(), activity);
    }

    public final String b(String str) {
        Set<String> queryParameterNames = Uri.parse(str).getQueryParameterNames();
        StringBuilder sb = new StringBuilder(2);
        sb.append(str);
        if (queryParameterNames == null || queryParameterNames.isEmpty()) {
            sb.append("?x-oss-process=image/resize,m_lfit,h_");
            sb.append(1920);
            sb.append(",w_");
            sb.append(1080);
        } else {
            sb.append("&x-oss-process=image/resize,m_lfit,h_");
            sb.append(1920);
            sb.append(",w_");
            sb.append(1080);
        }
        return sb.toString();
    }

    public boolean checkAllMustPermission(List<String> list, Activity activity) {
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (-1 == ContextCompat.checkSelfPermission(activity, it.next())) {
                return false;
            }
        }
        return true;
    }

    public boolean checkGPSIsOpen(Activity activity) {
        LocationManager locationManager = (LocationManager) activity.getApplicationContext().getSystemService(RequestParameters.SUBRESOURCE_LOCATION);
        if (locationManager == null) {
            return false;
        }
        return locationManager.isProviderEnabled("gps") || locationManager.isProviderEnabled("network");
    }

    public void disableBle() {
        if (!isEnableBle() || Build.VERSION.SDK_INT < 23) {
            return;
        }
        BluetoothAdapter.getDefaultAdapter().disable();
    }

    public List<String> getAllMustPermission() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("android.permission.ACCESS_FINE_LOCATION");
        arrayList.add("android.permission.ACCESS_COARSE_LOCATION");
        if (Build.VERSION.SDK_INT >= 31) {
            arrayList.add("android.permission.BLUETOOTH_SCAN");
            arrayList.add("android.permission.BLUETOOTH_ADVERTISE");
            arrayList.add("android.permission.BLUETOOTH_CONNECT");
        }
        return arrayList;
    }

    public boolean getAllPermission(Activity activity) {
        return checkAllMustPermission(getAllMustPermission(), activity);
    }

    public c.e.e.a.x.d getBleUnlockResponse(ResponseOpenDoorVo responseOpenDoorVo) {
        String bluetoothCookie = responseOpenDoorVo.getBluetoothCookie();
        String bluetoothPassword = responseOpenDoorVo.getBluetoothPassword();
        String bluetoothMac = responseOpenDoorVo.getBluetoothMac();
        c.e.e.a.x.d dVar = new c.e.e.a.x.d();
        dVar.setBluetoothCookie(bluetoothCookie);
        dVar.setBluetoothMac(bluetoothMac);
        dVar.setBluetoothPassword(bluetoothPassword);
        return dVar;
    }

    public f getOpenStateLogBo(String str, String str2) {
        f fVar = new f();
        fVar.setRemark(k.getString(R.string.tw_lib_tip_get_pwd_error));
        fVar.setStatus(0);
        fVar.setFailReason(l.getInstance().getFailedMessage(str));
        fVar.setAssetInstanceKey(str2);
        String remark = fVar.getRemark();
        if (remark != null) {
            fVar.setRemark(remark + "," + str);
        }
        fVar.setAppVersion(c.e.a.a.b.getInstance().getAppVersionName());
        return fVar;
    }

    public boolean isAuthPermission(String[] strArr, int[] iArr) {
        if (strArr != null && strArr.length > 0 && iArr != null && iArr.length > 0) {
            for (int i2 : iArr) {
                if (i2 == -1) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isEnableBle() {
        return BluetoothAdapter.getDefaultAdapter().isEnabled();
    }

    public void performOpenGPS(Activity activity, int i2) {
        activity.startActivityForResult(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"), i2);
    }

    public void sendUpdateSelectRoom(String str, String str2) {
        if (k.isNotNull(str)) {
            EventUpdateSelectRoom eventUpdateSelectRoom = new EventUpdateSelectRoom();
            eventUpdateSelectRoom.setKey(str2);
            eventUpdateSelectRoom.setName(str);
            g.b.a.c.getDefault().post(eventUpdateSelectRoom);
        }
    }

    public AppConfigExtVo.ADScreen.LockScreenBean setupADScreen(AppConfigExtVo appConfigExtVo, ImageView imageView) {
        AppConfigExtVo.ADScreen adScreenVo;
        if (appConfigExtVo == null || (adScreenVo = appConfigExtVo.getAdScreenVo()) == null) {
            return null;
        }
        AppConfigExtVo.ADScreen.LockScreenBean lockScreen = adScreenVo.getLockScreen();
        if (lockScreen == null) {
            return lockScreen;
        }
        String resource = lockScreen.getResource();
        if (!k.isNotNull(resource)) {
            return lockScreen;
        }
        String str = c.e.a.d.l.getAdLockNamePath() + c.e.a.d.l.getFileName(resource);
        File file = new File(str);
        i.d(c.class.getSimpleName(), "splashPath :" + str);
        if (!file.exists()) {
            c.e.a.d.c0.d.getInstance().display(b(resource), imageView, R.mipmap.tw_lib_ic_unlock_bg);
            return lockScreen;
        }
        c.e.a.d.c0.d.getInstance().display(file, imageView);
        i.d(c.class.getSimpleName(), "splashPath :" + str);
        return lockScreen;
    }

    public void startOpenDoorService(Activity activity, int i2, String str) {
        ResponseOpenDoorVo roomResponseOpenDoorVo;
        if (i2 == 1 && a(activity, str) && (roomResponseOpenDoorVo = d.getInstance().getRoomResponseOpenDoorVo()) != null) {
            c.e.e.a.x.d dVar = new c.e.e.a.x.d();
            dVar.setBluetoothMac(roomResponseOpenDoorVo.getBluetoothMac());
            dVar.setBluetoothPassword(roomResponseOpenDoorVo.getBluetoothPassword());
            dVar.setBluetoothCookie(roomResponseOpenDoorVo.getBluetoothCookie());
            Intent intent = new Intent(activity, (Class<?>) OpenDoorService.class);
            intent.setFlags(268435456);
            if (roomResponseOpenDoorVo.getAdapterModel() != null) {
                Integer doorType = getDoorType(roomResponseOpenDoorVo.getAdapterModel());
                roomResponseOpenDoorVo.setSupplierType(doorType.intValue());
                if (doorType.intValue() == 15 || doorType.intValue() == 16) {
                    dVar.setBluetoothPassword(roomResponseOpenDoorVo.getResultData());
                }
            }
            intent.putExtra("type", roomResponseOpenDoorVo.getSupplierType());
            intent.putExtra(com.alipay.sdk.m.p0.b.f5579d, JSON.toJSONString(dVar));
            if (Build.VERSION.SDK_INT >= 26) {
                activity.startForegroundService(intent);
            } else {
                activity.startService(intent);
            }
        }
    }
}
