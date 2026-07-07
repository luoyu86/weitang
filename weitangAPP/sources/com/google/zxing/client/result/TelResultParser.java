package com.google.zxing.client.result;

import com.google.zxing.Result;

/* JADX INFO: loaded from: classes2.dex */
public final class TelResultParser extends ResultParser {
    @Override // com.google.zxing.client.result.ResultParser
    public TelParsedResult parse(Result result) {
        String str;
        String text = result.getText();
        if (!text.startsWith("tel:") && !text.startsWith("TEL:")) {
            return null;
        }
        if (text.startsWith("TEL:")) {
            str = "tel:" + text.substring(4);
        } else {
            str = text;
        }
        int iIndexOf = text.indexOf(63, 4);
        return new TelParsedResult(iIndexOf < 0 ? text.substring(4) : text.substring(4, iIndexOf), str, null);
    }
}
