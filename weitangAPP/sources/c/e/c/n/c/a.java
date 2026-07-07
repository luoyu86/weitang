package c.e.c.n.c;

import c.e.a.d.w;
import c.e.a.d.x;
import c.e.a.d.z;
import com.alibaba.fastjson.JSON;
import com.chinavisionary.framework.mobile.common.vo.ResourceVo;
import com.chinavisionary.microtang.community.vo.CommunityActivityItemVo;
import com.chinavisionary.microtang.community.vo.LatLngVo;
import com.chinavisionary.microtang.community.vo.NewCommunityActivityItemVo;
import com.chinavisionary.microtang.order.vo.KeyValueVo;
import com.tom_roush.pdfbox.contentstream.operator.OperatorName;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f1706a = new a();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public LatLngVo f1711f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<KeyValueVo> f1707b = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Map<String, String> f1708c = new HashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List<String> f1709d = new ArrayList();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List<String> f1710e = new ArrayList();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ReentrantLock f1712g = new ReentrantLock();

    public static CommunityActivityItemVo getCommunityActivityItemVo(NewCommunityActivityItemVo newCommunityActivityItemVo) {
        CommunityActivityItemVo communityActivityItemVo = new CommunityActivityItemVo();
        communityActivityItemVo.setActivityName(newCommunityActivityItemVo.getTitle());
        communityActivityItemVo.setKey(newCommunityActivityItemVo.getPrimaryKey());
        communityActivityItemVo.setActivityStartTime(newCommunityActivityItemVo.getStartTime());
        communityActivityItemVo.setActivityEndTime(newCommunityActivityItemVo.getEndTime());
        communityActivityItemVo.setApplyStartTime(newCommunityActivityItemVo.getApplyStartTime());
        communityActivityItemVo.setApplyEndTime(newCommunityActivityItemVo.getApplyEndTime());
        communityActivityItemVo.setRealNumber(newCommunityActivityItemVo.getApplyNum());
        communityActivityItemVo.setMaxNumber(newCommunityActivityItemVo.getMaxNumber());
        communityActivityItemVo.setFinishFlag(newCommunityActivityItemVo.isFinishFlag());
        communityActivityItemVo.setHref(newCommunityActivityItemVo.getH5Url());
        communityActivityItemVo.setDistance(newCommunityActivityItemVo.getDistance());
        communityActivityItemVo.setActivityLab(getInstance().getActivityLabToKey(newCommunityActivityItemVo.getActivityLab()));
        communityActivityItemVo.setActivityAddress(newCommunityActivityItemVo.getShowAppAddress());
        ResourceVo resourceVo = new ResourceVo();
        resourceVo.setUrl(newCommunityActivityItemVo.getCoverUrl());
        communityActivityItemVo.setLogo(resourceVo);
        return communityActivityItemVo;
    }

    public static synchronized a getInstance() {
        return f1706a;
    }

    public final ResourceVo a(String str) {
        ResourceVo resourceVo = new ResourceVo();
        resourceVo.setKey("3435");
        resourceVo.setUrl(str);
        resourceVo.setSampleUrl(str);
        return resourceVo;
    }

    public final List<ResourceVo> b() {
        String[] strArr = {"https://alifei02.cfp.cn/creative/vcg/800/new/VCG211177178924.jpg", "https://tenfei02.cfp.cn/creative/vcg/800/new/VCG211177178902.jpg", "https://alifei03.cfp.cn/creative/vcg/800/new/VCG211177282880.jpg"};
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < 3; i2++) {
            arrayList.add(a(strArr[i2]));
        }
        return arrayList;
    }

    public List<String> getActivityLabKeyList() {
        this.f1712g.lock();
        try {
            return this.f1710e;
        } finally {
            this.f1712g.unlock();
        }
    }

    public List<KeyValueVo> getActivityLabList() {
        this.f1712g.lock();
        try {
            return this.f1707b;
        } finally {
            this.f1712g.unlock();
        }
    }

    public String getActivityLabToKey(String str) {
        this.f1712g.lock();
        try {
            return (x.isNotNull(str) && this.f1708c.containsKey(str)) ? this.f1708c.get(str) : null;
        } finally {
            this.f1712g.unlock();
        }
    }

    public List<String> getActivityLabValueList() {
        this.f1712g.lock();
        try {
            return this.f1709d;
        } finally {
            this.f1712g.unlock();
        }
    }

    public LatLngVo getLatLngVo() {
        return this.f1711f;
    }

    public List<KeyValueVo> getTestData() {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < 5; i2++) {
            KeyValueVo keyValueVo = new KeyValueVo();
            keyValueVo.setKey(OperatorName.SET_FLATNESS + i2);
            keyValueVo.setValue("运动活动" + i2);
            arrayList.add(keyValueVo);
        }
        return arrayList;
    }

    public void initActivityConstantData() {
        String string = w.getInstance().getString("activity_constant_key", null);
        if (x.isNotNull(string)) {
            try {
                setActivityLabList(JSON.parseArray(string, KeyValueVo.class));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public boolean setActivityLabList(List<KeyValueVo> list) {
        this.f1712g.lock();
        try {
            String jSONString = JSON.toJSONString(list);
            boolean z = !JSON.toJSONString(this.f1707b).equals(jSONString);
            this.f1708c.clear();
            this.f1707b.clear();
            this.f1707b.addAll(list);
            w.getInstance().putString("activity_constant_key", jSONString);
            this.f1710e.clear();
            this.f1709d.clear();
            for (KeyValueVo keyValueVo : list) {
                if (keyValueVo != null) {
                    this.f1708c.put(keyValueVo.getKey(), keyValueVo.getValue());
                    this.f1710e.add(keyValueVo.getKey());
                    this.f1709d.add(keyValueVo.getValue());
                }
            }
            return z;
        } finally {
            this.f1712g.unlock();
        }
    }

    public void setLatLngVo(LatLngVo latLngVo) {
        this.f1711f = latLngVo;
    }

    public List<CommunityActivityItemVo> getTestData(int i2) {
        ArrayList arrayList = new ArrayList(i2);
        List<ResourceVo> listB = b();
        int size = listB.size();
        for (int i3 = 0; i3 < i2; i3++) {
            CommunityActivityItemVo communityActivityItemVo = new CommunityActivityItemVo();
            communityActivityItemVo.setKey("i = " + i3);
            communityActivityItemVo.setLogo(listB.get(i3 % size));
            communityActivityItemVo.setActivityName("爬山活动 | 户外社团邀请您来一起登顶梧");
            communityActivityItemVo.setPublisher("刘德华");
            communityActivityItemVo.setActivityStatusDesc("进行中");
            communityActivityItemVo.setActivityPersonNumber(i3);
            communityActivityItemVo.setActivityStartTime(Long.valueOf(System.currentTimeMillis()));
            communityActivityItemVo.setActivityEndTime(Long.valueOf(z.getNextDayToAmount(3)));
            communityActivityItemVo.setViewType(122);
            arrayList.add(communityActivityItemVo);
        }
        return arrayList;
    }
}
