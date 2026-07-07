package com.chinavisionary.microtang.merchant.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import c.e.a.d.o;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.merchant.vo.SpecificationTagsVo;
import com.chinavisionary.microtang.view.CustomTextView;
import com.nex3z.flowlayout.FlowLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class CommoditySpecLayout extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f7933a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f7934b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f7935c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f7936d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public LayoutInflater f7937e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public LinearLayout.LayoutParams f7938f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Map<Integer, List<CustomTextView>> f7939g;

    public CommoditySpecLayout(Context context) {
        super(context);
        this.f7939g = new HashMap();
        setOrientation(1);
        this.f7937e = LayoutInflater.from(getContext());
        this.f7933a = getResources().getColor(R.color.tab_item_select_color);
        this.f7934b = getResources().getColor(R.color.colore757575);
        this.f7936d = R.drawable.bg_food_spec_tag;
        this.f7935c = R.drawable.bg_food_spec_tag_sel;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, getResources().getDimensionPixelSize(R.dimen.dp_30));
        this.f7938f = layoutParams;
        layoutParams.rightMargin = getResources().getDimensionPixelSize(R.dimen.dp_8);
    }

    public final CustomTextView a(SpecificationTagsVo specificationTagsVo, boolean z, int i2, int i3) {
        CustomTextView customTextView = new CustomTextView(getContext());
        customTextView.setId(R.id.id_spec_tag);
        customTextView.setGravity(17);
        customTextView.setLayoutParams(this.f7938f);
        customTextView.setBackgroundResource(z ? this.f7935c : this.f7936d);
        customTextView.setTextColor(z ? this.f7933a : this.f7934b);
        customTextView.setText(specificationTagsVo.getSpecificationTagName());
        customTextView.setTag(specificationTagsVo.getSpecificationTagKey());
        customTextView.setTag(R.id.id_spec_tag, Integer.valueOf(i2));
        customTextView.setTag(R.id.id_spec_column_tag, Integer.valueOf(i3));
        customTextView.setTextSize(12.0f);
        return customTextView;
    }

    public List<String> getSelectTagKeys() {
        ArrayList arrayList = new ArrayList();
        Iterator<Map.Entry<Integer, List<CustomTextView>>> it = this.f7939g.entrySet().iterator();
        while (it.hasNext()) {
            for (CustomTextView customTextView : it.next().getValue()) {
                Object tag = customTextView.getTag(R.id.id_spec_tag_select);
                if (tag != null && ((Boolean) tag).booleanValue()) {
                    arrayList.add((String) customTextView.getTag());
                }
            }
        }
        return arrayList;
    }

    public void setSpecificationTags(List<SpecificationTagsVo> list, List<String> list2, View.OnClickListener onClickListener) {
        removeAllViews();
        this.f7939g.clear();
        if (o.isNotEmpty(list)) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                SpecificationTagsVo specificationTagsVo = list.get(i2);
                if (specificationTagsVo != null) {
                    ArrayList arrayList = new ArrayList();
                    View viewInflate = this.f7937e.inflate(R.layout.item_commodity_spec_layout, (ViewGroup) this, false);
                    CustomTextView customTextView = (CustomTextView) viewInflate.findViewById(R.id.tv_spec_title);
                    FlowLayout flowLayout = (FlowLayout) viewInflate.findViewById(R.id.flow_layout_product_spec);
                    customTextView.setText(specificationTagsVo.getSpecificationTagName());
                    List<SpecificationTagsVo> subSpecificationTags = specificationTagsVo.getSubSpecificationTags();
                    if (o.isNotEmpty(subSpecificationTags)) {
                        int size2 = subSpecificationTags.size();
                        for (int i3 = 0; i3 < size2; i3++) {
                            SpecificationTagsVo specificationTagsVo2 = subSpecificationTags.get(i3);
                            if (specificationTagsVo2 != null) {
                                boolean zContains = list2.contains(specificationTagsVo2.getSpecificationTagKey());
                                CustomTextView customTextViewA = a(specificationTagsVo2, zContains, i2, i3);
                                customTextViewA.setTag(R.id.id_spec_tag_select, Boolean.valueOf(zContains));
                                customTextViewA.setOnClickListener(onClickListener);
                                flowLayout.addView(customTextViewA);
                                arrayList.add(customTextViewA);
                            }
                        }
                    }
                    addView(viewInflate);
                    this.f7939g.put(Integer.valueOf(i2), arrayList);
                }
            }
        }
    }

    public void updateSpecTagSelState(int i2, int i3) {
        for (Map.Entry<Integer, List<CustomTextView>> entry : this.f7939g.entrySet()) {
            if (entry.getKey().intValue() == i2) {
                List<CustomTextView> value = entry.getValue();
                int size = value.size();
                int i4 = 0;
                while (i4 < size) {
                    CustomTextView customTextView = value.get(i4);
                    boolean z = i4 == i3;
                    customTextView.setTag(R.id.id_spec_tag_select, Boolean.valueOf(z));
                    customTextView.setBackgroundResource(z ? this.f7935c : this.f7936d);
                    customTextView.setTextColor(z ? this.f7933a : this.f7934b);
                    i4++;
                }
            }
        }
    }

    public CommoditySpecLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7939g = new HashMap();
        setOrientation(1);
        this.f7937e = LayoutInflater.from(getContext());
        this.f7933a = getResources().getColor(R.color.tab_item_select_color);
        this.f7934b = getResources().getColor(R.color.colore757575);
        this.f7936d = R.drawable.bg_food_spec_tag;
        this.f7935c = R.drawable.bg_food_spec_tag_sel;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, getResources().getDimensionPixelSize(R.dimen.dp_30));
        this.f7938f = layoutParams;
        layoutParams.rightMargin = getResources().getDimensionPixelSize(R.dimen.dp_8);
    }

    public CommoditySpecLayout(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f7939g = new HashMap();
        setOrientation(1);
        this.f7937e = LayoutInflater.from(getContext());
        this.f7933a = getResources().getColor(R.color.tab_item_select_color);
        this.f7934b = getResources().getColor(R.color.colore757575);
        this.f7936d = R.drawable.bg_food_spec_tag;
        this.f7935c = R.drawable.bg_food_spec_tag_sel;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, getResources().getDimensionPixelSize(R.dimen.dp_30));
        this.f7938f = layoutParams;
        layoutParams.rightMargin = getResources().getDimensionPixelSize(R.dimen.dp_8);
    }
}
