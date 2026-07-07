package com.lzy.imagepicker.ui;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c.k.a.a;
import c.k.a.f.a;
import com.lzy.imagepicker.ImageDataSource;
import com.lzy.imagepicker.R;
import com.lzy.imagepicker.adapter.ImageRecyclerAdapter;
import com.lzy.imagepicker.bean.ImageItem;
import com.lzy.imagepicker.view.GridSpacingItemDecoration;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ImageGridActivity extends ImageBaseActivity {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c.k.a.a f9369b;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f9374g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Button f9375h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public TextView f9376i;
    public TextView j;
    public TextView k;
    public TextView l;
    public c.k.a.b.a m;
    public c.k.a.f.a n;
    public List<c.k.a.c.a> o;
    public View p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public RecyclerView f9377q;
    public ImageRecyclerAdapter r;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f9370c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f9371d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f9372e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f9373f = false;
    public final ImageDataSource.b s = new a();
    public final a.InterfaceC0039a t = new b();
    public final View.OnClickListener u = new c();
    public final RecyclerView.OnScrollListener v = new d();

    public class a implements ImageDataSource.b {

        /* JADX INFO: renamed from: com.lzy.imagepicker.ui.ImageGridActivity$a$a, reason: collision with other inner class name */
        public class RunnableC0124a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ List f9379a;

            public RunnableC0124a(List list) {
                this.f9379a = list;
            }

            @Override // java.lang.Runnable
            public void run() {
                ImageGridActivity.this.p.setVisibility(8);
                List list = this.f9379a;
                if (list == null || list.isEmpty()) {
                    return;
                }
                ImageGridActivity.this.o = this.f9379a;
                c.k.a.a.getInstance().setImageFolders(this.f9379a);
                ImageGridActivity.this.r.refreshData(((c.k.a.c.a) this.f9379a.get(0)).images);
                ImageGridActivity.this.m.refreshData(this.f9379a);
            }
        }

        public a() {
        }

        @Override // com.lzy.imagepicker.ImageDataSource.b
        public void onImagesLoaded(List<c.k.a.c.a> list) {
            ImageGridActivity.this.p.post(new RunnableC0124a(list));
        }
    }

    public class b implements a.InterfaceC0039a {
        public b() {
        }

        @Override // c.k.a.a.InterfaceC0039a
        public void onImageSelected(int i2, ImageItem imageItem, boolean z) {
            int selectImageCount = ImageGridActivity.this.f9369b.getSelectImageCount();
            boolean z2 = selectImageCount > 0;
            int I = ImageGridActivity.this.I(z2 ? R.color.ip_text_primary_inverted : R.color.ip_text_secondary_inverted);
            ImageGridActivity.this.Q(selectImageCount, z2, I);
            ImageGridActivity.this.R(selectImageCount, z2, I);
            if (imageItem != null) {
                ImageGridActivity.this.M(imageItem.path);
            }
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int id = view.getId();
            if (id == R.id.ll_dir) {
                ImageGridActivity.this.P();
                return;
            }
            if (id == R.id.btn_preview) {
                if (ImageGridActivity.this.f9371d) {
                    ImageGridActivity.this.H(true);
                    return;
                } else {
                    ImageGridActivity.this.O(0, true);
                    return;
                }
            }
            if (id == R.id.btn_back || id == R.id.btn_ok) {
                ImageGridActivity.this.H(id == R.id.btn_ok);
            } else if (id == R.id.camera) {
                ImageGridActivity.this.N();
            } else if (id == R.id.iv_thumb) {
                ImageGridActivity.this.F(view);
            }
        }
    }

    public class d extends RecyclerView.OnScrollListener {
        public d() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            super.onScrollStateChanged(recyclerView, i2);
            if (i2 == 0) {
                ImageGridActivity.this.K();
            }
        }
    }

    public class e implements a.d {
        public e() {
        }

        @Override // c.k.a.f.a.d
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            ImageGridActivity.this.m.setSelectIndex(i2);
            ImageGridActivity.this.f9369b.setCurrentImageFolderPosition(i2);
            ImageGridActivity.this.n.dismiss();
            c.k.a.c.a aVar = (c.k.a.c.a) adapterView.getAdapter().getItem(i2);
            if (aVar != null) {
                ImageGridActivity.this.r.resetFirstLastPosition();
                ImageGridActivity.this.r.refreshData(aVar.images);
                ImageGridActivity.this.f9376i.setText(aVar.name);
            }
        }
    }

    public final void E() {
        if (Build.VERSION.SDK_INT < 23) {
            T();
            return;
        }
        if (checkPermission("android.permission.WRITE_EXTERNAL_STORAGE")) {
            T();
            return;
        }
        if (this.f9372e) {
            this.l.setVisibility(0);
        } else {
            this.k.setVisibility(0);
        }
        this.k.setText(R.string.lib_image_picker_storage_permission_tip);
        ActivityCompat.requestPermissions(this, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 1);
    }

    public final void F(View view) {
        int iIntValue = ((Integer) view.getTag(view.getId())).intValue();
        if (this.f9369b.isShowCamera()) {
            iIntValue--;
        }
        O(iIntValue, false);
    }

    public final void G() {
        c.k.a.f.a aVar = new c.k.a.f.a(this, this.m);
        this.n = aVar;
        aVar.setOnItemClickListener(new e());
        this.n.setMargin(this.f9374g.getHeight());
    }

    public final void H(boolean z) {
        Intent intent = new Intent();
        if (z) {
            intent.putExtra("extra_result_items", this.f9369b.getSelectedImages());
            setResult(1004, intent);
        }
        finish();
    }

    public final int I(@ColorRes int i2) {
        return ContextCompat.getColor(this, i2);
    }

    public final void J(int[] iArr, int i2) {
        boolean z = i2 == 2;
        if (iArr.length <= 0 || iArr[0] != 0) {
            showToast((z || this.f9372e) ? "权限被禁止，无法打开相机" : "权限被禁止，无法选择本地图片");
            return;
        }
        if (!z) {
            T();
            return;
        }
        if (this.f9372e) {
            this.l.setVisibility(8);
        } else {
            this.k.setVisibility(8);
        }
        this.f9369b.takePicture(this, 1001);
    }

    public final void K() {
        RecyclerView.LayoutManager layoutManager = this.f9377q.getLayoutManager();
        if (layoutManager == null || layoutManager.getItemCount() <= 0) {
            return;
        }
        int[] position = getPosition(layoutManager);
        this.r.setFirstLastPosition(position[0], position[1]);
    }

    public final void L() {
        this.f9369b = c.k.a.a.getInstance();
        if (getIntent().getBooleanExtra("isClearSelect", true)) {
            this.f9369b.clear();
        }
        this.f9369b.addOnImageSelectedListener(this.t);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r1v2, types: [com.lzy.imagepicker.adapter.ImageRecyclerAdapter] */
    /* JADX WARN: Type inference failed for: r1v5, types: [com.lzy.imagepicker.adapter.ImageRecyclerAdapter] */
    /* JADX WARN: Type inference failed for: r3v1, types: [androidx.recyclerview.widget.RecyclerView$Adapter, com.lzy.imagepicker.adapter.ImageRecyclerAdapter] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void M(String str) {
        for (?? IsShowCamera = this.f9369b.isShowCamera(); IsShowCamera < this.r.getItemCount(); IsShowCamera++) {
            if (this.r.getItem(IsShowCamera).path != null && this.r.getItem(IsShowCamera).path.equals(str)) {
                this.r.notifyItemChanged(IsShowCamera);
                return;
            }
        }
    }

    public final void N() {
        if (checkPermission("android.permission.CAMERA")) {
            this.f9369b.takePicture(this, 1001);
            return;
        }
        if (this.f9372e) {
            this.l.setVisibility(0);
        } else {
            this.k.setVisibility(0);
        }
        this.k.setText(R.string.lib_image_picker_camera_permission_tip);
        ActivityCompat.requestPermissions(this, new String[]{"android.permission.CAMERA"}, 2);
    }

    public final void O(int i2, boolean z) {
        Intent intent = new Intent(this, (Class<?>) ImagePreviewActivity.class);
        intent.putExtra("selected_image_position", i2);
        intent.putExtra("extra_is_preview_select_items", z);
        if (z) {
            intent.putExtra("extra_image_items", this.f9369b.getSelectedImages());
        }
        intent.putExtra("isOrigin", this.f9370c);
        startActivityForResult(intent, 1003);
    }

    public final void P() {
        if (this.o == null) {
            showToast(getString(R.string.lib_image_picker_not_folder_list));
            return;
        }
        G();
        this.m.refreshData(this.o);
        if (this.n.isShowing()) {
            this.n.dismiss();
            return;
        }
        this.n.showAtLocation(this.f9374g, 0, 0, 0);
        int selectIndex = this.m.getSelectIndex();
        if (selectIndex != 0) {
            selectIndex--;
        }
        this.n.setSelection(selectIndex);
    }

    public final void Q(int i2, boolean z, int i3) {
        this.f9375h.setEnabled(z);
        this.f9375h.setText(z ? getString(R.string.ip_select_complete, new Object[]{Integer.valueOf(i2), Integer.valueOf(this.f9369b.getSelectLimit())}) : getString(R.string.ip_complete));
        this.f9375h.setTextColor(i3);
    }

    public final void R(int i2, boolean z, int i3) {
        this.j.setEnabled(z);
        this.j.setText(z ? getString(R.string.ip_preview_count, new Object[]{Integer.valueOf(i2)}) : getString(R.string.ip_preview));
        this.j.setTextColor(i3);
    }

    public final void S() {
        this.m = new c.k.a.b.a(this, null);
        ImageRecyclerAdapter imageRecyclerAdapter = new ImageRecyclerAdapter(this);
        this.r = imageRecyclerAdapter;
        imageRecyclerAdapter.setOnClickListener(this.u);
        this.f9377q.addOnScrollListener(this.v);
        ((DefaultItemAnimator) this.f9377q.getItemAnimator()).setSupportsChangeAnimations(false);
        this.f9377q.setLayoutManager(new GridLayoutManager(this, 3));
        this.f9377q.addItemDecoration(new GridSpacingItemDecoration(3, c.k.a.e.d.dp2px(this, 2.0f), false));
        this.f9377q.setHasFixedSize(true);
        this.f9377q.setAdapter(this.r);
    }

    public final void T() {
        this.k.setVisibility(8);
        new ImageDataSource(this, null, this.s);
    }

    public int[] getPosition(RecyclerView.LayoutManager layoutManager) {
        int iFindLastVisibleItemPosition;
        int iFindFirstVisibleItemPosition;
        if (layoutManager instanceof GridLayoutManager) {
            GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
            iFindFirstVisibleItemPosition = gridLayoutManager.findFirstVisibleItemPosition();
            iFindLastVisibleItemPosition = gridLayoutManager.findLastVisibleItemPosition();
        } else {
            iFindLastVisibleItemPosition = 0;
            iFindFirstVisibleItemPosition = 0;
        }
        return new int[]{iFindFirstVisibleItemPosition, iFindLastVisibleItemPosition};
    }

    public final void initView() {
        this.p = findViewById(R.id.llayout_tip);
        this.f9377q = (RecyclerView) findViewById(R.id.recycler);
        findViewById(R.id.btn_back).setOnClickListener(this.u);
        findViewById(R.id.ll_dir).setOnClickListener(this.u);
        Button button = (Button) findViewById(R.id.btn_ok);
        this.f9375h = button;
        button.setOnClickListener(this.u);
        TextView textView = (TextView) findViewById(R.id.btn_preview);
        this.j = textView;
        textView.setOnClickListener(this.u);
        this.f9374g = findViewById(R.id.footer_bar);
        this.f9376i = (TextView) findViewById(R.id.tv_dir);
        this.k = (TextView) findViewById(R.id.tv_permission_info);
        this.l = (TextView) findViewById(R.id.tv_permission_info_value);
        this.f9375h.setVisibility(this.f9369b.isMultiMode() ? 0 : 8);
        this.j.setVisibility(this.f9369b.isMultiMode() ? 0 : 8);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        Log.d("ImagePicker", "onActivityResult requestCode = " + i2 + ", resultCode = " + i3);
        if (i3 != -1 || i2 != 1001) {
            if (this.f9373f) {
                H(true);
                return;
            } else {
                if (i3 == 0 && i2 == 1001) {
                    finish();
                    return;
                }
                return;
            }
        }
        try {
            Log.d("ImagePicker", "onActivityResult takeImageFile = " + this.f9369b.getTakeImageFile());
            if (this.f9369b.getTakeImageFile() != null) {
                c.k.a.a.galleryAddPic(this, this.f9369b.getTakeImageFile());
                String absolutePath = this.f9369b.getTakeImageFile().getAbsolutePath();
                Log.d("ImagePicker", "onActivityResult path = " + absolutePath);
                if (this.f9369b.getSelectImageCount() < this.f9369b.getSelectLimit()) {
                    ImageItem imageItem = new ImageItem();
                    imageItem.path = absolutePath;
                    this.f9369b.addSelectedImageItem(0, imageItem, true);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        H(true);
    }

    @Override // com.lzy.imagepicker.ui.ImageBaseActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_image_grid);
        this.f9371d = getIntent().getBooleanExtra("is_scan_key", false);
        this.f9372e = getIntent().getBooleanExtra("is_only_camera", false);
        L();
        initView();
        S();
        this.t.onImageSelected(0, null, false);
        if (!this.f9372e) {
            E();
            return;
        }
        findViewById(R.id.top_bar).setVisibility(8);
        findViewById(R.id.layout_content).setVisibility(8);
        N();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        this.f9369b.removeOnImageSelectedListener(this.t);
        super.onDestroy();
        Log.d(getClass().getSimpleName(), "onDestroy");
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
        J(iArr, i2);
    }

    @Override // com.lzy.imagepicker.ui.ImageBaseActivity, android.app.Activity
    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.f9373f = bundle.getBoolean("TAKE", false);
    }

    @Override // com.lzy.imagepicker.ui.ImageBaseActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("TAKE", this.f9373f);
    }
}
