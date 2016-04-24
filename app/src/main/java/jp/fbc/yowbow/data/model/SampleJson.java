package jp.fbc.yowbow.data.model;

import java.io.Serializable;

/**
 *
 * SampleJsonのモデルクラス
 * Created by MBPU on 2016/03/06.
 */
public class SampleJson implements Serializable {

    public int id;
    public String name;
    public String content;

    public SampleJson(int id, String name, String content){

        this.id = id;
        this.name = name;
        this.content = content;

    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getContent(){
        return content;
    }

}
