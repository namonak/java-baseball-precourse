package baseball;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BallNumber that = (BallNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
