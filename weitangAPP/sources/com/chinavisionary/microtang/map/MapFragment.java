package com.chinavisionary.microtang.map;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import butterknife.BindView;
import butterknife.OnClick;
import c.e.a.d.r;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseFragment;

/* JADX INFO: loaded from: classes.dex */
public class MapFragment extends BaseFragment {

    @BindView(R.id.tv_address)
    public TextView mAddressTv;

    @BindView(R.id.view_bg)
    public View mBgView;

    @BindView(R.id.img_navigation)
    public ImageView mNavigationImg;

    @BindView(R.id.tv_title)
    public TextView mTitleTv;

    public final void E1() {
        C0();
    }

    public final void F1() {
    }

    public final void G1() {
        this.mTitleTv.setText(R.string.title_map);
        this.mNavigationImg.setOnClickListener(this.y);
    }

    public final void H1() {
    }

    public final void I1() {
    }

    public final void J1() {
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
        int id = view.getId();
        if (id == R.id.img_navigation) {
            E1();
        } else if (id == R.id.tv_baidu) {
            H1();
        } else {
            if (id != R.id.tv_gd) {
                return;
            }
            I1();
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        G1();
        F1();
        J1();
        requestPermissions(r.getLocationPermissions(), 1);
    }

    @OnClick({R.id.tv_back})
    public void backClick() {
        m();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_map;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void j0() {
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
    }
}
