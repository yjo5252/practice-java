# Stack 응용

## 1. 후위표기법 Postfix 

```java
import java.util.Scanner;
import java.util.Stack;
 
public class Main
{
    private static Scanner sc;
    public static int[] result;
    public static void main(String[] args) {
        sc = new Scanner(System.in);
        Stack<Integer> op = new Stack<Integer>();
        int N = sc.nextInt();
        int a,b;
        sc.nextLine();
         
        String str = sc.nextLine();
         
        char[] arr = str.toCharArray();
         
        for(int i = 0 ; i <  N; ++ i)
        {
            Character item = arr[2*i];
             
            //숫자인 경우
            if( item >= '0' && item <= '9' )
            {
                op.add(Integer.parseInt(item.toString()));
            }else{ //연산자인 경우
                b = op.pop();
                a = op.pop();
                if(item == '+'){
                    op.push((a+b));
                }else if(item == '-'){
                    op.push((a-b));
                }else if(item == '*'){
                    op.push((a*b));
                }else if(item == '/'){
                    op.push((a/b));
                }
            }
        }
         
        System.out.println(op.pop());
         
         
    }
}
```
