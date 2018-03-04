import java.io.*;
import java.net.*;

class TCPClient {
private static final char[] HEX_CHARS = "0123456789abcdef".toCharArray();
 public static void main(String argv[]) throws Exception {
  String message;
  String modifiedSentence;
  BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
  Socket clientSocket = new Socket("localhost", 9090);
  DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
  BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
  message = inFromUser.readLine();
  String finalmsg="MESSAGE:"+message.length()+":"+message+":"+"END";
   String helloWorldInHex = HexStringConverter.getHexStringConverterInstance().stringToHex(finalmsg);
  System.out.println("sent :"+helloWorldInHex);
  outToServer.writeBytes(helloWorldInHex + '\n');
  System.out.println("successfully send");
 /* modifiedSentence = inFromServer.readLine();
  System.out.println("FROM SERVER: " + modifiedSentence);
   System.out.println(modifiedSentence.substring(10,modifiedSentence.length()-4));
  
  */
  clientSocket.close();
 }
}