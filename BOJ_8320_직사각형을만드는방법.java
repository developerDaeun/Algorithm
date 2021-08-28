import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_8320_직사각형을만드는방법 {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());	// 정사각형 개수
		
		int total = 0, here = 0;
		for(int i = 1; i <= n; i++) {
			here = 0;
			for(int j = 1; j <= i; j++) {
				if(i%j==0) { // 약수 개수 구하기
					here++;
					if(j*j==i) here++;
				}
			}
			total += here/2;
		}
		
		System.out.println(total);
	}
}