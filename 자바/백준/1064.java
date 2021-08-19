
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Main {
	
	public static double distance (int x, int y , int x1, int y1) {
		
		return Math.sqrt((x1-x)*(x1-x) + (y1-y)*(y1-y));
	}
	
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		
		int x1 = sc.nextInt();
		int y1 = sc.nextInt();
		
		int x2 = sc.nextInt();
		int y2 = sc.nextInt();
		
		int x3 = sc.nextInt();
		int y3 = sc.nextInt();
		
		if((x2-x1)*(y3-y2) == (x3-x2)*(y2-y1)) {
			System.out.println(-1);
			return;
		}
		
		double doole1 = 2*distance(x1, y1, x2, y2);
		double doole2 = 2*distance(x3, y3, x2, y2);
		double doole3 = 2*distance(x1, y1, x3, y3);
		
		double max = Math.max(doole1, Math.max(doole2, doole3));
		double min = Math.min(doole1, Math.min(doole2, doole3));
		
		System.out.println(max - min);
		
	}
}
