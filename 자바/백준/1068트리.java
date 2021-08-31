import java.lang.*;
import java.util.*;

// 예외적으로 고려할 사항이 많았던 문제 ;;

class Main{
	
  // 트리가 1자일때 포함한 개수세기
	public static int count(int[][] tree, int ln) {
		int count = 0;
		int count2 = 0;
		int count1 = 0;
		int node = 0;
		for(int i = 0 ; i < tree.length; i++) {
			if(tree[ln][i] == 2) {
				count++;
				count2++;
			}else if(tree[ln][i] == 1) {
				count--;
				count1++;
				node = i;
			}
		}
		if(count2 == 1 && count1 == 1) {
			for(int i = 0 ; i < tree.length ; i++) {
				if(tree[node][i] == 1) {
					return 0;
				}
			}
			return 1;
		}
		
		if(count == 1) {
			return 1;
		}else {
			return 0;
		}
	}
	
	// 삭제노드 자식까지 싹다 삭제
	public static void dfs(int[][] tree,int del) {
		
		for(int i = 0 ; i < tree[del].length; i++) {
			if(tree[del][i] == 1) {
				tree[del][i] = 0;
				dfs(tree, i);
			}else if(tree[del][i] == 2) {
				tree[del][i] = 0;
			}
		}
	}
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int[][] tree = new int[n][n];
        int start = 0;
        
        for(int i = 0 ; i < n ; i++){
            int x = sc.nextInt();
            if(x == -1) {
                start = i;
            }
            else{
                tree[x][i] = 1;
                tree[i][x] = 2;
            }    
        }
        int del = sc.nextInt();
        dfs(tree, del);
        int answer = 0;
        for(int i = 0 ; i < n ; i++) {
        	answer += count(tree, i);
        }
        int cnt = 0;
      // 루트노드 값만 남았을 때 답 +1해주기
        if(answer == 0) {
        	for(int i = 0 ; i < n; i++) {
            	for(int j = 0 ; j < n ; j++) {
            		if(tree[i][j] == 1) {
            			cnt++;
            		}
            	}
            }
        }
        if(cnt == 1) {
        	answer++;
        }
        System.out.println(answer);

    }
}
