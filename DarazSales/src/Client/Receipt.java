package Client;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.OutputStreamWriter;
import java.sql.Date;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Bill;

import javax.swing.JTextArea;
import javax.swing.JButton;



import java.awt.print.*;

public class Receipt extends JFrame {

	private JPanel contentPane;
	private JTextArea textArea;
	private JButton btnPrint;
//	private List<Bill> Bills;
	

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
//		List<Bill> Bills= null;
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
		List<Bill> Bills=blist;
		String billdate = Bills.get(0).getDate().toString();
		 String billno = String.valueOf(Bills.get(0).getBill_no());
		String Cust= Bills.get(0).getCus_name().toString();
		String header=("************Receipt**********\n");
        String billinfo="Bill: "+billno+"\nDate: "+billdate+"\nCustomer: "+Cust+"\n\n";
	    int amnt = 0;
	    StringBuffer billdetail=new StringBuffer();
	    
		for(Bill b: Bills){
			String item_no= String.valueOf(b.getItem_no());
			String item_name= b.getItem_name();
			String mrp= String.valueOf(b.getMrp());
			String disc = String.valueOf(b.getDiscount());
			String amount = String.valueOf(b.getAmount());
			billdetail.append("\n"+item_no+"\t"+item_name+"\t\t"+mrp+"\t"+disc+"\t"+amount);
			amnt=amnt+Integer.parseInt(amount);
		}
		String columns="\nItem_no\tItem_name\t\t\tmrp\tdiscount\tamount";
		String Billdetailed=billdetail.toString();
		String total = "\n\nTotal\t\t\t\t\t\t"+String.valueOf(amnt);
		String footer = "\n\n\n\nTHANK YOU FOR SHOPPING WITH US. HOPE TO SEE YOU AGAIN";
		textArea.setText(header+billinfo+columns+Billdetailed+total+footer);
	}
	
	
	private JTextArea getTextArea() {
		if (textArea == null) {
			textArea = new JTextArea();
			textArea.setBounds(10, 29, 600, 510);
			
		}
		return textArea;
	}
	
	
//	public void fillText(List<Bill> billlist){ 
//		long billdate = billlist.get(0).getDate().getTime();
//		 String billno = String.valueOf(billlist.get(0).getBill_no());
//		String Cust= billlist.get(0).getCus_name().toString();
//		textArea.setText("************Receipt**********\n");
//		textArea.setText("Date: "+billno+"\nDate: "+billdate+"\nCustomer: "+Cust);
//		int amnt = 0;
//		for(Bill b: billlist){
//			String item_no= String.valueOf(b.getItem_no());
//			String item_name= b.getItem_name();
//			String mrp= String.valueOf(b.getMrp());
//			String disc = String.valueOf(b.getDiscount());
//			String amount = String.valueOf(b.getAmount());
//			textArea.setText("\n"+item_no+"\t"+item_name+"\t"+mrp+"\t"+disc+"\t"+amount);
//			amnt=amnt+Integer.parseInt(amount);
//		}
//		String total = String.valueOf(amnt);
//		textArea.setText("\n\t\t\t\t\t\t\t\t"+total);
//		textArea.setText("\n\n\n\nTHANK YOU FOR SHOPPING WITH US. HOPE TO SEE YOU AGAIN");
//	}
	
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
			});;
		}
		return btnPrint;
	}
}
