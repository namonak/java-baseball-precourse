package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BallTest {
    private Ball computer;

    @BeforeEach
    void setUp() {
        computer = new Ball(1, new BallNumber(4));
    }

    @Test
    void strike() {
        BallStatus status = computer.play(new Ball(1, new BallNumber(4)));
        assertThat(status).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    void ball() {
        BallStatus status = computer.play(new Ball(2, new BallNumber(4)));
        assertThat(status).isEqualTo(BallStatus.BALL);
    }

    @Test
    void nothing() {
        BallStatus status = computer.play(new Ball(2, new BallNumber(5)));
        assertThat(status).isEqualTo(BallStatus.NOTHING);
    }
}