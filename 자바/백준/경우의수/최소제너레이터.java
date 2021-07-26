package com.test01;

import java.util.Scanner;


public class Test01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int generator = N;
		
		for(int i = 1 ; i < N; i++) {
			int addEachN = 0;
			String iStr = Integer.toString(i);
			for(int j = 0; j < iStr.length(); j++) {
				addEachN += Integer.parseInt(iStr.substring(j,j+1));
			}
			
			if ((addEachN + i) == N) {
				int maxGenerator = i;
				if(maxGenerator < generator) {
					generator = maxGenerator;
				}
			}
		}
		System.out.println(generator);
	}

}
/*
max제너레이터를 찾는줄 알았다가, min값 찾는거였다고 나중에 깨달아서 변수명 수정은 안했다.
1부터 입력값 이전의 모든 제너레이터를 찾기 위해 for문을 돌렸고 기본 제너레이터를 입력값으로 선정하여
가장 작은 제너레이터를 찾을 수 있도록 조건문을 두었다. 
그런데 이걸 쓰면서 생각해보니, 가장 처음으로 N의 제너레이터가 된 수를 바로 출력하면 최소값을 찾을 수 있을 듯하다 (당연히 속도도 더 빨라지고 메모리도 덜 들겠지.)
*/
