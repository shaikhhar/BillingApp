 package Client;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AdminHome extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JLabel lblSearchBill;
	private JLabel lblProductInfo;
	private JButton btnExit;
	private JLabel label;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminHome frame = new AdminHome();
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
	public AdminHome() {
		setTitle("Daraz Bill");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 718, 336);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getPanel());
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBackground(new Color(255, 255, 102));
			panel.setBounds(0, 0, 692, 70);
			panel.setLayout(null);
			panel.add(getLblNewLabel());
			panel.add(getLblSearchBill());
			panel.add(getLblProductInfo());
			panel.add(getBtnExit());
			panel.add(getLabel_3());
		}
		return panel;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Cashier");
			lblNewLabel.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					new CashierEdit().setVisible(true);
					dispose();
				}
			});
			lblNewLabel.setIcon(new ImageIcon(AdminHome.class.getResource("/javax/swing/plaf/metal/icons/ocean/upFolder.gif")));
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblNewLabel.setBounds(140, 30, 103, 14);
		}
		return lblNewLabel;
	}
	private JLabel getLblSearchBill() {
		if (lblSearchBill == null) {
			lblSearchBill = new JLabel("Transaction");
			lblSearchBill.setIcon(new ImageIcon(getClass().getClassLoader().getResource("transaction-icon.png")));
			lblSearchBill.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblSearchBill.setBounds(253, 30, 115, 14);
			lblSearchBill.addMouseListener(new MouseAdapter() {
				
				public void mouseClicked(MouseEvent me){
					new BillInfo().setVisible(true);
					
				}
				
			});
			
		}
		return lblSearchBill;
	}
	private JLabel getLblProductInfo() {
		if (lblProductInfo == null) {
			lblProductInfo = new JLabel("Stock");
			lblProductInfo.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					new StockUpdate().setVisible(true);
				}
			});
			lblProductInfo.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblProductInfo.setBounds(431, 30, 95, 14);
		}
		lblProductInfo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("stock-icon.png")));
		return lblProductInfo;
	}
	private JButton getBtnExit() {
		if (btnExit == null) {
			btnExit = new JButton("Exit");
			btnExit.setIcon(new ImageIcon(AdminHome.class.getResource("/javax/swing/plaf/metal/icons/ocean/close.gif")));
			btnExit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new AdminLogin().setVisible(true);
					dispose();
				}
			});
			btnExit.setFont(new Font("Sylfaen", Font.BOLD, 11));
			btnExit.setBounds(585, 27, 97, 23);
		}
		return btnExit;
	}
	private JLabel getLabel_3() {
		if (label == null) {
			label = new JLabel("");
			Image img = new ImageIcon(getClass().getClassLoader().getResource("main.png")).getImage().getScaledInstance(92, 70, Image.SCALE_DEFAULT);
			label.setIcon(new ImageIcon(img));
			label.setBounds(10, 11, 92, 48);
		}
		return label;
	}
}
