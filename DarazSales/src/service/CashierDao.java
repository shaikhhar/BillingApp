package service;

import java.util.List;

import model.Cashier;

public interface CashierDao {
	
	boolean addCashier(Cashier c);
	boolean loginCashier();
	boolean uernameExists(String username);
	boolean userValidate(String username, String password);
	List<Cashier> getAll();
	Cashier getById(int id);
	boolean update(Cashier c);
	boolean delete(int id);

}
