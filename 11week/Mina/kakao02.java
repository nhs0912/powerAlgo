class Solution {
    public boolean solution(int[] arr) {
        boolean answer = true;
        int arrLen = arr.length;
        // 1~arrLen 까지 있는지 확인
        boolean[] check = new boolean[arrLen+1];
        for(int i = 0; i<arrLen; i++){
            // 범위가 맞지않는 수가 왔을 때
            if(arr[i]>arrLen){
                return false;
            }
            
            if(check[arr[i]]){
               return false;
            }
            check[arr[i]] = true;
        }
        
        // 1~arrLen 까지 수가 포함이 되어있는지 확인
        for(int i = 1; i<arrLen+1; i++){
            if(!check[i]){
                answer = false;
            }
        }
        
        return answer;
    }
}
