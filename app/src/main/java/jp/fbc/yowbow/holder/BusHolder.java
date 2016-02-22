package jp.fbc.yowbow.holder;

import com.squareup.otto.Bus;

/**
 * Created by MBPU on 2016/02/14.
 */
public class BusHolder {
    private static Bus sBus = new Bus();

    public static Bus get() {
        return sBus;
    }
}
