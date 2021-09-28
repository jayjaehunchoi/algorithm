import java.util.Arrays;

class Solution {

    public int solution(int[][] sizes) {
        for(int i = 0 ; i < sizes.length ;i++) {
        	if(sizes[i][0] <= sizes[i][1]) {
        		swap(sizes, i);
        	}
        }
        int[] arrS = new int[sizes.length];
        int[] arrG = new int[sizes.length];
        for(int i = 0 ; i < sizes.length; i++) {
        	arrS[i] = sizes[i][0];
        	arrG[i] = sizes[i][1];
        	
        }
        Arrays.sort(arrS);
        Arrays.sort(arrG);
        return arrS[sizes.length-1] * arrG[sizes.length-1] ;
    }
    
    
    public void swap(int[][] sizes,int idx) {
    	int tmp = sizes[idx][0];
    	sizes[idx][0] = sizes[idx][1];
    	sizes[idx][1] = tmp;
    	
    }
    
 
}
