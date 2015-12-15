import javax.swing.JPanel;
import java.awt.Graphics;
import java.util.ArrayList;

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
	}

	//Creates the Pre-requisite classes array
	//Uses deep access of n-ary tree
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

	//Main Method
	public static void main(String[] args)
	{

	}	//Main Method Ends
}	//Class definition Ends