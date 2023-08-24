import graphics.modal.*;
import graphics.controller.*;
import graphics.view.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MyWin extends WindowAdapter
{
	public void windowClosing(WindowEvent wObj)
	{
		//System.out.println("\n\tWindow Closing.....!!!!!");
		System.exit(0);
	}
}

class MyFrame extends Frame implements ActionListener
{
	
	public static void main(String args[])
	{
		MyFrame a = new MyFrame();
	}
	
	
	MenuBar mbObj;
	Menu mnuCourse, mnuBatch, mnuFaculty, mnuStudents, mnuFees;
	MenuItem mnu[];
	PopupMenu pMnu;
	Font f;
	String status;
	Image img;
	public MyFrame()
	{
		setTitle("Sucess Coaching Center");
		setSize(1400,800);
		setLocation(50,20);
		setBackground(Color.BLACK);
		f = new Font("Arial", Font.BOLD, 17);
		Toolkit tObj = Toolkit.getDefaultToolkit();
		img = tObj.getImage("D:\\Graphical Java\\sucess.JPG");
		
		Cursor Cobj = tObj.createCustomCursor(img,new Point(25,25),"MyCursor");
		setCursor(Frame.HAND_CURSOR);
		setIconImage(img);
		
		mbObj = new MenuBar();
		
		mbObj.setFont(new Font("TimesRoman",Font.BOLD | Font.ITALIC,80));
		mnuCourse = new Menu("Course");
		mnuBatch = new Menu("Batch");
		mnuFaculty = new Menu("Faculty");
		mnuStudents = new Menu("Student");
		mnuFees = new Menu("Fees");
		
		f = new Font("Arial",Font.BOLD,17);
		setFont(f);
		
		mnuCourse.setFont(new Font("sans-serif",Font.BOLD,18));
		mnuBatch.setFont(new Font("sans-serif",Font.BOLD,18));
		mnuFaculty.setFont(new Font("sans-serif",Font.BOLD,18));
		mnuStudents.setFont(new Font("sans-serif",Font.BOLD,18));
		mnuFees.setFont(new Font("sans-serif",Font.BOLD,18));
		
		mnu = new MenuItem[20];
		
		//Course
		mnu[0] = new MenuItem("Show Courses");
		mnuCourse.add(mnu[0]);
		
		mnu[1] = new MenuItem("Add Courses");
		mnuCourse.add(mnu[1]);
		
		mnu[2] = new MenuItem("Search Course");
		mnuCourse.add(mnu[2]);
		
		mnu[3] = new MenuItem("Delete Course");
		mnuCourse.add(mnu[3]);
		
		//Batch
		mnu[4] = new MenuItem("Show Batch");
		mnuBatch.add(mnu[4]);
		
		mnu[5] = new MenuItem("Add Batch");
		mnuBatch.add(mnu[5]);
		
		mnu[6] = new MenuItem("Search Batch");
		mnuBatch.add(mnu[6]);
		
		mnu[7] = new MenuItem("Delete Batch");
		mnuBatch.add(mnu[7]);
	
		//Faculty
		
		mnu[8] = new MenuItem("Show Faculty");
		mnuFaculty.add(mnu[8]);
		
		mnu[9] = new MenuItem("Add Faculty");
		mnuFaculty.add(mnu[9]);
		
		mnu[10] = new MenuItem("Search Faculty");
		mnuFaculty.add(mnu[10]);
		
		mnu[11] = new MenuItem("Delete Faculty");
		mnuFaculty.add(mnu[11]);
		
		
		//Students
		
		mnu[12] = new MenuItem("Show Students");
		mnuStudents.add(mnu[12]);
		
		mnu[13] = new MenuItem("Add Students");
		mnuStudents.add(mnu[13]);
		
		mnu[14] = new MenuItem("Search Students");
		mnuStudents.add(mnu[14]);
		
		mnu[15] = new MenuItem("Delete Students");
		mnuStudents.add(mnu[15]);
		
		//Fees
		
		mnu[16] = new MenuItem("Show Fees");
		mnuFees.add(mnu[16]);
		
		mnu[17] = new MenuItem("Add Fees");
		mnuFees.add(mnu[17]);
		
		mnu[18] = new MenuItem("Search Fees");
		mnuFees.add(mnu[18]);
		
		mnu[19] = new MenuItem("Delete Fees");
		mnuFees.add(mnu[19]);
		
		
		mbObj.add(mnuCourse);
		mbObj.add(mnuBatch);
		mbObj.add(mnuFaculty);
		mbObj.add(mnuStudents);
		mbObj.add(mnuFees);
		
		setMenuBar(mbObj);
		
		for(int i=0;i<mnu.length;i++)
		{
			mnu[i].addActionListener(this);
		}
		
		addWindowListener(new MyWin());
		setVisible(true);
		setResizable(false);
	}
	
	public void actionPerformed(ActionEvent aObj)
	{
		if(aObj.getSource()==mnu[0])
		{
			CourseView cv = new CourseView();
		}
		else if(aObj.getSource() == mnu[1])
		{
			new CourseController();
		}
		
		else if(aObj.getSource() == mnu[2])
		{
			new SearchCourse();
		}
		else if(aObj.getSource() == mnu[3])
		{
			new DeleteCourse();
		}
		
		else if(aObj.getSource() == mnu[4])
		{
			BatchView bv = new BatchView();
		}
		
		else if(aObj.getSource() == mnu[5])
		{
			new BatchController();
		}
		
		else if(aObj.getSource() == mnu[6])
		{
			new SearchBatch();
		}
		else if(aObj.getSource() == mnu[7])
		{
			new DeleteBatch();
		}
		
		else if(aObj.getSource() == mnu[8])
		{
			FacultyView fv = new FacultyView();
		}
		else if(aObj.getSource() == mnu[9])
		{
			new FacultyController();
		}
		
		else if(aObj.getSource() == mnu[10])
		{
			new SearchFaculty();
		}
		else if(aObj.getSource() == mnu[11])
		{
			new DeleteFaculty();
		}
		
		else if(aObj.getSource() == mnu[12])
		{
			StudentView sv = new StudentView();
		}
		else if(aObj.getSource() == mnu[13])
		{
			new StudentController();
		}
		
		else if(aObj.getSource() == mnu[14])
		{
			new SearchStudent();
		}
		else if(aObj.getSource() == mnu[15])
		{
			new DeleteStudent();
		}
		
		else if(aObj.getSource() == mnu[16])
		{
			new FeeView();
		}
		else if(aObj.getSource() == mnu[17])
		{
			new FeeController();
		}
		else if(aObj.getSource() == mnu[18])
		{
			new SearchFee();
		}
		else if(aObj.getSource() == mnu[19])
		{
			new DeleteFee();
		}
		
	}
	public void paint(Graphics Gobj)
	{
		Gobj.drawImage(img,0,0,1400,800,this);
	}
	
	
}