package c.e.c.m.f;

import c.e.a.d.o;
import c.e.a.d.x;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.comment.vo.CommentDetailsScoreVo;
import com.chinavisionary.microtang.comment.vo.CommentDetailsVo;
import com.chinavisionary.microtang.comment.vo.CreateCommentBo;
import com.chinavisionary.microtang.comment.vo.CreateCommentResponseVo;
import com.chinavisionary.microtang.comment.vo.CreateCommentScoresBo;
import com.chinavisionary.microtang.comment.vo.OptionItemVo;
import com.chinavisionary.microtang.comment.vo.ScoresBean;
import com.chinavisionary.microtang.order.vo.KeyValueVo;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class c {
    public final c.e.c.m.g.a a(CommentDetailsScoreVo commentDetailsScoreVo, int i2) {
        c.e.c.m.g.a aVar = new c.e.c.m.g.a();
        aVar.setItemType(i2);
        aVar.setScoresBean(commentDetailsScoreVo);
        return aVar;
    }

    public final c.e.c.m.g.a b(ScoresBean scoresBean, int i2) {
        c.e.c.m.g.a aVar = new c.e.c.m.g.a();
        aVar.setItemType(i2);
        aVar.setScoresBean(scoresBean);
        return aVar;
    }

    public final String c(List<OptionItemVo> list) {
        if (!o.isNotEmpty(list)) {
            return null;
        }
        for (OptionItemVo optionItemVo : list) {
            if (optionItemVo != null && optionItemVo.isIfSelect()) {
                return optionItemVo.getKey();
            }
        }
        return null;
    }

    public final CreateCommentScoresBo d(ScoresBean scoresBean) {
        CreateCommentScoresBo createCommentScoresBo = new CreateCommentScoresBo();
        createCommentScoresBo.setType(scoresBean.getType());
        createCommentScoresBo.setScoreType(scoresBean.getScoreType());
        String strC = c(scoresBean.getOptions());
        if (strC != null) {
            try {
                createCommentScoresBo.setScore(Float.valueOf(Float.parseFloat(strC)));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return createCommentScoresBo;
    }

    public final CreateCommentScoresBo e(ScoresBean scoresBean) {
        CreateCommentScoresBo createCommentScoresBo = new CreateCommentScoresBo();
        createCommentScoresBo.setType(scoresBean.getType());
        createCommentScoresBo.setScoreType(scoresBean.getScoreType());
        createCommentScoresBo.setScore(Float.valueOf(scoresBean.getScore()));
        return createCommentScoresBo;
    }

    public CreateCommentBo getSubmitData(List<c.e.c.m.g.a> list) {
        CreateCommentBo createCommentBo = new CreateCommentBo();
        ArrayList arrayList = new ArrayList();
        createCommentBo.setScores(arrayList);
        String strAppendStringToResId = null;
        if (o.isNotEmpty(list)) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                c.e.c.m.g.a aVar = list.get(i2);
                if (aVar != null) {
                    ScoresBean scoresBean = aVar.getScoresBean();
                    int itemType = aVar.getItemType();
                    if (itemType == 1) {
                        CreateCommentScoresBo createCommentScoresBoD = d(scoresBean);
                        arrayList.add(createCommentScoresBoD);
                        if (createCommentScoresBoD.getScore() == null && strAppendStringToResId == null) {
                            strAppendStringToResId = x.appendStringToResId(R.string.placeholder_comment_empty_tip, String.valueOf(i2));
                        }
                    } else if (itemType == 2) {
                        arrayList.add(e(scoresBean));
                        if (scoresBean.getScore() == 0.0f && strAppendStringToResId == null) {
                            strAppendStringToResId = x.appendStringToResId(R.string.placeholder_comment_empty_tip, String.valueOf(i2));
                        }
                    } else if (itemType == 3) {
                        arrayList.add(e(scoresBean));
                    } else if (itemType == 4) {
                        createCommentBo.setContent(scoresBean.getInputContent());
                    }
                }
            }
        }
        createCommentBo.setTipMsg(strAppendStringToResId);
        return createCommentBo;
    }

    public List<c.e.c.m.g.a> handleCommentDetailsVo(CommentDetailsVo commentDetailsVo) {
        ArrayList arrayList = new ArrayList();
        List<KeyValueVo> address = commentDetailsVo.getAddress();
        if (o.isNotEmpty(address)) {
            for (KeyValueVo keyValueVo : address) {
                if (keyValueVo != null) {
                    c.e.c.m.g.a aVar = new c.e.c.m.g.a();
                    aVar.setItemType(7);
                    aVar.setKeyValueVo(keyValueVo);
                    arrayList.add(aVar);
                }
            }
        }
        List<CommentDetailsScoreVo> scores = commentDetailsVo.getScores();
        boolean z = true;
        if (o.isNotEmpty(scores)) {
            boolean z2 = true;
            for (CommentDetailsScoreVo commentDetailsScoreVo : scores) {
                if (commentDetailsScoreVo != null && x.isNotNull(commentDetailsScoreVo.getType())) {
                    commentDetailsScoreVo.setHasEdit(false);
                    String type = commentDetailsScoreVo.getType();
                    if (ScoresBean.SCORE_TYPE_SCORE.equals(type)) {
                        arrayList.add(a(commentDetailsScoreVo, 2));
                    }
                    if (ScoresBean.SCORE_TYPE_RADIO.equals(type)) {
                        arrayList.add(a(commentDetailsScoreVo, 1));
                    }
                    if (ScoresBean.SCORE_TYPE_INPUT.equals(type)) {
                        arrayList.add(a(commentDetailsScoreVo, 4));
                        z2 = false;
                    }
                    if ("tag".equals(type)) {
                        arrayList.add(a(commentDetailsScoreVo, 5));
                    }
                    if (ScoresBean.SCORE_TYPE_SLIDER.equals(type)) {
                        arrayList.add(a(commentDetailsScoreVo, 3));
                    }
                }
            }
            z = z2;
        }
        if (z) {
            ScoresBean scoresBean = new ScoresBean();
            scoresBean.setHasEdit(false);
            scoresBean.setInputContent(commentDetailsVo.getContent());
            scoresBean.setScoreTypeDesc(x.getString(R.string.title_other_comment_content));
            arrayList.add(b(scoresBean, 4));
        }
        return arrayList;
    }

    public List<c.e.c.m.g.a> handleNewCreateComment(CreateCommentResponseVo createCommentResponseVo) {
        ArrayList arrayList = new ArrayList();
        List<KeyValueVo> address = createCommentResponseVo.getAddress();
        if (o.isNotEmpty(address)) {
            for (KeyValueVo keyValueVo : address) {
                if (keyValueVo != null) {
                    c.e.c.m.g.a aVar = new c.e.c.m.g.a();
                    aVar.setItemType(7);
                    aVar.setKeyValueVo(keyValueVo);
                    arrayList.add(aVar);
                }
            }
        }
        List<ScoresBean> scores = createCommentResponseVo.getScores();
        boolean z = true;
        if (o.isNotEmpty(scores)) {
            boolean z2 = true;
            for (ScoresBean scoresBean : scores) {
                if (scoresBean != null && x.isNotNull(scoresBean.getType())) {
                    String type = scoresBean.getType();
                    if (ScoresBean.SCORE_TYPE_SCORE.equals(type)) {
                        arrayList.add(b(scoresBean, 2));
                    }
                    if (ScoresBean.SCORE_TYPE_RADIO.equals(type)) {
                        arrayList.add(b(scoresBean, 1));
                    }
                    if (ScoresBean.SCORE_TYPE_INPUT.equals(type)) {
                        z2 = false;
                        arrayList.add(b(scoresBean, 4));
                    }
                    if ("tag".equals(type)) {
                        arrayList.add(b(scoresBean, 5));
                    }
                    if (ScoresBean.SCORE_TYPE_SLIDER.equals(type)) {
                        scoresBean.setScore(10.0f);
                        arrayList.add(b(scoresBean, 3));
                    }
                }
            }
            z = z2;
        }
        if (z) {
            ScoresBean scoresBean2 = new ScoresBean();
            scoresBean2.setScoreTypeDesc(x.getString(R.string.title_other_comment_content));
            arrayList.add(b(scoresBean2, 4));
        }
        return arrayList;
    }
}
