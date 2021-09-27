import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Algo1_구미_04반_김다은_시험후수정 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String[] s = br.readLine().split(" ");	// 빈칸을 기준으로 하나씩 가져오기
		int M = Integer.parseInt(s[0]);	// M 입력 (String 배열 s의 첫번째 값)
		int N = Integer.parseInt(s[1]); // N 입력 (String 배열 s의 두번째 값)
		
		ArrayList<Data> list = new ArrayList<>();	// 숫자 데이터를 담기위한 리스트 생성
		
		for(int i = M; i <= N; i++) {
			// 알파벳의 순서 번호를 저장함
			if(i < 10) {	// 10 이하이면 second 숫자는 없으므로 0으로 초기화
				list.add(new Data(i, create(i%10), 0));
			}
			// 첫번째 숫자는 10으로 나눈 몫, 두번째 숫자는 10으로 나눈 나머지로
			else list.add(new Data(i, create(i/10), create(i%10)));
		}
		
		Collections.sort(list);	// Data 클래스에서 재정의한대로 사전순으로 정렬
		
		// 시험 후 바꾼 부분...
		int cnt = 0;
		for(Data cur : list) {	// 리스트 정렬 후 sb에 값 저장
			if(cnt==10) {
				cnt = 0;
				sb.append("\n");
			}
			sb.append(cur.num + " ");
			cnt++;
		}
		
		System.out.print(sb);	// 최종 결과 값 출력
	}
	
	static int create(int num) {
		
		int res = 0;	// 알파벳이 몇번째 순서인지 번호 저장
		
		switch(num) {
		case 0 : res = 10; break;	// zero : 10번째 알파벳
		case 1 : res = 5; break;	// one : 5번째 알파벳
		case 2 : res = 9; break;	// two : 9번째 알파벳
		case 3 : res = 8; break;	// three : 8번째 알파벳
		case 4 : res = 3; break;	// four : 3번째 알파벳
		case 5 : res = 2; break;	// five : 2번째 알파벳
		case 6 : res = 7; break;	// six : 7번째 알파벳
		case 7 : res = 6; break;	// seven : 6번째 알파벳
		case 8 : res = 1; break;	// eight : 1번째 알파벳
		case 9 : res = 4; break;	// nine : 4번째 알파벳
		}
		
		return res;
	}
	
	static class Data implements Comparable<Data>{
		int num, first, second;

		public Data(int num, int first, int second) {	// 현재 숫자, 첫번째 숫자, 두번째 숫자
			this.num = num;
			this.first = first;
			this.second = second;
		}

		@Override
		public int compareTo(Data o) {
			if(this.first == o.first)	// 첫번째 숫자가 같다면
				return this.second - o.second;	// 두번째 숫자를 비교해 오름차순 정렬
			return this.first - o.first;	// 첫번째 숫자를 비교해 오름차순 정렬
		}
	}
}