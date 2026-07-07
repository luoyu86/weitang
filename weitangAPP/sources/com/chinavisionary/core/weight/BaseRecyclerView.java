package com.chinavisionary.core.weight;

import android.content.Context;
import android.os.Vibrator;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chinavisionary.core.app.adapter.BaseRecyclerAdapter;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class BaseRecyclerView extends RecyclerView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public BaseRecyclerAdapter f6677a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ItemTouchHelper f6678b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public f f6679c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f6680d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f6681e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public d f6682f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public e f6683g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public OnRecyclerItemClickListener f6684h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public RecyclerView.OnScrollListener f6685i;

    public class a extends OnRecyclerItemClickListener {
        public a(RecyclerView recyclerView) {
            super(recyclerView);
        }

        @Override // com.chinavisionary.core.weight.OnRecyclerItemClickListener
        public void onItemClick(RecyclerView.ViewHolder viewHolder) {
        }

        @Override // com.chinavisionary.core.weight.OnRecyclerItemClickListener
        public void onItemLongClick(RecyclerView.ViewHolder viewHolder) {
            if (viewHolder.getLayoutPosition() != BaseRecyclerView.this.f6680d) {
                BaseRecyclerView.this.f6678b.startDrag(viewHolder);
                ((Vibrator) BaseRecyclerView.this.getContext().getSystemService("vibrator")).vibrate(70L);
            }
        }
    }

    public class b extends ItemTouchHelper.Callback {
        public b() {
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            super.clearView(recyclerView, viewHolder);
            viewHolder.itemView.setBackgroundColor(0);
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            return recyclerView.getLayoutManager() instanceof GridLayoutManager ? ItemTouchHelper.Callback.makeMovementFlags(15, 0) : ItemTouchHelper.Callback.makeMovementFlags(3, 0);
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public boolean isLongPressDragEnabled() {
            return false;
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2) {
            int adapterPosition = viewHolder.getAdapterPosition();
            int adapterPosition2 = viewHolder2.getAdapterPosition();
            if (adapterPosition == BaseRecyclerView.this.f6680d || adapterPosition2 == BaseRecyclerView.this.f6680d) {
                return true;
            }
            BaseRecyclerView.this.i(adapterPosition, adapterPosition2);
            return true;
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int i2) {
            if (i2 != 0) {
                viewHolder.itemView.setBackgroundColor(-3355444);
            }
            super.onSelectedChanged(viewHolder, i2);
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public void onSwiped(RecyclerView.ViewHolder viewHolder, int i2) {
        }
    }

    public class c extends RecyclerView.OnScrollListener {
        public c() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            super.onScrollStateChanged(recyclerView, i2);
            if (BaseRecyclerView.this.f6679c != null) {
                if (i2 == 0) {
                    BaseRecyclerView.this.f();
                } else if (i2 == 1 && BaseRecyclerView.this.f6679c != null) {
                    BaseRecyclerView.this.f6679c.onStartScroll();
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            super.onScrolled(recyclerView, i2, i3);
            if (BaseRecyclerView.this.f6679c != null) {
                BaseRecyclerView.this.f6679c.onStartScroll(i2, i3);
            }
        }
    }

    public interface d {
        void upMove();
    }

    public interface e {
        void swapPosition(int i2, int i3);
    }

    public interface f {
        void onLoadFirstAndLastPosition(int i2, int i3);

        void onLoadMore();

        void onRefresh();

        void onStartScroll();

        void onStartScroll(int i2, int i3);

        void onStopScroll();
    }

    public BaseRecyclerView(Context context) {
        super(context);
        this.f6680d = -1;
        this.f6684h = new a(this);
        this.f6685i = new c();
        h();
    }

    public final void f() {
        f fVar = this.f6679c;
        if (fVar != null) {
            fVar.onStopScroll();
            RecyclerView.LayoutManager layoutManager = getLayoutManager();
            if (layoutManager == null || layoutManager.getItemCount() <= 0) {
                return;
            }
            int[] position = getPosition();
            int i2 = position[0];
            int i3 = position[1];
            this.f6679c.onLoadFirstAndLastPosition(i2, i3);
            if (layoutManager.getItemCount() - 1 == i3) {
                this.f6679c.onLoadMore();
            }
        }
    }

    public final void g() {
        if (this.f6678b != null) {
            return;
        }
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new b());
        this.f6678b = itemTouchHelper;
        itemTouchHelper.attachToRecyclerView(this);
    }

    public f getOnRecyclerScrollListener() {
        return this.f6679c;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0045  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int[] getPosition() {
        /*
            r4 = this;
            androidx.recyclerview.widget.RecyclerView$LayoutManager r0 = r4.getLayoutManager()
            r1 = 0
            if (r0 == 0) goto L45
            int r2 = r0.getItemCount()
            if (r2 <= 0) goto L45
            boolean r2 = r0 instanceof androidx.recyclerview.widget.LinearLayoutManager
            if (r2 == 0) goto L1c
            androidx.recyclerview.widget.LinearLayoutManager r0 = (androidx.recyclerview.widget.LinearLayoutManager) r0
            int r2 = r0.findFirstVisibleItemPosition()
            int r0 = r0.findLastVisibleItemPosition()
            goto L47
        L1c:
            boolean r2 = r0 instanceof androidx.recyclerview.widget.GridLayoutManager
            if (r2 == 0) goto L2b
            androidx.recyclerview.widget.GridLayoutManager r0 = (androidx.recyclerview.widget.GridLayoutManager) r0
            int r2 = r0.findFirstVisibleItemPosition()
            int r0 = r0.findLastVisibleItemPosition()
            goto L47
        L2b:
            boolean r2 = r0 instanceof androidx.recyclerview.widget.StaggeredGridLayoutManager
            if (r2 == 0) goto L45
            androidx.recyclerview.widget.StaggeredGridLayoutManager r0 = (androidx.recyclerview.widget.StaggeredGridLayoutManager) r0
            r2 = 0
            int[] r3 = r0.findFirstVisibleItemPositions(r2)
            int[] r0 = r0.findLastVisibleItemPositions(r2)
            int r2 = r3.length
            if (r2 <= 0) goto L45
            int r2 = r0.length
            if (r2 <= 0) goto L45
            r2 = r3[r1]
            r0 = r0[r1]
            goto L47
        L45:
            r0 = 0
            r2 = 0
        L47:
            r3 = 2
            int[] r3 = new int[r3]
            r3[r1] = r2
            r1 = 1
            r3[r1] = r0
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chinavisionary.core.weight.BaseRecyclerView.getPosition():int[]");
    }

    public final void h() {
        addOnScrollListener(this.f6685i);
        setLayoutManager(new LinearLayoutManager(getContext()));
        ((DefaultItemAnimator) getItemAnimator()).setSupportsChangeAnimations(false);
    }

    public final void i(int i2, int i3) {
        List list = this.f6677a.getList();
        if (i2 < i3) {
            int i4 = i2;
            while (i4 < i3) {
                int i5 = i4 + 1;
                Collections.swap(list, i4, i5);
                i4 = i5;
            }
        } else {
            for (int i6 = i2; i6 > i3; i6--) {
                Collections.swap(list, i6, i6 - 1);
            }
        }
        e eVar = this.f6683g;
        if (eVar != null) {
            eVar.swapPosition(i2, i3);
        }
        this.f6677a.notifyItemMoved(i2, i3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f6681e = (int) motionEvent.getY();
        } else if (actionMasked == 2) {
            int y = (int) motionEvent.getY();
            d dVar = this.f6682f;
            if (dVar != null && this.f6681e > y) {
                dVar.upMove();
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setAdapter(RecyclerView.Adapter adapter) {
        super.setAdapter(adapter);
        this.f6677a = (BaseRecyclerAdapter) adapter;
    }

    public void setEnableItemDrag(boolean z) {
        if (!z) {
            removeOnItemTouchListener(this.f6684h);
        } else {
            g();
            addOnItemTouchListener(this.f6684h);
        }
    }

    public void setIOnRecyclerMove(d dVar) {
        this.f6682f = dVar;
    }

    public void setIOnRecyclerSwapCallback(e eVar) {
        this.f6683g = eVar;
    }

    public void setOnRecyclerScrollListener(f fVar) {
        this.f6679c = fVar;
    }

    public void setSkipPosition(int i2) {
        this.f6680d = i2;
    }

    public BaseRecyclerView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6680d = -1;
        this.f6684h = new a(this);
        this.f6685i = new c();
        h();
    }
}
