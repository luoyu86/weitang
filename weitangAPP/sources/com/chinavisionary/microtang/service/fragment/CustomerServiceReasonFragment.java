package com.chinavisionary.microtang.service.fragment;

import android.view.View;
import butterknife.BindView;
import com.chinavisionary.core.app.base.CoreBaseFragment;
import com.chinavisionary.core.weight.BaseRecyclerView;
import com.chinavisionary.framework.mobile.common.vo.ResourceVo;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseFragment;
import com.chinavisionary.microtang.service.vo.CustomerServiceReasonVo;
import com.tom_roush.pdfbox.contentstream.operator.OperatorName;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class CustomerServiceReasonFragment extends BaseFragment {

    @BindView(R.id.recycler)
    public BaseRecyclerView mRecyclerView;

    public static CustomerServiceReasonFragment getInstance(String str) {
        CustomerServiceReasonFragment customerServiceReasonFragment = new CustomerServiceReasonFragment();
        customerServiceReasonFragment.setArguments(CoreBaseFragment.q(str));
        return customerServiceReasonFragment;
    }

    public final List<ResourceVo> E1() {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < 5; i2++) {
            ResourceVo resourceVo = new ResourceVo();
            resourceVo.setUrl("https://car3.autoimg.cn/cardfs/product/g27/M00/B3/31/1024x0_1_q95_autohomecar__ChcCQFvJzJCAGFRzAAtgAXq5SD4754.jpg");
            resourceVo.setSampleUrl("https://car3.autoimg.cn/cardfs/product/g27/M00/B3/31/1024x0_1_q95_autohomecar__ChcCQFvJzJCAGFRzAAtgAXq5SD4754.jpg");
            arrayList.add(resourceVo);
        }
        return arrayList;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final void F1() {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < 10; i2++) {
            CustomerServiceReasonVo customerServiceReasonVo = new CustomerServiceReasonVo();
            customerServiceReasonVo.setKey(OperatorName.SET_FLATNESS + i2);
            customerServiceReasonVo.setName("kchang" + i2);
            customerServiceReasonVo.setPhone("1331653776");
            customerServiceReasonVo.setReason("外面凉的衣服被雨淋湿了，赔钱。。。");
            customerServiceReasonVo.setReply("尊敬的租客您好，您反映的问题我们已经联系了相关负责人进行了处理,感谢您的建议,祝您生活愉快！");
            customerServiceReasonVo.setTime(Long.valueOf(System.currentTimeMillis()));
            ResourceVo resourceVo = new ResourceVo();
            resourceVo.setUrl("http://pic41.nipic.com/20140514/10284450_152332150000_2.jpg");
            customerServiceReasonVo.setUserIcon(resourceVo);
            customerServiceReasonVo.setReasonList(E1());
            customerServiceReasonVo.setReplyList(E1());
            arrayList.add(customerServiceReasonVo);
        }
        this.t.initListData(arrayList);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        this.r = this.mRecyclerView;
        F1();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_custome_service_reason;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void j0() {
    }
}
