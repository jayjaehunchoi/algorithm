import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
public class Main{
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		Stack<Integer> stack=new Stack<Integer>();
		ArrayList<Integer> result=new ArrayList<>();
		do {
			String input=br.readLine();
			String[] s=input.split(" ");
			switch(s[0]) {
			case "pop":
				if(!stack.isEmpty())
					result.add(stack.pop());
				else
					result.add(-1);
				N--;
				break;
			case "top":
				if(!stack.isEmpty())
					result.add(stack.peek());
				else
					result.add(-1);
				N--;
				break;
			case "size":
				result.add(stack.size());
				N--;
				break;
			case "empty":
				if(!stack.isEmpty())
					result.add(0);
				else
					result.add(1);
				N--;
				break;
			case "push":
				stack.push(Integer.parseInt(s[1]));
				N--;
				break;
			}
		}while(N>0);
		for(int i=0;i<result.size();i++) {
			System.out.println(result.get(i));
		}
	}
}
