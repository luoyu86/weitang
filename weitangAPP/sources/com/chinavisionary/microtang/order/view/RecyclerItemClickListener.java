package com.chinavisionary.microtang.order.view;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes.dex */
public class RecyclerItemClickListener implements RecyclerView.OnItemTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public GestureDetector f8126a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f8127b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public RecyclerView f8128c;

    public class a extends GestureDetector.SimpleOnGestureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f8129a;

        public a(b bVar) {
            this.f8129a = bVar;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            b bVar;
            if (RecyclerItemClickListener.this.f8127b == null || (bVar = this.f8129a) == null) {
                return;
            }
            bVar.onLongClick(RecyclerItemClickListener.this.f8127b, RecyclerItemClickListener.this.f8128c.getChildPosition(RecyclerItemClickListener.this.f8127b));
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            b bVar;
            if (RecyclerItemClickListener.this.f8127b == null || (bVar = this.f8129a) == null) {
                return true;
            }
            bVar.onItemClick(RecyclerItemClickListener.this.f8127b, RecyclerItemClickListener.this.f8128c.getChildPosition(RecyclerItemClickListener.this.f8127b));
            return true;
        }
    }

    public interface b {
        void onItemClick(View view, int i2);

        void onLongClick(View view, int i2);
    }

    public RecyclerItemClickListener(Context context, b bVar) {
        this.f8126a = new GestureDetector(context, new a(bVar));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        this.f8126a.onTouchEvent(motionEvent);
        this.f8127b = recyclerView.findChildViewUnder(motionEvent.getX(), motionEvent.getY());
        this.f8128c = recyclerView;
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public void onRequestDisallowInterceptTouchEvent(boolean z) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
    }
}
