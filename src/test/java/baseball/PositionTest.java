package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PositionTest {
    @DisplayName("0 - 2 사이의 값이 입력되는 경우 정상 처리되는 확인")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2})
    void set(int given) {
        Position position = new Position(given);
        assertThat(position).isEqualTo(new Position(given));
    }

    @DisplayName("비정상 입력에 대한 예외처리")
    @ParameterizedTest
    @ValueSource(ints = {-1, 3})
    void invalid(int given) {
        assertThatThrownBy(() -> new Position(given))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("0-2 사이의 위치값을 입력해주세요.");
    }
}
