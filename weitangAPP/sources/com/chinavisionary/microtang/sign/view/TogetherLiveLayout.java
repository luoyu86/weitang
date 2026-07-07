package com.chinavisionary.microtang.sign.view;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.b.a.d.e;
import c.e.a.d.x;
import com.chinavisionary.core.app.config.bo.LeftTitleToRightArrowVo;
import com.chinavisionary.core.weight.CoreRoundedImageView;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.me.vo.IDTypeNameValueVo;
import com.chinavisionary.microtang.sign.vo.ContactDetailsVo;
import com.chinavisionary.microtang.sign.vo.SignRoomVo;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class TogetherLiveLayout extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LayoutInflater f8604a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List f8605b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public EditText f8606c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public EditText f8607d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public EditText f8608e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TextView f8609f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public TextView f8610g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public TextView f8611h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f8612i;
    public boolean j;
    public String k;
    public int l;
    public List<IDTypeNameValueVo> m;
    public c.b.a.f.b<String> n;
    public TextWatcher o;
    public TextWatcher p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public TextWatcher f8613q;
    public View.OnClickListener r;

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
            TogetherLiveLayout.this.m();
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
            TogetherLiveLayout.this.n();
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
            TogetherLiveLayout.this.k();
        }
    }

    public TogetherLiveLayout(Context context) {
        super(context);
        this.j = true;
        this.o = new a();
        this.p = new b();
        this.f8613q = new c();
        this.r = new View.OnClickListener() { // from class: c.e.c.j0.d.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f1625a.f(view);
            }
        };
        d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void f(View view) {
        j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void h(int i2, int i3, int i4, View view) {
        this.l = i2;
        l();
    }

    private List<String> getPoliticalList() {
        ArrayList arrayList = new ArrayList();
        List<IDTypeNameValueVo> list = this.m;
        if (list != null && !list.isEmpty()) {
            for (IDTypeNameValueVo iDTypeNameValueVo : this.m) {
                if (iDTypeNameValueVo != null && x.isNotNull(iDTypeNameValueVo.getName())) {
                    arrayList.add(iDTypeNameValueVo.getName());
                }
            }
        }
        return arrayList;
    }

    private List<ContactDetailsVo.RoommatesBean> getRoommatesBeanList() {
        Object obj = this.f8605b.get(this.f8612i);
        return obj instanceof LeftTitleToRightArrowVo ? (List) ((LeftTitleToRightArrowVo) obj).getExtObj() : obj instanceof SignRoomVo ? ((SignRoomVo) obj).getRoommatesBeans() : null;
    }

    private void setSignRoomVos(List list) {
        this.f8605b = list;
    }

    public final void d() {
        this.f8604a = LayoutInflater.from(getContext());
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    }

    public final void i() {
        List<IDTypeNameValueVo> list = this.m;
        if (list == null || list.isEmpty() || this.n != null) {
            return;
        }
        c.b.a.f.b<String> bVarBuild = new c.b.a.b.a(getContext(), new e() { // from class: c.e.c.j0.d.a
            @Override // c.b.a.d.e
            public final void onOptionsSelect(int i2, int i3, int i4, View view) {
                this.f1624a.h(i2, i3, i4, view);
            }
        }).build();
        this.n = bVarBuild;
        bVarBuild.setPicker(getPoliticalList());
        int i2 = this.l;
        if (i2 != -1) {
            this.n.setSelectOptions(i2);
        }
    }

    public final void j() {
        c.b.a.f.b<String> bVar = this.n;
        if (bVar != null) {
            bVar.show();
        } else {
            i();
        }
    }

    public final void k() {
        if (this.f8605b != null) {
            int iIntValue = ((Integer) this.f8608e.getTag()).intValue();
            String string = this.f8608e.getText().toString();
            if (x.isNotNull(string)) {
                string = string.trim();
            }
            getRoommatesBeanList().get(iIntValue).setIdCardNo(string);
        }
    }

    public final void l() {
        IDTypeNameValueVo iDTypeNameValueVo = this.m.get(this.l);
        if (iDTypeNameValueVo == null || !x.isNotNull(iDTypeNameValueVo.getName())) {
            return;
        }
        this.f8609f.setText(iDTypeNameValueVo.getName());
        this.f8610g.setText(iDTypeNameValueVo.getIdFaceName());
        this.f8611h.setText(iDTypeNameValueVo.getIdBackName());
        TextView textView = this.f8609f;
        int iIntValue = ((Integer) textView.getTag(textView.getId())).intValue();
        getRoommatesBeanList().get(iIntValue).setCardType(iDTypeNameValueVo.getName());
        getRoommatesBeanList().get(iIntValue).setFaceName(iDTypeNameValueVo.getIdFaceName());
        getRoommatesBeanList().get(iIntValue).setBackName(iDTypeNameValueVo.getIdBackName());
    }

    public final void m() {
        if (this.f8605b != null) {
            int iIntValue = ((Integer) this.f8606c.getTag()).intValue();
            String string = this.f8606c.getText().toString();
            if (x.isNotNull(string)) {
                string = string.trim();
            }
            getRoommatesBeanList().get(iIntValue).setName(string);
        }
    }

    public final void n() {
        if (this.f8605b != null) {
            int iIntValue = ((Integer) this.f8607d.getTag()).intValue();
            String string = this.f8607d.getText().toString();
            if (x.isNotNull(string)) {
                string = string.trim();
            }
            getRoommatesBeanList().get(iIntValue).setPhone(string);
        }
    }

    public void setShowIDImage(boolean z) {
        this.j = z;
    }

    public void setTitle(String str) {
        this.k = str;
    }

    public void setupIdTypeList(List<IDTypeNameValueVo> list) {
        this.m = list;
        i();
    }

    public void setupList(List list, ContactDetailsVo.RoommatesBean roommatesBean, int i2, View.OnClickListener onClickListener, int i3, boolean z) {
        removeAllViews();
        setSignRoomVos(list);
        this.f8612i = i2;
        if (roommatesBean != null) {
            View viewInflate = this.f8604a.inflate(R.layout.item_together_live_layout, (ViewGroup) null);
            this.f8606c = (EditText) viewInflate.findViewById(R.id.edt_user_info);
            this.f8607d = (EditText) viewInflate.findViewById(R.id.edt_phone);
            this.f8608e = (EditText) viewInflate.findViewById(R.id.edt_id_card);
            Button button = (Button) viewInflate.findViewById(R.id.btn_del_together);
            ((TextView) viewInflate.findViewById(R.id.tv_title)).setText(x.isNullStr(this.k) ? x.getString(R.string.title_together_live) : this.k);
            this.f8606c.setText(x.getNotNullStr(roommatesBean.getName(), ""));
            this.f8607d.setText(x.getNotNullStr(roommatesBean.getPhone(), ""));
            this.f8608e.setText(x.getNotNullStr(roommatesBean.getIdCardNo(), ""));
            this.f8606c.setEnabled(z);
            this.f8607d.setEnabled(z);
            this.f8608e.setEnabled(z);
            if (z) {
                this.f8606c.setTag(Integer.valueOf(i3));
                this.f8607d.setTag(Integer.valueOf(i3));
                this.f8608e.setTag(Integer.valueOf(i3));
                this.f8606c.removeTextChangedListener(this.o);
                this.f8607d.removeTextChangedListener(this.p);
                this.f8608e.removeTextChangedListener(this.f8613q);
                this.f8606c.addTextChangedListener(this.o);
                this.f8607d.addTextChangedListener(this.p);
                this.f8608e.addTextChangedListener(this.f8613q);
            }
            ImageView imageView = (ImageView) viewInflate.findViewById(R.id.img_right_icon);
            ImageView imageView2 = (ImageView) viewInflate.findViewById(R.id.img_right_phone_icon);
            ImageView imageView3 = (ImageView) viewInflate.findViewById(R.id.img_right_id_icon);
            ImageView imageView4 = (ImageView) viewInflate.findViewById(R.id.img_right_id_type_icon);
            ImageView imageView5 = (ImageView) viewInflate.findViewById(R.id.img_del_face);
            ImageView imageView6 = (ImageView) viewInflate.findViewById(R.id.img_del_back);
            imageView5.setTag(imageView5.getId(), Integer.valueOf(i3));
            imageView5.setTag(R.id.id_room_sign_id_card_position, Integer.valueOf(i2));
            imageView6.setTag(imageView6.getId(), Integer.valueOf(i3));
            imageView6.setTag(R.id.id_room_sign_id_card_position, Integer.valueOf(i2));
            imageView.setVisibility(z ? 0 : 4);
            imageView2.setVisibility(z ? 0 : 4);
            imageView3.setVisibility(z ? 0 : 4);
            imageView4.setVisibility(z ? 0 : 4);
            TextView textView = (TextView) viewInflate.findViewById(R.id.tv_right_value);
            this.f8609f = textView;
            textView.setTag(Integer.valueOf(i2));
            TextView textView2 = this.f8609f;
            textView2.setTag(textView2.getId(), Integer.valueOf(i3));
            this.f8609f.setOnClickListener(this.r);
            this.f8609f.setText(x.getNotNullStr(roommatesBean.getCardType(), x.getString(R.string.title_id_card)));
            TextView textView3 = (TextView) viewInflate.findViewById(R.id.tv_id_card_face_title);
            this.f8610g = textView3;
            textView3.setTag(Integer.valueOf(i2));
            TextView textView4 = this.f8610g;
            textView4.setTag(textView4.getId(), Integer.valueOf(i3));
            this.f8610g.setText(x.getNotNullStr(roommatesBean.getFaceName(), x.getString(R.string.title_id_card_face)));
            TextView textView5 = (TextView) viewInflate.findViewById(R.id.tv_id_card_back_title);
            this.f8611h = textView5;
            textView5.setTag(Integer.valueOf(i2));
            TextView textView6 = this.f8611h;
            textView6.setTag(textView6.getId(), Integer.valueOf(i3));
            this.f8611h.setText(x.getNotNullStr(roommatesBean.getBackName(), x.getString(R.string.title_id_card_back)));
            CoreRoundedImageView coreRoundedImageView = (CoreRoundedImageView) viewInflate.findViewById(R.id.img_id_face);
            CoreRoundedImageView coreRoundedImageView2 = (CoreRoundedImageView) viewInflate.findViewById(R.id.img_id_back);
            coreRoundedImageView.setVisibility(this.j ? 0 : 8);
            coreRoundedImageView2.setVisibility(this.j ? 0 : 8);
            coreRoundedImageView.setTag(coreRoundedImageView.getId(), Integer.valueOf(i3));
            coreRoundedImageView.setTag(R.id.id_room_sign_id_card_position, Integer.valueOf(i2));
            coreRoundedImageView2.setTag(coreRoundedImageView2.getId(), Integer.valueOf(i3));
            coreRoundedImageView2.setTag(R.id.id_room_sign_id_card_position, Integer.valueOf(i2));
            button.setTag(button.getId(), Integer.valueOf(i3));
            button.setTag(R.id.id_room_sign_id_del_position, Integer.valueOf(i2));
            boolean zIsNotNull = x.isNotNull(roommatesBean.getIdCardFront());
            boolean zIsNotNull2 = x.isNotNull(roommatesBean.getIdCardBack());
            if (zIsNotNull) {
                coreRoundedImageView.loadImageToUrl(roommatesBean.getIdCardFront());
            } else {
                coreRoundedImageView.loadImageToResId(R.mipmap.ic_id_card_face);
            }
            imageView5.setVisibility((z && zIsNotNull) ? 0 : 4);
            imageView6.setVisibility((z && zIsNotNull2) ? 0 : 4);
            button.setVisibility(z ? 0 : 4);
            if (!this.j) {
                button.setVisibility(4);
            }
            if (zIsNotNull2) {
                coreRoundedImageView2.loadImageToUrl(roommatesBean.getIdCardBack());
            } else {
                coreRoundedImageView2.loadImageToResId(R.mipmap.ic_id_card_back);
            }
            if (z) {
                coreRoundedImageView.setOnClickListener(onClickListener);
                coreRoundedImageView2.setOnClickListener(onClickListener);
                imageView5.setOnClickListener(onClickListener);
                imageView6.setOnClickListener(onClickListener);
                button.setOnClickListener(onClickListener);
            }
            addView(viewInflate);
        }
    }

    public TogetherLiveLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.j = true;
        this.o = new a();
        this.p = new b();
        this.f8613q = new c();
        this.r = new View.OnClickListener() { // from class: c.e.c.j0.d.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f1625a.f(view);
            }
        };
        d();
    }

    public TogetherLiveLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.j = true;
        this.o = new a();
        this.p = new b();
        this.f8613q = new c();
        this.r = new View.OnClickListener() { // from class: c.e.c.j0.d.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f1625a.f(view);
            }
        };
        d();
    }
}
