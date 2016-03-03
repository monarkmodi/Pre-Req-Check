import java.util.Comparator;

public class CourseClassComparator implements Comparator<CourseClass>
{
	public int compare(CourseClass c1, CourseClass c2)
	{
		return c1.getCourseCode().compareTo(c2.getCourseCode());
	}
	public boolean equals(CourseClass c1, CourseClass c2)
	{
		return c1.getCourseCode().equals(c2.getCourseCode());
	}
}