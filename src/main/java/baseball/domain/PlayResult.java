package baseball.domain;

public class PlayResult {
    public static final int OUT_NUMBER = 3;
    private int strike;
    private int ball;

    public PlayResult() {
        this.strike = 0;
        this.ball = 0;
    }

    public int getStrike() {
        return this.strike;
    }

    public int getBall() {
        return this.ball;
    }

    public void setResult(BallStatus ballStatus) {
        if (ballStatus.isStrike()) {
            strike++;
        }
        if (ballStatus.isBall()) {
            ball++;
        }
    }

    public boolean isEnd() {
        return strike == OUT_NUMBER;
    }
}
