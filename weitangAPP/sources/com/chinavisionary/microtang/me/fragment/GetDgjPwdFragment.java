package com.chinavisionary.microtang.me.fragment;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.os.Message;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import c.e.a.a.h.c;
import com.alibaba.fastjson.JSON;
import com.chinavisionary.core.app.base.CoreBaseFragment;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseFragment;
import com.chinavisionary.microtang.me.bo.DGJLoginResult;
import com.chinavisionary.microtang.me.bo.DGJPwdResultVo;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* JADX INFO: loaded from: classes.dex */
public class GetDgjPwdFragment extends BaseFragment {

    @BindView(R.id.tv_content)
    public TextView mPwdContentTv;

    @BindView(R.id.edt_sn)
    public EditText mSnEdt;

    public class a implements Callback {
        public a() {
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            iOException.printStackTrace();
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) throws IOException {
            ResponseBody responseBodyBody;
            if (response == null || !response.isSuccessful() || (responseBodyBody = response.body()) == null) {
                return;
            }
            String strString = responseBodyBody.string();
            GetDgjPwdFragment.this.i("jsonResult:" + strString);
            String client_id = ((DGJLoginResult) JSON.parseObject(strString, DGJLoginResult.class)).getData().getClient_id();
            GetDgjPwdFragment.this.i("jsonResult clientId:" + client_id);
            GetDgjPwdFragment.this.I1(client_id);
        }
    }

    public class b implements Callback {
        public b() {
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            iOException.printStackTrace();
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) throws IOException {
            ResponseBody responseBodyBody;
            if (response == null || !response.isSuccessful() || (responseBodyBody = response.body()) == null) {
                return;
            }
            GetDgjPwdFragment.this.J1(responseBodyBody.string());
        }
    }

    public static GetDgjPwdFragment getInstance() {
        return new GetDgjPwdFragment();
    }

    public final void I1(String str) {
        c.getInstance().requestGet("https://www.doormaster.me:9099/doormaster/users/userinfo/rid?client_id=" + str, new b());
    }

    public final void J1(String str) {
        i("jsonResult parseResult:" + str);
        H();
        List<DGJPwdResultVo.DataBean> data = ((DGJPwdResultVo) JSON.parseObject(str, DGJPwdResultVo.class)).getData();
        if (data != null) {
            String string = this.mSnEdt.getText().toString();
            c.e.e.a.s.c cVar = new c.e.e.a.s.c();
            Iterator<DGJPwdResultVo.DataBean> it = data.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                DGJPwdResultVo.DataBean next = it.next();
                String dev_sn = next.getDev_sn();
                if (string.equals(dev_sn)) {
                    cVar.setDevSn(dev_sn);
                    cVar.setDevMac(next.getDev_mac());
                    K1(cVar, next);
                    break;
                }
            }
            this.f6488f.obtainMessage(1, JSON.toJSONString(cVar)).sendToTarget();
        }
    }

    public final void K1(c.e.e.a.s.c cVar, DGJPwdResultVo.DataBean dataBean) {
        for (DGJPwdResultVo.DataBean.ReaderBean readerBean : dataBean.getReader()) {
            if (cVar.getDevSn().equals(readerBean.getReader_sn())) {
                cVar.setDevType(2);
                cVar.setOpenType(readerBean.getOpen_type());
                cVar.setPrivilege(readerBean.getPrivilege());
                cVar.setVerified(readerBean.getVerified());
                cVar.setUseCount(readerBean.getUse_count());
                cVar.setStartDate(readerBean.getStart_date());
                cVar.setEndDate(readerBean.getEnd_date());
                cVar.seteKey(readerBean.getEkey());
                return;
            }
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        this.f6488f = new CoreBaseFragment.c(this);
    }

    @OnClick({R.id.tv_back})
    public void backClick() {
        n();
    }

    @OnClick({R.id.btn_copy_pwd})
    public void copyPwd() {
        ClipboardManager clipboardManager = (ClipboardManager) this.f6487e.getApplicationContext().getSystemService("clipboard");
        ClipData clipDataNewPlainText = ClipData.newPlainText("pwd", this.mPwdContentTv.getText().toString());
        if (clipboardManager != null) {
            clipboardManager.setPrimaryClip(clipDataNewPlainText);
            G0("复制成功");
        }
    }

    @OnClick({R.id.btn_get_pwd})
    public void getDgjPw() {
        z0(R.string.loading_text);
        c.getInstance().requestPost("https://www.doormaster.me:9099/doormaster/connection", "{\"username\":\"15889503195\",\"password\":\"qwe123\"}", new a());
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_get_dgj_pwd_layout;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void j0() {
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void z(Message message) {
        this.mPwdContentTv.setText((String) message.obj);
    }
}
