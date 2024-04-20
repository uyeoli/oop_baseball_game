package referee;

import gameStatus.GameStatus;

import java.util.List;

public class Judge implements Judgeable {

    private int strike;
    private int ball;
    private List<Integer> pitchingBall;
    private List<Integer> inputBall;
    private final int size = GameStatus.SIZE.getStatus();

    @Override
    public boolean isOut() {
        return strike == size;
    }

    @Override
    public void doJudge(List<Integer> pitchingBall, List<Integer> inputBall) {
        this.pitchingBall = pitchingBall;
        this.inputBall = inputBall;

        setCountingBall();
        printResult();
    }

    private void setCountingBall() {
        this.strike = countStrike();
        this.ball = countBall();
    }

    private int countBall() {
        int ball = 0;
        for (int i=0; i < size; i++) {
            if (pitchingBall.contains(inputBall.get(i))) {
                ball++;
            }
        }
        ball = ball - strike;
        return ball;
    }

    private int countStrike() {
        int strike = 0;
        for (int i=0; i < size; i++) {
            if (inputBall.get(i) == pitchingBall.get(i)) {
                strike++;
            }
        }
        return strike;
    }

    private void printResult() {
        StringBuffer sb = new StringBuffer();
        if(ball == 0 && strike == 0) {
            sb.append("낫싱");
        } else if(strike == 0) {
            sb.append(ball + "볼");
        } else if (ball == 0) {
            sb.append(strike + "스트라이크");
        } else {
            sb.append(ball + "볼 " + strike + "스트라이크");
        }
        System.out.println(sb);
    }



}
