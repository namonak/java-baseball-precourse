package baseball.domain;

import java.util.Objects;

public class Ball {
    private final Position position;
    private final BallNumber ballNumber;

    public Ball(int position, int ballNumber) {
        this.position = new Position(position);
        this.ballNumber = new BallNumber(ballNumber);
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
        return Objects.equals(position, ball.position) && Objects.equals(ballNumber, ball.ballNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, ballNumber);
    }
}
