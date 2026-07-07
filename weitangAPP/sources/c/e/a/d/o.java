package c.e.a.d;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class o {
    public static <T> T getFirstElement(List<T> list) {
        if (isNotEmpty(list)) {
            return list.get(0);
        }
        return null;
    }

    public static <T> T getListDataToPosition(List<T> list, int i2) {
        if (!isNotEmpty(list) || list.size() <= i2) {
            return null;
        }
        return list.get(i2);
    }

    public static boolean isNotEmpty(List list) {
        return !listIsEmpty(list);
    }

    public static <T> T lastElement(List<T> list) {
        if (isNotEmpty(list)) {
            return list.get(list.size() - 1);
        }
        return null;
    }

    public static boolean listIsEmpty(List list) {
        return list == null || list.isEmpty();
    }
}
