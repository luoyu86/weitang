package c.e.c.h0.g;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import c.e.a.d.n;
import c.e.a.d.o;
import c.e.a.d.q;
import c.e.a.d.x;
import com.chinavisionary.core.app.oss.bo.RoomBannerBo;
import com.chinavisionary.core.weight.CoreRoundedImageView;
import com.chinavisionary.framework.mobile.common.vo.ResourceVo;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.main.vo.BannerDataVo;
import com.chinavisionary.microtang.room.vo.ProductDetailsVo;
import com.lzy.ninegrid.preview.ImagePreviewActivity;
import com.nex3z.flowlayout.FlowLayout;
import com.tom_roush.fontbox.ttf.OS2WindowsMetricsTable;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1524a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<TextView> f1525b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Map<Integer, Integer> f1526c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Map<Integer, Integer> f1527d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List<ResourceVo> f1528e = new ArrayList();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public FragmentActivity f1529f;

    public a(FragmentActivity fragmentActivity) {
        this.f1529f = fragmentActivity;
    }

    public final void a(int i2, int i3) {
        if (this.f1527d.containsKey(Integer.valueOf(i2))) {
            return;
        }
        this.f1527d.put(Integer.valueOf(i2), Integer.valueOf(i3));
    }

    public void addProductTag(List<ProductDetailsVo.TagsBean> list, FlowLayout flowLayout) {
        flowLayout.removeAllViews();
        if (list == null || list.isEmpty()) {
            return;
        }
        int dimensionPixelSize = this.f1529f.getResources().getDimensionPixelSize(R.dimen.dp_4);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, dimensionPixelSize, 0, 0);
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            String tagName = list.get(i2).getTagName();
            if (x.isNotNull(tagName)) {
                TextView textView = new TextView(flowLayout.getContext());
                textView.setText(tagName);
                textView.setBackgroundResource(R.drawable.bg_room_details_tag);
                textView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
                textView.setTextAppearance(flowLayout.getContext(), R.style.ProductDetailsTagTvStyle);
                flowLayout.addView(textView, layoutParams);
            }
        }
    }

    public final BannerDataVo b(List<ProductDetailsVo.BannersBean> list) {
        BannerDataVo bannerDataVo = new BannerDataVo();
        ArrayList arrayList = new ArrayList();
        HashMap map = new HashMap();
        ArrayList arrayList2 = new ArrayList();
        if (list != null && !list.isEmpty()) {
            for (ProductDetailsVo.BannersBean bannersBean : list) {
                if (bannersBean != null) {
                    String tagKey = bannersBean.getTagKey();
                    if (arrayList2.contains(tagKey)) {
                        List<ResourceVo> list2 = map.get(tagKey);
                        if (list2 != null) {
                            list2.add(bannersBean.getResource());
                        }
                    } else {
                        arrayList2.add(tagKey);
                        arrayList.add(bannersBean);
                        ArrayList arrayList3 = new ArrayList();
                        arrayList3.add(bannersBean.getResource());
                        map.put(tagKey, arrayList3);
                    }
                }
            }
        }
        bannerDataVo.setTagResourceMap(map);
        bannerDataVo.setTags(arrayList);
        return bannerDataVo;
    }

    public final List<c.k.b.a> c(List<ResourceVo> list) {
        return n.getImageInfo(list);
    }

    public final CoreRoundedImageView d(Context context, LinearLayout.LayoutParams layoutParams) {
        CoreRoundedImageView coreRoundedImageView = new CoreRoundedImageView(context);
        coreRoundedImageView.setLayoutParams(layoutParams);
        coreRoundedImageView.setPicWidth(1080);
        coreRoundedImageView.setPicHeight(OS2WindowsMetricsTable.WEIGHT_CLASS_EXTRA_BOLD);
        coreRoundedImageView.setId(R.id.id_room_banner_img);
        coreRoundedImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return coreRoundedImageView;
    }

    public final TextView e(ViewGroup.LayoutParams layoutParams) {
        TextView textView = new TextView(this.f1529f);
        textView.setLayoutParams(layoutParams);
        textView.setGravity(17);
        textView.setTextSize(12.0f);
        textView.setTextColor(this.f1529f.getResources().getColor(R.color.color_white));
        textView.setId(R.id.id_room_details_banner_indicator_tv);
        return textView;
    }

    public final void f() {
        if (this.f1526c == null) {
            this.f1526c = new HashMap();
        }
        if (this.f1525b == null) {
            this.f1525b = new ArrayList();
        }
        if (this.f1527d == null) {
            this.f1527d = new HashMap();
        }
        this.f1526c.clear();
        this.f1525b.clear();
    }

    public final void g(TextView textView, boolean z) {
        if (z) {
            textView.setBackgroundResource(R.drawable.bg_room_details_indicator_text_normal);
        } else {
            textView.setBackground(null);
        }
    }

    public List<CoreRoundedImageView> getBannerList(List<ProductDetailsVo.BannersBean> list, LinearLayout linearLayout, View.OnClickListener onClickListener) {
        LinearLayout.LayoutParams layoutParams;
        int i2;
        Map<String, List<ResourceVo>> map;
        List<ProductDetailsVo.BannersBean> list2;
        f();
        ArrayList arrayList = new ArrayList();
        if (o.isNotEmpty(list)) {
            linearLayout.setVisibility(0);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, linearLayout.getResources().getDimensionPixelSize(R.dimen.dp_24));
            layoutParams3.rightMargin = this.f1529f.getResources().getDimensionPixelSize(R.dimen.dp_2);
            int dimensionPixelSize = this.f1529f.getResources().getDimensionPixelSize(R.dimen.dp_10);
            int dimensionPixelSize2 = this.f1529f.getResources().getDimensionPixelSize(R.dimen.dp_15);
            BannerDataVo bannerDataVoB = b(list);
            List<ProductDetailsVo.BannersBean> tags = bannerDataVoB.getTags();
            Map<String, List<ResourceVo>> tagResourceMap = bannerDataVoB.getTagResourceMap();
            int size = tags.size();
            int i3 = 0;
            int i4 = 0;
            while (i3 < size) {
                ProductDetailsVo.BannersBean bannersBean = tags.get(i3);
                List<ResourceVo> list3 = tagResourceMap.get(bannersBean.getTagKey());
                if (list3 != null) {
                    int size2 = list3.size();
                    map = tagResourceMap;
                    list2 = tags;
                    int i5 = 0;
                    while (true) {
                        String url = "";
                        if (i5 >= size2) {
                            break;
                        }
                        a(i3, i4);
                        int i6 = size2;
                        ResourceVo resourceVo = list3.get(i5);
                        if (resourceVo != null) {
                            this.f1528e.add(resourceVo);
                            url = resourceVo.getUrl();
                        }
                        CoreRoundedImageView coreRoundedImageViewD = d(this.f1529f, layoutParams2);
                        LinearLayout.LayoutParams layoutParams4 = layoutParams2;
                        float f2 = dimensionPixelSize2;
                        coreRoundedImageViewD.setCornerRadius(0.0f, 0.0f, f2, f2);
                        coreRoundedImageViewD.loadAliImageToUrl(url);
                        coreRoundedImageViewD.setOnClickListener(onClickListener);
                        coreRoundedImageViewD.setTag(R.id.edt_banner_view_img_path_id, url);
                        arrayList.add(coreRoundedImageViewD);
                        this.f1526c.put(Integer.valueOf(i4), Integer.valueOf(i3));
                        i4++;
                        i5++;
                        layoutParams2 = layoutParams4;
                        size2 = i6;
                        dimensionPixelSize2 = dimensionPixelSize2;
                    }
                    layoutParams = layoutParams2;
                    i2 = dimensionPixelSize2;
                    TextView textViewE = e(layoutParams3);
                    textViewE.setTag(Integer.valueOf(i3));
                    textViewE.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
                    textViewE.setText(x.getNotNullStr(bannersBean.getTagName(), ""));
                    textViewE.setOnClickListener(onClickListener);
                    this.f1525b.add(textViewE);
                    g(textViewE, i3 == 0);
                    linearLayout.addView(textViewE);
                } else {
                    layoutParams = layoutParams2;
                    i2 = dimensionPixelSize2;
                    map = tagResourceMap;
                    list2 = tags;
                }
                i3++;
                tagResourceMap = map;
                tags = list2;
                layoutParams2 = layoutParams;
                dimensionPixelSize2 = i2;
            }
        } else {
            linearLayout.setVisibility(8);
        }
        return arrayList;
    }

    public Integer getIndexToViewTag(View view) {
        int iIntValue = ((Integer) view.getTag()).intValue();
        this.f1524a = iIntValue;
        return this.f1527d.get(Integer.valueOf(iIntValue));
    }

    public List<ProductDetailsVo.BannersBean> loadBannerPic(String str) {
        List<RoomBannerBo> roomBannerVos = c.e.a.a.i.b.getInstance().getRoomBannerVos(c.e.a.a.i.b.getRoomTagPathToGroupName(str));
        ArrayList arrayList = new ArrayList();
        if (!o.isNotEmpty(roomBannerVos)) {
            return null;
        }
        for (RoomBannerBo roomBannerBo : roomBannerVos) {
            if (roomBannerBo != null) {
                String folderName = roomBannerBo.getFolderName();
                List<ResourceVo> resourceVos = roomBannerBo.getResourceVos();
                if (o.isNotEmpty(resourceVos)) {
                    q.d(a.class.getSimpleName(), "loadBannerPic tagName = " + folderName + ",resourceVoList=" + resourceVos.size());
                    for (ResourceVo resourceVo : resourceVos) {
                        ProductDetailsVo.BannersBean bannersBean = new ProductDetailsVo.BannersBean();
                        bannersBean.setTagKey(folderName);
                        bannersBean.setTagName(folderName);
                        bannersBean.setResource(resourceVo);
                        arrayList.add(bannersBean);
                    }
                }
            }
        }
        return arrayList;
    }

    public List<ProductDetailsVo.BannersBean> loadNewBannerPic(List<ProductDetailsVo.TagsBean> list) {
        ArrayList arrayList = new ArrayList();
        if (o.isNotEmpty(list)) {
            for (ProductDetailsVo.TagsBean tagsBean : list) {
                if (tagsBean.getImagesList() != null) {
                    for (String str : tagsBean.getImagesList()) {
                        if (x.isNotNull(str)) {
                            ProductDetailsVo.BannersBean bannersBean = new ProductDetailsVo.BannersBean();
                            bannersBean.setTagKey(tagsBean.getTagKey());
                            bannersBean.setTagName(tagsBean.getTagName());
                            ResourceVo resourceVo = new ResourceVo();
                            resourceVo.setUrl(str);
                            bannersBean.setResource(resourceVo);
                            arrayList.add(bannersBean);
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    public void openRoomDetailsPhoto() {
        Intent intent = new Intent(this.f1529f, (Class<?>) ImagePreviewActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("IMAGE_INFO", (Serializable) c(this.f1528e));
        bundle.putInt("CURRENT_ITEM", this.f1524a);
        intent.putExtras(bundle);
        this.f1529f.startActivity(intent);
    }

    public void recyclerReference() {
        this.f1529f = null;
        List<ResourceVo> list = this.f1528e;
        if (list != null) {
            list.clear();
        }
        this.f1528e = null;
        Map<Integer, Integer> map = this.f1527d;
        if (map != null) {
            map.clear();
        }
        this.f1527d = null;
        List<TextView> list2 = this.f1525b;
        if (list2 != null) {
            list2.clear();
        }
        this.f1525b = null;
        Map<Integer, Integer> map2 = this.f1526c;
        if (map2 != null) {
            map2.clear();
        }
        this.f1526c = null;
    }

    public void updatePageIndicator(int i2) {
        Map<Integer, Integer> map = this.f1526c;
        if (map == null || !map.containsKey(Integer.valueOf(i2))) {
            return;
        }
        Integer num = this.f1526c.get(Integer.valueOf(i2));
        if (num != null) {
            this.f1524a = num.intValue();
        }
        Iterator<TextView> it = this.f1525b.iterator();
        while (it.hasNext()) {
            g(it.next(), false);
        }
        g(this.f1525b.get(this.f1524a), true);
    }
}
