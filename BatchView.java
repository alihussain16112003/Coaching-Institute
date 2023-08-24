package graphics.view;
import graphics.modal.*;
import graphics.controller.*;
import java.util.*;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;
import java.awt.event.WindowEvent;
import javax.swing.JScrollPane.*;
public class BatchView extends JFrame implements ActionListener
{
	Button B;
	JPanel P;
	JTable j;
	Choice ch;

	public BatchView()
	{
		setTitle("Show All Batches");
		setSize(800,700);
		setLocation(200,80);
		setBackground(Color.BLACK);			
			
		try
		{
			P = new JPanel();
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection Cobj = DriverManager.getConnection("jdbc:mysql://localhost/Coaching_Institute","root"," ");
			
			Statement sobj = Cobj.createStatement();
			ResultSet rsobj = null;
			rsobj = sobj.executeQuery("Select * from Batch");
			ResultSetMetaData rsmd = rsobj.getMetaData();
			
			Font font = new Font("Arial",Font.BOLD,25);
			
			
			j=new JTable();
			DefaultTableModel model = (DefaultTableModel)j.getModel();
			
			int cols = rsmd.getColumnCount();
			String colName[] = new String[cols];
			
			for(int i=0; i<cols; i++)
				colName[i] = rsmd.getColumnName(i+1);
				
			model.setColumnIdentifiers(colName);
			j.setFont(new Font("Arial",Font.PLAIN,15));	
			
			String id,batchName,Course,startDate,duration,fcltFName,fcltLName;
				
			while(rsobj.next()){
				id = String.valueOf(rsobj.getInt(1));
				batchName = rsobj.getString(2);
				Course = rsobj.getString(3);
				startDate = rsobj.getString(4);
				duration = String.valueOf(rsobj.getInt(5));
				fcltFName = rsobj.getString(6);
				fcltLName = rsobj.getString(7);
				
	
				String[] row = {id,batchName,Course,startDate,duration,fcltFName,fcltLName};
				model.addRow(row);
			}	

			JTableHeader tableHeader = j.getTableHeader();
			tableHeader.setFont(font);
			Cobj.close();
			sobj.close();
			
		}
		catch(Exception e){		e.printStackTrace();		}
			B = new Button("CLOSE");
			B.setBackground(Color.DARK_GRAY);
			B.setForeground(Color.WHITE);
			B.setBounds(300,300,150,30);
			P.add(B);
			B.addActionListener(this);
			setLayout(new BorderLayout());
			add(P,"South");
			setVisible(true);
			add(new JScrollPane(j));
	}
	
	public void actionPerformed(ActionEvent AObj)
	{
		if(AObj.getSource()==B)
		{
			dispose();
		}
	}
}


