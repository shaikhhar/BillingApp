package Client;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;

public class IndexPage extends JFrame {

	private JPanel contentPane;
	private JLabel darazicon;
	private JLabel lblNewLabel;
	private JButton btnCashierLogin;
	private JLabel lblNewLabel_1;
	private JButton btnAdminLogin;
	private JSeparator separator;
	private JButton btnExit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IndexPage frame = new IndexPage();
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
	public IndexPage() {
		setTitle("Billing app");
		setBackground(new Color(0, 0, 128));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 481, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getDarazicon());
		contentPane.add(getLblNewLabel());
		contentPane.add(getBtnCashierLogin());
		contentPane.add(getLblNewLabel_1());
		contentPane.add(getBtnAdminLogin());
		contentPane.add(getSeparator());
		contentPane.add(getBtnExit());
	}
	private JLabel getDarazicon() {
		if (darazicon == null) {
			darazicon = new JLabel("New label");
			darazicon.setBounds(44, 56, 213, 112);
			darazicon.setIcon(new ImageIcon(new ImageIcon(getClass().getClassLoader().getResource("main.png")).getImage().getScaledInstance(darazicon.getWidth(), darazicon.getHeight(), Image.SCALE_DEFAULT)));
			
			
		}
		return darazicon;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Welcome to Billing App");
			lblNewLabel.setBounds(97, 0, 315, 32);
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblNewLabel.setForeground(new Color(0, 0, 128));
		}
		return lblNewLabel;
	}
	private JButton getBtnCashierLogin() {
		if (btnCashierLogin == null) {
			btnCashierLogin = new JButton("Cashier Login");
			btnCashierLogin.setForeground(Color.BLACK);
			btnCashierLogin.setBackground(Color.ORANGE);
			btnCashierLogin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					new CashierLogin().setVisible(true);
					dispose();
				}
			});
			btnCashierLogin.setFont(new Font("Tahoma", Font.BOLD, 12));
			btnCashierLogin.setBounds(328, 119, 116, 32);
		}
		return btnCashierLogin;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("Quick Bill");
			lblNewLabel_1.setBounds(45, 179, 84, 14);
			lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 15));
			lblNewLabel_1.setForeground(new Color(0, 0, 128));
		}
		return lblNewLabel_1;
	}
	private JButton getBtnAdminLogin() {
		if (btnAdminLogin == null) {
			btnAdminLogin = new JButton("Admin Login");
			btnAdminLogin.setForeground(Color.BLACK);
			btnAdminLogin.setBackground(Color.ORANGE);
			btnAdminLogin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					new AdminLogin().setVisible(true);
					dispose();
					
				}
			});
			btnAdminLogin.setFont(new Font("Tahoma", Font.BOLD, 12));
			btnAdminLogin.setBounds(328, 72, 116, 32);
		}
		return btnAdminLogin;
	}
	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setBackground(new Color(0, 0, 0));
			separator.setBounds(10, 31, 426, 2);
		}
		return separator;
	}
	private JButton getBtnExit() {
		if (btnExit == null) {
			btnExit = new JButton("EXIT");
			btnExit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
				}
			});
			btnExit.setBounds(187, 217, 70, 23);
		}
		return btnExit;
	}
}
