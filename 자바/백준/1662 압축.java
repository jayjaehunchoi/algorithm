import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split("");
        Stack<String> stack = new Stack<>();

        for(int i = 0 ; i < str.length; i++){
            if(!str[i].equals(")")){
                stack.push(str[i]);
            }else{
                int cnt = 0;
                while (!stack.peek().equals("(")){
                    String res = stack.pop();
                  // 길이 명시
                    if(res.equals("*")){
                        int len = Integer.parseInt(stack.pop());
                        cnt += len;
                    }else{
                        cnt++;
                    }
                }
                stack.pop();
                int len = Integer.parseInt(stack.pop());
                cnt *= len;
                stack.push(String.valueOf(cnt));
                stack.push("*"); // 길이 명시
            }
        }

        int answer = 0;
        while(!stack.isEmpty()){
            if(stack.peek().equals("*")){
                stack.pop();
                answer += Integer.parseInt(stack.pop());
            }else{
                stack.pop();
                answer++;
            }
        }
        System.out.println(answer);
    }
}
