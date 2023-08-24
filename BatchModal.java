package graphics.modal;
import graphics.modal.*;
import graphics.controller.*;
import graphics.view.*;
import java.util.*;
public class BatchModal
{
	private int batchID;
	private String batchName;
	private CourseModal course;
	private String batchDate;
	private int duration;
	private FacultyModal faculty;
	
	public BatchModal()
	{
		batchID = 1;
		batchName = "JAVA Batch";
		course = new CourseModal();
		batchDate = "01-04-2023";
		duration = 3;
		faculty = new FacultyModal();
	}
	
	public BatchModal(int batchID,String batchName,CourseModal course,String batchDate,int duration,FacultyModal faculty)
	{
		this.batchID = batchID;
		this.batchName = batchName;
		this.course = course;;
		this.batchDate = batchDate;
		this.duration = duration;
		this.faculty = faculty;
	}
	
	public void setBatchId(int batchID) 					{	this.batchID = batchID;		}
	public void setBatchName(String batchName) 				{	this.batchName = batchName;	}
	public void setBatchDate(String batchDate) 				{	this.batchDate = batchDate;	}
	public void setDuration(int duration)					{	this.duration = duration;	}
	public void setCourse(CourseModal course) 				{	this.course = course;		}
	public void setFaculty(FacultyModal faculty)			{	this.faculty = faculty;		}
	
	public int getBatchId() 				{	return batchID;		}
	public String getBatchName() 			{	return batchName;	}
	public String getBatchDate()			{	return batchDate;	}
	public int getDuration()				{	return duration;	}
	public CourseModal getCourse() 			{	return course;		}
	public FacultyModal getFaculty()		{	return faculty;		}
}