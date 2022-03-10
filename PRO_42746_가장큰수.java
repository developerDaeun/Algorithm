public class PRO_42746_가장큰수 {
    public static void main(String[] args) {

//        System.out.print(Solution.solution(new int[]{6, 10, 2}));
//        System.out.print(Solution.solution(new int[]{3, 30, 34, 5, 9}));
        System.out.print(Solution.solution(new int[]{3, 30, 34, 300}));
    }

    static class Solution {
        public static String solution(int[] numbers) {
            int n = numbers.length;

            // 문자열 배열로 변환
            Data[] s = new Data[n];
            for (int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                sb.append(numbers[i]);
                int len = sb.length();
                for (int j = 0; j < 4 - len; j++){
                    sb.append("0");
                }
                s[i] = new Data(sb.toString(), Integer.toString(numbers[i]));
            }

            // 정렬
            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    Data o1 = s[i];
                    Data o2 = s[j];
                    if(Integer.parseInt(o1.s) > Integer.parseInt(o2.s)) continue;
                    else if(Integer.parseInt(o1.s) < Integer.parseInt(o2.s)){
                        s[i] = o2;
                        s[j] = o1;
                    }else{
                        if(o1.original.length() > o2.original.length()){
                            s[i] = o2;
                            s[j] = o1;
                        }
                    }
                }
            }

            // 출력 결과
            StringBuilder answer = new StringBuilder();
            for (Data temp : s) {
                answer.append(temp.original);
            }
            if(Integer.parseInt(answer.toString()) == 0)
                return "0";

            return answer.toString();
        }
    }

    static class Data{
        String s, original;

        public Data(String s, String original) {
            this.s = s;
            this.original = original;
        }
    }
}