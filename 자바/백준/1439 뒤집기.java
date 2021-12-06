import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        boolean[] visited = new boolean[str.length()];
        int zCount = 0;
        int oCount = 0;
      
      // 연속 0과 연속 1의 공간을 찾아, 최솟값구하기
        for(int i = 0 ; i < str.length(); i++){
            if(!visited[i] && str.charAt(i) == '0'){
                for(int j = i; j < str.length(); j++){
                    if(str.charAt(j) != '0'){
                        break;
                    }
                    visited[j] = true;
                }
                zCount++;
            }else if(!visited[i] && str.charAt(i) == '1'){
                for(int j = i; j < str.length(); j++){
                    if(str.charAt(j) != '1'){
                        break;
                    }
                    visited[j] = true;
                }
                oCount++;
            }
        }
        System.out.println(Math.min(zCount, oCount));
    }
}
