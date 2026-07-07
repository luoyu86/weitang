package com.google.zxing.client.result;

import com.google.zxing.Result;

/* JADX INFO: loaded from: classes2.dex */
public final class URLTOResultParser extends ResultParser {
    @Override // com.google.zxing.client.result.ResultParser
    public URIParsedResult parse(Result result) {
        int iIndexOf;
        String text = result.getText();
        if ((text.startsWith("urlto:") || text.startsWith("URLTO:")) && (iIndexOf = text.indexOf(58, 6)) >= 0) {
            return new URIParsedResult(text.substring(iIndexOf + 1), iIndexOf > 6 ? text.substring(6, iIndexOf) : null);
        }
        return null;
    }
}
