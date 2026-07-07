package com.chinavisionary.microtang.clean.model;

import androidx.lifecycle.MutableLiveData;
import c.e.a.d.j;
import c.e.a.d.o;
import c.e.a.d.q;
import c.e.a.d.x;
import com.alibaba.fastjson.JSON;
import com.chinavisionary.core.app.net.base.dto.NewResponseRowsVo;
import com.chinavisionary.core.app.net.base.dto.PageBo;
import com.chinavisionary.core.app.net.base.dto.ResponseRowsVo;
import com.chinavisionary.core.app.net.base.dto.ResponseStateVo;
import com.chinavisionary.core.app.net.base.model.BaseModel;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.clean.vo.RequestIncrementServiceDetailsParamBo;
import com.chinavisionary.microtang.clean.vo.RequestIncrementServiceParamBo;
import com.chinavisionary.microtang.clean.vo.RequestSubmitOrderParamBo;
import com.chinavisionary.microtang.life.bo.RequestGetCouponGoodsParam;
import com.chinavisionary.microtang.life.vo.SubmitLifeOrderDetailsVo;
import com.chinavisionary.microtang.me.vo.CleanProductDetailsVo;
import com.chinavisionary.microtang.me.vo.CleanProductVo;
import com.chinavisionary.microtang.me.vo.NewCleanProductDetailsVo;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class NewCleanModel extends BaseModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MutableLiveData<ResponseRowsVo<CleanProductVo>> f6946a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MutableLiveData<ResponseRowsVo<CleanProductVo>> f6947b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MutableLiveData<NewResponseRowsVo<CleanProductVo>> f6948c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final MutableLiveData<NewResponseRowsVo<CleanProductVo>> f6949d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final MutableLiveData<CleanProductDetailsVo> f6950e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final MutableLiveData<SubmitLifeOrderDetailsVo> f6951f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final MutableLiveData<NewCleanProductDetailsVo> f6952g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public MutableLiveData<ResponseStateVo> f6953h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final c.e.c.l.f.b f6954i;

    public class a extends MutableLiveData<NewResponseRowsVo<CleanProductVo>> {
        public a() {
        }

        @Override // androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
        public void setValue(NewResponseRowsVo<CleanProductVo> newResponseRowsVo) {
            ResponseRowsVo responseRowsVo = new ResponseRowsVo();
            if (newResponseRowsVo != null && o.isNotEmpty(newResponseRowsVo.getRows())) {
                ArrayList arrayList = new ArrayList();
                List<CleanProductVo> rows = newResponseRowsVo.getRows();
                if (o.isNotEmpty(rows)) {
                    for (CleanProductVo cleanProductVo : rows) {
                        if (cleanProductVo != null) {
                            arrayList.add(cleanProductVo);
                        }
                    }
                }
                responseRowsVo.setRows(arrayList);
            }
            NewCleanModel.this.f6946a.postValue(responseRowsVo);
        }
    }

    public class b extends MutableLiveData<NewResponseRowsVo<CleanProductVo>> {
        public b() {
        }

        @Override // androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
        public void setValue(NewResponseRowsVo<CleanProductVo> newResponseRowsVo) {
            ResponseRowsVo responseRowsVo = new ResponseRowsVo();
            if (newResponseRowsVo != null && o.isNotEmpty(newResponseRowsVo.getRows())) {
                ArrayList arrayList = new ArrayList();
                List<CleanProductVo> rows = newResponseRowsVo.getRows();
                if (o.isNotEmpty(rows)) {
                    for (CleanProductVo cleanProductVo : rows) {
                        if (cleanProductVo != null) {
                            arrayList.add(cleanProductVo);
                        }
                    }
                }
                responseRowsVo.setRows(arrayList);
            }
            NewCleanModel.this.f6947b.postValue(responseRowsVo);
        }
    }

    public class c extends MutableLiveData<NewCleanProductDetailsVo> {
        public c() {
        }

        @Override // androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
        public void setValue(NewCleanProductDetailsVo newCleanProductDetailsVo) {
            CleanProductDetailsVo cleanProductDetailsVo = new CleanProductDetailsVo();
            if (newCleanProductDetailsVo != null) {
                cleanProductDetailsVo.setIfOrderPage(newCleanProductDetailsVo.isIfOrderPage());
                cleanProductDetailsVo.setSuccess(newCleanProductDetailsVo.isSuccess());
                cleanProductDetailsVo.setDesc(newCleanProductDetailsVo.getDesc());
                cleanProductDetailsVo.setPrice(newCleanProductDetailsVo.getPrice());
                cleanProductDetailsVo.setUnderlinePrice(newCleanProductDetailsVo.getUnderlinePrice());
                cleanProductDetailsVo.setMessage(newCleanProductDetailsVo.getMessage());
                cleanProductDetailsVo.setCoverKey(newCleanProductDetailsVo.getCoverKey());
                cleanProductDetailsVo.setKey(newCleanProductDetailsVo.getKey());
                cleanProductDetailsVo.setPrimaryKey(newCleanProductDetailsVo.getPrimaryKey());
                cleanProductDetailsVo.setDescKey(newCleanProductDetailsVo.getDescKey());
                cleanProductDetailsVo.setRemark(newCleanProductDetailsVo.getRemark());
                cleanProductDetailsVo.setName(newCleanProductDetailsVo.getName());
                cleanProductDetailsVo.setCover(newCleanProductDetailsVo.getCover());
                cleanProductDetailsVo.setAlbumPhotos(newCleanProductDetailsVo.getAlbumPhotos());
            }
            q.d(c.class.getSimpleName(), "cleanProductDetailsVo =" + JSON.toJSONString(cleanProductDetailsVo));
            NewCleanModel.this.f6950e.postValue(cleanProductDetailsVo);
        }
    }

    public NewCleanModel() {
        super(j.getInstance().getH5ApiBaseUrl());
        this.f6946a = new MutableLiveData<>();
        this.f6947b = new MutableLiveData<>();
        this.f6948c = new a();
        this.f6949d = new b();
        this.f6950e = new MutableLiveData<>();
        this.f6951f = new MutableLiveData<>();
        this.f6952g = new c();
        this.f6953h = new MutableLiveData<>();
        this.f6954i = (c.e.c.l.f.b) create(c.e.c.l.f.b.class);
    }

    public void getCleanDetails(String str) {
        if (!x.isNotNull(str)) {
            handlerResponseErr(null, x.getString(R.string.tip_request_param_is_empty));
            return;
        }
        RequestIncrementServiceDetailsParamBo requestIncrementServiceDetailsParamBo = new RequestIncrementServiceDetailsParamBo();
        requestIncrementServiceDetailsParamBo.setCommodityId(str);
        this.f6954i.getCleanDetails(getToken(), requestIncrementServiceDetailsParamBo).enqueue(enqueueBaseVoResponse(this.f6952g));
    }

    public void getCleanList(PageBo pageBo, String str, String str2, int i2) {
        if (x.isNullStr(str)) {
            str = "";
        }
        if (x.isNullStr(str2)) {
            str2 = null;
        }
        RequestIncrementServiceParamBo requestIncrementServiceParamBo = new RequestIncrementServiceParamBo();
        requestIncrementServiceParamBo.setProjectId(str);
        requestIncrementServiceParamBo.setSpaceId(str2);
        requestIncrementServiceParamBo.setCommodityType(i2);
        String token = getToken();
        if (x.isNullStr(c.e.a.a.b.getInstance().getToken())) {
            token = "81F6920921A9C40ABB0BF2E166E52F395";
        }
        this.f6954i.getCleanList(token, requestIncrementServiceParamBo).enqueue(enqueueBaseVoResponse(this.f6948c));
    }

    public void getCouponGoodsList(RequestGetCouponGoodsParam requestGetCouponGoodsParam) {
        this.f6954i.getCouponGoodsList(getToken(), requestGetCouponGoodsParam).enqueue(enqueueBaseVoResponse(this.f6949d));
    }

    public MutableLiveData<ResponseRowsVo<CleanProductVo>> getCouponGoodsListResult() {
        return this.f6947b;
    }

    public MutableLiveData<CleanProductDetailsVo> getDetailsLiveData() {
        return this.f6950e;
    }

    public MutableLiveData<ResponseRowsVo<CleanProductVo>> getListMutableLiveData() {
        return this.f6946a;
    }

    public MutableLiveData<ResponseStateVo> getResultLiveData() {
        return this.f6953h;
    }

    public MutableLiveData<SubmitLifeOrderDetailsVo> getSubmitLifeOrderDetailsResult() {
        return this.f6951f;
    }

    public void getSubmitOrderDetails(String str) {
        if (!x.isNotNull(str)) {
            handlerResponseErr(null, x.getString(R.string.tip_request_param_is_empty));
            return;
        }
        RequestSubmitOrderParamBo requestSubmitOrderParamBo = new RequestSubmitOrderParamBo();
        requestSubmitOrderParamBo.setCommodityId(str);
        this.f6954i.getSubmitOrderDetailsUrl(getToken(), requestSubmitOrderParamBo).enqueue(enqueueBaseVoResponse(this.f6951f));
    }
}
