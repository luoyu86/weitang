package cn.admobiletop.adsuyi.a.n;

import android.content.DialogInterface;
import cn.admobiletop.adsuyi.a.m.k;
import cn.admobiletop.adsuyi.util.ADSuyiToastUtil;

/* JADX INFO: loaded from: classes.dex */
public class a implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f3440a;

    public a(b bVar) {
        this.f3440a = bVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i2) {
        k.a(this.f3440a.f3461d, this.f3440a.f3462e, this.f3440a.f3461d, this.f3440a.f3462e, this.f3440a.getRespondClickView() == null ? this.f3440a : this.f3440a.getRespondClickView());
        if (this.f3440a.f3459b) {
            ADSuyiToastUtil.show(this.f3440a.getContext(), "如果没有开始下载或安装，请再次点击!");
        }
        this.f3440a.b();
    }
}
