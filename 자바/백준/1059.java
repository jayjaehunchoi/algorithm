
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Main {
	
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		
		int s = sc.nextInt();
		
		int [] nums = new int[s];
		
		for(int i = 0 ; i < s ;i++) {
			nums[i] = sc.nextInt();
		}
		
		int n = sc.nextInt();
		
		Arrays.sort(nums);
		
		int minM = 0;
		int maxM = 0;
		
		for(int i = 0 ; i < nums.length; i++) {
			if(nums[i] < n) {
				minM = nums[i]+1;
			}
			else if(nums[i] > n) {
				maxM = nums[i]-1;
				break;
			}else if(nums[i] == n) {
				System.out.println(0);
				return;
			}
		}
		// 이경우가 있을 줄이야 ;;
		if(minM == 0) {
			minM = 1;
		}
		
		int count = 0;
		for(int i = minM ; i <= n; i++) {
			for(int j = n ; j <= maxM ; j++) {
				if(i == j) {
					continue;
				}
				count++;
			}
		}
		System.out.println(count);

	}
}
