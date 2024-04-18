package referee;

import gameStatus.GameStatus;

import java.util.List;

public class Judge implements Judgeable {

    private int strike;
    private int ball;
    private final List<Integer> pitchingBall;
    private final List<Integer> inputBall;
    private final int size = GameStatus.SIZE.getStatus();

    public Judge(List<Integer> pitchingBall, List<Integer> inputBall) {
        this.pitchingBall = pitchingBall;
        this.inputBall = inputBall;

        setCountingBall();
    }

    public void setCountingBall() {
        this.strike = countStrike();
        this.ball = countBall();
    }

    @Override
    public int getCountingBall() {
        return this.ball;
    }
    @Override
    public int getCountingStrike() {
        return this.strike;
    }

    @Override
    public boolean isOut() {
        if(strike == size) {
            return true;
        }
        return false;
    }

    public int countBall() {
        int ball = 0;
        for (int i=0; i < inputBall.size(); i++) {
            if (pitchingBall.contains(inputBall.get(i))) {
                ball++;
            }
        }
        ball = ball - strike;

        return ball;
    }

    public int countStrike() {
        int strike = 0;
        for (int i=0; i < inputBall.size(); i++) {
            if (inputBall.get(i) == pitchingBall.get(i)) {
                strike++;
            }
        }

        return strike;
    }

}
