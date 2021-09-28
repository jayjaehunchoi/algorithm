
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

class Node implements Comparable<Node>{
	int plays;
	int idx;
	public Node(int plays, int idx) {
		this.plays = plays;
		this.idx = idx;
	}
	@Override
	public int compareTo(Node o) {
		if(o.plays-this.plays == 0) {
			return this.idx - o.idx;
		}else {
			return o.plays-this.plays;
		}
	}
}
class Solution {
    public List<Integer> solution(String[] genres, int[] plays) {
        
        
        Map<String, Integer> maps = new HashMap<String, Integer>();
        for(int i = 0 ; i < genres.length; i++) {
        	maps.put(genres[i],maps.getOrDefault(genres[i], 0)+plays[i]);
        }
        
        List<Integer> answer = new ArrayList<>();
        int idx = 0;
        while(true) {
        	PriorityQueue<Node> pq = new PriorityQueue<Node>();
        	int max = 0;
            String maxGen = "";
        	for(Entry<String,Integer> e : maps.entrySet()) {
        		if(e.getValue() > max) {
        			max = e.getValue();
        			maxGen = e.getKey();
        		}
        	}
        	int siz = maps.size();
        	maps.put(maxGen,0);
        	for(int i = 0 ; i < genres.length; i++) {
        		if(genres[i].equals(maxGen)) {
        			pq.add(new Node(plays[i],i));
        		}
        	}
        	int num = 0;
        	while(!pq.isEmpty()) {
        		if(num < 2) {
        			answer.add(pq.poll().idx);
        			num++;
        		}else {
        			pq.clear();
        		}
        	}
        	idx++;
        	if(idx == siz) {
        		return answer;
        	}
        	

        }
    }
}
