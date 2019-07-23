package Client;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import org.omg.PortableServer.IdAssignmentPolicyOperations;

import model.Item;
import service.ItemDao;
import service.ItemDaoImpl;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;
import java.awt.Font;

public class StockUpdate extends JFrame {
	private JLabel textItemId;
	private JLabel lblNewLabel;
	private JLabel lblStockQty;
	private JLabel lblQtyAdded;
	private JLabel lblMrp;
	private JButton btnAdd;
	private JButton btnUpdate;
	private JTextField textItem_no;
	private JTextField textItem_name;
	private JTextField textQty;
	private JTextField textQtyAdded;
	private JTextField textMrp;
	private JScrollPane scrollPane;
	private JTable tableStock;
	private JButton btnDelete;
	private JButton btnExit;
	private JLabel lblSearch;
	private JTextField textSearch;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StockUpdate frame = new StockUpdate();
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
	public StockUpdate() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(StockUpdate.class.getResource("/com/sun/java/swing/plaf/motif/icons/DesktopIcon.gif")));
		setTitle("Update Stock");
		setBackground(UIManager.getColor("Button.light"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 755, 419);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getTextItemId());
		contentPane.add(getLblNewLabel());
		contentPane.add(getLblStockQty());
		contentPane.add(getLblQtyAdded());
		contentPane.add(getLblMrp());
		contentPane.add(getBtnAdd());
		contentPane.add(getBtnUpdate());
		contentPane.add(getTextItem_no());
		contentPane.add(getTextItem_name());
		contentPane.add(getTextQty());
		contentPane.add(getTextQtyAdded());
		contentPane.add(getTextMrp());
		contentPane.add(getScrollPane());
		contentPane.add(getBtnDelete());
		contentPane.add(getBtnExit());
		contentPane.add(getLblSearch());
		contentPane.add(getTextSearch());
		populateStock();
	}

	private JLabel getTextItemId() {
		if (textItemId == null) {
			textItemId = new JLabel("Item-no");
			textItemId.setBounds(25, 27, 78, 14);
		}
		return textItemId;
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Item Name");
			lblNewLabel.setBounds(25, 55, 78, 14);
		}
		return lblNewLabel;
	}

	private JLabel getLblStockQty() {
		if (lblStockQty == null) {
			lblStockQty = new JLabel("Stock Qty");
			lblStockQty.setBounds(25, 83, 59, 14);
		}
		return lblStockQty;
	}

	private JLabel getLblQtyAdded() {
		if (lblQtyAdded == null) {
			lblQtyAdded = new JLabel("Qty added");
			lblQtyAdded.setBounds(24, 108, 69, 14);
		}
		return lblQtyAdded;
	}

	private JLabel getLblMrp() {
		if (lblMrp == null) {
			lblMrp = new JLabel("MRP");
			lblMrp.setBounds(25, 133, 46, 14);
		}
		return lblMrp;
	}

	private JButton getBtnAdd() {
		if (btnAdd == null) {
			btnAdd = new JButton("Add");
			btnAdd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					if (textItem_name.getText().isEmpty() || textItem_no.getText().isEmpty()
							|| textQty.getText().isEmpty() || textMrp.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Fill in all fields");

					} else {
						Item i = new Item();
						i.setItem_name(textItem_name.getText());
						i.setItem_no(Integer.parseInt(textItem_no.getText()));
						i.setQuantity(Integer.parseInt(textQty.getText()));
						i.setMrp(Integer.parseInt(textMrp.getText()));
						ItemDao idao = new ItemDaoImpl();
						if (idao.itemExists(Integer.parseInt(textItem_no.getText()))) {
							JOptionPane.showMessageDialog(null, "Item already exist, try another item no");
						} else if (idao.addItem(i)) {
							JOptionPane.showMessageDialog(null, "Added successfully");
							populateStock();
							textItem_no.setText(null);
							textItem_name.setText(null);
							textQty.setText(null);
							textMrp.setText(null);
						} else {
							JOptionPane.showMessageDialog(null, "Failed to add the item");
						}

					}
				}
			});
			btnAdd.setBounds(26, 182, 95, 23);
		}
		ImageIcon ic = new ImageIcon(getClass().getClassLoader().getResource("add-icon.png"));
		btnAdd.setIcon(ic);
		return btnAdd;
	}

	private JButton getBtnUpdate() {
		if (btnUpdate == null) {
			btnUpdate = new JButton("Update");
			btnUpdate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Item i = new Item();
					i.setItem_no(Integer.parseInt(textItem_no.getText()));
					i.setItem_name(textItem_name.getText());
					i.setMrp(Integer.parseInt(textMrp.getText()));
					if(!textQtyAdded.getText().isEmpty()){
					i.setQuantity(Integer.parseInt(textQty.getText())+Integer.parseInt(textQtyAdded.getText()));
					}else{
						i.setQuantity(Integer.parseInt(textQty.getText()));
					}
					ItemDao idao = new ItemDaoImpl();
					if(idao.updateItem(i)){
						JOptionPane.showMessageDialog(null, "Updated successfully");
						populateStock();
						textItem_no.setText(null);
						textItem_name.setText(null);
						textQty.setText(null);
						textQtyAdded.setText(null);
						textMrp.setText(null);
					}
					else{
						JOptionPane.showMessageDialog(null, "Update failed");
					}
					
				}
			});
			btnUpdate.setBounds(25, 227, 95, 23);
		}
		ImageIcon ic = new ImageIcon(getClass().getClassLoader().getResource("update-icon.png"));
		btnUpdate.setIcon(ic);
		return btnUpdate;
	}

	private JTextField getTextItem_no() {
		if (textItem_no == null) {
			textItem_no = new JTextField();
			textItem_no.setBounds(147, 24, 146, 20);
			textItem_no.setColumns(10);
		}
		return textItem_no;
	}

	private JTextField getTextItem_name() {
		if (textItem_name == null) {
			textItem_name = new JTextField();
			textItem_name.setBounds(147, 52, 146, 20);
			textItem_name.setColumns(10);
		}
		return textItem_name;
	}

	private JTextField getTextQty() {
		if (textQty == null) {
			textQty = new JTextField();
			textQty.setBounds(147, 80, 146, 20);
			textQty.setColumns(10);
		}
		return textQty;
	}

	private JTextField getTextQtyAdded() {
		if (textQtyAdded == null) {
			textQtyAdded = new JTextField();
			textQtyAdded.setBounds(147, 105, 146, 20);
			textQtyAdded.setColumns(10);
		}
		return textQtyAdded;
	}

	private JTextField getTextMrp() {
		if (textMrp == null) {
			textMrp = new JTextField();
			textMrp.setBounds(147, 130, 146, 20);
			textMrp.setColumns(10);
		}
		return textMrp;
	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(306, 59, 423, 292);
			scrollPane.setViewportView(getTable());
		}
		return scrollPane;
	}

	private JTable getTable() {
		if (tableStock == null) {
			tableStock = new JTable();
			tableStock.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
					//Display selected row in JTextFields
					
					int row=tableStock.getSelectedRow();
					TableModel model= tableStock.getModel();
					textItem_no.setText(model.getValueAt(row, 0).toString());
					textItem_name.setText(model.getValueAt(row, 1).toString());
					textQty.setText(model.getValueAt(row, 2).toString());
					textMrp.setText(model.getValueAt(row, 3).toString());
				}
			});
			tableStock.setModel(new DefaultTableModel(new Object[][] {},
					new String[] { "Item_no", "Item_name", "Quantity", "MRP" }));
		}
		
		tableStock.getColumnModel().getColumn(0).setPreferredWidth(60);
		tableStock.getColumnModel().getColumn(1).setPreferredWidth(220);
		
		return tableStock;
	}

	
	private void populateStock() {
		DefaultTableModel t1 = (DefaultTableModel) tableStock.getModel();
		ItemDao idao = new ItemDaoImpl();
		List<Item> ilist = idao.getAll();
		t1.setRowCount(0);
		for (Item x : ilist) {
			t1.addRow(new Object[] { x.getItem_no(), x.getItem_name(), x.getQuantity(), x.getMrp() });
		}

	}
	private JButton getBtnDelete() {
		if (btnDelete == null) {
			btnDelete = new JButton("Delete");
			btnDelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					int option= JOptionPane.showConfirmDialog(null, "Sure want to delete this product?");
					
					if(option==0){                 //0 means yes 1 means no and 2 means cancel
						Item i = new Item();
						int item_no = Integer.parseInt(textItem_no.getText());
						ItemDao idao = new ItemDaoImpl();
						if(idao.deleteItem(item_no)){
							JOptionPane.showMessageDialog(null, "Deleted successfully");
							populateStock();
							textItem_no.setText(null);
							textItem_name.setText(null);
							textQty.setText(null);
							textQtyAdded.setText(null);
							textMrp.setText(null);
						}else{
							JOptionPane.showMessageDialog(null, "Deleted unsuccess");	
						}
					}					
				}
			});
			ImageIcon ic = new ImageIcon(getClass().getClassLoader().getResource("Button-Delete-icon.png"));
			btnDelete.setIcon(ic);
			btnDelete.setBounds(25, 274, 95, 23);
		}
		return btnDelete;
	}
	private JButton getBtnExit() {
		if (btnExit == null) {
			btnExit = new JButton("Exit");
			btnExit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
				}
			});
			btnExit.setBounds(31, 347, 89, 23);
		}
		btnExit.setIcon(new ImageIcon(getClass().getClassLoader().getResource("exit-icon.png")));
		return btnExit;
	}
	private JLabel getLblSearch() {
		if (lblSearch == null) {
			lblSearch = new JLabel("Search");
			lblSearch.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblSearch.setBounds(366, 27, 69, 14);
		}
		return lblSearch;
	}
	private JTextField getTextSearch() {
		if (textSearch == null) {
			textSearch = new JTextField();
			textSearch.setBounds(442, 24, 167, 20);
			textSearch.setColumns(10);
			textSearch.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					String key = textSearch.getText();
					populateSearchedStock(key);
				}
			});
		}
		return textSearch;
	}
	
	public void populateSearchedStock(String s){
		DefaultTableModel t1 = (DefaultTableModel) tableStock.getModel();
		ItemDao idao = new ItemDaoImpl();
		List<Item> itemlist = idao.search(s);
		t1.setRowCount(0);
		
		for(Item i: itemlist){
			t1.addRow(new Object[]{i.getItem_no(),i.getItem_name(),i.getQuantity(),i.getMrp()});
			
		}	
	}
}
