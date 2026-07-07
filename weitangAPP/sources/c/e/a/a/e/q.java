package c.e.a.a.e;

import android.content.Context;
import android.text.SpannableString;
import android.view.View;
import android.widget.TextView;
import com.chinavisionary.core.R;

/* JADX INFO: loaded from: classes.dex */
public class q extends o {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f992b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f993c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f994d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public c f995e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TextView f996f;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (q.this.f995e != null) {
                q.this.dismiss();
                q.this.f995e.onClickButtonLeft();
            }
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (q.this.f995e != null) {
                q.this.dismiss();
                q.this.f995e.onClickButtonRight();
            }
        }
    }

    public interface c {
        void onClickButtonLeft();

        void onClickButtonRight();
    }

    public q(Context context) {
        super(context);
        d();
    }

    public final void c() {
        this.f993c.setOnClickListener(new a());
        this.f994d.setOnClickListener(new b());
    }

    public final void d() {
        setContentView(R.layout.dialog_confirm);
        this.f996f = (TextView) findViewById(R.id.tv_dialog_title);
        this.f992b = (TextView) findViewById(R.id.tv_dialog_content);
        this.f993c = (TextView) findViewById(R.id.tv_dialog_left_button);
        this.f994d = (TextView) findViewById(R.id.tv_dialog_right_button);
        c();
    }

    public q setButtonText(String str, String str2) {
        this.f993c.setText(str);
        this.f994d.setText(str2);
        return this;
    }

    public q setButtonTextColor(int i2, int i3) {
        this.f993c.setTextColor(i2);
        this.f994d.setTextColor(i3);
        return this;
    }

    public q setContent(String str) {
        this.f992b.setText(str);
        return this;
    }

    public q setContentVisible(boolean z) {
        this.f992b.setVisibility(z ? 0 : 8);
        return this;
    }

    public q setOnClickButtonListener(c cVar) {
        this.f995e = cVar;
        return this;
    }

    public q setTitle(String str) {
        this.f996f.setText(str);
        this.f996f.setVisibility(0);
        return this;
    }

    public q setContent(SpannableString spannableString) {
        this.f992b.setText("");
        this.f992b.append(spannableString);
        return this;
    }

    public q setButtonText(int i2, int i3) {
        this.f993c.setText(i2);
        this.f994d.setText(i3);
        return this;
    }

    @Override // android.app.Dialog
    public void setTitle(int i2) {
        this.f996f.setText(i2);
        this.f996f.setVisibility(0);
    }

    public q setContent(int i2) {
        this.f992b.setText(i2);
        return this;
    }
}
