package c.e.c.x.a;

import com.chinavisionary.core.app.net.base.dto.NewResponseRowsVo;
import com.chinavisionary.core.app.net.base.dto.NewResponseStateVo;
import com.chinavisionary.microtang.me.bo.RequestClickStatisticBo;
import com.chinavisionary.microtang.me.bo.RequestFundNewsParamBo;
import com.chinavisionary.microtang.me.vo.FundNewsVo;
import h.q.o;

/* JADX INFO: loaded from: classes.dex */
public interface a {
    @o("convenient/statistics/commit")
    h.b<NewResponseStateVo> doClickStatistic(@h.q.a RequestClickStatisticBo requestClickStatisticBo);

    @o("convenient/article/list")
    h.b<NewResponseRowsVo<FundNewsVo>> getFundNews(@h.q.a RequestFundNewsParamBo requestFundNewsParamBo);
}
