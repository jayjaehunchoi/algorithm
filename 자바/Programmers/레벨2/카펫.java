import java.util.ArrayList;

class Solution {
	static int[] answer = new int [2];
	
	// 재귀로 찾아주기!
  // 나름의 규칙이 있음, 그런데 다른 분들 풀이 보니까 더 쉬운 규칙이 있는 것 같았음
	public static int[] finding(ArrayList<Integer> yaksu, int start, int end, int brown, int yellow) {
	
			if(((yaksu.get(start) - 2)*(yaksu.get(end) - 2)) == yellow && (yaksu.get(end) + (yaksu.get(start) - 2))*2 == brown) {
				answer[0] = yaksu.get(end);
				answer[1] = yaksu.get(start);
				return answer;
			}
			if(end<start) {
				return answer ;
			}

			return finding(yaksu, start+1, end-1, brown, yellow);
		}
	
    public int[] solution(int brown, int yellow) {

        ArrayList<Integer> yaksu = new ArrayList<Integer>();
        int tot = brown + yellow;
        
      //재귀에 사용될 전체 값의 약수를 구한다 약1 * 약2 = 전체임
        for(int i = 1 ; i <= tot/2 ;i++ ) {
        	if(tot % i == 0) {
        		yaksu.add(i);
        	}
        }
        yaksu.add(tot);

        return finding(yaksu, 0 , yaksu.size()-1,brown, yellow);
    }
}
