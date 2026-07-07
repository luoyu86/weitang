package d.p0;

import com.chinavisionary.microtang.comment.vo.ScoresBean;
import d.p0.j;
import java.util.Iterator;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;

/* JADX INFO: loaded from: classes2.dex */
public final class k implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i f12919a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<String> f12920b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Matcher f12921c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CharSequence f12922d;

    public static final class a extends d.g0.d<String> {
        public a() {
        }

        @Override // d.g0.a, java.util.Collection
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof String) {
                return contains((String) obj);
            }
            return false;
        }

        @Override // d.g0.d, d.g0.a
        public int getSize() {
            return k.this.a().groupCount() + 1;
        }

        @Override // d.g0.d, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof String) {
                return indexOf((String) obj);
            }
            return -1;
        }

        @Override // d.g0.d, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof String) {
                return lastIndexOf((String) obj);
            }
            return -1;
        }

        public /* bridge */ boolean contains(String str) {
            return super.contains((Object) str);
        }

        @Override // d.g0.d, java.util.List
        public String get(int i2) {
            String strGroup = k.this.a().group(i2);
            return strGroup != null ? strGroup : "";
        }

        public /* bridge */ int indexOf(String str) {
            return super.indexOf((Object) str);
        }

        public /* bridge */ int lastIndexOf(String str) {
            return super.lastIndexOf((Object) str);
        }
    }

    public static final class b extends d.g0.a<h> implements i {

        public static final class a extends d.k0.d.u implements d.k0.c.l<Integer, h> {
            public a() {
                super(1);
            }

            @Override // d.k0.c.l
            public /* bridge */ /* synthetic */ h invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final h invoke(int i2) {
                return b.this.get(i2);
            }
        }

        public b() {
        }

        @Override // d.g0.a, java.util.Collection
        public final /* bridge */ boolean contains(Object obj) {
            if (obj != null ? obj instanceof h : true) {
                return contains((h) obj);
            }
            return false;
        }

        @Override // d.p0.i
        public h get(int i2) {
            d.m0.k kVarE = m.e(k.this.a(), i2);
            if (kVarE.getStart().intValue() < 0) {
                return null;
            }
            String strGroup = k.this.a().group(i2);
            d.k0.d.t.checkNotNullExpressionValue(strGroup, "matchResult.group(index)");
            return new h(strGroup, kVarE);
        }

        @Override // d.g0.a
        public int getSize() {
            return k.this.a().groupCount() + 1;
        }

        @Override // d.g0.a, java.util.Collection
        public boolean isEmpty() {
            return false;
        }

        @Override // d.g0.a, java.util.Collection, java.lang.Iterable
        public Iterator<h> iterator() {
            return d.o0.t.map(d.g0.a0.asSequence(d.g0.s.getIndices(this)), new a()).iterator();
        }

        public /* bridge */ boolean contains(h hVar) {
            return super.contains((Object) hVar);
        }

        public h get(String str) {
            d.k0.d.t.checkNotNullParameter(str, "name");
            return d.j0.b.f12610a.getMatchResultNamedGroup(k.this.a(), str);
        }
    }

    public k(Matcher matcher, CharSequence charSequence) {
        d.k0.d.t.checkNotNullParameter(matcher, "matcher");
        d.k0.d.t.checkNotNullParameter(charSequence, ScoresBean.SCORE_TYPE_INPUT);
        this.f12921c = matcher;
        this.f12922d = charSequence;
        this.f12919a = new b();
    }

    public final MatchResult a() {
        return this.f12921c;
    }

    @Override // d.p0.j
    public j.b getDestructured() {
        return j.a.getDestructured(this);
    }

    @Override // d.p0.j
    public List<String> getGroupValues() {
        if (this.f12920b == null) {
            this.f12920b = new a();
        }
        List<String> list = this.f12920b;
        d.k0.d.t.checkNotNull(list);
        return list;
    }

    @Override // d.p0.j
    public i getGroups() {
        return this.f12919a;
    }

    @Override // d.p0.j
    public d.m0.k getRange() {
        return m.d(a());
    }

    @Override // d.p0.j
    public String getValue() {
        String strGroup = a().group();
        d.k0.d.t.checkNotNullExpressionValue(strGroup, "matchResult.group()");
        return strGroup;
    }

    @Override // d.p0.j
    public j next() {
        int iEnd = a().end() + (a().end() == a().start() ? 1 : 0);
        if (iEnd > this.f12922d.length()) {
            return null;
        }
        Matcher matcher = this.f12921c.pattern().matcher(this.f12922d);
        d.k0.d.t.checkNotNullExpressionValue(matcher, "matcher.pattern().matcher(input)");
        return m.a(matcher, iEnd, this.f12922d);
    }
}
