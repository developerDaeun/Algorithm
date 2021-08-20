import java.util.Scanner;

public class BOJ_3985_롤케이크 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int L = sc.nextInt();	// 롤 케이크의 길이
		int N = sc.nextInt();	// 방청객의 수
		int[] roll = new int[L+1];	// 롤케이크 배열
		
		int max = 0;	// 가장 많은 케이크 조각을 기대한 방청객의 케이크 조각 개수
		int maxNum = 0;	// 가장 많은 케이크 조각을 기대한 방청객 번호
		int realMax = 0; 	// 실제로 가장 많은 케이크 조각을 받는 방청객의 케이크 조각 개수
		int realMaxNum = 0;	// 실제로 가장 많은 케이크 조각을 받는 방청객의 번호

		int start, end, cnt;
		for(int i = 1; i <= N; i++) {	// 방청객이 원하는 케이크 조각 P,K 입력받으면서 max, maxNum 구하기
			start = sc.nextInt();	// 현재 방청객의 케이크조각 start
			end = sc.nextInt();		// 현재 방청객의 케이크조각 end
			
			if(max < (end - start + 1)) {	// 가장 많은 케이크 조각을 기대한 방청객 번호 구하기
				max = end - start + 1;
				maxNum = i;
			}
			
			cnt = 0;
			for(int j = start; j <= end; j++) {	// 롤케이크 배열에 방청객 번호 넣기
				if(roll[j] == 0) {	// 현재 아무도 가져가지 않은 롤케이크면 현재 방청객 번호 넣기
					roll[j] = i;
					cnt++;
				}
			}
			
			if(realMax < cnt) {	// 실제로 가장 많은 케이크 조각을 받은 방청객 번호 구하기
				realMax = cnt;
				realMaxNum = i;
			}
		}
		
		System.out.println(maxNum);
		System.out.println(realMaxNum);
	}
}