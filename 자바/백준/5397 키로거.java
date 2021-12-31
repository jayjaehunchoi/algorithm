import java.io.*;
import java.util.Stack;

class Main {

    public static String setStack(String str) {
        Stack<Character> lStack = new Stack<>();
        Stack<Character> rStack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        char[] chars = str.toCharArray();
      
      // lStack은 메인, rStack은 서브로 사용
        for (char val : chars) {
            switch (val) {
                case '<' :
                    if (!lStack.isEmpty()) rStack.push(lStack.pop());
                    break;
                case '>' :
                    if(!rStack.isEmpty()) lStack.push(rStack.pop());
                    break;
                case '-' :
                    if(!lStack.isEmpty()) lStack.pop();
                    break;
                default:
                    lStack.push(val);
            }
        }

        for (Character character : lStack) {
            sb.append(character);
        }

      // 50퍼에서 계속 오류가 나서 이걸 썼는데,, 왜 필요하지 이게...
        while (!rStack.isEmpty()) {
            sb.append(rStack.pop());
        }

        return sb.toString();

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while(t-- > 0) {
            String str = br.readLine();
            System.out.println(setStack(str));
        }
    }

}
