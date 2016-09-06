package com.toin.glp.tools.singleFactory;

/**
 * Created by hb on 16/6/29.
 */
public class MoreManager {
    public static MoreImageLoader getImageLoader() {
        return STManager.getSingle(MoreImageLoader.class);
    }
}
