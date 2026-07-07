package com.bun.miitmdid;

import android.os.AsyncTask;
import com.bun.lib.MsaIdInterface;

/* JADX INFO: loaded from: classes.dex */
public class d0 extends AsyncTask<Void, Void, Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public f0 f5834a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public MsaIdInterface f5835b;

    public d0(MsaIdInterface msaIdInterface, f0 f0Var) {
        this.f5835b = msaIdInterface;
        this.f5834a = f0Var;
    }

    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public native Boolean doInBackground(Void... voidArr);

    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public native void onPostExecute(Boolean bool);
}
