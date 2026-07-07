package com.chinavisionary.core.app.config.bo;

import c.e.a.a.b;
import c.e.a.d.z;
import com.chinavisionary.core.R;
import com.chinavisionary.core.app.net.base.dto.BaseVo;
import java.text.SimpleDateFormat;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class LeftTitleToRightArrowVo extends BaseVo {
    public static final int DEFAULT_TYPE = -1;
    public static final int ITEM_BG_WHITE_TYPE = -3;
    public static final int ITEM_SWITCH_TYPE = -4;
    public static final int LINE_TYPE = -2;
    public static final int TITLE_TYPE = 1;
    private int autoLink;
    private int bgColor;
    private String center;
    private int centerFontColor;
    private String digits;
    private Object extObj;
    private String hint;
    private boolean isEdit;
    private boolean isPrice;
    private boolean isRequired;
    private boolean isSelectRadio;
    private boolean isShowArrow;
    private boolean isShowRadio;
    private boolean isShowRmbUnit;
    private boolean isTime;
    private boolean isTitle;
    private String key;
    private String left;
    private int leftFontColor;
    private SimpleDateFormat mSimpleDateFormat;
    private int onlyKey;
    private String right;
    private int rightFontColor;
    private String title;
    private int type = -1;
    private int maxLength = -1;
    private boolean isShowSplitLine = false;
    private int splitLineHeight = b.getInstance().getResources().getDimensionPixelSize(R.dimen.dp_1);
    private int inputType = 1;

    public static int getOnlyKeyToPosition(List<LeftTitleToRightArrowVo> list, int i2) {
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (list.get(i3).getOnlyKey() == i2) {
                return i3;
            }
        }
        return -1;
    }

    public int getAutoLink() {
        return this.autoLink;
    }

    public int getBgColor() {
        return this.bgColor;
    }

    public String getCenter() {
        return this.center;
    }

    public int getCenterFontColor() {
        return this.centerFontColor;
    }

    public String getDigits() {
        return this.digits;
    }

    public Object getExtObj() {
        return this.extObj;
    }

    public String getHint() {
        return this.hint;
    }

    public int getInputType() {
        return this.inputType;
    }

    public String getKey() {
        return this.key;
    }

    public String getLeft() {
        return this.left;
    }

    public int getLeftFontColor() {
        return this.leftFontColor;
    }

    public int getMaxLength() {
        return this.maxLength;
    }

    public int getOnlyKey() {
        return this.onlyKey;
    }

    public String getRight() {
        return this.right;
    }

    public int getRightFontColor() {
        return this.rightFontColor;
    }

    public SimpleDateFormat getSimpleDateFormat() {
        SimpleDateFormat simpleDateFormat = this.mSimpleDateFormat;
        if (simpleDateFormat != null) {
            return simpleDateFormat;
        }
        SimpleDateFormat simpleDateFormat2 = z.f1243d;
        this.mSimpleDateFormat = simpleDateFormat2;
        return simpleDateFormat2;
    }

    public int getSplitLineHeight() {
        return this.splitLineHeight;
    }

    public String getTitle() {
        return this.title;
    }

    public int getType() {
        return this.type;
    }

    public boolean isEdit() {
        return this.isEdit;
    }

    public boolean isPrice() {
        return this.isPrice;
    }

    public boolean isRequired() {
        return this.isRequired;
    }

    public boolean isSelectRadio() {
        return this.isSelectRadio;
    }

    public boolean isShowArrow() {
        return this.isShowArrow;
    }

    public boolean isShowRadio() {
        return this.isShowRadio;
    }

    public boolean isShowRmbUnit() {
        return this.isShowRmbUnit;
    }

    public boolean isShowSplitLine() {
        return this.isShowSplitLine;
    }

    public boolean isTime() {
        return this.isTime;
    }

    public boolean isTitle() {
        return this.isTitle;
    }

    public void setAutoLink(int i2) {
        this.autoLink = i2;
    }

    public void setBgColor(int i2) {
        this.bgColor = i2;
    }

    public void setCenter(String str) {
        this.center = str;
    }

    public void setCenterFontColor(int i2) {
        this.centerFontColor = i2;
    }

    public void setDigits(String str) {
        this.digits = str;
    }

    public void setEdit(boolean z) {
        this.isEdit = z;
    }

    public void setExtObj(Object obj) {
        this.extObj = obj;
    }

    public void setHint(String str) {
        this.hint = str;
    }

    public void setInputType(int i2) {
        this.inputType = i2;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setLeft(String str) {
        this.left = str;
    }

    public void setLeftFontColor(int i2) {
        this.leftFontColor = i2;
    }

    public void setMaxLength(int i2) {
        this.maxLength = i2;
    }

    public void setOnlyKey(int i2) {
        this.onlyKey = i2;
    }

    public void setPrice(boolean z) {
        this.isPrice = z;
    }

    public void setRequired(boolean z) {
        this.isRequired = z;
    }

    public void setRight(String str) {
        this.right = str;
    }

    public void setRightFontColor(int i2) {
        this.rightFontColor = i2;
    }

    public void setSelectRadio(boolean z) {
        this.isSelectRadio = z;
    }

    public void setShowArrow(boolean z) {
        this.isShowArrow = z;
    }

    public void setShowRadio(boolean z) {
        this.isShowRadio = z;
    }

    public void setShowRmbUnit(boolean z) {
        this.isShowRmbUnit = z;
    }

    public void setShowSplitLine(boolean z) {
        this.isShowSplitLine = z;
    }

    public void setSimpleDateFormat(SimpleDateFormat simpleDateFormat) {
        this.mSimpleDateFormat = simpleDateFormat;
    }

    public void setSplitLineHeight(int i2) {
        this.splitLineHeight = i2;
    }

    public void setTime(boolean z) {
        this.isTime = z;
    }

    public void setTitle(boolean z) {
        this.isTitle = z;
    }

    public void setType(int i2) {
        this.type = i2;
    }

    public void setTitle(String str) {
        this.title = str;
    }
}
