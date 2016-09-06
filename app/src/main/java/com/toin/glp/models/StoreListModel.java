package com.toin.glp.models;

import java.util.List;

/**
 * Created by hb on 16/4/14.
 */
public class StoreListModel {

    /**
     * current : 1 prev : 1 next : 1 last : 1 total : 1 per_page : 10 data :
     * [{"room_id"
     * :2,"title":"12123","shop_status":0,"construction_area":0,"rent"
     * :3000,"uname":"","create_time":1460517458,"image":""}]
     */

    private int                   current;
    private int                   prev;
    private int                   next;
    private int                   last;
    private String                total;
    private int                   per_page;
    /**
     * room_id : 2 title : 12123 shop_status : 0 construction_area : 0 rent :
     * 3000 uname : create_time : 1460517458 image :
     */

    private List<StoreItemEntity> data;

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public int getPrev() {
        return prev;
    }

    public void setPrev(int prev) {
        this.prev = prev;
    }

    public int getNext() {
        return next;
    }

    public void setNext(int next) {
        this.next = next;
    }

    public int getLast() {
        return last;
    }

    public void setLast(int last) {
        this.last = last;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public int getPer_page() {
        return per_page;
    }

    public void setPer_page(int per_page) {
        this.per_page = per_page;
    }

    public List<StoreItemEntity> getData() {
        return data;
    }

    public void setData(List<StoreItemEntity> data) {
        this.data = data;
    }

    public static class StoreItemEntity {
        private int    room_id;
        private String title;
        private int    shop_status;
        private String construction_area;
        private String rent;
        private String uname;
        private int    create_time;
        private String phone;
        private String image;
        private String business_area_name;

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public int getRoom_id() {
            return room_id;
        }

        public void setRoom_id(int room_id) {
            this.room_id = room_id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getShop_status() {
            return shop_status;
        }

        public void setShop_status(int shop_status) {
            this.shop_status = shop_status;
        }

        public String getConstruction_area() {
            return construction_area;
        }

        public void setConstruction_area(String construction_area) {
            this.construction_area = construction_area;
        }

        public String getRent() {
            return rent;
        }

        public void setRent(String rent) {
            this.rent = rent;
        }

        public String getUname() {
            return uname;
        }

        public void setUname(String uname) {
            this.uname = uname;
        }

        public int getCreate_time() {
            return create_time;
        }

        public void setCreate_time(int create_time) {
            this.create_time = create_time;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getBusiness_area_name() {
            return business_area_name;
        }

        public void setBusiness_area_name(String business_area_name) {
            this.business_area_name = business_area_name;
        }
    }
}
