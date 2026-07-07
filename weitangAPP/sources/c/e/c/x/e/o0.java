package c.e.c.x.e;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.chinavisionary.core.weight.CoreRoundedImageView;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.auth.IDAuthActivity;
import com.chinavisionary.microtang.me.EditMeActivity;

/* JADX INFO: loaded from: classes.dex */
public class o0 extends b0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f2198b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f2199c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public CoreRoundedImageView f2200d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View.OnClickListener f2201e;

    public o0(g0 g0Var) {
        super(g0Var);
        this.f2201e = new View.OnClickListener() { // from class: c.e.c.x.e.x
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f2219a.f(view);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void f(View view) {
        g0 g0Var = this.f2124a;
        if (g0Var == null || !g0Var.isLoginApp()) {
            return;
        }
        int id = view.getId();
        if (id != R.id.img_user_icon) {
            if (id == R.id.tv_auth_state) {
                g();
                return;
            } else if (id != R.id.tv_user_name) {
                return;
            }
        }
        h();
    }

    public void c(Boolean bool) {
        this.f2199c.setTag(bool);
        Resources resources = this.f2199c.getResources();
        this.f2199c.setCompoundDrawablesWithIntrinsicBounds(resources.getDrawable(bool.booleanValue() ? R.mipmap.ic_auth : R.mipmap.ic_unauth), (Drawable) null, (Drawable) null, (Drawable) null);
        this.f2199c.setText("");
        this.f2199c.setTextColor(bool.booleanValue() ? resources.getColor(R.color.color814402) : resources.getColor(R.color.color555555));
    }

    public void d(View view) {
        this.f2200d = (CoreRoundedImageView) view.findViewById(R.id.img_user_icon);
        this.f2198b = (TextView) view.findViewById(R.id.tv_user_name);
        this.f2199c = (TextView) view.findViewById(R.id.tv_auth_state);
        this.f2200d.setOnClickListener(this.f2201e);
        this.f2198b.setOnClickListener(this.f2201e);
        this.f2199c.setOnClickListener(this.f2201e);
    }

    public final void g() {
        if (this.f2124a.userIsAuth()) {
            return;
        }
        a(IDAuthActivity.class);
    }

    public final void h() {
        a(EditMeActivity.class);
    }

    public void i(String str, String str2) {
        this.f2198b.setText(c.e.a.d.x.getNotNullStr(str, c.e.a.d.x.getString(R.string.app_name)));
        this.f2200d.loadImageToUrl(str2, R.mipmap.ic_default_icon);
    }
}
