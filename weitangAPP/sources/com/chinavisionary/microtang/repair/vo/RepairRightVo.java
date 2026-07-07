package com.chinavisionary.microtang.repair.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import com.chinavisionary.framework.mobile.common.vo.ResourceVo;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class RepairRightVo extends BaseVo {
    private String key;
    private List<RepairProduct> productList;
    private String title;

    public static class RepairProduct extends BaseVo {
        private String key;
        private ResourceVo resourceVo;
        private String title;

        public String getKey() {
            return this.key;
        }

        public ResourceVo getResourceVo() {
            return this.resourceVo;
        }

        public String getTitle() {
            return this.title;
        }

        public void setKey(String str) {
            this.key = str;
        }

        public void setResourceVo(ResourceVo resourceVo) {
            this.resourceVo = resourceVo;
        }

        public void setTitle(String str) {
            this.title = str;
        }
    }

    public String getKey() {
        return this.key;
    }

    public List<RepairProduct> getProductList() {
        return this.productList;
    }

    public String getTitle() {
        return this.title;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setProductList(List<RepairProduct> list) {
        this.productList = list;
    }

    public void setTitle(String str) {
        this.title = str;
    }
}
