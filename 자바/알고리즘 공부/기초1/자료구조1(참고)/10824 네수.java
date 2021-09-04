import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextInt();
        long b = sc.nextInt();
        long c = sc.nextInt();
        long d = sc.nextInt();
        long blength = String.valueOf(b).length();
        long dlength = String.valueOf(d).length();
        long result = (long) (a*Math.pow(10,blength)+b+(c*Math.pow(10,dlength))+d);
        System.out.println(result);
    }
