import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

class Main {
	
	
	static char[] makeWord ;
	static int count = 0;
	static String word = "";
  
  // 조합..
	public static void comb(char[] arr, boolean[] check, int index, int starter, int target) {
		
		if(starter == target) {
			for(int i = 0 ; i < makeWord.length ; i++) {
				if(makeWord[i] != 'a' && makeWord[i] != 'e' && makeWord[i] != 'i' && makeWord[i] != 'o' && makeWord[i] != 'u' ) {
					count++;
				}
				word += makeWord[i];
			}
			if(count < 2 || count > makeWord.length-1) {
				count = 0 ;
				word = "";
				return;
			}
			System.out.println(word);
			word = "";
			count = 0;
			return;
		}
		
		for(int i = index ; i < arr.length; i++) {
			if(!check[i]) {
				makeWord[starter] = arr[i];
				check[i] = true;
				comb(arr, check, i , starter+1, target);
				check[i] = false;
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		
		int l = sc.nextInt();
		int c = sc.nextInt();
		
		char[] arr = new char[c];
		boolean[] check = new boolean[c];
		makeWord = new char[l];
		
			
		for(int i = 0 ; i < c ; i++) {
			arr[i] = sc.next().charAt(0);
		}
		Arrays.sort(arr);
		comb(arr, check, 0, 0, l);
		
		
	}
}
