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
    InputStreamReader isr = new InputStreamReader(fis, Charset.forName("UTF-8"));
	BufferedReader br = new BufferedReader(isr);
	Scanner scan = new Scanner(System.in);
    Scanner input = new Scanner(fis);



public courseClass add(String courseClass){
	
	/*
	FileUtils.writeStringToFile(file, courseClass, true);
	*/

	try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("file", true)))) {
    out.println(courseClass);
	}
	catch (IOException e) {
    System.err.println(e);
}
}

public courseClass searchAndReturn(String courseCode){
	
	/*
	FileUtils.readFileToString(file).contains(courseClass);
	*/

	 while ((courseCode=br.readLine()) != null) {
     return courseCode;
  }

}

public boolean search(String courseCode){

	/*

	if((courseCode=br.readLine() != null)){
		return true;
	}
 	else{
	return false;
	}

	*/
}


}

