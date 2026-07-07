package org.greenrobot.eventbus.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Build;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import g.b.a.c;
import g.b.a.t.a;
import g.b.a.t.b;

/* JADX INFO: loaded from: classes3.dex */
public class ErrorDialogManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static a<?> f14982a;

    @TargetApi(11)
    public static class HoneycombManagerFragment extends Fragment {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f14983a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Bundle f14984b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public c f14985c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Object f14986d;

        public static void attachTo(Activity activity, Object obj, boolean z, Bundle bundle) {
            FragmentManager fragmentManager = activity.getFragmentManager();
            HoneycombManagerFragment honeycombManagerFragment = (HoneycombManagerFragment) fragmentManager.findFragmentByTag("de.greenrobot.eventbus.error_dialog_manager");
            if (honeycombManagerFragment == null) {
                honeycombManagerFragment = new HoneycombManagerFragment();
                fragmentManager.beginTransaction().add(honeycombManagerFragment, "de.greenrobot.eventbus.error_dialog_manager").commit();
                fragmentManager.executePendingTransactions();
            }
            honeycombManagerFragment.f14983a = z;
            honeycombManagerFragment.f14984b = bundle;
            honeycombManagerFragment.f14986d = obj;
        }

        public void onEventMainThread(b bVar) {
            if (ErrorDialogManager.c(this.f14986d, bVar)) {
                ErrorDialogManager.b(bVar);
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.executePendingTransactions();
                DialogFragment dialogFragment = (DialogFragment) fragmentManager.findFragmentByTag("de.greenrobot.eventbus.error_dialog");
                if (dialogFragment != null) {
                    dialogFragment.dismiss();
                }
                throw null;
            }
        }

        @Override // android.app.Fragment
        public void onPause() {
            this.f14985c.unregister(this);
            super.onPause();
        }

        @Override // android.app.Fragment
        public void onResume() {
            super.onResume();
            throw null;
        }
    }

    public static class SupportManagerFragment extends androidx.fragment.app.Fragment {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f14987a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Bundle f14988b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public c f14989c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f14990d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Object f14991e;

        public static void attachTo(Activity activity, Object obj, boolean z, Bundle bundle) {
            androidx.fragment.app.FragmentManager supportFragmentManager = ((FragmentActivity) activity).getSupportFragmentManager();
            SupportManagerFragment supportManagerFragment = (SupportManagerFragment) supportFragmentManager.findFragmentByTag("de.greenrobot.eventbus.error_dialog_manager");
            if (supportManagerFragment == null) {
                supportManagerFragment = new SupportManagerFragment();
                supportFragmentManager.beginTransaction().add(supportManagerFragment, "de.greenrobot.eventbus.error_dialog_manager").commit();
                supportFragmentManager.executePendingTransactions();
            }
            supportManagerFragment.f14987a = z;
            supportManagerFragment.f14988b = bundle;
            supportManagerFragment.f14991e = obj;
        }

        @Override // androidx.fragment.app.Fragment
        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            throw null;
        }

        public void onEventMainThread(b bVar) {
            if (ErrorDialogManager.c(this.f14991e, bVar)) {
                ErrorDialogManager.b(bVar);
                androidx.fragment.app.FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.executePendingTransactions();
                androidx.fragment.app.DialogFragment dialogFragment = (androidx.fragment.app.DialogFragment) fragmentManager.findFragmentByTag("de.greenrobot.eventbus.error_dialog");
                if (dialogFragment != null) {
                    dialogFragment.dismiss();
                }
                throw null;
            }
        }

        @Override // androidx.fragment.app.Fragment
        public void onPause() {
            this.f14989c.unregister(this);
            super.onPause();
        }

        @Override // androidx.fragment.app.Fragment
        public void onResume() {
            super.onResume();
            if (!this.f14990d) {
                throw null;
            }
            this.f14990d = false;
        }
    }

    public static void attachTo(Activity activity) {
        attachTo(activity, false, null);
    }

    public static void b(b bVar) {
        throw null;
    }

    public static boolean c(Object obj, b bVar) {
        Object executionScope;
        return bVar == null || (executionScope = bVar.getExecutionScope()) == null || executionScope.equals(obj);
    }

    public static boolean d(Activity activity) {
        String name;
        Class<?> superclass = activity.getClass();
        do {
            superclass = superclass.getSuperclass();
            if (superclass == null) {
                throw new RuntimeException("Illegal activity type: " + activity.getClass());
            }
            name = superclass.getName();
            if (name.equals("androidx.fragment.app.FragmentActivity")) {
                return true;
            }
            if (name.startsWith("com.actionbarsherlock.app") && (name.endsWith(".SherlockActivity") || name.endsWith(".SherlockListActivity") || name.endsWith(".SherlockPreferenceActivity"))) {
                throw new RuntimeException("Please use SherlockFragmentActivity. Illegal activity: " + name);
            }
        } while (!name.equals("android.app.Activity"));
        if (Build.VERSION.SDK_INT >= 11) {
            return false;
        }
        throw new RuntimeException("Illegal activity without fragment support. Either use Android 3.0+ or android.support.v4.app.FragmentActivity.");
    }

    public static void attachTo(Activity activity, boolean z) {
        attachTo(activity, z, null);
    }

    public static void attachTo(Activity activity, boolean z, Bundle bundle) {
        attachTo(activity, activity.getClass(), z, bundle);
    }

    public static void attachTo(Activity activity, Object obj, boolean z, Bundle bundle) {
        if (f14982a != null) {
            if (d(activity)) {
                SupportManagerFragment.attachTo(activity, obj, z, bundle);
                return;
            } else {
                HoneycombManagerFragment.attachTo(activity, obj, z, bundle);
                return;
            }
        }
        throw new RuntimeException("You must set the static factory field to configure error dialogs for your app.");
    }
}
