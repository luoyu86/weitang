package com.chinavisionary.microtang.service.adapter;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import b.c.d;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import c.e.a.d.q;
import c.e.a.d.x;
import com.alibaba.fastjson.JSON;
import com.chinavisionary.core.app.adapter.BaseRecyclerAdapter;
import com.chinavisionary.core.app.adapter.BaseRecyclerViewHolder;
import com.chinavisionary.core.app.net.base.dto.ResponseUploadImgVo;
import com.chinavisionary.core.app.net.base.dto.UploadResponseDto;
import com.chinavisionary.core.app.upload.UploadNineFragment;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.service.bo.DataSourceVo;
import com.chinavisionary.microtang.service.bo.ResponseFormTemplateDetailsVo;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ReasonFromAdapter extends BaseRecyclerAdapter<ResponseFormTemplateDetailsVo.ItemsBean> {
    public FragmentManager n;
    public int o;

    public static class InputAreaVh extends BaseRecyclerViewHolder<ResponseFormTemplateDetailsVo.ItemsBean> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public List<ResponseFormTemplateDetailsVo.ItemsBean> f8405f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public TextWatcher f8406g;

        @BindView(R.id.edt_msg)
        public EditText mEditText;

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
                String string = InputAreaVh.this.mEditText.getText().toString();
                if (InputAreaVh.this.f8405f == null || InputAreaVh.this.f8405f.get(InputAreaVh.this.f6468a) == null) {
                    return;
                }
                if (((ResponseFormTemplateDetailsVo.ItemsBean) InputAreaVh.this.f8405f.get(InputAreaVh.this.f6468a)).getDataSourceVo() != null) {
                    ((ResponseFormTemplateDetailsVo.ItemsBean) InputAreaVh.this.f8405f.get(InputAreaVh.this.f6468a)).getDataSourceVo().getDatasourceItems().get(0).setDatasourceItemValue(string);
                    return;
                }
                DataSourceVo dataSourceVo = new DataSourceVo();
                ArrayList arrayList = new ArrayList();
                DataSourceVo.DatasourceItemsBean datasourceItemsBean = new DataSourceVo.DatasourceItemsBean();
                datasourceItemsBean.setDatasourceItemValue(string);
                arrayList.add(datasourceItemsBean);
                dataSourceVo.setDatasourceItems(arrayList);
                ((ResponseFormTemplateDetailsVo.ItemsBean) InputAreaVh.this.f8405f.get(InputAreaVh.this.f6468a)).setDataSourceVo(dataSourceVo);
            }
        }

        public InputAreaVh(View view) {
            super(view);
            this.f8406g = new a();
            ButterKnife.bind(this, view);
        }

        public void l(ResponseFormTemplateDetailsVo.ItemsBean itemsBean) {
            this.mTitleTv.setText(x.getNotNullStr(itemsBean.getName(), ""));
            DataSourceVo dataSourceVo = itemsBean.getDataSourceVo();
            String datasourceItemValue = (dataSourceVo == null || dataSourceVo.getDatasourceItems() == null || dataSourceVo.getDatasourceItems().isEmpty()) ? null : dataSourceVo.getDatasourceItems().get(0).getDatasourceItemValue();
            this.mEditText.removeTextChangedListener(this.f8406g);
            this.mEditText.addTextChangedListener(this.f8406g);
            this.mEditText.setText(x.getNotNullStr(datasourceItemValue, ""));
        }

        public void m(List<ResponseFormTemplateDetailsVo.ItemsBean> list) {
            this.f8405f = list;
        }
    }

    public class InputAreaVh_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public InputAreaVh f8408b;

        @UiThread
        public InputAreaVh_ViewBinding(InputAreaVh inputAreaVh, View view) {
            this.f8408b = inputAreaVh;
            inputAreaVh.mTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title, "field 'mTitleTv'", TextView.class);
            inputAreaVh.mEditText = (EditText) d.findRequiredViewAsType(view, R.id.edt_msg, "field 'mEditText'", EditText.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            InputAreaVh inputAreaVh = this.f8408b;
            if (inputAreaVh == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f8408b = null;
            inputAreaVh.mTitleTv = null;
            inputAreaVh.mEditText = null;
        }
    }

    public static class InputVh extends BaseRecyclerViewHolder<ResponseFormTemplateDetailsVo.ItemsBean> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public List<ResponseFormTemplateDetailsVo.ItemsBean> f8409f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public TextWatcher f8410g;

        @BindView(R.id.edt_input)
        public AppCompatEditText mEditText;

        @BindView(R.id.tv_input_title)
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
                String string = InputVh.this.mEditText.getText().toString();
                q.d(a.class.getSimpleName(), "beforeTextChanged:" + string);
                if (InputVh.this.f8409f == null || InputVh.this.f8409f.get(InputVh.this.f6468a) == null) {
                    return;
                }
                if (((ResponseFormTemplateDetailsVo.ItemsBean) InputVh.this.f8409f.get(InputVh.this.f6468a)).getDataSourceVo() != null) {
                    ((ResponseFormTemplateDetailsVo.ItemsBean) InputVh.this.f8409f.get(InputVh.this.f6468a)).getDataSourceVo().getDatasourceItems().get(0).setDatasourceItemValue(string);
                    return;
                }
                DataSourceVo dataSourceVo = new DataSourceVo();
                ArrayList arrayList = new ArrayList();
                DataSourceVo.DatasourceItemsBean datasourceItemsBean = new DataSourceVo.DatasourceItemsBean();
                datasourceItemsBean.setDatasourceItemValue(string);
                arrayList.add(datasourceItemsBean);
                dataSourceVo.setDatasourceItems(arrayList);
                ((ResponseFormTemplateDetailsVo.ItemsBean) InputVh.this.f8409f.get(InputVh.this.f6468a)).setDataSourceVo(dataSourceVo);
            }
        }

        public InputVh(View view) {
            super(view);
            this.f8410g = new a();
            ButterKnife.bind(this, view);
        }

        public void l(ResponseFormTemplateDetailsVo.ItemsBean itemsBean) {
            this.mTitleTv.setText(x.getNotNullStr(itemsBean.getName(), ""));
            DataSourceVo dataSourceVo = itemsBean.getDataSourceVo();
            String datasourceItemValue = (dataSourceVo == null || dataSourceVo.getDatasourceItems() == null || dataSourceVo.getDatasourceItems().isEmpty()) ? null : dataSourceVo.getDatasourceItems().get(0).getDatasourceItemValue();
            this.mEditText.removeTextChangedListener(this.f8410g);
            this.mEditText.addTextChangedListener(this.f8410g);
            this.mEditText.setText(x.getNotNullStr(datasourceItemValue, ""));
        }

        public void m(List<ResponseFormTemplateDetailsVo.ItemsBean> list) {
            this.f8409f = list;
        }
    }

    public class InputVh_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public InputVh f8412b;

        @UiThread
        public InputVh_ViewBinding(InputVh inputVh, View view) {
            this.f8412b = inputVh;
            inputVh.mTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_input_title, "field 'mTitleTv'", TextView.class);
            inputVh.mEditText = (AppCompatEditText) d.findRequiredViewAsType(view, R.id.edt_input, "field 'mEditText'", AppCompatEditText.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            InputVh inputVh = this.f8412b;
            if (inputVh == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f8412b = null;
            inputVh.mTitleTv = null;
            inputVh.mEditText = null;
        }
    }

    public static class NinPicVh extends BaseRecyclerViewHolder<ResponseFormTemplateDetailsVo.ItemsBean> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public FragmentManager f8413f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public UploadNineFragment f8414g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public List<ResponseFormTemplateDetailsVo.ItemsBean> f8415h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public c.e.a.a.k.d f8416i;

        @BindView(R.id.tv_title)
        public TextView mTitleTv;

        public class a implements c.e.a.a.k.d {
            public a() {
            }

            @Override // c.e.a.a.k.d
            public void uploadFailed(String str) {
            }

            @Override // c.e.a.a.k.d
            public void uploadSuccess(UploadResponseDto uploadResponseDto) {
            }
        }

        public NinPicVh(View view) {
            super(view);
            this.f8416i = new a();
            ButterKnife.bind(this, view);
        }

        public void g(ResponseFormTemplateDetailsVo.ItemsBean itemsBean) {
            List<DataSourceVo.DatasourceItemsBean> datasourceItems;
            DataSourceVo dataSourceVo = itemsBean.getDataSourceVo();
            this.mTitleTv.setText(x.getNotNullStr(itemsBean.getName(), ""));
            if (dataSourceVo == null || (datasourceItems = dataSourceVo.getDatasourceItems()) == null || datasourceItems.isEmpty()) {
                return;
            }
            String datasourceItemValue = datasourceItems.get(0).getDatasourceItemValue();
            if (x.isNotNull(datasourceItemValue)) {
                this.f8414g.initAdapterData(JSON.parseArray(datasourceItemValue, ResponseUploadImgVo.class));
            }
        }

        public void h(FragmentManager fragmentManager, int i2) {
            this.f8413f = fragmentManager;
            this.f8414g = UploadNineFragment.getInstance(this.f8416i);
            String str = NinPicVh.class.getCanonicalName() + i2;
            if (this.f8413f.findFragmentByTag(str) == null) {
                this.f8413f.beginTransaction().add(R.id.fragment_upload_nine, this.f8414g, str).commit();
            }
        }

        public void i(List<ResponseFormTemplateDetailsVo.ItemsBean> list) {
            this.f8415h = list;
        }
    }

    public class NinPicVh_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public NinPicVh f8418b;

        @UiThread
        public NinPicVh_ViewBinding(NinPicVh ninPicVh, View view) {
            this.f8418b = ninPicVh;
            ninPicVh.mTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title, "field 'mTitleTv'", TextView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            NinPicVh ninPicVh = this.f8418b;
            if (ninPicVh == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f8418b = null;
            ninPicVh.mTitleTv = null;
        }
    }

    public static class RadioVh extends BaseRecyclerViewHolder<ResponseFormTemplateDetailsVo.ItemsBean> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public RadioGroup.LayoutParams f8419f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public List<ResponseFormTemplateDetailsVo.ItemsBean> f8420g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public RadioGroup.OnCheckedChangeListener f8421h;

        @BindView(R.id.radio_group)
        public RadioGroup mRadioGroup;

        @BindView(R.id.tv_radio_title)
        public TextView mTitleTv;

        public class a implements RadioGroup.OnCheckedChangeListener {
            public a() {
            }

            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public void onCheckedChanged(RadioGroup radioGroup, int i2) {
                RadioVh.this.m();
                ((ResponseFormTemplateDetailsVo.ItemsBean) RadioVh.this.f8420g.get(RadioVh.this.f6468a)).getDataSourceVo().getDatasourceItems().get(i2).setSelect(true);
            }
        }

        public RadioVh(View view) {
            super(view);
            this.f8419f = new RadioGroup.LayoutParams(-2, -2);
            this.f8421h = new a();
            ButterKnife.bind(this, view);
        }

        public final void j(ResponseFormTemplateDetailsVo.ItemsBean itemsBean) {
            this.mRadioGroup.removeAllViews();
            List<DataSourceVo.DatasourceItemsBean> datasourceItems = itemsBean.getDataSourceVo().getDatasourceItems();
            if (datasourceItems == null || datasourceItems.isEmpty()) {
                return;
            }
            int i2 = 0;
            for (DataSourceVo.DatasourceItemsBean datasourceItemsBean : datasourceItems) {
                if (datasourceItemsBean != null) {
                    String datasourceItemName = datasourceItemsBean.getDatasourceItemName();
                    RadioButton radioButton = new RadioButton(this.mRadioGroup.getContext());
                    radioButton.setId(i2);
                    radioButton.setLayoutParams(this.f8419f);
                    radioButton.setText(x.getNotNullStr(datasourceItemName, ""));
                    radioButton.setChecked(datasourceItemsBean.isSelect());
                    this.mRadioGroup.addView(radioButton);
                    i2++;
                }
            }
        }

        public void k(ResponseFormTemplateDetailsVo.ItemsBean itemsBean) {
            this.mTitleTv.setText(x.getNotNullStr(itemsBean.getName(), ""));
            j(itemsBean);
            this.mRadioGroup.setOnCheckedChangeListener(null);
            this.mRadioGroup.setOnCheckedChangeListener(this.f8421h);
        }

        public void l(List<ResponseFormTemplateDetailsVo.ItemsBean> list) {
            this.f8420g = list;
        }

        public final void m() {
            for (DataSourceVo.DatasourceItemsBean datasourceItemsBean : this.f8420g.get(this.f6468a).getDataSourceVo().getDatasourceItems()) {
                if (datasourceItemsBean != null) {
                    datasourceItemsBean.setSelect(false);
                }
            }
        }
    }

    public class RadioVh_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public RadioVh f8423b;

        @UiThread
        public RadioVh_ViewBinding(RadioVh radioVh, View view) {
            this.f8423b = radioVh;
            radioVh.mTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_radio_title, "field 'mTitleTv'", TextView.class);
            radioVh.mRadioGroup = (RadioGroup) d.findRequiredViewAsType(view, R.id.radio_group, "field 'mRadioGroup'", RadioGroup.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            RadioVh radioVh = this.f8423b;
            if (radioVh == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f8423b = null;
            radioVh.mTitleTv = null;
            radioVh.mRadioGroup = null;
        }
    }

    public static class SelectVh extends BaseRecyclerViewHolder<ResponseFormTemplateDetailsVo.ItemsBean> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public View.OnClickListener f8424f;

        @BindView(R.id.tv_left)
        public TextView mLeftTv;

        @BindView(R.id.tv_right_value)
        public TextView mValueTv;

        public SelectVh(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        public final String g(List<DataSourceVo.DatasourceItemsBean> list) {
            String datasourceItemName = null;
            if (list == null || list.isEmpty()) {
                return null;
            }
            for (DataSourceVo.DatasourceItemsBean datasourceItemsBean : list) {
                if (datasourceItemsBean != null && datasourceItemsBean.isSelect()) {
                    datasourceItemName = datasourceItemsBean.getDatasourceItemName();
                }
            }
            if (!x.isNullStr(datasourceItemName)) {
                return datasourceItemName;
            }
            list.get(0).setSelect(true);
            return list.get(0).getDatasourceItemName();
        }

        public void h(ResponseFormTemplateDetailsVo.ItemsBean itemsBean) {
            this.mLeftTv.setText(x.getNotNullStr(itemsBean.getName(), ""));
            DataSourceVo dataSourceVo = itemsBean.getDataSourceVo();
            String string = x.getString(R.string.title_please_select);
            if (dataSourceVo != null) {
                string = g(dataSourceVo.getDatasourceItems());
            }
            this.mValueTv.setText(x.getNotNullStr(string, ""));
            this.mValueTv.setTag(Integer.valueOf(this.f6468a));
            this.mValueTv.setOnClickListener(null);
            this.mValueTv.setOnClickListener(this.f8424f);
        }

        public void setOnClickListener(View.OnClickListener onClickListener) {
            this.f8424f = onClickListener;
        }
    }

    public class SelectVh_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public SelectVh f8425b;

        @UiThread
        public SelectVh_ViewBinding(SelectVh selectVh, View view) {
            this.f8425b = selectVh;
            selectVh.mLeftTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_left, "field 'mLeftTv'", TextView.class);
            selectVh.mValueTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_right_value, "field 'mValueTv'", TextView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            SelectVh selectVh = this.f8425b;
            if (selectVh == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f8425b = null;
            selectVh.mLeftTv = null;
            selectVh.mValueTv = null;
        }
    }

    public static class TextVh extends BaseRecyclerViewHolder<ResponseFormTemplateDetailsVo.ItemsBean> {

        @BindView(R.id.tv_text)
        public TextView mTextView;

        public TextVh(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        public void g(ResponseFormTemplateDetailsVo.ItemsBean itemsBean) {
            this.mTextView.setText(x.getNotNullStr(itemsBean.getName(), ""));
        }
    }

    public class TextVh_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public TextVh f8426b;

        @UiThread
        public TextVh_ViewBinding(TextVh textVh, View view) {
            this.f8426b = textVh;
            textVh.mTextView = (TextView) d.findRequiredViewAsType(view, R.id.tv_text, "field 'mTextView'", TextView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            TextVh textVh = this.f8426b;
            if (textVh == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f8426b = null;
            textVh.mTextView = null;
        }
    }

    public ReasonFromAdapter(FragmentManager fragmentManager) {
        this.n = fragmentManager;
    }

    @Override // com.chinavisionary.core.app.adapter.BaseRecyclerAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        List<T> list = this.f6460b;
        return list != 0 ? ((ResponseFormTemplateDetailsVo.ItemsBean) list.get(i2)).getType() : super.getItemViewType(i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i2) {
        int itemViewType = viewHolder.getItemViewType();
        if (itemViewType == 0) {
            InputVh inputVh = (InputVh) viewHolder;
            inputVh.setListPosition(i2);
            inputVh.m(this.f6460b);
            inputVh.l((ResponseFormTemplateDetailsVo.ItemsBean) this.f6460b.get(i2));
            return;
        }
        if (itemViewType == 2) {
            RadioVh radioVh = (RadioVh) viewHolder;
            radioVh.setListPosition(i2);
            radioVh.l(this.f6460b);
            radioVh.k((ResponseFormTemplateDetailsVo.ItemsBean) this.f6460b.get(i2));
            return;
        }
        if (itemViewType == 10) {
            SelectVh selectVh = (SelectVh) viewHolder;
            selectVh.setListPosition(i2);
            selectVh.h((ResponseFormTemplateDetailsVo.ItemsBean) this.f6460b.get(i2));
            return;
        }
        if (itemViewType == 6) {
            InputAreaVh inputAreaVh = (InputAreaVh) viewHolder;
            inputAreaVh.setListPosition(i2);
            inputAreaVh.m(this.f6460b);
            inputAreaVh.l((ResponseFormTemplateDetailsVo.ItemsBean) this.f6460b.get(i2));
            return;
        }
        if (itemViewType != 7) {
            if (viewHolder instanceof TextVh) {
                ((TextVh) viewHolder).g((ResponseFormTemplateDetailsVo.ItemsBean) this.f6460b.get(i2));
            }
        } else {
            NinPicVh ninPicVh = (NinPicVh) viewHolder;
            ninPicVh.setListPosition(i2);
            ninPicVh.i(this.f6460b);
            ninPicVh.g((ResponseFormTemplateDetailsVo.ItemsBean) this.f6460b.get(i2));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        if (i2 == 0) {
            View viewI = i(viewGroup, R.layout.item_form_input_layout);
            InputVh inputVh = new InputVh(viewI);
            viewI.setTag(inputVh);
            return inputVh;
        }
        if (i2 == 2) {
            View viewI2 = i(viewGroup, R.layout.item_form_radio_layout);
            RadioVh radioVh = new RadioVh(viewI2);
            viewI2.setTag(radioVh);
            return radioVh;
        }
        if (i2 == 10) {
            View viewI3 = i(viewGroup, R.layout.item_select_layout);
            SelectVh selectVh = new SelectVh(viewI3);
            selectVh.setOnClickListener(this.f6461c);
            viewI3.setTag(selectVh);
            return selectVh;
        }
        if (i2 == 6) {
            View viewI4 = i(viewGroup, R.layout.item_input_layout);
            InputAreaVh inputAreaVh = new InputAreaVh(viewI4);
            viewI4.setTag(inputAreaVh);
            return inputAreaVh;
        }
        if (i2 != 7) {
            return new TextVh(i(viewGroup, R.layout.item_text_layout));
        }
        this.o++;
        View viewI5 = i(viewGroup, R.layout.item_upload_image_layout);
        NinPicVh ninPicVh = new NinPicVh(viewI5);
        ninPicVh.h(this.n, this.o);
        viewI5.setTag(ninPicVh);
        return ninPicVh;
    }
}
