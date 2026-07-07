package c.k.a.f;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import com.lzy.imagepicker.R;

/* JADX INFO: loaded from: classes2.dex */
public class a extends PopupWindow implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ListView f2799a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public d f2800b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f2801c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f2802d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f2803e;

    /* JADX INFO: renamed from: c.k.a.f.a$a, reason: collision with other inner class name */
    public class ViewTreeObserverOnGlobalLayoutListenerC0041a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f2804a;

        public ViewTreeObserverOnGlobalLayoutListenerC0041a(View view) {
            this.f2804a = view;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            this.f2804a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            int height = (this.f2804a.getHeight() * 5) / 8;
            int height2 = a.this.f2799a.getHeight();
            ViewGroup.LayoutParams layoutParams = a.this.f2799a.getLayoutParams();
            if (height2 <= height) {
                height = height2;
            }
            layoutParams.height = height;
            a.this.f2799a.setLayoutParams(layoutParams);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) a.this.f2802d.getLayoutParams();
            layoutParams2.height = a.this.f2803e;
            a.this.f2802d.setLayoutParams(layoutParams2);
            a.this.g();
        }
    }

    public class b implements AdapterView.OnItemClickListener {
        public b() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            if (a.this.f2800b != null) {
                a.this.f2800b.onItemClick(adapterView, view, i2, j);
            }
        }
    }

    public class c implements Animator.AnimatorListener {
        public c() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            a.super.dismiss();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            a.this.f2799a.setVisibility(0);
        }
    }

    public interface d {
        void onItemClick(AdapterView<?> adapterView, View view, int i2, long j);
    }

    public a(Context context, BaseAdapter baseAdapter) {
        super(context);
        View viewInflate = View.inflate(context, R.layout.pop_folder, null);
        View viewFindViewById = viewInflate.findViewById(R.id.masker);
        this.f2801c = viewFindViewById;
        viewFindViewById.setOnClickListener(this);
        View viewFindViewById2 = viewInflate.findViewById(R.id.margin);
        this.f2802d = viewFindViewById2;
        viewFindViewById2.setOnClickListener(this);
        ListView listView = (ListView) viewInflate.findViewById(R.id.listView);
        this.f2799a = listView;
        listView.setAdapter((ListAdapter) baseAdapter);
        setContentView(viewInflate);
        setWidth(-1);
        setHeight(-1);
        setFocusable(true);
        setOutsideTouchable(true);
        setBackgroundDrawable(new ColorDrawable(0));
        setAnimationStyle(0);
        viewInflate.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserverOnGlobalLayoutListenerC0041a(viewInflate));
        this.f2799a.setOnItemClickListener(new b());
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        h();
    }

    public final void g() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.f2801c, "alpha", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.f2799a, "translationY", r2.getHeight(), 0.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(400L);
        animatorSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorSet.start();
    }

    public final void h() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.f2801c, "alpha", 1.0f, 0.0f);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.f2799a, "translationY", 0.0f, r2.getHeight());
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(300L);
        animatorSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorSet.addListener(new c());
        animatorSet.start();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        dismiss();
    }

    public void setMargin(int i2) {
        this.f2803e = i2;
    }

    public void setOnItemClickListener(d dVar) {
        this.f2800b = dVar;
    }

    public void setSelection(int i2) {
        this.f2799a.setSelection(i2);
    }
}
