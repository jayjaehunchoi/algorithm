class Solution {
    public boolean solution(String[] phone_book) {
       
        
        for(String phoneNum : phone_book) {
        	
        	HashMap<String, Integer> hMap = new HashMap<String, Integer>();
        	hMap.put(phoneNum, 0);
        	
        	for(int i = 0; i < phone_book.length; i++) {
        		
        		if(phoneNum != phone_book[i]) {
        			
	        		if(phoneNum.length() <= phone_book[i].length()) {
	        			
	        			String str = phone_book[i].substring(0,phoneNum.length());
	        			
	        			if(!hMap.containsKey(str)) {
	        				hMap.put(str, 0);
	        			}
	        			
	        			else {
	        				hMap.replace(str, 1);
	        			}
	        			
	        		}
        		}
        		if(hMap.get(phoneNum) == 1) {
        			return false;
        		}
        	
        	}
        	
        }

        return true;
    }
}

/*
효율이 너무 떨어진다,
반복문을 줄이기 위해 sort하고  똑같은 로직으로 돌리면 runtime에러가뜬다.
일단 패스..
정확도 allpass 효율 2개 fail
*/
