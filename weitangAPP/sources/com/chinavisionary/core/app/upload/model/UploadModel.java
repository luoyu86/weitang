package com.chinavisionary.core.app.upload.model;

import c.e.a.d.j;
import c.e.a.d.n;
import c.e.a.d.o;
import c.e.a.d.q;
import c.e.a.d.x;
import c.e.a.d.y;
import com.alibaba.android.arouter.utils.Consts;
import com.chinavisionary.core.R;
import com.chinavisionary.core.app.net.base.model.BaseModel;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class UploadModel extends BaseModel {
    public UploadModel() {
        super(j.getInstance().getPublicBaseUrl());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void b(boolean z, List list) {
        if (z) {
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                File file = (File) it.next();
                if (file != null && file.exists()) {
                    String absolutePath = file.getAbsolutePath();
                    StringBuilder sb = new StringBuilder(absolutePath);
                    sb.insert(absolutePath.lastIndexOf(Consts.DOT), BaseModel.PIC_SCALE_APPEND_NAME);
                    q.d(UploadModel.class.getClass().getSimpleName(), "target path :" + sb.toString());
                    n.getBitmapWithScaleToSrcPath(absolutePath, sb.toString(), 1080, 1920);
                    File file2 = new File(sb.toString());
                    if (file2.exists()) {
                        file = file2;
                    } else {
                        q.d(UploadModel.class.getClass().getSimpleName(), "target path !exists:" + sb.toString());
                    }
                    arrayList.add(file);
                }
            }
            list.clear();
            list.addAll(arrayList);
        }
        if (o.isNotEmpty(list)) {
            newUploadFileList(list, true);
        } else {
            handlerResponseErr(null, x.getString(R.string.core_lib_title_upload_file_list_is_empty));
        }
    }

    public void uploadPicList(List<File> list) {
        uploadPicList(list, false);
    }

    public void uploadPicList(final List<File> list, final boolean z) {
        y.get().addRunnable(new Runnable() { // from class: c.e.a.a.k.f.a
            @Override // java.lang.Runnable
            public final void run() {
                this.f1040a.b(z, list);
            }
        });
    }
}
