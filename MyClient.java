
import java.io.*;
import java.net.*;

public class MyClient {
public static void main(String[] args) throws IOException {
        Socket s=new Socket("localhost",4444);  

        
        File file = new File("C:\\TestSo\\test.txt");
        // Get the size of the file
        long length = file.length();
        byte[] bytes = new byte[16 * 1024];
        InputStream in = new FileInputStream(file);
        OutputStream out = s.getOutputStream();
        
        int count;
        while ((count = in.read(bytes)) > 0) {
            out.write(bytes, 0, count);
        }

        out.close();
        in.close();
        s.close();
    }
}