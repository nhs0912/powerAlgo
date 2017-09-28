import java.io.*;
import java.util.StringTokenizer;


class Main {
    int[][] direction = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    boolean[][] visited;
    int[][] map;
    int cnt = 1;
    int numbering = 1;


    void DFS(int x, int y, int direct) {
        //visited[x][y] = true;
        int curDirection = direct;
        for (int i = 0; i < 4; i++) {
            curDirection = (curDirection + 3) % 4;
            int moveX = x + direction[curDirection][0];
            int moveY = y + direction[curDirection][1];
            if (map[moveX][moveY]==1||(moveX < 0 || moveY < 0) || (moveX > map.length - 1 || moveY > map[0].length - 1)) {
                continue;
            }

            if (map[moveX][moveY] == 0) {
                //방문하지 않아야하고, 벽이 아니여야한다.
                cnt++;
                map[moveX][moveY] = 2;//numbering++;// 청소한 구역은 2로 표시
                DFS(moveX, moveY, curDirection);
                return;
            }

        }
        curDirection = (direct + 2) % 4;
        int moveX = x + direction[curDirection][0];
        int moveY = y + direction[curDirection][1];
        if (map[moveX][moveY] == 1) {
            return;
        } else {
            DFS(moveX, moveY, direct);
        }


    }

    public void solve() throws IOException {
        //FileInputStream fis = new FileInputStream("test.txt");
        //BufferedReader br = new BufferedReader(new InputStreamReader(fis));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        st = new StringTokenizer(br.readLine());
        //robot청소기 위치 (r,c)
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int directRobot = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            int index = 0;
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                map[i][index++] = Integer.parseInt(st.nextToken());
            }
        }

        map[r][c] = 2;
        DFS(r, c, directRobot);


       
        System.out.println(cnt);


    }

    public static void main(String[] args) throws IOException {
        new Main().solve();

    }
}

