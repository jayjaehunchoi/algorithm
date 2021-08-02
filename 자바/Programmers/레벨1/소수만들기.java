class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        for(int i = 0 ; i < nums.length-2; i++) {
        	
        	int sum = 0;
        	int count = 0;
        	
          // 모든 경우의수 (3) 의 합.
        	for(int j = i+1; j < nums.length-1; j++) {
        		
        		for(int k = j+1; k < nums.length; k++) {
        			
        			sum = nums[i] + nums[j] + nums[k];
        		
              // 약수인지 아닌지 알아보기	
        			boolean[] sosu = new boolean[sum+1];
        			sosu[0] = sosu[1] = true;
        			
        			for(int num = 2; num*num <= sum; num++) {
        				
        				if(sosu[num] == false) {
        					
        					for(int number = num*num ; number <= sum; number+= num) {
        						sosu[number] = true;
        					}
        				}
        			}
        			if(sosu[sosu.length-1] == false) {
        				answer++;
        			}
        		}
        	}
        }

        return answer;
    }
}
