package com.toin.work.models;

/**
 * @author: xzx  2016-04-13 18:10
 */
public class ImgEntitys {
    private int image_id;
    private String url;

    public ImgEntitys(){}
    public ImgEntitys(int image_id,String url){

    }


    public void setImage_id(int image_id) {
        this.image_id = image_id;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getImage_id() {
        return image_id;
    }

    public String getUrl() {
        return url;
    }
}
