package com.intelligoo.sdk.utils;

import android.app.Activity;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.content.Intent;
import com.alipay.sdk.m.x.d;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
public class BleUtil {
    public static void closeBluetoothGatt(BluetoothGatt bluetoothGatt) {
        if (bluetoothGatt != null) {
            bluetoothGatt.disconnect();
            refreshDeviceCache(bluetoothGatt);
            bluetoothGatt.close();
        }
    }

    public static void enableBluetooth(Activity activity, int i2) {
        activity.startActivityForResult(new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE"), i2);
    }

    public static BluetoothGattCharacteristic getCharacteristic(BluetoothGatt bluetoothGatt, String str, String str2) {
        BluetoothGattService service = bluetoothGatt.getService(UUID.fromString(str));
        if (service != null) {
            return service.getCharacteristic(UUID.fromString(str2));
        }
        return null;
    }

    public static BluetoothGattCharacteristic getCharacteristic(BluetoothGattService bluetoothGattService, String str) {
        if (bluetoothGattService != null) {
            return bluetoothGattService.getCharacteristic(UUID.fromString(str));
        }
        return null;
    }

    public static BluetoothGattService getService(BluetoothGatt bluetoothGatt, String str) {
        return bluetoothGatt.getService(UUID.fromString(str));
    }

    public static boolean isBleEnable(Context context) {
        if (isSupportBle(context)) {
            return ((BluetoothManager) context.getSystemService("bluetooth")).getAdapter().isEnabled();
        }
        return false;
    }

    public static boolean isSupportBle(Context context) {
        return (context == null || !context.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le") || ((BluetoothManager) context.getSystemService("bluetooth")).getAdapter() == null) ? false : true;
    }

    public static void printServices(BluetoothGatt bluetoothGatt) {
        if (bluetoothGatt != null) {
            for (BluetoothGattService bluetoothGattService : bluetoothGatt.getServices()) {
                BleLog.i("service: " + bluetoothGattService.getUuid());
                for (BluetoothGattCharacteristic bluetoothGattCharacteristic : bluetoothGattService.getCharacteristics()) {
                    BleLog.d("  characteristic: " + bluetoothGattCharacteristic.getUuid() + " value: " + Arrays.toString(bluetoothGattCharacteristic.getValue()));
                    for (BluetoothGattDescriptor bluetoothGattDescriptor : bluetoothGattCharacteristic.getDescriptors()) {
                        BleLog.v("        descriptor: " + bluetoothGattDescriptor.getUuid() + " value: " + Arrays.toString(bluetoothGattDescriptor.getValue()));
                    }
                }
            }
        }
    }

    public static boolean refreshDeviceCache(BluetoothGatt bluetoothGatt) {
        try {
            Method method = BluetoothGatt.class.getMethod(d.w, new Class[0]);
            if (method != null) {
                boolean zBooleanValue = ((Boolean) method.invoke(bluetoothGatt, new Object[0])).booleanValue();
                BleLog.i("Refreshing result: " + zBooleanValue);
                return zBooleanValue;
            }
        } catch (Exception e2) {
            BleLog.e("An exception occured while refreshing device", e2);
        }
        return false;
    }
}
