import java.io.*;
import java.net.*;

class TCPClient2 {
private static final char[] HEX_CHARS = "0123456789abcdef".toCharArray();
 public static void main(String argv[]) throws Exception {
  String message;
  String modifiedSentence;
  //BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
  Socket clientSocket = new Socket("localhost", 9090);
  //DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
  
  BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
   modifiedSentence = inFromServer.readLine();
  //System.out.println("FROM SERVER: " + modifiedSentence);
  String []st=modifiedSentence.split(":");
   System.out.println(st[2]);
   clientSocket.close();
 }
}