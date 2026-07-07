package com.taobao.accs;

import android.util.Log;
import anet.channel.GlobalAppRuntimeInfo;
import com.alibaba.android.arouter.utils.Consts;
import com.alibaba.sdk.android.error.ErrorBuilder;
import com.alibaba.sdk.android.error.ErrorDefine;
import com.alibaba.sdk.android.error.IntCodeGenerator;
import com.taobao.accs.utl.i;
import com.vivo.identifier.IdentifierConstant;

/* JADX INFO: loaded from: classes2.dex */
public class AccsErrorCode {
    public static final com.alibaba.sdk.android.error.ErrorCode APPKEY_NULL;
    public static final com.alibaba.sdk.android.error.ErrorCode APPSECRET_NULL;
    public static final com.alibaba.sdk.android.error.ErrorCode APP_NOT_BIND;
    public static final com.alibaba.sdk.android.error.ErrorCode DM_APPKEY_INVALID;
    public static final com.alibaba.sdk.android.error.ErrorCode DM_DEVICEID_INVALID;
    public static final com.alibaba.sdk.android.error.ErrorCode DM_PACKAGENAME_INVALID;
    public static final com.alibaba.sdk.android.error.ErrorCode DM_TAIR_ERROR;
    public static final com.alibaba.sdk.android.error.ErrorCode ERROR_SHOULD_NEVER_HAPPEN;
    private static final int HTTP_CODE_DM_APP_KEY_INVALID = 303;
    private static final int HTTP_CODE_DM_DEVICE_ID_INVALID = 302;
    private static final int HTTP_CODE_DM_PACKAGE_NAME_INVALID = 304;
    private static final int HTTP_CODE_DM_TAIR_ERROR = 102;
    private static final int HTTP_CODE_SUCCESS = 200;
    public static final com.alibaba.sdk.android.error.ErrorCode INAPP_CON_DISCONNECTED;
    public static final com.alibaba.sdk.android.error.ErrorCode MESSAGE_HOST_NULL;
    public static final com.alibaba.sdk.android.error.ErrorCode MESSAGE_QUEUE_FULL;
    public static final com.alibaba.sdk.android.error.ErrorCode MESSAGE_TOO_LARGE;
    public static final com.alibaba.sdk.android.error.ErrorCode NETWORKSDK_SPDY_CLOSE_ERROR;
    public static final com.alibaba.sdk.android.error.ErrorCode NETWORKSDK_SPDY_RES_ERROR;
    public static final com.alibaba.sdk.android.error.ErrorCode NETWORK_INAPP_ARGS_INVALID;
    public static final com.alibaba.sdk.android.error.ErrorCode NETWORK_INAPP_CONNECT_FAIL;
    public static final com.alibaba.sdk.android.error.ErrorCode NETWORK_INAPP_EXCEPTION;
    public static final com.alibaba.sdk.android.error.ErrorCode NETWORK_INAPP_NO_STRATEGY;
    public static final com.alibaba.sdk.android.error.ErrorCode NETWORK_INAPP_TIMEOUT;
    public static final com.alibaba.sdk.android.error.ErrorCode NO_NETWORK;
    public static final com.alibaba.sdk.android.error.ErrorCode PARAMETER_ERROR;
    public static final com.alibaba.sdk.android.error.ErrorCode REQ_TIME_OUT;
    public static final com.alibaba.sdk.android.error.ErrorCode RESPONSE_PARSE_ERROR;
    public static final com.alibaba.sdk.android.error.ErrorCode SEND_LOCAL_EXCEPTION;
    public static final com.alibaba.sdk.android.error.ErrorCode SERVER_UNKNOWN_ERROR;
    public static final com.alibaba.sdk.android.error.ErrorCode SERVIER_HIGH_LIMIT;
    public static final com.alibaba.sdk.android.error.ErrorCode SERVIER_HIGH_LIMIT_BRUSH;
    public static final com.alibaba.sdk.android.error.ErrorCode SERVIER_LOW_LIMIT;
    public static final com.alibaba.sdk.android.error.ErrorCode SPDY_AUTH_EXCEPTION;
    public static final com.alibaba.sdk.android.error.ErrorCode SPDY_AUTH_PARAM_ERROR;
    public static final com.alibaba.sdk.android.error.ErrorCode SPDY_CONNECTION_DISCONNECTED_WHEN_SEND_DATA;
    public static final com.alibaba.sdk.android.error.ErrorCode SPDY_CON_DISCONNECTED;
    public static final com.alibaba.sdk.android.error.ErrorCode SPDY_PING_TIME_OUT;
    public static final com.alibaba.sdk.android.error.ErrorCode SUCCESS;
    public static final com.alibaba.sdk.android.error.ErrorCode[] codes;
    private static final ErrorDefine define;

    static {
        ErrorDefine errorDefine = new ErrorDefine("EACCS", new IntCodeGenerator());
        define = errorDefine;
        com.alibaba.sdk.android.error.ErrorCode errorCodeBuild = errorDefine.defineSdkError("200").msg("成功").build();
        SUCCESS = errorCodeBuild;
        com.alibaba.sdk.android.error.ErrorCode errorCodeBuild2 = errorDefine.defineSdkError("300").msg("通道未建立").solution("请先初始化，bindApp，再调用其它api").build();
        APP_NOT_BIND = errorCodeBuild2;
        com.alibaba.sdk.android.error.ErrorCode errorCodeBuild3 = errorDefine.defineSdkError(IdentifierConstant.OAID_STATE_DEFAULT).msg("静默连接中断，无法发送消息").solution("内部会重试，如果一直失败，需要排查下静默通道是否正常").build();
        SPDY_CONNECTION_DISCONNECTED_WHEN_SEND_DATA = errorCodeBuild3;
        com.alibaba.sdk.android.error.ErrorCode errorCodeBuild4 = errorDefine.defineSdkError(IdentifierConstant.OAID_STATE_NOT_SUPPORT).msg("参数错误,发送的msg为null").solution("请检查发起请求的参数是否正确").build();
        PARAMETER_ERROR = errorCodeBuild4;
        com.alibaba.sdk.android.error.ErrorCode errorCodeBuild5 = errorDefine.defineSdkError("-3").msg("服务返回数据异常").solution("请关注错误信息中的服务返回数据，并联系阿里云技术支持同学确认原因").build();
        RESPONSE_PARSE_ERROR = errorCodeBuild5;
        com.alibaba.sdk.android.error.ErrorCode errorCodeBuild6 = errorDefine.defineSdkError("-4").msg("单次发送数据过大").solution("请减少一次发送的数据量，封装之后总的数据量要小于16KB").build();
        MESSAGE_TOO_LARGE = errorCodeBuild6;
        com.alibaba.sdk.android.error.ErrorCode errorCodeBuild7 = errorDefine.defineSdkError("-5").msg("发送服务地址为null").solution("请检查下初始化配置是否正确").build();
        MESSAGE_HOST_NULL = errorCodeBuild7;
        com.alibaba.sdk.android.error.ErrorCode errorCodeBuild8 = errorDefine.defineSdkError("-6").msg("静默通道长连接认证参数错误").solution("请检查初始化参数配置是否正确").build();
        SPDY_AUTH_PARAM_ERROR = errorCodeBuild8;
        com.alibaba.sdk.android.error.ErrorCode errorCodeBuild9 = errorDefine.defineSdkError("-7").msg("静默通道长连接认证异常").solution("请查看错误信息，确认具体异常信息").build();
        SPDY_AUTH_EXCEPTION = errorCodeBuild9;
        com.alibaba.sdk.android.error.ErrorCode errorCodeBuild10 = errorDefine.defineSdkError("-8").msg("发送数据异常").solution("请查看错误信息，确认具体异常信息").build();
        SEND_LOCAL_EXCEPTION = errorCodeBuild10;
        com.alibaba.sdk.android.error.ErrorCode errorCodeBuild11 = errorDefine.defineSdkError("-9").msg("发送消息超时").solution("需要结合具体是查看为什么超时").build();
        REQ_TIME_OUT = errorCodeBuild11;
        com.alibaba.sdk.android.error.ErrorCode errorCodeBuild12 = errorDefine.defineSdkError("-10").msg("静默通道长连接断连").solution("断连需要查看之前的日志").build();
        SPDY_CON_DISCONNECTED = errorCodeBuild12;
        com.alibaba.sdk.android.error.ErrorCode errorCodeBuild13 = errorDefine.defineSdkError("-11").msg("应用内长连接断开").solution("一般为长连接建连失败造成，需要看日志分析").build();
        INAPP_CON_DISCONNECTED = errorCodeBuild13;
        com.alibaba.sdk.android.error.ErrorCode errorCodeBuild14 = errorDefine.defineSdkError("-12").msg("静默通道长连接ping超时").build();
        SPDY_PING_TIME_OUT = errorCodeBuild14;
        com.alibaba.sdk.android.error.ErrorCode errorCodeBuild15 = errorDefine.defineSdkError("-13").msg("无网络").solution("请检查网络连接").build();
        NO_NETWORK = errorCodeBuild15;
        com.alibaba.sdk.android.error.ErrorCode errorCodeBuild16 = errorDefine.defineSdkError("-14").msg("appKey不存在").solution("请检查初始化配置是否正确").build();
        APPKEY_NULL = errorCodeBuild16;
        com.alibaba.sdk.android.error.ErrorCode errorCodeBuild17 = errorDefine.defineSdkError("-15").msg("appSecret不存在").solution("请检查初始化配置是否正确").build();
        APPSECRET_NULL = errorCodeBuild17;
        com.alibaba.sdk.android.error.ErrorCode errorCodeBuild18 = errorDefine.defineServerError("70008").msg("长连接发送队列已满").solution("请确认是否有高并发发送消息，如果有，请限制发送频次").build();
        MESSAGE_QUEUE_FULL = errorCodeBuild18;
        com.alibaba.sdk.android.error.ErrorCode errorCodeBuild19 = errorDefine.defineServerError("70020").msg("低级别限流").solution("请和部署同学确认限流策略").build();
        SERVIER_LOW_LIMIT = errorCodeBuild19;
        com.alibaba.sdk.android.error.ErrorCode errorCodeBuild20 = errorDefine.defineServerError("70021").msg("高级别限流,不发送").solution("请和部署同学确认限流策略").build();
        SERVIER_HIGH_LIMIT = errorCodeBuild20;
        com.alibaba.sdk.android.error.ErrorCode errorCodeBuild21 = errorDefine.defineServerError("70023").msg("防刷解封后触发的限流，不发送").solution("请和部署同学确认限流策略").build();
        SERVIER_HIGH_LIMIT_BRUSH = errorCodeBuild21;
        com.alibaba.sdk.android.error.ErrorCode errorCodeBuild22 = errorDefine.defineServerError("102").msg("设备无效").solution("如果是测试时发现的，请清除应用数据重新尝试").build();
        DM_TAIR_ERROR = errorCodeBuild22;
        com.alibaba.sdk.android.error.ErrorCode errorCodeBuild23 = errorDefine.defineServerError("302").msg("设备无效").solution("如果是测试时发现的，请清除应用数据重新尝试").build();
        DM_DEVICEID_INVALID = errorCodeBuild23;
        com.alibaba.sdk.android.error.ErrorCode errorCodeBuild24 = errorDefine.defineServerError("303").msg("appkey配置错误").solution("请检查appKey配置是否正确").build();
        DM_APPKEY_INVALID = errorCodeBuild24;
        com.alibaba.sdk.android.error.ErrorCode errorCodeBuild25 = errorDefine.defineServerError("304").msg("包名错误").solution("请检查appKey和应用包名是否匹配").build();
        DM_PACKAGENAME_INVALID = errorCodeBuild25;
        com.alibaba.sdk.android.error.ErrorCode errorCodeBuild26 = errorDefine.defineServerError("-20").msg("服务返回错误").solution("请关注下错误信息中的服务返回的错误码，并联系阿里云技术支持同学确认原因").build();
        SERVER_UNKNOWN_ERROR = errorCodeBuild26;
        com.alibaba.sdk.android.error.ErrorCode errorCodeBuild27 = errorDefine.defineSdkError("-22").msg("底层sdk连接关闭").solution("请关注下错误信息中的底层sdk返回的错误信息，并联系阿里云技术支持同学确认原因").build();
        NETWORKSDK_SPDY_CLOSE_ERROR = errorCodeBuild27;
        com.alibaba.sdk.android.error.ErrorCode errorCodeBuild28 = errorDefine.defineSdkError("-23").msg("发送数据返回错误").solution("请关注下错误信息中的底层sdk返回的错误信息，并联系阿里云技术支持同学确认原因").build();
        NETWORKSDK_SPDY_RES_ERROR = errorCodeBuild28;
        com.alibaba.sdk.android.error.ErrorCode errorCodeBuild29 = errorDefine.defineSdkError("-25").msg("不应该发生的错误").solution("请关注下错误信息，检查初始化是否存在错误").build();
        ERROR_SHOULD_NEVER_HAPPEN = errorCodeBuild29;
        com.alibaba.sdk.android.error.ErrorCode errorCodeBuild30 = errorDefine.defineSdkError("-26").msg("建连参数错误").solution("请检查初始化配置是否正确").build();
        NETWORK_INAPP_ARGS_INVALID = errorCodeBuild30;
        com.alibaba.sdk.android.error.ErrorCode errorCodeBuild31 = errorDefine.defineSdkError("-27").msg("建连超时").solution("请查看具体错误信息排查").solution("请检查网络是否正常").build();
        NETWORK_INAPP_TIMEOUT = errorCodeBuild31;
        com.alibaba.sdk.android.error.ErrorCode errorCodeBuild32 = errorDefine.defineSdkError("-28").msg("建连失败").solution("请查看具体错误信息排查").solution("请检查网络是否正常").build();
        NETWORK_INAPP_CONNECT_FAIL = errorCodeBuild32;
        com.alibaba.sdk.android.error.ErrorCode errorCodeBuild33 = errorDefine.defineSdkError("-29").msg("连接地址不存在").solution("当前网络下无法解析长链接地址").solution("请检查网络是否正常").build();
        NETWORK_INAPP_NO_STRATEGY = errorCodeBuild33;
        com.alibaba.sdk.android.error.ErrorCode errorCodeBuild34 = errorDefine.defineSdkError("-30").msg("建连异常").solution("请查看具体错误信息排查").build();
        NETWORK_INAPP_EXCEPTION = errorCodeBuild34;
        codes = new com.alibaba.sdk.android.error.ErrorCode[]{errorCodeBuild, errorCodeBuild2, errorCodeBuild3, errorCodeBuild4, errorCodeBuild5, errorCodeBuild6, errorCodeBuild7, errorCodeBuild8, errorCodeBuild9, errorCodeBuild10, errorCodeBuild11, errorCodeBuild12, errorCodeBuild13, errorCodeBuild14, errorCodeBuild15, errorCodeBuild16, errorCodeBuild17, errorCodeBuild18, errorCodeBuild19, errorCodeBuild20, errorCodeBuild21, errorCodeBuild22, errorCodeBuild23, errorCodeBuild24, errorCodeBuild25, errorCodeBuild26, errorCodeBuild27, errorCodeBuild28, errorCodeBuild29, errorCodeBuild30, errorCodeBuild31, errorCodeBuild32, errorCodeBuild33, errorCodeBuild34, convertNetworkSdkError(0, "底层网络库信息").solution("小于-10000时，加上10000是底层网络库对应的错误码，请接口底层网络库错误码信息排查").build()};
    }

    private static StringBuilder addThrowableInfo(StringBuilder sb, Throwable th) {
        while (true) {
            sb.append(th.getMessage());
            sb.append('\t');
            StackTraceElement[] stackTrace = th.getStackTrace();
            if (stackTrace != null && stackTrace.length > 0) {
                sb.append(stackTrace[0].getClassName());
                sb.append(Consts.DOT);
                sb.append(stackTrace[0].getMethodName());
                sb.append('\t');
                for (int i2 = 1; i2 < stackTrace.length; i2++) {
                    if (stackTrace[i2].getClassName().startsWith("com.taobao") || stackTrace[i2].getClassName().startsWith("com.aliyun") || stackTrace[i2].getClassName().startsWith("org.android.agoo") || stackTrace[i2].getClassName().startsWith("org.alibaba")) {
                        sb.append(stackTrace[i2].getClassName());
                        sb.append(Consts.DOT);
                        sb.append(stackTrace[i2].getMethodName());
                        sb.append("(");
                        sb.append(stackTrace[i2].getFileName());
                        sb.append(":");
                        sb.append(stackTrace[i2].getLineNumber());
                        sb.append(")");
                        sb.append('\t');
                        break;
                    }
                }
            }
            th = th.getCause();
            if (th == null) {
                return sb;
            }
            sb.append("caused by ");
            sb.append('\t');
        }
    }

    public static ErrorBuilder convertNetworkSdkError(int i2, String str) {
        return define.defineSdkError(String.valueOf(i2 - 10000)).msg(str);
    }

    public static String getAllDetails(String str) {
        return "[" + AccsState.getInstance().getState() + "][" + i.a().b() + "][" + GlobalAppRuntimeInfo.isAppBackground() + "]" + str;
    }

    public static String getExceptionInfo(Throwable th) {
        return th == null ? "throwable null" : addThrowableInfo(new StringBuilder(), th).toString();
    }

    public static boolean isChannelError(int i2) {
        return i2 == SPDY_CONNECTION_DISCONNECTED_WHEN_SEND_DATA.getCodeInt() || i2 == SPDY_AUTH_PARAM_ERROR.getCodeInt() || i2 == SPDY_AUTH_EXCEPTION.getCodeInt() || i2 == REQ_TIME_OUT.getCodeInt() || i2 == SPDY_CON_DISCONNECTED.getCodeInt() || i2 == INAPP_CON_DISCONNECTED.getCodeInt() || i2 == SPDY_PING_TIME_OUT.getCodeInt() || i2 == NETWORKSDK_SPDY_CLOSE_ERROR.getCodeInt() || i2 == NETWORK_INAPP_ARGS_INVALID.getCodeInt() || i2 == NETWORK_INAPP_TIMEOUT.getCodeInt() || i2 == NETWORK_INAPP_CONNECT_FAIL.getCodeInt() || i2 == NETWORK_INAPP_NO_STRATEGY.getCodeInt() || i2 == NETWORK_INAPP_EXCEPTION.getCodeInt();
    }

    public static com.alibaba.sdk.android.error.ErrorCode parseHttpCode(int i2) {
        if (i2 == 102) {
            return DM_TAIR_ERROR;
        }
        if (i2 == 200) {
            return SUCCESS;
        }
        switch (i2) {
            case 302:
                return DM_DEVICEID_INVALID;
            case 303:
                return DM_APPKEY_INVALID;
            case 304:
                return DM_PACKAGENAME_INVALID;
            default:
                return SERVER_UNKNOWN_ERROR.copy().detail("code:" + i2).build();
        }
    }

    public static void printErrorCode() {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("ACCS错误码，一共");
        com.alibaba.sdk.android.error.ErrorCode[] errorCodeArr = codes;
        sb2.append(errorCodeArr.length);
        sb2.append("个");
        sb.append(sb2.toString());
        sb.append('\n');
        sb.append(com.alibaba.sdk.android.error.ErrorCode.docTitle());
        sb.append(com.alibaba.sdk.android.error.ErrorCode.docContent(errorCodeArr));
        Log.w("ACCS_ERROR_CODE", sb.toString());
    }
}
