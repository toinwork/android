package com.toin.glp.models;

import android.graphics.Bitmap;

import java.util.ArrayList;
import java.util.List;

public class ImgModel {
	public ImgModel(){

	}
	public ImgModel(int max, List<Bitmap> bmp, List<String> drr,List<ImgEntitys> url) {
		super();
		this.max = max;
		this.bmp = bmp;
		this.drr = drr;
		this.url = url;
	}

	public List<ImgEntitys> getUrl() {
		return url;
	}

	public void setUrl(List<ImgEntitys> url) {
		this.url = url;
	}

	private  int max = 0;
	private  List<Bitmap> bmp = new ArrayList<Bitmap>();
	private  List<String> drr = new ArrayList<String>();
	private  List<ImgEntitys> url = new ArrayList<ImgEntitys>();

	public int getMax() {
		return max;
	}
	public void setMax(int max) {
		this.max = max;
	}
	public List<Bitmap> getBmp() {
		return bmp;
	}
	public void setBmp(List<Bitmap> bmp) {
		this.bmp = bmp;
	}
	public List<String> getDrr() {
		return drr;
	}
	public void setDrr(List<String> drr) {
		this.drr = drr;
	}

}
