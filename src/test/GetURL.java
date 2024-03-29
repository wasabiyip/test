package test;

import java.io.*;
import java.net.*;

/**
 * This simple program uses the URL class and its openStream() method to
 * download the contents of a URL and copy them to a file or to the console.
 **/
public class GetURL {
    public static void main(String[] args) {
        InputStream in = null;   
        OutputStream out = null;
        try {
            // Check the arguments
           // if ((args.length != 1)&& (args.length != 2)) 
             //   throw new IllegalArgumentException("Wrong number of args");
        	String a="www.google.com";
	    String b= "test.txt";
            // Set up the streams
            URL url = new URL(a);   // Create the URL
            in = url.openStream();        // Open a stream to it
            if (args.length == 2)         // Get an appropriate output stream
                out = new FileOutputStream(b);
            else out = System.out;
	    
            // Now copy bytes from the URL to the output stream
            byte[] buffer = new byte[4096];
            int bytes_read;
            while((bytes_read = in.read(buffer)) != -1)
                out.write(buffer, 0, bytes_read);
	}
        // On exceptions, print error message and usage message.
        catch (Exception e) {
            System.err.println(e);
            System.err.println("Usage: java GetURL <URL> [<filename>]");
        }
        finally {  // Always close the streams, no matter what.
            try { in.close();  out.close(); } catch (Exception e) {}
        }
    }
}

