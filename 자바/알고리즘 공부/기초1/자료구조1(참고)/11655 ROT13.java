import java.util.*;
import java.io.*;

class Main{
	// a - z = 97 - 122
	// A - Z = 65-90
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
   
        char[] sChar = br.readLine().toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < sChar.length; i++){
            
        	if(sChar[i] >= 'A' && sChar[i] <= 'Z'){
                if(sChar[i] + 13 > 90){
                	sb.append((char) (64 + (sChar[i] + 13 - 90)));
                }
                else if(sChar[i] + 13 <= 90) {
                	sb.append((char) (sChar[i] + 13));
                }
            	
            }else if(sChar[i] >= 'a' && sChar[i] <= 'z') {
            	if(sChar[i] + 13 > 122){
                	sb.append((char) (96 + (sChar[i] + 13 - 122)));
                }
                else if(sChar[i] + 13 <= 122) {
                	sb.append((char) (sChar[i] + 13));
                }
            }
            else{
                sb.append(sChar[i]);
            }
        }
        System.out.println(sb.toString());
    }
}
