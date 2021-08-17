import java.util.Scanner;

public class BOJ2839_설탕배달 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int total = 0;
		
		// 5로 나누고 3의 배수가 나오면 갯수 구하기	
		while(N%5!=0) {
			if(N%5!=0) {	// 5의 배수가 아니면 3 빼기
				total++;
				N = N-3;
			}
		}
		System.out.println(N<0?"-1":total + N/5); // N이 0 밑이면 -1 출력, 5의 배수이면 그만큼 더하기
	}
}