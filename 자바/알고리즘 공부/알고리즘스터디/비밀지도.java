class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        
        for(int i = 0 ; i < n ; i ++) {
          //자릿수 맞춰주고 바로 #, " "으로 변환
        	answer[i] = String.format("%"+n+"s",(Integer.toBinaryString(arr1[i]|arr2[i]))); // 둘중 하나만 1이여도 1로 작성된다는뜻임
        	answer[i] = answer[i].replaceAll("[1]", "#");
        	answer[i] = answer[i].replaceAll("[0]", " ");
        }

        
        return answer;
    }
}
