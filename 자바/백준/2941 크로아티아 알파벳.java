import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        input = input.replaceAll("c=","c");
        input = input.replaceAll("c-","c");
        input = input.replaceAll("dz=","d");
        input = input.replaceAll("d-","d");
        input = input.replaceAll("lj","l");
        input = input.replaceAll("nj","n");
        input = input.replaceAll("s=","s");
        input = input.replaceAll("z=","z");

        System.out.println(input.length());
    }
}
