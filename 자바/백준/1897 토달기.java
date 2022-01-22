import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<String> words;
    static Queue<String> que;

    static boolean checkAdd(String curWord, String word) {
      
      // 비교 자체가 불가한 것 제외
        if(curWord.length() >= word.length() || curWord.length() + 1 < word.length()) {
            return false;
        }

      // 처음과 끝에 추가된 경우 확인
        if(curWord.equals(word.substring(1)) || curWord.equals(word.substring(0, word.length() - 1))) {
            return true;
        }

      // 중간에 삽입된 경우 확인
        int number = 0;
        for (int i = 0; i < curWord.length(); i++) {
            if (curWord.charAt(i) != word.charAt(i)) {
                number = i;
                break;
            }
        }

      // 중간 삽입 이후부터 비교값과 같으면 true
        if(curWord.substring(number).equals(word.substring(number + 1))) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        words = new ArrayList<>();
        que = new LinkedList<>();

        int d = Integer.parseInt(st.nextToken());
        que.add(st.nextToken());

        for (int i = 0; i < d; i++) {
            words.add(br.readLine());
        }

        String curWord = "";

      // 작업 que에 비교 결과 true인경우를 추가해가면서 최종적으로 살아남은 que값을 제일 긴 값으로 선언
        while (!que.isEmpty()) {
            curWord = que.poll();
            for (int i = 0; i < words.size(); i++) {
                String word = words.get(i);
                if (checkAdd(curWord, word)) {
                    que.add(word);
                    words.remove(i);
                    i--;
                } else {
                    if(curWord.length() == word.length()) {
                        words.remove(i);
                        i--;
                    }
                }
            }

        }

        System.out.println(curWord);

    }

}
