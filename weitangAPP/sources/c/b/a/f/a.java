package c.b.a.f;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import com.bigkoo.pickerview.R;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f861a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ViewGroup f862b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ViewGroup f863c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ViewGroup f864d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public c.b.a.c.a f865e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public c.b.a.d.c f866f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f867g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Animation f868h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Animation f869i;
    public boolean j;
    public Dialog l;
    public View m;
    public int k = 80;
    public boolean n = true;
    public View.OnKeyListener o = new d();
    public final View.OnTouchListener p = new e();

    /* JADX INFO: renamed from: c.b.a.f.a$a, reason: collision with other inner class name */
    public class ViewOnClickListenerC0010a implements View.OnClickListener {
        public ViewOnClickListenerC0010a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.dismiss();
        }
    }

    public class b implements Animation.AnimationListener {
        public b() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            a.this.dismissImmediately();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = a.this;
            aVar.f865e.O.removeView(aVar.f863c);
            a.this.j = false;
            a.this.f867g = false;
            if (a.this.f866f != null) {
                a.this.f866f.onDismiss(a.this);
            }
        }
    }

    public class d implements View.OnKeyListener {
        public d() {
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i2, KeyEvent keyEvent) {
            if (i2 != 4 || keyEvent.getAction() != 0 || !a.this.isShowing()) {
                return false;
            }
            a.this.dismiss();
            return true;
        }
    }

    public class e implements View.OnTouchListener {
        public e() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0) {
                return false;
            }
            a.this.dismiss();
            return false;
        }
    }

    public class f implements DialogInterface.OnDismissListener {
        public f() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            if (a.this.f866f != null) {
                a.this.f866f.onDismiss(a.this);
            }
        }
    }

    public a(Context context) {
        this.f861a = context;
    }

    public void createDialog() {
        if (this.f864d != null) {
            Dialog dialog = new Dialog(this.f861a, R.style.custom_dialog2);
            this.l = dialog;
            dialog.setCancelable(this.f865e.i0);
            this.l.setContentView(this.f864d);
            Window window = this.l.getWindow();
            if (window != null) {
                window.setWindowAnimations(R.style.picker_view_scale_anim);
                window.setGravity(17);
            }
            this.l.setOnDismissListener(new f());
        }
    }

    public void dismiss() {
        if (isDialog()) {
            e();
            return;
        }
        if (this.f867g) {
            return;
        }
        if (this.n) {
            this.f868h.setAnimationListener(new b());
            this.f862b.startAnimation(this.f868h);
        } else {
            dismissImmediately();
        }
        this.f867g = true;
    }

    public void dismissImmediately() {
        this.f865e.O.post(new c());
    }

    public final void e() {
        Dialog dialog = this.l;
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    public final Animation f() {
        return AnimationUtils.loadAnimation(this.f861a, c.b.a.e.c.getAnimationResource(this.k, true));
    }

    public View findViewById(int i2) {
        return this.f862b.findViewById(i2);
    }

    public final Animation g() {
        return AnimationUtils.loadAnimation(this.f861a, c.b.a.e.c.getAnimationResource(this.k, false));
    }

    public Dialog getDialog() {
        return this.l;
    }

    public ViewGroup getDialogContainerLayout() {
        return this.f862b;
    }

    public void h() {
        this.f869i = f();
        this.f868h = g();
    }

    public void i() {
    }

    public boolean isDialog() {
        return false;
    }

    public boolean isShowing() {
        if (isDialog()) {
            return false;
        }
        return this.f863c.getParent() != null || this.j;
    }

    public void j() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2, 80);
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.f861a);
        if (isDialog()) {
            ViewGroup viewGroup = (ViewGroup) layoutInflaterFrom.inflate(R.layout.layout_basepickerview, (ViewGroup) null, false);
            this.f864d = viewGroup;
            viewGroup.setBackgroundColor(0);
            ViewGroup viewGroup2 = (ViewGroup) this.f864d.findViewById(R.id.content_container);
            this.f862b = viewGroup2;
            layoutParams.leftMargin = 30;
            layoutParams.rightMargin = 30;
            viewGroup2.setLayoutParams(layoutParams);
            createDialog();
            this.f864d.setOnClickListener(new ViewOnClickListenerC0010a());
        } else {
            c.b.a.c.a aVar = this.f865e;
            if (aVar.O == null) {
                aVar.O = (ViewGroup) ((Activity) this.f861a).getWindow().getDecorView();
            }
            ViewGroup viewGroup3 = (ViewGroup) layoutInflaterFrom.inflate(R.layout.layout_basepickerview, this.f865e.O, false);
            this.f863c = viewGroup3;
            viewGroup3.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            int i2 = this.f865e.f0;
            if (i2 != -1) {
                this.f863c.setBackgroundColor(i2);
            }
            ViewGroup viewGroup4 = (ViewGroup) this.f863c.findViewById(R.id.content_container);
            this.f862b = viewGroup4;
            viewGroup4.setLayoutParams(layoutParams);
        }
        setKeyBackCancelable(true);
    }

    public final void k(View view) {
        this.f865e.O.addView(view);
        if (this.n) {
            this.f862b.startAnimation(this.f869i);
        }
    }

    public a l(boolean z) {
        ViewGroup viewGroup = this.f863c;
        if (viewGroup != null) {
            View viewFindViewById = viewGroup.findViewById(R.id.outmost_container);
            if (z) {
                viewFindViewById.setOnTouchListener(this.p);
            } else {
                viewFindViewById.setOnTouchListener(null);
            }
        }
        return this;
    }

    public final void m() {
        Dialog dialog = this.l;
        if (dialog != null) {
            dialog.show();
        }
    }

    public void setDialogOutSideCancelable() {
        Dialog dialog = this.l;
        if (dialog != null) {
            dialog.setCancelable(this.f865e.i0);
        }
    }

    public void setKeyBackCancelable(boolean z) {
        ViewGroup viewGroup = isDialog() ? this.f864d : this.f863c;
        viewGroup.setFocusable(z);
        viewGroup.setFocusableInTouchMode(z);
        if (z) {
            viewGroup.setOnKeyListener(this.o);
        } else {
            viewGroup.setOnKeyListener(null);
        }
    }

    public a setOnDismissListener(c.b.a.d.c cVar) {
        this.f866f = cVar;
        return this;
    }

    public void show(View view, boolean z) {
        this.m = view;
        this.n = z;
        show();
    }

    public void show(boolean z) {
        show(null, z);
    }

    public void show(View view) {
        this.m = view;
        show();
    }

    public void show() {
        if (isDialog()) {
            m();
        } else {
            if (isShowing()) {
                return;
            }
            this.j = true;
            k(this.f863c);
            this.f863c.requestFocus();
        }
    }
}
