package javax.mail.internet;

import com.intelligoo.sdk.utils.BleLog;
import com.sun.mail.util.ASCIIUtility;
import com.sun.mail.util.BASE64DecoderStream;
import com.sun.mail.util.BASE64EncoderStream;
import com.sun.mail.util.BEncoderStream;
import com.sun.mail.util.LineInputStream;
import com.sun.mail.util.PropUtil;
import com.sun.mail.util.QDecoderStream;
import com.sun.mail.util.QEncoderStream;
import com.sun.mail.util.QPDecoderStream;
import com.sun.mail.util.QPEncoderStream;
import com.sun.mail.util.UUDecoderStream;
import com.sun.mail.util.UUEncoderStream;
import com.tom_roush.pdfbox.contentstream.operator.OperatorName;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;
import javax.activation.DataHandler;
import javax.mail.MessagingException;
import org.apache.commons.codec.net.RFC1522Codec;

/* JADX INFO: loaded from: classes2.dex */
public class MimeUtility {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int ALL = -1;
    public static final int ALL_ASCII = 1;
    public static final int MOSTLY_ASCII = 2;
    public static final int MOSTLY_NONASCII = 3;
    private static String defaultJavaCharset;
    private static String defaultMIMECharset;
    private static final Map<String, Boolean> nonAsciiCharsetMap = new HashMap();
    private static final boolean decodeStrict = PropUtil.getBooleanSystemProperty("mail.mime.decodetext.strict", true);
    private static final boolean encodeEolStrict = PropUtil.getBooleanSystemProperty("mail.mime.encodeeol.strict", false);
    private static final boolean ignoreUnknownEncoding = PropUtil.getBooleanSystemProperty("mail.mime.ignoreunknownencoding", false);
    private static final boolean allowUtf8 = PropUtil.getBooleanSystemProperty("mail.mime.allowutf8", false);
    private static final boolean foldEncodedWords = PropUtil.getBooleanSystemProperty("mail.mime.foldencodedwords", false);
    private static final boolean foldText = PropUtil.getBooleanSystemProperty("mail.mime.foldtext", true);
    private static Map<String, String> java2mime = new HashMap(40);
    private static Map<String, String> mime2java = new HashMap(14);

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v15, types: [com.sun.mail.util.LineInputStream, java.io.InputStream] */
    static {
        ?? lineInputStream;
        Throwable th;
        try {
            InputStream resourceAsStream = MimeUtility.class.getResourceAsStream("/META-INF/javamail.charset.map");
            if (resourceAsStream != null) {
                try {
                    lineInputStream = new LineInputStream(resourceAsStream);
                } catch (Throwable th2) {
                    lineInputStream = resourceAsStream;
                    th = th2;
                }
                try {
                    loadMappings(lineInputStream, java2mime);
                    loadMappings(lineInputStream, mime2java);
                    lineInputStream.close();
                } catch (Throwable th3) {
                    th = th3;
                    try {
                        lineInputStream.close();
                    } catch (Exception unused) {
                    }
                    throw th;
                }
            }
        } catch (Exception unused2) {
        }
        if (java2mime.isEmpty()) {
            java2mime.put("8859_1", "ISO-8859-1");
            java2mime.put("iso8859_1", "ISO-8859-1");
            java2mime.put("iso8859-1", "ISO-8859-1");
            java2mime.put("8859_2", "ISO-8859-2");
            java2mime.put("iso8859_2", "ISO-8859-2");
            java2mime.put("iso8859-2", "ISO-8859-2");
            java2mime.put("8859_3", "ISO-8859-3");
            java2mime.put("iso8859_3", "ISO-8859-3");
            java2mime.put("iso8859-3", "ISO-8859-3");
            java2mime.put("8859_4", "ISO-8859-4");
            java2mime.put("iso8859_4", "ISO-8859-4");
            java2mime.put("iso8859-4", "ISO-8859-4");
            java2mime.put("8859_5", "ISO-8859-5");
            java2mime.put("iso8859_5", "ISO-8859-5");
            java2mime.put("iso8859-5", "ISO-8859-5");
            java2mime.put("8859_6", "ISO-8859-6");
            java2mime.put("iso8859_6", "ISO-8859-6");
            java2mime.put("iso8859-6", "ISO-8859-6");
            java2mime.put("8859_7", "ISO-8859-7");
            java2mime.put("iso8859_7", "ISO-8859-7");
            java2mime.put("iso8859-7", "ISO-8859-7");
            java2mime.put("8859_8", "ISO-8859-8");
            java2mime.put("iso8859_8", "ISO-8859-8");
            java2mime.put("iso8859-8", "ISO-8859-8");
            java2mime.put("8859_9", "ISO-8859-9");
            java2mime.put("iso8859_9", "ISO-8859-9");
            java2mime.put("iso8859-9", "ISO-8859-9");
            java2mime.put("sjis", "Shift_JIS");
            java2mime.put("jis", "ISO-2022-JP");
            java2mime.put("iso2022jp", "ISO-2022-JP");
            java2mime.put("euc_jp", "euc-jp");
            java2mime.put("koi8_r", "koi8-r");
            java2mime.put("euc_cn", "euc-cn");
            java2mime.put("euc_tw", "euc-tw");
            java2mime.put("euc_kr", "euc-kr");
        }
        if (mime2java.isEmpty()) {
            mime2java.put("iso-2022-cn", "ISO2022CN");
            mime2java.put("iso-2022-kr", "ISO2022KR");
            mime2java.put("utf-8", "UTF8");
            mime2java.put("utf8", "UTF8");
            mime2java.put("ja_jp.iso2022-7", "ISO2022JP");
            mime2java.put("ja_jp.eucjp", "EUCJIS");
            mime2java.put("euc-kr", "KSC5601");
            mime2java.put("euckr", "KSC5601");
            mime2java.put("us-ascii", "ISO-8859-1");
            mime2java.put("x-us-ascii", "ISO-8859-1");
            mime2java.put("gb2312", "GB18030");
            mime2java.put("cp936", "GB18030");
            mime2java.put("ms936", "GB18030");
            mime2java.put("gbk", "GB18030");
        }
    }

    private MimeUtility() {
    }

    public static int checkAscii(String str) {
        int length = str.length();
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            if (nonascii(str.charAt(i4))) {
                i2++;
            } else {
                i3++;
            }
        }
        if (i2 == 0) {
            return 1;
        }
        return i3 > i2 ? 2 : 3;
    }

    public static InputStream decode(InputStream inputStream, String str) throws MessagingException {
        if (str.equalsIgnoreCase("base64")) {
            return new BASE64DecoderStream(inputStream);
        }
        if (str.equalsIgnoreCase("quoted-printable")) {
            return new QPDecoderStream(inputStream);
        }
        if (str.equalsIgnoreCase("uuencode") || str.equalsIgnoreCase("x-uuencode") || str.equalsIgnoreCase("x-uue")) {
            return new UUDecoderStream(inputStream);
        }
        if (str.equalsIgnoreCase("binary") || str.equalsIgnoreCase("7bit") || str.equalsIgnoreCase("8bit") || ignoreUnknownEncoding) {
            return inputStream;
        }
        throw new MessagingException("Unknown encoding: " + str);
    }

    private static String decodeInnerWords(String str) throws UnsupportedEncodingException {
        int iIndexOf;
        int iIndexOf2;
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        while (true) {
            int iIndexOf3 = str.indexOf(RFC1522Codec.PREFIX, i2);
            if (iIndexOf3 < 0) {
                break;
            }
            sb.append(str.substring(i2, iIndexOf3));
            int iIndexOf4 = str.indexOf(63, iIndexOf3 + 2);
            if (iIndexOf4 < 0 || (iIndexOf = str.indexOf(63, iIndexOf4 + 1)) < 0 || (iIndexOf2 = str.indexOf(RFC1522Codec.POSTFIX, iIndexOf + 1)) < 0) {
                break;
            }
            i2 = iIndexOf2 + 2;
            String strSubstring = str.substring(iIndexOf3, i2);
            try {
                strSubstring = decodeWord(strSubstring);
            } catch (ParseException unused) {
            }
            sb.append(strSubstring);
        }
        if (i2 == 0) {
            return str;
        }
        if (i2 < str.length()) {
            sb.append(str.substring(i2));
        }
        return sb.toString();
    }

    public static String decodeText(String str) throws UnsupportedEncodingException {
        if (str.indexOf(RFC1522Codec.PREFIX) == -1) {
            return str;
        }
        StringTokenizer stringTokenizer = new StringTokenizer(str, " \t\n\r", true);
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        boolean zEndsWith = false;
        while (stringTokenizer.hasMoreTokens()) {
            String strNextToken = stringTokenizer.nextToken();
            char cCharAt = strNextToken.charAt(0);
            if (cCharAt == ' ' || cCharAt == '\t' || cCharAt == '\r' || cCharAt == '\n') {
                sb2.append(cCharAt);
            } else {
                try {
                    String strDecodeWord = decodeWord(strNextToken);
                    if (!zEndsWith && sb2.length() > 0) {
                        sb.append((CharSequence) sb2);
                    }
                    strNextToken = strDecodeWord;
                    zEndsWith = true;
                } catch (ParseException unused) {
                    if (!decodeStrict) {
                        String strDecodeInnerWords = decodeInnerWords(strNextToken);
                        if (strDecodeInnerWords != strNextToken) {
                            if ((!zEndsWith || !strNextToken.startsWith(RFC1522Codec.PREFIX)) && sb2.length() > 0) {
                                sb.append((CharSequence) sb2);
                            }
                            zEndsWith = strNextToken.endsWith(RFC1522Codec.POSTFIX);
                            strNextToken = strDecodeInnerWords;
                        } else if (sb2.length() > 0) {
                            sb.append((CharSequence) sb2);
                        }
                    } else if (sb2.length() > 0) {
                        sb.append((CharSequence) sb2);
                    }
                    zEndsWith = false;
                }
                sb.append(strNextToken);
                sb2.setLength(0);
            }
        }
        sb.append((CharSequence) sb2);
        return sb.toString();
    }

    public static String decodeWord(String str) throws ParseException, UnsupportedEncodingException {
        InputStream qDecoderStream;
        if (!str.startsWith(RFC1522Codec.PREFIX)) {
            throw new ParseException("encoded word does not start with \"=?\": " + str);
        }
        int iIndexOf = str.indexOf(63, 2);
        if (iIndexOf == -1) {
            throw new ParseException("encoded word does not include charset: " + str);
        }
        String strSubstring = str.substring(2, iIndexOf);
        int iIndexOf2 = strSubstring.indexOf(42);
        if (iIndexOf2 >= 0) {
            strSubstring = strSubstring.substring(0, iIndexOf2);
        }
        String strJavaCharset = javaCharset(strSubstring);
        int i2 = iIndexOf + 1;
        int iIndexOf3 = str.indexOf(63, i2);
        if (iIndexOf3 == -1) {
            throw new ParseException("encoded word does not include encoding: " + str);
        }
        String strSubstring2 = str.substring(i2, iIndexOf3);
        int i3 = iIndexOf3 + 1;
        int iIndexOf4 = str.indexOf(RFC1522Codec.POSTFIX, i3);
        if (iIndexOf4 == -1) {
            throw new ParseException("encoded word does not end with \"?=\": " + str);
        }
        String strSubstring3 = str.substring(i3, iIndexOf4);
        try {
            String str2 = "";
            if (strSubstring3.length() > 0) {
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(ASCIIUtility.getBytes(strSubstring3));
                if (strSubstring2.equalsIgnoreCase("B")) {
                    qDecoderStream = new BASE64DecoderStream(byteArrayInputStream);
                } else {
                    if (!strSubstring2.equalsIgnoreCase(OperatorName.RESTORE)) {
                        throw new UnsupportedEncodingException("unknown encoding: " + strSubstring2);
                    }
                    qDecoderStream = new QDecoderStream(byteArrayInputStream);
                }
                int iAvailable = byteArrayInputStream.available();
                byte[] bArr = new byte[iAvailable];
                int i4 = qDecoderStream.read(bArr, 0, iAvailable);
                if (i4 > 0) {
                    str2 = new String(bArr, 0, i4, strJavaCharset);
                }
            }
            int i5 = iIndexOf4 + 2;
            if (i5 >= str.length()) {
                return str2;
            }
            String strSubstring4 = str.substring(i5);
            if (!decodeStrict) {
                strSubstring4 = decodeInnerWords(strSubstring4);
            }
            return str2 + strSubstring4;
        } catch (UnsupportedEncodingException e2) {
            throw e2;
        } catch (IOException e3) {
            throw new ParseException(e3.toString());
        } catch (IllegalArgumentException unused) {
            throw new UnsupportedEncodingException(strJavaCharset);
        }
    }

    private static void doEncode(String str, boolean z, String str2, int i2, String str3, boolean z2, boolean z3, StringBuilder sb) throws UnsupportedEncodingException {
        int length;
        byte[] bytes = str.getBytes(str2);
        if ((z ? BEncoderStream.encodedLength(bytes) : QEncoderStream.encodedLength(bytes, z3)) > i2 && (length = str.length()) > 1) {
            int i3 = length / 2;
            if (Character.isHighSurrogate(str.charAt(i3 - 1))) {
                i3--;
            }
            int i4 = i3;
            if (i4 > 0) {
                doEncode(str.substring(0, i4), z, str2, i2, str3, z2, z3, sb);
            }
            doEncode(str.substring(i4, length), z, str2, i2, str3, false, z3, sb);
            return;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        OutputStream bEncoderStream = z ? new BEncoderStream(byteArrayOutputStream) : new QEncoderStream(byteArrayOutputStream, z3);
        try {
            bEncoderStream.write(bytes);
            bEncoderStream.close();
        } catch (IOException unused) {
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        if (!z2) {
            if (foldEncodedWords) {
                sb.append("\r\n ");
            } else {
                sb.append(" ");
            }
        }
        sb.append(str3);
        for (byte b2 : byteArray) {
            sb.append((char) b2);
        }
        sb.append(RFC1522Codec.POSTFIX);
    }

    public static OutputStream encode(OutputStream outputStream, String str) throws MessagingException {
        if (str == null) {
            return outputStream;
        }
        if (str.equalsIgnoreCase("base64")) {
            return new BASE64EncoderStream(outputStream);
        }
        if (str.equalsIgnoreCase("quoted-printable")) {
            return new QPEncoderStream(outputStream);
        }
        if (str.equalsIgnoreCase("uuencode") || str.equalsIgnoreCase("x-uuencode") || str.equalsIgnoreCase("x-uue")) {
            return new UUEncoderStream(outputStream);
        }
        if (str.equalsIgnoreCase("binary") || str.equalsIgnoreCase("7bit") || str.equalsIgnoreCase("8bit")) {
            return outputStream;
        }
        throw new MessagingException("Unknown encoding: " + str);
    }

    public static String encodeText(String str) throws UnsupportedEncodingException {
        return encodeText(str, null, null);
    }

    public static String encodeWord(String str) throws UnsupportedEncodingException {
        return encodeWord(str, null, null);
    }

    public static String fold(int i2, String str) {
        char cCharAt;
        if (!foldText) {
            return str;
        }
        int length = str.length() - 1;
        while (length >= 0 && ((cCharAt = str.charAt(length)) == ' ' || cCharAt == '\t' || cCharAt == '\r' || cCharAt == '\n')) {
            length--;
        }
        if (length != str.length() - 1) {
            str = str.substring(0, length + 1);
        }
        if (str.length() + i2 <= 76) {
            return makesafe(str);
        }
        StringBuilder sb = new StringBuilder(str.length() + 4);
        char cCharAt2 = 0;
        while (true) {
            if (str.length() + i2 <= 76) {
                break;
            }
            int i3 = 0;
            int i4 = -1;
            while (i3 < str.length() && (i4 == -1 || i2 + i3 <= 76)) {
                char cCharAt3 = str.charAt(i3);
                if ((cCharAt3 == ' ' || cCharAt3 == '\t') && cCharAt2 != ' ' && cCharAt2 != '\t') {
                    i4 = i3;
                }
                i3++;
                cCharAt2 = cCharAt3;
            }
            if (i4 == -1) {
                sb.append(str);
                str = "";
                break;
            }
            sb.append(str.substring(0, i4));
            sb.append(BleLog.LINE_BREAK);
            cCharAt2 = str.charAt(i4);
            sb.append(cCharAt2);
            str = str.substring(i4 + 1);
            i2 = 1;
        }
        sb.append(str);
        return makesafe(sb);
    }

    public static String getDefaultJavaCharset() {
        if (defaultJavaCharset == null) {
            String property = null;
            try {
                property = System.getProperty("mail.mime.charset");
            } catch (SecurityException unused) {
            }
            if (property != null && property.length() > 0) {
                String strJavaCharset = javaCharset(property);
                defaultJavaCharset = strJavaCharset;
                return strJavaCharset;
            }
            try {
                defaultJavaCharset = System.getProperty("file.encoding", "8859_1");
            } catch (SecurityException unused2) {
                String encoding = new InputStreamReader(new InputStream() { // from class: javax.mail.internet.MimeUtility.1NullInputStream
                    @Override // java.io.InputStream
                    public int read() {
                        return 0;
                    }
                }).getEncoding();
                defaultJavaCharset = encoding;
                if (encoding == null) {
                    defaultJavaCharset = "8859_1";
                }
            }
        }
        return defaultJavaCharset;
    }

    public static String getDefaultMIMECharset() {
        if (defaultMIMECharset == null) {
            try {
                defaultMIMECharset = System.getProperty("mail.mime.charset");
            } catch (SecurityException unused) {
            }
        }
        if (defaultMIMECharset == null) {
            defaultMIMECharset = mimeCharset(getDefaultJavaCharset());
        }
        return defaultMIMECharset;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x003e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String getEncoding(javax.activation.DataSource r6) {
        /*
            java.lang.String r0 = "base64"
            boolean r1 = r6 instanceof javax.mail.EncodingAware
            if (r1 == 0) goto L10
            r1 = r6
            javax.mail.EncodingAware r1 = (javax.mail.EncodingAware) r1
            java.lang.String r1 = r1.getEncoding()
            if (r1 == 0) goto L10
            return r1
        L10:
            r1 = 0
            javax.mail.internet.ContentType r2 = new javax.mail.internet.ContentType     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L50
            java.lang.String r3 = r6.getContentType()     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L50
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L50
            java.io.InputStream r1 = r6.getInputStream()     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L50
            java.lang.String r6 = "text/*"
            boolean r6 = r2.match(r6)     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L50
            r3 = -1
            r4 = 1
            if (r6 != 0) goto L2a
            r5 = 1
            goto L2b
        L2a:
            r5 = 0
        L2b:
            int r3 = checkAscii(r1, r3, r5)     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L50
            if (r3 == r4) goto L41
            r4 = 2
            if (r3 == r4) goto L35
            goto L43
        L35:
            if (r6 == 0) goto L3e
            boolean r6 = nonAsciiCharset(r2)     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L50
            if (r6 == 0) goto L3e
            goto L43
        L3e:
            java.lang.String r0 = "quoted-printable"
            goto L43
        L41:
            java.lang.String r0 = "7bit"
        L43:
            if (r1 == 0) goto L48
            r1.close()     // Catch: java.io.IOException -> L48
        L48:
            return r0
        L49:
            r6 = move-exception
            if (r1 == 0) goto L4f
            r1.close()     // Catch: java.io.IOException -> L4f
        L4f:
            throw r6
        L50:
            if (r1 == 0) goto L55
            r1.close()     // Catch: java.io.IOException -> L55
        L55:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.mail.internet.MimeUtility.getEncoding(javax.activation.DataSource):java.lang.String");
    }

    private static int indexOfAny(String str, String str2) {
        return indexOfAny(str, str2, 0);
    }

    public static String javaCharset(String str) {
        Map<String, String> map = mime2java;
        if (map == null || str == null) {
            return str;
        }
        String str2 = map.get(str.toLowerCase(Locale.ENGLISH));
        if (str2 != null) {
            try {
                Charset.forName(str2);
            } catch (Exception unused) {
                str2 = null;
            }
        }
        return str2 == null ? str : str2;
    }

    private static void loadMappings(LineInputStream lineInputStream, Map<String, String> map) {
        while (true) {
            try {
                String line = lineInputStream.readLine();
                if (line == null) {
                    return;
                }
                if (line.startsWith("--") && line.endsWith("--")) {
                    return;
                }
                if (line.trim().length() != 0 && !line.startsWith("#")) {
                    StringTokenizer stringTokenizer = new StringTokenizer(line, " \t");
                    try {
                        String strNextToken = stringTokenizer.nextToken();
                        map.put(strNextToken.toLowerCase(Locale.ENGLISH), stringTokenizer.nextToken());
                    } catch (NoSuchElementException unused) {
                    }
                }
            } catch (IOException unused2) {
                return;
            }
        }
    }

    private static String makesafe(CharSequence charSequence) {
        char cCharAt;
        int i2 = 0;
        while (i2 < charSequence.length() && (cCharAt = charSequence.charAt(i2)) != '\r' && cCharAt != '\n') {
            i2++;
        }
        if (i2 == charSequence.length()) {
            return charSequence.toString();
        }
        StringBuilder sb = new StringBuilder(charSequence.length() + 1);
        BufferedReader bufferedReader = new BufferedReader(new StringReader(charSequence.toString()));
        while (true) {
            try {
                String line = bufferedReader.readLine();
                if (line == null) {
                    return sb.toString();
                }
                if (line.trim().length() != 0) {
                    if (sb.length() > 0) {
                        sb.append(BleLog.LINE_BREAK);
                        char cCharAt2 = line.charAt(0);
                        if (cCharAt2 != ' ' && cCharAt2 != '\t') {
                            sb.append(' ');
                        }
                    }
                    sb.append(line);
                }
            } catch (IOException unused) {
                return charSequence.toString();
            }
        }
    }

    public static String mimeCharset(String str) {
        String str2;
        Map<String, String> map = java2mime;
        return (map == null || str == null || (str2 = map.get(str.toLowerCase(Locale.ENGLISH))) == null) ? str : str2;
    }

    private static boolean nonAsciiCharset(ContentType contentType) {
        Boolean bool;
        Boolean boolValueOf;
        String parameter = contentType.getParameter("charset");
        if (parameter == null) {
            return false;
        }
        String lowerCase = parameter.toLowerCase(Locale.ENGLISH);
        Map<String, Boolean> map = nonAsciiCharsetMap;
        synchronized (map) {
            bool = map.get(lowerCase);
        }
        if (bool == null) {
            try {
                byte[] bytes = BleLog.LINE_BREAK.getBytes(lowerCase);
                boolValueOf = Boolean.valueOf((bytes.length == 2 && bytes[0] == 13 && bytes[1] == 10) ? false : true);
            } catch (UnsupportedEncodingException unused) {
                boolValueOf = Boolean.FALSE;
            } catch (RuntimeException unused2) {
                boolValueOf = Boolean.TRUE;
            }
            bool = boolValueOf;
            Map<String, Boolean> map2 = nonAsciiCharsetMap;
            synchronized (map2) {
                map2.put(lowerCase, bool);
            }
        }
        return bool.booleanValue();
    }

    public static final boolean nonascii(int i2) {
        return i2 >= 127 || !(i2 >= 32 || i2 == 13 || i2 == 10 || i2 == 9);
    }

    public static String quote(String str, String str2) {
        char c2 = 0;
        int length = str == null ? 0 : str.length();
        if (length == 0) {
            return "\"\"";
        }
        int i2 = 0;
        boolean z = false;
        while (i2 < length) {
            char cCharAt = str.charAt(i2);
            if (cCharAt == '\"' || cCharAt == '\\' || cCharAt == '\r' || cCharAt == '\n') {
                StringBuilder sb = new StringBuilder(length + 3);
                sb.append('\"');
                sb.append(str.substring(0, i2));
                while (i2 < length) {
                    char cCharAt2 = str.charAt(i2);
                    if ((cCharAt2 == '\"' || cCharAt2 == '\\' || cCharAt2 == '\r' || cCharAt2 == '\n') && (cCharAt2 != '\n' || c2 != '\r')) {
                        sb.append('\\');
                    }
                    sb.append(cCharAt2);
                    i2++;
                    c2 = cCharAt2;
                }
                sb.append('\"');
                return sb.toString();
            }
            if (cCharAt < ' ' || ((cCharAt >= 127 && !allowUtf8) || str2.indexOf(cCharAt) >= 0)) {
                z = true;
            }
            i2++;
        }
        if (!z) {
            return str;
        }
        StringBuilder sb2 = new StringBuilder(length + 2);
        sb2.append('\"');
        sb2.append(str);
        sb2.append('\"');
        return sb2.toString();
    }

    public static String unfold(String str) {
        char cCharAt;
        if (!foldText) {
            return str;
        }
        StringBuilder sb = null;
        while (true) {
            int iIndexOfAny = indexOfAny(str, BleLog.LINE_BREAK);
            if (iIndexOfAny < 0) {
                break;
            }
            int length = str.length();
            int i2 = iIndexOfAny + 1;
            if (i2 < length && str.charAt(i2 - 1) == '\r' && str.charAt(i2) == '\n') {
                i2++;
            }
            if (iIndexOfAny > 0) {
                int i3 = iIndexOfAny - 1;
                if (str.charAt(i3) == '\\') {
                    if (sb == null) {
                        sb = new StringBuilder(str.length());
                    }
                    sb.append(str.substring(0, i3));
                    sb.append(str.substring(iIndexOfAny, i2));
                    str = str.substring(i2);
                }
            }
            if (i2 >= length || (cCharAt = str.charAt(i2)) == ' ' || cCharAt == '\t') {
                if (sb == null) {
                    sb = new StringBuilder(str.length());
                }
                sb.append(str.substring(0, iIndexOfAny));
                str = str.substring(i2);
            } else {
                if (sb == null) {
                    sb = new StringBuilder(str.length());
                }
                sb.append(str.substring(0, i2));
                str = str.substring(i2);
            }
        }
        if (sb == null) {
            return str;
        }
        sb.append(str);
        return sb.toString();
    }

    public static String encodeText(String str, String str2, String str3) throws UnsupportedEncodingException {
        return encodeWord(str, str2, str3, false);
    }

    public static String encodeWord(String str, String str2, String str3) throws UnsupportedEncodingException {
        return encodeWord(str, str2, str3, true);
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

    public static int checkAscii(byte[] bArr) {
        int i2 = 0;
        int i3 = 0;
        for (byte b2 : bArr) {
            if (nonascii(b2 & 255)) {
                i2++;
            } else {
                i3++;
            }
        }
        if (i2 == 0) {
            return 1;
        }
        return i3 > i2 ? 2 : 3;
    }

    private static String encodeWord(String str, String str2, String str3, boolean z) throws UnsupportedEncodingException {
        String strJavaCharset;
        boolean z2;
        int iCheckAscii = checkAscii(str);
        if (iCheckAscii == 1) {
            return str;
        }
        if (str2 == null) {
            strJavaCharset = getDefaultJavaCharset();
            str2 = getDefaultMIMECharset();
        } else {
            strJavaCharset = javaCharset(str2);
        }
        if (str3 == null) {
            str3 = iCheckAscii != 3 ? OperatorName.RESTORE : "B";
        }
        if (str3.equalsIgnoreCase("B")) {
            z2 = true;
        } else {
            if (!str3.equalsIgnoreCase(OperatorName.RESTORE)) {
                throw new UnsupportedEncodingException("Unknown transfer encoding: " + str3);
            }
            z2 = false;
        }
        StringBuilder sb = new StringBuilder();
        doEncode(str, z2, strJavaCharset, 68 - str2.length(), RFC1522Codec.PREFIX + str2 + "?" + str3 + "?", true, z, sb);
        return sb.toString();
    }

    public static int checkAscii(InputStream inputStream, int i2, boolean z) {
        int i3 = i2;
        int i4 = 0;
        boolean z2 = encodeEolStrict && z;
        byte[] bArr = null;
        int i5 = -1;
        if (i3 != 0) {
            iMin = i3 != -1 ? Math.min(i3, 4096) : 4096;
            bArr = new byte[iMin];
        }
        int i6 = 0;
        int i7 = 0;
        boolean z3 = false;
        boolean z4 = false;
        int i8 = 0;
        while (i3 != 0) {
            try {
                int i9 = inputStream.read(bArr, i4, iMin);
                if (i9 == i5) {
                    break;
                }
                int i10 = 0;
                while (i10 < i9) {
                    int i11 = bArr[i10] & 255;
                    if (z2 && ((i4 == 13 && i11 != 10) || (i4 != 13 && i11 == 10))) {
                        z3 = true;
                    }
                    if (i11 == 13 || i11 == 10) {
                        i8 = 0;
                    } else {
                        i8++;
                        if (i8 > 998) {
                            z4 = true;
                        }
                    }
                    if (!nonascii(i11)) {
                        i6++;
                    } else {
                        if (z) {
                            return 3;
                        }
                        i7++;
                    }
                    i10++;
                    i4 = i11;
                }
                if (i3 != -1) {
                    i3 -= i9;
                }
                i4 = 0;
                i5 = -1;
            } catch (IOException unused) {
            }
        }
        if (i3 == 0 && z) {
            return 3;
        }
        if (i7 != 0) {
            return i6 > i7 ? 2 : 3;
        }
        if (z3) {
            return 3;
        }
        return z4 ? 2 : 1;
    }

    public static String getEncoding(DataHandler dataHandler) {
        if (dataHandler.getName() != null) {
            return getEncoding(dataHandler.getDataSource());
        }
        try {
            if (new ContentType(dataHandler.getContentType()).match("text/*")) {
                AsciiOutputStream asciiOutputStream = new AsciiOutputStream(false, false);
                try {
                    dataHandler.writeTo(asciiOutputStream);
                } catch (IOException unused) {
                }
                int ascii = asciiOutputStream.getAscii();
                if (ascii != 1) {
                    return ascii != 2 ? "base64" : "quoted-printable";
                }
            } else {
                AsciiOutputStream asciiOutputStream2 = new AsciiOutputStream(true, encodeEolStrict);
                try {
                    dataHandler.writeTo(asciiOutputStream2);
                } catch (IOException unused2) {
                }
                if (asciiOutputStream2.getAscii() != 1) {
                    return "base64";
                }
            }
            return "7bit";
        } catch (Exception unused3) {
            return "base64";
        }
    }

    public static OutputStream encode(OutputStream outputStream, String str, String str2) throws MessagingException {
        if (str == null) {
            return outputStream;
        }
        if (str.equalsIgnoreCase("base64")) {
            return new BASE64EncoderStream(outputStream);
        }
        if (str.equalsIgnoreCase("quoted-printable")) {
            return new QPEncoderStream(outputStream);
        }
        if (!str.equalsIgnoreCase("uuencode") && !str.equalsIgnoreCase("x-uuencode") && !str.equalsIgnoreCase("x-uue")) {
            if (str.equalsIgnoreCase("binary") || str.equalsIgnoreCase("7bit") || str.equalsIgnoreCase("8bit")) {
                return outputStream;
            }
            throw new MessagingException("Unknown encoding: " + str);
        }
        return new UUEncoderStream(outputStream, str2);
    }
}
