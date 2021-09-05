
import java.util.*;

class Main{
	
	// 500 팩토리얼은 답이 엄청난 수가 나오기에;; 규칙을 찾아야함
  // 팩토리얼 과정 중 , 5와 2가 속해있으면 *10이 되기에 0이 하나 있음
  // 10 팩토리얼 에서는 2개 .... 25팩토리얼에서는 6개 (5의 거듭제곱이 있음)가 된다.
  // 이 규칙에 맞게 누적합을 이용해서 계산
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        
        int count = 0;
        while(n >= 5) {
        	count += n/5;
        	n = n/5;
        }
        
        System.out.println(count);
    }
}
