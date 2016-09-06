package com.toin.glp.models;

import java.util.List;

/**
 * @author: xzx 2016-04-11 14:50
 */
public class InfoModel {
    /**
     * degree_decoration :
     * [{"tag_id":18,"name":"毛胚"},{"tag_id":17,"name":"精装"},{
     * "tag_id":16,"name":"简装"}] facilities :
     * [{"tag_id":30,"name":"网络"},{"tag_id"
     * :29,"name":"中央空调"},{"tag_id":28,"name"
     * :"扶梯"},{"tag_id":27,"name":"货梯"},{"tag_id"
     * :26,"name":"客梯"},{"tag_id":25,"name"
     * :"煤气管道"},{"tag_id":24,"name":"停车位"},{"tag_id"
     * :23,"name":"三相电"},{"tag_id":22
     * ,"name":"排污管道"},{"tag_id":21,"name":"烟管道"},{
     * "tag_id":20,"name":"下水"},{"tag_id":19,"name":"上水"}] method_pay :
     * [{"tag_id"
     * :5,"name":"押二付六"},{"tag_id":4,"name":"押一付六"},{"tag_id":3,"name":
     * "押二付三"},{"tag_id":2,"name":"押一付三"},{"tag_id":1,"name":"全年付"}] shop_status
     * : [{"tag_id":15,"name":"空置"},{"tag_id":14,"name":"已租"},{"tag_id":13,
     * "name":"转让"},{"tag_id":12,"name":"营业中"}] store_type :
     * [{"tag_id":11,"name"
     * :"其它"},{"tag_id":10,"name":"购物中心/百货"},{"tag_id":9,"name"
     * :"写字楼配套底商"},{"tag_id"
     * :8,"name":"临街门面"},{"tag_id":7,"name":"商业街商铺"},{"tag_id":6,"name":"住宅底商"}]
     * suitable_business :
     * [{"tag_id":40,"name":"其它"},{"tag_id":39,"name":"休闲娱乐"}
     * ,{"tag_id":38,"name"
     * :"餐饮美食"},{"tag_id":37,"name":"美容美发"},{"tag_id":36,"name"
     * :"生活服务"},{"tag_id"
     * :35,"name":"服饰鞋包"},{"tag_id":34,"name":"家居建材"},{"tag_id"
     * :33,"name":"服饰鞋包"}
     * ,{"tag_id":32,"name":"酒店宾馆"},{"tag_id":31,"name":"百货超市"}]
     */

    private List<DataModel> degree_decoration;
    private List<DataModel> facilities;
    private List<DataModel> method_pay;
    private List<DataModel> shop_status;
    private List<DataModel> store_type;
    private List<DataModel> suitable_business;

    public void setDegree_decoration(List<DataModel> degree_decoration) {
        this.degree_decoration = degree_decoration;
    }

    public void setFacilities(List<DataModel> facilities) {
        this.facilities = facilities;
    }

    public void setMethod_pay(List<DataModel> method_pay) {
        this.method_pay = method_pay;
    }

    public void setShop_status(List<DataModel> shop_status) {
        this.shop_status = shop_status;
    }

    public void setStore_type(List<DataModel> store_type) {
        this.store_type = store_type;
    }

    public void setSuitable_business(List<DataModel> suitable_business) {
        this.suitable_business = suitable_business;
    }

    public List<DataModel> getDegree_decoration() {
        return degree_decoration;
    }

    public List<DataModel> getFacilities() {
        return facilities;
    }

    public List<DataModel> getMethod_pay() {
        return method_pay;
    }

    public List<DataModel> getShop_status() {
        return shop_status;
    }

    public List<DataModel> getStore_type() {
        return store_type;
    }

    public List<DataModel> getSuitable_business() {
        return suitable_business;
    }
}
