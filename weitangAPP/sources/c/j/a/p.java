package c.j.a;

import android.app.Activity;
import android.app.Dialog;
import android.app.FragmentManager;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.gyf.immersionbar.RequestManagerFragment;
import com.gyf.immersionbar.SupportRequestManagerFragment;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class p implements Handler.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f2758a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Handler f2759b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<FragmentManager, RequestManagerFragment> f2760c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<androidx.fragment.app.FragmentManager, SupportRequestManagerFragment> f2761d;

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final p f2762a = new p();
    }

    public static <T> void a(@Nullable T t, @NonNull String str) {
        Objects.requireNonNull(t, str);
    }

    public static p d() {
        return b.f2762a;
    }

    public final RequestManagerFragment b(FragmentManager fragmentManager, String str) {
        return c(fragmentManager, str, false);
    }

    public final RequestManagerFragment c(FragmentManager fragmentManager, String str, boolean z) {
        RequestManagerFragment requestManagerFragment = (RequestManagerFragment) fragmentManager.findFragmentByTag(str);
        if (requestManagerFragment == null && (requestManagerFragment = this.f2760c.get(fragmentManager)) == null) {
            if (z) {
                return null;
            }
            requestManagerFragment = new RequestManagerFragment();
            this.f2760c.put(fragmentManager, requestManagerFragment);
            fragmentManager.beginTransaction().add(requestManagerFragment, str).commitAllowingStateLoss();
            this.f2759b.obtainMessage(1, fragmentManager).sendToTarget();
        }
        if (!z) {
            return requestManagerFragment;
        }
        fragmentManager.beginTransaction().remove(requestManagerFragment).commit();
        return null;
    }

    public void destroy(Activity activity, Dialog dialog) {
        if (activity == null || dialog == null) {
            return;
        }
        if (activity instanceof FragmentActivity) {
            SupportRequestManagerFragment supportRequestManagerFragmentF = f(((FragmentActivity) activity).getSupportFragmentManager(), this.f2758a + dialog.toString(), true);
            if (supportRequestManagerFragmentF != null) {
                supportRequestManagerFragmentF.get(activity, dialog).d();
                return;
            }
            return;
        }
        RequestManagerFragment requestManagerFragmentC = c(activity.getFragmentManager(), this.f2758a + dialog.toString(), true);
        if (requestManagerFragmentC != null) {
            requestManagerFragmentC.get(activity, dialog).d();
        }
    }

    public final SupportRequestManagerFragment e(androidx.fragment.app.FragmentManager fragmentManager, String str) {
        return f(fragmentManager, str, false);
    }

    public final SupportRequestManagerFragment f(androidx.fragment.app.FragmentManager fragmentManager, String str, boolean z) {
        SupportRequestManagerFragment supportRequestManagerFragment = (SupportRequestManagerFragment) fragmentManager.findFragmentByTag(str);
        if (supportRequestManagerFragment == null && (supportRequestManagerFragment = this.f2761d.get(fragmentManager)) == null) {
            if (z) {
                return null;
            }
            supportRequestManagerFragment = new SupportRequestManagerFragment();
            this.f2761d.put(fragmentManager, supportRequestManagerFragment);
            fragmentManager.beginTransaction().add(supportRequestManagerFragment, str).commitAllowingStateLoss();
            this.f2759b.obtainMessage(2, fragmentManager).sendToTarget();
        }
        if (!z) {
            return supportRequestManagerFragment;
        }
        fragmentManager.beginTransaction().remove(supportRequestManagerFragment).commit();
        return null;
    }

    public h get(Activity activity) {
        a(activity, "activity is null");
        if (activity instanceof FragmentActivity) {
            return e(((FragmentActivity) activity).getSupportFragmentManager(), this.f2758a + activity.toString()).get(activity);
        }
        return b(activity.getFragmentManager(), this.f2758a + activity.toString()).get(activity);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i2 = message.what;
        if (i2 == 1) {
            this.f2760c.remove((FragmentManager) message.obj);
            return true;
        }
        if (i2 != 2) {
            return false;
        }
        this.f2761d.remove((androidx.fragment.app.FragmentManager) message.obj);
        return true;
    }

    public p() {
        this.f2758a = h.class.getName();
        this.f2760c = new HashMap();
        this.f2761d = new HashMap();
        this.f2759b = new Handler(Looper.getMainLooper(), this);
    }

    public h get(Fragment fragment) {
        a(fragment, "fragment is null");
        a(fragment.getActivity(), "fragment.getActivity() is null");
        if (fragment instanceof DialogFragment) {
            a(((DialogFragment) fragment).getDialog(), "fragment.getDialog() is null");
        }
        return e(fragment.getChildFragmentManager(), this.f2758a + fragment.toString()).get(fragment);
    }

    @RequiresApi(api = 17)
    public h get(android.app.Fragment fragment) {
        a(fragment, "fragment is null");
        a(fragment.getActivity(), "fragment.getActivity() is null");
        if (fragment instanceof android.app.DialogFragment) {
            a(((android.app.DialogFragment) fragment).getDialog(), "fragment.getDialog() is null");
        }
        return b(fragment.getChildFragmentManager(), this.f2758a + fragment.toString()).get(fragment);
    }

    public h get(Activity activity, Dialog dialog) {
        a(activity, "activity is null");
        a(dialog, "dialog is null");
        if (activity instanceof FragmentActivity) {
            return e(((FragmentActivity) activity).getSupportFragmentManager(), this.f2758a + dialog.toString()).get(activity, dialog);
        }
        return b(activity.getFragmentManager(), this.f2758a + dialog.toString()).get(activity, dialog);
    }
}
