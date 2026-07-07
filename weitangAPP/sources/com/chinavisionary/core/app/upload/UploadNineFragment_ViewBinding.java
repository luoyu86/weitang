package com.chinavisionary.core.app.upload;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import b.c.d;
import butterknife.Unbinder;
import com.chinavisionary.core.R;
import com.chinavisionary.core.weight.BaseRecyclerView;

/* JADX INFO: loaded from: classes.dex */
public class UploadNineFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public UploadNineFragment f6518b;

    @UiThread
    public UploadNineFragment_ViewBinding(UploadNineFragment uploadNineFragment, View view) {
        this.f6518b = uploadNineFragment;
        uploadNineFragment.mRecyclerView = (BaseRecyclerView) d.findRequiredViewAsType(view, R.id.recycler, "field 'mRecyclerView'", BaseRecyclerView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        UploadNineFragment uploadNineFragment = this.f6518b;
        if (uploadNineFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f6518b = null;
        uploadNineFragment.mRecyclerView = null;
    }
}
