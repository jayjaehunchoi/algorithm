import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


class Main {
	static int max = Integer.MIN_VALUE;
	static List<Integer> numList;
	static List<Character> opList;
	public static int calc(char op, int num1, int num2) {
		int res = 0;
		switch (op) {
		case '+':
			res = num1+num2;
			break;
		case '-':
			res = num1-num2;
			break;
		case '*':
			res = num1*num2;
			break;
		}
		return res;
	}
	
	public static void dfs(int res, int opIdx) {
		
		if(opIdx >= opList.size()) {
			max = Math.max(max, res);
			return;			
		}
		char op = opList.get(opIdx);
		int num1 = res;
		int num2 = numList.get(opIdx+1);
		int calRes = calc(op,num1,num2);
		dfs(calRes, opIdx+1); // 먼저 괄호없이 계산 전부 돌린 뒤 , 뒤로 return 되면서 괄호 추가
    
		if(opIdx+1 < opList.size()) {
      
			char newOp = opList.get(opIdx+1);
			int newNum = numList.get(opIdx+2);
			int calRes2 = calc(newOp, numList.get(opIdx+1), newNum);
			
			dfs(calc(opList.get(opIdx),res,calRes2), opIdx+2);
		}
		
	}
	
    public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String format = br.readLine();
		
		numList = new ArrayList<Integer>();
		opList = new ArrayList<Character>();
		
		for(int i = 0 ; i < format.length(); i++) {
			char c = format.charAt(i);
			if(c == '+' || c == '*' || c == '-') {
				opList.add(c);
				continue;
			}
			numList.add(c-'0');
		}
		dfs(numList.get(0), 0);
		System.out.println(max);
		
    }
  
}
