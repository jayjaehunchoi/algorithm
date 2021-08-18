import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
      // String으로 오름차순 sort해주면 Union코드 순으로 잘 배열됨, 즉 바로 다음 수의 접두사가 아니면 걍 패스해도 된다는 소리.
        Arrays.sort(phone_book,new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return o1.compareTo(o2);
			}
        	
        });
        
      // 하나 큰수와 계속 비교해나가면서 접두사면 false출력
        for(int i =  0 ; i < phone_book.length-1 ; i++) {
        	if(phone_book[i].length() <= phone_book[i+1].length()) {
        		if(phone_book[i].equals(phone_book[i+1].substring(0,phone_book[i].length()))) {
        			return false;
        		}
        	}
        }

        
        return answer;
    }
}
