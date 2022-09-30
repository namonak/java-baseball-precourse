package baseball;

public class BallNumber {
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 9;
    private final int number;

    public BallNumber(int ballNumber) {
        checkBallNumber(ballNumber);
        this.number = ballNumber;
    }

    private static void checkBallNumber(int ballNumber) {
        if (ballNumber < MIN_NUMBER || ballNumber > MAX_NUMBER) {
            throw new IllegalArgumentException("1-9 사이의 숫자를 입력해주세요.");
        }
    }

    public int getNumber() {
        return this.number;
    }
}
