package c.e.c.x.e;

import android.content.Intent;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import com.chinavisionary.core.app.adapter.BaseRecyclerAdapter;
import com.chinavisionary.core.app.config.bo.AppConfigExtVo;
import com.chinavisionary.core.app.net.base.dto.ResponseRowsVo;
import com.chinavisionary.core.weight.BaseRecyclerView;
import com.chinavisionary.core.weight.banner.EditBannerView;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.clean.CleanDetailsActivity;
import com.chinavisionary.microtang.contract.ContractDetailsActivity;
import com.chinavisionary.microtang.contract.vo.ContractListVo;
import com.chinavisionary.microtang.me.fragment.MeFragment;
import com.chinavisionary.microtang.me.vo.CleanProductVo;
import com.chinavisionary.microtang.me.vo.FundNewsVo;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class k0 extends a0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AppConfigExtVo f2160b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public i0 f2161c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public o0 f2162d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public n0 f2163e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public m0 f2164f;

    public class a extends GridLayoutManager.SpanSizeLookup {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseRecyclerView f2165a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ BaseRecyclerAdapter f2166b;

        public a(BaseRecyclerView baseRecyclerView, BaseRecyclerAdapter baseRecyclerAdapter) {
            this.f2165a = baseRecyclerView;
            this.f2166b = baseRecyclerAdapter;
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanSize(int i2) {
            return ((i2 == this.f2165a.getAdapter().getItemCount() - 1 && this.f2166b.isShowFooterView()) || this.f2166b.getItemViewType(i2) == 26758 || this.f2166b.getItemViewType(i2) == 34952 || this.f2166b.getItemViewType(i2) == 99 || this.f2166b.getItemViewType(i2) == 97 || i2 == 0) ? 2 : 1;
        }
    }

    public k0(g0 g0Var) {
        super(g0Var);
        this.f2161c = new i0(g0Var);
        this.f2162d = new o0(g0Var);
        this.f2163e = new n0(g0Var);
        m0 m0Var = new m0(g0Var);
        this.f2164f = m0Var;
        m0Var.w(this.f2161c);
    }

    public void addAboutDataToList(BaseRecyclerAdapter<CleanProductVo> baseRecyclerAdapter, BaseRecyclerView baseRecyclerView) {
        this.f2161c.c(baseRecyclerAdapter, baseRecyclerView);
    }

    public void addMeBannerData(List<EditBannerView.BannerDto> list, Fragment fragment) {
        this.f2164f.x(list, fragment);
    }

    public void addMenuItemToIsRent(boolean z) {
        d(z);
    }

    public void addMenuToFlowLayout(boolean z) {
        d(z);
        this.f2164f.d(z);
    }

    public final void b(List<CleanProductVo> list) {
        CleanProductVo cleanProductVo = new CleanProductVo();
        cleanProductVo.setName(c.e.a.d.x.getString(R.string.title_me_contract));
        cleanProductVo.setType(97);
        list.add(0, cleanProductVo);
        CleanProductVo cleanProductVo2 = new CleanProductVo();
        cleanProductVo2.setName(c.e.a.d.x.getString(R.string.title_increment_service));
        cleanProductVo2.setType(97);
        list.add(cleanProductVo2);
    }

    public final List<CleanProductVo> c(List<ContractListVo> list) {
        int contractStatus;
        ArrayList arrayList = new ArrayList();
        for (ContractListVo contractListVo : list) {
            if (contractListVo != null && ((contractStatus = contractListVo.getContractStatus()) == 10 || contractStatus == 11 || ((contractStatus == 16 && contractListVo.isRenewalFlag()) || contractStatus == 13))) {
                CleanProductVo cleanProductVo = new CleanProductVo();
                cleanProductVo.setType(99);
                cleanProductVo.setContractListVo(contractListVo);
                arrayList.add(cleanProductVo);
            }
        }
        return arrayList;
    }

    public final void d(boolean z) {
        this.f2163e.s(z);
    }

    public c.e.e.a.s.e getDefaultRentRoom(ResponseRowsVo<c.e.e.a.s.d> responseRowsVo, String str) {
        return this.f2163e.k(responseRowsVo, str);
    }

    public void handleAboutItemClickView(View view) {
        this.f2161c.f(view, this.f2160b);
    }

    public void handlerIsAuth(Boolean bool) {
        this.f2162d.c(bool);
        if (bool.booleanValue()) {
            return;
        }
        d(false);
    }

    public void initUserView(View view) {
        this.f2162d.d(view);
        this.f2163e.r(view);
        this.f2164f.f(view);
    }

    public void openCleanDetails(CleanProductVo cleanProductVo) {
        g0 g0Var = this.f2122a;
        if (g0Var == null || g0Var.getCurrentActivity() == null || !c.e.a.d.x.isNotNull(cleanProductVo.getValueaddedKey())) {
            return;
        }
        Intent intent = new Intent(this.f2122a.getCurrentActivity(), (Class<?>) CleanDetailsActivity.class);
        intent.setFlags(268435456);
        intent.putExtra("key", cleanProductVo.getValueaddedKey());
        intent.putExtra("payPriceKey", c.e.a.d.x.bigDecimalToString(cleanProductVo.getPrice()));
        this.f2122a.getCurrentActivity().startActivity(intent);
    }

    public void openContractDetails(CleanProductVo cleanProductVo) {
        ContractListVo contractListVo = cleanProductVo.getContractListVo();
        Intent intent = new Intent(this.f2122a.getCurrentActivity(), (Class<?>) ContractDetailsActivity.class);
        intent.setFlags(268435456);
        intent.putExtra("key", contractListVo.getContractKey());
        intent.putExtra("contractState", contractListVo.getContractStatus());
        intent.putExtra("contractStateName", contractListVo.getContractStatusName());
        this.f2122a.getCurrentActivity().startActivity(intent);
    }

    public void removeContractList(BaseRecyclerAdapter<CleanProductVo> baseRecyclerAdapter, BaseRecyclerView baseRecyclerView) {
        List<CleanProductVo> list = baseRecyclerAdapter.getList();
        if (c.e.a.d.o.isNotEmpty(list)) {
            int size = list.size();
            ArrayList arrayList = new ArrayList();
            int i2 = 0;
            int i3 = 0;
            for (int i4 = 0; i4 < size; i4++) {
                CleanProductVo cleanProductVo = list.get(i4);
                if (cleanProductVo != null) {
                    int type = cleanProductVo.getType();
                    if (type == 97) {
                        arrayList.add(cleanProductVo);
                        i2 = i4;
                    }
                    if (type == 99) {
                        arrayList.add(cleanProductVo);
                        i3 = i4;
                    }
                }
            }
            list.removeAll(arrayList);
            baseRecyclerAdapter.notifyDataSetChanged();
            c.e.a.d.q.d(k0.class.getCanonicalName(), "removeContractList titleIndex :" + i2 + ",contractIndex:" + i3);
        }
        setupItemDecoration(baseRecyclerAdapter, baseRecyclerView, 1);
        setupIncrementIsShow(true);
    }

    public void setAppConfigVo(AppConfigExtVo appConfigExtVo) {
        if (appConfigExtVo != null) {
            c.e.a.d.g.getInstance().setupAppConfig(appConfigExtVo);
        }
        this.f2160b = appConfigExtVo;
        this.f2164f.v(appConfigExtVo);
        this.f2163e.W(appConfigExtVo);
    }

    public void setupGridLayoutManager(BaseRecyclerAdapter<CleanProductVo> baseRecyclerAdapter, BaseRecyclerView baseRecyclerView) {
        if (baseRecyclerView == null || baseRecyclerAdapter == null) {
            return;
        }
        GridLayoutManager gridLayoutManager = new GridLayoutManager(baseRecyclerView.getContext(), 2);
        gridLayoutManager.setSpanSizeLookup(new a(baseRecyclerView, baseRecyclerAdapter));
        baseRecyclerView.setLayoutManager(gridLayoutManager);
    }

    public void setupIncrementIsShow(boolean z) {
        this.f2163e.X(z);
    }

    public void setupItemDecoration(BaseRecyclerAdapter<CleanProductVo> baseRecyclerAdapter, BaseRecyclerView baseRecyclerView, int i2) {
        this.f2161c.j(baseRecyclerAdapter, baseRecyclerView, i2);
    }

    public void setupRentRoomName(String str) {
        this.f2163e.Y(str);
    }

    public void setupUserInfo(String str, String str2) {
        this.f2162d.i(str, str2);
        this.f2164f.y(c.e.a.d.x.isNotNull(str));
    }

    public void unLoginState() {
        setupUserInfo(c.e.a.d.x.getString(R.string.title_un_login), null);
        handlerIsAuth(Boolean.FALSE);
        setupRentRoomName(null);
        updateRentCommentBadge(false, null);
        this.f2164f.y(false);
    }

    public void updateAboutUsConfig(List<FundNewsVo> list) {
        this.f2164f.updateAboutUsConfig(list);
    }

    public void updateApplyRentBadge(Integer num) {
        this.f2164f.updateApplyRentBadge(num);
    }

    public void updateContract(ResponseRowsVo<ContractListVo> responseRowsVo, BaseRecyclerAdapter<CleanProductVo> baseRecyclerAdapter, BaseRecyclerView baseRecyclerView) {
        if (responseRowsVo != null) {
            removeContractList(baseRecyclerAdapter, baseRecyclerView);
            List<ContractListVo> rows = responseRowsVo.getRows();
            if (c.e.a.d.o.isNotEmpty(rows)) {
                List<CleanProductVo> listC = c(rows);
                if (c.e.a.d.o.isNotEmpty(listC)) {
                    int size = listC.size() + 3;
                    b(listC);
                    baseRecyclerView.removeItemDecorationAt(0);
                    baseRecyclerAdapter.getList().addAll(0, listC);
                    setupItemDecoration(baseRecyclerAdapter, baseRecyclerView, size);
                    setupIncrementIsShow(false);
                    c.e.a.d.q.d(MeFragment.class.getCanonicalName(), "contract list is size:" + listC.size());
                } else {
                    removeContractList(baseRecyclerAdapter, baseRecyclerView);
                    c.e.a.d.q.d(MeFragment.class.getCanonicalName(), "contract list is null");
                }
                baseRecyclerAdapter.notifyDataSetChanged();
            }
        }
    }

    public void updateMeVtConfig(List<FundNewsVo> list) {
        this.f2164f.updateMeVtConfig(list);
    }

    public void updateMenuItem() {
        this.f2164f.c(true);
    }

    public void updateOftenRoomCache() {
        this.f2163e.updateOftenRoomCache(false);
    }

    public void updateOftenUseRoomVisibility(boolean z) {
        this.f2163e.b0(z);
    }

    public void updatePwdDoorEntryState() {
        this.f2164f.updatePwdDoorEntryState();
    }

    public void updateRemoteOpenDoor() {
        this.f2163e.c0();
    }

    public void updateRentCommentBadge(boolean z, Integer num) {
        this.f2164f.z(z, num);
    }

    public void updateServerConfig(List<FundNewsVo> list) {
        this.f2164f.updateServeConfig(list);
    }
}
