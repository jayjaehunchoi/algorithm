import java.util.ArrayList;

class Solution {
    public int[] solution(int[] answers) {
        
        //찍는 답에 반복되는 규칙성이 있다.
        // 반복과 정답 개수에 맞춰서 계산해주면 좋다.
        int [] pick1 = {1, 2, 3, 4, 5};
        int [] pick2 = {2, 1, 2, 3, 2, 4, 2, 5, 2};
        int[] pick3 = {3,3,1,1,2,2,4,4,5,5};
        
        // 정답 개수 세는 용      
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        
        //정답과 동일할 시 각 count 변수를 1씩 증가 시킨다.
        // 정답의 개수가 5개, 8개 ,10개 이상일 때, i로 개수를 잡으면 에러가 뜬다.
        // 이를 해결하기 위해 정답찍기의 반복만큼 나눠서 나머지로 계산해준다.
        for(int i = 0 ; i < answers.length; i++) {
        	if(answers[i] == pick1[i%5]) {
        		count1++;
        	}
        	
        	if(answers[i] == pick2[i%8]) {
        		count2++;
        	}
        	
        	if(answers[i] == pick3[i%10]) {
        		count3++;
        	}
        }
        
        // 최대값을 찾는 가장 간단한 방법.
        // 처음에는 선택정렬을 해서 테스트 케이스 몇개는 정답이 맞지 않았었다.
        int maxNum = Math.max(Math.max(count1,count2), count3);
        ArrayList<Integer> answerList = new ArrayList<Integer>();
        
        if(maxNum == count1) {
        	answerList.add(1);
        }
        if(maxNum == count2) {
        	answerList.add(2);
        }
        if(maxNum == count3) {
        	answerList.add(3);
        }
      
        // 모두 0개를 맞췄을때는, 어쨌든 점수가 같으니 1,2,3을 출력해준다.
        if(answerList.isEmpty()) {
        	return new int [] {1,2,3};
        }
        
        int[] answer = new int[answerList.size()];
        for(int i = 0; i < answerList.size(); i++) {
        	answer[i] = answerList.get(i);
        }
        
        return answer;
    }
}

/*
항상 쓰던 알고리즘만 쓰는 내가 얼마나 잘못 공부하고 있는지 알게해준 문제.
*/
