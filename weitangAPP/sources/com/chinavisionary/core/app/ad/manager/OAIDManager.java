package com.chinavisionary.core.app.ad.manager;

import android.content.Context;
import c.e.a.d.l;
import c.e.a.d.q;
import c.e.a.d.w;
import com.bun.miitmdid.core.MdidSdkHelper;
import com.bun.miitmdid.interfaces.IIdentifierListener;
import com.bun.miitmdid.interfaces.IdSupplier;
import com.bun.miitmdid.pojo.IdSupplierImpl;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/* JADX INFO: loaded from: classes.dex */
public class OAIDManager implements IIdentifierListener {
    public static final String ASSET_FILE_NAME_CERT = "com.chinavisionary.microtang.cert.pem";
    public static final int HELPER_VERSION_CODE = 20230919;
    public static final String TAG = "OAIDHelper";
    private boolean isCertInit = false;
    public boolean isSDKLogOn = true;

    public OAIDManager() {
        System.loadLibrary("msaoaidsec");
        if (MdidSdkHelper.SDK_VERSION_CODE != 20230919) {
            d(TAG, "SDK version not match.");
        }
    }

    private String bufferRead(BufferedReader bufferedReader) throws IOException {
        StringBuilder sb = new StringBuilder();
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                return sb.toString();
            }
            sb.append(line);
            sb.append('\n');
        }
    }

    private void d(String str, String str2) {
        q.d(str, str2);
    }

    private void e(String str, String str2) {
        q.e(str, str2);
    }

    private String getOAIDPem(Context context) {
        File file = new File(l.getOAIDFilePath());
        String strBufferRead = "";
        if (!file.exists()) {
            return loadPemFromAssetFile(context, ASSET_FILE_NAME_CERT);
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            strBufferRead = bufferRead(bufferedReader);
            bufferedReader.close();
            return strBufferRead;
        } catch (Exception e2) {
            e2.printStackTrace();
            e(TAG, "loadPemFromAssetFile failed");
            return strBufferRead;
        }
    }

    private void saveIdToLocal(IdSupplier idSupplier) {
        String oaid = idSupplier.getOAID();
        String vaid = idSupplier.getVAID();
        String aaid = idSupplier.getAAID();
        if (oaid != null && vaid != null && aaid != null) {
            w.getInstance().putString("oaid_key", oaid);
            w.getInstance().putString("vaid_key", vaid);
            w.getInstance().putString("aaid_key", aaid);
        }
        DeviceManager.getInstance().setOaid(oaid);
        DeviceManager.getInstance().setVaid(vaid);
        DeviceManager.getInstance().setAaid(aaid);
    }

    private void w(String str, String str2) {
        d(str, str2);
    }

    public void getDeviceIds(Context context, boolean z, boolean z2, boolean z3) {
        if (!this.isCertInit) {
            try {
                this.isCertInit = MdidSdkHelper.InitCert(context, getOAIDPem(context));
            } catch (Error e2) {
                e2.printStackTrace();
            }
            if (!this.isCertInit) {
                w(TAG, "getDeviceIds: cert init failed");
            }
        }
        try {
            MdidSdkHelper.setGlobalTimeout(5000L);
        } catch (Error e3) {
            e3.printStackTrace();
        }
        int iInitSdk = 0;
        try {
            iInitSdk = MdidSdkHelper.InitSdk(context, this.isSDKLogOn, z, z2, z3, this);
        } catch (Error e4) {
            e4.printStackTrace();
        }
        IdSupplierImpl idSupplierImpl = new IdSupplierImpl();
        if (iInitSdk == 1008616) {
            d(TAG, "cert not init or check not pass");
            onSupport(idSupplierImpl);
            return;
        }
        if (iInitSdk == 1008612) {
            d(TAG, "device not supported");
            onSupport(idSupplierImpl);
            return;
        }
        if (iInitSdk == 1008613) {
            w(TAG, "failed to load config file");
            onSupport(idSupplierImpl);
            return;
        }
        if (iInitSdk == 1008611) {
            w(TAG, "manufacturer not supported");
            onSupport(idSupplierImpl);
            return;
        }
        if (iInitSdk == 1008615) {
            w(TAG, "sdk call error");
            onSupport(idSupplierImpl);
        } else {
            if (iInitSdk == 1008614) {
                d(TAG, "result delay (async)");
                return;
            }
            if (iInitSdk == 1008610) {
                d(TAG, "result ok (sync)");
                return;
            }
            w(TAG, "getDeviceIds: unknown code: " + iInitSdk);
        }
    }

    public void init(Context context) {
        String string = w.getInstance().getString("oaid_key", null);
        String string2 = w.getInstance().getString("vaid_key", null);
        String string3 = w.getInstance().getString("aaid_key", null);
        if (string == null || string2 == null || string3 == null) {
            getDeviceIds(context, true, true, true);
            return;
        }
        DeviceManager.getInstance().setOaid(string);
        DeviceManager.getInstance().setVaid(string2);
        DeviceManager.getInstance().setAaid(string3);
    }

    public String loadPemFromAssetFile(Context context, String str) {
        String strBufferRead = "";
        try {
            InputStream inputStreamOpen = context.getAssets().open(str);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStreamOpen));
            strBufferRead = bufferRead(bufferedReader);
            bufferedReader.close();
            inputStreamOpen.close();
            return strBufferRead;
        } catch (Exception e2) {
            e2.printStackTrace();
            e(TAG, "loadPemFromAssetFile failed");
            return strBufferRead;
        }
    }

    @Override // com.bun.miitmdid.interfaces.IIdentifierListener
    public void onSupport(IdSupplier idSupplier) {
        if (idSupplier == null) {
            w(TAG, "onSupport: supplier is null");
            return;
        }
        boolean zIsSupported = idSupplier.isSupported();
        boolean zIsLimited = idSupplier.isLimited();
        String oaid = idSupplier.getOAID();
        String vaid = idSupplier.getVAID();
        String aaid = idSupplier.getAAID();
        saveIdToLocal(idSupplier);
        StringBuilder sb = new StringBuilder();
        sb.append("support: ");
        sb.append(zIsSupported ? "true" : "false");
        sb.append("\nlimit: ");
        sb.append(zIsLimited ? "true" : "false");
        sb.append("\nOAID: ");
        sb.append(oaid);
        sb.append("\nVAID: ");
        sb.append(vaid);
        sb.append("\nAAID: ");
        sb.append(aaid);
        sb.append("\n");
        d(TAG, "onSupport: ids: \n" + sb.toString());
    }
}
