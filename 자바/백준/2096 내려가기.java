import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][3];
        int[][] maxDp = new int[n][3];
        int[][] minDp = new int[n][3];
        StringTokenizer st;
      
        for (int i = 0; i < n; i++) {
            st= new StringTokenizer(br.readLine(), " ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }

      // 기본 값 세팅
        for (int i = 0; i < 3; i++) {
            maxDp[n-1][i] = arr[n-1][i];
            minDp[n-1][i] = arr[n-1][i];
        }

      // 각 자리수에서 나올 수 있는 최대값, 최소값 계산하여 dp에 넣어두기
        for (int i = n-2; i >= 0; i--) {
            maxDp[i][0] = Math.max(maxDp[i+1][0] + arr[i][0], maxDp[i+1][1] + arr[i][0]);
            maxDp[i][1] = Math.max(Math.max(maxDp[i+1][0] + arr[i][1], maxDp[i+1][1] + arr[i][1]), maxDp[i+1][2] + arr[i][1]);
            maxDp[i][2] = Math.max(maxDp[i+1][1] + arr[i][2], maxDp[i+1][2] + arr[i][2]);

            minDp[i][0] = Math.min(minDp[i+1][0] + arr[i][0], minDp[i+1][1] + arr[i][0]);
            minDp[i][1] = Math.min(Math.min(minDp[i+1][0] + arr[i][1], minDp[i+1][1] + arr[i][1]), minDp[i+1][2] + arr[i][1]);
            minDp[i][2] = Math.min(minDp[i+1][1] + arr[i][2], minDp[i+1][2] + arr[i][2]);
        }

      // 최종적으로 나오는 값 중 최대, 최소 
        int max = Math.max(Math.max(maxDp[0][0], maxDp[0][1]),maxDp[0][2]);
        int min = Math.min(Math.min(minDp[0][0], minDp[0][1]),minDp[0][2]);

        System.out.println(max + " " + min);
    }

}
