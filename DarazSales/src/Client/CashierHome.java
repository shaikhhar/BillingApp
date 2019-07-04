package Client;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CashierHome extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JLabel lblSearchBill;
	private JLabel lblProductInfo;
	private JLabel lblSales;
	private JButton btnExit;
	private JLabel label;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CashierHome frame = new CashierHome();
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
	public CashierHome() {
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
			panel.add(getLblSales());
			panel.add(getBtnExit());
			panel.add(getLabel_3());
		}
		return panel;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Create Bill");
			lblNewLabel.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					SalesBill sb = new SalesBill();
					sb.setVisible(true);
					//dispose();
					
				}
			});
			lblNewLabel.setIcon(new ImageIcon(CashierHome.class.getResource("/javax/swing/plaf/metal/icons/ocean/upFolder.gif")));
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblNewLabel.setBounds(140, 30, 103, 14);
		}
		return lblNewLabel;
	}
	private JLabel getLblSearchBill() {
		if (lblSearchBill == null) {
			lblSearchBill = new JLabel("Search Bill");
			lblSearchBill.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblSearchBill.setBounds(253, 30, 78, 14);
		}
		return lblSearchBill;
	}
	private JLabel getLblProductInfo() {
		if (lblProductInfo == null) {
			lblProductInfo = new JLabel("Product Info");
			lblProductInfo.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblProductInfo.setBounds(368, 31, 95, 14);
		}
		return lblProductInfo;
	}
	private JLabel getLblSales() {
		if (lblSales == null) {
			lblSales = new JLabel("Sales");
			lblSales.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblSales.setBounds(497, 31, 78, 14);
		}
		return lblSales;
	}
	private JButton getBtnExit() {
		if (btnExit == null) {
			btnExit = new JButton("Exit");
			btnExit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new CashierLogin().setVisible(true);
					dispose();
				}
			});
			btnExit.setFont(new Font("Sylfaen", Font.BOLD, 11));
			btnExit.setBounds(620, 27, 62, 17);
		}
		return btnExit;
	}
	private JLabel getLabel_3() {
		if (label == null) {
			label = new JLabel("");
			label.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\dell\\workspace\\DarazSales\\Image\\daraz.jpg").getImage().getScaledInstance(62, 50, ICONIFIED)));
			label.setBounds(10, 11, 62, 48);
		}
		return label;
	}
}