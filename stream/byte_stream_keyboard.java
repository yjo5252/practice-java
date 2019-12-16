// keyboard input 이용한 텍스트 파일 읽기

import java.io.*;
public class Demo3 {
  public static void main (String [] args) {
    try {
      InputStreamReader in = new InputStreamReader(System.in);
      FileWriter fout = new FileWriter("C:/outfile.txt");

      while ((c=in.read() != -1))
        fout.write(c);
      in.close();
      fout.close();
    }
    catch(IOException e){
      System.out.println(e.getMessage());
    }

  }
}
