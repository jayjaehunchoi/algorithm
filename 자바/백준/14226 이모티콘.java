import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Node{
    int screen;
    int clipBoard;
    int time;

    public Node(int screen, int clipBoard, int time){
        this.screen = screen;
        this.clipBoard = clipBoard;
        this.time = time;
    }
}

public class Main {
    public static int numberOfEmoji;
    public static boolean[][] check = new boolean[1002][1002]; // 중복 체크 방지
    public static void bfs(){
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(1,0,0));

        while (!que.isEmpty()){
            Node node = que.poll();
            if(numberOfEmoji == node.screen){
                System.out.println(node.time);
                return;
            }

            for(int i = 0 ; i < 3; i++){
                int nScreen = node.screen;
                int nClipBoard = node.clipBoard;
                if(nScreen > 1001 || nClipBoard > 1001)continue; // outofindex 방지

                if(i == 0){
                    if(nScreen != nClipBoard && !check[nScreen][nScreen])
                    nClipBoard = nScreen;
                }else if(i == 1){
                    if(nScreen + nClipBoard > 1001)continue;// outofindex 방지
                    if(nClipBoard != 0 && !check[nScreen+nClipBoard][nClipBoard]){
                        nScreen += nClipBoard;
                        if(nScreen == numberOfEmoji){
                            System.out.println(node.time+1);
                            return;
                        }
                    }
                }else{
                    if (nScreen >= 1 && !check[nScreen-1][nClipBoard]){
                        nScreen--;
                    }
                }
              // 동일한 로직이 수행된 경우 다시 반복문이 안돌게끔 세팅
                if(!check[nScreen][nClipBoard]){
                    check[nScreen][nClipBoard] = true;
                    que.add(new Node(nScreen, nClipBoard,node.time+1));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        numberOfEmoji = Integer.parseInt(br.readLine());

        bfs();
    }
}
