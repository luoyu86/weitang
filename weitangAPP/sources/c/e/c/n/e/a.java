package c.e.c.n.e;

import com.chinavisionary.framework.mobile.common.vo.ResourceVo;
import com.chinavisionary.microtang.community.vo.CommunityActivityVo;
import com.chinavisionary.microtang.community.vo.CommunityCommentVo;
import com.chinavisionary.microtang.community.vo.CommunityGuideVo;
import com.chinavisionary.microtang.community.vo.CommunityVo;
import com.chinavisionary.microtang.main.vo.ModelBannerVo;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f1731a = new a();

    public static a getInstance() {
        return f1731a;
    }

    public final List<CommunityVo> a() {
        ArrayList arrayList = new ArrayList();
        CommunityVo communityVo = new CommunityVo();
        communityVo.setViewType(1222);
        CommunityActivityVo communityActivityVo = new CommunityActivityVo();
        communityActivityVo.setTitle("新冠状病毒在全球大爆发");
        communityActivityVo.setSubtitle("两个月蒸发629万亿韩元 100家韩国上市公司市值大幅缩水");
        communityActivityVo.setCoverResource(e("http://img.yxad.cn/images/20181208/3b60c0c0dfaf4c2580c92b7a8bb46235.jpeg"));
        communityActivityVo.setPublisher("微棠食");
        communityActivityVo.setCommentCount(43);
        communityActivityVo.setPublishTime(Long.valueOf(System.currentTimeMillis()));
        communityVo.setCommunityActivityVo(communityActivityVo);
        arrayList.add(communityVo);
        String[] strArrG = g();
        String[] strArrD = d();
        int length = strArrG.length;
        for (int i2 = 0; i2 < length; i2++) {
            CommunityVo communityVoM73clone = communityVo.m73clone();
            CommunityActivityVo communityActivityVoMo71clone = communityVoM73clone.getCommunityActivityVo().mo71clone();
            communityActivityVoMo71clone.setTopSticky(false);
            communityActivityVoMo71clone.setTitle(strArrG[i2]);
            communityActivityVoMo71clone.setSubtitle(strArrG[i2]);
            communityActivityVoMo71clone.setCoverResource(e(strArrD[i2]));
            arrayList.add(communityVoM73clone);
        }
        return arrayList;
    }

    public final List<CommunityVo> b() {
        ArrayList arrayList = new ArrayList();
        CommunityVo communityVo = new CommunityVo();
        communityVo.setViewType(1333);
        CommunityCommentVo communityCommentVo = new CommunityCommentVo();
        communityCommentVo.setContent("新冠状病毒在全球大爆发");
        communityCommentVo.setUserName("王者荣耀");
        communityCommentVo.setLikeCount(23);
        communityCommentVo.setUserIconResource(e("https://images.uiiiuiii.com/wp-content/uploads/2018/07/i-bn20180725-2-04.jpg"));
        communityCommentVo.setCommentCount(43);
        communityCommentVo.setPublishTime(Long.valueOf(System.currentTimeMillis()));
        communityVo.setCommunityCommentVo(communityCommentVo);
        arrayList.add(communityVo);
        String[] strArrG = g();
        d();
        int length = strArrG.length;
        for (int i2 = 0; i2 < length; i2++) {
            CommunityVo communityVoM73clone = communityVo.m73clone();
            CommunityCommentVo communityCommentVoM72clone = communityVoM73clone.getCommunityCommentVo().m72clone();
            communityCommentVoM72clone.setContent("新冠状病毒在全球大爆发");
            communityCommentVoM72clone.setUserName("王者荣耀");
            communityCommentVoM72clone.setLikeCount(23);
            communityCommentVoM72clone.setCommentCount(43);
            communityCommentVoM72clone.setPublishPicList(f());
            communityCommentVoM72clone.setPublishTime(Long.valueOf(System.currentTimeMillis()));
            communityVo.setCommunityCommentVo(communityCommentVoM72clone);
            arrayList.add(communityVoM73clone);
        }
        return arrayList;
    }

    public final List<CommunityVo> c() {
        ArrayList arrayList = new ArrayList();
        CommunityVo communityVo = new CommunityVo();
        communityVo.setViewType(1444);
        ArrayList arrayList2 = new ArrayList();
        for (ResourceVo resourceVo : f()) {
            ModelBannerVo modelBannerVo = new ModelBannerVo();
            ModelBannerVo.ParamBean paramBean = new ModelBannerVo.ParamBean();
            paramBean.setHref("http://www.yuanjingweitang.com");
            paramBean.setTitle("测试banner");
            paramBean.setResourceVo(resourceVo);
            modelBannerVo.setParam(paramBean);
            arrayList2.add(modelBannerVo);
        }
        communityVo.setDataList(arrayList2);
        arrayList.add(communityVo);
        CommunityVo communityVo2 = new CommunityVo();
        communityVo2.setViewType(1111);
        CommunityGuideVo communityGuideVo = new CommunityGuideVo();
        communityGuideVo.setTitle("新冠状病毒在全球大爆发");
        communityGuideVo.setTopSticky(true);
        communityGuideVo.setTopSticky("置顶");
        communityGuideVo.setPublisher("特朗普");
        communityGuideVo.setCommentCount(23);
        communityGuideVo.setPublishTime(Long.valueOf(System.currentTimeMillis()));
        communityVo2.setCommunityGuideVo(communityGuideVo);
        arrayList.add(communityVo2);
        for (String str : g()) {
            CommunityGuideVo communityGuideVoMo71clone = communityVo2.m73clone().getCommunityGuideVo().mo71clone();
            communityGuideVoMo71clone.setTopSticky(false);
            communityGuideVoMo71clone.setTitle(str);
        }
        arrayList.addAll(a().subList(0, 2));
        arrayList.addAll(b().subList(0, 4));
        return arrayList;
    }

    public final String[] d() {
        return new String[]{"http://img.yxad.cn/images/20181208/bab220aa83084895b76f4bd8a0284f95.jpeg", "http://img.yxad.cn/images/20181208/ff881eff29304d62aac25cb95b2562fe.jpeg", "https://images.uiiiuiii.com/wp-content/uploads/2018/07/i-bn20180725-2-02.png", "https://images.uiiiuiii.com/wp-content/uploads/2018/07/i-bn20180725-2-04.jpg", "https://images.uiiiuiii.com/wp-content/uploads/2018/07/i-bn20180725-2-03.jpg", "https://img11.360buyimg.com/cms/jfs/t1/91431/17/10002/108103/5e155110Efbac44dd/558d622f067fa5f8.jpg", "https://images.uiiiuiii.com/wp-content/uploads/2018/07/i-bn20180725-2-07.jpg", "https://img30.360buyimg.com/jgsq-productsoa/jfs/t1/92683/18/14989/169194/5e6ed724Ea6e0e1c7/a4d1f5e474da040e.jpg", "http://img.yxad.cn/images/20181208/3b60c0c0dfaf4c2580c92b7a8bb46235.jpeg", "http://img.yxad.cn/images/20181208/3b60c0c0dfaf4c2580c92b7a8bb46235.jpeg", "http://img.yxad.cn/images/20181208/3b60c0c0dfaf4c2580c92b7a8bb46235.jpeg", "http://img.yxad.cn/images/20181208/ca8265a00cc24b7eafbb1b8d24a61953.jpeg"};
    }

    public final ResourceVo e(String str) {
        ResourceVo resourceVo = new ResourceVo();
        resourceVo.setKey("3435");
        resourceVo.setUrl(str);
        resourceVo.setSampleUrl(str);
        return resourceVo;
    }

    public final ArrayList<ResourceVo> f() {
        String[] strArrD = d();
        ArrayList<ResourceVo> arrayList = new ArrayList<>();
        for (String str : strArrD) {
            arrayList.add(e(str));
        }
        return arrayList;
    }

    public final String[] g() {
        return new String[]{"阿里CTO程立卸任蚂蚁金服子公司职务", "河北首例输入病例", "美国新增4776例", "武汉就业扶贫举措", "东京奥运推迟方案", "武汉主要商超营业", "意大利新冠肺炎死亡病例超过5000例", "软银宣布出售41亿美元资产，为回购股票提供资金", "OPPO Find X2 Pro使用感受 目之所及皆极致", "征战下沉市场，电商B2B如何突围?", "应勇辞去上海市市长，龚正任上海市代市长", "立思辰跌停，计算机应用行业跌4.27%"};
    }

    public List<CommunityVo> getTestData(int i2) {
        return i2 != 1 ? i2 != 2 ? c() : b() : a();
    }
}
