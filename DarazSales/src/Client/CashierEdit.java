package Client;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.text.TableView.TableRow;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;

import model.Cashier;
import service.CashierDao;
import service.CashierDaoImpl;

import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class CashierEdit extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblLastName;
	private JLabel lblUserName;
	private JLabel lblPassword;
	private JLabel lblDateOfBirth;
	private JLabel lblAddress;
	private JTextField textFname;
	private JTextField textLname;
	private JTextField textUsername;
	private JTextField textAddress;
	private JButton btnExit;
	private JDateChooser dateCh;
	private JLabel lblId;
	private JTextField textId;
	private JLabel lblAddeditCashierDetail;
	private JButton btnAdd;
	private JButton btnUpdate;
	private JButton btnDelete;
	private JScrollPane scrollPane;
	private JTable table;
	private JTextField pwdFirst;
	private JButton btnSave;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CashierEdit frame = new CashierEdit();
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
	public CashierEdit() {
		setBackground(new Color(51, 204, 204));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1102, 469);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblNewLabel());
		contentPane.add(getLblLastName());
		contentPane.add(getLblUserName());
		contentPane.add(getLblPassword());
		contentPane.add(getLblDateOfBirth());
		contentPane.add(getLblAddress());
		contentPane.add(getTextFname());
		contentPane.add(getTextLname());
		contentPane.add(getTextUsername());
		contentPane.add(getTextAddress());
		contentPane.add(getBtnExit());
		contentPane.add(getDateCh());
		contentPane.add(getLblId());
		contentPane.add(getTextId());
		contentPane.add(getLblAddeditCashierDetail());
		contentPane.add(getBtnAdd());
		contentPane.add(getBtnUpdate());
		contentPane.add(getBtnDelete());
		contentPane.add(getScrollPane());
		contentPane.add(getPwdFirst());
		contentPane.add(getBtnSave());
		populateData();

	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("First Name");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblNewLabel.setBounds(26, 78, 155, 23);
		}
		return lblNewLabel;
	}

	private JLabel getLblLastName() {
		if (lblLastName == null) {
			lblLastName = new JLabel("Last Name");
			lblLastName.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblLastName.setBounds(26, 112, 155, 23);
		}
		return lblLastName;
	}

	private JLabel getLblUserName() {
		if (lblUserName == null) {
			lblUserName = new JLabel("Username");
			lblUserName.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblUserName.setBounds(26, 146, 155, 23);
		}
		return lblUserName;
	}

	private JLabel getLblPassword() {
		if (lblPassword == null) {
			lblPassword = new JLabel("Password");
			lblPassword.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblPassword.setBounds(26, 180, 119, 23);
		}
		return lblPassword;
	}

	private JLabel getLblDateOfBirth() {
		if (lblDateOfBirth == null) {
			lblDateOfBirth = new JLabel("Date of Birth");
			lblDateOfBirth.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblDateOfBirth.setBounds(26, 214, 155, 23);
		}
		return lblDateOfBirth;
	}

	private JLabel getLblAddress() {
		if (lblAddress == null) {
			lblAddress = new JLabel("Address");
			lblAddress.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblAddress.setBounds(26, 248, 89, 23);
		}
		return lblAddress;
	}

	private JTextField getTextFname() {
		if (textFname == null) {
			textFname = new JTextField();
			textFname.setBounds(156, 77, 214, 24);
			textFname.setColumns(10);
		}
		return textFname;
	}

	private JTextField getTextLname() {
		if (textLname == null) {
			textLname = new JTextField();
			textLname.setColumns(10);
			textLname.setBounds(156, 111, 214, 24);
		}
		return textLname;
	}

	private JTextField getTextUsername() {
		if (textUsername == null) {
			textUsername = new JTextField();
			textUsername.setColumns(10);
			textUsername.setBounds(156, 146, 214, 24);
		}
		return textUsername;
	}

	private JTextField getTextAddress() {
		if (textAddress == null) {
			textAddress = new JTextField();
			textAddress.setColumns(10);
			textAddress.setBounds(156, 248, 214, 23);
		}
		return textAddress;
	}

	private JButton getBtnExit() {
		if (btnExit == null) {
			btnExit = new JButton("Exit");
			btnExit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					new AdminHome().setVisible(true);
					dispose();
				}
			});
			btnExit.setBounds(290, 366, 80, 23);
		}
		btnExit.setIcon(new ImageIcon(getClass().getClassLoader().getResource("exit-icon.png")));
		return btnExit;
	}

	private JDateChooser getDateCh() {
		if (dateCh == null) {
			dateCh = new JDateChooser();
			dateCh.setBounds(156, 214, 214, 20);
		}
		return dateCh;
	}

	private JLabel getLblId() {
		if (lblId == null) {
			lblId = new JLabel("ID");
			lblId.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblId.setBounds(26, 44, 155, 23);
		}
		return lblId;
	}

	private JTextField getTextId() {
		if (textId == null) {
			textId = new JTextField();
			textId.setEditable(false);
			textId.setColumns(10);
			textId.setBounds(156, 43, 214, 24);
		}
		return textId;
	}

	private JLabel getLblAddeditCashierDetail() {
		if (lblAddeditCashierDetail == null) {
			lblAddeditCashierDetail = new JLabel("Add/Edit Cashier Detail");
			lblAddeditCashierDetail.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblAddeditCashierDetail.setBounds(131, 0, 214, 25);
		}
		return lblAddeditCashierDetail;
	}

	private JButton getBtnAdd() {
		if (btnAdd == null) {
			btnAdd = new JButton("Add New");
			btnAdd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					String fname = textFname.getText();
					String lname = textLname.getText();
					String username = textUsername.getText();
					String password1 = new String(pwdFirst.getText());

					Date dob = new Date(dateCh.getDate().getTime());
					String address = textAddress.getText();
					if (fname.isEmpty() || lname.isEmpty() || username.isEmpty() || password1.isEmpty() || dob == null
							|| address.isEmpty()) {
						JOptionPane.showMessageDialog(null, "All field needs to be filled");

					} else if (password1.length() < 8) {
						JOptionPane.showMessageDialog(null, "Minimum password length should be 8");
					} else {

						Cashier c = new Cashier();
						c.setFname(fname);
						c.setLname(lname);
						c.setUsername(username);
						c.setPassword(password1);
						c.setDob(dob);
						c.setAddress(address);

						CashierDao cdao = new CashierDaoImpl();
						if (cdao.uernameExists(c.getUsername()) == true) {
							JOptionPane.showMessageDialog(null, "Username already exists");
							return;

						}
						if (cdao.addCashier(c)) {
							JOptionPane.showMessageDialog(null, "New cashier added");
							textFname.setText("");
							textLname.setText("");
							textUsername.setText("");
							pwdFirst.setText("");

							textAddress.setText("");
							populateData();

						} else {
							JOptionPane.showMessageDialog(null, "Error in signup");
						}

					}
				}
			});
			btnAdd.setBounds(26, 308, 105, 23);
		}
		btnAdd.setIcon(new ImageIcon(getClass().getClassLoader().getResource("add-icon.png")));
		return btnAdd;
	}

	private JButton getBtnUpdate() {
		if (btnUpdate == null) {
			btnUpdate = new JButton("Update");
			btnUpdate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (table.getSelectedRow() < 0) {
						JOptionPane.showMessageDialog(null, "No Row selected");
					} else {
						int row = table.getSelectedRow();
						int uid = (int) table.getModel().getValueAt(row, 0);
						CashierDao cdao = new CashierDaoImpl();
						Cashier c1 = cdao.getById(uid);
						textId.setText(String.valueOf(uid));
						textFname.setText(c1.getFname());
						textLname.setText(c1.getLname());
						textUsername.setText(c1.getUsername());
						pwdFirst.setText(c1.getPassword());
						dateCh.setDate(c1.getDob());
						textAddress.setText(c1.getAddress());

					}

				}
			});
			btnUpdate.setBounds(156, 308, 105, 23);
		}
		btnUpdate.setIcon(new ImageIcon(getClass().getClassLoader().getResource("update-icon.png")));
		return btnUpdate;
	}

	private JButton getBtnDelete() {
		if (btnDelete == null) {
			btnDelete = new JButton("Delete");
			btnDelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (table.getSelectedRow() < 0) {
						JOptionPane.showMessageDialog(null, "No Row selected");
					} else {
						int row = table.getSelectedRow();
						int uid = (int) table.getModel().getValueAt(row, 0);
						CashierDao cdao = new CashierDaoImpl();
						if (cdao.delete(uid)) {
							JOptionPane.showMessageDialog(null, "Record deleted");
							populateData();
						} else {
							JOptionPane.showMessageDialog(null, "Error");
						}

					}
				}
			});
			btnDelete.setBounds(277, 308, 100, 23);
		}
		btnDelete.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Button-Delete-icon.png")));
		return btnDelete;
	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(380, 23, 700, 308);
			scrollPane.setViewportView(getTable());
		}
		return scrollPane;
	}

	private JTable getTable() {
		if (table == null) {
			table = new JTable();
			table.setModel(new DefaultTableModel(new Object[][] {},
					new String[] { "Id", "fname", "lname", "Username", "password", "dob", "address" }));
		}

		return table;
	}

	private void populateData() {
		DefaultTableModel t1 = (DefaultTableModel) table.getModel();
		CashierDao cdao = new CashierDaoImpl();
		List<Cashier> clist = cdao.getAll();
		t1.setRowCount(0);
		for (Cashier c : clist) {
			t1.addRow(new Object[] { c.getId(), c.getFname(), c.getLname(), c.getUsername(), c.getPassword(),
					c.getDob(), c.getAddress() });

		}
	}

	private JTextField getPwdFirst() {
		if (pwdFirst == null) {
			pwdFirst = new JTextField();
			pwdFirst.setColumns(10);
			pwdFirst.setBounds(156, 180, 214, 24);
		}
		return pwdFirst;
	}

	private JButton getBtnSave() {
		if (btnSave == null) {
			btnSave = new JButton("Save");
			btnSave.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					Cashier c1 = new Cashier();
					c1.setId((Integer.parseInt(textId.getText())));
					c1.setFname(textFname.getText());
					c1.setLname(textLname.getText());
					c1.setUsername(textUsername.getText());
					c1.setPassword(pwdFirst.getText());
					c1.setDob(new Date(dateCh.getDate().getTime()));
					c1.setAddress(textAddress.getText());
					CashierDao cdao = new CashierDaoImpl();
					if (cdao.update(c1)) {
						JOptionPane.showMessageDialog(null, "Updated successfully");
						populateData();
						textId.setText(null);
						textFname.setText(null);
						textLname.setText(null);
						textUsername.setText(null);
						pwdFirst.setText(null);
						dateCh.setDate(null);
						textAddress.setText(null);
					} else {
						JOptionPane.showMessageDialog(null, "Update failed");
					}
				}
			});
			btnSave.setIcon(new ImageIcon(getClass().getClassLoader().getResource("save-icon.png")));
			btnSave.setBounds(156, 366, 105, 23);
		}
		return btnSave;
	}
}
