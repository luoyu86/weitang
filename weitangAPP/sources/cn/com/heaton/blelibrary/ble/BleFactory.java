package cn.com.heaton.blelibrary.ble;

import android.bluetooth.BluetoothDevice;
import cn.com.heaton.blelibrary.ble.model.BleDevice;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes.dex */
public class BleFactory<T extends BleDevice> {
    public static <T extends BleDevice> T create(Class<T> cls, BluetoothDevice bluetoothDevice) {
        try {
            Constructor<T> declaredConstructor = cls.getDeclaredConstructor(BluetoothDevice.class);
            declaredConstructor.setAccessible(true);
            try {
                try {
                    T tNewInstance = declaredConstructor.newInstance(bluetoothDevice);
                    tNewInstance.setAutoConnect(Ble.options().autoConnect);
                    return tNewInstance;
                } catch (InstantiationException e2) {
                    e2.printStackTrace();
                    throw new ClassCastException("Class must implements BleDevice");
                } catch (InvocationTargetException e3) {
                    e3.printStackTrace();
                    throw new ClassCastException("Class must implements BleDevice");
                }
            } catch (IllegalAccessException e4) {
                e4.printStackTrace();
                throw new ClassCastException("Class must implements BleDevice");
            }
        } catch (NoSuchMethodException e5) {
            e5.printStackTrace();
        }
    }
}
