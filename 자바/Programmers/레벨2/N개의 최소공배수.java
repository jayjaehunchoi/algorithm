import java.util.Arrays;

class Solution {
	
  //재귀를 이용하여 최소공배수를 구하는 함수제작
	public static int gcd(int x, int y) {
		
		if( y == 0) {
			return x;
		}
		
		return gcd(y,x%y);
	}

  // N개의 최소공배수를 구하려면 차례로 두수의 곱 / 두수의최대공약수를해주면됨
    public int solution(int[] arr) {
        
        Arrays.sort(arr);
        int n = arr[0] * arr[1] / gcd(arr[0], arr[1]);
        
        
        for(int i = 2 ; i < arr.length;i++) {
        	n = n*arr[i]/gcd(n,arr[i]);
        }
        
        return n;
      
    }
}
