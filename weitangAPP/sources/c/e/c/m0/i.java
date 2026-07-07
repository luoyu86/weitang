package c.e.c.m0;

import com.chinavisionary.core.app.config.bo.LeftTitleToRightArrowVo;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class i {
    public static int getItemIndexToOnlyKey(List<LeftTitleToRightArrowVo> list, int i2) {
        if (list == null || list.isEmpty()) {
            return 0;
        }
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            LeftTitleToRightArrowVo leftTitleToRightArrowVo = list.get(i3);
            if (leftTitleToRightArrowVo != null && leftTitleToRightArrowVo.getOnlyKey() == i2) {
                return i3;
            }
        }
        return 0;
    }

    public static LeftTitleToRightArrowVo getItemToOnlyKey(List<LeftTitleToRightArrowVo> list, int i2) {
        if (list != null && !list.isEmpty()) {
            for (LeftTitleToRightArrowVo leftTitleToRightArrowVo : list) {
                if (leftTitleToRightArrowVo != null && leftTitleToRightArrowVo.getOnlyKey() == i2) {
                    return leftTitleToRightArrowVo;
                }
            }
        }
        return null;
    }
}
