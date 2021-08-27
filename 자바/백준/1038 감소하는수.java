
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

class Main {
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
    
    // 최대로 감소하는 수, 그 수를 넘어가는 경우, N이 0인 경우를 따로 조건문 처리해줌
		if(N == 1022) {
			System.out.println("9876543210");
			return;
		}
		else if(N>1022) {
			System.out.println(-1);
			return;
		}
		else if(N==0) {
			System.out.println(0);
			return;
		}
		

    Queue<Long> que = new LinkedList<Long>(); 
    List<String> aList = new ArrayList<String>();

    for(long i = 0 ; i <= 9; i++) {
      que.add(i);
    }
    for(int i = 1 ; i <= 9; i++) {
      aList.add(String.valueOf(i));
    }
    while(aList.size() <= N) {

      long val = que.poll();
      long comp = val%10;

      for(long i = 0 ; i < 10; i++) {
        if(comp > i) {
          que.add(val*10 + i);
          aList.add(String.valueOf(val*10 + i));
        }
      }

    }
    System.out.println(aList.get(N-1));

	}

}
	

