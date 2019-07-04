package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import db.DB;
import model.Bill;

public class BillDaoImpl implements BillDao{

	@Override
	public List<Bill> getAllBill() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int maxBillno() {
		Connection con = DB.getDbCon();
		try {
			PreparedStatement pstm = con.prepareStatement("select bill_no from  Bill");
			ResultSet rs = pstm.executeQuery();
			int max= 0;
			while(rs.next()){
				if(rs.getInt(1)>max){
					max=rs.getInt(1);
				}				
			}
			return max+1;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public boolean addBill(Bill b) {
		Connection con = DB.getDbCon();
		try {
			PreparedStatement pstm = con.prepareStatement("insert into bill values (?,?,?,?,?,?,?,?,?)");
			pstm.setDate(1, b.getDate());
			pstm.setInt(2, b.getBill_no());
			pstm.setString(3, b.getCus_name());
			pstm.setInt(4, b.getItem_no());
			pstm.setString(5, b.getItem_name());
			pstm.setInt(6, b.getMrp());
			pstm.setInt(7, b.getQty());
			pstm.setInt(8, b.getDiscount()*b.getMrp()*b.getQty()/100);
			pstm.setInt(9, b.getMrp()*b.getQty()*(100-b.getDiscount())/100);
			pstm.execute();
			return true;
			
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
		
		
		return false;
	}

	@Override
	public boolean cancelBill(Bill b) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Bill getByBillno(Bill b) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteBill(int Billno, int item_no) {
		Connection con = DB.getDbCon();
		try {
			PreparedStatement pstm = con.prepareStatement("delete from Bill where bill_no ="+Billno+" and item_no = "+item_no);
			pstm.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return false;
	}

}
