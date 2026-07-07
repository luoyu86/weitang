package c.e.c.m.f;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.e.a.d.o;
import c.e.a.d.q;
import c.e.a.d.x;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.comment.vo.CommentDetailsScoreVo;
import com.chinavisionary.microtang.comment.vo.ScoresBean;
import com.chinavisionary.microtang.order.vo.KeyValueVo;
import com.hedgehog.ratingbar.RatingBar;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, TextView> f1668a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, RatingBar> f1669b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<RatingBar> f1670c = new ArrayList();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public c.e.c.m.d.a f1671d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Drawable f1672e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Drawable f1673f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Drawable f1674g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Drawable f1675h;

    public final void a(RatingBar ratingBar, float f2) {
        if (f2 <= 1.0f) {
            ratingBar.setStarFillDrawable(this.f1673f);
        } else if (f2 >= 2.0f && f2 <= 3.0f) {
            ratingBar.setStarFillDrawable(this.f1675h);
        } else if (f2 >= 3.0f) {
            ratingBar.setStarFillDrawable(this.f1672e);
        }
        ratingBar.setStar(f2);
        ratingBar.requestLayout();
        ratingBar.invalidate();
        q.d("CreateCommentHandle", "updateRatingIcon ratingCount = " + f2);
    }

    public Map<String, TextView> getTypeTextViewMap() {
        return this.f1668a;
    }

    public String getValueToRecommendScore(float f2) {
        return f2 == 1.0f ? x.getString(R.string.title_very_not_recommend) : f2 == 2.0f ? x.getString(R.string.title_not_recommend) : f2 == 3.0f ? x.getString(R.string.title_commonly) : f2 == 4.0f ? x.getString(R.string.title_a_need_recommend) : f2 == 5.0f ? x.getString(R.string.title_need_recommend) : "";
    }

    public String getValueToScore(float f2) {
        return f2 <= 1.0f ? x.getString(R.string.title_very_difference) : f2 <= 2.0f ? x.getString(R.string.title_difference) : f2 <= 3.0f ? x.getString(R.string.title_commonly) : f2 <= 4.0f ? x.getString(R.string.title_good) : f2 <= 5.0f ? x.getString(R.string.title_very_good) : "";
    }

    public void handleOneKeyPraise() {
        if (this.f1670c.isEmpty()) {
            return;
        }
        Iterator<RatingBar> it = this.f1670c.iterator();
        while (it.hasNext()) {
            it.next().setStar(5.0f);
        }
        Iterator<Map.Entry<String, TextView>> it2 = this.f1668a.entrySet().iterator();
        while (it2.hasNext()) {
            this.f1671d.onRagingBarCallback(it2.next().getKey(), 5.0f);
        }
    }

    public void setupActivityScore(List<ScoresBean> list, LayoutInflater layoutInflater, LinearLayout linearLayout, c.e.c.m.d.a aVar, boolean z) {
        this.f1674g = linearLayout.getResources().getDrawable(R.mipmap.ic_activity_comment_normal);
        this.f1672e = linearLayout.getResources().getDrawable(R.mipmap.ic_activity_comment_good);
        this.f1673f = linearLayout.getResources().getDrawable(R.mipmap.ic_activity_comment_low);
        this.f1675h = linearLayout.getResources().getDrawable(R.mipmap.ic_activity_comment_normal_good);
        linearLayout.removeAllViews();
        this.f1668a.clear();
        this.f1669b.clear();
        this.f1671d = aVar;
        for (ScoresBean scoresBean : list) {
            if (scoresBean != null) {
                View viewInflate = layoutInflater.inflate(R.layout.item_activity_comment_score_layout, (ViewGroup) linearLayout, false);
                TextView textView = (TextView) viewInflate.findViewById(R.id.tv_product_service_satisfied);
                RatingBar ratingBar = (RatingBar) viewInflate.findViewById(R.id.rating_bar_service_satisfied);
                TextView textView2 = (TextView) viewInflate.findViewById(R.id.tv_tip_commend_level);
                ratingBar.setTag(scoresBean.getScoreType());
                ratingBar.setmClickable(z);
                ratingBar.setStarEmptyDrawable(this.f1674g);
                if (z) {
                    a aVar2 = new a(aVar);
                    aVar2.setType(scoresBean.getScoreType());
                    ratingBar.setOnRatingChangeListener(aVar2);
                } else {
                    float score = scoresBean.getScore();
                    ratingBar.setStar(score);
                    a(ratingBar, score);
                }
                this.f1669b.put(scoresBean.getScoreType(), ratingBar);
                textView.setText(scoresBean.getScoreTypeDesc());
                linearLayout.addView(viewInflate);
                this.f1668a.put(scoresBean.getScoreType(), textView2);
            }
        }
    }

    public void setupCommentScore(List<CommentDetailsScoreVo> list, LayoutInflater layoutInflater, LinearLayout linearLayout) {
        ArrayList arrayList = new ArrayList();
        for (CommentDetailsScoreVo commentDetailsScoreVo : list) {
            if (commentDetailsScoreVo != null) {
                ScoresBean scoresBean = new ScoresBean();
                scoresBean.setScore(commentDetailsScoreVo.getScore());
                scoresBean.setScoreType(commentDetailsScoreVo.getScoreType());
                scoresBean.setScoreTypeDesc(commentDetailsScoreVo.getScoreTypeDesc());
                scoresBean.setScoreTypeName(commentDetailsScoreVo.getScoreTypeName());
                scoresBean.setScoreTypeContent(commentDetailsScoreVo.getScoreTypeContent());
                arrayList.add(scoresBean);
            }
        }
        setupScore(arrayList, layoutInflater, linearLayout, null, false);
    }

    public void setupInfo(List<KeyValueVo> list, LayoutInflater layoutInflater, LinearLayout linearLayout) {
        linearLayout.removeAllViews();
        if (o.isNotEmpty(list)) {
            for (KeyValueVo keyValueVo : list) {
                if (keyValueVo != null) {
                    View viewInflate = layoutInflater.inflate(R.layout.item_commend_address, (ViewGroup) linearLayout, false);
                    TextView textView = (TextView) viewInflate.findViewById(R.id.tv_room_address);
                    TextView textView2 = (TextView) viewInflate.findViewById(R.id.tv_room_address_value);
                    textView.setText(x.getNotNullStr(keyValueVo.getKey(), ""));
                    textView2.setText(x.getNotNullStr(keyValueVo.getValue(), ""));
                    linearLayout.addView(viewInflate);
                }
            }
        }
    }

    public void setupScore(List<ScoresBean> list, LayoutInflater layoutInflater, LinearLayout linearLayout, c.e.c.m.d.a aVar, boolean z) {
        linearLayout.removeAllViews();
        this.f1674g = linearLayout.getResources().getDrawable(R.mipmap.ic_activity_comment_normal);
        this.f1672e = linearLayout.getResources().getDrawable(R.mipmap.ic_activity_comment_good);
        this.f1673f = linearLayout.getResources().getDrawable(R.mipmap.ic_activity_comment_low);
        this.f1675h = linearLayout.getResources().getDrawable(R.mipmap.ic_activity_comment_normal_good);
        this.f1668a.clear();
        this.f1670c.clear();
        this.f1671d = aVar;
        for (ScoresBean scoresBean : list) {
            if (scoresBean != null) {
                View viewInflate = layoutInflater.inflate(R.layout.item_title_score_layout, (ViewGroup) linearLayout, false);
                TextView textView = (TextView) viewInflate.findViewById(R.id.tv_product_service_satisfied);
                RatingBar ratingBar = (RatingBar) viewInflate.findViewById(R.id.rating_bar_service_satisfied);
                TextView textView2 = (TextView) viewInflate.findViewById(R.id.tv_tip_commend_level);
                TextView textView3 = (TextView) viewInflate.findViewById(R.id.tv_service_info);
                ratingBar.setTag(scoresBean.getScoreType());
                ratingBar.setStarEmptyDrawable(this.f1674g);
                this.f1670c.add(ratingBar);
                if (z) {
                    a aVar2 = new a(aVar);
                    aVar2.setType(scoresBean.getScoreType());
                    ratingBar.setOnRatingChangeListener(aVar2);
                } else {
                    float score = scoresBean.getScore();
                    ratingBar.setStar(score);
                    a(ratingBar, score);
                    textView2.setText(getValueToScore(score));
                }
                textView.setText(scoresBean.getScoreTypeDesc());
                textView3.setText(scoresBean.getScoreTypeContent());
                textView3.setVisibility(x.isNotNull(scoresBean.getScoreTypeContent()) ? 0 : 8);
                linearLayout.addView(viewInflate);
                this.f1668a.put(scoresBean.getScoreType(), textView2);
            }
        }
    }

    public void updateRatingIcon(String str, float f2) {
        if (this.f1669b.containsKey(str)) {
            a(this.f1669b.get(str), f2);
        }
    }
}
