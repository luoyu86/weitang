package c.i.b;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes2.dex */
public abstract class u {
    public static final u DEFAULT;
    public static final u STRING;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ u[] f2618a;

    public enum a extends u {
        public a(String str, int i2) {
            super(str, i2, null);
        }

        @Override // c.i.b.u
        public l serialize(Long l) {
            return new q((Number) l);
        }
    }

    static {
        a aVar = new a("DEFAULT", 0);
        DEFAULT = aVar;
        u uVar = new u("STRING", 1) { // from class: c.i.b.u.b
            {
                a aVar2 = null;
            }

            @Override // c.i.b.u
            public l serialize(Long l) {
                return new q(String.valueOf(l));
            }
        };
        STRING = uVar;
        f2618a = new u[]{aVar, uVar};
    }

    public u(String str, int i2) {
    }

    public static u valueOf(String str) {
        return (u) Enum.valueOf(u.class, str);
    }

    public static u[] values() {
        return (u[]) f2618a.clone();
    }

    public abstract l serialize(Long l);

    public /* synthetic */ u(String str, int i2, a aVar) {
        this(str, i2);
    }
}
