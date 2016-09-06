package com.toin.glp.http;

public class STManager {
    public static <T> T getSingle(Class<T> serviceName) {
        return SingleFactory.getInstance().getService(serviceName);
    }
}
