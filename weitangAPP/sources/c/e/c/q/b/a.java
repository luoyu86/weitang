package c.e.c.q.b;

import c.e.a.d.x;
import c.e.c.q.d.b;
import c.p.a.a.k;
import com.alibaba.fastjson.JSON;
import com.chinavisionary.core.app.config.bo.AppConfigExtVo;
import com.chinavisionary.core.app.net.base.model.BaseModel;
import com.chinavisionary.microtang.R;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class a {
    public static c.e.c.q.d.a a(AppConfigExtVo appConfigExtVo, boolean z, String str) {
        c.e.c.q.d.a aVar = new c.e.c.q.d.a();
        aVar.setItemType(2);
        b bVar = new b();
        bVar.setEnableSetupPwd(z);
        if (x.isNullStr(str)) {
            str = x.getString(R.string.tip_empty_room);
        }
        bVar.setRoomName(str);
        bVar.setTipMsg(appConfigExtVo.getDoorLockDesc2());
        bVar.setPwdSetupTipMsg(appConfigExtVo.getDoorLockDesc3());
        aVar.setItemVo(bVar);
        return aVar;
    }

    public static String getAddPwdCommand() {
        c.p.a.b.b bVar = new c.p.a.b.b();
        ArrayList arrayList = new ArrayList();
        arrayList.add("9A40010fC42BD2792DD2525C2D326C34A781A53f");
        arrayList.add("9A40020f12EC07FF5DC5B173D020171060F1A4d3");
        arrayList.add("9A40030fFA7740F0F9BB146ADC129D65204DE7f1");
        arrayList.add("9A40040fEC0DDDAE74656FCBEBA985F782D48983");
        arrayList.add("9A4005045F99263F9e");
        bVar.setCommand(arrayList);
        return JSON.toJSONString(bVar);
    }

    public static String getBleCommandToJsonString(List<String> list) {
        c.p.a.b.b bVar = new c.p.a.b.b();
        bVar.setCommand(list);
        return JSON.toJSONString(bVar);
    }

    public static String getDelPwdCommand() {
        c.p.a.b.b bVar = new c.p.a.b.b();
        ArrayList arrayList = new ArrayList();
        arrayList.add("9A20010f58C7B695BB0977FBA28B47F4EFFD6D49");
        arrayList.add("9A20020fE0DB9EB938A46A31EC601D8D197822a9");
        arrayList.add("9A200302502253");
        bVar.setCommand(arrayList);
        return JSON.toJSONString(bVar);
    }

    public static List<c.e.c.q.d.a> getDoorPasswordList(AppConfigExtVo appConfigExtVo, boolean z, String str) {
        ArrayList arrayList = new ArrayList();
        c.e.c.q.d.a aVar = new c.e.c.q.d.a();
        aVar.setItemType(1);
        aVar.setTitle(appConfigExtVo.getDoorLockDesc1());
        arrayList.add(aVar);
        arrayList.add(a(appConfigExtVo, z, str));
        return arrayList;
    }

    public static String getGMAddPwdCommand() {
        c.p.a.b.b bVar = new c.p.a.b.b();
        ArrayList arrayList = new ArrayList();
        arrayList.add("9A30010F6B9E95092224053F5B81B6049C0B72E6");
        arrayList.add("9A30020F6F25FA710A2DFC7222A3D29AD0E3CC63");
        arrayList.add("9A30030F389CEDA08112A9A65A71DBAA45CD50CB");
        arrayList.add("9A3004033B73334C");
        bVar.setCommand(arrayList);
        return JSON.toJSONString(bVar);
    }

    public static String[] getGMCommandAndResultCode(String str) {
        int length = str.length() - 10;
        String strSubstring = str.substring(length, length + 4);
        int length2 = str.length() - 6;
        return new String[]{strSubstring, str.substring(length2, length2 + 4)};
    }

    public static String getGMDelPwdCommand() {
        c.p.a.b.b bVar = new c.p.a.b.b();
        ArrayList arrayList = new ArrayList();
        arrayList.add("9A20010F7A1AF9EE09C81EFA884F1170EA210213");
        arrayList.add("9A20020F446651F4522EF3351C8AE4CCC810E791");
        arrayList.add("9A200302A04DCC");
        bVar.setCommand(arrayList);
        return JSON.toJSONString(bVar);
    }

    public static String getGMSetupTimeCommand() {
        c.p.a.b.b bVar = new c.p.a.b.b();
        ArrayList arrayList = new ArrayList();
        arrayList.add("9A20010F8A0B2E23000A4DFE8A0DA1DCF905839E");
        arrayList.add("9A20020F9D3992E84861E0C7C15A6B8C40222CCF");
        arrayList.add("9A200302601554");
        bVar.setCommand(arrayList);
        return JSON.toJSONString(bVar);
    }

    public static String[] getMtCommandAndResultCode(String str) {
        int length = str.length() - 10;
        String strSubstring = str.substring(length, length + 2);
        int length2 = str.length() - 8;
        return new String[]{strSubstring, str.substring(length2, length2 + 2)};
    }

    public static String getSetupTimeCommand() {
        c.p.a.b.b bVar = new c.p.a.b.b();
        ArrayList arrayList = new ArrayList();
        arrayList.add("9A30010f6D6CBBA2992DBE2DCBBB03933EEE0F3e");
        arrayList.add("9A30020f3411CDCF3F23DC96E0B7E6380ABE5425");
        arrayList.add("9A30030fC9B9B1EEFB22F6DB3BC75284C254E2b9");
        arrayList.add("9A30040376B1A656");
        bVar.setCommand(arrayList);
        return JSON.toJSONString(bVar);
    }

    public static String getUpdatePwdCommand() {
        c.p.a.b.b bVar = new c.p.a.b.b();
        ArrayList arrayList = new ArrayList();
        arrayList.add("9A40010f03EE4144D461D257D165DD1449096Ec5");
        arrayList.add("9A40020f227186B78DB045037BC2CE1501277A6a");
        arrayList.add("9A40030fD520DB2DDFDC9E6AE10B637CA511748d");
        arrayList.add("9A40040fDA6B58AF8790D20297E787BA0B6B17f0");
        arrayList.add("9A40050448C723CC21");
        bVar.setCommand(arrayList);
        return JSON.toJSONString(bVar);
    }

    public static String parseOpenDoorResult(String str) {
        String str2 = "";
        if (str.equals("EE01")) {
            str2 = "校验位错误";
        }
        if (str.equals("EE02")) {
            str2 = str2 + "分包错误";
        }
        if (str.equals("EE05")) {
            str2 = str2 + "包头错误";
        }
        if (str.equals("EE06")) {
            str2 = str2 + "未鉴权";
        }
        if (str.equals("EEFF")) {
            str2 = str2 + "未知错误";
        }
        if (str.equals("EE03")) {
            str2 = str2 + "秘钥错误";
        }
        if (str.equals("EE04")) {
            str2 = str2 + "秘钥已过期";
        }
        if (str.equals("EE0F")) {
            str2 = str2 + "凭证不存在";
        }
        if (str.equals("EE0E")) {
            str2 = str2 + "凭证错误";
        }
        if (str.equals("EE0D")) {
            str2 = str2 + "指令时间已失效";
        }
        if (str.equals("EE0C")) {
            str2 = str2 + "凭证有效期起始时间未到";
        }
        if (str.equals("EE0B")) {
            str2 = str2 + "凭证已过期";
        }
        if (str.equals("EE10")) {
            str2 = str2 + "NB消息码错误";
        }
        if (str.equals("EE0A")) {
            str2 = str2 + "凭证被冻结";
        }
        if (str.equals("EE09")) {
            str2 = str2 + "开门次数不足";
        }
        if (str.equals("EE10")) {
            str2 = str2 + "用户ID不存在";
        }
        if (str.equals("EE11")) {
            str2 = str2 + "密码存在其他ID";
        }
        if (str.equals("EE12")) {
            str2 = str2 + "密码已满";
        }
        if (str.equals("01")) {
            str2 = str2 + "修改失败";
        }
        if (str.equals("02")) {
            str2 = str2 + "用户己满";
        }
        if (str.equals("03")) {
            str2 = str2 + "鉴权码失败";
        }
        if (str.equals("04")) {
            str2 = str2 + "密码已存在";
        }
        if (str.equals("05")) {
            str2 = str2 + "ID已存在";
        }
        if (str.equals("06")) {
            str2 = str2 + BaseModel.USER_NOT_EXITS;
        }
        if (str.equals("07")) {
            str2 = str2 + "日期错误";
        }
        if (str.equals("0A")) {
            str2 = str2 + "鉴权码未配置";
        }
        if (!x.isNullStr(str2)) {
            return str2;
        }
        return "(code=" + str + ")";
    }

    public static void setupMtUuid() {
        k.getInstance().setServiceUuid("0000FFF0-0000-1000-8000-00805F9B34FB");
        k.getInstance().setNotifyUuid("0000fff3-0000-1000-8000-00805f9b34fb");
        k.getInstance().setWriterUuid("0000fff2-0000-1000-8000-00805f9b34fb");
    }

    public static void setupZiSnooUuid() {
        k.getInstance().setServiceUuid("00000001-0000-1000-8000-00805f9b34fb");
        k.getInstance().setNotifyUuid("00000003-0000-1000-8000-00805f9b34fb");
        k.getInstance().setWriterUuid("00000002-0000-1000-8000-00805f9b34fb");
    }
}
