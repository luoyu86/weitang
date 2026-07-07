package d.p0;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class q extends p {

    public static final class a extends d.k0.d.u implements d.k0.c.l<String, String> {
        public static final a INSTANCE = new a();

        public a() {
            super(1);
        }

        @Override // d.k0.c.l
        public final String invoke(String str) {
            d.k0.d.t.checkNotNullParameter(str, "line");
            return str;
        }
    }

    public static final class b extends d.k0.d.u implements d.k0.c.l<String, String> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f12940b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str) {
            super(1);
            this.f12940b = str;
        }

        @Override // d.k0.c.l
        public final String invoke(String str) {
            d.k0.d.t.checkNotNullParameter(str, "line");
            return this.f12940b + str;
        }
    }

    public static final class c extends d.k0.d.u implements d.k0.c.l<String, String> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f12941b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(String str) {
            super(1);
            this.f12941b = str;
        }

        @Override // d.k0.c.l
        public final String invoke(String str) {
            d.k0.d.t.checkNotNullParameter(str, "it");
            if (x.isBlank(str)) {
                return str.length() < this.f12941b.length() ? this.f12941b : str;
            }
            return this.f12941b + str;
        }
    }

    public static final d.k0.c.l<String, String> a(String str) {
        return str.length() == 0 ? a.INSTANCE : new b(str);
    }

    public static final int b(String str) {
        int length = str.length();
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                i2 = -1;
                break;
            }
            if (!d.p0.c.isWhitespace(str.charAt(i2))) {
                break;
            }
            i2++;
        }
        return i2 == -1 ? str.length() : i2;
    }

    public static final String prependIndent(String str, String str2) {
        d.k0.d.t.checkNotNullParameter(str, "$this$prependIndent");
        d.k0.d.t.checkNotNullParameter(str2, "indent");
        return d.o0.t.joinToString$default(d.o0.t.map(y.lineSequence(str), new c(str2)), "\n", null, null, 0, null, null, 62, null);
    }

    public static /* synthetic */ String prependIndent$default(String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str2 = "    ";
        }
        return prependIndent(str, str2);
    }

    public static final String replaceIndent(String str, String str2) {
        String str3;
        String strInvoke;
        d.k0.d.t.checkNotNullParameter(str, "$this$replaceIndent");
        d.k0.d.t.checkNotNullParameter(str2, "newIndent");
        List<String> listLines = y.lines(str);
        ArrayList arrayList = new ArrayList();
        for (Object obj : listLines) {
            if (!x.isBlank((String) obj)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(d.g0.t.collectionSizeOrDefault(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(Integer.valueOf(b((String) it.next())));
        }
        Integer num = (Integer) d.g0.a0.minOrNull((Iterable) arrayList2);
        int i2 = 0;
        int iIntValue = num != null ? num.intValue() : 0;
        int length = str.length() + (str2.length() * listLines.size());
        d.k0.c.l<String, String> lVarA = a(str2);
        int lastIndex = d.g0.s.getLastIndex(listLines);
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : listLines) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                d.g0.s.throwIndexOverflow();
            }
            String str4 = (String) obj2;
            if ((i2 == 0 || i2 == lastIndex) && x.isBlank(str4)) {
                str3 = null;
            } else {
                String strDrop = a0.drop(str4, iIntValue);
                if (strDrop != null && (strInvoke = lVarA.invoke(strDrop)) != null) {
                    str4 = strInvoke;
                }
                str3 = str4;
            }
            if (str3 != null) {
                arrayList3.add(str3);
            }
            i2 = i3;
        }
        String string = ((StringBuilder) d.g0.a0.joinTo(arrayList3, new StringBuilder(length), (TTDownloadField.CALL_DOWNLOAD_MODEL_SET_EXPECT_FILE_LENGTH & 2) != 0 ? ", " : "\n", (TTDownloadField.CALL_DOWNLOAD_MODEL_SET_EXPECT_FILE_LENGTH & 4) != 0 ? "" : null, (TTDownloadField.CALL_DOWNLOAD_MODEL_SET_EXPECT_FILE_LENGTH & 8) == 0 ? null : "", (TTDownloadField.CALL_DOWNLOAD_MODEL_SET_EXPECT_FILE_LENGTH & 16) != 0 ? -1 : 0, (TTDownloadField.CALL_DOWNLOAD_MODEL_SET_EXPECT_FILE_LENGTH & 32) != 0 ? "..." : null, (TTDownloadField.CALL_DOWNLOAD_MODEL_SET_EXPECT_FILE_LENGTH & 64) != 0 ? null : null)).toString();
        d.k0.d.t.checkNotNullExpressionValue(string, "mapIndexedNotNull { inde…\"\\n\")\n        .toString()");
        return string;
    }

    public static /* synthetic */ String replaceIndent$default(String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str2 = "";
        }
        return replaceIndent(str, str2);
    }

    public static final String replaceIndentByMargin(String str, String str2, String str3) {
        int i2;
        String strInvoke;
        d.k0.d.t.checkNotNullParameter(str, "$this$replaceIndentByMargin");
        d.k0.d.t.checkNotNullParameter(str2, "newIndent");
        d.k0.d.t.checkNotNullParameter(str3, "marginPrefix");
        if (!(!x.isBlank(str3))) {
            throw new IllegalArgumentException("marginPrefix must be non-blank string.".toString());
        }
        List<String> listLines = y.lines(str);
        int length = str.length() + (str2.length() * listLines.size());
        d.k0.c.l<String, String> lVarA = a(str2);
        int lastIndex = d.g0.s.getLastIndex(listLines);
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        for (Object obj : listLines) {
            int i4 = i3 + 1;
            if (i3 < 0) {
                d.g0.s.throwIndexOverflow();
            }
            String str4 = (String) obj;
            String strSubstring = null;
            if ((i3 != 0 && i3 != lastIndex) || !x.isBlank(str4)) {
                int length2 = str4.length();
                int i5 = 0;
                while (true) {
                    if (i5 >= length2) {
                        i2 = -1;
                        break;
                    }
                    if (!d.p0.c.isWhitespace(str4.charAt(i5))) {
                        i2 = i5;
                        break;
                    }
                    i5++;
                }
                if (i2 != -1) {
                    int i6 = i2;
                    if (x.startsWith$default(str4, str3, i2, false, 4, null)) {
                        int length3 = i6 + str3.length();
                        Objects.requireNonNull(str4, "null cannot be cast to non-null type java.lang.String");
                        strSubstring = str4.substring(length3);
                        d.k0.d.t.checkNotNullExpressionValue(strSubstring, "(this as java.lang.String).substring(startIndex)");
                    }
                }
                if (strSubstring != null && (strInvoke = lVarA.invoke(strSubstring)) != null) {
                    str4 = strInvoke;
                }
                strSubstring = str4;
            }
            if (strSubstring != null) {
                arrayList.add(strSubstring);
            }
            i3 = i4;
        }
        String string = ((StringBuilder) d.g0.a0.joinTo(arrayList, new StringBuilder(length), (TTDownloadField.CALL_DOWNLOAD_MODEL_SET_EXPECT_FILE_LENGTH & 2) != 0 ? ", " : "\n", (TTDownloadField.CALL_DOWNLOAD_MODEL_SET_EXPECT_FILE_LENGTH & 4) != 0 ? "" : null, (TTDownloadField.CALL_DOWNLOAD_MODEL_SET_EXPECT_FILE_LENGTH & 8) == 0 ? null : "", (TTDownloadField.CALL_DOWNLOAD_MODEL_SET_EXPECT_FILE_LENGTH & 16) != 0 ? -1 : 0, (TTDownloadField.CALL_DOWNLOAD_MODEL_SET_EXPECT_FILE_LENGTH & 32) != 0 ? "..." : null, (TTDownloadField.CALL_DOWNLOAD_MODEL_SET_EXPECT_FILE_LENGTH & 64) != 0 ? null : null)).toString();
        d.k0.d.t.checkNotNullExpressionValue(string, "mapIndexedNotNull { inde…\"\\n\")\n        .toString()");
        return string;
    }

    public static /* synthetic */ String replaceIndentByMargin$default(String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str2 = "";
        }
        if ((i2 & 2) != 0) {
            str3 = "|";
        }
        return replaceIndentByMargin(str, str2, str3);
    }

    public static final String trimIndent(String str) {
        d.k0.d.t.checkNotNullParameter(str, "$this$trimIndent");
        return replaceIndent(str, "");
    }

    public static final String trimMargin(String str, String str2) {
        d.k0.d.t.checkNotNullParameter(str, "$this$trimMargin");
        d.k0.d.t.checkNotNullParameter(str2, "marginPrefix");
        return replaceIndentByMargin(str, "", str2);
    }

    public static /* synthetic */ String trimMargin$default(String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str2 = "|";
        }
        return trimMargin(str, str2);
    }
}
