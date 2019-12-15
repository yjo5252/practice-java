//write and read using byte stream

import java.io.*;
public class Demo {
	public static void mains(String[] args) {
	// (x) wrong  import system.in
	// (x) this is for c lang.  java uses class ! c uses method! public void main() {
	// (x) public static void () {
	// error handling : try catch
		try {
			FileOutputStream fout = new FileOutputStream("d:/output.txt");
			for ( int i = 0 ; i < 10; i++) {
				int n = 10 - i;
				fout.write(n); //write one byte
			}
			fout.close();

			FileInputStream fin = new FileInputStream("d:/output.txt");
			int c = 0; //declare before using a variable
			while ((c = fin.read()) != -1)
				System.out.print(c + " ");
			fin.close();

		}
		catch (IOException e) {
				Sytem.out.println(e.getMessage()));'
		}
	}
}
