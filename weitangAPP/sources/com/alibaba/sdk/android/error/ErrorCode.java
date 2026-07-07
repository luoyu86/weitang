package com.alibaba.sdk.android.error;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class ErrorCode implements Serializable {
    private final Code code;
    private String detail;
    private String msg;
    private String[] solutions;

    public ErrorCode(Code code) {
        this.code = code;
        this.msg = null;
        this.detail = null;
        this.solutions = null;
    }

    @Deprecated
    public ErrorCode(String str, String str2, String str3, String[] strArr, boolean z) {
        this.code = new Code(str, null);
        this.msg = str2;
        this.detail = str3;
        this.solutions = strArr;
    }

    public static String docContent(ErrorCode[] errorCodeArr) {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        for (ErrorCode errorCode : errorCodeArr) {
            sb.append("|");
            sb.append(errorCode.code);
            sb.append("|");
            sb.append(errorCode.msg);
            sb.append("|");
            if (errorCode.solutions != null) {
                int i2 = 0;
                while (i2 < errorCode.solutions.length) {
                    if (i2 != 0) {
                        sb.append("<br />");
                    }
                    int i3 = i2 + 1;
                    sb.append(i3);
                    sb.append(". ");
                    sb.append(errorCode.solutions[i2]);
                    i2 = i3;
                }
            }
            sb.append("|\n");
        }
        return sb.toString();
    }

    public static String docTitle() {
        return "\n| 错误码 | 错误描述 | 备注            |\n| ------ | -------- | ------------------- |\n";
    }

    private static String toStringWithAllInfo(ErrorCode errorCode) {
        StringBuilder sb = new StringBuilder();
        sb.append("错误码：");
        sb.append(errorCode.code);
        sb.append(", ");
        sb.append("错误：");
        sb.append(errorCode.msg);
        String str = errorCode.detail;
        if (str != null && !str.isEmpty()) {
            sb.append("(");
            sb.append(errorCode.detail);
            sb.append("), ");
        }
        String[] strArr = errorCode.solutions;
        if (strArr != null && strArr.length > 0) {
            sb.append("请检查一下几点：");
            for (String str2 : errorCode.solutions) {
                sb.append(str2);
                sb.append("; ");
            }
        }
        return sb.toString();
    }

    public ErrorBuilder copy() {
        ErrorBuilder errorBuilderBuilder = ErrorBuilder.builder(this.code);
        String str = this.msg;
        if (str != null) {
            errorBuilderBuilder.msg(str);
        }
        String str2 = this.detail;
        if (str2 != null) {
            errorBuilderBuilder.detail(str2);
        }
        String[] strArr = this.solutions;
        if (strArr != null) {
            errorBuilderBuilder.solutions(strArr);
        }
        return errorBuilderBuilder;
    }

    @Deprecated
    public ErrorCode create(String str) {
        return create(str, false);
    }

    @Deprecated
    public ErrorCode create(String str, boolean z) {
        return new ErrorCode(this.code.getCodeStr(), this.msg, str, this.solutions, z);
    }

    public String getCode() {
        return this.code.getCodeStr();
    }

    public int getCodeInt() {
        return this.code.getCodeInt();
    }

    public String getMsg() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.msg);
        String str = this.detail;
        if (str != null && !str.isEmpty()) {
            sb.append("(");
            sb.append(this.detail);
            sb.append(")");
        }
        return sb.toString();
    }

    public void setDetail(String str) {
        this.detail = str;
    }

    public void setMsg(String str) {
        this.msg = str;
    }

    public void setSolutions(String[] strArr) {
        this.solutions = strArr;
    }

    public String toShortString() {
        return "(" + this.code + "," + this.msg + "," + this.detail + ")";
    }

    public String toString() {
        return toStringWithAllInfo(this);
    }
}
