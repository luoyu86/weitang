package c.e.c.x.d;

import androidx.lifecycle.Observer;
import com.chinavisionary.core.app.net.base.dto.UploadResponseDto;
import com.chinavisionary.microtang.me.fragment.EditMeNewFragment;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class m implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ EditMeNewFragment f2069a;

    public /* synthetic */ m(EditMeNewFragment editMeNewFragment) {
        this.f2069a = editMeNewFragment;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object obj) {
        this.f2069a.P1((UploadResponseDto) obj);
    }
}
