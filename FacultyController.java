package graphics.controller;
import graphics.modal.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class FacultyController extends JFrame implements ActionListener
{
	JLabel L1,L2,L3,L4,L5;
	JTextField T1,T2,T5;
	Button B1,B2;
	int a1=0, q=0;
	boolean a = false,b = false, c = false, d = false, e = false;
	String Fname="",Lname="",gender="",specialization="",phn="";
	int dur=0;
	Choice ch,ch1;
	int id;
	public FacultyController()
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
			JLabel title = new JLabel("New Faculty :");
			title.setBounds(140,20,220,40);
			title.setFont(new Font("Arial",Font.BOLD, 30));
			p.add(title);
			
			L1 = new JLabel("First Name :");
			L1.setBounds(80,80,120,20);
			L1.setFont(new Font("Arial",Font.PLAIN,15));
			
			T1 = new JTextField();
			T1.setBounds(240,80,200,20);
			p.add(L1); 		p.add(T1);
			
			L2 = new JLabel("Last Name :");
			L2.setBounds(80,120,100,20);
			L2.setFont(new Font("Arial",Font.PLAIN,15));
			
			T2 = new JTextField();
			T2.setBounds(240,120,200,20);
			p.add(L2); 		p.add(T2);
			
			L3 = new JLabel("Select Gender :");
			L3.setBounds(80,160,120,20);
			L3.setFont(new Font("Arial",Font.PLAIN,15));
			
			
			ch = new Choice();
			ch.add("--NONE--");
			ch.add("MALE");
			ch.add("FEMALE");
			
			ch.setBounds(240,160,200,20);
			p.add(L3); 		p.add(ch);
			
			
			L4 = new JLabel("Specialization :");
			L4.setBounds(80,200,150,20);
			L4.setFont(new Font("Arial",Font.PLAIN,15));
			
			ch1 = new Choice();
			ch1.add("--NONE--");
			ch1.add("Software development");
			ch1.add("Web development");
			ch1.add("Data science");
			ch1.add("Cybersecurity");
			ch1.add("Network security");
			ch1.add("Cloud computing");
			ch1.add("Analytics");
			ch1.setBounds(240,200,200,20);
			p.add(L4); 		p.add(ch1);
			
			L5 = new JLabel("Contact No :");
			L5.setBounds(80,240,100,20);
			L5.setFont(new Font("Arial",Font.PLAIN,15));
			
			T5 = new JTextField();
			T5.setBounds(240,240,200,20);
			p.add(L5); 		p.add(T5);
			
			B1 = new Button("Add");
			B1.setBounds(120,350,90,20);
			B1.setFont(new Font("Arial",Font.PLAIN,15));
			B2 = new Button("Cancel");
			B2.setBounds(300,350,90,20);
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
			
		}
		catch(Exception e)	{	e.printStackTrace();	}
	}
	
	public void actionPerformed(ActionEvent Aobj)
	{
		
		if(Aobj.getSource()==B1)
		{
			if(T1.getText().length()!=0 && T2.getText().length()!=0 && !ch.getSelectedItem().equals("--NONE--") && !ch1.getSelectedItem().equals("--NONE--") && T5.getText().length()!=0)
			{
				if(!T1.getText().equals(""))
				{
						Fname = T1.getText();
						a=true;
				}
				if(!T2.getText().equals(""))
				{
						Lname = T2.getText();
						b=true;
				}
				if(!ch.getSelectedItem().equals("--NONE--"))
				{
					gender = ch.getSelectedItem();	
					c = true;
				}
				if(!ch1.getSelectedItem().equals("--NONE--"))
				{
					specialization = ch1.getSelectedItem();	
					d = true;
				}
				
				if( T5.getText().length()<11 && T5.getText().length()>9)
				{
					phn = T5.getText();
					e=true;
				}
				else 	JOptionPane.showMessageDialog(null,"PhNo must be 10");
			}
				if(a==true && b==true && c==true && d==true && e==true)
				{
					BatchModal B = new BatchModal();
					inputBatch(B);
				}
				
				if(a==true && b==true && c==true && d==true && e==true)
				{
					T1.setText("");
					T2.setText("");
					ch.select(0);
					ch1.select(0);
					T5.setText("");
					T1.requestFocus();
				}
			
			else	JOptionPane.showMessageDialog(null,"Plz Fill the Fields");		
		}
		
		if(Aobj.getSource()==B2)
		{
			T1.setText("");
			T2.setText("");
			ch.select(0);
			ch1.select(0);
			T5.setText("");
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
			
			String inputQry = "insert into Faculty(Fname,Lname,Gender,Specialization,ContactNo) values(";
			inputQry += "'" + Fname + "',";
			inputQry += "'" + Lname + "',";
			inputQry += "'" + gender + "'";
			inputQry += ",'" + specialization + "'";
			inputQry += ",'" + phn + "')";
	
			JOptionPane.showMessageDialog(null,"One Data Added Succesfully");
			System.out.print("\n\nQry is : " + inputQry);
			stObj.executeUpdate(inputQry);
			
			stObj.close();
			cObj.close();
		}
		catch(Exception iObj)	{	iObj.printStackTrace();	}
	}
}