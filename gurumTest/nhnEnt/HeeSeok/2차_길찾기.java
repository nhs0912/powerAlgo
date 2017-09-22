import java.io.*;
import java.util.StringTokenizer;


class Main {
    /**
     * 벽 정보
     * 0 : 갈수 없음
     * 1: right or left
     * 2: up or down
     * 3: up or right
     * 4: down or left
     */

    int[][] map = new int[8][8];// 지도 행렬
    boolean[][] visited = new boolean[8][8]; // 방문 행렬
    int[][] move = new int[][]{{0, 1}, {1, 0}};//동이의 이동경로
    int width = map.length;// 7
    int height = map[0].length;//7
    boolean[][] wallInfo
            = new boolean[][]{{false, false, false, false}, {true, true, false, false}, {false, false, true, true}, {true, false, false, true}, {false, true, true, false}};//동서남북
    boolean[][] canIGo
            = new boolean[][]{{false, false, false, false, false}, {false, true, false, true, false}, {false, false, true, false, true}, {false, false, true, false, true}, {false, true, false, true, false}};

    public void print(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.printf("%2d", arr[i][j]);
            }
            System.out.println();
        }
    }

    public void print(boolean[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.printf("%7b", arr[i][j]);
            }
            System.out.println();
        }
    }

    public void DFS(int x, int y, int preWallCnt) {
        int wallCnt = map[x][y];//벽 숫자
        if (preWallCnt != 0 && !canIGo[wallCnt][preWallCnt]) {
            return;
        }
        visited[x][y] = true;//방문 배열에 방문 표시

        boolean right = wallInfo[wallCnt][0];
        boolean down = wallInfo[wallCnt][2];
        //이동 경로 탐색
        for (int i = 0; i < move.length; i++) {
            //오른쪽 탐색 후 아래 탐색

            if (right && !down && i == 1) {
                continue;
            } else if (!right && down && i == 0) {
                continue;
            }
            int goToX = x + move[i][0];
            int goToY = y + move[i][1];
            if (goToX >= 0 && goToY >= 0 && goToX < width && goToY < height) {
                //지도 안에서만 탐색
                if (map[goToX][goToY] > 0 && visited[goToX][goToY] != true) {
                    //지도의 값이 0이 아니면서 방문하지 않았을 때
                    DFS(goToX, goToY, wallCnt);
                }
            }
        }

    }


    public void solve() throws IOException {
        //FileInputStream fis = new FileInputStream("test.txt");
        //BufferedReader br = new BufferedReader(new InputStreamReader(fis));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int TestCase = Integer.parseInt(br.readLine());
        //1) 지도 정보를 입력시킨다.
        while (TestCase-- > 0) {
            int N = 8;//8 x 8 행렬 입력
            int xIndex = 0;
            while (N-- > 0) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int yIndex = 0;
                while (st.hasMoreTokens()) {
                    visited[xIndex][yIndex] = false;
                    map[xIndex][yIndex++] = Integer.parseInt(st.nextToken());
                }
                xIndex++;
            }

            //2) DFS탐색
            DFS(0, 0, 0);
            if (visited[7][7] == true) {
                //도착지까지 도달했으면 YES 출력

                bw.write("YES\n");
            } else {
                //도착하지 않았다면 NO 출력                
                bw.write("NO\n");
            }
        }
        bw.close();


    }

    public static void main(String[] args) throws IOException {
        new Main().solve();

    }
}
