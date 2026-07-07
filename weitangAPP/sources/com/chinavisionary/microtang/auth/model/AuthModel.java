package com.chinavisionary.microtang.auth.model;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.lifecycle.MutableLiveData;
import c.e.a.a.a;
import c.e.a.d.j;
import c.e.a.d.n;
import c.e.a.d.q;
import c.e.a.d.x;
import c.e.a.d.y;
import c.e.c.x.a.d;
import com.alibaba.android.arouter.utils.Consts;
import com.chinavisionary.core.app.config.bo.LeftTitleToRightArrowVo;
import com.chinavisionary.core.app.net.base.dto.ResponseRowsVo;
import com.chinavisionary.core.app.net.base.dto.ResponseStateVo;
import com.chinavisionary.core.app.net.base.dto.ResponseUploadImgVo;
import com.chinavisionary.core.app.net.base.dto.UploadResponseDto;
import com.chinavisionary.core.app.net.base.model.BaseModel;
import com.chinavisionary.framework.mobile.common.vo.ResourceVo;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.auth.vo.RequestIDCardBo;
import com.chinavisionary.microtang.me.vo.IDHeadImageVo;
import com.chinavisionary.microtang.me.vo.NameValueVo;
import com.chinavisionary.microtang.me.vo.UserIDCardVo;
import com.lzy.ninegrid.preview.ImagePreviewActivity;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class AuthModel extends BaseModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MutableLiveData<ResponseStateVo> f6837a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MutableLiveData<String> f6838b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MutableLiveData<ResponseRowsVo<NameValueVo>> f6839c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final MutableLiveData<ResponseRowsVo<NameValueVo>> f6840d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final MutableLiveData<ResponseRowsVo<NameValueVo>> f6841e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final MutableLiveData<ResponseRowsVo<NameValueVo>> f6842f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final MutableLiveData<ResponseRowsVo<NameValueVo>> f6843g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public List<ResourceVo> f6844h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public d f6845i;

    public AuthModel() {
        super(j.getInstance().getPublicBaseUrl());
        this.f6837a = new MutableLiveData<>();
        this.f6838b = new MutableLiveData<>();
        this.f6839c = new MutableLiveData<>();
        this.f6840d = new MutableLiveData<>();
        this.f6841e = new MutableLiveData<>();
        this.f6842f = new MutableLiveData<>();
        this.f6843g = new MutableLiveData<>();
        this.f6845i = (d) create(d.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void b(List list) {
        uploadFileList(list, false);
    }

    public MutableLiveData<ResponseRowsVo<NameValueVo>> getEduList() {
        return this.f6839c;
    }

    public void getEductionList() {
        this.f6845i.getEductionList().enqueue(enqueueResponse(this.f6839c));
    }

    public MutableLiveData<String> getIDCardData() {
        return this.f6838b;
    }

    public void getIDTypeList() {
        this.f6845i.getIDTypeList().enqueue(enqueueResponse(this.f6842f));
    }

    public MutableLiveData<ResponseRowsVo<NameValueVo>> getIDTypeResultList() {
        return this.f6842f;
    }

    public List<LeftTitleToRightArrowVo> getList(UserIDCardVo userIDCardVo, boolean z) {
        ArrayList arrayList = new ArrayList();
        if (z) {
            List<ResourceVo> list = this.f6844h;
            if (list != null) {
                list.clear();
            } else {
                this.f6844h = new ArrayList();
            }
            this.f6844h.add(userIDCardVo.getIdCardFrontResourceVo());
            this.f6844h.add(userIDCardVo.getIdCardBackKeyResourceVo());
            this.f6844h.add(userIDCardVo.getPersonResourceVo());
            LeftTitleToRightArrowVo leftTitleToRightArrowVo = new LeftTitleToRightArrowVo();
            leftTitleToRightArrowVo.setTitle(true);
            leftTitleToRightArrowVo.setTitle(x.getString(R.string.title_auth_info_id_valid));
            arrayList.add(leftTitleToRightArrowVo);
            LeftTitleToRightArrowVo leftTitleToRightArrowVo2 = new LeftTitleToRightArrowVo();
            leftTitleToRightArrowVo2.setLeft(x.getString(R.string.title_user_name));
            leftTitleToRightArrowVo2.setRight(userIDCardVo.getPersonName());
            arrayList.add(leftTitleToRightArrowVo2);
            LeftTitleToRightArrowVo leftTitleToRightArrowVo3 = new LeftTitleToRightArrowVo();
            leftTitleToRightArrowVo3.setLeft(x.getString(R.string.title_card_type));
            leftTitleToRightArrowVo3.setRight(userIDCardVo.getCardType());
            arrayList.add(leftTitleToRightArrowVo3);
            LeftTitleToRightArrowVo leftTitleToRightArrowVo4 = new LeftTitleToRightArrowVo();
            leftTitleToRightArrowVo4.setLeft(x.getString(R.string.title_id_card_no));
            leftTitleToRightArrowVo4.setRight(x.getIDNoMask(userIDCardVo.getCardNo()));
            arrayList.add(leftTitleToRightArrowVo4);
            LeftTitleToRightArrowVo leftTitleToRightArrowVo5 = new LeftTitleToRightArrowVo();
            leftTitleToRightArrowVo5.setLeft(x.getString(R.string.title_contact_address));
            leftTitleToRightArrowVo5.setRight(userIDCardVo.getAddress());
            arrayList.add(leftTitleToRightArrowVo5);
            LeftTitleToRightArrowVo leftTitleToRightArrowVo6 = new LeftTitleToRightArrowVo();
            leftTitleToRightArrowVo6.setLeft(x.getString(R.string.title_nation));
            leftTitleToRightArrowVo6.setRight(userIDCardVo.getNation());
            arrayList.add(leftTitleToRightArrowVo6);
        }
        LeftTitleToRightArrowVo leftTitleToRightArrowVo7 = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo7.setTitle(true);
        leftTitleToRightArrowVo7.setTitle(x.getString(R.string.title_base_info));
        arrayList.add(leftTitleToRightArrowVo7);
        if (!z && a.getInstance().isDebug()) {
            LeftTitleToRightArrowVo leftTitleToRightArrowVo8 = new LeftTitleToRightArrowVo();
            leftTitleToRightArrowVo8.setLeft(x.getString(R.string.title_card_type));
            leftTitleToRightArrowVo8.setRight(userIDCardVo.getCardType());
            leftTitleToRightArrowVo8.setShowArrow(true);
            leftTitleToRightArrowVo8.setOnlyKey(12);
            leftTitleToRightArrowVo8.setRequired(true);
            leftTitleToRightArrowVo8.setRight(x.getNotNullStr(userIDCardVo.getCardType(), x.getString(R.string.title_select_id_type)));
            arrayList.add(leftTitleToRightArrowVo8);
        }
        LeftTitleToRightArrowVo leftTitleToRightArrowVo9 = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo9.setLeft(x.getString(R.string.title_education));
        leftTitleToRightArrowVo9.setShowArrow(true);
        leftTitleToRightArrowVo9.setOnlyKey(3);
        leftTitleToRightArrowVo9.setRequired(true);
        leftTitleToRightArrowVo9.setRight(x.getNotNullStr(userIDCardVo.getEducation(), x.getString(R.string.title_select_edu)));
        arrayList.add(leftTitleToRightArrowVo9);
        LeftTitleToRightArrowVo leftTitleToRightArrowVo10 = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo10.setLeft(x.getString(R.string.title_marriage_val));
        leftTitleToRightArrowVo10.setShowArrow(true);
        leftTitleToRightArrowVo10.setRequired(true);
        leftTitleToRightArrowVo10.setOnlyKey(5);
        leftTitleToRightArrowVo10.setRight(x.getNotNullStr(userIDCardVo.getMarriage(), x.getString(R.string.title_select_marriage_val)));
        arrayList.add(leftTitleToRightArrowVo10);
        LeftTitleToRightArrowVo leftTitleToRightArrowVo11 = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo11.setLeft(x.getString(R.string.title_political_val));
        leftTitleToRightArrowVo11.setShowArrow(true);
        leftTitleToRightArrowVo11.setOnlyKey(7);
        leftTitleToRightArrowVo11.setRight(x.getNotNullStr(userIDCardVo.getPolitical(), x.getString(R.string.title_select_political_val)));
        arrayList.add(leftTitleToRightArrowVo11);
        LeftTitleToRightArrowVo leftTitleToRightArrowVo12 = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo12.setLeft(x.getString(R.string.title_phone_no));
        leftTitleToRightArrowVo12.setRight(x.getPhoneMask(userIDCardVo.getPhone()));
        arrayList.add(leftTitleToRightArrowVo12);
        LeftTitleToRightArrowVo leftTitleToRightArrowVo13 = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo13.setLeft(x.getString(R.string.title_work_unit));
        leftTitleToRightArrowVo13.setEdit(true);
        leftTitleToRightArrowVo13.setShowArrow(true);
        leftTitleToRightArrowVo13.setOnlyKey(4);
        leftTitleToRightArrowVo13.setRight(userIDCardVo.getCompany());
        leftTitleToRightArrowVo13.setHint(x.getString(R.string.title_hint_input_work_unit));
        LeftTitleToRightArrowVo leftTitleToRightArrowVo14 = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo14.setLeft(x.getString(R.string.title_work_unit_address));
        leftTitleToRightArrowVo14.setShowArrow(true);
        leftTitleToRightArrowVo14.setRequired(true);
        leftTitleToRightArrowVo14.setOnlyKey(6);
        leftTitleToRightArrowVo14.setRight(x.getNotNullStr(userIDCardVo.getCompanyAddress(), x.getString(R.string.title_select_work_unit_address)));
        arrayList.add(leftTitleToRightArrowVo14);
        return arrayList;
    }

    public void getMarriageList() {
        this.f6845i.getMarriageList().enqueue(enqueueResponse(this.f6840d));
    }

    public MutableLiveData<ResponseRowsVo<NameValueVo>> getMarriageResultList() {
        return this.f6840d;
    }

    public void getPoliticalList() {
        this.f6845i.getPoliticalList().enqueue(enqueueResponse(this.f6841e));
    }

    public MutableLiveData<ResponseRowsVo<NameValueVo>> getPoliticalResultList() {
        return this.f6841e;
    }

    public MutableLiveData<ResponseStateVo> getResultMutableLiveData() {
        return this.f6837a;
    }

    public void getUserIDInfo() {
        this.f6845i.getUserIdCardInfo().enqueue(enqueueResponse(this.f6838b));
    }

    public void getWorkAddressList() {
        this.f6845i.getWorkAddressList().enqueue(enqueueResponse(this.f6843g));
    }

    public MutableLiveData<ResponseRowsVo<NameValueVo>> getWorkAddressResultList() {
        return this.f6843g;
    }

    public void openBigImg(Activity activity, int i2) {
        Intent intent = new Intent(activity, (Class<?>) ImagePreviewActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("IMAGE_INFO", (Serializable) n.getImageInfo(this.f6844h));
        int size = n.getImageInfo(this.f6844h).size();
        if (i2 >= size) {
            i2 = size - 1;
        }
        bundle.putInt("CURRENT_ITEM", i2);
        intent.putExtras(bundle);
        activity.startActivity(intent);
    }

    public String renameFile(String str) {
        File file = new File(str);
        File file2 = new File(file.getParent(), System.currentTimeMillis() + ".jpg");
        return (file.exists() && file.renameTo(file2)) ? file2.getAbsolutePath() : str;
    }

    public RequestIDCardBo setupImageKey(UploadResponseDto uploadResponseDto, IDHeadImageVo iDHeadImageVo) {
        String backFile = iDHeadImageVo.getBackFile();
        String faceFile = iDHeadImageVo.getFaceFile();
        String selfFile = iDHeadImageVo.getSelfFile();
        RequestIDCardBo requestIDCardBo = new RequestIDCardBo();
        for (ResponseUploadImgVo responseUploadImgVo : uploadResponseDto.getUploadSuccessList()) {
            String originalName = responseUploadImgVo.getOriginalName();
            if (x.isNotNull(originalName)) {
                String strSubstring = originalName.substring(0, originalName.lastIndexOf(Consts.DOT));
                q.d(getClass().getSimpleName(), "originalName:" + strSubstring + ",backFile =" + backFile + ",selfFile =" + selfFile + ",faceFile =" + faceFile);
                if (backFile.contains(strSubstring)) {
                    requestIDCardBo.setIdCardBackSideResourceKey(responseUploadImgVo.getKey());
                }
                if (faceFile.contains(strSubstring)) {
                    requestIDCardBo.setIdCardFrontSideResourceKey(responseUploadImgVo.getKey());
                }
                if (selfFile.contains(strSubstring)) {
                    requestIDCardBo.setPersonPhotoResourceKey(responseUploadImgVo.getKey());
                }
            }
        }
        return requestIDCardBo;
    }

    public void uploadFile(final List<File> list) {
        y.get().addRunnable(new Runnable() { // from class: c.e.c.h.d.a
            @Override // java.lang.Runnable
            public final void run() {
                this.f1489a.b(list);
            }
        });
    }

    public void uploadOneFile(String str) {
        uploadFile(str);
    }

    public void userAuth(RequestIDCardBo requestIDCardBo) {
        if (checkObjectParamIsValid(requestIDCardBo)) {
            this.f6845i.userAuth(requestIDCardBo).enqueue(enqueueResponse(this.f6837a));
        }
    }
}
