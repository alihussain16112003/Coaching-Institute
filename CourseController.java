package graphics.controller;
import graphics.modal.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class CourseController extends JFrame implements ActionListener
{
	JLabel L1,L2,L3;
	JTextField T1,T2,T3;
	Button B1,B2;
	int a1=0, q=0;
	boolean x = false, y = false, z = false;
	String cName="";
	int dur=0,fee=0;
	public CourseController()
	{
		setLocation(630,300);
		setSize(600,500);
		
		JPanel p = new JPanel();
		p.setLayout(null);
		p.setBackground(Color.YELLOW);
		
		JLabel title = new JLabel("New Course");
		title.setBounds(140,20,220,40);
		title.setFont(new Font("Arial",Font.BOLD, 30));
		p.add(title);
		
		L1 = new JLabel("Course Name : ");
		L1.setBounds(100,80,120,20);
		L1.setFont(new Font("Arial",Font.PLAIN,15));
		
		T1 = new JTextField();
		T1.setBounds(240,80,200,20);
		p.add(L1); 		p.add(T1);
		
		L2 = new JLabel("Duration(in month) : ");
		L2.setBounds(100,120,200,20);
		L2.setFont(new Font("Arial",Font.PLAIN,15));
		
		T2 = new JTextField();
		T2.setBounds(240,120,200,20);
		p.add(L2); 		p.add(T2);
		
		L3 = new JLabel("Fees : ");
		L3.setBounds(100,160,120,20);
		L3.setFont(new Font("Arial",Font.PLAIN,15));
		
		T3 = new JTextField();
		T3.setBounds(240,160,200,20);
		p.add(L3); 		p.add(T3);
		
		
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
	
	public void actionPerformed(ActionEvent Aobj){
		
		if(Aobj.getSource()==B1)
		{
			if(T1.getText().length()!=0 && T2.getText().length()!=0 && T3.getText().length()!=0)
			{
				if(!T1.getText().equals(""))
				{
						cName = T1.getText();
						x=true;
				}
				if(!T2.getText().equals(" "))
				{
					dur = Integer.parseInt(T2.getText());
					y = true;
				}
				if(!T3.getText().equals(""))
				{
					fee = Integer.parseInt(T3.getText());
					z = true;
				}
				if(x==true && y==true && z==true)
				{
					CourseModal C = new CourseModal();
					inputCourse(C);
				}
				
				if(x==true && y==true && z==true){
				T1.setText("");
				T2.setText("");
				T3.setText("");
				T1.requestFocus();
				}
			}
			else	JOptionPane.showMessageDialog(null,"Plz Fill the Fields");		
		}
		
		if(Aobj.getSource()==B2)
		{
			T1.setText("");
			T2.setText("");
			T3.setText("");
			T1.requestFocus();
			dispose();
		}
	}
	
	public void inputCourse(CourseModal coObj)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");								
			Connection cObj = DriverManager.getConnection("jdbc:mysql://localhost/Coaching_Institute","root"," ");
			Statement stObj = cObj.createStatement();
			
			String inputQry = "insert into Course(Name,Duration,Fee) values(";
			inputQry += "'" + cName + "',";
			inputQry += "" + dur + "";
			inputQry += "," + fee + ")";
			System.out.print("One Data Added Succesfully");
			System.out.print("\n\nQry is : " + inputQry);
			stObj.executeUpdate(inputQry);
			
			
			stObj.close();
			cObj.close();
		}
		catch(Exception iObj)	{	iObj.printStackTrace();	}
	}
}