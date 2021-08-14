import java.util.ArrayList;
import java.util.List;

class Solution {

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
		
		
        char[] expChar = expression.toCharArray();
        
        List<Long> numList = new ArrayList<>();
        List<Long> numList2 = new ArrayList<>();
        List<Character> operList = new ArrayList<>();
        List<Character> operList2 = new ArrayList<>();
        List<Character> useBackTrack = new ArrayList<>();
       
        // 숫자열과 부등호 모든걸로 바꿔줌.
        String n = "";
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
        
        
        // 백트래킹 요소 다 구함.
        for(int i = 0 ; i < operList.size() ; i++) {
        	if(!useBackTrack.contains(operList.get(i))) {
        		useBackTrack.add(operList.get(i));
        	}
        }
        opersOrder = new char[useBackTrack.size()];
		check = new boolean[useBackTrack.size()];
		
        backTracking(useBackTrack, 0);
        
        Long hap = 0l;
        System.out.println(allOper);
        for(int i = 0 ; i < allOper.size() ; i++) {
        	for(int j = 0 ; j < allOper.get(i).length() ; j++) {
        		for(int k = 0 ; k < operList.size() ; k++) {
        			if(allOper.get(i).charAt(j) == operList.get(k)) {
        				switch (operList.get(k)) {
						case '*':
							hap += numList.get(k) * numList.get(k+1);
							
							numList.add(k, hap);
							hap = 0l;
							numList.remove(k+2);
							numList.remove(k+1);
							operList.remove(k);
							System.out.println(numList);
							k--;
							
							break;
							
						case '+':
							hap += numList.get(k) + numList.get(k+1);
							numList.add(k, hap);
							hap = 0l;
							numList.remove(k+2);
							numList.remove(k+1);
							operList.remove(k);
							System.out.println(numList);
							k--;
							
							break;
							
						case '-':
							hap += numList.get(k) - numList.get(k+1);
							numList.add(k, hap);
							hap = 0l;
							numList.remove(k+2);
							numList.remove(k+1);
							operList.remove(k);
							System.out.println(numList);
							k--;
							
							break;

						}
        			}
        		}

        	}
        	
        	answer = Math.max(answer, Math.abs(numList.get(0)));
        	numList.clear();
        	operList.clear();

        	numList.addAll(numList2);
        	operList.addAll(operList2);

        }
        
        return answer;
    }
}
