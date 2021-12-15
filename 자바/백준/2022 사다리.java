import java.io.*;
import java.util.*;

class Main {

    static double x;
    static double y;

    public static double getC(double d) {
        double h1 = Math.sqrt(x*x - d*d);
        double h2 = Math.sqrt(y*y - d*d);
        return (h1 * h2) / (h1 + h2);
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        x = Double.parseDouble(st.nextToken());
        y = Double.parseDouble(st.nextToken());
        double c = Double.parseDouble(st.nextToken());

        if(x < y) {
            double tmp = x;
            x = y;
            y= tmp;
        }

        double start = 0;
        double end = y;

        while(true) {
            double d = (start + end) / 2;
            double tmpC = getC(d);

            if(Math.abs(tmpC - c) <= 0.001) {
                System.out.println(d);
                return;
            }

            if(tmpC > c) {
                start = d;
            }else {
                end = d;
            }
        }

    }

}
