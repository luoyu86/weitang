package cn.com.heaton.blelibrary.ble.event;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class CommandResultEvent {
    private int NBSignal;
    private int NBStatus;
    private int lockTimeZone;
    private int lockUtcTime;
    private String macAddress;
    private String method;
    private byte[] newKeyPackage;
    private byte[] randomStr;
    private int resultCode;

    public CommandResultEvent() {
    }

    public int getLockTimeZone() {
        return this.lockTimeZone;
    }

    public int getLockUtcTime() {
        return this.lockUtcTime;
    }

    public String getMacAddress() {
        return this.macAddress;
    }

    public String getMethod() {
        return this.method;
    }

    public int getNBSignal() {
        return this.NBSignal;
    }

    public int getNBStatus() {
        return this.NBStatus;
    }

    public byte[] getNewKeyPackage() {
        return this.newKeyPackage;
    }

    public byte[] getRandomStr() {
        return this.randomStr;
    }

    public int getResultCode() {
        return this.resultCode;
    }

    public void setLockTimeZone(int i2) {
        this.lockTimeZone = i2;
    }

    public void setLockUtcTime(int i2) {
        this.lockUtcTime = i2;
    }

    public void setMacAddress(String str) {
        this.macAddress = str;
    }

    public void setMethod(String str) {
        this.method = str;
    }

    public void setNBSignal(int i2) {
        this.NBSignal = i2;
    }

    public void setNBStatus(int i2) {
        this.NBStatus = i2;
    }

    public void setNewKeyPackage(byte[] bArr) {
        this.newKeyPackage = bArr;
    }

    public void setRandomStr(byte[] bArr) {
        this.randomStr = bArr;
    }

    public void setResultCode(int i2) {
        this.resultCode = i2;
    }

    public String toString() {
        return "CommandResultEvent{macAddress='" + this.macAddress + "', method='" + this.method + "', resultCode=" + this.resultCode + ", randomStr=" + Arrays.toString(this.randomStr) + ", NBSignal=" + this.NBSignal + ", newKeyPackage=" + Arrays.toString(this.newKeyPackage) + ", lockUtcTime=" + this.lockUtcTime + ", lockTimeZone=" + this.lockTimeZone + ", NBStatus=" + this.NBStatus + '}';
    }

    public CommandResultEvent(String str, String str2, int i2) {
        this.macAddress = str;
        this.method = str2;
        this.resultCode = i2;
    }
}
