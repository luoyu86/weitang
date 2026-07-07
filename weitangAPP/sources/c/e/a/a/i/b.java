package c.e.a.a.i;

import c.e.a.d.o;
import c.e.a.d.x;
import com.alibaba.android.arouter.utils.Consts;
import com.chinavisionary.core.app.oss.bo.AliYunOssResultVo;
import com.chinavisionary.core.app.oss.bo.AliYunOssToResourceBo;
import com.chinavisionary.core.app.oss.bo.RoomBannerBo;
import com.chinavisionary.framework.mobile.common.vo.ResourceVo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f1032a = new b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f1033b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f1034c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List<AliYunOssResultVo> f1035d = new ArrayList();

    public class a implements Comparator<ResourceVo> {
        @Override // java.util.Comparator
        public int compare(ResourceVo resourceVo, ResourceVo resourceVo2) {
            String url = resourceVo.getUrl();
            String strSubstring = url.substring(url.lastIndexOf("/") + 1);
            String strSubstring2 = strSubstring.substring(0, strSubstring.lastIndexOf(Consts.DOT));
            String url2 = resourceVo2.getUrl();
            String strSubstring3 = url2.substring(url2.lastIndexOf("/") + 1);
            return strSubstring2.compareTo(strSubstring3.substring(0, strSubstring3.lastIndexOf(Consts.DOT)));
        }
    }

    public static String getGroupFilePathToGroupName(String str) {
        return str + "/" + AliYunOssToResourceBo.COVER_KEY;
    }

    public static b getInstance() {
        return f1032a;
    }

    public static String getRoomBigMapPathToGroupName(String str) {
        return str + "/" + AliYunOssToResourceBo.MAP_KEY + "/" + AliYunOssToResourceBo.BIG_MAP_KEY;
    }

    public static String getRoomMapPathToGroupName(String str) {
        return str + "/" + AliYunOssToResourceBo.MAP_KEY;
    }

    public static String getRoomSourceBigMapPathToGroupName(String str, String str2) {
        return str + "/" + str2 + "/" + AliYunOssToResourceBo.MAP_KEY + "/" + AliYunOssToResourceBo.BIG_MAP_KEY;
    }

    public static String getRoomSourceMapPathToGroupName(String str, String str2) {
        return str + "/" + str2 + "/" + AliYunOssToResourceBo.MAP_KEY;
    }

    public static String getRoomTagPathToGroupName(String str) {
        return str + "/" + AliYunOssToResourceBo.TAG_KEY;
    }

    public static void sortResourceList(List<ResourceVo> list) {
        if (o.isNotEmpty(list)) {
            Collections.sort(list, new a());
        }
    }

    public final String a(String str) {
        StringBuilder sb = new StringBuilder(6);
        String str2 = this.f1033b;
        if (str2 != null) {
            sb.append(str2);
            sb.append("/");
        }
        String str3 = this.f1034c;
        if (str3 != null) {
            sb.append(str3);
            sb.append("/");
        }
        sb.append(str);
        sb.append("/");
        return sb.toString();
    }

    public List<AliYunOssResultVo> getList() {
        return this.f1035d;
    }

    public synchronized List<ResourceVo> getResourceListToPath(String str) {
        if (!x.isNotNull(str) || !x.isNotNull(this.f1034c) || !x.isNotNull(this.f1033b) || !o.isNotEmpty(this.f1035d)) {
            return null;
        }
        String strA = a(str);
        ArrayList arrayList = new ArrayList();
        for (AliYunOssResultVo aliYunOssResultVo : this.f1035d) {
            if (aliYunOssResultVo != null && x.isNotNull(aliYunOssResultVo.getPathName()) && x.isNotNull(aliYunOssResultVo.getPicUrl())) {
                String pathName = aliYunOssResultVo.getPathName();
                if (pathName.contains(strA)) {
                    String strSubstring = pathName.substring(strA.length());
                    if (x.isNotNull(strSubstring) && !strSubstring.contains("/")) {
                        ResourceVo resourceVo = new ResourceVo();
                        resourceVo.setUrl(aliYunOssResultVo.getPicUrl());
                        resourceVo.setSampleUrl(aliYunOssResultVo.getPicUrl());
                        arrayList.add(resourceVo);
                    }
                }
            }
        }
        return arrayList;
    }

    public synchronized List<RoomBannerBo> getRoomBannerVos(String str) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        if (x.isNotNull(str) && x.isNotNull(this.f1034c) && x.isNotNull(this.f1033b) && o.isNotEmpty(this.f1035d)) {
            String strA = a(str);
            try {
                ArrayList arrayList2 = new ArrayList();
                for (AliYunOssResultVo aliYunOssResultVo : this.f1035d) {
                    if (aliYunOssResultVo != null && x.isNotNull(aliYunOssResultVo.getPathName()) && x.isNotNull(aliYunOssResultVo.getPicUrl())) {
                        String pathName = aliYunOssResultVo.getPathName();
                        if (pathName.contains(strA)) {
                            String strSubstring = pathName.substring(strA.length());
                            if (x.isNotNull(strSubstring) && strSubstring.contains("/")) {
                                String strSubstring2 = strSubstring.substring(0, strSubstring.indexOf("/"));
                                String strSubstring3 = strSubstring.substring(strSubstring.lastIndexOf("/") + 1);
                                if (!arrayList2.contains(strSubstring2) && x.isNotNull(strSubstring3) && strSubstring3.length() > 3) {
                                    arrayList2.add(strSubstring2);
                                    RoomBannerBo roomBannerBo = new RoomBannerBo();
                                    roomBannerBo.setFolderName(strSubstring2);
                                    roomBannerBo.setResourceVos(getResourceListToPath(str + "/" + strSubstring2));
                                    arrayList.add(roomBannerBo);
                                }
                            }
                        }
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return arrayList;
    }

    public void setCityName(String str) {
        this.f1033b = str;
    }

    public void setList(List<AliYunOssResultVo> list) {
        this.f1035d = list;
    }

    public void setProjectName(String str) {
        this.f1034c = str;
    }

    public void setupGroupRoomPic(List<AliYunOssToResourceBo> list) {
        if (o.isNotEmpty(list) && o.isNotEmpty(this.f1035d)) {
            for (AliYunOssToResourceBo aliYunOssToResourceBo : list) {
                if (aliYunOssToResourceBo != null && x.isNotNull(aliYunOssToResourceBo.getFilePath())) {
                    aliYunOssToResourceBo.setResourceVo(getResourceListToPath(aliYunOssToResourceBo.getFilePath()));
                }
            }
        }
    }
}
