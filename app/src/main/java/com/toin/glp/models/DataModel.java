package com.toin.glp.models;
import java.io.Serializable;


public class DataModel implements Serializable{
    private int tag_id;
    private String name;

    public void setTag_id(int tag_id) {
        this.tag_id = tag_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTag_id() {
        return tag_id;
    }

    public String getName() {
        return name;
    }
    @Override
    public String toString() {
    	return getName();
    }

}
