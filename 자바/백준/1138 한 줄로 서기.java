import java.io.*;
import java.util.StringTokenizer;

class Main {
    static int[] rows;
    static int[] inputArr;

    static void putRow(int idx) {
        int curVal = inputArr[idx];
        int size = idx + 1;

        for (int i = 0; i < rows.length; i++) {
          
          // 왼쪽에 서야할 모든 사람이 count됐을 시
            if(curVal == 0) {
                int curIdx = i;
              
              // 이미 자리에 누가 서있다면, 그 다음 자리에 선다.
                while(rows[curIdx] != 0) {
                    curIdx++;
                }
                rows[curIdx] = size;
                break;
            }
          
          // 0(키 큰사람이 들어올 자리)이거나 나보다 키 큰사람이 이미 있는 경우
            if(rows[i] == 0 || rows[i] > size) {
                curVal--;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        inputArr = new int[n];
        rows = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i <n; i++) {
            inputArr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            putRow(i);
        }

        for (int i = 0; i < rows.length; i++) {
            System.out.print(rows[i] + " ");
        }


    }


}
