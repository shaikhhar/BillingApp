package Client;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import service.CashierDao;
import service.CashierDaoImpl;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CashierLogin extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblPassword;
	private JTextField textUn;
	private JCheckBox chckbxShow;
	private JButton btnLogin;
	private JButton btnCancel;
	private JButton btnExit;
	private JPasswordField pwd;
	private JLabel lblSignUpTo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CashierLogin frame = new CashierLogin();
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
	public CashierLogin() {
		setTitle("Cashier Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 444, 317);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 204, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblNewLabel());
		contentPane.add(getLblPassword());
		contentPane.add(getTextUn());
		contentPane.add(getChckbxShow());
		contentPane.add(getBtnLogin());
		contentPane.add(getBtnCancel());
		contentPane.add(getBtnExit());
		contentPane.add(getPwd());
		contentPane.add(getLblSignUpTo());
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Username");
			lblNewLabel.setBounds(10, 49, 103, 22);
			lblNewLabel.setForeground(new Color(0, 0, 0));
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		}
		return lblNewLabel;
	}
	private JLabel getLblPassword() {
		if (lblPassword == null) {
			lblPassword = new JLabel("Password");
			lblPassword.setBounds(10, 105, 103, 22);
			lblPassword.setForeground(new Color(0, 0, 0));
			lblPassword.setFont(new Font("Tahoma", Font.BOLD, 12));
		}
		return lblPassword;
	}
	private JTextField getTextUn() {
		if (textUn == null) {
			textUn = new JTextField();
			textUn.setBounds(123, 41, 165, 30);
			textUn.setColumns(10);
		}
		return textUn;
	}
	private JCheckBox getChckbxShow() {
		if (chckbxShow == null) {
			chckbxShow = new JCheckBox("Show");
			chckbxShow.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(chckbxShow.isSelected()){
						pwd.setEchoChar((char)0);
						
					}else{
						pwd.setEchoChar('*');
						
					}
					
				}
			});
			chckbxShow.setBounds(294, 106, 60, 23);
			chckbxShow.setBackground(new Color(0, 153, 204));
		}
		return chckbxShow;
	}
	private JButton getBtnLogin() {
		if (btnLogin == null) {
			btnLogin = new JButton("LOGIN");
			btnLogin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String un= textUn.getText();
					String pw= new String(pwd.getPassword());
					
					CashierDao cdao= new CashierDaoImpl();
					
					if(cdao.userValidate(un, pw)){
						new CashierHome().setVisible(true);
						dispose();
					}else{
						JOptionPane.showMessageDialog(null, "Invalid Username/Password");
					}
					
					
					
				}
			});
			btnLogin.setBounds(207, 149, 81, 23);
			btnLogin.setForeground(new Color(0, 0, 0));
			btnLogin.setFont(new Font("Tahoma", Font.BOLD, 10));
			btnLogin.setBackground(new Color(0, 153, 0));
		}
		return btnLogin;
	}
	private JButton getBtnCancel() {
		if (btnCancel == null) {
			btnCancel = new JButton("CANCEL");
			btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new IndexPage().setVisible(true);
					dispose();
					
					
				}
			});
			btnCancel.setBounds(123, 149, 78, 23);
			btnCancel.setFont(new Font("Tahoma", Font.BOLD, 10));
			btnCancel.setForeground(new Color(0, 0, 0));
			btnCancel.setBackground(new Color(204, 255, 0));
		}
		return btnCancel;
	}
	private JButton getBtnExit() {
		if (btnExit == null) {
			btnExit = new JButton("EXIT");
			btnExit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					new IndexPage().setVisible(true);
					dispose();
				}
			});
			btnExit.setBounds(162, 204, 81, 23);
			btnExit.setBackground(new Color(255, 0, 0));
		}
		return btnExit;
	}
	private JPasswordField getPwd() {
		if (pwd == null) {
			pwd = new JPasswordField();
			pwd.setBounds(123, 102, 165, 30);
		}
		return pwd;
	}
	private JLabel getLblSignUpTo() {
		if (lblSignUpTo == null) {
			lblSignUpTo = new JLabel("Click here to create new Cashier account");
			lblSignUpTo.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
					new CashierSignup().setVisible(true);
					dispose();
				}
			});
			lblSignUpTo.setBackground(new Color(0, 0, 102));
			lblSignUpTo.setForeground(new Color(0, 0, 0));
			lblSignUpTo.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 12));
			lblSignUpTo.setBounds(106, 254, 241, 14);
		}
		return lblSignUpTo;
	}
}
