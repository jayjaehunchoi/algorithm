import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    static int[] gates;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int g = Integer.parseInt(br.readLine());
        int p = Integer.parseInt(br.readLine());
        gates = new int[g+1];
        for(int i = 0 ; i <= g ; i++){
            gates[i] = i;
        }

        int cnt = 0;

        while(p-- > 0){
            int val = Integer.parseInt(br.readLine());
            int tmp = find(val);
            if(tmp != 0){
                cnt++;
                union(tmp -1, tmp);
            }else{
                break;
            }
        }
        System.out.println(cnt);
    }

  // 현재 게이트부터 1번 게이트까지 닫혔는지 확인
  // 0일 경우 모두 닫힘
    public static int find(int val){
        if(gates[val] == val) return val;
        return gates[val] = find(gates[val]);
    }

  // 현재 게이트에 비행기가 들어오면 값 변화
    public static void union(int a, int b){
        int g_a = find(a);
        int g_b = find(b);
        if(g_a < g_b) gates[g_b] = g_a;
        else gates[g_a] = g_b;
    }


}
