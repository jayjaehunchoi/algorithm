import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public String solution(String s) {
        String answer = "";

        ArrayList<Character> aList = new ArrayList<Character>();

        for(int i = 0 ; i < s.length(); i++) {
            aList.add(s.charAt(i));
        }

        Collections.sort(aList,Collections.reverseOrder());

        for(char m : aList) {
            answer += m;
        }
        return answer;
    }
}

/*

새로 알게된 사실!

char [] st = {'a','b','c','d','e'};
이런 char 배열이 있을때.
new StringBuffer(new String(st)).reverse().order();
요렇게하면 걍 String으로 뒤집어서 출력해줌;;

+
String sa = "qwdasdasfa";
char [] arr = sa.toCharArray();
하면 자동으로 하나씩 갈라줌;

*/
