import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * 코드그라운드
 * "HanoiTower"
 */

class Solution {
    void hanoiTower(int left, int mid, int right, int cnt) {
        if (cnt-- > 0) {
            hanoiTower(left, right, mid, cnt);
            System.out.println(left + " -> " + right);
            hanoiTower(mid, left, right, cnt);
        }
    }

    public void solve() throws FileNotFoundException {

        Scanner sc = new Scanner(System.in);
        //Scanner sc = new Scanner(new FileInputStream("input.txt"));
        // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = sc.nextInt();
        for (int test_case = 0; test_case < T; test_case++) {
            int cnt = sc.nextInt();
            System.out.println("Case #"+(test_case+1));           
            hanoiTower(1, 2, 3, cnt);
        }
    }

    public static void main(String args[]) throws Exception {
        new Solution().solve();
    }
}
