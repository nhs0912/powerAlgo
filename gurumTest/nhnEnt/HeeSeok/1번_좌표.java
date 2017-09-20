import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {

        //FileInputStream fis = new FileInputStream("test.txt");
        //BufferedReader br = new BufferedReader(new InputStreamReader(fis));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] numbers = new long[N];
        long[] distance = new long[N - 1];


        int index = 0;
        long shortDistance = Long.MAX_VALUE;
        long shortDistanceIndex = 0;
        while (st.hasMoreTokens()) {
            numbers[index++] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(numbers);
        index = 0;
        for (int i = 0; i < numbers.length - 1; i++) {
            //인접한 두점의 거리
            distance[index++] = numbers[i + 1] - numbers[i];
        }
        for (int i = 0; i < distance.length; i++) {
            if (distance[i] < shortDistance) {
                shortDistance = distance[i];
                shortDistanceIndex = i;
            }
        }

        int x = (int) shortDistanceIndex;
        int y = (int) shortDistanceIndex + 1;

        bw.write(numbers[x] + " " + numbers[y]);

        bw.close();
    }
}
