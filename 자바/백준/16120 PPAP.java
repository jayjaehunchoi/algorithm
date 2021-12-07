import java.io.*;
import java.util.Stack;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();


        Stack<Character> stack = new Stack<>();

      // 'A'가 나오고, 'A' 앞 두자리가 PP일 때 true
        boolean flag = false;
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == 'P'){
                if(flag == true){
                    flag = false;
                }
                stack.push('P');
            }else{
                // A다음 A, A 앞으로 두자리가 없는 경우, A가 마지막인경우 NP
                if(flag == true || stack.size() < 2 || i == str.length() - 1){
                    System.out.println("NP");
                    return;
                }
              
                // 앞 두자리가 P가 아니면 NP
                for (int j = 0; j < 2; j++) {
                    if(stack.pop() != 'P'){
                        System.out.println("NP");
                        return;
                    }
                }
                flag = true;
            }
        }
      
      // 주어진 문자열이 P * n 인 경우 
        if(stack.size() > 1){
            System.out.println("NP");
            return;
        }
      
      // 모두 뚫으면 PPAP
        System.out.println("PPAP");
    }
}
