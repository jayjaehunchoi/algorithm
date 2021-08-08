import java.util.ArrayList;
import java.util.List;

class Solution {
	
  // 전역 변수 선언
  // 이것때문에 엄청 고생함. 재정의 꼭 해줘야함, 특히 length나 num처럼 개수 변화있는 것
	static int length;
	static boolean[] check;
	static String[] num;
	static List<Integer> numList = new ArrayList<Integer>();
	
  // 백트래킹해서, 리스트에 없는 수이면 모두 추가 
	public static void backTracking(String[] number, int k) {
		String nums = ""; 
		if(k == length) {
			for(String a : num) {
				nums += a;
			}
			
			if(!numList.contains(Integer.parseInt(nums))) {
				numList.add(Integer.parseInt(nums));
			}
			return;
		}
		
    // 전체 숫자 개수만큼 for문이 돌아가야함.
    // 불리안도 전체 숫자개수와 동일하게
    // num은 원하고자 하는 자릿수값
		for(int i = 0 ; i < number.length; i++) {
			if(!check[i]) {
				
				num[k] = number[i];
				check[i] = true;
				backTracking(number, k+1);
				check[i] = false;
				
			}
		}
		
	}
	
    public int solution(String numbers) {
    	int answer = 0;
        
        String[] number = new String[numbers.length()];
        for(int i = 0 ; i < numbers.length(); i++) {
        	number[i] = numbers.substring(i,i+1);
        	
        }
        
      // 재정의
        length = 1;
        check = new boolean [number.length];
        num = new String[length];
        
        //  반복문 통해서 0~ numbers.length개 까지의 모든 경우의 수 찾기
        while (length <= numbers.length()) {
        	
        	backTracking(number, 0);
        	length++;
        	num = new String[length];
        }
        
       // 에라토스의 체였나 암튼 그거 사용
        for(int i = 0 ; i < numList.size() ; i++) {
        	boolean[] tF = new boolean[numList.get(i)+1];
        	
        	if(numList.get(i)>=2) {
        		tF[0] = tF[1] = true;
            	
            	for(int j = 2; j*j <= numList.get(i); j++) {
            		if(!tF[j]) {
            			for(int k = j*j; k <= numList.get(i); k = k+j) {
            				tF[k] = true;
            			}
            		}
            	}
            	
            	if(!tF[numList.get(i)]) {            		
            		answer++;
            	}
        	}

        }

        return answer;
    }
}
