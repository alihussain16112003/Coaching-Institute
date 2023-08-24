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
public class StudentView extends JFrame implements ActionListener
{
	Button B;
	JPanel P;
	JTable j;
	Choice ch;

	public StudentView()
	{
		setTitle("Show All Students");
		setSize(1000,800);
		setLocation(10,10);
		setBackground(Color.BLACK);			
			
		try
		{
			P = new JPanel();
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection Cobj = DriverManager.getConnection("jdbc:mysql://localhost/Coaching_Institute","root"," ");
			
			Statement sobj = Cobj.createStatement();
			ResultSet rsobj = null;
			rsobj = sobj.executeQuery("Select * from Student");
			ResultSetMetaData rsmd = rsobj.getMetaData();
			
			Font font = new Font("Arial",Font.BOLD,20);
			Color color = new Color(255,239,213);
			
			j=new JTable();
			DefaultTableModel model = (DefaultTableModel)j.getModel();
			
			int cols = rsmd.getColumnCount();
			String colName[] = new String[cols];
			
			for(int i=0; i<cols; i++)
				colName[i] = rsmd.getColumnName(i+1);
				
			model.setColumnIdentifiers(colName);
			j.setFont(new Font("Arial",Font.PLAIN,15));	
			
			String id,FName,LName,Gender,ContactNo,CName,DOD,totalAmt,paidAmt;
				
			while(rsobj.next()){
				id = String.valueOf(rsobj.getInt(1));
				FName = rsobj.getString(2);
				LName = rsobj.getString(3);
				Gender = rsobj.getString(4);
				ContactNo = rsobj.getString(5);
				CName = rsobj.getString(6);
				DOD = rsobj.getString(7);
				totalAmt = String.valueOf(rsobj.getString(8));
				paidAmt = String.valueOf(rsobj.getString(9));
		
				String[] row = {id,FName,LName,Gender,ContactNo,CName,DOD,totalAmt,paidAmt};
				model.addRow(row);
			}	

			JTableHeader tableHeader = j.getTableHeader();
			tableHeader.setFont(font);
			tableHeader.setBackground(color);
			tableHeader.setForeground(Color.black);
			rsobj.close();
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


