import java.util.*;
import java.io.*;

public class Main{
    public static int maxE = 15;
    public static int maxS = 28;
    public static int maxM = 19;
    
     public static void main(String []args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        
        int e = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int answer = 0;
        while(true){
            
            ++answer;
            int tmpE = answer % maxE;
            int tmpS = answer % maxS;
            int tmpM = answer % maxM;
            
            if(tmpE == 0)tmpE = maxE;
            if(tmpS == 0)tmpS = maxS;
            if(tmpM == 0)tmpM = maxM;
            
            if(e == tmpE && s == tmpS && m == tmpM){
                System.out.println(answer);
                return;
            }
        }
        
     }
}
