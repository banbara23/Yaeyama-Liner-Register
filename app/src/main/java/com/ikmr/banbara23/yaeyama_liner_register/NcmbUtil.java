package com.ikmr.banbara23.yaeyama_liner_register;

import android.util.Log;

import com.google.gson.Gson;
import com.ikmr.banbara23.yaeyama_liner_register.entity.LinerStatusList;
import com.nifty.cloud.mb.core.DoneCallback;
import com.nifty.cloud.mb.core.NCMBException;
import com.nifty.cloud.mb.core.NCMBObject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class NcmbUtil {

    /**
     * 現在の日付から年月日IDを作成
     *
     * @return 年月日ID
     */
    public static String getLinerId() {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd", Locale.JAPAN);
        return simpleDateFormat.format(date);
    }

    public static void saveRequest(LinerStatusList linerStatusList, final String tableName) {
        NCMBObject obj = new NCMBObject(tableName);
        String json = new Gson().toJson(linerStatusList);
        obj.put("result_json", json);

        obj.saveInBackground(new DoneCallback() {
            @Override
            public void done(NCMBException e) {
                if (e == null) {
                    // 保存成功
                    Log.d("NcmbUtil#saveRequest", tableName + " 送信成功");
                } else {
                    // 保存失敗
                    Log.d("NcmbUtil#saveRequest", tableName + " 送信失敗 :" + e);
                    Log.e("NcmbUtil#saveRequest", e.getMessage());
                }
            }
        });
    }
}
