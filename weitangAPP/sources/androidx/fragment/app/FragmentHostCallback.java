package androidx.fragment.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.util.Preconditions;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes.dex */
public abstract class FragmentHostCallback<E> extends FragmentContainer {

    @Nullable
    private final Activity mActivity;

    @NonNull
    private final Context mContext;
    public final FragmentManagerImpl mFragmentManager;

    @NonNull
    private final Handler mHandler;
    private final int mWindowAnimations;

    public FragmentHostCallback(@NonNull Context context, @NonNull Handler handler, int i2) {
        this(context instanceof Activity ? (Activity) context : null, context, handler, i2);
    }

    @Nullable
    public Activity getActivity() {
        return this.mActivity;
    }

    @NonNull
    public Context getContext() {
        return this.mContext;
    }

    public FragmentManagerImpl getFragmentManagerImpl() {
        return this.mFragmentManager;
    }

    @NonNull
    public Handler getHandler() {
        return this.mHandler;
    }

    public void onAttachFragment(Fragment fragment) {
    }

    public void onDump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    @Override // androidx.fragment.app.FragmentContainer
    @Nullable
    public View onFindViewById(int i2) {
        return null;
    }

    @Nullable
    public abstract E onGetHost();

    @NonNull
    public LayoutInflater onGetLayoutInflater() {
        return LayoutInflater.from(this.mContext);
    }

    public int onGetWindowAnimations() {
        return this.mWindowAnimations;
    }

    @Override // androidx.fragment.app.FragmentContainer
    public boolean onHasView() {
        return true;
    }

    public boolean onHasWindowAnimations() {
        return true;
    }

    public void onRequestPermissionsFromFragment(@NonNull Fragment fragment, @NonNull String[] strArr, int i2) {
    }

    public boolean onShouldSaveFragmentState(Fragment fragment) {
        return true;
    }

    public boolean onShouldShowRequestPermissionRationale(@NonNull String str) {
        return false;
    }

    public void onStartActivityFromFragment(Fragment fragment, Intent intent, int i2) {
        onStartActivityFromFragment(fragment, intent, i2, null);
    }

    public void onStartIntentSenderFromFragment(Fragment fragment, IntentSender intentSender, int i2, @Nullable Intent intent, int i3, int i4, int i5, Bundle bundle) throws IntentSender.SendIntentException {
        if (i2 != -1) {
            throw new IllegalStateException("Starting intent sender with a requestCode requires a FragmentActivity host");
        }
        ActivityCompat.startIntentSenderForResult(this.mActivity, intentSender, i2, intent, i3, i4, i5, bundle);
    }

    public void onSupportInvalidateOptionsMenu() {
    }

    public FragmentHostCallback(@NonNull FragmentActivity fragmentActivity) {
        this(fragmentActivity, fragmentActivity, fragmentActivity.mHandler, 0);
    }

    public void onStartActivityFromFragment(Fragment fragment, Intent intent, int i2, @Nullable Bundle bundle) {
        if (i2 != -1) {
            throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
        }
        this.mContext.startActivity(intent);
    }

    public FragmentHostCallback(@Nullable Activity activity, @NonNull Context context, @NonNull Handler handler, int i2) {
        this.mFragmentManager = new FragmentManagerImpl();
        this.mActivity = activity;
        this.mContext = (Context) Preconditions.checkNotNull(context, "context == null");
        this.mHandler = (Handler) Preconditions.checkNotNull(handler, "handler == null");
        this.mWindowAnimations = i2;
    }
}
