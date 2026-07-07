package c.j.a;

import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class c implements Cloneable {
    public n G;
    public o H;
    public View x;
    public View y;

    @ColorInt
    public int z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @ColorInt
    public int f2710a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @ColorInt
    public int f2711b = -16777216;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f2712c = -16777216;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @FloatRange(from = 0.0d, to = 1.0d)
    public float f2713d = 0.0f;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @FloatRange(from = 0.0d, to = 1.0d)
    public float f2714e = 0.0f;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f2715f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f2716g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public b f2717h = b.FLAG_SHOW_BAR;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f2718i = false;
    public boolean j = false;
    public boolean k = false;
    public boolean l = false;

    @FloatRange(from = 0.0d, to = 1.0d)
    public float m = 0.0f;

    @FloatRange(from = 0.0d, to = 1.0d)
    public float n = 0.0f;
    public boolean o = true;

    @ColorInt
    public int p = -16777216;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @ColorInt
    public int f2719q = -16777216;
    public Map<View, Map<Integer, Integer>> r = new HashMap();

    @FloatRange(from = 0.0d, to = 1.0d)
    public float s = 0.0f;

    @ColorInt
    public int t = 0;

    @ColorInt
    public int u = -16777216;

    @FloatRange(from = 0.0d, to = 1.0d)
    public float v = 0.0f;
    public boolean w = false;
    public boolean A = false;
    public boolean B = false;
    public int C = 18;
    public boolean D = true;
    public boolean E = true;
    public boolean F = true;

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public c clone() {
        try {
            return (c) super.clone();
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }
}
