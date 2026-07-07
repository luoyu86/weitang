package com.chinavisionary.microtang.service.fragment;

import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import butterknife.BindView;
import butterknife.OnClick;
import c.b.a.d.e;
import c.b.a.f.b;
import c.e.a.a.k.d;
import c.e.a.d.o;
import c.e.a.d.w;
import c.e.a.d.x;
import com.alibaba.fastjson.JSON;
import com.chinavisionary.core.app.config.bo.AppConfigExtVo;
import com.chinavisionary.core.app.net.base.dto.RequestErrDto;
import com.chinavisionary.core.app.net.base.dto.ResponseRowsVo;
import com.chinavisionary.core.app.net.base.dto.ResponseStateVo;
import com.chinavisionary.core.app.net.base.dto.ResponseUploadImgVo;
import com.chinavisionary.core.app.net.base.dto.UploadResponseDto;
import com.chinavisionary.core.app.upload.UploadNineFragment;
import com.chinavisionary.core.weight.BaseSwipeRefreshLayout;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseFragment;
import com.chinavisionary.microtang.me.model.UserOperateModel;
import com.chinavisionary.microtang.service.adapter.ReasonFromAdapter;
import com.chinavisionary.microtang.service.bo.CreateFormBo;
import com.chinavisionary.microtang.service.bo.DataSourceVo;
import com.chinavisionary.microtang.service.bo.ResponseFormBo;
import com.chinavisionary.microtang.service.bo.ResponseFormTemplateDetailsVo;
import com.chinavisionary.microtang.service.model.CustomerServiceModel;
import com.chinavisionary.microtang.service.model.TemplateModel;
import com.chinavisionary.microtang.service.vo.EventUpdateReasonVo;
import com.chinavisionary.microtang.service.vo.QuestionsTemplateVo;
import com.chinavisionary.microtang.service.vo.RequestCreateQuestionsFromVo;
import g.b.a.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class SubmitReasonFragment extends BaseFragment<ResponseFormTemplateDetailsVo.ItemsBean> {
    public b<String> B;
    public List<ResponseFormTemplateDetailsVo.ItemsBean> C;
    public TemplateModel D;
    public CustomerServiceModel E;
    public UserOperateModel F;
    public String G;
    public Map<String, Integer> H;
    public int I;
    public int J;
    public String K;
    public int L;

    @BindView(R.id.tv_alert_content)
    public TextView mAlertContentTv;

    @BindView(R.id.swipe_refresh_layout)
    public BaseSwipeRefreshLayout mSwipeRefreshLayout;

    @BindView(R.id.tv_title)
    public TextView mTitleTv;

    public class a implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f8461a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ List f8462b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ CreateFormBo f8463c;

        public a(int i2, List list, CreateFormBo createFormBo) {
            this.f8461a = i2;
            this.f8462b = list;
            this.f8463c = createFormBo;
        }

        @Override // c.e.a.a.k.d
        public void uploadFailed(String str) {
            SubmitReasonFragment.this.F0(R.string.tip_upload_failed);
        }

        @Override // c.e.a.a.k.d
        public void uploadSuccess(UploadResponseDto uploadResponseDto) {
            List<ResponseUploadImgVo> uploadSuccessList = uploadResponseDto.getUploadSuccessList();
            if (SubmitReasonFragment.this.C != null) {
                ArrayList arrayList = new ArrayList();
                DataSourceVo.DatasourceItemsBean datasourceItemsBean = new DataSourceVo.DatasourceItemsBean();
                datasourceItemsBean.setDatasourceItemValue(JSON.toJSONString(uploadSuccessList));
                arrayList.add(datasourceItemsBean);
                DataSourceVo dataSourceVo = ((ResponseFormTemplateDetailsVo.ItemsBean) SubmitReasonFragment.this.t.getList().get(this.f8461a)).getDataSourceVo();
                if (dataSourceVo == null) {
                    dataSourceVo = new DataSourceVo();
                }
                dataSourceVo.setDatasourceItems(arrayList);
                ((ResponseFormTemplateDetailsVo.ItemsBean) SubmitReasonFragment.this.t.getList().get(this.f8461a)).setDataSourceVo(dataSourceVo);
                ((CreateFormBo.ItemsBean) this.f8462b.get(this.f8461a)).setValue(datasourceItemsBean.getDatasourceItemValue());
                SubmitReasonFragment.this.z0(R.string.tip_submit_data_loading);
                SubmitReasonFragment.this.D.createTemplate(this.f8463c);
            }
        }
    }

    public static SubmitReasonFragment getInstance(int i2) {
        SubmitReasonFragment submitReasonFragment = new SubmitReasonFragment();
        submitReasonFragment.L = i2;
        return submitReasonFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /* JADX INFO: renamed from: j2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void k2(int i2, int i3, int i4, View view) {
        this.J = i2;
        DataSourceVo dataSourceVo = ((ResponseFormTemplateDetailsVo.ItemsBean) this.t.getList().get(this.I)).getDataSourceVo();
        if (dataSourceVo.getDatasourceItems() == null || dataSourceVo.getDatasourceItems().isEmpty()) {
            return;
        }
        u2(dataSourceVo.getDatasourceItems());
        dataSourceVo.getDatasourceItems().get(this.J).setSelect(true);
        this.t.notifyItemChanged(this.I);
        if (this.I == 0 && o.isNotEmpty(dataSourceVo.getDatasourceItems())) {
            v2(dataSourceVo.getDatasourceItems().get(this.J).getDatasourceItemKey());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: l2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void m2(ResponseFormBo responseFormBo) {
        t2();
    }

    private void o0() {
        this.r = this.mSwipeRefreshLayout.getBaseRecyclerView();
        ReasonFromAdapter reasonFromAdapter = new ReasonFromAdapter(getFragmentManager());
        this.t = reasonFromAdapter;
        reasonFromAdapter.setOnClickListener(this.y);
    }

    public final List<UploadNineFragment> K1(List<String> list) {
        ArrayList arrayList = new ArrayList();
        FragmentManager fragmentManager = getFragmentManager();
        for (String str : list) {
            if (fragmentManager != null) {
                Fragment fragmentFindFragmentByTag = fragmentManager.findFragmentByTag(str);
                if (fragmentFindFragmentByTag instanceof UploadNineFragment) {
                    UploadNineFragment uploadNineFragment = (UploadNineFragment) fragmentFindFragmentByTag;
                    if (uploadNineFragment.isExitsAddPic()) {
                        arrayList.add(uploadNineFragment);
                    }
                }
            }
        }
        return arrayList;
    }

    public final List<String> L1(List<DataSourceVo.DatasourceItemsBean> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                DataSourceVo.DatasourceItemsBean datasourceItemsBean = list.get(i2);
                if (datasourceItemsBean != null) {
                    String datasourceItemName = datasourceItemsBean.getDatasourceItemName();
                    if (x.isNotNull(datasourceItemName)) {
                        arrayList.add(datasourceItemName);
                    }
                    if (datasourceItemsBean.isSelect()) {
                        this.J = i2;
                    }
                }
            }
        }
        return arrayList;
    }

    public final void M1(ResponseStateVo responseStateVo) {
        t2();
        if (F(responseStateVo, R.string.tip_submit_success, R.string.tip_submit_failed)) {
            c.getDefault().post(new EventUpdateReasonVo());
            g0();
        }
    }

    public final void N1(ResponseRowsVo<DataSourceVo> responseRowsVo) {
        if (responseRowsVo != null) {
            List<DataSourceVo> rows = responseRowsVo.getRows();
            if (rows != null) {
                for (DataSourceVo dataSourceVo : rows) {
                    if (dataSourceVo != null) {
                        String datasourceKey = dataSourceVo.getDatasourceKey();
                        Map<String, Integer> map = this.H;
                        if (map != null && map.containsKey(datasourceKey)) {
                            this.C.get(this.H.get(datasourceKey).intValue()).setDataSourceVo(dataSourceVo);
                        }
                    }
                }
            }
            D(this.C);
        }
        t2();
    }

    public final boolean O1(DataSourceVo dataSourceVo, CreateFormBo.ItemsBean itemsBean) {
        List<DataSourceVo.DatasourceItemsBean> datasourceItems;
        if (dataSourceVo == null || (datasourceItems = dataSourceVo.getDatasourceItems()) == null || datasourceItems.isEmpty()) {
            return false;
        }
        i(JSON.toJSONString(datasourceItems));
        DataSourceVo.DatasourceItemsBean datasourceItemsBean = datasourceItems.get(0);
        if (datasourceItemsBean != null && x.isNotNull(datasourceItemsBean.getDatasourceItemValue())) {
            itemsBean.setValue(datasourceItemsBean.getDatasourceItemValue());
            return false;
        }
        H();
        F0(R.string.title_input_reason);
        return true;
    }

    public final void P1(ResponseStateVo responseStateVo) {
        if (responseStateVo == null || !x.isNotNull(responseStateVo.getData())) {
            return;
        }
        this.mAlertContentTv.setText(responseStateVo.getData());
    }

    public final void Q1(List<String> list) {
        Fragment fragmentFindFragmentByTag;
        FragmentManager fragmentManager = getFragmentManager();
        for (String str : list) {
            if (fragmentManager != null && (fragmentFindFragmentByTag = fragmentManager.findFragmentByTag(str)) != null) {
                fragmentManager.beginTransaction().remove(fragmentFindFragmentByTag).commitAllowingStateLoss();
            }
        }
    }

    public final void R1(RequestErrDto requestErrDto) {
        t2();
        C(requestErrDto);
    }

    public final void S1(View view) {
        this.I = ((Integer) view.getTag()).intValue();
        DataSourceVo dataSourceVo = ((ResponseFormTemplateDetailsVo.ItemsBean) this.t.getList().get(this.I)).getDataSourceVo();
        if (dataSourceVo != null) {
            q2(L1(dataSourceVo.getDatasourceItems()));
        }
    }

    public final void T1(DataSourceVo dataSourceVo, CreateFormBo.ItemsBean itemsBean, List<CreateFormBo.ItemsBean.DatasourceItemsBean> list) {
        List<DataSourceVo.DatasourceItemsBean> datasourceItems;
        if (dataSourceVo == null || (datasourceItems = dataSourceVo.getDatasourceItems()) == null || datasourceItems.isEmpty()) {
            return;
        }
        for (DataSourceVo.DatasourceItemsBean datasourceItemsBean : datasourceItems) {
            if (datasourceItemsBean != null && datasourceItemsBean.isSelect()) {
                CreateFormBo.ItemsBean.DatasourceItemsBean datasourceItemsBean2 = new CreateFormBo.ItemsBean.DatasourceItemsBean();
                datasourceItemsBean2.setKey(datasourceItemsBean.getDatasourceItemKey());
                datasourceItemsBean2.setValue(datasourceItemsBean.getDatasourceItemValue());
                datasourceItemsBean2.setName(datasourceItemsBean.getDatasourceItemName());
                list.add(datasourceItemsBean2);
            }
        }
        if (list.isEmpty()) {
            return;
        }
        itemsBean.setValue(JSON.toJSONString(list.get(0)));
        itemsBean.setDatasourceItems(list);
    }

    public final void U1(DataSourceVo dataSourceVo) {
        if (dataSourceVo != null) {
            String datasourceKey = dataSourceVo.getDatasourceKey();
            Map<String, Integer> map = this.H;
            if (map != null && map.containsKey(datasourceKey)) {
                int iIntValue = this.H.get(datasourceKey).intValue();
                if (iIntValue == 0 && o.isNotEmpty(dataSourceVo.getDatasourceItems())) {
                    v2(dataSourceVo.getDatasourceItems().get(0).getDatasourceItemKey());
                }
                this.C.get(iIntValue).setDataSourceVo(dataSourceVo);
            }
        }
        D(this.C);
        t2();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
        if (view.getId() == R.id.tv_right_value) {
            S1(view);
        }
    }

    public final void V1(String str) {
        if (str != null) {
            RequestCreateQuestionsFromVo requestCreateQuestionsFromVo = new RequestCreateQuestionsFromVo();
            requestCreateQuestionsFromVo.setFormKey(str);
            requestCreateQuestionsFromVo.setType(Integer.valueOf(this.L));
            this.E.createQuestion(requestCreateQuestionsFromVo);
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        Y1();
        o0();
        r2();
        p2();
        z0(R.string.loading_text);
        S();
    }

    public final void W1(ResponseFormTemplateDetailsVo responseFormTemplateDetailsVo) {
        if (responseFormTemplateDetailsVo == null || responseFormTemplateDetailsVo.getItems() == null) {
            return;
        }
        this.C = responseFormTemplateDetailsVo.getItems();
        Z1();
    }

    public final void X1(QuestionsTemplateVo questionsTemplateVo) {
        if (questionsTemplateVo != null) {
            String templateKey = questionsTemplateVo.getTemplateKey();
            this.G = templateKey;
            if (templateKey != null) {
                this.D.getFormTemplateDetails(templateKey);
            } else {
                H();
                F0(R.string.data_error);
            }
        }
    }

    public final void Y1() {
        this.mTitleTv.setText(this.L == 1 ? R.string.title_me_submit_reason : R.string.title_me_submit_consult);
        AppConfigExtVo appConfigExtVoO = o();
        String string = getString(R.string.title_default_phone);
        if (appConfigExtVoO != null) {
            String customerServicePhone = appConfigExtVoO.getCustomerServicePhone();
            if (x.isNotNull(customerServicePhone)) {
                string = customerServicePhone;
            }
        }
        this.mAlertContentTv.setText(string);
        this.H = new HashMap();
        this.K = w.getInstance().getString("selectProjectKey", null);
    }

    public final void Z1() {
        this.H.clear();
        int size = this.C.size();
        for (int i2 = 0; i2 < size; i2++) {
            ResponseFormTemplateDetailsVo.ItemsBean itemsBean = this.C.get(i2);
            if (itemsBean != null && x.isNotNull(itemsBean.getDataSourceKey())) {
                this.H.put(itemsBean.getDataSourceKey(), Integer.valueOf(i2));
                this.D.getFormDataSource(itemsBean.getDataSourceKey());
            }
        }
    }

    public final List<UploadNineFragment> a2() {
        List list = this.t.getList();
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            int size = list.size();
            int i2 = 1;
            for (int i3 = 0; i3 < size; i3++) {
                ResponseFormTemplateDetailsVo.ItemsBean itemsBean = (ResponseFormTemplateDetailsVo.ItemsBean) list.get(i3);
                if (itemsBean != null && itemsBean.getType() == 7) {
                    arrayList.add(ReasonFromAdapter.NinPicVh.class.getCanonicalName() + i2);
                    i2++;
                }
            }
        }
        return K1(arrayList);
    }

    @OnClick({R.id.tv_back})
    public void backClick(View view) {
        n();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_submit_reason;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    /* JADX INFO: renamed from: j0 */
    public void S() {
        this.E.getTemplateKey();
    }

    public final void o2() {
        List list = this.t.getList();
        ArrayList arrayList = new ArrayList();
        if (list == null || list.isEmpty()) {
            return;
        }
        int size = list.size();
        int i2 = 1;
        for (int i3 = 0; i3 < size; i3++) {
            ResponseFormTemplateDetailsVo.ItemsBean itemsBean = (ResponseFormTemplateDetailsVo.ItemsBean) list.get(i3);
            if (itemsBean != null && itemsBean.getType() == 7) {
                arrayList.add(ReasonFromAdapter.NinPicVh.class.getCanonicalName() + i2);
                i2++;
            }
        }
        Q1(arrayList);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        try {
            o2();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        super.onDestroy();
    }

    public final void p2() {
        CustomerServiceModel customerServiceModel = (CustomerServiceModel) h(CustomerServiceModel.class);
        this.E = customerServiceModel;
        customerServiceModel.getCreateResult().observe(this, new Observer() { // from class: c.e.c.i0.b.b0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1546a.M1((ResponseStateVo) obj);
            }
        });
        this.E.getTemplateResult().observe(this, new Observer() { // from class: c.e.c.i0.b.a0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1544a.X1((QuestionsTemplateVo) obj);
            }
        });
        this.E.getErrRequestLiveData().observe(this, new Observer() { // from class: c.e.c.i0.b.f0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1554a.C((RequestErrDto) obj);
            }
        });
    }

    public final void q2(List<String> list) {
        b<String> bVarBuild = new c.b.a.b.a(this.f6487e, new e() { // from class: c.e.c.i0.b.c0
            @Override // c.b.a.d.e
            public final void onOptionsSelect(int i2, int i3, int i4, View view) {
                this.f1548a.k2(i2, i3, i4, view);
            }
        }).build();
        this.B = bVarBuild;
        bVarBuild.setPicker(list);
        this.B.setSelectOptions(this.J);
        this.B.show();
    }

    public final void r2() {
        s2();
        TemplateModel templateModel = (TemplateModel) h(TemplateModel.class);
        this.D = templateModel;
        templateModel.getBoMutableLiveData().observe(this, new Observer() { // from class: c.e.c.i0.b.h0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1558a.m2((ResponseFormBo) obj);
            }
        });
        this.D.getResult().observe(this, new Observer() { // from class: c.e.c.i0.b.e0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1552a.V1((String) obj);
            }
        });
        this.D.getDataSourceResultList().observe(this, new Observer() { // from class: c.e.c.i0.b.g0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1556a.N1((ResponseRowsVo) obj);
            }
        });
        this.D.getDataSourceResult().observe(this, new Observer() { // from class: c.e.c.i0.b.x
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1575a.U1((DataSourceVo) obj);
            }
        });
        this.D.getTemplateDetailsResult().observe(this, new Observer() { // from class: c.e.c.i0.b.z
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1577a.W1((ResponseFormTemplateDetailsVo) obj);
            }
        });
        this.D.getErrRequestLiveData().observe(this, new Observer() { // from class: c.e.c.i0.b.d0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1550a.R1((RequestErrDto) obj);
            }
        });
    }

    public final void s2() {
        UserOperateModel userOperateModel = (UserOperateModel) h(UserOperateModel.class);
        this.F = userOperateModel;
        userOperateModel.getAppPhoneResult().observeForever(new Observer() { // from class: c.e.c.i0.b.y
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1576a.P1((ResponseStateVo) obj);
            }
        });
        v2(null);
    }

    @OnClick({R.id.btn_submit})
    public void submitReason(View view) {
        z0(R.string.tip_submit_data_loading);
        List<UploadNineFragment> arrayList = new ArrayList<>();
        CreateFormBo createFormBo = new CreateFormBo();
        createFormBo.setFormTemplateKey(this.G);
        ArrayList arrayList2 = new ArrayList();
        List list = this.t.getList();
        int size = list.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            ResponseFormTemplateDetailsVo.ItemsBean itemsBean = (ResponseFormTemplateDetailsVo.ItemsBean) list.get(i3);
            CreateFormBo.ItemsBean itemsBean2 = new CreateFormBo.ItemsBean();
            itemsBean2.setFormTemplateItemKey(itemsBean.getFormTemplateItemKey());
            DataSourceVo dataSourceVo = itemsBean.getDataSourceVo();
            ArrayList arrayList3 = new ArrayList();
            int type = itemsBean.getType();
            if (type == 6) {
                if (O1(dataSourceVo, itemsBean2)) {
                    return;
                }
            } else if (type == 7) {
                arrayList = a2();
                i2 = i3;
            } else if (type == 10) {
                T1(dataSourceVo, itemsBean2, arrayList3);
            }
            arrayList2.add(itemsBean2);
        }
        createFormBo.setItems(arrayList2);
        if (arrayList.isEmpty()) {
            this.D.createTemplate(createFormBo);
        } else {
            w2(arrayList, i2, createFormBo, arrayList2);
        }
    }

    public final void t2() {
        H();
        this.mSwipeRefreshLayout.setRefreshing(false);
    }

    public final void u2(List<DataSourceVo.DatasourceItemsBean> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (DataSourceVo.DatasourceItemsBean datasourceItemsBean : list) {
            if (datasourceItemsBean != null) {
                datasourceItemsBean.setSelect(false);
            }
        }
    }

    public final void v2(String str) {
        UserOperateModel userOperateModel = this.F;
        if (userOperateModel != null) {
            userOperateModel.getAppPhoneConfig(this.K, str);
        }
    }

    public final void w2(List<UploadNineFragment> list, int i2, CreateFormBo createFormBo, List<CreateFormBo.ItemsBean> list2) {
        H();
        for (UploadNineFragment uploadNineFragment : list) {
            uploadNineFragment.setIUploadCallback(new a(i2, list2, createFormBo));
            uploadNineFragment.uploadPic();
        }
    }
}
