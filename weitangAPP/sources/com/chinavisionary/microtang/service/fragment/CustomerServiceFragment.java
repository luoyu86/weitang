package com.chinavisionary.microtang.service.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import butterknife.BindView;
import butterknife.OnClick;
import c.b.a.d.e;
import c.b.a.f.b;
import c.e.a.a.c.c.a;
import c.e.a.d.q;
import c.e.a.d.x;
import com.chinavisionary.core.app.config.bo.AppConfigExtVo;
import com.chinavisionary.core.app.net.base.dto.RequestErrDto;
import com.chinavisionary.core.app.net.base.dto.ResponseStateVo;
import com.chinavisionary.core.app.net.base.dto.ResponseUploadImgVo;
import com.chinavisionary.core.app.net.base.dto.UploadResponseDto;
import com.chinavisionary.core.weight.BaseRecyclerView;
import com.chinavisionary.core.weight.BaseSwipeRefreshLayout;
import com.chinavisionary.framework.mobile.comment.vo.CommentListItemVo;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseFragment;
import com.chinavisionary.microtang.clean.adapter.CleanCommendAdapter;
import com.chinavisionary.microtang.comment.adapter.CommentPicAdapter;
import com.chinavisionary.microtang.me.model.UserOperateModel;
import com.chinavisionary.microtang.repair.adapter.RepairGridSpecItemDecoration;
import com.chinavisionary.microtang.repair.vo.ResponseVo;
import com.chinavisionary.microtang.service.bo.ResponseFormBo;
import com.chinavisionary.microtang.service.fragment.CustomerServiceFragment;
import com.chinavisionary.microtang.service.model.CustomerServiceModel;
import com.chinavisionary.microtang.service.model.TemplateModel;
import com.chinavisionary.microtang.service.vo.QuestionsCategoriesVo;
import com.chinavisionary.microtang.service.vo.RequestCustomerVo;
import com.lzy.imagepicker.bean.ImageItem;
import com.lzy.imagepicker.ui.ImageGridActivity;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public class CustomerServiceFragment extends BaseFragment<CommentListItemVo> {
    public CommentPicAdapter B;
    public int C;
    public List<ImageItem> D;
    public List<QuestionsCategoriesVo> E;
    public List<QuestionsCategoriesVo> F;
    public CustomerServiceModel G;
    public UserOperateModel H;
    public TemplateModel I;
    public b J;
    public b K;
    public int L;
    public int M;
    public a N = new a() { // from class: c.e.c.i0.b.h
        @Override // c.e.a.a.c.c.a
        public final void onItemClickListener(View view, int i2) {
            this.f1557a.W1(view, i2);
        }
    };

    @BindView(R.id.swipe_refresh_layout)
    public BaseSwipeRefreshLayout mBaseSwipeRefreshLayout;

    @BindView(R.id.nine_grid_view_commend)
    public BaseRecyclerView mNineGridView;

    @BindView(R.id.tv_phone)
    public TextView mPhoneTv;

    @BindView(R.id.tv_question_value)
    public TextView mQuestionCategoriesTv;

    @BindView(R.id.edt_question_info)
    public EditText mQuestionInfoEdt;

    @BindView(R.id.tv_common_question_value)
    public TextView mQuestionTv;

    @BindView(R.id.tv_title_split_line)
    public TextView mSplitLineTv;

    @BindView(R.id.tv_title_right)
    public TextView mTitleRightTv;

    @BindView(R.id.tv_title)
    public TextView mTitleTv;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: V1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void W1(View view, int i2) {
        if (i2 != this.D.size() - 1 || this.D.size() >= 9) {
            this.C = i2;
            t2(1);
        } else {
            this.C = -1;
            t2(9 - i2);
        }
        k2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: Y1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void Z1(ResponseStateVo responseStateVo) {
        H();
        if (responseStateVo != null) {
            if (responseStateVo.isSuccess()) {
                O1();
            } else {
                G0(responseStateVo.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void b2(AppConfigExtVo appConfigExtVo) {
        if (appConfigExtVo != null) {
            k0(appConfigExtVo);
            p2();
        }
    }

    public static /* synthetic */ void c2(ResponseFormBo responseFormBo) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: d2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void e2(String str) {
        if (x.isNotNull(str)) {
            g0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: f2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void g2(int i2, int i3, int i4, View view) {
        List<QuestionsCategoriesVo> list = this.E;
        if (list == null || list.isEmpty()) {
            return;
        }
        QuestionsCategoriesVo questionsCategoriesVo = this.E.get(i2);
        this.mQuestionCategoriesTv.setText(questionsCategoriesVo.getName());
        this.mQuestionCategoriesTv.setTag(questionsCategoriesVo);
        this.L = i2;
        M1(questionsCategoriesVo.getValue());
    }

    public static CustomerServiceFragment getInstance() {
        return new CustomerServiceFragment();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: h2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void i2(int i2, int i3, int i4, View view) {
        List<QuestionsCategoriesVo> list = this.F;
        if (list == null || list.isEmpty()) {
            return;
        }
        QuestionsCategoriesVo questionsCategoriesVo = this.F.get(i2);
        this.mQuestionTv.setText(questionsCategoriesVo.getName());
        this.mQuestionTv.setTag(questionsCategoriesVo);
        this.M = i2;
    }

    public final void E1() {
        ImageItem imageItem = new ImageItem();
        imageItem.path = String.valueOf(R.mipmap.ic_add_pic);
        this.D.add(imageItem);
        this.B.initListData(this.D);
        this.mNineGridView.setAdapter(this.B);
    }

    public final void F1() {
        b bVar = this.J;
        if (bVar != null) {
            bVar.show();
        }
    }

    public final void G1() {
        b bVar = this.K;
        if (bVar != null) {
            bVar.show();
        }
    }

    public final void H1(ArrayList<ImageItem> arrayList) {
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            ImageItem imageItem = arrayList.get(i2);
            if (imageItem != null && Q1(imageItem.path)) {
                arrayList2.add(imageItem);
            }
        }
        if (arrayList2.isEmpty()) {
            return;
        }
        arrayList.removeAll(arrayList2);
    }

    public final String I1() {
        AppConfigExtVo appConfigExtVoO = o();
        if (appConfigExtVoO != null) {
            return appConfigExtVoO.getCustomerServicePhone();
        }
        return null;
    }

    public final void J1() {
        this.H.getAppConfig();
        this.G.getQuestionsCategories();
    }

    public final List<String> K1() {
        ArrayList arrayList = new ArrayList();
        List<QuestionsCategoriesVo> list = this.E;
        if (list != null && !list.isEmpty()) {
            Iterator<QuestionsCategoriesVo> it = this.E.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().getName());
            }
        }
        return arrayList;
    }

    public final List<File> L1() {
        ArrayList arrayList = new ArrayList();
        int size = this.D.size() - 1;
        if (R1(this.D.get(size).path)) {
            this.D.remove(size);
        }
        Iterator<ImageItem> it = this.D.iterator();
        while (it.hasNext()) {
            arrayList.add(new File(it.next().path));
        }
        return arrayList;
    }

    public final void M1(String str) {
        this.G.getQuestions(str);
    }

    public final List<String> N1() {
        ArrayList arrayList = new ArrayList();
        List<QuestionsCategoriesVo> list = this.F;
        if (list != null && !list.isEmpty()) {
            Iterator<QuestionsCategoriesVo> it = this.F.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().getName());
            }
        }
        return arrayList;
    }

    public final void O1() {
        F0(R.string.tip_title_success);
        this.mQuestionInfoEdt.setText("");
        this.B.initListData(null);
        j2();
    }

    public final void P1() {
        this.D = new ArrayList();
        this.r = this.mBaseSwipeRefreshLayout.getBaseRecyclerView();
        CleanCommendAdapter cleanCommendAdapter = new CleanCommendAdapter();
        this.t = cleanCommendAdapter;
        this.r.setAdapter(cleanCommendAdapter);
        CommentPicAdapter commentPicAdapter = new CommentPicAdapter();
        this.B = commentPicAdapter;
        commentPicAdapter.setOnItemClickListener(this.N);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this.f6487e, 3);
        RepairGridSpecItemDecoration repairGridSpecItemDecoration = new RepairGridSpecItemDecoration(3, getResources().getDimensionPixelSize(R.dimen.dp_6));
        this.mNineGridView.setLayoutManager(gridLayoutManager);
        this.mNineGridView.addItemDecoration(repairGridSpecItemDecoration);
        E1();
    }

    public final boolean Q1(String str) {
        List<ImageItem> list = this.D;
        boolean zEquals = false;
        if (list != null && !list.isEmpty()) {
            Iterator<ImageItem> it = this.D.iterator();
            while (it.hasNext() && !(zEquals = it.next().path.equals(str))) {
            }
        }
        return zEquals;
    }

    public final boolean R1(String str) {
        return Pattern.compile("^[-\\+]?[\\d]*$").matcher(str).matches();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
        int id = view.getId();
        if (id == R.id.tv_common_question_value) {
            G1();
        } else if (id == R.id.tv_question_value) {
            F1();
        } else {
            if (id != R.id.tv_title_right) {
                return;
            }
            j2();
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        this.mTitleTv.setText(R.string.title_customer_service);
        this.mTitleRightTv.setText(R.string.title_customer_record);
        this.mSplitLineTv.setVisibility(0);
        this.mTitleRightTv.setVisibility(0);
        this.mQuestionCategoriesTv.setOnClickListener(this.y);
        this.mQuestionTv.setOnClickListener(this.y);
        this.mTitleRightTv.setOnClickListener(this.y);
        p2();
        P1();
        o2();
        q2();
        J1();
    }

    @OnClick({R.id.tv_back})
    public void backClick(View view) {
        n();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_server;
    }

    public final boolean isExitsAddPic() {
        int size = this.D.size();
        if (size == 1) {
            return true ^ R1(this.D.get(size - 1).path);
        }
        return true;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    /* JADX INFO: renamed from: j0 */
    public void I1() {
    }

    public final void j2() {
        if (N()) {
            d(CustomerServerRecordFragment.getInstance(), R.id.flayout_content);
        }
    }

    public final void k2() {
        startActivityForResult(new Intent(this.f6487e, (Class<?>) ImageGridActivity.class), 1000);
    }

    public final void l2(ArrayList<ImageItem> arrayList) {
        if (arrayList != null) {
            int size = this.D.size();
            if ((arrayList.size() + size) - 1 > 9 || this.C != -1) {
                this.D.get(this.C).path = arrayList.get(0).path;
            } else {
                H1(arrayList);
                if (!arrayList.isEmpty()) {
                    ImageItem imageItemRemove = this.D.remove(size - 1);
                    this.D.addAll(arrayList);
                    if (this.D.size() < 9) {
                        this.D.add(imageItemRemove);
                    }
                }
            }
        }
        this.B.initListData(this.D);
    }

    public final void m2(ResponseVo<QuestionsCategoriesVo> responseVo) {
        this.L = -1;
        if (responseVo != null) {
            List<QuestionsCategoriesVo> rows = responseVo.getRows();
            this.E = rows;
            int i2 = 0;
            for (QuestionsCategoriesVo questionsCategoriesVo : rows) {
                if (questionsCategoriesVo.isDefaultFlag()) {
                    this.L = i2;
                    this.mQuestionCategoriesTv.setText(questionsCategoriesVo.getName());
                    this.mQuestionCategoriesTv.setTag(questionsCategoriesVo);
                    M1(questionsCategoriesVo.getValue());
                    return;
                }
                i2++;
            }
            if (this.L != -1 || this.E.isEmpty()) {
                return;
            }
            this.L = 0;
            QuestionsCategoriesVo questionsCategoriesVo2 = this.E.get(0);
            this.mQuestionCategoriesTv.setText(questionsCategoriesVo2.getName());
            this.mQuestionCategoriesTv.setTag(questionsCategoriesVo2);
            M1(questionsCategoriesVo2.getValue());
        }
    }

    public final void n2(ResponseVo<QuestionsCategoriesVo> responseVo) {
        this.M = -1;
        if (responseVo != null) {
            List<QuestionsCategoriesVo> rows = responseVo.getRows();
            this.F = rows;
            int i2 = 0;
            for (QuestionsCategoriesVo questionsCategoriesVo : rows) {
                if (questionsCategoriesVo.isDefaultFlag()) {
                    this.M = i2;
                    this.mQuestionTv.setText(questionsCategoriesVo.getName());
                    this.mQuestionTv.setTag(questionsCategoriesVo);
                    return;
                }
                i2++;
            }
            if (this.M == -1 && !this.F.isEmpty()) {
                this.L = 0;
                QuestionsCategoriesVo questionsCategoriesVo2 = this.F.get(0);
                this.mQuestionTv.setText(questionsCategoriesVo2.getName());
                this.mQuestionTv.setTag(questionsCategoriesVo2);
            }
        }
        r2();
    }

    public final void o2() {
        CustomerServiceModel customerServiceModel = (CustomerServiceModel) ViewModelProviders.of(this).get(CustomerServiceModel.class);
        this.G = customerServiceModel;
        customerServiceModel.getResultLiveData().observe(this, new Observer() { // from class: c.e.c.i0.b.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1551a.Z1((ResponseStateVo) obj);
            }
        });
        this.G.getCategoresLiveData().observe(this, new Observer() { // from class: c.e.c.i0.b.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1555a.m2((ResponseVo) obj);
            }
        });
        this.G.getQuestionsLiveData().observe(this, new Observer() { // from class: c.e.c.i0.b.o
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1565a.n2((ResponseVo) obj);
            }
        });
        this.G.getUploadResponseDtoMutableLive().observe(this, new Observer() { // from class: c.e.c.i0.b.k
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1561a.s2((UploadResponseDto) obj);
            }
        });
        this.G.getErrRequestLiveData().observe(this, new Observer() { // from class: c.e.c.i0.b.i
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1559a.C((RequestErrDto) obj);
            }
        });
        UserOperateModel userOperateModel = (UserOperateModel) h(UserOperateModel.class);
        this.H = userOperateModel;
        userOperateModel.getAppConfigLiveData().observe(this, new Observer() { // from class: c.e.c.i0.b.n
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1564a.b2((AppConfigExtVo) obj);
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        q.d("onActivityResult result :" + i2);
        if (i3 == 1004 && intent != null && i2 == 1000) {
            l2((ArrayList) intent.getSerializableExtra("extra_result_items"));
        }
    }

    public final void p2() {
        String strI1 = I1();
        if (x.isNotNull(strI1)) {
            this.mPhoneTv.setText(strI1);
        }
    }

    public final void q2() {
        TemplateModel templateModel = (TemplateModel) h(TemplateModel.class);
        this.I = templateModel;
        templateModel.getBoMutableLiveData().observe(this, new Observer() { // from class: c.e.c.i0.b.m
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                CustomerServiceFragment.c2((ResponseFormBo) obj);
            }
        });
        this.I.getResult().observe(this, new Observer() { // from class: c.e.c.i0.b.j
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1560a.e2((String) obj);
            }
        });
    }

    public final void r2() {
        b bVarBuild = new c.b.a.b.a(this.f6487e, new e() { // from class: c.e.c.i0.b.l
            @Override // c.b.a.d.e
            public final void onOptionsSelect(int i2, int i3, int i4, View view) {
                this.f1562a.g2(i2, i3, i4, view);
            }
        }).build();
        this.J = bVarBuild;
        bVarBuild.setPicker(K1());
        this.J.setSelectOptions(this.L);
        b bVarBuild2 = new c.b.a.b.a(this.f6487e, new e() { // from class: c.e.c.i0.b.f
            @Override // c.b.a.d.e
            public final void onOptionsSelect(int i2, int i3, int i4, View view) {
                this.f1553a.i2(i2, i3, i4, view);
            }
        }).build();
        this.K = bVarBuild2;
        bVarBuild2.setPicker(N1());
        this.K.setSelectOptions(this.M);
    }

    public final void s2(UploadResponseDto uploadResponseDto) {
        String key = this.mQuestionTv.getTag() != null ? ((QuestionsCategoriesVo) this.mQuestionTv.getTag()).getKey() : null;
        String value = this.mQuestionCategoriesTv.getTag() != null ? ((QuestionsCategoriesVo) this.mQuestionCategoriesTv.getTag()).getValue() : null;
        RequestCustomerVo requestCustomerVo = new RequestCustomerVo();
        if (x.isNotNull(value)) {
            requestCustomerVo.setCategoryItemKey(value);
        }
        if (x.isNotNull(key)) {
            requestCustomerVo.setQuestionItemKey(key);
        }
        String string = this.mQuestionInfoEdt.getText().toString();
        if (x.isNullStr(string)) {
            F0(R.string.tip_question_is_empty);
            return;
        }
        requestCustomerVo.setDescribe(string);
        if (uploadResponseDto != null) {
            List<ResponseUploadImgVo> uploadSuccessList = uploadResponseDto.getUploadSuccessList();
            ArrayList arrayList = new ArrayList();
            for (ResponseUploadImgVo responseUploadImgVo : uploadSuccessList) {
                if (responseUploadImgVo != null) {
                    arrayList.add(responseUploadImgVo.getKey());
                }
            }
            requestCustomerVo.setEvidences(arrayList);
        }
        this.G.submitCustomerService(requestCustomerVo);
    }

    @OnClick({R.id.btn_submit})
    public void submit(View view) {
        if (N()) {
            if (x.isNullStr(this.mQuestionInfoEdt.getText().toString())) {
                F0(R.string.tip_question_is_empty);
                return;
            }
            z0(R.string.tip_submit_customer_load);
            if (isExitsAddPic()) {
                u2();
            } else {
                s2(null);
            }
        }
    }

    public final void t2(int i2) {
        c.k.a.a.getInstance().setSelectLimit(i2);
    }

    public final void u2() {
        if (isExitsAddPic()) {
            this.G.uploadPicList(L1());
        }
    }
}
