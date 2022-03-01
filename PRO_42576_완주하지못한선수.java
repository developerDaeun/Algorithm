import java.util.Arrays;

public class PRO_42576_완주하지못한선수 {
    public static void main(String[] args) {
        System.out.print(Solution.solution(new String[]{"leo", "kiki", "eden"}, new String[]{"eden", "kiki"}));
    }

    static class Solution {
        public static String solution(String[] participant, String[] completion) {
            String answer = "";

            Arrays.sort(participant);   // 정렬
            Arrays.sort(completion);

            for (int i = 0; i < completion.length; i++){
                if(!participant[i].equals(completion[i])){  // 같은 인덱스에 사람이 같지 않으면 정답
                    answer = participant[i];
                    break;
                }
            }

            // 완주한 사람 기준으로 answer 를 구했으므로, 마지막 인덱스에서 구해지지 않을 경우를 대비해 추가
            if(answer.equals("")){
                answer = participant[participant.length - 1];
            }

            return answer;
        }
    }
}