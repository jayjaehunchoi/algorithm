import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static double operations(List<Character> ops, List<Double> aList) {
		
		for(int i = 0 ; i < ops.size() ; i++) {
			if(ops.get(i) == '*') {
				double d = aList.get(i) * aList.get(i+1);
				aList.add(i, d);
				aList.remove(i+1);
				aList.remove(i+1);
				ops.remove(i);
				i--;
				
			}else if(ops.get(i) == '/') {
				double d = aList.get(i) / aList.get(i+1);
				aList.add(i, d);
				aList.remove(i+1);
				aList.remove(i+1);
				ops.remove(i);
				i--;
			}

		}
		for(int i = 0 ; i < ops.size() ;i++) {
			if(ops.get(i) == '+') {
				double d = aList.get(i) + aList.get(i+1);
				aList.add(i, d);
				aList.remove(i+1);
				aList.remove(i+1);
				ops.remove(i);
				i--;
				
			}else if(ops.get(i) == '-') {
				double d = aList.get(i) - aList.get(i+1);
				aList.add(i, d);
				aList.remove(i+1);
				aList.remove(i+1);
				ops.remove(i);
				i--;
			}

		}
		return aList.get(0);
		
		
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		String form = sc.next();
		double[] nums = new double[n];
		Stack<Double> stack = new Stack<>(); 

		for(int i = 0 ; i < n ; i++) {
			nums[i] = sc.nextInt();
		}
		for(int i = 0 ; i < form.length() ; i++) {
			if(form.charAt(i) >= 'A' && form.charAt(i) <= 'A' +n) {
				stack.push(nums[form.charAt(i)-65]);
			}else {
				if(form.charAt(i) == '*') {
					stack.push(stack.pop() * stack.pop());
					continue;
					
				}else if(form.charAt(i) == '/') {
					double a = stack.pop();
					double b = stack.pop();
					stack.push(b/a);
					continue;
				}else if(form.charAt(i) == '+') {
					stack.push(stack.pop() + stack.pop());
					continue;
					
				}else if(form.charAt(i) == '-') {
					double a = stack.pop();
					double b = stack.pop();
					stack.push(b-a);
					continue;
				}
			}	
		}
		System.out.println(String.format("%.2f",stack.pop()));
		
		
		
		
	}
}
