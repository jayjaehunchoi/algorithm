import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String explosion = br.readLine();

        Stack<Character> stack = new Stack<>();
        for(int i = 0 ; i <  str.length(); i++){
            stack.push(str.charAt(i));

            if(stack.size() >= explosion.length()){
                boolean flag = true;
                for (int j = 0; j < explosion.length(); j++) {
                  //처음엔 stack의 subList 사용, 매번 리스트를 복사하다보니 메모리 초과 발생
                  // get으로 변경, 일치하지 않으면 반복문 종료 
                    if (stack.get(stack.size() - explosion.length() + j) != explosion.charAt(j)) {
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    for(int j = 0 ; j < explosion.length(); j++){
                        stack.pop();
                    }
                }
            }
        }
        if(stack.isEmpty()){
            System.out.println("FRULA");
        }else{
            StringBuilder s = new StringBuilder();
            while(!stack.isEmpty()){
                s.append(stack.pop());
            }
            System.out.println(s.reverse().toString());
        }
    }
}
