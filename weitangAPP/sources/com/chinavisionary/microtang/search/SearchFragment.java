package com.chinavisionary.microtang.search;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.chinavisionary.core.weight.BaseRecyclerView;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseFragment;
import com.chinavisionary.microtang.search.adapter.SearchAdapter;

/* JADX INFO: loaded from: classes2.dex */
public class SearchFragment extends BaseFragment<SearchVo> {
    public TextWatcher B = new a();

    @BindView(R.id.recycler_search_result)
    public BaseRecyclerView mRecyclerView;

    @BindView(R.id.edt_input_search)
    public EditText mSearchEdt;

    @BindView(R.id.tv_title)
    public TextView mTitleTv;

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
            SearchFragment.this.F1();
        }
    }

    public static SearchFragment getInstance() {
        return new SearchFragment();
    }

    public final void F1() {
        this.mSearchEdt.getText().toString();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        this.mTitleTv.setText(R.string.title_search);
        this.mSearchEdt.addTextChangedListener(this.B);
        this.r = this.mRecyclerView;
        this.t = new SearchAdapter();
    }

    @OnClick({R.id.tv_back})
    public void backClick(View view) {
        n();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_search;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void j0() {
    }
}
