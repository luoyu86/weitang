package c.e.a.d.d0;

/* JADX INFO: loaded from: classes.dex */
public class c {
    public static boolean a(String str) {
        return str != null && str.length() > 0;
    }

    public static String decryptByPublicKey(String str, String str2) throws Exception {
        if (a(str) && a(str2)) {
            String[] strArrSplit = str.split("cvdata_separator");
            if (strArrSplit.length == 2) {
                return a.aesDecrypt(strArrSplit[0], b.rsaDecryptByPublicKey(strArrSplit[1], str2)).trim();
            }
        }
        return null;
    }

    public static String encryptByPublicKey(String str, String str2) throws Exception {
        if (!a(str) || !a(str2)) {
            return null;
        }
        String strSubstring = d.getUuid().substring(2, 18);
        return a.aesEncrypt(str, strSubstring) + "cvdata_separator" + b.rsaEncryptyPublicKey(strSubstring, str2);
    }
}
