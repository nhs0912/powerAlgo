class Solution {
    public boolean solution(int[] arr) {
        boolean answer = true;
        int size = arr.length;
        boolean[] numCheck = new boolean[size];

        for (int i = 0; i < size; i++) {
            if (arr[i] > size) {
                answer = false;
                break;
            }
            int index = arr[i];
            if (index != 0) {

                numCheck[index - 1] = true;
            }
        }

        for (int i = 0; i < size; i++) {
            if (numCheck[i] == false) {
                answer = false;
                break;
            }
        }
        return answer;
    }
}

class Main {

    public static void main(String[] args) {
        int[] arr = {5, 1, 2, 3, 4};
        Solution s = new Solution();
        System.out.println(s.solution(arr));
    }
}
