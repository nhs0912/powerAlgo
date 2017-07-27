import java.util.Scanner;

public class AssignRoom {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt(); // 참가하는 학생의 수
		int k = scan.nextInt(); // 한 방에 배정 가능한 최대 인원의 수

		int maleGrade[] = new int[6]; // 남학생 배열
		int femaleGrade[] = new int[6]; // 여학생 배열
		int minimumRoom = 0;

		for (int i = 0; i < n; i++) {
			int s = scan.nextInt(); // 0은 여자, 1은 남자
			int y = scan.nextInt(); // 학년

			if (s == 0) {
				femaleGrade[y - 1]++;
			} else if (s == 1)
				maleGrade[y - 1]++;
		}

		for (int i = 0; i < femaleGrade.length; i++) {
			if (femaleGrade[i] > k) {
				if (femaleGrade[i] % k == 0) 
					minimumRoom += (femaleGrade[i] / k);
				else
					minimumRoom += (femaleGrade[i] / k) + 1;
			} else if (femaleGrade[i] > 0) {
				minimumRoom++;
			}

			if (maleGrade[i] > k) {
				if (maleGrade[i] % k == 0) 
					minimumRoom += (maleGrade[i] / k);
				else
					minimumRoom += (maleGrade[i] / k) + 1;
			} else if (maleGrade[i] > 0) {
				minimumRoom++;
			}
		}
		System.out.println(minimumRoom);
	}
}
