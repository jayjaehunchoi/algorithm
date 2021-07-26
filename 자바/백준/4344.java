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

/*
너무 코드를 복잡하고 길게 짠 것 같다.. 하지만 출력값은 잘 나오고.. 시간도 나름 빠름..

나누기해서 소수점 나오려면 애초에 나누는 수 중 하나는 double 형이여야 한다.

반올림하는 방법 String 클래스에 format 메소드 (반올림 어떻게 할지, 반올림할 수. ex ) String.format("%.3f",pie)
*/
