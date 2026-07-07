package com.chinavisionary.microtang.pdf;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.chinavisionary.core.app.adapter.BaseRecyclerAdapter;
import com.chinavisionary.core.app.adapter.BaseRecyclerViewHolder;
import com.chinavisionary.core.weight.CoreRoundedImageView;
import com.chinavisionary.core.weight.banner.EditBannerView;
import com.chinavisionary.microtang.R;

/* JADX INFO: loaded from: classes.dex */
public class PdfRecyclerAdapter extends BaseRecyclerAdapter<EditBannerView.BannerDto> {

    public static class PdfVh extends BaseRecyclerViewHolder<EditBannerView.BannerDto> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public CoreRoundedImageView f8138f;

        public PdfVh(View view) {
            super(view);
            this.f8138f = (CoreRoundedImageView) view.findViewById(R.id.img_pdf_view);
        }

        public void g(EditBannerView.BannerDto bannerDto) {
            this.f8138f.loadImageToResourceVo(bannerDto.getCover());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i2) {
        ((PdfVh) viewHolder).g((EditBannerView.BannerDto) this.f6460b.get(i2));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        return new PdfVh(i(viewGroup, R.layout.item_pdf_layout));
    }
}
