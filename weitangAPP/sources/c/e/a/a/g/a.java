package c.e.a.a.g;

import android.app.Activity;
import android.content.Context;
import c.e.a.d.q;
import java.util.Stack;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Stack<Activity> f1003a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile a f1004b;

    public a() {
        if (f1003a == null) {
            f1003a = new Stack<>();
        }
    }

    public static a getAppManager() {
        if (f1004b == null) {
            synchronized (a.class) {
                if (f1004b == null) {
                    f1004b = new a();
                }
            }
        }
        return f1004b;
    }

    public void AppExit(Context context) {
        try {
            finishAllActivity();
            System.exit(0);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void addActivity(Activity activity) {
        if (f1003a == null) {
            f1003a = new Stack<>();
        }
        q.d(a.class.getSimpleName(), "add activity name :" + activity.getClass().getSimpleName());
        f1003a.add(activity);
    }

    public Activity currentActivity() {
        if (f1003a.isEmpty()) {
            return null;
        }
        return f1003a.lastElement();
    }

    public void finishActivity() {
        if (f1003a.isEmpty()) {
            return;
        }
        finishActivity(f1003a.lastElement());
    }

    public void finishAllActivity() {
        int size = f1003a.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (f1003a.get(i2) != null) {
                f1003a.get(i2).finish();
            }
        }
        f1003a.clear();
    }

    public boolean isAppExit() {
        Stack<Activity> stack = f1003a;
        return stack == null || stack.isEmpty();
    }

    public void finishActivity(Activity activity) {
        if (activity != null) {
            if (!f1003a.isEmpty()) {
                f1003a.remove(activity);
            }
            activity.finish();
        }
    }

    public void finishActivity(Class<?> cls) {
        if (f1003a.isEmpty()) {
            return;
        }
        Stack stack = new Stack();
        for (Activity activity : f1003a) {
            if (activity.getClass().equals(cls)) {
                activity.finish();
                stack.add(activity);
            }
        }
        f1003a.removeAll(stack);
        stack.removeAllElements();
    }
}
