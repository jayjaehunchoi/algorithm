import java.io.*;
import java.util.*;

class Main {
    static int n;
    static int c;
    static int[] arr;
    static int result = 0;

    public static void binarySearch() {
        int max = arr[n-1];
        int min = arr[0];
        int mid = 0;

        while (min < max) {
            mid = (min + max) / 2;

            if(isPossible(mid)) {
                result = Math.max(mid, result);
                min = mid + 1;
            }else {
                max = mid;
            }
        }
    }

    public static boolean isPossible(int gap) {
        int cnt = 1;
        int index = 0;

        for (int i = 1; i < n; i++) {
            if(arr[index] + gap <= arr[i]) {
                cnt++;
                index = i;
            }
        }
        if(cnt >= c){
            return true;
        }
        return false;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int tempVal = arr[0];
        for (int i = 0; i < n; i++) {
            arr[i] = arr[i] - tempVal + 1;
        }
        binarySearch();
        System.out.println(result);

    }

}
