package c.e.c.m0;

import android.annotation.SuppressLint;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;

/* JADX INFO: loaded from: classes2.dex */
public class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    public static final p f1704a = new p();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public FragmentActivity f1705b;

    public static p getInstance() {
        return f1704a;
    }

    public <T extends ViewModel> T getViewModel(Class<T> cls) {
        FragmentActivity fragmentActivity = this.f1705b;
        if (fragmentActivity != null) {
            return (T) ViewModelProviders.of(fragmentActivity).get(cls);
        }
        return null;
    }

    public void release() {
        this.f1705b = null;
    }

    public void setActivity(FragmentActivity fragmentActivity) {
        this.f1705b = fragmentActivity;
    }
}
