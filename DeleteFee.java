package graphics.controller;
import graphics.modal.*;
import java.util.*;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.WindowEvent;

public class DeleteFee extends JFrame implements ActionListener
{
	Button B;
	JPanel p;
	Choice ch ;
	JLabel L1, L2, L3, L4;
	JLabel T2, T3, T4;
	//DBHelper d;
	Font f;
	public DeleteFee()
	{
		Font f = new Font("TimesRoman",Font.BOLD , 20);
		p = new JPanel();
		setTitle("Do you want to Delete Fees ");
		setLocation(600,200);
		setSize(600,500);
		p.setBackground(new Color(255,255,153));
		
		JLabel title = new JLabel("Delete Fees");
		title.setBounds(240,30,220,30);
		title.setFont(new Font("Arial",Font.BOLD, 30));
		p.add(title);
		
		p.setLayout(null);
        L1 = new JLabel("Student ID : ");
		L1.setBounds(130,100,120,20);
		L1.setFont(new Font("Arial",Font.PLAIN,17));
      
        ch = new Choice();
		ch.setFont(new Font("TimesRoman",Font.BOLD , 17));
		ch.setBounds(290,100,200,20);
		ch.add("--None--");
		p.add(L1); 		
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection Cobj = DriverManager.getConnection("jdbc:mysql://localhost/Coaching_Institute","root"," ");
			Statement sobj = Cobj.createStatement();
			ResultSet rsobj = null; 
			rsobj = sobj.executeQuery("select StudentID from Fee;");
			while(rsobj.next())
			{
				ch.add(rsobj.getString(1));
			}
		}
		catch(Exception e){	e.printStackTrace();	}
		p.add(ch);
		
		L2 = new JLabel("Date Of Deposit :");
		L2.setBounds(130,150,200,20);
		L2.setFont(new Font("Arial",Font.PLAIN,17));
		
		T2 = new JLabel();
		T2.setBounds(290,150,200,20);
		T2.setFont(f);
		p.add(L2); 		p.add(T2);
		
		L3 = new JLabel("Total Paid Amt :");
		L3.setBounds(130,200,200,20);
		L3.setFont(new Font("Arial",Font.PLAIN,17));
		
		T3 = new JLabel();
		T3.setBounds(290,200,200,20);
		T3.setFont(f);
		p.add(L3); 		p.add(T3);
		
		L4 = new JLabel("Total Amt :");
		L4.setBounds(130,250,100,20);
		L4.setFont(new Font("Arial",Font.PLAIN,17));
		
		T4 = new JLabel();
		T4.setBounds(290,250,200,20);
		T4.setFont(f);
		p.add(L4); 		p.add(T4);
		
		
		
		ch.addItemListener(new ItemListener(){	
		public void itemStateChanged(ItemEvent Aobj){
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection Cobj = DriverManager.getConnection("jdbc:mysql://localhost/Coaching_Institute","root"," ");
				Statement sobj = Cobj.createStatement();
				ResultSet rsobj = sobj.executeQuery("select * from Fee where StudentID= "+ch.getSelectedItem()+";");
				
					while(rsobj.next())
					{	
						T2.setText(rsobj.getString("DateOfDeposit")); 
						T3.setText(rsobj.getString("TotalPaidAmt")); 
						T4.setText(rsobj.getString("TotalAmt")); 
					}
				}catch(Exception e){	e.printStackTrace();	}
			}
		});
		
		B = new Button("Delete");
		B.setBackground(Color.DARK_GRAY);
		B.setForeground(Color.WHITE);
		B.setBounds(230,400,200,30);
		B.setFont(new Font("Arial",Font.PLAIN,17));
		p.add(B);
	
		
		B.addActionListener(this);
		setLayout(new BorderLayout());
		add(p,"Center");
		setVisible(true);
	}

	public void actionPerformed(ActionEvent AObj){

		if(AObj.getSource()==B)
		{
			
		 if(!ch.getSelectedItem().equals("--None--")){			
					del();
			dispose();
				// dispose();
			 }
			else				JOptionPane.showMessageDialog(null,"Plz choose StudentID");			
		}
	}
	
	public void del()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection Cobj = DriverManager.getConnection("jdbc:mysql://localhost/Coaching_Institute","root"," ");
			Statement sobj = Cobj.createStatement();
			String insertQry = "update Fee set DateOfDeposit=NULL ,TotalPaidAmt="+0+" where StudentID=" + ch.getSelectedItem()+";";
			int count = sobj.executeUpdate(insertQry);
			System.out.print(insertQry);
			
			
			String dltQry = "update Student set Date_Of_Deposit=NULL ,PaidAmt="+0+" where ID=" + ch.getSelectedItem()+";";
			count = sobj.executeUpdate(dltQry);
			System.out.print(dltQry);
		}
		catch(Exception e){	e.printStackTrace();	}
	}
	
} 