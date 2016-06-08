
package com.ikmr.banbara23.yaeyama_liner_register.annei;

import com.ikmr.banbara23.yaeyama_liner_register.Const;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;

/**
 * 指定した安栄の詳細を取得
 */
public class AnneiDetailApiClient {
    public static Observable<String> get(final String url) {
        return Observable
                .create(new Observable.OnSubscribe<Document>() {
                    @Override
                    public void call(Subscriber<? super Document> subscriber) {
                        Document document;
                        try {
                            document = Jsoup.connect(url).timeout(Const.CONNECTION_TIME_OUT).get();
                            subscriber.onNext(document);
                            subscriber.onCompleted();
                        } catch (IOException e) {
                            subscriber.onError(e);
                        }
                    }
                })
                .map(new Func1<Document, String>() {
                    @Override
                    public String call(Document document) {
                        return AnneiDetailParser.pars(document);
                    }
                });
    }
}
