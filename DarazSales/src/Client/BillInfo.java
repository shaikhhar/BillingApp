package Client;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.PopupMenuListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;

import com.toedter.calendar.JDateChooser;

import model.Bill;
import service.BillDao;
import service.BillDaoImpl;
import javax.swing.DefaultComboBoxModel;

public class BillInfo extends JFrame {

	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTable table;
	private JLabel lbBill;
	private JTextField textSearch;
	private JButton btnSearch;
	private JComboBox comboBox;
	private JLabel lblDate;
	private JDateChooser dateChooserFrom;
	private JLabel lblTo;
	private JDateChooser dateChooserTo;
	private JLabel lblTotal;
	private JTextField textTotal;
	private JButton btnExportCsv;
	private JButton btnExit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BillInfo frame = new BillInfo();
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
	public BillInfo() {
		setTitle("BIlls");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 852, 476);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getScrollPane());
		contentPane.add(getLbBill());
		contentPane.add(getTextSearch());
		contentPane.add(getBtnSearch());
		contentPane.add(getComboBox());
		contentPane.add(getLblDate());
		contentPane.add(getDateChooserFrom());
		contentPane.add(getLblTo());
		contentPane.add(getDateChooserTo());
		contentPane.add(getLblTotal());
		contentPane.add(getTextTotal());
		contentPane.add(getBtnExportCsv());
		contentPane.add(getBtnExit());
		populateBills();
		sumTot();
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(20, 110, 806, 300);
			scrollPane.setViewportView(getTable());
		}
		return scrollPane;
	}
	private JTable getTable() {
		if (table == null) {
			table = new JTable();
		}
		DefaultTableModel t = new DefaultTableModel(new Object[][]{}, new String[]{"Billno","Date", "Cust_name", "item_no","item_name","mrp","discount","qty","amount"});
		table.setModel(t);
		return table;
	}
	private JLabel getLbBill() {
		if (lbBill == null) {
			lbBill = new JLabel("Search by");
			lbBill.setForeground(new Color(0, 0, 0));
			lbBill.setBounds(39, 11, 96, 14);
		}
		return lbBill;
	}
	private JTextField getTextSearch() {
		if (textSearch == null) {
			textSearch = new JTextField();
			textSearch.setToolTipText("Enter here");
			textSearch.setBounds(258, 8, 91, 20);
			textSearch.setColumns(10);
		}
		return textSearch;
	}
	private JButton getBtnSearch() {
		if (btnSearch == null) {
			btnSearch = new JButton("");
			btnSearch.setBounds(39, 62, 95, 23);
			
			btnSearch.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					String key = (String) comboBox.getSelectedItem();
					String value = textSearch.getText();
					Date from = null;
					Date to = null;
					try{
						from = new java.sql.Date(dateChooserFrom.getDate().getTime());
					}catch(NullPointerException e1){
						from=null;
					}
					try{
						to = new java.sql.Date(dateChooserTo.getDate().getTime());
					}catch(NullPointerException e1){
						to=null;
					}
					if(value.isEmpty()&&dateChooserFrom.equals(null)&&dateChooserTo.equals(null)){
						JOptionPane.showMessageDialog(null, "Enter some search keyword");
					}
					  
					BillDao bdao = new BillDaoImpl();
					List<Bill> blist = bdao.searchByKeyValue(key,value,from,to);
					if(blist.isEmpty()){
						JOptionPane.showMessageDialog(null, "Bill not found");
					}
					populateBills(blist);
					sumTot();
					
				}
			});
		}
		ImageIcon ic = new ImageIcon("Image/search-icon.png");
		btnSearch.setIcon(ic);
		btnSearch.setText("Search");
		return btnSearch;
	}
	private JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"bill_no", "cus_name", "item_no", "item_name"}));
			comboBox.setBounds(121, 8, 96, 20);
		}
		return comboBox;
	}
	private JLabel getLblDate() {
		if (lblDate == null) {
			lblDate = new JLabel("Date");
			lblDate.setBounds(39, 36, 46, 14);
		}
		return lblDate;
	}
	private JDateChooser getDateChooserFrom() {
		if (dateChooserFrom == null) {
			dateChooserFrom = new JDateChooser();
			dateChooserFrom.setBounds(121, 36, 102, 20);
		}
		return dateChooserFrom;
	}
	private JLabel getLblTo() {
		if (lblTo == null) {
			lblTo = new JLabel("to");
			lblTo.setBounds(233, 39, 28, 14);
		}
		return lblTo;
	}
	private JDateChooser getDateChooserTo() {
		if (dateChooserTo == null) {
			dateChooserTo = new JDateChooser();
			dateChooserTo.setBounds(258, 36, 102, 20);
		}
		return dateChooserTo;
	}
	
	public void populateBills(){
		DefaultTableModel t= (DefaultTableModel) table.getModel();
		
		BillDao bdao = new BillDaoImpl();
		List<Bill> BillList= bdao.getAllBill();
		t.setRowCount(0);
		for(Bill b: BillList){
			t.addRow(new Object[]{b.getBill_no(),b.getDate(),b.getCus_name(),b.getItem_no(),b.getItem_name(),b.getMrp(),b.getDiscount(),b.getQty(),b.getAmount()});
			//"Billno","Date", "Cust_name", "item_no","item_name","mrp","discount","qty","amount"
		}
					
	}
	//Overloading method populatebill to take bill list parameter and populate table accordingly
	public void populateBills(List<Bill> BillList){
		DefaultTableModel t= (DefaultTableModel) table.getModel();
		t.setRowCount(0);
		for(Bill b: BillList){
			t.addRow(new Object[]{b.getBill_no(),b.getDate(),b.getCus_name(),b.getItem_no(),b.getItem_name(),b.getMrp(),b.getDiscount(),b.getQty(),b.getAmount()});
			//"Billno","Date", "Cust_name", "item_no","item_name","mrp","discount","qty","amount"
		}
					
	}
	private JLabel getLblTotal() {
		if (lblTotal == null) {
			lblTotal = new JLabel("Total");
			lblTotal.setBounds(650, 413, 46, 14);
		}
		return lblTotal;
	} 
	private JTextField getTextTotal() {
		if (textTotal == null) {
			textTotal = new JTextField();
			textTotal.setBounds(706, 410, 120, 20);
			textTotal.setColumns(10);
				}
		return textTotal;
	}
	private void sumTot(){
		int rowno= table.getRowCount();
		int total =0;
		for(int i=0;i<rowno;i++){
			total =total + Integer.valueOf(table.getValueAt(i, 8).toString());
		}
		textTotal.setText(String.valueOf(String.format("%,d", total))); 
		
	}
	
	private JButton getBtnExportCsv() {
		if (btnExportCsv == null) {
			btnExportCsv = new JButton("export CSV");
			btnExportCsv.setBounds(706, 75, 120, 23);
			btnExportCsv.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					JFileChooser jf = new JFileChooser();
					jf.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
					jf.showSaveDialog(null);
					String fpath= jf.getSelectedFile().toString();
					File file= new File(fpath+"\\"+"export1.csv");
					FileWriter csv;
					try {
						csv = new FileWriter(file);
						int row= table.getRowCount();
						int col= table.getColumnCount();
						
						//writing column header
						for(int i=0;i<col;i++){
							csv.write(table.getColumnName(i).toString()+",");
						}
						csv.write("\n");
						
						//writing table data
						for(int i=0;i<row;i++){
							for(int j=0;j<col;j++){
								csv.write(table.getValueAt(i, j).toString()+",");
							}
							csv.write("\n");
							
						}
						csv.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}					
				}
			});
			
		}
		ImageIcon ic = new ImageIcon("Image/download-icon.png");
		btnExportCsv.setIcon(ic);
		return btnExportCsv;
	}
	private JButton getBtnExit() {
		if (btnExit == null) {
			btnExit = new JButton("Exit");
			btnExit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
				}
			});
			btnExit.setBounds(737, 7, 89, 23);
		}
		return btnExit;
	}
}
