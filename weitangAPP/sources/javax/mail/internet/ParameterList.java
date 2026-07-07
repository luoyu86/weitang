package javax.mail.internet;

import com.alipay.sdk.m.n.a;
import com.sun.mail.util.PropUtil;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class ParameterList {
    private String lastName;
    private Map<String, Object> list;
    private Set<String> multisegmentNames;
    private Map<String, Object> slist;
    private static final boolean encodeParameters = PropUtil.getBooleanSystemProperty("mail.mime.encodeparameters", true);
    private static final boolean decodeParameters = PropUtil.getBooleanSystemProperty("mail.mime.decodeparameters", true);
    private static final boolean decodeParametersStrict = PropUtil.getBooleanSystemProperty("mail.mime.decodeparameters.strict", false);
    private static final boolean applehack = PropUtil.getBooleanSystemProperty("mail.mime.applefilenames", false);
    private static final boolean windowshack = PropUtil.getBooleanSystemProperty("mail.mime.windowsfilenames", false);
    private static final boolean parametersStrict = PropUtil.getBooleanSystemProperty("mail.mime.parameters.strict", true);
    private static final boolean splitLongParameters = PropUtil.getBooleanSystemProperty("mail.mime.splitlongparameters", true);
    private static final char[] hex = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static class LiteralValue {
        public String value;

        private LiteralValue() {
        }
    }

    public static class MultiValue extends ArrayList<Object> {
        private static final long serialVersionUID = 699561094618751023L;
        public String value;

        private MultiValue() {
        }
    }

    public static class ParamEnum implements Enumeration<String> {
        private Iterator<String> it;

        public ParamEnum(Iterator<String> it) {
            this.it = it;
        }

        @Override // java.util.Enumeration
        public boolean hasMoreElements() {
            return this.it.hasNext();
        }

        @Override // java.util.Enumeration
        public String nextElement() {
            return this.it.next();
        }
    }

    public static class ToStringBuffer {
        private StringBuilder sb = new StringBuilder();
        private int used;

        public ToStringBuffer(int i2) {
            this.used = i2;
        }

        public void addNV(String str, String str2) {
            this.sb.append("; ");
            this.used += 2;
            if (this.used + str.length() + str2.length() + 1 > 76) {
                this.sb.append("\r\n\t");
                this.used = 8;
            }
            StringBuilder sb = this.sb;
            sb.append(str);
            sb.append(a.f5521h);
            int length = this.used + str.length() + 1;
            this.used = length;
            if (length + str2.length() <= 76) {
                this.sb.append(str2);
                this.used += str2.length();
                return;
            }
            String strFold = MimeUtility.fold(this.used, str2);
            this.sb.append(strFold);
            if (strFold.lastIndexOf(10) >= 0) {
                this.used += (strFold.length() - r5) - 1;
            } else {
                this.used += strFold.length();
            }
        }

        public String toString() {
            return this.sb.toString();
        }
    }

    public static class Value {
        public String charset;
        public String encodedValue;
        public String value;

        private Value() {
        }
    }

    public ParameterList() {
        this.list = new LinkedHashMap();
        this.lastName = null;
        if (decodeParameters) {
            this.multisegmentNames = new HashSet();
            this.slist = new HashMap();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0069 A[Catch: UnsupportedEncodingException -> 0x005f, all -> 0x0101, TryCatch #5 {UnsupportedEncodingException -> 0x005f, blocks: (B:21:0x005a, B:25:0x0063, B:29:0x006f, B:30:0x0076, B:27:0x0069), top: B:95:0x005a, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x006f A[Catch: UnsupportedEncodingException -> 0x005f, all -> 0x0101, TryCatch #5 {UnsupportedEncodingException -> 0x005f, blocks: (B:21:0x005a, B:25:0x0063, B:29:0x006f, B:30:0x0076, B:27:0x0069), top: B:95:0x005a, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0076 A[Catch: UnsupportedEncodingException -> 0x005f, all -> 0x0101, TRY_LEAVE, TryCatch #5 {UnsupportedEncodingException -> 0x005f, blocks: (B:21:0x005a, B:25:0x0063, B:29:0x006f, B:30:0x0076, B:27:0x0069), top: B:95:0x005a, outer: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void combineMultisegmentNames(boolean r10) throws javax.mail.internet.ParseException {
        /*
            Method dump skipped, instruction units count: 340
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.mail.internet.ParameterList.combineMultisegmentNames(boolean):void");
    }

    private static String decodeBytes(String str, String str2) throws ParseException, UnsupportedEncodingException {
        byte[] bArr = new byte[str.length()];
        int i2 = 0;
        int i3 = 0;
        while (i2 < str.length()) {
            char cCharAt = str.charAt(i2);
            if (cCharAt == '%') {
                try {
                    cCharAt = (char) Integer.parseInt(str.substring(i2 + 1, i2 + 3), 16);
                    i2 += 2;
                } catch (NumberFormatException e2) {
                    if (decodeParametersStrict) {
                        throw new ParseException(e2.toString());
                    }
                } catch (StringIndexOutOfBoundsException e3) {
                    if (decodeParametersStrict) {
                        throw new ParseException(e3.toString());
                    }
                }
            }
            bArr[i3] = (byte) cCharAt;
            i2++;
            i3++;
        }
        if (str2 != null) {
            str2 = MimeUtility.javaCharset(str2);
        }
        if (str2 == null || str2.length() == 0) {
            str2 = MimeUtility.getDefaultJavaCharset();
        }
        return new String(bArr, 0, i3, str2);
    }

    private static Value encodeValue(String str, String str2) {
        if (MimeUtility.checkAscii(str) == 1) {
            return null;
        }
        try {
            byte[] bytes = str.getBytes(MimeUtility.javaCharset(str2));
            StringBuffer stringBuffer = new StringBuffer(bytes.length + str2.length() + 2);
            stringBuffer.append(str2);
            stringBuffer.append("''");
            for (byte b2 : bytes) {
                char c2 = (char) (b2 & 255);
                if (c2 <= ' ' || c2 >= 127 || c2 == '*' || c2 == '\'' || c2 == '%' || HeaderTokenizer.MIME.indexOf(c2) >= 0) {
                    stringBuffer.append('%');
                    char[] cArr = hex;
                    stringBuffer.append(cArr[c2 >> 4]);
                    stringBuffer.append(cArr[c2 & 15]);
                } else {
                    stringBuffer.append(c2);
                }
            }
            Value value = new Value();
            value.charset = str2;
            value.value = str;
            value.encodedValue = stringBuffer.toString();
            return value;
        } catch (UnsupportedEncodingException unused) {
            return null;
        }
    }

    private static Value extractCharset(String str) throws ParseException {
        int iIndexOf;
        Value value = new Value();
        value.encodedValue = str;
        value.value = str;
        try {
            iIndexOf = str.indexOf(39);
        } catch (NumberFormatException e2) {
            if (decodeParametersStrict) {
                throw new ParseException(e2.toString());
            }
        } catch (StringIndexOutOfBoundsException e3) {
            if (decodeParametersStrict) {
                throw new ParseException(e3.toString());
            }
        }
        if (iIndexOf < 0) {
            if (!decodeParametersStrict) {
                return value;
            }
            throw new ParseException("Missing charset in encoded value: " + str);
        }
        String strSubstring = str.substring(0, iIndexOf);
        int iIndexOf2 = str.indexOf(39, iIndexOf + 1);
        if (iIndexOf2 >= 0) {
            value.value = str.substring(iIndexOf2 + 1);
            value.charset = strSubstring;
            return value;
        }
        if (!decodeParametersStrict) {
            return value;
        }
        throw new ParseException("Missing language in encoded value: " + str);
    }

    private void putEncodedName(String str, String str2) throws ParseException {
        Value valueExtractCharset;
        int iIndexOf = str.indexOf(42);
        if (iIndexOf < 0) {
            this.list.put(str, str2);
            return;
        }
        if (iIndexOf == str.length() - 1) {
            String strSubstring = str.substring(0, iIndexOf);
            Value valueExtractCharset2 = extractCharset(str2);
            try {
                valueExtractCharset2.value = decodeBytes(valueExtractCharset2.value, valueExtractCharset2.charset);
            } catch (UnsupportedEncodingException e2) {
                if (decodeParametersStrict) {
                    throw new ParseException(e2.toString());
                }
            }
            this.list.put(strSubstring, valueExtractCharset2);
            return;
        }
        String strSubstring2 = str.substring(0, iIndexOf);
        this.multisegmentNames.add(strSubstring2);
        this.list.put(strSubstring2, "");
        Object obj = str2;
        if (str.endsWith("*")) {
            if (str.endsWith("*0*")) {
                valueExtractCharset = extractCharset(str2);
            } else {
                Value value = new Value();
                value.encodedValue = str2;
                value.value = str2;
                valueExtractCharset = value;
            }
            str = str.substring(0, str.length() - 1);
            obj = valueExtractCharset;
        }
        this.slist.put(str, obj);
    }

    private static String quote(String str) {
        return MimeUtility.quote(str, HeaderTokenizer.MIME);
    }

    public void combineSegments() {
        if (!decodeParameters || this.multisegmentNames.size() <= 0) {
            return;
        }
        try {
            combineMultisegmentNames(true);
        } catch (ParseException unused) {
        }
    }

    public String get(String str) {
        Object obj = this.list.get(str.trim().toLowerCase(Locale.ENGLISH));
        return obj instanceof MultiValue ? ((MultiValue) obj).value : obj instanceof LiteralValue ? ((LiteralValue) obj).value : obj instanceof Value ? ((Value) obj).value : (String) obj;
    }

    public Enumeration<String> getNames() {
        return new ParamEnum(this.list.keySet().iterator());
    }

    public void remove(String str) {
        this.list.remove(str.trim().toLowerCase(Locale.ENGLISH));
    }

    public void set(String str, String str2) {
        String lowerCase = str.trim().toLowerCase(Locale.ENGLISH);
        if (!decodeParameters) {
            this.list.put(lowerCase, str2);
            return;
        }
        try {
            putEncodedName(lowerCase, str2);
        } catch (ParseException unused) {
            this.list.put(lowerCase, str2);
        }
    }

    public void setLiteral(String str, String str2) {
        LiteralValue literalValue = new LiteralValue();
        literalValue.value = str2;
        this.list.put(str, literalValue);
    }

    public int size() {
        return this.list.size();
    }

    public String toString() {
        return toString(0);
    }

    public String toString(int i2) {
        String str;
        String str2;
        ToStringBuffer toStringBuffer = new ToStringBuffer(i2);
        for (Map.Entry<String, Object> entry : this.list.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof MultiValue) {
                MultiValue multiValue = (MultiValue) value;
                String str3 = key + "*";
                for (int i3 = 0; i3 < multiValue.size(); i3++) {
                    Object obj = multiValue.get(i3);
                    if (obj instanceof Value) {
                        str = str3 + i3 + "*";
                        str2 = ((Value) obj).encodedValue;
                    } else {
                        str = str3 + i3;
                        str2 = (String) obj;
                    }
                    toStringBuffer.addNV(str, quote(str2));
                }
            } else if (value instanceof LiteralValue) {
                toStringBuffer.addNV(key, quote(((LiteralValue) value).value));
            } else if (value instanceof Value) {
                toStringBuffer.addNV(key + "*", quote(((Value) value).encodedValue));
            } else {
                String strSubstring = (String) value;
                if (strSubstring.length() > 60 && splitLongParameters && encodeParameters) {
                    String str4 = key + "*";
                    int i4 = 0;
                    while (strSubstring.length() > 60) {
                        toStringBuffer.addNV(str4 + i4, quote(strSubstring.substring(0, 60)));
                        strSubstring = strSubstring.substring(60);
                        i4++;
                    }
                    if (strSubstring.length() > 0) {
                        toStringBuffer.addNV(str4 + i4, quote(strSubstring));
                    }
                } else {
                    toStringBuffer.addNV(key, quote(strSubstring));
                }
            }
        }
        return toStringBuffer.toString();
    }

    public void set(String str, String str2, String str3) {
        if (encodeParameters) {
            Value valueEncodeValue = encodeValue(str2, str3);
            if (valueEncodeValue != null) {
                this.list.put(str.trim().toLowerCase(Locale.ENGLISH), valueEncodeValue);
                return;
            } else {
                set(str, str2);
                return;
            }
        }
        set(str, str2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0030, code lost:
    
        if (javax.mail.internet.ParameterList.decodeParameters == false) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0032, code lost:
    
        combineMultisegmentNames(false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0036, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:?, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public ParameterList(java.lang.String r12) throws javax.mail.internet.ParseException {
        /*
            Method dump skipped, instruction units count: 366
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.mail.internet.ParameterList.<init>(java.lang.String):void");
    }

    private static void decodeBytes(String str, OutputStream outputStream) throws ParseException, IOException {
        int i2 = 0;
        while (i2 < str.length()) {
            char cCharAt = str.charAt(i2);
            if (cCharAt == '%') {
                try {
                    cCharAt = (char) Integer.parseInt(str.substring(i2 + 1, i2 + 3), 16);
                    i2 += 2;
                } catch (NumberFormatException e2) {
                    if (decodeParametersStrict) {
                        throw new ParseException(e2.toString());
                    }
                } catch (StringIndexOutOfBoundsException e3) {
                    if (decodeParametersStrict) {
                        throw new ParseException(e3.toString());
                    }
                }
            }
            outputStream.write((byte) cCharAt);
            i2++;
        }
    }
}
