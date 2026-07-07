package com.chinavisionary.microtang.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.e.a.d.q;
import c.e.a.d.x;
import com.chinavisionary.core.weight.CoreRoundedImageView;
import com.chinavisionary.framework.mobile.common.vo.ResourceVo;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.main.vo.ModelProductVo;
import com.chinavisionary.microtang.main.vo.RoomModelVo;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class HorMainRoomView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LayoutInflater f8666a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View.OnClickListener f8667b;

    public HorMainRoomView(Context context) {
        super(context);
        b();
    }

    public final View a(RoomModelVo.ModulesBean modulesBean) {
        ModelProductVo modelProductVo;
        if (modulesBean == null || this.f8666a == null || (modelProductVo = modulesBean.getModelProductVo()) == null || modelProductVo.getParam() == null) {
            return null;
        }
        View viewInflate = this.f8666a.inflate(R.layout.item_hor_main_room_sub_layout, (ViewGroup) this, false);
        c(viewInflate, modulesBean);
        return viewInflate;
    }

    public void addData(List<RoomModelVo.ModulesBean> list, int i2) {
        if (list == null || list.isEmpty()) {
            return;
        }
        int size = list.size();
        int childCount = getChildCount();
        q.d(getClass().getSimpleName(), "childCount:" + childCount + ", size:" + size);
        int i3 = 0;
        if (childCount == size) {
            while (i3 < childCount) {
                RoomModelVo.ModulesBean modulesBean = list.get(i3);
                View childAt = getChildAt(i3);
                c(childAt, modulesBean);
                childAt.setTag(Integer.valueOf(i2));
                childAt.setTag(childAt.getId(), Integer.valueOf(i3));
                View.OnClickListener onClickListener = this.f8667b;
                if (onClickListener != null) {
                    childAt.setOnClickListener(onClickListener);
                }
                i3++;
            }
            return;
        }
        removeAllViews();
        while (i3 < size) {
            View viewA = a(list.get(i3));
            if (viewA != null) {
                addView(viewA);
                viewA.setTag(Integer.valueOf(i2));
                viewA.setTag(viewA.getId(), Integer.valueOf(i3));
                View.OnClickListener onClickListener2 = this.f8667b;
                if (onClickListener2 != null) {
                    viewA.setOnClickListener(onClickListener2);
                }
            }
            i3++;
        }
    }

    public final void b() {
        this.f8666a = LayoutInflater.from(getContext());
        setOrientation(0);
    }

    public final void c(View view, RoomModelVo.ModulesBean modulesBean) {
        ResourceVo resourceVo;
        ModelProductVo modelProductVo = modulesBean.getModelProductVo();
        if (modelProductVo == null || modelProductVo.getParam() == null) {
            return;
        }
        CoreRoundedImageView coreRoundedImageView = (CoreRoundedImageView) view.findViewById(R.id.img_cover);
        TextView textView = (TextView) view.findViewById(R.id.tv_title);
        TextView textView2 = (TextView) view.findViewById(R.id.tv_subtitle);
        TextView textView3 = (TextView) view.findViewById(R.id.tv_other_content);
        ModelProductVo.ParamBean param = modelProductVo.getParam();
        textView.setVisibility(x.isNotNull(param.getCommodityTitle()) ? 0 : 8);
        textView.setText(x.getNotNullStr(param.getCommodityTitle(), ""));
        textView2.setVisibility(x.isNotNull(param.getCommoditySubtitle()) ? 0 : 8);
        textView2.setText(x.getNotNullStr(param.getCommoditySubtitle(), ""));
        textView3.setVisibility(x.isNotNull(param.getMinimumMonthlyRent()) ? 0 : 8);
        textView3.setText(x.getNotNullStr(param.getMinimumMonthlyRent(), ""));
        List<ResourceVo> resourceVos = param.getResourceVos();
        if (resourceVos == null || resourceVos.isEmpty() || (resourceVo = resourceVos.get(0)) == null) {
            return;
        }
        coreRoundedImageView.loadAliImageToUrl(resourceVo.getUrl());
    }

    public void setupOnClickListener(View.OnClickListener onClickListener) {
        this.f8667b = onClickListener;
    }

    public HorMainRoomView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b();
    }

    public HorMainRoomView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        b();
    }
}
