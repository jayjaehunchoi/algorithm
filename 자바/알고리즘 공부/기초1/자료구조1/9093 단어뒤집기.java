import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        
        for(int i = 0 ; i< t ; i++){
            String[] s = br.readLine().split(" ");
            StringBuilder sb = new StringBuilder();
            for(int j = 0 ; j < s.length; j++){
                for(int k = s[j].length()-1 ; k >= 0 ; k-- ){
                    sb.append(s[j].charAt(k));
                }
                sb.append(" ");
            }
            System.out.println(sb.toString());
        }
        
        
    }
}
