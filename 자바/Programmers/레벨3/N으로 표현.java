import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeSet;
// 도저히 5,6,7,8 tc가 안돼서 해답 참고.
// dp 보다는 구현에 가까운 문제, 게다가 if 5번째인 경우 1+4 // 2+3 경우를 고려해줘야함 단순히 이전 경우의수 더하기 1이 아님.
class Solution {
	static int tempN;
	static TreeSet<Integer>[] arr;
  
	public static TreeSet<Integer> getSet(int num){
		if(arr[num] != null && !arr[num].isEmpty()) {
			return arr[num];
		}
		TreeSet<Integer> tempSet = new TreeSet<Integer>();
		String n = "";
    // 연속 5 add
		for(int i = 0 ; i < num ; i++) {
			n += tempN+"";
		}
		tempSet.add(Integer.parseInt(n));
		
		for(int i = 1 ; i < num ; i++){
      //만약  num 이 8이면 1,7 / 2,6 / 3,5 / 4,4를 고려해야한다.
			TreeSet<Integer> f = getSet(i);
			TreeSet<Integer> t = getSet(num-i);
			
			for(int n1 : f) {
				for(int n2 : t) {
					tempSet.add(n1+n2);
					tempSet.add(n1-n2);
					tempSet.add(n1*n2);
					if(n2!=0)tempSet.add(n1/n2);
				}
			}
			
		}
		return arr[num]  = tempSet;
		
	}
    public int solution(int N, int number) {
        int answer = 0;
        tempN = N;
        arr = new TreeSet[10];
        for(int i = 1 ; i <= 8 ; i++) {
        	TreeSet<Integer> set = getSet(i);
        	if(set.contains(number)) {
        		return i;
        	} 	
        }
       
        return -1;
    }
}
