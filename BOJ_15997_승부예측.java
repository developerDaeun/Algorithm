import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_15997_승부예측 {

	static Map<String, Integer> map;
	static Data[] Game;
	static int[] score;
	static double[] props;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		map = new HashMap<>();

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			map.put(st.nextToken(), i);
		}

		Game = new Data[6];
		for (int i = 0; i < 6; i++) {
			st = new StringTokenizer(br.readLine());
			Data data = new Data(st.nextToken(), st.nextToken(), Double.parseDouble(st.nextToken()),
					Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()));
			Game[i] = data;
		}

		score = new int[4];
		props = new double[4];

		dfs(0, 1.0);

		for(int i = 0; i < 4; i++) {
			System.out.printf("%.10f\n", props[i]);
		}
	}

	private static void dfs(int dept, double prop) {
		if (dept == 6) {

			// 새 score 생성
			Score[] final_score = new Score[4];
			for (int i = 0; i < 4; i++) {
				final_score[i] = new Score(i, score[i]);
			}

			// sort
			Arrays.sort(final_score, (o1, o2) -> Integer.compare(o2.score, o1.score));

			// 1==2==3==4
			if (final_score[0].score == final_score[3].score) {
				props[0] += prop / 2;
				props[1] += prop / 2;
				props[2] += prop / 2;
				props[3] += prop / 2;
			}

			// 1==2==3 4
			else if (final_score[0].score == final_score[2].score) {
				props[final_score[0].idx] += prop * 2 / 3;
				props[final_score[1].idx] += prop * 2 / 3;
				props[final_score[2].idx] += prop * 2 / 3;
			}

			// 1 2==3==4
			else if (final_score[1].score == final_score[3].score) {
				props[final_score[0].idx] += prop;
				props[final_score[1].idx] += prop * 1 / 3;
				props[final_score[2].idx] += prop * 1 / 3;
				props[final_score[3].idx] += prop * 1 / 3;
			}

			// 1 2==3 4
			else if (final_score[1].score == final_score[2].score) {
				props[final_score[0].idx] += prop;
				props[final_score[1].idx] += prop * 1 / 2;
				props[final_score[2].idx] += prop * 1 / 2;
			}

			// 1 2 3 4
			else {
				props[final_score[0].idx] += prop;
				props[final_score[1].idx] += prop;
			}

			return;
		}

		Data cur = Game[dept];

		// A
		score[map.get(cur.A)] += 3;
		dfs(dept + 1, prop * cur.w);
		score[map.get(cur.A)] -= 3;

		// A==B
		score[map.get(cur.A)] += 1;
		score[map.get(cur.B)] += 1;
		dfs(dept + 1, prop * cur.d);
		score[map.get(cur.A)] -= 1;
		score[map.get(cur.B)] -= 1;

		// B
		score[map.get(cur.B)] += 3;
		dfs(dept + 1, prop * cur.l);
		score[map.get(cur.B)] -= 3;
	}

	static class Data {
		String A, B;
		double w, d, l;

		public Data(String a, String b, double w, double d, double l) {
			A = a;
			B = b;
			this.w = w;
			this.d = d;
			this.l = l;
		}
	}

	static class Score {
		int idx, score;

		public Score(int idx, int score) {
			this.idx = idx;
			this.score = score;
		}
	}
}