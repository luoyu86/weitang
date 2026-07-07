package okhttp3;

import anet.channel.util.HttpConstant;
import com.alibaba.android.arouter.utils.Consts;
import com.alipay.sdk.m.n.a;
import com.taobao.accs.common.Constants;
import com.tom_roush.pdfbox.contentstream.operator.OperatorName;
import f.c;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.annotation.Nullable;
import okhttp3.internal.Util;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
import org.apache.commons.codec.net.RFC1522Codec;

/* JADX INFO: loaded from: classes2.dex */
public final class HttpUrl {
    public static final String FORM_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#&!$(),~";
    public static final String FRAGMENT_ENCODE_SET = "";
    public static final String FRAGMENT_ENCODE_SET_URI = " \"#<>\\^`{|}";
    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    public static final String PASSWORD_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#";
    public static final String PATH_SEGMENT_ENCODE_SET = " \"<>^`{}|/\\?#";
    public static final String PATH_SEGMENT_ENCODE_SET_URI = "[]";
    public static final String QUERY_COMPONENT_ENCODE_SET = " !\"#$&'(),/:;<=>?@[]\\^`{|}~";
    public static final String QUERY_COMPONENT_ENCODE_SET_URI = "\\^`{|}";
    public static final String QUERY_COMPONENT_REENCODE_SET = " \"'<>#&=";
    public static final String QUERY_ENCODE_SET = " \"'<>#";
    public static final String USERNAME_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#";

    @Nullable
    private final String fragment;
    public final String host;
    private final String password;
    private final List<String> pathSegments;
    public final int port;

    @Nullable
    private final List<String> queryNamesAndValues;
    public final String scheme;
    private final String url;
    private final String username;

    public HttpUrl(Builder builder) {
        this.scheme = builder.scheme;
        this.username = percentDecode(builder.encodedUsername, false);
        this.password = percentDecode(builder.encodedPassword, false);
        this.host = builder.host;
        this.port = builder.effectivePort();
        this.pathSegments = percentDecode(builder.encodedPathSegments, false);
        List<String> list = builder.encodedQueryNamesAndValues;
        this.queryNamesAndValues = list != null ? percentDecode(list, true) : null;
        String str = builder.encodedFragment;
        this.fragment = str != null ? percentDecode(str, false) : null;
        this.url = builder.toString();
    }

    public static String canonicalize(String str, int i2, int i3, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset) {
        int iCharCount = i2;
        while (iCharCount < i3) {
            int iCodePointAt = str.codePointAt(iCharCount);
            if (iCodePointAt < 32 || iCodePointAt == 127 || (iCodePointAt >= 128 && z4)) {
                c cVar = new c();
                cVar.writeUtf8(str, i2, iCharCount);
                canonicalize(cVar, str, iCharCount, i3, str2, z, z2, z3, z4, charset);
                return cVar.readUtf8();
            }
            if (str2.indexOf(iCodePointAt) != -1 || ((iCodePointAt == 37 && (!z || (z2 && !percentEncoded(str, iCharCount, i3)))) || (iCodePointAt == 43 && z3))) {
                c cVar2 = new c();
                cVar2.writeUtf8(str, i2, iCharCount);
                canonicalize(cVar2, str, iCharCount, i3, str2, z, z2, z3, z4, charset);
                return cVar2.readUtf8();
            }
            iCharCount += Character.charCount(iCodePointAt);
        }
        return str.substring(i2, i3);
    }

    public static int defaultPort(String str) {
        if (str.equals("http")) {
            return 80;
        }
        if (str.equals("https")) {
            return Constants.PORT;
        }
        return -1;
    }

    public static HttpUrl get(String str) {
        return new Builder().parse(null, str).build();
    }

    public static void namesAndValuesToQueryString(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2 += 2) {
            String str = list.get(i2);
            String str2 = list.get(i2 + 1);
            if (i2 > 0) {
                sb.append('&');
            }
            sb.append(str);
            if (str2 != null) {
                sb.append(a.f5521h);
                sb.append(str2);
            }
        }
    }

    @Nullable
    public static HttpUrl parse(String str) {
        try {
            return get(str);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public static void pathSegmentsToString(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            sb.append('/');
            sb.append(list.get(i2));
        }
    }

    public static String percentDecode(String str, boolean z) {
        return percentDecode(str, 0, str.length(), z);
    }

    public static boolean percentEncoded(String str, int i2, int i3) {
        int i4 = i2 + 2;
        return i4 < i3 && str.charAt(i2) == '%' && Util.decodeHexDigit(str.charAt(i2 + 1)) != -1 && Util.decodeHexDigit(str.charAt(i4)) != -1;
    }

    public static List<String> queryStringToNamesAndValues(String str) {
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (i2 <= str.length()) {
            int iIndexOf = str.indexOf(38, i2);
            if (iIndexOf == -1) {
                iIndexOf = str.length();
            }
            int iIndexOf2 = str.indexOf(61, i2);
            if (iIndexOf2 == -1 || iIndexOf2 > iIndexOf) {
                arrayList.add(str.substring(i2, iIndexOf));
                arrayList.add(null);
            } else {
                arrayList.add(str.substring(i2, iIndexOf2));
                arrayList.add(str.substring(iIndexOf2 + 1, iIndexOf));
            }
            i2 = iIndexOf + 1;
        }
        return arrayList;
    }

    @Nullable
    public String encodedFragment() {
        if (this.fragment == null) {
            return null;
        }
        return this.url.substring(this.url.indexOf(35) + 1);
    }

    public String encodedPassword() {
        if (this.password.isEmpty()) {
            return "";
        }
        return this.url.substring(this.url.indexOf(58, this.scheme.length() + 3) + 1, this.url.indexOf(64));
    }

    public String encodedPath() {
        int iIndexOf = this.url.indexOf(47, this.scheme.length() + 3);
        String str = this.url;
        return this.url.substring(iIndexOf, Util.delimiterOffset(str, iIndexOf, str.length(), "?#"));
    }

    public List<String> encodedPathSegments() {
        int iIndexOf = this.url.indexOf(47, this.scheme.length() + 3);
        String str = this.url;
        int iDelimiterOffset = Util.delimiterOffset(str, iIndexOf, str.length(), "?#");
        ArrayList arrayList = new ArrayList();
        while (iIndexOf < iDelimiterOffset) {
            int i2 = iIndexOf + 1;
            int iDelimiterOffset2 = Util.delimiterOffset(this.url, i2, iDelimiterOffset, '/');
            arrayList.add(this.url.substring(i2, iDelimiterOffset2));
            iIndexOf = iDelimiterOffset2;
        }
        return arrayList;
    }

    @Nullable
    public String encodedQuery() {
        if (this.queryNamesAndValues == null) {
            return null;
        }
        int iIndexOf = this.url.indexOf(63) + 1;
        String str = this.url;
        return this.url.substring(iIndexOf, Util.delimiterOffset(str, iIndexOf, str.length(), '#'));
    }

    public String encodedUsername() {
        if (this.username.isEmpty()) {
            return "";
        }
        int length = this.scheme.length() + 3;
        String str = this.url;
        return this.url.substring(length, Util.delimiterOffset(str, length, str.length(), ":@"));
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof HttpUrl) && ((HttpUrl) obj).url.equals(this.url);
    }

    @Nullable
    public String fragment() {
        return this.fragment;
    }

    public int hashCode() {
        return this.url.hashCode();
    }

    public String host() {
        return this.host;
    }

    public boolean isHttps() {
        return this.scheme.equals("https");
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.scheme = this.scheme;
        builder.encodedUsername = encodedUsername();
        builder.encodedPassword = encodedPassword();
        builder.host = this.host;
        builder.port = this.port != defaultPort(this.scheme) ? this.port : -1;
        builder.encodedPathSegments.clear();
        builder.encodedPathSegments.addAll(encodedPathSegments());
        builder.encodedQuery(encodedQuery());
        builder.encodedFragment = encodedFragment();
        return builder;
    }

    public String password() {
        return this.password;
    }

    public List<String> pathSegments() {
        return this.pathSegments;
    }

    public int pathSize() {
        return this.pathSegments.size();
    }

    public int port() {
        return this.port;
    }

    @Nullable
    public String query() {
        if (this.queryNamesAndValues == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        namesAndValuesToQueryString(sb, this.queryNamesAndValues);
        return sb.toString();
    }

    @Nullable
    public String queryParameter(String str) {
        List<String> list = this.queryNamesAndValues;
        if (list == null) {
            return null;
        }
        int size = list.size();
        for (int i2 = 0; i2 < size; i2 += 2) {
            if (str.equals(this.queryNamesAndValues.get(i2))) {
                return this.queryNamesAndValues.get(i2 + 1);
            }
        }
        return null;
    }

    public String queryParameterName(int i2) {
        List<String> list = this.queryNamesAndValues;
        if (list != null) {
            return list.get(i2 * 2);
        }
        throw new IndexOutOfBoundsException();
    }

    public Set<String> queryParameterNames() {
        if (this.queryNamesAndValues == null) {
            return Collections.emptySet();
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        int size = this.queryNamesAndValues.size();
        for (int i2 = 0; i2 < size; i2 += 2) {
            linkedHashSet.add(this.queryNamesAndValues.get(i2));
        }
        return Collections.unmodifiableSet(linkedHashSet);
    }

    public String queryParameterValue(int i2) {
        List<String> list = this.queryNamesAndValues;
        if (list != null) {
            return list.get((i2 * 2) + 1);
        }
        throw new IndexOutOfBoundsException();
    }

    public List<String> queryParameterValues(String str) {
        if (this.queryNamesAndValues == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        int size = this.queryNamesAndValues.size();
        for (int i2 = 0; i2 < size; i2 += 2) {
            if (str.equals(this.queryNamesAndValues.get(i2))) {
                arrayList.add(this.queryNamesAndValues.get(i2 + 1));
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    public int querySize() {
        List<String> list = this.queryNamesAndValues;
        if (list != null) {
            return list.size() / 2;
        }
        return 0;
    }

    public String redact() {
        return newBuilder("/...").username("").password("").build().toString();
    }

    @Nullable
    public HttpUrl resolve(String str) {
        Builder builderNewBuilder = newBuilder(str);
        if (builderNewBuilder != null) {
            return builderNewBuilder.build();
        }
        return null;
    }

    public String scheme() {
        return this.scheme;
    }

    public String toString() {
        return this.url;
    }

    @Nullable
    public String topPrivateDomain() {
        if (Util.verifyAsIpAddress(this.host)) {
            return null;
        }
        return PublicSuffixDatabase.get().getEffectiveTldPlusOne(this.host);
    }

    public URI uri() {
        String string = newBuilder().reencodeForUri().toString();
        try {
            return new URI(string);
        } catch (URISyntaxException e2) {
            try {
                return URI.create(string.replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", ""));
            } catch (Exception unused) {
                throw new RuntimeException(e2);
            }
        }
    }

    public URL url() {
        try {
            return new URL(this.url);
        } catch (MalformedURLException e2) {
            throw new RuntimeException(e2);
        }
    }

    public String username() {
        return this.username;
    }

    public static final class Builder {
        public static final String INVALID_HOST = "Invalid URL host";

        @Nullable
        public String encodedFragment;
        public final List<String> encodedPathSegments;

        @Nullable
        public List<String> encodedQueryNamesAndValues;

        @Nullable
        public String host;

        @Nullable
        public String scheme;
        public String encodedUsername = "";
        public String encodedPassword = "";
        public int port = -1;

        public Builder() {
            ArrayList arrayList = new ArrayList();
            this.encodedPathSegments = arrayList;
            arrayList.add("");
        }

        private static String canonicalizeHost(String str, int i2, int i3) {
            return Util.canonicalizeHost(HttpUrl.percentDecode(str, i2, i3, false));
        }

        private boolean isDot(String str) {
            return str.equals(Consts.DOT) || str.equalsIgnoreCase("%2e");
        }

        private boolean isDotDot(String str) {
            return str.equals("..") || str.equalsIgnoreCase("%2e.") || str.equalsIgnoreCase(".%2e") || str.equalsIgnoreCase("%2e%2e");
        }

        private static int parsePort(String str, int i2, int i3) {
            int i4;
            try {
                i4 = Integer.parseInt(HttpUrl.canonicalize(str, i2, i3, "", false, false, false, true, null));
            } catch (NumberFormatException unused) {
            }
            if (i4 <= 0 || i4 > 65535) {
                return -1;
            }
            return i4;
        }

        private void pop() {
            if (!this.encodedPathSegments.remove(r0.size() - 1).isEmpty() || this.encodedPathSegments.isEmpty()) {
                this.encodedPathSegments.add("");
            } else {
                this.encodedPathSegments.set(r0.size() - 1, "");
            }
        }

        private static int portColonOffset(String str, int i2, int i3) {
            while (i2 < i3) {
                char cCharAt = str.charAt(i2);
                if (cCharAt == ':') {
                    return i2;
                }
                if (cCharAt == '[') {
                    do {
                        i2++;
                        if (i2 < i3) {
                        }
                    } while (str.charAt(i2) != ']');
                }
                i2++;
            }
            return i3;
        }

        private void push(String str, int i2, int i3, boolean z, boolean z2) {
            String strCanonicalize = HttpUrl.canonicalize(str, i2, i3, HttpUrl.PATH_SEGMENT_ENCODE_SET, z2, false, false, true, null);
            if (isDot(strCanonicalize)) {
                return;
            }
            if (isDotDot(strCanonicalize)) {
                pop();
                return;
            }
            if (this.encodedPathSegments.get(r11.size() - 1).isEmpty()) {
                this.encodedPathSegments.set(r11.size() - 1, strCanonicalize);
            } else {
                this.encodedPathSegments.add(strCanonicalize);
            }
            if (z) {
                this.encodedPathSegments.add("");
            }
        }

        private void removeAllCanonicalQueryParameters(String str) {
            for (int size = this.encodedQueryNamesAndValues.size() - 2; size >= 0; size -= 2) {
                if (str.equals(this.encodedQueryNamesAndValues.get(size))) {
                    this.encodedQueryNamesAndValues.remove(size + 1);
                    this.encodedQueryNamesAndValues.remove(size);
                    if (this.encodedQueryNamesAndValues.isEmpty()) {
                        this.encodedQueryNamesAndValues = null;
                        return;
                    }
                }
            }
        }

        private void resolvePath(String str, int i2, int i3) {
            if (i2 == i3) {
                return;
            }
            char cCharAt = str.charAt(i2);
            if (cCharAt == '/' || cCharAt == '\\') {
                this.encodedPathSegments.clear();
                this.encodedPathSegments.add("");
                i2++;
            } else {
                List<String> list = this.encodedPathSegments;
                list.set(list.size() - 1, "");
            }
            while (true) {
                int i4 = i2;
                if (i4 >= i3) {
                    return;
                }
                i2 = Util.delimiterOffset(str, i4, i3, "/\\");
                boolean z = i2 < i3;
                push(str, i4, i2, z, true);
                if (z) {
                    i2++;
                }
            }
        }

        private static int schemeDelimiterOffset(String str, int i2, int i3) {
            if (i3 - i2 < 2) {
                return -1;
            }
            char cCharAt = str.charAt(i2);
            if ((cCharAt >= 'a' && cCharAt <= 'z') || (cCharAt >= 'A' && cCharAt <= 'Z')) {
                while (true) {
                    i2++;
                    if (i2 >= i3) {
                        break;
                    }
                    char cCharAt2 = str.charAt(i2);
                    if (cCharAt2 < 'a' || cCharAt2 > 'z') {
                        if (cCharAt2 < 'A' || cCharAt2 > 'Z') {
                            if (cCharAt2 < '0' || cCharAt2 > '9') {
                                if (cCharAt2 != '+' && cCharAt2 != '-' && cCharAt2 != '.') {
                                    if (cCharAt2 == ':') {
                                        return i2;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return -1;
        }

        private static int slashCount(String str, int i2, int i3) {
            int i4 = 0;
            while (i2 < i3) {
                char cCharAt = str.charAt(i2);
                if (cCharAt != '\\' && cCharAt != '/') {
                    break;
                }
                i4++;
                i2++;
            }
            return i4;
        }

        public Builder addEncodedPathSegment(String str) {
            Objects.requireNonNull(str, "encodedPathSegment == null");
            push(str, 0, str.length(), false, true);
            return this;
        }

        public Builder addEncodedPathSegments(String str) {
            Objects.requireNonNull(str, "encodedPathSegments == null");
            return addPathSegments(str, true);
        }

        public Builder addEncodedQueryParameter(String str, @Nullable String str2) {
            Objects.requireNonNull(str, "encodedName == null");
            if (this.encodedQueryNamesAndValues == null) {
                this.encodedQueryNamesAndValues = new ArrayList();
            }
            this.encodedQueryNamesAndValues.add(HttpUrl.canonicalize(str, HttpUrl.QUERY_COMPONENT_REENCODE_SET, true, false, true, true));
            this.encodedQueryNamesAndValues.add(str2 != null ? HttpUrl.canonicalize(str2, HttpUrl.QUERY_COMPONENT_REENCODE_SET, true, false, true, true) : null);
            return this;
        }

        public Builder addPathSegment(String str) {
            Objects.requireNonNull(str, "pathSegment == null");
            push(str, 0, str.length(), false, false);
            return this;
        }

        public Builder addPathSegments(String str) {
            Objects.requireNonNull(str, "pathSegments == null");
            return addPathSegments(str, false);
        }

        public Builder addQueryParameter(String str, @Nullable String str2) {
            Objects.requireNonNull(str, "name == null");
            if (this.encodedQueryNamesAndValues == null) {
                this.encodedQueryNamesAndValues = new ArrayList();
            }
            this.encodedQueryNamesAndValues.add(HttpUrl.canonicalize(str, HttpUrl.QUERY_COMPONENT_ENCODE_SET, false, false, true, true));
            this.encodedQueryNamesAndValues.add(str2 != null ? HttpUrl.canonicalize(str2, HttpUrl.QUERY_COMPONENT_ENCODE_SET, false, false, true, true) : null);
            return this;
        }

        public HttpUrl build() {
            if (this.scheme == null) {
                throw new IllegalStateException("scheme == null");
            }
            if (this.host != null) {
                return new HttpUrl(this);
            }
            throw new IllegalStateException("host == null");
        }

        public int effectivePort() {
            int i2 = this.port;
            return i2 != -1 ? i2 : HttpUrl.defaultPort(this.scheme);
        }

        public Builder encodedFragment(@Nullable String str) {
            this.encodedFragment = str != null ? HttpUrl.canonicalize(str, "", true, false, false, false) : null;
            return this;
        }

        public Builder encodedPassword(String str) {
            Objects.requireNonNull(str, "encodedPassword == null");
            this.encodedPassword = HttpUrl.canonicalize(str, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
            return this;
        }

        public Builder encodedPath(String str) {
            Objects.requireNonNull(str, "encodedPath == null");
            if (str.startsWith("/")) {
                resolvePath(str, 0, str.length());
                return this;
            }
            throw new IllegalArgumentException("unexpected encodedPath: " + str);
        }

        public Builder encodedQuery(@Nullable String str) {
            this.encodedQueryNamesAndValues = str != null ? HttpUrl.queryStringToNamesAndValues(HttpUrl.canonicalize(str, HttpUrl.QUERY_ENCODE_SET, true, false, true, true)) : null;
            return this;
        }

        public Builder encodedUsername(String str) {
            Objects.requireNonNull(str, "encodedUsername == null");
            this.encodedUsername = HttpUrl.canonicalize(str, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
            return this;
        }

        public Builder fragment(@Nullable String str) {
            this.encodedFragment = str != null ? HttpUrl.canonicalize(str, "", false, false, false, false) : null;
            return this;
        }

        public Builder host(String str) {
            Objects.requireNonNull(str, "host == null");
            String strCanonicalizeHost = canonicalizeHost(str, 0, str.length());
            if (strCanonicalizeHost != null) {
                this.host = strCanonicalizeHost;
                return this;
            }
            throw new IllegalArgumentException("unexpected host: " + str);
        }

        public Builder parse(@Nullable HttpUrl httpUrl, String str) {
            int iDelimiterOffset;
            int i2;
            int iSkipLeadingAsciiWhitespace = Util.skipLeadingAsciiWhitespace(str, 0, str.length());
            int iSkipTrailingAsciiWhitespace = Util.skipTrailingAsciiWhitespace(str, iSkipLeadingAsciiWhitespace, str.length());
            int iSchemeDelimiterOffset = schemeDelimiterOffset(str, iSkipLeadingAsciiWhitespace, iSkipTrailingAsciiWhitespace);
            if (iSchemeDelimiterOffset != -1) {
                if (str.regionMatches(true, iSkipLeadingAsciiWhitespace, "https:", 0, 6)) {
                    this.scheme = "https";
                    iSkipLeadingAsciiWhitespace += 6;
                } else {
                    if (!str.regionMatches(true, iSkipLeadingAsciiWhitespace, "http:", 0, 5)) {
                        throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but was '" + str.substring(0, iSchemeDelimiterOffset) + OperatorName.SHOW_TEXT_LINE);
                    }
                    this.scheme = "http";
                    iSkipLeadingAsciiWhitespace += 5;
                }
            } else {
                if (httpUrl == null) {
                    throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but no colon was found");
                }
                this.scheme = httpUrl.scheme;
            }
            int iSlashCount = slashCount(str, iSkipLeadingAsciiWhitespace, iSkipTrailingAsciiWhitespace);
            char c2 = RFC1522Codec.SEP;
            char c3 = '#';
            if (iSlashCount >= 2 || httpUrl == null || !httpUrl.scheme.equals(this.scheme)) {
                int i3 = iSkipLeadingAsciiWhitespace + iSlashCount;
                boolean z = false;
                boolean z2 = false;
                while (true) {
                    iDelimiterOffset = Util.delimiterOffset(str, i3, iSkipTrailingAsciiWhitespace, "@/\\?#");
                    byte bCharAt = iDelimiterOffset != iSkipTrailingAsciiWhitespace ? str.charAt(iDelimiterOffset) : (byte) -1;
                    if (bCharAt == -1 || bCharAt == c3 || bCharAt == 47 || bCharAt == 92 || bCharAt == c2) {
                        break;
                    }
                    if (bCharAt == 64) {
                        if (z) {
                            i2 = iDelimiterOffset;
                            this.encodedPassword += "%40" + HttpUrl.canonicalize(str, i3, i2, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                        } else {
                            int iDelimiterOffset2 = Util.delimiterOffset(str, i3, iDelimiterOffset, ':');
                            i2 = iDelimiterOffset;
                            String strCanonicalize = HttpUrl.canonicalize(str, i3, iDelimiterOffset2, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                            if (z2) {
                                strCanonicalize = this.encodedUsername + "%40" + strCanonicalize;
                            }
                            this.encodedUsername = strCanonicalize;
                            if (iDelimiterOffset2 != i2) {
                                this.encodedPassword = HttpUrl.canonicalize(str, iDelimiterOffset2 + 1, i2, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                                z = true;
                            }
                            z2 = true;
                        }
                        i3 = i2 + 1;
                    }
                    c2 = RFC1522Codec.SEP;
                    c3 = '#';
                }
                int iPortColonOffset = portColonOffset(str, i3, iDelimiterOffset);
                int i4 = iPortColonOffset + 1;
                if (i4 < iDelimiterOffset) {
                    this.host = canonicalizeHost(str, i3, iPortColonOffset);
                    int port = parsePort(str, i4, iDelimiterOffset);
                    this.port = port;
                    if (port == -1) {
                        throw new IllegalArgumentException("Invalid URL port: \"" + str.substring(i4, iDelimiterOffset) + '\"');
                    }
                } else {
                    this.host = canonicalizeHost(str, i3, iPortColonOffset);
                    this.port = HttpUrl.defaultPort(this.scheme);
                }
                if (this.host == null) {
                    throw new IllegalArgumentException("Invalid URL host: \"" + str.substring(i3, iPortColonOffset) + '\"');
                }
                iSkipLeadingAsciiWhitespace = iDelimiterOffset;
            } else {
                this.encodedUsername = httpUrl.encodedUsername();
                this.encodedPassword = httpUrl.encodedPassword();
                this.host = httpUrl.host;
                this.port = httpUrl.port;
                this.encodedPathSegments.clear();
                this.encodedPathSegments.addAll(httpUrl.encodedPathSegments());
                if (iSkipLeadingAsciiWhitespace == iSkipTrailingAsciiWhitespace || str.charAt(iSkipLeadingAsciiWhitespace) == '#') {
                    encodedQuery(httpUrl.encodedQuery());
                }
            }
            int iDelimiterOffset3 = Util.delimiterOffset(str, iSkipLeadingAsciiWhitespace, iSkipTrailingAsciiWhitespace, "?#");
            resolvePath(str, iSkipLeadingAsciiWhitespace, iDelimiterOffset3);
            if (iDelimiterOffset3 < iSkipTrailingAsciiWhitespace && str.charAt(iDelimiterOffset3) == '?') {
                int iDelimiterOffset4 = Util.delimiterOffset(str, iDelimiterOffset3, iSkipTrailingAsciiWhitespace, '#');
                this.encodedQueryNamesAndValues = HttpUrl.queryStringToNamesAndValues(HttpUrl.canonicalize(str, iDelimiterOffset3 + 1, iDelimiterOffset4, HttpUrl.QUERY_ENCODE_SET, true, false, true, true, null));
                iDelimiterOffset3 = iDelimiterOffset4;
            }
            if (iDelimiterOffset3 < iSkipTrailingAsciiWhitespace && str.charAt(iDelimiterOffset3) == '#') {
                this.encodedFragment = HttpUrl.canonicalize(str, 1 + iDelimiterOffset3, iSkipTrailingAsciiWhitespace, "", true, false, false, false, null);
            }
            return this;
        }

        public Builder password(String str) {
            Objects.requireNonNull(str, "password == null");
            this.encodedPassword = HttpUrl.canonicalize(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
            return this;
        }

        public Builder port(int i2) {
            if (i2 > 0 && i2 <= 65535) {
                this.port = i2;
                return this;
            }
            throw new IllegalArgumentException("unexpected port: " + i2);
        }

        public Builder query(@Nullable String str) {
            this.encodedQueryNamesAndValues = str != null ? HttpUrl.queryStringToNamesAndValues(HttpUrl.canonicalize(str, HttpUrl.QUERY_ENCODE_SET, false, false, true, true)) : null;
            return this;
        }

        public Builder reencodeForUri() {
            int size = this.encodedPathSegments.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.encodedPathSegments.set(i2, HttpUrl.canonicalize(this.encodedPathSegments.get(i2), HttpUrl.PATH_SEGMENT_ENCODE_SET_URI, true, true, false, true));
            }
            List<String> list = this.encodedQueryNamesAndValues;
            if (list != null) {
                int size2 = list.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    String str = this.encodedQueryNamesAndValues.get(i3);
                    if (str != null) {
                        this.encodedQueryNamesAndValues.set(i3, HttpUrl.canonicalize(str, HttpUrl.QUERY_COMPONENT_ENCODE_SET_URI, true, true, true, true));
                    }
                }
            }
            String str2 = this.encodedFragment;
            if (str2 != null) {
                this.encodedFragment = HttpUrl.canonicalize(str2, HttpUrl.FRAGMENT_ENCODE_SET_URI, true, true, false, false);
            }
            return this;
        }

        public Builder removeAllEncodedQueryParameters(String str) {
            Objects.requireNonNull(str, "encodedName == null");
            if (this.encodedQueryNamesAndValues == null) {
                return this;
            }
            removeAllCanonicalQueryParameters(HttpUrl.canonicalize(str, HttpUrl.QUERY_COMPONENT_REENCODE_SET, true, false, true, true));
            return this;
        }

        public Builder removeAllQueryParameters(String str) {
            Objects.requireNonNull(str, "name == null");
            if (this.encodedQueryNamesAndValues == null) {
                return this;
            }
            removeAllCanonicalQueryParameters(HttpUrl.canonicalize(str, HttpUrl.QUERY_COMPONENT_ENCODE_SET, false, false, true, true));
            return this;
        }

        public Builder removePathSegment(int i2) {
            this.encodedPathSegments.remove(i2);
            if (this.encodedPathSegments.isEmpty()) {
                this.encodedPathSegments.add("");
            }
            return this;
        }

        public Builder scheme(String str) {
            Objects.requireNonNull(str, "scheme == null");
            if (str.equalsIgnoreCase("http")) {
                this.scheme = "http";
            } else {
                if (!str.equalsIgnoreCase("https")) {
                    throw new IllegalArgumentException("unexpected scheme: " + str);
                }
                this.scheme = "https";
            }
            return this;
        }

        public Builder setEncodedPathSegment(int i2, String str) {
            Objects.requireNonNull(str, "encodedPathSegment == null");
            String strCanonicalize = HttpUrl.canonicalize(str, 0, str.length(), HttpUrl.PATH_SEGMENT_ENCODE_SET, true, false, false, true, null);
            this.encodedPathSegments.set(i2, strCanonicalize);
            if (!isDot(strCanonicalize) && !isDotDot(strCanonicalize)) {
                return this;
            }
            throw new IllegalArgumentException("unexpected path segment: " + str);
        }

        public Builder setEncodedQueryParameter(String str, @Nullable String str2) {
            removeAllEncodedQueryParameters(str);
            addEncodedQueryParameter(str, str2);
            return this;
        }

        public Builder setPathSegment(int i2, String str) {
            Objects.requireNonNull(str, "pathSegment == null");
            String strCanonicalize = HttpUrl.canonicalize(str, 0, str.length(), HttpUrl.PATH_SEGMENT_ENCODE_SET, false, false, false, true, null);
            if (!isDot(strCanonicalize) && !isDotDot(strCanonicalize)) {
                this.encodedPathSegments.set(i2, strCanonicalize);
                return this;
            }
            throw new IllegalArgumentException("unexpected path segment: " + str);
        }

        public Builder setQueryParameter(String str, @Nullable String str2) {
            removeAllQueryParameters(str);
            addQueryParameter(str, str2);
            return this;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.scheme);
            sb.append(HttpConstant.SCHEME_SPLIT);
            if (!this.encodedUsername.isEmpty() || !this.encodedPassword.isEmpty()) {
                sb.append(this.encodedUsername);
                if (!this.encodedPassword.isEmpty()) {
                    sb.append(':');
                    sb.append(this.encodedPassword);
                }
                sb.append('@');
            }
            if (this.host.indexOf(58) != -1) {
                sb.append('[');
                sb.append(this.host);
                sb.append(']');
            } else {
                sb.append(this.host);
            }
            int iEffectivePort = effectivePort();
            if (iEffectivePort != HttpUrl.defaultPort(this.scheme)) {
                sb.append(':');
                sb.append(iEffectivePort);
            }
            HttpUrl.pathSegmentsToString(sb, this.encodedPathSegments);
            if (this.encodedQueryNamesAndValues != null) {
                sb.append(RFC1522Codec.SEP);
                HttpUrl.namesAndValuesToQueryString(sb, this.encodedQueryNamesAndValues);
            }
            if (this.encodedFragment != null) {
                sb.append('#');
                sb.append(this.encodedFragment);
            }
            return sb.toString();
        }

        public Builder username(String str) {
            Objects.requireNonNull(str, "username == null");
            this.encodedUsername = HttpUrl.canonicalize(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
            return this;
        }

        private Builder addPathSegments(String str, boolean z) {
            int i2 = 0;
            do {
                int iDelimiterOffset = Util.delimiterOffset(str, i2, str.length(), "/\\");
                push(str, i2, iDelimiterOffset, iDelimiterOffset < str.length(), z);
                i2 = iDelimiterOffset + 1;
            } while (i2 <= str.length());
            return this;
        }
    }

    @Nullable
    public static HttpUrl get(URL url) {
        return parse(url.toString());
    }

    private List<String> percentDecode(List<String> list, boolean z) {
        int size = list.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i2 = 0; i2 < size; i2++) {
            String str = list.get(i2);
            arrayList.add(str != null ? percentDecode(str, z) : null);
        }
        return Collections.unmodifiableList(arrayList);
    }

    @Nullable
    public static HttpUrl get(URI uri) {
        return parse(uri.toString());
    }

    public static String percentDecode(String str, int i2, int i3, boolean z) {
        for (int i4 = i2; i4 < i3; i4++) {
            char cCharAt = str.charAt(i4);
            if (cCharAt == '%' || (cCharAt == '+' && z)) {
                c cVar = new c();
                cVar.writeUtf8(str, i2, i4);
                percentDecode(cVar, str, i4, i3, z);
                return cVar.readUtf8();
            }
        }
        return str.substring(i2, i3);
    }

    public static void canonicalize(c cVar, String str, int i2, int i3, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset) {
        c cVar2 = null;
        while (i2 < i3) {
            int iCodePointAt = str.codePointAt(i2);
            if (!z || (iCodePointAt != 9 && iCodePointAt != 10 && iCodePointAt != 12 && iCodePointAt != 13)) {
                if (iCodePointAt == 43 && z3) {
                    cVar.writeUtf8(z ? "+" : "%2B");
                } else if (iCodePointAt >= 32 && iCodePointAt != 127 && ((iCodePointAt < 128 || !z4) && str2.indexOf(iCodePointAt) == -1 && (iCodePointAt != 37 || (z && (!z2 || percentEncoded(str, i2, i3)))))) {
                    cVar.writeUtf8CodePoint(iCodePointAt);
                } else {
                    if (cVar2 == null) {
                        cVar2 = new c();
                    }
                    if (charset != null && !charset.equals(Util.UTF_8)) {
                        cVar2.writeString(str, i2, Character.charCount(iCodePointAt) + i2, charset);
                    } else {
                        cVar2.writeUtf8CodePoint(iCodePointAt);
                    }
                    while (!cVar2.exhausted()) {
                        int i4 = cVar2.readByte() & 255;
                        cVar.writeByte(37);
                        char[] cArr = HEX_DIGITS;
                        cVar.writeByte((int) cArr[(i4 >> 4) & 15]);
                        cVar.writeByte((int) cArr[i4 & 15]);
                    }
                }
            }
            i2 += Character.charCount(iCodePointAt);
        }
    }

    @Nullable
    public Builder newBuilder(String str) {
        try {
            return new Builder().parse(this, str);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0039  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void percentDecode(f.c r5, java.lang.String r6, int r7, int r8, boolean r9) {
        /*
        L0:
            if (r7 >= r8) goto L42
            int r0 = r6.codePointAt(r7)
            r1 = 37
            if (r0 != r1) goto L2d
            int r1 = r7 + 2
            if (r1 >= r8) goto L2d
            int r2 = r7 + 1
            char r2 = r6.charAt(r2)
            int r2 = okhttp3.internal.Util.decodeHexDigit(r2)
            char r3 = r6.charAt(r1)
            int r3 = okhttp3.internal.Util.decodeHexDigit(r3)
            r4 = -1
            if (r2 == r4) goto L39
            if (r3 == r4) goto L39
            int r7 = r2 << 4
            int r7 = r7 + r3
            r5.writeByte(r7)
            r7 = r1
            goto L3c
        L2d:
            r1 = 43
            if (r0 != r1) goto L39
            if (r9 == 0) goto L39
            r1 = 32
            r5.writeByte(r1)
            goto L3c
        L39:
            r5.writeUtf8CodePoint(r0)
        L3c:
            int r0 = java.lang.Character.charCount(r0)
            int r7 = r7 + r0
            goto L0
        L42:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.HttpUrl.percentDecode(f.c, java.lang.String, int, int, boolean):void");
    }

    public static String canonicalize(String str, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset) {
        return canonicalize(str, 0, str.length(), str2, z, z2, z3, z4, charset);
    }

    public static String canonicalize(String str, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        return canonicalize(str, 0, str.length(), str2, z, z2, z3, z4, null);
    }
}
