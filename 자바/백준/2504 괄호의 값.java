import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        Stack<Character> stack = new Stack<>();

        int cur = 1;
        int res = 0;
        for(int i = 0 ; i < s.length(); i++){
            switch (s.charAt(i)){
                case '(':
                    stack.push('(');
                    cur *= 2;
                    break;
                case '[':
                    stack.push('[');
                    cur *= 3;
                    break;
                case ')':
                    if(stack.isEmpty() || stack.peek() != '('){
                        res = 0;
                        System.out.println(0);
                        return;
                    }
                    if(s.charAt(i-1) == '('){
                        res += cur;
                    }
                    stack.pop();
                    cur /= 2;
                    break;
                case ']':
                    if(stack.isEmpty() || stack.peek() != '['){
                        res = 0;
                        System.out.println(0);
                        return;
                    }
                    if(s.charAt(i-1) == '['){
                        res += cur;
                    }
                    stack.pop();
                    cur /= 3;
                    break;
            }
        }
        System.out.println(stack.isEmpty() ? res : 0);

    }
}
