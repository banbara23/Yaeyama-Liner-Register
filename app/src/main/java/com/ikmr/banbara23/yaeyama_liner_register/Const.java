
package com.ikmr.banbara23.yaeyama_liner_register;

/**
 * 定数クラス
 */
public class Const {
    // 通信全般のタイムアウト 10秒, Jsoupのデフォルトは3秒
    // http://jsoup.org/apidocs/org/jsoup/Connection.html
    public static final int CONNECTION_TIME_OUT = 10000;

    // 一覧の値
    public static final String PREF_ANNEI_LIST_KEY = "PREF_ANNEI_LIST_KEY";
    public static final String PREF_YKF_LIST_KEY = "PREF_YKF_LIST_KEY";
    public static final String PREF_DREAM_LIST_KEY = "PREF_DREAM_LIST_KEY";
    public static final String PREF_ANNEI_DETAIL_KEY = "PREF_ANNEI_DETAIL_KEY";

    // 一覧のタイムスタンプ
    public static final String TIMESTAMP_ANNEI_LIST_KEY = "TIMESTAMP_ANNEI_LIST_KEY";
    public static final String TIMESTAMP_YKF_LIST_KEY = "TIMESTAMP_YKF_LIST_KEY";
    public static final String TIMESTAMP_DREAM_LIST_KEY = "TIMESTAMP_DREAM_LIST_KEY";

    // 設定画面で設定するキャッシュ設定値
    public static final String CACHE_CHECKBOX_PREFERENCE = "cache_checkbox_preference";

    // 詳細の値
    public static final String PREF_ANNEI_DETAIL_TAKETOMI_KEY = "PREF_ANNEI_DETAIL_TAKETOMI_KEY";
    public static final String PREF_ANNEI_DETAIL_KOHAMA_KEY = "PREF_ANNEI_DETAIL_KOHAMA_KEY";
    public static final String PREF_ANNEI_DETAIL_KUROSHIMA_KEY = "PREF_ANNEI_DETAIL_KUROSHIMA_KEY";
    public static final String PREF_ANNEI_DETAIL_OOHARA_KEY = "PREF_ANNEI_DETAIL_OOHARA_KEY";
    public static final String PREF_ANNEI_DETAIL_UEHARA_KEY = "PREF_ANNEI_DETAIL_UEHARA_KEY";
    public static final String PREF_ANNEI_DETAIL_HATOMA_KEY = "PREF_ANNEI_DETAIL_HATOMA_KEY";
    public static final String PREF_ANNEI_DETAIL_HATERUMA_KEY = "PREF_ANNEI_DETAIL_HATERUMA_KEY";

    // 詳細のタイムスタンプ
    public static final String TIMESTAMP_ANNEI_DETAIL_TAKETOMI_KEY = "TIMESTAMP_ANNEI_DETAIL_TAKETOMI_KEY";
    public static final String TIMESTAMP_ANNEI_DETAIL_KOHAMA_KEY = "TIMESTAMP_ANNEI_DETAIL_KOHAMA_KEY";
    public static final String TIMESTAMP_ANNEI_DETAIL_KUROSHIMA_KEY = "TIMESTAMP_ANNEI_DETAIL_KUROSHIMA_KEY";
    public static final String TIMESTAMP_ANNEI_DETAIL_OOHARA_KEY = "TIMESTAMP_ANNEI_DETAIL_OOHARA_KEY";
    public static final String TIMESTAMP_ANNEI_DETAIL_UEHARA_KEY = "TIMESTAMP_ANNEI_DETAIL_UEHARA_KEY";
    public static final String TIMESTAMP_ANNEI_DETAIL_HATOMA_KEY = "TIMESTAMP_ANNEI_DETAIL_HATOMA_KEY";
    public static final String TIMESTAMP_ANNEI_DETAIL_HATERUMA_KEY = "TIMESTAMP_ANNEI_DETAIL_HATERUMA_KEY";

    // キャッシュの保存時間(分)
    public static final int SAVE_TIME = 3;

    public class NcmbTable {
        public final static String ANEI_LIST_TABLE = "AneiLinerStatusList";
        public final static String ANEI_DETAIL_TABLE = "AneiLinerStatusDetail";
    }
    public class NcmbColumn {
        public final static String UPDATE_DATE = "updateDate";
        public final static String LINER_ID = "linerId";
        public final static String JSON = "json";
    }

}
