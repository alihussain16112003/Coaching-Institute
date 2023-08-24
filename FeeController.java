package graphics.controller;
import graphics.modal.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class FeeController extends JFrame implements ActionListener
{
	JLabel L1,L2,L3,L4,L5;
	JTextField T1,T2,T3,T4,T5;
	Button B1,B2;
	int sID=0,paidAmt=0,totalPaidAmt=0,totalAmt=0;
	String date="";
	int a1=0, q=0;
	boolean a = false,b = false, c = false, d = false, e = false, p=false;
	Choice st,ch,ch1;
	static LocalDate dt = LocalDate.now();
	public FeeController()
	{
		setTitle("Add Fee Student");
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
			JLabel title = new JLabel("Add Fee");
			title.setBounds(140,20,220,40);
			title.setFont(new Font("Arial",Font.BOLD, 30));
			p.add(title);
			
			L1 = new JLabel("Student ID :");
			L1.setBounds(100,80,120,20);
			L1.setFont(new Font("Arial",Font.PLAIN,15));
			
			//T1 = new JTextField();
			st = new Choice();
			st.add("--NONE--");
			rsobj = sobj.executeQuery("select ID From Student");
			while(true)
			{
				if(rsobj.next())
				{
					String stid = String.valueOf(rsobj.getInt(1));
					st.add(stid);
				}
				else	break;
			}
			st.setBounds(240,80,200,20);
			p.add(L1); 		p.add(st);
			
			L2 = new JLabel("Date Of Deposit :");
			L2.setBounds(100,120,300,20);
			L2.setFont(new Font("Arial",Font.PLAIN,15));
			
			T2 = new JTextField();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/YYYY");
			T2.setText(formatter.format(dt));
			T2.setEditable(false);
			T2.setBounds(240,120,200,20);
			p.add(L2); 		p.add(T2);
			
			L3 = new JLabel("Paying Amt :");
			L3.setBounds(100,160,120,20);
			L3.setFont(new Font("Arial",Font.PLAIN,15));
		
			T3 = new JTextField();
			T3.setBounds(240,160,200,20);
			p.add(L3); 		p.add(T3);
			
			
			L4 = new JLabel("Total Paid Amt :");
			L4.setBounds(100,200,200,20);
			L4.setFont(new Font("Arial",Font.PLAIN,15));
			
			T4 = new JTextField();
			st.addItemListener(new ItemListener(){	
			public void itemStateChanged(ItemEvent Aobj){
			try{
				//ch2.removeAll();
				Class.forName("com.mysql.jdbc.Driver");
				Connection Cobj = DriverManager.getConnection("jdbc:mysql://localhost/Coaching_Institute","root"," ");	
				Statement sobj = Cobj.createStatement();
				ResultSet rsobj = null;
			
				String insertQry = "select PaidAmt From Student where ID=" + st.getSelectedItem() + ";";
				rsobj = sobj.executeQuery(insertQry);
				System.out.print(insertQry);
					while(rsobj.next()){
						T4.setText(String.valueOf(rsobj.getInt("PaidAmt")));
					}
				}catch(Exception e){		}
			}
		});
			T4.setBounds(240,200,200,20);
			T4.setEditable(false);
			p.add(L4); 		p.add(T4);
			
			
			L5 = new JLabel("Total Amt :");
			L5.setBounds(100,240,100,20);
			L5.setFont(new Font("Arial",Font.PLAIN,15));
			
			T5 = new JTextField();
			st.addItemListener(new ItemListener(){	
			public void itemStateChanged(ItemEvent Aobj){
			try{
				//ch2.removeAll();
				Class.forName("com.mysql.jdbc.Driver");
				Connection Cobj = DriverManager.getConnection("jdbc:mysql://localhost/Coaching_Institute","root"," ");	
				Statement sobj = Cobj.createStatement();
				ResultSet rsobj = null;
			
				String insertQry = "select TotalAmt From Student where ID=" + st.getSelectedItem() + ";";
				rsobj = sobj.executeQuery(insertQry);
				System.out.print(insertQry);
					while(rsobj.next()){
						T5.setText(String.valueOf(rsobj.getInt("TotalAmt")));
					}
				}catch(Exception e){		}
			}
		});
			T5.setBounds(240,240,200,20);
			T5.setEditable(false);
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
			if(!st.getSelectedItem().equals("--NONE--") && T2.getText().length()!=0 && T3.getText().length()!=0 && T5.getText().length()!=0)	
			{
				int l = Integer.parseInt(T4.getText());
				if(l==0)
				{
					if(!st.getSelectedItem().equals("--NONE--"))
					{
						sID = Integer.parseInt(st.getSelectedItem());
						a=true;
					}
					if(!T2.getText().equals(""))
					{
							date = T2.getText();
							b=true;
					}
					if(!T3.getText().equals(""))
					{
						paidAmt = Integer.parseInt(T3.getText());	
						c = true;
					}
					if(!T5.getText().equals(""))
					{
						totalAmt = Integer.parseInt(T5.getText());	
						d = true;
					}
					if(a==true && b==true && c==true && d==true && paidAmt<=totalAmt)
					{
							FeeModal F = new FeeModal();
							inputFee(F);
							st.select(0);
						//T2.setText("");
							T3.setText("");
							T4.setText("");
							T5.setText("");
							st.requestFocus();
					}
					else 	JOptionPane.showMessageDialog(null,"Please Amount Checked..!!");
				}
				else if(T4.getText().length()!=0)
				{
					if(!T3.getText().equals(""))
					{
						date = T2.getText();
						totalAmt = Integer.parseInt(T5.getText());
						sID = Integer.parseInt(st.getSelectedItem());
						paidAmt = Integer.parseInt(T3.getText());	
						totalPaidAmt = Integer.parseInt(T4.getText());
						p = true;
					}
					int amt = totalPaidAmt+paidAmt;
					if(p==true && amt<=totalAmt)
					{
						FeeModal FM = new FeeModal();
						updateFee(FM);
						st.select(0);
						//T2.setText("");
						T3.setText("");
						T4.setText("");
						T5.setText("");
						st.requestFocus();
		
					}
					else	JOptionPane.showMessageDialog(null,"Please Amount Value Checked..!!");
				}
				
				
				
				// if(p==true  && totalPaidAmt<totalAmt)
				// {
							// }
				// if(a==true && b==true && c==true && d==true && paidAmt<=totalAmt)
				// {
					
				// }
			}
			else	JOptionPane.showMessageDialog(null,"Plz Fill the Fields");		
			
		}
		
		if(Aobj.getSource()==B2)
		{
			st.select(0);
			//T2.setText("");
			T3.setText("");
			T4.setText("");
			T5.setText("");
			st.requestFocus();
			dispose();
		}
	}
	
	public void inputFee(FeeModal fObj)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");								
			Connection cObj = DriverManager.getConnection("jdbc:mysql://localhost/Coaching_Institute","root"," ");
			Statement stObj = cObj.createStatement();
			
			String inputQry = "insert into Fee(StudentID,DateOfDeposit,TotalPaidAmt,TotalAmt) values(";
			inputQry += "" + sID + ",";
			inputQry += "'" + date + "',";
			inputQry += "" + paidAmt + ",";
			inputQry += "" + totalAmt + ")";
	
			JOptionPane.showMessageDialog(null,"One Data Added Succesfully");
			System.out.print("\n\nQry is : " + inputQry);
			stObj.executeUpdate(inputQry);
			
			String studentQry = "update Student set Date_Of_Deposit='" + date + "', PaidAmt=" + paidAmt + ",TotalAmt="+totalAmt+" where ID="+st.getSelectedItem();
			stObj.executeUpdate(studentQry);
			
			stObj.close();
			cObj.close();
		}
		catch(Exception iObj)	{	iObj.printStackTrace();	}
	}
	
	public void updateFee(FeeModal fmobj)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");								
			Connection cObj = DriverManager.getConnection("jdbc:mysql://localhost/Coaching_Institute","root"," ");
			Statement stObj = cObj.createStatement();
			int total = paidAmt+totalPaidAmt;
			String updateQry = "update Fee set TotalPaidAmt=" + total + " where StudentID=" +st.getSelectedItem();
			
			stObj.executeUpdate(updateQry);
			
			String studentQry = "update Student set Date_Of_Deposit='" + date + "', PaidAmt=" + total + ",TotalAmt="+totalAmt+" where ID=" +st.getSelectedItem();
			stObj.executeUpdate(studentQry);
			
			stObj.close();
			cObj.close();
		}
		catch(Exception iObj)	{	iObj.printStackTrace();	}
	}
}