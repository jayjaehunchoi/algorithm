import java.io.*;


class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String document = br.readLine();
        String word = br.readLine();

        int idx = 0;
        int answer = 0;

      // 이미 탐색 성공한 idx는 재끼고 탐색 시작해야함.
        while(idx <= document.length() - word.length()) {
            boolean flag = true;
            int wordIdx = 0;
            for (int i = idx; i < idx + word.length(); i++) {
                if(word.charAt(wordIdx++) != document.charAt(i)) {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                answer++;
                idx += word.length();
            }else {
                idx++;
            }

        }

        System.out.println(answer);

    }


}
