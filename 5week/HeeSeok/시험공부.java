
import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;


class Merge {
    static int[] sorted;

    Merge(int size) {
        sorted = new int[size];
    }

    void sort(int[] arr, int begin, int end) {
        int middle;
        if (begin < end) {
            middle = (begin + end) / 2;
            sort(arr, begin, middle);
            sort(arr, middle + 1, end);
            merge(arr, begin, middle, end);
        }
    }

    void merge(int[] arr, int begin, int middle, int end) {
        int left = begin;
        int right = middle + 1;
        int index = begin;
        while (left <= middle && right <= end) {
            if (arr[left] <= arr[right]) {
                sorted[index++] = arr[left++];
            }
            if (arr[left] > arr[right]) {
                sorted[index++] = arr[right++];
            }
        }
        while (left <= middle && right > end) {
            sorted[index++] = arr[left++];
        }
        while (left > middle && right <= end) {
            sorted[index++] = arr[right++];
        }
        for (int i = begin; i <= end; i++) {
            arr[i] = sorted[i];
        }
    }
}

class Main {
    int[] subjectPoints;

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public void printArr(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
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

        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //Scanner sc = new Scanner(System.in);

        int T = Integer.parseInt(br.readLine());
        int cnt =1;
        while (T-- > 0) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            int index = 0;
            int subjectCnt = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            subjectPoints = new int[subjectCnt];
            int sum=0;
            st = new StringTokenizer(br.readLine());

            while (st.hasMoreTokens()) {
                subjectPoints[index++] = Integer.parseInt(st.nextToken());
            }

            Merge m = new Merge(subjectCnt);
            m.sort(subjectPoints, 0, subjectPoints.length-1);

            for(int i=subjectPoints.length-K;i<subjectPoints.length;i++)
            {
                sum+=subjectPoints[i];
            }

            bw.write("Case #"+cnt++ +"\n"+sum+"\n");


        }
        //System.out.println("끝");
        bw.close();
    }


    public void Solve() throws IOException {
        inputData();

    }


    public static void main(String[] args) throws IOException {
        new Main().Solve();
    }

}
