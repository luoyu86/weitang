package c.e.c.b0.d;

import androidx.fragment.app.Fragment;
import com.chinavisionary.core.app.net.base.dto.RequestErrDto;
import com.chinavisionary.core.app.net.base.dto.ResponseStateVo;
import com.chinavisionary.microtang.buycart.vo.BuyCartVo;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface a {
    Fragment getCurrentFragment();

    void operationResponseState(ResponseStateVo responseStateVo);

    void setupOrderList(List<BuyCartVo> list);

    void setupRequestErr(RequestErrDto requestErrDto);
}
