import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;


class Main {
	static int[][] dp;
  
  // 최대값일 때 단어 찾기
  // 맨끝에서부터 -- 해가면서 똑같은 값이면 두 인덱스 모두 --
  // 위에서 끌어온 값이면 해당 인덱스로 이동 (idx1--)
  // 왼쪽에서 끌어온 값이면 해당 인덱스로 이동(idx2--)
	public static String findWord(String a1, String a2) {
		
		int idx1 = a1.length();
		int idx2 = a2.length();
		StringBuilder sb = new StringBuilder();
		while(idx1 > 0 && idx2 > 0) {
			if(a1.charAt(idx1-1) == a2.charAt(idx2-1)) {
				sb.append(a1.charAt(idx1-1));
				idx1--;
				idx2--;
			}else if(dp[idx1][idx2] == dp[idx1-1][idx2]) {
				idx1--;
			}else if(dp[idx1][idx2] == dp[idx1][idx2-1]) {
				idx2--;
			}
		}
		
		return sb.reverse().toString();
		
	}

    public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String a1 = br.readLine();
		String a2 = br.readLine();
		
		char[] a1Arr = a1.toCharArray();
		char[] a2Arr = a2.toCharArray();
		
		dp = new int[a1.length()+1][a2.length()+1];

		for(int i = 1 ; i < dp.length; i++) {
			for(int j = 1; j < dp[i].length; j++) {
				if(a1Arr[i-1] == a2Arr[j-1]) {
					dp[i][j] = dp[i-1][j-1]+1;
				
				}else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		
		if(dp[a1.length()][a2.length()] == 0) {
			System.out.println(dp[a1.length()][a2.length()]);
		}else {
			System.out.println(dp[a1.length()][a2.length()]);
			System.out.println(findWord(a1, a2));
		
		}
	}
}
