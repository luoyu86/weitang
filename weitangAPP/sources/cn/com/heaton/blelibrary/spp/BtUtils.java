package cn.com.heaton.blelibrary.spp;

import android.bluetooth.BluetoothDevice;
import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class BtUtils {
    public static boolean cancelBondProcess(Class<?> cls, BluetoothDevice bluetoothDevice) throws Exception {
        return ((Boolean) cls.getMethod("cancelBondProcess", new Class[0]).invoke(bluetoothDevice, new Object[0])).booleanValue();
    }

    public static boolean cancelPairingUserInput(Class<?> cls, BluetoothDevice bluetoothDevice) throws Exception {
        return ((Boolean) cls.getMethod("cancelPairingUserInput", new Class[0]).invoke(bluetoothDevice, new Object[0])).booleanValue();
    }

    public static boolean createBond(Class<?> cls, BluetoothDevice bluetoothDevice) throws Exception {
        return ((Boolean) cls.getMethod("createBond", new Class[0]).invoke(bluetoothDevice, new Object[0])).booleanValue();
    }

    public static boolean pair(BtDevice btDevice) {
        BluetoothDevice bluetoothDevice = btDevice.getBluetoothDevice();
        if (bluetoothDevice.getBondState() != 12) {
            try {
                setPin(bluetoothDevice.getClass(), bluetoothDevice, "0000");
                createBond(bluetoothDevice.getClass(), bluetoothDevice);
                return true;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } else {
            try {
                createBond(bluetoothDevice.getClass(), bluetoothDevice);
                setPin(bluetoothDevice.getClass(), bluetoothDevice, "0000");
                createBond(bluetoothDevice.getClass(), bluetoothDevice);
                return true;
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
        return false;
    }

    public static void printAllInform(Class cls) {
        try {
            Method[] methods = cls.getMethods();
            for (int i2 = 0; i2 < methods.length; i2++) {
                Log.e("method name", methods[i2].getName() + ";and the i is:" + i2);
            }
            for (Field field : cls.getFields()) {
                Log.e("Field name", field.getName());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static boolean removeBond(Class<?> cls, BluetoothDevice bluetoothDevice) throws Exception {
        return ((Boolean) cls.getMethod("removeBond", new Class[0]).invoke(bluetoothDevice, new Object[0])).booleanValue();
    }

    public static boolean setPin(Class<?> cls, BluetoothDevice bluetoothDevice, String str) throws Exception {
        try {
            return ((Boolean) cls.getDeclaredMethod("setPin", byte[].class).invoke(bluetoothDevice, str.getBytes())).booleanValue();
        } catch (Exception e2) {
            e2.printStackTrace();
            return true;
        }
    }
}
