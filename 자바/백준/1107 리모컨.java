import java.util.*;
import java.lang.*;


//처음엔 가장 가까운 작은수, 가장 가까운 큰수 만들어서
// 비교하였으나
// 그러면 자릿수가 바뀌는 경우에는 올바른 답을 못내더라, 4퍼인가? 에서 실패
// 그래서 고민끝에 다른사람 풀이의 풀이 방법을 보고 혼자 구현해보았다,,

class Main{
   static boolean[] broken = new boolean[10]; 
   public static int clickCount(int comp){
       if(comp == 0){
           if(broken[comp]){
               return 0;
           }else{
               return 1;
           }
       }
       int len = 0;
       while(comp > 0){
           if(broken[comp%10]){
               return 0;
           }
           len++;
           comp /= 10;
       }
       return len;
   }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        for(int i = 0 ; i < m ; i++){
            int b = sc.nextInt();
            broken[b] = true;
        }
        
        int min = Math.abs(n-100);
        
        for(int i = 0 ; i < 1000000; i++ ){
            int comp = i;
            int length = clickCount(comp);
            
            if(length > 0){
                int move = Math.abs(comp - n) + length;
                min = Math.min(min, move);
            }
            
        }
        System.out.println(min);
    }
    
}
