public class Q9{
    static int MAX = 100;
    
    // 동적계획법을 사용해 삼각형의 최적의 경로(합이 최대가 되는 경로)를 구한다. 
    public static long number_triangls(int a[][], int k){
        long best[][] = new long[MAX+1][MAX+1];
        for (int i = 0; i < MAX; i++){
            for (int j = 0; j < MAX; j++){
                best[i][j] = 0
            }
        }
        long max_result =0;
        
        for (int i = 1; i <= k; i++){
            for (int j = 1; j <= i; j++){
                 best[i][j] = a[i-1][j-1] + Math.max(best[i-1][j-1], best[i-1][j]);
            }
        }
    
        for (int i=1; i <= k; i++){
            if(max_result < best[k][i]) max_result = best[k][i];
        }
        
        return max_result;
    }
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int N;
        int C;
        C = scan.nextInt();
        long answer[] = new long[C];
        for (int testCase = 0; testCase < C; testCase++){
            N = C;
            
            // 배열 선언            
            int triangle[][] = new int[N][];
            for (int i = 0; i < N; i++){
                triangle[i] = new int[i+1];
            }
            
            // 배열 초기화 
            for (int i = 0; i < N; i++){
                for(int j = 0; j < i+1; j++){
                    triangle[i][j] = scan.nextInt();
                }
            }
            
            answer[testCase] = number_triangle(triangle, N);
        }
        
        for (int i = 0; i < C; i++){
            System.out.println(answer[i]);
        }
    }
}
