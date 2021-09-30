import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int[] solution(int[] weights, String[] head2head) {
        int[] answer = new int[weights.length];
        
        double[][] rate = winningRate(head2head, weights);
        Arrays.sort(rate, new Comparator<double[]>() {

			@Override
			public int compare(double[] arg0, double[] arg1) {
				int res = 0;
				if(arg1[0] - arg0[0] < 0)res = -1;
				else if(arg1[0] - arg0[0] > 0)res = 1;
				else {
					if(arg1[1] - arg0[1] < 0)res = -1;
					else if(arg1[1] - arg0[1] > 0)res = 1;
					else {
						if(arg1[2] - arg0[2] < 0)res = -1;
						else if(arg1[2] - arg0[2] > 0)res = 1;
						else {
							if(arg0[3] - arg1[3] < 0)res = -1;
							else if(arg0[3] - arg1[3] > 0)res = 1;
							else res = 0;
						}
					}
					
				}

				return res;
			}
		});
        
        for(int i = 0 ; i < rate.length; i++) {
        	answer[i] = (int) rate[i][3];
        }
        
        return answer;
    }
    
    public double[][] winningRate(String[] head2head, int[] weights) {
    	double[][] rate = new double[head2head.length][4];
    	
    	for(int i = 0 ; i < weights.length; i++) {
    		double tot = 0;
    		int cnt = 0;
    		int wCnt = 0;
    		
    		for(int j = 0 ; j < weights.length; j++) {
    			if(head2head[i].charAt(j) == 'W') {
    				if(weights[i] < weights[j]) {
    					cnt++;
    				}
    				wCnt++;
    				tot++;
    			}else if(head2head[i].charAt(j) == 'L') {
    				tot++;
    			}
    		}
    		if(tot == 0) {
    			rate[i][0] = 0;
    		}else {
    			rate[i][0] = wCnt*100/tot;
    		}
    		rate[i][1] = cnt;
    		rate[i][2] = weights[i];
    		rate[i][3] = i+1;
    		System.out.println(i);
    		System.out.println(rate[i][0]);
    		System.out.println(rate[i][1]);
    		System.out.println(rate[i][2]);
    	
    	}
    	return rate;
    	
    	
    	
    }
}
