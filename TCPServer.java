import java.io.*;
import java.net.*;
import java.util.*;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;

class TCPServer {
	private static final char[] HEX_CHARS = "0123456789abcdef".toCharArray();

 public static void main(String argv[]) throws Exception {
  String clientSentence;
  String capitalizedSentence;
  ServerSocket welcomeSocket = new ServerSocket(9090);

  while (true) {
   Socket connectionSocket = welcomeSocket.accept();
   Socket connectionSocket2=welcomeSocket.accept();
   BufferedReader inFromClient =
   new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
   DataOutputStream outToClient = new DataOutputStream(connectionSocket2.getOutputStream());
   clientSentence = inFromClient.readLine();
   System.out.println("Received: " + clientSentence);
   capitalizedSentence=unHex(clientSentence)+"\n";
   System.out.println("decoded : "+capitalizedSentence);
   outToClient.writeBytes(capitalizedSentence);
   connectionSocket.close();
   connectionSocket2.close();
  }
 }
 public static String unHex(String arg) {        

    String str = "";
    for(int i=0;i<arg.length();i+=2)
    {
        String s = arg.substring(i, (i + 2));
        int decimal = Integer.parseInt(s, 16);
        str = str + (char) decimal;
    }       
    return str;
 }
}
