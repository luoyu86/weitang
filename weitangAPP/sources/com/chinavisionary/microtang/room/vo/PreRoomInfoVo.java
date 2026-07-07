package com.chinavisionary.microtang.room.vo;

import com.chinavisionary.core.app.net.base.dto.NewBaseVo;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class PreRoomInfoVo extends NewBaseVo {
    private List<Long> dates;
    private String name;
    private String phone;

    public List<Long> getDates() {
        return this.dates;
    }

    public String getName() {
        return this.name;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setDates(List<Long> list) {
        this.dates = list;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setPhone(String str) {
        this.phone = str;
    }
}
