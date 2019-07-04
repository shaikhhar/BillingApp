package Client;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;

public class AdminLogin extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblPassword;
	private JTextField textFeildUserName;
	private JCheckBox chckbxShow;
	private JButton btnLogin;
	private JButton btnCancel;
	private JButton btnExit;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminLogin frame = new AdminLogin();
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
	public AdminLogin() {
		setTitle("Admin Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 444, 317);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 102, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblNewLabel());
		contentPane.add(getLblPassword());
		contentPane.add(getTextFeildUserName());
		contentPane.add(getChckbxShow());
		contentPane.add(getBtnLogin());
		contentPane.add(getBtnCancel());
		contentPane.add(getBtnExit());
		contentPane.add(getPasswordField());
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Username");
			lblNewLabel.setBounds(10, 49, 103, 22);
			lblNewLabel.setForeground(SystemColor.text);
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		}
		return lblNewLabel;
	}
	private JLabel getLblPassword() {
		if (lblPassword == null) {
			lblPassword = new JLabel("Password");
			lblPassword.setBounds(10, 105, 103, 22);
			lblPassword.setForeground(SystemColor.text);
			lblPassword.setFont(new Font("Tahoma", Font.BOLD, 12));
		}
		return lblPassword;
	}
	private JTextField getTextFeildUserName() {
		if (textFeildUserName == null) {
			textFeildUserName = new JTextField();
			textFeildUserName.setBounds(123, 41, 165, 30);
			textFeildUserName.setColumns(10);
		}
		return textFeildUserName;
	}
	private JCheckBox getChckbxShow() {
		if (chckbxShow == null) {
			chckbxShow = new JCheckBox("Show");
			chckbxShow.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(chckbxShow.isSelected()){
						passwordField.setEchoChar((char)0);
						
					}else{
						passwordField.setEchoChar('*');
						
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
					String un= textFeildUserName.getText();
					String pw= new String(passwordField.getPassword());
					if(un.equals("admin")&&pw.equals("12345678")){
						new AdminHome().setVisible(true);
						dispose();
						}
					else{
						JOptionPane.showMessageDialog(null, "Invalid username/password");
					}
					
				}
			});
			btnLogin.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
			btnLogin.setBounds(207, 149, 81, 23);
			btnLogin.setForeground(new Color(255, 255, 255));
			btnLogin.setFont(new Font("Tahoma", Font.BOLD, 10));
			btnLogin.setBackground(new Color(0, 153, 0));
		}
		return btnLogin;
	}
	private JButton getBtnCancel() {
		if (btnCancel == null) {
			btnCancel = new JButton("CANCEL");
			btnCancel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
			btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new IndexPage().setVisible(true);
					dispose();
					
					
				}
			});
			btnCancel.setBounds(123, 149, 78, 23);
			btnCancel.setFont(new Font("Tahoma", Font.BOLD, 10));
			btnCancel.setForeground(new Color(255, 255, 255));
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
	private JPasswordField getPasswordField() {
		if (passwordField == null) {
			passwordField = new JPasswordField();
			passwordField.setBounds(123, 102, 165, 30);
		}
		return passwordField;
	}
}
