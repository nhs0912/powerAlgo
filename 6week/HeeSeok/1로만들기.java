import java.io.*;
import java.util.*;


public class Main {

    public static int[] d;

    public static int go(int n) {

        if (n == 1) {//1일 경우
            return 0;
        }
        if (d[n] > 0) {//계산 한 값이 있으면 그대로 출력
            return d[n];
        }
        d[n] = go(n - 1) + 1; //그 전 값에다가 1을 더한다.
        if (n % 2 == 0) {//2로 나누었을 경우
            int temp = go(n / 2) + 1;
            if (d[n] > temp) {
                d[n] = temp;
            }
        }

        if (n % 3 == 0) {
            int temp = go(n / 3) + 1;
            if (d[n] > temp) {
                d[n] = temp;
            }
        }
        return d[n];

    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        d = new int[n + 1];
        if(d[n]==0) {
            bw.write(go(n) + "\n");
        }else if(d[n]>0)
        {
            bw.write(d[n]+"\n");
        }


        bw.close();


    }

}
