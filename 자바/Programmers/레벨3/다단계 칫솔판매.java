import java.util.HashMap;
import java.util.Map;

class Solution {
//	public static void main(String[] args) {
//		Solution s = new Solution();
//		String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
//		String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
//		String[] seller = {"young", "john", "tod", "emily", "mary"};
//		int[] amount = {12, 4, 2, 5, 10}; 
//		s.solution(enroll, referral, seller, amount);
//	}
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        
        Map<String, String> parentMem = new HashMap<String, String>();
        Map<String, Integer> money = new HashMap<String, Integer>();
        
        for(int i = 0 ; i < enroll.length ; i++) {
        	String member = enroll[i];
        	String par = referral[i];
        	if(par.equals("-")) {
        		par = "center";
        	}
        	parentMem.put(member,par);
        	money.put(member, 0);
        }
        
        
    	for(int i = 0 ; i < seller.length; i++) {
    		String memb = seller[i];
    		int mon = amount[i]*100;
    		int k = (int) (mon * 0.1);
    		money.put(memb, money.getOrDefault(memb, 0) + mon-k);
    		while(true) {
        		mon = k;
        		if(mon == 0) {
        			break;
        		}
        		k = (int) (mon * 0.1);
        		memb = parentMem.get(memb);
        		money.put(memb,money.getOrDefault(memb, 0) + mon-k);
        		
        		if(memb.equals("center")) {
        			break;
        		}
    		}
    		
    	}
    	
    	for(int i = 0 ; i < enroll.length; i++) {
    		answer[i] = money.get(enroll[i]);
    	}
        
        return answer;
    }
}
