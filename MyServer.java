import java.io.*;
import java.net.*;

public class MyServer {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = null;
        Socket s=null;
       

        try {
             ss= new ServerSocket(4444); 
             s=ss.accept();  
        } catch (IOException ex) {
            System.out.println("Can't setup server on this port number. ");
        }

      
        InputStream in = null;
        OutputStream out = null;
        
        
        try {
            in = s.getInputStream();
        } catch (IOException ex) {
            System.out.println("Can't get socket input stream. ");
        }

        try {
            out = new FileOutputStream("C:\\TestSo2\\test2.txt");
        } catch (FileNotFoundException ex) {
            System.out.println("File not found. ");
        }

        byte[] bytes = new byte[16*1024];

        int count;
        while ((count = in.read(bytes)) > 0) {
            out.write(bytes, 0, count);
        }

        out.close();
        in.close();
        s.close();
        ss.close();
    }
}