package c.e.c.f0.a;

import c.e.a.d.x;
import com.chinavisionary.core.weight.banner.EditBannerView;
import com.chinavisionary.framework.mobile.common.vo.ResourceVo;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.recommend.vo.RecommendVo;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f1432a = new a();

    public static a getInstance() {
        return f1432a;
    }

    public final List<EditBannerView.BannerDto> a(int i2) {
        ArrayList arrayList = new ArrayList(i2);
        EditBannerView.BannerDto bannerDto = new EditBannerView.BannerDto();
        bannerDto.setBannerKey("banner key");
        bannerDto.setCover(c());
        arrayList.add(bannerDto);
        return arrayList;
    }

    public final List<RecommendVo> b(int i2) {
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < i2; i3++) {
            RecommendVo recommendVo = new RecommendVo();
            recommendVo.setTitle("恭喜您成功推荐新人入住 , 奖励已发放至您的卡券!");
            recommendVo.setCurrentTime(Long.valueOf(System.currentTimeMillis()));
            recommendVo.setRecommendedPersonName("Kchang");
            recommendVo.setRecommendedPersonPhone("1331642996" + i3);
            arrayList.add(recommendVo);
        }
        return arrayList;
    }

    public final ResourceVo c() {
        ResourceVo resourceVo = new ResourceVo();
        resourceVo.setKey("resource vo");
        resourceVo.setSampleUrl("2131493062");
        resourceVo.setUrl("2131493062");
        return resourceVo;
    }

    public List<RecommendVo> getRecommendList() {
        ArrayList arrayList = new ArrayList();
        RecommendVo recommendVo = new RecommendVo();
        recommendVo.setItemType(1);
        recommendVo.setBannerList(a(1));
        arrayList.add(recommendVo);
        RecommendVo recommendVo2 = new RecommendVo();
        recommendVo2.setItemType(2);
        recommendVo2.setTitle(x.getString(R.string.title_me_recommend));
        arrayList.add(recommendVo2);
        arrayList.addAll(b(9));
        return arrayList;
    }
}
