package Client;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CashierSignup extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblLastName;
	private JLabel lblUserName;
	private JLabel lblPassword;
	private JLabel lblRetypePassword;
	private JLabel lblDateOfBirth;
	private JLabel lblAddress;
	private JTextField textFname;
	private JTextField textLname;
	private JTextField textUsername;
	private JTextField textAddress;
	private JButton btnSignUp;
	private JLabel lblClickHereTo;
	private JButton btnExit;
	private JDateChooser dateCh;
	private JPasswordField pwdFirst;
	private JPasswordField pwdSecond;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CashierSignup frame = new CashierSignup();
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
	public CashierSignup() {
		setBackground(new Color(51, 204, 204));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 469);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblNewLabel());
		contentPane.add(getLblLastName());
		contentPane.add(getLblUserName());
		contentPane.add(getLblPassword());
		contentPane.add(getLblRetypePassword());
		contentPane.add(getLblDateOfBirth());
		contentPane.add(getLblAddress());
		contentPane.add(getTextFname());
		contentPane.add(getTextLname());
		contentPane.add(getTextUsername());
		contentPane.add(getTextAddress());
		contentPane.add(getBtnSignUp());
		contentPane.add(getLabel_6());
		contentPane.add(getBtnExit());
		contentPane.add(getDateCh());
		contentPane.add(getPwdFirst());
		contentPane.add(getPwdSecond());
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("First Name");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblNewLabel.setBounds(26, 29, 155, 23);
		}
		return lblNewLabel;
	}
	private JLabel getLblLastName() {
		if (lblLastName == null) {
			lblLastName = new JLabel("Last Name");
			lblLastName.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblLastName.setBounds(26, 63, 155, 23);
		}
		return lblLastName;
	}
	private JLabel getLblUserName() {
		if (lblUserName == null) {
			lblUserName = new JLabel("Username");
			lblUserName.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblUserName.setBounds(26, 97, 155, 23);
		}
		return lblUserName;
	}
	private JLabel getLblPassword() {
		if (lblPassword == null) {
			lblPassword = new JLabel("Password");
			lblPassword.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblPassword.setBounds(26, 126, 119, 23);
		}
		return lblPassword;
	}
	private JLabel getLblRetypePassword() {
		if (lblRetypePassword == null) {
			lblRetypePassword = new JLabel("Retype Password");
			lblRetypePassword.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblRetypePassword.setBounds(26, 156, 155, 23);
		}
		return lblRetypePassword;
	}
	private JLabel getLblDateOfBirth() {
		if (lblDateOfBirth == null) {
			lblDateOfBirth = new JLabel("Date of Birth");
			lblDateOfBirth.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblDateOfBirth.setBounds(26, 187, 155, 23);
		}
		return lblDateOfBirth;
	}
	private JLabel getLblAddress() {
		if (lblAddress == null) {
			lblAddress = new JLabel("Address");
			lblAddress.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblAddress.setBounds(26, 221, 155, 23);
		}
		return lblAddress;
	}
	private JTextField getTextFname() {
		if (textFname == null) {
			textFname = new JTextField();
			textFname.setBounds(156, 22, 214, 24);
			textFname.setColumns(10);
		}
		return textFname;
	}
	private JTextField getTextLname() {
		if (textLname == null) {
			textLname = new JTextField();
			textLname.setColumns(10);
			textLname.setBounds(156, 56, 214, 24);
		}
		return textLname;
	}
	private JTextField getTextUsername() {
		if (textUsername == null) {
			textUsername = new JTextField();
			textUsername.setColumns(10);
			textUsername.setBounds(156, 91, 214, 24);
		}
		return textUsername;
	}
	private JTextField getTextAddress() {
		if (textAddress == null) {
			textAddress = new JTextField();
			textAddress.setColumns(10);
			textAddress.setBounds(156, 223, 214, 99);
		}
		return textAddress;
	}
	private JButton getBtnSignUp() {
		if (btnSignUp == null) {
			btnSignUp = new JButton("Sign Up");
			btnSignUp.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String fname= textFname.getText();
					String lname=textLname.getText();
					String username=textUsername.getText();
					String password1=new String(pwdFirst.getPassword());
					String password2=new String(pwdSecond.getPassword());
								
					Date dob= new Date(dateCh.getDate().getTime());
					String address= textAddress.getText();
					if(fname.isEmpty() || lname.isEmpty() || username.isEmpty() ||password1.isEmpty()||password2.isEmpty()||dob==null||address.isEmpty()){
						JOptionPane.showMessageDialog(null, "All field needs to be filled");
						
					}else if(!password1.equals(password2)){
						JOptionPane.showMessageDialog(null, fname+lname+username+password1+password2+"Password not matched");
					}else if(password1.length()<8){
						JOptionPane.showMessageDialog(null, "Minimum password length should be 8");
					}
					else{	
					
					Cashier c= new Cashier();
					c.setFname(fname);
					c.setLname(lname);
					c.setUsername(username);
					c.setPassword(password2);
					c.setDob(dob);
					c.setAddress(address);
					
					CashierDao cdao= new CashierDaoImpl();
					if(cdao.uernameExists(c.getUsername())==true){
						JOptionPane.showMessageDialog(null, "Username already exists");
						return;
						
					}
					if(cdao.addCashier(c)){
					JOptionPane.showMessageDialog(null, "New cashier registered Successfully");
					textFname.setText("");
					textLname.setText("");
					textUsername.setText("");
					pwdFirst.setText("");
					pwdSecond.setText("");
				    	
				    textAddress.setText("");
					
					}else{
						JOptionPane.showMessageDialog(null, "Error in signup");
					}
					
					
					}	
				}
			});
			btnSignUp.setFont(new Font("Tahoma", Font.BOLD, 11));
			btnSignUp.setBounds(209, 333, 89, 23);
		}
		return btnSignUp;
	}
	private JLabel getLabel_6() {
		if (lblClickHereTo == null) {
			lblClickHereTo = new JLabel("Click here to Login");
			lblClickHereTo.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					
					new CashierLogin().setVisible(true);
					dispose();
					
				}
			});
			lblClickHereTo.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblClickHereTo.setBounds(204, 368, 166, 14);
		}
		return lblClickHereTo;
	}
	private JButton getBtnExit() {
		if (btnExit == null) {
			btnExit = new JButton("Exit");
			btnExit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					new IndexPage().setVisible(true);
					dispose();
				}
			});
			btnExit.setBounds(229, 397, 57, 23);
		}
		return btnExit;
	}
	private JDateChooser getDateCh() {
		if (dateCh == null) {
			dateCh = new JDateChooser();
			dateCh.setBounds(156, 187, 214, 20);
		}
		return dateCh;
	}
	private JPasswordField getPwdFirst() {
		if (pwdFirst == null) {
			pwdFirst = new JPasswordField();
			pwdFirst.setBounds(156, 126, 214, 22);
		}
		return pwdFirst;
	}
	private JPasswordField getPwdSecond() {
		if (pwdSecond == null) {
			pwdSecond = new JPasswordField();
			pwdSecond.setBounds(156, 154, 214, 22);
		}
		return pwdSecond;
	}
}
