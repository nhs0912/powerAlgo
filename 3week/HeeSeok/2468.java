
import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제 번호 : 2468
 * 문제 이름 : 안전영역
 * 문제 주소 : https://www.acmicpc.net/problem/2468
 */
class Main {
    int[][] zone;
    boolean[][] visited;
    boolean[][] safeZone;
    int safeZoneCnt = 0;//안전구역 갯수

    public void printMatrix(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void printMatrix(boolean[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void initSafeZoneArr() {
        for (int i = 0; i < safeZone.length; i++) {
            for (int j = 0; j < safeZone[i].length; j++) {
                safeZone[i][j] = false;//초기화
            }
        }
    }

    public void initVisitedArr() {
        for (int i = 0; i < safeZone.length; i++) {
            for (int j = 0; j < safeZone[i].length; j++) {
                visited[i][j] = false;//초기화
            }
        }
    }

    public void searchSafeZone(int num) {//침수구간 찾기
        for (int i = 0; i < safeZone.length; i++) {
            for (int j = 0; j < safeZone[i].length; j++) {
                if (num >= zone[i][j]) {
                    safeZone[i][j] = true;//침수 구간
                }
            }
        }
    }

    public int countSafeZone() {
        //안전구역 갯수 카운트

        for (int i = 0; i < safeZone.length; i++) {
            for (int j = 0; j < safeZone[i].length; j++) {
                if (safeZone[i][j] == false && visited[i][j] == false) {//침수가 안되고 방문하지 않은 곳 탐색
                    searchNeighbor(i, j);
                    safeZoneCnt++;// 안전한 영역 갯수 세기
                }
            }
        }
        return safeZoneCnt;
    }


    public void searchNeighbor(int i, int j) {
        //int N = 4;


        if (j + 1 < safeZone.length && safeZone[i][j + 1] == false && visited[i][j + 1] == false) {//East
            visited[i][j + 1] = true;
            searchNeighbor(i, j + 1);
        }


        if (j - 1 >= 0 && safeZone[i][j - 1] == false && visited[i][j - 1] == false) {//West
            visited[i][j - 1] = true;
            searchNeighbor(i, j - 1);
        }


        if (i + 1 < safeZone.length && safeZone[i + 1][j] == false && visited[i + 1][j] == false) {//South
            visited[i + 1][j] = true;
            searchNeighbor(i + 1, j);
        }


        if (i - 1 >= 0 && safeZone[i - 1][j] == false && visited[i - 1][j] == false) {//North
            visited[i - 1][j] = true;
            searchNeighbor(i - 1, j);
        }


    }


    public void Solve() throws IOException {

        FileInputStream fis = new FileInputStream("test.txt");

        BufferedReader br = new BufferedReader(new InputStreamReader(fis));
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int bigSize = 0;
        zone = new int[N][N];
        visited = new boolean[N][N];
        safeZone = new boolean[N][N];
        int maxSafeZoneCnt = 0;
        int i = 0;
        while (N-- > 0) {//input data
            StringTokenizer st = new StringTokenizer(br.readLine());
            int index = 0;
            while (st.hasMoreTokens()) {
                int num = Integer.parseInt(st.nextToken());
                zone[i][index++] = num;
                if (bigSize < num) {
                    bigSize = num;
                }
            }
            i++;
        }


        for (int k = 0; k <= bigSize; k++) {
            initSafeZoneArr(); //초기화 safeZone
            initVisitedArr(); //초기화 visited
            safeZoneCnt = 0;
            searchSafeZone(k);
            int cnt = countSafeZone();

            if (maxSafeZoneCnt < cnt) {//최댓값 저장
                maxSafeZoneCnt = cnt;
            }
        }
        bw.write(Integer.toString(maxSafeZoneCnt));

        bw.close();
    }


    public static void main(String[] args) throws IOException {
        new Main().Solve();
    }

}
