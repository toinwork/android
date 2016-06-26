package com.toin.work.http;

public class MoreManager {

    public static MoreImageLoader getImageLoader() {
        return STManager.getSingle(MoreImageLoader.class);
    }

}
