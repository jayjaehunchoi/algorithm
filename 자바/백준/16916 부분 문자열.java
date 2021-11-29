import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        String p = br.readLine();

        System.out.println(kmp(s,p));
    }
  
  // idx 비교, 다르면 가장 최신의 같았던 idx로 돌아감
    public static int kmp(String s, String p){
        int sLen = s.length();
        int pLen = p.length();
        int[] table = createTable(p);

        int idx = 0;

        for(int i = 0; i < sLen ; i++){
            while(idx > 0 && s.charAt(i) != p.charAt(idx)){
                idx = table[idx-1];
            }
            if(s.charAt(i) == p.charAt(idx)){
                if(idx == pLen-1){
                    return 1;
                }else{
                    idx++;
                }
            }
        }
        return 0;
    }

  // 비교할 패턴의 접두사 접미사 비교, 이 로직으로 매번 처음상태로 돌아가는 것을 막아줌
    public static int[] createTable(String p){
        int n = p.length();
        int[] pArr = new int[n];

        int idx = 0;
        for(int i = 1; i < n; i++){
            while(idx > 0 && p.charAt(i) != p.charAt(idx)){
                idx = pArr[idx - 1];
            }

            if(p.charAt(i) == p.charAt(idx)){
                idx++;
                pArr[i] = idx;
            }
        }
        return pArr;
    }
}
