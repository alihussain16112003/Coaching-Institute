package graphics.modal;
import java.util.*;
import graphics.modal.*;
import graphics.controller.*;
import graphics.view.*;
public class StudentModal
{
	private CourseModal cObj;
	private FeeModal fObj;
	private int id;
	private String Fname;
	private String Lname;
	private char gender;
	private String contactNo;
	private String dateOfDeposit;
	private int totalAmt;
	private int paidAmt;
	
	public StudentModal()
	
	{
		cObj = new CourseModal();
		fObj = new FeeModal();
		id = 1;
		Fname = "Rohit";
		Lname = "Sharma";
		gender = 'M';
		contactNo = "9823657823";
		dateOfDeposit = "15-05-2022";
		totalAmt = 60000;
		paidAmt = 35000;
	}
	
	public StudentModal(CourseModal cObj,FeeModal fObj,int id,String Fname,String Lname,char gender,String contactNo,String dateOfDeposit,int totalAmt,int paidAmt)
	{
		this.cObj = cObj;
		this.fObj = fObj;
		this.id = id;
		this.Fname = Fname;
		this.Lname = Lname;
		this.gender = gender;
		this.contactNo = contactNo;
		this.dateOfDeposit = dateOfDeposit;
		this.totalAmt = totalAmt;
		this.paidAmt = paidAmt;
	}
	
	public void setCObj(CourseModal cObj)			{		this.cObj = cObj;					}
	public void setFObj(FeeModal cObj)				{		this.fObj = fObj;					}
	
	public void setID(int id)						{		this.id = id;						}
	public void setFName(String Fname)				{		this.Fname = Fname;					}
	public void setLName(String Lname)				{		this.Lname = Lname;					}
	public void setGender(char gender)				{		this.gender = gender;				}
	public void setContactNo(String contactNo)		{		this.contactNo = contactNo;			}
	public void setDateOfDeposit(String dateOfDeposit){		this.dateOfDeposit = dateOfDeposit;	}
	public void setTotalAmt(int totalAmt)			{		this.totalAmt = totalAmt;			}
	public void setPaidAmt(int paidAmt)				{		this.paidAmt = paidAmt;				}
	
	
	public CourseModal getCObj()		{	return cObj;			}
	public FeeModal getFObj()			{	return fObj;			}
	
	public int getID()					{	return id;				}
	public String getFName()			{	return Fname;			}
	public String getLName()			{	return Lname;			}
	public char getGender()				{	return gender;			}
	public String getContactNo()		{	return contactNo;		}
	public String getDateOfDeposit()	{	return dateOfDeposit;	}
	public int getTotalAmt()			{	return totalAmt;		}
	public int getPaidAmt()				{	return paidAmt;			}
	
}