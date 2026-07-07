package cn.com.heaton.blelibrary.ble.request;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Message;
import cn.com.heaton.blelibrary.ble.Ble;
import cn.com.heaton.blelibrary.ble.BleHandler;
import cn.com.heaton.blelibrary.ble.BluetoothLeService;
import cn.com.heaton.blelibrary.ble.annotation.Implement;
import cn.com.heaton.blelibrary.ble.callback.BleWriteCallback;
import cn.com.heaton.blelibrary.ble.callback.BleWriteEntityCallback;
import cn.com.heaton.blelibrary.ble.exception.BleWriteException;
import cn.com.heaton.blelibrary.ble.model.BleDevice;
import cn.com.heaton.blelibrary.ble.model.EntityData;
import cn.com.heaton.blelibrary.ble.utils.TaskExecutor;
import java.math.BigDecimal;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
@Implement(WriteRequest.class)
public class WriteRequest<T extends BleDevice> implements IMessage {
    private boolean isWritingEntity;
    private BleWriteEntityCallback<T> mBleEntityLisenter;
    private BleWriteCallback<T> mBleLisenter;
    private boolean isAutoWriteMode = false;
    private final Object lock = new Object();

    public WriteRequest() {
        BleHandler.of().setHandlerCallback(this);
    }

    private void executeEntity(EntityData entityData) {
        final boolean zIsAutoWriteMode = entityData.isAutoWriteMode();
        final byte[] data = entityData.getData();
        final int packLength = entityData.getPackLength();
        final String address = entityData.getAddress();
        final long delay = entityData.getDelay();
        final boolean zIsLastPackComplete = entityData.isLastPackComplete();
        final BluetoothLeService bleService = Ble.getInstance().getBleService();
        TaskExecutor.submit(new Callable<Boolean>() { // from class: cn.com.heaton.blelibrary.ble.request.WriteRequest.2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public Boolean call() throws Exception {
                WriteRequest.this.isWritingEntity = true;
                WriteRequest.this.isAutoWriteMode = zIsAutoWriteMode;
                int length = data.length;
                int i2 = length;
                int i3 = 0;
                while (i3 < length) {
                    if (!WriteRequest.this.isWritingEntity) {
                        if (WriteRequest.this.mBleEntityLisenter != null) {
                            WriteRequest.this.mBleEntityLisenter.onWriteCancel();
                            WriteRequest.this.isAutoWriteMode = false;
                        }
                        return Boolean.FALSE;
                    }
                    int i4 = packLength;
                    if (!zIsLastPackComplete && i2 < i4) {
                        i4 = i2;
                    }
                    byte[] bArr = new byte[i4];
                    for (int i5 = 0; i5 < i4; i5++) {
                        if (i3 < length) {
                            bArr[i5] = data[i3];
                            i3++;
                        }
                    }
                    i2 -= i4;
                    if (bleService.wirteCharacteristic(address, bArr)) {
                        if (WriteRequest.this.mBleEntityLisenter != null) {
                            WriteRequest.this.mBleEntityLisenter.onWriteProgress(new BigDecimal(i3 / length).setScale(2, 4).doubleValue());
                        }
                    } else if (WriteRequest.this.mBleEntityLisenter != null) {
                        WriteRequest.this.mBleEntityLisenter.onWriteFailed();
                        WriteRequest.this.isWritingEntity = false;
                        WriteRequest.this.isAutoWriteMode = false;
                        return Boolean.FALSE;
                    }
                    if (zIsAutoWriteMode) {
                        synchronized (WriteRequest.this.lock) {
                            WriteRequest.this.lock.wait(500L);
                        }
                    } else {
                        try {
                            Thread.sleep(delay);
                        } catch (InterruptedException e2) {
                            e2.printStackTrace();
                        }
                    }
                }
                if (WriteRequest.this.mBleEntityLisenter != null) {
                    WriteRequest.this.mBleEntityLisenter.onWriteSuccess();
                    WriteRequest.this.isWritingEntity = false;
                    WriteRequest.this.isAutoWriteMode = false;
                }
                return Boolean.TRUE;
            }
        });
    }

    public void cancelWriteEntity() {
        if (this.isWritingEntity) {
            this.isWritingEntity = false;
            this.isAutoWriteMode = false;
        }
    }

    @Override // cn.com.heaton.blelibrary.ble.request.IMessage
    public void handleMessage(Message message) {
        if (message.what != 2514) {
            return;
        }
        Object obj = message.obj;
        if (obj instanceof BluetoothGattCharacteristic) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = (BluetoothGattCharacteristic) obj;
            BleWriteCallback<T> bleWriteCallback = this.mBleLisenter;
            if (bleWriteCallback != null) {
                bleWriteCallback.onWriteSuccess(bluetoothGattCharacteristic);
            }
            if (this.isAutoWriteMode) {
                synchronized (this.lock) {
                    this.lock.notify();
                }
            }
        }
    }

    public boolean write(T t, byte[] bArr, BleWriteCallback<T> bleWriteCallback) {
        this.mBleLisenter = bleWriteCallback;
        BluetoothLeService bleService = Ble.getInstance().getBleService();
        if (bleService != null) {
            return bleService.wirteCharacteristic(t.getBleAddress(), bArr);
        }
        return false;
    }

    public void writeEntity(EntityData entityData, BleWriteEntityCallback<T> bleWriteEntityCallback) {
        try {
            EntityData.validParms(entityData);
        } catch (BleWriteException e2) {
            e2.printStackTrace();
        }
        this.mBleEntityLisenter = bleWriteEntityCallback;
        executeEntity(entityData);
    }

    public void writeEntity(final T t, final byte[] bArr, final int i2, final int i3, BleWriteEntityCallback<T> bleWriteEntityCallback) {
        BleWriteEntityCallback<T> bleWriteEntityCallback2;
        this.mBleEntityLisenter = bleWriteEntityCallback;
        final BluetoothLeService bleService = Ble.getInstance().getBleService();
        if ((bArr.length == 0 || i2 == 0 || bleService == null) && (bleWriteEntityCallback2 = this.mBleEntityLisenter) != null) {
            bleWriteEntityCallback2.onWriteFailed();
        } else {
            TaskExecutor.executeTask(new Runnable() { // from class: cn.com.heaton.blelibrary.ble.request.WriteRequest.1
                @Override // java.lang.Runnable
                public void run() {
                    byte[] bArr2 = bArr;
                    int length = bArr2.length;
                    int length2 = bArr2.length;
                    int i4 = i2;
                    int i5 = length2 / i4;
                    int length3 = bArr2.length % i4;
                    int i6 = 1;
                    if (length3 != 0) {
                        i5++;
                    }
                    int i7 = 0;
                    while (i7 < length) {
                        if (length3 == 0) {
                            byte[] bArr3 = new byte[i2];
                            for (int i8 = 0; i8 < i2; i8++) {
                                if (i7 < length) {
                                    bArr3[i8] = bArr[i7];
                                    i7++;
                                }
                            }
                            if (!bleService.wirteCharacteristic(t.getBleAddress(), bArr3) && WriteRequest.this.mBleEntityLisenter != null) {
                                WriteRequest.this.mBleEntityLisenter.onWriteFailed();
                                return;
                            }
                        } else if (i6 == i5) {
                            byte[] bArr4 = new byte[length3];
                            for (int i9 = 0; i9 < length3; i9++) {
                                if (i7 < length) {
                                    bArr4[i9] = bArr[i7];
                                    i7++;
                                }
                            }
                            if (!bleService.wirteCharacteristic(t.getBleAddress(), bArr4) && WriteRequest.this.mBleEntityLisenter != null) {
                                WriteRequest.this.mBleEntityLisenter.onWriteFailed();
                                return;
                            }
                        } else if (i6 < i5) {
                            byte[] bArr5 = new byte[i2];
                            for (int i10 = 0; i10 < i2; i10++) {
                                if (i7 < length) {
                                    bArr5[i10] = bArr[i7];
                                    i7++;
                                }
                            }
                            if (!bleService.wirteCharacteristic(t.getBleAddress(), bArr5) && WriteRequest.this.mBleEntityLisenter != null) {
                                WriteRequest.this.mBleEntityLisenter.onWriteFailed();
                                return;
                            }
                        }
                        try {
                            Thread.sleep(i3);
                        } catch (InterruptedException e2) {
                            e2.printStackTrace();
                        }
                        i6++;
                    }
                    if (WriteRequest.this.mBleEntityLisenter != null) {
                        WriteRequest.this.mBleEntityLisenter.onWriteSuccess();
                    }
                }
            });
        }
    }
}
