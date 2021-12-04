import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static String[] numbers = {"ZERO", "ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE"};

    public static List<Character> toList(String number){
        List<Character> list = new ArrayList<>();
        for(int i = 0 ; i < number.length(); i++){
            list.add(number.charAt(i));
        }
        return list;
    }

    public static boolean checkContains(List<Character> tmpList, String number){
        for(int i = 0 ; i < number.length(); i++){
            if(!tmpList.contains(number.charAt(i))){
                return false;
            }
        }
        if(number.equals("THREE") || number.equals("SEVEN")){
            int e = 0;
            for (Character character : tmpList) {
                if (character == 'E'){
                    e++;
                }
            }
            if (e < 2) return false;
        }

        if(number.equals("NINE")){
            int n = 0;
            for (Character character : tmpList) {
                if (character == 'N'){
                    n++;
                }
            }
            if (n < 2) return false;
        }
        return true;
    }

    public static void removerNumbers(List<Character> tmpList, String number){
        for(int i = 0 ; i < number.length(); i++){
            tmpList.remove(tmpList.indexOf(number.charAt(i)));
        }
    }

    public static String listToNumber(List<Integer> aList){
        String tmp = "";
        for (Integer integer : aList) {
            tmp += integer;
        }

        return tmp;
    }

    public static void removeSpecNumb(List<Character> tmpList, List<Integer> aList){
        while(tmpList.contains('W')){
            tmpList.remove(tmpList.indexOf('T'));
            tmpList.remove(tmpList.indexOf('W'));
            tmpList.remove(tmpList.indexOf('O'));
            aList.add(2);
        }

        while(tmpList.contains('U')){
            tmpList.remove(tmpList.indexOf('F'));
            tmpList.remove(tmpList.indexOf('O'));
            tmpList.remove(tmpList.indexOf('U'));
            tmpList.remove(tmpList.indexOf('R'));
            aList.add(4);
        }

        while(tmpList.contains('X')){
            tmpList.remove(tmpList.indexOf('S'));
            tmpList.remove(tmpList.indexOf('I'));
            tmpList.remove(tmpList.indexOf('X'));
            aList.add(6);
        }

        while(tmpList.contains('G')){
            tmpList.remove(tmpList.indexOf('E'));
            tmpList.remove(tmpList.indexOf('I'));
            tmpList.remove(tmpList.indexOf('G'));
            tmpList.remove(tmpList.indexOf('H'));
            tmpList.remove(tmpList.indexOf('T'));
            aList.add(8);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        List<Integer> aList;
        for(int i = 0 ; i < t ; i++){
            String number = br.readLine();
            List<Character> tmpList = toList(number);
            aList = new ArrayList<>();

            removeSpecNumb(tmpList, aList);
            for(int j = 0 ; j < numbers.length; j++){
                String digits = numbers[j];
                if(checkContains(tmpList, digits)){
                    removerNumbers(tmpList, digits);
                    aList.add(j);
                }
                if(checkContains(tmpList,digits)){
                    j--;
                    continue;
                }
                if (tmpList.isEmpty()){
                    break;
                }
            }
            Collections.sort(aList);
            System.out.println("Case #" + (i+1) + ": "+listToNumber(aList));
        }
    }
}
