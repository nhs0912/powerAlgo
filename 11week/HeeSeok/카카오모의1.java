import java.util.*;

public class Solution {
	    public int solution(int n) {
        int answer = 0;
        char[] charSave;//문자 저장
        int[] number;//문자를 숫자로 바꾸기
        String str = String.valueOf(n);   //숫자를 문자로 변환           
        charSave = str.toCharArray();//각 문자마다 배열로 저장 
        number = new int[charSave.length];
        for (int i = 0; i < charSave.length; i++) {
            number[i] = charSave[i] - '0';//각 문자를 숫자로 변환
        }
        for (int i : number) {
            answer += i; 
        }        
        return answer;
    }

}
