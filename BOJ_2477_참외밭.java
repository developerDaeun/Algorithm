import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2477_참외밭 {

	static class Data{
		int d, len;	// 변의 방향, 길이

		public Data(int d, int len) {
			this.d = d;
			this.len = len;
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int K = Integer.parseInt(br.readLine());	// 1m^2당 참외 개수
		
		Data[] arr = new Data[6];	// 6개의 변의 방향과 길이
		
		
		for (int i = 0; i < 6; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			arr[i] = new Data(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));	// 변의 방향 (동:1 서:2 남:3 북:4), 길이
		}

		// 같은 방향인 위치 찾기 (ㄱ:3->1->3->1 ┌:1->4->1->4 ㄴ:4->2->4->2 ┘:2->3->2->3 일때)
		// 넓이=> 1*(2+4) + (3*4) =>번호는 4개 인덱스 순서
		int W=0, H=0, w=0, h=0;
		int total=0;
		for(int i = 0; i < 6; i++) {
			W = arr[i].d;	// 첫번째 방향
			H = arr[(i+1)%6].d;	// 두번째 방향
			w = arr[(i+2)%6].d;	// 세번째 방향
			h = arr[(i+3)%6].d;	// 네번째 방향
			if((W==3&&H==1&&w==3&&h==1) || (W==1&&H==4&w==1&&h==4) || (W==4&&H==2&&w==4&&h==2) || (W==2&&H==3&&w==2&&h==3)) {
				total = (arr[i].len * (arr[(i+1)%6].len + arr[(i+3)%6].len)) + (arr[(i+2)%6].len * arr[(i+3)%6].len);
				System.out.println(total * K);
				return;
			}
		}
	}
}