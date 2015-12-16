import java.util.*;
import java.awt.*;

public class Tester
{
	public static void main(String[] args)
	{
		ArrayList<CourseClass> temp = new ArrayList<CourseClass>();
		int choice=0;
		Reader read = new Reader();
		Scanner inputChoice = new Scanner(System.in);
		Scanner readName = new Scanner(System.in);

		do
		{
			System.out.println("What do you want to do?");
			System.out.println("1. Input a new class");
			System.out.println("2. Show Pre-requisite for a given class");
			System.out.println("3. Exit");
			choice = inputChoice.nextInt();
			switch(choice)
			{
				case 1 :
				{
					ArrayList<CourseClass> prList = new ArrayList<CourseClass>();
					System.out.print("Enter the courseCode : ");
					String courseName = readName.nextLine();
					System.out.print("Enter the course codes for the pre-requisite class (comma-separated) : ");
					String prString = readName.nextLine();

					String[] prArr = prString.split("[,]");
					for(String iter : prArr)
					{
						if(iter.length()<=0)
							continue;
						else if(!read.search(iter))
							{
								System.out.println("++++WARNING : "+iter+" was not found in the database, please add++++");
								prList.add(new CourseClass(iter));
							}
						else
							prList.add(read.searchAndReturn(iter));

					}

					break;
				}
				case 2 :
				{
					break;
				}
				case 3 :
				{
					break;
				}
				default : break;
			}
		}while(1); //+++++++CHANGE THIS++++++++++
	}
}