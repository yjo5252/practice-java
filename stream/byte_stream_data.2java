import java.io.*;
public class Demo (){
  public static void main (String [] args ) {
    try {
    // you need to declare object before you use it 'new'
      DataOutputStream dos = new DataOutputStream(new FileOutputStream("d:/output2.txt"));

      int a = 10;
      double d = 20.0;
      boolean b = true;
      char c = 'a';

      dos.writeInt(a);
      dos.writeDouble(d);
      dos.writeBoolean(b);
      dos.writeClearChar(c);
      dos.close();

    }
    catch (IOException e){
      System.out.println(e.getMessage);

    }
  try {
    DataInputSystem dis = new DataInputSystem("d:/output2.txt");
    int aa = dis.readInt();
    int
    int as = dis.close();
  }
  }
}
