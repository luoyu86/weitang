package com.chinavisionary.core.weight.banner;

import android.app.Activity;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import c.e.a.a.e.q;
import c.e.a.d.a0;
import c.e.a.d.v;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.chinavisionary.core.R;
import com.chinavisionary.core.app.net.base.dto.BaseVo;
import com.chinavisionary.core.weight.CoreRoundedImageView;
import com.chinavisionary.framework.mobile.common.vo.ResourceVo;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class EditBannerView extends FrameLayout {
    public final View.OnClickListener A;
    public final View.OnClickListener B;
    public final ViewPager.OnPageChangeListener C;
    public final DataSetObserver D;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f6751a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Activity f6752b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Fragment f6753c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public f f6754d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f6755e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Button f6756f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Button f6757g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ViewPager f6758h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public View.OnClickListener f6759i;
    public EditBannerViewPagerAdapter j;
    public List<CheckBox> k;
    public LinearLayout l;
    public LinearLayout.LayoutParams m;
    public LinearLayout.LayoutParams n;
    public int o;
    public boolean p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f6760q;
    public boolean r;
    public boolean s;
    public int t;
    public int u;
    public ViewGroup.LayoutParams v;
    public int w;
    public int x;
    public int y;
    public int z;

    public static class BannerDto extends BaseVo {
        private String bannerKey;
        private ResourceVo cover;
        private String dataKey;
        private String dataParam;
        private int dataType;
        private int forwardType;
        private String href;
        private String key;
        private boolean picFitXy = true;
        private String targetAppid;
        private String targetMiniType;
        private String targetPath;
        private String title;

        public String getBannerKey() {
            return this.bannerKey;
        }

        public ResourceVo getCover() {
            return this.cover;
        }

        public String getDataKey() {
            String str = this.dataKey;
            return str == null ? this.href : str;
        }

        public String getDataParam() {
            return this.dataParam;
        }

        public int getDataType() {
            return Math.max(this.dataType, this.forwardType);
        }

        public int getForwardType() {
            return this.forwardType;
        }

        public String getHref() {
            return this.href;
        }

        public String getKey() {
            String str = this.key;
            return str == null ? this.href : str;
        }

        public String getTargetAppid() {
            return this.targetAppid;
        }

        public String getTargetMiniType() {
            return this.targetMiniType;
        }

        public String getTargetPath() {
            return this.targetPath;
        }

        public String getTitle() {
            return this.title;
        }

        public boolean isPicFitXy() {
            return this.picFitXy;
        }

        public void setBannerKey(String str) {
            this.bannerKey = str;
        }

        public void setCover(ResourceVo resourceVo) {
            this.cover = resourceVo;
        }

        public void setDataKey(String str) {
            this.dataKey = str;
        }

        public void setDataParam(String str) {
            this.dataParam = str;
        }

        public void setDataType(int i2) {
            this.dataType = i2;
        }

        public void setForwardType(int i2) {
            this.forwardType = i2;
        }

        public void setHref(String str) {
            this.href = str;
        }

        public void setKey(String str) {
            this.key = str;
        }

        public void setPicFitXy(boolean z) {
            this.picFitXy = z;
        }

        public void setTargetAppid(String str) {
            this.targetAppid = str;
        }

        public void setTargetMiniType(String str) {
            this.targetMiniType = str;
        }

        public void setTargetPath(String str) {
            this.targetPath = str;
        }

        public void setTitle(String str) {
            this.title = str;
        }
    }

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (v.getInstance().isRepeatedlyAction(view.getId())) {
                return;
            }
            EditBannerView.this.f6755e = view.getId();
            if (EditBannerView.this.f6755e == R.id.banner_del_btn && EditBannerView.this.j.getList().size() <= 1) {
                a0.showToast(EditBannerView.this.getContext(), R.string.edit_banner_is_not_del);
            } else {
                EditBannerView editBannerView = EditBannerView.this;
                editBannerView.u(editBannerView.f6755e == R.id.banner_add_btn ? R.string.edit_banner_add_title : R.string.edit_banner_del_title);
            }
        }
    }

    public class b implements q.c {
        public b() {
        }

        @Override // c.e.a.a.e.q.c
        public void onClickButtonLeft() {
            EditBannerView.this.q(false);
        }

        @Override // c.e.a.a.e.q.c
        public void onClickButtonRight() {
            EditBannerView.this.q(true);
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean zIsRepeatedlyAction = v.getInstance().isRepeatedlyAction(view.getId());
            String simpleName = c.class.getSimpleName();
            StringBuilder sb = new StringBuilder();
            sb.append("isRepeatedly:");
            sb.append(zIsRepeatedlyAction);
            sb.append(",isEdit:");
            sb.append(EditBannerView.this.s);
            sb.append(",mItemClickListener:");
            sb.append(EditBannerView.this.f6759i != null);
            c.e.a.d.q.d(simpleName, sb.toString());
            if (zIsRepeatedlyAction) {
                return;
            }
            if (EditBannerView.this.s) {
                EditBannerView.this.t();
            } else if (EditBannerView.this.f6759i != null) {
                EditBannerView.this.f6759i.onClick(view);
            }
        }
    }

    public class d implements ViewPager.OnPageChangeListener {
        public d() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i2, float f2, int i3) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            EditBannerView.this.f6760q = i2;
            EditBannerView.this.y(i2);
        }
    }

    public class e extends DataSetObserver {
        public e() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            super.onChanged();
            EditBannerView.this.x();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            super.onInvalidated();
        }
    }

    public static class f extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public WeakReference<EditBannerView> f6766a;

        public f(EditBannerView editBannerView) {
            this.f6766a = new WeakReference<>(editBannerView);
        }

        public void a() {
            removeCallbacksAndMessages(null);
            WeakReference<EditBannerView> weakReference = this.f6766a;
            if (weakReference != null) {
                weakReference.clear();
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            WeakReference<EditBannerView> weakReference = this.f6766a;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            this.f6766a.get().r(message);
        }
    }

    public EditBannerView(Context context) {
        super(context);
        this.f6751a = 5000;
        this.r = true;
        this.x = 1000;
        this.A = new a();
        this.B = new c();
        this.C = new d();
        this.D = new e();
        this.u = getResources().getColor(R.color.edit_banner_indicator_normal_color);
        this.t = getResources().getColor(R.color.edit_banner_indicator_select_color);
        s();
    }

    private StateListDrawable getIndicatorStateListDrawable() {
        CornerPathEffect cornerPathEffect = new CornerPathEffect(this.o);
        ShapeDrawable shapeDrawable = new ShapeDrawable();
        shapeDrawable.setShape(new RectShape());
        shapeDrawable.getPaint().setPathEffect(cornerPathEffect);
        shapeDrawable.getPaint().setColor(this.t);
        shapeDrawable.getPaint().setStyle(Paint.Style.FILL);
        ShapeDrawable shapeDrawable2 = new ShapeDrawable();
        shapeDrawable2.setShape(new RectShape());
        shapeDrawable2.getPaint().setPathEffect(cornerPathEffect);
        shapeDrawable2.getPaint().setColor(this.u);
        shapeDrawable2.getPaint().setStyle(Paint.Style.FILL);
        int[] iArr = {android.R.attr.state_checked};
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(iArr, shapeDrawable);
        stateListDrawable.addState(new int[]{-16842912}, shapeDrawable2);
        return stateListDrawable;
    }

    private void setIsPlay(boolean z) {
        this.f6754d.removeCallbacksAndMessages(null);
        if (!z || this.k.isEmpty()) {
            return;
        }
        this.f6754d.sendEmptyMessageDelayed(1, this.f6751a);
    }

    private void setViewPagerAdapter(EditBannerViewPagerAdapter editBannerViewPagerAdapter) {
        if (editBannerViewPagerAdapter == null) {
            editBannerViewPagerAdapter = new EditBannerViewPagerAdapter();
        }
        EditBannerViewPagerAdapter editBannerViewPagerAdapter2 = this.j;
        if (editBannerViewPagerAdapter2 != null) {
            editBannerViewPagerAdapter2.unregisterDataSetObserver(this.D);
        }
        this.j = editBannerViewPagerAdapter;
        this.f6758h.setAdapter(editBannerViewPagerAdapter);
        this.j.registerDataSetObserver(this.D);
    }

    public void addViewToAdapter(View view) {
        if (view != null) {
            if (getVisibility() != 0) {
                setVisibility(0);
            }
            this.f6760q = 0;
            this.j.addView(view);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            setIsPlay(false);
        } else if (action == 1) {
            setIsPlay(true);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void handlerPhotoSelectResult(Intent intent) {
        if (intent != null) {
            p(intent);
        }
    }

    public void handlerRequestPermissionSuccess() {
        t();
    }

    public final void l() {
        int count;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        CoreRoundedImageView coreRoundedImageView = new CoreRoundedImageView(getContext());
        coreRoundedImageView.setId(R.id.img_banner_pic);
        coreRoundedImageView.setLayoutParams(layoutParams);
        coreRoundedImageView.setImageResource(R.drawable.ic_place_holder);
        coreRoundedImageView.setOnClickListener(this.B);
        if (this.f6760q != this.j.getCount() - 1) {
            count = this.f6760q + 1;
            coreRoundedImageView.setTag(R.id.edt_banner_view_img_path_position, Integer.valueOf(count));
            this.j.getList().add(count, coreRoundedImageView);
        } else {
            count = this.j.getCount();
            coreRoundedImageView.setTag(R.id.edt_banner_view_img_path_position, Integer.valueOf(count));
            this.j.getList().add(coreRoundedImageView);
        }
        this.j.notifyDataSetChanged();
        x();
        this.f6758h.setCurrentItem(count, true);
    }

    public final String[] m(String[] strArr) {
        int length = strArr.length;
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            Context activity = this.f6752b;
            if (activity == null) {
                activity = this.f6753c.getActivity();
            }
            boolean z = ContextCompat.checkSelfPermission(activity, str) != 0;
            c.e.a.d.q.d("checkSelfPermission isGranted:" + z);
            if (z) {
                arrayList.add(str);
            }
        }
        if (!arrayList.isEmpty()) {
            return (String[]) arrayList.toArray(new String[arrayList.size()]);
        }
        c.e.a.d.q.d("checkSelfPermission isEmpty");
        return null;
    }

    public final void n() {
        this.j.getList().remove(this.f6760q);
        this.j.notifyDataSetChanged();
        int i2 = this.f6760q;
        if (i2 > 0) {
            this.f6760q = i2 - 1;
        }
        x();
        this.f6758h.setCurrentItem(this.f6760q, true);
    }

    public final String o(Uri uri, String str) {
        Activity activity = this.f6752b;
        if (activity == null) {
            activity = this.f6753c.getActivity();
        }
        Cursor cursorQuery = activity.getApplication().getContentResolver().query(uri, null, str, null, null);
        if (cursorQuery != null) {
            string = cursorQuery.moveToFirst() ? cursorQuery.getString(cursorQuery.getColumnIndex("_data")) : null;
            cursorQuery.close();
        }
        return string;
    }

    public final void p(Intent intent) {
        String strO;
        Uri data = intent.getData();
        Context activity = this.f6752b;
        if (activity == null) {
            activity = this.f6753c.getActivity();
        }
        String path = null;
        if (DocumentsContract.isDocumentUri(activity, data)) {
            String documentId = DocumentsContract.getDocumentId(data);
            if ("com.android.providers.media.documents".equals(data.getAuthority())) {
                strO = o(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "_id=" + documentId.split(":")[1]);
            } else if ("com.android.providers.downloads.documents".equals(data.getAuthority())) {
                strO = o(ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(documentId).longValue()), null);
            }
            path = strO;
        } else if ("content".equalsIgnoreCase(data.getScheme())) {
            path = o(data, null);
        } else if ("file".equalsIgnoreCase(data.getScheme())) {
            path = data.getPath();
        }
        w(path);
    }

    public final void q(boolean z) {
        if (!z) {
            setIsPlay(true);
            return;
        }
        int i2 = this.f6755e;
        if (i2 == R.id.banner_add_btn) {
            l();
        } else if (i2 == R.id.banner_del_btn) {
            n();
        }
    }

    public void r(Message message) {
        this.f6754d.removeCallbacksAndMessages(null);
        this.f6754d.sendEmptyMessageDelayed(1, this.f6751a);
        int i2 = this.f6760q + 1;
        this.f6760q = i2;
        if (i2 >= this.k.size()) {
            this.f6760q = 0;
        }
        this.f6758h.setCurrentItem(this.f6760q, true);
    }

    public void recycler() {
        EditBannerViewPagerAdapter editBannerViewPagerAdapter = this.j;
        if (editBannerViewPagerAdapter != null) {
            editBannerViewPagerAdapter.unregisterDataSetObserver(this.D);
        }
        f fVar = this.f6754d;
        if (fVar != null) {
            fVar.a();
            this.f6754d = null;
        }
        this.f6752b = null;
        this.f6753c = null;
    }

    public final void s() {
        this.w = getResources().getDimensionPixelSize(R.dimen.dp_120);
        this.y = getResources().getDimensionPixelSize(R.dimen.dp_6);
        this.f6754d = new f(this);
        this.k = new ArrayList();
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.edt_banner_view_indicator_width);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.edt_banner_view_indicator_select_width);
        int dimensionPixelSize3 = getResources().getDimensionPixelSize(R.dimen.edt_banner_view_indicator_margin_right);
        this.o = getResources().getDimensionPixelSize(R.dimen.dp_2);
        int dimensionPixelSize4 = getResources().getDimensionPixelSize(R.dimen.edt_banner_view_indicator_width_height);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize2, dimensionPixelSize4);
        this.n = layoutParams;
        layoutParams.rightMargin = dimensionPixelSize3;
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize4);
        this.m = layoutParams2;
        layoutParams2.rightMargin = dimensionPixelSize3;
        this.v = new ViewGroup.LayoutParams(-1, -1);
        View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.edit_banner_layout, (ViewGroup) this, false);
        addView(viewInflate);
        this.f6758h = (ViewPager) viewInflate.findViewById(R.id.banner_view_pager);
        this.f6756f = (Button) viewInflate.findViewById(R.id.banner_add_btn);
        this.f6757g = (Button) viewInflate.findViewById(R.id.banner_del_btn);
        this.f6756f.setOnClickListener(this.A);
        this.f6757g.setOnClickListener(this.A);
        this.l = (LinearLayout) viewInflate.findViewById(R.id.llayout_indicator);
        this.f6758h.addOnPageChangeListener(this.C);
    }

    public void setActivity(Activity activity) {
        setPagerAdapter((EditBannerViewPagerAdapter) null, activity);
    }

    public void setAdapter(EditBannerViewPagerAdapter editBannerViewPagerAdapter) {
        this.j = editBannerViewPagerAdapter;
        editBannerViewPagerAdapter.notifyDataSetChanged();
    }

    public void setAdapterListData(List<BannerDto> list) {
        this.j.clearList();
        if (list == null || list.isEmpty()) {
            if (getVisibility() != 8) {
                setVisibility(8);
                return;
            }
            return;
        }
        int i2 = 0;
        if (getVisibility() != 0) {
            setVisibility(0);
        }
        this.f6760q = 0;
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        if (this.r) {
            this.l.setVisibility(size > 1 ? 0 : 8);
        }
        for (BannerDto bannerDto : list) {
            CoreRoundedImageView coreRoundedImageView = new CoreRoundedImageView(getContext());
            coreRoundedImageView.setLayoutParams(this.v);
            coreRoundedImageView.setId(R.id.img_banner_pic);
            coreRoundedImageView.setCornerRadius(this.y);
            int i3 = this.z;
            if (i3 > 0) {
                coreRoundedImageView.setCornerRadius(0.0f, 0.0f, i3, 0.0f);
            }
            if (bannerDto.picFitXy) {
                coreRoundedImageView.setScaleType(ImageView.ScaleType.FIT_XY);
            } else {
                coreRoundedImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            }
            coreRoundedImageView.setPicWidth(this.x);
            coreRoundedImageView.setPicHeight(this.w);
            coreRoundedImageView.setTag(R.id.edt_banner_view_img_path_position, Integer.valueOf(i2));
            coreRoundedImageView.setTag(R.id.edt_banner_view_img_path_id, bannerDto);
            ResourceVo cover = bannerDto.getCover();
            if (cover != null) {
                coreRoundedImageView.loadImageToResourceVo(cover, true);
            }
            coreRoundedImageView.setOnClickListener(this.B);
            arrayList.add(coreRoundedImageView);
            i2++;
        }
        this.j.setViews(arrayList);
    }

    public void setFragment(Fragment fragment) {
        setPagerAdapter((EditBannerViewPagerAdapter) null, fragment);
    }

    public void setImageCornerBottomLeftRadius(int i2) {
        this.z = i2;
    }

    public void setImageCornerRadius(int i2) {
        this.y = i2;
    }

    public void setIsEdit(boolean z) {
        this.s = z;
        this.f6756f.setVisibility(z ? 0 : 8);
        this.f6757g.setVisibility(z ? 0 : 8);
    }

    public void setIsShowIndicator(boolean z) {
        this.r = z;
        if (z) {
            return;
        }
        ((ConstraintLayout.LayoutParams) this.f6758h.getLayoutParams()).bottomToBottom = 0;
        this.l.setVisibility(8);
    }

    public void setItemClickListener(View.OnClickListener onClickListener) {
        this.f6759i = onClickListener;
    }

    public void setPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.f6758h.addOnPageChangeListener(onPageChangeListener);
    }

    public void setPagerAdapter(EditBannerViewPagerAdapter editBannerViewPagerAdapter, Activity activity) {
        this.f6752b = activity;
        setViewPagerAdapter(editBannerViewPagerAdapter);
    }

    public void setPlay(boolean z) {
        this.p = z;
        setIsPlay(z);
    }

    public final void t() {
        if (this.f6752b == null && this.f6753c == null) {
            a0.showToast(getContext(), R.string.edit_banner_tip_activity_is_empty);
            return;
        }
        if (Build.VERSION.SDK_INT < 23) {
            v();
            return;
        }
        String[] strArrM = m(new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"});
        if (strArrM == null || strArrM.length <= 0) {
            v();
            return;
        }
        Fragment fragment = this.f6753c;
        if (fragment != null) {
            fragment.requestPermissions(strArrM, TTAdConstant.STYLE_SIZE_RADIO_9_16);
        } else {
            ActivityCompat.requestPermissions(this.f6752b, strArrM, 1);
        }
    }

    public final void u(int i2) {
        setIsPlay(false);
        q qVar = new q(getContext());
        qVar.setContent(i2);
        qVar.setOnClickButtonListener(new b());
        qVar.show();
    }

    public final void v() {
        c.e.a.d.q.d("openPickPhoto");
        Intent intent = new Intent("android.intent.action.PICK");
        intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
        Activity activity = this.f6752b;
        if (activity == null) {
            this.f6753c.startActivityForResult(intent, TTAdConstant.STYLE_SIZE_RADIO_9_16);
        } else {
            activity.startActivityForResult(intent, TTAdConstant.STYLE_SIZE_RADIO_9_16);
        }
    }

    public final void w(String str) {
        CoreRoundedImageView coreRoundedImageView = (CoreRoundedImageView) this.j.getList().get(this.f6760q);
        coreRoundedImageView.setTag(R.id.edt_banner_view_img_path_id, str);
        coreRoundedImageView.loadImageToFile(new File(str));
    }

    public final void x() {
        this.l.removeAllViews();
        this.k.clear();
        int size = this.j.getList().size();
        int i2 = 0;
        while (true) {
            boolean z = true;
            if (i2 >= size) {
                setIsPlay(true);
                return;
            }
            CheckBox checkBox = new CheckBox(getContext());
            checkBox.setLayoutParams(i2 == this.f6760q ? this.n : this.m);
            if (i2 != this.f6760q) {
                z = false;
            }
            checkBox.setChecked(z);
            checkBox.setEnabled(false);
            checkBox.setButtonDrawable(new ColorDrawable(0));
            checkBox.setBackground(getIndicatorStateListDrawable());
            this.l.addView(checkBox);
            this.k.add(checkBox);
            i2++;
        }
    }

    public final void y(int i2) {
        try {
            int childCount = this.l.getChildCount();
            if (childCount > 0) {
                int i3 = 0;
                while (i3 < childCount) {
                    this.l.getChildAt(i3).setLayoutParams(i3 == i2 ? this.n : this.m);
                    ((CheckBox) this.l.getChildAt(i3)).setChecked(i3 == i2);
                    i3++;
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void setPagerAdapter(EditBannerViewPagerAdapter editBannerViewPagerAdapter, Fragment fragment) {
        this.f6753c = fragment;
        setViewPagerAdapter(editBannerViewPagerAdapter);
    }

    public EditBannerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public EditBannerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f6751a = 5000;
        this.r = true;
        this.x = 1000;
        this.A = new a();
        this.B = new c();
        this.C = new d();
        this.D = new e();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.EditBannerView, 0, 0);
        int i3 = R.styleable.EditBannerView_indicator_normal_color;
        this.u = typedArrayObtainStyledAttributes.getColor(i3, getResources().getColor(R.color.edit_banner_indicator_normal_color));
        this.t = typedArrayObtainStyledAttributes.getColor(i3, getResources().getColor(R.color.edit_banner_indicator_select_color));
        this.f6751a = typedArrayObtainStyledAttributes.getInt(R.styleable.EditBannerView_play_time, this.f6751a);
        typedArrayObtainStyledAttributes.recycle();
        s();
    }
}
