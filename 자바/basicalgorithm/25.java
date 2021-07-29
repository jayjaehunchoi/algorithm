import java.util.HashMap;

class Solution {
    public String solution(int a, int b) {
        String answer = "";
        
        HashMap<Integer, Integer> monthlyDays = new HashMap<Integer, Integer>();
        
      //날짜를 더해줘야 하기때문에 각 월별 날짜를 확인
        monthlyDays.put(1, 31);
        monthlyDays.put(2, 29);
        monthlyDays.put(3, 31);
        monthlyDays.put(4, 30);
        monthlyDays.put(5, 31);
        monthlyDays.put(6, 30);
        monthlyDays.put(7, 31);
        monthlyDays.put(8, 31);
        monthlyDays.put(9, 30);
        monthlyDays.put(10, 31);
        monthlyDays.put(11, 30);
        monthlyDays.put(12, 31);
        
      // 기준이 1월 1일 금요일이기때문에 금요일부터 시작
        String[] weekDays = {"FRI","SAT","SUN","MON","TUE","WED","THU"};
        int periodBetween = 0;
        int pickDay = 0;
        
        
        for(int i = 1 ; i < a ; i++) {
        	periodBetween += monthlyDays.get(i);
        }
        periodBetween += b;
       
      // 1일 부터 시작이라 if 29일 이면 금요일인데 7로 나눴을 때 나머지는 1 하지만 0을 출력해야함, 따라서 출력시 -1값 해줌
      // 그럼 나머지가 0일때에는 7로 변경해서 6번째를 출력해줌.
        pickDay = periodBetween % 7;
        if(pickDay == 0) {
        	pickDay = 7;
        }
        answer = weekDays[pickDay-1];
        
        
        return answer;
    }
}
