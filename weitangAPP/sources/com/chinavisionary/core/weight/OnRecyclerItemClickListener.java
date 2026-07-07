package com.chinavisionary.core.weight;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.GestureDetectorCompat;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes.dex */
public abstract class OnRecyclerItemClickListener implements RecyclerView.OnItemTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public GestureDetectorCompat f6722a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public RecyclerView f6723b;

    public class b extends GestureDetector.SimpleOnGestureListener {
        public b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            View viewFindChildViewUnder = OnRecyclerItemClickListener.this.f6723b.findChildViewUnder(motionEvent.getX(), motionEvent.getY());
            if (viewFindChildViewUnder != null) {
                OnRecyclerItemClickListener.this.onItemLongClick(OnRecyclerItemClickListener.this.f6723b.getChildViewHolder(viewFindChildViewUnder));
            }
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            View viewFindChildViewUnder = OnRecyclerItemClickListener.this.f6723b.findChildViewUnder(motionEvent.getX(), motionEvent.getY());
            if (viewFindChildViewUnder == null) {
                return true;
            }
            OnRecyclerItemClickListener.this.onItemClick(OnRecyclerItemClickListener.this.f6723b.getChildViewHolder(viewFindChildViewUnder));
            return true;
        }
    }

    public OnRecyclerItemClickListener(RecyclerView recyclerView) {
        this.f6723b = recyclerView;
        this.f6722a = new GestureDetectorCompat(recyclerView.getContext(), new b());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        this.f6722a.onTouchEvent(motionEvent);
        return false;
    }

    public abstract void onItemClick(RecyclerView.ViewHolder viewHolder);

    public abstract void onItemLongClick(RecyclerView.ViewHolder viewHolder);

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public void onRequestDisallowInterceptTouchEvent(boolean z) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        this.f6722a.onTouchEvent(motionEvent);
    }
}
