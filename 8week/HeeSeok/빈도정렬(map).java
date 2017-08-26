
import java.io.*;
import java.util.*;

/**
 * 문제 번호 : 2910
 * 문제 이름 : 빈도정렬
 * 문제 주소 : https://www.acmicpc.net/problem/2910
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
        for (int i = 1; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }


    public void inputData() throws IOException {
        FileInputStream fis = new FileInputStream("test.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());// message length
        int C = Integer.parseInt(st.nextToken());//숫자 범위

        st = new StringTokenizer(br.readLine());
        HashMap<Long, Integer> map = new HashMap<>();
        int order = 1;
        while (st.hasMoreTokens()) {
            Long num = Long.parseLong(st.nextToken());
            if (!map.containsKey(num)) {
                map.put(num, N + (N - order));
            } else {
                map.put(num, map.get(num) + N);
            }
            order++;
        }

        List<Map.Entry<Long, Integer>> list = new LinkedList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Long, Integer>>() {

            @Override
            public int compare(Map.Entry<Long, Integer> o1, Map.Entry<Long, Integer> o2) {
                // TODO Auto-generated method stub
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });

        for (Map.Entry<Long, Integer> entry : list) {

            int k = entry.getValue() / N;
            for (int i = 0; i < k; i++) {
                bw.write(entry.getKey() + " ");
            }
        }

    }


    public void Solve() throws IOException {
        inputData();

        bw.close();
    }

    public static void main(String[] args) throws IOException {
        new Main().Solve();
    }

}
