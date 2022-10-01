package baseball;

import java.util.Objects;

public class Position {
    public static final int MIN_POSITION = 0;
    public static final int MAX_POSITION = 2;
    private final int position;

    public Position(int pos) {
        checkPosition(pos);
        this.position = pos;
    }

    private static void checkPosition(int pos) {
        if (pos < MIN_POSITION || pos > MAX_POSITION) {
            throw new IllegalArgumentException(MIN_POSITION + "-" + MAX_POSITION + " 사이의 위치값을 입력해주세요.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position1 = (Position) o;
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
