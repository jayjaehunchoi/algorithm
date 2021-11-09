import java.util.*;
import java.io.*;

public class Main{

     public static void main(String []args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while(t-- > 0){
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), " ");
            int[] arr = new int[n];
            int[] newArr = new int[n];
            
            for(int i = 0 ; i < n ; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);
            
            // 차이값을 가장 작게 하는법, 정렬된 수를 번갈아가며 앞, 뒤로 놓기
            int start = 0;
            int end = n-1;
            for(int i = 0 ; i < n; i++){
                if(i % 2 == 0){
                    newArr[start++] = arr[i];
                }else{
                    newArr[end--] = arr[i];
                }
            }
            
            int max = Math.abs(newArr[0] - newArr[n-1]);
            for(int i = 0 ; i < n-1; i++){
                max = Math.max(Math.abs(newArr[i] - newArr[i+1]),max);
            }
            
            System.out.println(max);
            
        }
     }
}
