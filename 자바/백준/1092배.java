
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

// 생각은 금방떠올랐으나 , 구현에서 문제가 있었던 듯
// que를 이용해서 완벽히 같은 개념으로 풀어냈다고 생각했는데 아니었나보다.
class Main {
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		List<Integer> crains = new ArrayList<Integer>();
		for(int i = 0 ; i < n ; i++) {
			crains.add(sc.nextInt());
		}
		
		int m = sc.nextInt();
		List<Integer> boxes = new ArrayList<Integer>();
		for(int i = 0 ; i < m ; i++) {
			boxes.add(sc.nextInt());
		}
		
		Collections.sort(crains, Collections.reverseOrder());
		Collections.sort(boxes, Collections.reverseOrder());
		
		if(boxes.get(0) > crains.get(0)) {
			System.out.println(-1);
			
		}
		else {
      // 뺄수 있는 최대값을 찾아서 빼주는 것! 반복
			int time = 0;
			 while(boxes.size() != 0){
	                int idx = 0;
	                int tmp = 0;
	                while(idx < n){
	                    if(tmp == boxes.size())
	                        break;
	                    if(boxes.get(tmp) <= crains.get(idx)){
	                        boxes.remove(tmp);
	                        idx++;
	                    }
	                    else if(boxes.get(tmp) > crains.get(idx)){
	                       tmp++;
	                    }
	                }
	                time++;
	            }
	            System.out.println(time);
	        }
		}

}
	

