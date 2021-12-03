import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] input;
    static int[] minTree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        input = new int[n+1];
        for(int i = 1 ; i <= n ; i++){
            input[i] = Integer.parseInt(br.readLine());
        }

        minTree = new int[n * 4];
      
      // 구간 최솟값 추가, 양 노드 모두 살피며 최솟값 넣기
        insertMin(1,n,1);

        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            System.out.println(findMin(1, n, 1, left, right));
        }
    }

    public static int insertMin(int start, int end, int node){
        if(start == end){
            return minTree[node] = input[start];
        }

        int mid = (start + end) / 2;
        return minTree[node] = Math.min(insertMin(start, mid, node * 2), insertMin(mid + 1, end, node * 2 + 1));
    }

  // 구간 최솟값 탐색, 양 노드 살피며 최솟값 찾기
    public static int findMin(int start, int end, int node, int left, int right){
        if(right < start || end < left){
            return Integer.MAX_VALUE; // min값에 방해되지 않도록 넣어줌
        }

        if(left <= start && right >= end){
            return minTree[node];
        }

        int mid = (start + end)/2;
        return Math.min(findMin(start, mid, node * 2, left, right), findMin(mid + 1, end, node * 2 + 1, left, right));
    }
}
