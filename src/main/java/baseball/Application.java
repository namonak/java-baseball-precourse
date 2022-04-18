package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Application {
    static class BaseballGameModel {
        int[] generateAnswer() {
            int[] answer = new int[3];
            for (int i = 0; i < answer.length; i++) {
                answer[i] = pickNumberInRange(Utils.MIN_NUM, Utils.MAX_NUM);
            }
            //System.out.println("컴퓨터가 생각한 숫자는 " + answer[0] + " " + answer[1] + " " + answer[2] + " 입니다.");
            return answer;
        }

        private int countStrike(int[] guess, int[] answer) {
            int countStrike = 0;
            for (int i = 0; i < answer.length; i++) {
                if (answer[i] == guess[i]) {
                    countStrike++;
                }
            }
            return countStrike;
        }

        private int countBall(int[] guess, int[] answer) {
            int ballCnt = 0;
            for (int i = 0; i < guess.length; i++) {
                if (isBall(guess[i], i, answer)) {
                    ballCnt++;
                }
            }
            return ballCnt;
        }

        private boolean isBall(int targetNum, int i, int[] answer) {
            for (int j = 0; j < answer.length; j++) {
                if (i == j) {
                    continue;
                }
                if (targetNum == answer[j]) {
                    return true;
                }
            }
            return false;
        }

        int[] score(int[] guess, int[] answer) {
            int ballCnt = countBall(guess, answer);
            int strikeCnt = countStrike(guess, answer);

            return new int[]{ballCnt, strikeCnt};
        }
    }

    static class BaseballGameView {}

    static class BaseballGameController {}

    static class Utils {
        private static final int MIN_NUM = 1;
        private static final int MAX_NUM = 9;
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
}
