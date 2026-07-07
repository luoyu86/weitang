package com.chinavisionary.microtang.clean.model;

import androidx.lifecycle.MutableLiveData;
import c.e.a.d.o;
import c.e.a.d.x;
import com.chinavisionary.core.app.net.base.dto.PageBo;
import com.chinavisionary.core.app.net.base.dto.ResponseRowsVo;
import com.chinavisionary.core.app.net.base.dto.ResponseStateVo;
import com.chinavisionary.core.app.net.base.model.BaseModel;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.me.vo.CleanProductDetailsVo;
import com.chinavisionary.microtang.me.vo.CleanProductVo;
import com.chinavisionary.microtang.me.vo.ValueaddedListBo;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class CleanModel extends BaseModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MutableLiveData<ResponseRowsVo<CleanProductVo>> f6940a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MutableLiveData<ResponseRowsVo<ValueaddedListBo>> f6941b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public MutableLiveData<CleanProductDetailsVo> f6942c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public MutableLiveData<ResponseStateVo> f6943d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public c.e.c.l.f.a f6944e;

    public class a extends MutableLiveData<ResponseRowsVo<ValueaddedListBo>> {
        public a() {
        }

        @Override // androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
        public void setValue(ResponseRowsVo<ValueaddedListBo> responseRowsVo) {
            ResponseRowsVo responseRowsVo2 = new ResponseRowsVo();
            if (responseRowsVo != null && o.isNotEmpty(responseRowsVo.getRows())) {
                ArrayList arrayList = new ArrayList();
                List<ValueaddedListBo> rows = responseRowsVo.getRows();
                if (o.isNotEmpty(rows)) {
                    for (ValueaddedListBo valueaddedListBo : rows) {
                        if (valueaddedListBo != null && o.isNotEmpty(valueaddedListBo.getList())) {
                            arrayList.addAll(valueaddedListBo.getList());
                        }
                    }
                }
                responseRowsVo2.setRows(arrayList);
            }
            CleanModel.this.f6940a.postValue(responseRowsVo2);
        }
    }

    public CleanModel() {
        super(null);
        this.f6940a = new MutableLiveData<>();
        this.f6941b = new a();
        this.f6942c = new MutableLiveData<>();
        this.f6943d = new MutableLiveData<>();
        this.f6944e = (c.e.c.l.f.a) create(c.e.c.l.f.a.class);
    }

    public void getCleanDetails(String str) {
        if (x.isNotNull(str)) {
            this.f6944e.getCleanDetails(str).enqueue(enqueueResponse(this.f6942c));
        } else {
            handlerResponseErr(null, x.getString(R.string.tip_request_param_is_empty), 900);
        }
    }

    public void getCleanList(PageBo pageBo, String str, String str2, String str3) {
        if (x.isNullStr(str)) {
            str = "";
        }
        if (x.isNullStr(str2)) {
            str2 = "";
        }
        if (x.isNullStr(str3)) {
            str3 = "";
        }
        this.f6944e.getCleanList(str, str2, str3).enqueue(enqueueResponse(this.f6941b));
    }

    public MutableLiveData<CleanProductDetailsVo> getDetailsLiveData() {
        return this.f6942c;
    }

    public MutableLiveData<ResponseRowsVo<CleanProductVo>> getListMutableLiveData() {
        return this.f6940a;
    }

    public MutableLiveData<ResponseStateVo> getResultLiveData() {
        return this.f6943d;
    }
}
