package baseball;

public class BallNumber {
    private final int number;

    public BallNumber(int ballNumber) {
        checkBallNumber(ballNumber);
        this.number = ballNumber;
    }

    private static void checkBallNumber(int ballNumber) {
        if (ballNumber < 1 || ballNumber > 9) {
            throw new IllegalArgumentException("1-9 사이의 숫자를 입력해주세요.");
        }
    }

    public int getNumber() {
        return this.number;
    }
}
