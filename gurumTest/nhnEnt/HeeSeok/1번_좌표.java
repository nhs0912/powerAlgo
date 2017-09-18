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
        int[] numbers = new int[N];
        int[] distance = new int[N - 1];
        int index = 0;
        int shortDistance = Integer.MAX_VALUE;
        int shortDistanceIndex = 0;
        while (st.hasMoreTokens()) {
            numbers[index++] = Integer.parseInt(st.nextToken());
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
        int x = shortDistanceIndex;
        int y = shortDistanceIndex + 1;
//        System.out.println(numbers[x] + " " + numbers[y]);
        bw.write(numbers[x] + " " + numbers[y]);
        bw.close();
    }
}
