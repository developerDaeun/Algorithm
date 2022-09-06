import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1157_단어공부 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        s = s.toUpperCase();

        Data[] count = new Data[26];
        for (int i = 0; i < 26; i++) {
            count[i] = new Data(0, (char) (65 + i));
        }

        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'A';
            count[idx].count++;
        }

        Arrays.sort(count);

        if (count[0].count == count[1].count) {
            System.out.print("?");
        } else {
            System.out.print(count[0].c);
        }
    }

    private static class Data implements Comparable<Data> {
        int count;
        char c;

        public Data(int count, char c) {
            this.count = count;
            this.c = c;
        }

        @Override
        public int compareTo(Data o) {
            return -(this.count - o.count);
        }
    }
}