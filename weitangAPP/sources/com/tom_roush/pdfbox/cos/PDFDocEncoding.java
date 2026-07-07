package com.tom_roush.pdfbox.cos;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.codec.net.RFC1522Codec;

/* JADX INFO: loaded from: classes2.dex */
public final class PDFDocEncoding {
    private static final char REPLACEMENT_CHARACTER = 65533;
    private static final int[] CODE_TO_UNI = new int[256];
    private static final Map<Character, Integer> UNI_TO_CODE = new HashMap(256);

    static {
        for (int i2 = 0; i2 < 256; i2++) {
            if ((i2 <= 23 || i2 >= 32) && ((i2 <= 126 || i2 >= 161) && i2 != 173)) {
                set(i2, (char) i2);
            }
        }
        set(24, (char) 728);
        set(25, (char) 711);
        set(26, (char) 710);
        set(27, (char) 729);
        set(28, (char) 733);
        set(29, (char) 731);
        set(30, (char) 730);
        set(31, (char) 732);
        set(127, REPLACEMENT_CHARACTER);
        set(128, (char) 8226);
        set(TTDownloadField.CALL_DOWNLOAD_MODEL_SET_EXTRA, (char) 8224);
        set(130, (char) 8225);
        set(131, (char) 8230);
        set(TTDownloadField.CALL_DOWNLOAD_MODEL_SET_ID, (char) 8212);
        set(TTDownloadField.CALL_DOWNLOAD_MODEL_SET_IS_AD, (char) 8211);
        set(TTDownloadField.CALL_DOWNLOAD_MODEL_SET_MODEL_TYPE, (char) 402);
        set(TTDownloadField.CALL_DOWNLOAD_MODEL_SET_LOG_EXTRA, (char) 8260);
        set(TTDownloadField.CALL_DOWNLOAD_MODEL_SET_PACKAGE_NAME, (char) 8249);
        set(TTDownloadField.CALL_DOWNLOAD_MODEL_SET_APP_ICON, (char) 8250);
        set(TTDownloadField.CALL_DOWNLOAD_MODEL_SET_DEEP_LINK, (char) 8722);
        set(TTDownloadField.CALL_DOWNLOAD_MODEL_SET_CLICK_TRACK_URL, (char) 8240);
        set(TTDownloadField.CALL_DOWNLOAD_MODEL_SET_DOWNLOAD_URL, (char) 8222);
        set(TTDownloadField.CALL_DOWNLOAD_MODEL_SET_BACKUP_URLS, (char) 8220);
        set(TTDownloadField.CALL_DOWNLOAD_MODEL_SET_NOTIFICATION_JUMP_URL, (char) 8221);
        set(TTDownloadField.CALL_DOWNLOAD_MODEL_SET_MIME_TYPE, (char) 8216);
        set(TTDownloadField.CALL_DOWNLOAD_MODEL_SET_HEADERS, (char) 8217);
        set(TTDownloadField.CALL_DOWNLOAD_MODEL_SET_IS_SHOW_NOTIFICATION, (char) 8218);
        set(TTDownloadField.CALL_DOWNLOAD_MODEL_SET_FILE_PATH, (char) 8482);
        set(TTDownloadField.CALL_DOWNLOAD_MODEL_SET_FILE_NAME, (char) 64257);
        set(TTDownloadField.CALL_DOWNLOAD_MODEL_SET_NEED_INDEPENDENT_PROCESS, (char) 64258);
        set(TTDownloadField.CALL_DOWNLOAD_MODEL_SET_VERSION_CODE, (char) 321);
        set(TTDownloadField.CALL_DOWNLOAD_MODEL_SET_VERSION_NAME, (char) 338);
        set(TTDownloadField.CALL_DOWNLOAD_MODEL_SET_QUICK_APP_MODEL, (char) 352);
        set(TTDownloadField.CALL_DOWNLOAD_MODEL_SET_AUTO_INSTALL_WITHOUT_NOTIFICATION, (char) 376);
        set(TTDownloadField.CALL_DOWNLOAD_MODEL_SET_FUNNEL_TYPE, (char) 381);
        set(154, (char) 305);
        set(155, (char) 322);
        set(156, (char) 339);
        set(157, (char) 353);
        set(158, (char) 382);
        set(159, REPLACEMENT_CHARACTER);
        set(160, (char) 8364);
    }

    private PDFDocEncoding() {
    }

    public static boolean containsChar(char c2) {
        return UNI_TO_CODE.containsKey(Character.valueOf(c2));
    }

    public static byte[] getBytes(String str) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (char c2 : str.toCharArray()) {
            Integer num = UNI_TO_CODE.get(Character.valueOf(c2));
            if (num == null) {
                byteArrayOutputStream.write(0);
            } else {
                byteArrayOutputStream.write(num.intValue());
            }
        }
        return byteArrayOutputStream.toByteArray();
    }

    private static void set(int i2, char c2) {
        CODE_TO_UNI[i2] = c2;
        UNI_TO_CODE.put(Character.valueOf(c2), Integer.valueOf(i2));
    }

    public static String toString(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b2 : bArr) {
            int i2 = b2 & 255;
            int[] iArr = CODE_TO_UNI;
            if (i2 >= iArr.length) {
                sb.append(RFC1522Codec.SEP);
            } else {
                sb.append((char) iArr[i2]);
            }
        }
        return sb.toString();
    }
}
