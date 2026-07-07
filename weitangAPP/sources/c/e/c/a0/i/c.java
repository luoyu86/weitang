package c.e.c.a0.i;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.e.a.d.o;
import c.e.a.d.q;
import c.e.a.d.x;
import c.e.e.a.s.e;
import com.chinavisionary.microtang.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class c {
    public static /* synthetic */ int b(e eVar, e eVar2) {
        if (eVar == null || eVar2 == null || eVar.getLockType() == null || eVar2.getLockType() == null) {
            return 0;
        }
        return eVar.getLockType().compareTo(eVar2.getLockType());
    }

    public final List<e> a(List<e> list, List<e> list2) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        if (!o.isNotEmpty(list2)) {
            return list;
        }
        if (!o.isNotEmpty(list)) {
            return list2;
        }
        for (e eVar : list2) {
            if (eVar == null || !x.isNotNull(eVar.getAssetInstanceName())) {
                arrayList2.add(eVar);
            } else {
                String assetInstanceName = eVar.getAssetInstanceName();
                int length = assetInstanceName.length();
                int iIndexOf = assetInstanceName.indexOf("栋");
                if (length - iIndexOf >= 2) {
                    iIndexOf++;
                }
                String strSubstring = assetInstanceName.substring(0, iIndexOf);
                arrayList.add(eVar);
                arrayList3.clear();
                q.d(c.class.getSimpleName(), "roomStartName = " + strSubstring);
                for (e eVar2 : list) {
                    if (eVar2 != null && x.isNotNull(eVar2.getAssetInstanceName())) {
                        String assetInstanceName2 = eVar2.getAssetInstanceName();
                        int length2 = assetInstanceName2.length();
                        int iIndexOf2 = assetInstanceName2.indexOf("栋");
                        if (length2 - iIndexOf2 >= 2) {
                            iIndexOf2++;
                        }
                        String strSubstring2 = assetInstanceName2.substring(0, iIndexOf2);
                        q.d(c.class.getSimpleName(), "publicStartName = " + strSubstring2);
                        if (strSubstring2.length() > 0 && strSubstring.contains(strSubstring2)) {
                            arrayList.add(eVar2);
                            arrayList3.add(eVar2);
                        }
                    }
                }
                if (!arrayList3.isEmpty()) {
                    list.removeAll(arrayList3);
                    arrayList3.clear();
                }
            }
        }
        if (!arrayList2.isEmpty()) {
            arrayList.addAll(arrayList2);
        }
        if (!list.isEmpty()) {
            arrayList.addAll(list);
        }
        return arrayList;
    }

    public List<e> filterAllRoomList(List<e> list) {
        List<e> arrayList = new ArrayList<>();
        List<e> arrayList2 = new ArrayList<>();
        arrayList2.addAll(list);
        if (o.isNotEmpty(arrayList2)) {
            for (e eVar : arrayList2) {
                if (eVar != null && eVar.getLockType() != null && eVar.getLockType().intValue() != 1) {
                    arrayList.add(eVar);
                }
            }
            arrayList2.removeAll(arrayList);
        }
        if (arrayList.size() == 1) {
            return a(arrayList2, arrayList);
        }
        arrayList2.addAll(0, arrayList);
        return arrayList2;
    }

    public View getRoomView(e eVar, LinearLayout linearLayout, boolean z) {
        View viewInflate = LayoutInflater.from(linearLayout.getContext()).inflate(R.layout.item_open_room, (ViewGroup) linearLayout, false);
        TextView textView = (TextView) viewInflate.findViewById(R.id.tv_room_title);
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.tv_room_no_value);
        String assetInstanceName = eVar.getAssetInstanceName();
        if (x.isNotNull(assetInstanceName) && assetInstanceName.contains("-")) {
            String[] strArrSplit = assetInstanceName.split("-");
            if (strArrSplit.length > 0) {
                assetInstanceName = strArrSplit[strArrSplit.length - 1];
            }
        }
        if (x.isNotNull(assetInstanceName) && assetInstanceName.contains("层")) {
            String[] strArrSplit2 = assetInstanceName.split("层");
            if (strArrSplit2.length > 0) {
                assetInstanceName = strArrSplit2[strArrSplit2.length - 1];
            }
        } else if (x.isNotNull(assetInstanceName) && assetInstanceName.contains("单元")) {
            String[] strArrSplit3 = assetInstanceName.split("单元");
            if (strArrSplit3.length > 0) {
                assetInstanceName = strArrSplit3[strArrSplit3.length - 1];
            }
        }
        if (eVar.getLockType() != null && eVar.getLockType().intValue() != 1) {
            textView2.setBackgroundResource(R.drawable.bg_room_fill_radius);
        }
        if (z) {
            textView2.setBackgroundResource(R.drawable.bg_room_fill_radius);
        }
        textView2.setText(assetInstanceName);
        textView.setText(eVar.getAssetInstanceName());
        viewInflate.setTag(eVar);
        return viewInflate;
    }

    public List<e> lockSort(List<e> list, List<e> list2) {
        if (!o.isNotEmpty(list) || !o.isNotEmpty(list2)) {
            return list2;
        }
        ArrayList arrayList = new ArrayList();
        for (e eVar : list) {
            if (eVar != null && x.isNotNull(eVar.getAssetInstanceKey())) {
                for (e eVar2 : list2) {
                    if (eVar2 != null && x.isNotNull(eVar2.getAssetInstanceKey()) && eVar.getAssetInstanceKey().equals(eVar2.getAssetInstanceKey())) {
                        arrayList.add(eVar2);
                    }
                }
            }
        }
        if (arrayList.size() < list2.size()) {
            list2.removeAll(arrayList);
            arrayList.addAll(list2);
        }
        return arrayList;
    }

    public void roomOrder(List<e> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        Collections.sort(list, new Comparator() { // from class: c.e.c.a0.i.a
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return c.b((e) obj, (e) obj2);
            }
        });
    }
}
