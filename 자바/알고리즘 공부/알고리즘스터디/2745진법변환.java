import java.util.Scanner;

public class Main {
	

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int answer = 0;
        String n = sc.next();
        int b = sc.nextInt();

        char[] nArr = n.toCharArray();
        
      // 제곱해주기 위해
        int k = nArr.length;
        for(int i = 0 ; i < nArr.length ; i++) {
        	k--;
          //알파벳 구간이면 , A= 65 > 10 즉, -55해주면 됨.
          // 그다음 자릿수 제곱한값과 곱해주면 됨!
        	if(nArr[i] >= 65 && nArr[i] <= 90) {
        		answer += Math.pow(b, k) * ((int)(nArr[i])-55);
        		
        	}
        	else {
        		answer += Math.pow(b,k) * Integer.parseInt(String.valueOf(nArr[i]));
        	}
        }

        System.out.println(answer);

	}
}
