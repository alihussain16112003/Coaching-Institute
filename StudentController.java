package graphics.controller;
import graphics.modal.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.WindowEvent;
import java.sql.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class StudentController extends JFrame implements ActionListener
{
	Frame p;
	JLabel L1,L2,L3,L4,L5,L6,L7,L8;
	JTextField T1,T2,T4,T6,T7,T8;
	Button B1,B2;
	int a1=0, q=0;
	boolean a = false,b = false, c = false, d = false, e = false,f = false,g = false;
	String Fname="",Lname="",gender="",phn="",courseName="",DOD="";
	int paidAmt=0,totalAmt=0;
	Choice ch,ch1,ch2;
	int id;
	static LocalDate dt = LocalDate.now();
	public StudentController()
	{
		setTitle("Add Student Data");
		setLocation(600,200);
		setSize(700,600);
		
		JPanel p = new JPanel();
		p.setLayout(null);
		p.setBackground(Color.YELLOW);
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection Cobj = DriverManager.getConnection("jdbc:mysql://localhost/Coaching_Institute","root"," ");
			
			Statement sobj = Cobj.createStatement();
			ResultSet rsobj = null;
			JLabel title = new JLabel("Add Student");
			title.setBounds(140,20,220,40);
			title.setFont(new Font("Arial",Font.BOLD, 30));
			p.add(title);
			
			L1 = new JLabel("First Name");
			L1.setBounds(100,120,120,20);
			L1.setFont(new Font("Arial",Font.PLAIN,15));
			
			T1 = new JTextField();
			T1.setBounds(240,120,200,20);
			p.add(L1); 		p.add(T1);
			
			L2 = new JLabel("Last Name");
			L2.setBounds(100,160,100,20);
			L2.setFont(new Font("Arial",Font.PLAIN,15));
			
			T2 = new JTextField();
			T2.setBounds(240,160,200,20);
			p.add(L2); 		p.add(T2);
			
			L3 = new JLabel("Select Gender");
			L3.setBounds(100,200,120,20);
			L3.setFont(new Font("Arial",Font.PLAIN,15));
			
			ch = new Choice();
			ch.add("--NONE--");
			ch.add("MALE");
			ch.add("FEMALE");
			
			ch.setBounds(240,200,200,20);
			p.add(L3); 		p.add(ch);
			
			L4 = new JLabel("Contact No");
			L4.setBounds(100,240,100,20);
			L4.setFont(new Font("Arial",Font.PLAIN,15));
			
			T4 = new JTextField();
			T4.setBounds(240,240,200,20);
			p.add(L4); 		p.add(T4);
			
			L5 = new JLabel("Course Name");
			L5.setBounds(100,280,100,20);
			L5.setFont(new Font("Arial",Font.PLAIN,15));
			
			ch1 = new Choice();
			ch1.add("--NONE--");
			rsobj = sobj.executeQuery("select Name From Course");
			while(true)
			{
				if(rsobj.next())
				{
					String cName = rsobj.getString("Name");
					ch1.add(cName);
				}
				else	break;
			}
			
			ch1.setBounds(240,280,200,20);
			p.add(L5); 		p.add(ch1);
			
			
			L6 = new JLabel("total Fees");
			L6.setBounds(100,320,100,20);
			L6.setFont(new Font("Arial",Font.PLAIN,15));
			
			T6 = new JTextField();
			ch1.addItemListener(new ItemListener(){	
			public void itemStateChanged(ItemEvent Aobj){
			try{
				Class.forName("com.mysql.jdbc.Driver");
				Connection Cobj = DriverManager.getConnection("jdbc:mysql://localhost/Coaching_Institute","root"," ");	
				Statement sobj = Cobj.createStatement();
				ResultSet rsobj = null;
			
				String insertQry = "select Fee From Course where Name='" + ch1.getSelectedItem() + "';";
				rsobj = sobj.executeQuery(insertQry);
				System.out.print(insertQry);
					while(rsobj.next()){
						T6.setText(rsobj.getString("Fee"));
						//System.out.print(rsobj.getInt("Fee"));
					}
				}catch(Exception e){		}
			}
		});
			T6.setEditable(false);
			
			T6.setBounds(240,320,200,20);
			p.add(L6); 		p.add(T6);
			
			
			
			B1 = new Button("Add");
			B1.setBounds(120,470,90,20);
			B1.setFont(new Font("Arial",Font.PLAIN,15));
			B2 = new Button("Cancel");
			B2.setBounds(300,470,90,20);
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
	
	public void actionPerformed(ActionEvent Aobj)
	{
		
		if(Aobj.getSource()==B1)
		{
			if(T1.getText().length()!=0 && T2.getText().length()!=0 && !ch.getSelectedItem().equals("--NONE--")  && T4.getText().length()!=0 && !ch1.getSelectedItem().equals("--NONE--"))
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
				
				if(T4.getText().length()<11 && T4.getText().length()>9)
				{
					phn = T4.getText();
					d=true;
				}
				else 	JOptionPane.showMessageDialog(null,"PhNo must be 10");
				
				
				if(!ch1.getSelectedItem().equals("--NONE--"))
				{
					courseName = ch1.getSelectedItem();	
					e = true;
				}
				if(!T6.getText().equals(""))
				{
						totalAmt = Integer.parseInt(T6.getText());
						f=true;
				}
			}
				if(a==true && b==true && c==true && d==true && e==true && f==true)
				{
					StudentModal B = new StudentModal();
					//System.out.print("\n\n\t\tHa Chal Rha Hai\t");
					inputStudent(B);
					T1.setText("");
					T2.setText("");
					ch.select(0);
					ch1.select(0);
					T4.setText("");
					T6.setText("");
					T1.requestFocus();
					//dispose();
				}
				
				
				if(a==true && b==true && c==true && d==true && e==true && f==true)
				{
				
				}
			
			else	JOptionPane.showMessageDialog(null,"Plz Fill the Fields");		
		}
		
		if(Aobj.getSource()==B2)
		{
			T1.setText("");
			T2.setText("");
			ch.select(0);
			ch1.select(0);
			T4.setText("");
			T6.setText("");
			T1.requestFocus();
			dispose();
		}
		
	}
	
	public void inputStudent(StudentModal B)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");								
			Connection cObj = DriverManager.getConnection("jdbc:mysql://localhost/Coaching_Institute","root"," ");
			Statement stObj = cObj.createStatement();
			
			
			String inputQry = "insert into Student(FName,LName,Gender,ContactNo,CourseName,TotalAmt) values(";
			inputQry += "'" + Fname + "',";
			inputQry += "'" + Lname + "',";
			inputQry += "'" + gender + "',";
			inputQry += "'" + phn + "',";
			inputQry += "'" + courseName + "',";
			inputQry += "" + totalAmt + ")";
			
			stObj.executeUpdate(inputQry);
			JOptionPane.showMessageDialog(null,"One Data Added Succesfully");
			
			stObj.close();
			cObj.close();
		}
		catch(Exception eobj){		eobj.printStackTrace();		}
	}

}