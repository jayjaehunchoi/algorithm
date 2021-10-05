import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 반복문을 통해 시작점을 달리하여, 부분 문자열에 대해 가장 길이가 긴 값을 찾는다.
class Main {
	static int[] pi;
	static int max = 0;
  
	public static int getPi(String str) {
		pi = new int[5001];
		int size = str.length();
		int pre = 0;
    
    // 접두사와 접미사가 같으면 두 index 모두 증가
    // 다를 경우 접두사 자리가 0보다 크면 가장 최근까지 같았던 문자열 자리로 이동
		for(int i = 1 ; i < size; i++) {
			while(pre > 0 && str.charAt(pre) != str.charAt(i)) {
				pre = pi[pre-1];
			}
			if(str.charAt(pre) == str.charAt(i)) {
				pi[i] = ++pre;
				max = Math.max(pi[i], max);
			}
		}
		return max;
	}
	
    public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String pat = br.readLine();

		for(int i = 0; i < pat.length() ; i++) {
			String str = pat.substring(i,pat.length());
			max = getPi(str);
		}

		System.out.println(max);
    }
  
}
