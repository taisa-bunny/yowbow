package jp.fbc.yowbow.data.api;

import java.io.IOException;

import jp.fbc.yowbow.data.wrapper.OkHttpWrapper;
import okhttp3.Request;
import okhttp3.Response;

/**
 *
 * OkHttpを使ってリクエストを行う。
 * Created by MBPU on 2016/03/06.
 */
public class ApiConnectOkHttp extends ApiConnect {

    @Override
    public void request(final sampleListener listener){

        String requestUrl = REQUEST_DOMAIN + REQUEST_PATH + "?" + REQUEST_QUERY ;

        OkHttpWrapper okHttpWrapper = new OkHttpWrapper();
        okHttpWrapper.enqueue(requestUrl,
                new OkHttpWrapper.OkHttpListener() {
                    @Override
                    public void onFailure(Request request, IOException e) {
                        e.printStackTrace();
                        listener.onFailed(request.toString());
                    }

                    @Override
                    public void onResponse(Response response) throws IOException {
                        listener.onSuccess(response.body().string());
                    }
                });


    }


}
