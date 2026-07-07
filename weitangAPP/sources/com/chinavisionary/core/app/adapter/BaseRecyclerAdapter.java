package com.chinavisionary.core.app.adapter;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.ColorRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import c.e.a.a.c.c.a;
import c.e.a.d.q;
import c.e.a.d.x;
import com.chinavisionary.core.R;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseRecyclerAdapter<T> extends RecyclerView.Adapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f6459a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View.OnClickListener f6461c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public a f6462d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f6463e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f6464f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public LinearLayout f6466h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public View f6467i;
    public String j;
    public int k;
    public int l;
    public boolean m;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<T> f6460b = new ArrayList();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f6465g = 8;

    public static class EmptyViewHolder extends RecyclerView.ViewHolder {
        public EmptyViewHolder(@NonNull View view) {
            super(view);
        }
    }

    public static class FooterViewHolder extends RecyclerView.ViewHolder {
        public FooterViewHolder(@NonNull View view) {
            super(view);
        }
    }

    public static class RecyclerHeadViewHodler extends RecyclerView.ViewHolder {
        public RecyclerHeadViewHodler(View view) {
            super(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void k(int i2, View view) {
        this.f6462d.onItemClickListener(view, i2 - h());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void m(BaseRecyclerViewHolder baseRecyclerViewHolder, View view) {
        q.d(BaseRecyclerAdapter.class.getCanonicalName(), "addOnItemClickListener");
        this.f6462d.onItemClickListener(view, baseRecyclerViewHolder.getAdapterPosition() - h());
    }

    public final void a(final BaseRecyclerViewHolder baseRecyclerViewHolder) {
        if (this.f6462d != null) {
            baseRecyclerViewHolder.itemView.setOnClickListener(null);
            baseRecyclerViewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: c.e.a.a.c.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f953a.m(baseRecyclerViewHolder, view);
                }
            });
        }
    }

    public final void addDataToList(T t) {
        if (t != null) {
            this.f6460b.add(t);
            this.m = true;
            notifyDataSetChanged();
        }
    }

    public final boolean addHeadView(View view) {
        if (view == null) {
            this.f6466h = null;
            return false;
        }
        if (this.f6466h == null) {
            LinearLayout linearLayout = new LinearLayout(view.getContext());
            this.f6466h = linearLayout;
            linearLayout.setOrientation(1);
            this.f6466h.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        }
        this.f6466h.addView(view);
        return true;
    }

    public final void appendDataToList(List<T> list) {
        if (list != null) {
            this.f6460b.addAll(list);
        }
        this.m = true;
        notifyDataSetChanged();
    }

    public final void b(BaseRecyclerViewHolder baseRecyclerViewHolder, final int i2) {
        if (this.f6462d != null) {
            baseRecyclerViewHolder.itemView.setOnClickListener(null);
            baseRecyclerViewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: c.e.a.a.c.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f955a.k(i2, view);
                }
            });
        }
    }

    public final RecyclerView.ViewHolder c(@NonNull ViewGroup viewGroup, int i2) {
        if (i2 == 26214) {
            return new RecyclerHeadViewHodler(this.f6466h);
        }
        if (i2 != 39321) {
            return null;
        }
        return new FooterViewHolder(f(viewGroup));
    }

    public final View d(ViewGroup viewGroup) {
        View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_empty, viewGroup, false);
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.img_empty_data);
        int i2 = this.l;
        if (i2 > 0) {
            imageView.setImageResource(i2);
        }
        TextView textView = (TextView) viewInflate.findViewById(R.id.tv_tip_msg);
        textView.setText(x.getNotNullStr(this.j, x.getString(R.string.empty_view_hint)));
        Resources resources = viewGroup.getResources();
        int i3 = this.k;
        if (i3 == 0) {
            i3 = R.color.color_text_sub;
        }
        textView.setTextColor(resources.getColor(i3));
        return viewInflate;
    }

    public int e() {
        return g() + h();
    }

    public View f(ViewGroup viewGroup) {
        View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_foot_layout, viewGroup, false);
        this.f6467i = viewInflate;
        return viewInflate;
    }

    public int g() {
        return this.f6463e ? 1 : 0;
    }

    public final int getDefaultLastPosition() {
        return this.f6465g;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f6460b.size() + e();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        return o(i2);
    }

    public List<T> getList() {
        return this.f6460b;
    }

    public final int h() {
        return this.f6466h != null ? 1 : 0;
    }

    public final View i(ViewGroup viewGroup, @LayoutRes int i2) {
        return LayoutInflater.from(viewGroup.getContext()).inflate(i2, viewGroup, false);
    }

    public final void initListData(List<T> list) {
        this.f6460b.clear();
        if (list != null && !list.isEmpty()) {
            this.f6460b.addAll(list);
        }
        this.m = true;
        notifyDataSetChanged();
    }

    public boolean isScrolling() {
        return this.f6459a;
    }

    public boolean isShowFooterView() {
        return this.f6463e;
    }

    public final int n(int i2) {
        if (this.f6463e && i2 == getItemCount() - 1) {
            return 39321;
        }
        return super.getItemViewType(i2);
    }

    public int o(int i2) {
        if (this.f6466h == null || i2 != 0) {
            return n(i2);
        }
        return 26214;
    }

    public final void recyclerData() {
        this.f6460b.clear();
    }

    public final void removeHeadView() {
        LinearLayout linearLayout = this.f6466h;
        if (linearLayout != null) {
            linearLayout.removeAllViews();
        }
    }

    public void setDefaultLastPosition(int i2) {
        this.f6465g = i2;
    }

    public void setEmptyIconResId(int i2) {
        this.l = i2;
    }

    public final void setEmptyMsgTextColor(@ColorRes int i2) {
        this.k = i2;
    }

    public void setEmptyTipMsg(String str) {
        this.j = str;
    }

    public final void setFirstLastPosition(int i2, int i3) {
        this.f6464f = i2;
        this.f6465g = i3;
        this.m = true;
        notifyDataSetChanged();
    }

    public void setIsShowFooterView(boolean z) {
        this.f6463e = z;
        View view = this.f6467i;
        if (view != null) {
            view.setVisibility(z ? 0 : 8);
        }
    }

    public final void setOnClickListener(View.OnClickListener onClickListener) {
        this.f6461c = onClickListener;
    }

    public final void setOnItemClickListener(a aVar) {
        this.f6462d = aVar;
    }

    public void setScrolling(boolean z) {
        this.f6459a = z;
    }

    public final void addDataToList(T t, int i2) {
        if (t != null) {
            this.f6460b.add(i2, t);
            this.m = true;
            notifyDataSetChanged();
        }
    }
}
