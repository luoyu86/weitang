package com.chinavisionary.microtang.main.bo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import com.chinavisionary.framework.mobile.common.vo.ResourceVo;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class MainVo extends BaseVo {
    public static final int BANNER_TYPE = 1;
    public static final int CONTENT_TYPE = 3;
    public static final int ENTERPRISE_NOTIFY_TYPE = 7;
    public static final int FOOD_MERCHANT_TYPE = 6;
    public static final int HOR_CONTENT_TYPE = 4;
    public static final int NEARBY_MERCHANT_TYPE = 5;
    public static final int TITLE_TYPE = 2;
    private Object extObj;
    private String key;
    private List<ResourceVo> pics;
    private String price;
    private String subtitle;
    private String title;
    private boolean isShowRightArrow = true;
    private int type = 3;

    public Object getExtObj() {
        return this.extObj;
    }

    public String getKey() {
        return this.key;
    }

    public List<ResourceVo> getPics() {
        return this.pics;
    }

    public String getPrice() {
        return this.price;
    }

    public String getSubtitle() {
        return this.subtitle;
    }

    public String getTitle() {
        return this.title;
    }

    public int getType() {
        return this.type;
    }

    public boolean isShowRightArrow() {
        return this.isShowRightArrow;
    }

    public void setExtObj(Object obj) {
        this.extObj = obj;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setPics(List<ResourceVo> list) {
        this.pics = list;
    }

    public void setPrice(String str) {
        this.price = str;
    }

    public void setShowRightArrow(boolean z) {
        this.isShowRightArrow = z;
    }

    public void setSubtitle(String str) {
        this.subtitle = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setType(int i2) {
        this.type = i2;
    }
}
