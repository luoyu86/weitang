package c.e.c.t.p;

import c.e.a.d.o;
import c.e.a.d.q;
import c.e.a.d.x;
import c.e.c.t.q.b;
import c.e.c.t.q.c;
import c.e.c.t.q.d;
import com.alibaba.fastjson.JSON;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.life.vo.SubmitLifeOrderVo;
import com.chinavisionary.microtang.life.vo.SubmitOrderRequestParamVo;
import com.chinavisionary.microtang.life.vo.TimeSelectVo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class a {
    public final List<c.e.c.t.q.a> a(List<c> list, String str) {
        ArrayList arrayList = new ArrayList();
        if (o.isNotEmpty(list)) {
            int size = list.size();
            int i2 = 0;
            while (i2 < size) {
                c cVar = list.get(i2);
                if (cVar != null) {
                    c.e.c.t.q.a aVar = new c.e.c.t.q.a();
                    aVar.setHasSelect(i2 == 0);
                    aVar.setKey(cVar.getValue());
                    aVar.setValue(cVar.getValue());
                    aVar.setTitle(cVar.getLabel());
                    aVar.setField(str);
                    arrayList.add(aVar);
                }
                i2++;
            }
        }
        return arrayList;
    }

    public List<SubmitLifeOrderVo> getListToQuestionBean(List<d> list) {
        ArrayList arrayList = new ArrayList();
        if (o.isNotEmpty(list)) {
            int size = list.size();
            int i2 = 0;
            while (i2 < size) {
                d dVar = list.get(i2);
                if (dVar != null) {
                    SubmitLifeOrderVo submitLifeOrderVo = new SubmitLifeOrderVo();
                    submitLifeOrderVo.setItemType(SubmitLifeOrderVo.ITEM_TYPE_CB);
                    submitLifeOrderVo.setTitle(dVar.getTitle());
                    submitLifeOrderVo.setShowSplitLine(i2 == size + (-1));
                    submitLifeOrderVo.setKeyValueVos(a(dVar.getOptions(), dVar.getField()));
                    arrayList.add(submitLifeOrderVo);
                }
                i2++;
            }
        }
        return arrayList;
    }

    public List<SubmitLifeOrderVo> getSubmitLiefOrder(String str, List<SubmitLifeOrderVo> list) {
        ArrayList arrayList = new ArrayList();
        SubmitLifeOrderVo submitLifeOrderVo = new SubmitLifeOrderVo();
        submitLifeOrderVo.setItemType(SubmitLifeOrderVo.ITEM_TYPE_ADDRESS);
        submitLifeOrderVo.setValue(str);
        arrayList.add(submitLifeOrderVo);
        SubmitLifeOrderVo submitLifeOrderVo2 = new SubmitLifeOrderVo();
        submitLifeOrderVo2.setItemType(SubmitLifeOrderVo.ITEM_TYPE_TIME);
        submitLifeOrderVo2.setHintValue(x.getString(R.string.tip_select_title_express_time));
        arrayList.add(submitLifeOrderVo2);
        if (o.isNotEmpty(list)) {
            arrayList.addAll(list);
        }
        SubmitLifeOrderVo submitLifeOrderVo3 = new SubmitLifeOrderVo();
        submitLifeOrderVo3.setItemType(SubmitLifeOrderVo.ITEM_TYPE_EDT);
        submitLifeOrderVo3.setTitle(x.getString(R.string.title_order_remark));
        arrayList.add(submitLifeOrderVo3);
        return arrayList;
    }

    public SubmitOrderRequestParamVo getSubmitOrderRequestParamVo(List<SubmitLifeOrderVo> list) {
        SubmitOrderRequestParamVo submitOrderRequestParamVo = new SubmitOrderRequestParamVo();
        HashMap map = new HashMap();
        submitOrderRequestParamVo.setKeyValueMap(map);
        if (o.isNotEmpty(list)) {
            q.d("SubmitOrderData", "getSubmitOrderRequestParamVo dataList = " + JSON.toJSONString(list));
            Iterator<SubmitLifeOrderVo> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                SubmitLifeOrderVo next = it.next();
                if (next != null) {
                    int itemType = next.getItemType();
                    if (itemType == 221) {
                        if (!x.isNotNull(next.getValue())) {
                            submitOrderRequestParamVo.setErr(true);
                            submitOrderRequestParamVo.setErrMsgTip("请选择配送时间");
                            break;
                        }
                        map.put("deliveryTime", next.getValue());
                    } else if (itemType == 241) {
                        List<c.e.c.t.q.a> keyValueVos = next.getKeyValueVos();
                        if (o.isNotEmpty(keyValueVos)) {
                            boolean z = false;
                            for (c.e.c.t.q.a aVar : keyValueVos) {
                                if (aVar != null && aVar.isHasSelect()) {
                                    map.put(aVar.getField(), aVar.getValue());
                                    z = true;
                                }
                            }
                            if (!z) {
                                submitOrderRequestParamVo.setErr(true);
                                submitOrderRequestParamVo.setErrMsgTip("请选择" + next.getTitle());
                                return submitOrderRequestParamVo;
                            }
                        } else {
                            continue;
                        }
                    } else if (itemType == 245 && x.isNotNull(next.getValue())) {
                        submitOrderRequestParamVo.setRemark(next.getValue());
                    }
                }
            }
        }
        return submitOrderRequestParamVo;
    }

    public TimeSelectVo getTimeSelectVo(List<b> list) {
        String str;
        TimeSelectVo timeSelectVo = new TimeSelectVo();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (o.isNotEmpty(list)) {
            for (b bVar : list) {
                if (bVar != null) {
                    if (o.isNotEmpty(bVar.getTime())) {
                        try {
                            str = bVar.getTime().get(0);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            str = "";
                        }
                        arrayList.add(bVar.getDay() + str);
                        arrayList2.add(bVar.getTime());
                    } else {
                        str = "";
                        arrayList.add(bVar.getDay() + str);
                        arrayList2.add(bVar.getTime());
                    }
                }
            }
        }
        timeSelectVo.setOneList(arrayList);
        timeSelectVo.setTwoList(arrayList2);
        return timeSelectVo;
    }
}
