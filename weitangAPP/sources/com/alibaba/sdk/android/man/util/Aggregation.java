package com.alibaba.sdk.android.man.util;

import com.alibaba.sdk.android.man.customperf.MANCustomPerformance;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: loaded from: classes.dex */
public class Aggregation {
    private static String tag = "MAN_Aggregation";
    private final String AGGREGATION_CUSTOM_PERFORMANCE_LABLE;
    private final String AGGREGATION_NETWORK_PERFORMANCE_LABLE;
    private final Map<String, AggregationSend> hashMap;
    private final ArrayList<String> networkDefineKey;
    private Timer timer;
    private AggregationTimerTask timerTask;
    private long totalNum;

    public class AggregationCustomPerf implements AggregationSend {
        private String eventLabel;
        private long duration = 0;
        private int count = 0;

        public AggregationCustomPerf(String str) {
            this.eventLabel = "";
            this.eventLabel = str;
        }

        public void addCustomPerf(long j) {
            this.duration += j;
            this.count++;
        }

        @Override // com.alibaba.sdk.android.man.util.Aggregation.AggregationSend
        public void send() {
            int i2 = this.count;
            if (i2 != 0) {
                EventCommitTool.commitEventToUT("UT", MANConfig.CUSTOM_PERFORMANCE_EVENT_ID, this.eventLabel, String.valueOf(i2), String.valueOf(this.duration / ((long) i2)), new HashMap());
            }
        }
    }

    public class AggregationNetworkPerformance implements AggregationSend {
        private long connectTimeCount;
        private long connectTimeSum;
        private long count;
        private long firstByteCount;
        private long firstByteSum;
        private String requestHost;
        private String requestMethod;
        private long requestRTSum;
        private long resourceBytesSum;

        private AggregationNetworkPerformance() {
            this.requestRTSum = 0L;
            this.connectTimeSum = 0L;
            this.firstByteSum = 0L;
            this.resourceBytesSum = 0L;
            this.connectTimeCount = 0L;
            this.firstByteCount = 0L;
            this.count = 0L;
            this.requestMethod = null;
            this.requestHost = null;
        }

        public void addNetworkPerformance(long j, long j2, long j3, long j4, String str, String str2) {
            if (j2 != -1) {
                this.connectTimeSum += j2;
                this.connectTimeCount++;
            }
            if (j3 != -1) {
                this.firstByteSum += j3;
                this.firstByteCount++;
            }
            this.resourceBytesSum += j4;
            this.requestRTSum += j;
            this.count++;
            this.requestHost = str2;
            this.requestMethod = str;
        }

        @Override // com.alibaba.sdk.android.man.util.Aggregation.AggregationSend
        public void send() {
            if (this.count == 0) {
                return;
            }
            HashMap map = new HashMap();
            long j = this.connectTimeCount;
            if (j != 0) {
                map.put(MANConfig.NETWORK_SINGLE_CONNECT_TIME_KEY, String.valueOf(this.connectTimeSum / j));
                map.put(MANConfig.NETWORK_AGGREGATION_CONNECTION_TIME_NUMBER_KEY, String.valueOf(this.connectTimeCount));
            }
            long j2 = this.firstByteCount;
            if (j2 != 0) {
                map.put(MANConfig.NETWORK_SINGLE_FIRST_PACKAGE_RT_KEY, String.valueOf(this.firstByteSum / j2));
                map.put(MANConfig.NETWORK_AGGREGATION_FIST_PACKAGE_NUMBER_KEY, String.valueOf(this.firstByteCount));
            }
            long j3 = this.count;
            if (j3 != 0) {
                map.put(MANConfig.NETWORK_SINGLE_REQUEST_RT_KEY, String.valueOf(this.requestRTSum / j3));
                map.put(MANConfig.NETWORK_AGGREGATION_PERFORMANCE_NUMBER_KEY, String.valueOf(this.count));
                map.put(MANConfig.NETWORK_SINGLE_REQUEST_SIZE_KEY, String.valueOf(this.resourceBytesSum / this.count));
            }
            String str = this.requestHost;
            if (str != null && !str.equals("")) {
                map.put("Host", this.requestHost);
            }
            String str2 = this.requestMethod;
            if (str2 != null && !str2.equals("")) {
                map.put(MANConfig.NETWORK_SINGLE_REQUEST_METHOD_KEY, this.requestMethod);
            }
            EventCommitTool.commitEventDirectly(3002, MANConfig.NETWORK_SIG_REQUEST_EVENT_LABEL, map);
        }
    }

    public interface AggregationSend {
        void send();
    }

    public class AggregationTimerTask extends TimerTask {
        private AggregationTimerTask() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            MANLog.Logi(Aggregation.tag, "timer alive.");
            Aggregation.getInstance().submitAggregation();
        }
    }

    public static class Singleton {
        public static Aggregation instance = new Aggregation();

        private Singleton() {
        }
    }

    private long convertTimeStr2Long(String str) {
        try {
            return Long.valueOf(str).longValue();
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }

    public static Aggregation getInstance() {
        return Singleton.instance;
    }

    private boolean isOnlyContainsDefineKey(Map<String, String> map) {
        if (map == null) {
            return false;
        }
        Iterator<String> it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!this.networkDefineKey.contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void submitAggregation() {
        synchronized (this.hashMap) {
            this.totalNum = 0L;
            Iterator<String> it = this.hashMap.keySet().iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (this.hashMap.get(next) != null) {
                    this.hashMap.get(next).send();
                }
                it.remove();
            }
        }
    }

    public boolean addCustomPerfToAggregation(MANCustomPerformance mANCustomPerformance) {
        if (mANCustomPerformance.getProperties() != null && mANCustomPerformance.getProperties().size() != 0) {
            return false;
        }
        String str = "AGGREGATION_66602" + mANCustomPerformance.getEventLabel();
        synchronized (this.hashMap) {
            AggregationCustomPerf aggregationCustomPerf = (AggregationCustomPerf) this.hashMap.get(str);
            if (aggregationCustomPerf == null) {
                aggregationCustomPerf = new AggregationCustomPerf(mANCustomPerformance.getEventLabel());
                this.hashMap.put(str, aggregationCustomPerf);
            }
            aggregationCustomPerf.addCustomPerf(mANCustomPerformance.getDuration());
            long j = this.totalNum + 1;
            this.totalNum = j;
            if (j >= 100) {
                submitAggregation();
            }
        }
        return true;
    }

    public boolean addToNetPerfAggregation(Map<String, String> map) {
        long jLongValue;
        if (!isOnlyContainsDefineKey(map)) {
            return false;
        }
        long jConvertTimeStr2Long = convertTimeStr2Long(map.get(MANConfig.NETWORK_SINGLE_CONNECT_TIME_KEY));
        long jConvertTimeStr2Long2 = convertTimeStr2Long(map.get(MANConfig.NETWORK_SINGLE_FIRST_PACKAGE_RT_KEY));
        long jConvertTimeStr2Long3 = convertTimeStr2Long(map.get(MANConfig.NETWORK_SINGLE_REQUEST_RT_KEY));
        try {
            jLongValue = Long.valueOf(map.get(MANConfig.NETWORK_SINGLE_REQUEST_SIZE_KEY)).longValue();
        } catch (NumberFormatException unused) {
            jLongValue = 0;
        }
        long j = jLongValue;
        String str = "AGGREGATION_3002" + map.get("Host") + map.get(MANConfig.NETWORK_SINGLE_REQUEST_METHOD_KEY);
        synchronized (this.hashMap) {
            AggregationNetworkPerformance aggregationNetworkPerformance = (AggregationNetworkPerformance) this.hashMap.get(str);
            if (aggregationNetworkPerformance != null) {
                aggregationNetworkPerformance.addNetworkPerformance(jConvertTimeStr2Long3, jConvertTimeStr2Long, jConvertTimeStr2Long2, j, map.get(MANConfig.NETWORK_SINGLE_REQUEST_METHOD_KEY), map.get("Host"));
            } else {
                AggregationNetworkPerformance aggregationNetworkPerformance2 = new AggregationNetworkPerformance();
                aggregationNetworkPerformance2.addNetworkPerformance(jConvertTimeStr2Long3, jConvertTimeStr2Long, jConvertTimeStr2Long2, j, map.get(MANConfig.NETWORK_SINGLE_REQUEST_METHOD_KEY), map.get("Host"));
                this.hashMap.put(str, aggregationNetworkPerformance2);
            }
            long j2 = this.totalNum + 1;
            this.totalNum = j2;
            if (j2 >= 100) {
                submitAggregation();
            }
        }
        return true;
    }

    private Aggregation() {
        this.AGGREGATION_NETWORK_PERFORMANCE_LABLE = "AGGREGATION_3002";
        this.AGGREGATION_CUSTOM_PERFORMANCE_LABLE = "AGGREGATION_66602";
        this.totalNum = 0L;
        this.hashMap = new LinkedHashMap<String, AggregationSend>() { // from class: com.alibaba.sdk.android.man.util.Aggregation.1
            private static final long serialVersionUID = 201503121136L;

            @Override // java.util.LinkedHashMap
            public boolean removeEldestEntry(Map.Entry<String, AggregationSend> entry) {
                return size() > 200;
            }
        };
        ArrayList<String> arrayList = new ArrayList<>();
        this.networkDefineKey = arrayList;
        arrayList.add(MANConfig.NETWORK_SINGLE_CONNECT_TIME_KEY);
        arrayList.add(MANConfig.NETWORK_SINGLE_FIRST_PACKAGE_RT_KEY);
        arrayList.add(MANConfig.NETWORK_SINGLE_REQUEST_RT_KEY);
        arrayList.add(MANConfig.NETWORK_SINGLE_REQUEST_SIZE_KEY);
        arrayList.add("Host");
        arrayList.add(MANConfig.NETWORK_SINGLE_REQUEST_METHOD_KEY);
        this.timerTask = new AggregationTimerTask();
        Timer timer = new Timer();
        this.timer = timer;
        timer.schedule(this.timerTask, 30000L, 30000L);
    }
}
