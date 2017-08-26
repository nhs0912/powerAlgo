
import java.io.*;
import java.util.*;

/**
 * 문제 번호 : 1339
 * 문제 이름 : 단어수학
 * 문제 주소 : https://www.acmicpc.net/problem/1339
 */


class Main {

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public void printArr(int[][] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void fastPrintArr(int[][] arr) throws IOException {
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr[i].length; j++) {
                bw.write(arr[i][j] + " ");

            }
            bw.write("\n");
        }
        bw.close();
    }

    public void printArr(boolean[][] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }


    public void inputData() throws IOException {
        FileInputStream fis = new FileInputStream("test.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] alphabet = new int[26];
        while (N-- > 0) {
            String str = br.readLine();
            int cipher = str.length();//자릿수
            int num = 1;
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                int cnt = cipher--;
                num = 1;
                while (--cnt > 0) {
                    num *= 10;
                }
                alphabet[ch - 'A'] += num;
            }
        }
        int weight = 9;
        int sum = 0;
        Arrays.sort(alphabet);
        //List<int[]> list = Arrays.asList(alphabet);

        //Collections.reverse(list);
        for (int i = alphabet.length - 1; i >= 0; i--) {
            alphabet[i] *= weight--;
        }
        //printArr(alphabet);

        for(int i=0; i<alphabet.length;i++) {
            sum+=alphabet[i];
        }
        System.out.println(sum);

    }


    public void Solve() throws IOException {
        inputData();

        //bw.close();
    }

    public static void main(String[] args) throws IOException {
        new Main().Solve();
    }

}
