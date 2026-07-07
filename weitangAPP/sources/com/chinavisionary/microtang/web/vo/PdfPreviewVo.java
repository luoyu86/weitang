package com.chinavisionary.microtang.web.vo;

import c.e.a.d.x;
import com.chinavisionary.core.app.net.base.dto.BaseVo;
import com.chinavisionary.microtang.R;

/* JADX INFO: loaded from: classes2.dex */
public class PdfPreviewVo extends BaseVo {
    private String contract_downloadUrl;
    private String name;

    public String getContract_downloadUrl() {
        return this.contract_downloadUrl;
    }

    public String getName() {
        if (this.name == null) {
            this.name = x.getString(R.string.title_electron_contract);
        }
        return this.name;
    }

    public void setContract_downloadUrl(String str) {
        this.contract_downloadUrl = str;
    }

    public void setName(String str) {
        this.name = str;
    }
}
