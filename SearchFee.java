package graphics.controller;
import graphics.modal.*;
//import graphics.Database.*;
import java.util.*;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.WindowEvent;

public class SearchFee extends JFrame implements ActionListener
{
	Button B2,B3,B;
	JLabel l1, l2;
	Choice ch;
	Frame j, j1;
	TextArea T;
	
	public SearchFee()
	{
		j = new Frame();
		j.setTitle("Search Fee");
		j.setLocation(630,350);
		j.setSize(500,300);	
		j.setBackground(Color.LIGHT_GRAY);
		
		JLabel title = new JLabel("Search Fee");
		title.setBounds(150,50,260,40);
		title.setFont(new Font("Arial",Font.BOLD, 30));
		j.add(title);
        l1 = new JLabel("Student ID : ");
		l1.setBounds(150,130,100,30);
		l1.setFont(new Font("Arial",Font.BOLD,17));

        ch = new Choice();
		ch.setFont(new Font("Arial",Font.BOLD,17));
		ch.add("--None--");
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection Cobj = DriverManager.getConnection("jdbc:mysql://localhost/Coaching_Institute","root"," ");
			Statement sobj = Cobj.createStatement();
			ResultSet rsobj = null; 
			rsobj = sobj.executeQuery("select StudentId from Fee;");
			while(rsobj.next())
			{
				ch.add(rsobj.getString(1));
			}
		}
		catch(Exception e){	e.printStackTrace();	}
		ch.setBounds(290,130,100,30);
		j.add(ch);
	
		B2 = new Button("Search");
		B2.setBackground(Color.DARK_GRAY);
		B2.setForeground(Color.WHITE);
		B2.setBounds(150,210,120,30);
		B2.setFont(new Font("Arial",Font.PLAIN,17));
		j.add(l1);
		j.add(ch);
		j.add(B2);	
		B2.addActionListener(this);
		j.setLayout(new BorderLayout());
		j.setVisible(true);
	}

	public void actionPerformed(ActionEvent AObj){

		if(AObj.getSource()==B2)
		{
			if(!ch.getSelectedItem().equals("--None--")){
				j.dispose();
				ShowSearch();
			}else			JOptionPane.showMessageDialog(null,"Plz Choose BatchId");		
		}
		if(AObj.getSource()==B)
		{
			j1.dispose();
		}
	}
	
	public void ShowSearch()
	{
		JLabel L1, L2, L3, L4, L5, L6, L7, L8,L9,L10;
		JLabel T1, T2, T3, T4, T5, T6, T7, T8, T9, T10;
	
		j1 = new Frame();
		Font f = new Font("TimesRoman",Font.BOLD , 20);
		
		j1.setTitle("Fees Data Found ");
		j1.setLocation(500,150);
		j1.setSize(600,600);
		j1.setBackground(new Color(255,204,153));
		
		JLabel title = new JLabel("Search Fees Data");
		title.setBounds(180,70,300,40);
		title.setFont(new Font("Arial",Font.BOLD, 30));
		j1.add(title);
		
		j1.setLayout(null);
        L1 = new JLabel("Student ID : ");
		L1.setBounds(160,140,120,30);
		L1.setFont(new Font("Arial",Font.PLAIN,17));
      
        T1 = new JLabel();
		T1.setFont(f);
		T1.setBounds(330,140,200,30);
		j1.add(L1);		j1.add(T1); 		
		
		L2 = new JLabel("Date Of Deposit :");
		L2.setBounds(160,190,200,30);
		L2.setFont(new Font("Arial",Font.PLAIN,17));
		
		T2 = new JLabel();
		T2.setBounds(330,190,200,30);
		T2.setFont(f);
		j1.add(L2); 		j1.add(T2);
		
		L3 = new JLabel("Total Paid Amt :");
		L3.setBounds(160,240,120,30);
		L3.setFont(new Font("Arial",Font.PLAIN,17));
		
		T3 = new JLabel();
		T3.setBounds(330,240,400,30);
		T3.setFont(f);
		j1.add(L3); 		j1.add(T3);
		
		L4 = new JLabel("Total Amt :");
		L4.setBounds(160,290,100,30);
		L4.setFont(new Font("Arial",Font.PLAIN,17));
		
		T4 = new JLabel();
		T4.setBounds(330,290,200,30);
		T4.setFont(f);
		j1.add(L4); 		j1.add(T4);
		
		
		B = new Button("CLOSE");
		B.setBackground(Color.DARK_GRAY);
		B.setForeground(Color.WHITE);
		B.setBounds(190,500,180,30);
		B.setFont(new Font("Arial",Font.PLAIN,17));
		j1.add(B);
		
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection Cobj = DriverManager.getConnection("jdbc:mysql://localhost/Coaching_Institute","root"," ");
				Statement sobj = Cobj.createStatement();
				ResultSet rsobj = sobj.executeQuery("select * from Fee where StudentId= "+ch.getSelectedItem()+";");
				
					while(rsobj.next())
					{
						T1.setText(rsobj.getString(2));
						T2.setText(rsobj.getString(3)); 
						T3.setText(rsobj.getString(4)); 
						T4.setText(rsobj.getString(5)); 
						// T5.setText(rsobj.getString(5)); 
						// T6.setText(rsobj.getString(6)); 
						// T7.setText(rsobj.getString(7)); 
					}
					rsobj.close();
					sobj.close();
					Cobj.close();
				}catch(Exception e){	e.printStackTrace();	}	
		j1.setLayout(new BorderLayout());
		B.addActionListener(this);
		j1.setVisible(true);
	}
}
	
