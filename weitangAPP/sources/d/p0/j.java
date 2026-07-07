package d.p0;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface j {

    public static final class a {
        public static b getDestructured(j jVar) {
            return new b(jVar);
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final j f12918a;

        public b(j jVar) {
            d.k0.d.t.checkNotNullParameter(jVar, "match");
            this.f12918a = jVar;
        }

        public final j getMatch() {
            return this.f12918a;
        }

        public final List<String> toList() {
            return this.f12918a.getGroupValues().subList(1, this.f12918a.getGroupValues().size());
        }
    }

    b getDestructured();

    List<String> getGroupValues();

    i getGroups();

    d.m0.k getRange();

    String getValue();

    j next();
}
