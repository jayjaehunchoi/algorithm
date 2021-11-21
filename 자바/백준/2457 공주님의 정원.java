
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main{
    public static int START = 301;
    public static int END = 1201;

    public static int createDate(int m, int d){
        return m*100 + d;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int start = createDate(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            int end = createDate(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            if(map.get(start) == null || map.get(start) < end){
                map.put(start, end);
            }
        }
        int answer = 0;
        boolean status = false;
        int date = START;
        while(date < END){
            int max = date;
            for(int key : map.keySet()){
                if(key <= date && max < map.get(key)){
                    max = map.get(key);
                    status =true;
                }
            }

            if(status){
                date = max;
                status = false;
                answer++;
            }else{
                System.out.println(0);
                return;
            }
        }
        System.out.println(answer);
    }
}
