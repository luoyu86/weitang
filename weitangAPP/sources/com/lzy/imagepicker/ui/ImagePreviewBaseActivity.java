package com.lzy.imagepicker.ui;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.k.a.e.d;
import com.lzy.imagepicker.R;
import com.lzy.imagepicker.adapter.ImagePageAdapter;
import com.lzy.imagepicker.bean.ImageItem;
import com.lzy.imagepicker.view.ViewPagerFixed;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ImagePreviewBaseActivity extends ImageBaseActivity {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c.k.a.a f9390b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ArrayList<ImageItem> f9391c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TextView f9393e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ArrayList<ImageItem> f9394f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f9395g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View f9396h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ViewPagerFixed f9397i;
    public ImagePageAdapter j;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f9392d = 0;
    public boolean k = false;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ImagePreviewBaseActivity.this.finish();
        }
    }

    public class b implements ImagePageAdapter.b {
        public b() {
        }

        @Override // com.lzy.imagepicker.adapter.ImagePageAdapter.b
        public void OnPhotoTapListener(View view, float f2, float f3) {
            ImagePreviewBaseActivity.this.onImageSingleTap();
        }
    }

    @Override // com.lzy.imagepicker.ui.ImageBaseActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_image_preview);
        this.f9390b = c.k.a.a.getInstance();
        this.f9392d = getIntent().getIntExtra("selected_image_position", 0);
        boolean booleanExtra = getIntent().getBooleanExtra("extra_is_preview_select_items", false);
        this.k = booleanExtra;
        if (booleanExtra) {
            this.f9391c = (ArrayList) getIntent().getSerializableExtra("extra_image_items");
        } else {
            this.f9391c = this.f9390b.getCurrentImageFolderItems();
            this.f9394f = this.f9390b.getSelectedImages();
        }
        this.f9395g = findViewById(R.id.content);
        View viewFindViewById = findViewById(R.id.top_bar);
        this.f9396h = viewFindViewById;
        if (Build.VERSION.SDK_INT >= 19) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) viewFindViewById.getLayoutParams();
            layoutParams.topMargin = d.getStatusHeight(this);
            this.f9396h.setLayoutParams(layoutParams);
        }
        this.f9396h.findViewById(R.id.btn_back).setOnClickListener(new a());
        this.f9393e = (TextView) findViewById(R.id.tv_des);
        this.f9397i = (ViewPagerFixed) findViewById(R.id.viewpager);
        ImagePageAdapter imagePageAdapter = new ImagePageAdapter(this, this.f9391c);
        this.j = imagePageAdapter;
        imagePageAdapter.setPhotoViewClickListener(new b());
        this.f9397i.setAdapter(this.j);
        this.f9397i.setCurrentItem(this.f9392d, false);
        this.f9393e.setText(getString(R.string.ip_preview_image_count, new Object[]{Integer.valueOf(this.f9392d + 1), Integer.valueOf(this.f9391c.size())}));
    }

    public abstract void onImageSingleTap();

    @Override // com.lzy.imagepicker.ui.ImageBaseActivity, android.app.Activity
    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        c.k.a.a.getInstance().restoreInstanceState(bundle);
    }

    @Override // com.lzy.imagepicker.ui.ImageBaseActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        c.k.a.a.getInstance().saveInstanceState(bundle);
    }
}
