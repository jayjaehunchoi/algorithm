import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;




class Main {

    public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		String t = br.readLine();
		char[] table = t.toCharArray();
		int count = 0;
		for(int i = 0; i < table.length; i++) {
			if(table[i] == 'P') {
				if( i >= k) {
					for(int j = i-k; j <= i+k; j++) {
						if(j >= table.length)break;
						if(table[j] == 'H') {
							count++;
							table[j] = 'E';
							break;
						}
					}
				}else {
					for(int j = 0; j <= i+k; j++) {
						if(j >= table.length)break;
						if(table[j] == 'H') {
							count++;
							table[j] = 'E';
							break;
						}
					}
				}
			}
		}
		System.out.println(count);
    }
  
}
