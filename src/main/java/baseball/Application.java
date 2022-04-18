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

    static class BaseballGameView {
        private boolean isEndGame = false;

        private final String RESUME_GAME = "1";
        private final String EXIT_GAME = "2";

        private final int INDEX_BALL = 0;
        private final int INDEX_STRIKE = 1;

        void validate(String input) {
            if (!Utils.isNumber(input)) {
                throw new IllegalArgumentException("숫자를 입력하세요.");
            }
            if (input.length() != 3) {
                throw new IllegalArgumentException("3자리 숫자를 입력하세요.");
            }
            if (!Utils.isInRangeNumbers(input)) {
                throw new IllegalArgumentException("자릿수별로 1~9 사이의 숫자를 입력하세요.");
            }
        }

        private int[] inputGuess() {
            System.out.print("숫자를 입력해주세요 : ");
            String input = readLine();

            this.validate(input);

            return Utils.convertStringToIntArray(input);
        }

        boolean checkResumeGame(String input) {
            return RESUME_GAME.equals(input) || EXIT_GAME.equals(input);
        }

        private boolean isResumeGame() {
            System.out.println("게임을 새로 시작하려면 " + RESUME_GAME + ", 종료하려면 " + EXIT_GAME + "를 입력하세요.");
            String input;

            while (!this.checkResumeGame(input = readLine())) {
                System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            }
            return RESUME_GAME.equals(input);
        }

        private String makeResult(int[] result) {
            StringBuilder sb = new StringBuilder();
            if (result[INDEX_BALL] == 0 && result[INDEX_STRIKE] == 0) {
                return sb.append("낫싱").toString();
            }
            if (result[INDEX_BALL] > 0) {
                sb.append(result[INDEX_BALL]).append("볼 ");
            }
            if (result[INDEX_STRIKE] > 0) {
                sb.append(result[INDEX_STRIKE]).append("스트라이크");
            }
            return sb.toString();
        }

        private void printScore(int[] result) {
            System.out.println(makeResult(result));

            if (result[INDEX_STRIKE] == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                isEndGame = true;
                return;
            }
            isEndGame = false;
        }
    }

    static class BaseballGameController {
        private final BaseballGameModel baseballGameModel = new BaseballGameModel();
        private final BaseballGameView view = new BaseballGameView();

        private void start() {
            do {
                int[] answer = baseballGameModel.generateAnswer();
                do {
                    int[] guess = view.inputGuess();
                    int[] score = baseballGameModel.score(guess, answer);
                    view.printScore(score);
                } while (!view.isEndGame);
            } while (view.isResumeGame());
        }
    }

    static class Utils {
        private static final int MIN_NUM = 1;
        private static final int MAX_NUM = 9;

        private static boolean isNumber(String input) {
            try {
                Integer.parseInt(input);
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        }

        private static boolean isInRange(int number) {
            return number >= MIN_NUM && number <= MAX_NUM;
        }

        private static boolean isInRangeNumbers(String input) {
            for (int i = 0; i < input.length(); i++) {
                if (!isInRange(Integer.parseInt(input.substring(i, i + 1)))) {
                    return false;
                }
            }
            return true;
        }

        private static int[] convertStringToIntArray(String input) {
            int[] numbers = new int[3];
            for (int i = 0; i < input.length(); i++) {
                numbers[i] = Integer.parseInt(input.substring(i, i + 1));
            }
            return numbers;
        }
    }

    public static void main(String[] args) {
        BaseballGameController baseballGameController = new Application.BaseballGameController();
        baseballGameController.start();
    }
}
