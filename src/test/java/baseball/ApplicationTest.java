package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ApplicationTest extends NsTest {
    @Test
    void 게임종료_후_재시작() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135", "1", "597", "589", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5, 5, 8, 9
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    @Test
    void generateAnswerTest() {
        Application.BaseballGameModel baseballGameModel = new Application.BaseballGameModel();

        for (int i = 0; i < 100; i++) {
            int[] result = baseballGameModel.generateAnswer();
            assertThat(result).hasSize(3);
            for (int j = 0; j < result.length; j++) {
                assertThat(result[j]).isBetween(1, 9);
            }
        }
    }

    static class TestCase {
        public String description;
        public int[] guess;
        public int[] answer;
        public int wantBallCnt;
        public int wantStrikeCnt;
    }

    @Test
    void scoreTest() {
        TestCase[] tests = new TestCase[] {
            new TestCase() {
                {
                    description = "3볼";
                    guess = new int[]{9, 1, 2};
                    answer = new int[]{1, 2, 9};
                    wantBallCnt = 3;
                    wantStrikeCnt = 0;
                }
            },
            new TestCase() {
                {
                    description = "3스트라이크";
                    guess = new int[]{1, 2, 3};
                    answer = new int[]{1, 2, 3};
                    wantBallCnt = 0;
                    wantStrikeCnt = 3;
                }
            },
            new TestCase() {
                {
                    description = "2볼 1스트라이크";
                    guess = new int[]{3, 8, 2};
                    answer = new int[]{3, 2, 8};
                    wantBallCnt = 2;
                    wantStrikeCnt = 1;
                }
            },
            new TestCase() {
                {
                    description = "2스트라이크";
                    guess = new int[]{3, 8, 2};
                    answer = new int[]{3, 8, 4};
                    wantBallCnt = 0;
                    wantStrikeCnt = 2;
                }
            },
            new TestCase() {
                {
                    description = "1스트라이크";
                    guess = new int[]{3, 8, 2};
                    answer = new int[]{3, 9, 4};
                    wantBallCnt = 0;
                    wantStrikeCnt = 1;
                }
            },
            new TestCase() {
                {
                    description = "낫싱";
                    guess = new int[]{2, 3, 4};
                    answer = new int[]{5, 6, 7};
                    wantBallCnt = 0;
                    wantStrikeCnt = 0;
                }
            },
        };

        for (int i = 0; i < tests.length; i++) {
            Application.BaseballGameModel baseballGameModel = new Application.BaseballGameModel();

            int[] score = baseballGameModel.score(tests[i].guess, tests[i].answer);

            assertThat(score).hasSize(2);
            int actualBallCnt = score[0];
            int actualStrikeCnt = score[1];

            assertEquals(actualBallCnt, tests[i].wantBallCnt);
            assertEquals(actualStrikeCnt, tests[i].wantStrikeCnt);
        }
    }

    @Test
    void validateTest() {
        Application.BaseballGameView baseballGameView = new Application.BaseballGameView();

        for (String s : Arrays.asList("aaa", "최해나", "Hannah", "1a1", "13?", "1", "12", "1234", "023", "103", "120")) {
            assertThatIllegalArgumentException().isThrownBy(() -> baseballGameView.validate(s));
        }
    }

    @Test
    void checkResumeGameTest() {
        Application.BaseballGameView baseballGameView = new Application.BaseballGameView();

        for (String s : Arrays.asList("1", "2")) {
            assertThat(baseballGameView.checkResumeGame(s)).isTrue();
        }
        for (String s : Arrays.asList("3", "12", "21", "aaa", "최해나", "Hannah")) {
            assertThat(baseballGameView.checkResumeGame(s)).isFalse();
        }
    }
}
