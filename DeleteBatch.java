package graphics.controller;
import graphics.modal.*;
//import graphics.Database.*;
import java.util.*;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.WindowEvent;

public class DeleteBatch extends JFrame implements ActionListener
{
	Button B;
	JPanel p;
	Choice ch ;
	JLabel L1, L2, L3, L4, L5, L6, L7;
	JLabel T2, T3, T4, T5, T6, T7;
	//DBHelper d;
	Font f;
	public DeleteBatch()
	{
		Font f = new Font("TimesRoman",Font.BOLD , 20);
		p = new JPanel();
		setTitle("Do you want to Delete Batch ");
		setLocation(600,200);
		setSize(700,600);
		p.setBackground(new Color(255,255,153));
		
		JLabel title = new JLabel("Delete Batch");
		title.setBounds(240,30,220,30);
		title.setFont(new Font("Arial",Font.BOLD, 30));
		p.add(title);
		
		p.setLayout(null);
        L1 = new JLabel("Batch ID : ");
		L1.setBounds(120,100,120,30);
		L1.setFont(new Font("Arial",Font.PLAIN,17));
      
        ch = new Choice();
		ch.setFont(new Font("TimesRoman",Font.BOLD , 17));
		ch.setBounds(290,100,200,30);
		ch.add("--None--");
		p.add(L1); 		
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection Cobj = DriverManager.getConnection("jdbc:mysql://localhost/Coaching_Institute","root"," ");
			Statement sobj = Cobj.createStatement();
			ResultSet rsobj = null; 
			rsobj = sobj.executeQuery("select Id from Batch;");
			while(rsobj.next())
			{
				ch.add(rsobj.getString(1));
			}
		}
		catch(Exception e){	e.printStackTrace();	}
		p.add(ch);
		
		L2 = new JLabel("Batch Name :");
		L2.setBounds(120,150,120,30);
		L2.setFont(new Font("Arial",Font.PLAIN,17));
		
		T2 = new JLabel();
		T2.setBounds(290,150,200,30);
		T2.setFont(f);
		p.add(L2); 		p.add(T2);
		
		L3 = new JLabel("Course :");
		L3.setBounds(120,200,120,30);
		L3.setFont(new Font("Arial",Font.PLAIN,17));
		
		T3 = new JLabel();
		T3.setBounds(290,200,400,30);
		T3.setFont(f);
		p.add(L3); 		p.add(T3);
		
		L4 = new JLabel("Start Date :");
		L4.setBounds(120,250,100,30);
		L4.setFont(new Font("Arial",Font.PLAIN,17));
		
		T4 = new JLabel();
		T4.setBounds(290,250,200,30);
		T4.setFont(f);
		p.add(L4); 		p.add(T4);
		
		L5 = new JLabel("Duration(in month) :");
		L5.setBounds(120,300,300,30);
		L5.setFont(new Font("Arial",Font.PLAIN,17));
		
		T5 = new JLabel();
		T5.setBounds(290,300,200,30);
		T5.setFont(f);
		p.add(L5); 		p.add(T5);
		
		L6 = new JLabel("Faculty First Name :");
		L6.setBounds(120,350,200,30);
		L6.setFont(new Font("Arial",Font.PLAIN,17));
		
		T6 = new JLabel();
		T6.setBounds(290,350,200,30);
		T6.setFont(f);
		p.add(L6); 		p.add(T6);
		
		L7 = new JLabel("Faculty Last Name :");
		L7.setBounds(120,400,200,30);
		L7.setFont(new Font("Arial",Font.PLAIN,17));
		
		T7 = new JLabel();
		T7.setBounds(290,400,200,30);
		T7.setFont(f);
		p.add(L7); 		p.add(T7);
		
		ch.addItemListener(new ItemListener(){	
		public void itemStateChanged(ItemEvent Aobj){
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection Cobj = DriverManager.getConnection("jdbc:mysql://localhost/Coaching_Institute","root"," ");
				Statement sobj = Cobj.createStatement();
				ResultSet rsobj = sobj.executeQuery("select * from Batch where Id= "+ch.getSelectedItem()+";");
				
					while(rsobj.next())
					{	
						T2.setText(rsobj.getString(2)); 
						T3.setText(rsobj.getString(3)); 
						T4.setText(rsobj.getString(4)); 
						T5.setText(rsobj.getString(5)); 
						T6.setText(rsobj.getString(6)); 
						T7.setText(rsobj.getString(7)); 
					}
				}catch(Exception e){	e.printStackTrace();	}
			}
		});
		
		B = new Button("Delete");
		B.setBackground(Color.DARK_GRAY);
		B.setForeground(Color.WHITE);
		B.setBounds(230,450,200,30);
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
			String insertQry = "delete from Batch where Id=" + ch.getSelectedItem()+";";
			int count = sobj.executeUpdate(insertQry);
			System.out.print(insertQry);
		}
		catch(Exception e){	e.printStackTrace();	}
	}
	
} 