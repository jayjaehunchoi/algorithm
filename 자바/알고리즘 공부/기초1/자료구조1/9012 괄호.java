import java.util.*;

class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for(int i = 0 ; i< t; i++){
            String s = sc.next();
            Stack<Character> stack = new Stack<>();
            boolean check = true;
            for(int j = 0 ; j< s.length(); j++){
                if(s.charAt(j) == '('){
                    stack.push('(');
                }else if(s.charAt(j) == ')'){
                    if(stack.isEmpty()){
                        System.out.println("NO");
                        check = false;
                        break;
                    }
                    else{
                        stack.pop();
                    }
                }
            }
            if(stack.isEmpty() && check){
                System.out.println("YES");
            }else if(!stack.isEmpty()) {
            	System.out.println("NO");
            }
        }
    }
}
