import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while(t-- > 0){
            List<String> aList = new ArrayList<>();
            int n = Integer.parseInt(br.readLine());
            for(int i = 0 ; i < n ; i++){
                aList.add(br.readLine());
            }
            Collections.sort(aList);
            boolean b = false;
            for(int i = 1 ; i < n; i++){
                String s = aList.get(i);
                String comp = aList.get(i-1);

                if(comp.length() < s.length()){
                    if(s.substring(0,comp.length()).equals(comp)){
                        System.out.println("NO");
                        b = true;
                        break;
                    }
                }
            }
            if(!b){
                System.out.println("YES");
            }
        }
    }
}
