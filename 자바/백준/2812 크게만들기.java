import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

// 프로그래머스때랑 똑같이 푸니 메모리초과
class Main {
	

    public static void main(String[] args) throws IOException{
    	 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	 BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	 StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    	 StringBuilder sb = new StringBuilder();
    	 int n = Integer.parseInt(st.nextToken());
    	 int k = Integer.parseInt(st.nextToken());
    	 
    	 Stack<Integer> stack = new Stack<>();
    	 String s = br.readLine();
    	 
    	 int count = 0;
 		for(int i = 0; i < s.length(); i++) {
 			int num = s.charAt(i) - '0';
 			
      //새로운 녀석이 들어올 수 있는 조건에서는 stack pop을 해줌
 			while(count < k && !stack.isEmpty() && stack.peek() < num) {
 				stack.pop();
 				count++;
 			}
 			
      // 푸시해줌
 			stack.push(num);
 		}
      // 이때, 위 조건때문에 추가로 들어온게 있을 수 있어서 자릿수로 출력해줌
    	 for(int i = 0 ; i < n-k; i++) {
    		 sb.append(stack.get(i));
    	 }
    	 bw.write(sb.toString());
    	 bw.flush();
    	 bw.close();
    	 br.close();
    }
  
}
