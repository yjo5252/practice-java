//File printout

import java.io.*;
public class Demo3 {
  public static void main (String[] args){
    String s ;
    try {
      BufferedReader rd = new BufferedReader(new FileReader("d:/test.txt"));
      FileWrite w = new FileWriter("d:/result.txt");

      while (( s=rd.nextLine()) != null) {
        w.write(s+"\r\n");
      }
      rd.close(); // close the stream
      w.close();
    }
    
    catch (IOException e) {
      System.out.println(e.getMessage());
    }
  }
}
