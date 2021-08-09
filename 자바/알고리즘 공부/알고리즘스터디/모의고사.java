import java.util.ArrayList;


class Solution {
    public ArrayList solution(int[] answers) {
        ArrayList<Integer> aList = new ArrayList<Integer>();
        
        int[] supo1 = {1,2,3,4,5};
        int[] supo2 = {2,1,2,3,2,4,2,5};
        int[] supo3 = {3,3,1,1,2,2,4,4,5,5};
        
        int a = 0;
        int b = 0;
        int c = 0;

        for(int i = 0 ; i < answers.length; i++) {
        	if(answers[i] == supo1[i%5]) {
        		a++;
        	}
        	if(answers[i] == supo2[i%8]) {
        		b++;
        	}
        	if(answers[i] == supo3[i%10]) {
        		c++;
        	}
        }
        
        int max = Math.max(a, Math.max(b, c));
        if(max == a) aList.add(1);
        if(max == b) aList.add(2);
        if(max == c) aList.add(3);
      
       
        
        return aList;
    }
}
