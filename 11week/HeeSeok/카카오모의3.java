class Solution {
    public int[] solution(int[][] v) {
        int[] answer = {};
        int x1 = v[0][0];
        int x2 = v[1][0];
        int x3 = v[2][0];
        int y1 = v[0][1];
        int y2 = v[1][1];
        int y3 = v[2][1];

        int x = x1 ^ x2 ^ x3;
        int y = y1 ^ y2 ^ y3;

        answer = new int[]{x, y};

        return answer;
    }
}
