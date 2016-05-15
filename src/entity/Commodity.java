package entity;

import java.util.Date;

public class Commodity {
	private String commodity_num;
	private String commodity_name;
	private Float commodity_price;
	private String commodity_type;
	private String commodity_information;
	private Date commodity_time;
	
	public String getCommodity_num() {
		return commodity_num;
	}
	public void setCommodity_num(String commodity_num) {
		this.commodity_num = commodity_num;
	}
	public String getCommodity_name() {
		return commodity_name;
	}
	public void setCommodity_name(String commodity_name) {
		this.commodity_name = commodity_name;
	}

	public Float getCommodity_price() {
		return commodity_price;
	}
	public void setCommodity_price(Float commodity_price) {
		this.commodity_price = commodity_price;
	}
	public String getCommodity_type() {
		return commodity_type;
	}
	public void setCommodity_type(String commodity_type) {
		this.commodity_type = commodity_type;
	}
	public String getCommodity_information() {
		return commodity_information;
	}
	public void setCommodity_information(String commodity_information) {
		this.commodity_information = commodity_information;
	}
	public Date getCommodity_time() {
		return commodity_time;
	}
	public void setCommodity_time(Date commodity_time) {
		this.commodity_time = commodity_time;
	}
	
	

}
