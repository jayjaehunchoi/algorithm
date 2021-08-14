import java.util.ArrayList;
import java.util.List;

class Solution {
	
	// 연산자의 모든 경우의 수를 찾아준다.
	static List<String> allOper = new ArrayList<>();
	static char[] opersOrder;
	static boolean[] check ;
	public static void backTracking(List<Character> useBackTrack, int k) {

		if( k == check.length ) {

			allOper.add(new String(opersOrder));	
			return;
		}


		for (int i = 0 ; i < useBackTrack.size(); i++) {
			if(!check[i]) {

				opersOrder[k] = useBackTrack.get(i);
				check[i] = true;
				backTracking(useBackTrack, k+1);
				check[i] = false;
			}
		}
		
	}
	
    public long solution(String expression) {

	long answer = 0;
		
	// 문자열을 숫자와 연산자로 구분하고, 이후 반복연산을위해 동일한 리스트를 하나 더 생성한다.	
        char[] expChar = expression.toCharArray();
        
        List<Long> numList = new ArrayList<>();
        List<Long> numList2 = new ArrayList<>();
	    
	// 연산자 순서대로 배치
        List<Character> operList = new ArrayList<>();
        List<Character> operList2 = new ArrayList<>();
	    
	// 실제로 사용된 연산자(중복 x)
        List<Character> useBackTrack = new ArrayList<>();
       
        
        String n = "";
	// 연산자가 나오면 지금까지의 합은 Long으로 변환하여 리스트에 담는다.
	// 다만 마지막 숫자는 뒤에 연산자가 없기때문에 꼭 조건문을 걸어줘야한다.
	    
        for(int i = 0 ; i < expChar.length ; i++) {
        	if(expChar[i] == 42 || expChar[i] == 43 || expChar[i] == 45) {
        		numList.add(Long.parseLong(n));
        		numList2.add(Long.parseLong(n));
        		operList.add(expChar[i]);
        		operList2.add(expChar[i]);
        		n = "";	
        		
        	}else {
        		n+= expChar[i];
        		if(i == expChar.length-1) {
        			numList.add(Long.parseLong(n));
        			numList2.add(Long.parseLong(n));
        		}
        	}
        }
        
        
        // 연산자 순서가 배치될 수 있는 모든 경우의 수를 찾는다
        for(int i = 0 ; i < operList.size() ; i++) {
        	if(!useBackTrack.contains(operList.get(i))) {
        		useBackTrack.add(operList.get(i));
        	}
        }
        opersOrder = new char[useBackTrack.size()];
	check = new boolean[useBackTrack.size()];
		
        backTracking(useBackTrack, 0);
        
	    
	//모든 경우의 수를 찾고, 3중for문을 돌려 , 
	//전체 경우의수 > 경우의 수 중 하나의 연산자 순서 > 실제 입력된 연산자 순서로 계산한다.
        Long hap = 0l;
        System.out.println(allOper);
        for(int i = 0 ; i < allOper.size() ; i++) {
        	for(int j = 0 ; j < allOper.get(i).length() ; j++) {
        		for(int k = 0 ; k < operList.size() ; k++) {
				//switch case를 사용하여 값을 구해주고, 구한값을 해당 위치에 추가한뒤 이후 기존 객체들을 제거한다
				// 이 때 리스트의 index가 하나 줄었으니, 꼭 --를 해줘야한다.
        			if(allOper.get(i).charAt(j) == operList.get(k)) {
        				switch (operList.get(k)) {
						case '*':
							hap = numList.get(k) * numList.get(k+1);
							
							numList.add(k, hap);
							numList.remove(k+2);
							numList.remove(k+1);
							operList.remove(k);
							k--;
							break;
							
						case '+':
							hap = numList.get(k) + numList.get(k+1);
							numList.add(k, hap);
							numList.remove(k+2);
							numList.remove(k+1);
							operList.remove(k);
							k--;
							
							break;
							
						case '-':
							hap = numList.get(k) - numList.get(k+1);
							numList.add(k, hap);
							numList.remove(k+2);
							numList.remove(k+1);
							operList.remove(k);
							k--;
							
							break;

						}
        			}
        		}

        	}
        	//배열의 0 번위치에 온것이 최종합, 최종합의 절대값과 기존값을 비교하며 답을 구한다.
        	answer = Math.max(answer, Math.abs(numList.get(0)));
		
		// 기존 배열을 모두 없애고 복제했던 배열을 추가해준다.
        	numList.clear();
        	operList.clear();

        	numList.addAll(numList2);
        	operList.addAll(operList2);

        }
        
        return answer;
    }
}
