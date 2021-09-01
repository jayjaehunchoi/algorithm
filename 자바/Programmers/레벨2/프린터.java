import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        Queue<Integer> que = new LinkedList<Integer>();
        
        for(int e : priorities) {
        	que.add(e);
        }
        
      // 여기부터 본격적인 프린터 계산식
        while(que.size() != 0) {
        	// 이터레이터는 한바퀴 돌때마다 재생성 해준다.
          Iterator<Integer> ir = que.iterator();
        
          // 다음에 자기보다 큰게 있으면 바로 제외후 맨뒤로
          // 이때 맨뒤로 보내면 바로 break (for문을 다 돈 값과, 중간에 큰게 있어서 나온애들 구분하기 위해.
          // 로케이션이 0아래로 가면 다시 큐 크기-1
        	for(int i = 0 ; i < que.size(); i++) {
        		if(ir.hasNext() && que.peek() < ir.next()) {
        			que.offer(que.poll());
        			location --;
        			if (location < 0) location = que.size()-1;
        			break;
        		}
        		
        	}
          
          // for문을 문제없이 다돌면 뒤에 남은값이 없음
          // 이때 location이 0이면 정답 출력
          // 아니면 answer만 더하고, 제거, 로케이션 감소 시킨다.
        	if(location == 0 && !ir.hasNext()) {
        		answer++;
        		return answer;
        	}
        	else if(!ir.hasNext()){
            que.poll();
            answer++;
            location--;
        	}
        	
        }
        
        return answer;
    }
}

// 시간이 지나서 풀어보니 전혀 다른 풀이..
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Integer> que = new LinkedList<>();
        int max = 0;
        for(int i : priorities){
            que.add(i);
        }
        Arrays.sort(priorities);
        
        int i = priorities.length-1;
        while(true){
            max = priorities[i];
            if(location == 0 && max == que.peek()){
                return answer+1;
            }
            
            if(que.peek() == max){
                que.poll();
                answer++;
                location--;
                i--;
                    
            }else if(que.peek() != max){
                que.add(que.poll());
                location--;
            }
            if(location <0){
                location = que.size()-1;
            }
        }

    }
}
