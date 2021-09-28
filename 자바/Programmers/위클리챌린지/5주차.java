class Solution {
    public int solution(String word) {
        int answer = 0;
        
        char[] words = word.toCharArray();
        int[] val = {780,155,30,5,0};
        
        for(int i = 0 ; i < words.length; i++){
            int n = 0;
            switch(words[i]){
                case 'A':
                    n = 0;
                    break;
                case 'E':
                    n = 1;
                    break;
                case 'I':
                    n = 2;
                    break;
                case 'O':
                    n = 3;
                    break;
                case 'U':
                    n = 4;
                    break;
            }
            answer += val[i]*n+(n+1);
        }
        
        return answer;
    }
}
