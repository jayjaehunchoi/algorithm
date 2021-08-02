import java.util.ArrayList;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        ArrayList<Integer> pocketMon = new ArrayList<Integer>();
        
        for(int i = 0 ; i < nums.length; i++) {
        	if(!pocketMon.contains(nums[i])) {
        		if(pocketMon.size() < nums.length/2) {
        			pocketMon.add(nums[i]);
        		}
        	}
        }
        if(pocketMon.size() > nums.length/2) {
        	return pocketMon.size();
        }

        return pocketMon.size();
    }
}

/*
그냥 제한수까지 중복되지않게 담으면됨. 딱히 필요없는 코드도 작성한 것 같다.
*/
