package com.chinavisionary.microtang.me.fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import c.e.a.d.x;
import c.e.c.x.b.b;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseFragment;
import com.chinavisionary.microtang.me.event.EventUpdateNickName;
import g.b.a.m;
import g.b.a.r;

/* JADX INFO: loaded from: classes.dex */
public class UpdateNickNameFragment extends BaseFragment<String> {
    public b B;

    @BindView(R.id.img_del_edt)
    public ImageView mDelEdtImg;

    @BindView(R.id.edt_nick_name)
    public EditText mNickNameEdt;

    @BindView(R.id.tv_title_right)
    public TextView mTitleRightTv;

    @BindView(R.id.tv_title_split_line)
    public TextView mTitleSplitLineTv;

    @BindView(R.id.tv_title)
    public TextView mTitleTv;

    public class a implements TextWatcher {
        public a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            int i2 = UpdateNickNameFragment.this.mNickNameEdt.getText().toString().length() > 0 ? 0 : 8;
            if (i2 != UpdateNickNameFragment.this.mDelEdtImg.getVisibility()) {
                UpdateNickNameFragment.this.mDelEdtImg.setVisibility(i2);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }
    }

    public static UpdateNickNameFragment getInstance(b bVar, String str) {
        UpdateNickNameFragment updateNickNameFragment = new UpdateNickNameFragment();
        updateNickNameFragment.B = bVar;
        updateNickNameFragment.f6484b = str;
        return updateNickNameFragment;
    }

    public final void E1() {
        String string = this.mNickNameEdt.getText().toString();
        if (x.isNullStr(string)) {
            F0(R.string.tip_nickname_is_empty);
        } else {
            this.B.doUpdateNickName(string);
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
        int id = view.getId();
        if (id == R.id.img_del_edt) {
            this.mNickNameEdt.setText("");
        } else if (id == R.id.tv_title_right) {
            E1();
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        h0(this);
        this.mTitleTv.setText(R.string.title_nick_name);
        this.mTitleRightTv.setText(R.string.title_save);
        this.mNickNameEdt.setText(this.f6484b);
        TextView textView = this.mTitleRightTv;
        textView.setTextColor(textView.getResources().getColor(R.color.colorFE9900));
        this.mTitleRightTv.setOnClickListener(this.y);
        this.mTitleRightTv.setVisibility(0);
        this.mTitleSplitLineTv.setVisibility(0);
        this.mDelEdtImg.setOnClickListener(this.y);
        this.mNickNameEdt.addTextChangedListener(new a());
    }

    @OnClick({R.id.tv_back})
    public void backClick(View view) {
        n();
    }

    @m(threadMode = r.MAIN)
    public void eventUpdateNickNameResult(EventUpdateNickName eventUpdateNickName) {
        if (eventUpdateNickName.isSuccess()) {
            this.B.onSuccess(this.mNickNameEdt.getText().toString());
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_update_nick_name;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void j0() {
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        L0(this);
    }
}
