import java.util.ArrayList;
import java.io.Serializable;
import java.util.Collections;


//+++++++CLASS USES LINEAR SEARCH, WILL CHANGE TO BINARY ONCE SORT IMPLEMENTED+++++++
public class CourseList implements Serializable,ConsoleColorPrint
{
	//Defining a comparator for CourseClass objects, used by sort()
	public ArrayList<CourseClass> courses;

	CourseList(ArrayList<CourseClass> courses)
	{this.courses = courses;}

	CourseList()
	{this(new ArrayList<CourseClass>());}

	//Display the Course list 
	public void display()
	{
		System.out.print("\n");
		for(CourseClass iter : courses)
		{
			iter.display();
		}
	}

	//Returns a course with the given course code
	public CourseClass searchAndReturn(String cCode) throws CourseClassNotFoundException
	{
		CourseClass temp = null;
		boolean flag=false;

		for(CourseClass iter : courses)
		{
			if(cCode.equals(iter.getCourseCode()))
			{
				temp=iter;
				flag=true;
				break;
			}
		}

		if(!flag) {throw new CourseClassNotFoundException(cCode);}

		return temp;
	}

	//Returns true if the given class is in the course list
	public boolean searchForClass(String cCode)
	{
		boolean flag=false;
		for(CourseClass iter : courses)
		{
			if(cCode.equals(iter.getCourseCode()))
			{
				flag=true;
				break;
			}
		}
		return flag;
	}

	//Add an element in the course list
	public void add(CourseClass c1)
	{
		if(searchForClass(c1.getCourseCode()))
		{
			System.out.println("Error: "+c1.getCourseCode()+" already exists in the database.");
		}
		else
		{
			courses.add(c1);
		}
	}

	//Delete the course with the given code 
	public void delete(String courseCode) throws CourseClassNotFoundException
	{
		boolean flag=false;
		for(int iter=0; iter<courses.size(); iter++)
		{
			if(courses.get(iter).getCourseCode().equals(courseCode))
			{
				courses.get(iter).display();
				flag=true;
				System.out.println("Deleting the instance of class.");
				courses.remove(iter);
				break;
			}
		}
		if(!flag){throw new CourseClassNotFoundException(courseCode);}
	}

	public void sort()
	{Collections.sort(courses, new CourseClassComparator());}

	// public CourseClass searchAndReturnB(String cCode)
	// {
	// 	int start,end,mid;
	// 	CourseClass retClass=new CourseClass(" ");
	// 	start=0;
	// 	end=courses.size()-1;
	// 	while(end<start)
	// 	{
	// 		mid=(start+end)/2;
	// 		if(cCode.compareTo(courses.get(mid).getCourseCode())>0) start = mid;
	// 		else if(cCode.compareTo(courses.get(mid).getCourseCode())<0) end = mid;
	// 		else {retClass=courses.get(mid); break;}
	// 	}
	// 	return retClass;
	// }
}