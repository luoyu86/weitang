package c.e.c.m.g;

import com.chinavisionary.microtang.comment.vo.ScoresBean;
import com.chinavisionary.microtang.order.vo.KeyValueVo;

/* JADX INFO: loaded from: classes.dex */
public class a extends c.e.e.a.s.a {
    public static final int ITEM_TYPE_ADDRESS = 7;
    public static final int ITEM_TYPE_EDIT = 4;
    public static final int ITEM_TYPE_PIC = 6;
    public static final int ITEM_TYPE_RADIO = 1;
    public static final int ITEM_TYPE_SCORE = 2;
    public static final int ITEM_TYPE_SEEK_BAR = 3;
    public static final int ITEM_TYPE_TAG = 5;
    private int itemType;
    private KeyValueVo keyValueVo;
    private ScoresBean scoresBean;

    public int getItemType() {
        return this.itemType;
    }

    public KeyValueVo getKeyValueVo() {
        return this.keyValueVo;
    }

    public ScoresBean getScoresBean() {
        return this.scoresBean;
    }

    public void setItemType(int i2) {
        this.itemType = i2;
    }

    public void setKeyValueVo(KeyValueVo keyValueVo) {
        this.keyValueVo = keyValueVo;
    }

    public void setScoresBean(ScoresBean scoresBean) {
        this.scoresBean = scoresBean;
    }
}
