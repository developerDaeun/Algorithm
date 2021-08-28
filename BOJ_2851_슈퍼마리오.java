import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_2851_슈퍼마리오 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int sum = 0, min = Integer.MAX_VALUE;
		int total = 0;
		
		for(int i = 0; i < 10; i++) {
			sum += Integer.parseInt(br.readLine());	// 현재 버섯까지의 합
			
			if(min >= Math.abs(100-sum)) {	// 현재 버섯까지의 합이 100과 가장 가까운 숫자일때 점수 저장 (절대값이 같다면 큰수 저장)
				min = Math.abs(100-sum);
				total = sum;
			}
		}
		
		System.out.println(total);
	}
}