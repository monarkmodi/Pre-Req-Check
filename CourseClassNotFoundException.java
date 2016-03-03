public class CourseClassNotFoundException extends Exception
{
	public CourseClassNotFoundException(String courseCode)
	{super("Could not find " + courseCode+" in the database");}
}