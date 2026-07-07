package cn.admobiletop.adsuyi.a.n;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.MotionEvent;
import android.view.View;
import cn.admobiletop.adsuyi.R;
import cn.admobiletop.adsuyi.ad.data.IBaseRelease;
import cn.admobiletop.adsuyi.ad.widget.ADSuyiAspectRatioContainer;

/* JADX INFO: loaded from: classes.dex */
public abstract class b extends ADSuyiAspectRatioContainer implements IBaseRelease {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f3459b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Activity f3460c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f3461d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f3462e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public AlertDialog f3463f;

    public b(Activity activity, boolean z) {
        super(activity, 0.0f);
        this.f3460c = activity;
        this.f3459b = z;
    }

    public abstract void b();

    public abstract boolean d();

    public final void e() {
        AlertDialog alertDialog = this.f3463f;
        if (alertDialog != null) {
            alertDialog.dismiss();
            this.f3463f = null;
        }
    }

    public final void g() {
        try {
            e();
            AlertDialog.Builder builder = new AlertDialog.Builder(this.f3460c, R.style.Theme_Dialog_TTDownload);
            builder.setTitle("下载安装提示");
            builder.setMessage("是否开始下载安装这个APP？");
            builder.setNegativeButton("取消", (DialogInterface.OnClickListener) null);
            builder.setPositiveButton("确定", new a(this));
            AlertDialog alertDialogCreate = builder.create();
            this.f3463f = alertDialogCreate;
            alertDialogCreate.setCancelable(false);
            this.f3463f.setCanceledOnTouchOutside(false);
            this.f3463f.show();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public abstract View getRespondClickView();

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!d() || 1 != motionEvent.getAction() || !cn.admobiletop.adsuyi.a.m.g.a()) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        this.f3461d = (int) motionEvent.getX();
        this.f3462e = (int) motionEvent.getY();
        g();
        return true;
    }

    @Override // cn.admobiletop.adsuyi.ad.data.IBaseRelease
    public void release() {
        this.f3460c = null;
        e();
    }
}
