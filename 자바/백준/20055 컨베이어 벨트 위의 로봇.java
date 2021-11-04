import java.util.*;
import java.io.*;

public class Main{
    static int n;
    static int k;
    static int[] belt;
    static boolean[] robot;

    public static int simulation(){
        int cnt = 0;
        while(true){
            cnt++;
             // 벨트 로봇 동시 회전
            int tmp = belt[belt.length-1];
            for(int i = belt.length-1; i > 0 ; i--){
                belt[i] = belt[i-1];
            }
            belt[0] = tmp;

            for(int i = n-1; i > 0 ; i--){
                robot[i] = robot[i-1];
            }
            robot[0] = false;
            // 한 칸 이동할 수 있으면 이동
            robot[n-1] = false;
            for(int i = n-1; i > 0 ; i--){
                if(belt[i] > 0 && robot[i-1] && !robot[i]){
                    robot[i] = true;
                    robot[i-1] = false;
                    belt[i]--;
                }
            }
            // 올리기 (내구도 0 아니면)
            if(belt[0] > 0){
                robot[0] = true;
                belt[0]--;
            }
          // 내구도 
            if(isZeroSameWithK()){
                return cnt;
            }
        }
    }

    public static boolean isZeroSameWithK(){
        int cnt = k;
        for(int i = 0 ; i < belt.length; i++){
            if(belt[i] == 0){
                cnt--;
            }
            if(cnt <= 0){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        belt = new int[2*n];
        robot = new boolean[n];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < belt.length; i++){
            belt[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(simulation());

    }


}
