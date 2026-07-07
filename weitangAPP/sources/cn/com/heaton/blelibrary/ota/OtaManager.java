package cn.com.heaton.blelibrary.ota;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import android.util.SparseArray;
import android.widget.ProgressBar;
import cn.com.heaton.blelibrary.R;
import cn.com.heaton.blelibrary.ble.Ble;
import cn.com.heaton.blelibrary.ble.model.BleDevice;
import cn.com.heaton.blelibrary.ota.OtaStatus;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public class OtaManager {
    public static final String TAG = "OtaManager";
    private Context mContext;
    private File mOtaFile;
    private ProgressBar mProgress;
    private ProgressDialog mUpdateDialog;
    private UpdateListener mUpdateListener;
    private MessageHandler mHandler = new MessageHandler(this);
    private SparseArray<BleOtaUpdater> mUpdateList = new SparseArray<>();
    private int mCounter = 0;
    private boolean mSingle = true;
    private boolean mStopUpdate = false;

    public static class MessageHandler extends Handler {
        private WeakReference<OtaManager> weakReference;

        public MessageHandler(OtaManager otaManager) {
            this.weakReference = new WeakReference<>(otaManager);
        }

        @Override // android.os.Handler
        public void dispatchMessage(Message message) {
            BleDevice bleDevice;
            String str;
            final OtaManager otaManager = this.weakReference.get();
            if (otaManager != null) {
                Integer num = (Integer) message.obj;
                final BleOtaUpdater bleOtaUpdater = null;
                if (num != null) {
                    BleOtaUpdater bleOtaUpdater2 = (BleOtaUpdater) otaManager.mUpdateList.get(num.intValue());
                    bleOtaUpdater = bleOtaUpdater2;
                    bleDevice = bleOtaUpdater2 != null ? bleOtaUpdater2.getBleDevice() : null;
                } else {
                    bleDevice = null;
                }
                int i2 = message.what;
                if (i2 == 1) {
                    if (otaManager.mStopUpdate) {
                        return;
                    }
                    otaManager.showProgress(message.arg1);
                    if (otaManager.mUpdateListener != null) {
                        otaManager.mUpdateListener.onUpdating(bleDevice, message.arg1);
                        return;
                    }
                    return;
                }
                if (i2 == 2) {
                    if (otaManager.mUpdateDialog != null) {
                        otaManager.mUpdateDialog.dismiss();
                    }
                    if (bleOtaUpdater != null) {
                        otaManager.mUpdateList.remove(bleOtaUpdater.getIndex());
                    }
                    if (otaManager.mUpdateListener != null) {
                        otaManager.mUpdateListener.onUpdateComplete(bleDevice);
                        return;
                    }
                    return;
                }
                if (i2 != 3) {
                    if (i2 != 4) {
                        super.dispatchMessage(message);
                        return;
                    } else {
                        if (otaManager.mUpdateListener != null) {
                            otaManager.mUpdateListener.onPreUpdate(bleDevice);
                            return;
                        }
                        return;
                    }
                }
                if (otaManager.mUpdateDialog != null) {
                    otaManager.mUpdateDialog.dismiss();
                    AlertDialog.Builder builder = new AlertDialog.Builder(otaManager.mContext);
                    builder.setTitle("硬件更新");
                    Resources resources = otaManager.mContext.getResources();
                    int i3 = R.string.ota_error;
                    Object[] objArr = new Object[1];
                    if (bleDevice != null) {
                        str = "[" + bleDevice.getBleName() + "]";
                    } else {
                        str = "";
                    }
                    objArr[0] = str;
                    builder.setMessage(resources.getString(i3, objArr));
                    builder.setPositiveButton(R.string.update_retry, new DialogInterface.OnClickListener() { // from class: cn.com.heaton.blelibrary.ota.OtaManager.MessageHandler.1
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i4) {
                            dialogInterface.dismiss();
                            otaManager.retryUpdate(bleOtaUpdater);
                        }
                    });
                    builder.setNegativeButton(R.string.update_cancel, new DialogInterface.OnClickListener() { // from class: cn.com.heaton.blelibrary.ota.OtaManager.MessageHandler.2
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i4) {
                            dialogInterface.dismiss();
                        }
                    });
                    builder.create().show();
                }
                if (otaManager.mUpdateListener != null) {
                    otaManager.mUpdateListener.onUpdateFailed(bleDevice);
                }
            }
        }
    }

    public interface UpdateListener {
        void onPreUpdate(BleDevice bleDevice);

        void onUpdateComplete(BleDevice bleDevice);

        void onUpdateFailed(BleDevice bleDevice);

        void onUpdating(BleDevice bleDevice, int i2);
    }

    public OtaManager(Context context) {
        this.mContext = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void retryUpdate(BleOtaUpdater bleOtaUpdater) {
        if (this.mStopUpdate || bleOtaUpdater == null) {
            return;
        }
        this.mUpdateList.remove(bleOtaUpdater.getIndex());
        startOtaUpdate(this.mOtaFile, bleOtaUpdater.getBleDevice(), bleOtaUpdater.getBleManager());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showProgress(int i2) {
        if (this.mSingle) {
            if (this.mUpdateDialog == null) {
                ProgressDialog progressDialog = new ProgressDialog(this.mContext);
                this.mUpdateDialog = progressDialog;
                progressDialog.setTitle(R.string.update_cancel);
                this.mUpdateDialog.setMessage(this.mContext.getString(R.string.updating));
                this.mUpdateDialog.setProgressStyle(1);
            }
            if (!this.mUpdateDialog.isShowing()) {
                this.mUpdateDialog.show();
            }
            this.mUpdateDialog.setProgress(i2);
        }
    }

    public UpdateListener getUpdateListener() {
        return this.mUpdateListener;
    }

    public void setSingle(boolean z) {
        this.mSingle = z;
    }

    public void setUpdateListener(UpdateListener updateListener) {
        this.mUpdateListener = updateListener;
    }

    public boolean startOtaUpdate(File file, BleDevice bleDevice, Ble ble) {
        String canonicalPath;
        if (ble == null || file == null || !file.exists() || !file.canRead() || (this.mSingle && this.mUpdateList.size() > 0)) {
            return false;
        }
        this.mCounter++;
        BleOtaUpdater bleOtaUpdater = new BleOtaUpdater(this.mHandler);
        bleOtaUpdater.setIndex(this.mCounter);
        this.mUpdateList.put(this.mCounter, bleOtaUpdater);
        try {
            this.mOtaFile = file;
            canonicalPath = file.getCanonicalPath();
            this.mStopUpdate = false;
        } catch (IOException unused) {
        }
        return bleOtaUpdater.otaStart(canonicalPath, bleDevice, ble) == OtaStatus.OtaResult.OTA_RESULT_SUCCESS;
    }

    public void stopAll() {
        if (this.mStopUpdate) {
            return;
        }
        this.mStopUpdate = true;
        if (this.mUpdateList.size() > 0) {
            int size = this.mUpdateList.size();
            for (int i2 = 0; i2 < size; i2++) {
                BleOtaUpdater bleOtaUpdater = this.mUpdateList.get(this.mUpdateList.keyAt(i2));
                if (bleOtaUpdater != null) {
                    bleOtaUpdater.otaStop();
                }
            }
        }
    }
}
