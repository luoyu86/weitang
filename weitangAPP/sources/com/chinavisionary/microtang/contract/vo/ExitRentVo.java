package com.chinavisionary.microtang.contract.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ExitRentVo extends BaseVo {
    private String key;
    private String reason;
    private List<ExitRentTag> tags;

    public static class ExitRentTag extends BaseVo {
        private boolean isSelect;
        private String tagKey;
        private String tagValue;

        public String getTagKey() {
            return this.tagKey;
        }

        public String getTagValue() {
            return this.tagValue;
        }

        public boolean isSelect() {
            return this.isSelect;
        }

        public void setSelect(boolean z) {
            this.isSelect = z;
        }

        public void setTagKey(String str) {
            this.tagKey = str;
        }

        public void setTagValue(String str) {
            this.tagValue = str;
        }
    }

    public String getKey() {
        return this.key;
    }

    public String getReason() {
        return this.reason;
    }

    public List<ExitRentTag> getTags() {
        return this.tags;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setReason(String str) {
        this.reason = str;
    }

    public void setTags(List<ExitRentTag> list) {
        this.tags = list;
    }
}
