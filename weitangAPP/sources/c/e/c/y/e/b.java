package c.e.c.y.e;

import androidx.fragment.app.Fragment;
import com.chinavisionary.microtang.buycart.vo.BuyCartVo;
import com.chinavisionary.microtang.merchant.vo.BuyCartCountVo;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface b {
    void buyCartList(List<BuyCartVo> list);

    Fragment getCurrentFragment();

    void setupBuyCartCountVo(BuyCartCountVo buyCartCountVo);
}
