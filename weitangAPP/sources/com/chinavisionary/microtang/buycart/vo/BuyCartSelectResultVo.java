package com.chinavisionary.microtang.buycart.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class BuyCartSelectResultVo extends BaseVo {
    private List<BuyCartVo> buyCartVoList;
    private List<String> specKeyList;

    public List<BuyCartVo> getBuyCartVoList() {
        return this.buyCartVoList;
    }

    public List<String> getSpecKeyList() {
        return this.specKeyList;
    }

    public void setBuyCartVoList(List<BuyCartVo> list) {
        this.buyCartVoList = list;
    }

    public void setSpecKeyList(List<String> list) {
        this.specKeyList = list;
    }
}
