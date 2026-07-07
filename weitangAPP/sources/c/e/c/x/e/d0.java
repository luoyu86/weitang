package c.e.c.x.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatButton;
import com.alibaba.android.arouter.launcher.ARouter;
import com.chinavisionary.core.weight.CoreRoundedImageView;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.me.vo.IDHeadImageVo;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f2131a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public CoreRoundedImageView f2132b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public CoreRoundedImageView f2133c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public CoreRoundedImageView f2134d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public f0 f2135e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View.OnClickListener f2136f = new a();

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.btn_upload /* 2131230917 */:
                    d0.this.handlerSubmitAuth();
                    break;
                case R.id.img_back /* 2131231187 */:
                    d0.this.f2131a = true;
                    d0.this.j();
                    break;
                case R.id.img_face /* 2131231230 */:
                    d0.this.f2131a = false;
                    d0.this.j();
                    break;
                case R.id.img_self /* 2131231281 */:
                    d0.this.k();
                    break;
                case R.id.tv_alert_camera /* 2131231940 */:
                    d0.this.g();
                    break;
                case R.id.tv_alert_photo_select /* 2131231944 */:
                    d0.this.h();
                    break;
            }
        }
    }

    public d0(f0 f0Var) {
        this.f2135e = f0Var;
    }

    public final List<File> f() {
        boolean z;
        String url = this.f2132b.getUrl();
        String url2 = this.f2133c.getUrl();
        String url3 = this.f2134d.getUrl();
        boolean z2 = true;
        if (c.e.a.d.x.isNullStr(url2)) {
            this.f2135e.showToast(R.string.title_id_card_face_is_empty);
            z = true;
        } else {
            z = false;
        }
        if (c.e.a.d.x.isNullStr(url) && !z) {
            this.f2135e.showToast(R.string.title_id_card_back_is_empty);
            z = true;
        }
        if (!c.e.a.d.x.isNullStr(url3) || z) {
            z2 = z;
        } else {
            this.f2135e.showToast(R.string.tip_self_camera);
        }
        if (z2) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new File(url2));
        arrayList.add(new File(url));
        arrayList.add(new File(url3));
        return arrayList;
    }

    public final void g() {
        this.f2135e.openIDCardCamera(this.f2131a ? 2 : 1);
    }

    public View getAdapterHeadView(boolean z) {
        View viewInflate = LayoutInflater.from(this.f2135e.getCurrentContext()).inflate(R.layout.item_id_head_layout, (ViewGroup) null, false);
        this.f2132b = (CoreRoundedImageView) viewInflate.findViewById(R.id.img_back);
        this.f2133c = (CoreRoundedImageView) viewInflate.findViewById(R.id.img_face);
        this.f2134d = (CoreRoundedImageView) viewInflate.findViewById(R.id.img_self);
        AppCompatButton appCompatButton = (AppCompatButton) viewInflate.findViewById(R.id.btn_upload);
        appCompatButton.setText(z ? R.string.title_auth_over : R.string.title_upload_auth);
        this.f2132b.setOnClickListener(this.f2136f);
        this.f2133c.setOnClickListener(this.f2136f);
        this.f2134d.setOnClickListener(this.f2136f);
        if (!z) {
            appCompatButton.setOnClickListener(this.f2136f);
        }
        return viewInflate;
    }

    public IDHeadImageVo getIDHeadImageVo() {
        IDHeadImageVo iDHeadImageVo = new IDHeadImageVo();
        iDHeadImageVo.setBackFile(this.f2132b.getUrl());
        iDHeadImageVo.setSelfFile(this.f2134d.getUrl());
        iDHeadImageVo.setFaceFile(this.f2133c.getUrl());
        return iDHeadImageVo;
    }

    public final void h() {
        i(this.f2131a ? 2 : 1);
    }

    public void handlerSubmitAuth() {
        List<File> listF = f();
        if (listF != null) {
            this.f2135e.uploadFile(listF);
        }
    }

    public final void i(int i2) {
        this.f2135e.openImageGridActivity(i2);
    }

    public final void j() {
        c.e.c.g.n.getInstance().showAlertPhoto(this.f2135e.getCurrentContext(), this.f2136f);
    }

    public final void k() {
        ARouter.getInstance().build("/camera/rout").withBoolean("isShowChangeBtn", false).navigation();
    }

    public void loadImageToFile(String str, boolean z) {
        if (z) {
            this.f2133c.loadImageToFile(new File(str));
        } else {
            this.f2132b.loadImageToFile(new File(str));
        }
    }

    public void setupOwnPhoto(String str) {
        this.f2134d.loadImageToUrl(str);
    }
}
