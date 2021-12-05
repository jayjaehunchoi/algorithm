import java.io.*;
class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        long s = Long.parseLong(br.readLine());
        
        long i = 1;
        int count = 0;
        long sum = 0;
      
      // 쭉 더하다가
        while(sum <= s){
            sum += i;
            count++;
            i++;
        }
      
      // 초과하면 이전 수 중 하나 제거하고 새로운 
        System.out.println(count-1);
        
    }
}
