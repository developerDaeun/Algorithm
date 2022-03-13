public class PRO_42842_카펫 {
    public static void main(String[] args) {

//        System.out.print(Solution.solution(10, 2));
//        System.out.print(Solution.solution(8, 1));
        System.out.print(Solution.solution(24, 24));
    }

    static class Solution {

        public static int[] solution(int brown, int yellow) {
            int[] answer = new int[2];

            int total = brown + yellow;

            double quo = 0;
            int div = 3;
            while(true){
                quo = (double)total / div;
                if(quo < div) break;
                if(quo * 2 + div * 2 - 4 == brown){
                    answer[0] = (int)quo;
                    answer[1] = div;
                    System.out.println(answer[0] + " " +answer[1]);
                    break;
                }
                div++;
            }

            return answer;
        }
    }
}