import java.io.PrintWriter;
import java.io.File;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.FileInputStream;



public class Reader { 
	
	
	InputStream fis = new FileInputStream("the_file_name");
    InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
	BufferedReader br = new BufferedReader(isr);
	Scanner scan = new Scanner(System.in);
    Scanner input = new Scanner(fis);



public CourseClass add(CourseClass c){
	
	/*
	FileUtils.writeStringToFile(file, courseClass, true);
	*/

	try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("file", true)))) {
    out.println(c);
	}
	catch (IOException e) {
    System.err.println(e);
}
}

public CourseClass searchAndReturn(String courseCode){
	
	/*
	FileUtils.readFileToString(file).contains(courseClass);
	*/

	 while ((courseCode=br.readLine()) != null) {
     return courseCode; //make changes here
  }

}

public boolean search(String courseCode){

	
	// Also here!
	if((courseCode=br.readLine() != null)){
		return true;
	}
 	else{
	return false;
	}

	
}


}

