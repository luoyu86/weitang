package cn.admobiletop.adsuyi.adapter.gdt.widget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import cn.admobiletop.adsuyi.adapter.gdt.R;
import com.qq.e.comm.compliance.DownloadConfirmCallBack;
import org.android.agoo.common.AgooConstants;

/* JADX INFO: loaded from: classes.dex */
public class DownloadApkConfirmDialogActivity extends Activity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static DownloadConfirmCallBack f3748a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f3749b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public f f3750c;

    public static void a(Context context, String str, DownloadConfirmCallBack downloadConfirmCallBack) {
        if (context != null) {
            try {
                f3748a = downloadConfirmCallBack;
                Intent intent = new Intent(context, (Class<?>) DownloadApkConfirmDialogActivity.class);
                intent.putExtra(AgooConstants.OPEN_URL, str);
                context.startActivity(intent);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.f3749b = getIntent().getStringExtra(AgooConstants.OPEN_URL);
        setContentView(R.layout.adsuyi_gdt_download_apk_layout);
        f fVar = new f(this, this.f3749b, f3748a);
        this.f3750c = fVar;
        fVar.setOnDismissListener(new d(this));
        this.f3750c.show();
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        f fVar = this.f3750c;
        if (fVar == null || !fVar.isShowing()) {
            return;
        }
        this.f3750c.dismiss();
    }
}
