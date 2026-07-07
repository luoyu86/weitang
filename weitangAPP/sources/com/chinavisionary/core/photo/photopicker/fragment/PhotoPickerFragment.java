package com.chinavisionary.core.photo.photopicker.fragment;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;
import androidx.appcompat.widget.ListPopupWindow;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import c.e.a.b.a.i.b;
import c.e.a.b.a.i.c;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.chinavisionary.core.R;
import com.chinavisionary.core.photo.photopicker.PhotoPickerActivity;
import com.chinavisionary.core.photo.photopicker.adapter.PhotoGridAdapter;
import com.chinavisionary.core.photo.photopicker.entity.Photo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class PhotoPickerFragment extends Fragment implements c.a, c.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f6592a = 5;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c.e.a.b.a.i.a f6593b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public PhotoGridAdapter f6594c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public c.e.a.b.a.e.a f6595d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List<c.e.a.b.a.g.b> f6596e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f6597f = 30;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ListPopupWindow f6598g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public RequestManager f6599h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Context f6600i;
    public Button j;
    public Button k;
    public c.e.a.b.a.b l;
    public View m;
    public c.e.a.b.a.i.c n;
    public c.e.a.b.a.c o;
    public int p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Animation f6601q;
    public Animation r;

    public class a implements b.InterfaceC0021b {
        public a() {
        }

        @Override // c.e.a.b.a.i.b.InterfaceC0021b
        public void onResultCallback(List<c.e.a.b.a.g.b> list) {
            PhotoPickerFragment.this.f6596e.clear();
            PhotoPickerFragment.this.f6596e.addAll(list);
            PhotoPickerFragment.this.f6594c.notifyDataSetChanged();
            PhotoPickerFragment.this.f6595d.notifyDataSetChanged();
            PhotoPickerFragment.this.adjustHeight();
        }
    }

    public class b extends RecyclerView.OnScrollListener {
        public b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            if (i2 == 0) {
                PhotoPickerFragment.this.f6599h.resumeRequests();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            super.onScrolled(recyclerView, i2, i3);
            if (Math.abs(i3) > PhotoPickerFragment.this.f6597f) {
                PhotoPickerFragment.this.f6599h.pauseRequests();
            } else {
                PhotoPickerFragment.this.f6599h.resumeRequests();
            }
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PhotoPickerFragment.this.f6598g.isShowing()) {
                PhotoPickerFragment.this.n();
            } else {
                if (PhotoPickerFragment.this.getActivity().isFinishing()) {
                    return;
                }
                PhotoPickerFragment.this.adjustHeight();
                PhotoPickerFragment.this.t();
                PhotoPickerFragment.this.f6598g.getListView().setVerticalScrollBarEnabled(false);
            }
        }
    }

    public class d implements AdapterView.OnItemClickListener {
        public d() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            PhotoPickerFragment.this.f6598g.dismiss();
            PhotoPickerFragment.this.k.setText(((c.e.a.b.a.g.b) PhotoPickerFragment.this.f6596e.get(i2)).getName().toLowerCase());
            PhotoPickerFragment.this.f6594c.setCurrentDirectoryIndex(i2);
            PhotoPickerFragment.this.f6594c.notifyDataSetChanged();
        }
    }

    public class e implements Animation.AnimationListener {
        public e() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            PhotoPickerFragment.this.f6598g.dismiss();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    public class f implements c.e.a.b.a.h.a {
        public f() {
        }

        @Override // c.e.a.b.a.h.a
        public void onClick(View view, int i2, boolean z) {
            if (z) {
                i2--;
            }
            PhotoPickerFragment.this.o.setCurrentPos(i2);
            PhotoPickerFragment.this.o.setPhotos(PhotoPickerFragment.this.n.getCurrentPagePhotos());
            ((PhotoPickerActivity) PhotoPickerFragment.this.getActivity()).addImagePagerFragment();
        }
    }

    public class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                if (c.e.a.b.a.b.getCurrentPhotoPicker().isUseSystemCamera()) {
                    PhotoPickerFragment.this.startActivityForResult(PhotoPickerFragment.this.f6593b.dispatchTakePictureIntent(), 1);
                } else {
                    PhotoPickerFragment.this.startActivityForResult(PhotoPickerFragment.this.f6593b.dispatchTakePictureIntent(PhotoPickerFragment.this.getActivity()), 1);
                }
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }

    public class h implements View.OnClickListener {
        public h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.e.a.b.a.i.c.getHelper().getSelectedList().size() > 0) {
                PhotoPickerFragment.this.o.setMaxCount(PhotoPickerFragment.this.l.getMaxCount()).setPhotos(PhotoPickerFragment.this.n.getSelectedList()).setCurrentPos(0).startPreview(PhotoPickerFragment.this.getActivity(), null);
            } else {
                Toast.makeText(PhotoPickerFragment.this.getActivity(), "还没有选择图片", 0).show();
            }
        }
    }

    public void adjustHeight() {
        c.e.a.b.a.e.a aVar = this.f6595d;
        if (aVar == null) {
            return;
        }
        int count = aVar.getCount();
        int i2 = f6592a;
        if (count >= i2) {
            count = i2;
        }
        if (this.f6598g != null) {
            int dimensionPixelSize = count * getResources().getDimensionPixelSize(R.dimen.__picker_item_directory_height);
            int i3 = getResources().getDisplayMetrics().heightPixels;
            Resources resources = getResources();
            int i4 = R.dimen.__bottom_navi_height;
            int iMin = Math.min(dimensionPixelSize, (int) ((i3 - (resources.getDimensionPixelSize(i4) * 2)) * 0.8f));
            this.f6598g.setHeight(iMin);
            this.f6598g.setVerticalOffset(-(iMin + this.p + getResources().getDimensionPixelSize(i4)));
        }
    }

    public void clearDirectories() {
        List<c.e.a.b.a.g.b> list = this.f6596e;
        if (list != null) {
            for (c.e.a.b.a.g.b bVar : list) {
                bVar.getPhotoPaths().clear();
                bVar.getPhotos().clear();
                bVar.setPhotos(null);
            }
            this.f6596e.clear();
            this.f6596e = null;
        }
    }

    public final void n() {
        if (this.r == null) {
            Animation animationLoadAnimation = AnimationUtils.loadAnimation(getActivity(), R.anim.__picker_dialog_exit);
            this.r = animationLoadAnimation;
            animationLoadAnimation.setAnimationListener(new e());
        }
        this.f6598g.getListView().startAnimation(this.r);
    }

    @SuppressLint({"RestrictedApi"})
    public final void o(View view) {
        this.k.setOnClickListener(new c());
        this.f6595d = new c.e.a.b.a.e.a(this.f6599h, this.f6596e);
        ListPopupWindow listPopupWindow = new ListPopupWindow(getActivity());
        this.f6598g = listPopupWindow;
        listPopupWindow.setBackgroundDrawable(new ColorDrawable(0));
        this.f6598g.setWidth(((WindowManager) getActivity().getSystemService("window")).getDefaultDisplay().getWidth());
        this.f6598g.setAnchorView(view.findViewById(R.id.bottom_bar));
        this.f6598g.setAdapter(this.f6595d);
        this.f6598g.setDropDownGravity(80);
        this.f6598g.setAnimationStyle(0);
        this.f6598g.setModal(true);
        this.f6598g.setForceIgnoreOutsideTouch(true);
        this.f6598g.setOnItemClickListener(new d());
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        if (i2 == 1 && i3 == -1) {
            this.f6593b.galleryAddPic();
            if (c.e.a.b.a.b.getCurrentPhotoPicker().isUseSystemCamera()) {
                c.e.a.b.a.i.c.getHelper().capturePhotoFinish(this.f6593b.getCurrentPhotoPath());
            } else if (intent == null) {
                c.e.a.b.a.i.c.getHelper().capturePhotoFinish("");
            } else {
                c.e.a.b.a.i.c.getHelper().capturePhotoFinish(intent.getStringExtra("image_path"));
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f6600i = activity.getApplicationContext();
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.l = c.e.a.b.a.b.getCurrentPhotoPicker();
        c.e.a.b.a.i.c helper = c.e.a.b.a.i.c.getHelper();
        this.n = helper;
        helper.addSelectedChangeListener(this);
        this.n.addStateChangeListener(this);
        c.e.a.b.a.c currentPhotoPreview = c.e.a.b.a.c.getCurrentPhotoPreview();
        this.o = currentPhotoPreview;
        if (currentPhotoPreview == null) {
            this.o = c.e.a.b.a.c.init();
        }
        this.o.setPreviewOnly(false);
        this.f6599h = Glide.with(getActivity());
        ArrayList arrayList = new ArrayList();
        this.f6596e = arrayList;
        PhotoGridAdapter photoGridAdapter = new PhotoGridAdapter(this.f6600i, this.f6599h, arrayList, this.l.getColumn());
        this.f6594c = photoGridAdapter;
        photoGridAdapter.setPreviewEnable(this.l.isPreviewEnable());
        this.f6594c.setShowCamera(this.l.isShowCamera());
        c.e.a.b.a.i.b.getPhotoDirs(getActivity(), new Bundle(), new a());
        this.f6593b = new c.e.a.b.a.i.a(getActivity());
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.__picker_fragment_photo_picker, viewGroup, false);
        View viewFindViewById = viewInflate.findViewById(R.id.bottom_nav);
        this.p = c.e.a.b.a.i.d.getNavigationBarHeight(getActivity());
        if (Build.VERSION.SDK_INT >= 19) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) viewFindViewById.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-1, this.p);
            }
            layoutParams.height = this.p;
            viewFindViewById.setLayoutParams(layoutParams);
        }
        this.j = (Button) viewInflate.findViewById(R.id.btn_preview);
        this.k = (Button) viewInflate.findViewById(R.id.button);
        this.m = viewInflate.findViewById(R.id.picker_bottom_bar);
        r(viewInflate);
        o(viewInflate);
        q();
        s(c.e.a.b.a.i.c.getHelper().getSelectedList().size());
        p();
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.n.removeSelectedChangeListener(this);
        this.n.removeStateChangeListener(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        this.f6593b.onSaveInstanceState(bundle);
        super.onSaveInstanceState(bundle);
    }

    @Override // c.e.a.b.a.i.c.b
    public void onSelectedChanged(Photo photo) {
        this.f6594c.notifyChange(photo);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle bundle) {
        this.f6593b.onRestoreInstanceState(bundle);
        super.onViewStateRestored(bundle);
    }

    public final void p() {
        c.e.a.b.a.d config = c.e.a.b.a.i.c.getHelper().getConfig();
        if (config != null) {
            this.j.setTextColor(config.getAllPictureTextColor());
            this.j.setTextSize(1, config.getAllPictureTextSize());
            this.k.setTextColor(config.getAllPictureTextColor());
            this.k.setTextSize(1, config.getAllPictureTextSize());
            Drawable drawable = getResources().getDrawable(config.getAllPictureIcon());
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            this.k.setCompoundDrawables(null, null, drawable, null);
            this.m.setBackgroundColor(config.getBottomBarColor());
        }
    }

    public final void q() {
        this.f6594c.setOnPhotoClickListener(new f());
        this.f6594c.setOnCameraClickListener(new g());
        this.j.setOnClickListener(new h());
    }

    public final void r(View view) {
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_photos);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) recyclerView.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        }
        layoutParams.topMargin = c.e.a.b.a.i.d.getStateBarHeight(getActivity());
        if (Build.VERSION.SDK_INT >= 19) {
            layoutParams.bottomMargin = this.p;
        }
        recyclerView.setLayoutParams(layoutParams);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(this.l.getColumn(), 1);
        staggeredGridLayoutManager.setGapStrategy(2);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        recyclerView.setAdapter(this.f6594c);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addOnScrollListener(new b());
    }

    public final void s(int i2) {
        if (i2 <= 0) {
            this.j.setText(R.string.__picker_preview);
            return;
        }
        this.j.setText(getString(R.string.__picker_preview) + "(" + i2 + ")");
    }

    @Override // c.e.a.b.a.i.c.a
    public void selectedCount(int i2) {
        s(i2);
    }

    public final void t() {
        this.f6598g.show();
        if (this.f6601q == null) {
            this.f6601q = AnimationUtils.loadAnimation(getActivity(), R.anim.__picker_dialog_enter);
        }
        this.f6598g.getListView().startAnimation(this.f6601q);
    }
}
