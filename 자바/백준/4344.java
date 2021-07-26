import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.MalformedParameterizedTypeException;
import java.util.Scanner;
import java.util.StringTokenizer;

import javax.annotation.processing.RoundEnvironment;

public class Baekjun {

	 

	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int C = sc.nextInt();
		StringTokenizer st;
		
		for (int i = 0; i < C; i++) {
			
			int sum = 0;
			st = new StringTokenizer(br.readLine()," ");
			int n = Integer.parseInt(st.nextToken());
			int[] arr = new int[n];
			double BiggerThanAvg = 0;
			
			for(int j = 0 ; j < n; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			
			for (int k = 0; k < n; k++) {
				sum += arr[k];	
			}
			
			double average = sum/n;
			
			for (int m = 0 ; m < n; m++) {
				if(arr[m] > average) {
					BiggerThanAvg += 1;
				}
			}
			double div = BiggerThanAvg/n;
			System.out.println(String.format("%.3f", (div*100))+"%");
		}	
  }
}
