import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

class Main {
    static int[] val;
    static int[] minTree;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        val = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            val[i] = Integer.parseInt(st.nextToken());
        }

        minTree = new int[n * 4];
        init(1, n , 1);

        int m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine()," ");
            int trigger = Integer.parseInt(st.nextToken());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());

            if(trigger == 1){
                update(1, n, 1, left, right);
            }else{
                System.out.println(findMin(1, n, 1, left, right));
            }
        }
    }

    // 초기 최소 세그먼트 트리 생성
    public static int init(int start, int end, int node){
        if(start == end){
            return minTree[node] = val[start];
        }

        int mid = (start + end) / 2;

        return minTree[node] = Math.min(init(start, mid, node * 2), init(mid+1, end, node * 2 + 1));
    }
  
  // 구간 최소값 탐색
    public static int findMin(int start, int end, int node, int left, int right){
        if(end < left || start > right){
            return Integer.MAX_VALUE;
        }

        if(left <= start && end <= right){
            return minTree[node];
        }

        int mid = (start + end) / 2;

        return Math.min(findMin(start, mid, node * 2, left, right), findMin(mid + 1, end, node * 2 + 1, left, right));
    }

  // 1이 나올시, 값 변경, 최소 
    public static int update(int start, int end, int node, int idx, int val){
        if(idx < start || idx > end){
            return minTree[node];
        }

        if(start == end){
            return minTree[node] = val;
        }

        int mid = (start + end) / 2;

        return minTree[node] = Math.min(update(start, mid, node * 2, idx, val), update(mid +1 ,end, node * 2 +1 , idx, val));
    }
}
