import java.util.Arrays;
import java.util.PriorityQueue;

// SJF(Shortest Job First) 알고리즘
// 1. 대기 열에 요청시간 순으로 오름차순 정렬한다.
// 2. 현재 시간보다 작은 요청시간을 가진 디스크를 작업 큐에 배치한다. (현재시간은 0 > 첫디스크의 종료시점 > ... )
// 아직 요청시간이 되지도 않았는데 작업을 시작할 수는 없지 않는가?

// 3. 이때 작업시간이 가장 적게 걸리는 디스크부터 작업을 실시한다. 
// 4. 작업이 진행중이라면(작업 큐에 남아있다면), 현재시각은 이전현재시각 + 작업 길이가 된다. 
//    작업이 없으면 , 현재 시각은 현재시각 이후 가장가까운 시작시간으로 설정한다.

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b) -> a[1]-b[1]);
        
        int tot = 0;
        int end = 0;
        int idx = 0;
        int count = 0;
        
        while(count < jobs.length) {
        	
        	while(idx < jobs.length && jobs[idx][0] <= end) {
        		pq.add(jobs[idx++]);
        	}
        	if(pq.isEmpty()) {
        		end = jobs[idx][0];
        	}else {
        		int[] tmp = pq.poll();
        		tot += tmp[1] + end - tmp[0];
        		end += tmp[1];
        		count++;
        	}
        	
        }
        return tot/jobs.length;
    }
}
