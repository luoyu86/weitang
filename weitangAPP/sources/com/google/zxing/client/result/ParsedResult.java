package com.google.zxing.client.result;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ParsedResult {
    private final ParsedResultType type;

    public ParsedResult(ParsedResultType parsedResultType) {
        this.type = parsedResultType;
    }

    public static void maybeAppend(String str, StringBuilder sb) {
        if (str == null || str.length() <= 0) {
            return;
        }
        if (sb.length() > 0) {
            sb.append('\n');
        }
        sb.append(str);
    }

    public abstract String getDisplayResult();

    public ParsedResultType getType() {
        return this.type;
    }

    public String toString() {
        return getDisplayResult();
    }

    public static void maybeAppend(String[] strArr, StringBuilder sb) {
        if (strArr != null) {
            for (String str : strArr) {
                if (str != null && str.length() > 0) {
                    if (sb.length() > 0) {
                        sb.append('\n');
                    }
                    sb.append(str);
                }
            }
        }
    }
}
