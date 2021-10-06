import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 10초도 통과시켜주는 프로그래머스 ㅎㅋ
// + 생각 해보니 end지점들로부터 +1초씩만 해도 똑같이 결과가 나올 것 같아 해보니 end로 부터 1초도 가능하다.
// 시간도 최대 6초까지 줄었다.
class Log implements Comparable<Log>{
	double start;
	double end;
	
	public Log(double start, double end) {
		this.start = start;
		this.end = end;
	}
	
	public int compareTo(Log o) {
		int res;
		if(this.start < o.start)res = -1;
		else if(this.start == o.start) res = 0;
		else res = 1;
		return res;
	}
}
class Solution {
    public int solution(String[] lines) {
        int answer = 0;
        List<Log> aList = makeLogs(lines);
        
        for(int i = 0 ; i < aList.size(); i++) {
        	answer = Math.max(answer,findMaxEnd(aList, i));
        }
        return answer;
    }
    // 로그 제작 (시간, 분 )
    public List<Log> makeLogs(String[] lines){
    	int time = Integer.parseInt(lines[0].substring(11,13))*3600+Integer.parseInt(lines[0].substring(14,16))*60;
    	List<Log> aList = new ArrayList<Log>();
    	for(int i = 0 ; i < lines.length ;i++) {
    		String[] logs = lines[i].split(" ");
    		
    		double end = (Integer.parseInt(logs[1].substring(0,2))*3600 + Integer.parseInt(logs[1].substring(3,5))*60 + Double.parseDouble(logs[1].substring(6,12))) - time;
    		int j = 0;
    		String sec = "";
    		while(logs[2].charAt(j) != 's') {
    			sec += logs[2].charAt(j);
    			j++;
    		}
    		
    		double start = end - Double.parseDouble(sec);
    		aList.add(new Log(start+0.001, end));
    	}
    	Collections.sort(aList);
    	return aList;
    }

  // end지점으로부터 1
    public int findMaxEnd(List<Log> aList, int idx) {
    	double start = formatter(aList.get(idx).end);
    	double end = formatter(start+0.999);
    	int cnt = 0;
    	for(int i = 0 ; i < aList.size();i++) {
    		Log l = aList.get(i);
    		double s = formatter(l.start);
    		double e = formatter(l.end);
    		if(start > end)continue;
    		if(end < s) {
    			return cnt;
    		}
    		if(s >= start && s <= end) {
    			cnt++;
    		}else if(e  >= start && e <= end) {
    			cnt++;
    		}else if(s< start && e > end) {
    			cnt++;
    		}
    	}
    	return cnt;
    }
    
  // 반올림 항상 소수점 3의자리까지 유자
    public double formatter(double num) {
    	return Double.parseDouble(String.format("%.3f", num));
    }
}
