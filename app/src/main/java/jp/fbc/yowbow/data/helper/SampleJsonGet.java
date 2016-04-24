package jp.fbc.yowbow.data.helper;

import jp.fbc.yowbow.data.api.ApiConnect;
import jp.fbc.yowbow.data.model.SampleJson;

/**
 * samplejsonを取得
 * Created by MBPU on 2016/03/08.
 */
public class SampleJsonGet {

    public SampleJsonGet() {

    }

    public void getServerJson(ApiConnect connect, final ApiConnect.sampleListener listener) {

        connect.request(listener);

    }
}
