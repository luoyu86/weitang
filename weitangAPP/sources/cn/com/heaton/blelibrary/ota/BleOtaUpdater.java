package cn.com.heaton.blelibrary.ota;

import android.os.Handler;
import cn.com.heaton.blelibrary.ble.Ble;
import cn.com.heaton.blelibrary.ble.model.BleDevice;
import cn.com.heaton.blelibrary.ota.OtaStatus;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.concurrent.Semaphore;

/* JADX INFO: loaded from: classes.dex */
public class BleOtaUpdater implements OtaListener {
    public static final int OTA_BEFORE = 4;
    public static final int OTA_FAIL = 3;
    public static final int OTA_OVER = 2;
    public static final int OTA_UPDATE = 1;
    private static final String TAG = "BleOtaUpdater";
    private BleDevice mBleDevice;
    private Ble mBleManager;
    private Handler mHandler;
    private Thread mUpdateThread;
    private Semaphore semp;
    private int mStartOffset = 0;
    private int mPercent = 0;
    private final int mTimeout = 12;
    private final int mPacketSize = 256;
    private boolean mShouldStop = false;
    private String mFilePath = null;
    private int mByteRate = 0;
    private int mElapsedTime = 0;
    private int mIndex = 0;
    private OtaStatus.OtaResult mRetValue = OtaStatus.OtaResult.OTA_RESULT_SUCCESS;
    private Runnable mUpdateRunnable = new Runnable() { // from class: cn.com.heaton.blelibrary.ota.BleOtaUpdater.1
        @Override // java.lang.Runnable
        public void run() {
            BleOtaUpdater bleOtaUpdater = BleOtaUpdater.this;
            bleOtaUpdater.otaUpdateProcess(bleOtaUpdater.mFilePath);
        }
    };

    /* JADX INFO: renamed from: cn.com.heaton.blelibrary.ota.BleOtaUpdater$2, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
        public static final /* synthetic */ int[] $SwitchMap$cn$com$heaton$blelibrary$ota$OtaStatus$OtaCmd;

        static {
            int[] iArr = new int[OtaStatus.OtaCmd.values().length];
            $SwitchMap$cn$com$heaton$blelibrary$ota$OtaStatus$OtaCmd = iArr;
            try {
                iArr[OtaStatus.OtaCmd.OTA_CMD_META_DATA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$cn$com$heaton$blelibrary$ota$OtaStatus$OtaCmd[OtaStatus.OtaCmd.OTA_CMD_BRICK_DATA.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$cn$com$heaton$blelibrary$ota$OtaStatus$OtaCmd[OtaStatus.OtaCmd.OTA_CMD_DATA_VERIFY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$cn$com$heaton$blelibrary$ota$OtaStatus$OtaCmd[OtaStatus.OtaCmd.OTA_CMD_EXECUTION_NEW_CODE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public BleOtaUpdater(Handler handler) {
        this.mHandler = handler;
    }

    private byte cmdToValue(OtaStatus.OtaCmd otaCmd) {
        int i2 = AnonymousClass2.$SwitchMap$cn$com$heaton$blelibrary$ota$OtaStatus$OtaCmd[otaCmd.ordinal()];
        byte b2 = 1;
        if (i2 != 1) {
            b2 = 2;
            if (i2 != 2) {
                b2 = 3;
                if (i2 != 3) {
                    b2 = 4;
                    if (i2 != 4) {
                        return (byte) 0;
                    }
                }
            }
        }
        return b2;
    }

    private int getOffset() {
        if (waitSemaphore(this.semp)) {
            return this.mStartOffset;
        }
        return -1;
    }

    private void notifyReadDataCompleted() {
        releaseSemaphore(this.semp);
    }

    private void notifyVerifyCmdDone() {
        releaseSemaphore(this.semp);
    }

    private int otaSendBrickData(FileInputStream fileInputStream, int i2) throws IOException {
        byte[] bArr = new byte[i2];
        int i3 = fileInputStream.read(bArr);
        if (i3 <= 0) {
            return -1;
        }
        if (i3 < i2) {
            i2 = i3;
        }
        short sCmdToValue = cmdToValue(OtaStatus.OtaCmd.OTA_CMD_BRICK_DATA);
        for (int i4 = 0; i4 < i2; i4++) {
            sCmdToValue = (short) (sCmdToValue + (bArr[i4] & 255));
        }
        if (otaSendPacket(OtaStatus.OtaCmd.OTA_CMD_BRICK_DATA, sCmdToValue, bArr, i2)) {
            return i3;
        }
        return -2;
    }

    private int otaSendMetaData(FileInputStream fileInputStream) throws IOException {
        byte[] bArr = new byte[2];
        fileInputStream.read(bArr);
        int i2 = (short) (((bArr[1] & 255) << 8) + (bArr[0] & 255));
        byte[] bArr2 = new byte[i2];
        int i3 = fileInputStream.read(bArr2);
        if (i3 < 0) {
            return -1;
        }
        short sCmdToValue = cmdToValue(OtaStatus.OtaCmd.OTA_CMD_META_DATA);
        for (int i4 = 0; i4 < i3; i4++) {
            sCmdToValue = (short) (sCmdToValue + (bArr2[i4] & 255));
        }
        if (otaSendPacket(OtaStatus.OtaCmd.OTA_CMD_META_DATA, sCmdToValue, bArr2, i2)) {
            return i3 + 2;
        }
        return -1;
    }

    private boolean otaSendPacket(OtaStatus.OtaCmd otaCmd, short s, byte[] bArr, int i2) {
        int i3;
        byte[] bArr2;
        byte bCmdToValue = cmdToValue(otaCmd);
        byte[] bArr3 = {(byte) s, (byte) (s >> 8)};
        byte[] bArr4 = new byte[3];
        int i4 = AnonymousClass2.$SwitchMap$cn$com$heaton$blelibrary$ota$OtaStatus$OtaCmd[otaCmd.ordinal()];
        if (i4 == 1 || i4 == 2) {
            int i5 = i2 + 1;
            bArr4[0] = (byte) i5;
            bArr4[1] = (byte) (i5 >> 8);
            bArr4[2] = bCmdToValue;
            int i6 = 3 + i2;
            int i7 = i6 + 2;
            byte[] bArr5 = new byte[i7];
            System.arraycopy(bArr4, 0, bArr5, 0, 3);
            System.arraycopy(bArr, 0, bArr5, 3, i2);
            System.arraycopy(bArr3, 0, bArr5, i6, 2);
            i3 = i7;
            bArr2 = bArr5;
        } else {
            if (i4 != 3 && i4 != 4) {
                return false;
            }
            i3 = 5;
            bArr2 = new byte[]{1, 0, bCmdToValue, bArr3[0], bArr3[1]};
        }
        int i8 = i3;
        while (i8 > 0) {
            int i9 = i8 > 20 ? 20 : i8;
            byte[] bArr6 = new byte[i9];
            System.arraycopy(bArr2, i3 - i8, bArr6, 0, i9);
            try {
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
            if (!otaWrite(bArr6)) {
                return false;
            }
            i8 -= i9;
        }
        return true;
    }

    private void otaSendResetCmd() {
        otaSendPacket(OtaStatus.OtaCmd.OTA_CMD_EXECUTION_NEW_CODE, cmdToValue(r0), null, 0);
    }

    private boolean otaSendVerifyCmd() {
        OtaStatus.OtaCmd otaCmd = OtaStatus.OtaCmd.OTA_CMD_DATA_VERIFY;
        return otaSendPacket(otaCmd, (short) cmdToValue(otaCmd), null, 0) && waitVerifyCmdDone();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void otaUpdateProcess(String str) {
        try {
            Handler handler = this.mHandler;
            if (handler != null) {
                handler.obtainMessage(4, Integer.valueOf(this.mIndex)).sendToTarget();
            }
            FileInputStream fileInputStream = new FileInputStream(str);
            int iAvailable = fileInputStream.available();
            if (iAvailable != 0 && !this.mShouldStop) {
                int iOtaSendMetaData = otaSendMetaData(fileInputStream);
                if (iOtaSendMetaData >= 0 && !this.mShouldStop) {
                    int offset = getOffset();
                    if (offset >= 0 && !this.mShouldStop) {
                        if (offset > 0) {
                            fileInputStream.skip(offset);
                        }
                        int i2 = iAvailable - iOtaSendMetaData;
                        long timeInMillis = Calendar.getInstance().getTimeInMillis();
                        int i3 = 0;
                        do {
                            int iOtaSendBrickData = otaSendBrickData(fileInputStream, 256);
                            if (iOtaSendBrickData >= 0 && !this.mShouldStop) {
                                if (waitReadDataCompleted() && !this.mShouldStop) {
                                    offset += iOtaSendBrickData;
                                    int i4 = (offset * 100) / iAvailable;
                                    this.mPercent = i4;
                                    Handler handler2 = this.mHandler;
                                    if (handler2 != null) {
                                        handler2.obtainMessage(1, i4, 0, Integer.valueOf(this.mIndex)).sendToTarget();
                                    }
                                    i3 += 256;
                                    long timeInMillis2 = Calendar.getInstance().getTimeInMillis() - timeInMillis;
                                    this.mElapsedTime = (int) (timeInMillis2 / 1000);
                                    this.mByteRate = (int) (((long) (i3 * 1000)) / timeInMillis2);
                                }
                                serErrorCode(OtaStatus.OtaResult.OTA_RESULT_DATA_RESPONSE_TIMEOUT);
                                Handler handler3 = this.mHandler;
                                if (handler3 != null) {
                                    handler3.obtainMessage(3, Integer.valueOf(this.mIndex)).sendToTarget();
                                    return;
                                }
                                return;
                            }
                            fileInputStream.close();
                            serErrorCode(OtaStatus.OtaResult.OTA_RESULT_DATA_RESPONSE_TIMEOUT);
                            Handler handler4 = this.mHandler;
                            if (handler4 != null) {
                                handler4.obtainMessage(3, Integer.valueOf(this.mIndex)).sendToTarget();
                                return;
                            }
                            return;
                        } while (offset < i2);
                        if (otaSendVerifyCmd() && !this.mShouldStop) {
                            this.mPercent = 100;
                            otaSendResetCmd();
                            fileInputStream.close();
                            Handler handler5 = this.mHandler;
                            if (handler5 != null) {
                                handler5.obtainMessage(2, Integer.valueOf(this.mIndex)).sendToTarget();
                            }
                            serErrorCode(OtaStatus.OtaResult.OTA_RESULT_SUCCESS);
                            return;
                        }
                        fileInputStream.close();
                        serErrorCode(OtaStatus.OtaResult.OTA_RESULT_FW_VERIFY_ERROR);
                        Handler handler6 = this.mHandler;
                        if (handler6 != null) {
                            handler6.obtainMessage(3, Integer.valueOf(this.mIndex)).sendToTarget();
                            return;
                        }
                        return;
                    }
                    fileInputStream.close();
                    serErrorCode(OtaStatus.OtaResult.OTA_RESULT_META_RESPONSE_TIMEOUT);
                    Handler handler7 = this.mHandler;
                    if (handler7 != null) {
                        handler7.obtainMessage(3, Integer.valueOf(this.mIndex)).sendToTarget();
                        return;
                    }
                    return;
                }
                fileInputStream.close();
                serErrorCode(OtaStatus.OtaResult.OTA_RESULT_SEND_META_ERROR);
                Handler handler8 = this.mHandler;
                if (handler8 != null) {
                    handler8.obtainMessage(3, Integer.valueOf(this.mIndex)).sendToTarget();
                    return;
                }
                return;
            }
            fileInputStream.close();
            serErrorCode(OtaStatus.OtaResult.OTA_RESULT_FW_SIZE_ERROR);
            Handler handler9 = this.mHandler;
            if (handler9 != null) {
                handler9.obtainMessage(3, Integer.valueOf(this.mIndex)).sendToTarget();
            }
        } catch (Exception unused) {
            serErrorCode(OtaStatus.OtaResult.OTA_RESULT_DATA_RESPONSE_TIMEOUT);
            Handler handler10 = this.mHandler;
            if (handler10 != null) {
                handler10.obtainMessage(3, Integer.valueOf(this.mIndex)).sendToTarget();
            }
        }
    }

    private boolean otaWrite(byte[] bArr) throws InterruptedException {
        if (!shouldStopUpdate() && this.mBleManager.getBleService().writeOtaData(this.mBleDevice.getBleAddress(), bArr)) {
            return waitWriteDataCompleted();
        }
        return false;
    }

    private void releaseSemaphore(Semaphore semaphore) {
        semaphore.release();
    }

    private void serErrorCode(OtaStatus.OtaResult otaResult) {
        this.mRetValue = otaResult;
    }

    private void setOffset(int i2) {
        this.mStartOffset = i2;
        releaseSemaphore(this.semp);
    }

    private boolean shouldStopUpdate() {
        return this.mShouldStop;
    }

    private OtaStatus.OtaCmd valueToCmd(int i2) {
        int i3 = i2 & 255;
        if (i3 == 1) {
            return OtaStatus.OtaCmd.OTA_CMD_META_DATA;
        }
        if (i3 == 2) {
            return OtaStatus.OtaCmd.OTA_CMD_BRICK_DATA;
        }
        if (i3 == 3) {
            return OtaStatus.OtaCmd.OTA_CMD_DATA_VERIFY;
        }
        if (i3 != 4) {
            return null;
        }
        return OtaStatus.OtaCmd.OTA_CMD_EXECUTION_NEW_CODE;
    }

    private boolean waitReadDataCompleted() {
        return waitSemaphore(this.semp);
    }

    private boolean waitSemaphore(Semaphore semaphore) {
        int i2 = 0;
        while (true) {
            int i3 = i2 + 1;
            if (i2 >= 12000) {
                return false;
            }
            if (semaphore.tryAcquire()) {
                return true;
            }
            try {
                Thread.sleep(1L);
                if (shouldStopUpdate()) {
                    return false;
                }
                i2 = i3;
            } catch (InterruptedException unused) {
                return true;
            }
        }
    }

    private boolean waitVerifyCmdDone() {
        return waitSemaphore(this.semp);
    }

    private boolean waitWriteDataCompleted() {
        return waitSemaphore(this.semp);
    }

    public BleDevice getBleDevice() {
        return this.mBleDevice;
    }

    public Ble getBleManager() {
        return this.mBleManager;
    }

    public int getIndex() {
        return this.mIndex;
    }

    public void notifyWriteDataCompleted() {
        releaseSemaphore(this.semp);
    }

    @Override // cn.com.heaton.blelibrary.ota.OtaListener
    public void onChange(byte[] bArr) {
        otaGetResult(bArr);
    }

    @Override // cn.com.heaton.blelibrary.ota.OtaListener
    public void onWrite() {
        notifyReadDataCompleted();
    }

    public OtaStatus.OtaResult otaGetProcess(int[] iArr) {
        if (iArr.length < 8) {
            return OtaStatus.OtaResult.OTA_RESULT_INVALID_ARGUMENT;
        }
        Arrays.fill(iArr, 0);
        iArr[0] = this.mPercent;
        iArr[1] = this.mByteRate;
        iArr[2] = this.mElapsedTime;
        return this.mRetValue;
    }

    public void otaGetResult(byte[] bArr) {
        OtaStatus.OtaCmd otaCmdValueToCmd = valueToCmd(bArr[2] & 255);
        if (otaCmdValueToCmd == null) {
            otaPrintBytes(bArr, "Notify data: ");
            serErrorCode(OtaStatus.OtaResult.OTA_RESULT_RECEIVED_INVALID_PACKET);
            return;
        }
        byte b2 = bArr[3];
        if (b2 == 0) {
            serErrorCode(OtaStatus.OtaResult.OTA_RESULT_SUCCESS);
        } else if (b2 == 1) {
            serErrorCode(OtaStatus.OtaResult.OTA_RESULT_PKT_CHECKSUM_ERROR);
        } else if (b2 == 2) {
            serErrorCode(OtaStatus.OtaResult.OTA_RESULT_PKT_LEN_ERROR);
        } else if (b2 == 3) {
            serErrorCode(OtaStatus.OtaResult.OTA_RESULT_DEVICE_NOT_SUPPORT_OTA);
        } else if (b2 == 4) {
            serErrorCode(OtaStatus.OtaResult.OTA_RESULT_FW_SIZE_ERROR);
        } else if (b2 != 5) {
            serErrorCode(OtaStatus.OtaResult.OTA_RESULT_INVALID_ARGUMENT);
        } else {
            serErrorCode(OtaStatus.OtaResult.OTA_RESULT_FW_VERIFY_ERROR);
        }
        if (this.mRetValue != OtaStatus.OtaResult.OTA_RESULT_SUCCESS) {
            otaPrintBytes(bArr, "Notify data: ");
            return;
        }
        int i2 = AnonymousClass2.$SwitchMap$cn$com$heaton$blelibrary$ota$OtaStatus$OtaCmd[otaCmdValueToCmd.ordinal()];
        if (i2 == 1) {
            setOffset((short) ((bArr[4] & 255) + ((bArr[5] & 255) << 8)));
            return;
        }
        if (i2 == 2) {
            byte b3 = bArr[4];
            byte b4 = bArr[5];
            notifyReadDataCompleted();
        } else if (i2 == 3) {
            notifyVerifyCmdDone();
        } else if (i2 != 4) {
            serErrorCode(OtaStatus.OtaResult.OTA_RESULT_INVALID_ARGUMENT);
        }
    }

    public void otaPrintBytes(byte[] bArr, String str) {
        if (bArr != null) {
            StringBuilder sb = new StringBuilder(bArr.length);
            for (byte b2 : bArr) {
                sb.append(String.format("%02X ", Byte.valueOf(b2)));
            }
        }
    }

    public OtaStatus.OtaResult otaStart(String str, BleDevice bleDevice, Ble ble) {
        if (str.isEmpty() || ble == null) {
            return OtaStatus.OtaResult.OTA_RESULT_INVALID_ARGUMENT;
        }
        this.mFilePath = str;
        this.mBleDevice = bleDevice;
        this.mBleManager = ble;
        ble.getBleService().setOtaListener(this);
        this.mShouldStop = false;
        this.mPercent = 0;
        this.mByteRate = 0;
        this.mElapsedTime = 0;
        this.semp = new Semaphore(0);
        Thread thread = new Thread(this.mUpdateRunnable);
        this.mUpdateThread = thread;
        thread.start();
        return OtaStatus.OtaResult.OTA_RESULT_SUCCESS;
    }

    public void otaStop() {
        this.mShouldStop = true;
        Thread thread = this.mUpdateThread;
        if (thread != null) {
            thread.interrupt();
        }
    }

    public void setIndex(int i2) {
        this.mIndex = i2;
    }
}
