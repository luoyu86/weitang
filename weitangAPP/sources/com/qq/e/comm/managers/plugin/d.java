package com.qq.e.comm.managers.plugin;

import com.tom_roush.pdfbox.contentstream.operator.OperatorName;
import com.tom_roush.pdfbox.pdmodel.common.PDPageLabelRange;
import org.android.agoo.message.MessageService;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String[] f9692a = {"0", "1", "2", "3", MessageService.MSG_ACCS_READY_REPORT, "5", "6", "7", MessageService.MSG_ACCS_NOTIFY_CLICK, MessageService.MSG_ACCS_NOTIFY_DISMISS, PDPageLabelRange.STYLE_LETTERS_LOWER, OperatorName.CLOSE_FILL_NON_ZERO_AND_STROKE, OperatorName.CURVE_TO, OperatorName.SET_LINE_DASHPATTERN, "e", OperatorName.FILL_NON_ZERO};

    public static String a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 : bArr) {
            if (i2 < 0) {
                i2 += 256;
            }
            StringBuilder sb = new StringBuilder();
            String[] strArr = f9692a;
            sb.append(strArr[i2 / 16]);
            sb.append(strArr[i2 % 16]);
            stringBuffer.append(sb.toString());
        }
        return stringBuffer.toString();
    }
}
