package baseball;

import java.util.Objects;

public class Ball {
    private final int ballPosition;
    private final BallNumber ballNumber;

    public Ball(int ballPosition, BallNumber ballNumber) {
        this.ballPosition = ballPosition;
        this.ballNumber = ballNumber;
    }

    public BallStatus play(Ball ball) {
        if (this.equals(ball)) {
            return BallStatus.STRIKE;
        }

        if (ball.isSameBallNumber(ballNumber)) {
            return BallStatus.BALL;
        }

        return BallStatus.NOTHING;
    }

    private boolean isSameBallNumber(BallNumber ballNumber) {
        return this.ballNumber.equals(ballNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return ballPosition == ball.ballPosition && ballNumber.equals(ball.ballNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ballPosition, ballNumber);
    }
}
