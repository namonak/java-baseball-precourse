package baseball.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class BallsTest {
    private Balls com;

    @BeforeEach
    void setUp() {
        com = new Balls(Arrays.asList(1, 2, 3));
    }

    @Test
    @DisplayName("3 스트라이크")
    void playThreeStrikes() {
        PlayResult result = com.play(Arrays.asList(1, 2, 3));
        assertThat(result.getStrike()).isEqualTo(3);
        assertThat(result.getBall()).isEqualTo(0);
        assertThat(result.isEnd()).isTrue();
    }

    @Test
    @DisplayName("1 스트라이크 2 볼")
    void playOneStrikeTwoBalls() {
        PlayResult result = com.play(Arrays.asList(1, 3, 2));
        assertThat(result.getStrike()).isEqualTo(1);
        assertThat(result.getBall()).isEqualTo(2);
    }

    @Test
    @DisplayName("낫싱")
    void playNothing() {
        PlayResult result = com.play(Arrays.asList(4, 5, 6));
        assertThat(result.getStrike()).isEqualTo(0);
        assertThat(result.getBall()).isEqualTo(0);
    }

    @Test
    void strike() {
        BallStatus result = com.play(new Ball(0, 1));
        assertThat(result).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    void ball() {
        BallStatus result = com.play(new Ball(0, 2));
        assertThat(result).isEqualTo(BallStatus.BALL);
    }

    @Test
    void nothing() {
        BallStatus result = com.play(new Ball(0, 4));
        assertThat(result).isEqualTo(BallStatus.NOTHING);
    }
}