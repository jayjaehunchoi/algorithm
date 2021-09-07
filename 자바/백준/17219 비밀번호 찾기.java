import java.util.*;
class Main{
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        Map<String, String> maps = new HashMap<>();
        for(int i = 0; i < n ; i++){
            String addr = sc.next();
            String pw = sc.next();
            maps.put(addr,pw);
        }
        
        for(int i = 0 ; i < m ; i++){
            String ans = sc.next();
            System.out.println(maps.get(ans));
        }
    }
}
