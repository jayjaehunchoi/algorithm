import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

class Main{
	static Map<Integer, Integer> maps;
  
  // que에 값을 넣으면서 map에도 넣어줌
  // map에 없는 수면 다시 반복문
  // 중복된 수는 - 하고 종료
  // 하나 있으면 remove해주고 break;
	public static int delete(Queue<Integer> q) {
		
		int res = 0;
		
		while(true) {
			
			res = q.poll();

			int c = maps.getOrDefault(res, 0);
			if(c == 0)continue;
			
			if(c == 1) maps.remove(res);
			else maps.put(res,maps.get(res)-1);
			
			break;
		}
		
		return res;
	}

    public static void main(String[] args) throws IOException {
    	Scanner sc = new Scanner(System.in);
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int t= Integer.parseInt(br.readLine());
    	StringTokenizer st; 
    	
    	for(int i = 0 ; i < t ; i++) {
    		int n = Integer.parseInt(br.readLine());
    		PriorityQueue<Integer> maxQ = new PriorityQueue<Integer>(Collections.reverseOrder());
    		PriorityQueue<Integer> minQ = new PriorityQueue<Integer>();
    		
    		maps = new HashMap<Integer, Integer>();
    		for(int j = 0 ; j < n ; j++) {
    			st = new StringTokenizer(br.readLine()," ");
    			
    			char oper = st.nextToken().charAt(0);
    			int num = Integer.parseInt(st.nextToken());
    			
    			if(oper == 'I') {
    				maxQ.offer(num);
    				minQ.offer(num);
    				maps.put(num, maps.getOrDefault(num, 0) + 1);
    			}else {
    				if(maps.size() == 0) continue;
    				if(num == -1 && minQ.size()>0) {
    					delete(minQ);

    				}else if(num == 1 && maxQ.size()>0) {
    					delete(maxQ);
    			
    				}
    			}

    		}
    		if(maps.size() == 0) {
    			System.out.println("EMPTY");
    		}else {
    			int max = delete(maxQ);
    			int min = max;
    			if(maps.size() > 0) {
    				min = delete(minQ);
    			}
    			System.out.println(max + " " + min);
    		}
    	}
    			
    }
}

