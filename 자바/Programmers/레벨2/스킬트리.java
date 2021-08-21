import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


// 간단한 문제였으나, que를 clear해주지 않아서 오류찾느라 시간을 좀 썼음
class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        Queue<Character> que = new LinkedList<Character>();
        List<Character> aList = new ArrayList<Character>();
        
        for(int i = 0 ; i < skill.length(); i++) {
        	aList.add(skill.charAt(i));
        }
        
        for(int i = 0 ; i < skill_trees.length; i++) {
        	
        	boolean check = true;
        	
            for(int j = 0 ; j < skill.length() ; j++) {
            	que.offer(skill.charAt(j));
            }
            
            for(int j = 0 ; j < skill_trees[i].length();j++) {
            	if(aList.contains(skill_trees[i].charAt(j))) {
            		if(que.peek() == skill_trees[i].charAt(j)) {
            			que.poll();
            		}else if(que.peek() != skill_trees[i].charAt(j)){
            			check = false;
            			break;
            		}
            	}
            }
            
            if(check) {
            	answer++;
            }
            que.clear();
        }
        
        return answer;
    }
}
