package graphics.modal;
import graphics.modal.*;
import graphics.controller.*;
//import graphics.view.*;
public class FeeModal
{
	private int studentID;
	private String dateOfDeposit;
	private int totalAmt;
	private int paidAmt;
	
	public FeeModal()
	{
		studentID = 1;
		dateOfDeposit = "15-05-2022";
		totalAmt = 60000;
		paidAmt = 35000;
	}
	
	public FeeModal(int studentID,String dateOfDeposit,int totalAmt,int paidAmt)
	{
		this.studentID = studentID;
		this.dateOfDeposit = dateOfDeposit;
		this.totalAmt = totalAmt;
		this.paidAmt = paidAmt;
	}
	
	public void setStudentId(int setStudentId)		{		this.studentID = studentID;	}
	public void setDateOfDeposit(String dateOfDeposit){		this.dateOfDeposit = dateOfDeposit;	}
	public void setTotalAmt(int totalAmt)			{		this.totalAmt = totalAmt;			}
	public void setPaidAmt(int paidAmt)				{		this.paidAmt = paidAmt;				}
	
	public int getStudentId()		{		return studentID;		}
	public String getDateOfDeposit(){		return dateOfDeposit;	}
	public int getTotalAmt()		{		return totalAmt;		}
	public int getPaidAmt()			{		return paidAmt;			}
}