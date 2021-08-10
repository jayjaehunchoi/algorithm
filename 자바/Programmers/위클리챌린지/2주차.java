import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
	
  // 학생의 점수 총합을 구하는 재귀
	public static int getScore(List<Integer> aList, int i) {
		
		if(i == aList.size()) {
			return 0;
		}
		
		return aList.get(i) + getScore(aList, i+1);
		
	}
	
  // 학생의 학점을 구하는 메서드
	public static String getGrad(int score) {
		
		if( score >= 90) return "A";
		else if(score >= 80) return "B";
		else if(score >= 70) return "C";
		else if(score >= 50) return "D";
		else return "F";
		
	}
	
	
  public String solution(int[][] scores) {
      String answer = "";
      List<Integer> aList = new ArrayList<>();
      
    // 학생의 점수를 계산해주기 위해 j,i 순으로 반복을 돌렸다.
    // List에 학생별로 점수를 담아준다.
      for(int j = 0 ; j < scores[0].length ; j++) {
        for(int i = 0 ; i < scores.length ; i ++) {
          
          aList.add(scores[i][j]);
       
        }
        // 최저점, 최고점 비교를 위해 collections로 오름차순 배열 해준다
        Collections.sort(aList);
        
        // 본인이 본인에게 준 점수는 i==j 배열에 배치된다.
        //최저이면서 공통된 수 가 없을 때, 지워준다.
        if(aList.get(0) == scores[j][j] && aList.get(1) != scores[j][j] ) {
          aList.remove(0);
        }
        // 최고점이면서 공통수가 없을때, 지워준다.
        else if(aList.get(scores.length-1) == scores[j][j] && aList.get(scores.length-2) != scores[j][j]) {
          aList.remove(scores.length-1);
        }
        // 평균점수를 구해서 학점에 대입한 뒤 문자열에 더해주고 리스트를 초기화시킨다.
        // 그리고 다시 반복.
        answer += getGrad(getScore(aList,0)/aList.size());
        aList.clear();

      }

      return answer;
    }
  
  
}
