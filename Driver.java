import javax.swing.JPanel;
import java.awt.Graphics;
import java.util.*;

public class Driver extends JPanel
{
	//Class Attributes
	private ArrayList<CourseClass> preReqArr;
	private CourseClass givenClass;  

	//Constructor
	public Driver(CourseClass gClass)
	{
		this.givenClass = gClass;
		ArrayList<CourseClass> preReqArr = new ArrayList<CourseClass>();
		createArr(givenClass);
		sortAndReduce(preReqArr);
	}

	//Creates the Pre-requisite classes array
	//Uses deep access of n-ary structure
	private void createArr(CourseClass cPassed)
	{
		for(CourseClass pointer : cPassed.preReqArr)
		{
			if(pointer==null)
				return;
			else
			{
				preReqArr.add(pointer);
				createArr(pointer);
			}
		}
	}

	private ArrayList<CourseClass> sortAndReduce(ArrayList<CourseClass> arr)
	{
		ArrayList<CourseClass> retArrList = new ArrayList<CourseClass>();

		//-------------Sort the array------------------------------

		//Sorting the array using Arrays.sort()
		//Comparator class for the sort() function
		//Compares the two classes based on the CourseCode of the classes
		class courseClassComparator implements Comparator<CourseClass>
		{
			@Override
			public int compare(CourseClass c1, CourseClass c2)
			{
				return c1.getCourseCode().compareToIgnoreCase(c2.getCourseCode());
			}
		}

		//Convert the arraylist to an array for sorting processes
		CourseClass[] tempArr = new CourseClass[arr.size()];
		arr.toArray(tempArr);
		
		//sort the array using the defined comparator
		courseClassComparator comp = new courseClassComparator();
		Arrays.sort(tempArr, comp);

		//---------------Reduce the array--------------------------

		//Reduce the sorted array
		for(int iter=0; iter<tempArr.length; iter++)
		{
			if(iter<tempArr.length-1)
				if(tempArr[iter].getCourseCode().equals(tempArr[iter+1].getCourseCode()))
					continue;
				else
					retArrList.add(tempArr[iter]);
			else 
				retArrList.add(tempArr[iter]);	
		}
		
		return retArrList;
	}

	//Main Method
	public static void main(String[] args)
	{

	}	//Main Method Ends
}	//Class definition Ends