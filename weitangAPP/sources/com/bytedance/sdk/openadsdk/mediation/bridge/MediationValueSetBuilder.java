package com.bytedance.sdk.openadsdk.mediation.bridge;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.ValueSet;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class MediationValueSetBuilder {
    private final SparseArray<Object> ok;

    public interface BooleanGetter extends ValueSet.ValueGetter<Boolean> {
    }

    public interface DoubleGetter extends ValueSet.ValueGetter<Double> {
    }

    public interface FloatGetter extends ValueSet.ValueGetter<Float> {
    }

    public interface IntGetter extends ValueSet.ValueGetter<Integer> {
    }

    public interface LongGetter extends ValueSet.ValueGetter<Long> {
    }

    public interface ObjectGetter extends ValueSet.ValueGetter<Object> {
    }

    public interface StringGetter extends ValueSet.ValueGetter<String> {
    }

    public static final class ValueSetImpl implements ValueSet {
        private final SparseArray<Object> ok;

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public <T> T[] arrayValue(int i2, Class<T> cls) {
            Object obj = this.ok.get(i2);
            if (obj == null) {
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
            return this.ok.indexOfKey(i2) >= 0;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public double doubleValue(int i2) {
            Object obj = this.ok.get(i2);
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
            int size = this.ok.size();
            HashSet hashSet = new HashSet();
            for (int i2 = 0; i2 < size; i2++) {
                hashSet.add(Integer.valueOf(i2));
            }
            return hashSet;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public long longValue(int i2) {
            return longValue(i2, 0L);
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public <T> T objectValue(int i2, Class<T> cls) {
            Object obj = this.ok.get(i2);
            if (obj instanceof ValueSet.ValueGetter) {
                obj = ((ValueSet.ValueGetter) obj).get();
            }
            if (cls.isInstance(obj)) {
                return (T) this.ok.get(i2);
            }
            return null;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public int size() {
            SparseArray<Object> sparseArray = this.ok;
            if (sparseArray == null) {
                return 0;
            }
            return sparseArray.size();
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public String stringValue(int i2) {
            return stringValue(i2, null);
        }

        private ValueSetImpl(SparseArray<Object> sparseArray) {
            this.ok = sparseArray;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public boolean booleanValue(int i2, boolean z) {
            Object obj = this.ok.get(i2);
            if (obj instanceof ValueSet.ValueGetter) {
                obj = ((ValueSet.ValueGetter) obj).get();
            }
            return obj instanceof Boolean ? ((Boolean) obj).booleanValue() : z;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public float floatValue(int i2, float f2) {
            Object obj = this.ok.get(i2);
            if (obj instanceof ValueSet.ValueGetter) {
                obj = ((ValueSet.ValueGetter) obj).get();
            }
            return obj instanceof Float ? ((Float) obj).floatValue() : f2;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public int intValue(int i2, int i3) {
            Object obj = this.ok.get(i2);
            if (obj instanceof ValueSet.ValueGetter) {
                obj = ((ValueSet.ValueGetter) obj).get();
            }
            return obj instanceof Integer ? ((Integer) obj).intValue() : i3;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public long longValue(int i2, long j) {
            Object obj = this.ok.get(i2);
            if (obj instanceof ValueSet.ValueGetter) {
                obj = ((ValueSet.ValueGetter) obj).get();
            }
            return obj instanceof Long ? ((Long) obj).longValue() : j;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public String stringValue(int i2, String str) {
            Object obj = this.ok.get(i2);
            return (obj instanceof ValueSet.ValueGetter ? ((ValueSet.ValueGetter) obj).get() : obj) instanceof String ? obj.toString() : str;
        }
    }

    private MediationValueSetBuilder(SparseArray<Object> sparseArray) {
        this.ok = sparseArray;
    }

    public static final MediationValueSetBuilder create() {
        return new MediationValueSetBuilder(new SparseArray());
    }

    public MediationValueSetBuilder add(int i2, Object obj) {
        this.ok.put(i2, obj);
        return this;
    }

    public <T> MediationValueSetBuilder addArray(int i2, T[] tArr) {
        this.ok.put(i2, tArr);
        return this;
    }

    public ValueSet build() {
        return new ValueSetImpl(this.ok);
    }

    public static final MediationValueSetBuilder create(ValueSet valueSet) {
        if (valueSet == null || valueSet.isEmpty()) {
            return new MediationValueSetBuilder(new SparseArray());
        }
        SparseArray sparseArray = new SparseArray();
        for (Integer num : valueSet.keys()) {
            sparseArray.put(num.intValue(), valueSet.objectValue(num.intValue(), Object.class));
        }
        return new MediationValueSetBuilder(sparseArray);
    }

    public MediationValueSetBuilder add(int i2, String str) {
        this.ok.put(i2, str);
        return this;
    }

    public MediationValueSetBuilder add(int i2, int i3) {
        this.ok.put(i2, Integer.valueOf(i3));
        return this;
    }

    public MediationValueSetBuilder add(int i2, double d2) {
        this.ok.put(i2, Double.valueOf(d2));
        return this;
    }

    public MediationValueSetBuilder add(int i2, boolean z) {
        this.ok.put(i2, Boolean.valueOf(z));
        return this;
    }

    public MediationValueSetBuilder add(int i2, long j) {
        this.ok.put(i2, Long.valueOf(j));
        return this;
    }

    public MediationValueSetBuilder add(int i2, float f2) {
        this.ok.put(i2, Float.valueOf(f2));
        return this;
    }

    public MediationValueSetBuilder add(int i2, ObjectGetter objectGetter) {
        this.ok.put(i2, objectGetter);
        return this;
    }

    public MediationValueSetBuilder add(int i2, StringGetter stringGetter) {
        this.ok.put(i2, stringGetter);
        return this;
    }

    public MediationValueSetBuilder add(int i2, DoubleGetter doubleGetter) {
        this.ok.put(i2, doubleGetter);
        return this;
    }

    public MediationValueSetBuilder add(int i2, IntGetter intGetter) {
        this.ok.put(i2, intGetter);
        return this;
    }

    public MediationValueSetBuilder add(int i2, BooleanGetter booleanGetter) {
        this.ok.put(i2, booleanGetter);
        return this;
    }

    public MediationValueSetBuilder add(int i2, LongGetter longGetter) {
        this.ok.put(i2, longGetter);
        return this;
    }

    public MediationValueSetBuilder add(int i2, FloatGetter floatGetter) {
        this.ok.put(i2, floatGetter);
        return this;
    }
}
