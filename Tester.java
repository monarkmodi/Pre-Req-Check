import java.util.*;
import java.io.*;

public class Tester implements ConsoleColorPrint
{
	public static void main(String[] args)
	{
		int choice=0;
		CourseList cList = new CourseList();
		String fileName = "Database.txt";

		//Load the course list from the database file
		try
		{
			ObjectInputStream reader = new ObjectInputStream(new FileInputStream(fileName));
			cList = ((CourseList)reader.readObject());
			reader.close();
		}
		catch(FileNotFoundException e) {System.out.println(ConsoleColorPrint.retColorString("red","Error: Cannot find " +fileName+" in the native directory"+ANSI_RESET));}
		catch(InvalidClassException e) 
		{
			System.out.println(ConsoleColorPrint.retColorString("red","Error: The definitions of CourseClass or CourseList have been changed, database cannot be loaded")); 
			cList = new CourseList();
		}
		catch(Exception e) {e.printStackTrace();}

		Scanner inputChoice = new Scanner(System.in);
		Scanner readName = new Scanner(System.in);

		do
		{
			System.out.println("\nWhat do you want to do?");
			System.out.println("1. Input a new class");
			System.out.println("2. Sort the database");
			System.out.println("3. Show the classes in database");
			System.out.println("4. Remove a given class");
			System.out.println("5. Create pr List");
			System.out.println("6. Exit");
			
			choice = inputChoice.nextInt();

			switch(choice)
			{
				case 1 :
				{
					ArrayList<CourseClass> prList = new ArrayList<CourseClass>();
					System.out.print("Enter the Course Code : ");
					String cCode = readName.nextLine();
					if(cList.searchForClass(cCode))
					{
						System.out.println(ConsoleColorPrint.retColorString("red",cCode+" already exists in the database."));
						break;
					}

					//Create and split the list of all Pre-requisites
					System.out.print("Enter the course codes for the pre-requisite class (comma-separated) : ");
					String prString = readName.nextLine();
					String[] prArr = prString.split("[,]");

					for(String iter : prArr)
					{
						if(iter.length()<=0)
							continue;
						else
						{
							try
							{
								prList.add(cList.searchAndReturn(iter));
							}catch(CourseClassNotFoundException e)
							{
								System.out.println("++++WARNING : "+iter+" was not found in the database, please add++++");
								prList.add(new CourseClass(iter));
							}
						}
					}
					
					//Add the new CourseClass to the list
					cList.courses.add(new CourseClass(cCode, prList));
					break;
				}
				case 2 :
				{
					cList.sort();

					break;
				}
				case 3 :
				{
					cList.display();
					break;
				}
				case 4:
				{
					System.out.print("Enter the course code: ");
					String courseCode=readName.nextLine();
					try
					{
						cList.delete(courseCode);
					}
					catch(CourseClassNotFoundException e){System.out.println(e.getMessage());}
					break;
				}
				case 5:
				{
					System.out.print("Enter the course code: ");
					String courseCode=readName.nextLine();
					try
					{
						Analyser a = new Analyser(cList.searchAndReturn(courseCode));
						a.display();
					}catch(CourseClassNotFoundException e){System.out.println(ConsoleColorPrint.retColorString("red",e.getMessage()));}
				}

				default : break;
			}
		}while(choice!=6);

		//Close the Scanners
		inputChoice.close();
		readName.close();
		
		//Write the new Course List to the file
		try
		{
			ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(fileName));
			System.out.println(ConsoleColorPrint.retColorString("blue","Writing the changes to the database....."));
			writer.writeObject(cList);
			writer.close();
		}
		catch(FileNotFoundException e) {System.out.println("Error: Cannot find " + fileName+" in the native directory" );}
		catch(Exception e) {e.printStackTrace();}
	}// Main ends
}