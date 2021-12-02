import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] input;
    static int[] minTree;
    static int[] maxTree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        input = new int[n+1];
        for(int i = 1 ; i <= n ; i++){
            input[i] = Integer.parseInt(br.readLine());
        }
      
      // 트리 만들기에 충분한 사이즈 준비
        minTree = new int[n * 4];
        maxTree = new int[n * 4];

      // 트리에 구간 별 최소 , 최대 값 삽입
        maxInit(1, n, 1);
        minInit(1, n, 1);

        for(int i = 0 ; i < m; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());

          // 구간을 돌며 최소 , 최대 값 탐색
            int max = findMax(1, n, 1, left, right);
            int min = findMin(1, n, 1, left, right);
            System.out.println(min + " " + max);

        }

    }

    public static int maxInit(int start, int end, int node){
        if(start == end){
           return maxTree[node] = input[start];
        }

        int mid = (start + end)/2;
        return maxTree[node] = Math.max(maxInit(start, mid, node * 2), maxInit(mid + 1, end, node * 2 + 1));
    }

    public static int minInit(int start, int end, int node){
        if(start == end){
            return minTree[node] = input[start];
        }

        int mid = (start + end)/2;
        return minTree[node] = Math.min(minInit(start, mid, node * 2), minInit(mid + 1, end, node * 2 + 1));
    }

    public static int findMax(int start, int end, int node, int left, int right){
        if(right < start || end < left){
            return Integer.MIN_VALUE;
        }

        if(left <= start && end <= right){
            return maxTree[node];
        }

        int mid = (start + end)/ 2;

        return Math.max(findMax(start,mid,node*2,left,right), findMax(mid+1, end, node * 2 + 1, left, right));
    }

    public static int findMin(int start, int end, int node, int left, int right){
        if(right < start || end < left){
            return Integer.MAX_VALUE;
        }

        if(left <= start && end <= right){
            return minTree[node];
        }

        int mid = (start + end)/ 2;

        return Math.min(findMin(start,mid,node*2,left,right), findMin(mid+1, end, node * 2 + 1, left, right));
    }

}
