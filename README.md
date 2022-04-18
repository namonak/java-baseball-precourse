# 숫자 야구 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

## 구현 내용

* BaseballGameModel : 야구 게임에서 데이터 처리 부분을 담당하는 클래스

| Method                                                            | Description                                                                   |
|-------------------------------------------------------------------|-------------------------------------------------------------------------------|
| int[] generateAnswer()                                            | 컴퓨터가 사용할 랜덤한 3자리 숫자를 생성하여 정수열 배열로 반환하는 메서드                                    |
| private int countStrike(int[] userNumbers, int[] computerNumbers) | 전달받은 정수열 배열 guess와 answer를 비교하여 스트라이크 개수를 정수 형태로 리턴하는 메서드                     |
| private int countBall(int[] guess, int[] answer)                  | 전달받은 정수열 배열 guess와 answer를 비교하여 볼 개수를 정수 형태로 리턴하는 메서드                         |
| private boolean isBall(int targetNum, int i, int[] answer)        | 전달받은 정수열 배열 anwser에서 targetNum에 해당하는 값이 있는지 여부를 true/false 형태로 리턴하는 메서드       |
| int[] score(int[] guess, int[] answer)                            | 정수형 배열 guess, anser를 전달받아 볼, 스트라이크 개수를 계산하여 정수열 배열에 볼, 스트라이크 순으로 개수를 리턴하는 메서드 |

* BaseballGameView : 야구 게임에서 사용자에게 보여지는 View 부분을 담당하는 클래스

| Method                                        | Description                                                                                              |
|-----------------------------------------------|----------------------------------------------------------------------------------------------------------|
| private void validate(String input)           | 사용자가 입력한 문자열이 3자리 숫자인지, 각 자릿수별로 1~9 범위의 값을 가지는지 검증하는 메서드, 사용자가 잘못된 값을 입력한 경우 IllegalArgumentException 발생 |
| private int[] inputGuess()                    | 사용자에게 문자 입력을 요청하는 콘솔에 메시지를 출력하고, validate() 메서드를 통해 입력받은 문자열을 검증하여 정수형 배열로 리턴하는 메서드                      |
| private boolean checkResumeGame(String input) | 전달받은 문자열이 게임 재개 혹은 게임 종료인지를 판단하는 메서드                                                                     |
| private boolean isResumeGame()                | 사용자에게 게임 재개 여부를 묻는 콘솔 메시지를 표시하고, checkResumeGame() 메서드의 리턴값에 따라 문자열이 유효한지 판단하여 true/false를 리턴하는 메서드      |
| private String makeResult(int[] result)       | 입력받은 정수형 배열에서 볼, 스트라이크 순으로 값을 판단하여 게임 결과를 문자열로 반환하는 메서드                                                  |
| private void printScore(int[] result)         | makeResult() 메서드를 통해 전달받은 정수형 배열에 대한 결과를 콘솔에 출력하고, 종료 조건에 부합하는 경우 종료 메시지를 출력하는 메서드                       |

* BaseballGameController : 야구 게임에서 사용자에게 보여지는 View와 데이터를 처리하는 Model을 연결하는 클래스

| Method               | Description        |
|----------------------|--------------------|
| private void start() | 숫자 야구 게임을 시작하는 메서드 |

* Utils : 야구 게임에서 사용하는 공통적인 메서드를 담당하는 클래스

| Method                                                     | Description                                                             |
|------------------------------------------------------------|-------------------------------------------------------------------------|
| private static boolean isNumber(String input)              | 전달받은 문자열의 정수값 변환 여부를 확인하여 true/false를 반환하는 메서드                          |
| private static boolean isInRange(int number)               | 전달받은 정수값이 1~9 범위의 값을 가지는지 확인하여 true/false를 반환하는 메서드                     |
| private static boolean isInRangeNumbers(String input)      | isInRange() 메서드를 통해 자릿수별 정수값이 1~9 범위의 값을 가지는지 확인하여 true/false를 반환하는 메서드 |
| private static int[] convertStringToIntArray(String input) | 전달받은 문자열을 정수형 배열로 변환하는 메서드                                              |
