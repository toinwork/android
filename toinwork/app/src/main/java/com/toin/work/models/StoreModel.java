package com.toin.work.models;

import java.util.List;

/**
 * @author: xzx 2016-04-13 18:08
 */
public class StoreModel {

    /**
     * room_id : 6 business_area_id : 3322 name : 11212 address : 1121212 rent :
     * 3000 is_property_fee : 1 property_fee : 100 construction_area :
     * door_head_width : 10 layer_height : 20 floor : 1,2 method_pay : 111
     * store_type : 0 shop_status : 0 is_transfer : 0 transfer_fee :
     * contract_time : lease_date : is_sale : 0 sale_price : is_cession : 0
     * degree_decoration : 0 facilities : current_business : suitable_business :
     * title : info : uname : phone : sex : 0 emergency_tel : status : 1 account
     * : 10000 update_time : 1460518781 create_time : 1460518781 image :
     * {"exterior_figure":[{"image_id":3,"url":
     * "http://ssp.bs.com/data/upload/interior_figure/20160413/48e1f964d699d42e75c5a712525ffa41495.jpg"
     * },{"image_id":4,"url":
     * "http://ssp.bs.com/data/upload/interior_figure/20160413/48e1f964d699d42e75c5a712525ffa41495.jpg"
     * }],"floor_plan":[{"image_id":5,"url":
     * "http://ssp.bs.com/data/upload/interior_figure/20160413/48e1f964d699d42e75c5a712525ffa41495.jpg"
     * },{"image_id":6,"url":
     * "http://ssp.bs.com/data/upload/interior_figure/20160413/48e1f964d699d42e75c5a712525ffa41495.jpg"
     * }],"house_property_card":[{"image_id":7,"url":
     * "http://ssp.bs.com/data/upload/interior_figure/20160413/48e1f964d699d42e75c5a712525ffa41495.jpg"
     * },{"image_id":8,"url":
     * "http://ssp.bs.com/data/upload/interior_figure/20160413/48e1f964d699d42e75c5a712525ffa41495.jpg"
     * }],"identity":[{"image_id":9,"url":
     * "http://ssp.bs.com/data/upload/interior_figure/20160413/48e1f964d699d42e75c5a712525ffa41495.jpg"
     * },{"image_id":10,"url":
     * "http://ssp.bs.com/data/upload/interior_figure/20160413/48e1f964d699d42e75c5a712525ffa41495.jpg"
     * }],"interior_figure":[{"image_id":1,"url":
     * "http://ssp.bs.com/data/upload/interior_figure/20160413/48e1f964d699d42e75c5a712525ffa41495.jpg"
     * },{"image_id":2,"url":
     * "http://ssp.bs.com/data/upload/interior_figure/20160413/48e1f964d699d42e75c5a712525ffa41495.jpg"
     * }]}
     */

    private int         room_id;
    private int         business_area_id;
    private String      name;
    private String      address;
    private String      rent;
    private int         is_property_fee;
    private String      property_fee;
    private String      construction_area;
    private String      door_head_width;
    private String      layer_height;
    private String      floor;
    private int         method_pay;
    private int         store_type;
    private int         shop_status;
    private int         is_transfer;
    private String      transfer_fee;
    private String      contract_time;
    private String      lease_date;
    private int         is_sale;
    private String      sale_price;
    private int         is_cession;
    private int         degree_decoration;
    private String      facilities;
    private String      current_business;
    private String      suitable_business;
    private String      title;
    private String      info;
    private String      uname;
    private String      phone;
    private int         sex;
    private String      emergency_tel;
    private int         status;
    private int         account;
    private int         update_time;
    private int         create_time;
    private ImageEntity image;
    private String      province_name;
    private String      city_name;
    private String      area_name;
    private String      business_area_name;
    private String      method_pay_name;
    private String      store_type_name;
    private String      shop_status_name;
    private String      degree_decoration_name;
    private String      facilities_data;
    private String      suitable_business_data;
    private int         province_id;
    private int         city_id;
    private int         area_id;

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    public void setBusiness_area_id(int business_area_id) {
        this.business_area_id = business_area_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setRent(String rent) {
        this.rent = rent;
    }

    public void setIs_property_fee(int is_property_fee) {
        this.is_property_fee = is_property_fee;
    }

    public void setProperty_fee(String property_fee) {
        this.property_fee = property_fee;
    }

    public void setConstruction_area(String construction_area) {
        this.construction_area = construction_area;
    }

    public void setDoor_head_width(String door_head_width) {
        this.door_head_width = door_head_width;
    }

    public void setLayer_height(String layer_height) {
        this.layer_height = layer_height;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public void setMethod_pay(int method_pay) {
        this.method_pay = method_pay;
    }

    public void setStore_type(int store_type) {
        this.store_type = store_type;
    }

    public void setShop_status(int shop_status) {
        this.shop_status = shop_status;
    }

    public void setIs_transfer(int is_transfer) {
        this.is_transfer = is_transfer;
    }

    public void setTransfer_fee(String transfer_fee) {
        this.transfer_fee = transfer_fee;
    }

    public void setContract_time(String contract_time) {
        this.contract_time = contract_time;
    }

    public void setLease_date(String lease_date) {
        this.lease_date = lease_date;
    }

    public void setIs_sale(int is_sale) {
        this.is_sale = is_sale;
    }

    public void setSale_price(String sale_price) {
        this.sale_price = sale_price;
    }

    public void setIs_cession(int is_cession) {
        this.is_cession = is_cession;
    }

    public void setDegree_decoration(int degree_decoration) {
        this.degree_decoration = degree_decoration;
    }

    public void setFacilities(String facilities) {
        this.facilities = facilities;
    }

    public void setCurrent_business(String current_business) {
        this.current_business = current_business;
    }

    public void setSuitable_business(String suitable_business) {
        this.suitable_business = suitable_business;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public void setEmergency_tel(String emergency_tel) {
        this.emergency_tel = emergency_tel;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setAccount(int account) {
        this.account = account;
    }

    public void setUpdate_time(int update_time) {
        this.update_time = update_time;
    }

    public void setCreate_time(int create_time) {
        this.create_time = create_time;
    }

    public void setImage(ImageEntity image) {
        this.image = image;
    }

    public int getRoom_id() {
        return room_id;
    }

    public int getBusiness_area_id() {
        return business_area_id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getRent() {
        return rent;
    }

    public int getIs_property_fee() {
        return is_property_fee;
    }

    public String getProperty_fee() {
        return property_fee;
    }

    public String getConstruction_area() {
        return construction_area;
    }

    public String getDoor_head_width() {
        return door_head_width;
    }

    public String getLayer_height() {
        return layer_height;
    }

    public String getFloor() {
        return floor;
    }

    public int getMethod_pay() {
        return method_pay;
    }

    public int getStore_type() {
        return store_type;
    }

    public int getShop_status() {
        return shop_status;
    }

    public int getIs_transfer() {
        return is_transfer;
    }

    public String getTransfer_fee() {
        return transfer_fee;
    }

    public String getContract_time() {
        return contract_time;
    }

    public String getLease_date() {
        return lease_date;
    }

    public int getIs_sale() {
        return is_sale;
    }

    public String getSale_price() {
        return sale_price;
    }

    public int getIs_cession() {
        return is_cession;
    }

    public int getDegree_decoration() {
        return degree_decoration;
    }

    public String getFacilities() {
        return facilities;
    }

    public String getCurrent_business() {
        return current_business;
    }

    public String getSuitable_business() {
        return suitable_business;
    }

    public String getTitle() {
        return title;
    }

    public String getInfo() {
        return info;
    }

    public String getUname() {
        return uname;
    }

    public String getPhone() {
        return phone;
    }

    public int getSex() {
        return sex;
    }

    public String getEmergency_tel() {
        return emergency_tel;
    }

    public int getStatus() {
        return status;
    }

    public int getAccount() {
        return account;
    }

    public int getUpdate_time() {
        return update_time;
    }

    public int getCreate_time() {
        return create_time;
    }

    public ImageEntity getImage() {
        return image;
    }

    public void setProvince_name(String province_name) {
        this.province_name = province_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public void setArea_name(String area_name) {
        this.area_name = area_name;
    }

    public void setBusiness_area_name(String business_area_name) {
        this.business_area_name = business_area_name;
    }

    public void setMethod_pay_name(String method_pay_name) {
        this.method_pay_name = method_pay_name;
    }

    public void setStore_type_name(String store_type_name) {
        this.store_type_name = store_type_name;
    }

    public void setShop_status_name(String shop_status_name) {
        this.shop_status_name = shop_status_name;
    }

    public void setDegree_decoration_name(String degree_decoration_name) {
        this.degree_decoration_name = degree_decoration_name;
    }

    public void setFacilities_data(String facilities_data) {
        this.facilities_data = facilities_data;
    }

    public void setSuitable_business_data(String suitable_business_data) {
        this.suitable_business_data = suitable_business_data;
    }

    public String getProvince_name() {
        return province_name;
    }

    public String getCity_name() {
        return city_name;
    }

    public String getArea_name() {
        return area_name;
    }

    public String getBusiness_area_name() {
        return business_area_name;
    }

    public String getMethod_pay_name() {
        return method_pay_name;
    }

    public String getStore_type_name() {
        return store_type_name;
    }

    public String getShop_status_name() {
        return shop_status_name;
    }

    public String getDegree_decoration_name() {
        return degree_decoration_name;
    }

    public String getFacilities_data() {
        return facilities_data;
    }

    public String getSuitable_business_data() {
        return suitable_business_data;
    }

    public void setProvince_id(int province_id) {
        this.province_id = province_id;
    }

    public void setCity_id(int city_id) {
        this.city_id = city_id;
    }

    public void setArea_id(int area_id) {
        this.area_id = area_id;
    }

    public int getProvince_id() {
        return province_id;
    }

    public int getCity_id() {
        return city_id;
    }

    public int getArea_id() {
        return area_id;
    }

    public static class ImageEntity {

        private List<ImgEntitys> exterior_figure;
        private List<ImgEntitys> floor_plan;
        private List<ImgEntitys> house_property_card;
        private List<ImgEntitys> identity;
        private List<ImgEntitys> interior_figure;

        public List<ImgEntitys> getInterior_figure() {
            return interior_figure;
        }

        public void setInterior_figure(List<ImgEntitys> interior_figure) {
            this.interior_figure = interior_figure;
        }

        public List<ImgEntitys> getExterior_figure() {
            return exterior_figure;
        }

        public void setExterior_figure(List<ImgEntitys> exterior_figure) {
            this.exterior_figure = exterior_figure;
        }

        public List<ImgEntitys> getFloor_plan() {
            return floor_plan;
        }

        public void setFloor_plan(List<ImgEntitys> floor_plan) {
            this.floor_plan = floor_plan;
        }

        public List<ImgEntitys> getHouse_property_card() {
            return house_property_card;
        }

        public void setHouse_property_card(List<ImgEntitys> house_property_card) {
            this.house_property_card = house_property_card;
        }

        public List<ImgEntitys> getIdentity() {
            return identity;
        }

        public void setIdentity(List<ImgEntitys> identity) {
            this.identity = identity;
        }

    }
}
