package jp.fbc.yowbow.data.wrapper;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Callback;


/**
 *
 *
 * Created by MBPU on 2016/03/05.
 */
public class OkHttpWrapper {
    /**
     * 呼び出し元に返すリスナー
     */
    public interface OkHttpListener {
        /**
         * 失敗
         * @param request 返すものそのまま
         * @param e 返すものそのまま
         */
        public void onFailure(Request request, IOException e);

        /**
         * 成功
         * @param response 返すものそのまま
         */
        public void onResponse(Response response) throws IOException;
    }

    public OkHttpWrapper() {

    }

    /**
     * enqueueする
     * @param url URL
     * @param listener 返すリスナー
     */
    public void enqueue(final String url, final OkHttpListener listener) {
        final Request request = new Request.Builder()
                .url(url)
                .get()
                .build();
        OkHttpClient client = new OkHttpClient();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                listener.onFailure(request, e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                listener.onResponse(response);

            }

        });
    }

}
