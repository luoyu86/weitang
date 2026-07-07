package com.chinavisionary.microtang.tip;

import android.view.View;
import android.widget.TextView;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseFragment;

/* JADX INFO: loaded from: classes2.dex */
public class ServerBusyFragment extends BaseFragment<String> {
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: E1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void F1(View view) {
        n();
    }

    public static ServerBusyFragment getInstance() {
        return new ServerBusyFragment();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        TextView textView = (TextView) this.u.findViewById(R.id.tv_back);
        ((TextView) this.u.findViewById(R.id.tv_title)).setText(R.string.title_alert_tip);
        textView.setOnClickListener(new View.OnClickListener() { // from class: c.e.c.l0.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f1651a.F1(view);
            }
        });
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_server_busy;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void j0() {
    }
}
