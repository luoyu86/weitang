package com.google.gson.internal.bind;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Currency;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

/* JADX INFO: loaded from: classes2.dex */
public final class TypeAdapters {
    public static final c.i.b.v<String> A;
    public static final c.i.b.v<BigDecimal> B;
    public static final c.i.b.v<BigInteger> C;
    public static final c.i.b.w D;
    public static final c.i.b.v<StringBuilder> E;
    public static final c.i.b.w F;
    public static final c.i.b.v<StringBuffer> G;
    public static final c.i.b.w H;
    public static final c.i.b.v<URL> I;
    public static final c.i.b.w J;
    public static final c.i.b.v<URI> K;
    public static final c.i.b.w L;
    public static final c.i.b.v<InetAddress> M;
    public static final c.i.b.w N;
    public static final c.i.b.v<UUID> O;
    public static final c.i.b.w P;
    public static final c.i.b.v<Currency> Q;
    public static final c.i.b.w R;
    public static final c.i.b.w S;
    public static final c.i.b.v<Calendar> T;
    public static final c.i.b.w U;
    public static final c.i.b.v<Locale> V;
    public static final c.i.b.w W;
    public static final c.i.b.v<c.i.b.l> X;
    public static final c.i.b.w Y;
    public static final c.i.b.w Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c.i.b.v<Class> f9042a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c.i.b.w f9043b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final c.i.b.v<BitSet> f9044c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final c.i.b.w f9045d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final c.i.b.v<Boolean> f9046e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final c.i.b.v<Boolean> f9047f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final c.i.b.w f9048g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final c.i.b.v<Number> f9049h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final c.i.b.w f9050i;
    public static final c.i.b.v<Number> j;
    public static final c.i.b.w k;
    public static final c.i.b.v<Number> l;
    public static final c.i.b.w m;
    public static final c.i.b.v<AtomicInteger> n;
    public static final c.i.b.w o;
    public static final c.i.b.v<AtomicBoolean> p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final c.i.b.w f9051q;
    public static final c.i.b.v<AtomicIntegerArray> r;
    public static final c.i.b.w s;
    public static final c.i.b.v<Number> t;
    public static final c.i.b.v<Number> u;
    public static final c.i.b.v<Number> v;
    public static final c.i.b.v<Number> w;
    public static final c.i.b.w x;
    public static final c.i.b.v<Character> y;
    public static final c.i.b.w z;

    public static class a extends c.i.b.v<AtomicIntegerArray> {
        @Override // c.i.b.v
        public AtomicIntegerArray read(c.i.b.a0.a aVar) throws IOException {
            ArrayList arrayList = new ArrayList();
            aVar.beginArray();
            while (aVar.hasNext()) {
                try {
                    arrayList.add(Integer.valueOf(aVar.nextInt()));
                } catch (NumberFormatException e2) {
                    throw new c.i.b.t(e2);
                }
            }
            aVar.endArray();
            int size = arrayList.size();
            AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(size);
            for (int i2 = 0; i2 < size; i2++) {
                atomicIntegerArray.set(i2, ((Integer) arrayList.get(i2)).intValue());
            }
            return atomicIntegerArray;
        }

        @Override // c.i.b.v
        public void write(c.i.b.a0.c cVar, AtomicIntegerArray atomicIntegerArray) throws IOException {
            cVar.beginArray();
            int length = atomicIntegerArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                cVar.value(atomicIntegerArray.get(i2));
            }
            cVar.endArray();
        }
    }

    public static class a0 extends c.i.b.v<Number> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // c.i.b.v
        public Number read(c.i.b.a0.a aVar) throws IOException {
            if (aVar.peek() == c.i.b.a0.b.NULL) {
                aVar.nextNull();
                return null;
            }
            try {
                return Integer.valueOf(aVar.nextInt());
            } catch (NumberFormatException e2) {
                throw new c.i.b.t(e2);
            }
        }

        @Override // c.i.b.v
        public void write(c.i.b.a0.c cVar, Number number) throws IOException {
            cVar.value(number);
        }
    }

    public static class b extends c.i.b.v<Number> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // c.i.b.v
        public Number read(c.i.b.a0.a aVar) throws IOException {
            if (aVar.peek() == c.i.b.a0.b.NULL) {
                aVar.nextNull();
                return null;
            }
            try {
                return Long.valueOf(aVar.nextLong());
            } catch (NumberFormatException e2) {
                throw new c.i.b.t(e2);
            }
        }

        @Override // c.i.b.v
        public void write(c.i.b.a0.c cVar, Number number) throws IOException {
            cVar.value(number);
        }
    }

    public static class b0 extends c.i.b.v<AtomicInteger> {
        @Override // c.i.b.v
        public AtomicInteger read(c.i.b.a0.a aVar) throws IOException {
            try {
                return new AtomicInteger(aVar.nextInt());
            } catch (NumberFormatException e2) {
                throw new c.i.b.t(e2);
            }
        }

        @Override // c.i.b.v
        public void write(c.i.b.a0.c cVar, AtomicInteger atomicInteger) throws IOException {
            cVar.value(atomicInteger.get());
        }
    }

    public static class c extends c.i.b.v<Number> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // c.i.b.v
        public Number read(c.i.b.a0.a aVar) throws IOException {
            if (aVar.peek() != c.i.b.a0.b.NULL) {
                return Float.valueOf((float) aVar.nextDouble());
            }
            aVar.nextNull();
            return null;
        }

        @Override // c.i.b.v
        public void write(c.i.b.a0.c cVar, Number number) throws IOException {
            cVar.value(number);
        }
    }

    public static class c0 extends c.i.b.v<AtomicBoolean> {
        @Override // c.i.b.v
        public AtomicBoolean read(c.i.b.a0.a aVar) throws IOException {
            return new AtomicBoolean(aVar.nextBoolean());
        }

        @Override // c.i.b.v
        public void write(c.i.b.a0.c cVar, AtomicBoolean atomicBoolean) throws IOException {
            cVar.value(atomicBoolean.get());
        }
    }

    public static class d extends c.i.b.v<Number> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // c.i.b.v
        public Number read(c.i.b.a0.a aVar) throws IOException {
            if (aVar.peek() != c.i.b.a0.b.NULL) {
                return Double.valueOf(aVar.nextDouble());
            }
            aVar.nextNull();
            return null;
        }

        @Override // c.i.b.v
        public void write(c.i.b.a0.c cVar, Number number) throws IOException {
            cVar.value(number);
        }
    }

    public static final class d0<T extends Enum<T>> extends c.i.b.v<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map<String, T> f9068a = new HashMap();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Map<T, String> f9069b = new HashMap();

        public d0(Class<T> cls) {
            try {
                for (T t : cls.getEnumConstants()) {
                    String strName = t.name();
                    c.i.b.x.c cVar = (c.i.b.x.c) cls.getField(strName).getAnnotation(c.i.b.x.c.class);
                    if (cVar != null) {
                        strName = cVar.value();
                        for (String str : cVar.alternate()) {
                            this.f9068a.put(str, t);
                        }
                    }
                    this.f9068a.put(strName, t);
                    this.f9069b.put(t, strName);
                }
            } catch (NoSuchFieldException e2) {
                throw new AssertionError(e2);
            }
        }

        @Override // c.i.b.v
        public T read(c.i.b.a0.a aVar) throws IOException {
            if (aVar.peek() != c.i.b.a0.b.NULL) {
                return this.f9068a.get(aVar.nextString());
            }
            aVar.nextNull();
            return null;
        }

        @Override // c.i.b.v
        public void write(c.i.b.a0.c cVar, T t) throws IOException {
            cVar.value(t == null ? null : this.f9069b.get(t));
        }
    }

    public static class e extends c.i.b.v<Number> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // c.i.b.v
        public Number read(c.i.b.a0.a aVar) throws IOException {
            c.i.b.a0.b bVarPeek = aVar.peek();
            int i2 = v.f9070a[bVarPeek.ordinal()];
            if (i2 == 1 || i2 == 3) {
                return new c.i.b.y.f(aVar.nextString());
            }
            if (i2 == 4) {
                aVar.nextNull();
                return null;
            }
            throw new c.i.b.t("Expecting number, got: " + bVarPeek);
        }

        @Override // c.i.b.v
        public void write(c.i.b.a0.c cVar, Number number) throws IOException {
            cVar.value(number);
        }
    }

    public static class f extends c.i.b.v<Character> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // c.i.b.v
        public Character read(c.i.b.a0.a aVar) throws IOException {
            if (aVar.peek() == c.i.b.a0.b.NULL) {
                aVar.nextNull();
                return null;
            }
            String strNextString = aVar.nextString();
            if (strNextString.length() == 1) {
                return Character.valueOf(strNextString.charAt(0));
            }
            throw new c.i.b.t("Expecting character, got: " + strNextString);
        }

        @Override // c.i.b.v
        public void write(c.i.b.a0.c cVar, Character ch) throws IOException {
            cVar.value(ch == null ? null : String.valueOf(ch));
        }
    }

    public static class g extends c.i.b.v<String> {
        @Override // c.i.b.v
        public String read(c.i.b.a0.a aVar) throws IOException {
            c.i.b.a0.b bVarPeek = aVar.peek();
            if (bVarPeek != c.i.b.a0.b.NULL) {
                return bVarPeek == c.i.b.a0.b.BOOLEAN ? Boolean.toString(aVar.nextBoolean()) : aVar.nextString();
            }
            aVar.nextNull();
            return null;
        }

        @Override // c.i.b.v
        public void write(c.i.b.a0.c cVar, String str) throws IOException {
            cVar.value(str);
        }
    }

    public static class h extends c.i.b.v<BigDecimal> {
        @Override // c.i.b.v
        public BigDecimal read(c.i.b.a0.a aVar) throws IOException {
            if (aVar.peek() == c.i.b.a0.b.NULL) {
                aVar.nextNull();
                return null;
            }
            try {
                return new BigDecimal(aVar.nextString());
            } catch (NumberFormatException e2) {
                throw new c.i.b.t(e2);
            }
        }

        @Override // c.i.b.v
        public void write(c.i.b.a0.c cVar, BigDecimal bigDecimal) throws IOException {
            cVar.value(bigDecimal);
        }
    }

    public static class i extends c.i.b.v<BigInteger> {
        @Override // c.i.b.v
        public BigInteger read(c.i.b.a0.a aVar) throws IOException {
            if (aVar.peek() == c.i.b.a0.b.NULL) {
                aVar.nextNull();
                return null;
            }
            try {
                return new BigInteger(aVar.nextString());
            } catch (NumberFormatException e2) {
                throw new c.i.b.t(e2);
            }
        }

        @Override // c.i.b.v
        public void write(c.i.b.a0.c cVar, BigInteger bigInteger) throws IOException {
            cVar.value(bigInteger);
        }
    }

    public static class j extends c.i.b.v<StringBuilder> {
        @Override // c.i.b.v
        public StringBuilder read(c.i.b.a0.a aVar) throws IOException {
            if (aVar.peek() != c.i.b.a0.b.NULL) {
                return new StringBuilder(aVar.nextString());
            }
            aVar.nextNull();
            return null;
        }

        @Override // c.i.b.v
        public void write(c.i.b.a0.c cVar, StringBuilder sb) throws IOException {
            cVar.value(sb == null ? null : sb.toString());
        }
    }

    public static class k extends c.i.b.v<Class> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // c.i.b.v
        public Class read(c.i.b.a0.a aVar) throws IOException {
            throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
        }

        @Override // c.i.b.v
        public void write(c.i.b.a0.c cVar, Class cls) throws IOException {
            throw new UnsupportedOperationException("Attempted to serialize java.lang.Class: " + cls.getName() + ". Forgot to register a type adapter?");
        }
    }

    public static class l extends c.i.b.v<StringBuffer> {
        @Override // c.i.b.v
        public StringBuffer read(c.i.b.a0.a aVar) throws IOException {
            if (aVar.peek() != c.i.b.a0.b.NULL) {
                return new StringBuffer(aVar.nextString());
            }
            aVar.nextNull();
            return null;
        }

        @Override // c.i.b.v
        public void write(c.i.b.a0.c cVar, StringBuffer stringBuffer) throws IOException {
            cVar.value(stringBuffer == null ? null : stringBuffer.toString());
        }
    }

    public static class m extends c.i.b.v<URL> {
        @Override // c.i.b.v
        public URL read(c.i.b.a0.a aVar) throws IOException {
            if (aVar.peek() == c.i.b.a0.b.NULL) {
                aVar.nextNull();
                return null;
            }
            String strNextString = aVar.nextString();
            if ("null".equals(strNextString)) {
                return null;
            }
            return new URL(strNextString);
        }

        @Override // c.i.b.v
        public void write(c.i.b.a0.c cVar, URL url) throws IOException {
            cVar.value(url == null ? null : url.toExternalForm());
        }
    }

    public static class n extends c.i.b.v<URI> {
        @Override // c.i.b.v
        public URI read(c.i.b.a0.a aVar) throws IOException {
            if (aVar.peek() == c.i.b.a0.b.NULL) {
                aVar.nextNull();
                return null;
            }
            try {
                String strNextString = aVar.nextString();
                if ("null".equals(strNextString)) {
                    return null;
                }
                return new URI(strNextString);
            } catch (URISyntaxException e2) {
                throw new c.i.b.m(e2);
            }
        }

        @Override // c.i.b.v
        public void write(c.i.b.a0.c cVar, URI uri) throws IOException {
            cVar.value(uri == null ? null : uri.toASCIIString());
        }
    }

    public static class o extends c.i.b.v<InetAddress> {
        @Override // c.i.b.v
        public InetAddress read(c.i.b.a0.a aVar) throws IOException {
            if (aVar.peek() != c.i.b.a0.b.NULL) {
                return InetAddress.getByName(aVar.nextString());
            }
            aVar.nextNull();
            return null;
        }

        @Override // c.i.b.v
        public void write(c.i.b.a0.c cVar, InetAddress inetAddress) throws IOException {
            cVar.value(inetAddress == null ? null : inetAddress.getHostAddress());
        }
    }

    public static class p extends c.i.b.v<UUID> {
        @Override // c.i.b.v
        public UUID read(c.i.b.a0.a aVar) throws IOException {
            if (aVar.peek() != c.i.b.a0.b.NULL) {
                return UUID.fromString(aVar.nextString());
            }
            aVar.nextNull();
            return null;
        }

        @Override // c.i.b.v
        public void write(c.i.b.a0.c cVar, UUID uuid) throws IOException {
            cVar.value(uuid == null ? null : uuid.toString());
        }
    }

    public static class q extends c.i.b.v<Currency> {
        @Override // c.i.b.v
        public Currency read(c.i.b.a0.a aVar) throws IOException {
            return Currency.getInstance(aVar.nextString());
        }

        @Override // c.i.b.v
        public void write(c.i.b.a0.c cVar, Currency currency) throws IOException {
            cVar.value(currency.getCurrencyCode());
        }
    }

    public static class r extends c.i.b.v<Calendar> {
        @Override // c.i.b.v
        public Calendar read(c.i.b.a0.a aVar) throws IOException {
            if (aVar.peek() == c.i.b.a0.b.NULL) {
                aVar.nextNull();
                return null;
            }
            aVar.beginObject();
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            int i7 = 0;
            while (aVar.peek() != c.i.b.a0.b.END_OBJECT) {
                String strNextName = aVar.nextName();
                int iNextInt = aVar.nextInt();
                if ("year".equals(strNextName)) {
                    i2 = iNextInt;
                } else if ("month".equals(strNextName)) {
                    i3 = iNextInt;
                } else if ("dayOfMonth".equals(strNextName)) {
                    i4 = iNextInt;
                } else if ("hourOfDay".equals(strNextName)) {
                    i5 = iNextInt;
                } else if ("minute".equals(strNextName)) {
                    i6 = iNextInt;
                } else if ("second".equals(strNextName)) {
                    i7 = iNextInt;
                }
            }
            aVar.endObject();
            return new GregorianCalendar(i2, i3, i4, i5, i6, i7);
        }

        @Override // c.i.b.v
        public void write(c.i.b.a0.c cVar, Calendar calendar) throws IOException {
            if (calendar == null) {
                cVar.nullValue();
                return;
            }
            cVar.beginObject();
            cVar.name("year");
            cVar.value(calendar.get(1));
            cVar.name("month");
            cVar.value(calendar.get(2));
            cVar.name("dayOfMonth");
            cVar.value(calendar.get(5));
            cVar.name("hourOfDay");
            cVar.value(calendar.get(11));
            cVar.name("minute");
            cVar.value(calendar.get(12));
            cVar.name("second");
            cVar.value(calendar.get(13));
            cVar.endObject();
        }
    }

    public static class s extends c.i.b.v<Locale> {
        @Override // c.i.b.v
        public Locale read(c.i.b.a0.a aVar) throws IOException {
            if (aVar.peek() == c.i.b.a0.b.NULL) {
                aVar.nextNull();
                return null;
            }
            StringTokenizer stringTokenizer = new StringTokenizer(aVar.nextString(), "_");
            String strNextToken = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            String strNextToken2 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            String strNextToken3 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            return (strNextToken2 == null && strNextToken3 == null) ? new Locale(strNextToken) : strNextToken3 == null ? new Locale(strNextToken, strNextToken2) : new Locale(strNextToken, strNextToken2, strNextToken3);
        }

        @Override // c.i.b.v
        public void write(c.i.b.a0.c cVar, Locale locale) throws IOException {
            cVar.value(locale == null ? null : locale.toString());
        }
    }

    public static class t extends c.i.b.v<c.i.b.l> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // c.i.b.v
        public c.i.b.l read(c.i.b.a0.a aVar) throws IOException {
            switch (v.f9070a[aVar.peek().ordinal()]) {
                case 1:
                    return new c.i.b.q((Number) new c.i.b.y.f(aVar.nextString()));
                case 2:
                    return new c.i.b.q(Boolean.valueOf(aVar.nextBoolean()));
                case 3:
                    return new c.i.b.q(aVar.nextString());
                case 4:
                    aVar.nextNull();
                    return c.i.b.n.f2614a;
                case 5:
                    c.i.b.i iVar = new c.i.b.i();
                    aVar.beginArray();
                    while (aVar.hasNext()) {
                        iVar.add(read(aVar));
                    }
                    aVar.endArray();
                    return iVar;
                case 6:
                    c.i.b.o oVar = new c.i.b.o();
                    aVar.beginObject();
                    while (aVar.hasNext()) {
                        oVar.add(aVar.nextName(), read(aVar));
                    }
                    aVar.endObject();
                    return oVar;
                default:
                    throw new IllegalArgumentException();
            }
        }

        @Override // c.i.b.v
        public void write(c.i.b.a0.c cVar, c.i.b.l lVar) throws IOException {
            if (lVar == null || lVar.isJsonNull()) {
                cVar.nullValue();
                return;
            }
            if (lVar.isJsonPrimitive()) {
                c.i.b.q asJsonPrimitive = lVar.getAsJsonPrimitive();
                if (asJsonPrimitive.isNumber()) {
                    cVar.value(asJsonPrimitive.getAsNumber());
                    return;
                } else if (asJsonPrimitive.isBoolean()) {
                    cVar.value(asJsonPrimitive.getAsBoolean());
                    return;
                } else {
                    cVar.value(asJsonPrimitive.getAsString());
                    return;
                }
            }
            if (lVar.isJsonArray()) {
                cVar.beginArray();
                Iterator<c.i.b.l> it = lVar.getAsJsonArray().iterator();
                while (it.hasNext()) {
                    write(cVar, it.next());
                }
                cVar.endArray();
                return;
            }
            if (!lVar.isJsonObject()) {
                throw new IllegalArgumentException("Couldn't write " + lVar.getClass());
            }
            cVar.beginObject();
            for (Map.Entry<String, c.i.b.l> entry : lVar.getAsJsonObject().entrySet()) {
                cVar.name(entry.getKey());
                write(cVar, entry.getValue());
            }
            cVar.endObject();
        }
    }

    public static class u extends c.i.b.v<BitSet> {
        /* JADX WARN: Removed duplicated region for block: B:15:0x002e  */
        @Override // c.i.b.v
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.util.BitSet read(c.i.b.a0.a r8) throws java.io.IOException {
            /*
                r7 = this;
                java.util.BitSet r0 = new java.util.BitSet
                r0.<init>()
                r8.beginArray()
                c.i.b.a0.b r1 = r8.peek()
                r2 = 0
                r3 = 0
            Le:
                c.i.b.a0.b r4 = c.i.b.a0.b.END_ARRAY
                if (r1 == r4) goto L75
                int[] r4 = com.google.gson.internal.bind.TypeAdapters.v.f9070a
                int r5 = r1.ordinal()
                r4 = r4[r5]
                r5 = 1
                if (r4 == r5) goto L63
                r6 = 2
                if (r4 == r6) goto L5e
                r6 = 3
                if (r4 != r6) goto L47
                java.lang.String r1 = r8.nextString()
                int r1 = java.lang.Integer.parseInt(r1)     // Catch: java.lang.NumberFormatException -> L30
                if (r1 == 0) goto L2e
                goto L69
            L2e:
                r5 = 0
                goto L69
            L30:
                c.i.b.t r8 = new c.i.b.t
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r2 = "Error: Expecting: bitset number value (1, 0), Found: "
                r0.append(r2)
                r0.append(r1)
                java.lang.String r0 = r0.toString()
                r8.<init>(r0)
                throw r8
            L47:
                c.i.b.t r8 = new c.i.b.t
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r2 = "Invalid bitset value type: "
                r0.append(r2)
                r0.append(r1)
                java.lang.String r0 = r0.toString()
                r8.<init>(r0)
                throw r8
            L5e:
                boolean r5 = r8.nextBoolean()
                goto L69
            L63:
                int r1 = r8.nextInt()
                if (r1 == 0) goto L2e
            L69:
                if (r5 == 0) goto L6e
                r0.set(r3)
            L6e:
                int r3 = r3 + 1
                c.i.b.a0.b r1 = r8.peek()
                goto Le
            L75:
                r8.endArray()
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.bind.TypeAdapters.u.read(c.i.b.a0.a):java.util.BitSet");
        }

        @Override // c.i.b.v
        public void write(c.i.b.a0.c cVar, BitSet bitSet) throws IOException {
            cVar.beginArray();
            int length = bitSet.length();
            for (int i2 = 0; i2 < length; i2++) {
                cVar.value(bitSet.get(i2) ? 1L : 0L);
            }
            cVar.endArray();
        }
    }

    public static /* synthetic */ class v {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f9070a;

        static {
            int[] iArr = new int[c.i.b.a0.b.values().length];
            f9070a = iArr;
            try {
                iArr[c.i.b.a0.b.NUMBER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f9070a[c.i.b.a0.b.BOOLEAN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f9070a[c.i.b.a0.b.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f9070a[c.i.b.a0.b.NULL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f9070a[c.i.b.a0.b.BEGIN_ARRAY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f9070a[c.i.b.a0.b.BEGIN_OBJECT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f9070a[c.i.b.a0.b.END_DOCUMENT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f9070a[c.i.b.a0.b.NAME.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f9070a[c.i.b.a0.b.END_OBJECT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f9070a[c.i.b.a0.b.END_ARRAY.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    public static class w extends c.i.b.v<Boolean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // c.i.b.v
        public Boolean read(c.i.b.a0.a aVar) throws IOException {
            c.i.b.a0.b bVarPeek = aVar.peek();
            if (bVarPeek != c.i.b.a0.b.NULL) {
                return bVarPeek == c.i.b.a0.b.STRING ? Boolean.valueOf(Boolean.parseBoolean(aVar.nextString())) : Boolean.valueOf(aVar.nextBoolean());
            }
            aVar.nextNull();
            return null;
        }

        @Override // c.i.b.v
        public void write(c.i.b.a0.c cVar, Boolean bool) throws IOException {
            cVar.value(bool);
        }
    }

    public static class x extends c.i.b.v<Boolean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // c.i.b.v
        public Boolean read(c.i.b.a0.a aVar) throws IOException {
            if (aVar.peek() != c.i.b.a0.b.NULL) {
                return Boolean.valueOf(aVar.nextString());
            }
            aVar.nextNull();
            return null;
        }

        @Override // c.i.b.v
        public void write(c.i.b.a0.c cVar, Boolean bool) throws IOException {
            cVar.value(bool == null ? "null" : bool.toString());
        }
    }

    public static class y extends c.i.b.v<Number> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // c.i.b.v
        public Number read(c.i.b.a0.a aVar) throws IOException {
            if (aVar.peek() == c.i.b.a0.b.NULL) {
                aVar.nextNull();
                return null;
            }
            try {
                return Byte.valueOf((byte) aVar.nextInt());
            } catch (NumberFormatException e2) {
                throw new c.i.b.t(e2);
            }
        }

        @Override // c.i.b.v
        public void write(c.i.b.a0.c cVar, Number number) throws IOException {
            cVar.value(number);
        }
    }

    public static class z extends c.i.b.v<Number> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // c.i.b.v
        public Number read(c.i.b.a0.a aVar) throws IOException {
            if (aVar.peek() == c.i.b.a0.b.NULL) {
                aVar.nextNull();
                return null;
            }
            try {
                return Short.valueOf((short) aVar.nextInt());
            } catch (NumberFormatException e2) {
                throw new c.i.b.t(e2);
            }
        }

        @Override // c.i.b.v
        public void write(c.i.b.a0.c cVar, Number number) throws IOException {
            cVar.value(number);
        }
    }

    static {
        c.i.b.v<Class> vVarNullSafe = new k().nullSafe();
        f9042a = vVarNullSafe;
        f9043b = newFactory(Class.class, vVarNullSafe);
        c.i.b.v<BitSet> vVarNullSafe2 = new u().nullSafe();
        f9044c = vVarNullSafe2;
        f9045d = newFactory(BitSet.class, vVarNullSafe2);
        w wVar = new w();
        f9046e = wVar;
        f9047f = new x();
        f9048g = newFactory(Boolean.TYPE, Boolean.class, wVar);
        y yVar = new y();
        f9049h = yVar;
        f9050i = newFactory(Byte.TYPE, Byte.class, yVar);
        z zVar = new z();
        j = zVar;
        k = newFactory(Short.TYPE, Short.class, zVar);
        a0 a0Var = new a0();
        l = a0Var;
        m = newFactory(Integer.TYPE, Integer.class, a0Var);
        c.i.b.v<AtomicInteger> vVarNullSafe3 = new b0().nullSafe();
        n = vVarNullSafe3;
        o = newFactory(AtomicInteger.class, vVarNullSafe3);
        c.i.b.v<AtomicBoolean> vVarNullSafe4 = new c0().nullSafe();
        p = vVarNullSafe4;
        f9051q = newFactory(AtomicBoolean.class, vVarNullSafe4);
        c.i.b.v<AtomicIntegerArray> vVarNullSafe5 = new a().nullSafe();
        r = vVarNullSafe5;
        s = newFactory(AtomicIntegerArray.class, vVarNullSafe5);
        t = new b();
        u = new c();
        v = new d();
        e eVar = new e();
        w = eVar;
        x = newFactory(Number.class, eVar);
        f fVar = new f();
        y = fVar;
        z = newFactory(Character.TYPE, Character.class, fVar);
        g gVar = new g();
        A = gVar;
        B = new h();
        C = new i();
        D = newFactory(String.class, gVar);
        j jVar = new j();
        E = jVar;
        F = newFactory(StringBuilder.class, jVar);
        l lVar = new l();
        G = lVar;
        H = newFactory(StringBuffer.class, lVar);
        m mVar = new m();
        I = mVar;
        J = newFactory(URL.class, mVar);
        n nVar = new n();
        K = nVar;
        L = newFactory(URI.class, nVar);
        o oVar = new o();
        M = oVar;
        N = newTypeHierarchyFactory(InetAddress.class, oVar);
        p pVar = new p();
        O = pVar;
        P = newFactory(UUID.class, pVar);
        c.i.b.v<Currency> vVarNullSafe6 = new q().nullSafe();
        Q = vVarNullSafe6;
        R = newFactory(Currency.class, vVarNullSafe6);
        S = new c.i.b.w() { // from class: com.google.gson.internal.bind.TypeAdapters.26

            /* JADX INFO: renamed from: com.google.gson.internal.bind.TypeAdapters$26$a */
            public class a extends c.i.b.v<Timestamp> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ c.i.b.v f9052a;

                public a(c.i.b.v vVar) {
                    this.f9052a = vVar;
                }

                @Override // c.i.b.v
                public Timestamp read(c.i.b.a0.a aVar) throws IOException {
                    Date date = (Date) this.f9052a.read(aVar);
                    if (date != null) {
                        return new Timestamp(date.getTime());
                    }
                    return null;
                }

                @Override // c.i.b.v
                public void write(c.i.b.a0.c cVar, Timestamp timestamp) throws IOException {
                    this.f9052a.write(cVar, timestamp);
                }
            }

            @Override // c.i.b.w
            public <T> c.i.b.v<T> create(c.i.b.f fVar2, c.i.b.z.a<T> aVar) {
                if (aVar.getRawType() != Timestamp.class) {
                    return null;
                }
                return new a(fVar2.getAdapter(Date.class));
            }
        };
        r rVar = new r();
        T = rVar;
        U = newFactoryForMultipleTypes(Calendar.class, GregorianCalendar.class, rVar);
        s sVar = new s();
        V = sVar;
        W = newFactory(Locale.class, sVar);
        t tVar = new t();
        X = tVar;
        Y = newTypeHierarchyFactory(c.i.b.l.class, tVar);
        Z = new c.i.b.w() { // from class: com.google.gson.internal.bind.TypeAdapters.30
            @Override // c.i.b.w
            public <T> c.i.b.v<T> create(c.i.b.f fVar2, c.i.b.z.a<T> aVar) {
                Class<? super T> rawType = aVar.getRawType();
                if (!Enum.class.isAssignableFrom(rawType) || rawType == Enum.class) {
                    return null;
                }
                if (!rawType.isEnum()) {
                    rawType = rawType.getSuperclass();
                }
                return new d0(rawType);
            }
        };
    }

    public static <TT> c.i.b.w newFactory(final c.i.b.z.a<TT> aVar, final c.i.b.v<TT> vVar) {
        return new c.i.b.w() { // from class: com.google.gson.internal.bind.TypeAdapters.31
            @Override // c.i.b.w
            public <T> c.i.b.v<T> create(c.i.b.f fVar, c.i.b.z.a<T> aVar2) {
                if (aVar2.equals(aVar)) {
                    return vVar;
                }
                return null;
            }
        };
    }

    public static <TT> c.i.b.w newFactoryForMultipleTypes(final Class<TT> cls, final Class<? extends TT> cls2, final c.i.b.v<? super TT> vVar) {
        return new c.i.b.w() { // from class: com.google.gson.internal.bind.TypeAdapters.34
            @Override // c.i.b.w
            public <T> c.i.b.v<T> create(c.i.b.f fVar, c.i.b.z.a<T> aVar) {
                Class<? super T> rawType = aVar.getRawType();
                if (rawType == cls || rawType == cls2) {
                    return vVar;
                }
                return null;
            }

            public String toString() {
                return "Factory[type=" + cls.getName() + "+" + cls2.getName() + ",adapter=" + vVar + "]";
            }
        };
    }

    public static <T1> c.i.b.w newTypeHierarchyFactory(final Class<T1> cls, final c.i.b.v<T1> vVar) {
        return new c.i.b.w() { // from class: com.google.gson.internal.bind.TypeAdapters.35

            /* JADX INFO: Add missing generic type declarations: [T1] */
            /* JADX INFO: renamed from: com.google.gson.internal.bind.TypeAdapters$35$a */
            public class a<T1> extends c.i.b.v<T1> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ Class f9066a;

                public a(Class cls) {
                    this.f9066a = cls;
                }

                @Override // c.i.b.v
                public T1 read(c.i.b.a0.a aVar) throws IOException {
                    T1 t1 = (T1) vVar.read(aVar);
                    if (t1 == null || this.f9066a.isInstance(t1)) {
                        return t1;
                    }
                    throw new c.i.b.t("Expected a " + this.f9066a.getName() + " but was " + t1.getClass().getName());
                }

                @Override // c.i.b.v
                public void write(c.i.b.a0.c cVar, T1 t1) throws IOException {
                    vVar.write(cVar, t1);
                }
            }

            @Override // c.i.b.w
            public <T2> c.i.b.v<T2> create(c.i.b.f fVar, c.i.b.z.a<T2> aVar) {
                Class<? super T2> rawType = aVar.getRawType();
                if (cls.isAssignableFrom(rawType)) {
                    return new a(rawType);
                }
                return null;
            }

            public String toString() {
                return "Factory[typeHierarchy=" + cls.getName() + ",adapter=" + vVar + "]";
            }
        };
    }

    public static <TT> c.i.b.w newFactory(final Class<TT> cls, final c.i.b.v<TT> vVar) {
        return new c.i.b.w() { // from class: com.google.gson.internal.bind.TypeAdapters.32
            @Override // c.i.b.w
            public <T> c.i.b.v<T> create(c.i.b.f fVar, c.i.b.z.a<T> aVar) {
                if (aVar.getRawType() == cls) {
                    return vVar;
                }
                return null;
            }

            public String toString() {
                return "Factory[type=" + cls.getName() + ",adapter=" + vVar + "]";
            }
        };
    }

    public static <TT> c.i.b.w newFactory(final Class<TT> cls, final Class<TT> cls2, final c.i.b.v<? super TT> vVar) {
        return new c.i.b.w() { // from class: com.google.gson.internal.bind.TypeAdapters.33
            @Override // c.i.b.w
            public <T> c.i.b.v<T> create(c.i.b.f fVar, c.i.b.z.a<T> aVar) {
                Class<? super T> rawType = aVar.getRawType();
                if (rawType == cls || rawType == cls2) {
                    return vVar;
                }
                return null;
            }

            public String toString() {
                return "Factory[type=" + cls2.getName() + "+" + cls.getName() + ",adapter=" + vVar + "]";
            }
        };
    }
}
