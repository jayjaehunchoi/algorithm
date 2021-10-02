import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        
        Arrays.sort(routes, (a,b) -> a[0]-b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        
        // 정렬 후, 첫 경로에서 플러스 , 우선순위 큐에 도착값 add
        // 만약 도착경로가 가장 작다면 앞에 들어감, 이보다 큰 시작값이 있으면 기존 경로 모두 초기화 후 새로운 카메라 지역 탐색
        for(int i = 0 ; i < routes.length; i++) {
        	if(pq.isEmpty()) {
            	pq.add(routes[i][1]);
            	answer ++;
            }else {
            	if(pq.peek() >= routes[i][0]) {
            		pq.add(routes[i][1]);
            	}else {
            		pq.clear();
            		answer++;
            		pq.add(routes[i][1]);
            		
            	}
            }
        }
        
        return answer;
    }
}
