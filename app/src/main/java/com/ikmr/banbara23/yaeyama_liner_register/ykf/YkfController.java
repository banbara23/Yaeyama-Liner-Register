package com.ikmr.banbara23.yaeyama_liner_register.ykf;

import android.util.Log;

import com.google.gson.Gson;
import com.ikmr.banbara23.yaeyama_liner_register.Base;
import com.ikmr.banbara23.yaeyama_liner_register.Const;
import com.ikmr.banbara23.yaeyama_liner_register.R;
import com.ikmr.banbara23.yaeyama_liner_register.entity.Result;
import com.ikmr.banbara23.yaeyama_liner_register.util.PreferenceUtils;
import com.nifty.cloud.mb.core.NCMBException;
import com.nifty.cloud.mb.core.NCMBObject;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

import rx.Subscriber;
import rx.schedulers.Schedulers;

import static com.ikmr.banbara23.yaeyama_liner_register.ykf.YkfListApiClient.post;

/**
 * ykfコントローラー
 */
public class YkfController {
    public static void start() {

        YkfListApiClient.request()
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Subscriber<Result>() {
                    @Override
                    public void onCompleted() {
                        // 完了
                        Log.d("YkfController", "YkfList:onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        // 失敗
                        Log.d("YkfController", "YkfList:onError");
                        Log.d("YkfController", "YkfList:e:" + e);
                    }

                    @Override
                    public void onNext(Result result) {
                        Log.d("YkfController", "YkfList:onNext");
                        // 取得成功
                        post(result);
                    }
                });
    }

    public void execute() {
        Result result = getListResult();
        sendResult(result);
    }

    private Result getListResult() {
        String url = Base.getString(R.string.url_ykf_list);
        try {
            Document document = Jsoup.connect(url).timeout(Const.CONNECTION_TIME_OUT).get();
            return YkfParser.pars(document);
        } catch (IOException e) {
            return null;
        }
    }

    private void sendResult(Result result) {
        String json = new Gson().toJson(result);
        String key = Base.getResources().getString(R.string.pref_ykf_result_key);
        if (isEqualForLastTime(json, key)) {
            return;
        }

        NCMBObject obj = new NCMBObject(Base.getResources().getString(R.string.NCMB_ykf_table));
        obj.put("result_json", json);

        try {
            obj.save();
            PreferenceUtils.put(key, json);
            Log.d("YkfListApiClient", "YkfList 送信成功");
            Log.d("YkfListApiClient", "result:" + result.toString());
        } catch (NCMBException e) {
            Log.e("YkfListApiClient", e.getMessage());
        }
    }

    /**
     * 前回のキャッシュと値を比較
     *
     * @param json 今回取得した値
     * @param key  前回値が保存されているキー
     * @return true:値が同じ false:違う
     */
    private static boolean isEqualForLastTime(String json, String key) {
        String lastTimeString = PreferenceUtils.get(key, "");
        return lastTimeString.equals(json);
    }
}
