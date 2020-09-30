import java.util.Scanner;

public class Q10{
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[] keyboard = new char[32];
        String[] dest = new String[n];
    
        //목적지와 입력 값 저장 
        for (int i = 0; i < n; i++)
            dest[i] = sc.next();
        String input = sc.next();
        int len = input.length();
        
        for (int i = 0; i < n; i++){
            String substr = dest[i].substring(0, len);
            
            if (substr.equals(input)){
                char ch = dest[i].charAt(len);
                keyboard[(int) ch - 62]  = ch;
            }
        }
        
        // 키보드 출력
        for (int i = 0; i < 32; i++){
            if (keyboard[i] == 0)
                System.out.print('*');
             else
                System.out.print(keyboard[i]);
             if (i % 8 == 7)
                System.out.println();
        }
    }
}
