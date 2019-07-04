package Client;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import model.Item;
import service.ItemDao;
import service.ItemDaoImpl;

import javax.swing.JLabel;
import java.awt.Font;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ProductInfo extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblProduct;
	private JTextField textField;
	private JScrollPane scrollPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductInfo frame = new ProductInfo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ProductInfo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 682, 354);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblNewLabel());
		contentPane.add(getLblProduct());
		contentPane.add(getTextField());
		contentPane.add(getScrollPane());
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Product Information");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblNewLabel.setBounds(221, 28, 149, 14);
		}
		return lblNewLabel;
	}
	private JLabel getLblProduct() {
		if (lblProduct == null) {
			lblProduct = new JLabel("Product");
			lblProduct.setBounds(188, 72, 62, 14);
		}
		return lblProduct;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setBounds(267, 69, 143, 20);
			textField.setColumns(10);
		}
		return textField;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(38, 103, 605, 177);
			scrollPane.setViewportView(getTable());
		}
		return scrollPane;
	}
	private JTable getTable() {
		if (table == null) {
			table = new JTable();
			table.setModel(new DefaultTableModel(new Object[][]{},new String[]{ "Item Id", "Item name", "Quantity", "mrp"}));
			table.getColumnModel().getColumn(0).setPreferredWidth(5);
			table.getColumnModel().getColumn(1).setPreferredWidth(350);
			table.getColumnModel().getColumn(2).setPreferredWidth(5);
			table.getColumnModel().getColumn(3).setPreferredWidth(70);
			
			
		}
		return table;
	}
	
	public void populateStock(){
		DefaultTableModel t = (DefaultTableModel) table.getModel();
		ItemDao idao = new ItemDaoImpl();
		List<Item> itemlist = idao.getAll();
		for(Item i: itemlist){
			t.addRow(new Object[]{i.getItem_no(),i.getItem_name(),i.getQuantity(),i.getMrp()});
			
		}
		
		
		
	}
}
