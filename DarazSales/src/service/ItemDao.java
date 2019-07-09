package service;

import java.util.List;

import model.Item;

public interface ItemDao {
	List<Item> getAll();
	boolean addItem(Item i);
	boolean updateItem(Item i);
	boolean deleteItem(int item_no);
	boolean itemExists(int item_no);
	Item getItemById(int item_no);
	boolean changeStock(int item_no, int addition);
	List<Item> search(String s);
}
 