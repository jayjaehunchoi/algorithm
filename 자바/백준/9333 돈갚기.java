import java.io.*;
import java.util.StringTokenizer;

class Main {
    static int count;
    static int getCount(double r, double b, double m) {
        double interest = Double.parseDouble(String.format("%.2f", r * b));
        double updatedB = interest + b;

        if(updatedB <= m) {
            return ++count;
        } else{
            count++;
            if (count > 1200) {
                return -1;
            }
            return getCount(r, updatedB - m, m);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for (int i = 0; i < n; i++) {
            count = 0;
            st = new StringTokenizer(br.readLine()," ");
            double r = Double.parseDouble(String.format("%.4f", Double.parseDouble(st.nextToken()) / 100));
            double b = Double.parseDouble(st.nextToken());
            double m = Double.parseDouble(st.nextToken());

            int answer = getCount(r, b, m);
            if(answer == -1){
                sb.append("impossible\n");
            }else{
                sb.append(answer + "\n");
            }

        }
        System.out.println(sb.toString());


    }

}
