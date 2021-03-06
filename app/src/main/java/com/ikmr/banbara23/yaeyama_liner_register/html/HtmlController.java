package com.ikmr.banbara23.yaeyama_liner_register.html;

import android.util.Log;

import com.google.gson.Gson;
import com.ikmr.banbara23.yaeyama_liner_register.Base;
import com.ikmr.banbara23.yaeyama_liner_register.R;
import com.ikmr.banbara23.yaeyama_liner_register.entity.Company;
import com.ikmr.banbara23.yaeyama_liner_register.util.CashUtil;
import com.ikmr.banbara23.yaeyama_liner_register.util.PreferenceUtils;
import com.nifty.cloud.mb.core.DoneCallback;
import com.nifty.cloud.mb.core.NCMBException;
import com.nifty.cloud.mb.core.NCMBObject;

import rx.functions.Action1;

public class HtmlController {

    public static void start() {
        try {
            // 安栄
            startAnnei();

            //ykf
            startYkf();

            //dream
            startDream();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * あんえい html
     */
    private static void startAnnei() {
        HTMLClient.getHtml(Base.getResources().getString(R.string.url_annei_list))
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String html) {
                        saveLocalAndServer(Company.ANNEI, html);
                    }
                });
    }

    private static void startYkf() {
        HTMLClient.getHtml(Base.getResources().getString(R.string.url_ykf_list))
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String html) {
                        saveLocalAndServer(Company.YKF, html);
                    }
                });
    }

    private static void startDream() {
        HTMLClient.getHtml(Base.getResources().getString(R.string.url_dream_list))
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String html) {
                        saveLocalAndServer(Company.DREAM, html);
                    }
                });
    }

    /**
     * ローカルに保存＆送信
     *
     * @param company 会社
     * @param value   HTML
     */
    private static void saveLocalAndServer(final Company company, final String value) {

        final Html html = new Html();
        html.setCompany(company);
        html.setHtml(value);

        final String json = new Gson().toJson(html);

        final String key = company.getCompany();
        if (CashUtil.isEqualForLastTime(json, key)) {
            // 前回の結果と同じ値なら送信しない
            return;
        }
        NCMBObject obj = new NCMBObject("HtmlHistory");
        obj.put("company", company.getCompany());
        obj.put("html", value);
        obj.saveInBackground(new DoneCallback() {
            @Override
            public void done(NCMBException e) {
                if (e == null) {
                    // 保存成功
                    Log.d("HtmlController", company.getCompanyName() + " html送信成功");
                    PreferenceUtils.put(key, json);
                } else {
                    // 保存失敗
                    Log.d("HtmlController", company.getCompanyName() + "html送信失敗 :" + e);
                }
            }
        });
    }
}
