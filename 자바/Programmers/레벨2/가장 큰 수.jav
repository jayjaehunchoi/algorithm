import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String solution(int[] numbers) {
    	
    	String answer = "";
    	String[] number = new String[numbers.length];
    	
    	// Integer -> String 배열
    	for(int i = 0 ; i < numbers.length ; i++ ) {
    		number[i] = String.valueOf(numbers[i]);
    	}
    	
      // 정렬을 number[1]+number[2] 와 number[2]+number[1] 비교해서 -가 나오게끔 처리
      // sgn(x,y) = must ensure -sgn(y,x); 즉 역순으로 적으면 내림차순이다 -라 이 말씀
     	Arrays.sort(number,new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return (o2+o1).compareTo(o1+o2);
			}
		});
    	
    	if(number[0].equals("0")) {
    		return "0";
    	}
    	
    	for(String a : number) {
    		answer += a;
    	}
    	
        return answer;
    }
}
