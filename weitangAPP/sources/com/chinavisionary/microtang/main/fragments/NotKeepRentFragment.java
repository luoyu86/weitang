package com.chinavisionary.microtang.main.fragments;

import android.view.View;
import android.widget.TextView;
import com.chinavisionary.core.app.config.bo.UserInfoVo;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseFragment;

/* JADX INFO: loaded from: classes.dex */
public class NotKeepRentFragment extends BaseFragment<String> {
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: E1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void F1(View view) {
        n();
    }

    public static NotKeepRentFragment getInstance() {
        return new NotKeepRentFragment();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        TextView textView = (TextView) this.u.findViewById(R.id.tv_user_name);
        UserInfoVo userInfoVoW = w();
        if (userInfoVoW != null) {
            textView.setText(userInfoVoW.getPersonName());
        }
        this.u.findViewById(R.id.btn_finish).setOnClickListener(new View.OnClickListener() { // from class: c.e.c.v.e.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f1909a.F1(view);
            }
        });
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_not_keep_rent;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    /* JADX INFO: renamed from: j0 */
    public void I1() {
    }
}
