
import java.io.*;

public class Reader{

public static void main(String[]args) throws IOException{

    FileReader in = new FileReader("File Directory");
    BufferedReader br = new BufferedReader(in);

    while (br.readLine() != null) {
        System.out.println(br.readLine());
    }
    in.close();

}
}
