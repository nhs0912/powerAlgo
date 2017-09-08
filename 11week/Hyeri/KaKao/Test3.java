
public class Test3 {
	//직사각형 좌표구하기
	public static void main(String[] args) {
		int[][] v = {{1, 4}, {3, 4}, {3, 10}};
		System.out.println(solution(v)[0]);
		System.out.println(solution(v)[1]);
	}
	
    public static int[] solution(int[][] v) {
       
        int x =0;
        int y =0;
        
        if(v[0][0] == v[1][0])
        	x = v[2][0];
        else if(v[0][0] == v[2][0])
        	x = v[1][0];
        else if(v[1][0] == v[2][0])
        	x = v[0][0];
        
        if(v[0][1] == v[1][1])
        	y = v[2][1];
        else if(v[0][1] == v[2][1])
        	y = v[1][1];
        else if(v[1][1] == v[2][1])
        	y = v[0][1];
        
        
        int[] answer = {x,y};

        return answer;
    }

}
