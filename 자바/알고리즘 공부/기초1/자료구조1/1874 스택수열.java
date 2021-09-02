import java.util.*;

class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        int[] nums = new int[n];
        int[] numSort = new int[n];
        
        for(int i = 0 ; i< n ; i++){
            int s = sc.nextInt();
            nums[i] = s;
            numSort[i] = s;
        }
        Arrays.sort(numSort);
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        int j = 0;
        while(i < n){
            stack.push(numSort[i]);
            sb.append("+\n");
            i++;
            if(stack.peek() == nums[j]){
                sb.append("-\n");
                stack.pop();
                j++;
                while(!stack.isEmpty()&& stack.peek() == nums[j]){
                    sb.append("-\n");
                    stack.pop();
                    j++;
                }
            }
        }
        if(!stack.isEmpty()){
            System.out.println("NO");
        }else{
            System.out.println(sb.toString());
        }
        
    }
}
