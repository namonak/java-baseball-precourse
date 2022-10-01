package baseball;

import java.util.ArrayList;
import java.util.List;

public class Balls {
    public static final int MAX_BALL_LENGTH = 3;
    private final List<Ball> balls;

    public Balls(List<Integer> ballList) {
        this.balls = setBalls(ballList);
    }

    private static List<Ball> setBalls(List<Integer> ballList) {
        List<Ball> balls = new ArrayList<>();
        for (int i = 0; i < MAX_BALL_LENGTH; i++) {
            balls.add(new Ball(i, ballList.get(i)));
        }
        return balls;
    }

    public BallStatus play(Ball userBall) {
        for (Ball ball : balls) {
            BallStatus ballStatus = ball.play(userBall);
            if (ballStatus.isStrike() || ballStatus.isBall()) {
                return ballStatus;
            }
        }
        return BallStatus.NOTHING;
    }

    public PlayResult play(List<Integer> userBalls) {
        Balls user = new Balls(userBalls);
        PlayResult result = new PlayResult();
        for (Ball ball : balls) {
            result.setResult(user.play(ball));
        }
        return result;
    }
}