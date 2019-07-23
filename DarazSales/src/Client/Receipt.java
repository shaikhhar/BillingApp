package Client;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Bill;

import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.print.*;

public class Receipt extends JFrame {

	private JPanel contentPane;
	private JTextArea textArea;
	private JButton btnPrint;
	// private List<Bill> Bills;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Receipt frame = new Receipt();
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
	public Receipt() {
		setTitle("Receipt");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 1100);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getTextArea());
		contentPane.add(getBtnPrint());
		// List<Bill> Bills= null;
	}

	public Receipt(List<Bill> blist) {
		setTitle("Receipt");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 455, 504);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getTextArea());
		contentPane.add(getBtnPrint());
		List<Bill> Bills = blist;
		String billdate = Bills.get(0).getDate().toString();
		String billno = String.valueOf(Bills.get(0).getBill_no());
		String Cust = Bills.get(0).getCus_name().toString();
		String header = ("************Receipt**********\n");
		String billinfo = "Bill: " + billno + "\nDate: " + billdate + "\nCustomer: " + Cust + "\n\n";
		int amnt = 0;
		StringBuffer billdetail = new StringBuffer();

		for (Bill b : Bills) {
			String item_no = String.valueOf(b.getItem_no());
			String item_name = b.getItem_name();
			String qty = String.valueOf(b.getQty());
			String mrp = String.format("%,d", b.getMrp());
			String disc = String.format("%,d", b.getDiscount());
			String amount = String.format("%,d", b.getAmount());
			if(item_name.length()>15){
			billdetail.append("\n" + item_no + "\t" + item_name + "\t" + qty+"     "+mrp + "\t" + disc + "\t" + amount);
			}else{
				billdetail.append("\n" + item_no + "\t" + item_name + "\t\t" + qty+"     "+mrp + "\t" + disc + "\t" + amount);	
			}
			amnt = amnt + b.getAmount();
		}
		String columns = "\nItem_no\tItem_name\t\tqty   mrp\tdiscount\tamount";
		String Billdetailed = billdetail.toString();
		String total = "\n\nTotal\t\t\t\t     \t" + String.format("%,d", amnt);
		String footer = "\n\n\n\nTHANK YOU FOR SHOPPING WITH US. HOPE TO SEE YOU AGAIN";
		textArea.setText(header + billinfo + columns + Billdetailed + total + footer);
	}

	private JTextArea getTextArea() {
		if (textArea == null) {
			textArea = new JTextArea();
			textArea.setBounds(10, 29, 600, 510);

		}
		return textArea;
	}

	private JButton getBtnPrint() {
		if (btnPrint == null) {
			btnPrint = new JButton("Print");
			btnPrint.setBounds(10, 545, 89, 23);
			btnPrint.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						textArea.print();
					} catch (PrinterException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}
			});
			;
		}
		ImageIcon ic = new ImageIcon("Image/print-icon.png");
		btnPrint.setIcon(ic);
		return btnPrint;
	}
}
