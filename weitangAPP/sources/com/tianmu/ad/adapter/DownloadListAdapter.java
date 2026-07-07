package com.tianmu.ad.adapter;

import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tianmu.TianmuSDK;
import com.tianmu.biz.widget.roundimage.RoundedImageView;
import com.tianmu.c.f.c;
import com.tianmu.c.f.c1;
import com.tianmu.c.f.q;
import com.tianmu.c.l.a;
import com.tianmu.utils.TianmuDisplayUtil;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class DownloadListAdapter extends BaseAdapter<Intent> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<Intent> f10608a;

    @Override // com.tianmu.ad.adapter.BaseAdapter
    public void addData(List<Intent> list) {
    }

    @Override // com.tianmu.ad.adapter.BaseAdapter
    public void clearData() {
        List<Intent> list = this.f10608a;
        if (list == null) {
            return;
        }
        list.clear();
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<Intent> list = this.f10608a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public void notifyItemChanged(Intent intent) {
        List<Intent> list = this.f10608a;
        if (list == null || intent == null) {
            return;
        }
        notifyItemChanged(list.indexOf(intent));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i2) {
        ((DownloadTaskViewHolder) viewHolder).setData(this.f10608a.get(i2));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        return new DownloadTaskViewHolder(this, viewGroup);
    }

    @Override // com.tianmu.ad.adapter.BaseAdapter
    public void setData(List<Intent> list) {
        this.f10608a = list;
        notifyDataSetChanged();
    }

    @Override // com.tianmu.ad.adapter.BaseAdapter
    public void removeData(Intent intent) {
        List<Intent> list = this.f10608a;
        if (list == null) {
            return;
        }
        list.remove(intent);
        notifyDataSetChanged();
    }

    public class DownloadTaskViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private RoundedImageView f10609a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private RoundedImageView f10610b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private TextView f10611c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private TextView f10612d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private TextView f10613e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private ProgressBar f10614f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private TextView f10615g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private TextView f10616h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private TextView f10617i;

        public DownloadTaskViewHolder(@NonNull DownloadListAdapter downloadListAdapter, ViewGroup viewGroup) {
            super(LayoutInflater.from(viewGroup.getContext()).inflate(q.f11480a, viewGroup, false));
            RoundedImageView roundedImageView = (RoundedImageView) this.itemView.findViewById(q.f11481b);
            this.f10609a = roundedImageView;
            roundedImageView.a(TianmuDisplayUtil.dp2px(15));
            RoundedImageView roundedImageView2 = (RoundedImageView) this.itemView.findViewById(q.f11482c);
            this.f10610b = roundedImageView2;
            roundedImageView2.a(TianmuDisplayUtil.dp2px(15));
            this.f10611c = (TextView) this.itemView.findViewById(q.f11483d);
            this.f10612d = (TextView) this.itemView.findViewById(q.f11484e);
            this.f10613e = (TextView) this.itemView.findViewById(q.f11485f);
            this.f10614f = (ProgressBar) this.itemView.findViewById(q.f11486g);
            this.f10615g = (TextView) this.itemView.findViewById(q.f11487h);
            this.f10616h = (TextView) this.itemView.findViewById(q.f11488i);
            this.f10617i = (TextView) this.itemView.findViewById(q.j);
        }

        private void a(int i2, String str) {
            if (i2 == 2) {
                if (TextUtils.isEmpty(str)) {
                    this.f10610b.setImageResource(c.f11281g);
                } else {
                    this.f10610b.setImageResource(c.f11282h);
                }
            } else if (TextUtils.isEmpty(str)) {
                this.f10610b.setImageResource(c.f11283i);
            } else {
                this.f10610b.setImageResource(c.j);
            }
            TianmuSDK.getInstance().getImageLoader().loadImage(this.f10609a.getContext(), str, this.f10609a);
        }

        private void b(int i2) {
            this.f10612d.setText(i2 + "%");
            this.f10614f.setProgress(i2);
        }

        private void c(int i2) {
            if (i2 == 2) {
                this.f10613e.setText(c1.f11298f);
            } else {
                this.f10613e.setText(c1.f11299g);
            }
        }

        public void setData(Intent intent) {
            String stringExtra = intent.getStringExtra("adKey");
            String stringExtra2 = intent.getStringExtra("appPackageName");
            String stringExtra3 = intent.getStringExtra("appLogoUrl");
            String stringExtra4 = intent.getStringExtra("appName");
            int intExtra = intent.getIntExtra("downloadProgress", 0);
            int intExtra2 = intent.getIntExtra("downloadState", 0);
            a(intExtra2, stringExtra3);
            b(intExtra);
            c(intExtra2);
            a(intExtra2);
            if (!TextUtils.isEmpty(stringExtra2)) {
                stringExtra = stringExtra2;
            }
            a(stringExtra);
            this.f10611c.setText(stringExtra4);
        }

        private void a(int i2) {
            if (i2 == 2) {
                this.f10616h.setVisibility(0);
                this.f10615g.setVisibility(8);
            } else {
                this.f10616h.setVisibility(8);
                this.f10615g.setVisibility(0);
            }
        }

        private void a(final String str) {
            this.f10615g.setOnClickListener(new a(this) { // from class: com.tianmu.ad.adapter.DownloadListAdapter.DownloadTaskViewHolder.1
                @Override // com.tianmu.c.l.a
                public void onSingleClick(View view) {
                    com.tianmu.c.h.d.c.c().f(str);
                }
            });
            this.f10616h.setOnClickListener(new a(this) { // from class: com.tianmu.ad.adapter.DownloadListAdapter.DownloadTaskViewHolder.2
                @Override // com.tianmu.c.l.a
                public void onSingleClick(View view) {
                    com.tianmu.c.h.d.c.c().d(str);
                }
            });
            this.f10617i.setOnClickListener(new a(this) { // from class: com.tianmu.ad.adapter.DownloadListAdapter.DownloadTaskViewHolder.3
                @Override // com.tianmu.c.l.a
                public void onSingleClick(View view) {
                    com.tianmu.c.h.d.c.c().g(str);
                }
            });
        }
    }
}
