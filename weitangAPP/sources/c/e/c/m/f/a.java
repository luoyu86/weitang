package c.e.c.m.f;

import com.hedgehog.ratingbar.RatingBar;

/* JADX INFO: loaded from: classes.dex */
public class a implements RatingBar.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f1666a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c.e.c.m.d.a f1667b;

    public a(c.e.c.m.d.a aVar) {
        this.f1667b = aVar;
    }

    @Override // com.hedgehog.ratingbar.RatingBar.b
    public void onRatingChange(float f2) {
        this.f1667b.onRagingBarCallback(this.f1666a, f2);
    }

    public void setType(String str) {
        this.f1666a = str;
    }
}
