package Client;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Bill;
import model.Item;
import service.BillDao;
import service.BillDaoImpl;
import service.ItemDao;
import service.ItemDaoImpl;

import javax.swing.JComboBox;

import com.toedter.calendar.JDateChooser;

public class SalesBill extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblCustomerName;
	private JLabel lblItemNo;
	private JLabel lblItemName;
	private JLabel lblMrp;
	private JLabel lblQuantity;
	private JLabel lblDiscount;
	private JTextField textBill;
	private JTextField textCust;
	private JTextField textItem;
	private JTextField textMrp;
	private JTextField textQty;
	private JTextField textDisc;
	private JButton btnAdd;
	private JButton btnDelete;
	private JScrollPane scrollPane;
	private JTable table;
	private JComboBox comboBox;
	private JLabel lblDate;
	private JDateChooser dateChooser;
	private JLabel lblTotal;
	private JTextField textTotal;
	private JButton btnReceipt;
	private JButton btnExit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SalesBill frame = new SalesBill();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws Exception
	 */
	public SalesBill() {
		setTitle("New Bill");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 865, 486);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblNewLabel());
		contentPane.add(getLblCustomerName());
		contentPane.add(getLblItemNo());
		contentPane.add(getLblItemName());
		contentPane.add(getLblMrp());
		contentPane.add(getLblQuantity());
		contentPane.add(getLblDiscount());
		contentPane.add(getTextBill());
		contentPane.add(getTextCust());
		contentPane.add(getTextItem());
		contentPane.add(getTextMrp());
		contentPane.add(getTextQty());
		contentPane.add(getTextDisc());
		contentPane.add(getBtnAdd());
		contentPane.add(getBtnDelete());
		contentPane.add(getScrollPane());
		contentPane.add(getComboBox());
		contentPane.add(getLblDate());
		contentPane.add(getDateChooser());
		contentPane.add(getLblTotal());
		contentPane.add(getTextTotal());
		contentPane.add(getBtnReceipt());
		contentPane.add(getBtnExit());
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Bill no");
			lblNewLabel.setBounds(27, 58, 46, 14);
		}
		return lblNewLabel;
	}

	private JLabel getLblCustomerName() {
		if (lblCustomerName == null) {
			lblCustomerName = new JLabel("Customer name");
			lblCustomerName.setBounds(27, 87, 92, 14);
		}
		return lblCustomerName;
	}

	private JLabel getLblItemNo() {
		if (lblItemNo == null) {
			lblItemNo = new JLabel("Item no");
			lblItemNo.setBounds(27, 112, 46, 14);
		}
		return lblItemNo;
	}

	private JLabel getLblItemName() {
		if (lblItemName == null) {
			lblItemName = new JLabel("Item name");
			lblItemName.setBounds(27, 137, 65, 14);
		}
		return lblItemName;
	}

	private JLabel getLblMrp() {
		if (lblMrp == null) {
			lblMrp = new JLabel("mrp");
			lblMrp.setBounds(27, 162, 46, 20);
		}
		return lblMrp;
	}

	private JLabel getLblQuantity() {
		if (lblQuantity == null) {
			lblQuantity = new JLabel("Quantity");
			lblQuantity.setBounds(27, 200, 75, 14);
		}
		return lblQuantity;
	}

	private JLabel getLblDiscount() {
		if (lblDiscount == null) {
			lblDiscount = new JLabel("Discount");
			lblDiscount.setBounds(27, 225, 75, 14);
		}
		return lblDiscount;
	}

	private JTextField getTextBill() {
		if (textBill == null) {
			textBill = new JTextField();
			textBill.setBounds(130, 55, 70, 20);
			textBill.setColumns(10);
			BillDao bdao = new BillDaoImpl();
			textBill.setText(Integer.toString(bdao.maxBillno()));
		}
		return textBill;
	}

	private JTextField getTextCust() {
		if (textCust == null) {
			textCust = new JTextField();
			textCust.setBounds(129, 85, 138, 20);
			textCust.setColumns(10);
		}
		return textCust;
	}

	private JTextField getTextItem() {
		if (textItem == null) {
			textItem = new JTextField();
			textItem.setBounds(130, 134, 138, 20);
			textItem.setColumns(10);
		}
		return textItem;
	}

	private JTextField getTextMrp() {
		if (textMrp == null) {
			textMrp = new JTextField();
			textMrp.setBounds(130, 163, 82, 20);
			textMrp.setColumns(10);
		}
		return textMrp;
	}

	private JTextField getTextQty() {
		if (textQty == null) {
			textQty = new JTextField();
			textQty.setBounds(130, 194, 86, 20);
			textQty.setColumns(10);
		}
		return textQty;
	}

	private JTextField getTextDisc() {
		if (textDisc == null) {
			textDisc = new JTextField();
			textDisc.setBounds(130, 222, 86, 20);
			textDisc.setColumns(10);
		}
		return textDisc;
	}

	// int total=0;
	private JButton getBtnAdd() {
		if (btnAdd == null) {
			btnAdd = new JButton("Add");
			btnAdd.setBounds(27, 268, 95, 23);
			btnAdd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					int discount = 0;
					int item_no = 0;
					int qty = 0;
					ItemDao idao = new ItemDaoImpl();

					long date1 = dateChooser.getDate().getTime();
					java.sql.Date date = new java.sql.Date(date1);
					int bill_no = Integer.parseInt(textBill.getText());
					String cus_name = textCust.getText();
					if (comboBox.getItemAt(comboBox.getSelectedIndex()) == null) {
						JOptionPane.showMessageDialog(null, "Choose a valid item no");
						item_no = 0;

					} else {
						item_no = (int) comboBox.getSelectedItem();

						String item_name = textItem.getText();
						int mrp = Integer.parseInt(textMrp.getText());

						if (textQty.getText().isEmpty() || textQty.getText().equals(0)) {
							JOptionPane.showMessageDialog(null, "Qty cant be empty or zero");
						} else {
							qty = Integer.parseInt(textQty.getText());

							int SOH = idao.getItemById(item_no).getQuantity();
							if (SOH < qty) { // sales unit shouldnt exceed available stock
								JOptionPane.showMessageDialog(null, "Only " + SOH + " units available on Stock");
							} else {

								if (textDisc.getText().isEmpty()) {
									discount = 0;
								} else {
									discount = Integer.parseInt(textDisc.getText());
								}
								int amount = mrp * qty * (100 - discount) / 100;
								// total=amount+total;

								Bill b = new Bill(date, bill_no, cus_name, item_no, item_name, mrp, qty, discount,
										amount);
								BillDao bdao = new BillDaoImpl();
								bdao.addBill(b);
								idao.changeStock(item_no, -qty); // after each sale,item qty to be reduced by billed qty
								DefaultTableModel model = (DefaultTableModel) table.getModel();
								model.addRow(
										new Object[] { item_no, item_name, qty, mrp, discount * mrp / 100, amount });
								SumTot(); // totalling the amount
								// textTotal.setText(Integer.toString(total));
							}
						}
					}
					emptyForm();

				}
			});
			ImageIcon img = new ImageIcon("Image/add-icon.png");
			btnAdd.setIcon(img);
		}
		return btnAdd;
	}

	private JButton getBtnDelete() {
		if (btnDelete == null) {
			btnDelete = new JButton("Delete");
			btnDelete.setBounds(25, 329, 95, 23);
			btnDelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					int row = table.getSelectedRow();
					if (row < 0) {
						JOptionPane.showMessageDialog(null, "No item selected");
					} else {
						int item_no = (int) table.getValueAt(row, 0);
						int qty = (int) table.getValueAt(row, 2);
						BillDao bdao = new BillDaoImpl();
						int Billno = Integer.parseInt(textBill.getText());
						if (bdao.deleteBill(Billno, item_no)) {
							JOptionPane.showMessageDialog(null, "Deleted bill item");
							model.removeRow(row);
							ItemDao idao = new ItemDaoImpl();
							idao.changeStock(item_no, qty);

							SumTot(); // showing the new total amount
						} else {
							JOptionPane.showMessageDialog(null, "Deletion failed");
						}
					}
				}
			});
		}
		ImageIcon img = new ImageIcon("Image/Button-Delete-icon.png");
		btnDelete.setIcon(img);
		return btnDelete;
	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(312, 71, 527, 267);
			scrollPane.setViewportView(getTable());
		}
		return scrollPane;
	}

	private JTable getTable() {
		if (table == null) {
			table = new JTable();
			table.setModel(new DefaultTableModel(new Object[][] {},
					new String[] { "Item_id", "Name", "Qty", "Mrp", "Discount", "Amount" }));

			table.getColumnModel().getColumn(0).setPreferredWidth(5);
			table.getColumnModel().getColumn(1).setPreferredWidth(98);
			table.getColumnModel().getColumn(2).setPreferredWidth(5);
			table.getColumnModel().getColumn(3).setPreferredWidth(18);
			table.getColumnModel().getColumn(4).setPreferredWidth(12);
			table.getColumnModel().getColumn(5).setPreferredWidth(18);
		}
		return table;
	}

	private JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.addItem(null);
			ItemDao idao = new ItemDaoImpl();
			List<Item> items = idao.getAll();
			for (Item x : items) {
				comboBox.addItem(x.getItem_no());
			}

			comboBox.setBounds(130, 109, 70, 20);
			comboBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					ItemDao idao = new ItemDaoImpl();
					try {
						Item i = idao.getItemById((int) comboBox.getSelectedItem());
						textItem.setText(i.getItem_name());
						textMrp.setText(Integer.toString(i.getMrp()));
						// textQty.setText(Integer.toString(i.getQuantity()));
					} catch (Exception e) {
						textItem.setText(null); // set to null in case the
												// selected item is null
						textMrp.setText(null);
						// textQty.setText(null);
					}

				}
			});
		}
		return comboBox;
	}

	private JLabel getLblDate() {
		if (lblDate == null) {
			lblDate = new JLabel("Date");
			lblDate.setBounds(312, 32, 46, 20);
		}
		return lblDate;
	}

	private JDateChooser getDateChooser() {
		if (dateChooser == null) {
			dateChooser = new JDateChooser();
			dateChooser.setBounds(350, 32, 113, 20);
			dateChooser.setDate(new Date());
		}
		return dateChooser;
	}

	private JLabel getLblTotal() {
		if (lblTotal == null) {
			lblTotal = new JLabel("Total");
			lblTotal.setBounds(605, 355, 75, 14);
		}
		return lblTotal;
	}

	private JTextField getTextTotal() {
		if (textTotal == null) {
			textTotal = new JTextField();
			textTotal.setBounds(708, 349, 86, 20);
			textTotal.setColumns(10);
		}

		return textTotal;
	}

	private void emptyForm() {
		comboBox.setSelectedIndex(0);
		textItem.setText(null);
		textMrp.setText(null);
		textQty.setText(null);
		textDisc.setText(null);
	}

	private void SumTot() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		int SumTot = 0;
		int TotRow = model.getRowCount();
		for (int i = 0; i < TotRow; i++) {
			SumTot = SumTot + Integer.parseInt(model.getValueAt(i, 5).toString());

		}
		textTotal.setText(Integer.toString(SumTot));

	}

	private JButton getBtnReceipt() {
		if (btnReceipt == null) {
			btnReceipt = new JButton("Receipt");
			btnReceipt.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					List<Bill> lb = getReceipt();
					new Receipt(lb).setVisible(true);
					; // creating new receipt object, passing billlist and
						// opening the frame
				}
			});
			btnReceipt.setBounds(312, 405, 89, 23);
		}
		return btnReceipt;
	}

	public List<Bill> getReceipt() {

		List<Bill> BillList = new ArrayList<>();
		int row = table.getRowCount();
		for (int i = 0; i < row; i++) {
			Bill b = new Bill();
			long date1 = dateChooser.getDate().getTime();
			java.sql.Date date = new java.sql.Date(date1);
			b.setDate(date);
			b.setItem_no((int) table.getValueAt(i, 0));
			b.setItem_name((String) table.getValueAt(i, 1));
			b.setQty((int) table.getValueAt(i, 2));
			b.setMrp((int) table.getValueAt(i, 3));
			b.setDiscount((int) table.getValueAt(i, 4));
			b.setAmount((int) table.getValueAt(i, 5));
			b.setCus_name(textCust.getText());
			b.setBill_no(Integer.parseInt(textBill.getText()));
			BillList.add(b);

		}
		return BillList;
	}
	private JButton getBtnExit() {
		if (btnExit == null) {
			btnExit = new JButton("Exit");
			btnExit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
				}
			});
			btnExit.setBounds(27, 414, 89, 23);
		}
		return btnExit;
	}
}
