package com.ut.mini;

import android.text.TextUtils;
import com.alibaba.mtl.log.d.i;
import com.alibaba.mtl.log.d.q;
import com.alibaba.mtl.log.model.LogField;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class UTHitBuilders {

    public static class UTCustomHitBuilder extends UTHitBuilder {
        public UTCustomHitBuilder(String str) {
            if (!TextUtils.isEmpty(str)) {
                super.setProperty(UTHitBuilder.FIELD_ARG1, str);
            }
            super.setProperty(UTHitBuilder.FIELD_EVENT_ID, "19999");
            super.setProperty(UTHitBuilder.FIELD_ARG3, "0");
        }

        @Override // com.ut.mini.UTHitBuilders.UTHitBuilder
        public Map<String, String> build() {
            Map<String, String> mapBuild = super.build();
            if (mapBuild == null) {
                return mapBuild;
            }
            LogField logField = LogField.PAGE;
            String str = mapBuild.get(logField.toString());
            LogField logField2 = LogField.ARG1;
            String str2 = mapBuild.get(logField2.toString());
            if (str2 == null) {
                return mapBuild;
            }
            mapBuild.remove(logField2.toString());
            mapBuild.remove(logField.toString());
            Map<String, String> mapB = q.b(mapBuild);
            mapB.put(logField2.toString(), str2);
            mapB.put(logField.toString(), str);
            return mapB;
        }

        public UTCustomHitBuilder setDurationOnEvent(long j) {
            if (j < 0) {
                j = 0;
            }
            super.setProperty(UTHitBuilder.FIELD_ARG3, "" + j);
            return this;
        }

        public UTCustomHitBuilder setEventPage(String str) {
            if (!TextUtils.isEmpty(str)) {
                super.setProperty(UTHitBuilder.FIELD_PAGE, str);
            }
            return this;
        }
    }

    public static class UTHitBuilder {
        public static final String FIELD_ARG1 = "_field_arg1";
        public static final String FIELD_ARG2 = "_field_arg2";
        public static final String FIELD_ARG3 = "_field_arg3";
        public static final String FIELD_ARGS = "_field_args";
        public static final String FIELD_EVENT_ID = "_field_event_id";
        public static final String FIELD_PAGE = "_field_page";
        private Map<String, String> y;

        public UTHitBuilder() {
            HashMap map = new HashMap();
            this.y = map;
            if (map.containsKey(FIELD_PAGE)) {
                return;
            }
            this.y.put(FIELD_PAGE, "UT");
        }

        private static boolean a(Map<String, String> map) {
            if (map == null) {
                return true;
            }
            if (map.containsKey(null)) {
                map.remove(null);
            }
            if (map.containsKey("")) {
                map.remove("");
            }
            if (map.containsKey(LogField.PAGE.toString())) {
                i.a("checkIlleagleProperty", "IlleaglePropertyKey(PAGE) is setted when you call the method setProperty or setProperties ,please use another key to replace it!");
                return false;
            }
            if (map.containsKey(LogField.EVENTID.toString())) {
                i.a("checkIlleagleProperty", "IlleaglePropertyKey(EVENTID) is setted when you call the method setProperty or setProperties ,please use another key to replace it!");
                return false;
            }
            if (map.containsKey(LogField.ARG1.toString())) {
                i.a("checkIlleagleProperty", "IlleaglePropertyKey(ARG1) is setted when you call the method setProperty or setProperties ,please use another key to replace it!");
                return false;
            }
            if (map.containsKey(LogField.ARG2.toString())) {
                i.a("checkIlleagleProperty", "IlleaglePropertyKey(ARG2) is setted when you call the method setProperty or setProperties ,please use another key to replace it!");
                return false;
            }
            if (!map.containsKey(LogField.ARG3.toString())) {
                return true;
            }
            i.a("checkIlleagleProperty", "IlleaglePropertyKey(ARG3) is setted when you call the method setProperty or setProperties ,please use another key to replace it!");
            return false;
        }

        private static void d(Map<String, String> map) {
            if (map != null) {
                if (map.containsKey(FIELD_PAGE)) {
                    String str = map.get(FIELD_PAGE);
                    map.remove(FIELD_PAGE);
                    map.put(LogField.PAGE.toString(), str);
                }
                if (map.containsKey(FIELD_ARG1)) {
                    String str2 = map.get(FIELD_ARG1);
                    map.remove(FIELD_ARG1);
                    map.put(LogField.ARG1.toString(), str2);
                }
                if (map.containsKey(FIELD_ARG2)) {
                    String str3 = map.get(FIELD_ARG2);
                    map.remove(FIELD_ARG2);
                    map.put(LogField.ARG2.toString(), str3);
                }
                if (map.containsKey(FIELD_ARG3)) {
                    String str4 = map.get(FIELD_ARG3);
                    map.remove(FIELD_ARG3);
                    map.put(LogField.ARG3.toString(), str4);
                }
                if (map.containsKey(FIELD_ARGS)) {
                    String str5 = map.get(FIELD_ARGS);
                    map.remove(FIELD_ARGS);
                    map.put(LogField.ARGS.toString(), str5);
                }
                if (map.containsKey(FIELD_EVENT_ID)) {
                    String str6 = map.get(FIELD_EVENT_ID);
                    map.remove(FIELD_EVENT_ID);
                    map.put(LogField.EVENTID.toString(), str6);
                }
            }
        }

        private static void e(Map<String, String> map) {
            if (map != null) {
                LogField logField = LogField.PAGE;
                if (map.containsKey(logField.toString())) {
                    map.remove(logField.toString());
                }
                LogField logField2 = LogField.EVENTID;
                if (map.containsKey(logField2.toString())) {
                    map.remove(logField2.toString());
                }
                LogField logField3 = LogField.ARG1;
                if (map.containsKey(logField3.toString())) {
                    map.remove(logField3.toString());
                }
                LogField logField4 = LogField.ARG2;
                if (map.containsKey(logField4.toString())) {
                    map.remove(logField4.toString());
                }
                LogField logField5 = LogField.ARG3;
                if (map.containsKey(logField5.toString())) {
                    map.remove(logField5.toString());
                }
                LogField logField6 = LogField.ARGS;
                if (map.containsKey(logField6.toString())) {
                    map.remove(logField6.toString());
                }
            }
        }

        public Map<String, String> build() {
            HashMap map = new HashMap();
            map.putAll(this.y);
            if (!a(map)) {
                return null;
            }
            e(map);
            d(map);
            if (map.containsKey(LogField.EVENTID.toString())) {
                return map;
            }
            return null;
        }

        public String getProperty(String str) {
            if (str == null || !this.y.containsKey(str)) {
                return null;
            }
            return this.y.get(str);
        }

        public UTHitBuilder setProperties(Map<String, String> map) {
            if (map != null) {
                this.y.putAll(map);
            }
            return this;
        }

        public UTHitBuilder setProperty(String str, String str2) {
            if (TextUtils.isEmpty(str) || str2 == null) {
                i.a("setProperty", "key is null or key is empty or value is null,please check it!");
            } else {
                if (this.y.containsKey(str)) {
                    this.y.remove(str);
                }
                this.y.put(str, str2);
            }
            return this;
        }
    }

    public static class UTPageHitBuilder extends UTHitBuilder {
        public UTPageHitBuilder(String str) {
            if (!TextUtils.isEmpty(str)) {
                super.setProperty(UTHitBuilder.FIELD_PAGE, str);
            }
            super.setProperty(UTHitBuilder.FIELD_EVENT_ID, "2001");
            super.setProperty(UTHitBuilder.FIELD_ARG3, "0");
        }

        public UTPageHitBuilder setDurationOnPage(long j) {
            if (j < 0) {
                j = 0;
            }
            super.setProperty(UTHitBuilder.FIELD_ARG3, "" + j);
            return this;
        }

        public UTPageHitBuilder setReferPage(String str) {
            if (!TextUtils.isEmpty(str)) {
                super.setProperty(UTHitBuilder.FIELD_ARG1, str);
            }
            return this;
        }
    }

    public static class UTControlHitBuilder extends UTHitBuilder {
        public UTControlHitBuilder(String str) {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("Control name can not be empty.");
            }
            String currentPageName = UTPageHitHelper.getInstance().getCurrentPageName();
            if (TextUtils.isEmpty(currentPageName)) {
                throw new IllegalArgumentException("Please call in at PageAppear and PageDisAppear.");
            }
            super.setProperty(UTHitBuilder.FIELD_PAGE, currentPageName);
            super.setProperty(UTHitBuilder.FIELD_EVENT_ID, "2101");
            super.setProperty(UTHitBuilder.FIELD_ARG1, currentPageName + "_" + str);
        }

        public UTControlHitBuilder(String str, String str2) {
            if (!TextUtils.isEmpty(str2)) {
                if (!TextUtils.isEmpty(str)) {
                    super.setProperty(UTHitBuilder.FIELD_PAGE, str);
                    super.setProperty(UTHitBuilder.FIELD_EVENT_ID, "2101");
                    super.setProperty(UTHitBuilder.FIELD_ARG1, str + "_" + str2);
                    return;
                }
                throw new IllegalArgumentException("Page name can not be empty.");
            }
            throw new IllegalArgumentException("Control name can not be empty.");
        }
    }
}
