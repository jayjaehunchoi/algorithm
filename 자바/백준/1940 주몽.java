import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        List<Integer> aList = new ArrayList<>();
        
        for(int i = 0 ; i < n; i++){
            aList.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(aList);
        int start = 0;
        int end = n-1;
        
        int answer = 0;
      
      // 투포인터
        while(start < end){
            Integer num1 = aList.get(start);
            Integer num2 = aList.get(end);
            
            int sum = num1 + num2;
            if(sum < m){
                start++;
            }else if(sum > m){
                end--;
            }else{
                answer++;
                start++;
                end--;
            }
        }
        System.out.println(answer);
    }
}
