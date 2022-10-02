package baseball.util;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Utils {
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 9;
    public static final int MAX_BALL_LENGTH = 3;

    public static List<Integer> generateNumber() {
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < MAX_BALL_LENGTH; i++) {
            answer.add(pickNumberInRange(MIN_NUMBER, MAX_NUMBER));
        }
        return answer;
    }

    public static List<Integer> generateInputNumbers(String input) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            numbers.add(Integer.parseInt(input.substring(i, i + 1)));
        }
        return numbers;
    }

    public static boolean isNumber(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}