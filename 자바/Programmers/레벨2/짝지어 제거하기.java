import java.util.Stack;

class Solution {
	public int solution(String s) {
		int answer = 0;
		Stack<String> stack = new Stack<String>();
		stack.push(s.substring(0, 1));

		for (int i = 1; i < s.length(); i++) {
			if (!stack.isEmpty()) {
				if (stack.peek().equals(s.substring(i, i + 1))) {
					stack.pop();
				} else {
					stack.push(s.substring(i, i + 1));
				}
			} else {
				stack.push(s.substring(i, i + 1));
			}
		}
		if (stack.isEmpty()) {
			return 1;
		}

		return answer;
	}
}
