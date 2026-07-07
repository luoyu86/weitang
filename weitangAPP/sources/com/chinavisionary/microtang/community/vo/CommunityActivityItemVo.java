package com.chinavisionary.microtang.community.vo;

import c.e.a.d.x;
import c.e.a.d.z;
import com.chinavisionary.core.app.net.base.dto.BaseVo;
import com.chinavisionary.framework.mobile.common.vo.ResourceVo;
import com.chinavisionary.microtang.R;

/* JADX INFO: loaded from: classes.dex */
public class CommunityActivityItemVo extends BaseVo {
    public static final int CAN_JOIN_STATE = 1;
    public static final int COMMUNITY_ACTIVITY_END_SPLIT_ITEM = 123;
    public static final int COMMUNITY_ACTIVITY_ITEM = 122;
    public static final int COMPLETE_STATE = 3;
    public static final int PROGRESS_STATE = 2;
    private static final int SHOW_JOIN_BTN = 1;
    private static final int SHOW_SIGN_BTN = 2;
    private String activityAddress;
    private Long activityEndTime;
    public String activityLab;
    private String activityName;
    private String activityObjectDesc;
    private int activityPersonNumber;
    private Long activityStartTime;
    private int activityStatus;
    private String activityStatusDesc;
    private Long applyEndTime;
    private Long applyStartTime;
    private String communityName;
    private Integer currentStatus;
    private String day;
    public String distance;
    private boolean finishFlag;
    private String hour;
    private String href;
    private String key;
    private ResourceVo logo;
    private int maxNumber;
    private String minute;
    private String publisher;
    private int realNumber;
    private String second;
    private int viewType = 122;

    private String addZeroPrefix(long j) {
        if (j >= 10) {
            return String.valueOf(j);
        }
        return "0" + j;
    }

    private String getActivityTimer() {
        long jLongValue = this.applyEndTime.longValue() - System.currentTimeMillis();
        return jLongValue >= 0 ? x.getString(R.string.placeholder_activity_timer, z.getSurplusToTime(Long.valueOf(jLongValue / 1000))) : "";
    }

    private boolean isJoinOverdue() {
        Long l = this.applyEndTime;
        return l == null || this.applyStartTime == null || l.longValue() <= System.currentTimeMillis() || this.applyStartTime.longValue() >= System.currentTimeMillis();
    }

    public String activityStatusDesc() {
        Long l;
        long jCurrentTimeMillis = System.currentTimeMillis();
        Long l2 = this.activityEndTime;
        if (l2 != null && l2.longValue() < jCurrentTimeMillis) {
            setFinishFlag(true);
            return "已结束";
        }
        if (this.finishFlag) {
            return "已结束";
        }
        Long l3 = this.applyStartTime;
        return ((l3 == null || this.activityStartTime == null || this.applyEndTime == null || jCurrentTimeMillis <= l3.longValue() || jCurrentTimeMillis >= this.applyEndTime.longValue() || this.activityStartTime.longValue() <= jCurrentTimeMillis) && (l = this.activityStartTime) != null && this.activityEndTime != null && l.longValue() <= jCurrentTimeMillis && jCurrentTimeMillis <= this.activityEndTime.longValue()) ? "进行中" : "";
    }

    public String activityTimerValue() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        Long l = this.activityEndTime;
        if (l != null && l.longValue() < jCurrentTimeMillis) {
            setFinishFlag(true);
            return null;
        }
        if (this.finishFlag) {
            return null;
        }
        Long l2 = this.applyStartTime;
        if (l2 != null && this.activityStartTime != null && this.applyEndTime != null && jCurrentTimeMillis > l2.longValue() && jCurrentTimeMillis < this.applyEndTime.longValue() && this.activityStartTime.longValue() > jCurrentTimeMillis) {
            getTimeDiff(this.applyEndTime.longValue(), jCurrentTimeMillis);
            return "距离报名结束";
        }
        Long l3 = this.activityStartTime;
        if (l3 == null || this.activityEndTime == null || l3.longValue() > jCurrentTimeMillis || jCurrentTimeMillis <= this.activityEndTime.longValue()) {
        }
        return null;
    }

    public String getActivityAddress() {
        return this.activityAddress;
    }

    public Long getActivityEndTime() {
        return this.activityEndTime;
    }

    public String getActivityLab() {
        return this.activityLab;
    }

    public String getActivityName() {
        return this.activityName;
    }

    public String getActivityObjectDesc() {
        return this.activityObjectDesc;
    }

    public int getActivityPersonNumber() {
        return this.realNumber;
    }

    public Long getActivityStartTime() {
        return this.activityStartTime;
    }

    public int getActivityStatus() {
        return this.activityStatus;
    }

    public Long getApplyEndTime() {
        return this.applyEndTime;
    }

    public Long getApplyStartTime() {
        return this.applyStartTime;
    }

    public String getCommunityName() {
        return this.communityName;
    }

    public ResourceVo getCoverRes() {
        return this.logo;
    }

    public Integer getCurrentStatus() {
        return this.currentStatus;
    }

    public String getDay() {
        return this.day;
    }

    public String getDistance() {
        return this.distance;
    }

    public boolean getFinishFlag() {
        return this.finishFlag;
    }

    public String getHour() {
        return this.hour;
    }

    public String getHref() {
        return this.href;
    }

    public String getKey() {
        return this.key;
    }

    public ResourceVo getLogo() {
        return this.logo;
    }

    public int getMaxNumber() {
        return this.maxNumber;
    }

    public String getMinute() {
        return this.minute;
    }

    public String getPublisher() {
        return this.communityName;
    }

    public int getRealNumber() {
        return this.realNumber;
    }

    public String getSecond() {
        return this.second;
    }

    public String getShowEndDate() {
        return z.isEqualsYear(getActivityStartTime(), getActivityEndTime()) ? z.isEqualsDay(getActivityStartTime(), getActivityEndTime()) ? z.getTime(getActivityEndTime(), z.l) : z.getMMDDHHMMTime(getActivityEndTime()) : z.getYYYYMMDDHHMMTime(getActivityEndTime());
    }

    public String getShowStartDate() {
        return z.isEqualsYear(getActivityStartTime(), getActivityEndTime()) ? z.getMMDDHHMMTime(getActivityStartTime()) : z.getYYYYMMDDHHMMTime(getActivityStartTime());
    }

    public String getTimeDiff(long j, long j2) {
        long jCurrentTimeMillis = j - System.currentTimeMillis();
        long j3 = jCurrentTimeMillis / 86400000;
        long j4 = jCurrentTimeMillis % 86400000;
        long j5 = j4 / 3600000;
        long j6 = j4 % 3600000;
        long j7 = j6 / 60000;
        long j8 = (j6 % 60000) / 1000;
        if (j3 > 0) {
            setDay(addZeroPrefix(j3));
            setHour(addZeroPrefix(j5));
            setMinute(addZeroPrefix(j7));
            setSecond(addZeroPrefix(j8));
            return j3 + "天" + j5 + "时" + j7 + "分" + j8 + "秒";
        }
        if (j5 > 0) {
            setHour(addZeroPrefix(j5));
            setMinute(addZeroPrefix(j7));
            setSecond(addZeroPrefix(j8));
            return j5 + "时" + j7 + "分" + j8 + "秒";
        }
        if (j7 <= 0) {
            if (j8 <= 0) {
                return "";
            }
            setSecond(addZeroPrefix(j8));
            return j8 + "秒";
        }
        setMinute(addZeroPrefix(j7));
        setSecond(addZeroPrefix(j8));
        return j7 + "分" + j8 + "秒";
    }

    public int getViewType() {
        return this.viewType;
    }

    public boolean isShowBtn() {
        return isShowJoin();
    }

    public boolean isShowJoin() {
        Long l = this.applyEndTime;
        return (l == null || this.applyStartTime == null || l.longValue() <= System.currentTimeMillis() || this.applyStartTime.longValue() >= System.currentTimeMillis() || joinPersonIsFull()) ? false : true;
    }

    public boolean isShowSign() {
        Integer num = this.currentStatus;
        return num != null && num.intValue() == 2;
    }

    public boolean joinPersonIsFull() {
        return this.maxNumber <= this.realNumber;
    }

    public void setActivityAddress(String str) {
        this.activityAddress = str;
    }

    public void setActivityEndTime(Long l) {
        this.activityEndTime = l;
    }

    public void setActivityLab(String str) {
        this.activityLab = str;
    }

    public void setActivityName(String str) {
        this.activityName = str;
    }

    public void setActivityObjectDesc(String str) {
        this.activityObjectDesc = str;
    }

    public void setActivityPersonNumber(int i2) {
        this.activityPersonNumber = i2;
    }

    public void setActivityStartTime(Long l) {
        this.activityStartTime = l;
    }

    public void setActivityStatus(int i2) {
        this.activityStatus = i2;
    }

    public void setActivityStatusDesc(String str) {
        this.activityStatusDesc = str;
    }

    public void setApplyEndTime(Long l) {
        this.applyEndTime = l;
    }

    public void setApplyStartTime(Long l) {
        this.applyStartTime = l;
    }

    public void setCommunityName(String str) {
        this.communityName = str;
    }

    public void setCurrentStatus(Integer num) {
        this.currentStatus = num;
    }

    public void setDay(String str) {
        this.day = str;
    }

    public void setDistance(String str) {
        this.distance = str;
    }

    public void setFinishFlag(boolean z) {
        this.finishFlag = z;
    }

    public void setHour(String str) {
        this.hour = str;
    }

    public void setHref(String str) {
        this.href = str;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setLogo(ResourceVo resourceVo) {
        this.logo = resourceVo;
    }

    public void setMaxNumber(int i2) {
        this.maxNumber = i2;
    }

    public void setMinute(String str) {
        this.minute = str;
    }

    public void setPublisher(String str) {
        this.publisher = str;
    }

    public void setRealNumber(int i2) {
        this.realNumber = i2;
    }

    public void setSecond(String str) {
        this.second = str;
    }

    public void setViewType(int i2) {
        this.viewType = i2;
    }
}
