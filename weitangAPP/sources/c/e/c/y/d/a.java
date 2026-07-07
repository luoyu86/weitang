package c.e.c.y.d;

import c.e.a.a.b;
import c.e.a.d.z;
import com.chinavisionary.core.app.config.bo.LeftTitleToRightArrowVo;
import com.chinavisionary.core.weight.banner.EditBannerView;
import com.chinavisionary.framework.mobile.common.vo.ResourceVo;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.buycart.vo.BuyCartProductVo;
import com.chinavisionary.microtang.buycart.vo.BuyCartVo;
import com.chinavisionary.microtang.comment.vo.ScoresBean;
import com.chinavisionary.microtang.merchant.vo.MerchantRightContentVo;
import com.chinavisionary.microtang.prelook.vo.TagVo;
import com.chinavisionary.microtang.repair.vo.RepairLeftVo;
import com.chinavisionary.microtang.room.vo.MoreRentCommentVo;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.android.agoo.common.AgooConstants;

/* JADX INFO: loaded from: classes.dex */
public class a {
    public static ResourceVo a() {
        ResourceVo resourceVo = new ResourceVo();
        resourceVo.setKey("232342");
        resourceVo.setUrl("http://5b0988e595225.cdn.sohucs.com/images/20171230/43714e0a04b44b17adaf14d57e03874c.jpeg");
        resourceVo.setSampleUrl("http://5b0988e595225.cdn.sohucs.com/images/20171230/43714e0a04b44b17adaf14d57e03874c.jpeg");
        return resourceVo;
    }

    public static List<BuyCartProductVo> b(int i2) {
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < i2; i3++) {
            BuyCartProductVo buyCartProductVo = new BuyCartProductVo();
            buyCartProductVo.setBaseKey("023923" + i3);
            buyCartProductVo.setCommodityName("青椒炒肉");
            buyCartProductVo.setCommodityCover(a());
            buyCartProductVo.setQuantity(2);
            buyCartProductVo.setCommoditySpecificationName("辣椒多+ " + i3);
            buyCartProductVo.setLimit(2);
            buyCartProductVo.setCommoditySpecificationPrice(new BigDecimal(23));
            buyCartProductVo.setSurplusNumber(2);
            buyCartProductVo.setSelect(true);
            arrayList.add(buyCartProductVo);
        }
        return arrayList;
    }

    public static ResourceVo c() {
        ResourceVo resourceVo = new ResourceVo();
        resourceVo.setKey("232342");
        resourceVo.setUrl("http://www.naixueteajm.com/uploads/allimg/180407/3-1P40GP3261V.jpg");
        resourceVo.setSampleUrl("http://www.naixueteajm.com/uploads/allimg/180407/3-1P40GP3261V.jpg");
        return resourceVo;
    }

    public static List<LeftTitleToRightArrowVo> d() {
        ArrayList arrayList = new ArrayList();
        LeftTitleToRightArrowVo leftTitleToRightArrowVo = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo.setLeft("备注");
        leftTitleToRightArrowVo.setRight("我不要🌶这个东西，谢谢");
        leftTitleToRightArrowVo.setType(2);
        leftTitleToRightArrowVo.setShowSplitLine(false);
        arrayList.add(leftTitleToRightArrowVo);
        LeftTitleToRightArrowVo leftTitleToRightArrowVo2 = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo2.setLeft("包装费");
        leftTitleToRightArrowVo2.setRight(AgooConstants.ACK_PACK_NULL);
        leftTitleToRightArrowVo2.setShowRmbUnit(true);
        leftTitleToRightArrowVo2.setType(2);
        leftTitleToRightArrowVo2.setShowSplitLine(false);
        arrayList.add(leftTitleToRightArrowVo2);
        LeftTitleToRightArrowVo leftTitleToRightArrowVo3 = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo3.setLeft("配送费");
        leftTitleToRightArrowVo3.setRight(AgooConstants.ACK_PACK_NULL);
        leftTitleToRightArrowVo3.setType(2);
        leftTitleToRightArrowVo3.setShowSplitLine(false);
        leftTitleToRightArrowVo3.setShowRmbUnit(true);
        arrayList.add(leftTitleToRightArrowVo3);
        LeftTitleToRightArrowVo leftTitleToRightArrowVo4 = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo4.setLeft("合计");
        leftTitleToRightArrowVo4.setRight(AgooConstants.REPORT_NOT_ENCRYPT);
        leftTitleToRightArrowVo4.setShowRmbUnit(true);
        leftTitleToRightArrowVo4.setRightFontColor(R.color.image_color_red);
        leftTitleToRightArrowVo4.setType(2);
        leftTitleToRightArrowVo4.setShowSplitLine(true);
        leftTitleToRightArrowVo4.setSplitLineHeight(b.getInstance().getResources().getDimensionPixelSize(R.dimen.dp_8));
        arrayList.add(leftTitleToRightArrowVo4);
        return arrayList;
    }

    public static List<ResourceVo> e(int i2) {
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < i2; i3++) {
            arrayList.add(getCoverResource());
        }
        return arrayList;
    }

    public static List<EditBannerView.BannerDto> getBannerVoList(int i2) {
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < i2; i3++) {
            EditBannerView.BannerDto bannerDto = new EditBannerView.BannerDto();
            bannerDto.setDataKey("http://www.baidu.com" + i3);
            bannerDto.setCover(c());
            bannerDto.setKey("http://www.baidu.com" + i3);
            bannerDto.setDataType(i3);
            bannerDto.setTitle("青椒炒肉");
            arrayList.add(bannerDto);
        }
        return arrayList;
    }

    public static List<MoreRentCommentVo> getCommentData(int i2) {
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < i2; i3++) {
            MoreRentCommentVo moreRentCommentVo = new MoreRentCommentVo();
            moreRentCommentVo.setCommentContent("我买了个青椒炒肉，第二天捂着屁股去的公司，不要问我好不好吃？就是太好吃了辣椒都吃完啦！");
            moreRentCommentVo.setAssetInstanceKey("00234923" + i3);
            moreRentCommentVo.setCommentUserName("法外狂徒张三");
            moreRentCommentVo.setCommentDate(Long.valueOf(System.currentTimeMillis()));
            moreRentCommentVo.setPictures(e(4));
            moreRentCommentVo.setUserIconResourceVo(getUserIconResource());
            arrayList.add(moreRentCommentVo);
        }
        return arrayList;
    }

    public static List<ScoresBean> getCommentScore() {
        ArrayList arrayList = new ArrayList();
        ScoresBean scoresBean = new ScoresBean();
        scoresBean.setScoreType(AgooConstants.ACK_PACK_NULL);
        scoresBean.setScoreTypeDesc("评分");
        arrayList.add(scoresBean);
        return arrayList;
    }

    public static List<MerchantRightContentVo> getContentListToSize(int i2) {
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < i2; i3++) {
            MerchantRightContentVo merchantRightContentVo = new MerchantRightContentVo();
            merchantRightContentVo.setTitle("精品推荐" + i3);
            merchantRightContentVo.setTitlePosition(i3);
            merchantRightContentVo.setBaseKey("0000" + i3);
            merchantRightContentVo.setItemType(101);
            arrayList.add(merchantRightContentVo);
            arrayList.addAll(getFoodVoToSize(4, 2));
        }
        return arrayList;
    }

    public static ResourceVo getCoverResource() {
        ResourceVo resourceVo = new ResourceVo();
        resourceVo.setKey("232342");
        resourceVo.setUrl("http://09imgmini.eastday.com/mobile/20190215/20190215124643_ae71f00fa44ddaa93df47bd3c24d53df_2.jpeg");
        resourceVo.setSampleUrl("http://09imgmini.eastday.com/mobile/20190215/20190215124643_ae71f00fa44ddaa93df47bd3c24d53df_2.jpeg");
        return resourceVo;
    }

    public static BuyCartVo getFoodSettlementList(int i2) {
        BuyCartVo buyCartVo = new BuyCartVo();
        buyCartVo.setMerchantName("微棠.食");
        buyCartVo.setCover(c());
        buyCartVo.setSelect(true);
        buyCartVo.setName("菜品名称");
        buyCartVo.setCommodities(b(i2));
        return buyCartVo;
    }

    public static List<MerchantRightContentVo> getFoodVoToSize(int i2, int i3) {
        ArrayList arrayList = new ArrayList();
        int i4 = 0;
        while (i4 < i2) {
            MerchantRightContentVo merchantRightContentVo = new MerchantRightContentVo();
            merchantRightContentVo.setBaseKey("023923" + i4);
            merchantRightContentVo.setTitle("好好吃肉");
            merchantRightContentVo.setItemType(102);
            MerchantRightContentVo.FoodVo foodVo = new MerchantRightContentVo.FoodVo();
            foodVo.setBaseKey("1000" + i4);
            foodVo.setCoverRes(a());
            foodVo.setMonthSaleVolume(i4 + 160);
            foodVo.setPrice(new BigDecimal(i4 + 12));
            foodVo.setTitle("加辣" + i4);
            foodVo.setMaxLimit(i4 + 5);
            foodVo.setMultiSpec(i4 < 3);
            merchantRightContentVo.setFoodVo(foodVo);
            arrayList.add(merchantRightContentVo);
            i4++;
        }
        return arrayList;
    }

    public static ResourceVo getMerchantCoverResource() {
        ResourceVo resourceVo = new ResourceVo();
        resourceVo.setKey("232342");
        resourceVo.setUrl("http://5b0988e595225.cdn.sohucs.com/images/20181126/d72b178100654ebd845f14d8784c2165.jpeg");
        resourceVo.setSampleUrl("http://5b0988e595225.cdn.sohucs.com/images/20181126/d72b178100654ebd845f14d8784c2165.jpeg");
        return resourceVo;
    }

    public static ResourceVo getMerchantIconResource() {
        ResourceVo resourceVo = new ResourceVo();
        resourceVo.setKey("232342");
        resourceVo.setUrl("http://app.axjmw.com/uploads/allimg/19031401/1667A9CDCDC.jpg");
        resourceVo.setSampleUrl("http://app.axjmw.com/uploads/allimg/19031401/1667A9CDCDC.jpg");
        return resourceVo;
    }

    public static List<LeftTitleToRightArrowVo> getMerchantInfoList(int i2) {
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        while (i3 < i2) {
            LeftTitleToRightArrowVo leftTitleToRightArrowVo = new LeftTitleToRightArrowVo();
            leftTitleToRightArrowVo.setLeft("商户地址");
            leftTitleToRightArrowVo.setRight("龙华区元芬新村78栋3楼301");
            leftTitleToRightArrowVo.setShowArrow(i3 == i2 + (-1));
            arrayList.add(leftTitleToRightArrowVo);
            i3++;
        }
        return arrayList;
    }

    public static List<LeftTitleToRightArrowVo> getOrderDetailsFeeList(int i2) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(d());
        for (int i3 = 0; i3 < i2; i3++) {
            LeftTitleToRightArrowVo leftTitleToRightArrowVo = new LeftTitleToRightArrowVo();
            leftTitleToRightArrowVo.setLeft("支付时间");
            leftTitleToRightArrowVo.setRight(z.getCurrentTimeInString());
            arrayList.add(leftTitleToRightArrowVo);
        }
        return arrayList;
    }

    public static List<MerchantRightContentVo.FoodVo> getProductSpecList(int i2) {
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        while (i3 < i2) {
            MerchantRightContentVo.FoodVo foodVo = new MerchantRightContentVo.FoodVo();
            foodVo.setTitle("不要辣+" + i3);
            foodVo.setPrice(new BigDecimal("12.2" + i3));
            foodVo.setBaseKey("9230" + i3);
            i3++;
            foodVo.setMaxLimit(i3);
            arrayList.add(foodVo);
        }
        return arrayList;
    }

    public static List<RepairLeftVo> getRepairLeftVoList(int i2) {
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        while (i3 < i2) {
            RepairLeftVo repairLeftVo = new RepairLeftVo();
            repairLeftVo.setBaseKey("023923" + i3);
            repairLeftVo.setTitle("精品推荐" + i3);
            repairLeftVo.setSelect(i3 == 0);
            repairLeftVo.setRelationPosition(i3 * 5);
            arrayList.add(repairLeftVo);
            i3++;
        }
        return arrayList;
    }

    public static List<TagVo> getSalePriceTagList(int i2) {
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < i2; i3++) {
            TagVo tagVo = new TagVo();
            tagVo.setContent("￥4" + i3);
            arrayList.add(tagVo);
        }
        return arrayList;
    }

    public static List<TagVo> getTagList(int i2) {
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < i2; i3++) {
            TagVo tagVo = new TagVo();
            tagVo.setContent("不辣" + i3);
            arrayList.add(tagVo);
        }
        return arrayList;
    }

    public static ResourceVo getUserIconResource() {
        ResourceVo resourceVo = new ResourceVo();
        resourceVo.setKey("232342");
        resourceVo.setUrl("http://imagecn.gasgoo.com/moblogo/News/UEditor/700-X/20180209/6365377177003542836704269.jpg");
        resourceVo.setSampleUrl("http://imagecn.gasgoo.com/moblogo/News/UEditor/700-X/20180209/6365377177003542836704269.jpg");
        return resourceVo;
    }
}
