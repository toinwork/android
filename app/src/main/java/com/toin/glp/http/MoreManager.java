package com.toin.glp.http;

public class MoreManager {

    public static MoreImageLoader getImageLoader() {
        return STManager.getSingle(MoreImageLoader.class);
    }

}
