package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BallNumberTest {
    @DisplayName("1 - 9 사이의 값이 입력되는 경우 정상 처리되는 확인")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9})
    void set(int given) {
        BallNumber ballNumber = new BallNumber(given);
        assertThat(ballNumber).isEqualTo(new BallNumber(given));
    }

    @DisplayName("비정상 입력에 대한 예외처리")
    @ParameterizedTest
    @ValueSource(ints = {0, 10, -1})
    void invalid(int given) {
        assertThatThrownBy(() -> new BallNumber(given))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1-9 사이의 숫자를 입력해주세요.");
    }
}
