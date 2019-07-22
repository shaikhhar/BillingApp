package service;

import java.sql.Date;
import java.util.List;

import model.Bill;

public interface BillDao {
	
	List<Bill> getAllBill();
	int maxBillno();
	boolean addBill(Bill b);
	boolean cancelBill(Bill b);
	Bill getByBillno(Bill b);
	boolean deleteBill(int Billno, int item_no);
	List<Bill> searchByKeyValue(String attribute, String value, Date from, Date to);
	

}
