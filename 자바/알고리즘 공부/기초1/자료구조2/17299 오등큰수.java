
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;
 
public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Stack<Integer> stack = new Stack<Integer>();
		
		int N = Integer.parseInt(br.readLine());
		int[] nums = new int [N];
		int[] ans = new int[N];
		Map<Integer, Integer> maps = new HashMap<Integer, Integer>();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0 ; i < N ; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
			maps.put(nums[i], maps.getOrDefault(nums[i],0)+1);
		}
		
		for(int i = 0 ; i < N ; i++) {
			ans[i] = maps.get(nums[i]);
		}
		
		for(int i = 0 ; i < N ; i++) {
			while(!stack.isEmpty() && ans[stack.peek()] < ans[i]) {
				nums[stack.peek()] = nums[i];
				stack.pop();
			}
			stack.push(i);
		}
		
		while(!stack.isEmpty()) {
			nums[stack.pop()] = -1;
		}
		StringBuilder sb = new StringBuilder();
		for(int i : nums) {
			sb.append(i + " ");
		}
		bw.write(sb.toString());
		br.close();
		bw.close();
		
	}
}
