package graphics.controller;
import graphics.modal.*;
import graphics.view.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
//import java.time.LocalDate;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class BatchController extends JFrame implements ActionListener
{
	JLabel L1,L2,L3,L4,L5,L6,L7;
	JTextField T1,T3,T4,T6,T7;
	Button B1,B2;
	int a1=0, q=0,id=0;
	boolean a = false, b = false, x = false, y = false, z = false;
	String bName="",chcourse="",fcid="",sdate="",fcltFName="",fcltLName="";
	int dur=0;
	Choice ch,ch1;
	static LocalDate dt = LocalDate.now();
	public BatchController()
	{
		setLocation(630,300);
		setSize(600,500);
		
		JPanel p = new JPanel();
		p.setLayout(null);
		p.setBackground(Color.YELLOW);
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection Cobj = DriverManager.getConnection("jdbc:mysql://localhost/Coaching_Institute","root"," ");
			
			Statement sobj = Cobj.createStatement();
			ResultSet rsobj = null;
			JLabel title = new JLabel("New Batch");
			title.setBounds(140,20,220,40);
			title.setFont(new Font("Arial",Font.BOLD, 30));
			p.add(title);
			
			L1 = new JLabel("Batch Name :");
			L1.setBounds(80,80,120,20);
			L1.setFont(new Font("Arial",Font.PLAIN,15));
			
			T1 = new JTextField();
			T1.setBounds(240,80,200,20);
			p.add(L1); 		p.add(T1);
			
			L2 = new JLabel("Select Course :");
			L2.setBounds(80,120,150,20);
			L2.setFont(new Font("Arial",Font.PLAIN,15));
			
			rsobj = sobj.executeQuery("select Name from Course");
			ch = new Choice();
			ch.add("--NONE--");
			while(true)
			{
				if(rsobj.next())
				{
					String course = rsobj.getString("Name");
					ch.add(course);
				}
				else	break;
			}
			
			
			
			ch.setBounds(240,120,200,20);
			p.add(L2); 		p.add(ch);
			
			
			L3 = new JLabel("Date :");
			L3.setBounds(80,160,120,20);
			L3.setFont(new Font("Arial",Font.PLAIN,15));
			
			T3 = new JTextField();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/YYYY");
			T3.setText(formatter.format(dt));
			T3.setEditable(false);
			T3.setBounds(240,160,200,20);
			p.add(L3); 		p.add(T3);
			
			L4 = new JLabel("Duration(in months) :");
			L4.setBounds(80,200,200,20);
			L4.setFont(new Font("Arial",Font.PLAIN,15));
			
			T4 = new JTextField();
			T4.setBounds(240,200,200,20);
			p.add(L4); 		p.add(T4);
			
			L5 = new JLabel("Faculty ID :");
			L5.setBounds(80,240,100,20);
			L5.setFont(new Font("Arial",Font.PLAIN,15));
			
			ch1 = new Choice();
			ch1.add("--NONE--");
			rsobj = sobj.executeQuery("select id From Faculty");
			while(true)
			{
				if(rsobj.next())
				{
					String cName = rsobj.getString("ID");
					ch1.add(cName);
				}
				else	break;
			}
			
			ch1.setBounds(240,240,200,20);
			p.add(L5); 		p.add(ch1);
			
			L6 = new JLabel("Faculty First Name :");
			L6.setBounds(80,280,200,20);
			L6.setFont(new Font("Arial",Font.PLAIN,15));
			
			T6 = new JTextField();
			ch1.addItemListener(new ItemListener(){	
			public void itemStateChanged(ItemEvent Aobj){
			try{
				Class.forName("com.mysql.jdbc.Driver");
				Connection Cobj = DriverManager.getConnection("jdbc:mysql://localhost/Coaching_Institute","root"," ");	
				Statement sobj = Cobj.createStatement();
				ResultSet rsobj = null;
			
				String insertQry = "select FName From Faculty where id=" + ch1.getSelectedItem() + ";";
				rsobj = sobj.executeQuery(insertQry);
				System.out.print(insertQry);
					while(rsobj.next()){
						T6.setText(rsobj.getString("FName"));
						//System.out.print(rsobj.getInt("Fee"));
					}
				}catch(Exception e){		}
			}
		});
			T6.setEditable(false);
			T6.setBounds(240,280,200,20);
			p.add(L6); 		p.add(T6);
			
			
			L7 = new JLabel("Faculty Last Name :");
			L7.setBounds(80,320,200,20);
			L7.setFont(new Font("Arial",Font.PLAIN,15));
			
			T7 = new JTextField();
			ch1.addItemListener(new ItemListener(){	
			public void itemStateChanged(ItemEvent Aobj){
			try{
				Class.forName("com.mysql.jdbc.Driver");
				Connection Cobj = DriverManager.getConnection("jdbc:mysql://localhost/Coaching_Institute","root"," ");	
				Statement sobj = Cobj.createStatement();
				ResultSet rsobj = null;
			
				String insertQry = "select LName From Faculty where id=" + ch1.getSelectedItem() + ";";
				rsobj = sobj.executeQuery(insertQry);
				System.out.print(insertQry);
					while(rsobj.next()){
						T7.setText(rsobj.getString("LName"));
						//System.out.print(rsobj.getInt("Fee"));
					}
				}catch(Exception e){		}
			}
		});
			T7.setEditable(false);
			T7.setBounds(240,320,200,20);
			p.add(L7); 		p.add(T7);
			
			B1 = new Button("Add");
			B1.setBounds(120,380,90,20);
			B1.setFont(new Font("Arial",Font.PLAIN,15));
			B2 = new Button("Cancel");
			B2.setBounds(300,380,90,20);
			B2.setFont(new Font("Arial",Font.PLAIN,15));
			B1.setBackground(Color.BLACK);
			B1.setForeground(Color.WHITE);
			B2.setBackground(Color.BLACK);
			B2.setForeground(Color.WHITE);
			
			p.add(B1);		p.add(B2);
			setLayout(new BorderLayout());
			B1.addActionListener(this);
			B2.addActionListener(this);
			add(p,"Center");
			setVisible(true);
			
			rsobj.close();
			sobj.close();
			Cobj.close();
			
		}
		catch(Exception e)	{	e.printStackTrace();	}
	}
	
	public void actionPerformed(ActionEvent Aobj){
		
		if(Aobj.getSource()==B1)
		{
			if(T1.getText().length()!=0 && !ch.getSelectedItem().equals("--NONE--") && T3.getText().length()!=0 && T4.getText().length()!=0 && !ch.getSelectedItem().equals("--NONE--"))
			{
				if(!T1.getText().equals(""))
				{
						bName = T1.getText();
						x=true;
				}
				if(!ch.getSelectedItem().equals("--NONE--"))
				{
					chcourse = ch.getSelectedItem();	
					y = true;
				}
				if(!T3.getText().equals(""))
				{
					sdate = T3.getText();
					z = true;
				}
				if(!T4.getText().equals(""))
				{
					dur = Integer.parseInt(T4.getText());
					a = true;
				}
				if(!ch1.getSelectedItem().equals("--NONE--"))
				{
					fcid = ch1.getSelectedItem();
					fcltFName = T6.getText();
					fcltLName = T7.getText();
					b = true;
				}
				if(a==true && x==true && y==true && z==true && b==true)
				{
					BatchModal B = new BatchModal();
					inputBatch(B);
				}
				
				if(a==true && x==true && y==true && z==true && b==true)
				{
					T1.setText("");
					ch.select(0);
					T4.setText("");
					ch1.select(0);
					T6.setText("");
					T7.setText("");
					T1.requestFocus();
				}
			}
			else	JOptionPane.showMessageDialog(null,"Plz Fill the Fields");		
		}
		
		if(Aobj.getSource()==B2)
		{
			T1.setText("");
			ch.select(0);
			T4.setText("");
			ch1.select(0);
			T6.setText("");
			T7.setText("");
			T1.requestFocus();
			dispose();
		}
	}
	
	public void inputBatch(BatchModal bObj)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");								
			Connection cObj = DriverManager.getConnection("jdbc:mysql://localhost/Coaching_Institute","root"," ");
			Statement stObj = cObj.createStatement();
			
			String inputQry = "insert into Batch(batchName,Course,startDate,duration,FacultyFName,FacultyLName) values(";
			inputQry += "'" + bName + "',";
			inputQry += "'" + chcourse + "'";
			inputQry += ",'" + sdate + "'";
			inputQry += "," + dur + ",";
			inputQry += "'" + fcltFName + "',";
			inputQry += "'" + fcltLName + "')";
			
	
			System.out.print("One Data Added Succesfully");
			System.out.print("\n\nQry is : " + inputQry);
			stObj.executeUpdate(inputQry);
			
			stObj.close();
			cObj.close();
		}
		catch(Exception iObj)	{	iObj.printStackTrace();	}
	}
}