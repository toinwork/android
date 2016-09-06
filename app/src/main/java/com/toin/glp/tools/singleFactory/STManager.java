package com.toin.glp.tools.singleFactory;

import com.toin.glp.http.SingleFactory;

/**
 * Created by hb on 16/6/29.
 */
public class STManager {
    public static <T> T getSingle(Class<T> serviceName) {
        return SingleFactory.getInstance().getService(serviceName);
    }
}
