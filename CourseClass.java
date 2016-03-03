import java.util.ArrayList;
import java.io.Serializable;

public class CourseClass implements Serializable,ConsoleColorPrint
{
	private String courseCode;	//Must be unique
	public ArrayList<CourseClass> preReqArr;	//List of all the preRequisites of the course

	CourseClass(String cCode, ArrayList<CourseClass> pRA)
	{
		this.courseCode = cCode;
		this.preReqArr = pRA;
		preReqArr = removeRedundancies();
	}

	CourseClass(String cCode)
	{this(cCode,new ArrayList<CourseClass>());}

	//----------------------STATIC DEFINITIONS----------------------

	//Deep nested tree search for 'toFind' in the 'tree'
	public static boolean nestedTreeSearch(CourseClass toFind, CourseClass tree)
	{
		if(equals(toFind,tree)) return true;
		else if(tree.preReqArr.size()==0) return false;
		else
		{
			boolean[] truthArr = new boolean[tree.preReqArr.size()];
			boolean flag=false;
			for(int iter=0; iter<tree.preReqArr.size(); iter++)
			{
				truthArr[iter] = nestedTreeSearch(toFind,tree.preReqArr.get(iter));
			}
			for(boolean iter : truthArr)
				{flag = flag||iter;}
			return flag;
		}
	}

	//Remove the redundant pre-requisites from the pre-requisite array
	//A redundant pre-requisite is a pre-requisite that exists as the pre-requisite
	//of a pre-requisite of the class itself.
	public static ArrayList<CourseClass> removeRedundancies(CourseClass cClass)
	{
		ArrayList<CourseClass> retArr = new ArrayList<CourseClass>();
		boolean flag=true;
		for(int prIter=0; prIter<cClass.preReqArr.size(); prIter++)
		{
			flag=true;
			for(int checkIter=0; checkIter<cClass.preReqArr.size(); checkIter++)
			{
				if(checkIter==prIter) continue;
				if(nestedTreeSearch(cClass.preReqArr.get(prIter),cClass.preReqArr.get(checkIter)))
				{
					flag=false;
					break;
				}
			}
			if(flag) retArr.add(cClass.preReqArr.get(prIter));
		}

		return retArr;
	}

	//Check for equality of two course using their courseCode 
	public static boolean equals(CourseClass c1, CourseClass c2)
	{return c1.getCourseCode().equals(c2.getCourseCode());}

	//---------------STATIC DEFINITIONS END------------------------------

	public ArrayList<CourseClass> removeRedundancies()
	{return removeRedundancies(this);}

	public boolean nestedTreeSearch(CourseClass tree)
	{return nestedTreeSearch(this,tree);}

	public String getCourseCode()
	{return courseCode;}

	//Return true if the given courseCode exists in the pre-requisite list
	public boolean instanceCourseCode(CourseClass toSearch)
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

	public void display()
	{
		System.out.print("Course Code: " + courseCode+"    ");

		if(preReqArr.size()==0)
			System.out.print("No Pre-requisites for this course");
		else
		{
			System.out.print("Pre-requisites: ");
			for(CourseClass iter : preReqArr)
				{System.out.print(iter.getCourseCode()+"; ");}
		}
		System.out.print("\n");
	}	

}

