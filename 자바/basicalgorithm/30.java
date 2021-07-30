class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
   
    	String[] answer = new String[n];
    	
      // 자릿수를 고정한 이진수를 담을 배열 생성
    	String arr1Str[] = new String[n];
    	String arr2Str[] = new String[n];
    	
      // 자릿수 고정, 이진수는 integer의 범위를 넘어가는경우가 빈번하기 때문에 Long으로 형변환을 해줘야한다.
    	for(int i = 0 ; i < arr1.length ; i++) {
    		arr1Str[i] = String.format("%0"+n+"d", Long.parseLong(Integer.toBinaryString(arr1[i])));
    		arr2Str[i] = String.format("%0"+n+"d", Long.parseLong(Integer.toBinaryString(arr2[i])));
    	}
    	
      // 지도를 2차원배열로 만들어 준다, 
      // 각 2진수의 자리를 떼서 넣어줄 map1, 2
      // 둘을 더해줄 mapSum
      // 더한 값을 #과 빈칸으로 바꿔줄 mapSharp
    	int[][] map1 = new int [n][n];
    	int[][] map2 = new int [n][n];
    	int[][] mapSum = new int[n][n];
    	char[][] mapSharp = new char[n][n];

    	// 하나씩 떼어 넣어준 다음, mapSum에서 더해준다.
    	for(int i = 0 ; i < n ; i++) {
    		for(int j = 0 ; j < n ; j++) {
    			map1[i][j] = Integer.parseInt(arr1Str[i].substring(j,j+1));
    			map2[i][j] = Integer.parseInt(arr2Str[i].substring(j,j+1));
    			mapSum[i][j] = map1[i][j]+map2[i][j];
    		}
    	}
    	
      // 다시 각자 흩어졌던 녀석을 한 문장으로 만들어줘야 한다.
      // eachLine이라는 변수를 생성하여 1행에 있는 값을 모두 합쳐준다.
      // 이후 answer배열에 넣는다.
    	for(int i = 0; i < n; i++) {
    		String eachLine = "";
    		for(int j = 0 ; j < n ; j++) {
    			if( 0 < mapSum[i][j]) {
    				mapSharp[i][j] = '#';
    			}
    			else if( 0 == mapSum[i][j]) {
    				mapSharp[i][j] = 32;
    			}
    			eachLine += mapSharp[i][j];
    		}
    		answer[i] = eachLine;
    	}

        return answer;
    }
}

/*
문제 해석이나 풀이는 전혀 어렵지 않았으나,
2진수 자리고정과 integer에 담기지 않는 2진수때문에 고생했다

꼭 기억해야 할 코드.
String.format("%0"+n+"d", Long.parseLong(Integer.toBinaryString(정수)));

*/
