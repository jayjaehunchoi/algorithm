import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {

	int[] temp;
	boolean[] visited;
	int numberOfCal = 0;
	List<List<Integer>> calList = new ArrayList<>();
  
  // 조합으로 후보키 조합 찾기. 
	public void combination(String[][] relation, int index, int count, int target) {
		
		if(count == target) {
      // 조건 2 최소 요건 
			for(int i = 0 ; i < calList.size(); i++) {
				int c = 0;
				for(int j = 0 ; j < calList.get(i).size(); j++) {
					for(int k = 0 ; k < temp.length; k++) {
						if(temp[k] == calList.get(i).get(j)) {
							c++;
						}
					}
				}
				if(c == calList.get(i).size()) {
					return;
				}
			}
			if(checkCandidate(relation)) {
				numberOfCal += 1;
				
			}
			return;
		}
		for(int i = index ; i < relation[0].length; i++ ) {
			if(!visited[i]) {
				temp[count] = i;
				visited[i] = true;
				combination(relation, i, count+1, target);
				visited[i] = false;
			}
		}
		
	}
	
  // 조건 1. 모두 
	public boolean checkCandidate(String[][] relation) {
		Set<String> set = new HashSet<String>();
		
		for(int i = 0 ; i< relation.length; i++) {
			String s = "";
			for(int j = 0 ; j < temp.length; j++) {
				s += relation[i][temp[j]];
			}
			set.add(s);
		}
		
		if(set.size() == relation.length) {
			List<Integer> aList = new ArrayList<Integer>();
			for(int i = 0 ; i < temp.length; i++) {
				aList.add(temp[i]);
			}
			calList.add(aList);
			return true;
		}
		return false;
	}
    public int solution(String[][] relation) {

        for(int i = 1; i <= relation[0].length; i++) {
        	temp = new int[i];
        	visited = new boolean[relation[0].length];
        	combination(relation, 0, 0, i);
        }
        
        return numberOfCal;
    }
}
