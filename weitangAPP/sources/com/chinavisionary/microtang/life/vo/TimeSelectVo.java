package com.chinavisionary.microtang.life.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class TimeSelectVo extends BaseVo {
    private List<String> oneList;
    private List<List<String>> twoList;

    public List<String> getOneList() {
        return this.oneList;
    }

    public List<List<String>> getTwoList() {
        return this.twoList;
    }

    public void setOneList(List<String> list) {
        this.oneList = list;
    }

    public void setTwoList(List<List<String>> list) {
        this.twoList = list;
    }
}
