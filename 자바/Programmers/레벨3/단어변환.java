import java.util.LinkedList;
import java.util.Queue;

//정말 간단한 문제였다, 하지만 문제에 대해 잘못이해하면 tc 3번에서 계속 오답이 나올것이다.
// 예제에 끝에 target이 있어 많은 사람들이 index값을 주고 , bfs로 큐에 값을 넣으면 그 다음 인덱스부터 반복문을 돌린다 (나도 그랬다)
// 하지만 , 그러면 안되고 사전에 target이 words에 없는 경우를 처리해주고, 항상 0 부터 돌며 언제가 됐든 target으로 도착하는 시간을 재야한다.
class Node{
	String cur;
	int idx;
	int cnt;
	
	public Node(String cur, int idx,int cnt) {
		this.cur = cur;
		this.idx = idx;
		this.cnt = cnt;
	}
	
}
class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        for(int i = 0 ; i < words.length; i++) {
        	if(words[i].equals(target)) {
        		 answer = bfs(begin, target, words);
        		 return answer;
        	}
        }
        
        return answer;
    }
    
    public boolean compareWord(String cur, String comp) {
    	int count = 0 ;
    	for(int i = 0 ; i < comp.length(); i++) {
    		if(cur.charAt(i) == comp.charAt(i)) {
    			count++;
    		}
    	}
    	if(count == cur.length()-1) {
    		return true;
    	}
    	return false;
    }
    
    public int bfs(String begin, String target, String[] words) {
    	
    	Queue<Node> que = new LinkedList<>();
    	que.add(new Node(begin, -1, 0));

    	while(!que.isEmpty()) {
    		Node node = que.poll();
    		String cur = node.cur;
    		int idx = node.idx+1;
    		if(cur.equals(target)) {
    			return node.cnt;
    		}
    		
    		for(int i =0 ; i < words.length; i++) {
    			if(compareWord(cur, words[i])) {
    				que.add(new Node(words[i],i,node.cnt+1));
    			}
    		}
    		
    	}
    	return 0;
    	
    	
    }
}
