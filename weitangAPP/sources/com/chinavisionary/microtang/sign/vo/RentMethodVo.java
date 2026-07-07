package com.chinavisionary.microtang.sign.vo;

import c.f.b.a;
import com.chinavisionary.core.app.config.bo.LeftTitleToRightArrowVo;
import com.chinavisionary.core.app.net.base.dto.BaseVo;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class RentMethodVo extends BaseVo implements a {
    private List<LeftTitleToRightArrowVo> configItems;
    private boolean defaultFlag;
    private String name;
    private int position;
    private int value;

    public List<LeftTitleToRightArrowVo> getConfigItems() {
        return this.configItems;
    }

    public String getName() {
        return this.name;
    }

    @Override // c.f.b.a
    public String getPickerViewText() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    public int getValue() {
        return this.value;
    }

    public boolean isDefaultFlag() {
        return this.defaultFlag;
    }

    public void setConfigItems(List<LeftTitleToRightArrowVo> list) {
        this.configItems = list;
    }

    public void setDefaultFlag(boolean z) {
        this.defaultFlag = z;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setPosition(int i2) {
        this.position = i2;
    }

    public void setValue(int i2) {
        this.value = i2;
    }
}
