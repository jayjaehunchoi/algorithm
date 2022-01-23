import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

  // 하나의 그룹에서 곱하기와 나누기가 가장 큰 우선순위를 가져야 한다.
  // 만약 괄호와 비교한다면 괄호는 가장 낮은 우선순위를 갖는다.
    static int checkPriority(char curChar) {
        if(curChar == '*' || curChar == '/') return 2;
        if(curChar == '+' || curChar == '-') return 1;
        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        char[] chars = input.toCharArray();
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < chars.length; i++) {
            char curChar = chars[i];
          
          // 알파벳 값은 바로 정답에 추가해준다.
            if(curChar >= 'A' && curChar <= 'Z') {
               sb.append(curChar);
            } else {
              // 괄호의 시작, 새로 들어올 연산자는 스택에 쌓인다.
                if (curChar == '(') {
                    stack.push(curChar);
                }else if(curChar == ')') {
                    while (!stack.isEmpty() && stack.peek() != '(') {
                      // 빠져나가지 못한 스택 내부의 연산자는 모두 추가된다.
                        sb.append(stack.pop());
                    }
                  
                  // 괄호 제거
                    if(!stack.isEmpty()) {
                        stack.pop();
                    }
                } else {
                  
                  // 기존 스택에 쌓여있는 연산자와 비교했을 때, 스택의 우선순위가 높다면 해당 값은 정답에 추가된다.
                    while (!stack.isEmpty() && checkPriority(stack.peek()) >= checkPriority(curChar)) {
                        sb.append(stack.pop());
                    }
                    stack.push(curChar);
                }
            }

        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        System.out.println(sb.toString());


    }

}
