package c.i.b;

import com.alibaba.android.arouter.utils.Consts;
import java.lang.reflect.Field;
import java.util.Locale;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes2.dex */
public abstract class d implements c.i.b.e {
    public static final d IDENTITY;
    public static final d LOWER_CASE_WITH_DASHES;
    public static final d LOWER_CASE_WITH_DOTS;
    public static final d LOWER_CASE_WITH_UNDERSCORES;
    public static final d UPPER_CAMEL_CASE;
    public static final d UPPER_CAMEL_CASE_WITH_SPACES;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ d[] f2588a;

    public enum a extends d {
        public a(String str, int i2) {
            super(str, i2, null);
        }

        @Override // c.i.b.d, c.i.b.e
        public String translateName(Field field) {
            return field.getName();
        }
    }

    static {
        a aVar = new a("IDENTITY", 0);
        IDENTITY = aVar;
        d dVar = new d("UPPER_CAMEL_CASE", 1) { // from class: c.i.b.d.b
            {
                a aVar2 = null;
            }

            @Override // c.i.b.d, c.i.b.e
            public String translateName(Field field) {
                return d.c(field.getName());
            }
        };
        UPPER_CAMEL_CASE = dVar;
        d dVar2 = new d("UPPER_CAMEL_CASE_WITH_SPACES", 2) { // from class: c.i.b.d.c
            {
                a aVar2 = null;
            }

            @Override // c.i.b.d, c.i.b.e
            public String translateName(Field field) {
                return d.c(d.b(field.getName(), " "));
            }
        };
        UPPER_CAMEL_CASE_WITH_SPACES = dVar2;
        d dVar3 = new d("LOWER_CASE_WITH_UNDERSCORES", 3) { // from class: c.i.b.d.d
            {
                a aVar2 = null;
            }

            @Override // c.i.b.d, c.i.b.e
            public String translateName(Field field) {
                return d.b(field.getName(), "_").toLowerCase(Locale.ENGLISH);
            }
        };
        LOWER_CASE_WITH_UNDERSCORES = dVar3;
        d dVar4 = new d("LOWER_CASE_WITH_DASHES", 4) { // from class: c.i.b.d.e
            {
                a aVar2 = null;
            }

            @Override // c.i.b.d, c.i.b.e
            public String translateName(Field field) {
                return d.b(field.getName(), "-").toLowerCase(Locale.ENGLISH);
            }
        };
        LOWER_CASE_WITH_DASHES = dVar4;
        d dVar5 = new d("LOWER_CASE_WITH_DOTS", 5) { // from class: c.i.b.d.f
            {
                a aVar2 = null;
            }

            @Override // c.i.b.d, c.i.b.e
            public String translateName(Field field) {
                return d.b(field.getName(), Consts.DOT).toLowerCase(Locale.ENGLISH);
            }
        };
        LOWER_CASE_WITH_DOTS = dVar5;
        f2588a = new d[]{aVar, dVar, dVar2, dVar3, dVar4, dVar5};
    }

    public d(String str, int i2) {
    }

    public static String a(char c2, String str, int i2) {
        if (i2 >= str.length()) {
            return String.valueOf(c2);
        }
        return c2 + str.substring(i2);
    }

    public static String b(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt = str.charAt(i2);
            if (Character.isUpperCase(cCharAt) && sb.length() != 0) {
                sb.append(str2);
            }
            sb.append(cCharAt);
        }
        return sb.toString();
    }

    public static String c(String str) {
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        char cCharAt = str.charAt(0);
        int length = str.length();
        while (i2 < length - 1 && !Character.isLetter(cCharAt)) {
            sb.append(cCharAt);
            i2++;
            cCharAt = str.charAt(i2);
        }
        if (Character.isUpperCase(cCharAt)) {
            return str;
        }
        sb.append(a(Character.toUpperCase(cCharAt), str, i2 + 1));
        return sb.toString();
    }

    public static d valueOf(String str) {
        return (d) Enum.valueOf(d.class, str);
    }

    public static d[] values() {
        return (d[]) f2588a.clone();
    }

    @Override // c.i.b.e
    public abstract /* synthetic */ String translateName(Field field);

    public /* synthetic */ d(String str, int i2, a aVar) {
        this(str, i2);
    }
}
