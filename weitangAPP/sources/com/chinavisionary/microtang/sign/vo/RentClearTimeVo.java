package com.chinavisionary.microtang.sign.vo;

import c.f.b.a;
import com.chinavisionary.core.app.net.base.dto.BaseVo;

/* JADX INFO: loaded from: classes2.dex */
public class RentClearTimeVo extends BaseVo implements a {
    private long checkinCleaningDate;
    private String checkinCleaningDateName;
    private boolean optional;
    private String reason;

    public long getCheckinCleaningDate() {
        return this.checkinCleaningDate;
    }

    public String getCheckinCleaningDateName() {
        return this.checkinCleaningDateName;
    }

    @Override // c.f.b.a
    public String getPickerViewText() {
        String str = this.checkinCleaningDateName;
        if (this.optional) {
            return str;
        }
        return str + " " + this.reason;
    }

    public String getReason() {
        return this.reason;
    }

    public boolean isOptional() {
        return this.optional;
    }

    public void setCheckinCleaningDate(long j) {
        this.checkinCleaningDate = j;
    }

    public void setCheckinCleaningDateName(String str) {
        this.checkinCleaningDateName = str;
    }

    public void setOptional(boolean z) {
        this.optional = z;
    }

    public void setReason(String str) {
        this.reason = str;
    }
}
