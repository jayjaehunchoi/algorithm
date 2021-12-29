import java.io.*;
import java.util.*;

class Main {
    static int[] friends;
    static List<Integer>[] friendList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        friends = new int[n + 1];
        friends[1] = -1;

        friendList = new ArrayList[n + 1];

        for (int i = 0; i < n + 1; i++) {
            friendList[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());

            friendList[left].add(right);
            friendList[right].add(left);
        }

        for (int i = 0; i < friendList[1].size(); i++) {
            int val = friendList[1].get(i);
            if(friends[val] == 0) {
                friends[val] = 1;
            }

            for (int j = 0; j < friendList[val].size(); j++) {
                int value = friendList[val].get(j);
                if(friends[value] == 0) {
                    friends[value] = 1;
                }
            }
        }

        int answer = 0;
        for (int i = 1; i < friends.length; i++) {
            if(friends[i] == 1){
                answer++;
            }
        }
        System.out.println(answer);

    }

}
