import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public String solution(String[] table, String[] languages, int[] preference) {
        String answer = "";
        int[] lang = new int[5];
        
        for(int i = 0 ; i < table.length; i++) {
        	String[] arr = table[i].split(" ");
        	int val = 0;
        	for(int j = 1; j < arr.length; j++) {
        		for(int k = 0 ; k < languages.length; k++) {
        			if(arr[j].equals(languages[k])) {
        				val+= preference[k]*(6-j);
        			}
        		}
        	}
        	lang[i] = val;
        }
        
        int max = 0;
        List<Integer> idx = new ArrayList<Integer>();
        for(int i = 0 ; i < 5; i++) {
        	if(lang[i] > max) {
        		max = lang[i];
        		idx.clear();
        		idx.add(i);
        	}else if(lang[i] == max) {
        		idx.add(i);
        	}
        }
        
        List<String> st = new ArrayList<>();
        for(int i = 0 ; i < idx.size(); i++) {
        	switch(idx.get(i)) {
            case 0: 
            	st.add("SI");
            	break;
            case 1:
            	st.add("CONTENTS");
            	break;
            case 2: 
            	st.add("HARDWARE");
            	break;
            case 3:
            	st.add("PORTAL");
            	break;
            case 4: 
            	st.add("GAME");
            	break;
            
            }
        }
        Collections.sort(st, (a,b) -> a.compareTo(b));
        
        answer = st.get(0);
        
        return answer;
    }
}
