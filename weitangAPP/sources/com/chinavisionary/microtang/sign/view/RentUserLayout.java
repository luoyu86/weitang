package com.chinavisionary.microtang.sign.view;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.e.a.d.x;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.sign.vo.ContactDetailsVo;
import com.chinavisionary.microtang.sign.vo.SignRoomVo;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class RentUserLayout extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LayoutInflater f8591a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<SignRoomVo> f8592b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public EditText f8593c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public EditText f8594d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public EditText f8595e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public EditText f8596f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f8597g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f8598h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public TextWatcher f8599i;
    public TextWatcher j;
    public TextWatcher k;
    public TextWatcher l;

    public class a implements TextWatcher {
        public a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            RentUserLayout.this.h();
        }
    }

    public class b implements TextWatcher {
        public b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            RentUserLayout.this.i();
        }
    }

    public class c implements TextWatcher {
        public c() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            RentUserLayout.this.g();
        }
    }

    public class d implements TextWatcher {
        public d() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            RentUserLayout.this.f();
        }
    }

    public RentUserLayout(Context context) {
        super(context);
        this.f8598h = true;
        this.f8599i = new a();
        this.j = new b();
        this.k = new c();
        this.l = new d();
        e();
    }

    public final void e() {
        this.f8591a = LayoutInflater.from(getContext());
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    }

    public final void f() {
        if (this.f8592b != null) {
            int iIntValue = ((Integer) this.f8596f.getTag()).intValue();
            this.f8592b.get(this.f8597g).getRoommatesBeans().get(iIntValue).setAddress(this.f8596f.getText().toString());
        }
    }

    public final void g() {
        if (this.f8592b != null) {
            int iIntValue = ((Integer) this.f8595e.getTag()).intValue();
            this.f8592b.get(this.f8597g).getRoommatesBeans().get(iIntValue).setIdCardNo(this.f8595e.getText().toString());
        }
    }

    public final void h() {
        if (this.f8592b != null) {
            int iIntValue = ((Integer) this.f8593c.getTag()).intValue();
            this.f8592b.get(this.f8597g).getRoommatesBeans().get(iIntValue).setName(this.f8593c.getText().toString());
        }
    }

    public final void i() {
        if (this.f8592b != null) {
            int iIntValue = ((Integer) this.f8594d.getTag()).intValue();
            this.f8592b.get(this.f8597g).getRoommatesBeans().get(iIntValue).setPhone(this.f8594d.getText().toString());
        }
    }

    public void setShowRentUser(boolean z) {
        this.f8598h = z;
    }

    public void setSignRoomVos(List<SignRoomVo> list) {
        this.f8592b = list;
    }

    public void setupRentUser(List<SignRoomVo> list, ContactDetailsVo.RoommatesBean roommatesBean, int i2, View.OnClickListener onClickListener, int i3) {
        removeAllViews();
        setSignRoomVos(list);
        this.f8597g = i2;
        if (roommatesBean != null) {
            View viewInflate = this.f8591a.inflate(R.layout.item_rent_user_info_layout, (ViewGroup) null);
            this.f8593c = (EditText) viewInflate.findViewById(R.id.edt_user_info);
            this.f8594d = (EditText) viewInflate.findViewById(R.id.edt_phone);
            this.f8595e = (EditText) viewInflate.findViewById(R.id.edt_id_card);
            this.f8596f = (EditText) viewInflate.findViewById(R.id.edt_address);
            this.f8593c.setEnabled(!this.f8598h);
            this.f8594d.setEnabled(!this.f8598h);
            this.f8595e.setEnabled(!this.f8598h);
            ((TextView) viewInflate.findViewById(R.id.tv_title)).setText(this.f8598h ? R.string.title_rent_user_info : R.string.title_rent_contact_info);
            TextView textView = (TextView) viewInflate.findViewById(R.id.tv_id_card_title);
            TextView textView2 = (TextView) viewInflate.findViewById(R.id.tv_id_card_type_title);
            TextView textView3 = (TextView) viewInflate.findViewById(R.id.tv_right_value);
            ImageView imageView = (ImageView) viewInflate.findViewById(R.id.img_right_id_type_icon);
            ImageView imageView2 = (ImageView) viewInflate.findViewById(R.id.img_right_icon);
            ImageView imageView3 = (ImageView) viewInflate.findViewById(R.id.img_right_phone_icon);
            ImageView imageView4 = (ImageView) viewInflate.findViewById(R.id.img_right_id_icon);
            imageView2.setVisibility(this.f8598h ? 4 : 0);
            imageView3.setVisibility(this.f8598h ? 4 : 0);
            imageView4.setVisibility(this.f8598h ? 4 : 0);
            imageView.setVisibility(4);
            TextView textView4 = (TextView) viewInflate.findViewById(R.id.tv_address_title);
            ImageView imageView5 = (ImageView) viewInflate.findViewById(R.id.img_right_address_icon);
            textView.setText(this.f8598h ? R.string.title_id_card_no : R.string.title_contact_relation);
            textView2.setVisibility(this.f8598h ? 0 : 8);
            textView3.setVisibility(this.f8598h ? 0 : 8);
            textView4.setVisibility(this.f8598h ? 0 : 8);
            imageView5.setVisibility(this.f8598h ? 0 : 8);
            this.f8596f.setVisibility(this.f8598h ? 0 : 8);
            this.f8595e.setHint(this.f8598h ? R.string.hint_input_rent_id_card : R.string.hint_input_contact_relation);
            this.f8595e.setInputType(this.f8598h ? 2 : 1);
            this.f8593c.setTag(Integer.valueOf(i3));
            this.f8594d.setTag(Integer.valueOf(i3));
            this.f8595e.setTag(Integer.valueOf(i3));
            this.f8596f.setTag(Integer.valueOf(i3));
            this.f8593c.setText(x.getNotNullStr(roommatesBean.getName(), ""));
            this.f8594d.setText(x.getNotNullStr(roommatesBean.getPhone(), ""));
            this.f8595e.setText(x.getNotNullStr(roommatesBean.getIdCardNo(), ""));
            this.f8596f.setText(x.getNotNullStr(roommatesBean.getAddress(), ""));
            this.f8593c.removeTextChangedListener(this.f8599i);
            this.f8594d.removeTextChangedListener(this.j);
            this.f8595e.removeTextChangedListener(this.k);
            this.f8596f.removeTextChangedListener(this.l);
            this.f8593c.addTextChangedListener(this.f8599i);
            this.f8594d.addTextChangedListener(this.j);
            this.f8595e.addTextChangedListener(this.k);
            this.f8596f.addTextChangedListener(this.l);
            addView(viewInflate);
        }
    }

    public RentUserLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8598h = true;
        this.f8599i = new a();
        this.j = new b();
        this.k = new c();
        this.l = new d();
        e();
    }

    public RentUserLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f8598h = true;
        this.f8599i = new a();
        this.j = new b();
        this.k = new c();
        this.l = new d();
        e();
    }
}
