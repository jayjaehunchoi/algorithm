import java.awt.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Baekjun {
	

	
	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = sc.nextInt();
		int M = sc.nextInt();			
		ArrayList<Integer> cardList = new ArrayList<Integer>();
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		for (int i = 0; i < N ; i++) {
			cardList.add(Integer.parseInt(st.nextToken()));
		}
		
		ArrayList<Integer> sumList = new ArrayList<Integer>();
		for (int i = 0 ; i < cardList.size()-2 ; i++) {
			int sum = 0;
			
			for(int j = i+1; j < cardList.size()-1; j++) {
				
				for(int k = j+1; k < cardList.size(); k++) {
					sum = cardList.get(i)+cardList.get(j)+cardList.get(k);
					if(sum <= M) {
						sumList.add(sum);
					}
				}
			}
		}
		Collections.sort(sumList,Collections.reverseOrder());;
		System.out.println(sumList.get(0));
	}
		
  }
