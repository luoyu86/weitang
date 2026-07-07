package com.chinavisionary.microtang.sign.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import com.chinavisionary.microtang.sign.vo.ContactDetailsVo;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class SignRoomVo extends BaseVo {
    public static final int PAY_MODE = 2;
    public static final int PAY_PRICE = 1;
    public static final int RENT_CONTACT_PERSON = 5;
    public static final int RENT_PERSON = 4;
    public static final int TOGETHER_PERSON = 3;
    private String hintValue;
    private boolean isCheck;
    private boolean isEdit = true;
    private boolean isShowEdit;
    private boolean isShowLine;
    private boolean isShowRightIcon;
    private String itemTitle;
    private String left;
    private List<ContactDetailsVo.RoommatesBean> mRoommatesBeans;
    private List<TogetherLiveVo> mTogetherLiveVos;
    private int payDrawableId;
    private String price;
    private String right;
    private int type;

    public String getHintValue() {
        return this.hintValue;
    }

    public String getItemTitle() {
        return this.itemTitle;
    }

    public String getLeft() {
        return this.left;
    }

    public int getPayDrawableId() {
        return this.payDrawableId;
    }

    public String getPrice() {
        return this.price;
    }

    public String getRight() {
        return this.right;
    }

    public List<ContactDetailsVo.RoommatesBean> getRoommatesBeans() {
        return this.mRoommatesBeans;
    }

    public List<TogetherLiveVo> getTogetherLiveVos() {
        return this.mTogetherLiveVos;
    }

    public int getType() {
        return this.type;
    }

    public boolean isCheck() {
        return this.isCheck;
    }

    public boolean isEdit() {
        return this.isEdit;
    }

    public boolean isShowEdit() {
        return this.isShowEdit;
    }

    public boolean isShowLine() {
        return this.isShowLine;
    }

    public boolean isShowRightIcon() {
        return this.isShowRightIcon;
    }

    public void setCheck(boolean z) {
        this.isCheck = z;
    }

    public void setEdit(boolean z) {
        this.isEdit = z;
    }

    public void setHintValue(String str) {
        this.hintValue = str;
    }

    public void setItemTitle(String str) {
        this.itemTitle = str;
    }

    public void setLeft(String str) {
        this.left = str;
    }

    public void setPayDrawableId(int i2) {
        this.payDrawableId = i2;
    }

    public void setPrice(String str) {
        this.price = str;
    }

    public void setRight(String str) {
        this.right = str;
    }

    public void setRoommatesBeans(List<ContactDetailsVo.RoommatesBean> list) {
        this.mRoommatesBeans = list;
    }

    public void setShowEdit(boolean z) {
        this.isShowEdit = z;
    }

    public void setShowLine(boolean z) {
        this.isShowLine = z;
    }

    public void setShowRightIcon(boolean z) {
        this.isShowRightIcon = z;
    }

    public void setTogetherLiveVos(List<TogetherLiveVo> list) {
        this.mTogetherLiveVos = list;
    }

    public void setType(int i2) {
        this.type = i2;
    }
}
