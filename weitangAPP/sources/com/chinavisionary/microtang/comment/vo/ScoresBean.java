package com.chinavisionary.microtang.comment.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ScoresBean extends BaseVo {
    public static final String SCORE_TYPE_INPUT = "input";
    public static final String SCORE_TYPE_RADIO = "radio";
    public static final String SCORE_TYPE_SCORE = "score";
    public static final String SCORE_TYPE_SLIDER = "slider";
    public static final String SCORE_TYPE_TAG = "tag";
    private boolean hasEdit = true;
    private String inputContent;
    private List<OptionItemVo> options;
    private float score;
    private String scoreType;
    private String scoreTypeContent;
    private String scoreTypeDesc;
    private String scoreTypeName;
    private String type;

    public String getInputContent() {
        return this.inputContent;
    }

    public List<OptionItemVo> getOptions() {
        return this.options;
    }

    public float getScore() {
        return this.score;
    }

    public String getScoreType() {
        return this.scoreType;
    }

    public String getScoreTypeContent() {
        return this.scoreTypeContent;
    }

    public String getScoreTypeDesc() {
        String str = this.scoreTypeDesc;
        return str == null ? this.scoreTypeName : str;
    }

    public String getScoreTypeName() {
        return this.scoreTypeName;
    }

    public String getType() {
        return this.type;
    }

    public boolean isHasEdit() {
        return this.hasEdit;
    }

    public void setHasEdit(boolean z) {
        this.hasEdit = z;
    }

    public void setInputContent(String str) {
        this.inputContent = str;
    }

    public void setOptions(List<OptionItemVo> list) {
        this.options = list;
    }

    public void setScore(float f2) {
        this.score = f2;
    }

    public void setScoreType(String str) {
        this.scoreType = str;
    }

    public void setScoreTypeContent(String str) {
        this.scoreTypeContent = str;
    }

    public void setScoreTypeDesc(String str) {
        this.scoreTypeDesc = str;
    }

    public void setScoreTypeName(String str) {
        this.scoreTypeName = str;
    }

    public void setType(String str) {
        this.type = str;
    }
}
