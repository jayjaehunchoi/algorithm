
class Solution {
  public String[] solution(int n, int[] arr1, int[] arr2) {
        
        String[] result = new String[n];
       
        // 이진수 비트연산자를 통해 단숨에 1을 채운 장면을 볼 수 있음.
        // or 연산자는 각 자리 둘중하나 1이면 1로 다 바꿔준다.
        // And 일때는 각자리가 둘다 1이여야 1
        for (int i = 0; i < n; i++) {
            result[i] = Integer.toBinaryString(arr1[i] | arr2[i]);
        }
        
        // 여기서 자리수를 맞춰주고, 1은 #으로,0 은 빈칸으로 모두 변경해준다.
        for (int i = 0; i < n; i++) {
            result[i] = String.format("%" + n + "s", result[i]);
            result[i] = result[i].replaceAll("1", "#");
            result[i] = result[i].replaceAll("0", " ");
        }

        return result;
    }
}
