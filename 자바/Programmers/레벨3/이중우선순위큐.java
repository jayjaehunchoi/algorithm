import java.util.PriorityQueue;
import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        int max = 0;

        // PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        List<Integer> aList = new ArrayList<>();
        for(int i = 0 ; i < operations.length; i++){
            if(operations[i].charAt(0) == 'D' && operations[i].charAt(2) == '-'){
                if(!aList.isEmpty()){
                    aList.remove(0);
                }
                
            }else if (operations[i].charAt(0) == 'D'){
                if(!aList.isEmpty()){
                    aList.remove(aList.size()-1);
                    
                }
            }else{
               String s = operations[i].substring(2,operations[i].length());
               int val = Integer.parseInt(s);
                aList.add(val);
                Collections.sort(aList);
            }
            
        }
        if(aList.size() == 0){
            return new int[] {0,0};
        }
        answer[1] = aList.get(0);
        answer[0] = aList.get(aList.size()-1);
        
        return answer;
    }
}
