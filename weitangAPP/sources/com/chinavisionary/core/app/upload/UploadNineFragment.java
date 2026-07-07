package com.chinavisionary.core.app.upload;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.GridLayoutManager;
import butterknife.BindView;
import c.e.a.a.e.p;
import c.e.a.a.k.d;
import c.e.a.a.k.e;
import c.e.a.d.o;
import c.e.a.d.q;
import c.e.a.d.x;
import com.chinavisionary.core.R;
import com.chinavisionary.core.app.base.CoreBaseFragment;
import com.chinavisionary.core.app.net.base.dto.RequestErrDto;
import com.chinavisionary.core.app.net.base.dto.ResponseUploadImgVo;
import com.chinavisionary.core.app.net.base.dto.UploadResponseDto;
import com.chinavisionary.core.app.upload.adapter.NinePicAdapter;
import com.chinavisionary.core.app.upload.model.UploadModel;
import com.chinavisionary.core.weight.BaseRecyclerView;
import com.chinavisionary.framework.mobile.common.vo.ResourceVo;
import com.lzy.imagepicker.bean.ImageItem;
import com.lzy.imagepicker.ui.ImageGridActivity;
import com.lzy.ninegrid.preview.ImagePreviewActivity;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public class UploadNineFragment extends CoreBaseFragment<ImageItem> {
    public int A;
    public int B;
    public List<ImageItem> C;
    public UploadModel D;
    public d E;
    public e F;
    public boolean G;
    public int H = 9;
    public final c.e.a.a.c.c.a I = new c.e.a.a.c.c.a() { // from class: c.e.a.a.k.b
        @Override // c.e.a.a.c.c.a
        public final void onItemClickListener(View view, int i2) {
            this.f1038a.V0(view, i2);
        }
    };

    @BindView(2483)
    public BaseRecyclerView mRecyclerView;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f6516a;

        public a(List list) {
            this.f6516a = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            UploadNineFragment.this.e1(this.f6516a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: U0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void V0(View view, int i2) {
        if (i2 != this.C.size() - 1 || this.C.size() >= 9) {
            this.B = i2;
        } else {
            this.B = -1;
        }
        if (!String.valueOf(R.drawable.core_lib_ic_add_pic).equals(this.C.get(i2).path)) {
            a1();
        } else if (this.G) {
            a1();
        } else {
            b1();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: W0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void X0(UploadResponseDto uploadResponseDto) {
        H();
        d dVar = this.E;
        if (dVar != null) {
            dVar.uploadSuccess(uploadResponseDto);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: Y0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void Z0(RequestErrDto requestErrDto) {
        H();
        int i2 = R.string.tip_upload_failed;
        F0(i2);
        d dVar = this.E;
        if (dVar != null) {
            dVar.uploadFailed(requestErrDto != null ? requestErrDto.getErrMsg() : x.getString(i2));
        }
    }

    public static UploadNineFragment getInstance(d dVar) {
        UploadNineFragment uploadNineFragment = new UploadNineFragment();
        uploadNineFragment.setIUploadCallback(dVar);
        return uploadNineFragment;
    }

    private void o0() {
        c.k.a.a.getInstance().setSelectLimit(this.H);
        c.k.a.a.getInstance().clear();
        Log.d(getClass().getSimpleName(), "clear");
        NinePicAdapter ninePicAdapter = new NinePicAdapter();
        this.t = ninePicAdapter;
        ninePicAdapter.setOnClickListener(this.y);
        this.t.setOnItemClickListener(this.I);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this.f6487e, 3);
        GridSpecItemDecoration gridSpecItemDecoration = new GridSpecItemDecoration(3, getResources().getDimensionPixelSize(R.dimen.dp_6));
        this.r.setLayoutManager(gridLayoutManager);
        this.r.addItemDecoration(gridSpecItemDecoration);
        this.C = new ArrayList();
        O0();
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final void O0() {
        this.C.add(Q0());
        this.t.initListData((List<T>) this.C);
    }

    public final List<c.k.b.a> P0() {
        ArrayList arrayList = new ArrayList();
        List<ImageItem> list = this.C;
        if (list != null && !list.isEmpty()) {
            int size = this.C.size();
            for (int i2 = 0; i2 < size; i2++) {
                ImageItem imageItem = this.C.get(i2);
                if (imageItem != null) {
                    c.k.b.a aVar = new c.k.b.a();
                    if (!T0(imageItem.path)) {
                        aVar.setBigImageUrl(imageItem.path);
                        aVar.setThumbnailUrl(imageItem.path);
                        arrayList.add(aVar);
                    }
                }
            }
        }
        return arrayList;
    }

    public final ImageItem Q0() {
        ImageItem imageItem = new ImageItem();
        imageItem.path = String.valueOf(R.drawable.core_lib_ic_add_pic);
        return imageItem;
    }

    public final List<File> R0() {
        ArrayList arrayList = new ArrayList();
        int size = this.C.size() - 1;
        if (T0(this.C.get(size).path)) {
            this.C.remove(size);
        }
        Iterator<ImageItem> it = this.C.iterator();
        while (it.hasNext()) {
            arrayList.add(new File(it.next().path));
        }
        return arrayList;
    }

    public final void S0(View view) {
        this.A = ((Integer) view.getTag()).intValue();
        p.showAlert(this.f6487e, x.getString(R.string.core_lib_title_alert_tip), x.getString(R.string.core_lib_tip_confirm_del_img), x.getString(R.string.core_lib_title_confirm), x.getString(R.string.core_lib_title_cancel), this.y, true);
    }

    public final boolean T0(String str) {
        return Pattern.compile("^[-\\+]?[\\d]*$").matcher(str).matches();
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
        int id = view.getId();
        if (id == R.id.img_del) {
            S0(view);
            return;
        }
        if (id == R.id.tv_alert_confirm) {
            c1(this.C.remove(this.A));
            g1();
            this.t.initListData((List<T>) this.C);
            this.t.notifyDataSetChanged();
            h1();
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        this.r = this.mRecyclerView;
        f1();
        o0();
    }

    public final void a1() {
        Intent intent = new Intent(this.f6487e, (Class<?>) ImagePreviewActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("IMAGE_INFO", (Serializable) P0());
        bundle.putInt("CURRENT_ITEM", this.B);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public final void b1() {
        Intent intent = new Intent(this.f6487e, (Class<?>) ImageGridActivity.class);
        intent.putExtra("isClearSelect", false);
        startActivityForResult(intent, 1000);
    }

    public final void c1(ImageItem imageItem) {
        c.k.a.a.getInstance().removeImageItem(imageItem.path);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final void d1(ArrayList<ImageItem> arrayList) {
        if (arrayList != null) {
            int size = arrayList.size();
            this.C.clear();
            this.C.addAll(arrayList);
            if (size < 9) {
                this.C.add(Q0());
            }
        }
        this.t.initListData((List<T>) this.C);
        h1();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void e0() {
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final void e1(List<ResourceVo> list) {
        this.G = true;
        ((NinePicAdapter) this.t).setHiedDelImg(true);
        this.t.setOnClickListener(null);
        if (list == null || list.isEmpty()) {
            this.mRecyclerView.setVisibility(8);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (ResourceVo resourceVo : list) {
            if (resourceVo != null) {
                ImageItem imageItem = new ImageItem();
                imageItem.path = resourceVo.getUrl();
                arrayList.add(imageItem);
            }
        }
        this.C = arrayList;
        this.t.initListData(arrayList);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void f0() {
    }

    public final void f1() {
        UploadModel uploadModel = (UploadModel) h(UploadModel.class);
        this.D = uploadModel;
        uploadModel.getUploadResponseDtoMutableLive().observe(this, new Observer() { // from class: c.e.a.a.k.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1039a.X0((UploadResponseDto) obj);
            }
        });
        this.D.getErrRequestLiveData().observe(this, new Observer() { // from class: c.e.a.a.k.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1037a.Z0((RequestErrDto) obj);
            }
        });
    }

    public final void g1() {
        if (this.C.size() >= 9 || !(!T0(this.C.get(r0 - 1).path))) {
            return;
        }
        O0();
    }

    public int getImageCount() {
        if (o.isNotEmpty(this.C)) {
            return this.C.size();
        }
        return 1;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.core_lib_fragment_upload_nine;
    }

    public final void h1() {
        e eVar = this.F;
        if (eVar != null) {
            eVar.onSelectPicChange(this.C);
        }
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public void initAdapterData(List<ResponseUploadImgVo> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (ResponseUploadImgVo responseUploadImgVo : list) {
            if (responseUploadImgVo != null) {
                ImageItem imageItem = new ImageItem();
                imageItem.path = responseUploadImgVo.getUrl();
                arrayList.add(imageItem);
            }
        }
        this.C = arrayList;
        this.t.initListData(arrayList);
    }

    public void initAdapterDataToResourceVo(List<ResourceVo> list) {
        if (this.t != null) {
            e1(list);
            return;
        }
        View view = this.u;
        if (view != null) {
            view.postDelayed(new a(list), 1300L);
        }
    }

    public boolean isExitsAddPic() {
        if (!o.isNotEmpty(this.C)) {
            return false;
        }
        int size = this.C.size();
        if (size == 1) {
            return true ^ T0(this.C.get(size - 1).path);
        }
        return true;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void j0() {
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        q.d("onActivityResult result :" + i2);
        if (i3 == 1004 || intent != null || i2 == 1000) {
            d1(c.k.a.a.getInstance().getSelectedImages());
        }
    }

    public void setIUploadCallback(d dVar) {
        this.E = dVar;
    }

    public void setIUploadPicCallback(e eVar) {
        this.F = eVar;
    }

    public void setMaxPic(int i2) {
        this.H = i2;
    }

    public boolean uploadPic() {
        if (!isExitsAddPic()) {
            return false;
        }
        z0(R.string.tip_uploading);
        this.D.uploadPicList(R0(), true);
        return true;
    }
}
