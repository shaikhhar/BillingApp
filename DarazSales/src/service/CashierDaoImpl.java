package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import db.DB;
import model.Cashier;

public class CashierDaoImpl implements CashierDao {
	
	@Override
	public boolean addCashier(Cashier c) {
		
		Connection con= DB.getDbCon();
		String sql= "insert into cashier(fname,lname,username,password,dob,address) values(?,?,?,?,?,?)";                                 
		try {
			PreparedStatement psm= con.prepareStatement(sql);
			psm.setString(1, c.getFname());
			psm.setString(2, c.getLname());
			psm.setString(3, c.getUsername());
			psm.setString(4, c.getPassword());
			psm.setDate(5, c.getDob());
			psm.setString(6, c.getAddress());
			psm.execute();			
			
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		
	}

	@Override
	public boolean loginCashier() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean uernameExists(String username) {
		Connection con= DB.getDbCon();
		
		String sql= "select * from cashier where username ="+"'"+username+"'";
		try {
			Statement stm= con.createStatement();
			ResultSet Rs=stm.executeQuery(sql);
			while(Rs.next()){
		           if(Rs.getString("username")!=null){
		        	   return true;
		           }
		           else{
		        	   return false;
		           }
			}
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean userValidate(String username, String password) {
Connection con= DB.getDbCon();
		
		String sql= "select * from cashier where username ="+"'"+username+"'"+"and password ="+"'"+password+"';";
		try {
			Statement stm= con.createStatement();
			ResultSet Rs=stm.executeQuery(sql);
			while(Rs.next()){
		           if(username.equals(Rs.getString("username"))&&password.equals(Rs.getString("password"))){
		        	   return true;
		           }
		           else{
		        	   return false;
		           }
			}
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return false;
	}

	@Override
	public List<Cashier> getAll() {
		
		List<Cashier> clist= new ArrayList<>();
		Connection con= DB.getDbCon();
		String sql= "select * from cashier";
		try {
			Statement stm= con.createStatement();
			ResultSet Rs= stm.executeQuery(sql);
			while(Rs.next()){
				Cashier c= new Cashier();
				c.setId(Rs.getInt("id"));
				c.setFname(Rs.getString("fname"));
				c.setLname(Rs.getString("lname"));
				c.setUsername(Rs.getString("username"));
				c.setPassword(Rs.getString("password"));
				c.setDob(Rs.getDate("dob"));
				c.setAddress(Rs.getString("address"));
				clist.add(c);
				
			}
			return clist;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Cashier getById(int id) {
		Cashier c= new Cashier();
		List<Cashier> clist= new ArrayList<>();
		Connection con= DB.getDbCon();
		String sql= "select * from cashier where id= "+id+";";
		try {
			Statement stm= con.createStatement();
			ResultSet Rs= stm.executeQuery(sql);
			while(Rs.next()){
				c.setId(Rs.getInt("id"));
				c.setFname(Rs.getString("fname"));
				c.setLname(Rs.getString("lname"));
				c.setUsername(Rs.getString("username"));
				c.setPassword(Rs.getString("password"));
				c.setDob(Rs.getDate("dob"));
				c.setAddress(Rs.getString("address"));
				clist.add(c);
			}
			 
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return c;
	}

	@Override
	public boolean update(Cashier c) {
		Connection con= DB.getDbCon();
		String sql= "update cashier set fname=?,lname=?,username=?,password=?,dob=?,address=? where id= "+c.getId()+";";
		try {
			PreparedStatement pstm= con.prepareStatement(sql);
			pstm.setString(1, c.getFname());
			pstm.setString(2, c.getLname());
			pstm.setString(3, c.getUsername());
			pstm.setString(4, c.getPassword());
			pstm.setDate(5, c.getDob());
			pstm.setString(6, c.getAddress());
			pstm.execute();
			return true;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		
		
		
	}

	@Override
	public boolean delete(int id) {
		Connection con= DB.getDbCon();
		String sql= "delete from cashier where id= "+id+";";
		try {
			Statement stm= con.createStatement();
			stm.execute(sql);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		
		
	}

}
