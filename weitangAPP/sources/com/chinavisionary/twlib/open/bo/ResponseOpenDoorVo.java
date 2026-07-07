package com.chinavisionary.twlib.open.bo;

import c.e.a.d.d0.c;
import c.e.a.d.j;
import c.e.e.a.s.k;
import com.alibaba.fastjson.JSON;
import com.chinavisionary.core.app.net.base.dto.NewBaseVo;

/* JADX INFO: loaded from: classes2.dex */
public class ResponseOpenDoorVo extends NewBaseVo {
    private static final String DA_GUANG_JIA = "THINMOO_ROUTE";
    private static final String GUODN_ROUTE = "GUODN_ROUTE";
    private static final String MA_TAI = "MARS_TIANYIYUN_HTTP_DOOR";
    private static final String TIANWANG_ROUTE = "TIANWANG_ROUTE";
    private static final String ZISNOO_ROUTE = "ZISNOO_ROUTE";
    private String adapterModel;
    private String bluetoothCookie;
    private String bluetoothMac;
    private String bluetoothPassword;
    private String encryptionData;
    private String key;
    private k responseRoomDoorVo;
    private String resultData;
    private int soc;
    private int socLevel;
    private String socLevelName;
    private String supplierKey;
    private int supplierType;

    private void decodeEncryptionData() {
        String encryptionData = getEncryptionData();
        if (c.e.e.a.x.k.isNotNull(encryptionData)) {
            String publicKey = j.getInstance().getPublicKey();
            if (c.e.e.a.x.k.isNotNull(publicKey)) {
                try {
                    ResponseOpenDoorVo responseOpenDoorVo = (ResponseOpenDoorVo) JSON.parseObject(c.decryptByPublicKey(encryptionData, publicKey), ResponseOpenDoorVo.class);
                    if (responseOpenDoorVo != null) {
                        setKey(responseOpenDoorVo.getKey());
                        setResultData(responseOpenDoorVo.getResultData());
                        setBluetoothCookie(responseOpenDoorVo.getBluetoothCookie());
                        setBluetoothMac(responseOpenDoorVo.getBluetoothMac());
                        setBluetoothPassword(responseOpenDoorVo.getBluetoothPassword());
                        setSoc(responseOpenDoorVo.getSoc());
                        setSocLevel(responseOpenDoorVo.getSocLevel());
                        setSocLevelName(responseOpenDoorVo.getSocLevelName());
                        setSupplierKey(responseOpenDoorVo.getSupplierKey());
                        setSupplierType(responseOpenDoorVo.getSupplierType());
                        setEncryptionData(responseOpenDoorVo.getEncryptionData());
                        setAdapterModel(responseOpenDoorVo.getAdapterModel());
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    private void initResponseRoomDoorVo() {
        String str;
        decodeEncryptionData();
        if (this.responseRoomDoorVo != null || (str = this.resultData) == null) {
            return;
        }
        try {
            this.responseRoomDoorVo = (k) JSON.parseObject(str, k.class);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public String getAdapterModel() {
        return this.adapterModel;
    }

    public String getBluetoothCookie() {
        initResponseRoomDoorVo();
        k kVar = this.responseRoomDoorVo;
        if (kVar != null && this.bluetoothCookie == null) {
            this.bluetoothCookie = kVar.getBluetoothCookie();
        }
        return this.bluetoothCookie;
    }

    public String getBluetoothMac() {
        return this.bluetoothMac;
    }

    public String getBluetoothPassword() {
        initResponseRoomDoorVo();
        k kVar = this.responseRoomDoorVo;
        if (kVar != null && this.bluetoothPassword == null) {
            this.bluetoothPassword = kVar.getBluetoothPassword();
        }
        if (c.e.e.a.x.k.isNotNull(this.resultData) && (getSupplierType() == 1 || getSupplierType() == 15 || getSupplierType() == 16)) {
            this.bluetoothPassword = this.resultData;
        }
        return this.bluetoothPassword;
    }

    public String getEncryptionData() {
        return this.encryptionData;
    }

    public String getKey() {
        return this.key;
    }

    public String getResultData() {
        return this.resultData;
    }

    public int getSoc() {
        return this.soc;
    }

    public int getSocLevel() {
        return this.socLevel;
    }

    public String getSocLevelName() {
        return this.socLevelName;
    }

    public String getSupplierKey() {
        return this.supplierKey;
    }

    public int getSupplierType() {
        if (c.e.e.a.x.k.isNotNull(this.adapterModel)) {
            if ("GUODN_ROUTE".equals(this.adapterModel)) {
                this.supplierType = 2;
            } else if ("TIANWANG_ROUTE".equals(this.adapterModel)) {
                this.supplierType = 0;
            } else if ("THINMOO_ROUTE".equals(this.adapterModel)) {
                this.supplierType = 1;
            } else if ("MARS_TIANYIYUN_HTTP_DOOR".equals(this.adapterModel)) {
                this.supplierType = 15;
            } else if ("ZISNOO_ROUTE".equals(this.adapterModel)) {
                this.supplierType = 16;
            }
        }
        return this.supplierType;
    }

    public void setAdapterModel(String str) {
        this.adapterModel = str;
    }

    public void setBluetoothCookie(String str) {
        this.bluetoothCookie = str;
    }

    public void setBluetoothMac(String str) {
        this.bluetoothMac = str;
    }

    public void setBluetoothPassword(String str) {
        this.bluetoothPassword = str;
    }

    public void setEncryptionData(String str) {
        this.encryptionData = str;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setResultData(String str) {
        this.resultData = str;
    }

    public void setSoc(int i2) {
        this.soc = i2;
    }

    public void setSocLevel(int i2) {
        this.socLevel = i2;
    }

    public void setSocLevelName(String str) {
        this.socLevelName = str;
    }

    public void setSupplierKey(String str) {
        this.supplierKey = str;
    }

    public void setSupplierType(int i2) {
        this.supplierType = i2;
    }
}
