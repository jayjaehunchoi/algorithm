import java.util.Scanner;

public class Main {
  
  // 재귀로 팩토리얼 구해준다.
	public static int factorial( int k ) {
		
		if(k==0) {
			return 1;
		}
		
		return k * factorial(k-1);
	}

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
        String n = "";
        
    // 0일때까지만 반복문 돌려준다.
        while(!n.equals("0")) {
        	int answer = 0;
        	n= sc.next();
        	
        	char[] nArr = n.toCharArray();
        	
          // 0번 인덱스일때, nArr.length 팩토리얼을 구하는 방법.
        	for(int i = 1 ; i <= nArr.length ; i++) {
        		answer += Integer.parseInt(String.valueOf(nArr[i-1]))*factorial(nArr.length -(i-1));
        		
        	}
          //0이면 출력안하고 끝낸다. 
          //n 뒤에다 조건걸어도 됐을지도?
        	if(answer == 0) {
        		break;
        	}
        	System.out.println(answer);
        }
	
	}
}
