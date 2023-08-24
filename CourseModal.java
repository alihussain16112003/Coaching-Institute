package graphics.modal;
//import graphics.modal.*;
//import project.controller.*;
//import project.view.*;
public class CourseModal
{
	private int ID;
	private String name;
	private int duration;
	private int fee;
	
	public CourseModal()
	{
		name = "BCA";
		duration = 12;
		fee = 25000;
	}
	
	public CourseModal(String name,int duration,int fee)
	{
		this.name = name;
		this.duration = duration;
		this.fee = fee;
	}
	
	public void setName(String name)			{	this.name = name;			}
	public void setDuration(int duration)		{	this.duration = duration;	}
	public void setFee(int fee)					{	this.fee = fee;				}
	
	public int getID()			{		return ID;			}
	public String getName()		{		return name;		}
	public int getDuration()	{		return duration;	}
	public int getFee()			{		return fee;			}
}