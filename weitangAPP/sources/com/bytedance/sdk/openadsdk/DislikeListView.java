package com.bytedance.sdk.openadsdk;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import c.d.a.a.a.a.a;
import c.d.a.a.a.a.b;
import com.bykv.vk.openvk.api.proto.EventListener;

/* JADX INFO: loaded from: classes.dex */
public class DislikeListView extends ListView {
    private EventListener mOnItemClickBridge;
    private AdapterView.OnItemClickListener mOnItemClickListener;
    private AdapterView.OnItemClickListener mOnItemClickListenerInner;

    public DislikeListView(Context context) {
        super(context);
        this.mOnItemClickListenerInner = new AdapterView.OnItemClickListener() { // from class: com.bytedance.sdk.openadsdk.DislikeListView.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
                if (DislikeListView.this.getAdapter() == null || DislikeListView.this.getAdapter().getItem(i2) == null || !(DislikeListView.this.getAdapter().getItem(i2) instanceof FilterWord)) {
                    throw new IllegalArgumentException("adapter数据异常，必须为FilterWord");
                }
                FilterWord filterWord = (FilterWord) DislikeListView.this.getAdapter().getItem(i2);
                if (filterWord.hasSecondOptions()) {
                    return;
                }
                if (DislikeListView.this.mOnItemClickListener != null) {
                    DislikeListView.this.mOnItemClickListener.onItemClick(adapterView, view, i2, j);
                }
                if (DislikeListView.this.mOnItemClickBridge != null) {
                    DislikeListView.this.mOnItemClickBridge.onEvent(0, b.ok().ok(a.ok().ok(0, filterWord.getId()).ok(1, filterWord.getName()).a()).a());
                }
            }
        };
        init();
    }

    private void init() {
        super.setOnItemClickListener(this.mOnItemClickListenerInner);
    }

    @Override // android.widget.AdapterView
    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        if (onItemClickListener instanceof EventListener) {
            this.mOnItemClickBridge = (EventListener) onItemClickListener;
        } else {
            this.mOnItemClickListener = onItemClickListener;
        }
    }

    public DislikeListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mOnItemClickListenerInner = new AdapterView.OnItemClickListener() { // from class: com.bytedance.sdk.openadsdk.DislikeListView.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
                if (DislikeListView.this.getAdapter() == null || DislikeListView.this.getAdapter().getItem(i2) == null || !(DislikeListView.this.getAdapter().getItem(i2) instanceof FilterWord)) {
                    throw new IllegalArgumentException("adapter数据异常，必须为FilterWord");
                }
                FilterWord filterWord = (FilterWord) DislikeListView.this.getAdapter().getItem(i2);
                if (filterWord.hasSecondOptions()) {
                    return;
                }
                if (DislikeListView.this.mOnItemClickListener != null) {
                    DislikeListView.this.mOnItemClickListener.onItemClick(adapterView, view, i2, j);
                }
                if (DislikeListView.this.mOnItemClickBridge != null) {
                    DislikeListView.this.mOnItemClickBridge.onEvent(0, b.ok().ok(a.ok().ok(0, filterWord.getId()).ok(1, filterWord.getName()).a()).a());
                }
            }
        };
        init();
    }

    public DislikeListView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mOnItemClickListenerInner = new AdapterView.OnItemClickListener() { // from class: com.bytedance.sdk.openadsdk.DislikeListView.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i22, long j) {
                if (DislikeListView.this.getAdapter() == null || DislikeListView.this.getAdapter().getItem(i22) == null || !(DislikeListView.this.getAdapter().getItem(i22) instanceof FilterWord)) {
                    throw new IllegalArgumentException("adapter数据异常，必须为FilterWord");
                }
                FilterWord filterWord = (FilterWord) DislikeListView.this.getAdapter().getItem(i22);
                if (filterWord.hasSecondOptions()) {
                    return;
                }
                if (DislikeListView.this.mOnItemClickListener != null) {
                    DislikeListView.this.mOnItemClickListener.onItemClick(adapterView, view, i22, j);
                }
                if (DislikeListView.this.mOnItemClickBridge != null) {
                    DislikeListView.this.mOnItemClickBridge.onEvent(0, b.ok().ok(a.ok().ok(0, filterWord.getId()).ok(1, filterWord.getName()).a()).a());
                }
            }
        };
        init();
    }
}
