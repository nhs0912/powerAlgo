import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * 코드그라운드
 * "태준이의 걱정"
 */
/*
   As the name of the class should be Solution , using Solution.java as the filename is recommended.
   In any case, you can execute your program by running 'java Solution' command.
 */
class Solution {
    //static int Answer;
    int[][] adjMatrix;
    boolean[] visited;
    char[] markedZone;


    void printArr(int[][] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    void printArr(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    void printArr(boolean[] arr) {
        for (int i = 1; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    void printArr(char[] arr) {
        for (int i = 1; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    void initMarkedZone() {
        //'A' , 'B', 'N'
        for (int i = 1; i < markedZone.length; i++) {
            markedZone[i] = 'N';
        }
    }

//    void DFS(int start) {
//        System.out.print(start + "->");
//        for (int j = 1; j < adjMatrix[start].length; j++) {
//            if (visited[start] != true && adjMatrix[start][j] != 0) {
//                if (markedZone[start] == 'A') {
//                    Mark(start, 'B');
//                } else {
//                    Mark(start, 'A');
//                }
//                if (isCheck) {
//                    break;
//                }
//                DFS(j);
//            }
//        }
//        visited[start] = true;
//    }
//
//    void Mark(int zone, char m) {
//        for (int j = 1; j < adjMatrix[zone].length; j++) {
//            if (zone != j && adjMatrix[zone][j] == 1) {
//                if (markedZone[j] == 'N') {
//                    markedZone[j] = m;
//                } else if (markedZone[zone] == markedZone[j]) {
//                    isCheck = true;
//                    break;
//                }
//
//            }
//        }
//    }


    public void solve() throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
       // Scanner sc = new Scanner(new FileInputStream("input.txt"));
        // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = sc.nextInt();

        for (int test_case = 0; test_case < T; test_case++) {
            boolean isCheck = false;
            int zoneCnt = sc.nextInt();// 지역의 갯수
            int adjZoneCnt = sc.nextInt();// 인접한 지역의 갯수
            // adjMatrix = new int[zoneCnt + 1][zoneCnt + 1];
            visited = new boolean[zoneCnt + 1];
            markedZone = new char[zoneCnt + 200];
            initMarkedZone();
            while (adjZoneCnt-- > 0) {
                int neighborZone1 = sc.nextInt();
                int neighborZone2 = sc.nextInt();
                if (markedZone[neighborZone1] == 'N' && markedZone[neighborZone2] == 'N') {
                    markedZone[neighborZone1] = 'A';
                } else if (markedZone[neighborZone1] == 'N' && markedZone[neighborZone2] != 'N') {
                    if (markedZone[neighborZone2] == 'A') {
                        markedZone[neighborZone1] = 'B';
                    }else{
                        markedZone[neighborZone1] = 'A';
                    }
                }

                if (markedZone[neighborZone1] == 'A') {
                    if (markedZone[neighborZone2] == 'N') {
                        markedZone[neighborZone2] = 'B';
                    } else if (markedZone[neighborZone2] == 'A') {
                        isCheck = true;
                        break;
                    }
                } else if (markedZone[neighborZone1] == 'B') {
                    if (markedZone[neighborZone2] == 'N') {
                        markedZone[neighborZone2] = 'A';
                    } else if (markedZone[neighborZone2] == 'B') {
                        isCheck = true;
                        break;
                    }
                }
                // adjMatrix[neighborZone1][neighborZone2] = 1;
            }

            //printArr(adjMatrix);

            //markedZone[1] = 'A';

            // DFS(1);
            //System.out.println();
            System.out.println("Case #" + (test_case + 1));
            //printArr(markedZone);
            //for(int i=1;i<)
            if (!isCheck) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
            //System.out.println(isCheck);
        }
    }

    public static void main(String args[]) throws Exception {
        new Solution().solve();

    }
}
