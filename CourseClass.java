import java.util.ArrayList;
import javax.swing.JPanel;
import java.awt.Graphics;

public class CourseClass extends JPanel
{
	private String instructor;	//Name of the instructor
	private String courseName;	//Name of the course 
	private String courseCode;	//Must be unique
	private boolean fall;		//Course offering in fall
	private boolean spring;		//Course offering in spring
	public ArrayList<CourseClass> preReqArr;	//List of all the preRequisites of the course

	CourseClass(String iName, String cName, String cCode, boolean f, boolean s, ArrayList<CourseClass> prList)
	{
		this.instructor = iName;
		this.courseName = cName;
		this.courseCode = cCode;
		fall = f;
		spring = s;

		ArrayList<CourseClass> preReqArr = new ArrayList<CourseClass>();
		preReqArr.addAll(prList);
	}

	CourseClass(String iName, String cName, String cCode, ArrayList<CourseClass> prList)
	{this(iName,cName,cCode,true,true,prList);}

	CourseClass(ArrayList<CourseClass> prList)
	{this("EMPTY", "EMPTY", "EMPTY",prList);}

	//----------FOR TESTING PURPOSES--------------
	CourseClass(String cCode,ArrayList<CourseClass> prList)
	{this("EMPTY", "EMPTY", cCode, prList);}

	public String getCourseCode()
	{return courseCode;}

	public boolean searchCourseCode(CourseClass toSearch)
	{
		boolean flag=false;
		for(int iter=0; iter<toSearch.preReqArr.size(); iter++)
		{
			if(toSearch.getCourseCode().equals(preReqArr.get(iter)))
			{
				flag=true;
				break;
			}
		}

		return flag;
	}

	public int getMaxWidth()
	{
		int maxLength=0;
		return maxLength;
	}

	//Draws a rectangle with upper left corner at (x,y)
	public void display(Graphics g,int x, int y)
	{
		int offset = 10;
		int height = 5*7;
		g.drawRect(x,y,this.getMaxWidth()+2*offset,height);
	}
}

