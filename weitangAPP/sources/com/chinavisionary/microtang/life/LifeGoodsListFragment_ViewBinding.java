package com.chinavisionary.microtang.life;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import b.c.d;
import butterknife.Unbinder;
import com.chinavisionary.core.weight.BaseSwipeRefreshLayout;
import com.chinavisionary.microtang.R;

/* JADX INFO: loaded from: classes.dex */
public class LifeGoodsListFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LifeGoodsListFragment f7251b;

    @UiThread
    public LifeGoodsListFragment_ViewBinding(LifeGoodsListFragment lifeGoodsListFragment, View view) {
        this.f7251b = lifeGoodsListFragment;
        lifeGoodsListFragment.mBackImgView = (ImageView) d.findRequiredViewAsType(view, R.id.img_back, "field 'mBackImgView'", ImageView.class);
        lifeGoodsListFragment.mProductNameSearchEdt = (EditText) d.findRequiredViewAsType(view, R.id.edt_product_name_search, "field 'mProductNameSearchEdt'", EditText.class);
        lifeGoodsListFragment.mBaseSwipeRefreshLayout = (BaseSwipeRefreshLayout) d.findRequiredViewAsType(view, R.id.swipe_refresh_layout_life, "field 'mBaseSwipeRefreshLayout'", BaseSwipeRefreshLayout.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        LifeGoodsListFragment lifeGoodsListFragment = this.f7251b;
        if (lifeGoodsListFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f7251b = null;
        lifeGoodsListFragment.mBackImgView = null;
        lifeGoodsListFragment.mProductNameSearchEdt = null;
        lifeGoodsListFragment.mBaseSwipeRefreshLayout = null;
    }
}
