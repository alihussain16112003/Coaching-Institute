package graphics.modal;
import graphics.modal.*;
import graphics.controller.*;
//import graphics.view.*;
public class FacultyModal
{
	private int id;
	private String Fname;
	private String Lname;
	private char gender;
	private String specialization;
	private String contactNo;
	
	public FacultyModal()
	{
		id = 1;
		Fname = "Sanjay";
		Lname = "Kumar";
		gender = 'M';
		specialization = "Web Desiging";
		contactNo = "9834763459";
	}
	
	public FacultyModal(int id,String Fname,String Lname,char gender,String specialization,String contactNo)
	{
		this.id = id;
		this.Fname = Fname;
		this.Lname = Lname;
		this.gender = gender;
		this.specialization = specialization;
		this.contactNo = contactNo;
	}
	
	public void setID(int id)							{		this.id = id;						}
	public void setFName(String Fname)					{		this.Fname = Fname;					}
	public void setLName(String Lname)					{		this.Lname = Lname;					}
	public void setGender(char gender)					{		this.gender = gender;				}
	public void setSpecialization(String specialization){	this.specialization = specialization;	}
	public void setContactNo(String contactNo)			{	this.contactNo = contactNo;				}
	
	public int getID()					{		return id;			}
	public String getFName()			{		return Fname;		}
	public String getLName()			{		return Lname;		}
	public char getGender()				{		return gender;		}
	public String getSpecialization()	{	return specialization;	}
	public String getContactNo()		{	return contactNo;		}
}