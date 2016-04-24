package jp.fbc.yowbow.data.api;

import java.io.Serializable;

import jp.fbc.yowbow.data.model.SampleJson;

/**
 *
 * sampleAPIを取得するためのインターフェース
 * Created by MBPU on 2016/03/06.
 */
public abstract class ApiConnect implements Serializable {

    public static final String REQUEST_DOMAIN = "http://fbc-web.heteml.jp";
    public static final String REQUEST_PATH = "/yowbow_test/json/yowbow_sample.json";
    public static final String REQUEST_QUERY = "";


    public interface sampleListener {
        /**
         * JSONの文字列を返す場合
         *
         * @param msg JSONの文字列
         */
        public void onSuccess(String msg);

        /**
         * JSONのインスタンスを返す場合
         *
         * @param json JSONのインスタンス
         */
        public void onSuccess(SampleJson json);

        /**
         * 失敗
         *
         * @param error 失敗メッセージ
         */
        public void onFailed(String error);

    }

    /**
     * ネットワークの実装を行う。
     *
     * @param listener 返すリスナー
     */
    public abstract void request(final sampleListener listener);


}
