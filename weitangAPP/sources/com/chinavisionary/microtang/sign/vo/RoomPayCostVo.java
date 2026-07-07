package com.chinavisionary.microtang.sign.vo;

import com.chinavisionary.core.app.config.bo.LeftTitleToRightArrowVo;
import com.chinavisionary.core.app.net.base.dto.BaseVo;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class RoomPayCostVo extends BaseVo {
    private String payPrice;
    private List<LeftTitleToRightArrowVo> rightArrowVoList;

    public String getPayPrice() {
        return this.payPrice;
    }

    public List<LeftTitleToRightArrowVo> getRightArrowVoList() {
        return this.rightArrowVoList;
    }

    public void setPayPrice(String str) {
        this.payPrice = str;
    }

    public void setRightArrowVoList(List<LeftTitleToRightArrowVo> list) {
        this.rightArrowVoList = list;
    }
}
