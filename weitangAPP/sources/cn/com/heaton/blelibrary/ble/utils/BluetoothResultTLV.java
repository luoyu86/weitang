package cn.com.heaton.blelibrary.ble.utils;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class BluetoothResultTLV {
    private Integer Cmd;
    private byte[] data;
    private int nbSignal;
    private int nbStatus;
    private byte[] newKeyPackage;
    private int power;
    private byte[] randNum;
    private byte[] randStr;
    private Integer resultCode = -1;
    private int status;
    private Integer subCmd;
    private int timeZone;
    private int utcTime;
    private Integer xuliehao;
    private byte[] zwaveCommand;

    public Integer getCmd() {
        return this.Cmd;
    }

    public byte[] getData() {
        return this.data;
    }

    public int getNbSignal() {
        return this.nbSignal;
    }

    public int getNbStatus() {
        return this.nbStatus;
    }

    public byte[] getNewKeyPackage() {
        return this.newKeyPackage;
    }

    public int getPower() {
        return this.power;
    }

    public byte[] getRandNum() {
        return this.randNum;
    }

    public byte[] getRandStr() {
        return this.randStr;
    }

    public Integer getResultCode() {
        return this.resultCode;
    }

    public int getStatus() {
        return this.status;
    }

    public Integer getSubCmd() {
        return this.subCmd;
    }

    public int getTimeZone() {
        return this.timeZone;
    }

    public int getUtcTime() {
        return this.utcTime;
    }

    public Integer getXuliehao() {
        return this.xuliehao;
    }

    public byte[] getZwaveCommand() {
        return this.zwaveCommand;
    }

    public void setCmd(Integer num) {
        this.Cmd = num;
    }

    public void setData(byte[] bArr) {
        this.data = bArr;
    }

    public void setNbSignal(int i2) {
        this.nbSignal = i2;
    }

    public void setNbStatus(int i2) {
        this.nbStatus = i2;
    }

    public void setNewKeyPackage(byte[] bArr) {
        this.newKeyPackage = bArr;
    }

    public void setPower(int i2) {
        this.power = i2;
    }

    public void setRandNum(byte[] bArr) {
        this.randNum = bArr;
    }

    public void setRandStr(byte[] bArr) {
        this.randStr = bArr;
    }

    public void setResultCode(Integer num) {
        this.resultCode = num;
    }

    public void setStatus(int i2) {
        this.status = i2;
    }

    public void setSubCmd(Integer num) {
        this.subCmd = num;
    }

    public void setTimeZone(int i2) {
        this.timeZone = i2;
    }

    public void setUtcTime(int i2) {
        this.utcTime = i2;
    }

    public void setXuliehao(Integer num) {
        this.xuliehao = num;
    }

    public void setZwaveCommand(byte[] bArr) {
        this.zwaveCommand = bArr;
    }

    public String toString() {
        return "BluetoothResultTLV{Cmd=" + this.Cmd + ", subCmd=" + this.subCmd + ", resultCode=" + this.resultCode + ", randStr=" + Arrays.toString(this.randStr) + ", xuliehao=" + this.xuliehao + ", randNum=" + Arrays.toString(this.randNum) + ", data=" + Arrays.toString(this.data) + ", power=" + this.power + ", status=" + this.status + ", zwaveCommand=" + Arrays.toString(this.zwaveCommand) + ", utcTime=" + this.utcTime + ", timeZone=" + this.timeZone + ", nbSignal=" + this.nbSignal + ", newKeyPackage=" + Arrays.toString(this.newKeyPackage) + '}';
    }
}
