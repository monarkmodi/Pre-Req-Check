import java.util.ArrayList;
import java.util.Collections;

public class Analyser
{
	private CourseClass givenCourse;
	private ArrayList<CourseClass> prCourses = new ArrayList<CourseClass>();

	public Analyser(CourseClass courseName) throws CourseClassNotFoundException
	{
		givenCourse = courseName;
		createArr(givenCourse);
		sortAndReduce();
	}

	private void sortAndReduce()
	{
		//Sort the array
		Collections.sort(prCourses,new CourseClassComparator());

		//Remove the redundancies
		ArrayList<CourseClass> temp = new ArrayList<CourseClass>();

		for(int iter=0; iter<prCourses.size(); iter++)
		{
			if(iter<prCourses.size()-1)
				if(prCourses.get(iter).equals(prCourses.get(iter+1)))
					continue;
				else
					temp.add(prCourses.get(iter));
			else
				temp.add(prCourses.get(iter));
		}

		prCourses = temp;
	}

	public void display()
	{
		System.out.println();
		try
		{
			System.out.print(givenCourse.getCourseCode()+": ");
			for(CourseClass iter : prCourses)
				System.out.print(iter.getCourseCode()+"; ");
		}catch (NullPointerException e) 
		{
			System.out.println("Error: The pre-requisite course list is empty");	
		}
		catch(Exception e) {e.printStackTrace();}
	}

	public void createArr(CourseClass cPassed)
	{
		for(CourseClass pointer : cPassed.preReqArr)
		{
			prCourses.add(pointer);
			if(pointer.preReqArr.size()==0)
			{
				return;
			}
			else
			{
				createArr(pointer);
			}
		}
	}
}