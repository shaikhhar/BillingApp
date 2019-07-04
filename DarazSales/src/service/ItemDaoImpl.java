package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import java.sql.*;

import db.DB;
import model.Item;

public class ItemDaoImpl implements ItemDao {

	@Override
	public List<Item> getAll() {
		Connection con = DB.getDbCon();
		List<Item> ilist = new ArrayList<>();
		try {

			PreparedStatement pstm = con.prepareStatement("select * from stock");
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				Item i = new Item();
				i.setItem_no(rs.getInt("item_no"));
				i.setItem_name(rs.getString("item_name"));
				i.setQuantity(rs.getInt("quantity"));
				i.setMrp(rs.getInt("mrp"));
				ilist.add(i);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ilist;
	}

	@Override
	public boolean addItem(Item i) {
		Connection con = DB.getDbCon();
		try {
			PreparedStatement pstm = con.prepareStatement("insert into stock(item_no, item_name, quantity, mrp) values(?,?,?,?)");
			pstm.setInt(1, i.getItem_no());
			pstm.setString(2, i.getItem_name());
			pstm.setInt(3, i.getQuantity());
			pstm.setInt(4, i.getMrp());
			pstm.execute();
			return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public boolean updateItem(Item i) {
		Connection con = DB.getDbCon();
		try {
			PreparedStatement pstm= con.prepareStatement("update stock set item_name=?, quantity=?, mrp=? where item_no="+i.getItem_no());
			pstm.setString(1, i.getItem_name());
			pstm.setInt(2, i.getQuantity());
			pstm.setInt(3, i.getMrp());
			pstm.execute();
			return true;			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteItem(int item_no) {
		Connection con = DB.getDbCon();
		try {
			Statement stm = con.createStatement();
			stm.execute("delete from stock where item_no ="+item_no);
			return true;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean itemExists(int item_no) {
		Connection con = DB.getDbCon();
		try {
			PreparedStatement psm = con.prepareStatement("select * from stock where item_no ="+item_no);
			ResultSet rs = psm.executeQuery();
			while (rs.next()) {
				if (rs.getInt("item_no")==item_no){
					return true;
				}
				else{
					return false;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Item getItemById(int item_no) {
		Connection con=DB.getDbCon();
		Item i = new Item();
		try {
			PreparedStatement pstm = con.prepareStatement("select * from stock where item_no = "+item_no);
			ResultSet rs= pstm.executeQuery();
			while(rs.next()){
				i.setItem_no(rs.getInt("item_no"));
				i.setItem_name(rs.getString("item_name"));
				i.setQuantity(rs.getInt("quantity"));
				i.setMrp(rs.getInt("mrp"));
				return i;
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean changeStock(int item_no, int addition) {
		Connection con=DB.getDbCon();
		int qty= 0;
		try {
			PreparedStatement pstm1 = con.prepareStatement("select quantity from stock where item_no="+item_no);
			ResultSet rs = pstm1.executeQuery();
			while(rs.next()){
			qty= rs.getInt("quantity");}
			PreparedStatement pstm= con.prepareStatement("update stock set quantity = ? where item_no ="+item_no);
			
			pstm.setInt(1, (qty+addition));
			pstm.execute();
			return true;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

}
