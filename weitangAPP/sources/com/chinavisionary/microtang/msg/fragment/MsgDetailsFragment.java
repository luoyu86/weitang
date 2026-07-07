package com.chinavisionary.microtang.msg.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import c.e.a.d.n;
import c.e.a.d.x;
import com.alibaba.fastjson.JSON;
import com.chinavisionary.core.app.base.CoreBaseFragment;
import com.chinavisionary.core.weight.CoreRoundedImageView;
import com.chinavisionary.framework.mobile.common.vo.ResourceVo;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseFragment;
import com.chinavisionary.microtang.msg.vo.MsgVo;
import com.lzy.ninegrid.preview.ImagePreviewActivity;
import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class MsgDetailsFragment extends BaseFragment<String> {
    public MsgVo B;

    @BindView(R.id.img_msg_cover)
    public CoreRoundedImageView mImageView;

    @BindView(R.id.tv_msg_content)
    public TextView mMsgContentTv;

    @BindView(R.id.tv_title_split_line)
    public TextView mSplitLineTv;

    @BindView(R.id.tv_msg_title)
    public TextView mTitleMsgTv;

    @BindView(R.id.tv_title)
    public TextView mTitleTv;

    public static MsgDetailsFragment getInstance(String str) {
        MsgDetailsFragment msgDetailsFragment = new MsgDetailsFragment();
        msgDetailsFragment.setArguments(CoreBaseFragment.q(str));
        return msgDetailsFragment;
    }

    public final void E1(int i2) {
        Intent intent = new Intent(this.f6487e, (Class<?>) ImagePreviewActivity.class);
        Bundle bundle = new Bundle();
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.B.getResourceVo());
        bundle.putSerializable("IMAGE_INFO", (Serializable) n.getImageInfo(arrayList));
        bundle.putInt("CURRENT_ITEM", i2);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
        E1(0);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        this.mTitleTv.setText(R.string.title_msg_details);
        this.mSplitLineTv.setVisibility(0);
        MsgVo msgVo = (MsgVo) JSON.parseObject(this.f6484b, MsgVo.class);
        this.B = msgVo;
        this.mTitleMsgTv.setText(x.getNotNullStr(msgVo.getTitle(), ""));
        this.mMsgContentTv.setText(x.getNotNullStr(this.B.getContent(), ""));
        ResourceVo resourceVo = this.B.getResourceVo();
        if (resourceVo != null) {
            this.mImageView.setOnClickListener(this.y);
            this.mImageView.setVisibility(0);
            this.mImageView.loadImageToUrl(resourceVo.getUrl());
        }
    }

    @OnClick({R.id.tv_back})
    public void backClick(View view) {
        n();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_msg_details;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void j0() {
    }
}
