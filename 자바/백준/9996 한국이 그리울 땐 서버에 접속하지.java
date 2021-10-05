import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.StringTokenizer;


class Main {
	
	
    public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String s = br.readLine();
		String[] sArr = s.split("[*]");
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < n ; i++) {
			String str = br.readLine();
      // 빈문자열인 경우 고려
			if(str.length() < s.length()-1) {
				sb.append("NE\n");
				continue;
			}
			String sComp1 = str.substring(0,sArr[0].length());
			String sComp2 = str.substring(str.length()-sArr[1].length(), str.length());
			if(sComp1.equals(sArr[0]) && sComp2.equals(sArr[1])) {
				sb.append("DA\n");
			}else {
				sb.append("NE\n");
			}
			
		}
		System.out.println(sb.toString());
    }
  
}
