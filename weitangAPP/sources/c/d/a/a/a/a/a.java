package c.d.a.a.a.a;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ValueSet f918a = ok(0).a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Bridge f919b = new c();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SparseArray<Object> f920c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ValueSet f921d;

    public static final class b implements ValueSet {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final SparseArray<Object> f922a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ValueSet f923b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f924c;

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public <T> T[] arrayValue(int i2, Class<T> cls) {
            Object obj = this.f922a.get(i2);
            if (obj == null) {
                ValueSet valueSet = this.f923b;
                if (valueSet != null) {
                    return (T[]) valueSet.arrayValue(i2, cls);
                }
                return null;
            }
            Class<?> cls2 = obj.getClass();
            if (cls2.isArray() && cls.isAssignableFrom(cls2.getComponentType())) {
                return (T[]) ((Object[]) obj);
            }
            return null;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public boolean booleanValue(int i2) {
            return booleanValue(i2, false);
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public boolean containsKey(int i2) {
            ValueSet valueSet;
            int iIndexOfKey = this.f922a.indexOfKey(i2);
            return (iIndexOfKey >= 0 || (valueSet = this.f923b) == null) ? iIndexOfKey >= 0 : valueSet.containsKey(i2);
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public double doubleValue(int i2) {
            ValueSet valueSet;
            Object obj = this.f922a.get(i2);
            if (obj == null && (valueSet = this.f923b) != null) {
                return valueSet.doubleValue(i2);
            }
            if (obj instanceof ValueSet.ValueGetter) {
                obj = ((ValueSet.ValueGetter) obj).get();
            }
            if (obj instanceof Double) {
                return ((Double) obj).doubleValue();
            }
            return 0.0d;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public float floatValue(int i2) {
            return floatValue(i2, 0.0f);
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public int intValue(int i2) {
            return intValue(i2, 0);
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public boolean isEmpty() {
            return size() <= 0;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public Set<Integer> keys() {
            int size = this.f922a.size();
            HashSet hashSet = new HashSet();
            for (int i2 = 0; i2 < size; i2++) {
                hashSet.add(Integer.valueOf(this.f922a.keyAt(i2)));
            }
            ValueSet valueSet = this.f923b;
            if (valueSet != null) {
                hashSet.addAll(valueSet.keys());
            }
            this.f924c = hashSet.size();
            return hashSet;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public long longValue(int i2) {
            return longValue(i2, 0L);
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public <T> T objectValue(int i2, Class<T> cls) {
            Object obj = this.f922a.get(i2);
            if (obj == null) {
                ValueSet valueSet = this.f923b;
                if (valueSet != null) {
                    return (T) valueSet.objectValue(i2, cls);
                }
                return null;
            }
            if (obj instanceof ValueSet.ValueGetter) {
                obj = ((ValueSet.ValueGetter) obj).get();
            }
            if (cls.isInstance(obj)) {
                return (T) obj;
            }
            return null;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public int size() {
            if (this.f924c < 0) {
                keys();
            }
            return this.f924c;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public String stringValue(int i2) {
            return stringValue(i2, null);
        }

        public b(SparseArray<Object> sparseArray, ValueSet valueSet) {
            this.f924c = -1;
            this.f922a = sparseArray;
            this.f923b = valueSet;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public boolean booleanValue(int i2, boolean z) {
            ValueSet valueSet;
            Object obj = this.f922a.get(i2);
            if (obj == null && (valueSet = this.f923b) != null) {
                return valueSet.booleanValue(i2, z);
            }
            if (obj instanceof ValueSet.ValueGetter) {
                obj = ((ValueSet.ValueGetter) obj).get();
            }
            return obj instanceof Boolean ? ((Boolean) obj).booleanValue() : z;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public float floatValue(int i2, float f2) {
            ValueSet valueSet;
            Object obj = this.f922a.get(i2);
            if (obj == null && (valueSet = this.f923b) != null) {
                return valueSet.floatValue(i2, f2);
            }
            if (obj instanceof ValueSet.ValueGetter) {
                obj = ((ValueSet.ValueGetter) obj).get();
            }
            return obj instanceof Float ? ((Float) obj).floatValue() : f2;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public int intValue(int i2, int i3) {
            ValueSet valueSet;
            Object obj = this.f922a.get(i2);
            if (obj == null && (valueSet = this.f923b) != null) {
                return valueSet.intValue(i2, i3);
            }
            if (obj instanceof ValueSet.ValueGetter) {
                obj = ((ValueSet.ValueGetter) obj).get();
            }
            return obj instanceof Integer ? ((Integer) obj).intValue() : i3;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public long longValue(int i2, long j) {
            ValueSet valueSet;
            Object obj = this.f922a.get(i2);
            if (obj == null && (valueSet = this.f923b) != null) {
                return valueSet.longValue(i2, j);
            }
            if (obj instanceof ValueSet.ValueGetter) {
                obj = ((ValueSet.ValueGetter) obj).get();
            }
            return obj instanceof Long ? ((Long) obj).longValue() : j;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public String stringValue(int i2, String str) {
            ValueSet valueSet;
            Object obj = this.f922a.get(i2);
            if (obj != null || (valueSet = this.f923b) == null) {
                return (obj instanceof ValueSet.ValueGetter ? ((ValueSet.ValueGetter) obj).get() : obj) instanceof String ? obj.toString() : str;
            }
            return valueSet.stringValue(i2, str);
        }
    }

    public static final class c implements Bridge {
        public c() {
        }

        @Override // com.bykv.vk.openvk.api.proto.Caller
        public <T> T call(int i2, ValueSet valueSet, Class<T> cls) {
            if (cls == Boolean.class) {
                return (T) Boolean.FALSE;
            }
            if (cls == Integer.TYPE || cls == Integer.class) {
                return (T) new Integer(0);
            }
            if (cls == Long.TYPE || cls == Long.class) {
                return (T) new Long(0L);
            }
            if (cls == Double.TYPE || cls == Double.class) {
                return (T) new Double(0.0d);
            }
            if (cls == Float.TYPE || cls == Float.class) {
                return (T) new Float(0.0f);
            }
            return null;
        }

        @Override // com.bykv.vk.openvk.api.proto.Bridge
        public ValueSet values() {
            return a.f918a;
        }
    }

    public a(SparseArray<Object> sparseArray, ValueSet valueSet) {
        this.f920c = sparseArray;
        this.f921d = valueSet;
    }

    public static final a ok() {
        return new a(new SparseArray());
    }

    public ValueSet a() {
        return new b(this.f920c, this.f921d);
    }

    public static final a ok(int i2) {
        return new a(new SparseArray(i2));
    }

    public static final a ok(ValueSet valueSet) {
        return new a(new SparseArray(), valueSet);
    }

    public a(SparseArray<Object> sparseArray) {
        this.f920c = sparseArray;
    }

    public a ok(int i2, Object obj) {
        this.f920c.put(i2, obj);
        return this;
    }

    public a ok(int i2, String str) {
        this.f920c.put(i2, str);
        return this;
    }

    public a ok(int i2, int i3) {
        this.f920c.put(i2, Integer.valueOf(i3));
        return this;
    }

    public a ok(int i2, double d2) {
        this.f920c.put(i2, Double.valueOf(d2));
        return this;
    }

    public a ok(int i2, boolean z) {
        this.f920c.put(i2, Boolean.valueOf(z));
        return this;
    }

    public a ok(int i2, long j) {
        this.f920c.put(i2, Long.valueOf(j));
        return this;
    }

    public a ok(int i2, float f2) {
        this.f920c.put(i2, Float.valueOf(f2));
        return this;
    }
}
