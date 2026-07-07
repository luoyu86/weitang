package com.tianmu.ad.base;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.tianmu.utils.TianmuLogUtil;

/* JADX INFO: loaded from: classes2.dex */
public class BaseAdTouchView extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f10642a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f10643b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f10644c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f10645d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f10646e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f10647f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f10648g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f10649h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f10650i;
    private int j;
    private int k;
    private int l;

    public BaseAdTouchView(Context context) {
        super(context);
        this.f10642a = 0;
        this.f10643b = 0;
        this.f10644c = 0;
        this.f10645d = 0;
        this.f10646e = 0;
        this.f10647f = 0;
        this.f10648g = 0;
        this.f10649h = 0;
        this.f10650i = 0;
        this.j = 0;
        this.k = 0;
        this.l = 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent != null) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f10642a = (int) motionEvent.getX();
                this.f10643b = (int) motionEvent.getRawX();
                this.f10644c = (int) motionEvent.getY();
                this.f10645d = (int) motionEvent.getRawY();
            } else if (action == 1) {
                this.f10650i = (int) motionEvent.getX();
                this.j = (int) motionEvent.getRawX();
                this.k = (int) motionEvent.getY();
                this.l = (int) motionEvent.getRawY();
                TianmuLogUtil.iD("dispatchTouchEvent view coordinate : (" + this.f10642a + "," + this.f10644c + "," + this.f10650i + "," + this.k + ")");
                TianmuLogUtil.iD("dispatchTouchEvent screen coordinate : (" + this.f10643b + "," + this.f10645d + "," + this.j + "," + this.l + ")");
            } else if (action == 2 || action == 3) {
                this.f10646e = (int) motionEvent.getX();
                this.f10647f = (int) motionEvent.getRawX();
                this.f10648g = (int) motionEvent.getY();
                this.f10649h = (int) motionEvent.getRawY();
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public int getDownSX() {
        return this.f10643b;
    }

    public int getDownSY() {
        return this.f10645d;
    }

    public int getDownX() {
        return this.f10642a;
    }

    public int getDownY() {
        return this.f10644c;
    }

    public int getMoveSX() {
        return this.f10647f;
    }

    public int getMoveSY() {
        return this.f10649h;
    }

    public int getMoveX() {
        return this.f10646e;
    }

    public int getMoveY() {
        return this.f10648g;
    }

    public int getUpSX() {
        return this.j;
    }

    public int getUpSY() {
        return this.l;
    }

    public int getUpX() {
        return this.f10650i;
    }

    public int getUpY() {
        return this.k;
    }
}
