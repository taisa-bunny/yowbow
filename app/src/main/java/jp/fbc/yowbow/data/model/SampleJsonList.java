package jp.fbc.yowbow.data.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * 不要になったっぽい（2016/3/13
 * Created by MBPU on 2016/03/08.
 */
public class SampleJsonList implements Serializable {

    public List<SampleJson> sampleJson;

    public SampleJsonList(){
        this.sampleJson = new ArrayList<>();
    }

    public List<SampleJson> getSampleJsonList(){
        return sampleJson;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append("{\n");
        builder.append("sampleJson:[");
        builder.append(sampleJson.toString());
        builder.append("],\n");

        return builder.toString();

    }

}
