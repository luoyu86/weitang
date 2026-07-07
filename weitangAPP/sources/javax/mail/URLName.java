package javax.mail;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.BitSet;
import java.util.Locale;
import org.apache.commons.codec.language.bm.ResourceConstants;

/* JADX INFO: loaded from: classes2.dex */
public class URLName {
    public static final int caseDiff = 32;
    private static boolean doEncode = true;
    public static BitSet dontNeedEncoding;
    private String file;
    public String fullURL;
    private int hashCode;
    private String host;
    private InetAddress hostAddress;
    private boolean hostAddressKnown;
    private String password;
    private int port;
    private String protocol;
    private String ref;
    private String username;

    static {
        try {
            doEncode = !Boolean.getBoolean("mail.URLName.dontencode");
        } catch (Exception unused) {
        }
        dontNeedEncoding = new BitSet(256);
        for (int i2 = 97; i2 <= 122; i2++) {
            dontNeedEncoding.set(i2);
        }
        for (int i3 = 65; i3 <= 90; i3++) {
            dontNeedEncoding.set(i3);
        }
        for (int i4 = 48; i4 <= 57; i4++) {
            dontNeedEncoding.set(i4);
        }
        dontNeedEncoding.set(32);
        dontNeedEncoding.set(45);
        dontNeedEncoding.set(95);
        dontNeedEncoding.set(46);
        dontNeedEncoding.set(42);
    }

    public URLName(String str, String str2, int i2, String str3, String str4, String str5) {
        int iIndexOf;
        this.hostAddressKnown = false;
        this.port = -1;
        this.hashCode = 0;
        this.protocol = str;
        this.host = str2;
        this.port = i2;
        if (str3 == null || (iIndexOf = str3.indexOf(35)) == -1) {
            this.file = str3;
            this.ref = null;
        } else {
            this.file = str3.substring(0, iIndexOf);
            this.ref = str3.substring(iIndexOf + 1);
        }
        this.username = doEncode ? encode(str4) : str4;
        this.password = doEncode ? encode(str5) : str5;
    }

    private static String _encode(String str) {
        StringBuilder sb = new StringBuilder(str.length());
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(10);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(byteArrayOutputStream);
        for (int i2 = 0; i2 < str.length(); i2++) {
            char cCharAt = str.charAt(i2);
            if (dontNeedEncoding.get(cCharAt)) {
                if (cCharAt == ' ') {
                    cCharAt = '+';
                }
                sb.append(cCharAt);
            } else {
                try {
                    outputStreamWriter.write(cCharAt);
                    outputStreamWriter.flush();
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    for (int i3 = 0; i3 < byteArray.length; i3++) {
                        sb.append('%');
                        char cForDigit = Character.forDigit((byteArray[i3] >> 4) & 15, 16);
                        if (Character.isLetter(cForDigit)) {
                            cForDigit = (char) (cForDigit - ' ');
                        }
                        sb.append(cForDigit);
                        char cForDigit2 = Character.forDigit(byteArray[i3] & 15, 16);
                        if (Character.isLetter(cForDigit2)) {
                            cForDigit2 = (char) (cForDigit2 - ' ');
                        }
                        sb.append(cForDigit2);
                    }
                    byteArrayOutputStream.reset();
                } catch (IOException unused) {
                    byteArrayOutputStream.reset();
                }
            }
        }
        return sb.toString();
    }

    public static String decode(String str) {
        if (str == null) {
            return null;
        }
        if (indexOfAny(str, "+%") == -1) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        while (i2 < str.length()) {
            char cCharAt = str.charAt(i2);
            if (cCharAt == '%') {
                int i3 = i2 + 3;
                try {
                    sb.append((char) Integer.parseInt(str.substring(i2 + 1, i3), 16));
                    i2 += 2;
                } catch (NumberFormatException unused) {
                    throw new IllegalArgumentException("Illegal URL encoded value: " + str.substring(i2, i3));
                }
            } else if (cCharAt != '+') {
                sb.append(cCharAt);
            } else {
                sb.append(' ');
            }
            i2++;
        }
        String string = sb.toString();
        try {
            return new String(string.getBytes("8859_1"));
        } catch (UnsupportedEncodingException unused2) {
            return string;
        }
    }

    public static String encode(String str) {
        if (str == null) {
            return null;
        }
        for (int i2 = 0; i2 < str.length(); i2++) {
            char cCharAt = str.charAt(i2);
            if (cCharAt == ' ' || !dontNeedEncoding.get(cCharAt)) {
                return _encode(str);
            }
        }
        return str;
    }

    private synchronized InetAddress getHostAddress() {
        if (this.hostAddressKnown) {
            return this.hostAddress;
        }
        String str = this.host;
        if (str == null) {
            return null;
        }
        try {
            this.hostAddress = InetAddress.getByName(str);
        } catch (UnknownHostException unused) {
            this.hostAddress = null;
        }
        this.hostAddressKnown = true;
        return this.hostAddress;
    }

    private static int indexOfAny(String str, String str2) {
        return indexOfAny(str, str2, 0);
    }

    public boolean equals(Object obj) {
        String str;
        if (!(obj instanceof URLName)) {
            return false;
        }
        URLName uRLName = (URLName) obj;
        String str2 = this.protocol;
        String str3 = uRLName.protocol;
        if (str2 != str3 && (str2 == null || !str2.equals(str3))) {
            return false;
        }
        InetAddress hostAddress = getHostAddress();
        InetAddress hostAddress2 = uRLName.getHostAddress();
        if (hostAddress == null || hostAddress2 == null) {
            String str4 = this.host;
            if (str4 == null || (str = uRLName.host) == null) {
                if (str4 != uRLName.host) {
                    return false;
                }
            } else if (!str4.equalsIgnoreCase(str)) {
                return false;
            }
        } else if (!hostAddress.equals(hostAddress2)) {
            return false;
        }
        String str5 = this.username;
        String str6 = uRLName.username;
        if (str5 != str6 && (str5 == null || !str5.equals(str6))) {
            return false;
        }
        String str7 = this.file;
        if (str7 == null) {
            str7 = "";
        }
        String str8 = uRLName.file;
        return str7.equals(str8 != null ? str8 : "") && this.port == uRLName.port;
    }

    public String getFile() {
        return this.file;
    }

    public String getHost() {
        return this.host;
    }

    public String getPassword() {
        return doEncode ? decode(this.password) : this.password;
    }

    public int getPort() {
        return this.port;
    }

    public String getProtocol() {
        return this.protocol;
    }

    public String getRef() {
        return this.ref;
    }

    public URL getURL() throws MalformedURLException {
        String str;
        String file = getFile();
        if (file == null) {
            str = "";
        } else {
            str = "/" + file;
        }
        return new URL(getProtocol(), getHost(), getPort(), str);
    }

    public String getUsername() {
        return doEncode ? decode(this.username) : this.username;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 != 0) {
            return i2;
        }
        String str = this.protocol;
        if (str != null) {
            this.hashCode = i2 + str.hashCode();
        }
        InetAddress hostAddress = getHostAddress();
        if (hostAddress != null) {
            this.hashCode += hostAddress.hashCode();
        } else {
            String str2 = this.host;
            if (str2 != null) {
                this.hashCode += str2.toLowerCase(Locale.ENGLISH).hashCode();
            }
        }
        String str3 = this.username;
        if (str3 != null) {
            this.hashCode += str3.hashCode();
        }
        String str4 = this.file;
        if (str4 != null) {
            this.hashCode += str4.hashCode();
        }
        int i3 = this.hashCode + this.port;
        this.hashCode = i3;
        return i3;
    }

    public void parseString(String str) {
        int iIndexOf;
        String strSubstring;
        this.password = null;
        this.username = null;
        this.host = null;
        this.ref = null;
        this.file = null;
        this.protocol = null;
        this.port = -1;
        int length = str.length();
        int iIndexOf2 = str.indexOf(58);
        if (iIndexOf2 != -1) {
            this.protocol = str.substring(0, iIndexOf2);
        }
        int i2 = iIndexOf2 + 1;
        if (str.regionMatches(i2, ResourceConstants.CMT, 0, 2)) {
            int i3 = iIndexOf2 + 3;
            int iIndexOf3 = str.indexOf(47, i3);
            if (iIndexOf3 != -1) {
                strSubstring = str.substring(i3, iIndexOf3);
                int i4 = iIndexOf3 + 1;
                if (i4 < length) {
                    this.file = str.substring(i4);
                } else {
                    this.file = "";
                }
            } else {
                strSubstring = str.substring(i3);
            }
            int iIndexOf4 = strSubstring.indexOf(64);
            if (iIndexOf4 != -1) {
                String strSubstring2 = strSubstring.substring(0, iIndexOf4);
                strSubstring = strSubstring.substring(iIndexOf4 + 1);
                int iIndexOf5 = strSubstring2.indexOf(58);
                if (iIndexOf5 != -1) {
                    this.username = strSubstring2.substring(0, iIndexOf5);
                    this.password = strSubstring2.substring(iIndexOf5 + 1);
                } else {
                    this.username = strSubstring2;
                }
            }
            int iIndexOf6 = (strSubstring.length() <= 0 || strSubstring.charAt(0) != '[') ? strSubstring.indexOf(58) : strSubstring.indexOf(58, strSubstring.indexOf(93));
            if (iIndexOf6 != -1) {
                String strSubstring3 = strSubstring.substring(iIndexOf6 + 1);
                if (strSubstring3.length() > 0) {
                    try {
                        this.port = Integer.parseInt(strSubstring3);
                    } catch (NumberFormatException unused) {
                        this.port = -1;
                    }
                }
                this.host = strSubstring.substring(0, iIndexOf6);
            } else {
                this.host = strSubstring;
            }
        } else if (i2 < length) {
            this.file = str.substring(i2);
        }
        String str2 = this.file;
        if (str2 == null || (iIndexOf = str2.indexOf(35)) == -1) {
            return;
        }
        this.ref = this.file.substring(iIndexOf + 1);
        this.file = this.file.substring(0, iIndexOf);
    }

    public String toString() {
        if (this.fullURL == null) {
            StringBuilder sb = new StringBuilder();
            String str = this.protocol;
            if (str != null) {
                sb.append(str);
                sb.append(":");
            }
            if (this.username != null || this.host != null) {
                sb.append(ResourceConstants.CMT);
                String str2 = this.username;
                if (str2 != null) {
                    sb.append(str2);
                    if (this.password != null) {
                        sb.append(":");
                        sb.append(this.password);
                    }
                    sb.append("@");
                }
                String str3 = this.host;
                if (str3 != null) {
                    sb.append(str3);
                }
                if (this.port != -1) {
                    sb.append(":");
                    sb.append(Integer.toString(this.port));
                }
                if (this.file != null) {
                    sb.append("/");
                }
            }
            String str4 = this.file;
            if (str4 != null) {
                sb.append(str4);
            }
            if (this.ref != null) {
                sb.append("#");
                sb.append(this.ref);
            }
            this.fullURL = sb.toString();
        }
        return this.fullURL;
    }

    private static int indexOfAny(String str, String str2, int i2) {
        try {
            int length = str.length();
            while (i2 < length) {
                if (str2.indexOf(str.charAt(i2)) >= 0) {
                    return i2;
                }
                i2++;
            }
        } catch (StringIndexOutOfBoundsException unused) {
        }
        return -1;
    }

    public URLName(URL url) {
        this(url.toString());
    }

    public URLName(String str) {
        this.hostAddressKnown = false;
        this.port = -1;
        this.hashCode = 0;
        parseString(str);
    }
}
