package cn.com.heaton.blelibrary.ble.utils;

import cn.com.heaton.blelibrary.ble.L;

/* JADX INFO: loaded from: classes.dex */
public class CommandUtil {
    public static CommandTlv closeLock(byte[] bArr, byte[] bArr2) {
        CommandTlv commandTlv = new CommandTlv(31, 9);
        commandTlv.addUnit(new TlvByteUnit(100, bArr));
        commandTlv.addUnit(new TlvByteUnit(25, bArr2));
        return commandTlv;
    }

    public static CommandTlv confirmUpdateKeyPackage(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        CommandTlv commandTlv = new CommandTlv(31, 17);
        commandTlv.addUnit(new TlvByteUnit(35, bArr));
        commandTlv.addUnit(new TlvByteUnit(100, bArr2));
        commandTlv.addUnit(new TlvByteUnit(25, bArr3));
        return commandTlv;
    }

    public static byte[] getCommunicationPackage(byte[] bArr, byte[] bArr2) {
        return getCommunicationPackage(bArr, bArr2, false);
    }

    public static CommandTlv getLockStatus(byte[] bArr, byte[] bArr2) {
        CommandTlv commandTlv = new CommandTlv(31, 13);
        commandTlv.addUnit(new TlvByteUnit(100, bArr));
        commandTlv.addUnit(new TlvByteUnit(25, bArr2));
        return commandTlv;
    }

    public static CommandTlv getNBStatus(byte[] bArr, byte[] bArr2) {
        CommandTlv commandTlv = new CommandTlv(31, 21);
        commandTlv.addUnit(new TlvByteUnit(100, bArr));
        commandTlv.addUnit(new TlvByteUnit(25, bArr2));
        return commandTlv;
    }

    public static CommandTlv getNewKeyPackage(byte[] bArr, byte[] bArr2) {
        CommandTlv commandTlv = new CommandTlv(31, 15);
        commandTlv.addUnit(new TlvByteUnit(100, bArr));
        commandTlv.addUnit(new TlvByteUnit(25, bArr2));
        return commandTlv;
    }

    public static CommandTlv getRangeCode(byte[] bArr) {
        CommandTlv commandTlv = new CommandTlv(31, 3);
        commandTlv.addUnit(new TlvByteUnit(25, bArr));
        return commandTlv;
    }

    public static CommandTlv iamMiLockCode(byte[] bArr) {
        CommandTlv commandTlv = new CommandTlv(106, 1);
        commandTlv.addUnit(new TlvByteUnit(29, bArr));
        return commandTlv;
    }

    public static CommandTlv iamMiLockCodeSuper(byte[] bArr) {
        CommandTlv commandTlv = new CommandTlv(106, 3);
        commandTlv.addUnit(new TlvByteUnit(29, bArr));
        return commandTlv;
    }

    public static CommandTlv openLock(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) {
        CommandTlv commandTlv = new CommandTlv(31, 7);
        commandTlv.addUnit(new TlvByteUnit(101, bArr));
        commandTlv.addUnit(new TlvByteUnit(100, bArr2));
        commandTlv.addUnit(new TlvByteUnit(25, bArr3));
        commandTlv.addUnit(new TlvByteUnit(66, bArr4));
        return commandTlv;
    }

    public static CommandTlv sendTouChuanCommand(byte[] bArr, String str, byte[] bArr2, byte[] bArr3) {
        CommandTlv commandTlv = new CommandTlv(31, 11);
        commandTlv.addUnit(new TlvByteUnit(100, bArr));
        commandTlv.addUnit(new TlvByteUnit(70, TLVParseUtils.hexStringtobyteArray(str.substring(8))));
        commandTlv.addUnit(new TlvByteUnit(31, bArr2));
        commandTlv.addUnit(new TlvByteUnit(25, bArr3));
        return commandTlv;
    }

    public static CommandTlv setLockCode(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        CommandTlv commandTlv = new CommandTlv(31, 5);
        commandTlv.addUnit(new TlvByteUnit(34, bArr));
        commandTlv.addUnit(new TlvByteUnit(100, bArr2));
        commandTlv.addUnit(new TlvByteUnit(25, bArr3));
        return commandTlv;
    }

    public static CommandTlv setLockTimeZone(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        CommandTlv commandTlv = new CommandTlv(31, 19);
        commandTlv.addUnit(new TlvByteUnit(102, bArr));
        commandTlv.addUnit(new TlvByteUnit(100, bArr2));
        commandTlv.addUnit(new TlvByteUnit(25, bArr3));
        return commandTlv;
    }

    public static CommandTlv setNBStatus(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        CommandTlv commandTlv = new CommandTlv(31, 21);
        commandTlv.addUnit(new TlvByteUnit(103, bArr3));
        commandTlv.addUnit(new TlvByteUnit(100, bArr));
        commandTlv.addUnit(new TlvByteUnit(25, bArr2));
        return commandTlv;
    }

    public static CommandTlv testSenddata(int i2, String str, int i3) {
        CommandTlv commandTlv = new CommandTlv(31, 2);
        commandTlv.addUnit(new TlvIntUnit(1, i2, 1));
        commandTlv.addUnit(new TlvByteUnit(100, str.getBytes()));
        commandTlv.addUnit(new TlvIntUnit(36, i3, 1));
        return commandTlv;
    }

    public static CommandTlv updateLockCode(byte[] bArr, byte[] bArr2) {
        CommandTlv commandTlv = new CommandTlv(31, 1);
        commandTlv.addUnit(new TlvByteUnit(33, bArr));
        commandTlv.addUnit(new TlvByteUnit(25, bArr2));
        return commandTlv;
    }

    public static byte[] getCommunicationPackage(byte[] bArr, byte[] bArr2, boolean z) {
        bArr2[bArr2.length - 1] = TLVParseUtils.getInstance().xorCode(bArr2);
        TLVParseUtils.getInstance();
        byte[] bArrEncryptByTea = TLVParseUtils.encryptByTea(bArr2, bArr, 16);
        byte[] bArr3 = z ? iamMiLockCodeSuper(bArrEncryptByTea).getByte() : iamMiLockCode(bArrEncryptByTea).getByte();
        bArr3[bArr3.length - 1] = TLVParseUtils.getInstance().xorCode(bArr3);
        L.e(L.TAG, "发送加密数据：" + TLVParseUtils.toHexStr(bArr3));
        return bArr3;
    }
}
