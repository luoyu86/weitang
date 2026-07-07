package com.chinavisionary.microtang.buycart.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import com.chinavisionary.microtang.room.vo.ExpressVo;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ResponseWaitBuyListVo extends BaseVo {
    private List<ExpressVo> address;
    private List<MerchantsBean> merchants;

    public List<ExpressVo> getAddress() {
        return this.address;
    }

    public List<MerchantsBean> getMerchants() {
        return this.merchants;
    }

    public void setAddress(List<ExpressVo> list) {
        this.address = list;
    }

    public void setMerchants(List<MerchantsBean> list) {
        this.merchants = list;
    }
}
