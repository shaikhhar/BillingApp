package model;

import java.sql.Date;

public class Bill {
	private Date date;
	private int bill_no;
	private String cus_name;
	private int item_no;
	private String item_name;
	private int mrp;
	private int qty;
	private int discount;
	private int amount;
	
	public Bill(){
		
	}
	
	public Bill(Date date, int bill_no,  String cus_name, int item_no, String item_name, int mrp, int qty, int discount, int amount){
		this.date= date;
		this.bill_no=bill_no;
		this.cus_name=cus_name;
		this.item_no=item_no;
		this.item_name=item_name;
		this.mrp=mrp;
		this.qty=qty;
		this.discount=discount;
		this.amount=amount;
				
	}
	
	public int getBill_no() {
		return bill_no;
	}
	public void setBill_no(int bill_no) {
		this.bill_no = bill_no;
	}
	public String getCus_name() {
		return cus_name;
	}
	public void setCus_name(String cus_name) {
		this.cus_name = cus_name;
	}
	public int getItem_no() {
		return item_no;
	}
	public void setItem_no(int item_no) {
		this.item_no = item_no;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public int getMrp() {
		return mrp;
	}
	public void setMrp(int mrp) {
		this.mrp = mrp;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	

}
